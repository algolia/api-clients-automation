module Algolia
  module Transport
    class EchoRequester
      def send_request(_host, method, path, body, headers, _timeout, _connect_timeout)
        Http::Response.new(status: 200, body: body, headers: headers, method: method, path: path)
      end
    end
  end
end
