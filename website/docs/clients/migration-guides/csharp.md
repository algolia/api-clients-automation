---
title: C#
---

### Usage

To get started, first install the `Algolia.Search` client.

You can get the last version of the client from [NuGet](https://www.nuget.org/packages/Algolia.Search/).

If you are using the .NET CLI, you can install the package using the following command:

```bash
dotnet add package Algolia.Search --version [The version you want to install]
```

You can continue this guide on [our installation page](/docs/clients/installation).

### Instantiating the client

```csharp
// Without custom configuration
new SearchClient("<YOUR_APP_ID>", "<YOUR_API_KEY>");

// With custom configuration
new SearchClient(new SearchConfig("<YOUR_APP_ID>", "<YOUR_API_KEY>")
{
  ReadTimeout = TimeSpan.FromMinutes(1)
});
```

### Methods targeting an `indexName`

Prior to the `initIndex` removal stated in the [common breaking changes](/docs/clients/migration-guides/#common-breaking-changes), all methods previously available at the `initIndex` level requires the `indexName` to be sent with the query.

That also mean you need to explicit the type you want to be returned from your queries, when it applies.

```csharp
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;

var client = new SearchClient("<YOUR_APP_ID>", "<YOUR_API_KEY>");

client.Search<YOUR_RECORD_TYPE_CLASS>(new SearchMethodParams(new List<SearchQuery>
{
  new(new SearchForHits("<YOUR_INDEX>") { Query = "<YOUR_QUERY>" })
}));
```




