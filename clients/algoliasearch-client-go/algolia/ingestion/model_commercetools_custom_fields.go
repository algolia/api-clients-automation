// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// CommercetoolsCustomFields Custom fields from commercetools to add to the records.  For more information, see [Using Custom Types and Custom Fields](https://docs.commercetools.com/tutorials/custom-types).
type CommercetoolsCustomFields struct {
	// Inventory custom fields.
	Inventory []string `json:"inventory,omitempty"`
	// Price custom fields.
	Price []string `json:"price,omitempty"`
	// Category custom fields.
	Category []string `json:"category,omitempty"`
}

type CommercetoolsCustomFieldsOption func(f *CommercetoolsCustomFields)

func WithCommercetoolsCustomFieldsInventory(val []string) CommercetoolsCustomFieldsOption {
	return func(f *CommercetoolsCustomFields) {
		f.Inventory = val
	}
}

func WithCommercetoolsCustomFieldsPrice(val []string) CommercetoolsCustomFieldsOption {
	return func(f *CommercetoolsCustomFields) {
		f.Price = val
	}
}

func WithCommercetoolsCustomFieldsCategory(val []string) CommercetoolsCustomFieldsOption {
	return func(f *CommercetoolsCustomFields) {
		f.Category = val
	}
}

// NewCommercetoolsCustomFields instantiates a new CommercetoolsCustomFields object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewCommercetoolsCustomFields(opts ...CommercetoolsCustomFieldsOption) *CommercetoolsCustomFields {
	this := &CommercetoolsCustomFields{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyCommercetoolsCustomFields return a pointer to an empty CommercetoolsCustomFields object.
func NewEmptyCommercetoolsCustomFields() *CommercetoolsCustomFields {
	return &CommercetoolsCustomFields{}
}

// GetInventory returns the Inventory field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *CommercetoolsCustomFields) GetInventory() []string {
	if o == nil {
		var ret []string
		return ret
	}
	return o.Inventory
}

// GetInventoryOk returns a tuple with the Inventory field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *CommercetoolsCustomFields) GetInventoryOk() ([]string, bool) {
	if o == nil || o.Inventory == nil {
		return nil, false
	}
	return o.Inventory, true
}

// HasInventory returns a boolean if a field has been set.
func (o *CommercetoolsCustomFields) HasInventory() bool {
	if o != nil && o.Inventory != nil {
		return true
	}

	return false
}

// SetInventory gets a reference to the given []string and assigns it to the Inventory field.
func (o *CommercetoolsCustomFields) SetInventory(v []string) *CommercetoolsCustomFields {
	o.Inventory = v
	return o
}

// GetPrice returns the Price field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *CommercetoolsCustomFields) GetPrice() []string {
	if o == nil {
		var ret []string
		return ret
	}
	return o.Price
}

// GetPriceOk returns a tuple with the Price field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *CommercetoolsCustomFields) GetPriceOk() ([]string, bool) {
	if o == nil || o.Price == nil {
		return nil, false
	}
	return o.Price, true
}

// HasPrice returns a boolean if a field has been set.
func (o *CommercetoolsCustomFields) HasPrice() bool {
	if o != nil && o.Price != nil {
		return true
	}

	return false
}

// SetPrice gets a reference to the given []string and assigns it to the Price field.
func (o *CommercetoolsCustomFields) SetPrice(v []string) *CommercetoolsCustomFields {
	o.Price = v
	return o
}

// GetCategory returns the Category field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *CommercetoolsCustomFields) GetCategory() []string {
	if o == nil {
		var ret []string
		return ret
	}
	return o.Category
}

// GetCategoryOk returns a tuple with the Category field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *CommercetoolsCustomFields) GetCategoryOk() ([]string, bool) {
	if o == nil || o.Category == nil {
		return nil, false
	}
	return o.Category, true
}

// HasCategory returns a boolean if a field has been set.
func (o *CommercetoolsCustomFields) HasCategory() bool {
	if o != nil && o.Category != nil {
		return true
	}

	return false
}

// SetCategory gets a reference to the given []string and assigns it to the Category field.
func (o *CommercetoolsCustomFields) SetCategory(v []string) *CommercetoolsCustomFields {
	o.Category = v
	return o
}

func (o CommercetoolsCustomFields) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Inventory != nil {
		toSerialize["inventory"] = o.Inventory
	}
	if o.Price != nil {
		toSerialize["price"] = o.Price
	}
	if o.Category != nil {
		toSerialize["category"] = o.Category
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal CommercetoolsCustomFields: %w", err)
	}

	return serialized, nil
}

func (o CommercetoolsCustomFields) String() string {
	out := ""
	out += fmt.Sprintf("  inventory=%v\n", o.Inventory)
	out += fmt.Sprintf("  price=%v\n", o.Price)
	out += fmt.Sprintf("  category=%v\n", o.Category)
	return fmt.Sprintf("CommercetoolsCustomFields {\n%s}", out)
}
