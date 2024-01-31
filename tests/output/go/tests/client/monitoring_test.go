package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/monitoring"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createMonitoringClient(t *testing.T) (*monitoring.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := monitoring.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, err := monitoring.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// calls api with correct user agent
func TestMonitoringcommonApi0(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestMonitoringcommonApi1(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestMonitoringcommonApi2(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// use the correct host
func TestMonitoringparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *monitoring.APIClient
	var cfg monitoring.Configuration
	_ = client
	_ = echo
	cfg = monitoring.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = monitoring.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomDelete(client.NewApiCustomDeleteRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Equal(t, "status.algolia.com", echo.Host)
}
