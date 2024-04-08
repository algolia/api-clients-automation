// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// SearchRecommendRulesResponse struct for SearchRecommendRulesResponse.
type SearchRecommendRulesResponse struct {
	// Recommend rules that match the search criteria.
	Hits []RecommendRule `json:"hits"`
	// Number of results (hits).
	NbHits int32 `json:"nbHits"`
	// Page of search results to retrieve.
	Page int32 `json:"page"`
	// Number of pages of results.
	NbPages int32 `json:"nbPages"`
}

// NewSearchRecommendRulesResponse instantiates a new SearchRecommendRulesResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSearchRecommendRulesResponse(hits []RecommendRule, nbHits int32, page int32, nbPages int32) *SearchRecommendRulesResponse {
	this := &SearchRecommendRulesResponse{}
	this.Hits = hits
	this.NbHits = nbHits
	this.Page = page
	this.NbPages = nbPages
	return this
}

// NewEmptySearchRecommendRulesResponse return a pointer to an empty SearchRecommendRulesResponse object.
func NewEmptySearchRecommendRulesResponse() *SearchRecommendRulesResponse {
	return &SearchRecommendRulesResponse{}
}

// GetHits returns the Hits field value.
func (o *SearchRecommendRulesResponse) GetHits() []RecommendRule {
	if o == nil {
		var ret []RecommendRule
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesResponse) GetHitsOk() ([]RecommendRule, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value.
func (o *SearchRecommendRulesResponse) SetHits(v []RecommendRule) *SearchRecommendRulesResponse {
	o.Hits = v
	return o
}

// GetNbHits returns the NbHits field value.
func (o *SearchRecommendRulesResponse) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesResponse) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value.
func (o *SearchRecommendRulesResponse) SetNbHits(v int32) *SearchRecommendRulesResponse {
	o.NbHits = v
	return o
}

// GetPage returns the Page field value.
func (o *SearchRecommendRulesResponse) GetPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Page
}

// GetPageOk returns a tuple with the Page field value
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesResponse) GetPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Page, true
}

// SetPage sets field value.
func (o *SearchRecommendRulesResponse) SetPage(v int32) *SearchRecommendRulesResponse {
	o.Page = v
	return o
}

// GetNbPages returns the NbPages field value.
func (o *SearchRecommendRulesResponse) GetNbPages() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbPages
}

// GetNbPagesOk returns a tuple with the NbPages field value
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesResponse) GetNbPagesOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbPages, true
}

// SetNbPages sets field value.
func (o *SearchRecommendRulesResponse) SetNbPages(v int32) *SearchRecommendRulesResponse {
	o.NbPages = v
	return o
}

func (o SearchRecommendRulesResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["hits"] = o.Hits
	}
	if true {
		toSerialize["nbHits"] = o.NbHits
	}
	if true {
		toSerialize["page"] = o.Page
	}
	if true {
		toSerialize["nbPages"] = o.NbPages
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SearchRecommendRulesResponse: %w", err)
	}

	return serialized, nil
}

func (o SearchRecommendRulesResponse) String() string {
	out := ""
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	out += fmt.Sprintf("  page=%v\n", o.Page)
	out += fmt.Sprintf("  nbPages=%v\n", o.NbPages)
	return fmt.Sprintf("SearchRecommendRulesResponse {\n%s}", out)
}

type NullableSearchRecommendRulesResponse struct {
	value *SearchRecommendRulesResponse
	isSet bool
}

func (v NullableSearchRecommendRulesResponse) Get() *SearchRecommendRulesResponse {
	return v.value
}

func (v *NullableSearchRecommendRulesResponse) Set(val *SearchRecommendRulesResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchRecommendRulesResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchRecommendRulesResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchRecommendRulesResponse(val *SearchRecommendRulesResponse) *NullableSearchRecommendRulesResponse {
	return &NullableSearchRecommendRulesResponse{value: val, isSet: true}
}

func (v NullableSearchRecommendRulesResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSearchRecommendRulesResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
