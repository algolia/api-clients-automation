// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// DailyRevenue struct for DailyRevenue.
type DailyRevenue struct {
	// Revenue associated with this search, broken-down by currencies.
	Currencies map[string]CurrenciesValue `json:"currencies"`
	// Date in the format YYYY-MM-DD.
	Date string `json:"date"`
}

// NewDailyRevenue instantiates a new DailyRevenue object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDailyRevenue(currencies map[string]CurrenciesValue, date string) *DailyRevenue {
	this := &DailyRevenue{}
	this.Currencies = currencies
	this.Date = date
	return this
}

// NewEmptyDailyRevenue return a pointer to an empty DailyRevenue object.
func NewEmptyDailyRevenue() *DailyRevenue {
	return &DailyRevenue{}
}

// GetCurrencies returns the Currencies field value.
func (o *DailyRevenue) GetCurrencies() map[string]CurrenciesValue {
	if o == nil {
		var ret map[string]CurrenciesValue
		return ret
	}

	return o.Currencies
}

// GetCurrenciesOk returns a tuple with the Currencies field value
// and a boolean to check if the value has been set.
func (o *DailyRevenue) GetCurrenciesOk() (*map[string]CurrenciesValue, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Currencies, true
}

// SetCurrencies sets field value.
func (o *DailyRevenue) SetCurrencies(v map[string]CurrenciesValue) *DailyRevenue {
	o.Currencies = v
	return o
}

// GetDate returns the Date field value.
func (o *DailyRevenue) GetDate() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Date
}

// GetDateOk returns a tuple with the Date field value
// and a boolean to check if the value has been set.
func (o *DailyRevenue) GetDateOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Date, true
}

// SetDate sets field value.
func (o *DailyRevenue) SetDate(v string) *DailyRevenue {
	o.Date = v
	return o
}

func (o DailyRevenue) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["currencies"] = o.Currencies
	}
	if true {
		toSerialize["date"] = o.Date
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DailyRevenue: %w", err)
	}

	return serialized, nil
}

func (o DailyRevenue) String() string {
	out := ""
	out += fmt.Sprintf("  currencies=%v\n", o.Currencies)
	out += fmt.Sprintf("  date=%v\n", o.Date)
	return fmt.Sprintf("DailyRevenue {\n%s}", out)
}
