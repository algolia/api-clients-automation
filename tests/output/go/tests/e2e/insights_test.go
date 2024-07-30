// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package e2e

import (
	"encoding/json"
	"gotests/tests"
	"os"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"github.com/joho/godotenv"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/insights"
)

func createE2EInsightsClient(t *testing.T) *insights.APIClient {
	t.Helper()

	appID := os.Getenv("ALGOLIA_APPLICATION_ID")
	if appID == "" && os.Getenv("CI") != "true" {
		err := godotenv.Load("../../../../.env")
		require.NoError(t, err)
		appID = os.Getenv("ALGOLIA_APPLICATION_ID")
	}
	apiKey := os.Getenv("ALGOLIA_ADMIN_KEY")
	client, err := insights.NewClient(appID, apiKey, insights.US)
	require.NoError(t, err)

	return client
}

func TestInsightsE2E_PushEvents(t *testing.T) {
	t.Run("Many events type", func(t *testing.T) {
		client := createE2EInsightsClient(t)
		res, err := client.PushEvents(client.NewApiPushEventsRequest(

			insights.NewEmptyInsightsEvents().SetEvents(
				[]insights.EventsItems{*insights.ConvertedObjectIDsAfterSearchAsEventsItems(
					insights.NewEmptyConvertedObjectIDsAfterSearch().SetEventType(insights.ConversionEvent("conversion")).SetEventName("Product Purchased").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1722124800000).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7")), *insights.ViewedObjectIDsAsEventsItems(
					insights.NewEmptyViewedObjectIDs().SetEventType(insights.ViewEvent("view")).SetEventName("Product Detail Page Viewed").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1722124800000).SetObjectIDs(
						[]string{"9780545139700", "9780439784542"}))}),
		))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `{"message":"OK","status":200}`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jsonassert.New(t).Assertf(string(unionBodyRaw), expectedBodyRaw)
	})
}
