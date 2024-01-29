// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// IndexingTimeResponseMetrics struct for IndexingTimeResponseMetrics.
type IndexingTimeResponseMetrics struct {
	Indexing *map[string][]TimeInner `json:"indexing,omitempty"`
}

type IndexingTimeResponseMetricsOption func(f *IndexingTimeResponseMetrics)

func WithIndexingTimeResponseMetricsIndexing(val map[string][]TimeInner) IndexingTimeResponseMetricsOption {
	return func(f *IndexingTimeResponseMetrics) {
		f.Indexing = &val
	}
}

// NewIndexingTimeResponseMetrics instantiates a new IndexingTimeResponseMetrics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewIndexingTimeResponseMetrics(opts ...IndexingTimeResponseMetricsOption) *IndexingTimeResponseMetrics {
	this := &IndexingTimeResponseMetrics{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyIndexingTimeResponseMetrics return a pointer to an empty IndexingTimeResponseMetrics object.
func NewEmptyIndexingTimeResponseMetrics() *IndexingTimeResponseMetrics {
	return &IndexingTimeResponseMetrics{}
}

// GetIndexing returns the Indexing field value if set, zero value otherwise.
func (o *IndexingTimeResponseMetrics) GetIndexing() map[string][]TimeInner {
	if o == nil || o.Indexing == nil {
		var ret map[string][]TimeInner
		return ret
	}
	return *o.Indexing
}

// GetIndexingOk returns a tuple with the Indexing field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *IndexingTimeResponseMetrics) GetIndexingOk() (*map[string][]TimeInner, bool) {
	if o == nil || o.Indexing == nil {
		return nil, false
	}
	return o.Indexing, true
}

// HasIndexing returns a boolean if a field has been set.
func (o *IndexingTimeResponseMetrics) HasIndexing() bool {
	if o != nil && o.Indexing != nil {
		return true
	}

	return false
}

// SetIndexing gets a reference to the given map[string][]TimeInner and assigns it to the Indexing field.
func (o *IndexingTimeResponseMetrics) SetIndexing(v map[string][]TimeInner) *IndexingTimeResponseMetrics {
	o.Indexing = &v
	return o
}

func (o IndexingTimeResponseMetrics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Indexing != nil {
		toSerialize["indexing"] = o.Indexing
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal IndexingTimeResponseMetrics: %w", err)
	}

	return serialized, nil
}

func (o IndexingTimeResponseMetrics) String() string {
	out := ""
	out += fmt.Sprintf("  indexing=%v\n", o.Indexing)
	return fmt.Sprintf("IndexingTimeResponseMetrics {\n%s}", out)
}

type NullableIndexingTimeResponseMetrics struct {
	value *IndexingTimeResponseMetrics
	isSet bool
}

func (v NullableIndexingTimeResponseMetrics) Get() *IndexingTimeResponseMetrics {
	return v.value
}

func (v *NullableIndexingTimeResponseMetrics) Set(val *IndexingTimeResponseMetrics) {
	v.value = val
	v.isSet = true
}

func (v NullableIndexingTimeResponseMetrics) IsSet() bool {
	return v.isSet
}

func (v *NullableIndexingTimeResponseMetrics) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableIndexingTimeResponseMetrics(val *IndexingTimeResponseMetrics) *NullableIndexingTimeResponseMetrics {
	return &NullableIndexingTimeResponseMetrics{value: val, isSet: true}
}

func (v NullableIndexingTimeResponseMetrics) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableIndexingTimeResponseMetrics) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
