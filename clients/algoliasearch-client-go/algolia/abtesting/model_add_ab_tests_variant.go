// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package abtesting

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// AddABTestsVariant - struct for AddABTestsVariant.
type AddABTestsVariant struct {
	AbTestsVariant             *AbTestsVariant
	AbTestsVariantSearchParams *AbTestsVariantSearchParams
}

// AbTestsVariantSearchParamsAsAddABTestsVariant is a convenience function that returns AbTestsVariantSearchParams wrapped in AddABTestsVariant.
func AbTestsVariantSearchParamsAsAddABTestsVariant(v *AbTestsVariantSearchParams) *AddABTestsVariant {
	return &AddABTestsVariant{
		AbTestsVariantSearchParams: v,
	}
}

// AbTestsVariantAsAddABTestsVariant is a convenience function that returns AbTestsVariant wrapped in AddABTestsVariant.
func AbTestsVariantAsAddABTestsVariant(v *AbTestsVariant) *AddABTestsVariant {
	return &AddABTestsVariant{
		AbTestsVariant: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *AddABTestsVariant) UnmarshalJSON(data []byte) error {
	var err error
	// use discriminator value to speed up the lookup if possible, if not we will try every possibility
	var jsonDict map[string]any
	_ = newStrictDecoder(data).Decode(&jsonDict)
	if utils.HasKey(jsonDict, "customSearchParameters") {
		// try to unmarshal data into AbTestsVariantSearchParams
		err = newStrictDecoder(data).Decode(&dst.AbTestsVariantSearchParams)
		if err == nil && validateStruct(dst.AbTestsVariantSearchParams) == nil {
			return nil // found the correct type
		} else {
			dst.AbTestsVariantSearchParams = nil
		}
	}
	// try to unmarshal data into AbTestsVariant
	err = newStrictDecoder(data).Decode(&dst.AbTestsVariant)
	if err == nil && validateStruct(dst.AbTestsVariant) == nil {
		return nil // found the correct type
	} else {
		dst.AbTestsVariant = nil
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
func (obj AddABTestsVariant) GetActualInstance() any {
	if obj.AbTestsVariant != nil {
		return *obj.AbTestsVariant
	}

	if obj.AbTestsVariantSearchParams != nil {
		return *obj.AbTestsVariantSearchParams
	}

	// all schemas are nil
	return nil
}
