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

func TestMonitoringcommonApi0(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestMonitoringcommonApi1(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestMonitoringcommonApi2(t *testing.T) {
	var err error
	client, echo := createMonitoringClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestMonitoringparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *monitoring.APIClient
	var cfg monitoring.Configuration
	_ = client
	require.NoError(t, err)
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

	require.Equal(t, "status.algolia.com", echo.Host)
}
