// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// Trigger - struct for Trigger.
type Trigger struct {
	OnDemandTrigger     *OnDemandTrigger
	ScheduleTrigger     *ScheduleTrigger
	SubscriptionTrigger *SubscriptionTrigger
}

// OnDemandTriggerAsTrigger is a convenience function that returns OnDemandTrigger wrapped in Trigger.
func OnDemandTriggerAsTrigger(v *OnDemandTrigger) *Trigger {
	return &Trigger{
		OnDemandTrigger: v,
	}
}

// ScheduleTriggerAsTrigger is a convenience function that returns ScheduleTrigger wrapped in Trigger.
func ScheduleTriggerAsTrigger(v *ScheduleTrigger) *Trigger {
	return &Trigger{
		ScheduleTrigger: v,
	}
}

// SubscriptionTriggerAsTrigger is a convenience function that returns SubscriptionTrigger wrapped in Trigger.
func SubscriptionTriggerAsTrigger(v *SubscriptionTrigger) *Trigger {
	return &Trigger{
		SubscriptionTrigger: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *Trigger) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into OnDemandTrigger
	err = newStrictDecoder(data).Decode(&dst.OnDemandTrigger)
	if err == nil && validateStruct(dst.OnDemandTrigger) == nil {
		jsonOnDemandTrigger, _ := json.Marshal(dst.OnDemandTrigger)
		if string(jsonOnDemandTrigger) == "{}" { // empty struct
			dst.OnDemandTrigger = nil
		} else {
			return nil
		}
	} else {
		dst.OnDemandTrigger = nil
	}

	// try to unmarshal data into ScheduleTrigger
	err = newStrictDecoder(data).Decode(&dst.ScheduleTrigger)
	if err == nil && validateStruct(dst.ScheduleTrigger) == nil {
		jsonScheduleTrigger, _ := json.Marshal(dst.ScheduleTrigger)
		if string(jsonScheduleTrigger) == "{}" { // empty struct
			dst.ScheduleTrigger = nil
		} else {
			return nil
		}
	} else {
		dst.ScheduleTrigger = nil
	}

	// try to unmarshal data into SubscriptionTrigger
	err = newStrictDecoder(data).Decode(&dst.SubscriptionTrigger)
	if err == nil && validateStruct(dst.SubscriptionTrigger) == nil {
		jsonSubscriptionTrigger, _ := json.Marshal(dst.SubscriptionTrigger)
		if string(jsonSubscriptionTrigger) == "{}" { // empty struct
			dst.SubscriptionTrigger = nil
		} else {
			return nil
		}
	} else {
		dst.SubscriptionTrigger = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(Trigger)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src Trigger) MarshalJSON() ([]byte, error) {
	if src.OnDemandTrigger != nil {
		serialized, err := json.Marshal(&src.OnDemandTrigger)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of OnDemandTrigger of Trigger: %w", err)
		}

		return serialized, nil
	}

	if src.ScheduleTrigger != nil {
		serialized, err := json.Marshal(&src.ScheduleTrigger)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of ScheduleTrigger of Trigger: %w", err)
		}

		return serialized, nil
	}

	if src.SubscriptionTrigger != nil {
		serialized, err := json.Marshal(&src.SubscriptionTrigger)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of SubscriptionTrigger of Trigger: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *Trigger) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.OnDemandTrigger != nil {
		return obj.OnDemandTrigger
	}

	if obj.ScheduleTrigger != nil {
		return obj.ScheduleTrigger
	}

	if obj.SubscriptionTrigger != nil {
		return obj.SubscriptionTrigger
	}

	// all schemas are nil
	return nil
}

type NullableTrigger struct {
	value *Trigger
	isSet bool
}

func (v NullableTrigger) Get() *Trigger {
	return v.value
}

func (v *NullableTrigger) Set(val *Trigger) {
	v.value = val
	v.isSet = true
}

func (v NullableTrigger) IsSet() bool {
	return v.isSet
}

func (v *NullableTrigger) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTrigger(val *Trigger) *NullableTrigger {
	return &NullableTrigger{value: val, isSet: true}
}

func (v NullableTrigger) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTrigger) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
