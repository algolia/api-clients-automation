// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RemoveStopWords - Removes stop words from the search query.  Stop words are common words like articles, conjunctions, prepositions, or pronouns that have little or no meaning on their own. In English, \"the\", \"a\", or \"and\" are stop words.  You should only use this feature for the languages used in your index.
type RemoveStopWords struct {
	ArrayOfSupportedLanguage *[]SupportedLanguage
	Bool                     *bool
}

// []SupportedLanguageAsRemoveStopWords is a convenience function that returns []SupportedLanguage wrapped in RemoveStopWords.
func ArrayOfSupportedLanguageAsRemoveStopWords(v []SupportedLanguage) *RemoveStopWords {
	return &RemoveStopWords{
		ArrayOfSupportedLanguage: &v,
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
	// try to unmarshal data into ArrayOfSupportedLanguage
	err = json.Unmarshal(data, &dst.ArrayOfSupportedLanguage)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.ArrayOfSupportedLanguage = nil
	}
	// try to unmarshal data into Bool
	err = json.Unmarshal(data, &dst.Bool)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.Bool = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(RemoveStopWords)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src RemoveStopWords) MarshalJSON() ([]byte, error) {
	if src.ArrayOfSupportedLanguage != nil {
		serialized, err := json.Marshal(&src.ArrayOfSupportedLanguage)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ArrayOfSupportedLanguage of RemoveStopWords: %w", err)
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
	if obj.ArrayOfSupportedLanguage != nil {
		return *obj.ArrayOfSupportedLanguage
	}

	if obj.Bool != nil {
		return *obj.Bool
	}

	// all schemas are nil
	return nil
}
