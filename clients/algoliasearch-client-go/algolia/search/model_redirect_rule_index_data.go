// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// RedirectRuleIndexData Redirect rule data.
type RedirectRuleIndexData struct {
	RuleObjectID string `json:"ruleObjectID"`
}

// NewRedirectRuleIndexData instantiates a new RedirectRuleIndexData object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRedirectRuleIndexData(ruleObjectID string) *RedirectRuleIndexData {
	this := &RedirectRuleIndexData{}
	this.RuleObjectID = ruleObjectID
	return this
}

// NewEmptyRedirectRuleIndexData return a pointer to an empty RedirectRuleIndexData object.
func NewEmptyRedirectRuleIndexData() *RedirectRuleIndexData {
	return &RedirectRuleIndexData{}
}

// GetRuleObjectID returns the RuleObjectID field value.
func (o *RedirectRuleIndexData) GetRuleObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.RuleObjectID
}

// GetRuleObjectIDOk returns a tuple with the RuleObjectID field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexData) GetRuleObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.RuleObjectID, true
}

// SetRuleObjectID sets field value.
func (o *RedirectRuleIndexData) SetRuleObjectID(v string) *RedirectRuleIndexData {
	o.RuleObjectID = v
	return o
}

func (o RedirectRuleIndexData) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["ruleObjectID"] = o.RuleObjectID
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RedirectRuleIndexData: %w", err)
	}

	return serialized, nil
}

func (o RedirectRuleIndexData) String() string {
	out := ""
	out += fmt.Sprintf("  ruleObjectID=%v\n", o.RuleObjectID)
	return fmt.Sprintf("RedirectRuleIndexData {\n%s}", out)
}
