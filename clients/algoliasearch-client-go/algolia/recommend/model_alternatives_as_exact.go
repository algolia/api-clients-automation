// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// AlternativesAsExact the model 'AlternativesAsExact'.
type AlternativesAsExact string

// List of alternativesAsExact.
const (
	ALTERNATIVES_AS_EXACT_IGNORE_PLURALS      AlternativesAsExact = "ignorePlurals"
	ALTERNATIVES_AS_EXACT_SINGLE_WORD_SYNONYM AlternativesAsExact = "singleWordSynonym"
	ALTERNATIVES_AS_EXACT_MULTI_WORDS_SYNONYM AlternativesAsExact = "multiWordsSynonym"
)

// All allowed values of AlternativesAsExact enum.
var AllowedAlternativesAsExactEnumValues = []AlternativesAsExact{
	"ignorePlurals",
	"singleWordSynonym",
	"multiWordsSynonym",
}

func (v *AlternativesAsExact) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'AlternativesAsExact': %w", string(src), err)
	}
	enumTypeValue := AlternativesAsExact(value)
	for _, existing := range AllowedAlternativesAsExactEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid AlternativesAsExact", value)
}

// NewAlternativesAsExactFromValue returns a pointer to a valid AlternativesAsExact
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewAlternativesAsExactFromValue(v string) (*AlternativesAsExact, error) {
	ev := AlternativesAsExact(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for AlternativesAsExact: valid values are %v", v, AllowedAlternativesAsExactEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v AlternativesAsExact) IsValid() bool {
	for _, existing := range AllowedAlternativesAsExactEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to alternativesAsExact value.
func (v AlternativesAsExact) Ptr() *AlternativesAsExact {
	return &v
}

type NullableAlternativesAsExact struct {
	value *AlternativesAsExact
	isSet bool
}

func (v NullableAlternativesAsExact) Get() *AlternativesAsExact {
	return v.value
}

func (v *NullableAlternativesAsExact) Set(val *AlternativesAsExact) {
	v.value = val
	v.isSet = true
}

func (v NullableAlternativesAsExact) IsSet() bool {
	return v.isSet
}

func (v *NullableAlternativesAsExact) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAlternativesAsExact(val *AlternativesAsExact) *NullableAlternativesAsExact {
	return &NullableAlternativesAsExact{value: val, isSet: true}
}

func (v NullableAlternativesAsExact) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableAlternativesAsExact) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
