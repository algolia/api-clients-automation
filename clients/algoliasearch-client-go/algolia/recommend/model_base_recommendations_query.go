// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// BaseRecommendationsQuery struct for BaseRecommendationsQuery.
type BaseRecommendationsQuery struct {
	Model RecommendationModels `json:"model"`
	// Unique record identifier.
	ObjectID           string              `json:"objectID"`
	QueryParameters    *SearchParamsObject `json:"queryParameters,omitempty"`
	FallbackParameters *SearchParamsObject `json:"fallbackParameters,omitempty"`
}

type BaseRecommendationsQueryOption func(f *BaseRecommendationsQuery)

func WithBaseRecommendationsQueryQueryParameters(val SearchParamsObject) BaseRecommendationsQueryOption {
	return func(f *BaseRecommendationsQuery) {
		f.QueryParameters = &val
	}
}

func WithBaseRecommendationsQueryFallbackParameters(val SearchParamsObject) BaseRecommendationsQueryOption {
	return func(f *BaseRecommendationsQuery) {
		f.FallbackParameters = &val
	}
}

// NewBaseRecommendationsQuery instantiates a new BaseRecommendationsQuery object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBaseRecommendationsQuery(model RecommendationModels, objectID string, opts ...BaseRecommendationsQueryOption) *BaseRecommendationsQuery {
	this := &BaseRecommendationsQuery{}
	this.Model = model
	this.ObjectID = objectID
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyBaseRecommendationsQuery return a pointer to an empty BaseRecommendationsQuery object.
func NewEmptyBaseRecommendationsQuery() *BaseRecommendationsQuery {
	return &BaseRecommendationsQuery{}
}

// GetModel returns the Model field value.
func (o *BaseRecommendationsQuery) GetModel() RecommendationModels {
	if o == nil {
		var ret RecommendationModels
		return ret
	}

	return o.Model
}

// GetModelOk returns a tuple with the Model field value
// and a boolean to check if the value has been set.
func (o *BaseRecommendationsQuery) GetModelOk() (*RecommendationModels, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Model, true
}

// SetModel sets field value.
func (o *BaseRecommendationsQuery) SetModel(v RecommendationModels) *BaseRecommendationsQuery {
	o.Model = v
	return o
}

// GetObjectID returns the ObjectID field value.
func (o *BaseRecommendationsQuery) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *BaseRecommendationsQuery) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value.
func (o *BaseRecommendationsQuery) SetObjectID(v string) *BaseRecommendationsQuery {
	o.ObjectID = v
	return o
}

// GetQueryParameters returns the QueryParameters field value if set, zero value otherwise.
func (o *BaseRecommendationsQuery) GetQueryParameters() SearchParamsObject {
	if o == nil || o.QueryParameters == nil {
		var ret SearchParamsObject
		return ret
	}
	return *o.QueryParameters
}

// GetQueryParametersOk returns a tuple with the QueryParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseRecommendationsQuery) GetQueryParametersOk() (*SearchParamsObject, bool) {
	if o == nil || o.QueryParameters == nil {
		return nil, false
	}
	return o.QueryParameters, true
}

// HasQueryParameters returns a boolean if a field has been set.
func (o *BaseRecommendationsQuery) HasQueryParameters() bool {
	if o != nil && o.QueryParameters != nil {
		return true
	}

	return false
}

// SetQueryParameters gets a reference to the given SearchParamsObject and assigns it to the QueryParameters field.
func (o *BaseRecommendationsQuery) SetQueryParameters(v *SearchParamsObject) *BaseRecommendationsQuery {
	o.QueryParameters = v
	return o
}

// GetFallbackParameters returns the FallbackParameters field value if set, zero value otherwise.
func (o *BaseRecommendationsQuery) GetFallbackParameters() SearchParamsObject {
	if o == nil || o.FallbackParameters == nil {
		var ret SearchParamsObject
		return ret
	}
	return *o.FallbackParameters
}

// GetFallbackParametersOk returns a tuple with the FallbackParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseRecommendationsQuery) GetFallbackParametersOk() (*SearchParamsObject, bool) {
	if o == nil || o.FallbackParameters == nil {
		return nil, false
	}
	return o.FallbackParameters, true
}

// HasFallbackParameters returns a boolean if a field has been set.
func (o *BaseRecommendationsQuery) HasFallbackParameters() bool {
	if o != nil && o.FallbackParameters != nil {
		return true
	}

	return false
}

// SetFallbackParameters gets a reference to the given SearchParamsObject and assigns it to the FallbackParameters field.
func (o *BaseRecommendationsQuery) SetFallbackParameters(v *SearchParamsObject) *BaseRecommendationsQuery {
	o.FallbackParameters = v
	return o
}

func (o BaseRecommendationsQuery) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["model"] = o.Model
	}
	if true {
		toSerialize["objectID"] = o.ObjectID
	}
	if o.QueryParameters != nil {
		toSerialize["queryParameters"] = o.QueryParameters
	}
	if o.FallbackParameters != nil {
		toSerialize["fallbackParameters"] = o.FallbackParameters
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal BaseRecommendationsQuery: %w", err)
	}

	return serialized, nil
}

func (o BaseRecommendationsQuery) String() string {
	out := ""
	out += fmt.Sprintf("  model=%v\n", o.Model)
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  queryParameters=%v\n", o.QueryParameters)
	out += fmt.Sprintf("  fallbackParameters=%v\n", o.FallbackParameters)
	return fmt.Sprintf("BaseRecommendationsQuery {\n%s}", out)
}

type NullableBaseRecommendationsQuery struct {
	value *BaseRecommendationsQuery
	isSet bool
}

func (v NullableBaseRecommendationsQuery) Get() *BaseRecommendationsQuery {
	return v.value
}

func (v *NullableBaseRecommendationsQuery) Set(val *BaseRecommendationsQuery) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseRecommendationsQuery) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseRecommendationsQuery) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseRecommendationsQuery(val *BaseRecommendationsQuery) *NullableBaseRecommendationsQuery {
	return &NullableBaseRecommendationsQuery{value: val, isSet: true}
}

func (v NullableBaseRecommendationsQuery) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableBaseRecommendationsQuery) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
