// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendationsHit - struct for RecommendationsHit.
type RecommendationsHit struct {
	RecommendHit     *RecommendHit
	TrendingFacetHit *TrendingFacetHit
}

// RecommendHitAsRecommendationsHit is a convenience function that returns RecommendHit wrapped in RecommendationsHit.
func RecommendHitAsRecommendationsHit(v RecommendHit) *RecommendationsHit {
	return &RecommendationsHit{
		RecommendHit: &v,
	}
}

// TrendingFacetHitAsRecommendationsHit is a convenience function that returns TrendingFacetHit wrapped in RecommendationsHit.
func TrendingFacetHitAsRecommendationsHit(v *TrendingFacetHit) *RecommendationsHit {
	return &RecommendationsHit{
		TrendingFacetHit: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *RecommendationsHit) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into RecommendHit
	err = newStrictDecoder(data).Decode(&dst.RecommendHit)
	if err == nil && validateStruct(dst.RecommendHit) == nil {
		jsonRecommendHit, _ := json.Marshal(dst.RecommendHit)
		if string(jsonRecommendHit) == "{}" { // empty struct
			dst.RecommendHit = nil
		} else {
			return nil
		}
	} else {
		dst.RecommendHit = nil
	}

	// try to unmarshal data into TrendingFacetHit
	err = newStrictDecoder(data).Decode(&dst.TrendingFacetHit)
	if err == nil && validateStruct(dst.TrendingFacetHit) == nil {
		jsonTrendingFacetHit, _ := json.Marshal(dst.TrendingFacetHit)
		if string(jsonTrendingFacetHit) == "{}" { // empty struct
			dst.TrendingFacetHit = nil
		} else {
			return nil
		}
	} else {
		dst.TrendingFacetHit = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(RecommendationsHit)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src RecommendationsHit) MarshalJSON() ([]byte, error) {
	if src.RecommendHit != nil {
		serialized, err := json.Marshal(&src.RecommendHit)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of RecommendHit of RecommendationsHit: %w", err)
		}

		return serialized, nil
	}

	if src.TrendingFacetHit != nil {
		serialized, err := json.Marshal(&src.TrendingFacetHit)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of TrendingFacetHit of RecommendationsHit: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *RecommendationsHit) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.RecommendHit != nil {
		return obj.RecommendHit
	}

	if obj.TrendingFacetHit != nil {
		return obj.TrendingFacetHit
	}

	// all schemas are nil
	return nil
}

type NullableRecommendationsHit struct {
	value *RecommendationsHit
	isSet bool
}

func (v NullableRecommendationsHit) Get() *RecommendationsHit {
	return v.value
}

func (v *NullableRecommendationsHit) Set(val *RecommendationsHit) {
	v.value = val
	v.isSet = true
}

func (v NullableRecommendationsHit) IsSet() bool {
	return v.isSet
}

func (v *NullableRecommendationsHit) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRecommendationsHit(val *RecommendationsHit) *NullableRecommendationsHit {
	return &NullableRecommendationsHit{value: val, isSet: true}
}

func (v NullableRecommendationsHit) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableRecommendationsHit) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
