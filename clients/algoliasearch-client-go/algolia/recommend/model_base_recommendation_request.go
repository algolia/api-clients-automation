// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// BaseRecommendationRequest struct for BaseRecommendationRequest
type BaseRecommendationRequest struct {
	Model RecommendationModels `json:"model" validate:"required"`
	// Unique identifier of the object.
	ObjectID string `json:"objectID" validate:"required"`
}

// NewBaseRecommendationRequest instantiates a new BaseRecommendationRequest object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBaseRecommendationRequest(model RecommendationModels, objectID string) *BaseRecommendationRequest {
	this := &BaseRecommendationRequest{}
	this.Model = model
	this.ObjectID = objectID
	return this
}

// NewBaseRecommendationRequestWithDefaults instantiates a new BaseRecommendationRequest object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBaseRecommendationRequestWithDefaults() *BaseRecommendationRequest {
	this := &BaseRecommendationRequest{}
	return this
}

// GetModel returns the Model field value
func (o *BaseRecommendationRequest) GetModel() RecommendationModels {
	if o == nil {
		var ret RecommendationModels
		return ret
	}

	return o.Model
}

// GetModelOk returns a tuple with the Model field value
// and a boolean to check if the value has been set.
func (o *BaseRecommendationRequest) GetModelOk() (*RecommendationModels, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Model, true
}

// SetModel sets field value
func (o *BaseRecommendationRequest) SetModel(v RecommendationModels) {
	o.Model = v
}

// GetObjectID returns the ObjectID field value
func (o *BaseRecommendationRequest) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *BaseRecommendationRequest) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value
func (o *BaseRecommendationRequest) SetObjectID(v string) {
	o.ObjectID = v
}

func (o BaseRecommendationRequest) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["model"] = o.Model
	}
	if true {
		toSerialize["objectID"] = o.ObjectID
	}
	return json.Marshal(toSerialize)
}

func (o BaseRecommendationRequest) String() string {
	out := ""
	out += fmt.Sprintf("  model=%v\n", o.Model)
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	return fmt.Sprintf("BaseRecommendationRequest {\n%s}", out)
}

type NullableBaseRecommendationRequest struct {
	value *BaseRecommendationRequest
	isSet bool
}

func (v NullableBaseRecommendationRequest) Get() *BaseRecommendationRequest {
	return v.value
}

func (v *NullableBaseRecommendationRequest) Set(val *BaseRecommendationRequest) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseRecommendationRequest) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseRecommendationRequest) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseRecommendationRequest(val *BaseRecommendationRequest) *NullableBaseRecommendationRequest {
	return &NullableBaseRecommendationRequest{value: val, isSet: true}
}

func (v NullableBaseRecommendationRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBaseRecommendationRequest) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
