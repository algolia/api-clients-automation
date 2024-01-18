package requests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/personalization"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createPersonalizationClient() (*personalization.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: personalization.US,
	}
	client, _ := personalization.NewClientWithConfig(cfg)

	return client, echo
}

func TestPersonalization_CustomDelete(t *testing.T) {
	client, echo := createPersonalizationClient()

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

func TestPersonalization_CustomGet(t *testing.T) {
	client, echo := createPersonalizationClient()

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

func TestPersonalization_CustomPost(t *testing.T) {
	client, echo := createPersonalizationClient()

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
			personalization.QueryParamOption("query", "myQueryParameter"),
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
			personalization.QueryParamOption("query2", "myQueryParameter"),
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
			personalization.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			personalization.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			personalization.QueryParamOption("isItWorking", true),
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
			personalization.QueryParamOption("myParam", 2),
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
			personalization.QueryParamOption("myParam",
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
			personalization.QueryParamOption("myParam",
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
			personalization.QueryParamOption("myParam",
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

func TestPersonalization_CustomPut(t *testing.T) {
	client, echo := createPersonalizationClient()

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

func TestPersonalization_DeleteUserProfile(t *testing.T) {
	client, echo := createPersonalizationClient()

	t.Run("delete deleteUserProfile", func(t *testing.T) {
		_, err := client.DeleteUserProfile(client.NewApiDeleteUserProfileRequest(
			"UserToken",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/profiles/UserToken")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestPersonalization_GetPersonalizationStrategy(t *testing.T) {
	client, echo := createPersonalizationClient()

	t.Run("get getPersonalizationStrategy", func(t *testing.T) {
		_, err := client.GetPersonalizationStrategy()
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/strategies/personalization")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestPersonalization_GetUserTokenProfile(t *testing.T) {
	client, echo := createPersonalizationClient()

	t.Run("get getUserTokenProfile", func(t *testing.T) {
		_, err := client.GetUserTokenProfile(client.NewApiGetUserTokenProfileRequest(
			"UserToken",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/profiles/personalization/UserToken")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestPersonalization_SetPersonalizationStrategy(t *testing.T) {
	client, echo := createPersonalizationClient()

	t.Run("set setPersonalizationStrategy", func(t *testing.T) {
		_, err := client.SetPersonalizationStrategy(client.NewApiSetPersonalizationStrategyRequest(

			personalization.NewEmptyPersonalizationStrategyParams().SetEventScoring(
				[]personalization.EventScoring{*personalization.NewEmptyEventScoring().SetScore(42).SetEventName("Algolia").SetEventType("Event")}).SetFacetScoring(
				[]personalization.FacetScoring{*personalization.NewEmptyFacetScoring().SetScore(42).SetFacetName("Event")}).SetPersonalizationImpact(42),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/strategies/personalization")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"eventScoring":[{"score":42,"eventName":"Algolia","eventType":"Event"}],"facetScoring":[{"score":42,"facetName":"Event"}],"personalizationImpact":42}`)
	})
}
