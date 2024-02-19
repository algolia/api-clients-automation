package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/recommend"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createRecommendClient(t *testing.T) (*recommend.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := recommend.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, err := recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// calls api with correct read host
func TestRecommendapi0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.Configuration
	_ = client
	_ = echo
	cfg = recommend.Configuration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

// calls api with correct write host
func TestRecommendapi1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.Configuration
	_ = client
	_ = echo
	cfg = recommend.Configuration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

// calls api with correct user agent
func TestRecommendcommonApi0(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	),
	)
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Recommend (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestRecommendcommonApi1(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestRecommendcommonApi2(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}
