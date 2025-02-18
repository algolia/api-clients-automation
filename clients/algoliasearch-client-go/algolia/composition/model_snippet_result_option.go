// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// SnippetResultOption Snippets that show the context around a matching search query.
type SnippetResultOption struct {
	// Highlighted attribute value, including HTML tags.
	Value      string     `json:"value"`
	MatchLevel MatchLevel `json:"matchLevel"`
}

// NewSnippetResultOption instantiates a new SnippetResultOption object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSnippetResultOption(value string, matchLevel MatchLevel) *SnippetResultOption {
	this := &SnippetResultOption{}
	this.Value = value
	this.MatchLevel = matchLevel
	return this
}

// NewEmptySnippetResultOption return a pointer to an empty SnippetResultOption object.
func NewEmptySnippetResultOption() *SnippetResultOption {
	return &SnippetResultOption{}
}

// GetValue returns the Value field value.
func (o *SnippetResultOption) GetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *SnippetResultOption) GetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value.
func (o *SnippetResultOption) SetValue(v string) *SnippetResultOption {
	o.Value = v
	return o
}

// GetMatchLevel returns the MatchLevel field value.
func (o *SnippetResultOption) GetMatchLevel() MatchLevel {
	if o == nil {
		var ret MatchLevel
		return ret
	}

	return o.MatchLevel
}

// GetMatchLevelOk returns a tuple with the MatchLevel field value
// and a boolean to check if the value has been set.
func (o *SnippetResultOption) GetMatchLevelOk() (*MatchLevel, bool) {
	if o == nil {
		return nil, false
	}
	return &o.MatchLevel, true
}

// SetMatchLevel sets field value.
func (o *SnippetResultOption) SetMatchLevel(v MatchLevel) *SnippetResultOption {
	o.MatchLevel = v
	return o
}

func (o SnippetResultOption) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["value"] = o.Value
	}
	if true {
		toSerialize["matchLevel"] = o.MatchLevel
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SnippetResultOption: %w", err)
	}

	return serialized, nil
}

func (o SnippetResultOption) String() string {
	out := ""
	out += fmt.Sprintf("  value=%v\n", o.Value)
	out += fmt.Sprintf("  matchLevel=%v\n", o.MatchLevel)
	return fmt.Sprintf("SnippetResultOption {\n%s}", out)
}
