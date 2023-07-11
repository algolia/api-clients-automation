// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// StatusResponse struct for StatusResponse
type StatusResponse struct {
	Status *map[string]Status `json:"status,omitempty"`
}

type StatusResponseOption func(f *StatusResponse)

func WithStatusResponseStatus(val map[string]Status) StatusResponseOption {
	return func(f *StatusResponse) {
		f.Status = &val
	}
}

// NewStatusResponse instantiates a new StatusResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewStatusResponse(opts ...StatusResponseOption) *StatusResponse {
	this := &StatusResponse{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewStatusResponseWithDefaults instantiates a new StatusResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewStatusResponseWithDefaults() *StatusResponse {
	this := &StatusResponse{}
	return this
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *StatusResponse) GetStatus() map[string]Status {
	if o == nil || o.Status == nil {
		var ret map[string]Status
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *StatusResponse) GetStatusOk() (*map[string]Status, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *StatusResponse) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given map[string]Status and assigns it to the Status field.
func (o *StatusResponse) SetStatus(v map[string]Status) {
	o.Status = &v
}

func (o StatusResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	return json.Marshal(toSerialize)
}

func (o StatusResponse) String() string {
	out := ""
	out += fmt.Sprintf("  status=%v\n", o.Status)
	return fmt.Sprintf("StatusResponse {\n%s}", out)
}

type NullableStatusResponse struct {
	value *StatusResponse
	isSet bool
}

func (v NullableStatusResponse) Get() *StatusResponse {
	return v.value
}

func (v *NullableStatusResponse) Set(val *StatusResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableStatusResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableStatusResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableStatusResponse(val *StatusResponse) *NullableStatusResponse {
	return &NullableStatusResponse{value: val, isSet: true}
}

func (v NullableStatusResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableStatusResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
