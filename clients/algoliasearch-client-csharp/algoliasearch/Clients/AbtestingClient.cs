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
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Algolia.Search.Clients;


/// <summary>
/// Represents a collection of functions to interact with the API endpoints
/// </summary>
public interface IAbtestingClient
{
  /// <summary>
  /// Creates an A/B test.
  /// </summary>
  /// <param name="addABTestsRequest"></param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> AddABTestsAsync(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default);

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
  /// Delete an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> DeleteABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// Get specific details for an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTest</returns>
  Task<ABTest> GetABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// List all A/B tests.
  /// </summary>
  /// <param name="offset">Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)</param>
  /// <param name="limit">Number of records to return (page size). (optional, default to 10)</param>
  /// <param name="indexPrefix">Only return A/B tests for indices starting with this prefix. (optional)</param>
  /// <param name="indexSuffix">Only return A/B tests for indices ending with this suffix. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ListABTestsResponse</returns>
  Task<ListABTestsResponse> ListABTestsAsync(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default);

  /// <summary>
  /// If stopped, the test is over and can't be restarted. There is now only one index, receiving 100% of all search requests. The data gathered for stopped A/B tests is retained. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  Task<ABTestResponse> StopABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default);

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


  /// <summary>
  /// Creates an A/B test.
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
  public async Task<ABTestResponse> AddABTestsAsync(AddABTestsRequest addABTestsRequest, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (addABTestsRequest == null)
      throw new ArgumentException("Parameter `addABTestsRequest` is required when calling `AddABTests`.");

    var requestOptions = new InternalRequestOptions(options);


    requestOptions.Data = addABTestsRequest;
    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("POST"), "/2/abtests", requestOptions, cancellationToken).ConfigureAwait(false);
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
    requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("DELETE"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
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
  public async Task<object> CustomGetAsync(string path, Dictionary<string, object> parameters = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    if (path == null)
      throw new ArgumentException("Parameter `path` is required when calling `CustomGet`.");

    var requestOptions = new InternalRequestOptions(options);
    requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("GET"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }

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
    requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    requestOptions.Data = body;
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("POST"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }

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
    requestOptions.CustomPathParameters.Add("path", ClientUtils.ParameterToString(path));

    requestOptions.AddCustomQueryParameters(parameters);
    requestOptions.Data = body;
    return await _transport.ExecuteRequestAsync<object>(new HttpMethod("PUT"), "/1{path}", requestOptions, cancellationToken).ConfigureAwait(false);
  }

  /// <summary>
  /// Delete an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  public async Task<ABTestResponse> DeleteABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", ClientUtils.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("DELETE"), "/2/abtests/{id}", requestOptions, cancellationToken).ConfigureAwait(false);
  }

  /// <summary>
  /// Get specific details for an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTest</returns>
  public async Task<ABTest> GetABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", ClientUtils.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTest>(new HttpMethod("GET"), "/2/abtests/{id}", requestOptions, cancellationToken).ConfigureAwait(false);
  }

  /// <summary>
  /// List all A/B tests.
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - analytics
  /// <param name="offset">Position of the starting record. Used for paging. 0 is the first record. (optional, default to 0)</param>
  /// <param name="limit">Number of records to return (page size). (optional, default to 10)</param>
  /// <param name="indexPrefix">Only return A/B tests for indices starting with this prefix. (optional)</param>
  /// <param name="indexSuffix">Only return A/B tests for indices ending with this suffix. (optional)</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ListABTestsResponse</returns>
  public async Task<ListABTestsResponse> ListABTestsAsync(int? offset = default, int? limit = default, string indexPrefix = default, string indexSuffix = default, RequestOptions options = null, CancellationToken cancellationToken = default)
  {
    var requestOptions = new InternalRequestOptions(options);


    requestOptions.AddQueryParameter("offset", offset);
    requestOptions.AddQueryParameter("limit", limit);
    requestOptions.AddQueryParameter("indexPrefix", indexPrefix);
    requestOptions.AddQueryParameter("indexSuffix", indexSuffix);
    return await _transport.ExecuteRequestAsync<ListABTestsResponse>(new HttpMethod("GET"), "/2/abtests", requestOptions, cancellationToken).ConfigureAwait(false);
  }

  /// <summary>
  /// If stopped, the test is over and can't be restarted. There is now only one index, receiving 100% of all search requests. The data gathered for stopped A/B tests is retained. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests). 
  /// </summary>
  ///
  /// Required API Key ACLs:
  ///   - editSettings
  /// <param name="id">Unique A/B test ID.</param>
  /// <param name="options">Add extra http header or query parameters to Algolia.</param>
  /// <param name="cancellationToken">Cancellation Token to cancel the request.</param>
  /// <exception cref="ArgumentException">Thrown when arguments are not correct</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaApiException">Thrown when the API call was rejected by Algolia</exception>
  /// <exception cref="Algolia.Search.Exceptions.AlgoliaUnreachableHostException">Thrown when the client failed to call the endpoint</exception>
  /// <returns>Task of ABTestResponse</returns>
  public async Task<ABTestResponse> StopABTestAsync(int id, RequestOptions options = null, CancellationToken cancellationToken = default)
  {

    var requestOptions = new InternalRequestOptions(options);

    requestOptions.PathParameters.Add("id", ClientUtils.ParameterToString(id));

    return await _transport.ExecuteRequestAsync<ABTestResponse>(new HttpMethod("POST"), "/2/abtests/{id}/stop", requestOptions, cancellationToken).ConfigureAwait(false);
  }
}

