// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// MultipleBatchRequest struct for MultipleBatchRequest.
type MultipleBatchRequest struct {
	Action Action `json:"action"`
	// Operation arguments (varies with specified `action`).
	Body map[string]interface{} `json:"body"`
	// Index name (case-sensitive).
	IndexName string `json:"indexName"`
}

// NewMultipleBatchRequest instantiates a new MultipleBatchRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewMultipleBatchRequest(action Action, body map[string]interface{}, indexName string) *MultipleBatchRequest {
	this := &MultipleBatchRequest{}
	this.Action = action
	this.Body = body
	this.IndexName = indexName
	return this
}

// NewEmptyMultipleBatchRequest return a pointer to an empty MultipleBatchRequest object.
func NewEmptyMultipleBatchRequest() *MultipleBatchRequest {
	return &MultipleBatchRequest{}
}

// GetAction returns the Action field value.
func (o *MultipleBatchRequest) GetAction() Action {
	if o == nil {
		var ret Action
		return ret
	}

	return o.Action
}

// GetActionOk returns a tuple with the Action field value
// and a boolean to check if the value has been set.
func (o *MultipleBatchRequest) GetActionOk() (*Action, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Action, true
}

// SetAction sets field value.
func (o *MultipleBatchRequest) SetAction(v Action) *MultipleBatchRequest {
	o.Action = v
	return o
}

// GetBody returns the Body field value.
func (o *MultipleBatchRequest) GetBody() map[string]interface{} {
	if o == nil {
		var ret map[string]interface{}
		return ret
	}

	return o.Body
}

// GetBodyOk returns a tuple with the Body field value
// and a boolean to check if the value has been set.
func (o *MultipleBatchRequest) GetBodyOk() (map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.Body, true
}

// SetBody sets field value.
func (o *MultipleBatchRequest) SetBody(v map[string]interface{}) *MultipleBatchRequest {
	o.Body = v
	return o
}

// GetIndexName returns the IndexName field value.
func (o *MultipleBatchRequest) GetIndexName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value
// and a boolean to check if the value has been set.
func (o *MultipleBatchRequest) GetIndexNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexName, true
}

// SetIndexName sets field value.
func (o *MultipleBatchRequest) SetIndexName(v string) *MultipleBatchRequest {
	o.IndexName = v
	return o
}

func (o MultipleBatchRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["action"] = o.Action
	}
	if true {
		toSerialize["body"] = o.Body
	}
	if true {
		toSerialize["indexName"] = o.IndexName
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal MultipleBatchRequest: %w", err)
	}

	return serialized, nil
}

func (o MultipleBatchRequest) String() string {
	out := ""
	out += fmt.Sprintf("  action=%v\n", o.Action)
	out += fmt.Sprintf("  body=%v\n", o.Body)
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	return fmt.Sprintf("MultipleBatchRequest {\n%s}", out)
}

type NullableMultipleBatchRequest struct {
	value *MultipleBatchRequest
	isSet bool
}

func (v NullableMultipleBatchRequest) Get() *MultipleBatchRequest {
	return v.value
}

func (v *NullableMultipleBatchRequest) Set(val *MultipleBatchRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableMultipleBatchRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableMultipleBatchRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableMultipleBatchRequest(val *MultipleBatchRequest) *NullableMultipleBatchRequest {
	return &NullableMultipleBatchRequest{value: val, isSet: true}
}

func (v NullableMultipleBatchRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableMultipleBatchRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
