// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// Platform Name of an ecommerce platform with which to authenticate. This determines which authentication type you can select.
type Platform string

// List of Platform.
const (
	PLATFORM_BIGCOMMERCE   Platform = "bigcommerce"
	PLATFORM_COMMERCETOOLS Platform = "commercetools"
	PLATFORM_SHOPIFY       Platform = "shopify"
)

// All allowed values of Platform enum.
var AllowedPlatformEnumValues = []Platform{
	"bigcommerce",
	"commercetools",
	"shopify",
}

func (v *Platform) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'Platform': %w", string(src), err)
	}
	enumTypeValue := Platform(value)
	for _, existing := range AllowedPlatformEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid Platform", value)
}

// NewPlatformFromValue returns a pointer to a valid Platform
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewPlatformFromValue(v string) (*Platform, error) {
	ev := Platform(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for Platform: valid values are %v", v, AllowedPlatformEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v Platform) IsValid() bool {
	for _, existing := range AllowedPlatformEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to Platform value.
func (v Platform) Ptr() *Platform {
	return &v
}
