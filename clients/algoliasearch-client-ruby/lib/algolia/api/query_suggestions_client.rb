# frozen_string_literal: true

# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

module Algolia
  class QuerySuggestionsClient
    attr_accessor :api_client

    def initialize(config = nil)
      raise "`config` is missing." if config.nil?
      raise "`app_id` is missing." if config.app_id.nil? || config.app_id == ""
      raise "`api_key` is missing." if config.api_key.nil? || config.api_key == ""

      @api_client = Algolia::ApiClient.new(config)
    end

    def self.create(app_id, api_key, region = nil, opts = {})
      hosts = []
      regions = ["eu", "us"]

      if region.is_a?(Hash) && (opts.nil? || opts.empty?)
        opts = region
        region = nil
      end

      if region.nil? || !region.is_a?(String) || !regions.include?(region)
        raise "`region` is required and must be one of the following: #{regions.join(", ")}"
      end

      hosts <<
        Transport::StatefulHost.new(
          "query-suggestions.{region}.algolia.com".sub("{region}", region),
          accept: CallType::READ | CallType::WRITE
        )

      config = Algolia::Configuration.new(app_id, api_key, hosts, "QuerySuggestions", opts)
      create_with_config(config)
    end

    def self.create_with_config(config)
      if config.connect_timeout.nil?
        config.connect_timeout = 2000
      end

      if config.read_timeout.nil?
        config.read_timeout = 5000
      end

      if config.write_timeout.nil?
        config.write_timeout = 30000
      end

      new(config)
    end

    # Helper method to switch the API key used to authenticate the requests.
    #
    # @param api_key [String] the new API key to use.
    # @return [void]
    def set_client_api_key(api_key)
      @api_client.set_client_api_key(api_key)

      self
    end

    def add_user_agent_segment(segment, version = nil)
      @api_client.config.add_user_agent_segment(segment, version)

      self
    end

    # Creates a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param configuration_with_index [ConfigurationWithIndex]  (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def create_config_with_http_info(configuration_with_index, request_options = {})
      # verify the required parameter 'configuration_with_index' is set
      if @api_client.config.client_side_validation && configuration_with_index.nil?
        raise ArgumentError, "Parameter `configuration_with_index` is required when calling `create_config`."
      end

      path = "/1/configs"
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body] || @api_client.object_to_http_body(configuration_with_index)

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.create_config",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:POST, path, new_options)
    end

    # Creates a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param configuration_with_index [ConfigurationWithIndex]  (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [BaseResponse]
    def create_config(configuration_with_index, request_options = {})
      response = create_config_with_http_info(configuration_with_index, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "QuerySuggestions::BaseResponse")
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def custom_delete_with_http_info(path, parameters = nil, request_options = {})
      # verify the required parameter 'path' is set
      if @api_client.config.client_side_validation && path.nil?
        raise ArgumentError, "Parameter `path` is required when calling `custom_delete`."
      end

      path = "/{path}".sub("{" + "path" + "}", path.to_s)
      query_params = {}
      query_params = query_params.merge(parameters) unless parameters.nil?
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.custom_delete",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:DELETE, path, new_options)
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Object]
    def custom_delete(path, parameters = nil, request_options = {})
      response = custom_delete_with_http_info(path, parameters, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "Object")
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def custom_get_with_http_info(path, parameters = nil, request_options = {})
      # verify the required parameter 'path' is set
      if @api_client.config.client_side_validation && path.nil?
        raise ArgumentError, "Parameter `path` is required when calling `custom_get`."
      end

      path = "/{path}".sub("{" + "path" + "}", path.to_s)
      query_params = {}
      query_params = query_params.merge(parameters) unless parameters.nil?
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.custom_get",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:GET, path, new_options)
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Object]
    def custom_get(path, parameters = nil, request_options = {})
      response = custom_get_with_http_info(path, parameters, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "Object")
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param body [Object] Parameters to send with the custom request.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def custom_post_with_http_info(path, parameters = nil, body = nil, request_options = {})
      # verify the required parameter 'path' is set
      if @api_client.config.client_side_validation && path.nil?
        raise ArgumentError, "Parameter `path` is required when calling `custom_post`."
      end

      path = "/{path}".sub("{" + "path" + "}", path.to_s)
      query_params = {}
      query_params = query_params.merge(parameters) unless parameters.nil?
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body] || @api_client.object_to_http_body(body)

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.custom_post",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:POST, path, new_options)
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param body [Object] Parameters to send with the custom request.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Object]
    def custom_post(path, parameters = nil, body = nil, request_options = {})
      response = custom_post_with_http_info(path, parameters, body, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "Object")
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param body [Object] Parameters to send with the custom request.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def custom_put_with_http_info(path, parameters = nil, body = nil, request_options = {})
      # verify the required parameter 'path' is set
      if @api_client.config.client_side_validation && path.nil?
        raise ArgumentError, "Parameter `path` is required when calling `custom_put`."
      end

      path = "/{path}".sub("{" + "path" + "}", path.to_s)
      query_params = {}
      query_params = query_params.merge(parameters) unless parameters.nil?
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body] || @api_client.object_to_http_body(body)

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.custom_put",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:PUT, path, new_options)
    end

    # This method lets you send requests to the Algolia REST API.

    # @param path [String] Path of the endpoint, for example `1/newFeature`. (required)
    # @param parameters [Hash<String, Object>] Query parameters to apply to the current query.
    # @param body [Object] Parameters to send with the custom request.
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Object]
    def custom_put(path, parameters = nil, body = nil, request_options = {})
      response = custom_put_with_http_info(path, parameters, body, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "Object")
    end

    # Deletes a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. To delete the Query Suggestions index itself, use the Search API and the `Delete an index` operation.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def delete_config_with_http_info(index_name, request_options = {})
      # verify the required parameter 'index_name' is set
      if @api_client.config.client_side_validation && index_name.nil?
        raise ArgumentError, "Parameter `index_name` is required when calling `delete_config`."
      end

      path = "/1/configs/{indexName}".sub("{" + "indexName" + "}", Transport.encode_uri(index_name.to_s))
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.delete_config",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:DELETE, path, new_options)
    end

    # Deletes a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. To delete the Query Suggestions index itself, use the Search API and the `Delete an index` operation.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [BaseResponse]
    def delete_config(index_name, request_options = {})
      response = delete_config_with_http_info(index_name, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "QuerySuggestions::BaseResponse")
    end

    # Retrieves all Query Suggestions configurations of your Algolia application.
    #
    # Required API Key ACLs:
    #   - settings
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def get_all_configs_with_http_info(request_options = {})
      path = "/1/configs"
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.get_all_configs",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:GET, path, new_options)
    end

    # Retrieves all Query Suggestions configurations of your Algolia application.
    #
    # Required API Key ACLs:
    #   - settings
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Array<ConfigurationResponse>]
    def get_all_configs(request_options = {})
      response = get_all_configs_with_http_info(request_options)
      @api_client.deserialize(
        response.body,
        request_options[:debug_return_type] || "Array<QuerySuggestions::ConfigurationResponse>"
      )
    end

    # Retrieves a single Query Suggestions configuration by its index name.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def get_config_with_http_info(index_name, request_options = {})
      # verify the required parameter 'index_name' is set
      if @api_client.config.client_side_validation && index_name.nil?
        raise ArgumentError, "Parameter `index_name` is required when calling `get_config`."
      end

      path = "/1/configs/{indexName}".sub("{" + "indexName" + "}", Transport.encode_uri(index_name.to_s))
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.get_config",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:GET, path, new_options)
    end

    # Retrieves a single Query Suggestions configuration by its index name.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [ConfigurationResponse]
    def get_config(index_name, request_options = {})
      response = get_config_with_http_info(index_name, request_options)
      @api_client.deserialize(
        response.body,
        request_options[:debug_return_type] || "QuerySuggestions::ConfigurationResponse"
      )
    end

    # Reports the status of a Query Suggestions index.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def get_config_status_with_http_info(index_name, request_options = {})
      # verify the required parameter 'index_name' is set
      if @api_client.config.client_side_validation && index_name.nil?
        raise ArgumentError, "Parameter `index_name` is required when calling `get_config_status`."
      end

      path = "/1/configs/{indexName}/status".sub("{" + "indexName" + "}", Transport.encode_uri(index_name.to_s))
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.get_config_status",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:GET, path, new_options)
    end

    # Reports the status of a Query Suggestions index.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [ConfigStatus]
    def get_config_status(index_name, request_options = {})
      response = get_config_status_with_http_info(index_name, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "QuerySuggestions::ConfigStatus")
    end

    # Retrieves the logs for a single Query Suggestions index.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def get_log_file_with_http_info(index_name, request_options = {})
      # verify the required parameter 'index_name' is set
      if @api_client.config.client_side_validation && index_name.nil?
        raise ArgumentError, "Parameter `index_name` is required when calling `get_log_file`."
      end

      path = "/1/logs/{indexName}".sub("{" + "indexName" + "}", Transport.encode_uri(index_name.to_s))
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body]

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.get_log_file",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:GET, path, new_options)
    end

    # Retrieves the logs for a single Query Suggestions index.
    #
    # Required API Key ACLs:
    #   - settings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [LogFile]
    def get_log_file(index_name, request_options = {})
      response = get_log_file_with_http_info(index_name, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "QuerySuggestions::LogFile")
    end

    # Updates a QuerySuggestions configuration.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param configuration [Configuration]  (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [Http::Response] the response
    def update_config_with_http_info(index_name, configuration, request_options = {})
      # verify the required parameter 'index_name' is set
      if @api_client.config.client_side_validation && index_name.nil?
        raise ArgumentError, "Parameter `index_name` is required when calling `update_config`."
      end
      # verify the required parameter 'configuration' is set
      if @api_client.config.client_side_validation && configuration.nil?
        raise ArgumentError, "Parameter `configuration` is required when calling `update_config`."
      end

      path = "/1/configs/{indexName}".sub("{" + "indexName" + "}", Transport.encode_uri(index_name.to_s))
      query_params = {}
      query_params = query_params.merge(request_options[:query_params]) unless request_options[:query_params].nil?
      header_params = {}
      header_params = header_params.merge(request_options[:header_params]) unless request_options[:header_params].nil?

      post_body = request_options[:debug_body] || @api_client.object_to_http_body(configuration)

      new_options = request_options.merge(
        :operation => :"QuerySuggestionsClient.update_config",
        :header_params => header_params,
        :query_params => query_params,
        :body => post_body,
        :use_read_transporter => false
      )

      @api_client.call_api(:PUT, path, new_options)
    end

    # Updates a QuerySuggestions configuration.
    #
    # Required API Key ACLs:
    #   - editSettings
    # @param index_name [String] Query Suggestions index name. (required)
    # @param configuration [Configuration]  (required)
    # @param request_options: The request options to send along with the query, they will be merged with the transporter base parameters (headers, query params, timeouts, etc.). (optional)
    # @return [BaseResponse]
    def update_config(index_name, configuration, request_options = {})
      response = update_config_with_http_info(index_name, configuration, request_options)
      @api_client.deserialize(response.body, request_options[:debug_return_type] || "QuerySuggestions::BaseResponse")
    end

  end
end
