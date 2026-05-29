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

	require.NotNil(t, source.InjectedItemSearchSource, "expected SearchSource to be set")
	require.Nil(t, source.InjectedItemExternalSource, "expected ExternalSource to be nil")
	require.Nil(t, source.InjectedItemRecommendSource, "expected RecommendSource to be nil")
	require.Equal(t, "demo", source.InjectedItemSearchSource.Search.Index)
}

func TestInjectedItemSource_UnmarshalExternalSource(t *testing.T) {
	t.Parallel()

	input := `{"external": {"index": "sponsored", "ordering": "userDefined"}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.InjectedItemExternalSource, "expected External Source to be set")
	require.Nil(t, source.InjectedItemSearchSource, "expected Search Source to be nil")
	require.Nil(t, source.InjectedItemRecommendSource, "expected RecommendSource to be nil")
	require.Equal(t, "sponsored", source.InjectedItemExternalSource.External.Index)
}

func TestInjectedItemSource_UnmarshalRecommendSource(t *testing.T) {
	t.Parallel()

	input := `{"recommend": {"indexName": "demo", "model": "trending-items", "threshold": 50}}`

	var source composition.InjectedItemSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.InjectedItemRecommendSource, "expected RecommendSource to be set")
	require.Nil(t, source.InjectedItemSearchSource, "expected InjectedItemSourceSearchSource to be nil")
	require.Nil(t, source.InjectedItemExternalSource, "expected External Source to be nil")
	require.Equal(t, "demo", source.InjectedItemRecommendSource.Recommend.IndexName)
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

	require.NotNil(t, source.InjectionMainSearchSource, "expected SearchSource to be set")
	require.Nil(t, source.InjectionMainRecommendSource, "expected RecommendSource to be nil")
	require.Equal(t, "demo", source.InjectionMainSearchSource.Search.Index)
}

func TestInjectionMainSource_UnmarshalRecommendSource(t *testing.T) {
	t.Parallel()

	input := `{"recommend": {"indexName": "demo", "model": "trending-items", "threshold": 50}}`

	var source composition.InjectionMainSource

	err := json.Unmarshal([]byte(input), &source)
	require.NoError(t, err)

	require.NotNil(t, source.InjectionMainRecommendSource, "expected RecommendSource to be set")
	require.Nil(t, source.InjectionMainSearchSource, "expected SearchSource to be nil")
	require.Equal(t, "demo", source.InjectionMainRecommendSource.Recommend.IndexName)
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
