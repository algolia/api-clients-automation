// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SemanticSearch Settings for the semantic search part of NeuralSearch. Only used when `mode` is _neuralSearch_.
type SemanticSearch struct {
	// Indices from which to collect click and conversion events. If null, the current index and replica group will be used as the event source.
	EventSources []string `json:"eventSources,omitempty"`
}

type SemanticSearchOption func(f *SemanticSearch)

func WithSemanticSearchEventSources(val []string) SemanticSearchOption {
	return func(f *SemanticSearch) {
		f.EventSources = val
	}
}

// NewSemanticSearch instantiates a new SemanticSearch object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSemanticSearch(opts ...SemanticSearchOption) *SemanticSearch {
	this := &SemanticSearch{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySemanticSearch return a pointer to an empty SemanticSearch object.
func NewEmptySemanticSearch() *SemanticSearch {
	return &SemanticSearch{}
}

// GetEventSources returns the EventSources field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *SemanticSearch) GetEventSources() []string {
	if o == nil {
		var ret []string
		return ret
	}
	return o.EventSources
}

// GetEventSourcesOk returns a tuple with the EventSources field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *SemanticSearch) GetEventSourcesOk() ([]string, bool) {
	if o == nil || o.EventSources == nil {
		return nil, false
	}
	return o.EventSources, true
}

// HasEventSources returns a boolean if a field has been set.
func (o *SemanticSearch) HasEventSources() bool {
	if o != nil && o.EventSources != nil {
		return true
	}

	return false
}

// SetEventSources gets a reference to the given []string and assigns it to the EventSources field.
func (o *SemanticSearch) SetEventSources(v []string) *SemanticSearch {
	o.EventSources = v
	return o
}

func (o SemanticSearch) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.EventSources != nil {
		toSerialize["eventSources"] = o.EventSources
	}
	return json.Marshal(toSerialize)
}

func (o SemanticSearch) String() string {
	out := ""
	out += fmt.Sprintf("  eventSources=%v\n", o.EventSources)
	return fmt.Sprintf("SemanticSearch {\n%s}", out)
}

type NullableSemanticSearch struct {
	value *SemanticSearch
	isSet bool
}

func (v NullableSemanticSearch) Get() *SemanticSearch {
	return v.value
}

func (v *NullableSemanticSearch) Set(val *SemanticSearch) {
	v.value = val
	v.isSet = true
}

func (v NullableSemanticSearch) IsSet() bool {
	return v.isSet
}

func (v *NullableSemanticSearch) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSemanticSearch(val *SemanticSearch) *NullableSemanticSearch {
	return &NullableSemanticSearch{value: val, isSet: true}
}

func (v NullableSemanticSearch) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSemanticSearch) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
