// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// ListIndicesResponse struct for ListIndicesResponse.
type ListIndicesResponse struct {
	// All indices in your Algolia application.
	Items []FetchedIndex `json:"items"`
	// Number of pages.
	NbPages *int32 `json:"nbPages,omitempty"`
}

type ListIndicesResponseOption func(f *ListIndicesResponse)

func WithListIndicesResponseNbPages(val int32) ListIndicesResponseOption {
	return func(f *ListIndicesResponse) {
		f.NbPages = &val
	}
}

// NewListIndicesResponse instantiates a new ListIndicesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListIndicesResponse(items []FetchedIndex, opts ...ListIndicesResponseOption) *ListIndicesResponse {
	this := &ListIndicesResponse{}
	this.Items = items
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyListIndicesResponse return a pointer to an empty ListIndicesResponse object.
func NewEmptyListIndicesResponse() *ListIndicesResponse {
	return &ListIndicesResponse{}
}

// GetItems returns the Items field value.
func (o *ListIndicesResponse) GetItems() []FetchedIndex {
	if o == nil {
		var ret []FetchedIndex
		return ret
	}

	return o.Items
}

// GetItemsOk returns a tuple with the Items field value
// and a boolean to check if the value has been set.
func (o *ListIndicesResponse) GetItemsOk() ([]FetchedIndex, bool) {
	if o == nil {
		return nil, false
	}
	return o.Items, true
}

// SetItems sets field value.
func (o *ListIndicesResponse) SetItems(v []FetchedIndex) *ListIndicesResponse {
	o.Items = v
	return o
}

// GetNbPages returns the NbPages field value if set, zero value otherwise.
func (o *ListIndicesResponse) GetNbPages() int32 {
	if o == nil || o.NbPages == nil {
		var ret int32
		return ret
	}
	return *o.NbPages
}

// GetNbPagesOk returns a tuple with the NbPages field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ListIndicesResponse) GetNbPagesOk() (*int32, bool) {
	if o == nil || o.NbPages == nil {
		return nil, false
	}
	return o.NbPages, true
}

// HasNbPages returns a boolean if a field has been set.
func (o *ListIndicesResponse) HasNbPages() bool {
	if o != nil && o.NbPages != nil {
		return true
	}

	return false
}

// SetNbPages gets a reference to the given int32 and assigns it to the NbPages field.
func (o *ListIndicesResponse) SetNbPages(v int32) *ListIndicesResponse {
	o.NbPages = &v
	return o
}

func (o ListIndicesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["items"] = o.Items
	}
	if o.NbPages != nil {
		toSerialize["nbPages"] = o.NbPages
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListIndicesResponse: %w", err)
	}

	return serialized, nil
}

func (o ListIndicesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  items=%v\n", o.Items)
	out += fmt.Sprintf("  nbPages=%v\n", o.NbPages)
	return fmt.Sprintf("ListIndicesResponse {\n%s}", out)
}
