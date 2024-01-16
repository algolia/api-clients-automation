// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetNoClickRateResponse struct for GetNoClickRateResponse.
type GetNoClickRateResponse struct {
	// [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
	Rate float64 `json:"rate"`
	// Number of click events.
	Count int32 `json:"count"`
	// Number of click events.
	NoClickCount int32 `json:"noClickCount"`
	// Overall count of searches without clicks plus a daily breakdown.
	Dates []NoClickRateEvent `json:"dates"`
}

// NewGetNoClickRateResponse instantiates a new GetNoClickRateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetNoClickRateResponse(rate float64, count int32, noClickCount int32, dates []NoClickRateEvent) *GetNoClickRateResponse {
	this := &GetNoClickRateResponse{}
	this.Rate = rate
	this.Count = count
	this.NoClickCount = noClickCount
	this.Dates = dates
	return this
}

// NewEmptyGetNoClickRateResponse return a pointer to an empty GetNoClickRateResponse object.
func NewEmptyGetNoClickRateResponse() *GetNoClickRateResponse {
	return &GetNoClickRateResponse{}
}

// GetRate returns the Rate field value.
func (o *GetNoClickRateResponse) GetRate() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Rate
}

// GetRateOk returns a tuple with the Rate field value
// and a boolean to check if the value has been set.
func (o *GetNoClickRateResponse) GetRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Rate, true
}

// SetRate sets field value.
func (o *GetNoClickRateResponse) SetRate(v float64) *GetNoClickRateResponse {
	o.Rate = v
	return o
}

// GetCount returns the Count field value.
func (o *GetNoClickRateResponse) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *GetNoClickRateResponse) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *GetNoClickRateResponse) SetCount(v int32) *GetNoClickRateResponse {
	o.Count = v
	return o
}

// GetNoClickCount returns the NoClickCount field value.
func (o *GetNoClickRateResponse) GetNoClickCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NoClickCount
}

// GetNoClickCountOk returns a tuple with the NoClickCount field value
// and a boolean to check if the value has been set.
func (o *GetNoClickRateResponse) GetNoClickCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NoClickCount, true
}

// SetNoClickCount sets field value.
func (o *GetNoClickRateResponse) SetNoClickCount(v int32) *GetNoClickRateResponse {
	o.NoClickCount = v
	return o
}

// GetDates returns the Dates field value.
func (o *GetNoClickRateResponse) GetDates() []NoClickRateEvent {
	if o == nil {
		var ret []NoClickRateEvent
		return ret
	}

	return o.Dates
}

// GetDatesOk returns a tuple with the Dates field value
// and a boolean to check if the value has been set.
func (o *GetNoClickRateResponse) GetDatesOk() ([]NoClickRateEvent, bool) {
	if o == nil {
		return nil, false
	}
	return o.Dates, true
}

// SetDates sets field value.
func (o *GetNoClickRateResponse) SetDates(v []NoClickRateEvent) *GetNoClickRateResponse {
	o.Dates = v
	return o
}

func (o GetNoClickRateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["rate"] = o.Rate
	}
	if true {
		toSerialize["count"] = o.Count
	}
	if true {
		toSerialize["noClickCount"] = o.NoClickCount
	}
	if true {
		toSerialize["dates"] = o.Dates
	}
	return json.Marshal(toSerialize)
}

func (o GetNoClickRateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  rate=%v\n", o.Rate)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  noClickCount=%v\n", o.NoClickCount)
	out += fmt.Sprintf("  dates=%v\n", o.Dates)
	return fmt.Sprintf("GetNoClickRateResponse {\n%s}", out)
}

type NullableGetNoClickRateResponse struct {
	value *GetNoClickRateResponse
	isSet bool
}

func (v NullableGetNoClickRateResponse) Get() *GetNoClickRateResponse {
	return v.value
}

func (v *NullableGetNoClickRateResponse) Set(val *GetNoClickRateResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetNoClickRateResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetNoClickRateResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetNoClickRateResponse(val *GetNoClickRateResponse) *NullableGetNoClickRateResponse {
	return &NullableGetNoClickRateResponse{value: val, isSet: true}
}

func (v NullableGetNoClickRateResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetNoClickRateResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
