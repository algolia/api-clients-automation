package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/query-suggestions"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createSuggestionsClient(t *testing.T) (*suggestions.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := suggestions.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: suggestions.US,
	}
	client, err := suggestions.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

func TestSuggestionscommonApi0(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; QuerySuggestions (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

func TestSuggestionscommonApi1(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

func TestSuggestionscommonApi2(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	require.NoError(t, err)
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"/test",
	))

	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

func TestSuggestionsparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	cfg = suggestions.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: suggestions.Region(""),
	}
	client, err = suggestions.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` is required and must be one of the following: eu, us")
}

func TestSuggestionsparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	cfg = suggestions.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: suggestions.Region("not_a_region"),
	}
	client, err = suggestions.NewClientWithConfig(cfg)

	require.EqualError(t, err, "`region` is required and must be one of the following: eu, us")
}

func TestSuggestionsparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	require.NoError(t, err)
	cfg = suggestions.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: suggestions.Region("us"),
	}
	client, err = suggestions.NewClientWithConfig(cfg)

}
