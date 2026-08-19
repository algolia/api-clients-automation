module Algolia
  class Configuration
    attr_accessor(
      :hosts,
      :app_id,
      :api_key,
      :user_agent,
      :header_params,
      :read_timeout,
      :write_timeout,
      :connect_timeout,
      :compression_type,
      :requester,
      :transformation_options,
      :request_id_enabled
    )

    # Set this to false to skip client side validation in the operation.
    # Default to true.
    # @return [true, false]
    attr_accessor :client_side_validation

    def initialize(app_id, api_key, hosts, client_name, opts = {})
      @hosts = hosts
      @app_id = app_id
      @api_key = api_key
      @client_side_validation = opts[:client_side_validation].nil? ? true : opts[:client_side_validation]
      @connect_timeout = opts[:connect_timeout]
      @read_timeout = opts[:read_timeout]
      @write_timeout = opts[:write_timeout]
      @compression_type = opts[:compression_type] || "none"
      @requester = opts[:requester]
      @transformation_options = opts[:transformation_options]

      # Whether the transport sends a Request-ID header, minted once per call and
      # reused across its retry attempts, so that Algolia support can tie the attempts
      # of one request together. When nil, the generated clients apply their
      # per-client default (on for the search, recommend and composition APIs, off
      # elsewhere); an explicit true or false always wins over that default. A
      # Request-ID supplied through request options or the config headers is never
      # overwritten.
      @request_id_enabled = opts[:request_id_enabled]

      @user_agent = UserAgent.new.add(client_name, VERSION)

      if opts[:user_agent_segments]
        opts[:user_agent_segments].each do |segment|
          @user_agent.add(segment)
        end
      end

      @header_params = {
        "X-Algolia-Application-Id" => app_id,
        "X-Algolia-API-Key" => api_key,
        "Content-Type" => "application/json",
        "User-Agent" => @user_agent.value
      }
      @header_params.transform_keys!(&:downcase)

      yield(self) if block_given?
    end

    def set_client_api_key(api_key)
      @api_key = api_key
      @header_params["X-Algolia-API-Key"] = api_key

      self
    end

    # The default Configuration object.
    def self.default
      @@default ||= Configuration.new
    end

    def add_user_agent_segment(segment, version = nil)
      @user_agent.add(segment, version)
      @header_params["user-agent"] = @user_agent.value

      self
    end
  end
end
