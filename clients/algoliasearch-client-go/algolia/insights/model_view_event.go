// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"encoding/json"
	"fmt"
)

// ViewEvent the model 'ViewEvent'.
type ViewEvent string

// List of ViewEvent.
const (
	VIEW_EVENT_VIEW ViewEvent = "view"
)

// All allowed values of ViewEvent enum.
var AllowedViewEventEnumValues = []ViewEvent{
	"view",
}

func (v *ViewEvent) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'ViewEvent': %w", string(src), err)
	}
	enumTypeValue := ViewEvent(value)
	for _, existing := range AllowedViewEventEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid ViewEvent", value)
}

// NewViewEventFromValue returns a pointer to a valid ViewEvent
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewViewEventFromValue(v string) (*ViewEvent, error) {
	ev := ViewEvent(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for ViewEvent: valid values are %v", v, AllowedViewEventEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v ViewEvent) IsValid() bool {
	for _, existing := range AllowedViewEventEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to ViewEvent value.
func (v ViewEvent) Ptr() *ViewEvent {
	return &v
}

type NullableViewEvent struct {
	value *ViewEvent
	isSet bool
}

func (v NullableViewEvent) Get() *ViewEvent {
	return v.value
}

func (v *NullableViewEvent) Set(val *ViewEvent) {
	v.value = val
	v.isSet = true
}

func (v NullableViewEvent) IsSet() bool {
	return v.isSet
}

func (v *NullableViewEvent) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableViewEvent(val *ViewEvent) *NullableViewEvent {
	return &NullableViewEvent{value: val, isSet: true}
}

func (v NullableViewEvent) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableViewEvent) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
