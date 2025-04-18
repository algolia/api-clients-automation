// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// GetClickThroughRateResponse struct for GetClickThroughRateResponse.
type GetClickThroughRateResponse struct {
	// Click-through rate: calculated as the number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	Rate utils.Nullable[float64] `json:"rate"`
	// Number of clicks associated with this search.
	ClickCount int32 `json:"clickCount"`
	// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
	TrackedSearchCount int32 `json:"trackedSearchCount"`
	// Daily click-through rates.
	Dates []DailyClickThroughRates `json:"dates"`
}

// NewGetClickThroughRateResponse instantiates a new GetClickThroughRateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetClickThroughRateResponse(rate utils.Nullable[float64], clickCount int32, trackedSearchCount int32, dates []DailyClickThroughRates) *GetClickThroughRateResponse {
	this := &GetClickThroughRateResponse{}
	this.Rate = rate
	this.ClickCount = clickCount
	this.TrackedSearchCount = trackedSearchCount
	this.Dates = dates
	return this
}

// NewEmptyGetClickThroughRateResponse return a pointer to an empty GetClickThroughRateResponse object.
func NewEmptyGetClickThroughRateResponse() *GetClickThroughRateResponse {
	return &GetClickThroughRateResponse{}
}

// GetRate returns the Rate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *GetClickThroughRateResponse) GetRate() float64 {
	if o == nil || o.Rate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.Rate.Get()
}

// GetRateOk returns a tuple with the Rate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *GetClickThroughRateResponse) GetRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.Rate.Get(), o.Rate.IsSet()
}

// SetRate sets field value.
func (o *GetClickThroughRateResponse) SetRate(v float64) *GetClickThroughRateResponse {
	o.Rate.Set(&v)
	return o
}

// GetClickCount returns the ClickCount field value.
func (o *GetClickThroughRateResponse) GetClickCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ClickCount
}

// GetClickCountOk returns a tuple with the ClickCount field value
// and a boolean to check if the value has been set.
func (o *GetClickThroughRateResponse) GetClickCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ClickCount, true
}

// SetClickCount sets field value.
func (o *GetClickThroughRateResponse) SetClickCount(v int32) *GetClickThroughRateResponse {
	o.ClickCount = v
	return o
}

// GetTrackedSearchCount returns the TrackedSearchCount field value.
func (o *GetClickThroughRateResponse) GetTrackedSearchCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.TrackedSearchCount
}

// GetTrackedSearchCountOk returns a tuple with the TrackedSearchCount field value
// and a boolean to check if the value has been set.
func (o *GetClickThroughRateResponse) GetTrackedSearchCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TrackedSearchCount, true
}

// SetTrackedSearchCount sets field value.
func (o *GetClickThroughRateResponse) SetTrackedSearchCount(v int32) *GetClickThroughRateResponse {
	o.TrackedSearchCount = v
	return o
}

// GetDates returns the Dates field value.
func (o *GetClickThroughRateResponse) GetDates() []DailyClickThroughRates {
	if o == nil {
		var ret []DailyClickThroughRates
		return ret
	}

	return o.Dates
}

// GetDatesOk returns a tuple with the Dates field value
// and a boolean to check if the value has been set.
func (o *GetClickThroughRateResponse) GetDatesOk() ([]DailyClickThroughRates, bool) {
	if o == nil {
		return nil, false
	}
	return o.Dates, true
}

// SetDates sets field value.
func (o *GetClickThroughRateResponse) SetDates(v []DailyClickThroughRates) *GetClickThroughRateResponse {
	o.Dates = v
	return o
}

func (o GetClickThroughRateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["rate"] = o.Rate.Get()
	toSerialize["clickCount"] = o.ClickCount
	toSerialize["trackedSearchCount"] = o.TrackedSearchCount
	toSerialize["dates"] = o.Dates
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetClickThroughRateResponse: %w", err)
	}

	return serialized, nil
}

func (o GetClickThroughRateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  rate=%v\n", o.Rate)
	out += fmt.Sprintf("  clickCount=%v\n", o.ClickCount)
	out += fmt.Sprintf("  trackedSearchCount=%v\n", o.TrackedSearchCount)
	out += fmt.Sprintf("  dates=%v\n", o.Dates)
	return fmt.Sprintf("GetClickThroughRateResponse {\n%s}", out)
}
