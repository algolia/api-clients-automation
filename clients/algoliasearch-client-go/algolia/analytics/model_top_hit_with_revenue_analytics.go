// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// TopHitWithRevenueAnalytics struct for TopHitWithRevenueAnalytics.
type TopHitWithRevenueAnalytics struct {
	// Object ID of a record that's returned as a search result.
	Hit string `json:"hit"`
	// Number of occurrences.
	Count int32 `json:"count"`
	// Click-through rate, calculated as number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	ClickThroughRate utils.Nullable[float64] `json:"clickThroughRate"`
	// Conversion rate, calculated as number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	ConversionRate utils.Nullable[float64] `json:"conversionRate"`
	// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
	TrackedHitCount int32 `json:"trackedHitCount"`
	// Number of clicks associated with this search.
	ClickCount int32 `json:"clickCount"`
	// Number of conversions from this search.
	ConversionCount int32 `json:"conversionCount"`
	// Add-to-cart rate, calculated as number of tracked searches with at least one add-to-cart event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	AddToCartRate utils.Nullable[float64] `json:"addToCartRate"`
	// Number of add-to-cart events from this search.
	AddToCartCount int32 `json:"addToCartCount"`
	// Purchase rate, calculated as number of tracked searches with at least one purchase event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	PurchaseRate utils.Nullable[float64] `json:"purchaseRate"`
	// Number of purchase events from this search.
	PurchaseCount int32 `json:"purchaseCount"`
	// Revenue associated with this search, broken-down by currencies.
	Currencies map[string]CurrencyCode `json:"currencies"`
}

// NewTopHitWithRevenueAnalytics instantiates a new TopHitWithRevenueAnalytics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTopHitWithRevenueAnalytics(hit string, count int32, clickThroughRate utils.Nullable[float64], conversionRate utils.Nullable[float64], trackedHitCount int32, clickCount int32, conversionCount int32, addToCartRate utils.Nullable[float64], addToCartCount int32, purchaseRate utils.Nullable[float64], purchaseCount int32, currencies map[string]CurrencyCode) *TopHitWithRevenueAnalytics {
	this := &TopHitWithRevenueAnalytics{}
	this.Hit = hit
	this.Count = count
	this.ClickThroughRate = clickThroughRate
	this.ConversionRate = conversionRate
	this.TrackedHitCount = trackedHitCount
	this.ClickCount = clickCount
	this.ConversionCount = conversionCount
	this.AddToCartRate = addToCartRate
	this.AddToCartCount = addToCartCount
	this.PurchaseRate = purchaseRate
	this.PurchaseCount = purchaseCount
	this.Currencies = currencies
	return this
}

// NewEmptyTopHitWithRevenueAnalytics return a pointer to an empty TopHitWithRevenueAnalytics object.
func NewEmptyTopHitWithRevenueAnalytics() *TopHitWithRevenueAnalytics {
	return &TopHitWithRevenueAnalytics{}
}

// GetHit returns the Hit field value.
func (o *TopHitWithRevenueAnalytics) GetHit() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Hit
}

// GetHitOk returns a tuple with the Hit field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetHitOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Hit, true
}

// SetHit sets field value.
func (o *TopHitWithRevenueAnalytics) SetHit(v string) *TopHitWithRevenueAnalytics {
	o.Hit = v
	return o
}

// GetCount returns the Count field value.
func (o *TopHitWithRevenueAnalytics) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetCount(v int32) *TopHitWithRevenueAnalytics {
	o.Count = v
	return o
}

// GetClickThroughRate returns the ClickThroughRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopHitWithRevenueAnalytics) GetClickThroughRate() float64 {
	if o == nil || o.ClickThroughRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.ClickThroughRate.Get()
}

// GetClickThroughRateOk returns a tuple with the ClickThroughRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopHitWithRevenueAnalytics) GetClickThroughRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.ClickThroughRate.Get(), o.ClickThroughRate.IsSet()
}

// SetClickThroughRate sets field value.
func (o *TopHitWithRevenueAnalytics) SetClickThroughRate(v float64) *TopHitWithRevenueAnalytics {
	o.ClickThroughRate.Set(&v)
	return o
}

// GetConversionRate returns the ConversionRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopHitWithRevenueAnalytics) GetConversionRate() float64 {
	if o == nil || o.ConversionRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.ConversionRate.Get()
}

// GetConversionRateOk returns a tuple with the ConversionRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopHitWithRevenueAnalytics) GetConversionRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.ConversionRate.Get(), o.ConversionRate.IsSet()
}

// SetConversionRate sets field value.
func (o *TopHitWithRevenueAnalytics) SetConversionRate(v float64) *TopHitWithRevenueAnalytics {
	o.ConversionRate.Set(&v)
	return o
}

// GetTrackedHitCount returns the TrackedHitCount field value.
func (o *TopHitWithRevenueAnalytics) GetTrackedHitCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.TrackedHitCount
}

// GetTrackedHitCountOk returns a tuple with the TrackedHitCount field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetTrackedHitCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TrackedHitCount, true
}

// SetTrackedHitCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetTrackedHitCount(v int32) *TopHitWithRevenueAnalytics {
	o.TrackedHitCount = v
	return o
}

// GetClickCount returns the ClickCount field value.
func (o *TopHitWithRevenueAnalytics) GetClickCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ClickCount
}

// GetClickCountOk returns a tuple with the ClickCount field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetClickCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ClickCount, true
}

// SetClickCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetClickCount(v int32) *TopHitWithRevenueAnalytics {
	o.ClickCount = v
	return o
}

// GetConversionCount returns the ConversionCount field value.
func (o *TopHitWithRevenueAnalytics) GetConversionCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ConversionCount
}

// GetConversionCountOk returns a tuple with the ConversionCount field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetConversionCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ConversionCount, true
}

// SetConversionCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetConversionCount(v int32) *TopHitWithRevenueAnalytics {
	o.ConversionCount = v
	return o
}

// GetAddToCartRate returns the AddToCartRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopHitWithRevenueAnalytics) GetAddToCartRate() float64 {
	if o == nil || o.AddToCartRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.AddToCartRate.Get()
}

// GetAddToCartRateOk returns a tuple with the AddToCartRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopHitWithRevenueAnalytics) GetAddToCartRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.AddToCartRate.Get(), o.AddToCartRate.IsSet()
}

// SetAddToCartRate sets field value.
func (o *TopHitWithRevenueAnalytics) SetAddToCartRate(v float64) *TopHitWithRevenueAnalytics {
	o.AddToCartRate.Set(&v)
	return o
}

// GetAddToCartCount returns the AddToCartCount field value.
func (o *TopHitWithRevenueAnalytics) GetAddToCartCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.AddToCartCount
}

// GetAddToCartCountOk returns a tuple with the AddToCartCount field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetAddToCartCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.AddToCartCount, true
}

// SetAddToCartCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetAddToCartCount(v int32) *TopHitWithRevenueAnalytics {
	o.AddToCartCount = v
	return o
}

// GetPurchaseRate returns the PurchaseRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopHitWithRevenueAnalytics) GetPurchaseRate() float64 {
	if o == nil || o.PurchaseRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.PurchaseRate.Get()
}

// GetPurchaseRateOk returns a tuple with the PurchaseRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopHitWithRevenueAnalytics) GetPurchaseRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.PurchaseRate.Get(), o.PurchaseRate.IsSet()
}

// SetPurchaseRate sets field value.
func (o *TopHitWithRevenueAnalytics) SetPurchaseRate(v float64) *TopHitWithRevenueAnalytics {
	o.PurchaseRate.Set(&v)
	return o
}

// GetPurchaseCount returns the PurchaseCount field value.
func (o *TopHitWithRevenueAnalytics) GetPurchaseCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.PurchaseCount
}

// GetPurchaseCountOk returns a tuple with the PurchaseCount field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetPurchaseCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.PurchaseCount, true
}

// SetPurchaseCount sets field value.
func (o *TopHitWithRevenueAnalytics) SetPurchaseCount(v int32) *TopHitWithRevenueAnalytics {
	o.PurchaseCount = v
	return o
}

// GetCurrencies returns the Currencies field value.
func (o *TopHitWithRevenueAnalytics) GetCurrencies() map[string]CurrencyCode {
	if o == nil {
		var ret map[string]CurrencyCode
		return ret
	}

	return o.Currencies
}

// GetCurrenciesOk returns a tuple with the Currencies field value
// and a boolean to check if the value has been set.
func (o *TopHitWithRevenueAnalytics) GetCurrenciesOk() (*map[string]CurrencyCode, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Currencies, true
}

// SetCurrencies sets field value.
func (o *TopHitWithRevenueAnalytics) SetCurrencies(v map[string]CurrencyCode) *TopHitWithRevenueAnalytics {
	o.Currencies = v
	return o
}

func (o TopHitWithRevenueAnalytics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["hit"] = o.Hit
	}
	if true {
		toSerialize["count"] = o.Count
	}
	if true {
		toSerialize["clickThroughRate"] = o.ClickThroughRate.Get()
	}
	if true {
		toSerialize["conversionRate"] = o.ConversionRate.Get()
	}
	if true {
		toSerialize["trackedHitCount"] = o.TrackedHitCount
	}
	if true {
		toSerialize["clickCount"] = o.ClickCount
	}
	if true {
		toSerialize["conversionCount"] = o.ConversionCount
	}
	if true {
		toSerialize["addToCartRate"] = o.AddToCartRate.Get()
	}
	if true {
		toSerialize["addToCartCount"] = o.AddToCartCount
	}
	if true {
		toSerialize["purchaseRate"] = o.PurchaseRate.Get()
	}
	if true {
		toSerialize["purchaseCount"] = o.PurchaseCount
	}
	if true {
		toSerialize["currencies"] = o.Currencies
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TopHitWithRevenueAnalytics: %w", err)
	}

	return serialized, nil
}

func (o TopHitWithRevenueAnalytics) String() string {
	out := ""
	out += fmt.Sprintf("  hit=%v\n", o.Hit)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  clickThroughRate=%v\n", o.ClickThroughRate)
	out += fmt.Sprintf("  conversionRate=%v\n", o.ConversionRate)
	out += fmt.Sprintf("  trackedHitCount=%v\n", o.TrackedHitCount)
	out += fmt.Sprintf("  clickCount=%v\n", o.ClickCount)
	out += fmt.Sprintf("  conversionCount=%v\n", o.ConversionCount)
	out += fmt.Sprintf("  addToCartRate=%v\n", o.AddToCartRate)
	out += fmt.Sprintf("  addToCartCount=%v\n", o.AddToCartCount)
	out += fmt.Sprintf("  purchaseRate=%v\n", o.PurchaseRate)
	out += fmt.Sprintf("  purchaseCount=%v\n", o.PurchaseCount)
	out += fmt.Sprintf("  currencies=%v\n", o.Currencies)
	return fmt.Sprintf("TopHitWithRevenueAnalytics {\n%s}", out)
}
