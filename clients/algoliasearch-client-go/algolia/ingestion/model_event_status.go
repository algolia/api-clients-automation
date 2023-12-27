// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// EventStatus the model 'EventStatus'.
type EventStatus string

// List of EventStatus.
const (
	EVENTSTATUS_CREATED   EventStatus = "created"
	EVENTSTATUS_STARTED   EventStatus = "started"
	EVENTSTATUS_RETRIED   EventStatus = "retried"
	EVENTSTATUS_FAILED    EventStatus = "failed"
	EVENTSTATUS_SUCCEEDED EventStatus = "succeeded"
	EVENTSTATUS_CRITICAL  EventStatus = "critical"
)

// All allowed values of EventStatus enum.
var AllowedEventStatusEnumValues = []EventStatus{
	"created",
	"started",
	"retried",
	"failed",
	"succeeded",
	"critical",
}

func (v *EventStatus) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := EventStatus(value)
	for _, existing := range AllowedEventStatusEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid EventStatus", value)
}

// NewEventStatusFromValue returns a pointer to a valid EventStatus
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewEventStatusFromValue(v string) (*EventStatus, error) {
	ev := EventStatus(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for EventStatus: valid values are %v", v, AllowedEventStatusEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v EventStatus) IsValid() bool {
	for _, existing := range AllowedEventStatusEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to EventStatus value.
func (v EventStatus) Ptr() *EventStatus {
	return &v
}

type NullableEventStatus struct {
	value *EventStatus
	isSet bool
}

func (v NullableEventStatus) Get() *EventStatus {
	return v.value
}

func (v *NullableEventStatus) Set(val *EventStatus) {
	v.value = val
	v.isSet = true
}

func (v NullableEventStatus) IsSet() bool {
	return v.isSet
}

func (v *NullableEventStatus) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEventStatus(val *EventStatus) *NullableEventStatus {
	return &NullableEventStatus{value: val, isSet: true}
}

func (v NullableEventStatus) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEventStatus) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
