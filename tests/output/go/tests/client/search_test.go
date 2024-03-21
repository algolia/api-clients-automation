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
)

func createSearchClient(t *testing.T) (*search.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := search.Configuration{
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
	var cfg search.Configuration
	_ = client
	_ = echo
	cfg = search.Configuration{
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
	),
	)
	require.NoError(t, err)
	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

// calls api with correct write host
func TestSearchapi1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
	_ = echo
	cfg = search.Configuration{
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
	),
	)
	require.NoError(t, err)
	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

// tests the retry strategy
func TestSearchapi2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
	_ = echo
	cfg = search.Configuration{
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
	),
	)
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
	var cfg search.Configuration
	_ = client
	_ = echo
	cfg = search.Configuration{
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
	).WithParameters(map[string]any{}).WithBody(map[string]any{"message": "this is a compressed body"}),
	)
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
	),
	)
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
	),
	)
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
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// client throws with invalid parameters
func TestSearchparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
	_ = echo
	cfg = search.Configuration{
		Configuration: transport.Configuration{
			AppID:     "",
			ApiKey:    "",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`appId` is missing.")
	cfg = search.Configuration{
		Configuration: transport.Configuration{
			AppID:     "",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = search.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`appId` is missing.")
	cfg = search.Configuration{
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
	),
	)
	require.EqualError(t, err, "Parameter `apiKey` is required when calling `AddApiKey`.")
}

// &#x60;addOrUpdateObject&#x60; throws with invalid parameters
func TestSearchparameters2(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		tests.ZeroValue[string](), "my-object-id", map[string]any{},
	),
	)
	require.EqualError(t, err, "Parameter `indexName` is required when calling `AddOrUpdateObject`.")
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		"my-index-name", tests.ZeroValue[string](), map[string]any{},
	),
	)
	require.EqualError(t, err, "Parameter `objectID` is required when calling `AddOrUpdateObject`.")
	_, err = client.AddOrUpdateObject(client.NewApiAddOrUpdateObjectRequest(
		"my-index-name", "my-object-id", tests.ZeroValue[map[string]any](),
	),
	)
	require.EqualError(t, err, "Parameter `body` is required when calling `AddOrUpdateObject`.")
}
