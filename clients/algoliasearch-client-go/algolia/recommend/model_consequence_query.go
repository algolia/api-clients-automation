// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// ConsequenceQuery - When providing a string, it replaces the entire query string. When providing an object, it describes incremental edits to be made to the query string (but you can't do both).
type ConsequenceQuery struct {
	ConsequenceQueryObject *ConsequenceQueryObject
	String                 *string
}

// ConsequenceQueryObjectAsConsequenceQuery is a convenience function that returns ConsequenceQueryObject wrapped in ConsequenceQuery.
func ConsequenceQueryObjectAsConsequenceQuery(v *ConsequenceQueryObject) *ConsequenceQuery {
	return &ConsequenceQuery{
		ConsequenceQueryObject: v,
	}
}

// stringAsConsequenceQuery is a convenience function that returns string wrapped in ConsequenceQuery.
func StringAsConsequenceQuery(v string) *ConsequenceQuery {
	return &ConsequenceQuery{
		String: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *ConsequenceQuery) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into ConsequenceQueryObject
	err = newStrictDecoder(data).Decode(&dst.ConsequenceQueryObject)
	if err == nil && validateStruct(dst.ConsequenceQueryObject) == nil {
		jsonConsequenceQueryObject, _ := json.Marshal(dst.ConsequenceQueryObject)
		if string(jsonConsequenceQueryObject) == "{}" { // empty struct
			dst.ConsequenceQueryObject = nil
		} else {
			return nil
		}
	} else {
		dst.ConsequenceQueryObject = nil
	}

	// try to unmarshal data into String
	err = newStrictDecoder(data).Decode(&dst.String)
	if err == nil && validateStruct(dst.String) == nil {
		jsonString, _ := json.Marshal(dst.String)
		if string(jsonString) == "{}" { // empty struct
			dst.String = nil
		} else {
			return nil
		}
	} else {
		dst.String = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(ConsequenceQuery)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src ConsequenceQuery) MarshalJSON() ([]byte, error) {
	if src.ConsequenceQueryObject != nil {
		serialized, err := json.Marshal(&src.ConsequenceQueryObject)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ConsequenceQueryObject of ConsequenceQuery: %w", err)
		}

		return serialized, nil
	}

	if src.String != nil {
		serialized, err := json.Marshal(&src.String)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of String of ConsequenceQuery: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj ConsequenceQuery) GetActualInstance() any {
	if obj.ConsequenceQueryObject != nil {
		return *obj.ConsequenceQueryObject
	}

	if obj.String != nil {
		return *obj.String
	}

	// all schemas are nil
	return nil
}

type NullableConsequenceQuery struct {
	value *ConsequenceQuery
	isSet bool
}

func (v NullableConsequenceQuery) Get() *ConsequenceQuery {
	return v.value
}

func (v *NullableConsequenceQuery) Set(val *ConsequenceQuery) {
	v.value = val
	v.isSet = true
}

func (v NullableConsequenceQuery) IsSet() bool {
	return v.isSet
}

func (v *NullableConsequenceQuery) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableConsequenceQuery(val *ConsequenceQuery) *NullableConsequenceQuery {
	return &NullableConsequenceQuery{value: val, isSet: true}
}

func (v NullableConsequenceQuery) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableConsequenceQuery) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
