// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// RunListResponse struct for RunListResponse.
type RunListResponse struct {
	Runs       []Run      `json:"runs"`
	Pagination Pagination `json:"pagination"`
	Window     Window     `json:"window"`
}

// NewRunListResponse instantiates a new RunListResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRunListResponse(runs []Run, pagination Pagination, window Window) *RunListResponse {
	this := &RunListResponse{}
	this.Runs = runs
	this.Pagination = pagination
	this.Window = window
	return this
}

// NewEmptyRunListResponse return a pointer to an empty RunListResponse object.
func NewEmptyRunListResponse() *RunListResponse {
	return &RunListResponse{}
}

// GetRuns returns the Runs field value.
func (o *RunListResponse) GetRuns() []Run {
	if o == nil {
		var ret []Run
		return ret
	}

	return o.Runs
}

// GetRunsOk returns a tuple with the Runs field value
// and a boolean to check if the value has been set.
func (o *RunListResponse) GetRunsOk() ([]Run, bool) {
	if o == nil {
		return nil, false
	}
	return o.Runs, true
}

// SetRuns sets field value.
func (o *RunListResponse) SetRuns(v []Run) *RunListResponse {
	o.Runs = v
	return o
}

// GetPagination returns the Pagination field value.
func (o *RunListResponse) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *RunListResponse) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value.
func (o *RunListResponse) SetPagination(v *Pagination) *RunListResponse {
	o.Pagination = *v
	return o
}

// GetWindow returns the Window field value.
func (o *RunListResponse) GetWindow() Window {
	if o == nil {
		var ret Window
		return ret
	}

	return o.Window
}

// GetWindowOk returns a tuple with the Window field value
// and a boolean to check if the value has been set.
func (o *RunListResponse) GetWindowOk() (*Window, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Window, true
}

// SetWindow sets field value.
func (o *RunListResponse) SetWindow(v *Window) *RunListResponse {
	o.Window = *v
	return o
}

func (o RunListResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["runs"] = o.Runs
	toSerialize["pagination"] = o.Pagination
	toSerialize["window"] = o.Window
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RunListResponse: %w", err)
	}

	return serialized, nil
}

func (o RunListResponse) String() string {
	out := ""
	out += fmt.Sprintf("  runs=%v\n", o.Runs)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	out += fmt.Sprintf("  window=%v\n", o.Window)
	return fmt.Sprintf("RunListResponse {\n%s}", out)
}
