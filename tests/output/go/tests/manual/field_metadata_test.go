package manual

import (
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting"
	abtestingv3 "github.com/algolia/algoliasearch-client-go/v4/algolia/abtesting-v3"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/analytics"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/composition"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/insights"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/monitoring"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/personalization"
	suggestions "github.com/algolia/algoliasearch-client-go/v4/algolia/query-suggestions"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/recommend"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
)

type fieldMetadata interface {
	FieldDescription(field string) string
	FieldExample(field string) string
}

func TestFieldMetadata_IsExposedOnEveryClient(t *testing.T) {
	t.Parallel()

	testcases := []struct {
		name  string
		model fieldMetadata
		field string
	}{
		{
			name:  "abtesting",
			model: abtesting.AbTestsVariantSearchParams{},
			field: "index",
		},
		{
			name:  "abtesting-v3",
			model: abtestingv3.ABTestResponse{},
			field: "abTestID",
		},
		{
			name:  "analytics",
			model: analytics.DailyAverageClicks{},
			field: "clickCount",
		},
		{
			name:  "composition",
			model: composition.Composition{},
			field: "name",
		},
		{
			name:  "ingestion",
			model: ingestion.AuthGoogleServiceAccount{},
			field: "clientEmail",
		},
		{
			name:  "insights",
			model: insights.AddedToCartObjectIDs{},
			field: "index",
		},
		{
			name:  "monitoring",
			model: monitoring.Server{},
			field: "name",
		},
		{
			name:  "personalization",
			model: personalization.DeleteUserProfileResponse{},
			field: "userToken",
		},
		{
			name:  "query-suggestions",
			model: suggestions.ConfigurationResponse{},
			field: "indexName",
		},
		{
			name:  "recommend",
			model: recommend.Condition{},
			field: "context",
		},
		{
			name:  "search",
			model: search.SearchParamsObject{},
			field: "restrictSearchableAttributes",
		},
	}

	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			require.NotEmpty(t, tc.model.FieldDescription(tc.field))
			require.NotEmpty(t, tc.model.FieldExample(tc.field))
		})
	}
}

func TestFieldDescription_InheritsFromReference(t *testing.T) {
	t.Parallel()
	type FieldDescriber interface {
		FieldDescription(field string) string
	}

	testcases := []struct {
		name  string
		model FieldDescriber
		field string
	}{
		{
			name:  "referenced model",
			model: composition.InjectionMain{},
			field: "source",
		},
		{
			name:  "referenced enum",
			model: composition.Value{},
			field: "sortRemainingBy",
		},
	}

	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			require.NotEmpty(t, tc.model.FieldDescription(tc.field))
		})
	}
}
