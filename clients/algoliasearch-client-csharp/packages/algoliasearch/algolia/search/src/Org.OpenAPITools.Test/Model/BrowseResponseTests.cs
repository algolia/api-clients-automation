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
    ///  Class for testing BrowseResponse
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class BrowseResponseTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for BrowseResponse
        //private BrowseResponse instance;

        public BrowseResponseTests()
        {
            // TODO uncomment below to create an instance of BrowseResponse
            //instance = new BrowseResponse();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of BrowseResponse
        /// </summary>
        [Fact]
        public void BrowseResponseInstanceTest()
        {
            // TODO uncomment below to test "IsType" BrowseResponse
            //Assert.IsType<BrowseResponse>(instance);
        }

        /// <summary>
        /// Test the property 'AbTestID'
        /// </summary>
        [Fact]
        public void AbTestIDTest()
        {
            // TODO unit test for the property 'AbTestID'
        }

        /// <summary>
        /// Test the property 'AbTestVariantID'
        /// </summary>
        [Fact]
        public void AbTestVariantIDTest()
        {
            // TODO unit test for the property 'AbTestVariantID'
        }

        /// <summary>
        /// Test the property 'AroundLatLng'
        /// </summary>
        [Fact]
        public void AroundLatLngTest()
        {
            // TODO unit test for the property 'AroundLatLng'
        }

        /// <summary>
        /// Test the property 'AutomaticRadius'
        /// </summary>
        [Fact]
        public void AutomaticRadiusTest()
        {
            // TODO unit test for the property 'AutomaticRadius'
        }

        /// <summary>
        /// Test the property 'Exhaustive'
        /// </summary>
        [Fact]
        public void ExhaustiveTest()
        {
            // TODO unit test for the property 'Exhaustive'
        }

        /// <summary>
        /// Test the property 'ExhaustiveFacetsCount'
        /// </summary>
        [Fact]
        public void ExhaustiveFacetsCountTest()
        {
            // TODO unit test for the property 'ExhaustiveFacetsCount'
        }

        /// <summary>
        /// Test the property 'ExhaustiveNbHits'
        /// </summary>
        [Fact]
        public void ExhaustiveNbHitsTest()
        {
            // TODO unit test for the property 'ExhaustiveNbHits'
        }

        /// <summary>
        /// Test the property 'ExhaustiveTypo'
        /// </summary>
        [Fact]
        public void ExhaustiveTypoTest()
        {
            // TODO unit test for the property 'ExhaustiveTypo'
        }

        /// <summary>
        /// Test the property 'Facets'
        /// </summary>
        [Fact]
        public void FacetsTest()
        {
            // TODO unit test for the property 'Facets'
        }

        /// <summary>
        /// Test the property 'FacetsStats'
        /// </summary>
        [Fact]
        public void FacetsStatsTest()
        {
            // TODO unit test for the property 'FacetsStats'
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
        /// Test the property 'Index'
        /// </summary>
        [Fact]
        public void IndexTest()
        {
            // TODO unit test for the property 'Index'
        }

        /// <summary>
        /// Test the property 'IndexUsed'
        /// </summary>
        [Fact]
        public void IndexUsedTest()
        {
            // TODO unit test for the property 'IndexUsed'
        }

        /// <summary>
        /// Test the property 'Message'
        /// </summary>
        [Fact]
        public void MessageTest()
        {
            // TODO unit test for the property 'Message'
        }

        /// <summary>
        /// Test the property 'NbHits'
        /// </summary>
        [Fact]
        public void NbHitsTest()
        {
            // TODO unit test for the property 'NbHits'
        }

        /// <summary>
        /// Test the property 'NbPages'
        /// </summary>
        [Fact]
        public void NbPagesTest()
        {
            // TODO unit test for the property 'NbPages'
        }

        /// <summary>
        /// Test the property 'NbSortedHits'
        /// </summary>
        [Fact]
        public void NbSortedHitsTest()
        {
            // TODO unit test for the property 'NbSortedHits'
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
        /// Test the property 'ParsedQuery'
        /// </summary>
        [Fact]
        public void ParsedQueryTest()
        {
            // TODO unit test for the property 'ParsedQuery'
        }

        /// <summary>
        /// Test the property 'ProcessingTimeMS'
        /// </summary>
        [Fact]
        public void ProcessingTimeMSTest()
        {
            // TODO unit test for the property 'ProcessingTimeMS'
        }

        /// <summary>
        /// Test the property 'ProcessingTimingsMS'
        /// </summary>
        [Fact]
        public void ProcessingTimingsMSTest()
        {
            // TODO unit test for the property 'ProcessingTimingsMS'
        }

        /// <summary>
        /// Test the property 'QueryAfterRemoval'
        /// </summary>
        [Fact]
        public void QueryAfterRemovalTest()
        {
            // TODO unit test for the property 'QueryAfterRemoval'
        }

        /// <summary>
        /// Test the property 'Redirect'
        /// </summary>
        [Fact]
        public void RedirectTest()
        {
            // TODO unit test for the property 'Redirect'
        }

        /// <summary>
        /// Test the property 'RenderingContent'
        /// </summary>
        [Fact]
        public void RenderingContentTest()
        {
            // TODO unit test for the property 'RenderingContent'
        }

        /// <summary>
        /// Test the property 'ServerTimeMS'
        /// </summary>
        [Fact]
        public void ServerTimeMSTest()
        {
            // TODO unit test for the property 'ServerTimeMS'
        }

        /// <summary>
        /// Test the property 'ServerUsed'
        /// </summary>
        [Fact]
        public void ServerUsedTest()
        {
            // TODO unit test for the property 'ServerUsed'
        }

        /// <summary>
        /// Test the property 'UserData'
        /// </summary>
        [Fact]
        public void UserDataTest()
        {
            // TODO unit test for the property 'UserData'
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
        /// Test the property 'Query'
        /// </summary>
        [Fact]
        public void QueryTest()
        {
            // TODO unit test for the property 'Query'
        }

        /// <summary>
        /// Test the property 'VarParams'
        /// </summary>
        [Fact]
        public void VarParamsTest()
        {
            // TODO unit test for the property 'VarParams'
        }

        /// <summary>
        /// Test the property 'Cursor'
        /// </summary>
        [Fact]
        public void CursorTest()
        {
            // TODO unit test for the property 'Cursor'
        }
    }
}
