namespace Algolia.Search.Client
{
  /// <summary>
  /// Holding all default values of the library
  /// </summary>
  internal class Defaults
  {
    /// <summary>
    /// Maximum time to wait for wait task in milliseconds
    /// </summary>
    public const int MaxTimeToWait = 10000;

    /// <summary>
    /// Read timeout in seconds
    /// </summary>
    public const int ReadTimeout = 5;

    /// <summary>
    /// Write timeout in seconds
    /// </summary>
    public const int WriteTimeout = 30;

    public const string AcceptHeader = "Accept";
    public const string AlgoliaApplicationHeader = "X-Algolia-Application-Id";
    public const string AlgoliaApiKeyHeader = "X-Algolia-API-Key";
    public const string AlgoliaUserIdHeader = "X-Algolia-USER-ID";
    public const string UserAgentHeader = "User-Agent";
    public const string Connection = "Connection";
    public const string KeepAlive = "keep-alive";
    public const string ContentType = "Content-Type";
    public const string ApplicationJson = "application/json; charset=utf-8";
    public const string GzipEncoding = "gzip";
  }
}
