// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// MultipleBatchRequest struct for MultipleBatchRequest.
type MultipleBatchRequest struct {
	Action Action `json:"action"`
	// Operation arguments (varies with specified `action`).
	Body map[string]any `json:"body,omitempty"`
	// Index name (case-sensitive).
	IndexName string `json:"indexName"`
}

type MultipleBatchRequestOption func(f *MultipleBatchRequest)

func WithMultipleBatchRequestBody(val map[string]any) MultipleBatchRequestOption {
	return func(f *MultipleBatchRequest) {
		f.Body = val
	}
}

// NewMultipleBatchRequest instantiates a new MultipleBatchRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewMultipleBatchRequest(action Action, indexName string, opts ...MultipleBatchRequestOption) *MultipleBatchRequest {
	this := &MultipleBatchRequest{}
	this.Action = action
	this.IndexName = indexName
	for _, opt := range opts {
		opt(this)
	}
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

// GetBody returns the Body field value if set, zero value otherwise.
func (o *MultipleBatchRequest) GetBody() map[string]any {
	if o == nil || o.Body == nil {
		var ret map[string]any
		return ret
	}
	return o.Body
}

// GetBodyOk returns a tuple with the Body field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *MultipleBatchRequest) GetBodyOk() (map[string]any, bool) {
	if o == nil || o.Body == nil {
		return nil, false
	}
	return o.Body, true
}

// HasBody returns a boolean if a field has been set.
func (o *MultipleBatchRequest) HasBody() bool {
	if o != nil && o.Body != nil {
		return true
	}

	return false
}

// SetBody gets a reference to the given map[string]any and assigns it to the Body field.
func (o *MultipleBatchRequest) SetBody(v map[string]any) *MultipleBatchRequest {
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
	toSerialize["action"] = o.Action
	if o.Body != nil {
		toSerialize["body"] = o.Body
	}
	toSerialize["indexName"] = o.IndexName
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
