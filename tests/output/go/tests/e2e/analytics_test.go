// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package requestse2e

import (
	"encoding/json"
	"gotests/tests"
	"os"
	"testing"

	"github.com/kinbiko/jsonassert"
	"github.com/stretchr/testify/require"

	"github.com/joho/godotenv"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
)

func createE2EAnalyticsClient(t *testing.T) *analytics.APIClient {
	t.Helper()

	appID := os.Getenv("ALGOLIA_APPLICATION_ID")
	if appID == "" && os.Getenv("CI") != "true" {
		err := godotenv.Load("../../../../.env")
		require.NoError(t, err)
		appID = os.Getenv("ALGOLIA_APPLICATION_ID")
	}
	apiKey := os.Getenv("ALGOLIA_ADMIN_KEY")
	client, err := analytics.NewClient(appID, apiKey, analytics.US)
	require.NoError(t, err)

	return client
}

func TestAnalyticsE2E_GetTopSearches(t *testing.T) {
	t.Run("e2e with complex query params", func(t *testing.T) {
		client := createE2EAnalyticsClient(t)
		res, err := client.GetTopSearches(client.NewApiGetTopSearchesRequest(
			"cts_e2e_space in index",
		))
		require.NoError(t, err)
		_ = res

		rawBody, err := json.Marshal(res)
		require.NoError(t, err)

		var rawBodyMap any
		err = json.Unmarshal(rawBody, &rawBodyMap)
		require.NoError(t, err)

		expectedBodyRaw := `{"searches":[{"search":"","nbHits":0}]}`
		var expectedBody any
		err = json.Unmarshal([]byte(expectedBodyRaw), &expectedBody)
		require.NoError(t, err)

		unionBody := tests.Union(expectedBody, rawBodyMap)
		unionBodyRaw, err := json.Marshal(unionBody)
		require.NoError(t, err)

		jsonassert.New(t).Assertf(string(unionBodyRaw), expectedBodyRaw)
	})
}