// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ListSourcesResponse struct for ListSourcesResponse.
type ListSourcesResponse struct {
	Sources    []Source   `json:"sources"`
	Pagination Pagination `json:"pagination"`
}

// NewListSourcesResponse instantiates a new ListSourcesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListSourcesResponse(sources []Source, pagination Pagination) *ListSourcesResponse {
	this := &ListSourcesResponse{}
	this.Sources = sources
	this.Pagination = pagination
	return this
}

// NewEmptyListSourcesResponse return a pointer to an empty ListSourcesResponse object.
func NewEmptyListSourcesResponse() *ListSourcesResponse {
	return &ListSourcesResponse{}
}

// GetSources returns the Sources field value.
func (o *ListSourcesResponse) GetSources() []Source {
	if o == nil {
		var ret []Source
		return ret
	}

	return o.Sources
}

// GetSourcesOk returns a tuple with the Sources field value
// and a boolean to check if the value has been set.
func (o *ListSourcesResponse) GetSourcesOk() ([]Source, bool) {
	if o == nil {
		return nil, false
	}
	return o.Sources, true
}

// SetSources sets field value.
func (o *ListSourcesResponse) SetSources(v []Source) *ListSourcesResponse {
	o.Sources = v
	return o
}

// GetPagination returns the Pagination field value.
func (o *ListSourcesResponse) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *ListSourcesResponse) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value.
func (o *ListSourcesResponse) SetPagination(v *Pagination) *ListSourcesResponse {
	o.Pagination = *v
	return o
}

func (o ListSourcesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["sources"] = o.Sources
	}
	if true {
		toSerialize["pagination"] = o.Pagination
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListSourcesResponse: %w", err)
	}

	return serialized, nil
}

func (o ListSourcesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  sources=%v\n", o.Sources)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	return fmt.Sprintf("ListSourcesResponse {\n%s}", out)
}
