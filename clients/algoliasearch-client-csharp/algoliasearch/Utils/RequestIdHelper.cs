using System;
using System.Collections.Generic;
using System.Security.Cryptography;

namespace Algolia.Search.Utils;

/// <summary>
/// Mints the Request-ID tracing header sent by the clients that support it.
/// </summary>
internal static class RequestIdHelper
{
  private const string Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  private const int Length = 11;

  /// <summary>
  /// Returns a fresh 11-character base62 identifier suitable for the
  /// Request-ID header. The modulo bias of the byte mapping is acceptable:
  /// the ID is a tracing breadcrumb, not a secret.
  /// </summary>
  internal static string Generate()
  {
    var bytes = new byte[Length];
    using (var rng = RandomNumberGenerator.Create())
    {
      rng.GetBytes(bytes);
    }

    var id = new char[Length];
    for (var i = 0; i < Length; i++)
    {
      id[i] = Alphabet[bytes[i] % Alphabet.Length];
    }

    return new string(id);
  }

  /// <summary>
  /// Whether the given header dictionary already carries a Request-ID entry,
  /// whatever its casing. Plain header dictionaries keep the caller's literal
  /// casing, so the lookup must not assume a canonical form.
  /// </summary>
  internal static bool HasRequestId(IDictionary<string, string> headers)
  {
    if (headers == null)
    {
      return false;
    }

    foreach (var header in headers)
    {
      if (header.Key.Equals(Defaults.RequestIdHeader, StringComparison.OrdinalIgnoreCase))
      {
        return true;
      }
    }

    return false;
  }
}
