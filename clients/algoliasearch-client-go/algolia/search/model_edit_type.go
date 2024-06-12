// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// EditType Type of edit.
type EditType string

// List of editType.
const (
	EDIT_TYPE_REMOVE  EditType = "remove"
	EDIT_TYPE_REPLACE EditType = "replace"
)

// All allowed values of EditType enum.
var AllowedEditTypeEnumValues = []EditType{
	"remove",
	"replace",
}

func (v *EditType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'EditType': %w", string(src), err)
	}
	enumTypeValue := EditType(value)
	for _, existing := range AllowedEditTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid EditType", value)
}

// NewEditTypeFromValue returns a pointer to a valid EditType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewEditTypeFromValue(v string) (*EditType, error) {
	ev := EditType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for EditType: valid values are %v", v, AllowedEditTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v EditType) IsValid() bool {
	for _, existing := range AllowedEditTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to editType value.
func (v EditType) Ptr() *EditType {
	return &v
}

type NullableEditType struct {
	value *EditType
	isSet bool
}

func (v NullableEditType) Get() *EditType {
	return v.value
}

func (v *NullableEditType) Set(val *EditType) {
	v.value = val
	v.isSet = true
}

func (v NullableEditType) IsSet() bool {
	return v.isSet
}

func (v *NullableEditType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEditType(val *EditType) *NullableEditType {
	return &NullableEditType{value: val, isSet: true}
}

func (v NullableEditType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableEditType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
