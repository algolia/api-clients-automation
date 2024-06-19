// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ShopifyMarket Represents a market in Shopify.
type ShopifyMarket struct {
	Countries  []string `json:"countries"`
	Currencies []string `json:"currencies"`
	Locales    []string `json:"locales"`
}

// NewShopifyMarket instantiates a new ShopifyMarket object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewShopifyMarket(countries []string, currencies []string, locales []string) *ShopifyMarket {
	this := &ShopifyMarket{}
	this.Countries = countries
	this.Currencies = currencies
	this.Locales = locales
	return this
}

// NewEmptyShopifyMarket return a pointer to an empty ShopifyMarket object.
func NewEmptyShopifyMarket() *ShopifyMarket {
	return &ShopifyMarket{}
}

// GetCountries returns the Countries field value.
func (o *ShopifyMarket) GetCountries() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.Countries
}

// GetCountriesOk returns a tuple with the Countries field value
// and a boolean to check if the value has been set.
func (o *ShopifyMarket) GetCountriesOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Countries, true
}

// SetCountries sets field value.
func (o *ShopifyMarket) SetCountries(v []string) *ShopifyMarket {
	o.Countries = v
	return o
}

// GetCurrencies returns the Currencies field value.
func (o *ShopifyMarket) GetCurrencies() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.Currencies
}

// GetCurrenciesOk returns a tuple with the Currencies field value
// and a boolean to check if the value has been set.
func (o *ShopifyMarket) GetCurrenciesOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Currencies, true
}

// SetCurrencies sets field value.
func (o *ShopifyMarket) SetCurrencies(v []string) *ShopifyMarket {
	o.Currencies = v
	return o
}

// GetLocales returns the Locales field value.
func (o *ShopifyMarket) GetLocales() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.Locales
}

// GetLocalesOk returns a tuple with the Locales field value
// and a boolean to check if the value has been set.
func (o *ShopifyMarket) GetLocalesOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Locales, true
}

// SetLocales sets field value.
func (o *ShopifyMarket) SetLocales(v []string) *ShopifyMarket {
	o.Locales = v
	return o
}

func (o ShopifyMarket) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["countries"] = o.Countries
	}
	if true {
		toSerialize["currencies"] = o.Currencies
	}
	if true {
		toSerialize["locales"] = o.Locales
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ShopifyMarket: %w", err)
	}

	return serialized, nil
}

func (o ShopifyMarket) String() string {
	out := ""
	out += fmt.Sprintf("  countries=%v\n", o.Countries)
	out += fmt.Sprintf("  currencies=%v\n", o.Currencies)
	out += fmt.Sprintf("  locales=%v\n", o.Locales)
	return fmt.Sprintf("ShopifyMarket {\n%s}", out)
}
