// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DestinationSearch API request body for searching destinations.
type DestinationSearch struct {
	DestinationIDs []string `json:"destinationIDs"`
}

// NewDestinationSearch instantiates a new DestinationSearch object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDestinationSearch(destinationIDs []string) *DestinationSearch {
	this := &DestinationSearch{}
	this.DestinationIDs = destinationIDs
	return this
}

// NewEmptyDestinationSearch return a pointer to an empty DestinationSearch object.
func NewEmptyDestinationSearch() *DestinationSearch {
	return &DestinationSearch{}
}

// GetDestinationIDs returns the DestinationIDs field value.
func (o *DestinationSearch) GetDestinationIDs() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.DestinationIDs
}

// GetDestinationIDsOk returns a tuple with the DestinationIDs field value
// and a boolean to check if the value has been set.
func (o *DestinationSearch) GetDestinationIDsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.DestinationIDs, true
}

// SetDestinationIDs sets field value.
func (o *DestinationSearch) SetDestinationIDs(v []string) *DestinationSearch {
	o.DestinationIDs = v
	return o
}

func (o DestinationSearch) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["destinationIDs"] = o.DestinationIDs
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DestinationSearch: %w", err)
	}

	return serialized, nil
}

func (o DestinationSearch) String() string {
	out := ""
	out += fmt.Sprintf("  destinationIDs=%v\n", o.DestinationIDs)
	return fmt.Sprintf("DestinationSearch {\n%s}", out)
}
