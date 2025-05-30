// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceUpdateResponse struct for SourceUpdateResponse.
type SourceUpdateResponse struct {
	// Universally uniqud identifier (UUID) of a source.
	SourceID string `json:"sourceID"`
	// Descriptive name of the source.
	Name string `json:"name"`
	// Date of last update in RFC 3339 format.
	UpdatedAt string `json:"updatedAt"`
}

// NewSourceUpdateResponse instantiates a new SourceUpdateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSourceUpdateResponse(sourceID string, name string, updatedAt string) *SourceUpdateResponse {
	this := &SourceUpdateResponse{}
	this.SourceID = sourceID
	this.Name = name
	this.UpdatedAt = updatedAt
	return this
}

// NewEmptySourceUpdateResponse return a pointer to an empty SourceUpdateResponse object.
func NewEmptySourceUpdateResponse() *SourceUpdateResponse {
	return &SourceUpdateResponse{}
}

// GetSourceID returns the SourceID field value.
func (o *SourceUpdateResponse) GetSourceID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.SourceID
}

// GetSourceIDOk returns a tuple with the SourceID field value
// and a boolean to check if the value has been set.
func (o *SourceUpdateResponse) GetSourceIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.SourceID, true
}

// SetSourceID sets field value.
func (o *SourceUpdateResponse) SetSourceID(v string) *SourceUpdateResponse {
	o.SourceID = v
	return o
}

// GetName returns the Name field value.
func (o *SourceUpdateResponse) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *SourceUpdateResponse) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value.
func (o *SourceUpdateResponse) SetName(v string) *SourceUpdateResponse {
	o.Name = v
	return o
}

// GetUpdatedAt returns the UpdatedAt field value.
func (o *SourceUpdateResponse) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *SourceUpdateResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value.
func (o *SourceUpdateResponse) SetUpdatedAt(v string) *SourceUpdateResponse {
	o.UpdatedAt = v
	return o
}

func (o SourceUpdateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["sourceID"] = o.SourceID
	toSerialize["name"] = o.Name
	toSerialize["updatedAt"] = o.UpdatedAt
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SourceUpdateResponse: %w", err)
	}

	return serialized, nil
}

func (o SourceUpdateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  sourceID=%v\n", o.SourceID)
	out += fmt.Sprintf("  name=%v\n", o.Name)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	return fmt.Sprintf("SourceUpdateResponse {\n%s}", out)
}
