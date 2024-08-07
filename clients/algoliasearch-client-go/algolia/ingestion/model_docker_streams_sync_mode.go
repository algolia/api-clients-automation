// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DockerStreamsSyncMode The strategy to use to fetch the data.
type DockerStreamsSyncMode string

// List of DockerStreamsSyncMode.
const (
	DOCKER_STREAMS_SYNC_MODE_INCREMENTAL DockerStreamsSyncMode = "incremental"
	DOCKER_STREAMS_SYNC_MODE_FULL_TABLE  DockerStreamsSyncMode = "fullTable"
)

// All allowed values of DockerStreamsSyncMode enum.
var AllowedDockerStreamsSyncModeEnumValues = []DockerStreamsSyncMode{
	"incremental",
	"fullTable",
}

func (v *DockerStreamsSyncMode) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'DockerStreamsSyncMode': %w", string(src), err)
	}
	enumTypeValue := DockerStreamsSyncMode(value)
	for _, existing := range AllowedDockerStreamsSyncModeEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid DockerStreamsSyncMode", value)
}

// NewDockerStreamsSyncModeFromValue returns a pointer to a valid DockerStreamsSyncMode
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewDockerStreamsSyncModeFromValue(v string) (*DockerStreamsSyncMode, error) {
	ev := DockerStreamsSyncMode(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for DockerStreamsSyncMode: valid values are %v", v, AllowedDockerStreamsSyncModeEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v DockerStreamsSyncMode) IsValid() bool {
	for _, existing := range AllowedDockerStreamsSyncModeEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to DockerStreamsSyncMode value.
func (v DockerStreamsSyncMode) Ptr() *DockerStreamsSyncMode {
	return &v
}