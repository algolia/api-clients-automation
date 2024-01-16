// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// BigCommerceMetafield struct for BigCommerceMetafield.
type BigCommerceMetafield struct {
	// The namespace of the metafield.
	Namespace string `json:"namespace"`
	// The key identifier of the metafield.
	Key string `json:"key"`
}

// NewBigCommerceMetafield instantiates a new BigCommerceMetafield object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBigCommerceMetafield(namespace string, key string) *BigCommerceMetafield {
	this := &BigCommerceMetafield{}
	this.Namespace = namespace
	this.Key = key
	return this
}

// NewEmptyBigCommerceMetafield return a pointer to an empty BigCommerceMetafield object.
func NewEmptyBigCommerceMetafield() *BigCommerceMetafield {
	return &BigCommerceMetafield{}
}

// GetNamespace returns the Namespace field value.
func (o *BigCommerceMetafield) GetNamespace() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Namespace
}

// GetNamespaceOk returns a tuple with the Namespace field value
// and a boolean to check if the value has been set.
func (o *BigCommerceMetafield) GetNamespaceOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Namespace, true
}

// SetNamespace sets field value.
func (o *BigCommerceMetafield) SetNamespace(v string) *BigCommerceMetafield {
	o.Namespace = v
	return o
}

// GetKey returns the Key field value.
func (o *BigCommerceMetafield) GetKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Key
}

// GetKeyOk returns a tuple with the Key field value
// and a boolean to check if the value has been set.
func (o *BigCommerceMetafield) GetKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Key, true
}

// SetKey sets field value.
func (o *BigCommerceMetafield) SetKey(v string) *BigCommerceMetafield {
	o.Key = v
	return o
}

func (o BigCommerceMetafield) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["namespace"] = o.Namespace
	}
	if true {
		toSerialize["key"] = o.Key
	}
	return json.Marshal(toSerialize)
}

func (o BigCommerceMetafield) String() string {
	out := ""
	out += fmt.Sprintf("  namespace=%v\n", o.Namespace)
	out += fmt.Sprintf("  key=%v\n", o.Key)
	return fmt.Sprintf("BigCommerceMetafield {\n%s}", out)
}

type NullableBigCommerceMetafield struct {
	value *BigCommerceMetafield
	isSet bool
}

func (v NullableBigCommerceMetafield) Get() *BigCommerceMetafield {
	return v.value
}

func (v *NullableBigCommerceMetafield) Set(val *BigCommerceMetafield) {
	v.value = val
	v.isSet = true
}

func (v NullableBigCommerceMetafield) IsSet() bool {
	return v.isSet
}

func (v *NullableBigCommerceMetafield) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBigCommerceMetafield(val *BigCommerceMetafield) *NullableBigCommerceMetafield {
	return &NullableBigCommerceMetafield{value: val, isSet: true}
}

func (v NullableBigCommerceMetafield) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBigCommerceMetafield) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
