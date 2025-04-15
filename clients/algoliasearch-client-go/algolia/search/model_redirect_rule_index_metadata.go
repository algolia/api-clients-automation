// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// RedirectRuleIndexMetadata struct for RedirectRuleIndexMetadata.
type RedirectRuleIndexMetadata struct {
	// Source index for the redirect rule.
	Source string `json:"source"`
	// Destination index for the redirect rule.
	Dest string `json:"dest"`
	// Reason for the redirect rule.
	Reason string `json:"reason"`
	// Redirect rule status.
	Succeed bool                  `json:"succeed"`
	Data    RedirectRuleIndexData `json:"data"`
}

// NewRedirectRuleIndexMetadata instantiates a new RedirectRuleIndexMetadata object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRedirectRuleIndexMetadata(source string, dest string, reason string, succeed bool, data RedirectRuleIndexData) *RedirectRuleIndexMetadata {
	this := &RedirectRuleIndexMetadata{}
	this.Source = source
	this.Dest = dest
	this.Reason = reason
	this.Succeed = succeed
	this.Data = data
	return this
}

// NewEmptyRedirectRuleIndexMetadata return a pointer to an empty RedirectRuleIndexMetadata object.
func NewEmptyRedirectRuleIndexMetadata() *RedirectRuleIndexMetadata {
	return &RedirectRuleIndexMetadata{}
}

// GetSource returns the Source field value.
func (o *RedirectRuleIndexMetadata) GetSource() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Source
}

// GetSourceOk returns a tuple with the Source field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadata) GetSourceOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Source, true
}

// SetSource sets field value.
func (o *RedirectRuleIndexMetadata) SetSource(v string) *RedirectRuleIndexMetadata {
	o.Source = v
	return o
}

// GetDest returns the Dest field value.
func (o *RedirectRuleIndexMetadata) GetDest() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Dest
}

// GetDestOk returns a tuple with the Dest field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadata) GetDestOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Dest, true
}

// SetDest sets field value.
func (o *RedirectRuleIndexMetadata) SetDest(v string) *RedirectRuleIndexMetadata {
	o.Dest = v
	return o
}

// GetReason returns the Reason field value.
func (o *RedirectRuleIndexMetadata) GetReason() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Reason
}

// GetReasonOk returns a tuple with the Reason field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadata) GetReasonOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Reason, true
}

// SetReason sets field value.
func (o *RedirectRuleIndexMetadata) SetReason(v string) *RedirectRuleIndexMetadata {
	o.Reason = v
	return o
}

// GetSucceed returns the Succeed field value.
func (o *RedirectRuleIndexMetadata) GetSucceed() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.Succeed
}

// GetSucceedOk returns a tuple with the Succeed field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadata) GetSucceedOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Succeed, true
}

// SetSucceed sets field value.
func (o *RedirectRuleIndexMetadata) SetSucceed(v bool) *RedirectRuleIndexMetadata {
	o.Succeed = v
	return o
}

// GetData returns the Data field value.
func (o *RedirectRuleIndexMetadata) GetData() RedirectRuleIndexData {
	if o == nil {
		var ret RedirectRuleIndexData
		return ret
	}

	return o.Data
}

// GetDataOk returns a tuple with the Data field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadata) GetDataOk() (*RedirectRuleIndexData, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Data, true
}

// SetData sets field value.
func (o *RedirectRuleIndexMetadata) SetData(v *RedirectRuleIndexData) *RedirectRuleIndexMetadata {
	o.Data = *v
	return o
}

func (o RedirectRuleIndexMetadata) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["source"] = o.Source
	toSerialize["dest"] = o.Dest
	toSerialize["reason"] = o.Reason
	toSerialize["succeed"] = o.Succeed
	toSerialize["data"] = o.Data
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RedirectRuleIndexMetadata: %w", err)
	}

	return serialized, nil
}

func (o RedirectRuleIndexMetadata) String() string {
	out := ""
	out += fmt.Sprintf("  source=%v\n", o.Source)
	out += fmt.Sprintf("  dest=%v\n", o.Dest)
	out += fmt.Sprintf("  reason=%v\n", o.Reason)
	out += fmt.Sprintf("  succeed=%v\n", o.Succeed)
	out += fmt.Sprintf("  data=%v\n", o.Data)
	return fmt.Sprintf("RedirectRuleIndexMetadata {\n%s}", out)
}
