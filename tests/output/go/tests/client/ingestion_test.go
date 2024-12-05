// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"encoding/json"
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createIngestionClient(t *testing.T) (*ingestion.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: ingestion.US,
	}
	client, err := ingestion.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// can handle HTML error
func TestIngestionapi0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.IngestionConfiguration
	_ = client
	_ = echo
	cfg = ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", tests.GetLocalhost()+":6676", call.IsReadWrite)},
		},
		Region: ingestion.Region("us"),
	}
	client, err = ingestion.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/html-error",
	))
	require.EqualError(t, err, "API error [429] Too Many Requests")
}

// calls api with correct user agent
func TestIngestioncommonApi0(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createIngestionClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Ingestion (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// the user agent contains the latest version
func TestIngestioncommonApi1(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createIngestionClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(4.8.2\).*`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestIngestioncommonApi2(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createIngestionClient(t)
	_ = echo
	res, err = client.CustomGet(client.NewApiCustomGetRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(5000), echo.Timeout.Milliseconds())
}

// calls api with default write timeouts
func TestIngestioncommonApi3(t *testing.T) {
	var err error
	var res any
	_ = res
	client, echo := createIngestionClient(t)
	_ = echo
	res, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	))
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// uses the correct region
func TestIngestionparameters0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.IngestionConfiguration
	_ = client
	_ = echo
	cfg = ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: ingestion.Region("us"),
	}
	client, err = ingestion.NewClientWithConfig(cfg)
	require.NoError(t, err)
	res, err = client.GetSource(client.NewApiGetSourceRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	))
	require.NoError(t, err)
	require.Equal(t, "data.us.algolia.com", echo.Host)
}

// throws when incorrect region is given
func TestIngestionparameters1(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.IngestionConfiguration
	_ = client
	_ = echo
	cfg = ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: ingestion.Region("not_a_region"),
	}
	client, err = ingestion.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`region` is required and must be one of the following: eu, us")
}

// switch API key
func TestIngestionsetClientApiKey0(t *testing.T) {
	var err error
	var res any
	_ = res
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.IngestionConfiguration
	_ = client
	_ = echo
	cfg = ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:  "test-app-id",
			ApiKey: "test-api-key",
			Hosts:  []transport.StatefulHost{transport.NewStatefulHost("http", tests.GetLocalhost()+":6683", call.IsReadWrite)},
		},
		Region: ingestion.Region("us"),
	}
	client, err = ingestion.NewClientWithConfig(cfg)
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
