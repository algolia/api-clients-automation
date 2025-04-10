// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// DailyPurchaseRates struct for DailyPurchaseRates.
type DailyPurchaseRates struct {
	// Purchase rate: calculated as the number of tracked searches with at least one purchase event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	Rate utils.Nullable[float64] `json:"rate"`
	// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
	TrackedSearchCount int32 `json:"trackedSearchCount"`
	// Number of purchase events from this search.
	PurchaseCount int32 `json:"purchaseCount"`
	// Date in the format YYYY-MM-DD.
	Date string `json:"date"`
}

// NewDailyPurchaseRates instantiates a new DailyPurchaseRates object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDailyPurchaseRates(rate utils.Nullable[float64], trackedSearchCount int32, purchaseCount int32, date string) *DailyPurchaseRates {
	this := &DailyPurchaseRates{}
	this.Rate = rate
	this.TrackedSearchCount = trackedSearchCount
	this.PurchaseCount = purchaseCount
	this.Date = date
	return this
}

// NewEmptyDailyPurchaseRates return a pointer to an empty DailyPurchaseRates object.
func NewEmptyDailyPurchaseRates() *DailyPurchaseRates {
	return &DailyPurchaseRates{}
}

// GetRate returns the Rate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *DailyPurchaseRates) GetRate() float64 {
	if o == nil || o.Rate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.Rate.Get()
}

// GetRateOk returns a tuple with the Rate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *DailyPurchaseRates) GetRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.Rate.Get(), o.Rate.IsSet()
}

// SetRate sets field value.
func (o *DailyPurchaseRates) SetRate(v float64) *DailyPurchaseRates {
	o.Rate.Set(&v)
	return o
}

// GetTrackedSearchCount returns the TrackedSearchCount field value.
func (o *DailyPurchaseRates) GetTrackedSearchCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.TrackedSearchCount
}

// GetTrackedSearchCountOk returns a tuple with the TrackedSearchCount field value
// and a boolean to check if the value has been set.
func (o *DailyPurchaseRates) GetTrackedSearchCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TrackedSearchCount, true
}

// SetTrackedSearchCount sets field value.
func (o *DailyPurchaseRates) SetTrackedSearchCount(v int32) *DailyPurchaseRates {
	o.TrackedSearchCount = v
	return o
}

// GetPurchaseCount returns the PurchaseCount field value.
func (o *DailyPurchaseRates) GetPurchaseCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.PurchaseCount
}

// GetPurchaseCountOk returns a tuple with the PurchaseCount field value
// and a boolean to check if the value has been set.
func (o *DailyPurchaseRates) GetPurchaseCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.PurchaseCount, true
}

// SetPurchaseCount sets field value.
func (o *DailyPurchaseRates) SetPurchaseCount(v int32) *DailyPurchaseRates {
	o.PurchaseCount = v
	return o
}

// GetDate returns the Date field value.
func (o *DailyPurchaseRates) GetDate() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Date
}

// GetDateOk returns a tuple with the Date field value
// and a boolean to check if the value has been set.
func (o *DailyPurchaseRates) GetDateOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Date, true
}

// SetDate sets field value.
func (o *DailyPurchaseRates) SetDate(v string) *DailyPurchaseRates {
	o.Date = v
	return o
}

func (o DailyPurchaseRates) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["rate"] = o.Rate.Get()
	toSerialize["trackedSearchCount"] = o.TrackedSearchCount
	toSerialize["purchaseCount"] = o.PurchaseCount
	toSerialize["date"] = o.Date
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DailyPurchaseRates: %w", err)
	}

	return serialized, nil
}

func (o DailyPurchaseRates) String() string {
	out := ""
	out += fmt.Sprintf("  rate=%v\n", o.Rate)
	out += fmt.Sprintf("  trackedSearchCount=%v\n", o.TrackedSearchCount)
	out += fmt.Sprintf("  purchaseCount=%v\n", o.PurchaseCount)
	out += fmt.Sprintf("  date=%v\n", o.Date)
	return fmt.Sprintf("DailyPurchaseRates {\n%s}", out)
}
