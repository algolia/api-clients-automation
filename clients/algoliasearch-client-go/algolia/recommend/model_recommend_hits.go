// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendHits struct for RecommendHits
type RecommendHits struct {
	Hits []RecommendHit `json:"hits"`
}

// NewRecommendHits instantiates a new RecommendHits object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewRecommendHits(hits []RecommendHit) *RecommendHits {
	this := &RecommendHits{}
	this.Hits = hits
	return this
}

// NewRecommendHitsWithDefaults instantiates a new RecommendHits object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewRecommendHitsWithDefaults() *RecommendHits {
	this := &RecommendHits{}
	return this
}

// GetHits returns the Hits field value
func (o *RecommendHits) GetHits() []RecommendHit {
	if o == nil {
		var ret []RecommendHit
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *RecommendHits) GetHitsOk() ([]RecommendHit, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value
func (o *RecommendHits) SetHits(v []RecommendHit) {
	o.Hits = v
}

func (o RecommendHits) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["hits"] = o.Hits
	}
	return json.Marshal(toSerialize)
}

func (o RecommendHits) String() string {
	out := ""
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	return fmt.Sprintf("RecommendHits {\n%s}", out)
}

type NullableRecommendHits struct {
	value *RecommendHits
	isSet bool
}

func (v NullableRecommendHits) Get() *RecommendHits {
	return v.value
}

func (v *NullableRecommendHits) Set(val *RecommendHits) {
	v.value = val
	v.isSet = true
}

func (v NullableRecommendHits) IsSet() bool {
	return v.isSet
}

func (v *NullableRecommendHits) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRecommendHits(val *RecommendHits) *NullableRecommendHits {
	return &NullableRecommendHits{value: val, isSet: true}
}

func (v NullableRecommendHits) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRecommendHits) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
