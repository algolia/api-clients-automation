// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package usage

import (
	"encoding/json"
	"fmt"
)

// IndexUsage struct for IndexUsage.
type IndexUsage struct {
	Statistics []StatisticEntry `json:"statistics,omitempty"`
}

type IndexUsageOption func(f *IndexUsage)

func WithIndexUsageStatistics(val []StatisticEntry) IndexUsageOption {
	return func(f *IndexUsage) {
		f.Statistics = val
	}
}

// NewIndexUsage instantiates a new IndexUsage object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewIndexUsage(opts ...IndexUsageOption) *IndexUsage {
	this := &IndexUsage{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyIndexUsage return a pointer to an empty IndexUsage object.
func NewEmptyIndexUsage() *IndexUsage {
	return &IndexUsage{}
}

// GetStatistics returns the Statistics field value if set, zero value otherwise.
func (o *IndexUsage) GetStatistics() []StatisticEntry {
	if o == nil || o.Statistics == nil {
		var ret []StatisticEntry
		return ret
	}
	return o.Statistics
}

// GetStatisticsOk returns a tuple with the Statistics field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *IndexUsage) GetStatisticsOk() ([]StatisticEntry, bool) {
	if o == nil || o.Statistics == nil {
		return nil, false
	}
	return o.Statistics, true
}

// HasStatistics returns a boolean if a field has been set.
func (o *IndexUsage) HasStatistics() bool {
	if o != nil && o.Statistics != nil {
		return true
	}

	return false
}

// SetStatistics gets a reference to the given []StatisticEntry and assigns it to the Statistics field.
func (o *IndexUsage) SetStatistics(v []StatisticEntry) *IndexUsage {
	o.Statistics = v
	return o
}

func (o IndexUsage) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Statistics != nil {
		toSerialize["statistics"] = o.Statistics
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal IndexUsage: %w", err)
	}

	return serialized, nil
}

func (o IndexUsage) String() string {
	out := ""
	out += fmt.Sprintf("  statistics=%v\n", o.Statistics)
	return fmt.Sprintf("IndexUsage {\n%s}", out)
}
