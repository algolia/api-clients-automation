package snippets

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func SnippetForAddApiKeyOfSearch() {
	/*
	   Snippet for the addApiKey method.

	   addApiKey0
	*/

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
}
func SnippetForAddOrUpdateObjectOfSearch() {
	/*
	   Snippet for the addOrUpdateObject method.

	   addOrUpdateObject0
	*/

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
}
func SnippetForAppendSourceOfSearch() {
	/*
	   Snippet for the appendSource method.

	   appendSource0
	*/

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
}
func SnippetForAssignUserIdOfSearch() {
	/*
	   Snippet for the assignUserId method.

	   assignUserId0
	*/

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
}
func SnippetForBatchOfSearch() {
	/*
	   Snippet for the batch method.

	   allows batch method with `addObject` action
	*/

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
}
func SnippetForBatchAssignUserIdsOfSearch() {
	/*
	   Snippet for the batchAssignUserIds method.

	   batchAssignUserIds0
	*/

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
}
func SnippetForBatchDictionaryEntriesOfSearch() {
	/*
	   Snippet for the batchDictionaryEntries method.

	   get batchDictionaryEntries results with minimal parameters
	*/

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
}
func SnippetForBrowseOfSearch() {
	/*
	   Snippet for the browse method.

	   browse with minimal parameters
	*/

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
}
func SnippetForClearObjectsOfSearch() {
	/*
	   Snippet for the clearObjects method.

	   clearObjects0
	*/

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
}
func SnippetForClearRulesOfSearch() {
	/*
	   Snippet for the clearRules method.

	   clearRules0
	*/

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
}
func SnippetForClearSynonymsOfSearch() {
	/*
	   Snippet for the clearSynonyms method.

	   clearSynonyms0
	*/

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
}
func SnippetForCustomDeleteOfSearch() {
	/*
	   Snippet for the customDelete method.

	   allow del method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomGetOfSearch() {
	/*
	   Snippet for the customGet method.

	   allow get method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomPostOfSearch() {
	/*
	   Snippet for the customPost method.

	   allow post method for a custom path with minimal parameters
	*/

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
}
func SnippetForCustomPutOfSearch() {
	/*
	   Snippet for the customPut method.

	   allow put method for a custom path with minimal parameters
	*/

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
}
func SnippetForDeleteApiKeyOfSearch() {
	/*
	   Snippet for the deleteApiKey method.

	   deleteApiKey0
	*/

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
}
func SnippetForDeleteByOfSearch() {
	/*
	   Snippet for the deleteBy method.

	   deleteBy0
	*/

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
}
func SnippetForDeleteIndexOfSearch() {
	/*
	   Snippet for the deleteIndex method.

	   deleteIndex0
	*/

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
}
func SnippetForDeleteObjectOfSearch() {
	/*
	   Snippet for the deleteObject method.

	   deleteObject0
	*/

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
}
func SnippetForDeleteRuleOfSearch() {
	/*
	   Snippet for the deleteRule method.

	   delete rule simple case
	*/

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
}
func SnippetForDeleteSourceOfSearch() {
	/*
	   Snippet for the deleteSource method.

	   deleteSource0
	*/

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
}
func SnippetForDeleteSynonymOfSearch() {
	/*
	   Snippet for the deleteSynonym method.

	   deleteSynonym0
	*/

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
}
func SnippetForGetApiKeyOfSearch() {
	/*
	   Snippet for the getApiKey method.

	   getApiKey0
	*/

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
}
func SnippetForGetDictionaryLanguagesOfSearch() {
	/*
	   Snippet for the getDictionaryLanguages method.

	   get getDictionaryLanguages
	*/

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
}
func SnippetForGetDictionarySettingsOfSearch() {
	/*
	   Snippet for the getDictionarySettings method.

	   get getDictionarySettings results
	*/

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
}
func SnippetForGetLogsOfSearch() {
	/*
	   Snippet for the getLogs method.

	   getLogs with minimal parameters
	*/

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
}
func SnippetForGetObjectOfSearch() {
	/*
	   Snippet for the getObject method.

	   getObject0
	*/

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
}
func SnippetForGetObjectsOfSearch() {
	/*
	   Snippet for the getObjects method.

	   getObjects0
	*/

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
}
func SnippetForGetRuleOfSearch() {
	/*
	   Snippet for the getRule method.

	   getRule0
	*/

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
}
func SnippetForGetSettingsOfSearch() {
	/*
	   Snippet for the getSettings method.

	   getSettings0
	*/

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
}
func SnippetForGetSourcesOfSearch() {
	/*
	   Snippet for the getSources method.

	   getSources0
	*/

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
}
func SnippetForGetSynonymOfSearch() {
	/*
	   Snippet for the getSynonym method.

	   getSynonym0
	*/

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
}
func SnippetForGetTaskOfSearch() {
	/*
	   Snippet for the getTask method.

	   getTask0
	*/

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
}
func SnippetForGetTopUserIdsOfSearch() {
	/*
	   Snippet for the getTopUserIds method.

	   getTopUserIds0
	*/

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
}
func SnippetForGetUserIdOfSearch() {
	/*
	   Snippet for the getUserId method.

	   getUserId0
	*/

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
}
func SnippetForHasPendingMappingsOfSearch() {
	/*
	   Snippet for the hasPendingMappings method.

	   hasPendingMappings with minimal parameters
	*/

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
}
func SnippetForListApiKeysOfSearch() {
	/*
	   Snippet for the listApiKeys method.

	   listApiKeys0
	*/

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
}
func SnippetForListClustersOfSearch() {
	/*
	   Snippet for the listClusters method.

	   listClusters0
	*/

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
}
func SnippetForListIndicesOfSearch() {
	/*
	   Snippet for the listIndices method.

	   listIndices with minimal parameters
	*/

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
}
func SnippetForListUserIdsOfSearch() {
	/*
	   Snippet for the listUserIds method.

	   listUserIds with minimal parameters
	*/

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
}
func SnippetForMultipleBatchOfSearch() {
	/*
	   Snippet for the multipleBatch method.

	   multipleBatch0
	*/

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
}
func SnippetForOperationIndexOfSearch() {
	/*
	   Snippet for the operationIndex method.

	   operationIndex0
	*/

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
}
func SnippetForPartialUpdateObjectOfSearch() {
	/*
	   Snippet for the partialUpdateObject method.

	   partialUpdateObject0
	*/

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
}
func SnippetForRemoveUserIdOfSearch() {
	/*
	   Snippet for the removeUserId method.

	   removeUserId0
	*/

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
}
func SnippetForReplaceSourcesOfSearch() {
	/*
	   Snippet for the replaceSources method.

	   replaceSources0
	*/

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
}
func SnippetForRestoreApiKeyOfSearch() {
	/*
	   Snippet for the restoreApiKey method.

	   restoreApiKey0
	*/

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
}
func SnippetForSaveObjectOfSearch() {
	/*
	   Snippet for the saveObject method.

	   saveObject0
	*/

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
}
func SnippetForSaveRuleOfSearch() {
	/*
	   Snippet for the saveRule method.

	   saveRule with minimal parameters
	*/

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
}
func SnippetForSaveRulesOfSearch() {
	/*
	   Snippet for the saveRules method.

	   saveRules with minimal parameters
	*/

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
}
func SnippetForSaveSynonymOfSearch() {
	/*
	   Snippet for the saveSynonym method.

	   saveSynonym0
	*/

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
}
func SnippetForSaveSynonymsOfSearch() {
	/*
	   Snippet for the saveSynonyms method.

	   saveSynonyms0
	*/

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
}
func SnippetForSearchOfSearch() {
	/*
	   Snippet for the search method.

	   search for a single hits request with minimal parameters
	*/

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
}
func SnippetForSearchDictionaryEntriesOfSearch() {
	/*
	   Snippet for the searchDictionaryEntries method.

	   get searchDictionaryEntries results with minimal parameters
	*/

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
}
func SnippetForSearchForFacetValuesOfSearch() {
	/*
	   Snippet for the searchForFacetValues method.

	   get searchForFacetValues results with minimal parameters
	*/

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
}
func SnippetForSearchRulesOfSearch() {
	/*
	   Snippet for the searchRules method.

	   searchRules0
	*/

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
}
func SnippetForSearchSingleIndexOfSearch() {
	/*
	   Snippet for the searchSingleIndex method.

	   search with minimal parameters
	*/

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
}
func SnippetForSearchSynonymsOfSearch() {
	/*
	   Snippet for the searchSynonyms method.

	   searchSynonyms with minimal parameters
	*/

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
}
func SnippetForSearchUserIdsOfSearch() {
	/*
	   Snippet for the searchUserIds method.

	   searchUserIds0
	*/

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
}
func SnippetForSetDictionarySettingsOfSearch() {
	/*
	   Snippet for the setDictionarySettings method.

	   get setDictionarySettings results with minimal parameters
	*/

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
}
func SnippetForSetSettingsOfSearch() {
	/*
	   Snippet for the setSettings method.

	   setSettings with minimal parameters
	*/

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
}
func SnippetForUpdateApiKeyOfSearch() {
	/*
	   Snippet for the updateApiKey method.

	   updateApiKey0
	*/

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
}
