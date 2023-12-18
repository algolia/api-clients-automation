# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

module Algolia
  class Configuration
    attr_accessor :hosts
    attr_accessor :app_id
    attr_accessor :api_key

    # Set this to false to skip client side validation in the operation.
    # Default to true.
    # @return [true, false]
    attr_accessor :client_side_validation

    # Set this to customize parameters encoder of array parameter.
    # Default to nil. Faraday uses NestedParamsEncoder when nil.
    #
    # @see The params_encoder option of Faraday. Related source code:
    # https://github.com/lostisland/faraday/tree/main/lib/faraday/encoders
    attr_accessor :params_encoder

    attr_accessor :inject_format

    attr_accessor :force_ending_format

    attr_accessor :user_agent
    attr_accessor :header_params
    attr_accessor :read_timeout
    attr_accessor :write_timeout
    attr_accessor :connect_timeout
    attr_accessor :compression_type

    def initialize(app_id, api_key, hosts, client_name)
      @hosts = hosts
      @app_id = app_id
      @api_key = api_key
      @client_side_validation = true
      @middlewares = Hash.new { |h, k| h[k] = [] }
      @params_encoder = nil
      @inject_format = false
      @force_ending_format = false
      @read_timeout = 30000
      @write_timeout = 5000
      @connect_timeout = 2000
      @compression_type = 'none'

      @user_agent = UserAgent::new().add(client_name, VERSION)

      @header_params = {
        'X-Algolia-Application-Id' => app_id,
        'X-Algolia-API-Key' => api_key,
        'Content-Type' => 'application/json',
        'User-Agent' => @user_agent
      }

      yield(self) if block_given?
    end

    # The default Configuration object.
    def self.default
      @@default ||= Configuration.new
    end

    # Adds middleware to the stack
    def use(*middleware)
      set_faraday_middleware(:use, *middleware)
    end

    # Adds request middleware to the stack
    def request(*middleware)
      set_faraday_middleware(:request, *middleware)
    end

    # Adds response middleware to the stack
    def response(*middleware)
      set_faraday_middleware(:response, *middleware)
    end

    # Adds Faraday middleware setting information to the stack
    #
    # @example Use the `set_faraday_middleware` method to set middleware information
    #   config.set_faraday_middleware(:request, :retry, max: 3, methods: [:get, :post], retry_statuses: [503])
    #   config.set_faraday_middleware(:response, :logger, nil, { bodies: true, log_level: :debug })
    #   config.set_faraday_middleware(:use, Faraday::HttpCache, store: Rails.cache, shared_cache: false)
    #   config.set_faraday_middleware(:insert, 0, FaradayMiddleware::FollowRedirects, { standards_compliant: true, limit: 1 })
    #   config.set_faraday_middleware(:swap, 0, Faraday::Response::Logger)
    #
    # @see https://github.com/lostisland/faraday/blob/v2.3.0/lib/faraday/rack_builder.rb#L92-L143
    def set_faraday_middleware(operation, key, *args, &block)
      unless [:request, :response, :use, :insert, :insert_before, :insert_after, :swap, :delete].include?(operation)
        fail ArgumentError, "Invalid faraday middleware operation #{operation}. Must be" \
                            " :request, :response, :use, :insert, :insert_before, :insert_after, :swap or :delete."
      end

      @middlewares[operation] << [key, args, block]
    end
    ruby2_keywords(:set_faraday_middleware) if respond_to?(:ruby2_keywords, true)

    # Set up middleware on the connection
    def configure_middleware(connection)
      return if @middlewares.empty?

      [:request, :response, :use, :insert, :insert_before, :insert_after, :swap].each do |operation|
        next unless @middlewares.key?(operation)

        @middlewares[operation].each do |key, args, block|
          connection.builder.send(operation, key, *args, &block)
        end
      end

      if @middlewares.key?(:delete)
        @middlewares[:delete].each do |key, _args, _block|
          connection.builder.delete(key)
        end
      end
    end
  end
end
