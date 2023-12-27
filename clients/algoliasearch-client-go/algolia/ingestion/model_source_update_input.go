// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceUpdateInput - struct for SourceUpdateInput.
type SourceUpdateInput struct {
	SourceBigQuery            *SourceBigQuery
	SourceCSV                 *SourceCSV
	SourceJSON                *SourceJSON
	SourceUpdateCommercetools *SourceUpdateCommercetools
	SourceUpdateDocker        *SourceUpdateDocker
}

// SourceBigQueryAsSourceUpdateInput is a convenience function that returns SourceBigQuery wrapped in SourceUpdateInput.
func SourceBigQueryAsSourceUpdateInput(v *SourceBigQuery) SourceUpdateInput {
	return SourceUpdateInput{
		SourceBigQuery: v,
	}
}

// SourceCSVAsSourceUpdateInput is a convenience function that returns SourceCSV wrapped in SourceUpdateInput.
func SourceCSVAsSourceUpdateInput(v *SourceCSV) SourceUpdateInput {
	return SourceUpdateInput{
		SourceCSV: v,
	}
}

// SourceJSONAsSourceUpdateInput is a convenience function that returns SourceJSON wrapped in SourceUpdateInput.
func SourceJSONAsSourceUpdateInput(v *SourceJSON) SourceUpdateInput {
	return SourceUpdateInput{
		SourceJSON: v,
	}
}

// SourceUpdateCommercetoolsAsSourceUpdateInput is a convenience function that returns SourceUpdateCommercetools wrapped in SourceUpdateInput.
func SourceUpdateCommercetoolsAsSourceUpdateInput(v *SourceUpdateCommercetools) SourceUpdateInput {
	return SourceUpdateInput{
		SourceUpdateCommercetools: v,
	}
}

// SourceUpdateDockerAsSourceUpdateInput is a convenience function that returns SourceUpdateDocker wrapped in SourceUpdateInput.
func SourceUpdateDockerAsSourceUpdateInput(v *SourceUpdateDocker) SourceUpdateInput {
	return SourceUpdateInput{
		SourceUpdateDocker: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *SourceUpdateInput) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into SourceBigQuery
	err = newStrictDecoder(data).Decode(&dst.SourceBigQuery)
	if err == nil && validateStruct(dst.SourceBigQuery) == nil {
		jsonSourceBigQuery, _ := json.Marshal(dst.SourceBigQuery)
		if string(jsonSourceBigQuery) == "{}" { // empty struct
			dst.SourceBigQuery = nil
		} else {
			return nil
		}
	} else {
		dst.SourceBigQuery = nil
	}

	// try to unmarshal data into SourceCSV
	err = newStrictDecoder(data).Decode(&dst.SourceCSV)
	if err == nil && validateStruct(dst.SourceCSV) == nil {
		jsonSourceCSV, _ := json.Marshal(dst.SourceCSV)
		if string(jsonSourceCSV) == "{}" { // empty struct
			dst.SourceCSV = nil
		} else {
			return nil
		}
	} else {
		dst.SourceCSV = nil
	}

	// try to unmarshal data into SourceJSON
	err = newStrictDecoder(data).Decode(&dst.SourceJSON)
	if err == nil && validateStruct(dst.SourceJSON) == nil {
		jsonSourceJSON, _ := json.Marshal(dst.SourceJSON)
		if string(jsonSourceJSON) == "{}" { // empty struct
			dst.SourceJSON = nil
		} else {
			return nil
		}
	} else {
		dst.SourceJSON = nil
	}

	// try to unmarshal data into SourceUpdateCommercetools
	err = newStrictDecoder(data).Decode(&dst.SourceUpdateCommercetools)
	if err == nil && validateStruct(dst.SourceUpdateCommercetools) == nil {
		jsonSourceUpdateCommercetools, _ := json.Marshal(dst.SourceUpdateCommercetools)
		if string(jsonSourceUpdateCommercetools) == "{}" { // empty struct
			dst.SourceUpdateCommercetools = nil
		} else {
			return nil
		}
	} else {
		dst.SourceUpdateCommercetools = nil
	}

	// try to unmarshal data into SourceUpdateDocker
	err = newStrictDecoder(data).Decode(&dst.SourceUpdateDocker)
	if err == nil && validateStruct(dst.SourceUpdateDocker) == nil {
		jsonSourceUpdateDocker, _ := json.Marshal(dst.SourceUpdateDocker)
		if string(jsonSourceUpdateDocker) == "{}" { // empty struct
			dst.SourceUpdateDocker = nil
		} else {
			return nil
		}
	} else {
		dst.SourceUpdateDocker = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(SourceUpdateInput)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src SourceUpdateInput) MarshalJSON() ([]byte, error) {
	if src.SourceBigQuery != nil {
		return json.Marshal(&src.SourceBigQuery)
	}

	if src.SourceCSV != nil {
		return json.Marshal(&src.SourceCSV)
	}

	if src.SourceJSON != nil {
		return json.Marshal(&src.SourceJSON)
	}

	if src.SourceUpdateCommercetools != nil {
		return json.Marshal(&src.SourceUpdateCommercetools)
	}

	if src.SourceUpdateDocker != nil {
		return json.Marshal(&src.SourceUpdateDocker)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *SourceUpdateInput) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.SourceBigQuery != nil {
		return obj.SourceBigQuery
	}

	if obj.SourceCSV != nil {
		return obj.SourceCSV
	}

	if obj.SourceJSON != nil {
		return obj.SourceJSON
	}

	if obj.SourceUpdateCommercetools != nil {
		return obj.SourceUpdateCommercetools
	}

	if obj.SourceUpdateDocker != nil {
		return obj.SourceUpdateDocker
	}

	// all schemas are nil
	return nil
}

type NullableSourceUpdateInput struct {
	value *SourceUpdateInput
	isSet bool
}

func (v NullableSourceUpdateInput) Get() *SourceUpdateInput {
	return v.value
}

func (v *NullableSourceUpdateInput) Set(val *SourceUpdateInput) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceUpdateInput) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceUpdateInput) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceUpdateInput(val *SourceUpdateInput) *NullableSourceUpdateInput {
	return &NullableSourceUpdateInput{value: val, isSet: true}
}

func (v NullableSourceUpdateInput) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSourceUpdateInput) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
