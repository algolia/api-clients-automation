// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package requests

import (
	"encoding/json"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/usage"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

func createUsageClient(t *testing.T) (*usage.APIClient, *tests.EchoRequester) {
	t.Helper()

	echo := &tests.EchoRequester{}
	cfg := usage.UsageConfiguration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, err := usage.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func TestUsage_CustomDelete(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("allow del method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/test/minimal", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow del method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/test/all", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestUsage_CustomGet(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("allow get method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/test/minimal", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow get method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"test/all",
		).WithParameters(map[string]any{"query": "parameters with space"}))
		require.NoError(t, err)

		require.Equal(t, "/test/all", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters%20with%20space"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions should be escaped too", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"test/all",
		).WithParameters(map[string]any{"query": "to be overriden"}),
			utils.WithQueryParam("query", "parameters with space"), utils.WithQueryParam("and an array",
				[]string{"array", "with spaces"}), utils.WithHeaderParam("x-header-1", "spaces are left alone"),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/all", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		headers := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"x-header-1":"spaces are left alone"}`), &headers))
		for k, v := range headers {
			require.Equal(t, v, echo.Header.Get(k))
		}
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters%20with%20space","and%20an%20array":"array%2Cwith%20spaces"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestUsage_CustomPost(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("allow post method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/test/minimal", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow post method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/test/all", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions can override default query parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("query", "myQueryParameter"),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"myQueryParameter"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions merges query parameters with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("query2", "myQueryParameter"),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","query2":"myQueryParameter"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions can override default headers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithHeaderParam("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
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
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions merges headers with default ones", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithHeaderParam("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
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
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("isItWorking", true),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","isItWorking":"true"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("myParam", 2),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"2"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of string", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("myParam",
				[]string{"b and c", "d"}),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"b%20and%20c%2Cd"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of booleans", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("myParam",
				[]bool{true, true, false}),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"true%2Ctrue%2Cfalse"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
	t.Run("requestOptions queryParameters accepts list of integers", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			utils.WithQueryParam("myParam",
				[]int32{1, 2}),
		)
		require.NoError(t, err)

		require.Equal(t, "/test/requestOptions", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"facet":"filters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters","myParam":"1%2C2"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestUsage_CustomPut(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("allow put method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/test/minimal", echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow put method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/test/all", echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"body":"parameters"}`)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"query":"parameters"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestUsage_GetIndexUsage(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("getIndexUsage with minimal parameters", func(t *testing.T) {
		_, err := client.GetIndexUsage(client.NewApiGetIndexUsageRequest(
			usage.Statistic("queries_operations"), "myIndexName", "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/usage/queries_operations/myIndexName", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"startDate":"2024-04-03T12%3A46%3A43Z","endDate":"2024-04-05T12%3A46%3A43Z"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}

func TestUsage_GetUsage(t *testing.T) {
	client, echo := createUsageClient(t)
	_ = echo

	t.Run("getUsage with minimal parameters", func(t *testing.T) {
		_, err := client.GetUsage(client.NewApiGetUsageRequest(
			usage.Statistic("queries_operations"), "2024-04-03T12:46:43Z", "2024-04-05T12:46:43Z",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/usage/queries_operations", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"startDate":"2024-04-03T12%3A46%3A43Z","endDate":"2024-04-05T12%3A46%3A43Z"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
	})
}
