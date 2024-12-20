// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"encoding/json"
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createAnalyticsClient(t *testing.T) (*analytics.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := analytics.AnalyticsConfiguration{
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

// calls api with correct user agent
func TestAnalyticscommonApi0(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAnalyticsClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Analytics (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// the user agent contains the latest version
func TestAnalyticscommonApi1(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAnalyticsClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(4.10.2\).*`), echo.Header.Get("User-Agent"))
}

// fallbacks to the alias when region is not given
func TestAnalyticsparameters0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.AnalyticsConfiguration
	_ = client
	_ = echo
	cfg = analytics.AnalyticsConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = analytics.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.GetAverageClickPosition(client.NewApiGetAverageClickPositionRequest(
		"my-index",
	))
	require.NoError(t, err)
	require.Equal(t, "analytics.algolia.com", echo.Host)
}

// uses the correct region
func TestAnalyticsparameters1(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.AnalyticsConfiguration
	_ = client
	_ = echo
	cfg = analytics.AnalyticsConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: analytics.Region("de"),
	}
	client, err = analytics.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"test",
	))
	require.NoError(t, err)
	require.Equal(t, "analytics.de.algolia.com", echo.Host)
}

// throws when incorrect region is given
func TestAnalyticsparameters2(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.AnalyticsConfiguration
	_ = client
	_ = echo
	cfg = analytics.AnalyticsConfiguration{
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

// getAverageClickPosition throws without index
func TestAnalyticsparameters3(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAnalyticsClient(t)
	_ = echo
	res, err = client.GetClickPositions(client.NewApiGetClickPositionsRequest(
		tests.ZeroValue[string](),
	))
	require.EqualError(t, err, "Parameter `index` is required when calling `GetClickPositions`.")
}

// switch API key
func TestAnalyticssetClientApiKey0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *analytics.APIClient
	var cfg analytics.AnalyticsConfiguration
	_ = client
	_ = echo
	cfg = analytics.AnalyticsConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", tests.GetLocalhost()+":6683", call.IsReadWrite)},
		},
		Region: analytics.Region("us"),
	}
	client, err = analytics.NewClientWithConfig(cfg)
	require.NoError(t, err)
	{
		res, err = client.CustomGet(client.NewApiCustomGetRequest(
			"check-api-key/1",
		))
		require.NoError(t, err)
		rawBody, err := json.Marshal(res)
		require.NoError(t, err)
		require.JSONEq(t, `{"headerAPIKeyValue":"test-api-key"}`, string(rawBody))
	}
	{
		err = client.SetClientApiKey(
			"updated-api-key",
		)
		require.NoError(t, err)
	}
	{
		res, err = client.CustomGet(client.NewApiCustomGetRequest(
			"check-api-key/2",
		))
		require.NoError(t, err)
		rawBody, err := json.Marshal(res)
		require.NoError(t, err)
		require.JSONEq(t, `{"headerAPIKeyValue":"updated-api-key"}`, string(rawBody))
	}
}
