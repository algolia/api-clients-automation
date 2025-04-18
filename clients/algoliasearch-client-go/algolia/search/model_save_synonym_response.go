// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// SaveSynonymResponse struct for SaveSynonymResponse.
type SaveSynonymResponse struct {
	// Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
	TaskID int64 `json:"taskID"`
	// Date and time when the object was updated, in RFC 3339 format.
	UpdatedAt string `json:"updatedAt"`
	// Unique identifier of a synonym object.
	Id string `json:"id"`
}

// NewSaveSynonymResponse instantiates a new SaveSynonymResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSaveSynonymResponse(taskID int64, updatedAt string, id string) *SaveSynonymResponse {
	this := &SaveSynonymResponse{}
	this.TaskID = taskID
	this.UpdatedAt = updatedAt
	this.Id = id
	return this
}

// NewEmptySaveSynonymResponse return a pointer to an empty SaveSynonymResponse object.
func NewEmptySaveSynonymResponse() *SaveSynonymResponse {
	return &SaveSynonymResponse{}
}

// GetTaskID returns the TaskID field value.
func (o *SaveSynonymResponse) GetTaskID() int64 {
	if o == nil {
		var ret int64
		return ret
	}

	return o.TaskID
}

// GetTaskIDOk returns a tuple with the TaskID field value
// and a boolean to check if the value has been set.
func (o *SaveSynonymResponse) GetTaskIDOk() (*int64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TaskID, true
}

// SetTaskID sets field value.
func (o *SaveSynonymResponse) SetTaskID(v int64) *SaveSynonymResponse {
	o.TaskID = v
	return o
}

// GetUpdatedAt returns the UpdatedAt field value.
func (o *SaveSynonymResponse) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *SaveSynonymResponse) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value.
func (o *SaveSynonymResponse) SetUpdatedAt(v string) *SaveSynonymResponse {
	o.UpdatedAt = v
	return o
}

// GetId returns the Id field value.
func (o *SaveSynonymResponse) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *SaveSynonymResponse) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value.
func (o *SaveSynonymResponse) SetId(v string) *SaveSynonymResponse {
	o.Id = v
	return o
}

func (o SaveSynonymResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["taskID"] = o.TaskID
	toSerialize["updatedAt"] = o.UpdatedAt
	toSerialize["id"] = o.Id
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SaveSynonymResponse: %w", err)
	}

	return serialized, nil
}

func (o SaveSynonymResponse) String() string {
	out := ""
	out += fmt.Sprintf("  taskID=%v\n", o.TaskID)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	out += fmt.Sprintf("  id=%v\n", o.Id)
	return fmt.Sprintf("SaveSynonymResponse {\n%s}", out)
}
