// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SearchSynonymsResponse struct for SearchSynonymsResponse.
type SearchSynonymsResponse struct {
	// Synonym objects.
	Hits []SynonymHit `json:"hits"`
	// Number of hits the search query matched.
	NbHits               int32 `json:"nbHits"`
	AdditionalProperties map[string]any
}

type _SearchSynonymsResponse SearchSynonymsResponse

// NewSearchSynonymsResponse instantiates a new SearchSynonymsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSearchSynonymsResponse(hits []SynonymHit, nbHits int32) *SearchSynonymsResponse {
	this := &SearchSynonymsResponse{}
	this.Hits = hits
	this.NbHits = nbHits
	return this
}

// NewEmptySearchSynonymsResponse return a pointer to an empty SearchSynonymsResponse object.
func NewEmptySearchSynonymsResponse() *SearchSynonymsResponse {
	return &SearchSynonymsResponse{}
}

// GetHits returns the Hits field value.
func (o *SearchSynonymsResponse) GetHits() []SynonymHit {
	if o == nil {
		var ret []SynonymHit
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *SearchSynonymsResponse) GetHitsOk() ([]SynonymHit, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value.
func (o *SearchSynonymsResponse) SetHits(v []SynonymHit) *SearchSynonymsResponse {
	o.Hits = v
	return o
}

// GetNbHits returns the NbHits field value.
func (o *SearchSynonymsResponse) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *SearchSynonymsResponse) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value.
func (o *SearchSynonymsResponse) SetNbHits(v int32) *SearchSynonymsResponse {
	o.NbHits = v
	return o
}

func (o *SearchSynonymsResponse) SetAdditionalProperty(key string, value any) *SearchSynonymsResponse {
	if o.AdditionalProperties == nil {
		o.AdditionalProperties = make(map[string]any)
	}

	o.AdditionalProperties[key] = value

	return o
}

func (o SearchSynonymsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["hits"] = o.Hits
	}
	if true {
		toSerialize["nbHits"] = o.NbHits
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SearchSynonymsResponse: %w", err)
	}

	return serialized, nil
}

func (o *SearchSynonymsResponse) UnmarshalJSON(bytes []byte) error {
	varSearchSynonymsResponse := _SearchSynonymsResponse{}

	err := json.Unmarshal(bytes, &varSearchSynonymsResponse)
	if err != nil {
		return fmt.Errorf("failed to unmarshal SearchSynonymsResponse: %w", err)
	}

	*o = SearchSynonymsResponse(varSearchSynonymsResponse)

	additionalProperties := make(map[string]any)

	err = json.Unmarshal(bytes, &additionalProperties)
	if err != nil {
		return fmt.Errorf("failed to unmarshal additionalProperties in SearchSynonymsResponse: %w", err)
	}

	delete(additionalProperties, "hits")
	delete(additionalProperties, "nbHits")
	o.AdditionalProperties = additionalProperties

	return nil
}

func (o SearchSynonymsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("SearchSynonymsResponse {\n%s}", out)
}

type NullableSearchSynonymsResponse struct {
	value *SearchSynonymsResponse
	isSet bool
}

func (v NullableSearchSynonymsResponse) Get() *SearchSynonymsResponse {
	return v.value
}

func (v *NullableSearchSynonymsResponse) Set(val *SearchSynonymsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchSynonymsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchSynonymsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchSynonymsResponse(val *SearchSynonymsResponse) *NullableSearchSynonymsResponse {
	return &NullableSearchSynonymsResponse{value: val, isSet: true}
}

func (v NullableSearchSynonymsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSearchSynonymsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
