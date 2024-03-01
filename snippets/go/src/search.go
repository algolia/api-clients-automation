package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func SnippetForAddApiKeyOfSearch() {
	/*
	   Snippet for the addApiKey method.

	   addApiKey0
	*/

	// >SEPARATOR addApiKey
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.AddApiKey(client.NewApiAddApiKeyRequest(

		search.NewEmptyApiKey().SetAcl(
			[]search.Acl{search.Acl("search"), search.Acl("addObject")}).SetDescription("my new api key").SetValidity(300).SetMaxQueriesPerIPPerHour(100).SetMaxHitsPerQuery(20),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForAddOrUpdateObjectOfSearch() {
	/*
	   Snippet for the addOrUpdateObject method.

	   addOrUpdateObject0
	*/

	// >SEPARATOR addOrUpdateObject
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		"indexName", "uniqueID", map[string]any{"key": "value"},
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForAppendSourceOfSearch() {
	/*
	   Snippet for the appendSource method.

	   appendSource0
	*/

	// >SEPARATOR appendSource
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.AppendSource(client.NewApiAppendSourceRequest(

		search.NewEmptySource().SetSource("theSource").SetDescription("theDescription"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForAssignUserIdOfSearch() {
	/*
	   Snippet for the assignUserId method.

	   assignUserId0
	*/

	// >SEPARATOR assignUserId
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.AssignUserId(client.NewApiAssignUserIdRequest(
		"userID",
		search.NewEmptyAssignUserIdParams().SetCluster("theCluster"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForBatchOfSearch() {
	/*
	   Snippet for the batch method.

	   allows batch method with `addObject` action
	*/

	// >SEPARATOR batch
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.Batch(client.NewApiBatchRequest(
		"theIndexName",
		search.NewEmptyBatchWriteParams().SetRequests(
			[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("addObject")).SetBody(map[string]any{"key": "value"})}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForBatchAssignUserIdsOfSearch() {
	/*
	   Snippet for the batchAssignUserIds method.

	   batchAssignUserIds0
	*/

	// >SEPARATOR batchAssignUserIds
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.BatchAssignUserIds(client.NewApiBatchAssignUserIdsRequest(
		"userID",
		search.NewEmptyBatchAssignUserIdsParams().SetCluster("theCluster").SetUsers(
			[]string{"user1", "user2"}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForBatchDictionaryEntriesOfSearch() {
	/*
	   Snippet for the batchDictionaryEntries method.

	   get batchDictionaryEntries results with minimal parameters
	*/

	// >SEPARATOR batchDictionaryEntries
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.BatchDictionaryEntries(client.NewApiBatchDictionaryEntriesRequest(
		search.DictionaryType("compounds"),
		search.NewEmptyBatchDictionaryEntriesParams().SetRequests(
			[]search.BatchDictionaryEntriesRequest{*search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("addEntry")).SetBody(
				search.NewEmptyDictionaryEntry().SetObjectID("1").SetLanguage("en")), *search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("deleteEntry")).SetBody(
				search.NewEmptyDictionaryEntry().SetObjectID("2").SetLanguage("fr"))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForBrowseOfSearch() {
	/*
	   Snippet for the browse method.

	   browse with minimal parameters
	*/

	// >SEPARATOR browse
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.Browse(client.NewApiBrowseRequest(
		"cts_e2e_browse",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForClearObjectsOfSearch() {
	/*
	   Snippet for the clearObjects method.

	   clearObjects0
	*/

	// >SEPARATOR clearObjects
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ClearObjects(client.NewApiClearObjectsRequest(
		"theIndexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForClearRulesOfSearch() {
	/*
	   Snippet for the clearRules method.

	   clearRules0
	*/

	// >SEPARATOR clearRules
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ClearRules(client.NewApiClearRulesRequest(
		"indexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForClearSynonymsOfSearch() {
	/*
	   Snippet for the clearSynonyms method.

	   clearSynonyms0
	*/

	// >SEPARATOR clearSynonyms
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ClearSynonyms(client.NewApiClearSynonymsRequest(
		"indexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomDeleteOfSearch() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

	// >SEPARATOR customDelete
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomGetOfSearch() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

	// >SEPARATOR customGet
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomGet(client.NewApiCustomGetRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomPostOfSearch() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPost
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPost(client.NewApiCustomPostRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForCustomPutOfSearch() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

	// >SEPARATOR customPut
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.CustomPut(client.NewApiCustomPutRequest(
		"/test/minimal",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteApiKeyOfSearch() {
	/*
	   Snippet for the deleteApiKey method.

	   deleteApiKey0
	*/

	// >SEPARATOR deleteApiKey
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteApiKey(client.NewApiDeleteApiKeyRequest(
		"myTestApiKey",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteByOfSearch() {
	/*
	   Snippet for the deleteBy method.

	   deleteBy0
	*/

	// >SEPARATOR deleteBy
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteBy(client.NewApiDeleteByRequest(
		"theIndexName",
		search.NewEmptyDeleteByParams().SetFilters("brand:brandName"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteIndexOfSearch() {
	/*
	   Snippet for the deleteIndex method.

	   deleteIndex0
	*/

	// >SEPARATOR deleteIndex
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteIndex(client.NewApiDeleteIndexRequest(
		"theIndexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteObjectOfSearch() {
	/*
	   Snippet for the deleteObject method.

	   deleteObject0
	*/

	// >SEPARATOR deleteObject
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteObject(client.NewApiDeleteObjectRequest(
		"theIndexName", "uniqueID",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteRuleOfSearch() {
	/*
	   Snippet for the deleteRule method.

	   delete rule simple case
	*/

	// >SEPARATOR deleteRule
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteRule(client.NewApiDeleteRuleRequest(
		"indexName", "id1",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteSourceOfSearch() {
	/*
	   Snippet for the deleteSource method.

	   deleteSource0
	*/

	// >SEPARATOR deleteSource
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteSource(client.NewApiDeleteSourceRequest(
		"theSource",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForDeleteSynonymOfSearch() {
	/*
	   Snippet for the deleteSynonym method.

	   deleteSynonym0
	*/

	// >SEPARATOR deleteSynonym
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.DeleteSynonym(client.NewApiDeleteSynonymRequest(
		"indexName", "id1",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetApiKeyOfSearch() {
	/*
	   Snippet for the getApiKey method.

	   getApiKey0
	*/

	// >SEPARATOR getApiKey
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetApiKey(client.NewApiGetApiKeyRequest(
		"myTestApiKey",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetDictionaryLanguagesOfSearch() {
	/*
	   Snippet for the getDictionaryLanguages method.

	   get getDictionaryLanguages
	*/

	// >SEPARATOR getDictionaryLanguages
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetDictionaryLanguages()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetDictionarySettingsOfSearch() {
	/*
	   Snippet for the getDictionarySettings method.

	   get getDictionarySettings results
	*/

	// >SEPARATOR getDictionarySettings
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetDictionarySettings()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetLogsOfSearch() {
	/*
	   Snippet for the getLogs method.

	   getLogs with minimal parameters
	*/

	// >SEPARATOR getLogs
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetLogs(client.NewApiGetLogsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetObjectOfSearch() {
	/*
	   Snippet for the getObject method.

	   getObject0
	*/

	// >SEPARATOR getObject
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetObject(client.NewApiGetObjectRequest(
		"theIndexName", "uniqueID",
	).WithAttributesToRetrieve(
		[]string{"attr1", "attr2"}))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetObjectsOfSearch() {
	/*
	   Snippet for the getObjects method.

	   getObjects0
	*/

	// >SEPARATOR getObjects
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetObjects(client.NewApiGetObjectsRequest(

		search.NewEmptyGetObjectsParams().SetRequests(
			[]search.GetObjectsRequest{*search.NewEmptyGetObjectsRequest().SetAttributesToRetrieve(
				[]string{"attr1", "attr2"}).SetObjectID("uniqueID").SetIndexName("theIndexName")}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetRuleOfSearch() {
	/*
	   Snippet for the getRule method.

	   getRule0
	*/

	// >SEPARATOR getRule
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetRule(client.NewApiGetRuleRequest(
		"indexName", "id1",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetSettingsOfSearch() {
	/*
	   Snippet for the getSettings method.

	   getSettings0
	*/

	// >SEPARATOR getSettings
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSettings(client.NewApiGetSettingsRequest(
		"cts_e2e_settings",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetSourcesOfSearch() {
	/*
	   Snippet for the getSources method.

	   getSources0
	*/

	// >SEPARATOR getSources
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSources()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetSynonymOfSearch() {
	/*
	   Snippet for the getSynonym method.

	   getSynonym0
	*/

	// >SEPARATOR getSynonym
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetSynonym(client.NewApiGetSynonymRequest(
		"indexName", "id1",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetTaskOfSearch() {
	/*
	   Snippet for the getTask method.

	   getTask0
	*/

	// >SEPARATOR getTask
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTask(client.NewApiGetTaskRequest(
		"theIndexName", 123,
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetTopUserIdsOfSearch() {
	/*
	   Snippet for the getTopUserIds method.

	   getTopUserIds0
	*/

	// >SEPARATOR getTopUserIds
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetTopUserIds()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForGetUserIdOfSearch() {
	/*
	   Snippet for the getUserId method.

	   getUserId0
	*/

	// >SEPARATOR getUserId
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.GetUserId(client.NewApiGetUserIdRequest(
		"uniqueID",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForHasPendingMappingsOfSearch() {
	/*
	   Snippet for the hasPendingMappings method.

	   hasPendingMappings with minimal parameters
	*/

	// >SEPARATOR hasPendingMappings
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.HasPendingMappings(client.NewApiHasPendingMappingsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForListApiKeysOfSearch() {
	/*
	   Snippet for the listApiKeys method.

	   listApiKeys0
	*/

	// >SEPARATOR listApiKeys
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ListApiKeys()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForListClustersOfSearch() {
	/*
	   Snippet for the listClusters method.

	   listClusters0
	*/

	// >SEPARATOR listClusters
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ListClusters()
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForListIndicesOfSearch() {
	/*
	   Snippet for the listIndices method.

	   listIndices with minimal parameters
	*/

	// >SEPARATOR listIndices
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ListIndices(client.NewApiListIndicesRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForListUserIdsOfSearch() {
	/*
	   Snippet for the listUserIds method.

	   listUserIds with minimal parameters
	*/

	// >SEPARATOR listUserIds
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ListUserIds(client.NewApiListUserIdsRequest())
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForMultipleBatchOfSearch() {
	/*
	   Snippet for the multipleBatch method.

	   multipleBatch0
	*/

	// >SEPARATOR multipleBatch
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.MultipleBatch(client.NewApiMultipleBatchRequest(

		search.NewEmptyBatchParams().SetRequests(
			[]search.MultipleBatchRequest{*search.NewEmptyMultipleBatchRequest().SetAction(search.Action("addObject")).SetBody(map[string]any{"key": "value"}).SetIndexName("theIndexName")}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForOperationIndexOfSearch() {
	/*
	   Snippet for the operationIndex method.

	   operationIndex0
	*/

	// >SEPARATOR operationIndex
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.OperationIndex(client.NewApiOperationIndexRequest(
		"theIndexName",
		search.NewEmptyOperationIndexParams().SetOperation(search.OperationType("copy")).SetDestination("dest").SetScope(
			[]search.ScopeType{search.ScopeType("rules"), search.ScopeType("settings")}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForPartialUpdateObjectOfSearch() {
	/*
	   Snippet for the partialUpdateObject method.

	   partialUpdateObject0
	*/

	// >SEPARATOR partialUpdateObject
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.PartialUpdateObject(client.NewApiPartialUpdateObjectRequest(
		"theIndexName", "uniqueID", map[string]search.AttributeToUpdate{"id1": *search.StringAsAttributeToUpdate("test"), "id2": *search.BuiltInOperationAsAttributeToUpdate(
			search.NewEmptyBuiltInOperation().SetOperation(search.BuiltInOperationType("AddUnique")).SetValue("test2"))},
	).WithCreateIfNotExists(true))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForRemoveUserIdOfSearch() {
	/*
	   Snippet for the removeUserId method.

	   removeUserId0
	*/

	// >SEPARATOR removeUserId
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.RemoveUserId(client.NewApiRemoveUserIdRequest(
		"uniqueID",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForReplaceSourcesOfSearch() {
	/*
	   Snippet for the replaceSources method.

	   replaceSources0
	*/

	// >SEPARATOR replaceSources
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.ReplaceSources(client.NewApiReplaceSourcesRequest(

		[]search.Source{*search.NewEmptySource().SetSource("theSource").SetDescription("theDescription")},
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForRestoreApiKeyOfSearch() {
	/*
	   Snippet for the restoreApiKey method.

	   restoreApiKey0
	*/

	// >SEPARATOR restoreApiKey
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.RestoreApiKey(client.NewApiRestoreApiKeyRequest(
		"myApiKey",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSaveObjectOfSearch() {
	/*
	   Snippet for the saveObject method.

	   saveObject0
	*/

	// >SEPARATOR saveObject
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SaveObject(client.NewApiSaveObjectRequest(
		"theIndexName", map[string]any{"objectID": "id", "test": "val"},
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSaveRuleOfSearch() {
	/*
	   Snippet for the saveRule method.

	   saveRule with minimal parameters
	*/

	// >SEPARATOR saveRule
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SaveRule(client.NewApiSaveRuleRequest(
		"indexName", "id1",
		search.NewEmptyRule().SetObjectID("id1").SetConditions(
			[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains"))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSaveRulesOfSearch() {
	/*
	   Snippet for the saveRules method.

	   saveRules with minimal parameters
	*/

	// >SEPARATOR saveRules
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SaveRules(client.NewApiSaveRulesRequest(
		"indexName",
		[]search.Rule{*search.NewEmptyRule().SetObjectID("a-rule-id").SetConditions(
			[]search.Condition{*search.NewEmptyCondition().SetPattern("smartphone").SetAnchoring(search.Anchoring("contains"))}), *search.NewEmptyRule().SetObjectID("a-second-rule-id").SetConditions(
			[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains"))})},
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSaveSynonymOfSearch() {
	/*
	   Snippet for the saveSynonym method.

	   saveSynonym0
	*/

	// >SEPARATOR saveSynonym
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SaveSynonym(client.NewApiSaveSynonymRequest(
		"indexName", "id1",
		search.NewEmptySynonymHit().SetObjectID("id1").SetType(search.SynonymType("synonym")).SetSynonyms(
			[]string{"car", "vehicule", "auto"}),
	).WithForwardToReplicas(true))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSaveSynonymsOfSearch() {
	/*
	   Snippet for the saveSynonyms method.

	   saveSynonyms0
	*/

	// >SEPARATOR saveSynonyms
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SaveSynonyms(client.NewApiSaveSynonymsRequest(
		"indexName",
		[]search.SynonymHit{*search.NewEmptySynonymHit().SetObjectID("id1").SetType(search.SynonymType("synonym")).SetSynonyms(
			[]string{"car", "vehicule", "auto"}), *search.NewEmptySynonymHit().SetObjectID("id2").SetType(search.SynonymType("onewaysynonym")).SetInput("iphone").SetSynonyms(
			[]string{"ephone", "aphone", "yphone"})},
	).WithForwardToReplicas(true).WithReplaceExistingSynonyms(false))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchOfSearch() {
	/*
	   Snippet for the search method.

	   search for a single hits request with minimal parameters
	*/

	// >SEPARATOR search
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.Search(client.NewApiSearchRequest(

		search.NewEmptySearchMethodParams().SetRequests(
			[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
				search.NewEmptySearchForHits().SetIndexName("cts_e2e_search_empty_index"))}),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchDictionaryEntriesOfSearch() {
	/*
	   Snippet for the searchDictionaryEntries method.

	   get searchDictionaryEntries results with minimal parameters
	*/

	// >SEPARATOR searchDictionaryEntries
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchDictionaryEntries(client.NewApiSearchDictionaryEntriesRequest(
		search.DictionaryType("compounds"),
		search.NewEmptySearchDictionaryEntriesParams().SetQuery("foo"),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchForFacetValuesOfSearch() {
	/*
	   Snippet for the searchForFacetValues method.

	   get searchForFacetValues results with minimal parameters
	*/

	// >SEPARATOR searchForFacetValues
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchForFacetValues(client.NewApiSearchForFacetValuesRequest(
		"indexName", "facetName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchRulesOfSearch() {
	/*
	   Snippet for the searchRules method.

	   searchRules0
	*/

	// >SEPARATOR searchRules
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchRules(client.NewApiSearchRulesRequest(
		"indexName",
	).WithSearchRulesParams(
		search.NewEmptySearchRulesParams().SetQuery("something")))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchSingleIndexOfSearch() {
	/*
	   Snippet for the searchSingleIndex method.

	   search with minimal parameters
	*/

	// >SEPARATOR searchSingleIndex
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
		"indexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchSynonymsOfSearch() {
	/*
	   Snippet for the searchSynonyms method.

	   searchSynonyms with minimal parameters
	*/

	// >SEPARATOR searchSynonyms
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchSynonyms(client.NewApiSearchSynonymsRequest(
		"indexName",
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSearchUserIdsOfSearch() {
	/*
	   Snippet for the searchUserIds method.

	   searchUserIds0
	*/

	// >SEPARATOR searchUserIds
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SearchUserIds(client.NewApiSearchUserIdsRequest(

		search.NewEmptySearchUserIdsParams().SetQuery("test").SetClusterName("theClusterName").SetPage(5).SetHitsPerPage(10),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSetDictionarySettingsOfSearch() {
	/*
	   Snippet for the setDictionarySettings method.

	   get setDictionarySettings results with minimal parameters
	*/

	// >SEPARATOR setDictionarySettings
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SetDictionarySettings(client.NewApiSetDictionarySettingsRequest(

		search.NewEmptyDictionarySettingsParams().SetDisableStandardEntries(
			search.NewEmptyStandardEntries().SetPlurals(map[string]bool{"fr": false, "en": false, "ru": true})),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForSetSettingsOfSearch() {
	/*
	   Snippet for the setSettings method.

	   setSettings with minimal parameters
	*/

	// >SEPARATOR setSettings
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.SetSettings(client.NewApiSetSettingsRequest(
		"cts_e2e_settings",
		search.NewEmptyIndexSettings().SetPaginationLimitedTo(10),
	).WithForwardToReplicas(true))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
func SnippetForUpdateApiKeyOfSearch() {
	/*
	   Snippet for the updateApiKey method.

	   updateApiKey0
	*/

	// >SEPARATOR updateApiKey
	// Initialize the client
	client, err := search.NewClient("YOUR_APP_ID", "YOUR_API_KEY")
	if err != nil {
		// The client can fail to initialize if you pass an invalid parameter.
		panic(err)
	}

	// Call the API
	resp, err := client.UpdateApiKey(client.NewApiUpdateApiKeyRequest(
		"myApiKey",
		search.NewEmptyApiKey().SetAcl(
			[]search.Acl{search.Acl("search"), search.Acl("addObject")}).SetValidity(300).SetMaxQueriesPerIPPerHour(100).SetMaxHitsPerQuery(20),
	))
	if err != nil {
		// handle the eventual error
		panic(err)
	}

	// use the model directly
	print(resp)
	// SEPARATOR<
}
