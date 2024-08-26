// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// IgnorePlurals - Treat singular, plurals, and other forms of declensions as equivalent. You should only use this feature for the languages used in your index.
type IgnorePlurals struct {
	ArrayOfSupportedLanguage *[]SupportedLanguage
	Bool                     *bool
}

// []SupportedLanguageAsIgnorePlurals is a convenience function that returns []SupportedLanguage wrapped in IgnorePlurals.
func ArrayOfSupportedLanguageAsIgnorePlurals(v []SupportedLanguage) *IgnorePlurals {
	return &IgnorePlurals{
		ArrayOfSupportedLanguage: &v,
	}
}

// boolAsIgnorePlurals is a convenience function that returns bool wrapped in IgnorePlurals.
func BoolAsIgnorePlurals(v bool) *IgnorePlurals {
	return &IgnorePlurals{
		Bool: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *IgnorePlurals) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into ArrayOfSupportedLanguage
	err = newStrictDecoder(data).Decode(&dst.ArrayOfSupportedLanguage)
	if err == nil && validateStruct(dst.ArrayOfSupportedLanguage) == nil {
		return nil // found the correct type
	} else {
		dst.ArrayOfSupportedLanguage = nil
	}
	// try to unmarshal data into Bool
	err = newStrictDecoder(data).Decode(&dst.Bool)
	if err == nil && validateStruct(dst.Bool) == nil {
		return nil // found the correct type
	} else {
		dst.Bool = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(IgnorePlurals)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src IgnorePlurals) MarshalJSON() ([]byte, error) {
	if src.ArrayOfSupportedLanguage != nil {
		serialized, err := json.Marshal(&src.ArrayOfSupportedLanguage)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ArrayOfSupportedLanguage of IgnorePlurals: %w", err)
		}

		return serialized, nil
	}

	if src.Bool != nil {
		serialized, err := json.Marshal(&src.Bool)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of Bool of IgnorePlurals: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj IgnorePlurals) GetActualInstance() any {
	if obj.ArrayOfSupportedLanguage != nil {
		return *obj.ArrayOfSupportedLanguage
	}

	if obj.Bool != nil {
		return *obj.Bool
	}

	// all schemas are nil
	return nil
}
