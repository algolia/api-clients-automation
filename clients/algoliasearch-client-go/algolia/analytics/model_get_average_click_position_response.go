// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// GetAverageClickPositionResponse struct for GetAverageClickPositionResponse.
type GetAverageClickPositionResponse struct {
	// Average position of a clicked search result in the list of search results. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	Average utils.Nullable[float64] `json:"average"`
	// Number of clicks associated with this search.
	ClickCount int32 `json:"clickCount"`
	// Daily average click positions.
	Dates []DailyAverageClicks `json:"dates"`
}

// NewGetAverageClickPositionResponse instantiates a new GetAverageClickPositionResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetAverageClickPositionResponse(average utils.Nullable[float64], clickCount int32, dates []DailyAverageClicks) *GetAverageClickPositionResponse {
	this := &GetAverageClickPositionResponse{}
	this.Average = average
	this.ClickCount = clickCount
	this.Dates = dates
	return this
}

// NewEmptyGetAverageClickPositionResponse return a pointer to an empty GetAverageClickPositionResponse object.
func NewEmptyGetAverageClickPositionResponse() *GetAverageClickPositionResponse {
	return &GetAverageClickPositionResponse{}
}

// GetAverage returns the Average field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *GetAverageClickPositionResponse) GetAverage() float64 {
	if o == nil || o.Average.Get() == nil {
		var ret float64
		return ret
	}

	return *o.Average.Get()
}

// GetAverageOk returns a tuple with the Average field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *GetAverageClickPositionResponse) GetAverageOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.Average.Get(), o.Average.IsSet()
}

// SetAverage sets field value.
func (o *GetAverageClickPositionResponse) SetAverage(v float64) *GetAverageClickPositionResponse {
	o.Average.Set(&v)
	return o
}

// GetClickCount returns the ClickCount field value.
func (o *GetAverageClickPositionResponse) GetClickCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ClickCount
}

// GetClickCountOk returns a tuple with the ClickCount field value
// and a boolean to check if the value has been set.
func (o *GetAverageClickPositionResponse) GetClickCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ClickCount, true
}

// SetClickCount sets field value.
func (o *GetAverageClickPositionResponse) SetClickCount(v int32) *GetAverageClickPositionResponse {
	o.ClickCount = v
	return o
}

// GetDates returns the Dates field value.
func (o *GetAverageClickPositionResponse) GetDates() []DailyAverageClicks {
	if o == nil {
		var ret []DailyAverageClicks
		return ret
	}

	return o.Dates
}

// GetDatesOk returns a tuple with the Dates field value
// and a boolean to check if the value has been set.
func (o *GetAverageClickPositionResponse) GetDatesOk() ([]DailyAverageClicks, bool) {
	if o == nil {
		return nil, false
	}
	return o.Dates, true
}

// SetDates sets field value.
func (o *GetAverageClickPositionResponse) SetDates(v []DailyAverageClicks) *GetAverageClickPositionResponse {
	o.Dates = v
	return o
}

func (o GetAverageClickPositionResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["average"] = o.Average.Get()
	toSerialize["clickCount"] = o.ClickCount
	toSerialize["dates"] = o.Dates
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetAverageClickPositionResponse: %w", err)
	}

	return serialized, nil
}

func (o GetAverageClickPositionResponse) String() string {
	out := ""
	out += fmt.Sprintf("  average=%v\n", o.Average)
	out += fmt.Sprintf("  clickCount=%v\n", o.ClickCount)
	out += fmt.Sprintf("  dates=%v\n", o.Dates)
	return fmt.Sprintf("GetAverageClickPositionResponse {\n%s}", out)
}
