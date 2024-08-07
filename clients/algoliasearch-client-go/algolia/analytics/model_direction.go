// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// Direction the model 'Direction'.
type Direction string

// List of direction.
const (
	DIRECTION_ASC  Direction = "asc"
	DIRECTION_DESC Direction = "desc"
)

// All allowed values of Direction enum.
var AllowedDirectionEnumValues = []Direction{
	"asc",
	"desc",
}

func (v *Direction) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'Direction': %w", string(src), err)
	}
	enumTypeValue := Direction(value)
	for _, existing := range AllowedDirectionEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid Direction", value)
}

// NewDirectionFromValue returns a pointer to a valid Direction
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewDirectionFromValue(v string) (*Direction, error) {
	ev := Direction(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for Direction: valid values are %v", v, AllowedDirectionEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v Direction) IsValid() bool {
	for _, existing := range AllowedDirectionEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to direction value.
func (v Direction) Ptr() *Direction {
	return &v
}
