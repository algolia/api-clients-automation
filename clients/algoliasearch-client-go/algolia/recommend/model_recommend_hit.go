// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RecommendHit Recommend hit.
type RecommendHit struct {
	// Unique object identifier.
	ObjectID string `json:"objectID" validate:"required"`
	// Show highlighted section and words matched on a query.
	HighlightResult *map[string]HighlightResult `json:"_highlightResult,omitempty"`
	// Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
	SnippetResult *map[string]SnippetResult `json:"_snippetResult,omitempty"`
	RankingInfo   *RankingInfo              `json:"_rankingInfo,omitempty"`
	DistinctSeqID *int32                    `json:"_distinctSeqID,omitempty"`
	// Recommendation score.
	Score                float64 `json:"_score" validate:"required"`
	AdditionalProperties map[string]any
}

type _RecommendHit RecommendHit

type RecommendHitOption func(f *RecommendHit)

func WithRecommendHitHighlightResult(val map[string]HighlightResult) RecommendHitOption {
	return func(f *RecommendHit) {
		f.HighlightResult = &val
	}
}

func WithRecommendHitSnippetResult(val map[string]SnippetResult) RecommendHitOption {
	return func(f *RecommendHit) {
		f.SnippetResult = &val
	}
}

func WithRecommendHitRankingInfo(val RankingInfo) RecommendHitOption {
	return func(f *RecommendHit) {
		f.RankingInfo = &val
	}
}

func WithRecommendHitDistinctSeqID(val int32) RecommendHitOption {
	return func(f *RecommendHit) {
		f.DistinctSeqID = &val
	}
}

// NewRecommendHit instantiates a new RecommendHit object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewRecommendHit(objectID string, score float64, opts ...RecommendHitOption) *RecommendHit {
	this := &RecommendHit{}
	this.ObjectID = objectID
	this.Score = score
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewRecommendHitWithDefaults instantiates a new RecommendHit object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewRecommendHitWithDefaults() *RecommendHit {
	this := &RecommendHit{}
	return this
}

// GetObjectID returns the ObjectID field value
func (o *RecommendHit) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value
func (o *RecommendHit) SetObjectID(v string) {
	o.ObjectID = v
}

// GetHighlightResult returns the HighlightResult field value if set, zero value otherwise.
func (o *RecommendHit) GetHighlightResult() map[string]HighlightResult {
	if o == nil || o.HighlightResult == nil {
		var ret map[string]HighlightResult
		return ret
	}
	return *o.HighlightResult
}

// GetHighlightResultOk returns a tuple with the HighlightResult field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetHighlightResultOk() (*map[string]HighlightResult, bool) {
	if o == nil || o.HighlightResult == nil {
		return nil, false
	}
	return o.HighlightResult, true
}

// HasHighlightResult returns a boolean if a field has been set.
func (o *RecommendHit) HasHighlightResult() bool {
	if o != nil && o.HighlightResult != nil {
		return true
	}

	return false
}

// SetHighlightResult gets a reference to the given map[string]HighlightResult and assigns it to the HighlightResult field.
func (o *RecommendHit) SetHighlightResult(v map[string]HighlightResult) {
	o.HighlightResult = &v
}

// GetSnippetResult returns the SnippetResult field value if set, zero value otherwise.
func (o *RecommendHit) GetSnippetResult() map[string]SnippetResult {
	if o == nil || o.SnippetResult == nil {
		var ret map[string]SnippetResult
		return ret
	}
	return *o.SnippetResult
}

// GetSnippetResultOk returns a tuple with the SnippetResult field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetSnippetResultOk() (*map[string]SnippetResult, bool) {
	if o == nil || o.SnippetResult == nil {
		return nil, false
	}
	return o.SnippetResult, true
}

// HasSnippetResult returns a boolean if a field has been set.
func (o *RecommendHit) HasSnippetResult() bool {
	if o != nil && o.SnippetResult != nil {
		return true
	}

	return false
}

// SetSnippetResult gets a reference to the given map[string]SnippetResult and assigns it to the SnippetResult field.
func (o *RecommendHit) SetSnippetResult(v map[string]SnippetResult) {
	o.SnippetResult = &v
}

// GetRankingInfo returns the RankingInfo field value if set, zero value otherwise.
func (o *RecommendHit) GetRankingInfo() RankingInfo {
	if o == nil || o.RankingInfo == nil {
		var ret RankingInfo
		return ret
	}
	return *o.RankingInfo
}

// GetRankingInfoOk returns a tuple with the RankingInfo field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetRankingInfoOk() (*RankingInfo, bool) {
	if o == nil || o.RankingInfo == nil {
		return nil, false
	}
	return o.RankingInfo, true
}

// HasRankingInfo returns a boolean if a field has been set.
func (o *RecommendHit) HasRankingInfo() bool {
	if o != nil && o.RankingInfo != nil {
		return true
	}

	return false
}

// SetRankingInfo gets a reference to the given RankingInfo and assigns it to the RankingInfo field.
func (o *RecommendHit) SetRankingInfo(v RankingInfo) {
	o.RankingInfo = &v
}

// GetDistinctSeqID returns the DistinctSeqID field value if set, zero value otherwise.
func (o *RecommendHit) GetDistinctSeqID() int32 {
	if o == nil || o.DistinctSeqID == nil {
		var ret int32
		return ret
	}
	return *o.DistinctSeqID
}

// GetDistinctSeqIDOk returns a tuple with the DistinctSeqID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetDistinctSeqIDOk() (*int32, bool) {
	if o == nil || o.DistinctSeqID == nil {
		return nil, false
	}
	return o.DistinctSeqID, true
}

// HasDistinctSeqID returns a boolean if a field has been set.
func (o *RecommendHit) HasDistinctSeqID() bool {
	if o != nil && o.DistinctSeqID != nil {
		return true
	}

	return false
}

// SetDistinctSeqID gets a reference to the given int32 and assigns it to the DistinctSeqID field.
func (o *RecommendHit) SetDistinctSeqID(v int32) {
	o.DistinctSeqID = &v
}

// GetScore returns the Score field value
func (o *RecommendHit) GetScore() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Score
}

// GetScoreOk returns a tuple with the Score field value
// and a boolean to check if the value has been set.
func (o *RecommendHit) GetScoreOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Score, true
}

// SetScore sets field value
func (o *RecommendHit) SetScore(v float64) {
	o.Score = v
}

func (o RecommendHit) MarshalJSON() ([]byte, error) {
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
	if true {
		toSerialize["_score"] = o.Score
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return json.Marshal(toSerialize)
}

func (o *RecommendHit) UnmarshalJSON(bytes []byte) (err error) {
	varRecommendHit := _RecommendHit{}

	if err = json.Unmarshal(bytes, &varRecommendHit); err == nil {
		*o = RecommendHit(varRecommendHit)
	}

	additionalProperties := make(map[string]any)

	if err = json.Unmarshal(bytes, &additionalProperties); err == nil {
		delete(additionalProperties, "objectID")
		delete(additionalProperties, "_highlightResult")
		delete(additionalProperties, "_snippetResult")
		delete(additionalProperties, "_rankingInfo")
		delete(additionalProperties, "_distinctSeqID")
		delete(additionalProperties, "_score")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

func (o RecommendHit) String() string {
	out := ""
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  _highlightResult=%v\n", o.HighlightResult)
	out += fmt.Sprintf("  _snippetResult=%v\n", o.SnippetResult)
	out += fmt.Sprintf("  _rankingInfo=%v\n", o.RankingInfo)
	out += fmt.Sprintf("  _distinctSeqID=%v\n", o.DistinctSeqID)
	out += fmt.Sprintf("  _score=%v\n", o.Score)
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("RecommendHit {\n%s}", out)
}

type NullableRecommendHit struct {
	value *RecommendHit
	isSet bool
}

func (v NullableRecommendHit) Get() *RecommendHit {
	return v.value
}

func (v *NullableRecommendHit) Set(val *RecommendHit) {
	v.value = val
	v.isSet = true
}

func (v NullableRecommendHit) IsSet() bool {
	return v.isSet
}

func (v *NullableRecommendHit) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRecommendHit(val *RecommendHit) *NullableRecommendHit {
	return &NullableRecommendHit{value: val, isSet: true}
}

func (v NullableRecommendHit) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRecommendHit) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
