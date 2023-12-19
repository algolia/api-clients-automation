/*
* Copyright (c) 2018 Algolia
* http://www.algolia.com/
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using Algolia.Search.Client;
using Algolia.Search.Exceptions;
using Algolia.Search.Http;
using Algolia.Search.Search.Client;
using Algolia.Search.Serializer;
using Algolia.Search.Utils;

namespace Algolia.Search.Transport
{
  /// <summary>
  /// Transport logic of the library
  /// Holding an instance of the requester and the retry strategy
  /// </summary>
  internal class HttpTransport
  {
    private readonly IHttpRequester _httpClient;
    private readonly CustomJsonCodec _serializer;
    private readonly RetryStrategy _retryStrategy;
    private readonly AlgoliaConfig _algoliaConfig;
    private string errorMessage;

    /// <summary>
    /// Instantiate the transport class with the given configuration and requester
    /// </summary>
    /// <param name="config">Algolia Config</param>
    /// <param name="httpClient">An implementation of http requester <see cref="IHttpRequester"/> </param>
    public HttpTransport(AlgoliaConfig config, IHttpRequester httpClient)
    {
      _algoliaConfig = config ?? throw new ArgumentNullException(nameof(config));
      _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
      //_serializer = new DefaultSerializer();
      _serializer = new CustomJsonCodec(JsonConfig.AlgoliaJsonSerializerSettings);



      _retryStrategy = new RetryStrategy(config);
    }

    /// <summary>
    /// Execute the request (more likely request with no body like GET or Delete)
    /// </summary>
    /// <typeparam name="TResult"></typeparam>
    /// <param name="method">The HttpMethod <see cref="HttpMethod"/></param>
    /// <param name="uri">The endpoint URI</param>
    /// <param name="callType">The method Algolia's call type <see cref="CallType"/> </param>
    /// <param name="requestOptions">Add extra http header or query parameters to Algolia</param>
    /// <param name="ct">Optional cancellation token</param>
    public async Task<TResult> ExecuteRequestAsync<TResult>(HttpMethod method, string uri,
        RequestOptions requestOptions = null,
        CancellationToken ct = default)
        where TResult : class =>
        await ExecuteRequestAsync<TResult, object>(method, uri, requestOptions, ct)
            .ConfigureAwait(false);

    /// <summary>
    /// Call api with retry strategy
    /// </summary>
    /// <typeparam name="TResult">Return type</typeparam>
    /// <typeparam name="TData">Data type</typeparam>
    /// <param name="method">The HttpMethod <see cref="HttpMethod"/></param>
    /// <param name="uri">The endpoint URI</param>
    /// <param name="callType">The method Algolia's call type <see cref="CallType"/> </param>
    /// <param name="data">Your data</param>
    /// <param name="requestOptions">Add extra http header or query parameters to Algolia</param>
    /// <param name="ct">Optional cancellation token</param>
    public async Task<TResult> ExecuteRequestAsync<TResult, TData>(HttpMethod method, string uri, RequestOptions requestOptions = null,
        CancellationToken ct = default)
        where TResult : class
        where TData : class
    {
      if (string.IsNullOrWhiteSpace(uri))
      {
        throw new ArgumentNullException(nameof(uri));
      }

      if (method == null)
      {
        throw new ArgumentNullException(nameof(method));
      }

      var request = new Request
      {
        Method = method,
        Headers = GenerateHeaders(requestOptions?.HeaderParameters),
        Compression = _algoliaConfig.Compression
      };

      var callType = (requestOptions?.UseReadTransporter != null && requestOptions.UseReadTransporter.Value) || method == HttpMethod.Get ? CallType.Read : CallType.Write;

      foreach (var host in _retryStrategy.GetTryableHost(callType))
      {
        request.Body = CreateRequestContent(requestOptions?.Data, request.CanCompress);
        request.Uri = BuildUri(host.Url, uri, requestOptions?.PathParameters, requestOptions?.QueryParameters);
        var requestTimeout = TimeSpan.FromTicks((requestOptions?.Timeout ?? GetTimeOut(callType)).Ticks * (host.RetryCount + 1));

        AlgoliaHttpResponse response = await _httpClient
            .SendRequestAsync(request, requestTimeout, ct)
            .ConfigureAwait(false);

        errorMessage = response.Error;

        switch (_retryStrategy.Decide(host, response))
        {
          case RetryOutcomeType.Success:
            return await _serializer.Deserialize<TResult>(response.Body);
          case RetryOutcomeType.Retry:
            continue;
          case RetryOutcomeType.Failure:
            throw new AlgoliaApiException(response.Error, response.HttpStatusCode);
        }
      }

      throw new AlgoliaUnreachableHostException("RetryStrategy failed to connect to Algolia. Reason: " + errorMessage);
    }

    /// <summary>
    /// Generate stream for serializing objects
    /// </summary>
    /// <param name="data">Data to send</param>
    /// <param name="compress">Whether the stream should be compressed or not</param>
    /// <typeparam name="T">Type of the data to send/retrieve</typeparam>
    /// <returns></returns>
    private string CreateRequestContent<T>(T data, bool compress)
    {
      if (data == null)
        return null;

      return _serializer.Serialize(data);
    }

    /// <summary>
    /// Generate common headers from the config
    /// </summary>
    /// <param name="optionalHeaders"></param>
    /// <returns></returns>
    private Dictionary<string, string> GenerateHeaders(Dictionary<string, string> optionalHeaders = null)
    {
      return optionalHeaders != null && optionalHeaders.Any()
          ? optionalHeaders.MergeWith(_algoliaConfig.DefaultHeaders)
          : _algoliaConfig.DefaultHeaders;
    }

    /// <summary>
    /// Build uri depending on the method
    /// </summary>
    /// <param name="url"></param>
    /// <param name="baseUri"></param>
    /// <param name="pathParameters"></param>
    /// <param name="optionalQueryParameters"></param>
    /// <returns></returns>
    private Uri BuildUri(string url, string baseUri, Dictionary<string, string> pathParameters = null, Dictionary<string, string> optionalQueryParameters = null)
    {
      var path = $"{baseUri}";
      if (pathParameters != null)
      {
        foreach (var parameter in pathParameters)
        {
          path = path.Replace("{" + parameter.Key + "}", Uri.EscapeDataString(parameter.Value));
        }
      }

      if (optionalQueryParameters != null)
      {
        var queryParams = optionalQueryParameters.ToQueryString();
        return new UriBuilder { Scheme = "https", Host = url, Path = path, Query = queryParams }.Uri;
      }

      return new UriBuilder { Scheme = "https", Host = url, Path = path }.Uri;
    }

    /// <summary>
    /// Compute the request timeout with the given call type and configuration
    /// </summary>
    /// <param name="callType"></param>
    /// <returns></returns>
    private TimeSpan GetTimeOut(CallType callType)
    {
      switch (callType)
      {
        case CallType.Read:
          return _algoliaConfig.ReadTimeout ?? Defaults.ReadTimeout;

        case CallType.Write:
          return _algoliaConfig.WriteTimeout ?? Defaults.WriteTimeout;

        default:
          return Defaults.WriteTimeout;
      }
    }
  }
}
