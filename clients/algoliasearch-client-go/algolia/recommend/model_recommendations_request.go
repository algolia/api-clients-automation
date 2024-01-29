// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendationsRequest - struct for RecommendationsRequest.
type RecommendationsRequest struct {
	RecommendationsQuery   *RecommendationsQuery
	RecommendedForYouQuery *RecommendedForYouQuery
	TrendingFacetsQuery    *TrendingFacetsQuery
	TrendingItemsQuery     *TrendingItemsQuery
}

// TrendingItemsQueryAsRecommendationsRequest is a convenience function that returns TrendingItemsQuery wrapped in RecommendationsRequest.
func TrendingItemsQueryAsRecommendationsRequest(v *TrendingItemsQuery) *RecommendationsRequest {
	return &RecommendationsRequest{
		TrendingItemsQuery: v,
	}
}

// TrendingFacetsQueryAsRecommendationsRequest is a convenience function that returns TrendingFacetsQuery wrapped in RecommendationsRequest.
func TrendingFacetsQueryAsRecommendationsRequest(v *TrendingFacetsQuery) *RecommendationsRequest {
	return &RecommendationsRequest{
		TrendingFacetsQuery: v,
	}
}

// RecommendationsQueryAsRecommendationsRequest is a convenience function that returns RecommendationsQuery wrapped in RecommendationsRequest.
func RecommendationsQueryAsRecommendationsRequest(v *RecommendationsQuery) *RecommendationsRequest {
	return &RecommendationsRequest{
		RecommendationsQuery: v,
	}
}

// RecommendedForYouQueryAsRecommendationsRequest is a convenience function that returns RecommendedForYouQuery wrapped in RecommendationsRequest.
func RecommendedForYouQueryAsRecommendationsRequest(v *RecommendedForYouQuery) *RecommendationsRequest {
	return &RecommendationsRequest{
		RecommendedForYouQuery: v,
	}
}

// Unmarshal JSON data into one of the pointers in the struct.
func (dst *RecommendationsRequest) UnmarshalJSON(data []byte) error {
	var err error
	// try to unmarshal data into RecommendationsQuery
	err = newStrictDecoder(data).Decode(&dst.RecommendationsQuery)
	if err == nil && validateStruct(dst.RecommendationsQuery) == nil {
		jsonRecommendationsQuery, _ := json.Marshal(dst.RecommendationsQuery)
		if string(jsonRecommendationsQuery) == "{}" { // empty struct
			dst.RecommendationsQuery = nil
		} else {
			return nil
		}
	} else {
		dst.RecommendationsQuery = nil
	}

	// try to unmarshal data into RecommendedForYouQuery
	err = newStrictDecoder(data).Decode(&dst.RecommendedForYouQuery)
	if err == nil && validateStruct(dst.RecommendedForYouQuery) == nil {
		jsonRecommendedForYouQuery, _ := json.Marshal(dst.RecommendedForYouQuery)
		if string(jsonRecommendedForYouQuery) == "{}" { // empty struct
			dst.RecommendedForYouQuery = nil
		} else {
			return nil
		}
	} else {
		dst.RecommendedForYouQuery = nil
	}

	// try to unmarshal data into TrendingFacetsQuery
	err = newStrictDecoder(data).Decode(&dst.TrendingFacetsQuery)
	if err == nil && validateStruct(dst.TrendingFacetsQuery) == nil {
		jsonTrendingFacetsQuery, _ := json.Marshal(dst.TrendingFacetsQuery)
		if string(jsonTrendingFacetsQuery) == "{}" { // empty struct
			dst.TrendingFacetsQuery = nil
		} else {
			return nil
		}
	} else {
		dst.TrendingFacetsQuery = nil
	}

	// try to unmarshal data into TrendingItemsQuery
	err = newStrictDecoder(data).Decode(&dst.TrendingItemsQuery)
	if err == nil && validateStruct(dst.TrendingItemsQuery) == nil {
		jsonTrendingItemsQuery, _ := json.Marshal(dst.TrendingItemsQuery)
		if string(jsonTrendingItemsQuery) == "{}" { // empty struct
			dst.TrendingItemsQuery = nil
		} else {
			return nil
		}
	} else {
		dst.TrendingItemsQuery = nil
	}

	return fmt.Errorf("Data failed to match schemas in oneOf(RecommendationsRequest)")
}

// Marshal data from the first non-nil pointers in the struct to JSON.
func (src RecommendationsRequest) MarshalJSON() ([]byte, error) {
	if src.RecommendationsQuery != nil {
		serialized, err := json.Marshal(&src.RecommendationsQuery)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of RecommendationsQuery of RecommendationsRequest: %w", err)
		}

		return serialized, nil
	}

	if src.RecommendedForYouQuery != nil {
		serialized, err := json.Marshal(&src.RecommendedForYouQuery)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of RecommendedForYouQuery of RecommendationsRequest: %w", err)
		}

		return serialized, nil
	}

	if src.TrendingFacetsQuery != nil {
		serialized, err := json.Marshal(&src.TrendingFacetsQuery)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of TrendingFacetsQuery of RecommendationsRequest: %w", err)
		}

		return serialized, nil
	}

	if src.TrendingItemsQuery != nil {
		serialized, err := json.Marshal(&src.TrendingItemsQuery)
		if err != nil {
			return nil, fmt.Errorf("failed to unmarshal one of TrendingItemsQuery of RecommendationsRequest: %w", err)
		}

		return serialized, nil
	}

	return nil, nil // no data in oneOf schemas
}

// Get the actual instance.
func (obj *RecommendationsRequest) GetActualInstance() any {
	if obj == nil {
		return nil
	}
	if obj.RecommendationsQuery != nil {
		return obj.RecommendationsQuery
	}

	if obj.RecommendedForYouQuery != nil {
		return obj.RecommendedForYouQuery
	}

	if obj.TrendingFacetsQuery != nil {
		return obj.TrendingFacetsQuery
	}

	if obj.TrendingItemsQuery != nil {
		return obj.TrendingItemsQuery
	}

	// all schemas are nil
	return nil
}

type NullableRecommendationsRequest struct {
	value *RecommendationsRequest
	isSet bool
}

func (v NullableRecommendationsRequest) Get() *RecommendationsRequest {
	return v.value
}

func (v *NullableRecommendationsRequest) Set(val *RecommendationsRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableRecommendationsRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableRecommendationsRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRecommendationsRequest(val *RecommendationsRequest) *NullableRecommendationsRequest {
	return &NullableRecommendationsRequest{value: val, isSet: true}
}

func (v NullableRecommendationsRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableRecommendationsRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
