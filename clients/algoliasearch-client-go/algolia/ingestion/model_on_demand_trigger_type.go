// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// OnDemandTriggerType A task which is manually executed via the run task endpoint.
type OnDemandTriggerType string

// List of OnDemandTriggerType.
const (
	ONDEMANDTRIGGERTYPE_ON_DEMAND OnDemandTriggerType = "onDemand"
)

// All allowed values of OnDemandTriggerType enum.
var AllowedOnDemandTriggerTypeEnumValues = []OnDemandTriggerType{
	"onDemand",
}

func (v *OnDemandTriggerType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'OnDemandTriggerType': %w", string(src), err)
	}
	enumTypeValue := OnDemandTriggerType(value)
	for _, existing := range AllowedOnDemandTriggerTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid OnDemandTriggerType", value)
}

// NewOnDemandTriggerTypeFromValue returns a pointer to a valid OnDemandTriggerType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewOnDemandTriggerTypeFromValue(v string) (*OnDemandTriggerType, error) {
	ev := OnDemandTriggerType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for OnDemandTriggerType: valid values are %v", v, AllowedOnDemandTriggerTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v OnDemandTriggerType) IsValid() bool {
	for _, existing := range AllowedOnDemandTriggerTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to OnDemandTriggerType value.
func (v OnDemandTriggerType) Ptr() *OnDemandTriggerType {
	return &v
}

type NullableOnDemandTriggerType struct {
	value *OnDemandTriggerType
	isSet bool
}

func (v NullableOnDemandTriggerType) Get() *OnDemandTriggerType {
	return v.value
}

func (v *NullableOnDemandTriggerType) Set(val *OnDemandTriggerType) {
	v.value = val
	v.isSet = true
}

func (v NullableOnDemandTriggerType) IsSet() bool {
	return v.isSet
}

func (v *NullableOnDemandTriggerType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableOnDemandTriggerType(val *OnDemandTriggerType) *NullableOnDemandTriggerType {
	return &NullableOnDemandTriggerType{value: val, isSet: true}
}

func (v NullableOnDemandTriggerType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableOnDemandTriggerType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
