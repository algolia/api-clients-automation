// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendRule Recommend rule.
type RecommendRule struct {
	Metadata *RuleMetadata `json:"_metadata,omitempty"`
	// Unique identifier of a rule object.
	ObjectID    *string      `json:"objectID,omitempty"`
	Condition   *Condition   `json:"condition,omitempty"`
	Consequence *Consequence `json:"consequence,omitempty"`
	// Description of the rule's purpose. This can be helpful for display in the Algolia dashboard.
	Description *string `json:"description,omitempty"`
	// Indicates whether to enable the rule. If it isn't enabled, it isn't applied at query time.
	Enabled *bool `json:"enabled,omitempty"`
	// Time periods when the rule is active.
	Validity []TimeRange `json:"validity,omitempty"`
}

type RecommendRuleOption func(f *RecommendRule)

func WithRecommendRuleMetadata(val RuleMetadata) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Metadata = &val
	}
}

func WithRecommendRuleObjectID(val string) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.ObjectID = &val
	}
}

func WithRecommendRuleCondition(val Condition) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Condition = &val
	}
}

func WithRecommendRuleConsequence(val Consequence) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Consequence = &val
	}
}

func WithRecommendRuleDescription(val string) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Description = &val
	}
}

func WithRecommendRuleEnabled(val bool) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Enabled = &val
	}
}

func WithRecommendRuleValidity(val []TimeRange) RecommendRuleOption {
	return func(f *RecommendRule) {
		f.Validity = val
	}
}

// NewRecommendRule instantiates a new RecommendRule object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewRecommendRule(opts ...RecommendRuleOption) *RecommendRule {
	this := &RecommendRule{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyRecommendRule return a pointer to an empty RecommendRule object.
func NewEmptyRecommendRule() *RecommendRule {
	return &RecommendRule{}
}

// GetMetadata returns the Metadata field value if set, zero value otherwise.
func (o *RecommendRule) GetMetadata() RuleMetadata {
	if o == nil || o.Metadata == nil {
		var ret RuleMetadata
		return ret
	}
	return *o.Metadata
}

// GetMetadataOk returns a tuple with the Metadata field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetMetadataOk() (*RuleMetadata, bool) {
	if o == nil || o.Metadata == nil {
		return nil, false
	}
	return o.Metadata, true
}

// HasMetadata returns a boolean if a field has been set.
func (o *RecommendRule) HasMetadata() bool {
	if o != nil && o.Metadata != nil {
		return true
	}

	return false
}

// SetMetadata gets a reference to the given RuleMetadata and assigns it to the Metadata field.
func (o *RecommendRule) SetMetadata(v *RuleMetadata) *RecommendRule {
	o.Metadata = v
	return o
}

// GetObjectID returns the ObjectID field value if set, zero value otherwise.
func (o *RecommendRule) GetObjectID() string {
	if o == nil || o.ObjectID == nil {
		var ret string
		return ret
	}
	return *o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetObjectIDOk() (*string, bool) {
	if o == nil || o.ObjectID == nil {
		return nil, false
	}
	return o.ObjectID, true
}

// HasObjectID returns a boolean if a field has been set.
func (o *RecommendRule) HasObjectID() bool {
	if o != nil && o.ObjectID != nil {
		return true
	}

	return false
}

// SetObjectID gets a reference to the given string and assigns it to the ObjectID field.
func (o *RecommendRule) SetObjectID(v string) *RecommendRule {
	o.ObjectID = &v
	return o
}

// GetCondition returns the Condition field value if set, zero value otherwise.
func (o *RecommendRule) GetCondition() Condition {
	if o == nil || o.Condition == nil {
		var ret Condition
		return ret
	}
	return *o.Condition
}

// GetConditionOk returns a tuple with the Condition field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetConditionOk() (*Condition, bool) {
	if o == nil || o.Condition == nil {
		return nil, false
	}
	return o.Condition, true
}

// HasCondition returns a boolean if a field has been set.
func (o *RecommendRule) HasCondition() bool {
	if o != nil && o.Condition != nil {
		return true
	}

	return false
}

// SetCondition gets a reference to the given Condition and assigns it to the Condition field.
func (o *RecommendRule) SetCondition(v *Condition) *RecommendRule {
	o.Condition = v
	return o
}

// GetConsequence returns the Consequence field value if set, zero value otherwise.
func (o *RecommendRule) GetConsequence() Consequence {
	if o == nil || o.Consequence == nil {
		var ret Consequence
		return ret
	}
	return *o.Consequence
}

// GetConsequenceOk returns a tuple with the Consequence field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetConsequenceOk() (*Consequence, bool) {
	if o == nil || o.Consequence == nil {
		return nil, false
	}
	return o.Consequence, true
}

// HasConsequence returns a boolean if a field has been set.
func (o *RecommendRule) HasConsequence() bool {
	if o != nil && o.Consequence != nil {
		return true
	}

	return false
}

// SetConsequence gets a reference to the given Consequence and assigns it to the Consequence field.
func (o *RecommendRule) SetConsequence(v *Consequence) *RecommendRule {
	o.Consequence = v
	return o
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *RecommendRule) GetDescription() string {
	if o == nil || o.Description == nil {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetDescriptionOk() (*string, bool) {
	if o == nil || o.Description == nil {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *RecommendRule) HasDescription() bool {
	if o != nil && o.Description != nil {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *RecommendRule) SetDescription(v string) *RecommendRule {
	o.Description = &v
	return o
}

// GetEnabled returns the Enabled field value if set, zero value otherwise.
func (o *RecommendRule) GetEnabled() bool {
	if o == nil || o.Enabled == nil {
		var ret bool
		return ret
	}
	return *o.Enabled
}

// GetEnabledOk returns a tuple with the Enabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetEnabledOk() (*bool, bool) {
	if o == nil || o.Enabled == nil {
		return nil, false
	}
	return o.Enabled, true
}

// HasEnabled returns a boolean if a field has been set.
func (o *RecommendRule) HasEnabled() bool {
	if o != nil && o.Enabled != nil {
		return true
	}

	return false
}

// SetEnabled gets a reference to the given bool and assigns it to the Enabled field.
func (o *RecommendRule) SetEnabled(v bool) *RecommendRule {
	o.Enabled = &v
	return o
}

// GetValidity returns the Validity field value if set, zero value otherwise.
func (o *RecommendRule) GetValidity() []TimeRange {
	if o == nil || o.Validity == nil {
		var ret []TimeRange
		return ret
	}
	return o.Validity
}

// GetValidityOk returns a tuple with the Validity field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendRule) GetValidityOk() ([]TimeRange, bool) {
	if o == nil || o.Validity == nil {
		return nil, false
	}
	return o.Validity, true
}

// HasValidity returns a boolean if a field has been set.
func (o *RecommendRule) HasValidity() bool {
	if o != nil && o.Validity != nil {
		return true
	}

	return false
}

// SetValidity gets a reference to the given []TimeRange and assigns it to the Validity field.
func (o *RecommendRule) SetValidity(v []TimeRange) *RecommendRule {
	o.Validity = v
	return o
}

func (o RecommendRule) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Metadata != nil {
		toSerialize["_metadata"] = o.Metadata
	}
	if o.ObjectID != nil {
		toSerialize["objectID"] = o.ObjectID
	}
	if o.Condition != nil {
		toSerialize["condition"] = o.Condition
	}
	if o.Consequence != nil {
		toSerialize["consequence"] = o.Consequence
	}
	if o.Description != nil {
		toSerialize["description"] = o.Description
	}
	if o.Enabled != nil {
		toSerialize["enabled"] = o.Enabled
	}
	if o.Validity != nil {
		toSerialize["validity"] = o.Validity
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal RecommendRule: %w", err)
	}

	return serialized, nil
}

func (o RecommendRule) String() string {
	out := ""
	out += fmt.Sprintf("  _metadata=%v\n", o.Metadata)
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  condition=%v\n", o.Condition)
	out += fmt.Sprintf("  consequence=%v\n", o.Consequence)
	out += fmt.Sprintf("  description=%v\n", o.Description)
	out += fmt.Sprintf("  enabled=%v\n", o.Enabled)
	out += fmt.Sprintf("  validity=%v\n", o.Validity)
	return fmt.Sprintf("RecommendRule {\n%s}", out)
}
