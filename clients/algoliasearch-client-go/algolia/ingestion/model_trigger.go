// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// Trigger - Trigger that runs the task.
type Trigger struct {
	OnDemandTrigger     *OnDemandTrigger
	ScheduleTrigger     *ScheduleTrigger
	StreamingTrigger    *StreamingTrigger
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

// StreamingTriggerAsTrigger is a convenience function that returns StreamingTrigger wrapped in Trigger.
func StreamingTriggerAsTrigger(v *StreamingTrigger) *Trigger {
	return &Trigger{
		StreamingTrigger: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *Trigger) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into OnDemandTrigger
	err = json.Unmarshal(data, &dst.OnDemandTrigger)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.OnDemandTrigger = nil
	}
	// try to unmarshal data into ScheduleTrigger
	err = json.Unmarshal(data, &dst.ScheduleTrigger)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.ScheduleTrigger = nil
	}
	// try to unmarshal data into SubscriptionTrigger
	err = json.Unmarshal(data, &dst.SubscriptionTrigger)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.SubscriptionTrigger = nil
	}
	// try to unmarshal data into StreamingTrigger
	err = json.Unmarshal(data, &dst.StreamingTrigger)
	if err == nil {
		return nil // found the correct type
	} else {
		dst.StreamingTrigger = nil
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

	if src.StreamingTrigger != nil {
		serialized, err := json.Marshal(&src.StreamingTrigger)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of StreamingTrigger of Trigger: %w", err)
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
func (obj Trigger) GetActualInstance() any {
	if obj.OnDemandTrigger != nil {
		return *obj.OnDemandTrigger
	}

	if obj.ScheduleTrigger != nil {
		return *obj.ScheduleTrigger
	}

	if obj.StreamingTrigger != nil {
		return *obj.StreamingTrigger
	}

	if obj.SubscriptionTrigger != nil {
		return *obj.SubscriptionTrigger
	}

	// all schemas are nil
	return nil
}
