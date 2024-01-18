package requests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createSearchClient() (*search.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := search.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, _ := search.NewClientWithConfig(cfg)

	return client, echo
}

func TestSearch_AddApiKey(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("addApiKey0", func(t *testing.T) {
		_, err := client.AddApiKey(client.NewApiAddApiKeyRequest(

			search.NewEmptyApiKey().SetAcl(
				[]search.Acl{search.Acl("search"), search.Acl("addObject")}).SetDescription("my new api key").SetValidity(300).SetMaxQueriesPerIPPerHour(100).SetMaxHitsPerQuery(20),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"acl":["search","addObject"],"description":"my new api key","validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}`)
	})
}

func TestSearch_AddOrUpdateObject(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("addOrUpdateObject0", func(t *testing.T) {
		_, err := client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
			"indexName", "uniqueID", map[string]any{"key": "value"},
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/uniqueID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"key":"value"}`)
	})
}

func TestSearch_AppendSource(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("appendSource0", func(t *testing.T) {
		_, err := client.AppendSource(client.NewApiAppendSourceRequest(

			search.NewEmptySource().SetSource("theSource").SetDescription("theDescription"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/security/sources/append")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"source":"theSource","description":"theDescription"}`)
	})
}

func TestSearch_AssignUserId(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("assignUserId0", func(t *testing.T) {
		_, err := client.AssignUserId(client.NewApiAssignUserIdRequest(
			"userID",
			search.NewEmptyAssignUserIdParams().SetCluster("theCluster"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"cluster":"theCluster"}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-user-id":"userID"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.Header.Get(k))
		}
	})
}

func TestSearch_Batch(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("allows batch method with `addObject` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("addObject")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"addObject","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `clear` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("clear")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"clear","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `delete` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("delete")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"delete","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `deleteObject` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("deleteObject")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"deleteObject","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `partialUpdateObject` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("partialUpdateObject")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"partialUpdateObject","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `partialUpdateObjectNoCreate` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("partialUpdateObjectNoCreate")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"partialUpdateObjectNoCreate","body":{"key":"value"}}]}`)
	})
	t.Run("allows batch method with `updateObject` action", func(t *testing.T) {
		_, err := client.Batch(client.NewApiBatchRequest(
			"theIndexName",
			search.NewEmptyBatchWriteParams().SetRequests(
				[]search.BatchRequest{*search.NewEmptyBatchRequest().SetAction(search.Action("updateObject")).SetBody(map[string]any{"key": "value"})}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"updateObject","body":{"key":"value"}}]}`)
	})
}

func TestSearch_BatchAssignUserIds(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("batchAssignUserIds0", func(t *testing.T) {
		_, err := client.BatchAssignUserIds(client.NewApiBatchAssignUserIdsRequest(
			"userID",
			search.NewEmptyBatchAssignUserIdsParams().SetCluster("theCluster").SetUsers(
				[]string{"user1", "user2"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"cluster":"theCluster","users":["user1","user2"]}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-user-id":"userID"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.Header.Get(k))
		}
	})
}

func TestSearch_BatchDictionaryEntries(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get batchDictionaryEntries results with minimal parameters", func(t *testing.T) {
		_, err := client.BatchDictionaryEntries(client.NewApiBatchDictionaryEntriesRequest(
			search.DictionaryType("compounds"),
			search.NewEmptyBatchDictionaryEntriesParams().SetRequests(
				[]search.BatchDictionaryEntriesRequest{*search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("addEntry")).SetBody(
					search.NewEmptyDictionaryEntry().SetObjectID("1").SetLanguage("en")), *search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("deleteEntry")).SetBody(
					search.NewEmptyDictionaryEntry().SetObjectID("2").SetLanguage("fr"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/compounds/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr"}}]}`)
	})
	t.Run("get batchDictionaryEntries results with all parameters", func(t *testing.T) {
		_, err := client.BatchDictionaryEntries(client.NewApiBatchDictionaryEntriesRequest(
			search.DictionaryType("compounds"),
			search.NewEmptyBatchDictionaryEntriesParams().SetClearExistingDictionaryEntries(false).SetRequests(
				[]search.BatchDictionaryEntriesRequest{*search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("addEntry")).SetBody(
					search.NewEmptyDictionaryEntry().SetObjectID("1").SetLanguage("en").SetWord("fancy").SetWords(
						[]string{"believe", "algolia"}).SetDecomposition(
						[]string{"trust", "algolia"}).SetState(search.DictionaryEntryState("enabled"))), *search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("deleteEntry")).SetBody(
					search.NewEmptyDictionaryEntry().SetObjectID("2").SetLanguage("fr").SetWord("humility").SetWords(
						[]string{"candor", "algolia"}).SetDecomposition(
						[]string{"grit", "algolia"}).SetState(search.DictionaryEntryState("enabled")))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/compounds/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"clearExistingDictionaryEntries":false,"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","word":"fancy","words":["believe","algolia"],"decomposition":["trust","algolia"],"state":"enabled"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr","word":"humility","words":["candor","algolia"],"decomposition":["grit","algolia"],"state":"enabled"}}]}`)
	})
	t.Run("get batchDictionaryEntries results additional properties", func(t *testing.T) {
		_, err := client.BatchDictionaryEntries(client.NewApiBatchDictionaryEntriesRequest(
			search.DictionaryType("compounds"),
			search.NewEmptyBatchDictionaryEntriesParams().SetRequests(
				[]search.BatchDictionaryEntriesRequest{*search.NewEmptyBatchDictionaryEntriesRequest().SetAction(search.DictionaryAction("addEntry")).SetBody(
					search.NewEmptyDictionaryEntry().SetObjectID("1").SetLanguage("en").SetAdditionalProperty("additional", "try me"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/compounds/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","additional":"try me"}}]}`)
	})
}

func TestSearch_Browse(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("browse with minimal parameters", func(t *testing.T) {
		_, err := client.Browse(client.NewApiBrowseRequest(
			"cts_e2e_browse",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/cts_e2e_browse/browse")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("browse with search parameters", func(t *testing.T) {
		_, err := client.Browse(client.NewApiBrowseRequest(
			"indexName",
		).WithBrowseParams(search.BrowseParamsObjectAsBrowseParams(
			search.NewEmptyBrowseParamsObject().SetQuery("myQuery").SetFacetFilters(search.ArrayOfMixedSearchFiltersAsFacetFilters(
				[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("tags:algolia")})))))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/browse")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"myQuery","facetFilters":["tags:algolia"]}`)
	})
	t.Run("browse allow a cursor in parameters", func(t *testing.T) {
		_, err := client.Browse(client.NewApiBrowseRequest(
			"indexName",
		).WithBrowseParams(search.BrowseParamsObjectAsBrowseParams(
			search.NewEmptyBrowseParamsObject().SetCursor("test"))))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/browse")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"cursor":"test"}`)
	})
}

func TestSearch_ClearObjects(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("clearObjects0", func(t *testing.T) {
		_, err := client.ClearObjects(client.NewApiClearObjectsRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/clear")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestSearch_ClearRules(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("clearRules0", func(t *testing.T) {
		_, err := client.ClearRules(client.NewApiClearRulesRequest(
			"indexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/clear")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestSearch_ClearSynonyms(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("clearSynonyms0", func(t *testing.T) {
		_, err := client.ClearSynonyms(client.NewApiClearSynonymsRequest(
			"indexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/clear")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestSearch_CustomDelete(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("allow del method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow del method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_CustomGet(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("allow get method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow get method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_CustomPost(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("allow post method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow post method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions can override default query parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("query", "myQueryParameter"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"myQueryParameter"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions merges query parameters with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("query2", "myQueryParameter"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","query2":"myQueryParameter"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions can override default headers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.Header.Get(k))
		}
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions merges headers with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.Header.Get(k))
		}
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("isItWorking", true),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","isItWorking":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("myParam", 2),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"2"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of string", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("myParam",
				[]string{"c", "d"}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"c,d"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("myParam",
				[]bool{true, true, false}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"true,true,false"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			search.QueryParamOption("myParam",
				[]int32{1, 2}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"1,2"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_CustomPut(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("allow put method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow put method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_DeleteApiKey(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteApiKey0", func(t *testing.T) {
		_, err := client.DeleteApiKey(client.NewApiDeleteApiKeyRequest(
			"myTestApiKey",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys/myTestApiKey")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_DeleteBy(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteBy0", func(t *testing.T) {
		_, err := client.DeleteBy(client.NewApiDeleteByRequest(
			"theIndexName",
			search.NewEmptyDeleteByParams().SetFilters("brand:brandName"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/deleteByQuery")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"filters":"brand:brandName"}`)
	})
}

func TestSearch_DeleteIndex(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteIndex0", func(t *testing.T) {
		_, err := client.DeleteIndex(client.NewApiDeleteIndexRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_DeleteObject(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteObject0", func(t *testing.T) {
		_, err := client.DeleteObject(client.NewApiDeleteObjectRequest(
			"theIndexName", "uniqueID",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/uniqueID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_DeleteRule(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("delete rule simple case", func(t *testing.T) {
		_, err := client.DeleteRule(client.NewApiDeleteRuleRequest(
			"indexName", "id1",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("delete rule with simple characters to encode in objectID", func(t *testing.T) {
		_, err := client.DeleteRule(client.NewApiDeleteRuleRequest(
			"indexName", "test/with/slash",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/test%2Fwith%2Fslash")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_DeleteSource(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteSource0", func(t *testing.T) {
		_, err := client.DeleteSource(client.NewApiDeleteSourceRequest(
			"theSource",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/security/sources/theSource")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_DeleteSynonym(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("deleteSynonym0", func(t *testing.T) {
		_, err := client.DeleteSynonym(client.NewApiDeleteSynonymRequest(
			"indexName", "id1",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetApiKey(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getApiKey0", func(t *testing.T) {
		_, err := client.GetApiKey(client.NewApiGetApiKeyRequest(
			"myTestApiKey",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys/myTestApiKey")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetDictionaryLanguages(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get getDictionaryLanguages", func(t *testing.T) {
		_, err := client.GetDictionaryLanguages()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/*/languages")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetDictionarySettings(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get getDictionarySettings results", func(t *testing.T) {
		_, err := client.GetDictionarySettings()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/*/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetLogs(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getLogs with minimal parameters", func(t *testing.T) {
		_, err := client.GetLogs(client.NewApiGetLogsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/logs")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("getLogs with parameters", func(t *testing.T) {
		_, err := client.GetLogs(client.NewApiGetLogsRequest().WithOffset(5).WithLength(10).WithIndexName("theIndexName").WithType(search.LogType("all")))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/logs")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"offset":"5","length":"10","indexName":"theIndexName","type":"all"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_GetObject(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getObject0", func(t *testing.T) {
		_, err := client.GetObject(client.NewApiGetObjectRequest(
			"theIndexName", "uniqueID",
		).WithAttributesToRetrieve(
			[]string{"attr1", "attr2"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/uniqueID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"attributesToRetrieve":"attr1,attr2"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_GetObjects(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getObjects0", func(t *testing.T) {
		_, err := client.GetObjects(client.NewApiGetObjectsRequest(

			search.NewEmptyGetObjectsParams().SetRequests(
				[]search.GetObjectsRequest{*search.NewEmptyGetObjectsRequest().SetAttributesToRetrieve(
					[]string{"attr1", "attr2"}).SetObjectID("uniqueID").SetIndexName("theIndexName")}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/objects")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"attributesToRetrieve":["attr1","attr2"],"objectID":"uniqueID","indexName":"theIndexName"}]}`)
	})
}

func TestSearch_GetRule(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getRule0", func(t *testing.T) {
		_, err := client.GetRule(client.NewApiGetRuleRequest(
			"indexName", "id1",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetSettings(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getSettings0", func(t *testing.T) {
		_, err := client.GetSettings(client.NewApiGetSettingsRequest(
			"cts_e2e_settings",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/cts_e2e_settings/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetSources(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getSources0", func(t *testing.T) {
		_, err := client.GetSources()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/security/sources")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetSynonym(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getSynonym0", func(t *testing.T) {
		_, err := client.GetSynonym(client.NewApiGetSynonymRequest(
			"indexName", "id1",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetTask(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getTask0", func(t *testing.T) {
		_, err := client.GetTask(client.NewApiGetTaskRequest(
			"theIndexName", 123,
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/task/123")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetTopUserIds(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getTopUserIds0", func(t *testing.T) {
		_, err := client.GetTopUserIds()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/top")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_GetUserId(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("getUserId0", func(t *testing.T) {
		_, err := client.GetUserId(client.NewApiGetUserIdRequest(
			"uniqueID",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/uniqueID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_HasPendingMappings(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("hasPendingMappings with minimal parameters", func(t *testing.T) {
		_, err := client.HasPendingMappings(client.NewApiHasPendingMappingsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/pending")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("hasPendingMappings with parameters", func(t *testing.T) {
		_, err := client.HasPendingMappings(client.NewApiHasPendingMappingsRequest().WithGetClusters(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/pending")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"getClusters":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_ListApiKeys(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("listApiKeys0", func(t *testing.T) {
		_, err := client.ListApiKeys()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_ListClusters(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("listClusters0", func(t *testing.T) {
		_, err := client.ListClusters()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_ListIndices(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("listIndices with minimal parameters", func(t *testing.T) {
		_, err := client.ListIndices(client.NewApiListIndicesRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("listIndices with parameters", func(t *testing.T) {
		_, err := client.ListIndices(client.NewApiListIndicesRequest().WithPage(8).WithHitsPerPage(3))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"page":"8","hitsPerPage":"3"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_ListUserIds(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("listUserIds with minimal parameters", func(t *testing.T) {
		_, err := client.ListUserIds(client.NewApiListUserIdsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("listUserIds with parameters", func(t *testing.T) {
		_, err := client.ListUserIds(client.NewApiListUserIdsRequest().WithPage(8).WithHitsPerPage(100))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"page":"8","hitsPerPage":"100"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_MultipleBatch(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("multipleBatch0", func(t *testing.T) {
		_, err := client.MultipleBatch(client.NewApiMultipleBatchRequest(

			search.NewEmptyBatchParams().SetRequests(
				[]search.MultipleBatchRequest{*search.NewEmptyMultipleBatchRequest().SetAction(search.Action("addObject")).SetBody(map[string]any{"key": "value"}).SetIndexName("theIndexName")}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"action":"addObject","body":{"key":"value"},"indexName":"theIndexName"}]}`)
	})
}

func TestSearch_OperationIndex(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("operationIndex0", func(t *testing.T) {
		_, err := client.OperationIndex(client.NewApiOperationIndexRequest(
			"theIndexName",
			search.NewEmptyOperationIndexParams().SetOperation(search.OperationType("copy")).SetDestination("dest").SetScope(
				[]search.ScopeType{search.ScopeType("rules"), search.ScopeType("settings")}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/operation")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"operation":"copy","destination":"dest","scope":["rules","settings"]}`)
	})
}

func TestSearch_PartialUpdateObject(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("partialUpdateObject0", func(t *testing.T) {
		_, err := client.PartialUpdateObject(client.NewApiPartialUpdateObjectRequest(
			"theIndexName", "uniqueID", map[string]search.AttributeToUpdate{"id1": *search.StringAsAttributeToUpdate("test"), "id2": *search.BuiltInOperationAsAttributeToUpdate(
				search.NewEmptyBuiltInOperation().SetOperation(search.BuiltInOperationType("AddUnique")).SetValue("test2"))},
		).WithCreateIfNotExists(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/uniqueID/partial")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"id1":"test","id2":{"_operation":"AddUnique","value":"test2"}}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"createIfNotExists":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_RemoveUserId(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("removeUserId0", func(t *testing.T) {
		_, err := client.RemoveUserId(client.NewApiRemoveUserIdRequest(
			"uniqueID",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/uniqueID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestSearch_ReplaceSources(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("replaceSources0", func(t *testing.T) {
		_, err := client.ReplaceSources(client.NewApiReplaceSourcesRequest(

			[]search.Source{*search.NewEmptySource().SetSource("theSource").SetDescription("theDescription")},
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/security/sources")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `[{"source":"theSource","description":"theDescription"}]`)
	})
}

func TestSearch_RestoreApiKey(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("restoreApiKey0", func(t *testing.T) {
		_, err := client.RestoreApiKey(client.NewApiRestoreApiKeyRequest(
			"myApiKey",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys/myApiKey/restore")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestSearch_SaveObject(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("saveObject0", func(t *testing.T) {
		_, err := client.SaveObject(client.NewApiSaveObjectRequest(
			"theIndexName", map[string]any{"objectID": "id", "test": "val"},
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"objectID":"id","test":"val"}`)
	})
}

func TestSearch_SaveRule(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("saveRule with minimal parameters", func(t *testing.T) {
		_, err := client.SaveRule(client.NewApiSaveRuleRequest(
			"indexName", "id1",
			search.NewEmptyRule().SetObjectID("id1").SetConditions(
				[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains"}]}`)
	})
	t.Run("saveRule with all parameters", func(t *testing.T) {
		_, err := client.SaveRule(client.NewApiSaveRuleRequest(
			"indexName", "id1",
			search.NewEmptyRule().SetObjectID("id1").SetConditions(
				[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains")).SetAlternatives(false).SetContext("search")}).SetConsequence(
				search.NewEmptyConsequence().SetParams(
					search.NewEmptyConsequenceParams().SetFilters("brand:apple").SetQuery(search.ConsequenceQueryObjectAsConsequenceQuery(
						search.NewEmptyConsequenceQueryObject().SetRemove(
							[]string{"algolia"}).SetEdits(
							[]search.Edit{*search.NewEmptyEdit().SetType(search.EditType("remove")).SetDelete("abc").SetInsert("cde"), *search.NewEmptyEdit().SetType(search.EditType("replace")).SetDelete("abc").SetInsert("cde")})))).SetHide(
					[]search.ConsequenceHide{*search.NewEmptyConsequenceHide().SetObjectID("321")}).SetFilterPromotes(false).SetUserData(map[string]any{"algolia": "aloglia"}).SetPromote(
					[]search.Promote{*search.PromoteObjectIDAsPromote(
						search.NewEmptyPromoteObjectID().SetObjectID("abc").SetPosition(3)), *search.PromoteObjectIDsAsPromote(
						search.NewEmptyPromoteObjectIDs().SetObjectIDs(
							[]string{"abc", "def"}).SetPosition(1))})).SetDescription("test").SetEnabled(true).SetValidity(
				[]search.TimeRange{*search.NewEmptyTimeRange().SetFrom(1656670273).SetUntil(1656670277)}),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_SaveRules(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("saveRules with minimal parameters", func(t *testing.T) {
		_, err := client.SaveRules(client.NewApiSaveRulesRequest(
			"indexName",
			[]search.Rule{*search.NewEmptyRule().SetObjectID("a-rule-id").SetConditions(
				[]search.Condition{*search.NewEmptyCondition().SetPattern("smartphone").SetAnchoring(search.Anchoring("contains"))}), *search.NewEmptyRule().SetObjectID("a-second-rule-id").SetConditions(
				[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains"))})},
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `[{"objectID":"a-rule-id","conditions":[{"pattern":"smartphone","anchoring":"contains"}]},{"objectID":"a-second-rule-id","conditions":[{"pattern":"apple","anchoring":"contains"}]}]`)
	})
	t.Run("saveRules with all parameters", func(t *testing.T) {
		_, err := client.SaveRules(client.NewApiSaveRulesRequest(
			"indexName",
			[]search.Rule{*search.NewEmptyRule().SetObjectID("id1").SetConditions(
				[]search.Condition{*search.NewEmptyCondition().SetPattern("apple").SetAnchoring(search.Anchoring("contains")).SetAlternatives(false).SetContext("search")}).SetConsequence(
				search.NewEmptyConsequence().SetParams(
					search.NewEmptyConsequenceParams().SetFilters("brand:apple").SetQuery(search.ConsequenceQueryObjectAsConsequenceQuery(
						search.NewEmptyConsequenceQueryObject().SetRemove(
							[]string{"algolia"}).SetEdits(
							[]search.Edit{*search.NewEmptyEdit().SetType(search.EditType("remove")).SetDelete("abc").SetInsert("cde"), *search.NewEmptyEdit().SetType(search.EditType("replace")).SetDelete("abc").SetInsert("cde")})))).SetHide(
					[]search.ConsequenceHide{*search.NewEmptyConsequenceHide().SetObjectID("321")}).SetFilterPromotes(false).SetUserData(map[string]any{"algolia": "aloglia"}).SetPromote(
					[]search.Promote{*search.PromoteObjectIDAsPromote(
						search.NewEmptyPromoteObjectID().SetObjectID("abc").SetPosition(3)), *search.PromoteObjectIDsAsPromote(
						search.NewEmptyPromoteObjectIDs().SetObjectIDs(
							[]string{"abc", "def"}).SetPosition(1))})).SetDescription("test").SetEnabled(true).SetValidity(
				[]search.TimeRange{*search.NewEmptyTimeRange().SetFrom(1656670273).SetUntil(1656670277)})},
		).WithForwardToReplicas(true).WithClearExistingRules(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `[{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}]`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true","clearExistingRules":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_SaveSynonym(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("saveSynonym0", func(t *testing.T) {
		_, err := client.SaveSynonym(client.NewApiSaveSynonymRequest(
			"indexName", "id1",
			search.NewEmptySynonymHit().SetObjectID("id1").SetType(search.SynonymType("synonym")).SetSynonyms(
				[]string{"car", "vehicule", "auto"}),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/id1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_SaveSynonyms(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("saveSynonyms0", func(t *testing.T) {
		_, err := client.SaveSynonyms(client.NewApiSaveSynonymsRequest(
			"indexName",
			[]search.SynonymHit{*search.NewEmptySynonymHit().SetObjectID("id1").SetType(search.SynonymType("synonym")).SetSynonyms(
				[]string{"car", "vehicule", "auto"}), *search.NewEmptySynonymHit().SetObjectID("id2").SetType(search.SynonymType("onewaysynonym")).SetInput("iphone").SetSynonyms(
				[]string{"ephone", "aphone", "yphone"})},
		).WithForwardToReplicas(true).WithReplaceExistingSynonyms(false))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/batch")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `[{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]},{"objectID":"id2","type":"onewaysynonym","input":"iphone","synonyms":["ephone","aphone","yphone"]}]`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true","replaceExistingSynonyms":"false"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_Search(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("search for a single hits request with minimal parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("cts_e2e_search_empty_index"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"cts_e2e_search_empty_index"}]}`)
	})
	t.Run("search for a single facet request with minimal parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForFacetsAsSearchQuery(
					search.NewEmptySearchForFacets().SetIndexName("cts_e2e_search_facet").SetType(search.SearchTypeFacet("facet")).SetFacet("editor"))}).SetStrategy(search.SearchStrategy("stopIfEnoughMatches")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"cts_e2e_search_facet","type":"facet","facet":"editor"}],"strategy":"stopIfEnoughMatches"}`)
	})
	t.Run("search for a single hits request with all parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName").SetQuery("myQuery").SetHitsPerPage(50).SetType(search.SearchTypeDefault("default")))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}]}`)
	})
	t.Run("search for a single facet request with all parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForFacetsAsSearchQuery(
					search.NewEmptySearchForFacets().SetIndexName("theIndexName").SetType(search.SearchTypeFacet("facet")).SetFacet("theFacet").SetFacetQuery("theFacetQuery").SetQuery("theQuery").SetMaxFacetHits(50))}).SetStrategy(search.SearchStrategy("stopIfEnoughMatches")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50}],"strategy":"stopIfEnoughMatches"}`)
	})
	t.Run("search for multiple mixed requests in multiple indices with minimal parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName")), *search.SearchForFacetsAsSearchQuery(
					search.NewEmptySearchForFacets().SetIndexName("theIndexName2").SetType(search.SearchTypeFacet("facet")).SetFacet("theFacet")), *search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName").SetType(search.SearchTypeDefault("default")))}).SetStrategy(search.SearchStrategy("stopIfEnoughMatches")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"theIndexName"},{"indexName":"theIndexName2","type":"facet","facet":"theFacet"},{"indexName":"theIndexName","type":"default"}],"strategy":"stopIfEnoughMatches"}`)
	})
	t.Run("search for multiple mixed requests in multiple indices with all parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForFacetsAsSearchQuery(
					search.NewEmptySearchForFacets().SetIndexName("theIndexName").SetType(search.SearchTypeFacet("facet")).SetFacet("theFacet").SetFacetQuery("theFacetQuery").SetQuery("theQuery").SetMaxFacetHits(50)), *search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName").SetQuery("myQuery").SetHitsPerPage(50).SetType(search.SearchTypeDefault("default")))}).SetStrategy(search.SearchStrategy("stopIfEnoughMatches")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50},{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}],"strategy":"stopIfEnoughMatches"}`)
	})
	t.Run("search filters accept all of the possible shapes", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName").SetFacetFilters(search.StringAsFacetFilters("mySearch:filters")).SetReRankingApplyFilter(search.StringAsReRankingApplyFilter("mySearch:filters")).SetTagFilters(search.StringAsTagFilters("mySearch:filters")).SetNumericFilters(search.StringAsNumericFilters("mySearch:filters")).SetOptionalFilters(search.StringAsOptionalFilters("mySearch:filters"))), *search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetIndexName("theIndexName").SetFacetFilters(search.ArrayOfMixedSearchFiltersAsFacetFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("mySearch:filters"), *search.ArrayOfStringAsMixedSearchFilters(
							[]string{"mySearch:filters"})})).SetReRankingApplyFilter(search.ArrayOfMixedSearchFiltersAsReRankingApplyFilter(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("mySearch:filters"), *search.ArrayOfStringAsMixedSearchFilters(
							[]string{"mySearch:filters"})})).SetTagFilters(search.ArrayOfMixedSearchFiltersAsTagFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("mySearch:filters"), *search.ArrayOfStringAsMixedSearchFilters(
							[]string{"mySearch:filters"})})).SetNumericFilters(search.ArrayOfMixedSearchFiltersAsNumericFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("mySearch:filters"), *search.ArrayOfStringAsMixedSearchFilters(
							[]string{"mySearch:filters"})})).SetOptionalFilters(search.ArrayOfMixedSearchFiltersAsOptionalFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("mySearch:filters"), *search.ArrayOfStringAsMixedSearchFilters(
							[]string{"mySearch:filters"})})))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"theIndexName","facetFilters":"mySearch:filters","reRankingApplyFilter":"mySearch:filters","tagFilters":"mySearch:filters","numericFilters":"mySearch:filters","optionalFilters":"mySearch:filters"},{"indexName":"theIndexName","facetFilters":["mySearch:filters",["mySearch:filters"]],"reRankingApplyFilter":["mySearch:filters",["mySearch:filters"]],"tagFilters":["mySearch:filters",["mySearch:filters"]],"numericFilters":["mySearch:filters",["mySearch:filters"]],"optionalFilters":["mySearch:filters",["mySearch:filters"]]}]}`)
	})
	t.Run("search with all search parameters", func(t *testing.T) {
		_, err := client.Search(client.NewApiSearchRequest(

			search.NewEmptySearchMethodParams().SetRequests(
				[]search.SearchQuery{*search.SearchForHitsAsSearchQuery(
					search.NewEmptySearchForHits().SetAdvancedSyntax(true).SetAdvancedSyntaxFeatures(
						[]search.AdvancedSyntaxFeatures{search.AdvancedSyntaxFeatures("exactPhrase")}).SetAllowTyposOnNumericTokens(true).SetAlternativesAsExact(
						[]search.AlternativesAsExact{search.AlternativesAsExact("multiWordsSynonym")}).SetAnalytics(true).SetAnalyticsTags(
						[]string{""}).SetAroundLatLng("").SetAroundLatLngViaIP(true).SetAroundPrecision(search.Int32AsAroundPrecision(0)).SetAroundRadius(search.AroundRadiusAllAsAroundRadius(search.AroundRadiusAll("all"))).SetAttributeCriteriaComputedByMinProximity(true).SetAttributesForFaceting(
						[]string{""}).SetAttributesToHighlight(
						[]string{""}).SetAttributesToRetrieve(
						[]string{""}).SetAttributesToSnippet(
						[]string{""}).SetClickAnalytics(true).SetCustomRanking(
						[]string{""}).SetDecompoundQuery(true).SetDisableExactOnAttributes(
						[]string{""}).SetDisableTypoToleranceOnAttributes(
						[]string{""}).SetDistinct(search.Int32AsDistinct(0)).SetEnableABTest(true).SetEnablePersonalization(true).SetEnableReRanking(true).SetEnableRules(true).SetExactOnSingleWordQuery(search.ExactOnSingleWordQuery("attribute")).SetExplain(
						[]string{"foo", "bar"}).SetFacetFilters(search.ArrayOfMixedSearchFiltersAsFacetFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("")})).SetFacetingAfterDistinct(true).SetFacets(
						[]string{""}).SetFilters("").SetGetRankingInfo(true).SetHighlightPostTag("").SetHighlightPreTag("").SetHitsPerPage(1).SetIgnorePlurals(search.BoolAsIgnorePlurals(false)).SetIndexName("theIndexName").SetInsideBoundingBox(
						[][]float64{
							[]float64{47.3165, 4.9665, 47.3424, 5.0201},
							[]float64{40.9234, 2.1185, 38.643, 1.9916}}).SetInsidePolygon(
						[][]float64{
							[]float64{47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9},
							[]float64{40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104}}).SetKeepDiacriticsOnCharacters("").SetLength(1).SetMaxValuesPerFacet(0).SetMinProximity(1).SetMinWordSizefor1Typo(0).SetMinWordSizefor2Typos(0).SetMinimumAroundRadius(1).SetNaturalLanguages(
						[]string{""}).SetNumericFilters(search.ArrayOfMixedSearchFiltersAsNumericFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("")})).SetOffset(0).SetOptionalFilters(search.ArrayOfMixedSearchFiltersAsOptionalFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("")})).SetOptionalWords(
						[]string{""}).SetPage(0).SetPercentileComputation(true).SetPersonalizationImpact(0).SetQuery("").SetQueryLanguages(
						[]string{""}).SetQueryType(search.QueryType("prefixAll")).SetRanking(
						[]string{""}).SetReRankingApplyFilter(search.ArrayOfMixedSearchFiltersAsReRankingApplyFilter(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("")})).SetRelevancyStrictness(0).SetRemoveStopWords(search.BoolAsRemoveStopWords(true)).SetRemoveWordsIfNoResults(search.RemoveWordsIfNoResults("allOptional")).SetRenderingContent(
						search.NewEmptyRenderingContent().SetFacetOrdering(
							search.NewEmptyFacetOrdering().SetFacets(
								search.NewEmptyFacets().SetOrder(
									[]string{"a", "b"})).SetValues(map[string]search.Value{"a": *search.NewEmptyValue().SetOrder(
								[]string{"b"}).SetSortRemainingBy(search.SortRemainingBy("count"))}))).SetReplaceSynonymsInHighlight(true).SetResponseFields(
						[]string{""}).SetRestrictHighlightAndSnippetArrays(true).SetRestrictSearchableAttributes(
						[]string{""}).SetRuleContexts(
						[]string{""}).SetSimilarQuery("").SetSnippetEllipsisText("").SetSortFacetValuesBy("").SetSumOrFiltersScores(true).SetSynonyms(true).SetTagFilters(search.ArrayOfMixedSearchFiltersAsTagFilters(
						[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("")})).SetType(search.SearchTypeDefault("default")).SetTypoTolerance(search.TypoToleranceEnumAsTypoTolerance(search.TypoToleranceEnum("min"))).SetUserToken(""))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/queries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowTyposOnNumericTokens":true,"alternativesAsExact":["multiWordsSynonym"],"analytics":true,"analyticsTags":[""],"aroundLatLng":"","aroundLatLngViaIP":true,"aroundPrecision":0,"aroundRadius":"all","attributeCriteriaComputedByMinProximity":true,"attributesForFaceting":[""],"attributesToHighlight":[""],"attributesToRetrieve":[""],"attributesToSnippet":[""],"clickAnalytics":true,"customRanking":[""],"decompoundQuery":true,"disableExactOnAttributes":[""],"disableTypoToleranceOnAttributes":[""],"distinct":0,"enableABTest":true,"enablePersonalization":true,"enableReRanking":true,"enableRules":true,"exactOnSingleWordQuery":"attribute","explain":["foo","bar"],"facetFilters":[""],"facetingAfterDistinct":true,"facets":[""],"filters":"","getRankingInfo":true,"highlightPostTag":"","highlightPreTag":"","hitsPerPage":1,"ignorePlurals":false,"indexName":"theIndexName","insideBoundingBox":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],"insidePolygon":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],"keepDiacriticsOnCharacters":"","length":1,"maxValuesPerFacet":0,"minProximity":1,"minWordSizefor1Typo":0,"minWordSizefor2Typos":0,"minimumAroundRadius":1,"naturalLanguages":[""],"numericFilters":[""],"offset":0,"optionalFilters":[""],"optionalWords":[""],"page":0,"percentileComputation":true,"personalizationImpact":0,"query":"","queryLanguages":[""],"queryType":"prefixAll","ranking":[""],"reRankingApplyFilter":[""],"relevancyStrictness":0,"removeStopWords":true,"removeWordsIfNoResults":"allOptional","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"responseFields":[""],"restrictHighlightAndSnippetArrays":true,"restrictSearchableAttributes":[""],"ruleContexts":[""],"similarQuery":"","snippetEllipsisText":"","sortFacetValuesBy":"","sumOrFiltersScores":true,"synonyms":true,"tagFilters":[""],"type":"default","typoTolerance":"min","userToken":""}]}`)
	})
}

func TestSearch_SearchDictionaryEntries(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get searchDictionaryEntries results with minimal parameters", func(t *testing.T) {
		_, err := client.SearchDictionaryEntries(client.NewApiSearchDictionaryEntriesRequest(
			search.DictionaryType("compounds"),
			search.NewEmptySearchDictionaryEntriesParams().SetQuery("foo"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/compounds/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"foo"}`)
	})
	t.Run("get searchDictionaryEntries results with all parameters", func(t *testing.T) {
		_, err := client.SearchDictionaryEntries(client.NewApiSearchDictionaryEntriesRequest(
			search.DictionaryType("compounds"),
			search.NewEmptySearchDictionaryEntriesParams().SetQuery("foo").SetPage(4).SetHitsPerPage(2).SetLanguage("fr"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/compounds/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"foo","page":4,"hitsPerPage":2,"language":"fr"}`)
	})
}

func TestSearch_SearchForFacetValues(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get searchForFacetValues results with minimal parameters", func(t *testing.T) {
		_, err := client.SearchForFacetValues(client.NewApiSearchForFacetValuesRequest(
			"indexName", "facetName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/facets/facetName/query")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("get searchForFacetValues results with all parameters", func(t *testing.T) {
		_, err := client.SearchForFacetValues(client.NewApiSearchForFacetValuesRequest(
			"indexName", "facetName",
		).WithSearchForFacetValuesRequest(
			search.NewEmptySearchForFacetValuesRequest().SetParams("query=foo&facetFilters=['bar']").SetFacetQuery("foo").SetMaxFacetHits(42)))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/facets/facetName/query")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"params":"query=foo&facetFilters=['bar']","facetQuery":"foo","maxFacetHits":42}`)
	})
}

func TestSearch_SearchRules(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("searchRules0", func(t *testing.T) {
		_, err := client.SearchRules(client.NewApiSearchRulesRequest(
			"indexName",
		).WithSearchRulesParams(
			search.NewEmptySearchRulesParams().SetQuery("something")))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/rules/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"something"}`)
	})
}

func TestSearch_SearchSingleIndex(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("search with minimal parameters", func(t *testing.T) {
		_, err := client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
			"indexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/query")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("search with special characters in indexName", func(t *testing.T) {
		_, err := client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
			"cts_e2e_space in index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/cts_e2e_space%20in%20index/query")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("search with searchParams", func(t *testing.T) {
		_, err := client.SearchSingleIndex(client.NewApiSearchSingleIndexRequest(
			"indexName",
		).WithSearchParams(search.SearchParamsObjectAsSearchParams(
			search.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(search.ArrayOfMixedSearchFiltersAsFacetFilters(
				[]search.MixedSearchFilters{*search.StringAsMixedSearchFilters("tags:algolia")})))))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/query")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"myQuery","facetFilters":["tags:algolia"]}`)
	})
}

func TestSearch_SearchSynonyms(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("searchSynonyms with minimal parameters", func(t *testing.T) {
		_, err := client.SearchSynonyms(client.NewApiSearchSynonymsRequest(
			"indexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("searchSynonyms with all parameters", func(t *testing.T) {
		_, err := client.SearchSynonyms(client.NewApiSearchSynonymsRequest(
			"indexName",
		).WithType(search.SynonymType("altcorrection1")).WithPage(10).WithHitsPerPage(10).WithSearchSynonymsParams(
			search.NewEmptySearchSynonymsParams().SetQuery("myQuery")))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/synonyms/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"myQuery"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"type":"altcorrection1","page":"10","hitsPerPage":"10"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestSearch_SearchUserIds(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("searchUserIds0", func(t *testing.T) {
		_, err := client.SearchUserIds(client.NewApiSearchUserIdsRequest(

			search.NewEmptySearchUserIdsParams().SetQuery("test").SetClusterName("theClusterName").SetPage(5).SetHitsPerPage(10),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/clusters/mapping/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"query":"test","clusterName":"theClusterName","page":5,"hitsPerPage":10}`)
	})
}

func TestSearch_SetDictionarySettings(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("get setDictionarySettings results with minimal parameters", func(t *testing.T) {
		_, err := client.SetDictionarySettings(client.NewApiSetDictionarySettingsRequest(

			search.NewEmptyDictionarySettingsParams().SetDisableStandardEntries(
				search.NewEmptyStandardEntries().SetPlurals(map[string]bool{"fr": false, "en": false, "ru": true})),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/*/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true}}}`)
	})
	t.Run("get setDictionarySettings results with all parameters", func(t *testing.T) {
		_, err := client.SetDictionarySettings(client.NewApiSetDictionarySettingsRequest(

			search.NewEmptyDictionarySettingsParams().SetDisableStandardEntries(
				search.NewEmptyStandardEntries().SetPlurals(map[string]bool{"fr": false, "en": false, "ru": true}).SetStopwords(map[string]bool{"fr": false}).SetCompounds(map[string]bool{"ru": true})),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/dictionaries/*/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true},"stopwords":{"fr":false},"compounds":{"ru":true}}}`)
	})
}

func TestSearch_SetSettings(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("setSettings with minimal parameters", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"cts_e2e_settings",
			search.NewEmptyIndexSettings().SetPaginationLimitedTo(10),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/cts_e2e_settings/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"paginationLimitedTo":10}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow boolean `typoTolerance`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetTypoTolerance(search.BoolAsTypoTolerance(true)),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"typoTolerance":true}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow enum `typoTolerance`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetTypoTolerance(search.TypoToleranceEnumAsTypoTolerance(search.TypoToleranceEnum("min"))),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"typoTolerance":"min"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow boolean `ignorePlurals`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetIgnorePlurals(search.BoolAsIgnorePlurals(true)),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"ignorePlurals":true}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow list of string `ignorePlurals`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetIgnorePlurals(search.ArrayOfStringAsIgnorePlurals(
				[]string{"algolia"})),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"ignorePlurals":["algolia"]}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow boolean `removeStopWords`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetRemoveStopWords(search.BoolAsRemoveStopWords(true)),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"removeStopWords":true}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow list of string `removeStopWords`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetRemoveStopWords(search.ArrayOfStringAsRemoveStopWords(
				[]string{"algolia"})),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"removeStopWords":["algolia"]}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow boolean `distinct`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetDistinct(search.BoolAsDistinct(true)),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"distinct":true}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow integers for `distinct`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetDistinct(search.Int32AsDistinct(1)),
		).WithForwardToReplicas(true))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"distinct":1}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"forwardToReplicas":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("setSettings allow all `indexSettings`", func(t *testing.T) {
		_, err := client.SetSettings(client.NewApiSetSettingsRequest(
			"theIndexName",
			search.NewEmptyIndexSettings().SetAdvancedSyntax(true).SetAdvancedSyntaxFeatures(
				[]search.AdvancedSyntaxFeatures{search.AdvancedSyntaxFeatures("exactPhrase")}).SetAllowCompressionOfIntegerArray(true).SetAllowTyposOnNumericTokens(true).SetAlternativesAsExact(
				[]search.AlternativesAsExact{search.AlternativesAsExact("singleWordSynonym")}).SetAttributeCriteriaComputedByMinProximity(true).SetAttributeForDistinct("test").SetAttributesForFaceting(
				[]string{"algolia"}).SetAttributesToHighlight(
				[]string{"algolia"}).SetAttributesToRetrieve(
				[]string{"algolia"}).SetAttributesToSnippet(
				[]string{"algolia"}).SetAttributesToTransliterate(
				[]string{"algolia"}).SetCamelCaseAttributes(
				[]string{"algolia"}).SetCustomNormalization(map[string]map[string]string{"algolia": map[string]string{"aloglia": "aglolia"}}).SetCustomRanking(
				[]string{"algolia"}).SetDecompoundQuery(false).SetDecompoundedAttributes(map[string]any{"algolia": "aloglia"}).SetDisableExactOnAttributes(
				[]string{"algolia"}).SetDisablePrefixOnAttributes(
				[]string{"algolia"}).SetDisableTypoToleranceOnAttributes(
				[]string{"algolia"}).SetDisableTypoToleranceOnWords(
				[]string{"algolia"}).SetDistinct(search.Int32AsDistinct(3)).SetEnablePersonalization(true).SetEnableReRanking(false).SetEnableRules(true).SetExactOnSingleWordQuery(search.ExactOnSingleWordQuery("attribute")).SetHighlightPreTag("<span>").SetHighlightPostTag("</span>").SetHitsPerPage(10).SetIgnorePlurals(search.BoolAsIgnorePlurals(false)).SetIndexLanguages(
				[]string{"algolia"}).SetKeepDiacriticsOnCharacters("abc").SetMaxFacetHits(20).SetMaxValuesPerFacet(30).SetMinProximity(6).SetMinWordSizefor1Typo(5).SetMinWordSizefor2Typos(11).SetMode(search.Mode("neuralSearch")).SetNumericAttributesForFiltering(
				[]string{"algolia"}).SetOptionalWords(
				[]string{"myspace"}).SetPaginationLimitedTo(0).SetQueryLanguages(
				[]string{"algolia"}).SetQueryType(search.QueryType("prefixLast")).SetRanking(
				[]string{"geo"}).SetReRankingApplyFilter(search.StringAsReRankingApplyFilter("mySearch:filters")).SetRelevancyStrictness(10).SetRemoveStopWords(search.BoolAsRemoveStopWords(false)).SetRemoveWordsIfNoResults(search.RemoveWordsIfNoResults("lastWords")).SetRenderingContent(
				search.NewEmptyRenderingContent().SetFacetOrdering(
					search.NewEmptyFacetOrdering().SetFacets(
						search.NewEmptyFacets().SetOrder(
							[]string{"a", "b"})).SetValues(map[string]search.Value{"a": *search.NewEmptyValue().SetOrder(
						[]string{"b"}).SetSortRemainingBy(search.SortRemainingBy("count"))}))).SetReplaceSynonymsInHighlight(true).SetReplicas(
				[]string{""}).SetResponseFields(
				[]string{"algolia"}).SetRestrictHighlightAndSnippetArrays(true).SetSearchableAttributes(
				[]string{"foo"}).SetSemanticSearch(
				search.NewEmptySemanticSearch().SetEventSources(
					[]string{"foo"})).SetSeparatorsToIndex("bar").SetSnippetEllipsisText("---").SetSortFacetValuesBy("date").SetTypoTolerance(search.BoolAsTypoTolerance(false)).SetUnretrievableAttributes(
				[]string{"foo"}).SetUserData(map[string]any{"user": "data"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/theIndexName/settings")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowCompressionOfIntegerArray":true,"allowTyposOnNumericTokens":true,"alternativesAsExact":["singleWordSynonym"],"attributeCriteriaComputedByMinProximity":true,"attributeForDistinct":"test","attributesForFaceting":["algolia"],"attributesToHighlight":["algolia"],"attributesToRetrieve":["algolia"],"attributesToSnippet":["algolia"],"attributesToTransliterate":["algolia"],"camelCaseAttributes":["algolia"],"customNormalization":{"algolia":{"aloglia":"aglolia"}},"customRanking":["algolia"],"decompoundQuery":false,"decompoundedAttributes":{"algolia":"aloglia"},"disableExactOnAttributes":["algolia"],"disablePrefixOnAttributes":["algolia"],"disableTypoToleranceOnAttributes":["algolia"],"disableTypoToleranceOnWords":["algolia"],"distinct":3,"enablePersonalization":true,"enableReRanking":false,"enableRules":true,"exactOnSingleWordQuery":"attribute","highlightPreTag":"<span>","highlightPostTag":"</span>","hitsPerPage":10,"ignorePlurals":false,"indexLanguages":["algolia"],"keepDiacriticsOnCharacters":"abc","maxFacetHits":20,"maxValuesPerFacet":30,"minProximity":6,"minWordSizefor1Typo":5,"minWordSizefor2Typos":11,"mode":"neuralSearch","numericAttributesForFiltering":["algolia"],"optionalWords":["myspace"],"paginationLimitedTo":0,"queryLanguages":["algolia"],"queryType":"prefixLast","ranking":["geo"],"reRankingApplyFilter":"mySearch:filters","relevancyStrictness":10,"removeStopWords":false,"removeWordsIfNoResults":"lastWords","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"replicas":[""],"responseFields":["algolia"],"restrictHighlightAndSnippetArrays":true,"searchableAttributes":["foo"],"semanticSearch":{"eventSources":["foo"]},"separatorsToIndex":"bar","snippetEllipsisText":"---","sortFacetValuesBy":"date","typoTolerance":false,"unretrievableAttributes":["foo"],"userData":{"user":"data"}}`)
	})
}

func TestSearch_UpdateApiKey(t *testing.T) {
	client, echo := createSearchClient()

	t.Run("updateApiKey0", func(t *testing.T) {
		_, err := client.UpdateApiKey(client.NewApiUpdateApiKeyRequest(
			"myApiKey",
			search.NewEmptyApiKey().SetAcl(
				[]search.Acl{search.Acl("search"), search.Acl("addObject")}).SetValidity(300).SetMaxQueriesPerIPPerHour(100).SetMaxHitsPerQuery(20),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/keys/myApiKey")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"acl":["search","addObject"],"validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}`)
	})
}
