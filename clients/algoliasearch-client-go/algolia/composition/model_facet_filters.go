// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// FacetFilters - Filter the search by facet values, so that only records with the same facet values are retrieved.  **Prefer using the `filters` parameter, which supports all filter types and combinations with boolean operators.**  - `[filter1, filter2]` is interpreted as `filter1 AND filter2`. - `[[filter1, filter2], filter3]` is interpreted as `filter1 OR filter2 AND filter3`. - `facet:-value` is interpreted as `NOT facet:value`.  While it's best to avoid attributes that start with a `-`, you can still filter them by escaping with a backslash: `facet:\\-value`.
type FacetFilters struct {
	ArrayOfFacetFilters *[]FacetFilters
	String              *string
}

// []FacetFiltersAsFacetFilters is a convenience function that returns []FacetFilters wrapped in FacetFilters.
func ArrayOfFacetFiltersAsFacetFilters(v []FacetFilters) *FacetFilters {
	return &FacetFilters{
		ArrayOfFacetFilters: &v,
	}
}

// stringAsFacetFilters is a convenience function that returns string wrapped in FacetFilters.
func StringAsFacetFilters(v string) *FacetFilters {
	return &FacetFilters{
		String: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *FacetFilters) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into ArrayOfFacetFilters
	err = newStrictDecoder(data).Decode(&dst.ArrayOfFacetFilters)
	if err == nil && validateStruct(dst.ArrayOfFacetFilters) == nil {
		return nil // found the correct type
	} else {
		dst.ArrayOfFacetFilters = nil
	}
	// try to unmarshal data into String
	err = newStrictDecoder(data).Decode(&dst.String)
	if err == nil && validateStruct(dst.String) == nil {
		return nil // found the correct type
	} else {
		dst.String = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(FacetFilters)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src FacetFilters) MarshalJSON() ([]byte, error) {
	if src.ArrayOfFacetFilters != nil {
		serialized, err := json.Marshal(&src.ArrayOfFacetFilters)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ArrayOfFacetFilters of FacetFilters: %w", err)
		}

		return serialized, nil
	}

	if src.String != nil {
		serialized, err := json.Marshal(&src.String)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of String of FacetFilters: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj FacetFilters) GetActualInstance() any {
	if obj.ArrayOfFacetFilters != nil {
		return *obj.ArrayOfFacetFilters
	}

	if obj.String != nil {
		return *obj.String
	}

	// all schemas are nil
	return nil
}
