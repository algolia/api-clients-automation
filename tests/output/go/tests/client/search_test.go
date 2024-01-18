package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

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

func TestSearchapi0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
	require.NoError(t, err)
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
		"/test",
	))

	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

func TestSearchapi1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
	require.NoError(t, err)
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
		"/test",
	))

	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

func TestSearchcommonApi0(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Search (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestSearchcommonApi1(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestSearchcommonApi2(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestSearchparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *search.APIClient
	var cfg search.Configuration
	_ = client
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

func TestSearchparameters1(t *testing.T) {
	var err error
	client, echo := createSearchClient(t)
	_ = echo
	_, err = client.AddApiKey(client.NewApiAddApiKeyRequest(
		tests.ZeroValue[*search.ApiKey](),
	))

	require.EqualError(t, err, "Parameter `apiKey` is required when calling `AddApiKey`.")
}

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
