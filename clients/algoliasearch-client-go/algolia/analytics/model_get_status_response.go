// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// GetStatusResponse struct for GetStatusResponse.
type GetStatusResponse struct {
	// Date and time when the object was updated, in RFC 3339 format.
	UpdatedAt utils.Nullable[string] `json:"updatedAt"`
}

// NewGetStatusResponse instantiates a new GetStatusResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetStatusResponse(updatedAt utils.Nullable[string]) *GetStatusResponse {
	this := &GetStatusResponse{}
	this.UpdatedAt = updatedAt
	return this
}

// NewEmptyGetStatusResponse return a pointer to an empty GetStatusResponse object.
func NewEmptyGetStatusResponse() *GetStatusResponse {
	return &GetStatusResponse{}
}

// GetUpdatedAt returns the UpdatedAt field value.
// If the value is explicit nil, the zero value for string will be returned.
func (o *GetStatusResponse) GetUpdatedAt() string {
	if o == nil || o.UpdatedAt.Get() == nil {
		var ret string
		return ret
	}

	return *o.UpdatedAt.Get()
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *GetStatusResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return o.UpdatedAt.Get(), o.UpdatedAt.IsSet()
}

// SetUpdatedAt sets field value.
func (o *GetStatusResponse) SetUpdatedAt(v string) *GetStatusResponse {
	o.UpdatedAt.Set(&v)
	return o
}

func (o GetStatusResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["updatedAt"] = o.UpdatedAt.Get()
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetStatusResponse: %w", err)
	}

	return serialized, nil
}

func (o GetStatusResponse) String() string {
	out := ""
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	return fmt.Sprintf("GetStatusResponse {\n%s}", out)
}
