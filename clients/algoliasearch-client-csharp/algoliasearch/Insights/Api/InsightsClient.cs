//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Clients;
using Algolia.Search.Models;
using Algolia.Search.Models.Insights;
using Algolia.Search.Transport;
using Algolia.Search.Http;

namespace Algolia.Search.Clients
{
  /// <summary>
  /// Represents a collection of functions to interact with the API endpoints
  /// </summary>
  public interface IInsightsClient
  {
    /// <summary>
    /// Send requests to the Algolia REST API.
    /// </summary>
    /// <remarks>
    /// This method allow you to send requests to the Algolia REST API.
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    Task<Object> CustomDeleteAsync(string path, Dictionary<string, Object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);
    /// <summary>
    /// Send requests to the Algolia REST API.
    /// </summary>
    /// <remarks>
    /// This method allow you to send requests to the Algolia REST API.
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    Task<Object> CustomGetAsync(string path, Dictionary<string, Object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);
    /// <summary>
    /// Send requests to the Algolia REST API.
    /// </summary>
    /// <remarks>
    /// This method allow you to send requests to the Algolia REST API.
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="body">Parameters to send with the custom request. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    Task<Object> CustomPostAsync(string path, Dictionary<string, Object> parameters = default, Object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);
    /// <summary>
    /// Send requests to the Algolia REST API.
    /// </summary>
    /// <remarks>
    /// This method allow you to send requests to the Algolia REST API.
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="body">Parameters to send with the custom request. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    Task<Object> CustomPutAsync(string path, Dictionary<string, Object> parameters = default, Object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);
    /// <summary>
    /// Delete user token.
    /// </summary>
    /// <remarks>
    /// Delete all events related to a certain user token from events metrics and analytics. To delete a personalization user profile, see [Delete a user profile](https://www.algolia.com/doc/rest-api/personalization/#delete-a-user-profile). 
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="userToken">The user token for which to delete all associated events.</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of  </returns>
    Task DeleteUserTokenAsync(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default);
    /// <summary>
    /// Send events.
    /// </summary>
    /// <remarks>
    /// Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB. 
    /// </remarks>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="insightsEvents"></param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of EventsResponse</returns>
    Task<EventsResponse> PushEventsAsync(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default);
  }


  /// <summary>
  /// Represents a collection of functions to interact with the API endpoints
  /// </summary>
  public partial class InsightsClient : IInsightsClient
  {
    private readonly HttpTransport _transport;
    private readonly AlgoliaConfig _config;

    /// <summary>
    /// Create a new Insights client for the given appID and apiKey.
    /// </summary>
    /// <param name="applicationId">Your application</param>
    /// <param name="apiKey">Your API key</param>
    /// <param name="region">The targeted region</param>
    public InsightsClient(string applicationId, string apiKey, string region = null) : this(new InsightsConfig(applicationId, apiKey, region), new AlgoliaHttpRequester())
    {
    }

    /// <summary>
    /// Initialize a client with custom config
    /// </summary>
    /// <param name="config">Algolia configuration</param>
    public InsightsClient(InsightsConfig config) : this(config, new AlgoliaHttpRequester())
    {
    }

    /// <summary>
    /// Initialize the client with custom config and custom Requester
    /// </summary>
    /// <param name="config">Algolia Config</param>
    /// <param name="httpRequester">Your Http requester implementation of <see cref="IHttpRequester"/></param>
    public InsightsClient(InsightsConfig config, IHttpRequester httpRequester)
    {
      if (httpRequester == null)
      {
        throw new ArgumentException("An httpRequester is required");
      }
      if (config == null)
      {
        throw new ArgumentException("A config is required");
      }
      if (string.IsNullOrWhiteSpace(config.AppId))
      {
        throw new ArgumentException("`AppId` is missing.");
      }
      if (string.IsNullOrWhiteSpace(config.ApiKey))
      {
        throw new ArgumentException("`ApiKey` is missing.");
      }

      _config = config;
      _transport = new HttpTransport(config, httpRequester);
    }


    /// <summary>
    /// Send requests to the Algolia REST API. This method allow you to send requests to the Algolia REST API.
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    public async Task<Object> CustomDeleteAsync(string path, Dictionary<string, Object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (path == null)
        throw new ApiException(400, "Parameter `path` is required when calling `CustomDelete`.");
      var requestOptions = new InternalRequestOptions(options);
      requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

      requestOptions.AddCustomQueryParameters(parameters);
      return await _transport.ExecuteRequestAsync<Object>(new HttpMethod("DELETE"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
    }

    /// <summary>
    /// Send requests to the Algolia REST API. This method allow you to send requests to the Algolia REST API.
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    public async Task<Object> CustomGetAsync(string path, Dictionary<string, Object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (path == null)
        throw new ApiException(400, "Parameter `path` is required when calling `CustomGet`.");
      var requestOptions = new InternalRequestOptions(options);
      requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

      requestOptions.AddCustomQueryParameters(parameters);
      return await _transport.ExecuteRequestAsync<Object>(new HttpMethod("GET"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
    }

    /// <summary>
    /// Send requests to the Algolia REST API. This method allow you to send requests to the Algolia REST API.
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="body">Parameters to send with the custom request. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    public async Task<Object> CustomPostAsync(string path, Dictionary<string, Object> parameters = default, Object body = default, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (path == null)
        throw new ApiException(400, "Parameter `path` is required when calling `CustomPost`.");
      var requestOptions = new InternalRequestOptions(options);
      requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

      requestOptions.AddCustomQueryParameters(parameters);
      requestOptions.Data = body;
      return await _transport.ExecuteRequestAsync<Object>(new HttpMethod("POST"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
    }

    /// <summary>
    /// Send requests to the Algolia REST API. This method allow you to send requests to the Algolia REST API.
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
    /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
    /// <param name="body">Parameters to send with the custom request. (optional)</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of Object</returns>
    public async Task<Object> CustomPutAsync(string path, Dictionary<string, Object> parameters = default, Object body = default, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (path == null)
        throw new ApiException(400, "Parameter `path` is required when calling `CustomPut`.");
      var requestOptions = new InternalRequestOptions(options);
      requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

      requestOptions.AddCustomQueryParameters(parameters);
      requestOptions.Data = body;
      return await _transport.ExecuteRequestAsync<Object>(new HttpMethod("PUT"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
    }

    /// <summary>
    /// Delete user token. Delete all events related to a certain user token from events metrics and analytics. To delete a personalization user profile, see [Delete a user profile](https://www.algolia.com/doc/rest-api/personalization/#delete-a-user-profile). 
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="userToken">The user token for which to delete all associated events.</param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of  </returns>
    public async Task DeleteUserTokenAsync(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (userToken == null)
        throw new ApiException(400, "Parameter `userToken` is required when calling `DeleteUserToken`.");
      var requestOptions = new InternalRequestOptions(options);

      requestOptions.PathParameters.Add("userToken", ClientUtils.ParameterToString(userToken));

      await _transport.ExecuteRequestAsync(new HttpMethod("DELETE"), "/1/usertokens/{userToken}", requestOptions, cancellationToken).ConfigureAwait(false);
    }

    /// <summary>
    /// Send events. Send a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&amp;nbsp;MB. 
    /// </summary>
    /// <exception cref="Algolia.Search.Insights.Client.ApiException">Thrown when fails to make API call</exception>
    /// <param name="insightsEvents"></param>
    /// <param name="options">Add extra http header or query parameters to Algolia.</param>
    /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
    /// <returns>Task of EventsResponse</returns>
    public async Task<EventsResponse> PushEventsAsync(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default)
    {
      if (insightsEvents == null)
        throw new ApiException(400, "Parameter `insightsEvents` is required when calling `PushEvents`.");
      var requestOptions = new InternalRequestOptions(options);


      requestOptions.Data = insightsEvents;
      return await _transport.ExecuteRequestAsync<EventsResponse>(new HttpMethod("POST"), "/1/events", requestOptions, cancellationToken).ConfigureAwait(false);
    }
  }
}
