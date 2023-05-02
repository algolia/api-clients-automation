// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// BigQueryDataType the model 'BigQueryDataType'
type BigQueryDataType string

// List of BigQueryDataType
const (
	BIGQUERYDATATYPE_GA4   BigQueryDataType = "ga4"
	BIGQUERYDATATYPE_GA360 BigQueryDataType = "ga360"
)

// All allowed values of BigQueryDataType enum
var AllowedBigQueryDataTypeEnumValues = []BigQueryDataType{
	"ga4",
	"ga360",
}

func (v *BigQueryDataType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return err
	}
	enumTypeValue := BigQueryDataType(value)
	for _, existing := range AllowedBigQueryDataTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid BigQueryDataType", value)
}

// NewBigQueryDataTypeFromValue returns a pointer to a valid BigQueryDataType
// for the value passed as argument, or an error if the value passed is not allowed by the enum
func NewBigQueryDataTypeFromValue(v string) (*BigQueryDataType, error) {
	ev := BigQueryDataType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for BigQueryDataType: valid values are %v", v, AllowedBigQueryDataTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise
func (v BigQueryDataType) IsValid() bool {
	for _, existing := range AllowedBigQueryDataTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to BigQueryDataType value
func (v BigQueryDataType) Ptr() *BigQueryDataType {
	return &v
}

type NullableBigQueryDataType struct {
	value *BigQueryDataType
	isSet bool
}

func (v NullableBigQueryDataType) Get() *BigQueryDataType {
	return v.value
}

func (v *NullableBigQueryDataType) Set(val *BigQueryDataType) {
	v.value = val
	v.isSet = true
}

func (v NullableBigQueryDataType) IsSet() bool {
	return v.isSet
}

func (v *NullableBigQueryDataType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBigQueryDataType(val *BigQueryDataType) *NullableBigQueryDataType {
	return &NullableBigQueryDataType{value: val, isSet: true}
}

func (v NullableBigQueryDataType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBigQueryDataType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
