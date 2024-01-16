// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// InfrastructureResponseMetrics struct for InfrastructureResponseMetrics.
type InfrastructureResponseMetrics struct {
	// CPU idleness in %.
	CpuUsage *map[string][]ProbesMetric `json:"cpu_usage,omitempty"`
	// RAM used for indexing in MB.
	RamIndexingUsage *map[string][]ProbesMetric `json:"ram_indexing_usage,omitempty"`
	// RAM used for search in MB.
	RamSearchUsage *map[string][]ProbesMetric `json:"ram_search_usage,omitempty"`
	// Solid-state disk (SSD) usage expressed as % of RAM.  0% means no SSD usage. A value of 50% indicates 32&nbsp;GB SSD usage for a machine with 64&nbsp;RAM.
	SsdUsage *map[string][]ProbesMetric `json:"ssd_usage,omitempty"`
	// Average build time of the indices in seconds.
	AvgBuildTime *map[string][]ProbesMetric `json:"avg_build_time,omitempty"`
}

type InfrastructureResponseMetricsOption func(f *InfrastructureResponseMetrics)

func WithInfrastructureResponseMetricsCpuUsage(val map[string][]ProbesMetric) InfrastructureResponseMetricsOption {
	return func(f *InfrastructureResponseMetrics) {
		f.CpuUsage = &val
	}
}

func WithInfrastructureResponseMetricsRamIndexingUsage(val map[string][]ProbesMetric) InfrastructureResponseMetricsOption {
	return func(f *InfrastructureResponseMetrics) {
		f.RamIndexingUsage = &val
	}
}

func WithInfrastructureResponseMetricsRamSearchUsage(val map[string][]ProbesMetric) InfrastructureResponseMetricsOption {
	return func(f *InfrastructureResponseMetrics) {
		f.RamSearchUsage = &val
	}
}

func WithInfrastructureResponseMetricsSsdUsage(val map[string][]ProbesMetric) InfrastructureResponseMetricsOption {
	return func(f *InfrastructureResponseMetrics) {
		f.SsdUsage = &val
	}
}

func WithInfrastructureResponseMetricsAvgBuildTime(val map[string][]ProbesMetric) InfrastructureResponseMetricsOption {
	return func(f *InfrastructureResponseMetrics) {
		f.AvgBuildTime = &val
	}
}

// NewInfrastructureResponseMetrics instantiates a new InfrastructureResponseMetrics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewInfrastructureResponseMetrics(opts ...InfrastructureResponseMetricsOption) *InfrastructureResponseMetrics {
	this := &InfrastructureResponseMetrics{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyInfrastructureResponseMetrics return a pointer to an empty InfrastructureResponseMetrics object.
func NewEmptyInfrastructureResponseMetrics() *InfrastructureResponseMetrics {
	return &InfrastructureResponseMetrics{}
}

// GetCpuUsage returns the CpuUsage field value if set, zero value otherwise.
func (o *InfrastructureResponseMetrics) GetCpuUsage() map[string][]ProbesMetric {
	if o == nil || o.CpuUsage == nil {
		var ret map[string][]ProbesMetric
		return ret
	}
	return *o.CpuUsage
}

// GetCpuUsageOk returns a tuple with the CpuUsage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *InfrastructureResponseMetrics) GetCpuUsageOk() (*map[string][]ProbesMetric, bool) {
	if o == nil || o.CpuUsage == nil {
		return nil, false
	}
	return o.CpuUsage, true
}

// HasCpuUsage returns a boolean if a field has been set.
func (o *InfrastructureResponseMetrics) HasCpuUsage() bool {
	if o != nil && o.CpuUsage != nil {
		return true
	}

	return false
}

// SetCpuUsage gets a reference to the given map[string][]ProbesMetric and assigns it to the CpuUsage field.
func (o *InfrastructureResponseMetrics) SetCpuUsage(v map[string][]ProbesMetric) *InfrastructureResponseMetrics {
	o.CpuUsage = &v
	return o
}

// GetRamIndexingUsage returns the RamIndexingUsage field value if set, zero value otherwise.
func (o *InfrastructureResponseMetrics) GetRamIndexingUsage() map[string][]ProbesMetric {
	if o == nil || o.RamIndexingUsage == nil {
		var ret map[string][]ProbesMetric
		return ret
	}
	return *o.RamIndexingUsage
}

// GetRamIndexingUsageOk returns a tuple with the RamIndexingUsage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *InfrastructureResponseMetrics) GetRamIndexingUsageOk() (*map[string][]ProbesMetric, bool) {
	if o == nil || o.RamIndexingUsage == nil {
		return nil, false
	}
	return o.RamIndexingUsage, true
}

// HasRamIndexingUsage returns a boolean if a field has been set.
func (o *InfrastructureResponseMetrics) HasRamIndexingUsage() bool {
	if o != nil && o.RamIndexingUsage != nil {
		return true
	}

	return false
}

// SetRamIndexingUsage gets a reference to the given map[string][]ProbesMetric and assigns it to the RamIndexingUsage field.
func (o *InfrastructureResponseMetrics) SetRamIndexingUsage(v map[string][]ProbesMetric) *InfrastructureResponseMetrics {
	o.RamIndexingUsage = &v
	return o
}

// GetRamSearchUsage returns the RamSearchUsage field value if set, zero value otherwise.
func (o *InfrastructureResponseMetrics) GetRamSearchUsage() map[string][]ProbesMetric {
	if o == nil || o.RamSearchUsage == nil {
		var ret map[string][]ProbesMetric
		return ret
	}
	return *o.RamSearchUsage
}

// GetRamSearchUsageOk returns a tuple with the RamSearchUsage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *InfrastructureResponseMetrics) GetRamSearchUsageOk() (*map[string][]ProbesMetric, bool) {
	if o == nil || o.RamSearchUsage == nil {
		return nil, false
	}
	return o.RamSearchUsage, true
}

// HasRamSearchUsage returns a boolean if a field has been set.
func (o *InfrastructureResponseMetrics) HasRamSearchUsage() bool {
	if o != nil && o.RamSearchUsage != nil {
		return true
	}

	return false
}

// SetRamSearchUsage gets a reference to the given map[string][]ProbesMetric and assigns it to the RamSearchUsage field.
func (o *InfrastructureResponseMetrics) SetRamSearchUsage(v map[string][]ProbesMetric) *InfrastructureResponseMetrics {
	o.RamSearchUsage = &v
	return o
}

// GetSsdUsage returns the SsdUsage field value if set, zero value otherwise.
func (o *InfrastructureResponseMetrics) GetSsdUsage() map[string][]ProbesMetric {
	if o == nil || o.SsdUsage == nil {
		var ret map[string][]ProbesMetric
		return ret
	}
	return *o.SsdUsage
}

// GetSsdUsageOk returns a tuple with the SsdUsage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *InfrastructureResponseMetrics) GetSsdUsageOk() (*map[string][]ProbesMetric, bool) {
	if o == nil || o.SsdUsage == nil {
		return nil, false
	}
	return o.SsdUsage, true
}

// HasSsdUsage returns a boolean if a field has been set.
func (o *InfrastructureResponseMetrics) HasSsdUsage() bool {
	if o != nil && o.SsdUsage != nil {
		return true
	}

	return false
}

// SetSsdUsage gets a reference to the given map[string][]ProbesMetric and assigns it to the SsdUsage field.
func (o *InfrastructureResponseMetrics) SetSsdUsage(v map[string][]ProbesMetric) *InfrastructureResponseMetrics {
	o.SsdUsage = &v
	return o
}

// GetAvgBuildTime returns the AvgBuildTime field value if set, zero value otherwise.
func (o *InfrastructureResponseMetrics) GetAvgBuildTime() map[string][]ProbesMetric {
	if o == nil || o.AvgBuildTime == nil {
		var ret map[string][]ProbesMetric
		return ret
	}
	return *o.AvgBuildTime
}

// GetAvgBuildTimeOk returns a tuple with the AvgBuildTime field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *InfrastructureResponseMetrics) GetAvgBuildTimeOk() (*map[string][]ProbesMetric, bool) {
	if o == nil || o.AvgBuildTime == nil {
		return nil, false
	}
	return o.AvgBuildTime, true
}

// HasAvgBuildTime returns a boolean if a field has been set.
func (o *InfrastructureResponseMetrics) HasAvgBuildTime() bool {
	if o != nil && o.AvgBuildTime != nil {
		return true
	}

	return false
}

// SetAvgBuildTime gets a reference to the given map[string][]ProbesMetric and assigns it to the AvgBuildTime field.
func (o *InfrastructureResponseMetrics) SetAvgBuildTime(v map[string][]ProbesMetric) *InfrastructureResponseMetrics {
	o.AvgBuildTime = &v
	return o
}

func (o InfrastructureResponseMetrics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.CpuUsage != nil {
		toSerialize["cpu_usage"] = o.CpuUsage
	}
	if o.RamIndexingUsage != nil {
		toSerialize["ram_indexing_usage"] = o.RamIndexingUsage
	}
	if o.RamSearchUsage != nil {
		toSerialize["ram_search_usage"] = o.RamSearchUsage
	}
	if o.SsdUsage != nil {
		toSerialize["ssd_usage"] = o.SsdUsage
	}
	if o.AvgBuildTime != nil {
		toSerialize["avg_build_time"] = o.AvgBuildTime
	}
	return json.Marshal(toSerialize)
}

func (o InfrastructureResponseMetrics) String() string {
	out := ""
	out += fmt.Sprintf("  cpu_usage=%v\n", o.CpuUsage)
	out += fmt.Sprintf("  ram_indexing_usage=%v\n", o.RamIndexingUsage)
	out += fmt.Sprintf("  ram_search_usage=%v\n", o.RamSearchUsage)
	out += fmt.Sprintf("  ssd_usage=%v\n", o.SsdUsage)
	out += fmt.Sprintf("  avg_build_time=%v\n", o.AvgBuildTime)
	return fmt.Sprintf("InfrastructureResponseMetrics {\n%s}", out)
}

type NullableInfrastructureResponseMetrics struct {
	value *InfrastructureResponseMetrics
	isSet bool
}

func (v NullableInfrastructureResponseMetrics) Get() *InfrastructureResponseMetrics {
	return v.value
}

func (v *NullableInfrastructureResponseMetrics) Set(val *InfrastructureResponseMetrics) {
	v.value = val
	v.isSet = true
}

func (v NullableInfrastructureResponseMetrics) IsSet() bool {
	return v.isSet
}

func (v *NullableInfrastructureResponseMetrics) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableInfrastructureResponseMetrics(val *InfrastructureResponseMetrics) *NullableInfrastructureResponseMetrics {
	return &NullableInfrastructureResponseMetrics{value: val, isSet: true}
}

func (v NullableInfrastructureResponseMetrics) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableInfrastructureResponseMetrics) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
