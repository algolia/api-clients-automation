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
    ///  Class for testing FacetHits
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class FacetHitsTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for FacetHits
        //private FacetHits instance;

        public FacetHitsTests()
        {
            // TODO uncomment below to create an instance of FacetHits
            //instance = new FacetHits();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of FacetHits
        /// </summary>
        [Fact]
        public void FacetHitsInstanceTest()
        {
            // TODO uncomment below to test "IsType" FacetHits
            //Assert.IsType<FacetHits>(instance);
        }

        /// <summary>
        /// Test the property 'Value'
        /// </summary>
        [Fact]
        public void ValueTest()
        {
            // TODO unit test for the property 'Value'
        }

        /// <summary>
        /// Test the property 'Highlighted'
        /// </summary>
        [Fact]
        public void HighlightedTest()
        {
            // TODO unit test for the property 'Highlighted'
        }

        /// <summary>
        /// Test the property 'Count'
        /// </summary>
        [Fact]
        public void CountTest()
        {
            // TODO unit test for the property 'Count'
        }
    }
}
