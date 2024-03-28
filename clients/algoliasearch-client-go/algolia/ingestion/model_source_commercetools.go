// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceCommercetools struct for SourceCommercetools.
type SourceCommercetools struct {
	StoreKeys []string `json:"storeKeys,omitempty"`
	// Locales for your commercetools stores.
	Locales    []string `json:"locales,omitempty"`
	Url        string   `json:"url"`
	ProjectKey string   `json:"projectKey"`
	// Whether a fallback value is stored in the Algolia record if there's no inventory information about the product.
	FallbackIsInStockValue *bool                      `json:"fallbackIsInStockValue,omitempty"`
	CustomFields           *CommercetoolsCustomFields `json:"customFields,omitempty"`
}

type SourceCommercetoolsOption func(f *SourceCommercetools)

func WithSourceCommercetoolsStoreKeys(val []string) SourceCommercetoolsOption {
	return func(f *SourceCommercetools) {
		f.StoreKeys = val
	}
}

func WithSourceCommercetoolsLocales(val []string) SourceCommercetoolsOption {
	return func(f *SourceCommercetools) {
		f.Locales = val
	}
}

func WithSourceCommercetoolsFallbackIsInStockValue(val bool) SourceCommercetoolsOption {
	return func(f *SourceCommercetools) {
		f.FallbackIsInStockValue = &val
	}
}

func WithSourceCommercetoolsCustomFields(val CommercetoolsCustomFields) SourceCommercetoolsOption {
	return func(f *SourceCommercetools) {
		f.CustomFields = &val
	}
}

// NewSourceCommercetools instantiates a new SourceCommercetools object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSourceCommercetools(url string, projectKey string, opts ...SourceCommercetoolsOption) *SourceCommercetools {
	this := &SourceCommercetools{}
	this.Url = url
	this.ProjectKey = projectKey
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySourceCommercetools return a pointer to an empty SourceCommercetools object.
func NewEmptySourceCommercetools() *SourceCommercetools {
	return &SourceCommercetools{}
}

// GetStoreKeys returns the StoreKeys field value if set, zero value otherwise.
func (o *SourceCommercetools) GetStoreKeys() []string {
	if o == nil || o.StoreKeys == nil {
		var ret []string
		return ret
	}
	return o.StoreKeys
}

// GetStoreKeysOk returns a tuple with the StoreKeys field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetStoreKeysOk() ([]string, bool) {
	if o == nil || o.StoreKeys == nil {
		return nil, false
	}
	return o.StoreKeys, true
}

// HasStoreKeys returns a boolean if a field has been set.
func (o *SourceCommercetools) HasStoreKeys() bool {
	if o != nil && o.StoreKeys != nil {
		return true
	}

	return false
}

// SetStoreKeys gets a reference to the given []string and assigns it to the StoreKeys field.
func (o *SourceCommercetools) SetStoreKeys(v []string) *SourceCommercetools {
	o.StoreKeys = v
	return o
}

// GetLocales returns the Locales field value if set, zero value otherwise.
func (o *SourceCommercetools) GetLocales() []string {
	if o == nil || o.Locales == nil {
		var ret []string
		return ret
	}
	return o.Locales
}

// GetLocalesOk returns a tuple with the Locales field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetLocalesOk() ([]string, bool) {
	if o == nil || o.Locales == nil {
		return nil, false
	}
	return o.Locales, true
}

// HasLocales returns a boolean if a field has been set.
func (o *SourceCommercetools) HasLocales() bool {
	if o != nil && o.Locales != nil {
		return true
	}

	return false
}

// SetLocales gets a reference to the given []string and assigns it to the Locales field.
func (o *SourceCommercetools) SetLocales(v []string) *SourceCommercetools {
	o.Locales = v
	return o
}

// GetUrl returns the Url field value.
func (o *SourceCommercetools) GetUrl() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Url
}

// GetUrlOk returns a tuple with the Url field value
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetUrlOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Url, true
}

// SetUrl sets field value.
func (o *SourceCommercetools) SetUrl(v string) *SourceCommercetools {
	o.Url = v
	return o
}

// GetProjectKey returns the ProjectKey field value.
func (o *SourceCommercetools) GetProjectKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ProjectKey
}

// GetProjectKeyOk returns a tuple with the ProjectKey field value
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetProjectKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ProjectKey, true
}

// SetProjectKey sets field value.
func (o *SourceCommercetools) SetProjectKey(v string) *SourceCommercetools {
	o.ProjectKey = v
	return o
}

// GetFallbackIsInStockValue returns the FallbackIsInStockValue field value if set, zero value otherwise.
func (o *SourceCommercetools) GetFallbackIsInStockValue() bool {
	if o == nil || o.FallbackIsInStockValue == nil {
		var ret bool
		return ret
	}
	return *o.FallbackIsInStockValue
}

// GetFallbackIsInStockValueOk returns a tuple with the FallbackIsInStockValue field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetFallbackIsInStockValueOk() (*bool, bool) {
	if o == nil || o.FallbackIsInStockValue == nil {
		return nil, false
	}
	return o.FallbackIsInStockValue, true
}

// HasFallbackIsInStockValue returns a boolean if a field has been set.
func (o *SourceCommercetools) HasFallbackIsInStockValue() bool {
	if o != nil && o.FallbackIsInStockValue != nil {
		return true
	}

	return false
}

// SetFallbackIsInStockValue gets a reference to the given bool and assigns it to the FallbackIsInStockValue field.
func (o *SourceCommercetools) SetFallbackIsInStockValue(v bool) *SourceCommercetools {
	o.FallbackIsInStockValue = &v
	return o
}

// GetCustomFields returns the CustomFields field value if set, zero value otherwise.
func (o *SourceCommercetools) GetCustomFields() CommercetoolsCustomFields {
	if o == nil || o.CustomFields == nil {
		var ret CommercetoolsCustomFields
		return ret
	}
	return *o.CustomFields
}

// GetCustomFieldsOk returns a tuple with the CustomFields field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCommercetools) GetCustomFieldsOk() (*CommercetoolsCustomFields, bool) {
	if o == nil || o.CustomFields == nil {
		return nil, false
	}
	return o.CustomFields, true
}

// HasCustomFields returns a boolean if a field has been set.
func (o *SourceCommercetools) HasCustomFields() bool {
	if o != nil && o.CustomFields != nil {
		return true
	}

	return false
}

// SetCustomFields gets a reference to the given CommercetoolsCustomFields and assigns it to the CustomFields field.
func (o *SourceCommercetools) SetCustomFields(v *CommercetoolsCustomFields) *SourceCommercetools {
	o.CustomFields = v
	return o
}

func (o SourceCommercetools) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.StoreKeys != nil {
		toSerialize["storeKeys"] = o.StoreKeys
	}
	if o.Locales != nil {
		toSerialize["locales"] = o.Locales
	}
	if true {
		toSerialize["url"] = o.Url
	}
	if true {
		toSerialize["projectKey"] = o.ProjectKey
	}
	if o.FallbackIsInStockValue != nil {
		toSerialize["fallbackIsInStockValue"] = o.FallbackIsInStockValue
	}
	if o.CustomFields != nil {
		toSerialize["customFields"] = o.CustomFields
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SourceCommercetools: %w", err)
	}

	return serialized, nil
}

func (o SourceCommercetools) String() string {
	out := ""
	out += fmt.Sprintf("  storeKeys=%v\n", o.StoreKeys)
	out += fmt.Sprintf("  locales=%v\n", o.Locales)
	out += fmt.Sprintf("  url=%v\n", o.Url)
	out += fmt.Sprintf("  projectKey=%v\n", o.ProjectKey)
	out += fmt.Sprintf("  fallbackIsInStockValue=%v\n", o.FallbackIsInStockValue)
	out += fmt.Sprintf("  customFields=%v\n", o.CustomFields)
	return fmt.Sprintf("SourceCommercetools {\n%s}", out)
}

type NullableSourceCommercetools struct {
	value *SourceCommercetools
	isSet bool
}

func (v NullableSourceCommercetools) Get() *SourceCommercetools {
	return v.value
}

func (v *NullableSourceCommercetools) Set(val *SourceCommercetools) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceCommercetools) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceCommercetools) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceCommercetools(val *SourceCommercetools) *NullableSourceCommercetools {
	return &NullableSourceCommercetools{value: val, isSet: true}
}

func (v NullableSourceCommercetools) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSourceCommercetools) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
