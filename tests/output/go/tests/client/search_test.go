// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"encoding/json"
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/compression"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

func createSearchClient(t *testing.T) (*search.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, err := search.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// calls api with correct read host
func TestSearchapi0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"test",
	))
	require.NoError(t, err)
	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

// calls api with correct write host
func TestSearchapi1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"test",
	))
	require.NoError(t, err)
	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

// tests the retry strategy
func TestSearchapi2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", "localhost:6677", call.IsReadWrite), transport.NewStatefulHost("http", "localhost:6678", call.IsReadWrite)},
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err := client.CustomGet(client.NewApiCustomGetRequest(
		"1/test/retry",
	))
	require.NoError(t, err)
	rawBody, err := json.Marshal(res)
	require.NoError(t, err)
	require.JSONEq(t, `{"message":"ok test server response"}`, string(rawBody))
}

// test the compression strategy
func TestSearchapi3(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:       "test-app-id",
			ApiKey:      "test-api-key",
			Hosts:       []transport.StatefulHost{transport.NewStatefulHost("http", "localhost:6678", call.IsReadWrite)},
			Compression: compression.GZIP,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err := client.CustomPost(client.NewApiCustomPostRequest(
		"1/test/gzip",
	).WithParameters(map[string]any{}).WithBody(map[string]any{"message": "this is a compressed body"}))
	require.NoError(t, err)
	rawBody, err := json.Marshal(res)
	require.NoError(t, err)
	require.JSONEq(t, `{"message":"ok compression test server response","body":{"message":"this is a compressed body"}}`, string(rawBody))
}

// calls api with correct user agent
func TestSearchcommonApi0(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestSearchcommonApi1(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestSearchcommonApi2(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// generate secured api key basic
func TestSearchhelpers0(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	res, err := client.GenerateSecuredApiKey(
		"2640659426d5107b6e47d75db9cbaef8",
		search.NewEmptySecuredApiKeyRestrictions().SetValidUntil(2524604400).SetRestrictIndices(
			[]string{"Movies"}),
	)
	require.NoError(t, err)
	require.Equal(t, `NjFhZmE0OGEyMTI3OThiODc0OTlkOGM0YjcxYzljY2M2NmU2NDE5ZWY0NDZjMWJhNjA2NzBkMjAwOTI2YWQyZnJlc3RyaWN0SW5kaWNlcz1Nb3ZpZXMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw`, res)
}

// generate secured api key with searchParams
func TestSearchhelpers1(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	res, err := client.GenerateSecuredApiKey(
		"2640659426d5107b6e47d75db9cbaef8",
		search.NewEmptySecuredApiKeyRestrictions().SetValidUntil(2524604400).SetRestrictIndices(
			[]string{"Movies", "cts_e2e_settings"}).SetRestrictSources("192.168.1.0/24").SetFilters("category:Book OR category:Ebook AND _tags:published").SetUserToken("user123").SetSearchParams(
			search.NewEmptySearchParamsObject().SetQuery("batman").SetTypoTolerance(search.TypoToleranceEnumAsTypoTolerance(search.TypoToleranceEnum("strict"))).SetAroundRadius(search.AroundRadiusAllAsAroundRadius(search.AroundRadiusAll("all"))).SetMode(search.Mode("neuralSearch")).SetHitsPerPage(10).SetOptionalWords(
				[]string{"one", "two"})),
	)
	require.NoError(t, err)
	require.Equal(t, `MzAxMDUwYjYyODMxODQ3ZWM1ZDYzNTkxZmNjNDg2OGZjMjAzYjQyOTZhMGQ1NDJhMDFiNGMzYTYzODRhNmMxZWFyb3VuZFJhZGl1cz1hbGwmZmlsdGVycz1jYXRlZ29yeSUzQUJvb2slMjBPUiUyMGNhdGVnb3J5JTNBRWJvb2slMjBBTkQlMjBfdGFncyUzQXB1Ymxpc2hlZCZoaXRzUGVyUGFnZT0xMCZtb2RlPW5ldXJhbFNlYXJjaCZvcHRpb25hbFdvcmRzPW9uZSUyQ3R3byZxdWVyeT1iYXRtYW4mcmVzdHJpY3RJbmRpY2VzPU1vdmllcyUyQ2N0c19lMmVfc2V0dGluZ3MmcmVzdHJpY3RTb3VyY2VzPTE5Mi4xNjguMS4wJTJGMjQmdHlwb1RvbGVyYW5jZT1zdHJpY3QmdXNlclRva2VuPXVzZXIxMjMmdmFsaWRVbnRpbD0yNTI0NjA0NDAw`, res)
}

// call replaceAllObjects without error
func TestSearchhelpers2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", "localhost:6679", call.IsReadWrite)},
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err := client.ReplaceAllObjects(
		"cts_e2e_replace_all_objects_Go",
		[]map[string]any{map[string]any{"objectID": "1", "name": "Adam"}, map[string]any{"objectID": "2", "name": "Benoit"}, map[string]any{"objectID": "3", "name": "Cyril"}, map[string]any{"objectID": "4", "name": "David"}, map[string]any{"objectID": "5", "name": "Eva"}, map[string]any{"objectID": "6", "name": "Fiona"}, map[string]any{"objectID": "7", "name": "Gael"}, map[string]any{"objectID": "8", "name": "Hugo"}, map[string]any{"objectID": "9", "name": "Igor"}, map[string]any{"objectID": "10", "name": "Julia"}},
		utils.ToPtr(3))
	require.NoError(t, err)
	rawBody, err := json.Marshal(res)
	require.NoError(t, err)
	require.JSONEq(t, `{"copyOperationResponse":{"taskID":125,"updatedAt":"2021-01-01T00:00:00.000Z"},"batchResponses":[{"taskID":127,"objectIDs":["1","2","3"]},{"taskID":130,"objectIDs":["4","5","6"]},{"taskID":133,"objectIDs":["7","8","9"]},{"taskID":134,"objectIDs":["10"]}],"moveOperationResponse":{"taskID":777,"updatedAt":"2021-01-01T00:00:00.000Z"}}`, string(rawBody))
}

// client throws with invalid parameters
func TestSearchparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.SearchConfiguration
	_ = client
	_ = echo
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "",
			ApiKey:    "",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`appId` is missing.")
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`appId` is missing.")
	cfg = search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`apiKey` is missing.")
}

// &#x60;addApiKey&#x60; throws with invalid parameters
func TestSearchparameters1(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.AddApiKey(client.NewApiAddApiKeyRequest(
		tests.ZeroValue[*search.ApiKey](),
	))
	require.EqualError(t, err, "Parameter `apiKey` is required when calling `AddApiKey`.")
}

// &#x60;addOrUpdateObject&#x60; throws with invalid parameters
func TestSearchparameters2(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		tests.ZeroValue[string](), "my-object-id", map[string]any{},
	))
	require.EqualError(t, err, "Parameter `indexName` is required when calling `AddOrUpdateObject`.")
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		"my-index-name", tests.ZeroValue[string](), map[string]any{},
	))
	require.EqualError(t, err, "Parameter `objectID` is required when calling `AddOrUpdateObject`.")
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		"my-index-name", "my-object-id", tests.ZeroValue[map[string]any](),
	))
	require.EqualError(t, err, "Parameter `body` is required when calling `AddOrUpdateObject`.")
}
