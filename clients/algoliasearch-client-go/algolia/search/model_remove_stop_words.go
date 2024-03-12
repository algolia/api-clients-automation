// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// RemoveStopWords - Removes stop words from the search query.  Stop words are common words like articles, conjunctions, prepositions, or pronouns that have little or no meaning on their own. In English, \"the\", \"a\", or \"and\" are stop words.  You should only use this feature for the languages used in your index.
type RemoveStopWords struct {
	ArrayOfString *[]string
	Bool          *bool
}

// []stringAsRemoveStopWords is a convenience function that returns []string wrapped in RemoveStopWords.
func ArrayOfStringAsRemoveStopWords(v []string) *RemoveStopWords {
	return &RemoveStopWords{
		ArrayOfString: &v,
	}
}

// boolAsRemoveStopWords is a convenience function that returns bool wrapped in RemoveStopWords.
func BoolAsRemoveStopWords(v bool) *RemoveStopWords {
	return &RemoveStopWords{
		Bool: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *RemoveStopWords) UnmarshalJSON(data []byte) error {
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

	return fmt.Errorf("Data failed to match schemas in oneOf(RemoveStopWords)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src RemoveStopWords) MarshalJSON() ([]byte, error) {
	if src.ArrayOfString != nil {
		serialized, err := json.Marshal(&src.ArrayOfString)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ArrayOfString of RemoveStopWords: %w", err)
		}

		return serialized, nil
	}

	if src.Bool != nil {
		serialized, err := json.Marshal(&src.Bool)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of Bool of RemoveStopWords: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj RemoveStopWords) GetActualInstance() any {
	if obj.ArrayOfString != nil {
		return *obj.ArrayOfString
	}

	if obj.Bool != nil {
		return *obj.Bool
	}

	// all schemas are nil
	return nil
}

type NullableRemoveStopWords struct {
	value *RemoveStopWords
	isSet bool
}

func (v NullableRemoveStopWords) Get() *RemoveStopWords {
	return v.value
}

func (v *NullableRemoveStopWords) Set(val *RemoveStopWords) {
	v.value = val
	v.isSet = true
}

func (v NullableRemoveStopWords) IsSet() bool {
	return v.isSet
}

func (v *NullableRemoveStopWords) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRemoveStopWords(val *RemoveStopWords) *NullableRemoveStopWords {
	return &NullableRemoveStopWords{value: val, isSet: true}
}

func (v NullableRemoveStopWords) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableRemoveStopWords) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
