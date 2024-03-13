// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// TriggerType The type of the task reflect how it can be used:   - onDemand: a task that runs manually   - schedule: a task that runs regularly, following a given cron expression   - subscription: a task that runs after a subscription event is received from an integration (e.g. Webhook).   - streaming: a task that runs continuously.
type TriggerType string

// List of TriggerType.
const (
	TRIGGERTYPE_ON_DEMAND    TriggerType = "onDemand"
	TRIGGERTYPE_SCHEDULE     TriggerType = "schedule"
	TRIGGERTYPE_SUBSCRIPTION TriggerType = "subscription"
	TRIGGERTYPE_STREAMING    TriggerType = "streaming"
)

// All allowed values of TriggerType enum.
var AllowedTriggerTypeEnumValues = []TriggerType{
	"onDemand",
	"schedule",
	"subscription",
	"streaming",
}

func (v *TriggerType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'TriggerType': %w", string(src), err)
	}
	enumTypeValue := TriggerType(value)
	for _, existing := range AllowedTriggerTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid TriggerType", value)
}

// NewTriggerTypeFromValue returns a pointer to a valid TriggerType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewTriggerTypeFromValue(v string) (*TriggerType, error) {
	ev := TriggerType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for TriggerType: valid values are %v", v, AllowedTriggerTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v TriggerType) IsValid() bool {
	for _, existing := range AllowedTriggerTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to TriggerType value.
func (v TriggerType) Ptr() *TriggerType {
	return &v
}

type NullableTriggerType struct {
	value *TriggerType
	isSet bool
}

func (v NullableTriggerType) Get() *TriggerType {
	return v.value
}

func (v *NullableTriggerType) Set(val *TriggerType) {
	v.value = val
	v.isSet = true
}

func (v NullableTriggerType) IsSet() bool {
	return v.isSet
}

func (v *NullableTriggerType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTriggerType(val *TriggerType) *NullableTriggerType {
	return &NullableTriggerType{value: val, isSet: true}
}

func (v NullableTriggerType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTriggerType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
