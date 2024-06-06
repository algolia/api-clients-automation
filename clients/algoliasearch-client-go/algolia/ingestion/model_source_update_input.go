// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceUpdateInput - struct for SourceUpdateInput.
type SourceUpdateInput struct {
	SourceBigQuery            *SourceBigQuery
	SourceCSV                 *SourceCSV
	SourceGA4BigQueryExport   *SourceGA4BigQueryExport
	SourceJSON                *SourceJSON
	SourceUpdateCommercetools *SourceUpdateCommercetools
	SourceUpdateDocker        *SourceUpdateDocker
	SourceUpdateShopify       *SourceUpdateShopify
}

// SourceUpdateCommercetoolsAsSourceUpdateInput is a convenience function that returns SourceUpdateCommercetools wrapped in SourceUpdateInput.
func SourceUpdateCommercetoolsAsSourceUpdateInput(v *SourceUpdateCommercetools) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceUpdateCommercetools: v,
	}
}

// SourceJSONAsSourceUpdateInput is a convenience function that returns SourceJSON wrapped in SourceUpdateInput.
func SourceJSONAsSourceUpdateInput(v *SourceJSON) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceJSON: v,
	}
}

// SourceCSVAsSourceUpdateInput is a convenience function that returns SourceCSV wrapped in SourceUpdateInput.
func SourceCSVAsSourceUpdateInput(v *SourceCSV) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceCSV: v,
	}
}

// SourceBigQueryAsSourceUpdateInput is a convenience function that returns SourceBigQuery wrapped in SourceUpdateInput.
func SourceBigQueryAsSourceUpdateInput(v *SourceBigQuery) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceBigQuery: v,
	}
}

// SourceGA4BigQueryExportAsSourceUpdateInput is a convenience function that returns SourceGA4BigQueryExport wrapped in SourceUpdateInput.
func SourceGA4BigQueryExportAsSourceUpdateInput(v *SourceGA4BigQueryExport) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceGA4BigQueryExport: v,
	}
}

// SourceUpdateDockerAsSourceUpdateInput is a convenience function that returns SourceUpdateDocker wrapped in SourceUpdateInput.
func SourceUpdateDockerAsSourceUpdateInput(v *SourceUpdateDocker) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceUpdateDocker: v,
	}
}

// SourceUpdateShopifyAsSourceUpdateInput is a convenience function that returns SourceUpdateShopify wrapped in SourceUpdateInput.
func SourceUpdateShopifyAsSourceUpdateInput(v *SourceUpdateShopify) *SourceUpdateInput {
	return &SourceUpdateInput{
		SourceUpdateShopify: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *SourceUpdateInput) UnmarshalJSON(data []byte) error {
	var err error
	// use discriminator value to speed up the lookup
	var jsonDict map[string]any
	err = newStrictDecoder(data).Decode(&jsonDict)
	if err != nil {
		return fmt.Errorf("Failed to unmarshal JSON into map for the discriminator lookup (SourceGA4BigQueryExport).")
	}

	// Hold the schema validity between checks
	validSchemaForModel := true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'projectID'
		if _, ok := jsonDict["projectID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'datasetID'
		if _, ok := jsonDict["datasetID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'tablePrefix'
		if _, ok := jsonDict["tablePrefix"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into SourceGA4BigQueryExport
		err = newStrictDecoder(data).Decode(&dst.SourceGA4BigQueryExport)
		if err == nil && validateStruct(dst.SourceGA4BigQueryExport) == nil {
			jsonSourceGA4BigQueryExport, _ := json.Marshal(dst.SourceGA4BigQueryExport)
			if string(jsonSourceGA4BigQueryExport) == "{}" { // empty struct
				dst.SourceGA4BigQueryExport = nil
			} else {
				return nil
			}
		} else {
			dst.SourceGA4BigQueryExport = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'projectID'
		if _, ok := jsonDict["projectID"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
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
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true
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

	// try to unmarshal data into SourceUpdateShopify
	err = newStrictDecoder(data).Decode(&dst.SourceUpdateShopify)
	if err == nil && validateStruct(dst.SourceUpdateShopify) == nil {
		jsonSourceUpdateShopify, _ := json.Marshal(dst.SourceUpdateShopify)
		if string(jsonSourceUpdateShopify) == "{}" { // empty struct
			dst.SourceUpdateShopify = nil
		} else {
			return nil
		}
	} else {
		dst.SourceUpdateShopify = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(SourceUpdateInput)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src SourceUpdateInput) MarshalJSON() ([]byte, error) {
	if src.SourceBigQuery != nil {
		serialized, err := json.Marshal(&src.SourceBigQuery)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceBigQuery of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceCSV != nil {
		serialized, err := json.Marshal(&src.SourceCSV)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceCSV of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceGA4BigQueryExport != nil {
		serialized, err := json.Marshal(&src.SourceGA4BigQueryExport)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceGA4BigQueryExport of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceJSON != nil {
		serialized, err := json.Marshal(&src.SourceJSON)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceJSON of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceUpdateCommercetools != nil {
		serialized, err := json.Marshal(&src.SourceUpdateCommercetools)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceUpdateCommercetools of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceUpdateDocker != nil {
		serialized, err := json.Marshal(&src.SourceUpdateDocker)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceUpdateDocker of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	if src.SourceUpdateShopify != nil {
		serialized, err := json.Marshal(&src.SourceUpdateShopify)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SourceUpdateShopify of SourceUpdateInput: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj SourceUpdateInput) GetActualInstance() any {
	if obj.SourceBigQuery != nil {
		return *obj.SourceBigQuery
	}

	if obj.SourceCSV != nil {
		return *obj.SourceCSV
	}

	if obj.SourceGA4BigQueryExport != nil {
		return *obj.SourceGA4BigQueryExport
	}

	if obj.SourceJSON != nil {
		return *obj.SourceJSON
	}

	if obj.SourceUpdateCommercetools != nil {
		return *obj.SourceUpdateCommercetools
	}

	if obj.SourceUpdateDocker != nil {
		return *obj.SourceUpdateDocker
	}

	if obj.SourceUpdateShopify != nil {
		return *obj.SourceUpdateShopify
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
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSourceUpdateInput) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
