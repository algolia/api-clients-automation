// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// TypoToleranceEnum - `min`. Return matches with the lowest number of typos.   For example, if you have matches without typos, only include those.   But if there are no matches without typos (with 1 typo), include matches with 1 typo (2 typos). - `strict`. Return matches with the two lowest numbers of typos.   With `strict`, the Typo ranking criterion is applied first in the `ranking` setting.
type TypoToleranceEnum string

// List of typoToleranceEnum.
const (
	TYPOTOLERANCEENUM_MIN    TypoToleranceEnum = "min"
	TYPOTOLERANCEENUM_STRICT TypoToleranceEnum = "strict"
)

// All allowed values of TypoToleranceEnum enum.
var AllowedTypoToleranceEnumEnumValues = []TypoToleranceEnum{
	"min",
	"strict",
}

func (v *TypoToleranceEnum) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'TypoToleranceEnum': %w", string(src), err)
	}
	enumTypeValue := TypoToleranceEnum(value)
	for _, existing := range AllowedTypoToleranceEnumEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid TypoToleranceEnum", value)
}

// NewTypoToleranceEnumFromValue returns a pointer to a valid TypoToleranceEnum
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewTypoToleranceEnumFromValue(v string) (*TypoToleranceEnum, error) {
	ev := TypoToleranceEnum(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for TypoToleranceEnum: valid values are %v", v, AllowedTypoToleranceEnumEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v TypoToleranceEnum) IsValid() bool {
	for _, existing := range AllowedTypoToleranceEnumEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to typoToleranceEnum value.
func (v TypoToleranceEnum) Ptr() *TypoToleranceEnum {
	return &v
}

type NullableTypoToleranceEnum struct {
	value *TypoToleranceEnum
	isSet bool
}

func (v NullableTypoToleranceEnum) Get() *TypoToleranceEnum {
	return v.value
}

func (v *NullableTypoToleranceEnum) Set(val *TypoToleranceEnum) {
	v.value = val
	v.isSet = true
}

func (v NullableTypoToleranceEnum) IsSet() bool {
	return v.isSet
}

func (v *NullableTypoToleranceEnum) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTypoToleranceEnum(val *TypoToleranceEnum) *NullableTypoToleranceEnum {
	return &NullableTypoToleranceEnum{value: val, isSet: true}
}

func (v NullableTypoToleranceEnum) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTypoToleranceEnum) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
