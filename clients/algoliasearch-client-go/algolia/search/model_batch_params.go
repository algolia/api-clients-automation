// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// BatchParams Batch parameters.
type BatchParams struct {
	Requests []MultipleBatchRequest `json:"requests"`
}

// NewBatchParams instantiates a new BatchParams object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBatchParams(requests []MultipleBatchRequest) *BatchParams {
	this := &BatchParams{}
	this.Requests = requests
	return this
}

// NewEmptyBatchParams return a pointer to an empty BatchParams object.
func NewEmptyBatchParams() *BatchParams {
	return &BatchParams{}
}

// GetRequests returns the Requests field value.
func (o *BatchParams) GetRequests() []MultipleBatchRequest {
	if o == nil {
		var ret []MultipleBatchRequest
		return ret
	}

	return o.Requests
}

// GetRequestsOk returns a tuple with the Requests field value
// and a boolean to check if the value has been set.
func (o *BatchParams) GetRequestsOk() ([]MultipleBatchRequest, bool) {
	if o == nil {
		return nil, false
	}
	return o.Requests, true
}

// SetRequests sets field value.
func (o *BatchParams) SetRequests(v []MultipleBatchRequest) *BatchParams {
	o.Requests = v
	return o
}

func (o BatchParams) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["requests"] = o.Requests
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal BatchParams: %w", err)
	}

	return serialized, nil
}

func (o BatchParams) String() string {
	out := ""
	out += fmt.Sprintf("  requests=%v\n", o.Requests)
	return fmt.Sprintf("BatchParams {\n%s}", out)
}
