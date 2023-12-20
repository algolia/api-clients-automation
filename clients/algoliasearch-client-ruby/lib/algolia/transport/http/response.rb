module Algolia
  module Http
    class Response
      attr_reader :status, :body, :error, :headers, :has_timed_out, :network_failure

      # used for the echo requester
      attr_reader :method, :path, :query_params

      #
      # @option status    [String]  Response status
      # @option body    [String]  Response body
      # @option error    [String]  Response error or caught error
      # @option headers    [String]  Response headers
      # @option has_timed_out    [String]  If the request has timed out
      #
      def initialize(opts = {})
        @status          = opts[:status]
        @body            = opts[:body]
        @error           = opts[:error] || ''
        @headers         = opts[:headers] || ''
        @has_timed_out   = opts[:has_timed_out] || false
        @network_failure = opts[:network_failure] || false

        @method = opts[:method] || ''
        @path = opts[:path] || ''
        @query_params = opts[:query_params] || {}
      end
    end
  end
end
