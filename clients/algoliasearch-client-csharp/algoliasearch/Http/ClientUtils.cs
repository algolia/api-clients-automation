using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Runtime.Serialization;

namespace Algolia.Search.Http
{
  /// <summary>
  /// Utility functions providing some benefit to API client consumers.
  /// </summary>
  public static class ClientUtils
  {
    /// <summary>
    /// If parameter is a list, join the list with ",".
    /// Otherwise just return the string.
    /// </summary>
    /// <param name="obj">The parameter (header, path, query, form).</param>
    /// <returns>Formatted string.</returns>
    public static string ParameterToString(object obj)
    {
      switch (obj)
      {
        case bool boolean:
          return boolean ? "true" : "false";
        case ICollection collection:
        {
          var entries = new List<string>();
          foreach (var entry in collection)
            entries.Add(ParameterToString(entry));
          return string.Join(",", entries);
        }
        case Enum when HasEnumMemberAttrValue(obj):
          return GetEnumMemberAttrValue(obj);
        default:
          return Convert.ToString(obj, CultureInfo.InvariantCulture);
      }
    }

    /// <summary>
    /// Is the Enum decorated with EnumMember Attribute
    /// </summary>
    /// <param name="enumVal"></param>
    /// <returns>true if found</returns>
    private static bool HasEnumMemberAttrValue(object enumVal)
    {
      if (enumVal == null)
        throw new ArgumentNullException(nameof(enumVal));
      var enumType = enumVal.GetType();
      var memInfo = enumType.GetMember(enumVal.ToString() ?? throw new InvalidOperationException());
      var attr = memInfo.FirstOrDefault()?.GetCustomAttributes(false).OfType<EnumMemberAttribute>().FirstOrDefault();
      return attr != null;
    }

    /// <summary>
    /// Get the EnumMember value
    /// </summary>
    /// <param name="enumVal"></param>
    /// <returns>EnumMember value as string otherwise null</returns>
    private static string GetEnumMemberAttrValue(object enumVal)
    {
      if (enumVal == null)
        throw new ArgumentNullException(nameof(enumVal));
      var enumType = enumVal.GetType();
      var memInfo = enumType.GetMember(enumVal.ToString() ?? throw new InvalidOperationException());
      var attr = memInfo.FirstOrDefault()?.GetCustomAttributes(false).OfType<EnumMemberAttribute>().FirstOrDefault();
      return attr?.Value;
    }
  }
}
