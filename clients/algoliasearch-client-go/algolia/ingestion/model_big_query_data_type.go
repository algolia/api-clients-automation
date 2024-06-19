// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// BigQueryDataType the model 'BigQueryDataType'.
type BigQueryDataType string

// List of BigQueryDataType.
const (
	BIG_QUERY_DATA_TYPE_GA4   BigQueryDataType = "ga4"
	BIG_QUERY_DATA_TYPE_GA360 BigQueryDataType = "ga360"
)

// All allowed values of BigQueryDataType enum.
var AllowedBigQueryDataTypeEnumValues = []BigQueryDataType{
	"ga4",
	"ga360",
}

func (v *BigQueryDataType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'BigQueryDataType': %w", string(src), err)
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
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewBigQueryDataTypeFromValue(v string) (*BigQueryDataType, error) {
	ev := BigQueryDataType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for BigQueryDataType: valid values are %v", v, AllowedBigQueryDataTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v BigQueryDataType) IsValid() bool {
	for _, existing := range AllowedBigQueryDataTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to BigQueryDataType value.
func (v BigQueryDataType) Ptr() *BigQueryDataType {
	return &v
}
