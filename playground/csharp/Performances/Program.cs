using System.Diagnostics;
using System.Text.Json;
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;
using Algolia.Search.Transport;
using WireMock.RequestBuilders;
using WireMock.ResponseBuilders;
using WireMock.Server;
using Action = Algolia.Search.Models.Search.Action;

var server = WireMockServer.Start();
var client = new SearchClient(new SearchConfig("FakeAppID", "FakeApiKey")
{
  CustomHosts =
  [
    new()
    {
      Scheme = HttpScheme.Http,
      Port = server.Port,
      Url = "localhost",
      Accept = CallType.Read | CallType.Write,
      Up = true
    }
  ]
});


var searchResults = File.ReadAllText("Data/searchResult.json");

server
  .Given(Request.Create().WithPath("/1/indexes/test-csharp-new-client/query").UsingPost())
  .RespondWith(
    Response.Create()
      .WithStatusCode(200)
      .WithBody(searchResults)
  );

server
  .Given(Request.Create().WithPath("/1/indexes/test-csharp-new-client/batch").UsingPost())
  .RespondWith(
    Response.Create()
      .WithStatusCode(200)
      .WithBody(JsonSerializer.Serialize(new BatchResponse(1, [])))
  );


Console.WriteLine("Starting performance tests...");

Console.WriteLine("----------------");
Console.WriteLine("---- Search ----");
Console.WriteLine("----------------");

const int iterations = 10000;
Stopwatch stopwatch = new();

Console.WriteLine(
  $"Calling SearchAsync {iterations} times, with a response payload of {searchResults.Length / 1024} ko");

stopwatch.Start();
for (var i = 0; i < iterations; i++)
{
  await client
    .SearchSingleIndexAsync<TestObject>("test-csharp-new-client", new SearchParams(new SearchParamsObject()));
}

stopwatch.Stop();
Console.WriteLine(
  $"Elapsed:  {stopwatch.Elapsed.Seconds} s {stopwatch.Elapsed.Milliseconds} ms {stopwatch.Elapsed.Microseconds} μs");

Console.WriteLine();


Console.WriteLine("-----------------------------------");
Console.WriteLine("---- Save records, using Batch ----");
Console.WriteLine("-----------------------------------");

const int iterationsBatch = 100;
const int iterationsRecords = 1000;
Console.WriteLine(
  $"Saving {iterationsBatch * iterationsRecords} records by calling BatchAsync {iterationsBatch} times, with request payload containing {iterationsRecords} record of {JsonSerializer.Serialize(CreateBody(0)).Length / 1024} ko.");

stopwatch.Restart();
for (var i = 0; i < iterationsBatch; i++)
{
  await client
    .BatchAsync("test-csharp-new-client", new BatchWriteParams(CreateRequests())).ConfigureAwait(false);
}

stopwatch.Stop();
Console.WriteLine(
  $"Elapsed:  {stopwatch.Elapsed.Seconds} s {stopwatch.Elapsed.Milliseconds} ms {stopwatch.Elapsed.Microseconds} μs");

List<BatchRequest> CreateRequests()
{
  var requests = new List<BatchRequest>();

  for (var i = 0; i < iterationsRecords; i++)
  {
    var batchRequest = new BatchRequest()
    {
      Action = Action.AddObject,
      Body = CreateBody(i)
    };
    requests.Add(
      batchRequest);
  }

  return requests;
}

object CreateBody(int i1)
{
  return new
  {
    objectID = Guid.NewGuid(),
    name = "Test" + i1,
    age = i1,
    city = "Paris",
    country = "France",
    hobbies = new[] { "sport", "music" },
    friends = new[]
    {
      new { name = "John", age = 42 },
      new { name = "Paul", age = 32 }
    },
    company = new { name = "Algolia", country = "France", city = "Paris" },
    email = "test" + i1 + "@algolia.com",
    objectIDWithNumbers = "42",
    objectIDWithDates = "2020-01-01T00:00:00Z",
    objectIDWithBoolean = "true",
    objectIDWithArray = "[]",
    objectIDWithObject = "{}",
    objectIDWithNull = "null",
    objectIDWithGeoPoint = "48.8584,2.2945",
    objectIDWithGeoJSON = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON1 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON2 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON3 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON4 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON5 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON6 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON7 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON8 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithGeoJSON9 = "{\"type\":\"Point\",\"coordinates\":[2.2945,48.8584]}",
    objectIDWithPolygon1 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon2 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon3 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon4 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon5 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon6 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon7 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon8 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon9 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithPolygon10 = "[[[-74.0059413,40.7127837],[-74.0059413,40.7127837],[-74.0059413,40.7127837]]]",
    objectIDWithNullGeoPoint = "null",
    objectIDWithNullGeoJSON = "null",
    objectIDWithNullPolygon = "null",
    objectIDWithEmptyGeoPoint = "",
    objectIDWithEmptyGeoJSON = "",
    objectIDWithEmptyPolygon = "",
    objectIDWithEmptyArray = "",
    objectIDWithEmptyObject = "",
    objectIDWithEmptyString = "",
    objectIDWithEmptyBoolean = "",
    objectIDWithEmptyNull = "",
    objectIDWithEmptyNumber = "",
    objectIDWithEmptyDate = "",
    objectIDWithEmptyPolygonArray = "",
    objectIDWithEmptyGeoPointArray = "",
    objectIDWithEmptyGeoJSONArray = "",
    objectIDWithEmptyNullArray = "",
    objectIDWithEmptyStringArray = "",
    objectIDWithEmptyBooleanArray = "",
  };
}
