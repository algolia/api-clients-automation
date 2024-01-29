// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package analytics

import (
	"encoding/json"
	"fmt"
)

// TopSearchesResponse struct for TopSearchesResponse.
type TopSearchesResponse struct {
	// Top searches with their hits count.
	Searches []TopSearch `json:"searches"`
}

// NewTopSearchesResponse instantiates a new TopSearchesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTopSearchesResponse(searches []TopSearch) *TopSearchesResponse {
	this := &TopSearchesResponse{}
	this.Searches = searches
	return this
}

// NewEmptyTopSearchesResponse return a pointer to an empty TopSearchesResponse object.
func NewEmptyTopSearchesResponse() *TopSearchesResponse {
	return &TopSearchesResponse{}
}

// GetSearches returns the Searches field value.
func (o *TopSearchesResponse) GetSearches() []TopSearch {
	if o == nil {
		var ret []TopSearch
		return ret
	}

	return o.Searches
}

// GetSearchesOk returns a tuple with the Searches field value
// and a boolean to check if the value has been set.
func (o *TopSearchesResponse) GetSearchesOk() ([]TopSearch, bool) {
	if o == nil {
		return nil, false
	}
	return o.Searches, true
}

// SetSearches sets field value.
func (o *TopSearchesResponse) SetSearches(v []TopSearch) *TopSearchesResponse {
	o.Searches = v
	return o
}

func (o TopSearchesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["searches"] = o.Searches
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TopSearchesResponse: %w", err)
	}

	return serialized, nil
}

func (o TopSearchesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  searches=%v\n", o.Searches)
	return fmt.Sprintf("TopSearchesResponse {\n%s}", out)
}

type NullableTopSearchesResponse struct {
	value *TopSearchesResponse
	isSet bool
}

func (v NullableTopSearchesResponse) Get() *TopSearchesResponse {
	return v.value
}

func (v *NullableTopSearchesResponse) Set(val *TopSearchesResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableTopSearchesResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableTopSearchesResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTopSearchesResponse(val *TopSearchesResponse) *NullableTopSearchesResponse {
	return &NullableTopSearchesResponse{value: val, isSet: true}
}

func (v NullableTopSearchesResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTopSearchesResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
