// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package abtesting

import (
	"encoding/json"
	"fmt"
)

// AddABTestsVariant - struct for AddABTestsVariant.
type AddABTestsVariant struct {
	AbTestsVariant             *AbTestsVariant
	AbTestsVariantSearchParams *AbTestsVariantSearchParams
}

// AbTestsVariantAsAddABTestsVariant is a convenience function that returns AbTestsVariant wrapped in AddABTestsVariant.
func AbTestsVariantAsAddABTestsVariant(v *AbTestsVariant) *AddABTestsVariant {
	return &AddABTestsVariant{
		AbTestsVariant: v,
	}
}

// AbTestsVariantSearchParamsAsAddABTestsVariant is a convenience function that returns AbTestsVariantSearchParams wrapped in AddABTestsVariant.
func AbTestsVariantSearchParamsAsAddABTestsVariant(v *AbTestsVariantSearchParams) *AddABTestsVariant {
	return &AddABTestsVariant{
		AbTestsVariantSearchParams: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *AddABTestsVariant) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into AbTestsVariant
	err = newStrictDecoder(data).Decode(&dst.AbTestsVariant)
	if err == nil && validateStruct(dst.AbTestsVariant) == nil {
		jsonAbTestsVariant, _ := json.Marshal(dst.AbTestsVariant)
		if string(jsonAbTestsVariant) == "{}" { // empty struct
			dst.AbTestsVariant = nil
		} else {
			return nil
		}
	} else {
		dst.AbTestsVariant = nil
	}

	// try to unmarshal data into AbTestsVariantSearchParams
	err = newStrictDecoder(data).Decode(&dst.AbTestsVariantSearchParams)
	if err == nil && validateStruct(dst.AbTestsVariantSearchParams) == nil {
		jsonAbTestsVariantSearchParams, _ := json.Marshal(dst.AbTestsVariantSearchParams)
		if string(jsonAbTestsVariantSearchParams) == "{}" { // empty struct
			dst.AbTestsVariantSearchParams = nil
		} else {
			return nil
		}
	} else {
		dst.AbTestsVariantSearchParams = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(AddABTestsVariant)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src AddABTestsVariant) MarshalJSON() ([]byte, error) {
	if src.AbTestsVariant != nil {
		serialized, err := json.Marshal(&src.AbTestsVariant)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of AbTestsVariant of AddABTestsVariant: %w", err)
		}

		return serialized, nil
	}

	if src.AbTestsVariantSearchParams != nil {
		serialized, err := json.Marshal(&src.AbTestsVariantSearchParams)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of AbTestsVariantSearchParams of AddABTestsVariant: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *AddABTestsVariant) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.AbTestsVariant != nil {
		return obj.AbTestsVariant
	}

	if obj.AbTestsVariantSearchParams != nil {
		return obj.AbTestsVariantSearchParams
	}

	// all schemas are nil
	return nil
}

type NullableAddABTestsVariant struct {
	value *AddABTestsVariant
	isSet bool
}

func (v NullableAddABTestsVariant) Get() *AddABTestsVariant {
	return v.value
}

func (v *NullableAddABTestsVariant) Set(val *AddABTestsVariant) {
	v.value = val
	v.isSet = true
}

func (v NullableAddABTestsVariant) IsSet() bool {
	return v.isSet
}

func (v *NullableAddABTestsVariant) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAddABTestsVariant(val *AddABTestsVariant) *NullableAddABTestsVariant {
	return &NullableAddABTestsVariant{value: val, isSet: true}
}

func (v NullableAddABTestsVariant) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableAddABTestsVariant) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
