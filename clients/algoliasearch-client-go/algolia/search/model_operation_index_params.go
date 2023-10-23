// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// OperationIndexParams struct for OperationIndexParams
type OperationIndexParams struct {
	Operation OperationType `json:"operation"`
	// Algolia index name.
	Destination string `json:"destination"`
	// **This only applies to the _copy_ operation.**  If you omit `scope`, the copy command copies all records, settings, synonyms, and rules.  If you specify `scope`, only the specified scopes are copied.
	Scope []ScopeType `json:"scope,omitempty"`
}

type OperationIndexParamsOption func(f *OperationIndexParams)

func WithOperationIndexParamsScope(val []ScopeType) OperationIndexParamsOption {
	return func(f *OperationIndexParams) {
		f.Scope = val
	}
}

// NewOperationIndexParams instantiates a new OperationIndexParams object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewOperationIndexParams(operation OperationType, destination string, opts ...OperationIndexParamsOption) *OperationIndexParams {
	this := &OperationIndexParams{}
	this.Operation = operation
	this.Destination = destination
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewOperationIndexParamsWithDefaults instantiates a new OperationIndexParams object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewOperationIndexParamsWithDefaults() *OperationIndexParams {
	this := &OperationIndexParams{}
	return this
}

// GetOperation returns the Operation field value
func (o *OperationIndexParams) GetOperation() OperationType {
	if o == nil {
		var ret OperationType
		return ret
	}

	return o.Operation
}

// GetOperationOk returns a tuple with the Operation field value
// and a boolean to check if the value has been set.
func (o *OperationIndexParams) GetOperationOk() (*OperationType, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Operation, true
}

// SetOperation sets field value
func (o *OperationIndexParams) SetOperation(v OperationType) {
	o.Operation = v
}

// GetDestination returns the Destination field value
func (o *OperationIndexParams) GetDestination() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Destination
}

// GetDestinationOk returns a tuple with the Destination field value
// and a boolean to check if the value has been set.
func (o *OperationIndexParams) GetDestinationOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Destination, true
}

// SetDestination sets field value
func (o *OperationIndexParams) SetDestination(v string) {
	o.Destination = v
}

// GetScope returns the Scope field value if set, zero value otherwise.
func (o *OperationIndexParams) GetScope() []ScopeType {
	if o == nil || o.Scope == nil {
		var ret []ScopeType
		return ret
	}
	return o.Scope
}

// GetScopeOk returns a tuple with the Scope field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *OperationIndexParams) GetScopeOk() ([]ScopeType, bool) {
	if o == nil || o.Scope == nil {
		return nil, false
	}
	return o.Scope, true
}

// HasScope returns a boolean if a field has been set.
func (o *OperationIndexParams) HasScope() bool {
	if o != nil && o.Scope != nil {
		return true
	}

	return false
}

// SetScope gets a reference to the given []ScopeType and assigns it to the Scope field.
func (o *OperationIndexParams) SetScope(v []ScopeType) {
	o.Scope = v
}

func (o OperationIndexParams) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["operation"] = o.Operation
	}
	if true {
		toSerialize["destination"] = o.Destination
	}
	if o.Scope != nil {
		toSerialize["scope"] = o.Scope
	}
	return json.Marshal(toSerialize)
}

func (o OperationIndexParams) String() string {
	out := ""
	out += fmt.Sprintf("  operation=%v\n", o.Operation)
	out += fmt.Sprintf("  destination=%v\n", o.Destination)
	out += fmt.Sprintf("  scope=%v\n", o.Scope)
	return fmt.Sprintf("OperationIndexParams {\n%s}", out)
}

type NullableOperationIndexParams struct {
	value *OperationIndexParams
	isSet bool
}

func (v NullableOperationIndexParams) Get() *OperationIndexParams {
	return v.value
}

func (v *NullableOperationIndexParams) Set(val *OperationIndexParams) {
	v.value = val
	v.isSet = true
}

func (v NullableOperationIndexParams) IsSet() bool {
	return v.isSet
}

func (v *NullableOperationIndexParams) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableOperationIndexParams(val *OperationIndexParams) *NullableOperationIndexParams {
	return &NullableOperationIndexParams{value: val, isSet: true}
}

func (v NullableOperationIndexParams) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableOperationIndexParams) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
