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

func TestRecommendapi0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.Configuration
	_ = client
	require.NoError(t, err)
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
	))

	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

func TestRecommendapi1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.Configuration
	_ = client
	require.NoError(t, err)
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
	))

	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

func TestRecommendcommonApi0(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Recommend (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestRecommendcommonApi1(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestRecommendcommonApi2(t *testing.T) {
	var err error
	client, echo := createRecommendClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}
