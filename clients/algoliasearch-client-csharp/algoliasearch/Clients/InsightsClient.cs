//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Models.Insights;
using Algolia.Search.Transport;
using Algolia.Search.Http;
using Algolia.Search.Utils;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Algolia.Search.Clients;


/// <summary>
/// Represents a collection of functions to interact with the API endpoints
/// </summary>
public interface IInsightsClient
{
  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  Task<object> CustomDeleteAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  object CustomDelete(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  Task<object> CustomGetAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  object CustomGet(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  Task<object> CustomPostAsync(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  object CustomPost(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  Task<object> CustomPutAsync(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \"/1\" must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  object CustomPut(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is asynchronous, and processed within 48 hours. To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile). 
  /// </summary>
  /// <param name="userToken">User token for which to delete all associated events.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of  </returns>
  Task DeleteUserTokenAsync(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is asynchronous, and processed within 48 hours. To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile).  (Synchronous version)
  /// </summary>
  /// <param name="userToken">User token for which to delete all associated events.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns> </returns>
  void DeleteUserToken(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB. 
  /// </summary>
  /// <param name="insightsEvents"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of EventsResponse</returns>
  Task<EventsResponse> PushEventsAsync(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.  (Synchronous version)
  /// </summary>
  /// <param name="insightsEvents"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>EventsResponse</returns>
  EventsResponse PushEvents(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default);

}



/// <summary>
/// Represents a collection of functions to interact with the API endpoints
/// </summary>
public partial class InsightsClient : IInsightsClient
{
  private readonly HttpTransport _transport;
  private readonly ILogger<InsightsClient> _logger;

  /// <summary>
  /// Create a new Insights client for the given appID and apiKey.
  /// </summary>
  /// <param name="applicationId">Your application</param>
  /// <param name="apiKey">Your API key</param>
  /// <param name="loggerFactory">Logger factory</param>
  /// <param name="region">The targeted region</param>
  public InsightsClient(string applicationId, string apiKey, string region = null, ILoggerFactory loggerFactory = null) : this(new InsightsConfig(applicationId, apiKey, region), new AlgoliaHttpRequester(loggerFactory), loggerFactory)
  {
  }

  /// <summary>
  /// Initialize a client with custom config
  /// </summary>
  /// <param name="config">Algolia configuration</param>
  /// <param name="loggerFactory">Logger factory</param>
  public InsightsClient(InsightsConfig config, ILoggerFactory loggerFactory = null) : this(config, new AlgoliaHttpRequester(loggerFactory), loggerFactory)
  {
  }

  /// <summary>
  /// Initialize the client with custom config and custom Requester
  /// </summary>
  /// <param name="config">Algolia Config</param>
  /// <param name="httpRequester">Your Http requester implementation of <see cref="IHttpRequester"/></param>
  /// <param name="loggerFactory">Logger factory</param>
  public InsightsClient(InsightsConfig config, IHttpRequester httpRequester, ILoggerFactory loggerFactory = null)
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

    var factory = loggerFactory ?? NullLoggerFactory.Instance;
    _transport = new HttpTransport(config, httpRequester, factory);
    _logger = factory.CreateLogger<InsightsClient>();

    if (_logger.IsEnabled(Microsoft.Extensions.Logging.LogLevel.Information))
    {
      _logger.LogInformation("Algolia Insights client is initialized.");
    }
  }


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  public async Task<object> CustomDeleteAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomDelete`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("DELETE"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  public object CustomDelete(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomDeleteAsync(path, parameters, options, cancellationToken));


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  public async Task<object> CustomGetAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomGet`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("GET"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  public object CustomGet(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomGetAsync(path, parameters, options, cancellationToken));


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  public async Task<object> CustomPostAsync(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomPost`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    requestOptions.Data = body;
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("POST"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  public object CustomPost(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomPostAsync(path, parameters, body, options, cancellationToken));


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API.
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of object</returns>
  public async Task<object> CustomPutAsync(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomPut`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    requestOptions.Data = body;
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("PUT"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// This method allow you to send requests to the Algolia REST API. (Synchronous version)
  /// </summary>
  /// <param name="path">Path of the endpoint, anything after \&quot;/1\&quot; must be specified.</param>
  /// <param name="parameters">Query parameters to apply to the current query. (optional)</param>
  /// <param name="body">Parameters to send with the custom request. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>object</returns>
  public object CustomPut(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomPutAsync(path, parameters, body, options, cancellationToken));


  /// <summary>
  /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is asynchronous, and processed within 48 hours. To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile). 
  /// </summary>
  /// <param name="userToken">User token for which to delete all associated events.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of  </returns>
  public async Task DeleteUserTokenAsync(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (userToken == null)
      throw new ArgumentException("Parameter `userToken` is required when calling `DeleteUserToken`.");

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("userToken", QueryStringHelper.ParameterToString(userToken));

    await _transport.ExecuteRequestAsync(new HttpMethod("DELETE"), "/1/usertokens/{userToken}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is asynchronous, and processed within 48 hours. To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile).  (Synchronous version)
  /// </summary>
  /// <param name="userToken">User token for which to delete all associated events.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns> </returns>
  public void DeleteUserToken(string userToken, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => DeleteUserTokenAsync(userToken, options, cancellationToken));


  /// <summary>
  /// Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB. 
  /// </summary>
  /// <param name="insightsEvents"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of EventsResponse</returns>
  public async Task<EventsResponse> PushEventsAsync(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (insightsEvents == null)
      throw new ArgumentException("Parameter `insightsEvents` is required when calling `PushEvents`.");

    var requestOptions = new InternalRequestOptions(options);


    requestOptions.Data = insightsEvents;
    return await _transport.ExecuteRequestAsync<EventsResponse>(new HttpMethod("POST"), "/1/events", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <summary>
  /// Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.  (Synchronous version)
  /// </summary>
  /// <param name="insightsEvents"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>EventsResponse</returns>
  public EventsResponse PushEvents(InsightsEvents insightsEvents, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => PushEventsAsync(insightsEvents, options, cancellationToken));

}

