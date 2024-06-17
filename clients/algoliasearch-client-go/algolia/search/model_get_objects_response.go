// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// GetObjectsResponse struct for GetObjectsResponse.
type GetObjectsResponse struct {
	// Retrieved records.
	Results []map[string]any `json:"results"`
}

// NewGetObjectsResponse instantiates a new GetObjectsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetObjectsResponse(results []map[string]any) *GetObjectsResponse {
	this := &GetObjectsResponse{}
	this.Results = results
	return this
}

// NewEmptyGetObjectsResponse return a pointer to an empty GetObjectsResponse object.
func NewEmptyGetObjectsResponse() *GetObjectsResponse {
	return &GetObjectsResponse{}
}

// GetResults returns the Results field value.
func (o *GetObjectsResponse) GetResults() []map[string]any {
	if o == nil {
		var ret []map[string]any
		return ret
	}

	return o.Results
}

// GetResultsOk returns a tuple with the Results field value
// and a boolean to check if the value has been set.
func (o *GetObjectsResponse) GetResultsOk() ([]map[string]any, bool) {
	if o == nil {
		return nil, false
	}
	return o.Results, true
}

// SetResults sets field value.
func (o *GetObjectsResponse) SetResults(v []map[string]any) *GetObjectsResponse {
	o.Results = v
	return o
}

func (o GetObjectsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["results"] = o.Results
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetObjectsResponse: %w", err)
	}

	return serialized, nil
}

func (o GetObjectsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  results=%v\n", o.Results)
	return fmt.Sprintf("GetObjectsResponse {\n%s}", out)
}

type NullableGetObjectsResponse struct {
	value *GetObjectsResponse
	isSet bool
}

func (v NullableGetObjectsResponse) Get() *GetObjectsResponse {
	return v.value
}

func (v *NullableGetObjectsResponse) Set(val *GetObjectsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetObjectsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetObjectsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetObjectsResponse(val *GetObjectsResponse) *NullableGetObjectsResponse {
	return &NullableGetObjectsResponse{value: val, isSet: true}
}

func (v NullableGetObjectsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableGetObjectsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
