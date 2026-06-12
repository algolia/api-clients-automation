using System.Text.Json;
using System.Text.Json.Nodes;
using Quibble.Xunit;

namespace Algolia.Search.Tests.Utils;

public static class TestHelpers
{
  /// <summary>
  /// Asserts that the serialized response contains at least the expected JSON structure.
  /// Extra keys in objects and extra elements in arrays (beyond expected indices) are ignored.
  /// Mirrors the union-based e2e assertion used by JS, Python, Ruby, PHP, Go, and Swift clients.
  /// </summary>
  public static void LenientJsonAssert(string expected, string actual)
  {
    var expectedNode = JsonNode.Parse(expected);
    var actualNode = JsonNode.Parse(actual);
    var unionNode = Union(expectedNode, actualNode);
    var unionJson = JsonSerializer.Serialize(unionNode);
    JsonAssert.EqualOverrideDefault(expected, unionJson, new JsonDiffConfig(true));
  }

  /// <summary>
  /// Recursively intersects the structure of <paramref name="expected"/> with the values of
  /// <paramref name="received"/>. Only keys/indices present in expected are kept.
  /// </summary>
  private static JsonNode Union(JsonNode expected, JsonNode received)
  {
    if (expected is JsonObject expectedObj && received is JsonObject receivedObj)
    {
      var result = new JsonObject();
      foreach (var prop in expectedObj)
      {
        if (receivedObj[prop.Key] != null)
        {
          result[prop.Key] = Union(prop.Value, receivedObj[prop.Key]);
        }
      }
      return result;
    }

    if (expected is JsonArray expectedArr && received is JsonArray receivedArr)
    {
      var result = new JsonArray();
      for (int i = 0; i < expectedArr.Count && i < receivedArr.Count; i++)
      {
        result.Add(Union(expectedArr[i], receivedArr[i]));
      }
      return result;
    }

    return received.DeepClone();
  }
}
