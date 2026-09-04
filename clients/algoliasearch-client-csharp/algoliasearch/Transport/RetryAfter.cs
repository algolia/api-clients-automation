using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Algolia.Search.Transport;

/// <summary>
/// Parses the Retry-After header for same-host 429 waits.
/// </summary>
internal static class RetryAfter
{
  private static readonly TimeSpan DefaultWait = TimeSpan.FromSeconds(1);
  private static readonly Regex WholeSeconds = new("^[0-9]+$", RegexOptions.Compiled);

  /// <summary>
  /// Honors Retry-After only as a positive whole number of seconds.
  /// Missing, empty, 0, HTTP-date, and junk values wait 1 second.
  /// </summary>
  public static TimeSpan Parse(IDictionary<string, string> headers)
  {
    if (headers == null)
    {
      return DefaultWait;
    }

    string raw = null;
    foreach (var header in headers)
    {
      if (header.Key.Equals("Retry-After", StringComparison.OrdinalIgnoreCase))
      {
        raw = header.Value?.Trim();
        break;
      }
    }

    if (string.IsNullOrEmpty(raw) || !WholeSeconds.IsMatch(raw))
    {
      return DefaultWait;
    }

    if (!long.TryParse(raw, out var seconds) || seconds <= 0)
    {
      return DefaultWait;
    }

    try
    {
      return TimeSpan.FromSeconds(seconds);
    }
    catch (OverflowException)
    {
      return TimeSpan.MaxValue;
    }
  }
}
