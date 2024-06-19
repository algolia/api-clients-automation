// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// UpdatedRuleResponse struct for UpdatedRuleResponse.
type UpdatedRuleResponse struct {
	// Unique identifier of a rule object.
	ObjectID string `json:"objectID"`
	// Date and time when the object was updated, in RFC 3339 format.
	UpdatedAt string `json:"updatedAt"`
	// Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
	TaskID int64 `json:"taskID"`
}

// NewUpdatedRuleResponse instantiates a new UpdatedRuleResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewUpdatedRuleResponse(objectID string, updatedAt string, taskID int64) *UpdatedRuleResponse {
	this := &UpdatedRuleResponse{}
	this.ObjectID = objectID
	this.UpdatedAt = updatedAt
	this.TaskID = taskID
	return this
}

// NewEmptyUpdatedRuleResponse return a pointer to an empty UpdatedRuleResponse object.
func NewEmptyUpdatedRuleResponse() *UpdatedRuleResponse {
	return &UpdatedRuleResponse{}
}

// GetObjectID returns the ObjectID field value.
func (o *UpdatedRuleResponse) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *UpdatedRuleResponse) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value.
func (o *UpdatedRuleResponse) SetObjectID(v string) *UpdatedRuleResponse {
	o.ObjectID = v
	return o
}

// GetUpdatedAt returns the UpdatedAt field value.
func (o *UpdatedRuleResponse) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *UpdatedRuleResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value.
func (o *UpdatedRuleResponse) SetUpdatedAt(v string) *UpdatedRuleResponse {
	o.UpdatedAt = v
	return o
}

// GetTaskID returns the TaskID field value.
func (o *UpdatedRuleResponse) GetTaskID() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *UpdatedRuleResponse) GetTaskIDOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value.
func (o *UpdatedRuleResponse) SetTaskID(v int64) *UpdatedRuleResponse {
	o.TaskID = v
	return o
}

func (o UpdatedRuleResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["objectID"] = o.ObjectID
	}
	if true {
		toSerialize["updatedAt"] = o.UpdatedAt
	}
	if true {
		toSerialize["taskID"] = o.TaskID
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal UpdatedRuleResponse: %w", err)
	}

	return serialized, nil
}

func (o UpdatedRuleResponse) String() string {
	out := ""
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	return fmt.Sprintf("UpdatedRuleResponse {\n%s}", out)
}
