using System;

namespace Algolia.Search.Client
{
  /// <summary>
  /// Holding all default values of the library
  /// </summary>
  internal class Defaults
  {
    /// <summary>
    /// Read timeout
    /// </summary>
    public static TimeSpan ReadTimeout = TimeSpan.FromSeconds(5);

    /// <summary>
    /// Write timeout
    /// </summary>
    public static TimeSpan WriteTimeout = TimeSpan.FromSeconds(30);

    public const string AcceptHeader = "accept";
    public const string AlgoliaApplicationHeader = "x-algolia-application-id";
    public const string AlgoliaApiKeyHeader = "x-algolia-api-key";
    public const string AlgoliaUserIdHeader = "x-algolia-user-id";
    public const string UserAgentHeader = "user-agent";
    public const string Connection = "connection";
    public const string KeepAlive = "keep-alive";
    public const string ContentType = "content-Type";
    public const string ApplicationJson = "application/json; charset=utf-8";
    public const string GzipEncoding = "gzip";
  }
}
