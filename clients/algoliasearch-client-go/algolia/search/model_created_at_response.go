// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// CreatedAtResponse The response with a createdAt timestamp.
type CreatedAtResponse struct {
	// Date of creation (ISO-8601 format).
	CreatedAt string `json:"createdAt"`
}

// NewCreatedAtResponse instantiates a new CreatedAtResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewCreatedAtResponse(createdAt string) *CreatedAtResponse {
	this := &CreatedAtResponse{}
	this.CreatedAt = createdAt
	return this
}

// NewCreatedAtResponseWithDefaults instantiates a new CreatedAtResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewCreatedAtResponseWithDefaults() *CreatedAtResponse {
	this := &CreatedAtResponse{}
	return this
}

// GetCreatedAt returns the CreatedAt field value
func (o *CreatedAtResponse) GetCreatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *CreatedAtResponse) GetCreatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value
func (o *CreatedAtResponse) SetCreatedAt(v string) {
	o.CreatedAt = v
}

func (o CreatedAtResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["createdAt"] = o.CreatedAt
	}
	return json.Marshal(toSerialize)
}

func (o CreatedAtResponse) String() string {
	out := ""
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	return fmt.Sprintf("CreatedAtResponse {\n%s}", out)
}

type NullableCreatedAtResponse struct {
	value *CreatedAtResponse
	isSet bool
}

func (v NullableCreatedAtResponse) Get() *CreatedAtResponse {
	return v.value
}

func (v *NullableCreatedAtResponse) Set(val *CreatedAtResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableCreatedAtResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableCreatedAtResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableCreatedAtResponse(val *CreatedAtResponse) *NullableCreatedAtResponse {
	return &NullableCreatedAtResponse{value: val, isSet: true}
}

func (v NullableCreatedAtResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableCreatedAtResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
