package client

import (
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

func TestTransformationOptionsRegionRequired(t *testing.T) {
	opts := search.TransformationOptions{}
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationOptions(opts)
	require.ErrorContains(t, err, "Region is required in TransformationOptions")
}

func TestTransformationOptionsWithRegionOnly(t *testing.T) {
	opts := search.TransformationOptions{Region: "us"}
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationOptions(opts)
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
