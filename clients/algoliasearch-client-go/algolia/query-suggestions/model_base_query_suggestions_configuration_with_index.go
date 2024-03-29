// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package suggestions

import (
	"encoding/json"
	"fmt"
)

// BaseQuerySuggestionsConfigurationWithIndex struct for BaseQuerySuggestionsConfigurationWithIndex.
type BaseQuerySuggestionsConfigurationWithIndex struct {
	// Query Suggestions index name.
	IndexName string `json:"indexName"`
}

// NewBaseQuerySuggestionsConfigurationWithIndex instantiates a new BaseQuerySuggestionsConfigurationWithIndex object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBaseQuerySuggestionsConfigurationWithIndex(indexName string) *BaseQuerySuggestionsConfigurationWithIndex {
	this := &BaseQuerySuggestionsConfigurationWithIndex{}
	this.IndexName = indexName
	return this
}

// NewEmptyBaseQuerySuggestionsConfigurationWithIndex return a pointer to an empty BaseQuerySuggestionsConfigurationWithIndex object.
func NewEmptyBaseQuerySuggestionsConfigurationWithIndex() *BaseQuerySuggestionsConfigurationWithIndex {
	return &BaseQuerySuggestionsConfigurationWithIndex{}
}

// GetIndexName returns the IndexName field value.
func (o *BaseQuerySuggestionsConfigurationWithIndex) GetIndexName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value
// and a boolean to check if the value has been set.
func (o *BaseQuerySuggestionsConfigurationWithIndex) GetIndexNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexName, true
}

// SetIndexName sets field value.
func (o *BaseQuerySuggestionsConfigurationWithIndex) SetIndexName(v string) *BaseQuerySuggestionsConfigurationWithIndex {
	o.IndexName = v
	return o
}

func (o BaseQuerySuggestionsConfigurationWithIndex) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["indexName"] = o.IndexName
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal BaseQuerySuggestionsConfigurationWithIndex: %w", err)
	}

	return serialized, nil
}

func (o BaseQuerySuggestionsConfigurationWithIndex) String() string {
	out := ""
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	return fmt.Sprintf("BaseQuerySuggestionsConfigurationWithIndex {\n%s}", out)
}

type NullableBaseQuerySuggestionsConfigurationWithIndex struct {
	value *BaseQuerySuggestionsConfigurationWithIndex
	isSet bool
}

func (v NullableBaseQuerySuggestionsConfigurationWithIndex) Get() *BaseQuerySuggestionsConfigurationWithIndex {
	return v.value
}

func (v *NullableBaseQuerySuggestionsConfigurationWithIndex) Set(val *BaseQuerySuggestionsConfigurationWithIndex) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseQuerySuggestionsConfigurationWithIndex) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseQuerySuggestionsConfigurationWithIndex) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseQuerySuggestionsConfigurationWithIndex(val *BaseQuerySuggestionsConfigurationWithIndex) *NullableBaseQuerySuggestionsConfigurationWithIndex {
	return &NullableBaseQuerySuggestionsConfigurationWithIndex{value: val, isSet: true}
}

func (v NullableBaseQuerySuggestionsConfigurationWithIndex) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableBaseQuerySuggestionsConfigurationWithIndex) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
