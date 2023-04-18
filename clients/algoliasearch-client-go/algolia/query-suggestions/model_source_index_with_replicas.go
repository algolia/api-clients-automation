// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package suggestions

import (
	"encoding/json"
	"fmt"
)

// SourceIndexWithReplicas Source index with replicas used to generate a Query Suggestions index.
type SourceIndexWithReplicas struct {
	// true if the Query Suggestions index is a replicas.
	Replicas bool `json:"replicas"`
	// Source index name.
	IndexName string `json:"indexName"`
	// List of analytics tags to filter the popular searches per tag.
	AnalyticsTags []string `json:"analyticsTags"`
	// List of facets to define as categories for the query suggestions.
	Facets []map[string]interface{} `json:"facets"`
	// Minimum number of hits (e.g., matching records in the source index) to generate a suggestions.
	MinHits int32 `json:"minHits"`
	// Minimum number of required letters for a suggestion to remain.
	MinLetters int32 `json:"minLetters"`
	// List of facet attributes used to generate Query Suggestions. The resulting suggestions are every combination of the facets in the nested list (e.g., (facetA and facetB) and facetC).
	Generate [][]string `json:"generate"`
	// List of external indices to use to generate custom Query Suggestions.
	External []SourceIndexExternal `json:"external"`
}

// NewSourceIndexWithReplicas instantiates a new SourceIndexWithReplicas object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewSourceIndexWithReplicas(replicas bool, indexName string, analyticsTags []string, facets []map[string]interface{}, minHits int32, minLetters int32, generate [][]string, external []SourceIndexExternal) *SourceIndexWithReplicas {
	this := &SourceIndexWithReplicas{}
	this.Replicas = replicas
	this.IndexName = indexName
	this.AnalyticsTags = analyticsTags
	this.Facets = facets
	this.MinHits = minHits
	this.MinLetters = minLetters
	this.Generate = generate
	this.External = external
	return this
}

// NewSourceIndexWithReplicasWithDefaults instantiates a new SourceIndexWithReplicas object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewSourceIndexWithReplicasWithDefaults() *SourceIndexWithReplicas {
	this := &SourceIndexWithReplicas{}
	return this
}

// GetReplicas returns the Replicas field value
func (o *SourceIndexWithReplicas) GetReplicas() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.Replicas
}

// GetReplicasOk returns a tuple with the Replicas field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetReplicasOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Replicas, true
}

// SetReplicas sets field value
func (o *SourceIndexWithReplicas) SetReplicas(v bool) {
	o.Replicas = v
}

// GetIndexName returns the IndexName field value
func (o *SourceIndexWithReplicas) GetIndexName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetIndexNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexName, true
}

// SetIndexName sets field value
func (o *SourceIndexWithReplicas) SetIndexName(v string) {
	o.IndexName = v
}

// GetAnalyticsTags returns the AnalyticsTags field value
func (o *SourceIndexWithReplicas) GetAnalyticsTags() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.AnalyticsTags
}

// GetAnalyticsTagsOk returns a tuple with the AnalyticsTags field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetAnalyticsTagsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.AnalyticsTags, true
}

// SetAnalyticsTags sets field value
func (o *SourceIndexWithReplicas) SetAnalyticsTags(v []string) {
	o.AnalyticsTags = v
}

// GetFacets returns the Facets field value
func (o *SourceIndexWithReplicas) GetFacets() []map[string]interface{} {
	if o == nil {
		var ret []map[string]interface{}
		return ret
	}

	return o.Facets
}

// GetFacetsOk returns a tuple with the Facets field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetFacetsOk() ([]map[string]interface{}, bool) {
	if o == nil {
		return nil, false
	}
	return o.Facets, true
}

// SetFacets sets field value
func (o *SourceIndexWithReplicas) SetFacets(v []map[string]interface{}) {
	o.Facets = v
}

// GetMinHits returns the MinHits field value
func (o *SourceIndexWithReplicas) GetMinHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.MinHits
}

// GetMinHitsOk returns a tuple with the MinHits field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetMinHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.MinHits, true
}

// SetMinHits sets field value
func (o *SourceIndexWithReplicas) SetMinHits(v int32) {
	o.MinHits = v
}

// GetMinLetters returns the MinLetters field value
func (o *SourceIndexWithReplicas) GetMinLetters() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.MinLetters
}

// GetMinLettersOk returns a tuple with the MinLetters field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetMinLettersOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.MinLetters, true
}

// SetMinLetters sets field value
func (o *SourceIndexWithReplicas) SetMinLetters(v int32) {
	o.MinLetters = v
}

// GetGenerate returns the Generate field value
func (o *SourceIndexWithReplicas) GetGenerate() [][]string {
	if o == nil {
		var ret [][]string
		return ret
	}

	return o.Generate
}

// GetGenerateOk returns a tuple with the Generate field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetGenerateOk() ([][]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.Generate, true
}

// SetGenerate sets field value
func (o *SourceIndexWithReplicas) SetGenerate(v [][]string) {
	o.Generate = v
}

// GetExternal returns the External field value
func (o *SourceIndexWithReplicas) GetExternal() []SourceIndexExternal {
	if o == nil {
		var ret []SourceIndexExternal
		return ret
	}

	return o.External
}

// GetExternalOk returns a tuple with the External field value
// and a boolean to check if the value has been set.
func (o *SourceIndexWithReplicas) GetExternalOk() ([]SourceIndexExternal, bool) {
	if o == nil {
		return nil, false
	}
	return o.External, true
}

// SetExternal sets field value
func (o *SourceIndexWithReplicas) SetExternal(v []SourceIndexExternal) {
	o.External = v
}

func (o SourceIndexWithReplicas) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["replicas"] = o.Replicas
	}
	if true {
		toSerialize["indexName"] = o.IndexName
	}
	if true {
		toSerialize["analyticsTags"] = o.AnalyticsTags
	}
	if true {
		toSerialize["facets"] = o.Facets
	}
	if true {
		toSerialize["minHits"] = o.MinHits
	}
	if true {
		toSerialize["minLetters"] = o.MinLetters
	}
	if true {
		toSerialize["generate"] = o.Generate
	}
	if true {
		toSerialize["external"] = o.External
	}
	return json.Marshal(toSerialize)
}

func (o SourceIndexWithReplicas) String() string {
	out := ""
	out += fmt.Sprintf("  replicas=%v\n", o.Replicas)
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	out += fmt.Sprintf("  analyticsTags=%v\n", o.AnalyticsTags)
	out += fmt.Sprintf("  facets=%v\n", o.Facets)
	out += fmt.Sprintf("  minHits=%v\n", o.MinHits)
	out += fmt.Sprintf("  minLetters=%v\n", o.MinLetters)
	out += fmt.Sprintf("  generate=%v\n", o.Generate)
	out += fmt.Sprintf("  external=%v\n", o.External)
	return fmt.Sprintf("SourceIndexWithReplicas {\n%s}", out)
}

type NullableSourceIndexWithReplicas struct {
	value *SourceIndexWithReplicas
	isSet bool
}

func (v NullableSourceIndexWithReplicas) Get() *SourceIndexWithReplicas {
	return v.value
}

func (v *NullableSourceIndexWithReplicas) Set(val *SourceIndexWithReplicas) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceIndexWithReplicas) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceIndexWithReplicas) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceIndexWithReplicas(val *SourceIndexWithReplicas) *NullableSourceIndexWithReplicas {
	return &NullableSourceIndexWithReplicas{value: val, isSet: true}
}

func (v NullableSourceIndexWithReplicas) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSourceIndexWithReplicas) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
