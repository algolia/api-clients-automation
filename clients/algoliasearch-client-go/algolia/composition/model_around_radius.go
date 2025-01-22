// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// AroundRadius - Maximum radius for a search around a central location.  This parameter works in combination with the `aroundLatLng` and `aroundLatLngViaIP` parameters. By default, the search radius is determined automatically from the density of hits around the central location. The search radius is small if there are many hits close to the central coordinates.
type AroundRadius struct {
	AroundRadiusAll *AroundRadiusAll
	Int32           *int32
}

// int32AsAroundRadius is a convenience function that returns int32 wrapped in AroundRadius.
func Int32AsAroundRadius(v int32) *AroundRadius {
	return &AroundRadius{
		Int32: &v,
	}
}

// AroundRadiusAllAsAroundRadius is a convenience function that returns AroundRadiusAll wrapped in AroundRadius.
func AroundRadiusAllAsAroundRadius(v AroundRadiusAll) *AroundRadius {
	return &AroundRadius{
		AroundRadiusAll: &v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *AroundRadius) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into Int32
	err = newStrictDecoder(data).Decode(&dst.Int32)
	if err == nil && validateStruct(dst.Int32) == nil {
		return nil // found the correct type
	} else {
		dst.Int32 = nil
	}
	// try to unmarshal data into AroundRadiusAll
	err = newStrictDecoder(data).Decode(&dst.AroundRadiusAll)
	if err == nil && validateStruct(dst.AroundRadiusAll) == nil {
		return nil // found the correct type
	} else {
		dst.AroundRadiusAll = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(AroundRadius)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src AroundRadius) MarshalJSON() ([]byte, error) {
	if src.AroundRadiusAll != nil {
		serialized, err := json.Marshal(&src.AroundRadiusAll)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of AroundRadiusAll of AroundRadius: %w", err)
		}

		return serialized, nil
	}

	if src.Int32 != nil {
		serialized, err := json.Marshal(&src.Int32)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of Int32 of AroundRadius: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj AroundRadius) GetActualInstance() any {
	if obj.AroundRadiusAll != nil {
		return *obj.AroundRadiusAll
	}

	if obj.Int32 != nil {
		return *obj.Int32
	}

	// all schemas are nil
	return nil
}
