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

// calls api with correct user agent
func TestPersonalizationcommonApi0(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Personalization (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestPersonalizationcommonApi1(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestPersonalizationcommonApi2(t *testing.T) {
	var err error
	client, echo := createPersonalizationClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// throws when region is not given
func TestPersonalizationparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	_ = echo
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

// throws when incorrect region is given
func TestPersonalizationparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	_ = echo
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

// does not throw when region is given
func TestPersonalizationparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *personalization.APIClient
	var cfg personalization.Configuration
	_ = client
	_ = echo
	cfg = personalization.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: personalization.Region("us"),
	}
	client, err = personalization.NewClientWithConfig(cfg)
	require.NoError(t, err)
}
