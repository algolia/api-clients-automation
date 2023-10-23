// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"encoding/json"
	"fmt"
)

// EventsItems - struct for EventsItems
type EventsItems struct {
	AddedToCartObjectIDs            *AddedToCartObjectIDs
	AddedToCartObjectIDsAfterSearch *AddedToCartObjectIDsAfterSearch
	ClickedFilters                  *ClickedFilters
	ClickedObjectIDs                *ClickedObjectIDs
	ClickedObjectIDsAfterSearch     *ClickedObjectIDsAfterSearch
	ConvertedFilters                *ConvertedFilters
	ConvertedObjectIDs              *ConvertedObjectIDs
	ConvertedObjectIDsAfterSearch   *ConvertedObjectIDsAfterSearch
	PurchasedObjectIDs              *PurchasedObjectIDs
	PurchasedObjectIDsAfterSearch   *PurchasedObjectIDsAfterSearch
	ViewedFilters                   *ViewedFilters
	ViewedObjectIDs                 *ViewedObjectIDs
}

// AddedToCartObjectIDsAsEventsItems is a convenience function that returns AddedToCartObjectIDs wrapped in EventsItems
func AddedToCartObjectIDsAsEventsItems(v *AddedToCartObjectIDs) EventsItems {
	return EventsItems{
		AddedToCartObjectIDs: v,
	}
}

// AddedToCartObjectIDsAfterSearchAsEventsItems is a convenience function that returns AddedToCartObjectIDsAfterSearch wrapped in EventsItems
func AddedToCartObjectIDsAfterSearchAsEventsItems(v *AddedToCartObjectIDsAfterSearch) EventsItems {
	return EventsItems{
		AddedToCartObjectIDsAfterSearch: v,
	}
}

// ClickedFiltersAsEventsItems is a convenience function that returns ClickedFilters wrapped in EventsItems
func ClickedFiltersAsEventsItems(v *ClickedFilters) EventsItems {
	return EventsItems{
		ClickedFilters: v,
	}
}

// ClickedObjectIDsAsEventsItems is a convenience function that returns ClickedObjectIDs wrapped in EventsItems
func ClickedObjectIDsAsEventsItems(v *ClickedObjectIDs) EventsItems {
	return EventsItems{
		ClickedObjectIDs: v,
	}
}

// ClickedObjectIDsAfterSearchAsEventsItems is a convenience function that returns ClickedObjectIDsAfterSearch wrapped in EventsItems
func ClickedObjectIDsAfterSearchAsEventsItems(v *ClickedObjectIDsAfterSearch) EventsItems {
	return EventsItems{
		ClickedObjectIDsAfterSearch: v,
	}
}

// ConvertedFiltersAsEventsItems is a convenience function that returns ConvertedFilters wrapped in EventsItems
func ConvertedFiltersAsEventsItems(v *ConvertedFilters) EventsItems {
	return EventsItems{
		ConvertedFilters: v,
	}
}

// ConvertedObjectIDsAsEventsItems is a convenience function that returns ConvertedObjectIDs wrapped in EventsItems
func ConvertedObjectIDsAsEventsItems(v *ConvertedObjectIDs) EventsItems {
	return EventsItems{
		ConvertedObjectIDs: v,
	}
}

// ConvertedObjectIDsAfterSearchAsEventsItems is a convenience function that returns ConvertedObjectIDsAfterSearch wrapped in EventsItems
func ConvertedObjectIDsAfterSearchAsEventsItems(v *ConvertedObjectIDsAfterSearch) EventsItems {
	return EventsItems{
		ConvertedObjectIDsAfterSearch: v,
	}
}

// PurchasedObjectIDsAsEventsItems is a convenience function that returns PurchasedObjectIDs wrapped in EventsItems
func PurchasedObjectIDsAsEventsItems(v *PurchasedObjectIDs) EventsItems {
	return EventsItems{
		PurchasedObjectIDs: v,
	}
}

// PurchasedObjectIDsAfterSearchAsEventsItems is a convenience function that returns PurchasedObjectIDsAfterSearch wrapped in EventsItems
func PurchasedObjectIDsAfterSearchAsEventsItems(v *PurchasedObjectIDsAfterSearch) EventsItems {
	return EventsItems{
		PurchasedObjectIDsAfterSearch: v,
	}
}

// ViewedFiltersAsEventsItems is a convenience function that returns ViewedFilters wrapped in EventsItems
func ViewedFiltersAsEventsItems(v *ViewedFilters) EventsItems {
	return EventsItems{
		ViewedFilters: v,
	}
}

// ViewedObjectIDsAsEventsItems is a convenience function that returns ViewedObjectIDs wrapped in EventsItems
func ViewedObjectIDsAsEventsItems(v *ViewedObjectIDs) EventsItems {
	return EventsItems{
		ViewedObjectIDs: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct
func (dst *EventsItems) UnmarshalJSON(data []byte) error {
	var err error
	// use discriminator value to speed up the lookup
	var jsonDict map[string]any
	err = newStrictDecoder(data).Decode(&jsonDict)
	if err != nil {
		return fmt.Errorf("Failed to unmarshal JSON into map for the discriminator lookup (AddedToCartObjectIDsAfterSearch).")
	}

	// Hold the schema validity between checks
	validSchemaForModel := true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventSubtype'
		if _, ok := jsonDict["eventSubtype"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'queryID'
		if _, ok := jsonDict["queryID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into AddedToCartObjectIDsAfterSearch
		err = newStrictDecoder(data).Decode(&dst.AddedToCartObjectIDsAfterSearch)
		if err == nil && validateStruct(dst.AddedToCartObjectIDsAfterSearch) == nil {
			jsonAddedToCartObjectIDsAfterSearch, _ := json.Marshal(dst.AddedToCartObjectIDsAfterSearch)
			if string(jsonAddedToCartObjectIDsAfterSearch) == "{}" { // empty struct
				dst.AddedToCartObjectIDsAfterSearch = nil
			} else {
				return nil
			}
		} else {
			dst.AddedToCartObjectIDsAfterSearch = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventSubtype'
		if _, ok := jsonDict["eventSubtype"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'queryID'
		if _, ok := jsonDict["queryID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into PurchasedObjectIDsAfterSearch
		err = newStrictDecoder(data).Decode(&dst.PurchasedObjectIDsAfterSearch)
		if err == nil && validateStruct(dst.PurchasedObjectIDsAfterSearch) == nil {
			jsonPurchasedObjectIDsAfterSearch, _ := json.Marshal(dst.PurchasedObjectIDsAfterSearch)
			if string(jsonPurchasedObjectIDsAfterSearch) == "{}" { // empty struct
				dst.PurchasedObjectIDsAfterSearch = nil
			} else {
				return nil
			}
		} else {
			dst.PurchasedObjectIDsAfterSearch = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventSubtype'
		if _, ok := jsonDict["eventSubtype"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into AddedToCartObjectIDs
		err = newStrictDecoder(data).Decode(&dst.AddedToCartObjectIDs)
		if err == nil && validateStruct(dst.AddedToCartObjectIDs) == nil {
			jsonAddedToCartObjectIDs, _ := json.Marshal(dst.AddedToCartObjectIDs)
			if string(jsonAddedToCartObjectIDs) == "{}" { // empty struct
				dst.AddedToCartObjectIDs = nil
			} else {
				return nil
			}
		} else {
			dst.AddedToCartObjectIDs = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'positions'
		if _, ok := jsonDict["positions"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'queryID'
		if _, ok := jsonDict["queryID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ClickedObjectIDsAfterSearch
		err = newStrictDecoder(data).Decode(&dst.ClickedObjectIDsAfterSearch)
		if err == nil && validateStruct(dst.ClickedObjectIDsAfterSearch) == nil {
			jsonClickedObjectIDsAfterSearch, _ := json.Marshal(dst.ClickedObjectIDsAfterSearch)
			if string(jsonClickedObjectIDsAfterSearch) == "{}" { // empty struct
				dst.ClickedObjectIDsAfterSearch = nil
			} else {
				return nil
			}
		} else {
			dst.ClickedObjectIDsAfterSearch = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventSubtype'
		if _, ok := jsonDict["eventSubtype"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into PurchasedObjectIDs
		err = newStrictDecoder(data).Decode(&dst.PurchasedObjectIDs)
		if err == nil && validateStruct(dst.PurchasedObjectIDs) == nil {
			jsonPurchasedObjectIDs, _ := json.Marshal(dst.PurchasedObjectIDs)
			if string(jsonPurchasedObjectIDs) == "{}" { // empty struct
				dst.PurchasedObjectIDs = nil
			} else {
				return nil
			}
		} else {
			dst.PurchasedObjectIDs = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'filters'
		if _, ok := jsonDict["filters"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ClickedFilters
		err = newStrictDecoder(data).Decode(&dst.ClickedFilters)
		if err == nil && validateStruct(dst.ClickedFilters) == nil {
			jsonClickedFilters, _ := json.Marshal(dst.ClickedFilters)
			if string(jsonClickedFilters) == "{}" { // empty struct
				dst.ClickedFilters = nil
			} else {
				return nil
			}
		} else {
			dst.ClickedFilters = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ClickedObjectIDs
		err = newStrictDecoder(data).Decode(&dst.ClickedObjectIDs)
		if err == nil && validateStruct(dst.ClickedObjectIDs) == nil {
			jsonClickedObjectIDs, _ := json.Marshal(dst.ClickedObjectIDs)
			if string(jsonClickedObjectIDs) == "{}" { // empty struct
				dst.ClickedObjectIDs = nil
			} else {
				return nil
			}
		} else {
			dst.ClickedObjectIDs = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'filters'
		if _, ok := jsonDict["filters"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ConvertedFilters
		err = newStrictDecoder(data).Decode(&dst.ConvertedFilters)
		if err == nil && validateStruct(dst.ConvertedFilters) == nil {
			jsonConvertedFilters, _ := json.Marshal(dst.ConvertedFilters)
			if string(jsonConvertedFilters) == "{}" { // empty struct
				dst.ConvertedFilters = nil
			} else {
				return nil
			}
		} else {
			dst.ConvertedFilters = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ConvertedObjectIDs
		err = newStrictDecoder(data).Decode(&dst.ConvertedObjectIDs)
		if err == nil && validateStruct(dst.ConvertedObjectIDs) == nil {
			jsonConvertedObjectIDs, _ := json.Marshal(dst.ConvertedObjectIDs)
			if string(jsonConvertedObjectIDs) == "{}" { // empty struct
				dst.ConvertedObjectIDs = nil
			} else {
				return nil
			}
		} else {
			dst.ConvertedObjectIDs = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'queryID'
		if _, ok := jsonDict["queryID"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ConvertedObjectIDsAfterSearch
		err = newStrictDecoder(data).Decode(&dst.ConvertedObjectIDsAfterSearch)
		if err == nil && validateStruct(dst.ConvertedObjectIDsAfterSearch) == nil {
			jsonConvertedObjectIDsAfterSearch, _ := json.Marshal(dst.ConvertedObjectIDsAfterSearch)
			if string(jsonConvertedObjectIDsAfterSearch) == "{}" { // empty struct
				dst.ConvertedObjectIDsAfterSearch = nil
			} else {
				return nil
			}
		} else {
			dst.ConvertedObjectIDsAfterSearch = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'filters'
		if _, ok := jsonDict["filters"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ViewedFilters
		err = newStrictDecoder(data).Decode(&dst.ViewedFilters)
		if err == nil && validateStruct(dst.ViewedFilters) == nil {
			jsonViewedFilters, _ := json.Marshal(dst.ViewedFilters)
			if string(jsonViewedFilters) == "{}" { // empty struct
				dst.ViewedFilters = nil
			} else {
				return nil
			}
		} else {
			dst.ViewedFilters = nil
		}
	}

	// Reset the schema validity for the next class check
	validSchemaForModel = true

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'eventType'
		if _, ok := jsonDict["eventType"]; !ok {
			validSchemaForModel = false
		}
	}

	// If the model wasn't discriminated yet, continue checking for other discriminating properties
	if validSchemaForModel {
		// Check if the model holds a property 'objectIDs'
		if _, ok := jsonDict["objectIDs"]; !ok {
			validSchemaForModel = false
		}
	}

	if validSchemaForModel {
		// try to unmarshal data into ViewedObjectIDs
		err = newStrictDecoder(data).Decode(&dst.ViewedObjectIDs)
		if err == nil && validateStruct(dst.ViewedObjectIDs) == nil {
			jsonViewedObjectIDs, _ := json.Marshal(dst.ViewedObjectIDs)
			if string(jsonViewedObjectIDs) == "{}" { // empty struct
				dst.ViewedObjectIDs = nil
			} else {
				return nil
			}
		} else {
			dst.ViewedObjectIDs = nil
		}
	}
	return fmt.Errorf("Data failed to match schemas in oneOf(EventsItems)")
}

// Marshal data from the first non-nil pointers in the struct to JSON
func (src EventsItems) MarshalJSON() ([]byte, error) {
	if src.AddedToCartObjectIDs != nil {
		return json.Marshal(&src.AddedToCartObjectIDs)
	}

	if src.AddedToCartObjectIDsAfterSearch != nil {
		return json.Marshal(&src.AddedToCartObjectIDsAfterSearch)
	}

	if src.ClickedFilters != nil {
		return json.Marshal(&src.ClickedFilters)
	}

	if src.ClickedObjectIDs != nil {
		return json.Marshal(&src.ClickedObjectIDs)
	}

	if src.ClickedObjectIDsAfterSearch != nil {
		return json.Marshal(&src.ClickedObjectIDsAfterSearch)
	}

	if src.ConvertedFilters != nil {
		return json.Marshal(&src.ConvertedFilters)
	}

	if src.ConvertedObjectIDs != nil {
		return json.Marshal(&src.ConvertedObjectIDs)
	}

	if src.ConvertedObjectIDsAfterSearch != nil {
		return json.Marshal(&src.ConvertedObjectIDsAfterSearch)
	}

	if src.PurchasedObjectIDs != nil {
		return json.Marshal(&src.PurchasedObjectIDs)
	}

	if src.PurchasedObjectIDsAfterSearch != nil {
		return json.Marshal(&src.PurchasedObjectIDsAfterSearch)
	}

	if src.ViewedFilters != nil {
		return json.Marshal(&src.ViewedFilters)
	}

	if src.ViewedObjectIDs != nil {
		return json.Marshal(&src.ViewedObjectIDs)
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance
func (obj *EventsItems) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.AddedToCartObjectIDs != nil {
		return obj.AddedToCartObjectIDs
	}

	if obj.AddedToCartObjectIDsAfterSearch != nil {
		return obj.AddedToCartObjectIDsAfterSearch
	}

	if obj.ClickedFilters != nil {
		return obj.ClickedFilters
	}

	if obj.ClickedObjectIDs != nil {
		return obj.ClickedObjectIDs
	}

	if obj.ClickedObjectIDsAfterSearch != nil {
		return obj.ClickedObjectIDsAfterSearch
	}

	if obj.ConvertedFilters != nil {
		return obj.ConvertedFilters
	}

	if obj.ConvertedObjectIDs != nil {
		return obj.ConvertedObjectIDs
	}

	if obj.ConvertedObjectIDsAfterSearch != nil {
		return obj.ConvertedObjectIDsAfterSearch
	}

	if obj.PurchasedObjectIDs != nil {
		return obj.PurchasedObjectIDs
	}

	if obj.PurchasedObjectIDsAfterSearch != nil {
		return obj.PurchasedObjectIDsAfterSearch
	}

	if obj.ViewedFilters != nil {
		return obj.ViewedFilters
	}

	if obj.ViewedObjectIDs != nil {
		return obj.ViewedObjectIDs
	}

	// all schemas are nil
	return nil
}

type NullableEventsItems struct {
	value *EventsItems
	isSet bool
}

func (v NullableEventsItems) Get() *EventsItems {
	return v.value
}

func (v *NullableEventsItems) Set(val *EventsItems) {
	v.value = val
	v.isSet = true
}

func (v NullableEventsItems) IsSet() bool {
	return v.isSet
}

func (v *NullableEventsItems) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableEventsItems(val *EventsItems) *NullableEventsItems {
	return &NullableEventsItems{value: val, isSet: true}
}

func (v NullableEventsItems) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableEventsItems) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
