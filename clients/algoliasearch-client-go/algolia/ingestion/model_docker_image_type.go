// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DockerImageType Image type.
type DockerImageType string

// List of DockerImageType.
const (
	DOCKER_IMAGE_TYPE_SINGER  DockerImageType = "singer"
	DOCKER_IMAGE_TYPE_CUSTOM  DockerImageType = "custom"
	DOCKER_IMAGE_TYPE_AIRBYTE DockerImageType = "airbyte"
)

// All allowed values of DockerImageType enum.
var AllowedDockerImageTypeEnumValues = []DockerImageType{
	"singer",
	"custom",
	"airbyte",
}

func (v *DockerImageType) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'DockerImageType': %w", string(src), err)
	}
	enumTypeValue := DockerImageType(value)
	for _, existing := range AllowedDockerImageTypeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid DockerImageType", value)
}

// NewDockerImageTypeFromValue returns a pointer to a valid DockerImageType
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewDockerImageTypeFromValue(v string) (*DockerImageType, error) {
	ev := DockerImageType(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for DockerImageType: valid values are %v", v, AllowedDockerImageTypeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v DockerImageType) IsValid() bool {
	for _, existing := range AllowedDockerImageTypeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to DockerImageType value.
func (v DockerImageType) Ptr() *DockerImageType {
	return &v
}

type NullableDockerImageType struct {
	value *DockerImageType
	isSet bool
}

func (v NullableDockerImageType) Get() *DockerImageType {
	return v.value
}

func (v *NullableDockerImageType) Set(val *DockerImageType) {
	v.value = val
	v.isSet = true
}

func (v NullableDockerImageType) IsSet() bool {
	return v.isSet
}

func (v *NullableDockerImageType) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDockerImageType(val *DockerImageType) *NullableDockerImageType {
	return &NullableDockerImageType{value: val, isSet: true}
}

func (v NullableDockerImageType) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableDockerImageType) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
