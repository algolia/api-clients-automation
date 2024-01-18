package requests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createIngestionClient() (*ingestion.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := ingestion.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: ingestion.US,
	}
	client, _ := ingestion.NewClientWithConfig(cfg)

	return client, echo
}

func TestIngestion_CreateAuthentication(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("createAuthenticationOAuth", func(t *testing.T) {
		_, err := client.CreateAuthentication(client.NewApiCreateAuthenticationRequest(

			ingestion.NewEmptyAuthenticationCreate().SetType(ingestion.AuthenticationType("oauth")).SetName("authName").SetInput(ingestion.AuthOAuthAsAuthInput(
				ingestion.NewEmptyAuthOAuth().SetUrl("http://test.oauth").SetClientId("myID").SetClientSecret("mySecret"))),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"oauth","name":"authName","input":{"url":"http://test.oauth","client_id":"myID","client_secret":"mySecret"}}`)
	})
	t.Run("createAuthenticationAlgolia", func(t *testing.T) {
		_, err := client.CreateAuthentication(client.NewApiCreateAuthenticationRequest(

			ingestion.NewEmptyAuthenticationCreate().SetType(ingestion.AuthenticationType("algolia")).SetName("authName").SetInput(ingestion.AuthAlgoliaAsAuthInput(
				ingestion.NewEmptyAuthAlgolia().SetAppID("myappID").SetApiKey("randomApiKey"))),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"algolia","name":"authName","input":{"appID":"myappID","apiKey":"randomApiKey"}}`)
	})
}

func TestIngestion_CreateDestination(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("createDestination", func(t *testing.T) {
		_, err := client.CreateDestination(client.NewApiCreateDestinationRequest(

			ingestion.NewEmptyDestinationCreate().SetType(ingestion.DestinationType("search")).SetName("destinationName").SetInput(ingestion.DestinationIndexPrefixAsDestinationInput(
				ingestion.NewEmptyDestinationIndexPrefix().SetIndexPrefix("prefix_"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"search","name":"destinationName","input":{"indexPrefix":"prefix_"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}`)
	})
}

func TestIngestion_CreateSource(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("createSource", func(t *testing.T) {
		_, err := client.CreateSource(client.NewApiCreateSourceRequest(

			ingestion.NewEmptySourceCreate().SetType(ingestion.SourceType("commercetools")).SetName("sourceName").SetInput(ingestion.SourceCommercetoolsAsSourceInput(
				ingestion.NewEmptySourceCommercetools().SetStoreKeys(
					[]string{"myStore"}).SetLocales(
					[]string{"de"}).SetUrl("http://commercetools.com").SetProjectKey("keyID"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"commercetools","name":"sourceName","input":{"storeKeys":["myStore"],"locales":["de"],"url":"http://commercetools.com","projectKey":"keyID"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}`)
	})
}

func TestIngestion_CreateTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("createTaskOnDemand", func(t *testing.T) {
		_, err := client.CreateTask(client.NewApiCreateTaskRequest(

			ingestion.NewEmptyTaskCreate().SetSourceID("search").SetDestinationID("destinationName").SetTrigger(ingestion.OnDemandTriggerInputAsTaskCreateTrigger(
				ingestion.NewEmptyOnDemandTriggerInput().SetType(ingestion.OnDemandTriggerType("onDemand")))).SetAction(ingestion.ActionType("replace")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}`)
	})
	t.Run("createTaskSchedule", func(t *testing.T) {
		_, err := client.CreateTask(client.NewApiCreateTaskRequest(

			ingestion.NewEmptyTaskCreate().SetSourceID("search").SetDestinationID("destinationName").SetTrigger(ingestion.ScheduleTriggerInputAsTaskCreateTrigger(
				ingestion.NewEmptyScheduleTriggerInput().SetType(ingestion.ScheduleTriggerType("schedule")).SetCron("* * * * *"))).SetAction(ingestion.ActionType("replace")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"schedule","cron":"* * * * *"},"action":"replace"}`)
	})
	t.Run("createTaskSubscription", func(t *testing.T) {
		_, err := client.CreateTask(client.NewApiCreateTaskRequest(

			ingestion.NewEmptyTaskCreate().SetSourceID("search").SetDestinationID("destinationName").SetTrigger(ingestion.OnDemandTriggerInputAsTaskCreateTrigger(
				ingestion.NewEmptyOnDemandTriggerInput().SetType(ingestion.OnDemandTriggerType("onDemand")))).SetAction(ingestion.ActionType("replace")),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}`)
	})
}

func TestIngestion_CustomDelete(t *testing.T) {
	client, echo := createIngestionClient()

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

func TestIngestion_CustomGet(t *testing.T) {
	client, echo := createIngestionClient()

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

func TestIngestion_CustomPost(t *testing.T) {
	client, echo := createIngestionClient()

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
			ingestion.QueryParamOption("query", "myQueryParameter"),
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
			ingestion.QueryParamOption("query2", "myQueryParameter"),
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
			ingestion.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			ingestion.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			ingestion.QueryParamOption("isItWorking", true),
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
			ingestion.QueryParamOption("myParam", 2),
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
			ingestion.QueryParamOption("myParam",
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
			ingestion.QueryParamOption("myParam",
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
			ingestion.QueryParamOption("myParam",
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

func TestIngestion_CustomPut(t *testing.T) {
	client, echo := createIngestionClient()

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

func TestIngestion_DeleteAuthentication(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("deleteAuthentication", func(t *testing.T) {
		_, err := client.DeleteAuthentication(client.NewApiDeleteAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteDestination(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("deleteDestination", func(t *testing.T) {
		_, err := client.DeleteDestination(client.NewApiDeleteDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteSource(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("deleteSource", func(t *testing.T) {
		_, err := client.DeleteSource(client.NewApiDeleteSourceRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("deleteTask", func(t *testing.T) {
		_, err := client.DeleteTask(client.NewApiDeleteTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DisableTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("disableTask", func(t *testing.T) {
		_, err := client.DisableTask(client.NewApiDisableTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_EnableTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("enableTask", func(t *testing.T) {
		_, err := client.EnableTask(client.NewApiEnableTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/enable")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PUT", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_GetAuthentication(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getAuthentication", func(t *testing.T) {
		_, err := client.GetAuthentication(client.NewApiGetAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetAuthentications(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getAuthentications", func(t *testing.T) {
		_, err := client.GetAuthentications(client.NewApiGetAuthenticationsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetDestination(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getDestination", func(t *testing.T) {
		_, err := client.GetDestination(client.NewApiGetDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetDestinations(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getDestinations", func(t *testing.T) {
		_, err := client.GetDestinations(client.NewApiGetDestinationsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetDockerSourceStreams(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getDockerSourceStreams", func(t *testing.T) {
		_, err := client.GetDockerSourceStreams(client.NewApiGetDockerSourceStreamsRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetEvent(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getEvent", func(t *testing.T) {
		_, err := client.GetEvent(client.NewApiGetEventRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetEvents(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getEvents", func(t *testing.T) {
		_, err := client.GetEvents(client.NewApiGetEventsRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetRun(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getRun", func(t *testing.T) {
		_, err := client.GetRun(client.NewApiGetRunRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetRuns(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getRuns", func(t *testing.T) {
		_, err := client.GetRuns(client.NewApiGetRunsRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/runs")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetSource(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getSource", func(t *testing.T) {
		_, err := client.GetSource(client.NewApiGetSourceRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetSources(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getSources", func(t *testing.T) {
		_, err := client.GetSources(client.NewApiGetSourcesRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getTask", func(t *testing.T) {
		_, err := client.GetTask(client.NewApiGetTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetTasks(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("getTasks", func(t *testing.T) {
		_, err := client.GetTasks(client.NewApiGetTasksRequest())
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_RunTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("runTask", func(t *testing.T) {
		_, err := client.RunTask(client.NewApiRunTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_SearchAuthentications(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("searchAuthentications", func(t *testing.T) {
		_, err := client.SearchAuthentications(client.NewApiSearchAuthenticationsRequest(

			ingestion.NewEmptyAuthenticationSearch().SetAuthenticationIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"authenticationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchDestinations(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("searchDestinations", func(t *testing.T) {
		_, err := client.SearchDestinations(client.NewApiSearchDestinationsRequest(

			ingestion.NewEmptyDestinationSearch().SetDestinationIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"destinationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchSources(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("searchSources", func(t *testing.T) {
		_, err := client.SearchSources(client.NewApiSearchSourcesRequest(

			ingestion.NewEmptySourceSearch().SetSourceIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchTasks(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("searchTasks", func(t *testing.T) {
		_, err := client.SearchTasks(client.NewApiSearchTasksRequest(

			ingestion.NewEmptyTaskSearch().SetTaskIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/search")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"taskIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_TriggerDockerSourceDiscover(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("triggerDockerSourceDiscover", func(t *testing.T) {
		_, err := client.TriggerDockerSourceDiscover(client.NewApiTriggerDockerSourceDiscoverRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_UpdateAuthentication(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("updateAuthentication", func(t *testing.T) {
		_, err := client.UpdateAuthentication(client.NewApiUpdateAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyAuthenticationUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateDestination(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("updateDestination", func(t *testing.T) {
		_, err := client.UpdateDestination(client.NewApiUpdateDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyDestinationUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateSource(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("updateSource", func(t *testing.T) {
		_, err := client.UpdateSource(client.NewApiUpdateSourceRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptySourceUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateTask(t *testing.T) {
	client, echo := createIngestionClient()

	t.Run("updateTask", func(t *testing.T) {
		_, err := client.UpdateTask(client.NewApiUpdateTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyTaskUpdate().SetEnabled(false),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"enabled":false}`)
	})
}
