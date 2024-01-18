package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createAnalyticsClient(t *testing.T) (*analytics.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := analytics.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: analytics.US,
	}
	client, err := analytics.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func TestAnalyticscommonApi0(t *testing.T) {
	var err error
	client, echo := createAnalyticsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Analytics (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestAnalyticscommonApi1(t *testing.T) {
	var err error
	client, echo := createAnalyticsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestAnalyticscommonApi2(t *testing.T) {
	var err error
	client, echo := createAnalyticsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestAnalyticsparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.Configuration
	_ = client
	require.NoError(t, err)
	cfg = analytics.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = analytics.NewClientWithConfig(cfg)

	require.NoError(t, err)
	_, err = client.GetAverageClickPosition(client.NewApiGetAverageClickPositionRequest(
		"my-index",
	))

	require.Equal(t, "analytics.algolia.com", echo.Host)
}

func TestAnalyticsparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.Configuration
	_ = client
	require.NoError(t, err)
	cfg = analytics.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: analytics.Region("de"),
	}
	client, err = analytics.NewClientWithConfig(cfg)

	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, "analytics.de.algolia.com", echo.Host)
}

func TestAnalyticsparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.Configuration
	_ = client
	cfg = analytics.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: analytics.Region("not_a_region"),
	}
	client, err = analytics.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` must be one of the following: de, us")
}

func TestAnalyticsparameters3(t *testing.T) {
	var err error
	client, echo := createAnalyticsClient(t)
	_ = echo
	_, err = client.GetClickPositions(client.NewApiGetClickPositionsRequest(
		tests.ZeroValue[string](),
	))

	require.EqualError(t, err, "Parameter `index` is required when calling `GetClickPositions`.")
}
