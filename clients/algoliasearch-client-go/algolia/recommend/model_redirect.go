// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// Redirect [Redirect results to a URL](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/redirects/).
type Redirect struct {
	Index []RedirectRuleIndexMetadata `json:"index,omitempty"`
}

type RedirectOption func(f *Redirect)

func WithRedirectIndex(val []RedirectRuleIndexMetadata) RedirectOption {
	return func(f *Redirect) {
		f.Index = val
	}
}

// NewRedirect instantiates a new Redirect object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRedirect(opts ...RedirectOption) *Redirect {
	this := &Redirect{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyRedirect return a pointer to an empty Redirect object.
func NewEmptyRedirect() *Redirect {
	return &Redirect{}
}

// GetIndex returns the Index field value if set, zero value otherwise.
func (o *Redirect) GetIndex() []RedirectRuleIndexMetadata {
	if o == nil || o.Index == nil {
		var ret []RedirectRuleIndexMetadata
		return ret
	}
	return o.Index
}

// GetIndexOk returns a tuple with the Index field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Redirect) GetIndexOk() ([]RedirectRuleIndexMetadata, bool) {
	if o == nil || o.Index == nil {
		return nil, false
	}
	return o.Index, true
}

// HasIndex returns a boolean if a field has been set.
func (o *Redirect) HasIndex() bool {
	if o != nil && o.Index != nil {
		return true
	}

	return false
}

// SetIndex gets a reference to the given []RedirectRuleIndexMetadata and assigns it to the Index field.
func (o *Redirect) SetIndex(v []RedirectRuleIndexMetadata) *Redirect {
	o.Index = v
	return o
}

func (o Redirect) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Index != nil {
		toSerialize["index"] = o.Index
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Redirect: %w", err)
	}

	return serialized, nil
}

func (o Redirect) String() string {
	out := ""
	out += fmt.Sprintf("  index=%v\n", o.Index)
	return fmt.Sprintf("Redirect {\n%s}", out)
}
