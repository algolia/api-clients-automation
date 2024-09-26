// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"encoding/json"
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/recommend"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createRecommendClient(t *testing.T) (*recommend.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := recommend.RecommendConfiguration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
	}
	client, err := recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// calls api with correct read host
func TestRecommendapi0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.RecommendConfiguration
	_ = client
	_ = echo
	cfg = recommend.RecommendConfiguration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.CustomGet(client.NewApiCustomGetRequest(
		"test",
	))
	require.NoError(t, err)
	require.Equal(t, "test-app-id-dsn.algolia.net", echo.Host)
}

// calls api with correct write host
func TestRecommendapi1(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.RecommendConfiguration
	_ = client
	_ = echo
	cfg = recommend.RecommendConfiguration{
		Configuration: transport.Configuration{
			AppID:     "test-app-id",
			ApiKey:    "test-api-key",
			Requester: echo,
		},
	}
	client, err = recommend.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"test",
	))
	require.NoError(t, err)
	require.Equal(t, "test-app-id.algolia.net", echo.Host)
}

// calls api with correct user agent
func TestRecommendcommonApi0(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createRecommendClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Recommend (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// the user agent contains the latest version
func TestRecommendcommonApi1(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createRecommendClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(4.3.5\).*`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestRecommendcommonApi2(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createRecommendClient(t)
	_ = echo
	res, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestRecommendcommonApi3(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createRecommendClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// switch API key
func TestRecommendsetClientApiKey0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *recommend.APIClient
	var cfg recommend.RecommendConfiguration
	_ = client
	_ = echo
	cfg = recommend.RecommendConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", tests.GetLocalhost()+":6683", call.IsReadWrite)},
		},
	}
	client, err = recommend.NewClientWithConfig(cfg)
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
