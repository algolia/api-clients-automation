// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// MethodType HTTP method to be used for retrieving your data.
type MethodType string

// List of MethodType.
const (
	METHOD_TYPE_GET  MethodType = "GET"
	METHOD_TYPE_POST MethodType = "POST"
)

// All allowed values of MethodType enum.
var AllowedMethodTypeEnumValues = []MethodType{
	"GET",
	"POST",
}

func (v *MethodType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'MethodType': %w", string(src), err)
	}
	enumTypeValue := MethodType(value)
	for _, existing := range AllowedMethodTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid MethodType", value)
}

// NewMethodTypeFromValue returns a pointer to a valid MethodType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewMethodTypeFromValue(v string) (*MethodType, error) {
	ev := MethodType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for MethodType: valid values are %v", v, AllowedMethodTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v MethodType) IsValid() bool {
	for _, existing := range AllowedMethodTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to MethodType value.
func (v MethodType) Ptr() *MethodType {
	return &v
}
