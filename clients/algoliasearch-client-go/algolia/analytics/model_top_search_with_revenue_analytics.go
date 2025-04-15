// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

// TopSearchWithRevenueAnalytics struct for TopSearchWithRevenueAnalytics.
type TopSearchWithRevenueAnalytics struct {
	// Search query.
	Search string `json:"search"`
	// Number of searches.
	Count int32 `json:"count"`
	// Click-through rate: calculated as the number of tracked searches with at least one click event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	ClickThroughRate utils.Nullable[float64] `json:"clickThroughRate"`
	// Average position of a clicked search result in the list of search results. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	AverageClickPosition utils.Nullable[float64] `json:"averageClickPosition"`
	// List of positions in the search results and clicks associated with this search.
	ClickPositions []ClickPosition `json:"clickPositions"`
	// Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	ConversionRate utils.Nullable[float64] `json:"conversionRate"`
	// Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
	TrackedSearchCount int32 `json:"trackedSearchCount"`
	// Number of clicks associated with this search.
	ClickCount int32 `json:"clickCount"`
	// Number of conversions from this search.
	ConversionCount int32 `json:"conversionCount"`
	// Number of results (hits).
	NbHits int32 `json:"nbHits"`
	// Revenue associated with this search: broken down by currency.
	Currencies map[string]CurrencyCode `json:"currencies"`
	// Add-to-cart rate: calculated as the number of tracked searches with at least one add-to-cart event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	AddToCartRate utils.Nullable[float64] `json:"addToCartRate"`
	// Number of add-to-cart events from this search.
	AddToCartCount int32 `json:"addToCartCount"`
	// Purchase rate: calculated as the number of tracked searches with at least one purchase event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
	PurchaseRate utils.Nullable[float64] `json:"purchaseRate"`
	// Number of purchase events from this search.
	PurchaseCount int32 `json:"purchaseCount"`
}

// NewTopSearchWithRevenueAnalytics instantiates a new TopSearchWithRevenueAnalytics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTopSearchWithRevenueAnalytics(search string, count int32, clickThroughRate utils.Nullable[float64], averageClickPosition utils.Nullable[float64], clickPositions []ClickPosition, conversionRate utils.Nullable[float64], trackedSearchCount int32, clickCount int32, conversionCount int32, nbHits int32, currencies map[string]CurrencyCode, addToCartRate utils.Nullable[float64], addToCartCount int32, purchaseRate utils.Nullable[float64], purchaseCount int32) *TopSearchWithRevenueAnalytics {
	this := &TopSearchWithRevenueAnalytics{}
	this.Search = search
	this.Count = count
	this.ClickThroughRate = clickThroughRate
	this.AverageClickPosition = averageClickPosition
	this.ClickPositions = clickPositions
	this.ConversionRate = conversionRate
	this.TrackedSearchCount = trackedSearchCount
	this.ClickCount = clickCount
	this.ConversionCount = conversionCount
	this.NbHits = nbHits
	this.Currencies = currencies
	this.AddToCartRate = addToCartRate
	this.AddToCartCount = addToCartCount
	this.PurchaseRate = purchaseRate
	this.PurchaseCount = purchaseCount
	return this
}

// NewEmptyTopSearchWithRevenueAnalytics return a pointer to an empty TopSearchWithRevenueAnalytics object.
func NewEmptyTopSearchWithRevenueAnalytics() *TopSearchWithRevenueAnalytics {
	return &TopSearchWithRevenueAnalytics{}
}

// GetSearch returns the Search field value.
func (o *TopSearchWithRevenueAnalytics) GetSearch() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Search
}

// GetSearchOk returns a tuple with the Search field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetSearchOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Search, true
}

// SetSearch sets field value.
func (o *TopSearchWithRevenueAnalytics) SetSearch(v string) *TopSearchWithRevenueAnalytics {
	o.Search = v
	return o
}

// GetCount returns the Count field value.
func (o *TopSearchWithRevenueAnalytics) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetCount(v int32) *TopSearchWithRevenueAnalytics {
	o.Count = v
	return o
}

// GetClickThroughRate returns the ClickThroughRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopSearchWithRevenueAnalytics) GetClickThroughRate() float64 {
	if o == nil || o.ClickThroughRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.ClickThroughRate.Get()
}

// GetClickThroughRateOk returns a tuple with the ClickThroughRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopSearchWithRevenueAnalytics) GetClickThroughRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.ClickThroughRate.Get(), o.ClickThroughRate.IsSet()
}

// SetClickThroughRate sets field value.
func (o *TopSearchWithRevenueAnalytics) SetClickThroughRate(v float64) *TopSearchWithRevenueAnalytics {
	o.ClickThroughRate.Set(&v)
	return o
}

// GetAverageClickPosition returns the AverageClickPosition field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopSearchWithRevenueAnalytics) GetAverageClickPosition() float64 {
	if o == nil || o.AverageClickPosition.Get() == nil {
		var ret float64
		return ret
	}

	return *o.AverageClickPosition.Get()
}

// GetAverageClickPositionOk returns a tuple with the AverageClickPosition field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopSearchWithRevenueAnalytics) GetAverageClickPositionOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.AverageClickPosition.Get(), o.AverageClickPosition.IsSet()
}

// SetAverageClickPosition sets field value.
func (o *TopSearchWithRevenueAnalytics) SetAverageClickPosition(v float64) *TopSearchWithRevenueAnalytics {
	o.AverageClickPosition.Set(&v)
	return o
}

// GetClickPositions returns the ClickPositions field value.
func (o *TopSearchWithRevenueAnalytics) GetClickPositions() []ClickPosition {
	if o == nil {
		var ret []ClickPosition
		return ret
	}

	return o.ClickPositions
}

// GetClickPositionsOk returns a tuple with the ClickPositions field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetClickPositionsOk() ([]ClickPosition, bool) {
	if o == nil {
		return nil, false
	}
	return o.ClickPositions, true
}

// SetClickPositions sets field value.
func (o *TopSearchWithRevenueAnalytics) SetClickPositions(v []ClickPosition) *TopSearchWithRevenueAnalytics {
	o.ClickPositions = v
	return o
}

// GetConversionRate returns the ConversionRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopSearchWithRevenueAnalytics) GetConversionRate() float64 {
	if o == nil || o.ConversionRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.ConversionRate.Get()
}

// GetConversionRateOk returns a tuple with the ConversionRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopSearchWithRevenueAnalytics) GetConversionRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.ConversionRate.Get(), o.ConversionRate.IsSet()
}

// SetConversionRate sets field value.
func (o *TopSearchWithRevenueAnalytics) SetConversionRate(v float64) *TopSearchWithRevenueAnalytics {
	o.ConversionRate.Set(&v)
	return o
}

// GetTrackedSearchCount returns the TrackedSearchCount field value.
func (o *TopSearchWithRevenueAnalytics) GetTrackedSearchCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.TrackedSearchCount
}

// GetTrackedSearchCountOk returns a tuple with the TrackedSearchCount field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetTrackedSearchCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TrackedSearchCount, true
}

// SetTrackedSearchCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetTrackedSearchCount(v int32) *TopSearchWithRevenueAnalytics {
	o.TrackedSearchCount = v
	return o
}

// GetClickCount returns the ClickCount field value.
func (o *TopSearchWithRevenueAnalytics) GetClickCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ClickCount
}

// GetClickCountOk returns a tuple with the ClickCount field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetClickCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ClickCount, true
}

// SetClickCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetClickCount(v int32) *TopSearchWithRevenueAnalytics {
	o.ClickCount = v
	return o
}

// GetConversionCount returns the ConversionCount field value.
func (o *TopSearchWithRevenueAnalytics) GetConversionCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ConversionCount
}

// GetConversionCountOk returns a tuple with the ConversionCount field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetConversionCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ConversionCount, true
}

// SetConversionCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetConversionCount(v int32) *TopSearchWithRevenueAnalytics {
	o.ConversionCount = v
	return o
}

// GetNbHits returns the NbHits field value.
func (o *TopSearchWithRevenueAnalytics) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value.
func (o *TopSearchWithRevenueAnalytics) SetNbHits(v int32) *TopSearchWithRevenueAnalytics {
	o.NbHits = v
	return o
}

// GetCurrencies returns the Currencies field value.
func (o *TopSearchWithRevenueAnalytics) GetCurrencies() map[string]CurrencyCode {
	if o == nil {
		var ret map[string]CurrencyCode
		return ret
	}

	return o.Currencies
}

// GetCurrenciesOk returns a tuple with the Currencies field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetCurrenciesOk() (*map[string]CurrencyCode, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Currencies, true
}

// SetCurrencies sets field value.
func (o *TopSearchWithRevenueAnalytics) SetCurrencies(v map[string]CurrencyCode) *TopSearchWithRevenueAnalytics {
	o.Currencies = v
	return o
}

// GetAddToCartRate returns the AddToCartRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopSearchWithRevenueAnalytics) GetAddToCartRate() float64 {
	if o == nil || o.AddToCartRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.AddToCartRate.Get()
}

// GetAddToCartRateOk returns a tuple with the AddToCartRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopSearchWithRevenueAnalytics) GetAddToCartRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.AddToCartRate.Get(), o.AddToCartRate.IsSet()
}

// SetAddToCartRate sets field value.
func (o *TopSearchWithRevenueAnalytics) SetAddToCartRate(v float64) *TopSearchWithRevenueAnalytics {
	o.AddToCartRate.Set(&v)
	return o
}

// GetAddToCartCount returns the AddToCartCount field value.
func (o *TopSearchWithRevenueAnalytics) GetAddToCartCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.AddToCartCount
}

// GetAddToCartCountOk returns a tuple with the AddToCartCount field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetAddToCartCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.AddToCartCount, true
}

// SetAddToCartCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetAddToCartCount(v int32) *TopSearchWithRevenueAnalytics {
	o.AddToCartCount = v
	return o
}

// GetPurchaseRate returns the PurchaseRate field value.
// If the value is explicit nil, the zero value for float64 will be returned.
func (o *TopSearchWithRevenueAnalytics) GetPurchaseRate() float64 {
	if o == nil || o.PurchaseRate.Get() == nil {
		var ret float64
		return ret
	}

	return *o.PurchaseRate.Get()
}

// GetPurchaseRateOk returns a tuple with the PurchaseRate field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *TopSearchWithRevenueAnalytics) GetPurchaseRateOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return o.PurchaseRate.Get(), o.PurchaseRate.IsSet()
}

// SetPurchaseRate sets field value.
func (o *TopSearchWithRevenueAnalytics) SetPurchaseRate(v float64) *TopSearchWithRevenueAnalytics {
	o.PurchaseRate.Set(&v)
	return o
}

// GetPurchaseCount returns the PurchaseCount field value.
func (o *TopSearchWithRevenueAnalytics) GetPurchaseCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.PurchaseCount
}

// GetPurchaseCountOk returns a tuple with the PurchaseCount field value
// and a boolean to check if the value has been set.
func (o *TopSearchWithRevenueAnalytics) GetPurchaseCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.PurchaseCount, true
}

// SetPurchaseCount sets field value.
func (o *TopSearchWithRevenueAnalytics) SetPurchaseCount(v int32) *TopSearchWithRevenueAnalytics {
	o.PurchaseCount = v
	return o
}

func (o TopSearchWithRevenueAnalytics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["search"] = o.Search
	toSerialize["count"] = o.Count
	toSerialize["clickThroughRate"] = o.ClickThroughRate.Get()
	toSerialize["averageClickPosition"] = o.AverageClickPosition.Get()
	toSerialize["clickPositions"] = o.ClickPositions
	toSerialize["conversionRate"] = o.ConversionRate.Get()
	toSerialize["trackedSearchCount"] = o.TrackedSearchCount
	toSerialize["clickCount"] = o.ClickCount
	toSerialize["conversionCount"] = o.ConversionCount
	toSerialize["nbHits"] = o.NbHits
	toSerialize["currencies"] = o.Currencies
	toSerialize["addToCartRate"] = o.AddToCartRate.Get()
	toSerialize["addToCartCount"] = o.AddToCartCount
	toSerialize["purchaseRate"] = o.PurchaseRate.Get()
	toSerialize["purchaseCount"] = o.PurchaseCount
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TopSearchWithRevenueAnalytics: %w", err)
	}

	return serialized, nil
}

func (o TopSearchWithRevenueAnalytics) String() string {
	out := ""
	out += fmt.Sprintf("  search=%v\n", o.Search)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  clickThroughRate=%v\n", o.ClickThroughRate)
	out += fmt.Sprintf("  averageClickPosition=%v\n", o.AverageClickPosition)
	out += fmt.Sprintf("  clickPositions=%v\n", o.ClickPositions)
	out += fmt.Sprintf("  conversionRate=%v\n", o.ConversionRate)
	out += fmt.Sprintf("  trackedSearchCount=%v\n", o.TrackedSearchCount)
	out += fmt.Sprintf("  clickCount=%v\n", o.ClickCount)
	out += fmt.Sprintf("  conversionCount=%v\n", o.ConversionCount)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	out += fmt.Sprintf("  currencies=%v\n", o.Currencies)
	out += fmt.Sprintf("  addToCartRate=%v\n", o.AddToCartRate)
	out += fmt.Sprintf("  addToCartCount=%v\n", o.AddToCartCount)
	out += fmt.Sprintf("  purchaseRate=%v\n", o.PurchaseRate)
	out += fmt.Sprintf("  purchaseCount=%v\n", o.PurchaseCount)
	return fmt.Sprintf("TopSearchWithRevenueAnalytics {\n%s}", out)
}
