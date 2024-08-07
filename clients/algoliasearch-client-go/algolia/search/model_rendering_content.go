// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// RenderingContent Extra data that can be used in the search UI.  You can use this to control aspects of your search UI, such as, the order of facet names and values without changing your frontend code.
type RenderingContent struct {
	FacetOrdering *FacetOrdering `json:"facetOrdering,omitempty"`
	Redirect      *RedirectURL   `json:"redirect,omitempty"`
}

type RenderingContentOption func(f *RenderingContent)

func WithRenderingContentFacetOrdering(val FacetOrdering) RenderingContentOption {
	return func(f *RenderingContent) {
		f.FacetOrdering = &val
	}
}

func WithRenderingContentRedirect(val RedirectURL) RenderingContentOption {
	return func(f *RenderingContent) {
		f.Redirect = &val
	}
}

// NewRenderingContent instantiates a new RenderingContent object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRenderingContent(opts ...RenderingContentOption) *RenderingContent {
	this := &RenderingContent{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyRenderingContent return a pointer to an empty RenderingContent object.
func NewEmptyRenderingContent() *RenderingContent {
	return &RenderingContent{}
}

// GetFacetOrdering returns the FacetOrdering field value if set, zero value otherwise.
func (o *RenderingContent) GetFacetOrdering() FacetOrdering {
	if o == nil || o.FacetOrdering == nil {
		var ret FacetOrdering
		return ret
	}
	return *o.FacetOrdering
}

// GetFacetOrderingOk returns a tuple with the FacetOrdering field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RenderingContent) GetFacetOrderingOk() (*FacetOrdering, bool) {
	if o == nil || o.FacetOrdering == nil {
		return nil, false
	}
	return o.FacetOrdering, true
}

// HasFacetOrdering returns a boolean if a field has been set.
func (o *RenderingContent) HasFacetOrdering() bool {
	if o != nil && o.FacetOrdering != nil {
		return true
	}

	return false
}

// SetFacetOrdering gets a reference to the given FacetOrdering and assigns it to the FacetOrdering field.
func (o *RenderingContent) SetFacetOrdering(v *FacetOrdering) *RenderingContent {
	o.FacetOrdering = v
	return o
}

// GetRedirect returns the Redirect field value if set, zero value otherwise.
func (o *RenderingContent) GetRedirect() RedirectURL {
	if o == nil || o.Redirect == nil {
		var ret RedirectURL
		return ret
	}
	return *o.Redirect
}

// GetRedirectOk returns a tuple with the Redirect field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RenderingContent) GetRedirectOk() (*RedirectURL, bool) {
	if o == nil || o.Redirect == nil {
		return nil, false
	}
	return o.Redirect, true
}

// HasRedirect returns a boolean if a field has been set.
func (o *RenderingContent) HasRedirect() bool {
	if o != nil && o.Redirect != nil {
		return true
	}

	return false
}

// SetRedirect gets a reference to the given RedirectURL and assigns it to the Redirect field.
func (o *RenderingContent) SetRedirect(v *RedirectURL) *RenderingContent {
	o.Redirect = v
	return o
}

func (o RenderingContent) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.FacetOrdering != nil {
		toSerialize["facetOrdering"] = o.FacetOrdering
	}
	if o.Redirect != nil {
		toSerialize["redirect"] = o.Redirect
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RenderingContent: %w", err)
	}

	return serialized, nil
}

func (o RenderingContent) String() string {
	out := ""
	out += fmt.Sprintf("  facetOrdering=%v\n", o.FacetOrdering)
	out += fmt.Sprintf("  redirect=%v\n", o.Redirect)
	return fmt.Sprintf("RenderingContent {\n%s}", out)
}
