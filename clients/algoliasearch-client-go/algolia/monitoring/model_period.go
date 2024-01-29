// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// Period the model 'Period'.
type Period string

// List of Period.
const (
	PERIOD_MINUTE Period = "minute"
	PERIOD_HOUR   Period = "hour"
	PERIOD_DAY    Period = "day"
	PERIOD_WEEK   Period = "week"
	PERIOD_MONTH  Period = "month"
)

// All allowed values of Period enum.
var AllowedPeriodEnumValues = []Period{
	"minute",
	"hour",
	"day",
	"week",
	"month",
}

func (v *Period) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'Period': %w", string(src), err)
	}
	enumTypeValue := Period(value)
	for _, existing := range AllowedPeriodEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid Period", value)
}

// NewPeriodFromValue returns a pointer to a valid Period
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewPeriodFromValue(v string) (*Period, error) {
	ev := Period(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for Period: valid values are %v", v, AllowedPeriodEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v Period) IsValid() bool {
	for _, existing := range AllowedPeriodEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to Period value.
func (v Period) Ptr() *Period {
	return &v
}

type NullablePeriod struct {
	value *Period
	isSet bool
}

func (v NullablePeriod) Get() *Period {
	return v.value
}

func (v *NullablePeriod) Set(val *Period) {
	v.value = val
	v.isSet = true
}

func (v NullablePeriod) IsSet() bool {
	return v.isSet
}

func (v *NullablePeriod) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullablePeriod(val *Period) *NullablePeriod {
	return &NullablePeriod{value: val, isSet: true}
}

func (v NullablePeriod) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullablePeriod) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
