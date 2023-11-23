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
    ///  Class for testing SearchDictionaryEntriesParams
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class SearchDictionaryEntriesParamsTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for SearchDictionaryEntriesParams
        //private SearchDictionaryEntriesParams instance;

        public SearchDictionaryEntriesParamsTests()
        {
            // TODO uncomment below to create an instance of SearchDictionaryEntriesParams
            //instance = new SearchDictionaryEntriesParams();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of SearchDictionaryEntriesParams
        /// </summary>
        [Fact]
        public void SearchDictionaryEntriesParamsInstanceTest()
        {
            // TODO uncomment below to test "IsType" SearchDictionaryEntriesParams
            //Assert.IsType<SearchDictionaryEntriesParams>(instance);
        }

        /// <summary>
        /// Test the property 'Query'
        /// </summary>
        [Fact]
        public void QueryTest()
        {
            // TODO unit test for the property 'Query'
        }

        /// <summary>
        /// Test the property 'Page'
        /// </summary>
        [Fact]
        public void PageTest()
        {
            // TODO unit test for the property 'Page'
        }

        /// <summary>
        /// Test the property 'HitsPerPage'
        /// </summary>
        [Fact]
        public void HitsPerPageTest()
        {
            // TODO unit test for the property 'HitsPerPage'
        }

        /// <summary>
        /// Test the property 'Language'
        /// </summary>
        [Fact]
        public void LanguageTest()
        {
            // TODO unit test for the property 'Language'
        }
    }
}
