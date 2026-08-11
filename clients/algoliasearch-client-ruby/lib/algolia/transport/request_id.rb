require "securerandom"

module Algolia
  module Transport
    # Mints the Request-ID tracing header sent by the clients that support it.
    module RequestId
      HEADER = "Request-ID".freeze

      # Returns a fresh 11-character base62 identifier suitable for the Request-ID header.
      def self.generate
        SecureRandom.alphanumeric(11)
      end

      # Whether the given headers already carry a Request-ID entry, whatever its casing
      # and key type. Header hashes keep the caller's literal casing and may use symbol
      # keys, so the lookup must not assume a canonical form.
      def self.request_id?(headers)
        return false unless headers.respond_to?(:each_pair)

        headers.any? { |k, _| k.to_s.casecmp?(HEADER) }
      end
    end
  end
end
