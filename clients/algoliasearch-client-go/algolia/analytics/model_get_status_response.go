// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetStatusResponse struct for GetStatusResponse.
type GetStatusResponse struct {
	// Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
	UpdatedAt string `json:"updatedAt"`
}

// NewGetStatusResponse instantiates a new GetStatusResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetStatusResponse(updatedAt string) *GetStatusResponse {
	this := &GetStatusResponse{}
	this.UpdatedAt = updatedAt
	return this
}

// NewEmptyGetStatusResponse return a pointer to an empty GetStatusResponse object.
func NewEmptyGetStatusResponse() *GetStatusResponse {
	return &GetStatusResponse{}
}

// GetUpdatedAt returns the UpdatedAt field value.
func (o *GetStatusResponse) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *GetStatusResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value.
func (o *GetStatusResponse) SetUpdatedAt(v string) *GetStatusResponse {
	o.UpdatedAt = v
	return o
}

func (o GetStatusResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["updatedAt"] = o.UpdatedAt
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetStatusResponse: %w", err)
	}

	return serialized, nil
}

func (o GetStatusResponse) String() string {
	out := ""
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	return fmt.Sprintf("GetStatusResponse {\n%s}", out)
}

type NullableGetStatusResponse struct {
	value *GetStatusResponse
	isSet bool
}

func (v NullableGetStatusResponse) Get() *GetStatusResponse {
	return v.value
}

func (v *NullableGetStatusResponse) Set(val *GetStatusResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetStatusResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetStatusResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetStatusResponse(val *GetStatusResponse) *NullableGetStatusResponse {
	return &NullableGetStatusResponse{value: val, isSet: true}
}

func (v NullableGetStatusResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableGetStatusResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
