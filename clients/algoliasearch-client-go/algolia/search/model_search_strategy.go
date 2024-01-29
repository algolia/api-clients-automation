// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SearchStrategy - `none`: executes all queries. - `stopIfEnoughMatches`: executes queries one by one, stopping further query execution as soon as a query matches at least the `hitsPerPage` number of results.
type SearchStrategy string

// List of searchStrategy.
const (
	SEARCHSTRATEGY_NONE                   SearchStrategy = "none"
	SEARCHSTRATEGY_STOP_IF_ENOUGH_MATCHES SearchStrategy = "stopIfEnoughMatches"
)

// All allowed values of SearchStrategy enum.
var AllowedSearchStrategyEnumValues = []SearchStrategy{
	"none",
	"stopIfEnoughMatches",
}

func (v *SearchStrategy) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'SearchStrategy': %w", string(src), err)
	}
	enumTypeValue := SearchStrategy(value)
	for _, existing := range AllowedSearchStrategyEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid SearchStrategy", value)
}

// NewSearchStrategyFromValue returns a pointer to a valid SearchStrategy
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewSearchStrategyFromValue(v string) (*SearchStrategy, error) {
	ev := SearchStrategy(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for SearchStrategy: valid values are %v", v, AllowedSearchStrategyEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v SearchStrategy) IsValid() bool {
	for _, existing := range AllowedSearchStrategyEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to searchStrategy value.
func (v SearchStrategy) Ptr() *SearchStrategy {
	return &v
}

type NullableSearchStrategy struct {
	value *SearchStrategy
	isSet bool
}

func (v NullableSearchStrategy) Get() *SearchStrategy {
	return v.value
}

func (v *NullableSearchStrategy) Set(val *SearchStrategy) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchStrategy) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchStrategy) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchStrategy(val *SearchStrategy) *NullableSearchStrategy {
	return &NullableSearchStrategy{value: val, isSet: true}
}

func (v NullableSearchStrategy) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSearchStrategy) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
