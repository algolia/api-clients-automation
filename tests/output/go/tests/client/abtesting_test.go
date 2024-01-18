package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createAbtestingClient(t *testing.T) (*abtesting.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := abtesting.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: abtesting.US,
	}
	client, err := abtesting.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func TestAbtestingcommonApi0(t *testing.T) {
	var err error
	client, echo := createAbtestingClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Abtesting (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestAbtestingcommonApi1(t *testing.T) {
	var err error
	client, echo := createAbtestingClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestAbtestingcommonApi2(t *testing.T) {
	var err error
	client, echo := createAbtestingClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestAbtestingparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.Configuration
	_ = client
	require.NoError(t, err)
	cfg = abtesting.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = abtesting.NewClientWithConfig(cfg)

	require.NoError(t, err)
	_, err = client.GetABTest(client.NewApiGetABTestRequest(
		123,
	))

	require.Equal(t, "analytics.algolia.com", echo.Host)
}

func TestAbtestingparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.Configuration
	_ = client
	require.NoError(t, err)
	cfg = abtesting.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: abtesting.Region("us"),
	}
	client, err = abtesting.NewClientWithConfig(cfg)

	require.NoError(t, err)
	_, err = client.GetABTest(client.NewApiGetABTestRequest(
		123,
	))

	require.Equal(t, "analytics.us.algolia.com", echo.Host)
}

func TestAbtestingparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.Configuration
	_ = client
	cfg = abtesting.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: abtesting.Region("not_a_region"),
	}
	client, err = abtesting.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` must be one of the following: de, us")
}
