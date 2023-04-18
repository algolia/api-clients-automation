// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package predict

import (
	"encoding/json"
	"fmt"
)

// Affinity struct for Affinity
type Affinity struct {
	Name        string                  `json:"name"`
	Value       PredictionAffinityValue `json:"value"`
	Probability float64                 `json:"probability"`
}

// NewAffinity instantiates a new Affinity object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAffinity(name string, value PredictionAffinityValue, probability float64) *Affinity {
	this := &Affinity{}
	this.Name = name
	this.Value = value
	this.Probability = probability
	return this
}

// NewAffinityWithDefaults instantiates a new Affinity object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAffinityWithDefaults() *Affinity {
	this := &Affinity{}
	return this
}

// GetName returns the Name field value
func (o *Affinity) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *Affinity) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value
func (o *Affinity) SetName(v string) {
	o.Name = v
}

// GetValue returns the Value field value
func (o *Affinity) GetValue() PredictionAffinityValue {
	if o == nil {
		var ret PredictionAffinityValue
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *Affinity) GetValueOk() (*PredictionAffinityValue, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value
func (o *Affinity) SetValue(v PredictionAffinityValue) {
	o.Value = v
}

// GetProbability returns the Probability field value
func (o *Affinity) GetProbability() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Probability
}

// GetProbabilityOk returns a tuple with the Probability field value
// and a boolean to check if the value has been set.
func (o *Affinity) GetProbabilityOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Probability, true
}

// SetProbability sets field value
func (o *Affinity) SetProbability(v float64) {
	o.Probability = v
}

func (o Affinity) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["name"] = o.Name
	}
	if true {
		toSerialize["value"] = o.Value
	}
	if true {
		toSerialize["probability"] = o.Probability
	}
	return json.Marshal(toSerialize)
}

func (o Affinity) String() string {
	out := ""
	out += fmt.Sprintf("  name=%v\n", o.Name)
	out += fmt.Sprintf("  value=%v\n", o.Value)
	out += fmt.Sprintf("  probability=%v\n", o.Probability)
	return fmt.Sprintf("Affinity {\n%s}", out)
}

type NullableAffinity struct {
	value *Affinity
	isSet bool
}

func (v NullableAffinity) Get() *Affinity {
	return v.value
}

func (v *NullableAffinity) Set(val *Affinity) {
	v.value = val
	v.isSet = true
}

func (v NullableAffinity) IsSet() bool {
	return v.isSet
}

func (v *NullableAffinity) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAffinity(val *Affinity) *NullableAffinity {
	return &NullableAffinity{value: val, isSet: true}
}

func (v NullableAffinity) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAffinity) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
