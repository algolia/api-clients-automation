// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package predict

import (
	"encoding/json"
	"fmt"
)

// FunnelStage struct for FunnelStage
type FunnelStage struct {
	Name        string  `json:"name"`
	Probability float64 `json:"probability"`
}

// NewFunnelStage instantiates a new FunnelStage object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewFunnelStage(name string, probability float64) *FunnelStage {
	this := &FunnelStage{}
	this.Name = name
	this.Probability = probability
	return this
}

// NewFunnelStageWithDefaults instantiates a new FunnelStage object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewFunnelStageWithDefaults() *FunnelStage {
	this := &FunnelStage{}
	return this
}

// GetName returns the Name field value
func (o *FunnelStage) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *FunnelStage) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *FunnelStage) SetName(v string) {
	o.Name = v
}

// GetProbability returns the Probability field value
func (o *FunnelStage) GetProbability() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Probability
}

// GetProbabilityOk returns a tuple with the Probability field value
// and a boolean to check if the value has been set.
func (o *FunnelStage) GetProbabilityOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Probability, true
}

// SetProbability sets field value
func (o *FunnelStage) SetProbability(v float64) {
	o.Probability = v
}

func (o FunnelStage) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["name"] = o.Name
	}
	if true {
		toSerialize["probability"] = o.Probability
	}
	return json.Marshal(toSerialize)
}

func (o FunnelStage) String() string {
	out := ""
	out += fmt.Sprintf("  name=%v\n", o.Name)
	out += fmt.Sprintf("  probability=%v\n", o.Probability)
	return fmt.Sprintf("FunnelStage {\n%s}", out)
}

type NullableFunnelStage struct {
	value *FunnelStage
	isSet bool
}

func (v NullableFunnelStage) Get() *FunnelStage {
	return v.value
}

func (v *NullableFunnelStage) Set(val *FunnelStage) {
	v.value = val
	v.isSet = true
}

func (v NullableFunnelStage) IsSet() bool {
	return v.isSet
}

func (v *NullableFunnelStage) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFunnelStage(val *FunnelStage) *NullableFunnelStage {
	return &NullableFunnelStage{value: val, isSet: true}
}

func (v NullableFunnelStage) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFunnelStage) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
