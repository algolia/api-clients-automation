// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// RunProgress struct for RunProgress.
type RunProgress struct {
	ExpectedNbOfEvents int32 `json:"expectedNbOfEvents"`
	ReceivedNbOfEvents int32 `json:"receivedNbOfEvents"`
}

// NewRunProgress instantiates a new RunProgress object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRunProgress(expectedNbOfEvents int32, receivedNbOfEvents int32) *RunProgress {
	this := &RunProgress{}
	this.ExpectedNbOfEvents = expectedNbOfEvents
	this.ReceivedNbOfEvents = receivedNbOfEvents
	return this
}

// NewEmptyRunProgress return a pointer to an empty RunProgress object.
func NewEmptyRunProgress() *RunProgress {
	return &RunProgress{}
}

// GetExpectedNbOfEvents returns the ExpectedNbOfEvents field value.
func (o *RunProgress) GetExpectedNbOfEvents() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ExpectedNbOfEvents
}

// GetExpectedNbOfEventsOk returns a tuple with the ExpectedNbOfEvents field value
// and a boolean to check if the value has been set.
func (o *RunProgress) GetExpectedNbOfEventsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ExpectedNbOfEvents, true
}

// SetExpectedNbOfEvents sets field value.
func (o *RunProgress) SetExpectedNbOfEvents(v int32) *RunProgress {
	o.ExpectedNbOfEvents = v
	return o
}

// GetReceivedNbOfEvents returns the ReceivedNbOfEvents field value.
func (o *RunProgress) GetReceivedNbOfEvents() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ReceivedNbOfEvents
}

// GetReceivedNbOfEventsOk returns a tuple with the ReceivedNbOfEvents field value
// and a boolean to check if the value has been set.
func (o *RunProgress) GetReceivedNbOfEventsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ReceivedNbOfEvents, true
}

// SetReceivedNbOfEvents sets field value.
func (o *RunProgress) SetReceivedNbOfEvents(v int32) *RunProgress {
	o.ReceivedNbOfEvents = v
	return o
}

func (o RunProgress) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["expectedNbOfEvents"] = o.ExpectedNbOfEvents
	toSerialize["receivedNbOfEvents"] = o.ReceivedNbOfEvents
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RunProgress: %w", err)
	}

	return serialized, nil
}

func (o RunProgress) String() string {
	out := ""
	out += fmt.Sprintf("  expectedNbOfEvents=%v\n", o.ExpectedNbOfEvents)
	out += fmt.Sprintf("  receivedNbOfEvents=%v\n", o.ReceivedNbOfEvents)
	return fmt.Sprintf("RunProgress {\n%s}", out)
}
