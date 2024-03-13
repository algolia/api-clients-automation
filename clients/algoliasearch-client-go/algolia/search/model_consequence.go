// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// Consequence Effect of the rule.  For more information, see [Consequences](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#consequences).
type Consequence struct {
	Params *ConsequenceParams `json:"params,omitempty"`
	// Records you want to pin to a specific position in the search results.  You can promote up to 300 records, either individually, or as groups of up to 100 records each.
	Promote []Promote `json:"promote,omitempty"`
	// Whether promoted records must match an active filter for the consequence to be applied.  This ensures that user actions (filtering the search) are given a higher precedence. For example, if you promote a record with the `color: red` attribute, and the user filters the search for `color: blue`, the \"red\" record won't be shown.
	FilterPromotes *bool `json:"filterPromotes,omitempty"`
	// Records you want to hide from the search results.
	Hide []ConsequenceHide `json:"hide,omitempty"`
	// A JSON object with custom data that will be appended to the `userData` array in the response. This object isn't interpreted by the API and is limited to 1&nbsp;kB of minified JSON.
	UserData interface{} `json:"userData,omitempty"`
}

type ConsequenceOption func(f *Consequence)

func WithConsequenceParams(val ConsequenceParams) ConsequenceOption {
	return func(f *Consequence) {
		f.Params = &val
	}
}

func WithConsequencePromote(val []Promote) ConsequenceOption {
	return func(f *Consequence) {
		f.Promote = val
	}
}

func WithConsequenceFilterPromotes(val bool) ConsequenceOption {
	return func(f *Consequence) {
		f.FilterPromotes = &val
	}
}

func WithConsequenceHide(val []ConsequenceHide) ConsequenceOption {
	return func(f *Consequence) {
		f.Hide = val
	}
}

func WithConsequenceUserData(val interface{}) ConsequenceOption {
	return func(f *Consequence) {
		f.UserData = val
	}
}

// NewConsequence instantiates a new Consequence object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewConsequence(opts ...ConsequenceOption) *Consequence {
	this := &Consequence{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyConsequence return a pointer to an empty Consequence object.
func NewEmptyConsequence() *Consequence {
	return &Consequence{}
}

// GetParams returns the Params field value if set, zero value otherwise.
func (o *Consequence) GetParams() ConsequenceParams {
	if o == nil || o.Params == nil {
		var ret ConsequenceParams
		return ret
	}
	return *o.Params
}

// GetParamsOk returns a tuple with the Params field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Consequence) GetParamsOk() (*ConsequenceParams, bool) {
	if o == nil || o.Params == nil {
		return nil, false
	}
	return o.Params, true
}

// HasParams returns a boolean if a field has been set.
func (o *Consequence) HasParams() bool {
	if o != nil && o.Params != nil {
		return true
	}

	return false
}

// SetParams gets a reference to the given ConsequenceParams and assigns it to the Params field.
func (o *Consequence) SetParams(v *ConsequenceParams) *Consequence {
	o.Params = v
	return o
}

// GetPromote returns the Promote field value if set, zero value otherwise.
func (o *Consequence) GetPromote() []Promote {
	if o == nil || o.Promote == nil {
		var ret []Promote
		return ret
	}
	return o.Promote
}

// GetPromoteOk returns a tuple with the Promote field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Consequence) GetPromoteOk() ([]Promote, bool) {
	if o == nil || o.Promote == nil {
		return nil, false
	}
	return o.Promote, true
}

// HasPromote returns a boolean if a field has been set.
func (o *Consequence) HasPromote() bool {
	if o != nil && o.Promote != nil {
		return true
	}

	return false
}

// SetPromote gets a reference to the given []Promote and assigns it to the Promote field.
func (o *Consequence) SetPromote(v []Promote) *Consequence {
	o.Promote = v
	return o
}

// GetFilterPromotes returns the FilterPromotes field value if set, zero value otherwise.
func (o *Consequence) GetFilterPromotes() bool {
	if o == nil || o.FilterPromotes == nil {
		var ret bool
		return ret
	}
	return *o.FilterPromotes
}

// GetFilterPromotesOk returns a tuple with the FilterPromotes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Consequence) GetFilterPromotesOk() (*bool, bool) {
	if o == nil || o.FilterPromotes == nil {
		return nil, false
	}
	return o.FilterPromotes, true
}

// HasFilterPromotes returns a boolean if a field has been set.
func (o *Consequence) HasFilterPromotes() bool {
	if o != nil && o.FilterPromotes != nil {
		return true
	}

	return false
}

// SetFilterPromotes gets a reference to the given bool and assigns it to the FilterPromotes field.
func (o *Consequence) SetFilterPromotes(v bool) *Consequence {
	o.FilterPromotes = &v
	return o
}

// GetHide returns the Hide field value if set, zero value otherwise.
func (o *Consequence) GetHide() []ConsequenceHide {
	if o == nil || o.Hide == nil {
		var ret []ConsequenceHide
		return ret
	}
	return o.Hide
}

// GetHideOk returns a tuple with the Hide field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Consequence) GetHideOk() ([]ConsequenceHide, bool) {
	if o == nil || o.Hide == nil {
		return nil, false
	}
	return o.Hide, true
}

// HasHide returns a boolean if a field has been set.
func (o *Consequence) HasHide() bool {
	if o != nil && o.Hide != nil {
		return true
	}

	return false
}

// SetHide gets a reference to the given []ConsequenceHide and assigns it to the Hide field.
func (o *Consequence) SetHide(v []ConsequenceHide) *Consequence {
	o.Hide = v
	return o
}

// GetUserData returns the UserData field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *Consequence) GetUserData() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}
	return o.UserData
}

// GetUserDataOk returns a tuple with the UserData field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *Consequence) GetUserDataOk() (*interface{}, bool) {
	if o == nil || o.UserData == nil {
		return nil, false
	}
	return &o.UserData, true
}

// HasUserData returns a boolean if a field has been set.
func (o *Consequence) HasUserData() bool {
	if o != nil && o.UserData != nil {
		return true
	}

	return false
}

// SetUserData gets a reference to the given interface{} and assigns it to the UserData field.
func (o *Consequence) SetUserData(v interface{}) *Consequence {
	o.UserData = v
	return o
}

func (o Consequence) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Params != nil {
		toSerialize["params"] = o.Params
	}
	if o.Promote != nil {
		toSerialize["promote"] = o.Promote
	}
	if o.FilterPromotes != nil {
		toSerialize["filterPromotes"] = o.FilterPromotes
	}
	if o.Hide != nil {
		toSerialize["hide"] = o.Hide
	}
	if o.UserData != nil {
		toSerialize["userData"] = o.UserData
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Consequence: %w", err)
	}

	return serialized, nil
}

func (o Consequence) String() string {
	out := ""
	out += fmt.Sprintf("  params=%v\n", o.Params)
	out += fmt.Sprintf("  promote=%v\n", o.Promote)
	out += fmt.Sprintf("  filterPromotes=%v\n", o.FilterPromotes)
	out += fmt.Sprintf("  hide=%v\n", o.Hide)
	out += fmt.Sprintf("  userData=%v\n", o.UserData)
	return fmt.Sprintf("Consequence {\n%s}", out)
}

type NullableConsequence struct {
	value *Consequence
	isSet bool
}

func (v NullableConsequence) Get() *Consequence {
	return v.value
}

func (v *NullableConsequence) Set(val *Consequence) {
	v.value = val
	v.isSet = true
}

func (v NullableConsequence) IsSet() bool {
	return v.isSet
}

func (v *NullableConsequence) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableConsequence(val *Consequence) *NullableConsequence {
	return &NullableConsequence{value: val, isSet: true}
}

func (v NullableConsequence) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableConsequence) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
