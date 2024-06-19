// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetTopFilterAttributesResponse struct for GetTopFilterAttributesResponse.
type GetTopFilterAttributesResponse struct {
	// Most frequent filters.
	Attributes []GetTopFilterAttribute `json:"attributes"`
}

// NewGetTopFilterAttributesResponse instantiates a new GetTopFilterAttributesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetTopFilterAttributesResponse(attributes []GetTopFilterAttribute) *GetTopFilterAttributesResponse {
	this := &GetTopFilterAttributesResponse{}
	this.Attributes = attributes
	return this
}

// NewEmptyGetTopFilterAttributesResponse return a pointer to an empty GetTopFilterAttributesResponse object.
func NewEmptyGetTopFilterAttributesResponse() *GetTopFilterAttributesResponse {
	return &GetTopFilterAttributesResponse{}
}

// GetAttributes returns the Attributes field value.
func (o *GetTopFilterAttributesResponse) GetAttributes() []GetTopFilterAttribute {
	if o == nil {
		var ret []GetTopFilterAttribute
		return ret
	}

	return o.Attributes
}

// GetAttributesOk returns a tuple with the Attributes field value
// and a boolean to check if the value has been set.
func (o *GetTopFilterAttributesResponse) GetAttributesOk() ([]GetTopFilterAttribute, bool) {
	if o == nil {
		return nil, false
	}
	return o.Attributes, true
}

// SetAttributes sets field value.
func (o *GetTopFilterAttributesResponse) SetAttributes(v []GetTopFilterAttribute) *GetTopFilterAttributesResponse {
	o.Attributes = v
	return o
}

func (o GetTopFilterAttributesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["attributes"] = o.Attributes
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetTopFilterAttributesResponse: %w", err)
	}

	return serialized, nil
}

func (o GetTopFilterAttributesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  attributes=%v\n", o.Attributes)
	return fmt.Sprintf("GetTopFilterAttributesResponse {\n%s}", out)
}
