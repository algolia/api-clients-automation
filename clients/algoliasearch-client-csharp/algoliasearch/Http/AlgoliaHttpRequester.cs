using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Microsoft.Extensions.Logging.Abstractions;

namespace Algolia.Search.Http;

/// <summary>
/// Algolia's HTTP requester
/// You can inject your own by implementing IHttpRequester
/// </summary>
internal class AlgoliaHttpRequester : IHttpRequester, IDisposable
{
  private const int CopyBufferSize = 81920;

  /// <summary>
  /// https://docs.microsoft.com/en-gb/aspnet/web-api/overview/advanced/calling-a-web-api-from-a-net-client
  /// </summary>
  private readonly HttpClient _httpClient = new(
    new TimeoutHandler
    {
      InnerHandler = new HttpClientHandler { AutomaticDecompression = DecompressionMethods.GZip },
    }
  );

  private readonly ILogger<AlgoliaHttpRequester> _logger;

  public AlgoliaHttpRequester(ILoggerFactory loggerFactory)
  {
    var logger = loggerFactory ?? NullLoggerFactory.Instance;
    _logger = logger.CreateLogger<AlgoliaHttpRequester>();
  }

  /// <summary>
  /// Don't use it directly
  /// Send request to the REST API
  /// </summary>
  /// <param name="request">Request</param>
  /// <param name="requestTimeout">Read/write timeout: budget to receive the response once a connection is possible, applied again to the body read</param>
  /// <param name="connectTimeout">Connect timeout: extra budget granted on top of <paramref name="requestTimeout"/> to establish the connection</param>
  /// <param name="ct">Optional cancellation token</param>
  /// <returns></returns>
  public async Task<AlgoliaHttpResponse> SendRequestAsync(
    Request request,
    TimeSpan requestTimeout,
    TimeSpan connectTimeout,
    CancellationToken ct = default
  )
  {
    if (request.Method == null)
    {
      throw new ArgumentNullException(nameof(request.Method), "No HTTP method found");
    }

    if (request.Uri == null)
    {
      throw new ArgumentNullException(nameof(request), "No URI found");
    }

    var httpRequestMessage = new HttpRequestMessage
    {
      Method = request.Method,
      RequestUri = request.Uri,
      Content = request.Body != null ? new StreamContent(request.Body) : null,
    };

    if (request.Body != null && httpRequestMessage.Content != null)
    {
      httpRequestMessage.Content.Headers.Clear();
      httpRequestMessage.Content.Headers.Fill(request);
    }

    httpRequestMessage.Headers.Fill(request.Headers);

    // HttpClient offers no way to bound the connect phase on its own, so the phase
    // until response headers arrive gets the connect budget plus the read/write budget.
    httpRequestMessage.SetTimeout(connectTimeout + requestTimeout);

    try
    {
      using (httpRequestMessage)
      using (
        var response = await _httpClient
          .SendAsync(httpRequestMessage, HttpCompletionOption.ResponseHeadersRead, ct)
          .ConfigureAwait(false)
      )
      using (var bodyCts = CancellationTokenSource.CreateLinkedTokenSource(ct))
      {
        bodyCts.CancelAfter(requestTimeout);

        // On some platforms the response stream ignores the cancellation token once a
        // read is in flight; disposing the response aborts the connection and unblocks it.
        using (bodyCts.Token.Register(response.Dispose))
        {
          try
          {
            using (var stream = await response.Content.ReadAsStreamAsync().ConfigureAwait(false))
            {
              var responseHeaders = response.Headers.ToDictionary(
                h => h.Key,
                h => string.Join(", ", h.Value)
              );

              if (!response.IsSuccessStatusCode)
              {
                return new AlgoliaHttpResponse
                {
                  Error = await StreamToStringAsync(stream, bodyCts.Token).ConfigureAwait(false),
                  HttpStatusCode = (int)response.StatusCode,
                  ResponseHeaders = responseHeaders,
                };
              }

              var outputStream = new MemoryStream();
              await stream
                .CopyToAsync(outputStream, CopyBufferSize, bodyCts.Token)
                .ConfigureAwait(false);
              outputStream.Seek(0, SeekOrigin.Begin);

              return new AlgoliaHttpResponse
              {
                Body = outputStream,
                HttpStatusCode = (int)response.StatusCode,
                ResponseHeaders = responseHeaders,
              };
            }
          }
          catch (OperationCanceledException) when (ct.IsCancellationRequested)
          {
            throw;
          }
          catch (Exception ex) when (ct.IsCancellationRequested)
          {
            throw new OperationCanceledException("The request was canceled.", ex, ct);
          }
          catch (Exception ex) when (bodyCts.IsCancellationRequested)
          {
            if (_logger.IsEnabled(LogLevel.Warning))
            {
              _logger.LogWarning(ex, "Timeout while reading the response body");
            }

            return new AlgoliaHttpResponse
            {
              IsTimedOut = true,
              Error = "Request timed out while reading the response body.",
            };
          }
        }
      }
    }
    catch (TimeoutException ex)
    {
      if (_logger.IsEnabled(LogLevel.Warning))
      {
        _logger.LogWarning(ex, "Timeout while sending request");
      }

      return new AlgoliaHttpResponse { IsTimedOut = true, Error = ex.Message };
    }
    catch (HttpRequestException ex)
    {
      // HttpRequestException is thrown when an underlying issue happened such as
      // network connectivity, DNS failure, server certificate validation.
      if (_logger.IsEnabled(LogLevel.Error))
      {
        _logger.LogError(ex, "Error while sending request {Request}", request);
      }

      return new AlgoliaHttpResponse { IsNetworkError = true, Error = ex.Message };
    }
    catch (IOException ex)
    {
      // With the response streamed after the headers, a connection dropped mid-body
      // surfaces as an IOException instead of an HttpRequestException.
      if (_logger.IsEnabled(LogLevel.Error))
      {
        _logger.LogError(ex, "Error while reading the response of request {Request}", request);
      }

      return new AlgoliaHttpResponse { IsNetworkError = true, Error = ex.Message };
    }
  }

  private static async Task<string> StreamToStringAsync(Stream stream, CancellationToken ct)
  {
    if (stream == null)
      return null;

    using var ms = new MemoryStream();
    await stream.CopyToAsync(ms, CopyBufferSize, ct).ConfigureAwait(false);
    ms.Seek(0, SeekOrigin.Begin);

    using var sr = new StreamReader(ms);
    return await sr.ReadToEndAsync().ConfigureAwait(false);
  }

  /// <summary>
  /// Disposes the underlying <see cref="HttpClient"/>.
  /// </summary>
  public void Dispose()
  {
    _httpClient?.Dispose();
    GC.SuppressFinalize(this);
  }
}
