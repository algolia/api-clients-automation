// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TaskUpdateV1 API request body for updating a task using the V1 shape, please use methods and types that don't contain the V1 suffix.
type TaskUpdateV1 struct {
	// Universally unique identifier (UUID) of a destination resource.
	DestinationID *string             `json:"destinationID,omitempty"`
	Trigger       *TriggerUpdateInput `json:"trigger,omitempty"`
	Input         *TaskInput          `json:"input,omitempty"`
	// Whether the task is enabled.
	Enabled *bool `json:"enabled,omitempty"`
	// Maximum accepted percentage of failures for a task run to finish successfully.
	FailureThreshold *int32 `json:"failureThreshold,omitempty"`
}

type TaskUpdateV1Option func(f *TaskUpdateV1)

func WithTaskUpdateV1DestinationID(val string) TaskUpdateV1Option {
	return func(f *TaskUpdateV1) {
		f.DestinationID = &val
	}
}

func WithTaskUpdateV1Trigger(val TriggerUpdateInput) TaskUpdateV1Option {
	return func(f *TaskUpdateV1) {
		f.Trigger = &val
	}
}

func WithTaskUpdateV1Input(val TaskInput) TaskUpdateV1Option {
	return func(f *TaskUpdateV1) {
		f.Input = &val
	}
}

func WithTaskUpdateV1Enabled(val bool) TaskUpdateV1Option {
	return func(f *TaskUpdateV1) {
		f.Enabled = &val
	}
}

func WithTaskUpdateV1FailureThreshold(val int32) TaskUpdateV1Option {
	return func(f *TaskUpdateV1) {
		f.FailureThreshold = &val
	}
}

// NewTaskUpdateV1 instantiates a new TaskUpdateV1 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTaskUpdateV1(opts ...TaskUpdateV1Option) *TaskUpdateV1 {
	this := &TaskUpdateV1{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyTaskUpdateV1 return a pointer to an empty TaskUpdateV1 object.
func NewEmptyTaskUpdateV1() *TaskUpdateV1 {
	return &TaskUpdateV1{}
}

// GetDestinationID returns the DestinationID field value if set, zero value otherwise.
func (o *TaskUpdateV1) GetDestinationID() string {
	if o == nil || o.DestinationID == nil {
		var ret string
		return ret
	}
	return *o.DestinationID
}

// GetDestinationIDOk returns a tuple with the DestinationID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskUpdateV1) GetDestinationIDOk() (*string, bool) {
	if o == nil || o.DestinationID == nil {
		return nil, false
	}
	return o.DestinationID, true
}

// HasDestinationID returns a boolean if a field has been set.
func (o *TaskUpdateV1) HasDestinationID() bool {
	if o != nil && o.DestinationID != nil {
		return true
	}

	return false
}

// SetDestinationID gets a reference to the given string and assigns it to the DestinationID field.
func (o *TaskUpdateV1) SetDestinationID(v string) *TaskUpdateV1 {
	o.DestinationID = &v
	return o
}

// GetTrigger returns the Trigger field value if set, zero value otherwise.
func (o *TaskUpdateV1) GetTrigger() TriggerUpdateInput {
	if o == nil || o.Trigger == nil {
		var ret TriggerUpdateInput
		return ret
	}
	return *o.Trigger
}

// GetTriggerOk returns a tuple with the Trigger field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskUpdateV1) GetTriggerOk() (*TriggerUpdateInput, bool) {
	if o == nil || o.Trigger == nil {
		return nil, false
	}
	return o.Trigger, true
}

// HasTrigger returns a boolean if a field has been set.
func (o *TaskUpdateV1) HasTrigger() bool {
	if o != nil && o.Trigger != nil {
		return true
	}

	return false
}

// SetTrigger gets a reference to the given TriggerUpdateInput and assigns it to the Trigger field.
func (o *TaskUpdateV1) SetTrigger(v *TriggerUpdateInput) *TaskUpdateV1 {
	o.Trigger = v
	return o
}

// GetInput returns the Input field value if set, zero value otherwise.
func (o *TaskUpdateV1) GetInput() TaskInput {
	if o == nil || o.Input == nil {
		var ret TaskInput
		return ret
	}
	return *o.Input
}

// GetInputOk returns a tuple with the Input field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskUpdateV1) GetInputOk() (*TaskInput, bool) {
	if o == nil || o.Input == nil {
		return nil, false
	}
	return o.Input, true
}

// HasInput returns a boolean if a field has been set.
func (o *TaskUpdateV1) HasInput() bool {
	if o != nil && o.Input != nil {
		return true
	}

	return false
}

// SetInput gets a reference to the given TaskInput and assigns it to the Input field.
func (o *TaskUpdateV1) SetInput(v *TaskInput) *TaskUpdateV1 {
	o.Input = v
	return o
}

// GetEnabled returns the Enabled field value if set, zero value otherwise.
func (o *TaskUpdateV1) GetEnabled() bool {
	if o == nil || o.Enabled == nil {
		var ret bool
		return ret
	}
	return *o.Enabled
}

// GetEnabledOk returns a tuple with the Enabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskUpdateV1) GetEnabledOk() (*bool, bool) {
	if o == nil || o.Enabled == nil {
		return nil, false
	}
	return o.Enabled, true
}

// HasEnabled returns a boolean if a field has been set.
func (o *TaskUpdateV1) HasEnabled() bool {
	if o != nil && o.Enabled != nil {
		return true
	}

	return false
}

// SetEnabled gets a reference to the given bool and assigns it to the Enabled field.
func (o *TaskUpdateV1) SetEnabled(v bool) *TaskUpdateV1 {
	o.Enabled = &v
	return o
}

// GetFailureThreshold returns the FailureThreshold field value if set, zero value otherwise.
func (o *TaskUpdateV1) GetFailureThreshold() int32 {
	if o == nil || o.FailureThreshold == nil {
		var ret int32
		return ret
	}
	return *o.FailureThreshold
}

// GetFailureThresholdOk returns a tuple with the FailureThreshold field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *TaskUpdateV1) GetFailureThresholdOk() (*int32, bool) {
	if o == nil || o.FailureThreshold == nil {
		return nil, false
	}
	return o.FailureThreshold, true
}

// HasFailureThreshold returns a boolean if a field has been set.
func (o *TaskUpdateV1) HasFailureThreshold() bool {
	if o != nil && o.FailureThreshold != nil {
		return true
	}

	return false
}

// SetFailureThreshold gets a reference to the given int32 and assigns it to the FailureThreshold field.
func (o *TaskUpdateV1) SetFailureThreshold(v int32) *TaskUpdateV1 {
	o.FailureThreshold = &v
	return o
}

func (o TaskUpdateV1) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.DestinationID != nil {
		toSerialize["destinationID"] = o.DestinationID
	}
	if o.Trigger != nil {
		toSerialize["trigger"] = o.Trigger
	}
	if o.Input != nil {
		toSerialize["input"] = o.Input
	}
	if o.Enabled != nil {
		toSerialize["enabled"] = o.Enabled
	}
	if o.FailureThreshold != nil {
		toSerialize["failureThreshold"] = o.FailureThreshold
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TaskUpdateV1: %w", err)
	}

	return serialized, nil
}

func (o TaskUpdateV1) String() string {
	out := ""
	out += fmt.Sprintf("  destinationID=%v\n", o.DestinationID)
	out += fmt.Sprintf("  trigger=%v\n", o.Trigger)
	out += fmt.Sprintf("  input=%v\n", o.Input)
	out += fmt.Sprintf("  enabled=%v\n", o.Enabled)
	out += fmt.Sprintf("  failureThreshold=%v\n", o.FailureThreshold)
	return fmt.Sprintf("TaskUpdateV1 {\n%s}", out)
}
