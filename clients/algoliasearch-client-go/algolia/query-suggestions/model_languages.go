// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package suggestions

import (
	"encoding/json"
	"fmt"
)

// Languages - Set the language for deduplicating singular and plural suggestions. If specified, only the more popular form is included.
type Languages struct {
	ArrayOfString *[]string
	Bool          *bool
}

// []stringAsLanguages is a convenience function that returns []string wrapped in Languages.
func ArrayOfStringAsLanguages(v []string) *Languages {
	return &Languages{
		ArrayOfString: &v,
	}
}

// boolAsLanguages is a convenience function that returns bool wrapped in Languages.
func BoolAsLanguages(v bool) *Languages {
	return &Languages{
		Bool: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *Languages) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into ArrayOfString
	err = newStrictDecoder(data).Decode(&dst.ArrayOfString)
	if err == nil && validateStruct(dst.ArrayOfString) == nil {
		jsonArrayOfString, _ := json.Marshal(dst.ArrayOfString)
		if string(jsonArrayOfString) == "{}" { // empty struct
			dst.ArrayOfString = nil
		} else {
			return nil
		}
	} else {
		dst.ArrayOfString = nil
	}

	// try to unmarshal data into Bool
	err = newStrictDecoder(data).Decode(&dst.Bool)
	if err == nil && validateStruct(dst.Bool) == nil {
		jsonBool, _ := json.Marshal(dst.Bool)
		if string(jsonBool) == "{}" { // empty struct
			dst.Bool = nil
		} else {
			return nil
		}
	} else {
		dst.Bool = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(Languages)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src Languages) MarshalJSON() ([]byte, error) {
	if src.ArrayOfString != nil {
		return json.Marshal(&src.ArrayOfString)
	}

	if src.Bool != nil {
		return json.Marshal(&src.Bool)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *Languages) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.ArrayOfString != nil {
		return obj.ArrayOfString
	}

	if obj.Bool != nil {
		return obj.Bool
	}

	// all schemas are nil
	return nil
}

type NullableLanguages struct {
	value *Languages
	isSet bool
}

func (v NullableLanguages) Get() *Languages {
	return v.value
}

func (v *NullableLanguages) Set(val *Languages) {
	v.value = val
	v.isSet = true
}

func (v NullableLanguages) IsSet() bool {
	return v.isSet
}

func (v *NullableLanguages) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableLanguages(val *Languages) *NullableLanguages {
	return &NullableLanguages{value: val, isSet: true}
}

func (v NullableLanguages) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableLanguages) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
