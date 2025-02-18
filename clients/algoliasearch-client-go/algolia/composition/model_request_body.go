// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// RequestBody struct for RequestBody.
type RequestBody struct {
	Params *Params `json:"params,omitempty"`
}

type RequestBodyOption func(f *RequestBody)

func WithRequestBodyParams(val Params) RequestBodyOption {
	return func(f *RequestBody) {
		f.Params = &val
	}
}

// NewRequestBody instantiates a new RequestBody object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRequestBody(opts ...RequestBodyOption) *RequestBody {
	this := &RequestBody{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyRequestBody return a pointer to an empty RequestBody object.
func NewEmptyRequestBody() *RequestBody {
	return &RequestBody{}
}

// GetParams returns the Params field value if set, zero value otherwise.
func (o *RequestBody) GetParams() Params {
	if o == nil || o.Params == nil {
		var ret Params
		return ret
	}
	return *o.Params
}

// GetParamsOk returns a tuple with the Params field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RequestBody) GetParamsOk() (*Params, bool) {
	if o == nil || o.Params == nil {
		return nil, false
	}
	return o.Params, true
}

// HasParams returns a boolean if a field has been set.
func (o *RequestBody) HasParams() bool {
	if o != nil && o.Params != nil {
		return true
	}

	return false
}

// SetParams gets a reference to the given Params and assigns it to the Params field.
func (o *RequestBody) SetParams(v *Params) *RequestBody {
	o.Params = v
	return o
}

func (o RequestBody) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Params != nil {
		toSerialize["params"] = o.Params
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RequestBody: %w", err)
	}

	return serialized, nil
}

func (o RequestBody) String() string {
	out := ""
	out += fmt.Sprintf("  params=%v\n", o.Params)
	return fmt.Sprintf("RequestBody {\n%s}", out)
}
