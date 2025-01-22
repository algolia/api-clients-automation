// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// Widgets Widgets returned from any rules that are applied to the current search.
type Widgets struct {
	// Banners defined in the Merchandising Studio for a given search.
	Banners []Banner `json:"banners,omitempty"`
}

type WidgetsOption func(f *Widgets)

func WithWidgetsBanners(val []Banner) WidgetsOption {
	return func(f *Widgets) {
		f.Banners = val
	}
}

// NewWidgets instantiates a new Widgets object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewWidgets(opts ...WidgetsOption) *Widgets {
	this := &Widgets{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyWidgets return a pointer to an empty Widgets object.
func NewEmptyWidgets() *Widgets {
	return &Widgets{}
}

// GetBanners returns the Banners field value if set, zero value otherwise.
func (o *Widgets) GetBanners() []Banner {
	if o == nil || o.Banners == nil {
		var ret []Banner
		return ret
	}
	return o.Banners
}

// GetBannersOk returns a tuple with the Banners field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Widgets) GetBannersOk() ([]Banner, bool) {
	if o == nil || o.Banners == nil {
		return nil, false
	}
	return o.Banners, true
}

// HasBanners returns a boolean if a field has been set.
func (o *Widgets) HasBanners() bool {
	if o != nil && o.Banners != nil {
		return true
	}

	return false
}

// SetBanners gets a reference to the given []Banner and assigns it to the Banners field.
func (o *Widgets) SetBanners(v []Banner) *Widgets {
	o.Banners = v
	return o
}

func (o Widgets) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Banners != nil {
		toSerialize["banners"] = o.Banners
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Widgets: %w", err)
	}

	return serialized, nil
}

func (o Widgets) String() string {
	out := ""
	out += fmt.Sprintf("  banners=%v\n", o.Banners)
	return fmt.Sprintf("Widgets {\n%s}", out)
}
