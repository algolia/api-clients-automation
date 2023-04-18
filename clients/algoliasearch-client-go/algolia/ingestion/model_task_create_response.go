// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TaskCreateResponse The response from the API after a task creation.
type TaskCreateResponse struct {
	// The task UUID.
	TaskID string `json:"taskID"`
	// Date of creation (RFC3339 format).
	CreatedAt string `json:"createdAt"`
}

// NewTaskCreateResponse instantiates a new TaskCreateResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewTaskCreateResponse(taskID string, createdAt string) *TaskCreateResponse {
	this := &TaskCreateResponse{}
	this.TaskID = taskID
	this.CreatedAt = createdAt
	return this
}

// NewTaskCreateResponseWithDefaults instantiates a new TaskCreateResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewTaskCreateResponseWithDefaults() *TaskCreateResponse {
	this := &TaskCreateResponse{}
	return this
}

// GetTaskID returns the TaskID field value
func (o *TaskCreateResponse) GetTaskID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *TaskCreateResponse) GetTaskIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value
func (o *TaskCreateResponse) SetTaskID(v string) {
	o.TaskID = v
}

// GetCreatedAt returns the CreatedAt field value
func (o *TaskCreateResponse) GetCreatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *TaskCreateResponse) GetCreatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value
func (o *TaskCreateResponse) SetCreatedAt(v string) {
	o.CreatedAt = v
}

func (o TaskCreateResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["taskID"] = o.TaskID
	}
	if true {
		toSerialize["createdAt"] = o.CreatedAt
	}
	return json.Marshal(toSerialize)
}

func (o TaskCreateResponse) String() string {
	out := ""
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	return fmt.Sprintf("TaskCreateResponse {\n%s}", out)
}

type NullableTaskCreateResponse struct {
	value *TaskCreateResponse
	isSet bool
}

func (v NullableTaskCreateResponse) Get() *TaskCreateResponse {
	return v.value
}

func (v *NullableTaskCreateResponse) Set(val *TaskCreateResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableTaskCreateResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableTaskCreateResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTaskCreateResponse(val *TaskCreateResponse) *NullableTaskCreateResponse {
	return &NullableTaskCreateResponse{value: val, isSet: true}
}

func (v NullableTaskCreateResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableTaskCreateResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
