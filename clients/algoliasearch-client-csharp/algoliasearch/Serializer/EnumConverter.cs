using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace Algolia.Search.Serializer;

public class JsonStringEnumConverterFactory : JsonConverterFactory
{
  public override bool CanConvert(Type typeToConvert)
  {
    return typeToConvert.IsEnum;
  }

  public override JsonConverter? CreateConverter(Type typeToConvert, JsonSerializerOptions options)
  {
    var type = typeof(JsonStringEnumConverter2<>).MakeGenericType(typeToConvert);
    return (JsonConverter)Activator.CreateInstance(type)!;
  }
}

public class JsonStringEnumConverter2<TEnum> : JsonConverter<TEnum> where TEnum : struct, Enum
{
  private readonly Dictionary<TEnum, string> _enumToString = new();
  private readonly Dictionary<string, TEnum> _stringToEnum = new();
  private readonly Dictionary<int, TEnum> _numberToEnum = new();

  public JsonStringEnumConverter2()
  {
    var type = typeof(TEnum);
    foreach (var value in Enum.GetValues(type))
    {
      var enumMember = type.GetMember(value.ToString())[0];
      var attr = enumMember.GetCustomAttributes(typeof(JsonPropertyNameAttribute), false)
        .Cast<JsonPropertyNameAttribute>()
        .FirstOrDefault();

      var num = Convert.ToInt32(type.GetField("value__")?.GetValue(value));
      if (attr?.Name != null)
      {
        _enumToString.Add((TEnum)value, attr.Name);
        _stringToEnum.Add(attr.Name, (TEnum)value);
        _numberToEnum.Add(num, (TEnum)value);
      }
      else
      {
        _enumToString.Add((TEnum)value, value.ToString());
        _stringToEnum.Add(value.ToString(), (TEnum)value);
        _numberToEnum.Add(num, (TEnum)value);
      }
    }
  }


  public override TEnum Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
  {
    var type = reader.TokenType;
    if (type == JsonTokenType.String)
    {
      var stringValue = reader.GetString();

      if (stringValue != null && _stringToEnum.TryGetValue(stringValue, out var enumValue))
      {
        return enumValue;
      }
    }
    else if (type == JsonTokenType.Number)
    {
      var numValue = reader.GetInt32();
      _numberToEnum.TryGetValue(numValue, out var enumValue);
      return enumValue;
    }

    return default;
  }

  public override void Write(Utf8JsonWriter writer, TEnum value, JsonSerializerOptions options)
  {
    var success = _enumToString.TryGetValue(value, out var stringValue);
    if (success)
    {
      writer.WriteStringValue(stringValue);
    }
    else
    {
      writer.WriteNullValue();
    }
  }
}
