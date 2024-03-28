// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createIngestionClient(t *testing.T) (*ingestion.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := ingestion.Configuration{
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

// calls api with correct user agent
func TestIngestioncommonApi0(t *testing.T) {
	var err error
	client, echo := createIngestionClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Ingestion (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestIngestioncommonApi1(t *testing.T) {
	var err error
	client, echo := createIngestionClient(t)
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
func TestIngestioncommonApi2(t *testing.T) {
	var err error
	client, echo := createIngestionClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// uses the correct region
func TestIngestionparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.Configuration
	_ = client
	_ = echo
	cfg = ingestion.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: ingestion.Region("us"),
	}
	client, err = ingestion.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.GetSource(client.NewApiGetSourceRequest(
		"6c02aeb1-775e-418e-870b-1faccd4b2c0f",
	),
	)
	require.NoError(t, err)
	require.Equal(t, "data.us.algolia.com", echo.Host)
}

// throws when incorrect region is given
func TestIngestionparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *ingestion.APIClient
	var cfg ingestion.Configuration
	_ = client
	_ = echo
	cfg = ingestion.Configuration{
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
