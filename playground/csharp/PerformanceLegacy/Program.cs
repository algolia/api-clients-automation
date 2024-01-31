// See https://aka.ms/new-console-template for more information

using System.Diagnostics;
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;

Console.WriteLine("Hello, World!");

// dotnet dev-certs https
// dotnet dev-certs https --trust

// var server = WireMockServer.Start();
//
//
// server
//   .Given(Request.Create().WithPath("/1/indexes/test/query").UsingPost())
//   .RespondWith(
//     Response.Create()
//       .WithStatusCode(200)
//       .WithBody(@"{ ""params"": "" "", ""query"": "" "", ""processingTimeMS"": ""2"", ""hitsPerPage"": ""2"", ""nbHits"": ""10"", ""page"": ""0"", ""nbPages"": ""5"", ""hits"": [ { ""firstname"": ""Jimmie"", ""lastname"": ""Barninger"", ""objectID"": ""433"" }, { ""firstname"": ""Warren"", ""lastname"": ""Speach"", ""objectID"": ""2"" } ] }")
//   );

var client = new SearchClient(new SearchConfig("LEKUUYKIXX", "XXX"));
// {
//   CustomHosts =
//   [
//     new()
//     {
//       Scheme = HttpScheme.Http,
//       Port = server.Port,
//       Url = "localhost",
//       Accept = CallType.Read | CallType.Write,
//       Up = true
//     }
//   ]
// });

for (int i = 0; i < 5; i++)
{
  Stopwatch stopwatch = new();
  stopwatch.Start();

  var searchIndex = client.InitIndex("test-csharp-new-client");
  var searchResponse = await searchIndex.SearchAsync<object>(new Query() { }).ConfigureAwait(false);

  stopwatch.Stop();
  Console.WriteLine($"Elapsed: {stopwatch.ElapsedMilliseconds}ms " + searchResponse.Hits.Count);
}
