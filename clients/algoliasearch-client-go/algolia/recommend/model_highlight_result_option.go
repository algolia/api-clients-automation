// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// HighlightResultOption Surround words that match the query with HTML tags for highlighting.
type HighlightResultOption struct {
	// Highlighted attribute value, including HTML tags.
	Value      string     `json:"value"`
	MatchLevel MatchLevel `json:"matchLevel"`
	// List of matched words from the search query.
	MatchedWords []string `json:"matchedWords"`
	// Whether the entire attribute value is highlighted.
	FullyHighlighted *bool `json:"fullyHighlighted,omitempty"`
}

type HighlightResultOptionOption func(f *HighlightResultOption)

func WithHighlightResultOptionFullyHighlighted(val bool) HighlightResultOptionOption {
	return func(f *HighlightResultOption) {
		f.FullyHighlighted = &val
	}
}

// NewHighlightResultOption instantiates a new HighlightResultOption object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewHighlightResultOption(value string, matchLevel MatchLevel, matchedWords []string, opts ...HighlightResultOptionOption) *HighlightResultOption {
	this := &HighlightResultOption{}
	this.Value = value
	this.MatchLevel = matchLevel
	this.MatchedWords = matchedWords
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyHighlightResultOption return a pointer to an empty HighlightResultOption object.
func NewEmptyHighlightResultOption() *HighlightResultOption {
	return &HighlightResultOption{}
}

// GetValue returns the Value field value.
func (o *HighlightResultOption) GetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *HighlightResultOption) GetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value.
func (o *HighlightResultOption) SetValue(v string) *HighlightResultOption {
	o.Value = v
	return o
}

// GetMatchLevel returns the MatchLevel field value.
func (o *HighlightResultOption) GetMatchLevel() MatchLevel {
	if o == nil {
		var ret MatchLevel
		return ret
	}

	return o.MatchLevel
}

// GetMatchLevelOk returns a tuple with the MatchLevel field value
// and a boolean to check if the value has been set.
func (o *HighlightResultOption) GetMatchLevelOk() (*MatchLevel, bool) {
	if o == nil {
		return nil, false
	}
	return &o.MatchLevel, true
}

// SetMatchLevel sets field value.
func (o *HighlightResultOption) SetMatchLevel(v MatchLevel) *HighlightResultOption {
	o.MatchLevel = v
	return o
}

// GetMatchedWords returns the MatchedWords field value.
func (o *HighlightResultOption) GetMatchedWords() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.MatchedWords
}

// GetMatchedWordsOk returns a tuple with the MatchedWords field value
// and a boolean to check if the value has been set.
func (o *HighlightResultOption) GetMatchedWordsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.MatchedWords, true
}

// SetMatchedWords sets field value.
func (o *HighlightResultOption) SetMatchedWords(v []string) *HighlightResultOption {
	o.MatchedWords = v
	return o
}

// GetFullyHighlighted returns the FullyHighlighted field value if set, zero value otherwise.
func (o *HighlightResultOption) GetFullyHighlighted() bool {
	if o == nil || o.FullyHighlighted == nil {
		var ret bool
		return ret
	}
	return *o.FullyHighlighted
}

// GetFullyHighlightedOk returns a tuple with the FullyHighlighted field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *HighlightResultOption) GetFullyHighlightedOk() (*bool, bool) {
	if o == nil || o.FullyHighlighted == nil {
		return nil, false
	}
	return o.FullyHighlighted, true
}

// HasFullyHighlighted returns a boolean if a field has been set.
func (o *HighlightResultOption) HasFullyHighlighted() bool {
	if o != nil && o.FullyHighlighted != nil {
		return true
	}

	return false
}

// SetFullyHighlighted gets a reference to the given bool and assigns it to the FullyHighlighted field.
func (o *HighlightResultOption) SetFullyHighlighted(v bool) *HighlightResultOption {
	o.FullyHighlighted = &v
	return o
}

func (o HighlightResultOption) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["value"] = o.Value
	}
	if true {
		toSerialize["matchLevel"] = o.MatchLevel
	}
	if true {
		toSerialize["matchedWords"] = o.MatchedWords
	}
	if o.FullyHighlighted != nil {
		toSerialize["fullyHighlighted"] = o.FullyHighlighted
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal HighlightResultOption: %w", err)
	}

	return serialized, nil
}

func (o HighlightResultOption) String() string {
	out := ""
	out += fmt.Sprintf("  value=%v\n", o.Value)
	out += fmt.Sprintf("  matchLevel=%v\n", o.MatchLevel)
	out += fmt.Sprintf("  matchedWords=%v\n", o.MatchedWords)
	out += fmt.Sprintf("  fullyHighlighted=%v\n", o.FullyHighlighted)
	return fmt.Sprintf("HighlightResultOption {\n%s}", out)
}
