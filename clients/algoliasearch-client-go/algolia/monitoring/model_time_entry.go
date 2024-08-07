// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// TimeEntry struct for TimeEntry.
type TimeEntry struct {
	// Timestamp, measured in milliseconds since the Unix epoch.
	T *int64 `json:"t,omitempty"`
	// Time in ms.
	V *int32 `json:"v,omitempty"`
}

type TimeEntryOption func(f *TimeEntry)

func WithTimeEntryT(val int64) TimeEntryOption {
	return func(f *TimeEntry) {
		f.T = &val
	}
}

func WithTimeEntryV(val int32) TimeEntryOption {
	return func(f *TimeEntry) {
		f.V = &val
	}
}

// NewTimeEntry instantiates a new TimeEntry object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTimeEntry(opts ...TimeEntryOption) *TimeEntry {
	this := &TimeEntry{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyTimeEntry return a pointer to an empty TimeEntry object.
func NewEmptyTimeEntry() *TimeEntry {
	return &TimeEntry{}
}

// GetT returns the T field value if set, zero value otherwise.
func (o *TimeEntry) GetT() int64 {
	if o == nil || o.T == nil {
		var ret int64
		return ret
	}
	return *o.T
}

// GetTOk returns a tuple with the T field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TimeEntry) GetTOk() (*int64, bool) {
	if o == nil || o.T == nil {
		return nil, false
	}
	return o.T, true
}

// HasT returns a boolean if a field has been set.
func (o *TimeEntry) HasT() bool {
	if o != nil && o.T != nil {
		return true
	}

	return false
}

// SetT gets a reference to the given int64 and assigns it to the T field.
func (o *TimeEntry) SetT(v int64) *TimeEntry {
	o.T = &v
	return o
}

// GetV returns the V field value if set, zero value otherwise.
func (o *TimeEntry) GetV() int32 {
	if o == nil || o.V == nil {
		var ret int32
		return ret
	}
	return *o.V
}

// GetVOk returns a tuple with the V field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TimeEntry) GetVOk() (*int32, bool) {
	if o == nil || o.V == nil {
		return nil, false
	}
	return o.V, true
}

// HasV returns a boolean if a field has been set.
func (o *TimeEntry) HasV() bool {
	if o != nil && o.V != nil {
		return true
	}

	return false
}

// SetV gets a reference to the given int32 and assigns it to the V field.
func (o *TimeEntry) SetV(v int32) *TimeEntry {
	o.V = &v
	return o
}

func (o TimeEntry) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.T != nil {
		toSerialize["t"] = o.T
	}
	if o.V != nil {
		toSerialize["v"] = o.V
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TimeEntry: %w", err)
	}

	return serialized, nil
}

func (o TimeEntry) String() string {
	out := ""
	out += fmt.Sprintf("  t=%v\n", o.T)
	out += fmt.Sprintf("  v=%v\n", o.V)
	return fmt.Sprintf("TimeEntry {\n%s}", out)
}
