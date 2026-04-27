package manual

import (
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func TestTransformationOptionsRegionRequired(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationOptions(search.TransformationOptions{})
	require.ErrorContains(t, err, "Region is required in TransformationOptions")
}

func TestTransformationOptionsRegionRequiredAtConstruction(t *testing.T) {
	_, err := search.NewClient("appID", "apiKey",
		search.WithTransformationOptions(search.TransformationOptions{}),
	)
	require.ErrorContains(t, err, "Region is required in TransformationOptions")
}

func TestTransformationOptionsWithRegionOnly(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationOptions(search.TransformationOptions{Region: "us"})
	require.NoError(t, err)
}

func TestWithTransformationOptionsFunctionalOption(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey",
		search.WithTransformationOptions(search.TransformationOptions{
			Region:      "us",
			ReadTimeout: 50 * time.Second,
		}),
	)
	require.NoError(t, err)
	_ = client
}

func TestSetTransformationOptionsReplacesTransporter(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey",
		search.WithTransformationOptions(search.TransformationOptions{Region: "us"}),
	)
	require.NoError(t, err)
	// Replace with a different region — must not error
	err = client.SetTransformationOptions(search.TransformationOptions{Region: "eu"})
	require.NoError(t, err)
}

func TestDeprecatedSetTransformationRegion(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationRegion("us")
	require.NoError(t, err)
}
