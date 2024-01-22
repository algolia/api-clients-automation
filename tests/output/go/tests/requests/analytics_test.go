package requests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createAnalyticsClient() (*analytics.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := analytics.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: analytics.US,
	}
	client, _ := analytics.NewClientWithConfig(cfg)

	return client, echo
}

func TestAnalytics_CustomDelete(t *testing.T) {
	client, echo := createAnalyticsClient()

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

func TestAnalytics_CustomGet(t *testing.T) {
	client, echo := createAnalyticsClient()

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

func TestAnalytics_CustomPost(t *testing.T) {
	client, echo := createAnalyticsClient()

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
			analytics.QueryParamOption("query", "myQueryParameter"),
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
			analytics.QueryParamOption("query2", "myQueryParameter"),
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
			analytics.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			analytics.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			analytics.QueryParamOption("isItWorking", true),
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
			analytics.QueryParamOption("myParam", 2),
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
			analytics.QueryParamOption("myParam",
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
			analytics.QueryParamOption("myParam",
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
			analytics.QueryParamOption("myParam",
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

func TestAnalytics_CustomPut(t *testing.T) {
	client, echo := createAnalyticsClient()

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

func TestAnalytics_GetAverageClickPosition(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getAverageClickPosition with minimal parameters", func(t *testing.T) {
		_, err := client.GetAverageClickPosition(client.NewApiGetAverageClickPositionRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/averageClickPosition")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getAverageClickPosition with all parameters", func(t *testing.T) {
		_, err := client.GetAverageClickPosition(client.NewApiGetAverageClickPositionRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/averageClickPosition")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetClickPositions(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getClickPositions with minimal parameters", func(t *testing.T) {
		_, err := client.GetClickPositions(client.NewApiGetClickPositionsRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/positions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getClickPositions with all parameters", func(t *testing.T) {
		_, err := client.GetClickPositions(client.NewApiGetClickPositionsRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/positions")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetClickThroughRate(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getClickThroughRate with minimal parameters", func(t *testing.T) {
		_, err := client.GetClickThroughRate(client.NewApiGetClickThroughRateRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/clickThroughRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getClickThroughRate with all parameters", func(t *testing.T) {
		_, err := client.GetClickThroughRate(client.NewApiGetClickThroughRateRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/clicks/clickThroughRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetConversationRate(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getConversationRate with minimal parameters", func(t *testing.T) {
		_, err := client.GetConversationRate(client.NewApiGetConversationRateRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/conversions/conversionRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getConversationRate with all parameters", func(t *testing.T) {
		_, err := client.GetConversationRate(client.NewApiGetConversationRateRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/conversions/conversionRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetNoClickRate(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getNoClickRate with minimal parameters", func(t *testing.T) {
		_, err := client.GetNoClickRate(client.NewApiGetNoClickRateRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noClickRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getNoClickRate with all parameters", func(t *testing.T) {
		_, err := client.GetNoClickRate(client.NewApiGetNoClickRateRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noClickRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetNoResultsRate(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getNoResultsRate with minimal parameters", func(t *testing.T) {
		_, err := client.GetNoResultsRate(client.NewApiGetNoResultsRateRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noResultRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getNoResultsRate with all parameters", func(t *testing.T) {
		_, err := client.GetNoResultsRate(client.NewApiGetNoResultsRateRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noResultRate")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetSearchesCount(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getSearchesCount with minimal parameters", func(t *testing.T) {
		_, err := client.GetSearchesCount(client.NewApiGetSearchesCountRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/count")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getSearchesCount with all parameters", func(t *testing.T) {
		_, err := client.GetSearchesCount(client.NewApiGetSearchesCountRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/count")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetSearchesNoClicks(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getSearchesNoClicks with minimal parameters", func(t *testing.T) {
		_, err := client.GetSearchesNoClicks(client.NewApiGetSearchesNoClicksRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noClicks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getSearchesNoClicks with all parameters", func(t *testing.T) {
		_, err := client.GetSearchesNoClicks(client.NewApiGetSearchesNoClicksRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noClicks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetSearchesNoResults(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getSearchesNoResults with minimal parameters", func(t *testing.T) {
		_, err := client.GetSearchesNoResults(client.NewApiGetSearchesNoResultsRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noResults")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getSearchesNoResults with all parameters", func(t *testing.T) {
		_, err := client.GetSearchesNoResults(client.NewApiGetSearchesNoResultsRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches/noResults")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetStatus(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getStatus with minimal parameters", func(t *testing.T) {
		_, err := client.GetStatus(client.NewApiGetStatusRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/status")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopCountries(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopCountries with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopCountries(client.NewApiGetTopCountriesRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/countries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopCountries with all parameters", func(t *testing.T) {
		_, err := client.GetTopCountries(client.NewApiGetTopCountriesRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/countries")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopFilterAttributes(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopFilterAttributes with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopFilterAttributes(client.NewApiGetTopFilterAttributesRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopFilterAttributes with all parameters", func(t *testing.T) {
		_, err := client.GetTopFilterAttributes(client.NewApiGetTopFilterAttributesRequest(
			"index",
		).WithSearch("mySearch").WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopFilterForAttribute(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopFilterForAttribute with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopFilterForAttribute(client.NewApiGetTopFilterForAttributeRequest(
			"myAttribute", "index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/myAttribute")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopFilterForAttribute with minimal parameters and multiple attributes", func(t *testing.T) {
		_, err := client.GetTopFilterForAttribute(client.NewApiGetTopFilterForAttributeRequest(
			"myAttribute1,myAttribute2", "index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/myAttribute1%2CmyAttribute2")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopFilterForAttribute with all parameters", func(t *testing.T) {
		_, err := client.GetTopFilterForAttribute(client.NewApiGetTopFilterForAttributeRequest(
			"myAttribute", "index",
		).WithSearch("mySearch").WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/myAttribute")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopFilterForAttribute with all parameters and multiple attributes", func(t *testing.T) {
		_, err := client.GetTopFilterForAttribute(client.NewApiGetTopFilterForAttributeRequest(
			"myAttribute1,myAttribute2", "index",
		).WithSearch("mySearch").WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/myAttribute1%2CmyAttribute2")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopFiltersNoResults(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopFiltersNoResults with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopFiltersNoResults(client.NewApiGetTopFiltersNoResultsRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/noResults")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopFiltersNoResults with all parameters", func(t *testing.T) {
		_, err := client.GetTopFiltersNoResults(client.NewApiGetTopFiltersNoResultsRequest(
			"index",
		).WithSearch("mySearch").WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/filters/noResults")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","search":"mySearch","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopHits(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopHits with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopHits(client.NewApiGetTopHitsRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/hits")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopHits with all parameters", func(t *testing.T) {
		_, err := client.GetTopHits(client.NewApiGetTopHitsRequest(
			"index",
		).WithSearch("mySearch").WithClickAnalytics(true).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/hits")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","search":"mySearch","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetTopSearches(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getTopSearches with minimal parameters", func(t *testing.T) {
		_, err := client.GetTopSearches(client.NewApiGetTopSearchesRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getTopSearches with all parameters", func(t *testing.T) {
		_, err := client.GetTopSearches(client.NewApiGetTopSearchesRequest(
			"index",
		).WithClickAnalytics(true).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithOrderBy(analytics.OrderBy("searchCount")).WithDirection(analytics.Direction("asc")).WithLimit(21).WithOffset(42).WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/searches")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","clickAnalytics":"true","startDate":"1999-09-19","endDate":"2001-01-01","orderBy":"searchCount","direction":"asc","limit":"21","offset":"42","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestAnalytics_GetUsersCount(t *testing.T) {
	client, echo := createAnalyticsClient()

	t.Run("get getUsersCount with minimal parameters", func(t *testing.T) {
		_, err := client.GetUsersCount(client.NewApiGetUsersCountRequest(
			"index",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/users/count")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("get getUsersCount with all parameters", func(t *testing.T) {
		_, err := client.GetUsersCount(client.NewApiGetUsersCountRequest(
			"index",
		).WithStartDate("1999-09-19").WithEndDate("2001-01-01").WithTags("tag"))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/2/users/count")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"index":"index","startDate":"1999-09-19","endDate":"2001-01-01","tags":"tag"}`), &queryParams))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}
