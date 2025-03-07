// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceType the model 'SourceType'.
type SourceType string

// List of SourceType.
const (
	SOURCE_TYPE_BIGCOMMERCE         SourceType = "bigcommerce"
	SOURCE_TYPE_BIGQUERY            SourceType = "bigquery"
	SOURCE_TYPE_COMMERCETOOLS       SourceType = "commercetools"
	SOURCE_TYPE_CSV                 SourceType = "csv"
	SOURCE_TYPE_DOCKER              SourceType = "docker"
	SOURCE_TYPE_GA4_BIGQUERY_EXPORT SourceType = "ga4BigqueryExport"
	SOURCE_TYPE_JSON                SourceType = "json"
	SOURCE_TYPE_SHOPIFY             SourceType = "shopify"
	SOURCE_TYPE_PUSH                SourceType = "push"
)

// All allowed values of SourceType enum.
var AllowedSourceTypeEnumValues = []SourceType{
	"bigcommerce",
	"bigquery",
	"commercetools",
	"csv",
	"docker",
	"ga4BigqueryExport",
	"json",
	"shopify",
	"push",
}

func (v *SourceType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'SourceType': %w", string(src), err)
	}
	enumTypeValue := SourceType(value)
	for _, existing := range AllowedSourceTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid SourceType", value)
}

// NewSourceTypeFromValue returns a pointer to a valid SourceType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewSourceTypeFromValue(v string) (*SourceType, error) {
	ev := SourceType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for SourceType: valid values are %v", v, AllowedSourceTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v SourceType) IsValid() bool {
	for _, existing := range AllowedSourceTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to SourceType value.
func (v SourceType) Ptr() *SourceType {
	return &v
}
