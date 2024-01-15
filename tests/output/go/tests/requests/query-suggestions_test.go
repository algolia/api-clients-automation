package tests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/query-suggestions"
)

func createSuggestionsClient() (*suggestions.APIClient, *echoRequester) {
	echo := &echoRequester{}
	cfg := suggestions.Configuration{
		AppID:     "appID",
		ApiKey:    "apiKey",
		Region:    suggestions.US,
		Requester: echo,
	}
	client := suggestions.NewClientWithConfig(cfg)

	// so that the linter doesn't complain
	_ = jsonassert.New(nil)

	return client, echo
}

func TestSuggestions_CreateConfig(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("createConfig0", func(t *testing.T) {
		_, err := client.CreateConfig(client.NewApiCreateConfigRequest(

			suggestions.NewEmptyQuerySuggestionsConfigurationWithIndex().SetIndexName("theIndexName").SetSourceIndices(
				[]suggestions.SourceIndex{*suggestions.NewEmptySourceIndex().SetIndexName("testIndex").SetFacets(
					[]suggestions.Facet{*suggestions.NewEmptyFacet().SetAttribute("test")}).SetGenerate(
					[][]string{
						[]string{"facetA", "facetB"},
						[]string{"facetC"}})}).SetLanguages(suggestions.ArrayOfStringAsLanguages(
				[]string{"french"})).SetExclude(
				[]string{"test"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"indexName":"theIndexName","sourceIndices":[{"indexName":"testIndex","facets":[{"attribute":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}`)
	})
}

func TestSuggestions_CustomDelete(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("allow del method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "DELETE", echo.method)

		require.Nil(t, echo.body)
	})
	t.Run("allow del method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "DELETE", echo.method)

		require.Nil(t, echo.body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
}

func TestSuggestions_CustomGet(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("allow get method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
	})
	t.Run("allow get method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
}

func TestSuggestions_CustomPost(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("allow post method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{}`)
	})
	t.Run("allow post method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions can override default query parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("query", "myQueryParameter"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"myQueryParameter"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions merges query parameters with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("query2", "myQueryParameter"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","query2":"myQueryParameter"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions can override default headers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.header.Get(k))
		}
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions merges headers with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.header.Get(k))
		}
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("isItWorking", true),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","isItWorking":"true"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("myParam", 2),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"2"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of string", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("myParam",
				[]string{"c", "d"}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"c,d"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("myParam",
				[]bool{true, true, false}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"true,true,false"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			suggestions.QueryParamOption("myParam",
				[]int32{1, 2}),
		)
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/requestOptions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"1,2"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
}

func TestSuggestions_CustomPut(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("allow put method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/minimal")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "PUT", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{}`)
	})
	t.Run("allow put method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/test/all")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "PUT", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.query.Get(k))
		}
	})
}

func TestSuggestions_DeleteConfig(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("deleteConfig0", func(t *testing.T) {
		_, err := client.DeleteConfig(client.NewApiDeleteConfigRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "DELETE", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestSuggestions_GetAllConfigs(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("getAllConfigs0", func(t *testing.T) {
		_, err := client.GetAllConfigs()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestSuggestions_GetConfig(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("getConfig0", func(t *testing.T) {
		_, err := client.GetConfig(client.NewApiGetConfigRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestSuggestions_GetConfigStatus(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("getConfigStatus0", func(t *testing.T) {
		_, err := client.GetConfigStatus(client.NewApiGetConfigStatusRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs/theIndexName/status")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestSuggestions_GetLogFile(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("getLogFile0", func(t *testing.T) {
		_, err := client.GetLogFile(client.NewApiGetLogFileRequest(
			"theIndexName",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/logs/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "GET", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestSuggestions_UpdateConfig(t *testing.T) {
	client, echo := createSuggestionsClient()

	t.Run("updateConfig0", func(t *testing.T) {
		_, err := client.UpdateConfig(client.NewApiUpdateConfigRequest(
			"theIndexName",
			suggestions.NewEmptyQuerySuggestionsConfiguration().SetSourceIndices(
				[]suggestions.SourceIndex{*suggestions.NewEmptySourceIndex().SetIndexName("testIndex").SetFacets(
					[]suggestions.Facet{*suggestions.NewEmptyFacet().SetAttribute("test")}).SetGenerate(
					[][]string{
						[]string{"facetA", "facetB"},
						[]string{"facetC"}})}).SetLanguages(suggestions.ArrayOfStringAsLanguages(
				[]string{"french"})).SetExclude(
				[]string{"test"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/configs/theIndexName")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "PUT", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"sourceIndices":[{"indexName":"testIndex","facets":[{"attribute":"test"}],"generate":[["facetA","facetB"],["facetC"]]}],"languages":["french"],"exclude":["test"]}`)
	})
}
