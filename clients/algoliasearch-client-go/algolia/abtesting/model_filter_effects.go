// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package abtesting

import (
	"encoding/json"
	"fmt"
)

// FilterEffects A/B test filter effects resulting from configuration settings.
type FilterEffects struct {
	Outliers    *OutliersFilter    `json:"outliers,omitempty"`
	EmptySearch *EmptySearchFilter `json:"emptySearch,omitempty"`
}

type FilterEffectsOption func(f *FilterEffects)

func WithFilterEffectsOutliers(val OutliersFilter) FilterEffectsOption {
	return func(f *FilterEffects) {
		f.Outliers = &val
	}
}

func WithFilterEffectsEmptySearch(val EmptySearchFilter) FilterEffectsOption {
	return func(f *FilterEffects) {
		f.EmptySearch = &val
	}
}

// NewFilterEffects instantiates a new FilterEffects object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewFilterEffects(opts ...FilterEffectsOption) *FilterEffects {
	this := &FilterEffects{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyFilterEffects return a pointer to an empty FilterEffects object.
func NewEmptyFilterEffects() *FilterEffects {
	return &FilterEffects{}
}

// GetOutliers returns the Outliers field value if set, zero value otherwise.
func (o *FilterEffects) GetOutliers() OutliersFilter {
	if o == nil || o.Outliers == nil {
		var ret OutliersFilter
		return ret
	}
	return *o.Outliers
}

// GetOutliersOk returns a tuple with the Outliers field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FilterEffects) GetOutliersOk() (*OutliersFilter, bool) {
	if o == nil || o.Outliers == nil {
		return nil, false
	}
	return o.Outliers, true
}

// HasOutliers returns a boolean if a field has been set.
func (o *FilterEffects) HasOutliers() bool {
	if o != nil && o.Outliers != nil {
		return true
	}

	return false
}

// SetOutliers gets a reference to the given OutliersFilter and assigns it to the Outliers field.
func (o *FilterEffects) SetOutliers(v *OutliersFilter) *FilterEffects {
	o.Outliers = v
	return o
}

// GetEmptySearch returns the EmptySearch field value if set, zero value otherwise.
func (o *FilterEffects) GetEmptySearch() EmptySearchFilter {
	if o == nil || o.EmptySearch == nil {
		var ret EmptySearchFilter
		return ret
	}
	return *o.EmptySearch
}

// GetEmptySearchOk returns a tuple with the EmptySearch field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FilterEffects) GetEmptySearchOk() (*EmptySearchFilter, bool) {
	if o == nil || o.EmptySearch == nil {
		return nil, false
	}
	return o.EmptySearch, true
}

// HasEmptySearch returns a boolean if a field has been set.
func (o *FilterEffects) HasEmptySearch() bool {
	if o != nil && o.EmptySearch != nil {
		return true
	}

	return false
}

// SetEmptySearch gets a reference to the given EmptySearchFilter and assigns it to the EmptySearch field.
func (o *FilterEffects) SetEmptySearch(v *EmptySearchFilter) *FilterEffects {
	o.EmptySearch = v
	return o
}

func (o FilterEffects) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Outliers != nil {
		toSerialize["outliers"] = o.Outliers
	}
	if o.EmptySearch != nil {
		toSerialize["emptySearch"] = o.EmptySearch
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal FilterEffects: %w", err)
	}

	return serialized, nil
}

func (o FilterEffects) String() string {
	out := ""
	out += fmt.Sprintf("  outliers=%v\n", o.Outliers)
	out += fmt.Sprintf("  emptySearch=%v\n", o.EmptySearch)
	return fmt.Sprintf("FilterEffects {\n%s}", out)
}
