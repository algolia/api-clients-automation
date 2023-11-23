/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */

using System;
using System.IO;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Reflection;
using RestSharp;
using Xunit;

using Org.OpenAPITools.Client;
using Org.OpenAPITools.Api;
// uncomment below to import models
//using Org.OpenAPITools.Model;

namespace Org.OpenAPITools.Test.Api
{
    /// <summary>
    ///  Class for testing SearchApi
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the API endpoint.
    /// </remarks>
    public class SearchApiTests : IDisposable
    {
        private SearchApi instance;

        public SearchApiTests()
        {
            instance = new SearchApi();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of SearchApi
        /// </summary>
        [Fact]
        public void InstanceTest()
        {
            // TODO uncomment below to test 'IsType' SearchApi
            //Assert.IsType<SearchApi>(instance);
        }

        /// <summary>
        /// Test AddApiKey
        /// </summary>
        [Fact]
        public void AddApiKeyTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //ApiKey apiKey = null;
            //var response = instance.AddApiKey(apiKey);
            //Assert.IsType<AddApiKeyResponse>(response);
        }

        /// <summary>
        /// Test AddOrUpdateObject
        /// </summary>
        [Fact]
        public void AddOrUpdateObjectTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //Object body = null;
            //var response = instance.AddOrUpdateObject(indexName, objectID, body);
            //Assert.IsType<UpdatedAtWithObjectIdResponse>(response);
        }

        /// <summary>
        /// Test AppendSource
        /// </summary>
        [Fact]
        public void AppendSourceTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //Source source = null;
            //var response = instance.AppendSource(source);
            //Assert.IsType<CreatedAtResponse>(response);
        }

        /// <summary>
        /// Test AssignUserId
        /// </summary>
        [Fact]
        public void AssignUserIdTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string xAlgoliaUserID = null;
            //AssignUserIdParams assignUserIdParams = null;
            //var response = instance.AssignUserId(xAlgoliaUserID, assignUserIdParams);
            //Assert.IsType<CreatedAtResponse>(response);
        }

        /// <summary>
        /// Test Batch
        /// </summary>
        [Fact]
        public void BatchTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //BatchWriteParams batchWriteParams = null;
            //var response = instance.Batch(indexName, batchWriteParams);
            //Assert.IsType<BatchResponse>(response);
        }

        /// <summary>
        /// Test BatchAssignUserIds
        /// </summary>
        [Fact]
        public void BatchAssignUserIdsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string xAlgoliaUserID = null;
            //BatchAssignUserIdsParams batchAssignUserIdsParams = null;
            //var response = instance.BatchAssignUserIds(xAlgoliaUserID, batchAssignUserIdsParams);
            //Assert.IsType<CreatedAtResponse>(response);
        }

        /// <summary>
        /// Test BatchDictionaryEntries
        /// </summary>
        [Fact]
        public void BatchDictionaryEntriesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //DictionaryType dictionaryName = null;
            //BatchDictionaryEntriesParams batchDictionaryEntriesParams = null;
            //var response = instance.BatchDictionaryEntries(dictionaryName, batchDictionaryEntriesParams);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test Browse
        /// </summary>
        [Fact]
        public void BrowseTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //BrowseParams browseParams = null;
            //var response = instance.Browse(indexName, browseParams);
            //Assert.IsType<BrowseResponse>(response);
        }

        /// <summary>
        /// Test ClearAllSynonyms
        /// </summary>
        [Fact]
        public void ClearAllSynonymsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //bool? forwardToReplicas = null;
            //var response = instance.ClearAllSynonyms(indexName, forwardToReplicas);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test ClearObjects
        /// </summary>
        [Fact]
        public void ClearObjectsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //var response = instance.ClearObjects(indexName);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test ClearRules
        /// </summary>
        [Fact]
        public void ClearRulesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //bool? forwardToReplicas = null;
            //var response = instance.ClearRules(indexName, forwardToReplicas);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test Del
        /// </summary>
        [Fact]
        public void DelTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string path = null;
            //Dictionary<string, Object> parameters = null;
            //var response = instance.Del(path, parameters);
            //Assert.IsType<Object>(response);
        }

        /// <summary>
        /// Test DeleteApiKey
        /// </summary>
        [Fact]
        public void DeleteApiKeyTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string key = null;
            //var response = instance.DeleteApiKey(key);
            //Assert.IsType<DeleteApiKeyResponse>(response);
        }

        /// <summary>
        /// Test DeleteBy
        /// </summary>
        [Fact]
        public void DeleteByTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //DeleteByParams deleteByParams = null;
            //var response = instance.DeleteBy(indexName, deleteByParams);
            //Assert.IsType<DeletedAtResponse>(response);
        }

        /// <summary>
        /// Test DeleteIndex
        /// </summary>
        [Fact]
        public void DeleteIndexTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //var response = instance.DeleteIndex(indexName);
            //Assert.IsType<DeletedAtResponse>(response);
        }

        /// <summary>
        /// Test DeleteObject
        /// </summary>
        [Fact]
        public void DeleteObjectTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //var response = instance.DeleteObject(indexName, objectID);
            //Assert.IsType<DeletedAtResponse>(response);
        }

        /// <summary>
        /// Test DeleteRule
        /// </summary>
        [Fact]
        public void DeleteRuleTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //bool? forwardToReplicas = null;
            //var response = instance.DeleteRule(indexName, objectID, forwardToReplicas);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test DeleteSource
        /// </summary>
        [Fact]
        public void DeleteSourceTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string source = null;
            //var response = instance.DeleteSource(source);
            //Assert.IsType<DeleteSourceResponse>(response);
        }

        /// <summary>
        /// Test DeleteSynonym
        /// </summary>
        [Fact]
        public void DeleteSynonymTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //bool? forwardToReplicas = null;
            //var response = instance.DeleteSynonym(indexName, objectID, forwardToReplicas);
            //Assert.IsType<DeletedAtResponse>(response);
        }

        /// <summary>
        /// Test Get
        /// </summary>
        [Fact]
        public void GetTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string path = null;
            //Dictionary<string, Object> parameters = null;
            //var response = instance.Get(path, parameters);
            //Assert.IsType<Object>(response);
        }

        /// <summary>
        /// Test GetApiKey
        /// </summary>
        [Fact]
        public void GetApiKeyTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string key = null;
            //var response = instance.GetApiKey(key);
            //Assert.IsType<GetApiKeyResponse>(response);
        }

        /// <summary>
        /// Test GetDictionaryLanguages
        /// </summary>
        [Fact]
        public void GetDictionaryLanguagesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.GetDictionaryLanguages();
            //Assert.IsType<Dictionary<string, Languages>>(response);
        }

        /// <summary>
        /// Test GetDictionarySettings
        /// </summary>
        [Fact]
        public void GetDictionarySettingsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.GetDictionarySettings();
            //Assert.IsType<GetDictionarySettingsResponse>(response);
        }

        /// <summary>
        /// Test GetLogs
        /// </summary>
        [Fact]
        public void GetLogsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //int? offset = null;
            //int? length = null;
            //string indexName = null;
            //LogType type = null;
            //var response = instance.GetLogs(offset, length, indexName, type);
            //Assert.IsType<GetLogsResponse>(response);
        }

        /// <summary>
        /// Test GetObject
        /// </summary>
        [Fact]
        public void GetObjectTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //List<string> attributesToRetrieve = null;
            //var response = instance.GetObject(indexName, objectID, attributesToRetrieve);
            //Assert.IsType<Dictionary<string, string>>(response);
        }

        /// <summary>
        /// Test GetObjects
        /// </summary>
        [Fact]
        public void GetObjectsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //GetObjectsParams getObjectsParams = null;
            //var response = instance.GetObjects(getObjectsParams);
            //Assert.IsType<GetObjectsResponse>(response);
        }

        /// <summary>
        /// Test GetRule
        /// </summary>
        [Fact]
        public void GetRuleTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //var response = instance.GetRule(indexName, objectID);
            //Assert.IsType<Rule>(response);
        }

        /// <summary>
        /// Test GetSettings
        /// </summary>
        [Fact]
        public void GetSettingsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //var response = instance.GetSettings(indexName);
            //Assert.IsType<IndexSettings>(response);
        }

        /// <summary>
        /// Test GetSources
        /// </summary>
        [Fact]
        public void GetSourcesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.GetSources();
            //Assert.IsType<List<Source>>(response);
        }

        /// <summary>
        /// Test GetSynonym
        /// </summary>
        [Fact]
        public void GetSynonymTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //var response = instance.GetSynonym(indexName, objectID);
            //Assert.IsType<SynonymHit>(response);
        }

        /// <summary>
        /// Test GetTask
        /// </summary>
        [Fact]
        public void GetTaskTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //long taskID = null;
            //var response = instance.GetTask(indexName, taskID);
            //Assert.IsType<GetTaskResponse>(response);
        }

        /// <summary>
        /// Test GetTopUserIds
        /// </summary>
        [Fact]
        public void GetTopUserIdsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.GetTopUserIds();
            //Assert.IsType<GetTopUserIdsResponse>(response);
        }

        /// <summary>
        /// Test GetUserId
        /// </summary>
        [Fact]
        public void GetUserIdTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string userID = null;
            //var response = instance.GetUserId(userID);
            //Assert.IsType<UserId>(response);
        }

        /// <summary>
        /// Test HasPendingMappings
        /// </summary>
        [Fact]
        public void HasPendingMappingsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //bool? getClusters = null;
            //var response = instance.HasPendingMappings(getClusters);
            //Assert.IsType<HasPendingMappingsResponse>(response);
        }

        /// <summary>
        /// Test ListApiKeys
        /// </summary>
        [Fact]
        public void ListApiKeysTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.ListApiKeys();
            //Assert.IsType<ListApiKeysResponse>(response);
        }

        /// <summary>
        /// Test ListClusters
        /// </summary>
        [Fact]
        public void ListClustersTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //var response = instance.ListClusters();
            //Assert.IsType<ListClustersResponse>(response);
        }

        /// <summary>
        /// Test ListIndices
        /// </summary>
        [Fact]
        public void ListIndicesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //int? page = null;
            //int? hitsPerPage = null;
            //var response = instance.ListIndices(page, hitsPerPage);
            //Assert.IsType<ListIndicesResponse>(response);
        }

        /// <summary>
        /// Test ListUserIds
        /// </summary>
        [Fact]
        public void ListUserIdsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //int? page = null;
            //int? hitsPerPage = null;
            //var response = instance.ListUserIds(page, hitsPerPage);
            //Assert.IsType<ListUserIdsResponse>(response);
        }

        /// <summary>
        /// Test MultipleBatch
        /// </summary>
        [Fact]
        public void MultipleBatchTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //BatchParams batchParams = null;
            //var response = instance.MultipleBatch(batchParams);
            //Assert.IsType<MultipleBatchResponse>(response);
        }

        /// <summary>
        /// Test OperationIndex
        /// </summary>
        [Fact]
        public void OperationIndexTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //OperationIndexParams operationIndexParams = null;
            //var response = instance.OperationIndex(indexName, operationIndexParams);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test PartialUpdateObject
        /// </summary>
        [Fact]
        public void PartialUpdateObjectTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //Dictionary<string, AttributeToUpdate> attributesToUpdate = null;
            //bool? createIfNotExists = null;
            //var response = instance.PartialUpdateObject(indexName, objectID, attributesToUpdate, createIfNotExists);
            //Assert.IsType<UpdatedAtWithObjectIdResponse>(response);
        }

        /// <summary>
        /// Test Post
        /// </summary>
        [Fact]
        public void PostTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string path = null;
            //Dictionary<string, Object> parameters = null;
            //Object body = null;
            //var response = instance.Post(path, parameters, body);
            //Assert.IsType<Object>(response);
        }

        /// <summary>
        /// Test Put
        /// </summary>
        [Fact]
        public void PutTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string path = null;
            //Dictionary<string, Object> parameters = null;
            //Object body = null;
            //var response = instance.Put(path, parameters, body);
            //Assert.IsType<Object>(response);
        }

        /// <summary>
        /// Test RemoveUserId
        /// </summary>
        [Fact]
        public void RemoveUserIdTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string userID = null;
            //var response = instance.RemoveUserId(userID);
            //Assert.IsType<RemoveUserIdResponse>(response);
        }

        /// <summary>
        /// Test ReplaceSources
        /// </summary>
        [Fact]
        public void ReplaceSourcesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //List<Source> source = null;
            //var response = instance.ReplaceSources(source);
            //Assert.IsType<ReplaceSourceResponse>(response);
        }

        /// <summary>
        /// Test RestoreApiKey
        /// </summary>
        [Fact]
        public void RestoreApiKeyTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string key = null;
            //var response = instance.RestoreApiKey(key);
            //Assert.IsType<AddApiKeyResponse>(response);
        }

        /// <summary>
        /// Test SaveObject
        /// </summary>
        [Fact]
        public void SaveObjectTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //Object body = null;
            //var response = instance.SaveObject(indexName, body);
            //Assert.IsType<SaveObjectResponse>(response);
        }

        /// <summary>
        /// Test SaveRule
        /// </summary>
        [Fact]
        public void SaveRuleTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //Rule rule = null;
            //bool? forwardToReplicas = null;
            //var response = instance.SaveRule(indexName, objectID, rule, forwardToReplicas);
            //Assert.IsType<UpdatedRuleResponse>(response);
        }

        /// <summary>
        /// Test SaveRules
        /// </summary>
        [Fact]
        public void SaveRulesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //List<Rule> rules = null;
            //bool? forwardToReplicas = null;
            //bool? clearExistingRules = null;
            //var response = instance.SaveRules(indexName, rules, forwardToReplicas, clearExistingRules);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test SaveSynonym
        /// </summary>
        [Fact]
        public void SaveSynonymTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string objectID = null;
            //SynonymHit synonymHit = null;
            //bool? forwardToReplicas = null;
            //var response = instance.SaveSynonym(indexName, objectID, synonymHit, forwardToReplicas);
            //Assert.IsType<SaveSynonymResponse>(response);
        }

        /// <summary>
        /// Test SaveSynonyms
        /// </summary>
        [Fact]
        public void SaveSynonymsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //List<SynonymHit> synonymHit = null;
            //bool? forwardToReplicas = null;
            //bool? replaceExistingSynonyms = null;
            //var response = instance.SaveSynonyms(indexName, synonymHit, forwardToReplicas, replaceExistingSynonyms);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test Search
        /// </summary>
        [Fact]
        public void SearchTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //SearchMethodParams searchMethodParams = null;
            //var response = instance.Search(searchMethodParams);
            //Assert.IsType<SearchResponses>(response);
        }

        /// <summary>
        /// Test SearchDictionaryEntries
        /// </summary>
        [Fact]
        public void SearchDictionaryEntriesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //DictionaryType dictionaryName = null;
            //SearchDictionaryEntriesParams searchDictionaryEntriesParams = null;
            //var response = instance.SearchDictionaryEntries(dictionaryName, searchDictionaryEntriesParams);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test SearchForFacetValues
        /// </summary>
        [Fact]
        public void SearchForFacetValuesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //string facetName = null;
            //SearchForFacetValuesRequest searchForFacetValuesRequest = null;
            //var response = instance.SearchForFacetValues(indexName, facetName, searchForFacetValuesRequest);
            //Assert.IsType<SearchForFacetValuesResponse>(response);
        }

        /// <summary>
        /// Test SearchRules
        /// </summary>
        [Fact]
        public void SearchRulesTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //SearchRulesParams searchRulesParams = null;
            //var response = instance.SearchRules(indexName, searchRulesParams);
            //Assert.IsType<SearchRulesResponse>(response);
        }

        /// <summary>
        /// Test SearchSingleIndex
        /// </summary>
        [Fact]
        public void SearchSingleIndexTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //SearchParams searchParams = null;
            //var response = instance.SearchSingleIndex(indexName, searchParams);
            //Assert.IsType<SearchResponse>(response);
        }

        /// <summary>
        /// Test SearchSynonyms
        /// </summary>
        [Fact]
        public void SearchSynonymsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //SynonymType type = null;
            //int? page = null;
            //int? hitsPerPage = null;
            //SearchSynonymsParams searchSynonymsParams = null;
            //var response = instance.SearchSynonyms(indexName, type, page, hitsPerPage, searchSynonymsParams);
            //Assert.IsType<SearchSynonymsResponse>(response);
        }

        /// <summary>
        /// Test SearchUserIds
        /// </summary>
        [Fact]
        public void SearchUserIdsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //SearchUserIdsParams searchUserIdsParams = null;
            //var response = instance.SearchUserIds(searchUserIdsParams);
            //Assert.IsType<SearchUserIdsResponse>(response);
        }

        /// <summary>
        /// Test SetDictionarySettings
        /// </summary>
        [Fact]
        public void SetDictionarySettingsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //DictionarySettingsParams dictionarySettingsParams = null;
            //var response = instance.SetDictionarySettings(dictionarySettingsParams);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test SetSettings
        /// </summary>
        [Fact]
        public void SetSettingsTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string indexName = null;
            //IndexSettings indexSettings = null;
            //bool? forwardToReplicas = null;
            //var response = instance.SetSettings(indexName, indexSettings, forwardToReplicas);
            //Assert.IsType<UpdatedAtResponse>(response);
        }

        /// <summary>
        /// Test UpdateApiKey
        /// </summary>
        [Fact]
        public void UpdateApiKeyTest()
        {
            // TODO uncomment below to test the method and replace null with proper value
            //string key = null;
            //ApiKey apiKey = null;
            //var response = instance.UpdateApiKey(key, apiKey);
            //Assert.IsType<UpdateApiKeyResponse>(response);
        }
    }
}
