package tests

import (
	"encoding/json"
	"net/url"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/insights"
)

func createInsightsClient() (*insights.APIClient, *echoRequester) {
	echo := &echoRequester{}
	cfg := insights.Configuration{
		AppID:     "appID",
		ApiKey:    "apiKey",
		Region:    insights.US,
		Requester: echo,
	}
	client := insights.NewClientWithConfig(cfg)

	// so that the linter doesn't complain
	_ = jsonassert.New(nil)

	return client, echo
}

func TestInsights_CustomDelete(t *testing.T) {
	client, echo := createInsightsClient()

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

func TestInsights_CustomGet(t *testing.T) {
	client, echo := createInsightsClient()

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

func TestInsights_CustomPost(t *testing.T) {
	client, echo := createInsightsClient()

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
			insights.QueryParamOption("query", "myQueryParameter"),
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
			insights.QueryParamOption("query2", "myQueryParameter"),
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
			insights.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			insights.HeaderParamOption("x-algolia-api-key", "myApiKey"),
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
			insights.QueryParamOption("isItWorking", true),
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
			insights.QueryParamOption("myParam", 2),
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
			insights.QueryParamOption("myParam",
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
			insights.QueryParamOption("myParam",
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
			insights.QueryParamOption("myParam",
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

func TestInsights_CustomPut(t *testing.T) {
	client, echo := createInsightsClient()

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

func TestInsights_DeleteUserToken(t *testing.T) {
	client, echo := createInsightsClient()

	t.Run("deleteUserToken0", func(t *testing.T) {
		err := client.DeleteUserToken(client.NewApiDeleteUserTokenRequest(
			"test-user-1",
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/usertokens/test-user-1")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "DELETE", echo.method)

		require.Nil(t, echo.body)
	})
}

func TestInsights_PushEvents(t *testing.T) {
	client, echo := createInsightsClient()

	t.Run("pushEvents0", func(t *testing.T) {
		_, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.ClickedObjectIDsAfterSearchAsEventsItems(
					insights.NewEmptyClickedObjectIDsAfterSearch().SetEventType(insights.ClickEvent("click")).SetEventName("Product Clicked").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetPositions(
						[]int32{7, 6}))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"events":[{"eventType":"click","eventName":"Product Clicked","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7","positions":[7,6]}]}`)
	})
	t.Run("Many events type", func(t *testing.T) {
		_, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.ConvertedObjectIDsAfterSearchAsEventsItems(
					insights.NewEmptyConvertedObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventName("Product Purchased").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7")), *insights.ViewedObjectIDsAsEventsItems(
					insights.NewEmptyViewedObjectIDs().SetEventType(insights.ViewEvent("view")).SetEventName("Product Detail Page Viewed").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"},{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}`)
	})
	t.Run("ConvertedObjectIDsAfterSearch", func(t *testing.T) {
		_, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.ConvertedObjectIDsAfterSearchAsEventsItems(
					insights.NewEmptyConvertedObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventName("Product Purchased").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"events":[{"eventType":"conversion","eventName":"Product Purchased","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"queryID":"43b15df305339e827f0ac0bdc5ebcaa7"}]}`)
	})
	t.Run("ViewedObjectIDs", func(t *testing.T) {
		_, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.ViewedObjectIDsAsEventsItems(
					insights.NewEmptyViewedObjectIDs().SetEventType(insights.ViewEvent("view")).SetEventName("Product Detail Page Viewed").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"events":[{"eventType":"view","eventName":"Product Detail Page Viewed","index":"products","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"]}]}`)
	})
	t.Run("AddedToCartObjectIDs", func(t *testing.T) {
		_, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.AddedToCartObjectIDsAfterSearchAsEventsItems(
					insights.NewEmptyAddedToCartObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventSubtype(insights.AddToCartEvent("addToCart")).SetEventName("Product Added To Cart").SetIndex("products").SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}).SetObjectData(
						[]insights.ObjectDataAfterSearch{*insights.NewEmptyObjectDataAfterSearch().SetPrice(insights.Float64AsPrice(19.99)).SetQuantity(10).SetDiscount(insights.Float64AsDiscount(2.5)), *insights.NewEmptyObjectDataAfterSearch().SetPrice(insights.StringAsPrice("8$")).SetQuantity(7).SetDiscount(insights.StringAsDiscount("30%"))}).SetCurrency("USD"))}),
		))
		require.NoError(t, err)

		expectedPath, err := url.QueryUnescape("/1/events")
		require.NoError(t, err)
		require.Equal(t, expectedPath, echo.path)
		require.Equal(t, "POST", echo.method)

		ja := jsonassert.New(t)
		ja.Assertf(*echo.body, `{"events":[{"eventType":"conversion","eventSubtype":"addToCart","eventName":"Product Added To Cart","index":"products","queryID":"43b15df305339e827f0ac0bdc5ebcaa7","userToken":"user-123456","authenticatedUserToken":"user-123456","timestamp":1641290601962,"objectIDs":["9780545139700","9780439784542"],"objectData":[{"price":19.99,"quantity":10,"discount":2.5},{"price":"8$","quantity":7,"discount":"30%%"}],"currency":"USD"}]}`)
	})
}
