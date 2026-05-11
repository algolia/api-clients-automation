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

func TestTransformationOptionsRegionOnlyHasNilClientOptions(t *testing.T) {
	opts := search.TransformationOptions{Region: "us"}
	require.Equal(t, "us", string(opts.Region))
	require.Nil(t, opts.ClientOptions)
}

func TestTransformationOptionsClientOptionsStored(t *testing.T) {
	co := &search.ClientOptions{ReadTimeout: 50 * time.Second}
	opts := search.TransformationOptions{Region: "eu", ClientOptions: co}
	require.Equal(t, "eu", string(opts.Region))
	require.Same(t, co, opts.ClientOptions)
}

func TestTransformationOptionsWithRegionOnly(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	err = client.SetTransformationOptions(search.TransformationOptions{Region: "us"})
	require.NoError(t, err)
}

func TestIngestionTransporterNilBeforeSet(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	_, err = client.SaveObjectsWithTransformation("index", []map[string]any{{"objectID": "1"}})
	require.ErrorContains(t, err, "TransformationOptions must be set")
}

func TestSetTransformationOptionsCreatesTransporter(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey")
	require.NoError(t, err)
	_, err = client.SaveObjectsWithTransformation("index", []map[string]any{{"objectID": "1"}})
	require.ErrorContains(t, err, "TransformationOptions must be set")
	require.NoError(t, client.SetTransformationOptions(search.TransformationOptions{Region: "us"}))
	_, err = client.SaveObjectsWithTransformation("index", []map[string]any{{"objectID": "1"}})
	require.Error(t, err)
	require.NotContains(t, err.Error(), "TransformationOptions must be set")
}

func TestWithTransformationOptionsFunctionalOption(t *testing.T) {
	client, err := search.NewClient("appID", "apiKey",
		search.WithTransformationOptions(search.TransformationOptions{
			Region:        "us",
			ClientOptions: &search.ClientOptions{ReadTimeout: 50 * time.Second},
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
