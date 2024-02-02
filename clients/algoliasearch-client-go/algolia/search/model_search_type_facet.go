// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SearchTypeFacet - `default`: perform a search query - `facet` [searches for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
type SearchTypeFacet string

// List of searchTypeFacet.
const (
	SEARCHTYPEFACET_FACET SearchTypeFacet = "facet"
)

// All allowed values of SearchTypeFacet enum.
var AllowedSearchTypeFacetEnumValues = []SearchTypeFacet{
	"facet",
}

func (v *SearchTypeFacet) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'SearchTypeFacet': %w", string(src), err)
	}
	enumTypeValue := SearchTypeFacet(value)
	for _, existing := range AllowedSearchTypeFacetEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid SearchTypeFacet", value)
}

// NewSearchTypeFacetFromValue returns a pointer to a valid SearchTypeFacet
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewSearchTypeFacetFromValue(v string) (*SearchTypeFacet, error) {
	ev := SearchTypeFacet(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for SearchTypeFacet: valid values are %v", v, AllowedSearchTypeFacetEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v SearchTypeFacet) IsValid() bool {
	for _, existing := range AllowedSearchTypeFacetEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to searchTypeFacet value.
func (v SearchTypeFacet) Ptr() *SearchTypeFacet {
	return &v
}

type NullableSearchTypeFacet struct {
	value *SearchTypeFacet
	isSet bool
}

func (v NullableSearchTypeFacet) Get() *SearchTypeFacet {
	return v.value
}

func (v *NullableSearchTypeFacet) Set(val *SearchTypeFacet) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchTypeFacet) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchTypeFacet) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchTypeFacet(val *SearchTypeFacet) *NullableSearchTypeFacet {
	return &NullableSearchTypeFacet{value: val, isSet: true}
}

func (v NullableSearchTypeFacet) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSearchTypeFacet) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
