// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// BaseGetApiKeyResponse struct for BaseGetApiKeyResponse.
type BaseGetApiKeyResponse struct {
	// API key.
	Value *string `json:"value,omitempty"`
	// Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).
	CreatedAt int64 `json:"createdAt"`
}

type BaseGetApiKeyResponseOption func(f *BaseGetApiKeyResponse)

func WithBaseGetApiKeyResponseValue(val string) BaseGetApiKeyResponseOption {
	return func(f *BaseGetApiKeyResponse) {
		f.Value = &val
	}
}

// NewBaseGetApiKeyResponse instantiates a new BaseGetApiKeyResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBaseGetApiKeyResponse(createdAt int64, opts ...BaseGetApiKeyResponseOption) *BaseGetApiKeyResponse {
	this := &BaseGetApiKeyResponse{}
	this.CreatedAt = createdAt
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewBaseGetApiKeyResponseWithDefaults instantiates a new BaseGetApiKeyResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set.
func NewBaseGetApiKeyResponseWithDefaults() *BaseGetApiKeyResponse {
	this := &BaseGetApiKeyResponse{}
	return this
}

// GetValue returns the Value field value if set, zero value otherwise.
func (o *BaseGetApiKeyResponse) GetValue() string {
	if o == nil || o.Value == nil {
		var ret string
		return ret
	}
	return *o.Value
}

// GetValueOk returns a tuple with the Value field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseGetApiKeyResponse) GetValueOk() (*string, bool) {
	if o == nil || o.Value == nil {
		return nil, false
	}
	return o.Value, true
}

// HasValue returns a boolean if a field has been set.
func (o *BaseGetApiKeyResponse) HasValue() bool {
	if o != nil && o.Value != nil {
		return true
	}

	return false
}

// SetValue gets a reference to the given string and assigns it to the Value field.
func (o *BaseGetApiKeyResponse) SetValue(v string) {
	o.Value = &v
}

// GetCreatedAt returns the CreatedAt field value.
func (o *BaseGetApiKeyResponse) GetCreatedAt() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *BaseGetApiKeyResponse) GetCreatedAtOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value.
func (o *BaseGetApiKeyResponse) SetCreatedAt(v int64) {
	o.CreatedAt = v
}

func (o BaseGetApiKeyResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Value != nil {
		toSerialize["value"] = o.Value
	}
	if true {
		toSerialize["createdAt"] = o.CreatedAt
	}
	return json.Marshal(toSerialize)
}

func (o BaseGetApiKeyResponse) String() string {
	out := ""
	out += fmt.Sprintf("  value=%v\n", o.Value)
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	return fmt.Sprintf("BaseGetApiKeyResponse {\n%s}", out)
}

type NullableBaseGetApiKeyResponse struct {
	value *BaseGetApiKeyResponse
	isSet bool
}

func (v NullableBaseGetApiKeyResponse) Get() *BaseGetApiKeyResponse {
	return v.value
}

func (v *NullableBaseGetApiKeyResponse) Set(val *BaseGetApiKeyResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseGetApiKeyResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseGetApiKeyResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseGetApiKeyResponse(val *BaseGetApiKeyResponse) *NullableBaseGetApiKeyResponse {
	return &NullableBaseGetApiKeyResponse{value: val, isSet: true}
}

func (v NullableBaseGetApiKeyResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBaseGetApiKeyResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
