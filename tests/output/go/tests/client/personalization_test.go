package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/personalization"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createPersonalizationClient(t *testing.T) (*personalization.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: personalization.US,
	}
	client, err := personalization.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func TestPersonalizationcommonApi0(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Personalization (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestPersonalizationcommonApi1(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestPersonalizationcommonApi2(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestPersonalizationparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	cfg = personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: personalization.Region(""),
	}
	client, err = personalization.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` is required and must be one of the following: eu, us")
}

func TestPersonalizationparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	cfg = personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: personalization.Region("not_a_region"),
	}
	client, err = personalization.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` is required and must be one of the following: eu, us")
}

func TestPersonalizationparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	require.NoError(t, err)
	cfg = personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: personalization.Region("us"),
	}
	client, err = personalization.NewClientWithConfig(cfg)

}
