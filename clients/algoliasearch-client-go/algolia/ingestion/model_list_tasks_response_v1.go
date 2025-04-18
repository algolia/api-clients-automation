// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ListTasksResponseV1 Configured tasks and pagination information.
type ListTasksResponseV1 struct {
	Tasks      []TaskV1   `json:"tasks"`
	Pagination Pagination `json:"pagination"`
}

// NewListTasksResponseV1 instantiates a new ListTasksResponseV1 object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListTasksResponseV1(tasks []TaskV1, pagination Pagination) *ListTasksResponseV1 {
	this := &ListTasksResponseV1{}
	this.Tasks = tasks
	this.Pagination = pagination
	return this
}

// NewEmptyListTasksResponseV1 return a pointer to an empty ListTasksResponseV1 object.
func NewEmptyListTasksResponseV1() *ListTasksResponseV1 {
	return &ListTasksResponseV1{}
}

// GetTasks returns the Tasks field value.
func (o *ListTasksResponseV1) GetTasks() []TaskV1 {
	if o == nil {
		var ret []TaskV1
		return ret
	}

	return o.Tasks
}

// GetTasksOk returns a tuple with the Tasks field value
// and a boolean to check if the value has been set.
func (o *ListTasksResponseV1) GetTasksOk() ([]TaskV1, bool) {
	if o == nil {
		return nil, false
	}
	return o.Tasks, true
}

// SetTasks sets field value.
func (o *ListTasksResponseV1) SetTasks(v []TaskV1) *ListTasksResponseV1 {
	o.Tasks = v
	return o
}

// GetPagination returns the Pagination field value.
func (o *ListTasksResponseV1) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *ListTasksResponseV1) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value.
func (o *ListTasksResponseV1) SetPagination(v *Pagination) *ListTasksResponseV1 {
	o.Pagination = *v
	return o
}

func (o ListTasksResponseV1) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["tasks"] = o.Tasks
	toSerialize["pagination"] = o.Pagination
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListTasksResponseV1: %w", err)
	}

	return serialized, nil
}

func (o ListTasksResponseV1) String() string {
	out := ""
	out += fmt.Sprintf("  tasks=%v\n", o.Tasks)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	return fmt.Sprintf("ListTasksResponseV1 {\n%s}", out)
}
