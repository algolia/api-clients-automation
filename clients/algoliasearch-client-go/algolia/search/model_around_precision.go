// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// AroundPrecision - Precision of a geographical search (in meters), to [group results that are more or less the same distance from a central point](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/in-depth/geo-ranking-precision/).
type AroundPrecision struct {
	ArrayOfAroundPrecisionFromValueInner *[]AroundPrecisionFromValueInner
	Int32                                *int32
}

// []AroundPrecisionFromValueInnerAsAroundPrecision is a convenience function that returns []AroundPrecisionFromValueInner wrapped in AroundPrecision
func ArrayOfAroundPrecisionFromValueInnerAsAroundPrecision(v *[]AroundPrecisionFromValueInner) AroundPrecision {
	return AroundPrecision{
		ArrayOfAroundPrecisionFromValueInner: v,
	}
}

// int32AsAroundPrecision is a convenience function that returns int32 wrapped in AroundPrecision
func Int32AsAroundPrecision(v *int32) AroundPrecision {
	return AroundPrecision{
		Int32: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct
func (dst *AroundPrecision) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into ArrayOfAroundPrecisionFromValueInner
	err = newStrictDecoder(data).Decode(&dst.ArrayOfAroundPrecisionFromValueInner)
	if err == nil && validateStruct(dst.ArrayOfAroundPrecisionFromValueInner) == nil {
		jsonArrayOfAroundPrecisionFromValueInner, _ := json.Marshal(dst.ArrayOfAroundPrecisionFromValueInner)
		if string(jsonArrayOfAroundPrecisionFromValueInner) == "{}" { // empty struct
			dst.ArrayOfAroundPrecisionFromValueInner = nil
		} else {
			return nil
		}
	} else {
		dst.ArrayOfAroundPrecisionFromValueInner = nil
	}

	// try to unmarshal data into Int32
	err = newStrictDecoder(data).Decode(&dst.Int32)
	if err == nil && validateStruct(dst.Int32) == nil {
		jsonInt32, _ := json.Marshal(dst.Int32)
		if string(jsonInt32) == "{}" { // empty struct
			dst.Int32 = nil
		} else {
			return nil
		}
	} else {
		dst.Int32 = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(AroundPrecision)")
}

// Marshal data from the first non-nil pointers in the struct to JSON
func (src AroundPrecision) MarshalJSON() ([]byte, error) {
	if src.ArrayOfAroundPrecisionFromValueInner != nil {
		return json.Marshal(&src.ArrayOfAroundPrecisionFromValueInner)
	}

	if src.Int32 != nil {
		return json.Marshal(&src.Int32)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance
func (obj *AroundPrecision) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.ArrayOfAroundPrecisionFromValueInner != nil {
		return obj.ArrayOfAroundPrecisionFromValueInner
	}

	if obj.Int32 != nil {
		return obj.Int32
	}

	// all schemas are nil
	return nil
}

type NullableAroundPrecision struct {
	value *AroundPrecision
	isSet bool
}

func (v NullableAroundPrecision) Get() *AroundPrecision {
	return v.value
}

func (v *NullableAroundPrecision) Set(val *AroundPrecision) {
	v.value = val
	v.isSet = true
}

func (v NullableAroundPrecision) IsSet() bool {
	return v.isSet
}

func (v *NullableAroundPrecision) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAroundPrecision(val *AroundPrecision) *NullableAroundPrecision {
	return &NullableAroundPrecision{value: val, isSet: true}
}

func (v NullableAroundPrecision) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAroundPrecision) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
