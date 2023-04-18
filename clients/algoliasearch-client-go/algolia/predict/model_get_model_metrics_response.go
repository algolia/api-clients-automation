// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package predict

import (
	"encoding/json"
	"fmt"
)

// GetModelMetricsResponse struct for GetModelMetricsResponse
type GetModelMetricsResponse struct {
	// The ID of the model.
	ModelID string         `json:"modelID"`
	Metrics []ModelMetrics `json:"metrics"`
}

// NewGetModelMetricsResponse instantiates a new GetModelMetricsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewGetModelMetricsResponse(modelID string, metrics []ModelMetrics) *GetModelMetricsResponse {
	this := &GetModelMetricsResponse{}
	this.ModelID = modelID
	this.Metrics = metrics
	return this
}

// NewGetModelMetricsResponseWithDefaults instantiates a new GetModelMetricsResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewGetModelMetricsResponseWithDefaults() *GetModelMetricsResponse {
	this := &GetModelMetricsResponse{}
	return this
}

// GetModelID returns the ModelID field value
func (o *GetModelMetricsResponse) GetModelID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ModelID
}

// GetModelIDOk returns a tuple with the ModelID field value
// and a boolean to check if the value has been set.
func (o *GetModelMetricsResponse) GetModelIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ModelID, true
}

// SetModelID sets field value
func (o *GetModelMetricsResponse) SetModelID(v string) {
	o.ModelID = v
}

// GetMetrics returns the Metrics field value
func (o *GetModelMetricsResponse) GetMetrics() []ModelMetrics {
	if o == nil {
		var ret []ModelMetrics
		return ret
	}

	return o.Metrics
}

// GetMetricsOk returns a tuple with the Metrics field value
// and a boolean to check if the value has been set.
func (o *GetModelMetricsResponse) GetMetricsOk() ([]ModelMetrics, bool) {
	if o == nil {
		return nil, false
	}
	return o.Metrics, true
}

// SetMetrics sets field value
func (o *GetModelMetricsResponse) SetMetrics(v []ModelMetrics) {
	o.Metrics = v
}

func (o GetModelMetricsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["modelID"] = o.ModelID
	}
	if true {
		toSerialize["metrics"] = o.Metrics
	}
	return json.Marshal(toSerialize)
}

func (o GetModelMetricsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  modelID=%v\n", o.ModelID)
	out += fmt.Sprintf("  metrics=%v\n", o.Metrics)
	return fmt.Sprintf("GetModelMetricsResponse {\n%s}", out)
}

type NullableGetModelMetricsResponse struct {
	value *GetModelMetricsResponse
	isSet bool
}

func (v NullableGetModelMetricsResponse) Get() *GetModelMetricsResponse {
	return v.value
}

func (v *NullableGetModelMetricsResponse) Set(val *GetModelMetricsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetModelMetricsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetModelMetricsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetModelMetricsResponse(val *GetModelMetricsResponse) *NullableGetModelMetricsResponse {
	return &NullableGetModelMetricsResponse{value: val, isSet: true}
}

func (v NullableGetModelMetricsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableGetModelMetricsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
