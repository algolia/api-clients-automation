package client

import (
	"regexp"
	"testing"

	"github.com/stretchr/testify/require"

	"gotests/tests"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/insights"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func createInsightsClient(t *testing.T) (*insights.APIClient, *tests.EchoRequester) {
	echo := &tests.EchoRequester{}
	cfg := insights.Configuration{
		Configuration: transport.Configuration{
			AppID:     "appID",
			ApiKey:    "apiKey",
			Requester: echo,
		},
		Region: insights.US,
	}
	client, err := insights.NewClientWithConfig(cfg)
	require.NoError(t, err)

	return client, echo
}

// calls api with correct user agent
func TestInsightscommonApi0(t *testing.T) {
	var err error
	client, echo := createInsightsClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Regexp(t, regexp.MustCompile(`^Algolia for Go \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Insights (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$`), echo.Header.Get("User-Agent"))
}

// calls api with default read timeouts
func TestInsightscommonApi1(t *testing.T) {
	var err error
	client, echo := createInsightsClient(t)
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
func TestInsightscommonApi2(t *testing.T) {
	var err error
	client, echo := createInsightsClient(t)
	_ = echo
	_, err = client.CustomPost(client.NewApiCustomPostRequest(
		"1/test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, int64(2000), echo.ConnectTimeout.Milliseconds())
	require.Equal(t, int64(30000), echo.Timeout.Milliseconds())
}

// fallbacks to the alias when region is not given
func TestInsightsparameters0(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *insights.APIClient
	var cfg insights.Configuration
	_ = client
	_ = echo
	cfg = insights.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
	}
	client, err = insights.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.PushEvents(client.NewApiPushEventsRequest(

		insights.NewEmptyInsightsEvents().SetEvents(
			[]insights.EventsItems{*insights.ClickedObjectIDsAfterSearchAsEventsItems(
				insights.NewEmptyClickedObjectIDsAfterSearch().SetEventType(insights.ClickEvent("click")).SetEventName("Product Clicked").SetIndex("products").SetUserToken("user-123456").SetAuthenticatedUserToken("user-123456").SetTimestamp(1641290601962).SetObjectIDs(
					[]string{"9780545139700", "9780439784542"}).SetQueryID("43b15df305339e827f0ac0bdc5ebcaa7").SetPositions(
					[]int32{7, 6}))}),
	),
	)
	require.NoError(t, err)
	require.Equal(t, "insights.algolia.io", echo.Host)
}

// uses the correct region
func TestInsightsparameters1(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *insights.APIClient
	var cfg insights.Configuration
	_ = client
	_ = echo
	cfg = insights.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: insights.Region("us"),
	}
	client, err = insights.NewClientWithConfig(cfg)
	require.NoError(t, err)
	_, err = client.CustomDelete(client.NewApiCustomDeleteRequest(
		"test",
	),
	)
	require.NoError(t, err)
	require.Equal(t, "insights.us.algolia.io", echo.Host)
}

// throws when incorrect region is given
func TestInsightsparameters2(t *testing.T) {
	var err error
	echo := &tests.EchoRequester{}
	var client *insights.APIClient
	var cfg insights.Configuration
	_ = client
	_ = echo
	cfg = insights.Configuration{
		Configuration: transport.Configuration{
			AppID:     "my-app-id",
			ApiKey:    "my-api-key",
			Requester: echo,
		},
		Region: insights.Region("not_a_region"),
	}
	client, err = insights.NewClientWithConfig(cfg)
	require.EqualError(t, err, "`region` must be one of the following: de, us")
}
