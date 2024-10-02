// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"encoding/json"
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createAbtestingClient(t *testing.T) (*abtesting.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := abtesting.AbtestingConfiguration{
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

// calls api with correct user agent
func TestAbtestingcommonApi0(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAbtestingClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Abtesting (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// the user agent contains the latest version
func TestAbtestingcommonApi1(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAbtestingClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(4.4.0\).*`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestAbtestingcommonApi2(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAbtestingClient(t)
	_ = echo
	res, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestAbtestingcommonApi3(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createAbtestingClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// fallbacks to the alias when region is not given
func TestAbtestingparameters0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.AbtestingConfiguration
	_ = client
	_ = echo
	cfg = abtesting.AbtestingConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = abtesting.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.GetABTest(client.NewApiGetABTestRequest(
		123,
	))
	require.NoError(t, err)
	require.Equal(t, "analytics.algolia.com", echo.Host)
}

// uses the correct region
func TestAbtestingparameters1(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.AbtestingConfiguration
	_ = client
	_ = echo
	cfg = abtesting.AbtestingConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: abtesting.Region("us"),
	}
	client, err = abtesting.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.GetABTest(client.NewApiGetABTestRequest(
		123,
	))
	require.NoError(t, err)
	require.Equal(t, "analytics.us.algolia.com", echo.Host)
}

// throws when incorrect region is given
func TestAbtestingparameters2(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.AbtestingConfiguration
	_ = client
	_ = echo
	cfg = abtesting.AbtestingConfiguration{
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

// switch API key
func TestAbtestingsetClientApiKey0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *abtesting.APIClient
	var cfg abtesting.AbtestingConfiguration
	_ = client
	_ = echo
	cfg = abtesting.AbtestingConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", tests.GetLocalhost()+":6683", call.IsReadWrite)},
		},
		Region: abtesting.Region("us"),
	}
	client, err = abtesting.NewClientWithConfig(cfg)
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
