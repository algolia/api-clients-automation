// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// BuiltInOperation Update to perform on the attribute.
type BuiltInOperation struct {
	Operation BuiltInOperationType `json:"_operation"`
	// Value that corresponds to the operation, for example an `Increment` or `Decrement` step, or an `Add` or `Remove` value.
	Value string `json:"value"`
}

// NewBuiltInOperation instantiates a new BuiltInOperation object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBuiltInOperation(operation BuiltInOperationType, value string) *BuiltInOperation {
	this := &BuiltInOperation{}
	this.Operation = operation
	this.Value = value
	return this
}

// NewEmptyBuiltInOperation return a pointer to an empty BuiltInOperation object.
func NewEmptyBuiltInOperation() *BuiltInOperation {
	return &BuiltInOperation{}
}

// GetOperation returns the Operation field value.
func (o *BuiltInOperation) GetOperation() BuiltInOperationType {
	if o == nil {
		var ret BuiltInOperationType
		return ret
	}

	return o.Operation
}

// GetOperationOk returns a tuple with the Operation field value
// and a boolean to check if the value has been set.
func (o *BuiltInOperation) GetOperationOk() (*BuiltInOperationType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Operation, true
}

// SetOperation sets field value.
func (o *BuiltInOperation) SetOperation(v BuiltInOperationType) *BuiltInOperation {
	o.Operation = v
	return o
}

// GetValue returns the Value field value.
func (o *BuiltInOperation) GetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *BuiltInOperation) GetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value.
func (o *BuiltInOperation) SetValue(v string) *BuiltInOperation {
	o.Value = v
	return o
}

func (o BuiltInOperation) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["_operation"] = o.Operation
	}
	if true {
		toSerialize["value"] = o.Value
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal BuiltInOperation: %w", err)
	}

	return serialized, nil
}

func (o BuiltInOperation) String() string {
	out := ""
	out += fmt.Sprintf("  _operation=%v\n", o.Operation)
	out += fmt.Sprintf("  value=%v\n", o.Value)
	return fmt.Sprintf("BuiltInOperation {\n%s}", out)
}

type NullableBuiltInOperation struct {
	value *BuiltInOperation
	isSet bool
}

func (v NullableBuiltInOperation) Get() *BuiltInOperation {
	return v.value
}

func (v *NullableBuiltInOperation) Set(val *BuiltInOperation) {
	v.value = val
	v.isSet = true
}

func (v NullableBuiltInOperation) IsSet() bool {
	return v.isSet
}

func (v *NullableBuiltInOperation) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBuiltInOperation(val *BuiltInOperation) *NullableBuiltInOperation {
	return &NullableBuiltInOperation{value: val, isSet: true}
}

func (v NullableBuiltInOperation) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableBuiltInOperation) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
