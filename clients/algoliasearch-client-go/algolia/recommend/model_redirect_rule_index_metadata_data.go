// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RedirectRuleIndexMetadataData Redirect rule data.
type RedirectRuleIndexMetadataData struct {
	RuleObjectID string `json:"ruleObjectID"`
}

// NewRedirectRuleIndexMetadataData instantiates a new RedirectRuleIndexMetadataData object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRedirectRuleIndexMetadataData(ruleObjectID string) *RedirectRuleIndexMetadataData {
	this := &RedirectRuleIndexMetadataData{}
	this.RuleObjectID = ruleObjectID
	return this
}

// NewEmptyRedirectRuleIndexMetadataData return a pointer to an empty RedirectRuleIndexMetadataData object.
func NewEmptyRedirectRuleIndexMetadataData() *RedirectRuleIndexMetadataData {
	return &RedirectRuleIndexMetadataData{}
}

// GetRuleObjectID returns the RuleObjectID field value.
func (o *RedirectRuleIndexMetadataData) GetRuleObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.RuleObjectID
}

// GetRuleObjectIDOk returns a tuple with the RuleObjectID field value
// and a boolean to check if the value has been set.
func (o *RedirectRuleIndexMetadataData) GetRuleObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.RuleObjectID, true
}

// SetRuleObjectID sets field value.
func (o *RedirectRuleIndexMetadataData) SetRuleObjectID(v string) *RedirectRuleIndexMetadataData {
	o.RuleObjectID = v
	return o
}

func (o RedirectRuleIndexMetadataData) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["ruleObjectID"] = o.RuleObjectID
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RedirectRuleIndexMetadataData: %w", err)
	}

	return serialized, nil
}

func (o RedirectRuleIndexMetadataData) String() string {
	out := ""
	out += fmt.Sprintf("  ruleObjectID=%v\n", o.RuleObjectID)
	return fmt.Sprintf("RedirectRuleIndexMetadataData {\n%s}", out)
}
