using Algolia.Search.Http;

namespace Algolia.Search.Tests.Utils;

/// <summary>
/// Http Custom requester, used for testing
/// </summary>
public class EchoHttpRequester : IHttpRequester
{
  private readonly bool _bodyAsStream;

  /// <summary>
  /// Instantiate the EchoHttpRequester
  /// </summary>
  /// <param name="bodyAsStream"></param>
  public EchoHttpRequester(bool bodyAsStream = false)
  {
    _bodyAsStream = bodyAsStream;
  }

  /// <summary>
  /// Last response returned by the echo API
  /// </summary>
  public EchoResponse LastResponse;

  private static Dictionary<string, string> SplitQuery(string query)
  {
    if (string.IsNullOrEmpty(query))
      return new Dictionary<string, string>();

    if (query[0] == '?')
      query = query.Substring(1);

    return query
      .Split('&')
      .Select(part => part.Split('='))
      .ToDictionary(split => split[0], split => split[1]);
  }

  /// <summary>
  /// Send a fake request
  /// </summary>
  /// <param name="request"></param>
  /// <param name="requestTimeout"></param>
  /// <param name="connectTimeout"></param>
  /// <param name="ct"></param>
  /// <returns></returns>
  public Task<AlgoliaHttpResponse> SendRequestAsync(
    Request request,
    TimeSpan requestTimeout,
    TimeSpan connectTimeout,
    CancellationToken ct = default
  )
  {
    string body = null;
    if (!_bodyAsStream && request.Body != null)
    {
      var reader = new StreamReader(request.Body);
      body = reader.ReadToEnd();
    }

    var echo = new EchoResponse
    {
      Path = request.Uri.AbsolutePath,
      Host = request.Uri.Host,
      Method = request.Method,
      BodyStream = request.Body,
      Body = body,
      QueryParameters = SplitQuery(request.Uri.Query),
      Headers = new Dictionary<string, string>(request.Headers),
      ConnectTimeout = connectTimeout,
      ResponseTimeout = requestTimeout,
    };

    LastResponse = echo;

    return Task.FromResult(
      new AlgoliaHttpResponse { Body = new MemoryStream(), HttpStatusCode = 200 }
    );
  }
}
