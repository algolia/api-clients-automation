package manual

import (
	"encoding/json"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/composition"
)

func TestInjectedItemSource_UnmarshalSearchSource(t *testing.T) {
	t.Parallel()

	input := `{"search": {"index": "demo"}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.InjectedItemSourceSearchSource, "expected InjectedItemSourceSearchSource to be set")
	require.Nil(t, source.ExternalSource, "expected ExternalSource to be nil")
	require.Equal(t, "demo", source.InjectedItemSourceSearchSource.Search.Index)
}

func TestInjectedItemSource_UnmarshalExternalSource(t *testing.T) {
	t.Parallel()

	input := `{"external": {"index": "sponsored", "ordering": "userDefined"}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.ExternalSource, "expected ExternalSource to be set")
	require.Nil(t, source.InjectedItemSourceSearchSource, "expected InjectedItemSourceSearchSource to be nil")
	require.Equal(t, "sponsored", source.ExternalSource.External.Index)
}

func TestInjectedItemSource_RoundTripSearchSource(t *testing.T) {
	t.Parallel()

	input := `{"search":{"index":"demo"}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	output, err := json.Marshal(&source)
	require.NoError(t, err)
	require.JSONEq(t, input, string(output))
}

func TestInjectedItemSource_RoundTripExternalSource(t *testing.T) {
	t.Parallel()

	input := `{"external":{"index":"sponsored"}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	output, err := json.Marshal(&source)
	require.NoError(t, err)
	require.JSONEq(t, input, string(output))
}

func TestInjectionMainSource_UnmarshalSearchSource(t *testing.T) {
	t.Parallel()

	input := `{"search": {"index": "demo"}}`

	var source composition.InjectionMainSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.SearchSource, "expected SearchSource to be set")
	require.Nil(t, source.RecommendSource, "expected RecommendSource to be nil")
	require.Equal(t, "demo", source.SearchSource.Search.Index)
}

func TestInjectionMainSource_RoundTripSearchSource(t *testing.T) {
	t.Parallel()

	input := `{"search":{"index":"demo"}}`

	var source composition.InjectionMainSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	output, err := json.Marshal(&source)
	require.NoError(t, err)
	require.JSONEq(t, input, string(output))
}
