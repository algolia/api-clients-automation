// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// TrendingFacetsModel Trending facets model.
type TrendingFacetsModel string

// List of trendingFacetsModel.
const (
	TRENDINGFACETSMODEL_TRENDING_FACETS TrendingFacetsModel = "trending-facets"
)

// All allowed values of TrendingFacetsModel enum.
var AllowedTrendingFacetsModelEnumValues = []TrendingFacetsModel{
	"trending-facets",
}

func (v *TrendingFacetsModel) UnmarshalJSON(src []byte) error {
	var value string
	err := json.Unmarshal(src, &value)
	if err != nil {
		return fmt.Errorf("failed to unmarshal value '%s' for enum 'TrendingFacetsModel': %w", string(src), err)
	}
	enumTypeValue := TrendingFacetsModel(value)
	for _, existing := range AllowedTrendingFacetsModelEnumValues {
		if existing == enumTypeValue {
			*v = enumTypeValue
			return nil
		}
	}

	return fmt.Errorf("%+v is not a valid TrendingFacetsModel", value)
}

// NewTrendingFacetsModelFromValue returns a pointer to a valid TrendingFacetsModel
// for the value passed as argument, or an error if the value passed is not allowed by the enum.
func NewTrendingFacetsModelFromValue(v string) (*TrendingFacetsModel, error) {
	ev := TrendingFacetsModel(v)
	if ev.IsValid() {
		return &ev, nil
	} else {
		return nil, fmt.Errorf("invalid value '%v' for TrendingFacetsModel: valid values are %v", v, AllowedTrendingFacetsModelEnumValues)
	}
}

// IsValid return true if the value is valid for the enum, false otherwise.
func (v TrendingFacetsModel) IsValid() bool {
	for _, existing := range AllowedTrendingFacetsModelEnumValues {
		if existing == v {
			return true
		}
	}
	return false
}

// Ptr returns reference to trendingFacetsModel value.
func (v TrendingFacetsModel) Ptr() *TrendingFacetsModel {
	return &v
}

type NullableTrendingFacetsModel struct {
	value *TrendingFacetsModel
	isSet bool
}

func (v NullableTrendingFacetsModel) Get() *TrendingFacetsModel {
	return v.value
}

func (v *NullableTrendingFacetsModel) Set(val *TrendingFacetsModel) {
	v.value = val
	v.isSet = true
}

func (v NullableTrendingFacetsModel) IsSet() bool {
	return v.isSet
}

func (v *NullableTrendingFacetsModel) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableTrendingFacetsModel(val *TrendingFacetsModel) *NullableTrendingFacetsModel {
	return &NullableTrendingFacetsModel{value: val, isSet: true}
}

func (v NullableTrendingFacetsModel) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableTrendingFacetsModel) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
