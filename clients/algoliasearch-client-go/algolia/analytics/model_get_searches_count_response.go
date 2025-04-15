// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetSearchesCountResponse struct for GetSearchesCountResponse.
type GetSearchesCountResponse struct {
	// Number of occurrences.
	Count int32 `json:"count"`
	// Daily number of searches.
	Dates []DailySearches `json:"dates"`
}

// NewGetSearchesCountResponse instantiates a new GetSearchesCountResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetSearchesCountResponse(count int32, dates []DailySearches) *GetSearchesCountResponse {
	this := &GetSearchesCountResponse{}
	this.Count = count
	this.Dates = dates
	return this
}

// NewEmptyGetSearchesCountResponse return a pointer to an empty GetSearchesCountResponse object.
func NewEmptyGetSearchesCountResponse() *GetSearchesCountResponse {
	return &GetSearchesCountResponse{}
}

// GetCount returns the Count field value.
func (o *GetSearchesCountResponse) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *GetSearchesCountResponse) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *GetSearchesCountResponse) SetCount(v int32) *GetSearchesCountResponse {
	o.Count = v
	return o
}

// GetDates returns the Dates field value.
func (o *GetSearchesCountResponse) GetDates() []DailySearches {
	if o == nil {
		var ret []DailySearches
		return ret
	}

	return o.Dates
}

// GetDatesOk returns a tuple with the Dates field value
// and a boolean to check if the value has been set.
func (o *GetSearchesCountResponse) GetDatesOk() ([]DailySearches, bool) {
	if o == nil {
		return nil, false
	}
	return o.Dates, true
}

// SetDates sets field value.
func (o *GetSearchesCountResponse) SetDates(v []DailySearches) *GetSearchesCountResponse {
	o.Dates = v
	return o
}

func (o GetSearchesCountResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["count"] = o.Count
	toSerialize["dates"] = o.Dates
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetSearchesCountResponse: %w", err)
	}

	return serialized, nil
}

func (o GetSearchesCountResponse) String() string {
	out := ""
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  dates=%v\n", o.Dates)
	return fmt.Sprintf("GetSearchesCountResponse {\n%s}", out)
}
