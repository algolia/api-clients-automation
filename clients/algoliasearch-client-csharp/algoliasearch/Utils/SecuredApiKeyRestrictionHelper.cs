using System;
using System.Collections;
using System.Linq;
using System.Net;
using System.Reflection;
using System.Text.Json.Serialization;
using Algolia.Search.Models.Common;

namespace Algolia.Search.Utils;

internal static class SecuredApiKeyRestrictionHelper
{
  public static string ToQueryString(this SecuredApiKeyRestriction restriction)
  {
    string restrictionQuery = null;
    if (restriction.Query != null)
    {
      restrictionQuery = ToQueryString(restriction.Query);
    }

    var restrictions = ToQueryString(restriction, nameof(restriction.Query));
    var array = new[] { restrictionQuery, restrictions };

    return string.Join("&", array.Where(s => !string.IsNullOrEmpty(s)));
  }

  /// <summary>
  /// Transform a poco (only class of primitive objects) to a query string
  /// </summary>
  /// <param name="value"></param>
  /// <param name="ignoreList"></param>
  /// <typeparam name="T"></typeparam>
  /// <returns></returns>
  private static string ToQueryString<T>(T value, params string[] ignoreList)
  {
    // Flat properties
    var properties = typeof(T).GetTypeInfo()
      .DeclaredProperties.Where(p =>
        !(p.PropertyType.GetTypeInfo().IsGenericType && typeof(IEnumerable).GetTypeInfo()
          .IsAssignableFrom(p.PropertyType.GetTypeInfo())) &&
        p.GetValue(value, null) != null && !ignoreList.Contains(p.Name) &&
        p.GetCustomAttribute<JsonPropertyNameAttribute>() != null)
      .Select(p =>
      {
        var underlyingType = Nullable.GetUnderlyingType(p.PropertyType);
        if (underlyingType is { IsEnum: true })
        {
          var attr = GetEnumValue(value, p, underlyingType);
            return p.GetCustomAttribute<JsonPropertyNameAttribute>().Name + "=" + (attr?.Name != null ? attr.Name : value.ToString());
        }

        var encodedValue = underlyingType == typeof(bool)
          ? Uri.EscapeDataString(p.GetValue(value, null).ToString().ToLower())
          : Uri.EscapeDataString(p.GetValue(value, null).ToString());
        return p.Name.ToCamelCase() + "=" + encodedValue;
      });

    // List<T> properties
    var listProperties = typeof(T).GetTypeInfo()
      .DeclaredProperties.Where(p =>
        p.PropertyType.GetTypeInfo().IsGenericType &&
        typeof(IEnumerable).GetTypeInfo().IsAssignableFrom(p.PropertyType.GetTypeInfo()) &&
        p.GetValue(value, null) != null && !ignoreList.Contains(p.Name) &&
        p.GetCustomAttribute<JsonPropertyNameAttribute>() != null)
      .Select(p =>
      {
        var innerType = p.PropertyType.GetGenericArguments()[0];
        var parameterList = ((IEnumerable)p.GetValue(value, null)).Cast<object>();
        
        if (innerType is { IsEnum: true })
        {
          parameterList = parameterList.Select(x =>
          {
            var enumMember = innerType.GetMember(x.ToString())[0];
            var attr = enumMember.GetCustomAttributes(typeof(JsonPropertyNameAttribute), false)
              .Cast<JsonPropertyNameAttribute>()
              .FirstOrDefault();
            return attr?.Name != null ? attr.Name : x.ToString();
          });
        }

        var values = string.Join(",", parameterList);
        return p.GetCustomAttribute<JsonPropertyNameAttribute>().Name + "=" + WebUtility.UrlEncode(values);
      });

    return string.Join("&", listProperties.Concat(properties).ToArray());
  }

  private static JsonPropertyNameAttribute GetEnumValue<T>(T value, PropertyInfo p, Type underlyingType)
  {
    var val = p.GetValue(value, null);
    var enumMember = underlyingType.GetMember(val.ToString())[0];
    var attr = enumMember.GetCustomAttributes(typeof(JsonPropertyNameAttribute), false)
      .Cast<JsonPropertyNameAttribute>()
      .FirstOrDefault();
    return attr;
  }

  private static string ToCamelCase(this string stringToCamelCase)
  {
    return char.ToLowerInvariant(stringToCamelCase[0]) + stringToCamelCase.Substring(1);
  }
}
