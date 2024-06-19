// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// TrendingFacetHit Trending facet hit.
type TrendingFacetHit struct {
	// Recommendation score.
	Score float64 `json:"_score"`
	// Facet attribute. To be used in combination with `facetValue`. If specified, only recommendations matching the facet filter will be returned.
	FacetName string `json:"facetName"`
	// Facet value. To be used in combination with `facetName`. If specified, only recommendations matching the facet filter will be returned.
	FacetValue string `json:"facetValue"`
}

// NewTrendingFacetHit instantiates a new TrendingFacetHit object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTrendingFacetHit(score float64, facetName string, facetValue string) *TrendingFacetHit {
	this := &TrendingFacetHit{}
	this.Score = score
	this.FacetName = facetName
	this.FacetValue = facetValue
	return this
}

// NewEmptyTrendingFacetHit return a pointer to an empty TrendingFacetHit object.
func NewEmptyTrendingFacetHit() *TrendingFacetHit {
	return &TrendingFacetHit{}
}

// GetScore returns the Score field value.
func (o *TrendingFacetHit) GetScore() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Score
}

// GetScoreOk returns a tuple with the Score field value
// and a boolean to check if the value has been set.
func (o *TrendingFacetHit) GetScoreOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Score, true
}

// SetScore sets field value.
func (o *TrendingFacetHit) SetScore(v float64) *TrendingFacetHit {
	o.Score = v
	return o
}

// GetFacetName returns the FacetName field value.
func (o *TrendingFacetHit) GetFacetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.FacetName
}

// GetFacetNameOk returns a tuple with the FacetName field value
// and a boolean to check if the value has been set.
func (o *TrendingFacetHit) GetFacetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.FacetName, true
}

// SetFacetName sets field value.
func (o *TrendingFacetHit) SetFacetName(v string) *TrendingFacetHit {
	o.FacetName = v
	return o
}

// GetFacetValue returns the FacetValue field value.
func (o *TrendingFacetHit) GetFacetValue() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.FacetValue
}

// GetFacetValueOk returns a tuple with the FacetValue field value
// and a boolean to check if the value has been set.
func (o *TrendingFacetHit) GetFacetValueOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.FacetValue, true
}

// SetFacetValue sets field value.
func (o *TrendingFacetHit) SetFacetValue(v string) *TrendingFacetHit {
	o.FacetValue = v
	return o
}

func (o TrendingFacetHit) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["_score"] = o.Score
	}
	if true {
		toSerialize["facetName"] = o.FacetName
	}
	if true {
		toSerialize["facetValue"] = o.FacetValue
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TrendingFacetHit: %w", err)
	}

	return serialized, nil
}

func (o TrendingFacetHit) String() string {
	out := ""
	out += fmt.Sprintf("  _score=%v\n", o.Score)
	out += fmt.Sprintf("  facetName=%v\n", o.FacetName)
	out += fmt.Sprintf("  facetValue=%v\n", o.FacetValue)
	return fmt.Sprintf("TrendingFacetHit {\n%s}", out)
}
