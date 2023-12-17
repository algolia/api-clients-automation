require 'faraday'
# this is the default adapter and it needs to be required to be registered.
require 'faraday/net_http_persistent' unless Faraday::VERSION < '1'

module Algolia
  module Transport
    class Transport
      include RetryOutcomeType
      include CallType

      # @param config [Configuration]
      # @param requester [Object] requester used for sending requests. Uses Algolia::Http::HttpRequester by default
      #
      def initialize(config, requester)
        @config           = config
        @http_requester   = requester
        @retry_strategy   = RetryStrategy.new(config.hosts)
      end

      # @param call_type [Binary] READ or WRITE operation
      # @param method [Symbol] method used for request
      # @param path [String] path of the request
      # @param body [Hash] request body
      # @param opts [Hash] contains extra parameters to send with your query
      #
      # @return [Response] response of the request
      #
      def request(call_type, method, path, body, opts = {})
        @retry_strategy.get_tryable_hosts(call_type).each do |host|
          opts[:timeout]         ||= get_timeout(call_type) * (host.retry_count + 1)
          opts[:connect_timeout] ||= @config.connect_timeout * (host.retry_count + 1)

          request_options = RequestOptions.new(@config)
          request_options.create(opts)
          # TODO: what is this merge for ?
          # request_options.params.merge!(request_options.data) if method == :GET

          request  = build_request(method, path, body, request_options)
          response = @http_requester.send_request(
            host,
            request[:method],
            request[:path],
            request[:body],
            request[:headers],
            request[:timeout],
            request[:connect_timeout]
          )

          outcome  = @retry_strategy.decide(host, http_response_code: response.status, is_timed_out: response.has_timed_out, network_failure: response.network_failure)
          if outcome == FAILURE
            decoded_error = JSON.parse(response.error, :symbolize_names => true)
            puts decoded_error
            raise AlgoliaHttpError.new(decoded_error[:status], decoded_error[:message])
          end
          return response unless outcome == RETRY
        end

        raise AlgoliaUnreachableHostError('Unreachable hosts')
      end

      private

        # Parse the different information and build the request
        #
        # @param [Symbol] method
        # @param [String] path
        # @param [Hash] body
        # @param [RequestOptions] request_options
        #
        # @return [Hash]
        #
        def build_request(method, path, body, request_options)
          request                   = {}
          request[:method]          = method.downcase
          request[:path]            = build_uri_path(path, request_options.params)
          request[:body]            = body.nil? || body.empty? ? '' : body
          request[:headers]         = generate_headers(request_options)
          request[:timeout]         = request_options.timeout
          request[:connect_timeout] = request_options.connect_timeout
          request
        end

        # Build the uri from path and additional params
        #
        # @param [Object] path
        # @param [Object] params
        #
        # @return [String]
        #
        def build_uri_path(path, params)
          path + handle_params(params)
        end

        # Generates headers from config headers and optional parameters
        #
        # @param request_options [RequestOptions]
        #
        # @return [Hash] merged headers
        #
        def generate_headers(request_options = {})
          headers = @config.headers.merge(request_options.headers)
          if request_options.compression_type == 'gzip'
            headers['Accept-Encoding'] = 'gzip'
          end
          headers
        end

        # Retrieves a timeout according to call_type
        #
        # @param call_type [Binary] requested call type
        #
        # @return [Integer]
        #
        def get_timeout(call_type)
          case call_type
          when READ
            @config.read_timeout
          else
            @config.write_timeout
          end
        end

        # Convert params to a full query string
        #
        def handle_params(params)
          params.nil? || params.empty? ? '' : "?#{to_query_string(params)}"
        end

        # Create a query string from params
        #
        def to_query_string(params)
          params.map do |key, value|
            "#{CGI.escape(key.to_s)}=#{CGI.escape(value.to_s)}"
          end.join('&')
        end
    end
  end
end
