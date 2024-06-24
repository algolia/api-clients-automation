// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"encoding/json"
	"fmt"
)

// ClickEvent the model 'ClickEvent'.
type ClickEvent string

// List of ClickEvent.
const (
	CLICK_EVENT_CLICK ClickEvent = "click"
)

// All allowed values of ClickEvent enum.
var AllowedClickEventEnumValues = []ClickEvent{
	"click",
}

func (v *ClickEvent) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'ClickEvent': %w", string(src), err)
	}
	enumTypeValue := ClickEvent(value)
	for _, existing := range AllowedClickEventEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid ClickEvent", value)
}

// NewClickEventFromValue returns a pointer to a valid ClickEvent
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewClickEventFromValue(v string) (*ClickEvent, error) {
	ev := ClickEvent(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for ClickEvent: valid values are %v", v, AllowedClickEventEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v ClickEvent) IsValid() bool {
	for _, existing := range AllowedClickEventEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to ClickEvent value.
func (v ClickEvent) Ptr() *ClickEvent {
	return &v
}
