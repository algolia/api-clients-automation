using System;
using System.Collections.Generic;
using System.Linq;
using Algolia.Search.Models.Common;

namespace Algolia.Search.Utils;

internal static class QueryStringHelper
{
  public static string ToQueryString(this IDictionary<string, string> dic)
  {
    if (dic == null)
    {
      throw new ArgumentNullException(nameof(dic));
    }

    return string.Join("&",
      dic.Select(kvp =>
        string.Format($"{kvp.Key}={Uri.EscapeDataString(kvp.Value)}")));
  }
  
  public static string BuildRestrictionQueryString(SecuredApiKeyRestriction restriction)
  {
    string restrictionQuery = null;
    if (restriction.Query != null)
    {
      restrictionQuery = ToQueryString(restriction.Query);
    }

    string restrictIndices = null;
    if (restriction.RestrictIndices != null)
    {
      restrictIndices = $"restrictIndices={string.Join(",", restriction.RestrictIndices)}";
    }

    string restrictSources = null;
    if (restriction.RestrictSources != null)
    {
      restrictSources = $"restrictSources={string.Join(",", restriction.RestrictSources)}";
    }

    string restrictionQueryParams = ToQueryString(restriction, nameof(restriction.Query),
      nameof(restriction.RestrictIndices), nameof(restriction.RestrictSources));
    var array = new[] { restrictionQuery, restrictIndices, restrictSources, restrictionQueryParams };

    return string.Join("&", array.Where(s => !string.IsNullOrEmpty(s)));
  }

}
