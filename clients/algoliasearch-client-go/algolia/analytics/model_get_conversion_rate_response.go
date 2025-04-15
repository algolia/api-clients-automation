// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// GetConversionRateResponse struct for GetConversionRateResponse.
type GetConversionRateResponse struct {
	// Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	Rate utils.Nullable[float64] `json:"rate"`
	// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
	TrackedSearchCount int32 `json:"trackedSearchCount"`
	// Number of conversions from this search.
	ConversionCount int32 `json:"conversionCount"`
	// Daily conversion rates.
	Dates []DailyConversionRates `json:"dates"`
}

// NewGetConversionRateResponse instantiates a new GetConversionRateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetConversionRateResponse(rate utils.Nullable[float64], trackedSearchCount int32, conversionCount int32, dates []DailyConversionRates) *GetConversionRateResponse {
	this := &GetConversionRateResponse{}
	this.Rate = rate
	this.TrackedSearchCount = trackedSearchCount
	this.ConversionCount = conversionCount
	this.Dates = dates
	return this
}

// NewEmptyGetConversionRateResponse return a pointer to an empty GetConversionRateResponse object.
func NewEmptyGetConversionRateResponse() *GetConversionRateResponse {
	return &GetConversionRateResponse{}
}

// GetRate returns the Rate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *GetConversionRateResponse) GetRate() float64 {
	if o == nil || o.Rate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.Rate.Get()
}

// GetRateOk returns a tuple with the Rate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *GetConversionRateResponse) GetRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.Rate.Get(), o.Rate.IsSet()
}

// SetRate sets field value.
func (o *GetConversionRateResponse) SetRate(v float64) *GetConversionRateResponse {
	o.Rate.Set(&v)
	return o
}

// GetTrackedSearchCount returns the TrackedSearchCount field value.
func (o *GetConversionRateResponse) GetTrackedSearchCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.TrackedSearchCount
}

// GetTrackedSearchCountOk returns a tuple with the TrackedSearchCount field value
// and a boolean to check if the value has been set.
func (o *GetConversionRateResponse) GetTrackedSearchCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TrackedSearchCount, true
}

// SetTrackedSearchCount sets field value.
func (o *GetConversionRateResponse) SetTrackedSearchCount(v int32) *GetConversionRateResponse {
	o.TrackedSearchCount = v
	return o
}

// GetConversionCount returns the ConversionCount field value.
func (o *GetConversionRateResponse) GetConversionCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ConversionCount
}

// GetConversionCountOk returns a tuple with the ConversionCount field value
// and a boolean to check if the value has been set.
func (o *GetConversionRateResponse) GetConversionCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ConversionCount, true
}

// SetConversionCount sets field value.
func (o *GetConversionRateResponse) SetConversionCount(v int32) *GetConversionRateResponse {
	o.ConversionCount = v
	return o
}

// GetDates returns the Dates field value.
func (o *GetConversionRateResponse) GetDates() []DailyConversionRates {
	if o == nil {
		var ret []DailyConversionRates
		return ret
	}

	return o.Dates
}

// GetDatesOk returns a tuple with the Dates field value
// and a boolean to check if the value has been set.
func (o *GetConversionRateResponse) GetDatesOk() ([]DailyConversionRates, bool) {
	if o == nil {
		return nil, false
	}
	return o.Dates, true
}

// SetDates sets field value.
func (o *GetConversionRateResponse) SetDates(v []DailyConversionRates) *GetConversionRateResponse {
	o.Dates = v
	return o
}

func (o GetConversionRateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["rate"] = o.Rate.Get()
	toSerialize["trackedSearchCount"] = o.TrackedSearchCount
	toSerialize["conversionCount"] = o.ConversionCount
	toSerialize["dates"] = o.Dates
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetConversionRateResponse: %w", err)
	}

	return serialized, nil
}

func (o GetConversionRateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  rate=%v\n", o.Rate)
	out += fmt.Sprintf("  trackedSearchCount=%v\n", o.TrackedSearchCount)
	out += fmt.Sprintf("  conversionCount=%v\n", o.ConversionCount)
	out += fmt.Sprintf("  dates=%v\n", o.Dates)
	return fmt.Sprintf("GetConversionRateResponse {\n%s}", out)
}
