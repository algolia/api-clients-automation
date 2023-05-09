// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TaskUpdateResponse The response from the API after a task update.
type TaskUpdateResponse struct {
	// The task UUID.
	TaskID string `json:"taskID" validate:"required"`
	// Date of last update (RFC3339 format).
	UpdatedAt string `json:"updatedAt" validate:"required"`
}

// NewTaskUpdateResponse instantiates a new TaskUpdateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewTaskUpdateResponse(taskID string, updatedAt string) *TaskUpdateResponse {
	this := &TaskUpdateResponse{}
	this.TaskID = taskID
	this.UpdatedAt = updatedAt
	return this
}

// NewTaskUpdateResponseWithDefaults instantiates a new TaskUpdateResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewTaskUpdateResponseWithDefaults() *TaskUpdateResponse {
	this := &TaskUpdateResponse{}
	return this
}

// GetTaskID returns the TaskID field value
func (o *TaskUpdateResponse) GetTaskID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *TaskUpdateResponse) GetTaskIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value
func (o *TaskUpdateResponse) SetTaskID(v string) {
	o.TaskID = v
}

// GetUpdatedAt returns the UpdatedAt field value
func (o *TaskUpdateResponse) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *TaskUpdateResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value
func (o *TaskUpdateResponse) SetUpdatedAt(v string) {
	o.UpdatedAt = v
}

func (o TaskUpdateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["taskID"] = o.TaskID
	}
	if true {
		toSerialize["updatedAt"] = o.UpdatedAt
	}
	return json.Marshal(toSerialize)
}

func (o TaskUpdateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	return fmt.Sprintf("TaskUpdateResponse {\n%s}", out)
}

type NullableTaskUpdateResponse struct {
	value *TaskUpdateResponse
	isSet bool
}

func (v NullableTaskUpdateResponse) Get() *TaskUpdateResponse {
	return v.value
}

func (v *NullableTaskUpdateResponse) Set(val *TaskUpdateResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableTaskUpdateResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableTaskUpdateResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTaskUpdateResponse(val *TaskUpdateResponse) *NullableTaskUpdateResponse {
	return &NullableTaskUpdateResponse{value: val, isSet: true}
}

func (v NullableTaskUpdateResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableTaskUpdateResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
