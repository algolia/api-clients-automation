/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using Xunit;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using Org.OpenAPITools.Model;
using Org.OpenAPITools.Client;
using System.Reflection;
using Newtonsoft.Json;

namespace Org.OpenAPITools.Test.Model
{
  /// <summary>
  ///  Class for testing SearchSynonymsResponse
  /// </summary>
  /// <remarks>
  /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
  /// Please update the test case below to test the model.
  /// </remarks>
  public class SearchSynonymsResponseTests : IDisposable
  {
    // TODO uncomment below to declare an instance variable for SearchSynonymsResponse
    //private SearchSynonymsResponse instance;

    public SearchSynonymsResponseTests()
    {
      // TODO uncomment below to create an instance of SearchSynonymsResponse
      //instance = new SearchSynonymsResponse();
    }

    public void Dispose()
    {
      // Cleanup when everything is done.
    }

    /// <summary>
    /// Test an instance of SearchSynonymsResponse
    /// </summary>
    [Fact]
    public void SearchSynonymsResponseInstanceTest()
    {
      // TODO uncomment below to test "IsType" SearchSynonymsResponse
      //Assert.IsType<SearchSynonymsResponse>(instance);
    }

    /// <summary>
    /// Test the property 'Hits'
    /// </summary>
    [Fact]
    public void HitsTest()
    {
      // TODO unit test for the property 'Hits'
    }

    /// <summary>
    /// Test the property 'NbHits'
    /// </summary>
    [Fact]
    public void NbHitsTest()
    {
      // TODO unit test for the property 'NbHits'
    }
  }
}
