// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// FacetHits struct for FacetHits.
type FacetHits struct {
	// Facet value.
	Value string `json:"value"`
	// Highlighted attribute value, including HTML tags.
	Highlighted string `json:"highlighted"`
	// Number of records with this facet value. [The count may be approximated](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
	Count int32 `json:"count"`
}

// NewFacetHits instantiates a new FacetHits object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewFacetHits(value string, highlighted string, count int32) *FacetHits {
	this := &FacetHits{}
	this.Value = value
	this.Highlighted = highlighted
	this.Count = count
	return this
}

// NewEmptyFacetHits return a pointer to an empty FacetHits object.
func NewEmptyFacetHits() *FacetHits {
	return &FacetHits{}
}

// GetValue returns the Value field value.
func (o *FacetHits) GetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Value
}

// GetValueOk returns a tuple with the Value field value
// and a boolean to check if the value has been set.
func (o *FacetHits) GetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Value, true
}

// SetValue sets field value.
func (o *FacetHits) SetValue(v string) *FacetHits {
	o.Value = v
	return o
}

// GetHighlighted returns the Highlighted field value.
func (o *FacetHits) GetHighlighted() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Highlighted
}

// GetHighlightedOk returns a tuple with the Highlighted field value
// and a boolean to check if the value has been set.
func (o *FacetHits) GetHighlightedOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Highlighted, true
}

// SetHighlighted sets field value.
func (o *FacetHits) SetHighlighted(v string) *FacetHits {
	o.Highlighted = v
	return o
}

// GetCount returns the Count field value.
func (o *FacetHits) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *FacetHits) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *FacetHits) SetCount(v int32) *FacetHits {
	o.Count = v
	return o
}

func (o FacetHits) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["value"] = o.Value
	toSerialize["highlighted"] = o.Highlighted
	toSerialize["count"] = o.Count
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal FacetHits: %w", err)
	}

	return serialized, nil
}

func (o FacetHits) String() string {
	out := ""
	out += fmt.Sprintf("  value=%v\n", o.Value)
	out += fmt.Sprintf("  highlighted=%v\n", o.Highlighted)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	return fmt.Sprintf("FacetHits {\n%s}", out)
}
