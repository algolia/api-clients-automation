module Algolia
  module Transport
    class StatefulHost
      include CallType

      attr_reader :url, :protocol, :accept, :port
      attr_accessor :last_use, :retry_count, :up

      # @param url [String] host url
      # @option options [binary] :accept accept type flag
      # @option options [DateTime] :last_use last usage date
      # @option options [Integer] :retry_count number of retries
      # @option options [Boolean] :up host status
      #
      def initialize(url, opts = {})
        @url         = url
        @protocol    = opts[:protocol] || 'https://'
        @port        = opts[:port]
        @accept      = opts[:accept] || (READ | WRITE)
        @last_use    = opts[:last_use] || Time.now.utc
        @retry_count = opts[:retry_count] || 0
        @up          = opts.key?(:up) ? opts[:up] : true
      end
    end
  end
end
