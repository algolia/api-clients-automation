// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package composition

import (
	"encoding/json"
	"fmt"
)

// Exhaustive Whether certain properties of the search response are calculated exhaustive (exact) or approximated.
type Exhaustive struct {
	// Whether the facet count is exhaustive (`true`) or approximate (`false`). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
	FacetsCount *bool `json:"facetsCount,omitempty"`
	// The value is `false` if not all facet values are retrieved.
	FacetValues *bool `json:"facetValues,omitempty"`
	// Whether the `nbHits` is exhaustive (`true`) or approximate (`false`). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). `nbHits` is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.
	NbHits *bool `json:"nbHits,omitempty"`
	// Rules matching exhaustivity. The value is `false` if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.
	RulesMatch *bool `json:"rulesMatch,omitempty"`
	// Whether the typo search was exhaustive (`true`) or approximate (`false`). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.
	Typo *bool `json:"typo,omitempty"`
}

type ExhaustiveOption func(f *Exhaustive)

func WithExhaustiveFacetsCount(val bool) ExhaustiveOption {
	return func(f *Exhaustive) {
		f.FacetsCount = &val
	}
}

func WithExhaustiveFacetValues(val bool) ExhaustiveOption {
	return func(f *Exhaustive) {
		f.FacetValues = &val
	}
}

func WithExhaustiveNbHits(val bool) ExhaustiveOption {
	return func(f *Exhaustive) {
		f.NbHits = &val
	}
}

func WithExhaustiveRulesMatch(val bool) ExhaustiveOption {
	return func(f *Exhaustive) {
		f.RulesMatch = &val
	}
}

func WithExhaustiveTypo(val bool) ExhaustiveOption {
	return func(f *Exhaustive) {
		f.Typo = &val
	}
}

// NewExhaustive instantiates a new Exhaustive object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewExhaustive(opts ...ExhaustiveOption) *Exhaustive {
	this := &Exhaustive{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyExhaustive return a pointer to an empty Exhaustive object.
func NewEmptyExhaustive() *Exhaustive {
	return &Exhaustive{}
}

// GetFacetsCount returns the FacetsCount field value if set, zero value otherwise.
func (o *Exhaustive) GetFacetsCount() bool {
	if o == nil || o.FacetsCount == nil {
		var ret bool
		return ret
	}
	return *o.FacetsCount
}

// GetFacetsCountOk returns a tuple with the FacetsCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Exhaustive) GetFacetsCountOk() (*bool, bool) {
	if o == nil || o.FacetsCount == nil {
		return nil, false
	}
	return o.FacetsCount, true
}

// HasFacetsCount returns a boolean if a field has been set.
func (o *Exhaustive) HasFacetsCount() bool {
	if o != nil && o.FacetsCount != nil {
		return true
	}

	return false
}

// SetFacetsCount gets a reference to the given bool and assigns it to the FacetsCount field.
func (o *Exhaustive) SetFacetsCount(v bool) *Exhaustive {
	o.FacetsCount = &v
	return o
}

// GetFacetValues returns the FacetValues field value if set, zero value otherwise.
func (o *Exhaustive) GetFacetValues() bool {
	if o == nil || o.FacetValues == nil {
		var ret bool
		return ret
	}
	return *o.FacetValues
}

// GetFacetValuesOk returns a tuple with the FacetValues field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Exhaustive) GetFacetValuesOk() (*bool, bool) {
	if o == nil || o.FacetValues == nil {
		return nil, false
	}
	return o.FacetValues, true
}

// HasFacetValues returns a boolean if a field has been set.
func (o *Exhaustive) HasFacetValues() bool {
	if o != nil && o.FacetValues != nil {
		return true
	}

	return false
}

// SetFacetValues gets a reference to the given bool and assigns it to the FacetValues field.
func (o *Exhaustive) SetFacetValues(v bool) *Exhaustive {
	o.FacetValues = &v
	return o
}

// GetNbHits returns the NbHits field value if set, zero value otherwise.
func (o *Exhaustive) GetNbHits() bool {
	if o == nil || o.NbHits == nil {
		var ret bool
		return ret
	}
	return *o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Exhaustive) GetNbHitsOk() (*bool, bool) {
	if o == nil || o.NbHits == nil {
		return nil, false
	}
	return o.NbHits, true
}

// HasNbHits returns a boolean if a field has been set.
func (o *Exhaustive) HasNbHits() bool {
	if o != nil && o.NbHits != nil {
		return true
	}

	return false
}

// SetNbHits gets a reference to the given bool and assigns it to the NbHits field.
func (o *Exhaustive) SetNbHits(v bool) *Exhaustive {
	o.NbHits = &v
	return o
}

// GetRulesMatch returns the RulesMatch field value if set, zero value otherwise.
func (o *Exhaustive) GetRulesMatch() bool {
	if o == nil || o.RulesMatch == nil {
		var ret bool
		return ret
	}
	return *o.RulesMatch
}

// GetRulesMatchOk returns a tuple with the RulesMatch field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Exhaustive) GetRulesMatchOk() (*bool, bool) {
	if o == nil || o.RulesMatch == nil {
		return nil, false
	}
	return o.RulesMatch, true
}

// HasRulesMatch returns a boolean if a field has been set.
func (o *Exhaustive) HasRulesMatch() bool {
	if o != nil && o.RulesMatch != nil {
		return true
	}

	return false
}

// SetRulesMatch gets a reference to the given bool and assigns it to the RulesMatch field.
func (o *Exhaustive) SetRulesMatch(v bool) *Exhaustive {
	o.RulesMatch = &v
	return o
}

// GetTypo returns the Typo field value if set, zero value otherwise.
func (o *Exhaustive) GetTypo() bool {
	if o == nil || o.Typo == nil {
		var ret bool
		return ret
	}
	return *o.Typo
}

// GetTypoOk returns a tuple with the Typo field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Exhaustive) GetTypoOk() (*bool, bool) {
	if o == nil || o.Typo == nil {
		return nil, false
	}
	return o.Typo, true
}

// HasTypo returns a boolean if a field has been set.
func (o *Exhaustive) HasTypo() bool {
	if o != nil && o.Typo != nil {
		return true
	}

	return false
}

// SetTypo gets a reference to the given bool and assigns it to the Typo field.
func (o *Exhaustive) SetTypo(v bool) *Exhaustive {
	o.Typo = &v
	return o
}

func (o Exhaustive) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.FacetsCount != nil {
		toSerialize["facetsCount"] = o.FacetsCount
	}
	if o.FacetValues != nil {
		toSerialize["facetValues"] = o.FacetValues
	}
	if o.NbHits != nil {
		toSerialize["nbHits"] = o.NbHits
	}
	if o.RulesMatch != nil {
		toSerialize["rulesMatch"] = o.RulesMatch
	}
	if o.Typo != nil {
		toSerialize["typo"] = o.Typo
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Exhaustive: %w", err)
	}

	return serialized, nil
}

func (o Exhaustive) String() string {
	out := ""
	out += fmt.Sprintf("  facetsCount=%v\n", o.FacetsCount)
	out += fmt.Sprintf("  facetValues=%v\n", o.FacetValues)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	out += fmt.Sprintf("  rulesMatch=%v\n", o.RulesMatch)
	out += fmt.Sprintf("  typo=%v\n", o.Typo)
	return fmt.Sprintf("Exhaustive {\n%s}", out)
}
