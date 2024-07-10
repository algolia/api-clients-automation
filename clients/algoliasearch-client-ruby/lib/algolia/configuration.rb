# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

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
      :requester
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
      @write_timeout = opts[:write_timeout] || 30_000
      @read_timeout = opts[:read_timeout] || 5_000
      @connect_timeout = opts[:connect_timeout] || 2_000
      @compression_type = opts[:compression_type] || "none"
      @requester = opts[:requester]

      @user_agent = UserAgent.new.add(client_name, VERSION)

      @header_params = {
        "X-Algolia-Application-Id" => app_id,
        "X-Algolia-API-Key" => api_key,
        "Content-Type" => "application/json",
        "User-Agent" => @user_agent
      }
      @header_params.transform_keys!(&:downcase)

      yield(self) if block_given?
    end

    # The default Configuration object.
    def self.default
      @@default ||= Configuration.new
    end
  end
end
