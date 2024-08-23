// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TransformationModels List of available AI models for transformation purposes.
type TransformationModels struct {
	Llms []Model `json:"llms"`
}

// NewTransformationModels instantiates a new TransformationModels object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTransformationModels(llms []Model) *TransformationModels {
	this := &TransformationModels{}
	this.Llms = llms
	return this
}

// NewEmptyTransformationModels return a pointer to an empty TransformationModels object.
func NewEmptyTransformationModels() *TransformationModels {
	return &TransformationModels{}
}

// GetLlms returns the Llms field value.
func (o *TransformationModels) GetLlms() []Model {
	if o == nil {
		var ret []Model
		return ret
	}

	return o.Llms
}

// GetLlmsOk returns a tuple with the Llms field value
// and a boolean to check if the value has been set.
func (o *TransformationModels) GetLlmsOk() ([]Model, bool) {
	if o == nil {
		return nil, false
	}
	return o.Llms, true
}

// SetLlms sets field value.
func (o *TransformationModels) SetLlms(v []Model) *TransformationModels {
	o.Llms = v
	return o
}

func (o TransformationModels) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["llms"] = o.Llms
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TransformationModels: %w", err)
	}

	return serialized, nil
}

func (o TransformationModels) String() string {
	out := ""
	out += fmt.Sprintf("  llms=%v\n", o.Llms)
	return fmt.Sprintf("TransformationModels {\n%s}", out)
}
