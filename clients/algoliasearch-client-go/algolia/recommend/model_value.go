// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// Value struct for Value.
type Value struct {
	// Explicit order of facets or facet values.  This setting lets you always show specific facets or facet values at the top of the list.
	Order           []string         `json:"order,omitempty"`
	SortRemainingBy *SortRemainingBy `json:"sortRemainingBy,omitempty"`
}

type ValueOption func(f *Value)

func WithValueOrder(val []string) ValueOption {
	return func(f *Value) {
		f.Order = val
	}
}

func WithValueSortRemainingBy(val SortRemainingBy) ValueOption {
	return func(f *Value) {
		f.SortRemainingBy = &val
	}
}

// NewValue instantiates a new Value object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewValue(opts ...ValueOption) *Value {
	this := &Value{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyValue return a pointer to an empty Value object.
func NewEmptyValue() *Value {
	return &Value{}
}

// GetOrder returns the Order field value if set, zero value otherwise.
func (o *Value) GetOrder() []string {
	if o == nil || o.Order == nil {
		var ret []string
		return ret
	}
	return o.Order
}

// GetOrderOk returns a tuple with the Order field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Value) GetOrderOk() ([]string, bool) {
	if o == nil || o.Order == nil {
		return nil, false
	}
	return o.Order, true
}

// HasOrder returns a boolean if a field has been set.
func (o *Value) HasOrder() bool {
	if o != nil && o.Order != nil {
		return true
	}

	return false
}

// SetOrder gets a reference to the given []string and assigns it to the Order field.
func (o *Value) SetOrder(v []string) *Value {
	o.Order = v
	return o
}

// GetSortRemainingBy returns the SortRemainingBy field value if set, zero value otherwise.
func (o *Value) GetSortRemainingBy() SortRemainingBy {
	if o == nil || o.SortRemainingBy == nil {
		var ret SortRemainingBy
		return ret
	}
	return *o.SortRemainingBy
}

// GetSortRemainingByOk returns a tuple with the SortRemainingBy field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Value) GetSortRemainingByOk() (*SortRemainingBy, bool) {
	if o == nil || o.SortRemainingBy == nil {
		return nil, false
	}
	return o.SortRemainingBy, true
}

// HasSortRemainingBy returns a boolean if a field has been set.
func (o *Value) HasSortRemainingBy() bool {
	if o != nil && o.SortRemainingBy != nil {
		return true
	}

	return false
}

// SetSortRemainingBy gets a reference to the given SortRemainingBy and assigns it to the SortRemainingBy field.
func (o *Value) SetSortRemainingBy(v SortRemainingBy) *Value {
	o.SortRemainingBy = &v
	return o
}

func (o Value) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Order != nil {
		toSerialize["order"] = o.Order
	}
	if o.SortRemainingBy != nil {
		toSerialize["sortRemainingBy"] = o.SortRemainingBy
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Value: %w", err)
	}

	return serialized, nil
}

func (o Value) String() string {
	out := ""
	out += fmt.Sprintf("  order=%v\n", o.Order)
	out += fmt.Sprintf("  sortRemainingBy=%v\n", o.SortRemainingBy)
	return fmt.Sprintf("Value {\n%s}", out)
}
