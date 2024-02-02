// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package analytics

import (
	"encoding/json"
	"fmt"
)

// GetClickPositionsResponse struct for GetClickPositionsResponse.
type GetClickPositionsResponse struct {
	// Click positions.
	Positions []ClickPosition `json:"positions"`
}

// NewGetClickPositionsResponse instantiates a new GetClickPositionsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetClickPositionsResponse(positions []ClickPosition) *GetClickPositionsResponse {
	this := &GetClickPositionsResponse{}
	this.Positions = positions
	return this
}

// NewEmptyGetClickPositionsResponse return a pointer to an empty GetClickPositionsResponse object.
func NewEmptyGetClickPositionsResponse() *GetClickPositionsResponse {
	return &GetClickPositionsResponse{}
}

// GetPositions returns the Positions field value.
func (o *GetClickPositionsResponse) GetPositions() []ClickPosition {
	if o == nil {
		var ret []ClickPosition
		return ret
	}

	return o.Positions
}

// GetPositionsOk returns a tuple with the Positions field value
// and a boolean to check if the value has been set.
func (o *GetClickPositionsResponse) GetPositionsOk() ([]ClickPosition, bool) {
	if o == nil {
		return nil, false
	}
	return o.Positions, true
}

// SetPositions sets field value.
func (o *GetClickPositionsResponse) SetPositions(v []ClickPosition) *GetClickPositionsResponse {
	o.Positions = v
	return o
}

func (o GetClickPositionsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["positions"] = o.Positions
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetClickPositionsResponse: %w", err)
	}

	return serialized, nil
}

func (o GetClickPositionsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  positions=%v\n", o.Positions)
	return fmt.Sprintf("GetClickPositionsResponse {\n%s}", out)
}

type NullableGetClickPositionsResponse struct {
	value *GetClickPositionsResponse
	isSet bool
}

func (v NullableGetClickPositionsResponse) Get() *GetClickPositionsResponse {
	return v.value
}

func (v *NullableGetClickPositionsResponse) Set(val *GetClickPositionsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableGetClickPositionsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableGetClickPositionsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetClickPositionsResponse(val *GetClickPositionsResponse) *NullableGetClickPositionsResponse {
	return &NullableGetClickPositionsResponse{value: val, isSet: true}
}

func (v NullableGetClickPositionsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableGetClickPositionsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
