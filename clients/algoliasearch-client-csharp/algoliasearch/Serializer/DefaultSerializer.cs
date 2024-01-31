using System;
using System.Diagnostics;
using System.IO;
using System.Text;
using System.Threading.Tasks;
using Algolia.Search.Exceptions;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;

namespace Algolia.Search.Serializer;

internal class DefaultJsonSerializer : ISerializer
{
  private readonly JsonSerializerSettings _serializerSettings;
  private readonly ILogger<DefaultJsonSerializer> _logger;

  public DefaultJsonSerializer(JsonSerializerSettings serializerSettings, ILoggerFactory logger)
  {
    _serializerSettings = serializerSettings;
    _logger = logger.CreateLogger<DefaultJsonSerializer>();
  }

  /// <summary>
  /// Serialize the object into a JSON string.
  /// </summary>
  /// <param name="obj">Object to be serialized.</param>
  /// <returns>A JSON string.</returns>
  public string Serialize(object data)
  {
    if (data is AbstractSchema schema)
    {
      // the object to be serialized is an oneOf/anyOf schema
      var serialize = schema.ToJson();
      return serialize;
    }

    // using (var sw = new StreamWriter(memoryStream))
    // using (var jtw = new JsonTextWriter(sw) { Formatting = Formatting.None })
    // {
    //   Serializer.MaxDepth = 123456789;
    //   Serializer.Serialize(jtw, data);
    //   jtw.Flush();
    // }
    // stop.Stop();
    // Console.WriteLine($"Serialize: {stop.ElapsedTicks}ms");
    //
    //
    // memoryStream.Seek(0, SeekOrigin.Begin);
    // Stopwatch stop2 = new Stopwatch();
    // stop2.Start();
    //
    // stop2.Stop();
    // Console.WriteLine($"Serialize: {stop2.ElapsedMilliseconds}ms");

    return JsonConvert.SerializeObject(data, _serializerSettings);
  }

  public async Task<T> Deserialize<T>(Stream response)
  {
    var result = (T)await Deserialize(response, typeof(T)).ConfigureAwait(false);
    return result;
  }

  /// <summary>
  /// Deserialize the JSON string into a proper object.
  /// </summary>
  /// <param name="response">The HTTP response.</param>
  /// <param name="type">Object type.</param>
  /// <returns>Object representation of the JSON string.</returns>
  private async Task<object> Deserialize(Stream response, Type type)
  {
    if (type == typeof(byte[])) // return a byte array
    {
      using var reader = new StreamReader(response);
      return Encoding.UTF8.GetBytes(await reader.ReadToEndAsync().ConfigureAwait(false));
    }

    if (type == typeof(Stream))
    {
      return response;
    }

    if (type.Name.StartsWith("System.Nullable`1[[System.DateTime")) // return a datetime object
    {
      using var reader = new StreamReader(response);
      var text = await reader.ReadToEndAsync().ConfigureAwait(false);
      return DateTime.Parse(text, null, System.Globalization.DateTimeStyles.RoundtripKind);
    }

    if (type == typeof(string) || type.Name.StartsWith("System.Nullable")) // return primitive type
    {
      using var reader = new StreamReader(response);
      var text = await reader.ReadToEndAsync().ConfigureAwait(false);
      return Convert.ChangeType(text, type);
    }

    // Json Model
    try
    {
      using var reader = new StreamReader(response);
      var text = await reader.ReadToEndAsync().ConfigureAwait(false);
      // Stopwatch sw = new Stopwatch();
      // sw.Start();
      //
      //
      // if (response == null || response.CanRead == false)
      //   return default;
      //
      // using (response)
      // using (var sr = new StreamReader(response))
      // using (var jtr = new JsonTextReader(sr))
      // {
      //   return Serializer.Deserialize(jtr);
      // }



      var deserializeObject = JsonConvert.DeserializeObject(text, type, _serializerSettings);
      // sw.Stop();
      // Console.WriteLine($"DeserializeObject: {sw.ElapsedMilliseconds}ms");
      return deserializeObject;
    }
    catch (Exception ex)
    {
      if (_logger.IsEnabled(LogLevel.Debug))
      {
        _logger.Log(LogLevel.Debug, ex, "Error while deserializing response");
      }

      throw new AlgoliaException(ex.Message);
    }
  }
}
