// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// AroundRadiusAll Return all records with a valid `_geoloc` attribute. Don't filter by distance.
type AroundRadiusAll string

// List of aroundRadiusAll.
const (
	AROUND_RADIUS_ALL_ALL AroundRadiusAll = "all"
)

// All allowed values of AroundRadiusAll enum.
var AllowedAroundRadiusAllEnumValues = []AroundRadiusAll{
	"all",
}

func (v *AroundRadiusAll) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'AroundRadiusAll': %w", string(src), err)
	}
	enumTypeValue := AroundRadiusAll(value)
	for _, existing := range AllowedAroundRadiusAllEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid AroundRadiusAll", value)
}

// NewAroundRadiusAllFromValue returns a pointer to a valid AroundRadiusAll
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewAroundRadiusAllFromValue(v string) (*AroundRadiusAll, error) {
	ev := AroundRadiusAll(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for AroundRadiusAll: valid values are %v", v, AllowedAroundRadiusAllEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v AroundRadiusAll) IsValid() bool {
	for _, existing := range AllowedAroundRadiusAllEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to aroundRadiusAll value.
func (v AroundRadiusAll) Ptr() *AroundRadiusAll {
	return &v
}
