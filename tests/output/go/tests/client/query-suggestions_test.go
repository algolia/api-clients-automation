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

// calls api with correct user agent
func TestSuggestionscommonApi0(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; QuerySuggestions (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestSuggestionscommonApi1(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	_, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestSuggestionscommonApi2(t *testing.T) {
	var err error
	client, echo := createSuggestionsClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// throws when region is not given
func TestSuggestionsparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	_ = echo
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

// throws when incorrect region is given
func TestSuggestionsparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	_ = echo
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

// does not throw when region is given
func TestSuggestionsparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *suggestions.APIClient
	var cfg suggestions.Configuration
	_ = client
	_ = echo
	cfg = suggestions.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: suggestions.Region("us"),
	}
	client, err = suggestions.NewClientWithConfig(cfg)
	require.NoError(t, err)
}
