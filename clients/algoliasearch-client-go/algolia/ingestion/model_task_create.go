// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TaskCreate API request body for creating a task.
type TaskCreate struct {
	// Universally uniqud identifier (UUID) of a source.
	SourceID string `json:"sourceID"`
	// Universally unique identifier (UUID) of a destination resource.
	DestinationID string            `json:"destinationID"`
	Trigger       TaskCreateTrigger `json:"trigger"`
	Action        ActionType        `json:"action"`
	// Whether the task is enabled.
	Enabled *bool `json:"enabled,omitempty"`
	// Maximum accepted percentage of failures for a task run to finish successfully.
	FailureThreshold *int32     `json:"failureThreshold,omitempty"`
	Input            *TaskInput `json:"input,omitempty"`
}

type TaskCreateOption func(f *TaskCreate)

func WithTaskCreateEnabled(val bool) TaskCreateOption {
	return func(f *TaskCreate) {
		f.Enabled = &val
	}
}

func WithTaskCreateFailureThreshold(val int32) TaskCreateOption {
	return func(f *TaskCreate) {
		f.FailureThreshold = &val
	}
}

func WithTaskCreateInput(val TaskInput) TaskCreateOption {
	return func(f *TaskCreate) {
		f.Input = &val
	}
}

// NewTaskCreate instantiates a new TaskCreate object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTaskCreate(sourceID string, destinationID string, trigger TaskCreateTrigger, action ActionType, opts ...TaskCreateOption) *TaskCreate {
	this := &TaskCreate{}
	this.SourceID = sourceID
	this.DestinationID = destinationID
	this.Trigger = trigger
	this.Action = action
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyTaskCreate return a pointer to an empty TaskCreate object.
func NewEmptyTaskCreate() *TaskCreate {
	return &TaskCreate{}
}

// GetSourceID returns the SourceID field value.
func (o *TaskCreate) GetSourceID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.SourceID
}

// GetSourceIDOk returns a tuple with the SourceID field value
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetSourceIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.SourceID, true
}

// SetSourceID sets field value.
func (o *TaskCreate) SetSourceID(v string) *TaskCreate {
	o.SourceID = v
	return o
}

// GetDestinationID returns the DestinationID field value.
func (o *TaskCreate) GetDestinationID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.DestinationID
}

// GetDestinationIDOk returns a tuple with the DestinationID field value
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetDestinationIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DestinationID, true
}

// SetDestinationID sets field value.
func (o *TaskCreate) SetDestinationID(v string) *TaskCreate {
	o.DestinationID = v
	return o
}

// GetTrigger returns the Trigger field value.
func (o *TaskCreate) GetTrigger() TaskCreateTrigger {
	if o == nil {
		var ret TaskCreateTrigger
		return ret
	}

	return o.Trigger
}

// GetTriggerOk returns a tuple with the Trigger field value
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetTriggerOk() (*TaskCreateTrigger, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Trigger, true
}

// SetTrigger sets field value.
func (o *TaskCreate) SetTrigger(v *TaskCreateTrigger) *TaskCreate {
	o.Trigger = *v
	return o
}

// GetAction returns the Action field value.
func (o *TaskCreate) GetAction() ActionType {
	if o == nil {
		var ret ActionType
		return ret
	}

	return o.Action
}

// GetActionOk returns a tuple with the Action field value
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetActionOk() (*ActionType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Action, true
}

// SetAction sets field value.
func (o *TaskCreate) SetAction(v ActionType) *TaskCreate {
	o.Action = v
	return o
}

// GetEnabled returns the Enabled field value if set, zero value otherwise.
func (o *TaskCreate) GetEnabled() bool {
	if o == nil || o.Enabled == nil {
		var ret bool
		return ret
	}
	return *o.Enabled
}

// GetEnabledOk returns a tuple with the Enabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetEnabledOk() (*bool, bool) {
	if o == nil || o.Enabled == nil {
		return nil, false
	}
	return o.Enabled, true
}

// HasEnabled returns a boolean if a field has been set.
func (o *TaskCreate) HasEnabled() bool {
	if o != nil && o.Enabled != nil {
		return true
	}

	return false
}

// SetEnabled gets a reference to the given bool and assigns it to the Enabled field.
func (o *TaskCreate) SetEnabled(v bool) *TaskCreate {
	o.Enabled = &v
	return o
}

// GetFailureThreshold returns the FailureThreshold field value if set, zero value otherwise.
func (o *TaskCreate) GetFailureThreshold() int32 {
	if o == nil || o.FailureThreshold == nil {
		var ret int32
		return ret
	}
	return *o.FailureThreshold
}

// GetFailureThresholdOk returns a tuple with the FailureThreshold field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetFailureThresholdOk() (*int32, bool) {
	if o == nil || o.FailureThreshold == nil {
		return nil, false
	}
	return o.FailureThreshold, true
}

// HasFailureThreshold returns a boolean if a field has been set.
func (o *TaskCreate) HasFailureThreshold() bool {
	if o != nil && o.FailureThreshold != nil {
		return true
	}

	return false
}

// SetFailureThreshold gets a reference to the given int32 and assigns it to the FailureThreshold field.
func (o *TaskCreate) SetFailureThreshold(v int32) *TaskCreate {
	o.FailureThreshold = &v
	return o
}

// GetInput returns the Input field value if set, zero value otherwise.
func (o *TaskCreate) GetInput() TaskInput {
	if o == nil || o.Input == nil {
		var ret TaskInput
		return ret
	}
	return *o.Input
}

// GetInputOk returns a tuple with the Input field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskCreate) GetInputOk() (*TaskInput, bool) {
	if o == nil || o.Input == nil {
		return nil, false
	}
	return o.Input, true
}

// HasInput returns a boolean if a field has been set.
func (o *TaskCreate) HasInput() bool {
	if o != nil && o.Input != nil {
		return true
	}

	return false
}

// SetInput gets a reference to the given TaskInput and assigns it to the Input field.
func (o *TaskCreate) SetInput(v *TaskInput) *TaskCreate {
	o.Input = v
	return o
}

func (o TaskCreate) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
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
		toSerialize["action"] = o.Action
	}
	if o.Enabled != nil {
		toSerialize["enabled"] = o.Enabled
	}
	if o.FailureThreshold != nil {
		toSerialize["failureThreshold"] = o.FailureThreshold
	}
	if o.Input != nil {
		toSerialize["input"] = o.Input
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TaskCreate: %w", err)
	}

	return serialized, nil
}

func (o TaskCreate) String() string {
	out := ""
	out += fmt.Sprintf("  sourceID=%v\n", o.SourceID)
	out += fmt.Sprintf("  destinationID=%v\n", o.DestinationID)
	out += fmt.Sprintf("  trigger=%v\n", o.Trigger)
	out += fmt.Sprintf("  action=%v\n", o.Action)
	out += fmt.Sprintf("  enabled=%v\n", o.Enabled)
	out += fmt.Sprintf("  failureThreshold=%v\n", o.FailureThreshold)
	out += fmt.Sprintf("  input=%v\n", o.Input)
	return fmt.Sprintf("TaskCreate {\n%s}", out)
}

type NullableTaskCreate struct {
	value *TaskCreate
	isSet bool
}

func (v NullableTaskCreate) Get() *TaskCreate {
	return v.value
}

func (v *NullableTaskCreate) Set(val *TaskCreate) {
	v.value = val
	v.isSet = true
}

func (v NullableTaskCreate) IsSet() bool {
	return v.isSet
}

func (v *NullableTaskCreate) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTaskCreate(val *TaskCreate) *NullableTaskCreate {
	return &NullableTaskCreate{value: val, isSet: true}
}

func (v NullableTaskCreate) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTaskCreate) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
