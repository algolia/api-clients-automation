require "securerandom"

module Algolia
  module Transport
    # Mints the Request-ID tracing header sent by the clients that support it.
    module RequestId
      HEADER = "request-id".freeze
      CORRELATION_HEADER = "Correlation-ID".freeze
      QUERY_PARAM = "x-algolia-request-id".freeze

      # Returns a fresh 11-character base62 identifier suitable for the Request-ID header.
      #
      # @return [String]
      #
      def self.generate
        SecureRandom.alphanumeric(11)
      end

      # Whether the given headers already carry a Request-ID entry, whatever its casing
      # and key type. Header hashes keep the caller's literal casing and may use symbol
      # keys, so the lookup must not assume a canonical form.
      #
      # @param headers [Hash, nil]
      #
      # @return [true, false]
      #
      def self.request_id?(headers)
        return false unless headers.respond_to?(:each_pair)

        headers.any? { |k, _| k.to_s.casecmp?(HEADER) }
      end

      # The Request-ID value carried by the given headers, or nil when absent.
      #
      # @param headers [Hash, nil]
      #
      # @return [String, nil]
      #
      def self.value(headers)
        return nil unless headers.respond_to?(:each_pair)

        headers.find { |k, _| k.to_s.casecmp?(HEADER) }&.last
      end

      # Whether the given query parameters already carry an x-algolia-request-id
      # entry, whatever its casing and key type. The server consults the query
      # parameter only when the header is absent, so minting a header would
      # override a caller-supplied value sent on that channel.
      #
      # @param query_params [Hash, nil]
      #
      # @return [true, false]
      #
      def self.request_id_query_param?(query_params)
        return false unless query_params.respond_to?(:each_pair)

        query_params.any? { |k, _| k.to_s.casecmp?(QUERY_PARAM) }
      end

      # The x-algolia-request-id value carried by the given query parameters, or nil when absent.
      #
      # @param query_params [Hash, nil]
      #
      # @return [String, nil]
      #
      def self.query_param_value(query_params)
        return nil unless query_params.respond_to?(:each_pair)

        query_params.find { |k, _| k.to_s.casecmp?(QUERY_PARAM) }&.last
      end
    end
  end
end
