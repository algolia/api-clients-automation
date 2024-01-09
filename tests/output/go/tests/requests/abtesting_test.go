package tests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting"
)

func createAbtestingClient() (*abtesting.APIClient, *echoRequester) {
	echo := &echoRequester{}
	cfg := abtesting.Configuration{
		AppID:     "appID",
		ApiKey:    "apiKey",
		Region:    abtesting.US,
		Requester: echo,
	}
	client := abtesting.NewClientWithConfig(cfg)

	// so that the linter doesn't complain
	_ = jsonassert.New(nil)

	return client, echo
}

func TestAbtesting_AddABTests(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "addABTests with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}`
				req := abtesting.ApiAddABTestsRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.AddABTests(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "POST", echo.method)

				ja := jsonassert.New(t)
				ja.Assertf(*echo.body, `{"endAt":"2022-12-31T00:00:00.000Z","name":"myABTest","variants":[{"index":"AB_TEST_1","trafficPercentage":30},{"index":"AB_TEST_2","trafficPercentage":50}]}`)
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_CustomDelete(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "allow del method for a custom path with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/minimal"}`
				req := abtesting.ApiCustomDeleteRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomDelete(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/1/test/minimal")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "DELETE", echo.method)

				require.Nil(t, echo.body)
			},
		},
		{
			name: "allow del method for a custom path with all parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/all","parameters":{"query":"parameters"}}`
				req := abtesting.ApiCustomDeleteRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomDelete(req)
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
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_CustomGet(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "allow get method for a custom path with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/minimal"}`
				req := abtesting.ApiCustomGetRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomGet(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/1/test/minimal")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "GET", echo.method)

				require.Nil(t, echo.body)
			},
		},
		{
			name: "allow get method for a custom path with all parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/all","parameters":{"query":"parameters"}}`
				req := abtesting.ApiCustomGetRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomGet(req)
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
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_CustomPost(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "allow post method for a custom path with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/minimal"}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomPost(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/1/test/minimal")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "POST", echo.method)

				ja := jsonassert.New(t)
				ja.Assertf(*echo.body, `{}`)
			},
		},
		{
			name: "allow post method for a custom path with all parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/all","parameters":{"query":"parameters"},"body":{"body":"parameters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomPost(req)
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
			},
		},
		{
			name: "requestOptions can override default query parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"query":"myQueryParameter"}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions merges query parameters with default ones",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"query2":"myQueryParameter"}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions can override default headers",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionHeaders := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &requestOptionHeaders))
				for k, v := range requestOptionHeaders {
					opts = append(opts, abtesting.HeaderParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions merges headers with default ones",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionHeaders := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"x-algolia-api-key":"myApiKey"}`), &requestOptionHeaders))
				for k, v := range requestOptionHeaders {
					opts = append(opts, abtesting.HeaderParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions queryParameters accepts booleans",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"isItWorking":true}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions queryParameters accepts integers",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"myParam":2}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions queryParameters accepts list of string",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"myParam":["c","d"]}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions queryParameters accepts list of booleans",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"myParam":[true,true,false]}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
		{
			name: "requestOptions queryParameters accepts list of integers",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/requestOptions","parameters":{"query":"parameters"},"body":{"facet":"filters"}}`
				req := abtesting.ApiCustomPostRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				var opts []abtesting.Option
				requestOptionParameters := map[string]any{}
				require.NoError(t, json.Unmarshal([]byte(`{"myParam":[1,2]}`), &requestOptionParameters))
				for k, v := range requestOptionParameters {
					opts = append(opts, abtesting.QueryParamOption(k, v))
				}
				_, err := client.CustomPost(req, opts...)
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
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_CustomPut(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "allow put method for a custom path with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/minimal"}`
				req := abtesting.ApiCustomPutRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomPut(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/1/test/minimal")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "PUT", echo.method)

				ja := jsonassert.New(t)
				ja.Assertf(*echo.body, `{}`)
			},
		},
		{
			name: "allow put method for a custom path with all parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"path":"/test/all","parameters":{"query":"parameters"},"body":{"body":"parameters"}}`
				req := abtesting.ApiCustomPutRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.CustomPut(req)
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
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_DeleteABTest(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "deleteABTest",
			testFunc: func(t *testing.T) {
				parametersStr := `{"id":42}`
				req := abtesting.ApiDeleteABTestRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.DeleteABTest(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests/42")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "DELETE", echo.method)

				require.Nil(t, echo.body)
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_GetABTest(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "getABTest",
			testFunc: func(t *testing.T) {
				parametersStr := `{"id":42}`
				req := abtesting.ApiGetABTestRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.GetABTest(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests/42")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "GET", echo.method)

				require.Nil(t, echo.body)
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_ListABTests(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "listABTests with minimal parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{}`
				req := abtesting.ApiListABTestsRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.ListABTests(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "GET", echo.method)

				require.Nil(t, echo.body)
			},
		},
		{
			name: "listABTests with parameters",
			testFunc: func(t *testing.T) {
				parametersStr := `{"offset":42,"limit":21,"indexPrefix":"foo","indexSuffix":"bar"}`
				req := abtesting.ApiListABTestsRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.ListABTests(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "GET", echo.method)

				require.Nil(t, echo.body)
				queryParams := map[string]string{}
				require.NoError(t, json.Unmarshal([]byte(`{"offset":"42","limit":"21","indexPrefix":"foo","indexSuffix":"bar"}`), &queryParams))
				for k, v := range queryParams {
					require.Equal(t, v, echo.query.Get(k))
				}
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}

func TestAbtesting_StopABTest(t *testing.T) {
	client, echo := createAbtestingClient()

	tests := []struct {
		name     string
		testFunc func(t *testing.T)
	}{
		{
			name: "stopABTest",
			testFunc: func(t *testing.T) {
				parametersStr := `{"id":42}`
				req := abtesting.ApiStopABTestRequest{}
				require.NoError(t, json.Unmarshal([]byte(parametersStr), &req))
				_, err := client.StopABTest(req)
				require.NoError(t, err)

				expectedPath, err := url.QueryUnescape("/2/abtests/42/stop")
				require.NoError(t, err)
				require.Equal(t, expectedPath, echo.path)
				require.Equal(t, "POST", echo.method)

				require.Empty(t, echo.body)
			},
		},
	}
	for _, test := range tests {
		test := test
		t.Run(test.name, func(t *testing.T) {
			test.testFunc(t)
		})
	}
}
