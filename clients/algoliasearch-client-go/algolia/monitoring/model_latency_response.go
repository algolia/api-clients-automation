// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// LatencyResponse struct for LatencyResponse.
type LatencyResponse struct {
	Metrics *LatencyMetric `json:"metrics,omitempty"`
}

type LatencyResponseOption func(f *LatencyResponse)

func WithLatencyResponseMetrics(val LatencyMetric) LatencyResponseOption {
	return func(f *LatencyResponse) {
		f.Metrics = &val
	}
}

// NewLatencyResponse instantiates a new LatencyResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewLatencyResponse(opts ...LatencyResponseOption) *LatencyResponse {
	this := &LatencyResponse{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyLatencyResponse return a pointer to an empty LatencyResponse object.
func NewEmptyLatencyResponse() *LatencyResponse {
	return &LatencyResponse{}
}

// GetMetrics returns the Metrics field value if set, zero value otherwise.
func (o *LatencyResponse) GetMetrics() LatencyMetric {
	if o == nil || o.Metrics == nil {
		var ret LatencyMetric
		return ret
	}
	return *o.Metrics
}

// GetMetricsOk returns a tuple with the Metrics field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *LatencyResponse) GetMetricsOk() (*LatencyMetric, bool) {
	if o == nil || o.Metrics == nil {
		return nil, false
	}
	return o.Metrics, true
}

// HasMetrics returns a boolean if a field has been set.
func (o *LatencyResponse) HasMetrics() bool {
	if o != nil && o.Metrics != nil {
		return true
	}

	return false
}

// SetMetrics gets a reference to the given LatencyMetric and assigns it to the Metrics field.
func (o *LatencyResponse) SetMetrics(v *LatencyMetric) *LatencyResponse {
	o.Metrics = v
	return o
}

func (o LatencyResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Metrics != nil {
		toSerialize["metrics"] = o.Metrics
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal LatencyResponse: %w", err)
	}

	return serialized, nil
}

func (o LatencyResponse) String() string {
	out := ""
	out += fmt.Sprintf("  metrics=%v\n", o.Metrics)
	return fmt.Sprintf("LatencyResponse {\n%s}", out)
}
