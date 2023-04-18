// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// Task struct for Task
type Task struct {
	// The task UUID.
	TaskID string `json:"taskID"`
	// The source UUID.
	SourceID string `json:"sourceID"`
	// The destination UUID.
	DestinationID string  `json:"destinationID"`
	Trigger       Trigger `json:"trigger"`
	// Whether the task is enabled or not.
	Enabled bool       `json:"enabled"`
	Action  ActionType `json:"action"`
	// Date of creation (RFC3339 format).
	CreatedAt string `json:"createdAt"`
	// Date of last update (RFC3339 format).
	UpdatedAt *string `json:"updatedAt,omitempty"`
}

type TaskOption func(f *Task)

func WithTaskUpdatedAt(val string) TaskOption {
	return func(f *Task) {
		f.UpdatedAt = &val
	}
}

// NewTask instantiates a new Task object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewTask(taskID string, sourceID string, destinationID string, trigger Trigger, enabled bool, action ActionType, createdAt string, opts ...TaskOption) *Task {
	this := &Task{}
	this.TaskID = taskID
	this.SourceID = sourceID
	this.DestinationID = destinationID
	this.Trigger = trigger
	this.Enabled = enabled
	this.Action = action
	this.CreatedAt = createdAt
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewTaskWithDefaults instantiates a new Task object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewTaskWithDefaults() *Task {
	this := &Task{}
	var enabled bool = true
	this.Enabled = enabled
	return this
}

// GetTaskID returns the TaskID field value
func (o *Task) GetTaskID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *Task) GetTaskIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value
func (o *Task) SetTaskID(v string) {
	o.TaskID = v
}

// GetSourceID returns the SourceID field value
func (o *Task) GetSourceID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.SourceID
}

// GetSourceIDOk returns a tuple with the SourceID field value
// and a boolean to check if the value has been set.
func (o *Task) GetSourceIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.SourceID, true
}

// SetSourceID sets field value
func (o *Task) SetSourceID(v string) {
	o.SourceID = v
}

// GetDestinationID returns the DestinationID field value
func (o *Task) GetDestinationID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.DestinationID
}

// GetDestinationIDOk returns a tuple with the DestinationID field value
// and a boolean to check if the value has been set.
func (o *Task) GetDestinationIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DestinationID, true
}

// SetDestinationID sets field value
func (o *Task) SetDestinationID(v string) {
	o.DestinationID = v
}

// GetTrigger returns the Trigger field value
func (o *Task) GetTrigger() Trigger {
	if o == nil {
		var ret Trigger
		return ret
	}

	return o.Trigger
}

// GetTriggerOk returns a tuple with the Trigger field value
// and a boolean to check if the value has been set.
func (o *Task) GetTriggerOk() (*Trigger, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Trigger, true
}

// SetTrigger sets field value
func (o *Task) SetTrigger(v Trigger) {
	o.Trigger = v
}

// GetEnabled returns the Enabled field value
func (o *Task) GetEnabled() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.Enabled
}

// GetEnabledOk returns a tuple with the Enabled field value
// and a boolean to check if the value has been set.
func (o *Task) GetEnabledOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Enabled, true
}

// SetEnabled sets field value
func (o *Task) SetEnabled(v bool) {
	o.Enabled = v
}

// GetAction returns the Action field value
func (o *Task) GetAction() ActionType {
	if o == nil {
		var ret ActionType
		return ret
	}

	return o.Action
}

// GetActionOk returns a tuple with the Action field value
// and a boolean to check if the value has been set.
func (o *Task) GetActionOk() (*ActionType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Action, true
}

// SetAction sets field value
func (o *Task) SetAction(v ActionType) {
	o.Action = v
}

// GetCreatedAt returns the CreatedAt field value
func (o *Task) GetCreatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *Task) GetCreatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value
func (o *Task) SetCreatedAt(v string) {
	o.CreatedAt = v
}

// GetUpdatedAt returns the UpdatedAt field value if set, zero value otherwise.
func (o *Task) GetUpdatedAt() string {
	if o == nil || o.UpdatedAt == nil {
		var ret string
		return ret
	}
	return *o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Task) GetUpdatedAtOk() (*string, bool) {
	if o == nil || o.UpdatedAt == nil {
		return nil, false
	}
	return o.UpdatedAt, true
}

// HasUpdatedAt returns a boolean if a field has been set.
func (o *Task) HasUpdatedAt() bool {
	if o != nil && o.UpdatedAt != nil {
		return true
	}

	return false
}

// SetUpdatedAt gets a reference to the given string and assigns it to the UpdatedAt field.
func (o *Task) SetUpdatedAt(v string) {
	o.UpdatedAt = &v
}

func (o Task) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["taskID"] = o.TaskID
	}
	if true {
		toSerialize["sourceID"] = o.SourceID
	}
	if true {
		toSerialize["destinationID"] = o.DestinationID
	}
	if true {
		toSerialize["trigger"] = o.Trigger
	}
	if true {
		toSerialize["enabled"] = o.Enabled
	}
	if true {
		toSerialize["action"] = o.Action
	}
	if true {
		toSerialize["createdAt"] = o.CreatedAt
	}
	if o.UpdatedAt != nil {
		toSerialize["updatedAt"] = o.UpdatedAt
	}
	return json.Marshal(toSerialize)
}

func (o Task) String() string {
	out := ""
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	out += fmt.Sprintf("  sourceID=%v\n", o.SourceID)
	out += fmt.Sprintf("  destinationID=%v\n", o.DestinationID)
	out += fmt.Sprintf("  trigger=%v\n", o.Trigger)
	out += fmt.Sprintf("  enabled=%v\n", o.Enabled)
	out += fmt.Sprintf("  action=%v\n", o.Action)
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	return fmt.Sprintf("Task {\n%s}", out)
}

type NullableTask struct {
	value *Task
	isSet bool
}

func (v NullableTask) Get() *Task {
	return v.value
}

func (v *NullableTask) Set(val *Task) {
	v.value = val
	v.isSet = true
}

func (v NullableTask) IsSet() bool {
	return v.isSet
}

func (v *NullableTask) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTask(val *Task) *NullableTask {
	return &NullableTask{value: val, isSet: true}
}

func (v NullableTask) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableTask) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
