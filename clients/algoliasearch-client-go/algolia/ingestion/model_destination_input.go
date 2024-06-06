// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DestinationInput - struct for DestinationInput.
type DestinationInput struct {
	DestinationIndexName   *DestinationIndexName
	DestinationIndexPrefix *DestinationIndexPrefix
}

// DestinationIndexPrefixAsDestinationInput is a convenience function that returns DestinationIndexPrefix wrapped in DestinationInput.
func DestinationIndexPrefixAsDestinationInput(v *DestinationIndexPrefix) *DestinationInput {
	return &DestinationInput{
		DestinationIndexPrefix: v,
	}
}

// DestinationIndexNameAsDestinationInput is a convenience function that returns DestinationIndexName wrapped in DestinationInput.
func DestinationIndexNameAsDestinationInput(v *DestinationIndexName) *DestinationInput {
	return &DestinationInput{
		DestinationIndexName: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *DestinationInput) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into DestinationIndexName
	err = newStrictDecoder(data).Decode(&dst.DestinationIndexName)
	if err == nil && validateStruct(dst.DestinationIndexName) == nil {
		jsonDestinationIndexName, _ := json.Marshal(dst.DestinationIndexName)
		if string(jsonDestinationIndexName) == "{}" { // empty struct
			dst.DestinationIndexName = nil
		} else {
			return nil
		}
	} else {
		dst.DestinationIndexName = nil
	}

	// try to unmarshal data into DestinationIndexPrefix
	err = newStrictDecoder(data).Decode(&dst.DestinationIndexPrefix)
	if err == nil && validateStruct(dst.DestinationIndexPrefix) == nil {
		jsonDestinationIndexPrefix, _ := json.Marshal(dst.DestinationIndexPrefix)
		if string(jsonDestinationIndexPrefix) == "{}" { // empty struct
			dst.DestinationIndexPrefix = nil
		} else {
			return nil
		}
	} else {
		dst.DestinationIndexPrefix = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(DestinationInput)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src DestinationInput) MarshalJSON() ([]byte, error) {
	if src.DestinationIndexName != nil {
		serialized, err := json.Marshal(&src.DestinationIndexName)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of DestinationIndexName of DestinationInput: %w", err)
		}

		return serialized, nil
	}

	if src.DestinationIndexPrefix != nil {
		serialized, err := json.Marshal(&src.DestinationIndexPrefix)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of DestinationIndexPrefix of DestinationInput: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj DestinationInput) GetActualInstance() any {
	if obj.DestinationIndexName != nil {
		return *obj.DestinationIndexName
	}

	if obj.DestinationIndexPrefix != nil {
		return *obj.DestinationIndexPrefix
	}

	// all schemas are nil
	return nil
}

type NullableDestinationInput struct {
	value *DestinationInput
	isSet bool
}

func (v NullableDestinationInput) Get() *DestinationInput {
	return v.value
}

func (v *NullableDestinationInput) Set(val *DestinationInput) {
	v.value = val
	v.isSet = true
}

func (v NullableDestinationInput) IsSet() bool {
	return v.isSet
}

func (v *NullableDestinationInput) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDestinationInput(val *DestinationInput) *NullableDestinationInput {
	return &NullableDestinationInput{value: val, isSet: true}
}

func (v NullableDestinationInput) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableDestinationInput) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
