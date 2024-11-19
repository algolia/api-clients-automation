// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// OptionalWords - struct for OptionalWords.
type OptionalWords struct {
	ArrayOfString *[]string
	String        *string
}

// stringAsOptionalWords is a convenience function that returns string wrapped in OptionalWords.
func StringAsOptionalWords(v string) *OptionalWords {
	return &OptionalWords{
		String: &v,
	}
}

// []stringAsOptionalWords is a convenience function that returns []string wrapped in OptionalWords.
func ArrayOfStringAsOptionalWords(v []string) *OptionalWords {
	return &OptionalWords{
		ArrayOfString: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *OptionalWords) UnmarshalJSON(data []byte) error {
	var err error
	// this object is nullable so check if the payload is null or empty string
	if string(data) == "" || string(data) == "{}" {
		return nil
	}

	// try to unmarshal data into String
	err = newStrictDecoder(data).Decode(&dst.String)
	if err == nil && validateStruct(dst.String) == nil {
		return nil // found the correct type
	} else {
		dst.String = nil
	}
	// try to unmarshal data into ArrayOfString
	err = newStrictDecoder(data).Decode(&dst.ArrayOfString)
	if err == nil && validateStruct(dst.ArrayOfString) == nil {
		return nil // found the correct type
	} else {
		dst.ArrayOfString = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(OptionalWords)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src OptionalWords) MarshalJSON() ([]byte, error) {
	if src.ArrayOfString != nil {
		serialized, err := json.Marshal(&src.ArrayOfString)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ArrayOfString of OptionalWords: %w", err)
		}

		return serialized, nil
	}

	if src.String != nil {
		serialized, err := json.Marshal(&src.String)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of String of OptionalWords: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj OptionalWords) GetActualInstance() any {
	if obj.ArrayOfString != nil {
		return *obj.ArrayOfString
	}

	if obj.String != nil {
		return *obj.String
	}

	// all schemas are nil
	return nil
}