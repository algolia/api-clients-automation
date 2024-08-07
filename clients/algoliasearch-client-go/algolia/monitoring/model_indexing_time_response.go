// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// IndexingTimeResponse struct for IndexingTimeResponse.
type IndexingTimeResponse struct {
	Metrics *IndexingMetric `json:"metrics,omitempty"`
}

type IndexingTimeResponseOption func(f *IndexingTimeResponse)

func WithIndexingTimeResponseMetrics(val IndexingMetric) IndexingTimeResponseOption {
	return func(f *IndexingTimeResponse) {
		f.Metrics = &val
	}
}

// NewIndexingTimeResponse instantiates a new IndexingTimeResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewIndexingTimeResponse(opts ...IndexingTimeResponseOption) *IndexingTimeResponse {
	this := &IndexingTimeResponse{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyIndexingTimeResponse return a pointer to an empty IndexingTimeResponse object.
func NewEmptyIndexingTimeResponse() *IndexingTimeResponse {
	return &IndexingTimeResponse{}
}

// GetMetrics returns the Metrics field value if set, zero value otherwise.
func (o *IndexingTimeResponse) GetMetrics() IndexingMetric {
	if o == nil || o.Metrics == nil {
		var ret IndexingMetric
		return ret
	}
	return *o.Metrics
}

// GetMetricsOk returns a tuple with the Metrics field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *IndexingTimeResponse) GetMetricsOk() (*IndexingMetric, bool) {
	if o == nil || o.Metrics == nil {
		return nil, false
	}
	return o.Metrics, true
}

// HasMetrics returns a boolean if a field has been set.
func (o *IndexingTimeResponse) HasMetrics() bool {
	if o != nil && o.Metrics != nil {
		return true
	}

	return false
}

// SetMetrics gets a reference to the given IndexingMetric and assigns it to the Metrics field.
func (o *IndexingTimeResponse) SetMetrics(v *IndexingMetric) *IndexingTimeResponse {
	o.Metrics = v
	return o
}

func (o IndexingTimeResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Metrics != nil {
		toSerialize["metrics"] = o.Metrics
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal IndexingTimeResponse: %w", err)
	}

	return serialized, nil
}

func (o IndexingTimeResponse) String() string {
	out := ""
	out += fmt.Sprintf("  metrics=%v\n", o.Metrics)
	return fmt.Sprintf("IndexingTimeResponse {\n%s}", out)
}
