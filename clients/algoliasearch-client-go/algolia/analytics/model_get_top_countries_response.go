// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetTopCountriesResponse struct for GetTopCountriesResponse
type GetTopCountriesResponse struct {
	// A list of countries with their count.
	Countries []TopCountry `json:"countries" validate:"required"`
}

// NewGetTopCountriesResponse instantiates a new GetTopCountriesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGetTopCountriesResponse(countries []TopCountry) *GetTopCountriesResponse {
	this := &GetTopCountriesResponse{}
	this.Countries = countries
	return this
}

// NewGetTopCountriesResponseWithDefaults instantiates a new GetTopCountriesResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGetTopCountriesResponseWithDefaults() *GetTopCountriesResponse {
	this := &GetTopCountriesResponse{}
	return this
}

// GetCountries returns the Countries field value
func (o *GetTopCountriesResponse) GetCountries() []TopCountry {
	if o == nil {
		var ret []TopCountry
		return ret
	}

	return o.Countries
}

// GetCountriesOk returns a tuple with the Countries field value
// and a boolean to check if the value has been set.
func (o *GetTopCountriesResponse) GetCountriesOk() ([]TopCountry, bool) {
	if o == nil {
		return nil, false
	}
	return o.Countries, true
}

// SetCountries sets field value
func (o *GetTopCountriesResponse) SetCountries(v []TopCountry) {
	o.Countries = v
}

func (o GetTopCountriesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["countries"] = o.Countries
	}
	return json.Marshal(toSerialize)
}

func (o GetTopCountriesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  countries=%v\n", o.Countries)
	return fmt.Sprintf("GetTopCountriesResponse {\n%s}", out)
}

type NullableGetTopCountriesResponse struct {
	value *GetTopCountriesResponse
	isSet bool
}

func (v NullableGetTopCountriesResponse) Get() *GetTopCountriesResponse {
	return v.value
}

func (v *NullableGetTopCountriesResponse) Set(val *GetTopCountriesResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetTopCountriesResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetTopCountriesResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetTopCountriesResponse(val *GetTopCountriesResponse) *NullableGetTopCountriesResponse {
	return &NullableGetTopCountriesResponse{value: val, isSet: true}
}

func (v NullableGetTopCountriesResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetTopCountriesResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
