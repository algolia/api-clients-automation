// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// Hit A single hit.
type Hit struct {
	// Unique object identifier.
	ObjectID string `json:"objectID"`
	// Show highlighted section and words matched on a query.
	HighlightResult *map[string]HighlightResult `json:"_highlightResult,omitempty"`
	// Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
	SnippetResult        *map[string]SnippetResult `json:"_snippetResult,omitempty"`
	RankingInfo          *RankingInfo              `json:"_rankingInfo,omitempty"`
	DistinctSeqID        *int32                    `json:"_distinctSeqID,omitempty"`
	AdditionalProperties map[string]any
}

type _Hit Hit

type HitOption func(f *Hit)

func WithHitHighlightResult(val map[string]HighlightResult) HitOption {
	return func(f *Hit) {
		f.HighlightResult = &val
	}
}

func WithHitSnippetResult(val map[string]SnippetResult) HitOption {
	return func(f *Hit) {
		f.SnippetResult = &val
	}
}

func WithHitRankingInfo(val RankingInfo) HitOption {
	return func(f *Hit) {
		f.RankingInfo = &val
	}
}

func WithHitDistinctSeqID(val int32) HitOption {
	return func(f *Hit) {
		f.DistinctSeqID = &val
	}
}

// NewHit instantiates a new Hit object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewHit(objectID string, opts ...HitOption) *Hit {
	this := &Hit{}
	this.ObjectID = objectID
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyHit return a pointer to an empty Hit object.
func NewEmptyHit() *Hit {
	return &Hit{}
}

// GetObjectID returns the ObjectID field value.
func (o *Hit) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *Hit) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value.
func (o *Hit) SetObjectID(v string) *Hit {
	o.ObjectID = v
	return o
}

// GetHighlightResult returns the HighlightResult field value if set, zero value otherwise.
func (o *Hit) GetHighlightResult() map[string]HighlightResult {
	if o == nil || o.HighlightResult == nil {
		var ret map[string]HighlightResult
		return ret
	}
	return *o.HighlightResult
}

// GetHighlightResultOk returns a tuple with the HighlightResult field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Hit) GetHighlightResultOk() (*map[string]HighlightResult, bool) {
	if o == nil || o.HighlightResult == nil {
		return nil, false
	}
	return o.HighlightResult, true
}

// HasHighlightResult returns a boolean if a field has been set.
func (o *Hit) HasHighlightResult() bool {
	if o != nil && o.HighlightResult != nil {
		return true
	}

	return false
}

// SetHighlightResult gets a reference to the given map[string]HighlightResult and assigns it to the HighlightResult field.
func (o *Hit) SetHighlightResult(v map[string]HighlightResult) *Hit {
	o.HighlightResult = &v
	return o
}

// GetSnippetResult returns the SnippetResult field value if set, zero value otherwise.
func (o *Hit) GetSnippetResult() map[string]SnippetResult {
	if o == nil || o.SnippetResult == nil {
		var ret map[string]SnippetResult
		return ret
	}
	return *o.SnippetResult
}

// GetSnippetResultOk returns a tuple with the SnippetResult field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Hit) GetSnippetResultOk() (*map[string]SnippetResult, bool) {
	if o == nil || o.SnippetResult == nil {
		return nil, false
	}
	return o.SnippetResult, true
}

// HasSnippetResult returns a boolean if a field has been set.
func (o *Hit) HasSnippetResult() bool {
	if o != nil && o.SnippetResult != nil {
		return true
	}

	return false
}

// SetSnippetResult gets a reference to the given map[string]SnippetResult and assigns it to the SnippetResult field.
func (o *Hit) SetSnippetResult(v map[string]SnippetResult) *Hit {
	o.SnippetResult = &v
	return o
}

// GetRankingInfo returns the RankingInfo field value if set, zero value otherwise.
func (o *Hit) GetRankingInfo() RankingInfo {
	if o == nil || o.RankingInfo == nil {
		var ret RankingInfo
		return ret
	}
	return *o.RankingInfo
}

// GetRankingInfoOk returns a tuple with the RankingInfo field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Hit) GetRankingInfoOk() (*RankingInfo, bool) {
	if o == nil || o.RankingInfo == nil {
		return nil, false
	}
	return o.RankingInfo, true
}

// HasRankingInfo returns a boolean if a field has been set.
func (o *Hit) HasRankingInfo() bool {
	if o != nil && o.RankingInfo != nil {
		return true
	}

	return false
}

// SetRankingInfo gets a reference to the given RankingInfo and assigns it to the RankingInfo field.
func (o *Hit) SetRankingInfo(v *RankingInfo) *Hit {
	o.RankingInfo = v
	return o
}

// GetDistinctSeqID returns the DistinctSeqID field value if set, zero value otherwise.
func (o *Hit) GetDistinctSeqID() int32 {
	if o == nil || o.DistinctSeqID == nil {
		var ret int32
		return ret
	}
	return *o.DistinctSeqID
}

// GetDistinctSeqIDOk returns a tuple with the DistinctSeqID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Hit) GetDistinctSeqIDOk() (*int32, bool) {
	if o == nil || o.DistinctSeqID == nil {
		return nil, false
	}
	return o.DistinctSeqID, true
}

// HasDistinctSeqID returns a boolean if a field has been set.
func (o *Hit) HasDistinctSeqID() bool {
	if o != nil && o.DistinctSeqID != nil {
		return true
	}

	return false
}

// SetDistinctSeqID gets a reference to the given int32 and assigns it to the DistinctSeqID field.
func (o *Hit) SetDistinctSeqID(v int32) *Hit {
	o.DistinctSeqID = &v
	return o
}

func (o *Hit) SetAdditionalProperty(key string, value any) *Hit {
	if o.AdditionalProperties == nil {
		o.AdditionalProperties = make(map[string]any)
	}

	o.AdditionalProperties[key] = value

	return o
}

func (o Hit) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["objectID"] = o.ObjectID
	}
	if o.HighlightResult != nil {
		toSerialize["_highlightResult"] = o.HighlightResult
	}
	if o.SnippetResult != nil {
		toSerialize["_snippetResult"] = o.SnippetResult
	}
	if o.RankingInfo != nil {
		toSerialize["_rankingInfo"] = o.RankingInfo
	}
	if o.DistinctSeqID != nil {
		toSerialize["_distinctSeqID"] = o.DistinctSeqID
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Hit: %w", err)
	}

	return serialized, nil
}

func (o *Hit) UnmarshalJSON(bytes []byte) (err error) {
	varHit := _Hit{}

	if err = json.Unmarshal(bytes, &varHit); err == nil {
		*o = Hit(varHit)
	}

	additionalProperties := make(map[string]any)

	err = json.Unmarshal(bytes, &additionalProperties)
	if err != nil {
		return fmt.Errorf("failed to unmarshal additionalProperties in Hit: %w", err)
	}

	delete(additionalProperties, "objectID")
	delete(additionalProperties, "_highlightResult")
	delete(additionalProperties, "_snippetResult")
	delete(additionalProperties, "_rankingInfo")
	delete(additionalProperties, "_distinctSeqID")
	o.AdditionalProperties = additionalProperties

	return nil
}

func (o Hit) String() string {
	out := ""
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  _highlightResult=%v\n", o.HighlightResult)
	out += fmt.Sprintf("  _snippetResult=%v\n", o.SnippetResult)
	out += fmt.Sprintf("  _rankingInfo=%v\n", o.RankingInfo)
	out += fmt.Sprintf("  _distinctSeqID=%v\n", o.DistinctSeqID)
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("Hit {\n%s}", out)
}

type NullableHit struct {
	value *Hit
	isSet bool
}

func (v NullableHit) Get() *Hit {
	return v.value
}

func (v *NullableHit) Set(val *Hit) {
	v.value = val
	v.isSet = true
}

func (v NullableHit) IsSet() bool {
	return v.isSet
}

func (v *NullableHit) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableHit(val *Hit) *NullableHit {
	return &NullableHit{value: val, isSet: true}
}

func (v NullableHit) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableHit) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
