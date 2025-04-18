// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ListTransformationsResponse Configured transformations and pagination information.
type ListTransformationsResponse struct {
	Transformations []Transformation `json:"transformations"`
	Pagination      Pagination       `json:"pagination"`
}

// NewListTransformationsResponse instantiates a new ListTransformationsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListTransformationsResponse(transformations []Transformation, pagination Pagination) *ListTransformationsResponse {
	this := &ListTransformationsResponse{}
	this.Transformations = transformations
	this.Pagination = pagination
	return this
}

// NewEmptyListTransformationsResponse return a pointer to an empty ListTransformationsResponse object.
func NewEmptyListTransformationsResponse() *ListTransformationsResponse {
	return &ListTransformationsResponse{}
}

// GetTransformations returns the Transformations field value.
func (o *ListTransformationsResponse) GetTransformations() []Transformation {
	if o == nil {
		var ret []Transformation
		return ret
	}

	return o.Transformations
}

// GetTransformationsOk returns a tuple with the Transformations field value
// and a boolean to check if the value has been set.
func (o *ListTransformationsResponse) GetTransformationsOk() ([]Transformation, bool) {
	if o == nil {
		return nil, false
	}
	return o.Transformations, true
}

// SetTransformations sets field value.
func (o *ListTransformationsResponse) SetTransformations(v []Transformation) *ListTransformationsResponse {
	o.Transformations = v
	return o
}

// GetPagination returns the Pagination field value.
func (o *ListTransformationsResponse) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *ListTransformationsResponse) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value.
func (o *ListTransformationsResponse) SetPagination(v *Pagination) *ListTransformationsResponse {
	o.Pagination = *v
	return o
}

func (o ListTransformationsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["transformations"] = o.Transformations
	toSerialize["pagination"] = o.Pagination
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListTransformationsResponse: %w", err)
	}

	return serialized, nil
}

func (o ListTransformationsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  transformations=%v\n", o.Transformations)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	return fmt.Sprintf("ListTransformationsResponse {\n%s}", out)
}
