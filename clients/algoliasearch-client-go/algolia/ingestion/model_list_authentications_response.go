// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ListAuthenticationsResponse struct for ListAuthenticationsResponse.
type ListAuthenticationsResponse struct {
	Authentications []Authentication `json:"authentications"`
	Pagination      Pagination       `json:"pagination"`
}

// NewListAuthenticationsResponse instantiates a new ListAuthenticationsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListAuthenticationsResponse(authentications []Authentication, pagination Pagination) *ListAuthenticationsResponse {
	this := &ListAuthenticationsResponse{}
	this.Authentications = authentications
	this.Pagination = pagination
	return this
}

// NewEmptyListAuthenticationsResponse return a pointer to an empty ListAuthenticationsResponse object.
func NewEmptyListAuthenticationsResponse() *ListAuthenticationsResponse {
	return &ListAuthenticationsResponse{}
}

// GetAuthentications returns the Authentications field value.
func (o *ListAuthenticationsResponse) GetAuthentications() []Authentication {
	if o == nil {
		var ret []Authentication
		return ret
	}

	return o.Authentications
}

// GetAuthenticationsOk returns a tuple with the Authentications field value
// and a boolean to check if the value has been set.
func (o *ListAuthenticationsResponse) GetAuthenticationsOk() ([]Authentication, bool) {
	if o == nil {
		return nil, false
	}
	return o.Authentications, true
}

// SetAuthentications sets field value.
func (o *ListAuthenticationsResponse) SetAuthentications(v []Authentication) *ListAuthenticationsResponse {
	o.Authentications = v
	return o
}

// GetPagination returns the Pagination field value.
func (o *ListAuthenticationsResponse) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *ListAuthenticationsResponse) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value.
func (o *ListAuthenticationsResponse) SetPagination(v *Pagination) *ListAuthenticationsResponse {
	o.Pagination = *v
	return o
}

func (o ListAuthenticationsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["authentications"] = o.Authentications
	toSerialize["pagination"] = o.Pagination
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListAuthenticationsResponse: %w", err)
	}

	return serialized, nil
}

func (o ListAuthenticationsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  authentications=%v\n", o.Authentications)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	return fmt.Sprintf("ListAuthenticationsResponse {\n%s}", out)
}
