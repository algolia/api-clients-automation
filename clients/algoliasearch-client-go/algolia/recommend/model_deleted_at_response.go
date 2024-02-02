// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// DeletedAtResponse Response, taskID, and deletion timestamp.
type DeletedAtResponse struct {
	// Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`.
	TaskID int64 `json:"taskID"`
	// Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
	DeletedAt string `json:"deletedAt"`
}

// NewDeletedAtResponse instantiates a new DeletedAtResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDeletedAtResponse(taskID int64, deletedAt string) *DeletedAtResponse {
	this := &DeletedAtResponse{}
	this.TaskID = taskID
	this.DeletedAt = deletedAt
	return this
}

// NewEmptyDeletedAtResponse return a pointer to an empty DeletedAtResponse object.
func NewEmptyDeletedAtResponse() *DeletedAtResponse {
	return &DeletedAtResponse{}
}

// GetTaskID returns the TaskID field value.
func (o *DeletedAtResponse) GetTaskID() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *DeletedAtResponse) GetTaskIDOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value.
func (o *DeletedAtResponse) SetTaskID(v int64) *DeletedAtResponse {
	o.TaskID = v
	return o
}

// GetDeletedAt returns the DeletedAt field value.
func (o *DeletedAtResponse) GetDeletedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.DeletedAt
}

// GetDeletedAtOk returns a tuple with the DeletedAt field value
// and a boolean to check if the value has been set.
func (o *DeletedAtResponse) GetDeletedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DeletedAt, true
}

// SetDeletedAt sets field value.
func (o *DeletedAtResponse) SetDeletedAt(v string) *DeletedAtResponse {
	o.DeletedAt = v
	return o
}

func (o DeletedAtResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["taskID"] = o.TaskID
	}
	if true {
		toSerialize["deletedAt"] = o.DeletedAt
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DeletedAtResponse: %w", err)
	}

	return serialized, nil
}

func (o DeletedAtResponse) String() string {
	out := ""
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	out += fmt.Sprintf("  deletedAt=%v\n", o.DeletedAt)
	return fmt.Sprintf("DeletedAtResponse {\n%s}", out)
}

type NullableDeletedAtResponse struct {
	value *DeletedAtResponse
	isSet bool
}

func (v NullableDeletedAtResponse) Get() *DeletedAtResponse {
	return v.value
}

func (v *NullableDeletedAtResponse) Set(val *DeletedAtResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableDeletedAtResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableDeletedAtResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDeletedAtResponse(val *DeletedAtResponse) *NullableDeletedAtResponse {
	return &NullableDeletedAtResponse{value: val, isSet: true}
}

func (v NullableDeletedAtResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableDeletedAtResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
