// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendHits struct for RecommendHits
type RecommendHits struct {
	Hits []RecommendHit `json:"hits" validate:"required"`
	// Text to search for in an index.
	Query *string `json:"query,omitempty"`
	// URL-encoded string of all search parameters.
	Params *string `json:"params,omitempty"`
}

type RecommendHitsOption func(f *RecommendHits)

func WithRecommendHitsQuery(val string) RecommendHitsOption {
	return func(f *RecommendHits) {
		f.Query = &val
	}
}

func WithRecommendHitsParams(val string) RecommendHitsOption {
	return func(f *RecommendHits) {
		f.Params = &val
	}
}

// NewRecommendHits instantiates a new RecommendHits object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewRecommendHits(hits []RecommendHit, opts ...RecommendHitsOption) *RecommendHits {
	this := &RecommendHits{}
	this.Hits = hits
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewRecommendHitsWithDefaults instantiates a new RecommendHits object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewRecommendHitsWithDefaults() *RecommendHits {
	this := &RecommendHits{}
	var query string = ""
	this.Query = &query
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

// GetQuery returns the Query field value if set, zero value otherwise.
func (o *RecommendHits) GetQuery() string {
	if o == nil || o.Query == nil {
		var ret string
		return ret
	}
	return *o.Query
}

// GetQueryOk returns a tuple with the Query field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHits) GetQueryOk() (*string, bool) {
	if o == nil || o.Query == nil {
		return nil, false
	}
	return o.Query, true
}

// HasQuery returns a boolean if a field has been set.
func (o *RecommendHits) HasQuery() bool {
	if o != nil && o.Query != nil {
		return true
	}

	return false
}

// SetQuery gets a reference to the given string and assigns it to the Query field.
func (o *RecommendHits) SetQuery(v string) {
	o.Query = &v
}

// GetParams returns the Params field value if set, zero value otherwise.
func (o *RecommendHits) GetParams() string {
	if o == nil || o.Params == nil {
		var ret string
		return ret
	}
	return *o.Params
}

// GetParamsOk returns a tuple with the Params field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHits) GetParamsOk() (*string, bool) {
	if o == nil || o.Params == nil {
		return nil, false
	}
	return o.Params, true
}

// HasParams returns a boolean if a field has been set.
func (o *RecommendHits) HasParams() bool {
	if o != nil && o.Params != nil {
		return true
	}

	return false
}

// SetParams gets a reference to the given string and assigns it to the Params field.
func (o *RecommendHits) SetParams(v string) {
	o.Params = &v
}

func (o RecommendHits) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["hits"] = o.Hits
	}
	if o.Query != nil {
		toSerialize["query"] = o.Query
	}
	if o.Params != nil {
		toSerialize["params"] = o.Params
	}
	return json.Marshal(toSerialize)
}

func (o RecommendHits) String() string {
	out := ""
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	out += fmt.Sprintf("  query=%v\n", o.Query)
	out += fmt.Sprintf("  params=%v\n", o.Params)
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
