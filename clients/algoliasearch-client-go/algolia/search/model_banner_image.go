// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// BannerImage Image to show inside a banner.
type BannerImage struct {
	Urls  []BannerImageUrl `json:"urls,omitempty"`
	Title *string          `json:"title,omitempty"`
}

type BannerImageOption func(f *BannerImage)

func WithBannerImageUrls(val []BannerImageUrl) BannerImageOption {
	return func(f *BannerImage) {
		f.Urls = val
	}
}

func WithBannerImageTitle(val string) BannerImageOption {
	return func(f *BannerImage) {
		f.Title = &val
	}
}

// NewBannerImage instantiates a new BannerImage object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewBannerImage(opts ...BannerImageOption) *BannerImage {
	this := &BannerImage{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyBannerImage return a pointer to an empty BannerImage object.
func NewEmptyBannerImage() *BannerImage {
	return &BannerImage{}
}

// GetUrls returns the Urls field value if set, zero value otherwise.
func (o *BannerImage) GetUrls() []BannerImageUrl {
	if o == nil || o.Urls == nil {
		var ret []BannerImageUrl
		return ret
	}
	return o.Urls
}

// GetUrlsOk returns a tuple with the Urls field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BannerImage) GetUrlsOk() ([]BannerImageUrl, bool) {
	if o == nil || o.Urls == nil {
		return nil, false
	}
	return o.Urls, true
}

// HasUrls returns a boolean if a field has been set.
func (o *BannerImage) HasUrls() bool {
	if o != nil && o.Urls != nil {
		return true
	}

	return false
}

// SetUrls gets a reference to the given []BannerImageUrl and assigns it to the Urls field.
func (o *BannerImage) SetUrls(v []BannerImageUrl) *BannerImage {
	o.Urls = v
	return o
}

// GetTitle returns the Title field value if set, zero value otherwise.
func (o *BannerImage) GetTitle() string {
	if o == nil || o.Title == nil {
		var ret string
		return ret
	}
	return *o.Title
}

// GetTitleOk returns a tuple with the Title field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BannerImage) GetTitleOk() (*string, bool) {
	if o == nil || o.Title == nil {
		return nil, false
	}
	return o.Title, true
}

// HasTitle returns a boolean if a field has been set.
func (o *BannerImage) HasTitle() bool {
	if o != nil && o.Title != nil {
		return true
	}

	return false
}

// SetTitle gets a reference to the given string and assigns it to the Title field.
func (o *BannerImage) SetTitle(v string) *BannerImage {
	o.Title = &v
	return o
}

func (o BannerImage) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Urls != nil {
		toSerialize["urls"] = o.Urls
	}
	if o.Title != nil {
		toSerialize["title"] = o.Title
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal BannerImage: %w", err)
	}

	return serialized, nil
}

func (o BannerImage) String() string {
	out := ""
	out += fmt.Sprintf("  urls=%v\n", o.Urls)
	out += fmt.Sprintf("  title=%v\n", o.Title)
	return fmt.Sprintf("BannerImage {\n%s}", out)
}
