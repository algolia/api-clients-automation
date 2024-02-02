// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// LatencyResponseMetrics struct for LatencyResponseMetrics.
type LatencyResponseMetrics struct {
	Latency *map[string][]TimeInner `json:"latency,omitempty"`
}

type LatencyResponseMetricsOption func(f *LatencyResponseMetrics)

func WithLatencyResponseMetricsLatency(val map[string][]TimeInner) LatencyResponseMetricsOption {
	return func(f *LatencyResponseMetrics) {
		f.Latency = &val
	}
}

// NewLatencyResponseMetrics instantiates a new LatencyResponseMetrics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewLatencyResponseMetrics(opts ...LatencyResponseMetricsOption) *LatencyResponseMetrics {
	this := &LatencyResponseMetrics{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyLatencyResponseMetrics return a pointer to an empty LatencyResponseMetrics object.
func NewEmptyLatencyResponseMetrics() *LatencyResponseMetrics {
	return &LatencyResponseMetrics{}
}

// GetLatency returns the Latency field value if set, zero value otherwise.
func (o *LatencyResponseMetrics) GetLatency() map[string][]TimeInner {
	if o == nil || o.Latency == nil {
		var ret map[string][]TimeInner
		return ret
	}
	return *o.Latency
}

// GetLatencyOk returns a tuple with the Latency field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *LatencyResponseMetrics) GetLatencyOk() (*map[string][]TimeInner, bool) {
	if o == nil || o.Latency == nil {
		return nil, false
	}
	return o.Latency, true
}

// HasLatency returns a boolean if a field has been set.
func (o *LatencyResponseMetrics) HasLatency() bool {
	if o != nil && o.Latency != nil {
		return true
	}

	return false
}

// SetLatency gets a reference to the given map[string][]TimeInner and assigns it to the Latency field.
func (o *LatencyResponseMetrics) SetLatency(v map[string][]TimeInner) *LatencyResponseMetrics {
	o.Latency = &v
	return o
}

func (o LatencyResponseMetrics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Latency != nil {
		toSerialize["latency"] = o.Latency
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal LatencyResponseMetrics: %w", err)
	}

	return serialized, nil
}

func (o LatencyResponseMetrics) String() string {
	out := ""
	out += fmt.Sprintf("  latency=%v\n", o.Latency)
	return fmt.Sprintf("LatencyResponseMetrics {\n%s}", out)
}

type NullableLatencyResponseMetrics struct {
	value *LatencyResponseMetrics
	isSet bool
}

func (v NullableLatencyResponseMetrics) Get() *LatencyResponseMetrics {
	return v.value
}

func (v *NullableLatencyResponseMetrics) Set(val *LatencyResponseMetrics) {
	v.value = val
	v.isSet = true
}

func (v NullableLatencyResponseMetrics) IsSet() bool {
	return v.isSet
}

func (v *NullableLatencyResponseMetrics) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableLatencyResponseMetrics(val *LatencyResponseMetrics) *NullableLatencyResponseMetrics {
	return &NullableLatencyResponseMetrics{value: val, isSet: true}
}

func (v NullableLatencyResponseMetrics) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableLatencyResponseMetrics) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
