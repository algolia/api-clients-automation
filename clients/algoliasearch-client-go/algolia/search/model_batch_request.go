// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// BatchRequest struct for BatchRequest
type BatchRequest struct {
	Action Action `json:"action" validate:"required"`
	// arguments to the operation (depends on the type of the operation).
	Body map[string]interface{} `json:"body" validate:"required"`
}

// NewBatchRequest instantiates a new BatchRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBatchRequest(action Action, body map[string]interface{}) *BatchRequest {
	this := &BatchRequest{}
	this.Action = action
	this.Body = body
	return this
}

// NewBatchRequestWithDefaults instantiates a new BatchRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBatchRequestWithDefaults() *BatchRequest {
	this := &BatchRequest{}
	return this
}

// GetAction returns the Action field value
func (o *BatchRequest) GetAction() Action {
	if o == nil {
		var ret Action
		return ret
	}

	return o.Action
}

// GetActionOk returns a tuple with the Action field value
// and a boolean to check if the value has been set.
func (o *BatchRequest) GetActionOk() (*Action, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Action, true
}

// SetAction sets field value
func (o *BatchRequest) SetAction(v Action) {
	o.Action = v
}

// GetBody returns the Body field value
func (o *BatchRequest) GetBody() map[string]interface{} {
	if o == nil {
		var ret map[string]interface{}
		return ret
	}

	return o.Body
}

// GetBodyOk returns a tuple with the Body field value
// and a boolean to check if the value has been set.
func (o *BatchRequest) GetBodyOk() (map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.Body, true
}

// SetBody sets field value
func (o *BatchRequest) SetBody(v map[string]interface{}) {
	o.Body = v
}

func (o BatchRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["action"] = o.Action
	}
	if true {
		toSerialize["body"] = o.Body
	}
	return json.Marshal(toSerialize)
}

func (o BatchRequest) String() string {
	out := ""
	out += fmt.Sprintf("  action=%v\n", o.Action)
	out += fmt.Sprintf("  body=%v\n", o.Body)
	return fmt.Sprintf("BatchRequest {\n%s}", out)
}

type NullableBatchRequest struct {
	value *BatchRequest
	isSet bool
}

func (v NullableBatchRequest) Get() *BatchRequest {
	return v.value
}

func (v *NullableBatchRequest) Set(val *BatchRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableBatchRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableBatchRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBatchRequest(val *BatchRequest) *NullableBatchRequest {
	return &NullableBatchRequest{value: val, isSet: true}
}

func (v NullableBatchRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBatchRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
