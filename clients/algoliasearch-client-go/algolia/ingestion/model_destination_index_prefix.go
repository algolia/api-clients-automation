// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DestinationIndexPrefix struct for DestinationIndexPrefix.
type DestinationIndexPrefix struct {
	// The prefix of the final index name.
	IndexPrefix string `json:"indexPrefix"`
}

// NewDestinationIndexPrefix instantiates a new DestinationIndexPrefix object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDestinationIndexPrefix(indexPrefix string) *DestinationIndexPrefix {
	this := &DestinationIndexPrefix{}
	this.IndexPrefix = indexPrefix
	return this
}

// NewDestinationIndexPrefixWithDefaults instantiates a new DestinationIndexPrefix object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set.
func NewDestinationIndexPrefixWithDefaults() *DestinationIndexPrefix {
	this := &DestinationIndexPrefix{}
	return this
}

// GetIndexPrefix returns the IndexPrefix field value.
func (o *DestinationIndexPrefix) GetIndexPrefix() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexPrefix
}

// GetIndexPrefixOk returns a tuple with the IndexPrefix field value
// and a boolean to check if the value has been set.
func (o *DestinationIndexPrefix) GetIndexPrefixOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexPrefix, true
}

// SetIndexPrefix sets field value.
func (o *DestinationIndexPrefix) SetIndexPrefix(v string) {
	o.IndexPrefix = v
}

func (o DestinationIndexPrefix) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["indexPrefix"] = o.IndexPrefix
	}
	return json.Marshal(toSerialize)
}

func (o DestinationIndexPrefix) String() string {
	out := ""
	out += fmt.Sprintf("  indexPrefix=%v\n", o.IndexPrefix)
	return fmt.Sprintf("DestinationIndexPrefix {\n%s}", out)
}

type NullableDestinationIndexPrefix struct {
	value *DestinationIndexPrefix
	isSet bool
}

func (v NullableDestinationIndexPrefix) Get() *DestinationIndexPrefix {
	return v.value
}

func (v *NullableDestinationIndexPrefix) Set(val *DestinationIndexPrefix) {
	v.value = val
	v.isSet = true
}

func (v NullableDestinationIndexPrefix) IsSet() bool {
	return v.isSet
}

func (v *NullableDestinationIndexPrefix) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDestinationIndexPrefix(val *DestinationIndexPrefix) *NullableDestinationIndexPrefix {
	return &NullableDestinationIndexPrefix{value: val, isSet: true}
}

func (v NullableDestinationIndexPrefix) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableDestinationIndexPrefix) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
