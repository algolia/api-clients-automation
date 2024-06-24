// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// RemoveWordsIfNoResults Strategy for removing words from the query when it doesn't return any results. This helps to avoid returning empty search results.  - `none`.   No words are removed when a query doesn't return results.  - `lastWords`.   Treat the last (then second to last, then third to last) word as optional,   until there are results or at most 5 words have been removed.  - `firstWords`.   Treat the first (then second, then third) word as optional,   until there are results or at most 5 words have been removed.  - `allOptional`.   Treat all words as optional.  For more information, see [Remove words to improve results](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/).
type RemoveWordsIfNoResults string

// List of removeWordsIfNoResults.
const (
	REMOVE_WORDS_IF_NO_RESULTS_NONE         RemoveWordsIfNoResults = "none"
	REMOVE_WORDS_IF_NO_RESULTS_LAST_WORDS   RemoveWordsIfNoResults = "lastWords"
	REMOVE_WORDS_IF_NO_RESULTS_FIRST_WORDS  RemoveWordsIfNoResults = "firstWords"
	REMOVE_WORDS_IF_NO_RESULTS_ALL_OPTIONAL RemoveWordsIfNoResults = "allOptional"
)

// All allowed values of RemoveWordsIfNoResults enum.
var AllowedRemoveWordsIfNoResultsEnumValues = []RemoveWordsIfNoResults{
	"none",
	"lastWords",
	"firstWords",
	"allOptional",
}

func (v *RemoveWordsIfNoResults) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'RemoveWordsIfNoResults': %w", string(src), err)
	}
	enumTypeValue := RemoveWordsIfNoResults(value)
	for _, existing := range AllowedRemoveWordsIfNoResultsEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid RemoveWordsIfNoResults", value)
}

// NewRemoveWordsIfNoResultsFromValue returns a pointer to a valid RemoveWordsIfNoResults
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewRemoveWordsIfNoResultsFromValue(v string) (*RemoveWordsIfNoResults, error) {
	ev := RemoveWordsIfNoResults(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for RemoveWordsIfNoResults: valid values are %v", v, AllowedRemoveWordsIfNoResultsEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v RemoveWordsIfNoResults) IsValid() bool {
	for _, existing := range AllowedRemoveWordsIfNoResultsEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to removeWordsIfNoResults value.
func (v RemoveWordsIfNoResults) Ptr() *RemoveWordsIfNoResults {
	return &v
}
