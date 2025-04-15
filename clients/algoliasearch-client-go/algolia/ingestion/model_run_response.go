// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// RunResponse API response for running a task.
type RunResponse struct {
	// Universally unique identifier (UUID) of a task run.
	RunID string `json:"runID"`
	// Date of creation in RFC 3339 format.
	CreatedAt string `json:"createdAt"`
}

// NewRunResponse instantiates a new RunResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRunResponse(runID string, createdAt string) *RunResponse {
	this := &RunResponse{}
	this.RunID = runID
	this.CreatedAt = createdAt
	return this
}

// NewEmptyRunResponse return a pointer to an empty RunResponse object.
func NewEmptyRunResponse() *RunResponse {
	return &RunResponse{}
}

// GetRunID returns the RunID field value.
func (o *RunResponse) GetRunID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.RunID
}

// GetRunIDOk returns a tuple with the RunID field value
// and a boolean to check if the value has been set.
func (o *RunResponse) GetRunIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.RunID, true
}

// SetRunID sets field value.
func (o *RunResponse) SetRunID(v string) *RunResponse {
	o.RunID = v
	return o
}

// GetCreatedAt returns the CreatedAt field value.
func (o *RunResponse) GetCreatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *RunResponse) GetCreatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value.
func (o *RunResponse) SetCreatedAt(v string) *RunResponse {
	o.CreatedAt = v
	return o
}

func (o RunResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["runID"] = o.RunID
	toSerialize["createdAt"] = o.CreatedAt
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RunResponse: %w", err)
	}

	return serialized, nil
}

func (o RunResponse) String() string {
	out := ""
	out += fmt.Sprintf("  runID=%v\n", o.RunID)
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	return fmt.Sprintf("RunResponse {\n%s}", out)
}
