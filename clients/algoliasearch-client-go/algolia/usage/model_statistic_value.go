// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package usage

import (
	"encoding/json"
	"fmt"
)

// StatisticValue - struct for StatisticValue.
type StatisticValue struct {
	Int32               *int32
	MapmapOfStringint32 *map[string]int32
}

// int32AsStatisticValue is a convenience function that returns int32 wrapped in StatisticValue.
func Int32AsStatisticValue(v int32) *StatisticValue {
	return &StatisticValue{
		Int32: &v,
	}
}

// map[string]int32AsStatisticValue is a convenience function that returns map[string]int32 wrapped in StatisticValue.
func MapmapOfStringint32AsStatisticValue(v map[string]int32) *StatisticValue {
	return &StatisticValue{
		MapmapOfStringint32: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *StatisticValue) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into Int32
	err = newStrictDecoder(data).Decode(&dst.Int32)
	if err == nil && validateStruct(dst.Int32) == nil {
		jsonInt32, _ := json.Marshal(dst.Int32)
		if string(jsonInt32) == "{}" { // empty struct
			dst.Int32 = nil
		} else {
			return nil
		}
	} else {
		dst.Int32 = nil
	}

	// try to unmarshal data into MapmapOfStringint32
	err = newStrictDecoder(data).Decode(&dst.MapmapOfStringint32)
	if err == nil && validateStruct(dst.MapmapOfStringint32) == nil {
		jsonMapmapOfStringint32, _ := json.Marshal(dst.MapmapOfStringint32)
		if string(jsonMapmapOfStringint32) == "{}" { // empty struct
			dst.MapmapOfStringint32 = nil
		} else {
			return nil
		}
	} else {
		dst.MapmapOfStringint32 = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(StatisticValue)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src StatisticValue) MarshalJSON() ([]byte, error) {
	if src.Int32 != nil {
		serialized, err := json.Marshal(&src.Int32)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of Int32 of StatisticValue: %w", err)
		}

		return serialized, nil
	}

	if src.MapmapOfStringint32 != nil {
		serialized, err := json.Marshal(&src.MapmapOfStringint32)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of MapmapOfStringint32 of StatisticValue: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj StatisticValue) GetActualInstance() any {
	if obj.Int32 != nil {
		return *obj.Int32
	}

	if obj.MapmapOfStringint32 != nil {
		return *obj.MapmapOfStringint32
	}

	// all schemas are nil
	return nil
}
