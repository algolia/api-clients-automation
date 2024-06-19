// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// ReplaceAllObjectsResponse struct for ReplaceAllObjectsResponse.
type ReplaceAllObjectsResponse struct {
	CopyOperationResponse UpdatedAtResponse `json:"copyOperationResponse"`
	// The response of the `batch` request(s).
	BatchResponses        []BatchResponse   `json:"batchResponses"`
	MoveOperationResponse UpdatedAtResponse `json:"moveOperationResponse"`
}

// NewReplaceAllObjectsResponse instantiates a new ReplaceAllObjectsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewReplaceAllObjectsResponse(copyOperationResponse UpdatedAtResponse, batchResponses []BatchResponse, moveOperationResponse UpdatedAtResponse) *ReplaceAllObjectsResponse {
	this := &ReplaceAllObjectsResponse{}
	this.CopyOperationResponse = copyOperationResponse
	this.BatchResponses = batchResponses
	this.MoveOperationResponse = moveOperationResponse
	return this
}

// NewEmptyReplaceAllObjectsResponse return a pointer to an empty ReplaceAllObjectsResponse object.
func NewEmptyReplaceAllObjectsResponse() *ReplaceAllObjectsResponse {
	return &ReplaceAllObjectsResponse{}
}

// GetCopyOperationResponse returns the CopyOperationResponse field value.
func (o *ReplaceAllObjectsResponse) GetCopyOperationResponse() UpdatedAtResponse {
	if o == nil {
		var ret UpdatedAtResponse
		return ret
	}

	return o.CopyOperationResponse
}

// GetCopyOperationResponseOk returns a tuple with the CopyOperationResponse field value
// and a boolean to check if the value has been set.
func (o *ReplaceAllObjectsResponse) GetCopyOperationResponseOk() (*UpdatedAtResponse, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CopyOperationResponse, true
}

// SetCopyOperationResponse sets field value.
func (o *ReplaceAllObjectsResponse) SetCopyOperationResponse(v *UpdatedAtResponse) *ReplaceAllObjectsResponse {
	o.CopyOperationResponse = *v
	return o
}

// GetBatchResponses returns the BatchResponses field value.
func (o *ReplaceAllObjectsResponse) GetBatchResponses() []BatchResponse {
	if o == nil {
		var ret []BatchResponse
		return ret
	}

	return o.BatchResponses
}

// GetBatchResponsesOk returns a tuple with the BatchResponses field value
// and a boolean to check if the value has been set.
func (o *ReplaceAllObjectsResponse) GetBatchResponsesOk() ([]BatchResponse, bool) {
	if o == nil {
		return nil, false
	}
	return o.BatchResponses, true
}

// SetBatchResponses sets field value.
func (o *ReplaceAllObjectsResponse) SetBatchResponses(v []BatchResponse) *ReplaceAllObjectsResponse {
	o.BatchResponses = v
	return o
}

// GetMoveOperationResponse returns the MoveOperationResponse field value.
func (o *ReplaceAllObjectsResponse) GetMoveOperationResponse() UpdatedAtResponse {
	if o == nil {
		var ret UpdatedAtResponse
		return ret
	}

	return o.MoveOperationResponse
}

// GetMoveOperationResponseOk returns a tuple with the MoveOperationResponse field value
// and a boolean to check if the value has been set.
func (o *ReplaceAllObjectsResponse) GetMoveOperationResponseOk() (*UpdatedAtResponse, bool) {
	if o == nil {
		return nil, false
	}
	return &o.MoveOperationResponse, true
}

// SetMoveOperationResponse sets field value.
func (o *ReplaceAllObjectsResponse) SetMoveOperationResponse(v *UpdatedAtResponse) *ReplaceAllObjectsResponse {
	o.MoveOperationResponse = *v
	return o
}

func (o ReplaceAllObjectsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["copyOperationResponse"] = o.CopyOperationResponse
	}
	if true {
		toSerialize["batchResponses"] = o.BatchResponses
	}
	if true {
		toSerialize["moveOperationResponse"] = o.MoveOperationResponse
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ReplaceAllObjectsResponse: %w", err)
	}

	return serialized, nil
}

func (o ReplaceAllObjectsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  copyOperationResponse=%v\n", o.CopyOperationResponse)
	out += fmt.Sprintf("  batchResponses=%v\n", o.BatchResponses)
	out += fmt.Sprintf("  moveOperationResponse=%v\n", o.MoveOperationResponse)
	return fmt.Sprintf("ReplaceAllObjectsResponse {\n%s}", out)
}
