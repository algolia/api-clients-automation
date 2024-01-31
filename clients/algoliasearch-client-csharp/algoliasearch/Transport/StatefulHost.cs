using System;

namespace Algolia.Search.Transport;

/// <summary>
/// Algolia's stateful host
/// </summary>
public class StatefulHost
{
  /// <summary>
  /// Url endpoint without the scheme, without the port
  /// </summary>
  public string Url { get; set; }

  /// <summary>
  /// Scheme of the URL
  /// </summary>
  public HttpScheme Scheme { get; set; } = HttpScheme.Https;

  /// <summary>
  /// Port of the URL (Optional)
  /// </summary>
  public int Port { get; set; } = -1;

  /// <summary>
  /// Is the host up or not
  /// </summary>
  public bool Up { get; set; } = true;

  /// <summary>
  /// Retry count
  /// </summary>
  public int RetryCount { get; set; }

  /// <summary>
  /// Last time the host has been used
  /// </summary>
  public DateTime LastUse { get; set; } = DateTime.UtcNow;

  /// <summary>
  /// Calltype accepted by the host
  /// </summary>
  public CallType Accept { get; set; }
}

public enum HttpScheme
{
  /// <summary>
  /// Http
  /// </summary>
  Http,
  /// <summary>
  /// Https
  /// </summary>
  Https
}

/// <summary>
/// https://docs.microsoft.com/en-us/dotnet/csharp/programming-guide/enumeration-types
/// Binary enums beware when adding new values
/// </summary>
[Flags]
public enum CallType
{
  /// <summary>
  /// Read Call
  /// </summary>
  Read = 1,

  /// <summary>
  /// Write Call
  /// </summary>
  Write = 2
}
