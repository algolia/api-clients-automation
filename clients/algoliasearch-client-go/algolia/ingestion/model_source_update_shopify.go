// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceUpdateShopify struct for SourceUpdateShopify.
type SourceUpdateShopify struct {
	// Whether to index collection IDs.   If your store has `has_collection_search_page` set to true, collection IDs will be indexed even if `collectionIDIndexing` is false.
	CollectionIDIndexing *bool `json:"collectionIDIndexing,omitempty"`
	// Whether to increase the number of indexed collections per product. If true, Algolia indexes 200 collections per product. If false, 100 collections per product are indexed.
	IncreaseProductCollectionLimit *bool `json:"increaseProductCollectionLimit,omitempty"`
	// Whether to set the default price ratio to 1 if no sale price is present.  The price ratio is determined by the ratio: `sale_price` / `regular_price`. If no sale price is present, the price ratio would be 0. If `defaultPriceRatioAsOne` is true, the price ratio is indexed as 1 instead.
	DefaultPriceRatioAsOne *bool `json:"defaultPriceRatioAsOne,omitempty"`
	// Whether to exclude out-of-stock variants when determining the `max_variant_price` and `min_variant_price` attributes.
	ExcludeOOSVariantsForPriceAtTRS *bool `json:"excludeOOSVariantsForPriceAtTRS,omitempty"`
	// Whether to include an inventory with every variant for every product record.
	IncludeVariantsInventory *bool `json:"includeVariantsInventory,omitempty"`
	// Whether to include collection IDs and handles in the product records.
	HasCollectionSearchPage *bool `json:"hasCollectionSearchPage,omitempty"`
	// Whether to convert tags on products to named tags.  To learn more, see [Named tags](https://www.algolia.com/doc/integration/shopify/sending-and-managing-data/named-tags).
	ProductNamedTags *bool `json:"productNamedTags,omitempty"`
}

type SourceUpdateShopifyOption func(f *SourceUpdateShopify)

func WithSourceUpdateShopifyCollectionIDIndexing(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.CollectionIDIndexing = &val
	}
}

func WithSourceUpdateShopifyIncreaseProductCollectionLimit(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.IncreaseProductCollectionLimit = &val
	}
}

func WithSourceUpdateShopifyDefaultPriceRatioAsOne(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.DefaultPriceRatioAsOne = &val
	}
}

func WithSourceUpdateShopifyExcludeOOSVariantsForPriceAtTRS(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.ExcludeOOSVariantsForPriceAtTRS = &val
	}
}

func WithSourceUpdateShopifyIncludeVariantsInventory(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.IncludeVariantsInventory = &val
	}
}

func WithSourceUpdateShopifyHasCollectionSearchPage(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.HasCollectionSearchPage = &val
	}
}

func WithSourceUpdateShopifyProductNamedTags(val bool) SourceUpdateShopifyOption {
	return func(f *SourceUpdateShopify) {
		f.ProductNamedTags = &val
	}
}

// NewSourceUpdateShopify instantiates a new SourceUpdateShopify object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSourceUpdateShopify(opts ...SourceUpdateShopifyOption) *SourceUpdateShopify {
	this := &SourceUpdateShopify{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySourceUpdateShopify return a pointer to an empty SourceUpdateShopify object.
func NewEmptySourceUpdateShopify() *SourceUpdateShopify {
	return &SourceUpdateShopify{}
}

// GetCollectionIDIndexing returns the CollectionIDIndexing field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetCollectionIDIndexing() bool {
	if o == nil || o.CollectionIDIndexing == nil {
		var ret bool
		return ret
	}
	return *o.CollectionIDIndexing
}

// GetCollectionIDIndexingOk returns a tuple with the CollectionIDIndexing field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetCollectionIDIndexingOk() (*bool, bool) {
	if o == nil || o.CollectionIDIndexing == nil {
		return nil, false
	}
	return o.CollectionIDIndexing, true
}

// HasCollectionIDIndexing returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasCollectionIDIndexing() bool {
	if o != nil && o.CollectionIDIndexing != nil {
		return true
	}

	return false
}

// SetCollectionIDIndexing gets a reference to the given bool and assigns it to the CollectionIDIndexing field.
func (o *SourceUpdateShopify) SetCollectionIDIndexing(v bool) *SourceUpdateShopify {
	o.CollectionIDIndexing = &v
	return o
}

// GetIncreaseProductCollectionLimit returns the IncreaseProductCollectionLimit field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetIncreaseProductCollectionLimit() bool {
	if o == nil || o.IncreaseProductCollectionLimit == nil {
		var ret bool
		return ret
	}
	return *o.IncreaseProductCollectionLimit
}

// GetIncreaseProductCollectionLimitOk returns a tuple with the IncreaseProductCollectionLimit field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetIncreaseProductCollectionLimitOk() (*bool, bool) {
	if o == nil || o.IncreaseProductCollectionLimit == nil {
		return nil, false
	}
	return o.IncreaseProductCollectionLimit, true
}

// HasIncreaseProductCollectionLimit returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasIncreaseProductCollectionLimit() bool {
	if o != nil && o.IncreaseProductCollectionLimit != nil {
		return true
	}

	return false
}

// SetIncreaseProductCollectionLimit gets a reference to the given bool and assigns it to the IncreaseProductCollectionLimit field.
func (o *SourceUpdateShopify) SetIncreaseProductCollectionLimit(v bool) *SourceUpdateShopify {
	o.IncreaseProductCollectionLimit = &v
	return o
}

// GetDefaultPriceRatioAsOne returns the DefaultPriceRatioAsOne field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetDefaultPriceRatioAsOne() bool {
	if o == nil || o.DefaultPriceRatioAsOne == nil {
		var ret bool
		return ret
	}
	return *o.DefaultPriceRatioAsOne
}

// GetDefaultPriceRatioAsOneOk returns a tuple with the DefaultPriceRatioAsOne field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetDefaultPriceRatioAsOneOk() (*bool, bool) {
	if o == nil || o.DefaultPriceRatioAsOne == nil {
		return nil, false
	}
	return o.DefaultPriceRatioAsOne, true
}

// HasDefaultPriceRatioAsOne returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasDefaultPriceRatioAsOne() bool {
	if o != nil && o.DefaultPriceRatioAsOne != nil {
		return true
	}

	return false
}

// SetDefaultPriceRatioAsOne gets a reference to the given bool and assigns it to the DefaultPriceRatioAsOne field.
func (o *SourceUpdateShopify) SetDefaultPriceRatioAsOne(v bool) *SourceUpdateShopify {
	o.DefaultPriceRatioAsOne = &v
	return o
}

// GetExcludeOOSVariantsForPriceAtTRS returns the ExcludeOOSVariantsForPriceAtTRS field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetExcludeOOSVariantsForPriceAtTRS() bool {
	if o == nil || o.ExcludeOOSVariantsForPriceAtTRS == nil {
		var ret bool
		return ret
	}
	return *o.ExcludeOOSVariantsForPriceAtTRS
}

// GetExcludeOOSVariantsForPriceAtTRSOk returns a tuple with the ExcludeOOSVariantsForPriceAtTRS field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetExcludeOOSVariantsForPriceAtTRSOk() (*bool, bool) {
	if o == nil || o.ExcludeOOSVariantsForPriceAtTRS == nil {
		return nil, false
	}
	return o.ExcludeOOSVariantsForPriceAtTRS, true
}

// HasExcludeOOSVariantsForPriceAtTRS returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasExcludeOOSVariantsForPriceAtTRS() bool {
	if o != nil && o.ExcludeOOSVariantsForPriceAtTRS != nil {
		return true
	}

	return false
}

// SetExcludeOOSVariantsForPriceAtTRS gets a reference to the given bool and assigns it to the ExcludeOOSVariantsForPriceAtTRS field.
func (o *SourceUpdateShopify) SetExcludeOOSVariantsForPriceAtTRS(v bool) *SourceUpdateShopify {
	o.ExcludeOOSVariantsForPriceAtTRS = &v
	return o
}

// GetIncludeVariantsInventory returns the IncludeVariantsInventory field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetIncludeVariantsInventory() bool {
	if o == nil || o.IncludeVariantsInventory == nil {
		var ret bool
		return ret
	}
	return *o.IncludeVariantsInventory
}

// GetIncludeVariantsInventoryOk returns a tuple with the IncludeVariantsInventory field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetIncludeVariantsInventoryOk() (*bool, bool) {
	if o == nil || o.IncludeVariantsInventory == nil {
		return nil, false
	}
	return o.IncludeVariantsInventory, true
}

// HasIncludeVariantsInventory returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasIncludeVariantsInventory() bool {
	if o != nil && o.IncludeVariantsInventory != nil {
		return true
	}

	return false
}

// SetIncludeVariantsInventory gets a reference to the given bool and assigns it to the IncludeVariantsInventory field.
func (o *SourceUpdateShopify) SetIncludeVariantsInventory(v bool) *SourceUpdateShopify {
	o.IncludeVariantsInventory = &v
	return o
}

// GetHasCollectionSearchPage returns the HasCollectionSearchPage field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetHasCollectionSearchPage() bool {
	if o == nil || o.HasCollectionSearchPage == nil {
		var ret bool
		return ret
	}
	return *o.HasCollectionSearchPage
}

// GetHasCollectionSearchPageOk returns a tuple with the HasCollectionSearchPage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetHasCollectionSearchPageOk() (*bool, bool) {
	if o == nil || o.HasCollectionSearchPage == nil {
		return nil, false
	}
	return o.HasCollectionSearchPage, true
}

// HasHasCollectionSearchPage returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasHasCollectionSearchPage() bool {
	if o != nil && o.HasCollectionSearchPage != nil {
		return true
	}

	return false
}

// SetHasCollectionSearchPage gets a reference to the given bool and assigns it to the HasCollectionSearchPage field.
func (o *SourceUpdateShopify) SetHasCollectionSearchPage(v bool) *SourceUpdateShopify {
	o.HasCollectionSearchPage = &v
	return o
}

// GetProductNamedTags returns the ProductNamedTags field value if set, zero value otherwise.
func (o *SourceUpdateShopify) GetProductNamedTags() bool {
	if o == nil || o.ProductNamedTags == nil {
		var ret bool
		return ret
	}
	return *o.ProductNamedTags
}

// GetProductNamedTagsOk returns a tuple with the ProductNamedTags field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceUpdateShopify) GetProductNamedTagsOk() (*bool, bool) {
	if o == nil || o.ProductNamedTags == nil {
		return nil, false
	}
	return o.ProductNamedTags, true
}

// HasProductNamedTags returns a boolean if a field has been set.
func (o *SourceUpdateShopify) HasProductNamedTags() bool {
	if o != nil && o.ProductNamedTags != nil {
		return true
	}

	return false
}

// SetProductNamedTags gets a reference to the given bool and assigns it to the ProductNamedTags field.
func (o *SourceUpdateShopify) SetProductNamedTags(v bool) *SourceUpdateShopify {
	o.ProductNamedTags = &v
	return o
}

func (o SourceUpdateShopify) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.CollectionIDIndexing != nil {
		toSerialize["collectionIDIndexing"] = o.CollectionIDIndexing
	}
	if o.IncreaseProductCollectionLimit != nil {
		toSerialize["increaseProductCollectionLimit"] = o.IncreaseProductCollectionLimit
	}
	if o.DefaultPriceRatioAsOne != nil {
		toSerialize["defaultPriceRatioAsOne"] = o.DefaultPriceRatioAsOne
	}
	if o.ExcludeOOSVariantsForPriceAtTRS != nil {
		toSerialize["excludeOOSVariantsForPriceAtTRS"] = o.ExcludeOOSVariantsForPriceAtTRS
	}
	if o.IncludeVariantsInventory != nil {
		toSerialize["includeVariantsInventory"] = o.IncludeVariantsInventory
	}
	if o.HasCollectionSearchPage != nil {
		toSerialize["hasCollectionSearchPage"] = o.HasCollectionSearchPage
	}
	if o.ProductNamedTags != nil {
		toSerialize["productNamedTags"] = o.ProductNamedTags
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SourceUpdateShopify: %w", err)
	}

	return serialized, nil
}

func (o SourceUpdateShopify) String() string {
	out := ""
	out += fmt.Sprintf("  collectionIDIndexing=%v\n", o.CollectionIDIndexing)
	out += fmt.Sprintf("  increaseProductCollectionLimit=%v\n", o.IncreaseProductCollectionLimit)
	out += fmt.Sprintf("  defaultPriceRatioAsOne=%v\n", o.DefaultPriceRatioAsOne)
	out += fmt.Sprintf("  excludeOOSVariantsForPriceAtTRS=%v\n", o.ExcludeOOSVariantsForPriceAtTRS)
	out += fmt.Sprintf("  includeVariantsInventory=%v\n", o.IncludeVariantsInventory)
	out += fmt.Sprintf("  hasCollectionSearchPage=%v\n", o.HasCollectionSearchPage)
	out += fmt.Sprintf("  productNamedTags=%v\n", o.ProductNamedTags)
	return fmt.Sprintf("SourceUpdateShopify {\n%s}", out)
}

type NullableSourceUpdateShopify struct {
	value *SourceUpdateShopify
	isSet bool
}

func (v NullableSourceUpdateShopify) Get() *SourceUpdateShopify {
	return v.value
}

func (v *NullableSourceUpdateShopify) Set(val *SourceUpdateShopify) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceUpdateShopify) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceUpdateShopify) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceUpdateShopify(val *SourceUpdateShopify) *NullableSourceUpdateShopify {
	return &NullableSourceUpdateShopify{value: val, isSet: true}
}

func (v NullableSourceUpdateShopify) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSourceUpdateShopify) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
