//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Models.Abtesting;
using Algolia.Search.Transport;
using Algolia.Search.Http;
using Algolia.Search.Utils;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Algolia.Search.Clients;


/// <summary>
/// Represents a collection of functions to interact with the API endpoints
/// </summary>
public interface IAbtestingClient
{
  /// <summary>
  /// Creates a new A/B test.
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="addABTestsRequest"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> AddABTestsAsync(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Creates a new A/B test. (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="addABTestsRequest"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ABTestResponse</returns>
  ABTestResponse AddABTests(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default);

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
  /// Deletes an A/B test by its ID.
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> DeleteABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Deletes an A/B test by its ID. (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ABTestResponse</returns>
  ABTestResponse DeleteABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Retrieves the details for an A/B test by its ID.
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTest</returns>
  Task<ABTest> GetABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Retrieves the details for an A/B test by its ID. (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ABTest</returns>
  ABTest GetABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Lists all A/B tests you configured for this application.
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="offset">Position of the first item to return. (optional, default to 0)</param>
  /// <param name="limit">Number of items to return. (optional, default to 10)</param>
  /// <param name="indexPrefix">Index name prefix. Only A/B tests for indices starting with this string are included in the response. (optional)</param>
  /// <param name="indexSuffix">Index name suffix. Only A/B tests for indices ending with this string are included in the response. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ListABTestsResponse</returns>
  Task<ListABTestsResponse> ListABTestsAsync(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Lists all A/B tests you configured for this application. (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="offset">Position of the first item to return. (optional, default to 0)</param>
  /// <param name="limit">Number of items to return. (optional, default to 10)</param>
  /// <param name="indexPrefix">Index name prefix. Only A/B tests for indices starting with this string are included in the response. (optional)</param>
  /// <param name="indexSuffix">Index name suffix. Only A/B tests for indices ending with this string are included in the response. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ListABTestsResponse</returns>
  ListABTestsResponse ListABTests(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Schedule an A/B test to be started at a later time. 
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="scheduleABTestsRequest"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ScheduleABTestResponse</returns>
  Task<ScheduleABTestResponse> ScheduleABTestAsync(ScheduleABTestsRequest scheduleABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Schedule an A/B test to be started at a later time.  (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="scheduleABTestsRequest"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ScheduleABTestResponse</returns>
  ScheduleABTestResponse ScheduleABTest(ScheduleABTestsRequest scheduleABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Stops an A/B test by its ID.  You can't restart stopped A/B tests. 
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> StopABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Stops an A/B test by its ID.  You can't restart stopped A/B tests.  (Synchronous version)
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test identifier.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>ABTestResponse</returns>
  ABTestResponse StopABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

}



/// <summary>
/// Represents a collection of functions to interact with the API endpoints
/// </summary>
public partial class AbtestingClient : IAbtestingClient
{
  private readonly HttpTransport _transport;
  private readonly ILogger<AbtestingClient> _logger;

  /// <summary>
  /// Create a new Abtesting client for the given appID and apiKey.
  /// </summary>
  /// <param name="applicationId">Your application</param>
  /// <param name="apiKey">Your API key</param>
  /// <param name="loggerFactory">Logger factory</param>
  /// <param name="region">The targeted region</param>
  public AbtestingClient(string applicationId, string apiKey, string region = null, ILoggerFactory loggerFactory = null) : this(new AbtestingConfig(applicationId, apiKey, region), new AlgoliaHttpRequester(loggerFactory), loggerFactory)
  {
  }

  /// <summary>
  /// Initialize a client with custom config
  /// </summary>
  /// <param name="config">Algolia configuration</param>
  /// <param name="loggerFactory">Logger factory</param>
  public AbtestingClient(AbtestingConfig config, ILoggerFactory loggerFactory = null) : this(config, new AlgoliaHttpRequester(loggerFactory), loggerFactory)
  {
  }

  /// <summary>
  /// Initialize the client with custom config and custom Requester
  /// </summary>
  /// <param name="config">Algolia Config</param>
  /// <param name="httpRequester">Your Http requester implementation of <see cref="IHttpRequester"/></param>
  /// <param name="loggerFactory">Logger factory</param>
  public AbtestingClient(AbtestingConfig config, IHttpRequester httpRequester, ILoggerFactory loggerFactory = null)
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
    _logger = factory.CreateLogger<AbtestingClient>();

    if (_logger.IsEnabled(Microsoft.Extensions.Logging.LogLevel.Information))
    {
      _logger.LogInformation("Algolia Abtesting client is initialized.");
    }
  }


  /// <inheritdoc />
  public async Task<ABTestResponse> AddABTestsAsync(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (addABTestsRequest == null)
      throw new ArgumentException("Parameter `addABTestsRequest` is required when calling `AddABTests`.");

    var requestOptions = new InternalRequestOptions(options);


    requestOptions.Data = addABTestsRequest;
    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("POST"), "/2/abtests", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ABTestResponse AddABTests(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => AddABTestsAsync(addABTestsRequest, options, cancellationToken));


  /// <inheritdoc />
  public async Task<object> CustomDeleteAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomDelete`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("DELETE"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public object CustomDelete(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomDeleteAsync(path, parameters, options, cancellationToken));


  /// <inheritdoc />
  public async Task<object> CustomGetAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomGet`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", QueryStringHelper.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("GET"), "/{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public object CustomGet(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomGetAsync(path, parameters, options, cancellationToken));


  /// <inheritdoc />
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


  /// <inheritdoc />
  public object CustomPost(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomPostAsync(path, parameters, body, options, cancellationToken));


  /// <inheritdoc />
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


  /// <inheritdoc />
  public object CustomPut(string path, Dictionary<string, object> parameters = default, object body = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => CustomPutAsync(path, parameters, body, options, cancellationToken));


  /// <inheritdoc />
  public async Task<ABTestResponse> DeleteABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", QueryStringHelper.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("DELETE"), "/2/abtests/{id}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ABTestResponse DeleteABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => DeleteABTestAsync(id, options, cancellationToken));


  /// <inheritdoc />
  public async Task<ABTest> GetABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", QueryStringHelper.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTest>(new HttpMethod("GET"), "/2/abtests/{id}", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ABTest GetABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => GetABTestAsync(id, options, cancellationToken));


  /// <inheritdoc />
  public async Task<ListABTestsResponse> ListABTestsAsync(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {
    var requestOptions = new InternalRequestOptions(options);


    requestOptions.AddQueryParameter("offset", offset);
    requestOptions.AddQueryParameter("limit", limit);
    requestOptions.AddQueryParameter("indexPrefix", indexPrefix);
    requestOptions.AddQueryParameter("indexSuffix", indexSuffix);
    return await _transport.ExecuteRequestAsync<ListABTestsResponse>(new HttpMethod("GET"), "/2/abtests", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ListABTestsResponse ListABTests(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => ListABTestsAsync(offset, limit, indexPrefix, indexSuffix, options, cancellationToken));


  /// <inheritdoc />
  public async Task<ScheduleABTestResponse> ScheduleABTestAsync(ScheduleABTestsRequest scheduleABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (scheduleABTestsRequest == null)
      throw new ArgumentException("Parameter `scheduleABTestsRequest` is required when calling `ScheduleABTest`.");

    var requestOptions = new InternalRequestOptions(options);


    requestOptions.Data = scheduleABTestsRequest;
    return await _transport.ExecuteRequestAsync<ScheduleABTestResponse>(new HttpMethod("POST"), "/2/abtests/schedule", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ScheduleABTestResponse ScheduleABTest(ScheduleABTestsRequest scheduleABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => ScheduleABTestAsync(scheduleABTestsRequest, options, cancellationToken));


  /// <inheritdoc />
  public async Task<ABTestResponse> StopABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", QueryStringHelper.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("POST"), "/2/abtests/{id}/stop", requestOptions, cancellationToken).ConfigureAwait(false);
  }


  /// <inheritdoc />
  public ABTestResponse StopABTest(int id, RequestOptions options = null, CancellationToken cancellationToken = default) =>
    AsyncHelper.RunSync(() => StopABTestAsync(id, options, cancellationToken));

}
