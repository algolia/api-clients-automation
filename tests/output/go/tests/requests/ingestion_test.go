package requests

import (
	"encoding/json"
	"os"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"github.com/joho/godotenv"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createIngestionClient(t *testing.T) (*ingestion.APIClient, *tests.EchoRequester) {
	t.Helper()

	echo := &tests.EchoRequester{}
	cfg := ingestion.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: ingestion.US,
	}
	client, err := ingestion.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func createE2EIngestionClient(t *testing.T) *ingestion.APIClient {
	t.Helper()

	appID := os.Getenv("ALGOLIA_APPLICATION_ID")
	if appID == "" && os.Getenv("CI") != "true" {
		err := godotenv.Load("../../../../.env")
		require.NoError(t, err)
		appID = os.Getenv("ALGOLIA_APPLICATION_ID")
	}
	apiKey := os.Getenv("ALGOLIA_ADMIN_KEY")
	client, err := ingestion.NewClient(appID, apiKey, ingestion.US)
	require.NoError(t, err)

	return client
}

func TestIngestion_CreateAuthentication(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("createAuthenticationOAuth", func(t *testing.T) {
		_, err := client.CreateAuthentication(client.NewApiCreateAuthenticationRequest(

			ingestion.NewEmptyAuthenticationCreate().SetType(ingestion.AuthenticationType("oauth")).SetName("authName").SetInput(ingestion.AuthOAuthAsAuthInput(
				ingestion.NewEmptyAuthOAuth().SetUrl("http://test.oauth").SetClientId("myID").SetClientSecret("mySecret"))),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications", echo.Path)
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

		require.Equal(t, "/1/authentications", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"algolia","name":"authName","input":{"appID":"myappID","apiKey":"randomApiKey"}}`)
	})
}

func TestIngestion_CreateDestination(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("createDestination", func(t *testing.T) {
		_, err := client.CreateDestination(client.NewApiCreateDestinationRequest(

			ingestion.NewEmptyDestinationCreate().SetType(ingestion.DestinationType("search")).SetName("destinationName").SetInput(ingestion.DestinationIndexPrefixAsDestinationInput(
				ingestion.NewEmptyDestinationIndexPrefix().SetIndexPrefix("prefix_"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/destinations", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"search","name":"destinationName","input":{"indexPrefix":"prefix_"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}`)
	})
}

func TestIngestion_CreateSource(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("createSource", func(t *testing.T) {
		_, err := client.CreateSource(client.NewApiCreateSourceRequest(

			ingestion.NewEmptySourceCreate().SetType(ingestion.SourceType("commercetools")).SetName("sourceName").SetInput(ingestion.SourceCommercetoolsAsSourceInput(
				ingestion.NewEmptySourceCommercetools().SetStoreKeys(
					[]string{"myStore"}).SetLocales(
					[]string{"de"}).SetUrl("http://commercetools.com").SetProjectKey("keyID"))).SetAuthenticationID("6c02aeb1-775e-418e-870b-1faccd4b2c0f"),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"type":"commercetools","name":"sourceName","input":{"storeKeys":["myStore"],"locales":["de"],"url":"http://commercetools.com","projectKey":"keyID"},"authenticationID":"6c02aeb1-775e-418e-870b-1faccd4b2c0f"}`)
	})
}

func TestIngestion_CreateTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("createTaskOnDemand", func(t *testing.T) {
		_, err := client.CreateTask(client.NewApiCreateTaskRequest(

			ingestion.NewEmptyTaskCreate().SetSourceID("search").SetDestinationID("destinationName").SetTrigger(ingestion.OnDemandTriggerInputAsTaskCreateTrigger(
				ingestion.NewEmptyOnDemandTriggerInput().SetType(ingestion.OnDemandTriggerType("onDemand")))).SetAction(ingestion.ActionType("replace")),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks", echo.Path)
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

		require.Equal(t, "/1/tasks", echo.Path)
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

		require.Equal(t, "/1/tasks", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceID":"search","destinationID":"destinationName","trigger":{"type":"onDemand"},"action":"replace"}`)
	})
}

func TestIngestion_CustomDelete(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("allow del method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/test/minimal", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow del method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomDelete(client.NewApiCustomDeleteRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/1/test/all", echo.Path)
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

func TestIngestion_CustomGet(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("allow get method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/test/minimal", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("allow get method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomGet(client.NewApiCustomGetRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters with space"}))
		require.NoError(t, err)

		require.Equal(t, "/1/test/all", echo.Path)
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
			"/test/all",
		).WithParameters(map[string]any{"query": "to be overriden"}),
			ingestion.QueryParamOption("query", "parameters with space"), ingestion.QueryParamOption("and an array",
				[]string{"array", "with spaces"}), ingestion.HeaderParamOption("x-header-1", "spaces are left alone"),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/all", echo.Path)
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

func TestIngestion_CustomPost(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("allow post method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/test/minimal", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow post method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPost(client.NewApiCustomPostRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/1/test/all", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("query", "myQueryParameter"),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("query2", "myQueryParameter"),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.HeaderParamOption("x-algolia-api-key", "myApiKey"),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("isItWorking", true),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("myParam", 2),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("myParam",
				[]string{"b and c", "d"}),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("myParam",
				[]bool{true, true, false}),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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
			"/test/requestOptions",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"facet": "filters"}),
			ingestion.QueryParamOption("myParam",
				[]int32{1, 2}),
		)
		require.NoError(t, err)

		require.Equal(t, "/1/test/requestOptions", echo.Path)
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

func TestIngestion_CustomPut(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("allow put method for a custom path with minimal parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/minimal",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/test/minimal", echo.Path)
		require.Equal(t, "PUT", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{}`)
	})
	t.Run("allow put method for a custom path with all parameters", func(t *testing.T) {
		_, err := client.CustomPut(client.NewApiCustomPutRequest(
			"/test/all",
		).WithParameters(map[string]any{"query": "parameters"}).WithBody(map[string]any{"body": "parameters"}))
		require.NoError(t, err)

		require.Equal(t, "/1/test/all", echo.Path)
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

func TestIngestion_DeleteAuthentication(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("deleteAuthentication", func(t *testing.T) {
		_, err := client.DeleteAuthentication(client.NewApiDeleteAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteDestination(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("deleteDestination", func(t *testing.T) {
		_, err := client.DeleteDestination(client.NewApiDeleteDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteSource(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("deleteSource", func(t *testing.T) {
		_, err := client.DeleteSource(client.NewApiDeleteSourceRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DeleteTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("deleteTask", func(t *testing.T) {
		_, err := client.DeleteTask(client.NewApiDeleteTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "DELETE", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_DisableTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("disableTask", func(t *testing.T) {
		_, err := client.DisableTask(client.NewApiDisableTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/disable", echo.Path)
		require.Equal(t, "PUT", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_EnableTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("enable task e2e", func(t *testing.T) {
		_, err := client.EnableTask(client.NewApiEnableTaskRequest(
			"76ab4c2a-ce17-496f-b7a6-506dc59ee498",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/76ab4c2a-ce17-496f-b7a6-506dc59ee498/enable", echo.Path)
		require.Equal(t, "PUT", echo.Method)

		require.Empty(t, echo.Body)
		clientE2E := createE2EIngestionClient(t)
		res, err := clientE2E.EnableTask(client.NewApiEnableTaskRequest(
			"76ab4c2a-ce17-496f-b7a6-506dc59ee498",
		))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498"}`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jaE2E := jsonassert.New(t)
		jaE2E.Assertf(expectedBodyRaw, string(unionBodyRaw))
	})
}

func TestIngestion_GetAuthentication(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getAuthentication", func(t *testing.T) {
		_, err := client.GetAuthentication(client.NewApiGetAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetAuthentications(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getAuthentications", func(t *testing.T) {
		_, err := client.GetAuthentications(client.NewApiGetAuthenticationsRequest())
		require.NoError(t, err)

		require.Equal(t, "/1/authentications", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
	t.Run("getAuthentications with query params", func(t *testing.T) {
		_, err := client.GetAuthentications(client.NewApiGetAuthenticationsRequest().WithItemsPerPage(10).WithPage(1).WithType(
			[]ingestion.AuthenticationType{ingestion.AuthenticationType("basic"), ingestion.AuthenticationType("algolia")}).WithPlatform(
			[]ingestion.PlatformWithNone{*ingestion.PlatformNoneAsPlatformWithNone(ingestion.PlatformNone("none"))}).WithSort(ingestion.AuthenticationSortKeys("createdAt")).WithOrder(ingestion.OrderKeys("desc")))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		queryParams := map[string]string{}
		require.NoError(t, json.Unmarshal([]byte(`{"itemsPerPage":"10","page":"1","type":"basic%2Calgolia","platform":"none","sort":"createdAt","order":"desc"}`), &queryParams))
		require.Len(t, queryParams, len(echo.Query))
		for k, v := range queryParams {
			require.Equal(t, v, echo.Query.Get(k))
		}
		clientE2E := createE2EIngestionClient(t)
		res, err := clientE2E.GetAuthentications(client.NewApiGetAuthenticationsRequest().WithItemsPerPage(10).WithPage(1).WithType(
			[]ingestion.AuthenticationType{ingestion.AuthenticationType("basic"), ingestion.AuthenticationType("algolia")}).WithPlatform(
			[]ingestion.PlatformWithNone{*ingestion.PlatformNoneAsPlatformWithNone(ingestion.PlatformNone("none"))}).WithSort(ingestion.AuthenticationSortKeys("createdAt")).WithOrder(ingestion.OrderKeys("desc")))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `{"pagination":{"page":1,"itemsPerPage":10},"authentications":[{"authenticationID":"b57a7ea5-8592-493b-b75b-6c66d77aee7f","type":"algolia","name":"Auto-generated Authentication for T8JK9S7I7X - 1704732447751","input":{},"createdAt":"2024-01-08T16:47:31Z","updatedAt":"2024-01-08T16:47:31Z"},{},{},{},{},{},{},{}]}`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jaE2E := jsonassert.New(t)
		jaE2E.Assertf(expectedBodyRaw, string(unionBodyRaw))
	})
}

func TestIngestion_GetDestination(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getDestination", func(t *testing.T) {
		_, err := client.GetDestination(client.NewApiGetDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetDestinations(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getDestinations", func(t *testing.T) {
		_, err := client.GetDestinations(client.NewApiGetDestinationsRequest())
		require.NoError(t, err)

		require.Equal(t, "/1/destinations", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetDockerSourceStreams(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getDockerSourceStreams", func(t *testing.T) {
		_, err := client.GetDockerSourceStreams(client.NewApiGetDockerSourceStreamsRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetEvent(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getEvent", func(t *testing.T) {
		_, err := client.GetEvent(client.NewApiGetEventRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "6c02aeb1-775e-418e-870b-1faccd4b2c0c",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events/6c02aeb1-775e-418e-870b-1faccd4b2c0c", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetEvents(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getEvents", func(t *testing.T) {
		_, err := client.GetEvents(client.NewApiGetEventsRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f/events", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetRun(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getRun", func(t *testing.T) {
		_, err := client.GetRun(client.NewApiGetRunRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/runs/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetRuns(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getRuns", func(t *testing.T) {
		_, err := client.GetRuns(client.NewApiGetRunsRequest())
		require.NoError(t, err)

		require.Equal(t, "/1/runs", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetSource(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getSource", func(t *testing.T) {
		_, err := client.GetSource(client.NewApiGetSourceRequest(
			"75eeb306-51d3-4e5e-a279-3c92bd8893ac",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/75eeb306-51d3-4e5e-a279-3c92bd8893ac", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
		clientE2E := createE2EIngestionClient(t)
		res, err := clientE2E.GetSource(client.NewApiGetSourceRequest(
			"75eeb306-51d3-4e5e-a279-3c92bd8893ac",
		))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `{"sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","name":"cts_e2e_browse","type":"json","input":{"url":"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json"}}`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jaE2E := jsonassert.New(t)
		jaE2E.Assertf(expectedBodyRaw, string(unionBodyRaw))
	})
}

func TestIngestion_GetSources(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getSources", func(t *testing.T) {
		_, err := client.GetSources(client.NewApiGetSourcesRequest())
		require.NoError(t, err)

		require.Equal(t, "/1/sources", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getTask", func(t *testing.T) {
		_, err := client.GetTask(client.NewApiGetTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_GetTasks(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("getTasks", func(t *testing.T) {
		_, err := client.GetTasks(client.NewApiGetTasksRequest())
		require.NoError(t, err)

		require.Equal(t, "/1/tasks", echo.Path)
		require.Equal(t, "GET", echo.Method)

		require.Nil(t, echo.Body)
	})
}

func TestIngestion_RunTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("runTask", func(t *testing.T) {
		_, err := client.RunTask(client.NewApiRunTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f/run", echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_SearchAuthentications(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("searchAuthentications", func(t *testing.T) {
		_, err := client.SearchAuthentications(client.NewApiSearchAuthenticationsRequest(

			ingestion.NewEmptyAuthenticationSearch().SetAuthenticationIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications/search", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"authenticationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchDestinations(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("searchDestinations", func(t *testing.T) {
		_, err := client.SearchDestinations(client.NewApiSearchDestinationsRequest(

			ingestion.NewEmptyDestinationSearch().SetDestinationIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/destinations/search", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"destinationIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchSources(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("searchSources", func(t *testing.T) {
		_, err := client.SearchSources(client.NewApiSearchSourcesRequest(

			ingestion.NewEmptySourceSearch().SetSourceIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a"}),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/search", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"sourceIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a"]}`)
	})
}

func TestIngestion_SearchTasks(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("searchTasks", func(t *testing.T) {
		_, err := client.SearchTasks(client.NewApiSearchTasksRequest(

			ingestion.NewEmptyTaskSearch().SetTaskIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"}),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/search", echo.Path)
		require.Equal(t, "POST", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"taskIDs":["6c02aeb1-775e-418e-870b-1faccd4b2c0f","947ac9c4-7e58-4c87-b1e7-14a68e99699a","76ab4c2a-ce17-496f-b7a6-506dc59ee498"]}`)
		clientE2E := createE2EIngestionClient(t)
		res, err := clientE2E.SearchTasks(client.NewApiSearchTasksRequest(

			ingestion.NewEmptyTaskSearch().SetTaskIDs(
				[]string{"6c02aeb1-775e-418e-870b-1faccd4b2c0f", "947ac9c4-7e58-4c87-b1e7-14a68e99699a", "76ab4c2a-ce17-496f-b7a6-506dc59ee498"}),
		))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `[{"taskID":"76ab4c2a-ce17-496f-b7a6-506dc59ee498","sourceID":"75eeb306-51d3-4e5e-a279-3c92bd8893ac","destinationID":"506d79fa-e29d-4bcf-907c-6b6a41172153","trigger":{"type":"onDemand"},"enabled":true,"failureThreshold":0,"action":"replace","createdAt":"2024-01-08T16:47:41Z"}]`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jaE2E := jsonassert.New(t)
		jaE2E.Assertf(expectedBodyRaw, string(unionBodyRaw))
	})
}

func TestIngestion_TriggerDockerSourceDiscover(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("triggerDockerSourceDiscover", func(t *testing.T) {
		_, err := client.TriggerDockerSourceDiscover(client.NewApiTriggerDockerSourceDiscoverRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f/discover", echo.Path)
		require.Equal(t, "POST", echo.Method)

		require.Empty(t, echo.Body)
	})
}

func TestIngestion_UpdateAuthentication(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("updateAuthentication", func(t *testing.T) {
		_, err := client.UpdateAuthentication(client.NewApiUpdateAuthenticationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyAuthenticationUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/authentications/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateDestination(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("updateDestination", func(t *testing.T) {
		_, err := client.UpdateDestination(client.NewApiUpdateDestinationRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyDestinationUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/destinations/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateSource(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("updateSource", func(t *testing.T) {
		_, err := client.UpdateSource(client.NewApiUpdateSourceRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptySourceUpdate().SetName("newName"),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/sources/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"name":"newName"}`)
	})
}

func TestIngestion_UpdateTask(t *testing.T) {
	client, echo := createIngestionClient(t)
	_ = echo

	t.Run("updateTask", func(t *testing.T) {
		_, err := client.UpdateTask(client.NewApiUpdateTaskRequest(
			"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
			ingestion.NewEmptyTaskUpdate().SetEnabled(false),
		))
		require.NoError(t, err)

		require.Equal(t, "/1/tasks/6c02aeb1-775e-418e-870b-1faccd4b2c0f", echo.Path)
		require.Equal(t, "PATCH", echo.Method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.Body, `{"enabled":false}`)
	})
}
