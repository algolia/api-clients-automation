// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ScheduleTrigger Trigger information for scheduled tasks.
type ScheduleTrigger struct {
	Type ScheduleTriggerType `json:"type"`
	// Cron expression for the task's schedule.
	Cron string `json:"cron"`
	// The last time the scheduled task ran in RFC 3339 format.
	LastRun *string `json:"lastRun,omitempty"`
	// The next scheduled run of the task in RFC 3339 format.
	NextRun string `json:"nextRun"`
}

type ScheduleTriggerOption func(f *ScheduleTrigger)

func WithScheduleTriggerLastRun(val string) ScheduleTriggerOption {
	return func(f *ScheduleTrigger) {
		f.LastRun = &val
	}
}

// NewScheduleTrigger instantiates a new ScheduleTrigger object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewScheduleTrigger(type_ ScheduleTriggerType, cron string, nextRun string, opts ...ScheduleTriggerOption) *ScheduleTrigger {
	this := &ScheduleTrigger{}
	this.Type = type_
	this.Cron = cron
	this.NextRun = nextRun
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyScheduleTrigger return a pointer to an empty ScheduleTrigger object.
func NewEmptyScheduleTrigger() *ScheduleTrigger {
	return &ScheduleTrigger{}
}

// GetType returns the Type field value.
func (o *ScheduleTrigger) GetType() ScheduleTriggerType {
	if o == nil {
		var ret ScheduleTriggerType
		return ret
	}

	return o.Type
}

// GetTypeOk returns a tuple with the Type field value
// and a boolean to check if the value has been set.
func (o *ScheduleTrigger) GetTypeOk() (*ScheduleTriggerType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Type, true
}

// SetType sets field value.
func (o *ScheduleTrigger) SetType(v ScheduleTriggerType) *ScheduleTrigger {
	o.Type = v
	return o
}

// GetCron returns the Cron field value.
func (o *ScheduleTrigger) GetCron() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Cron
}

// GetCronOk returns a tuple with the Cron field value
// and a boolean to check if the value has been set.
func (o *ScheduleTrigger) GetCronOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Cron, true
}

// SetCron sets field value.
func (o *ScheduleTrigger) SetCron(v string) *ScheduleTrigger {
	o.Cron = v
	return o
}

// GetLastRun returns the LastRun field value if set, zero value otherwise.
func (o *ScheduleTrigger) GetLastRun() string {
	if o == nil || o.LastRun == nil {
		var ret string
		return ret
	}
	return *o.LastRun
}

// GetLastRunOk returns a tuple with the LastRun field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ScheduleTrigger) GetLastRunOk() (*string, bool) {
	if o == nil || o.LastRun == nil {
		return nil, false
	}
	return o.LastRun, true
}

// HasLastRun returns a boolean if a field has been set.
func (o *ScheduleTrigger) HasLastRun() bool {
	if o != nil && o.LastRun != nil {
		return true
	}

	return false
}

// SetLastRun gets a reference to the given string and assigns it to the LastRun field.
func (o *ScheduleTrigger) SetLastRun(v string) *ScheduleTrigger {
	o.LastRun = &v
	return o
}

// GetNextRun returns the NextRun field value.
func (o *ScheduleTrigger) GetNextRun() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.NextRun
}

// GetNextRunOk returns a tuple with the NextRun field value
// and a boolean to check if the value has been set.
func (o *ScheduleTrigger) GetNextRunOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NextRun, true
}

// SetNextRun sets field value.
func (o *ScheduleTrigger) SetNextRun(v string) *ScheduleTrigger {
	o.NextRun = v
	return o
}

func (o ScheduleTrigger) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["type"] = o.Type
	toSerialize["cron"] = o.Cron
	if o.LastRun != nil {
		toSerialize["lastRun"] = o.LastRun
	}
	toSerialize["nextRun"] = o.NextRun
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ScheduleTrigger: %w", err)
	}

	return serialized, nil
}

func (o ScheduleTrigger) String() string {
	out := ""
	out += fmt.Sprintf("  type=%v\n", o.Type)
	out += fmt.Sprintf("  cron=%v\n", o.Cron)
	out += fmt.Sprintf("  lastRun=%v\n", o.LastRun)
	out += fmt.Sprintf("  nextRun=%v\n", o.NextRun)
	return fmt.Sprintf("ScheduleTrigger {\n%s}", out)
}
