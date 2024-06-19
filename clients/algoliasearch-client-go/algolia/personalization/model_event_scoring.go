// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package personalization

import (
	"encoding/json"
	"fmt"
)

// EventScoring struct for EventScoring.
type EventScoring struct {
	// Event score.
	Score int32 `json:"score"`
	// Event name.
	EventName string    `json:"eventName"`
	EventType EventType `json:"eventType"`
}

// NewEventScoring instantiates a new EventScoring object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewEventScoring(score int32, eventName string, eventType EventType) *EventScoring {
	this := &EventScoring{}
	this.Score = score
	this.EventName = eventName
	this.EventType = eventType
	return this
}

// NewEmptyEventScoring return a pointer to an empty EventScoring object.
func NewEmptyEventScoring() *EventScoring {
	return &EventScoring{}
}

// GetScore returns the Score field value.
func (o *EventScoring) GetScore() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Score
}

// GetScoreOk returns a tuple with the Score field value
// and a boolean to check if the value has been set.
func (o *EventScoring) GetScoreOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Score, true
}

// SetScore sets field value.
func (o *EventScoring) SetScore(v int32) *EventScoring {
	o.Score = v
	return o
}

// GetEventName returns the EventName field value.
func (o *EventScoring) GetEventName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.EventName
}

// GetEventNameOk returns a tuple with the EventName field value
// and a boolean to check if the value has been set.
func (o *EventScoring) GetEventNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventName, true
}

// SetEventName sets field value.
func (o *EventScoring) SetEventName(v string) *EventScoring {
	o.EventName = v
	return o
}

// GetEventType returns the EventType field value.
func (o *EventScoring) GetEventType() EventType {
	if o == nil {
		var ret EventType
		return ret
	}

	return o.EventType
}

// GetEventTypeOk returns a tuple with the EventType field value
// and a boolean to check if the value has been set.
func (o *EventScoring) GetEventTypeOk() (*EventType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventType, true
}

// SetEventType sets field value.
func (o *EventScoring) SetEventType(v EventType) *EventScoring {
	o.EventType = v
	return o
}

func (o EventScoring) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["score"] = o.Score
	}
	if true {
		toSerialize["eventName"] = o.EventName
	}
	if true {
		toSerialize["eventType"] = o.EventType
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal EventScoring: %w", err)
	}

	return serialized, nil
}

func (o EventScoring) String() string {
	out := ""
	out += fmt.Sprintf("  score=%v\n", o.Score)
	out += fmt.Sprintf("  eventName=%v\n", o.EventName)
	out += fmt.Sprintf("  eventType=%v\n", o.EventType)
	return fmt.Sprintf("EventScoring {\n%s}", out)
}
