// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendedForYouQuery struct for RecommendedForYouQuery.
type RecommendedForYouQuery struct {
	// Algolia index name.
	IndexName string `json:"indexName"`
	// Recommendations with a confidence score lower than `threshold` won't appear in results. > **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are.
	Threshold *int32 `json:"threshold,omitempty"`
	// Maximum number of recommendations to retrieve. If 0, all recommendations will be returned.
	MaxRecommendations *int32                            `json:"maxRecommendations,omitempty"`
	Model              RecommendedForYouModel            `json:"model"`
	QueryParameters    *RecommendedForYouQueryParameters `json:"queryParameters,omitempty"`
	FallbackParameters *RecommendedForYouQueryParameters `json:"fallbackParameters,omitempty"`
}

type RecommendedForYouQueryOption func(f *RecommendedForYouQuery)

func WithRecommendedForYouQueryThreshold(val int32) RecommendedForYouQueryOption {
	return func(f *RecommendedForYouQuery) {
		f.Threshold = &val
	}
}

func WithRecommendedForYouQueryMaxRecommendations(val int32) RecommendedForYouQueryOption {
	return func(f *RecommendedForYouQuery) {
		f.MaxRecommendations = &val
	}
}

func WithRecommendedForYouQueryQueryParameters(val RecommendedForYouQueryParameters) RecommendedForYouQueryOption {
	return func(f *RecommendedForYouQuery) {
		f.QueryParameters = &val
	}
}

func WithRecommendedForYouQueryFallbackParameters(val RecommendedForYouQueryParameters) RecommendedForYouQueryOption {
	return func(f *RecommendedForYouQuery) {
		f.FallbackParameters = &val
	}
}

// NewRecommendedForYouQuery instantiates a new RecommendedForYouQuery object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRecommendedForYouQuery(indexName string, model RecommendedForYouModel, opts ...RecommendedForYouQueryOption) *RecommendedForYouQuery {
	this := &RecommendedForYouQuery{}
	this.IndexName = indexName
	this.Model = model
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyRecommendedForYouQuery return a pointer to an empty RecommendedForYouQuery object.
func NewEmptyRecommendedForYouQuery() *RecommendedForYouQuery {
	return &RecommendedForYouQuery{}
}

// GetIndexName returns the IndexName field value.
func (o *RecommendedForYouQuery) GetIndexName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetIndexNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexName, true
}

// SetIndexName sets field value.
func (o *RecommendedForYouQuery) SetIndexName(v string) *RecommendedForYouQuery {
	o.IndexName = v
	return o
}

// GetThreshold returns the Threshold field value if set, zero value otherwise.
func (o *RecommendedForYouQuery) GetThreshold() int32 {
	if o == nil || o.Threshold == nil {
		var ret int32
		return ret
	}
	return *o.Threshold
}

// GetThresholdOk returns a tuple with the Threshold field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetThresholdOk() (*int32, bool) {
	if o == nil || o.Threshold == nil {
		return nil, false
	}
	return o.Threshold, true
}

// HasThreshold returns a boolean if a field has been set.
func (o *RecommendedForYouQuery) HasThreshold() bool {
	if o != nil && o.Threshold != nil {
		return true
	}

	return false
}

// SetThreshold gets a reference to the given int32 and assigns it to the Threshold field.
func (o *RecommendedForYouQuery) SetThreshold(v int32) *RecommendedForYouQuery {
	o.Threshold = &v
	return o
}

// GetMaxRecommendations returns the MaxRecommendations field value if set, zero value otherwise.
func (o *RecommendedForYouQuery) GetMaxRecommendations() int32 {
	if o == nil || o.MaxRecommendations == nil {
		var ret int32
		return ret
	}
	return *o.MaxRecommendations
}

// GetMaxRecommendationsOk returns a tuple with the MaxRecommendations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetMaxRecommendationsOk() (*int32, bool) {
	if o == nil || o.MaxRecommendations == nil {
		return nil, false
	}
	return o.MaxRecommendations, true
}

// HasMaxRecommendations returns a boolean if a field has been set.
func (o *RecommendedForYouQuery) HasMaxRecommendations() bool {
	if o != nil && o.MaxRecommendations != nil {
		return true
	}

	return false
}

// SetMaxRecommendations gets a reference to the given int32 and assigns it to the MaxRecommendations field.
func (o *RecommendedForYouQuery) SetMaxRecommendations(v int32) *RecommendedForYouQuery {
	o.MaxRecommendations = &v
	return o
}

// GetModel returns the Model field value.
func (o *RecommendedForYouQuery) GetModel() RecommendedForYouModel {
	if o == nil {
		var ret RecommendedForYouModel
		return ret
	}

	return o.Model
}

// GetModelOk returns a tuple with the Model field value
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetModelOk() (*RecommendedForYouModel, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Model, true
}

// SetModel sets field value.
func (o *RecommendedForYouQuery) SetModel(v RecommendedForYouModel) *RecommendedForYouQuery {
	o.Model = v
	return o
}

// GetQueryParameters returns the QueryParameters field value if set, zero value otherwise.
func (o *RecommendedForYouQuery) GetQueryParameters() RecommendedForYouQueryParameters {
	if o == nil || o.QueryParameters == nil {
		var ret RecommendedForYouQueryParameters
		return ret
	}
	return *o.QueryParameters
}

// GetQueryParametersOk returns a tuple with the QueryParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetQueryParametersOk() (*RecommendedForYouQueryParameters, bool) {
	if o == nil || o.QueryParameters == nil {
		return nil, false
	}
	return o.QueryParameters, true
}

// HasQueryParameters returns a boolean if a field has been set.
func (o *RecommendedForYouQuery) HasQueryParameters() bool {
	if o != nil && o.QueryParameters != nil {
		return true
	}

	return false
}

// SetQueryParameters gets a reference to the given RecommendedForYouQueryParameters and assigns it to the QueryParameters field.
func (o *RecommendedForYouQuery) SetQueryParameters(v *RecommendedForYouQueryParameters) *RecommendedForYouQuery {
	o.QueryParameters = v
	return o
}

// GetFallbackParameters returns the FallbackParameters field value if set, zero value otherwise.
func (o *RecommendedForYouQuery) GetFallbackParameters() RecommendedForYouQueryParameters {
	if o == nil || o.FallbackParameters == nil {
		var ret RecommendedForYouQueryParameters
		return ret
	}
	return *o.FallbackParameters
}

// GetFallbackParametersOk returns a tuple with the FallbackParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendedForYouQuery) GetFallbackParametersOk() (*RecommendedForYouQueryParameters, bool) {
	if o == nil || o.FallbackParameters == nil {
		return nil, false
	}
	return o.FallbackParameters, true
}

// HasFallbackParameters returns a boolean if a field has been set.
func (o *RecommendedForYouQuery) HasFallbackParameters() bool {
	if o != nil && o.FallbackParameters != nil {
		return true
	}

	return false
}

// SetFallbackParameters gets a reference to the given RecommendedForYouQueryParameters and assigns it to the FallbackParameters field.
func (o *RecommendedForYouQuery) SetFallbackParameters(v *RecommendedForYouQueryParameters) *RecommendedForYouQuery {
	o.FallbackParameters = v
	return o
}

func (o RecommendedForYouQuery) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["indexName"] = o.IndexName
	}
	if o.Threshold != nil {
		toSerialize["threshold"] = o.Threshold
	}
	if o.MaxRecommendations != nil {
		toSerialize["maxRecommendations"] = o.MaxRecommendations
	}
	if true {
		toSerialize["model"] = o.Model
	}
	if o.QueryParameters != nil {
		toSerialize["queryParameters"] = o.QueryParameters
	}
	if o.FallbackParameters != nil {
		toSerialize["fallbackParameters"] = o.FallbackParameters
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RecommendedForYouQuery: %w", err)
	}

	return serialized, nil
}

func (o RecommendedForYouQuery) String() string {
	out := ""
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	out += fmt.Sprintf("  threshold=%v\n", o.Threshold)
	out += fmt.Sprintf("  maxRecommendations=%v\n", o.MaxRecommendations)
	out += fmt.Sprintf("  model=%v\n", o.Model)
	out += fmt.Sprintf("  queryParameters=%v\n", o.QueryParameters)
	out += fmt.Sprintf("  fallbackParameters=%v\n", o.FallbackParameters)
	return fmt.Sprintf("RecommendedForYouQuery {\n%s}", out)
}

type NullableRecommendedForYouQuery struct {
	value *RecommendedForYouQuery
	isSet bool
}

func (v NullableRecommendedForYouQuery) Get() *RecommendedForYouQuery {
	return v.value
}

func (v *NullableRecommendedForYouQuery) Set(val *RecommendedForYouQuery) {
	v.value = val
	v.isSet = true
}

func (v NullableRecommendedForYouQuery) IsSet() bool {
	return v.isSet
}

func (v *NullableRecommendedForYouQuery) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRecommendedForYouQuery(val *RecommendedForYouQuery) *NullableRecommendedForYouQuery {
	return &NullableRecommendedForYouQuery{value: val, isSet: true}
}

func (v NullableRecommendedForYouQuery) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableRecommendedForYouQuery) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
