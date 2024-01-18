package requests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/recommend"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createRecommendClient() (*recommend.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := recommend.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, _ := recommend.NewClientWithConfig(cfg)

	return client, echo
}

func TestRecommend_CustomDelete(t *testing.T) {
	client, echo := createRecommendClient()

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

func TestRecommend_CustomGet(t *testing.T) {
	client, echo := createRecommendClient()

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

func TestRecommend_CustomPost(t *testing.T) {
	client, echo := createRecommendClient()

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
			recommend.QueryParamOption("query", "myQueryParameter"),
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
			recommend.QueryParamOption("query2", "myQueryParameter"),
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
			recommend.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			recommend.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			recommend.QueryParamOption("isItWorking", true),
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
			recommend.QueryParamOption("myParam", 2),
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
			recommend.QueryParamOption("myParam",
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
			recommend.QueryParamOption("myParam",
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
			recommend.QueryParamOption("myParam",
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

func TestRecommend_CustomPut(t *testing.T) {
	client, echo := createRecommendClient()

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

func TestRecommend_DeleteRecommendRule(t *testing.T) {
	client, echo := createRecommendClient()

	t.Run("deleteRecommendRule0", func(t *testing.T) {
		_, err := client.DeleteRecommendRule(client.NewApiDeleteRecommendRuleRequest(
			"indexName", recommend.RecommendModels("related-products"), "objectID",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/related-products/recommend/rules/objectID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestRecommend_GetRecommendRule(t *testing.T) {
	client, echo := createRecommendClient()

	t.Run("getRecommendRule0", func(t *testing.T) {
		_, err := client.GetRecommendRule(client.NewApiGetRecommendRuleRequest(
			"indexName", recommend.RecommendModels("related-products"), "objectID",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/related-products/recommend/rules/objectID")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestRecommend_GetRecommendStatus(t *testing.T) {
	client, echo := createRecommendClient()

	t.Run("getRecommendStatus0", func(t *testing.T) {
		_, err := client.GetRecommendStatus(client.NewApiGetRecommendStatusRequest(
			"indexName", recommend.RecommendModels("related-products"), 12345,
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/related-products/task/12345")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestRecommend_GetRecommendations(t *testing.T) {
	client, echo := createRecommendClient()

	t.Run("get recommendations for recommend model with minimal parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName").SetObjectID("objectID").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(42))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42}]}`)
	})
	t.Run("get recommendations for recommend model with all parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName").SetObjectID("objectID").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(42).SetMaxRecommendations(10).SetQueryParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("query")}))).SetFallbackParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("fallback")}))))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName","objectID":"objectID","model":"related-products","threshold":42,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}`)
	})
	t.Run("get recommendations for trending model with minimal parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.TrendingItemsQueryAsRecommendationsRequest(
					recommend.NewEmptyTrendingItemsQuery().SetIndexName("indexName").SetModel(recommend.TrendingItemsModel("trending-items")).SetThreshold(42))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42}]}`)
	})
	t.Run("get recommendations for trending model with all parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.TrendingItemsQueryAsRecommendationsRequest(
					recommend.NewEmptyTrendingItemsQuery().SetIndexName("indexName").SetModel(recommend.TrendingItemsModel("trending-items")).SetThreshold(42).SetMaxRecommendations(10).SetFacetName("myFacetName").SetFacetValue("myFacetValue").SetQueryParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("query")}))).SetFallbackParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("fallback")}))))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName","model":"trending-items","threshold":42,"maxRecommendations":10,"facetName":"myFacetName","facetValue":"myFacetValue","queryParameters":{"query":"myQuery","facetFilters":["query"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback"]}}]}`)
	})
	t.Run("get multiple recommendations with minimal parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName1").SetObjectID("objectID1").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(21)), *recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName2").SetObjectID("objectID2").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(21))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21}]}`)
	})
	t.Run("get multiple recommendations with all parameters", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName1").SetObjectID("objectID1").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(21).SetMaxRecommendations(10).SetQueryParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("query1")}))).SetFallbackParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("fallback1")})))), *recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName2").SetObjectID("objectID2").SetModel(recommend.RecommendationModels("related-products")).SetThreshold(21).SetMaxRecommendations(10).SetQueryParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("query2")}))).SetFallbackParameters(
						recommend.NewEmptySearchParamsObject().SetQuery("myQuery").SetFacetFilters(recommend.ArrayOfMixedSearchFiltersAsFacetFilters(
							[]recommend.MixedSearchFilters{*recommend.StringAsMixedSearchFilters("fallback2")}))))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query1"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback1"]}},{"indexName":"indexName2","objectID":"objectID2","model":"related-products","threshold":21,"maxRecommendations":10,"queryParameters":{"query":"myQuery","facetFilters":["query2"]},"fallbackParameters":{"query":"myQuery","facetFilters":["fallback2"]}}]}`)
	})
	t.Run("get frequently bought together recommendations", func(t *testing.T) {
		_, err := client.GetRecommendations(client.NewApiGetRecommendationsRequest(

			recommend.NewEmptyGetRecommendationsParams().SetRequests(
				[]recommend.RecommendationsRequest{*recommend.RecommendationsQueryAsRecommendationsRequest(
					recommend.NewEmptyRecommendationsQuery().SetIndexName("indexName1").SetObjectID("objectID1").SetModel(recommend.RecommendationModels("bought-together")).SetThreshold(42))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/*/recommendations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"requests":[{"indexName":"indexName1","objectID":"objectID1","model":"bought-together","threshold":42}]}`)
	})
}

func TestRecommend_SearchRecommendRules(t *testing.T) {
	client, echo := createRecommendClient()

	t.Run("searchRecommendRules0", func(t *testing.T) {
		_, err := client.SearchRecommendRules(client.NewApiSearchRecommendRulesRequest(
			"indexName", recommend.RecommendModels("related-products"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/indexes/indexName/related-products/recommend/rules/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
}
