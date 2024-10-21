// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// SearchRecommendRulesParams Recommend rules parameters.
type SearchRecommendRulesParams struct {
	// Search query.
	Query *string `json:"query,omitempty"`
	// Only search for rules with matching context.
	Context *string `json:"context,omitempty"`
	// Requested page of the API response.  Algolia uses `page` and `hitsPerPage` to control how search results are displayed ([paginated](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/)).  - `hitsPerPage`: sets the number of search results (_hits_) displayed per page. - `page`: specifies the page number of the search results you want to retrieve. Page numbering starts at 0, so the first page is `page=0`, the second is `page=1`, and so on.  For example, to display 10 results per page starting from the third page, set `hitsPerPage` to 10 and `page` to 2.
	Page *int32 `json:"page,omitempty"`
	// Maximum number of hits per page.  Algolia uses `page` and `hitsPerPage` to control how search results are displayed ([paginated](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/)).  - `hitsPerPage`: sets the number of search results (_hits_) displayed per page. - `page`: specifies the page number of the search results you want to retrieve. Page numbering starts at 0, so the first page is `page=0`, the second is `page=1`, and so on.  For example, to display 10 results per page starting from the third page, set `hitsPerPage` to 10 and `page` to 2.
	HitsPerPage *int32 `json:"hitsPerPage,omitempty"`
	// Whether to only show rules where the value of their `enabled` property matches this parameter. If absent, show all rules, regardless of their `enabled` property.
	Enabled *bool `json:"enabled,omitempty"`
	// Filter expression. This only searches for rules matching the filter expression.
	Filters *string `json:"filters,omitempty"`
	// Include facets and facet values in the response. Use `['*']` to include all facets.
	Facets []string `json:"facets,omitempty"`
	// Maximum number of values to return for each facet.
	MaxValuesPerFacet *int32 `json:"maxValuesPerFacet,omitempty"`
}

type SearchRecommendRulesParamsOption func(f *SearchRecommendRulesParams)

func WithSearchRecommendRulesParamsQuery(val string) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Query = &val
	}
}

func WithSearchRecommendRulesParamsContext(val string) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Context = &val
	}
}

func WithSearchRecommendRulesParamsPage(val int32) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Page = &val
	}
}

func WithSearchRecommendRulesParamsHitsPerPage(val int32) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.HitsPerPage = &val
	}
}

func WithSearchRecommendRulesParamsEnabled(val bool) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Enabled = &val
	}
}

func WithSearchRecommendRulesParamsFilters(val string) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Filters = &val
	}
}

func WithSearchRecommendRulesParamsFacets(val []string) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.Facets = val
	}
}

func WithSearchRecommendRulesParamsMaxValuesPerFacet(val int32) SearchRecommendRulesParamsOption {
	return func(f *SearchRecommendRulesParams) {
		f.MaxValuesPerFacet = &val
	}
}

// NewSearchRecommendRulesParams instantiates a new SearchRecommendRulesParams object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSearchRecommendRulesParams(opts ...SearchRecommendRulesParamsOption) *SearchRecommendRulesParams {
	this := &SearchRecommendRulesParams{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySearchRecommendRulesParams return a pointer to an empty SearchRecommendRulesParams object.
func NewEmptySearchRecommendRulesParams() *SearchRecommendRulesParams {
	return &SearchRecommendRulesParams{}
}

// GetQuery returns the Query field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetQuery() string {
	if o == nil || o.Query == nil {
		var ret string
		return ret
	}
	return *o.Query
}

// GetQueryOk returns a tuple with the Query field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetQueryOk() (*string, bool) {
	if o == nil || o.Query == nil {
		return nil, false
	}
	return o.Query, true
}

// HasQuery returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasQuery() bool {
	if o != nil && o.Query != nil {
		return true
	}

	return false
}

// SetQuery gets a reference to the given string and assigns it to the Query field.
func (o *SearchRecommendRulesParams) SetQuery(v string) *SearchRecommendRulesParams {
	o.Query = &v
	return o
}

// GetContext returns the Context field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetContext() string {
	if o == nil || o.Context == nil {
		var ret string
		return ret
	}
	return *o.Context
}

// GetContextOk returns a tuple with the Context field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetContextOk() (*string, bool) {
	if o == nil || o.Context == nil {
		return nil, false
	}
	return o.Context, true
}

// HasContext returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasContext() bool {
	if o != nil && o.Context != nil {
		return true
	}

	return false
}

// SetContext gets a reference to the given string and assigns it to the Context field.
func (o *SearchRecommendRulesParams) SetContext(v string) *SearchRecommendRulesParams {
	o.Context = &v
	return o
}

// GetPage returns the Page field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetPage() int32 {
	if o == nil || o.Page == nil {
		var ret int32
		return ret
	}
	return *o.Page
}

// GetPageOk returns a tuple with the Page field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetPageOk() (*int32, bool) {
	if o == nil || o.Page == nil {
		return nil, false
	}
	return o.Page, true
}

// HasPage returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasPage() bool {
	if o != nil && o.Page != nil {
		return true
	}

	return false
}

// SetPage gets a reference to the given int32 and assigns it to the Page field.
func (o *SearchRecommendRulesParams) SetPage(v int32) *SearchRecommendRulesParams {
	o.Page = &v
	return o
}

// GetHitsPerPage returns the HitsPerPage field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetHitsPerPage() int32 {
	if o == nil || o.HitsPerPage == nil {
		var ret int32
		return ret
	}
	return *o.HitsPerPage
}

// GetHitsPerPageOk returns a tuple with the HitsPerPage field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetHitsPerPageOk() (*int32, bool) {
	if o == nil || o.HitsPerPage == nil {
		return nil, false
	}
	return o.HitsPerPage, true
}

// HasHitsPerPage returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasHitsPerPage() bool {
	if o != nil && o.HitsPerPage != nil {
		return true
	}

	return false
}

// SetHitsPerPage gets a reference to the given int32 and assigns it to the HitsPerPage field.
func (o *SearchRecommendRulesParams) SetHitsPerPage(v int32) *SearchRecommendRulesParams {
	o.HitsPerPage = &v
	return o
}

// GetEnabled returns the Enabled field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetEnabled() bool {
	if o == nil || o.Enabled == nil {
		var ret bool
		return ret
	}
	return *o.Enabled
}

// GetEnabledOk returns a tuple with the Enabled field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetEnabledOk() (*bool, bool) {
	if o == nil || o.Enabled == nil {
		return nil, false
	}
	return o.Enabled, true
}

// HasEnabled returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasEnabled() bool {
	if o != nil && o.Enabled != nil {
		return true
	}

	return false
}

// SetEnabled gets a reference to the given bool and assigns it to the Enabled field.
func (o *SearchRecommendRulesParams) SetEnabled(v bool) *SearchRecommendRulesParams {
	o.Enabled = &v
	return o
}

// GetFilters returns the Filters field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetFilters() string {
	if o == nil || o.Filters == nil {
		var ret string
		return ret
	}
	return *o.Filters
}

// GetFiltersOk returns a tuple with the Filters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetFiltersOk() (*string, bool) {
	if o == nil || o.Filters == nil {
		return nil, false
	}
	return o.Filters, true
}

// HasFilters returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasFilters() bool {
	if o != nil && o.Filters != nil {
		return true
	}

	return false
}

// SetFilters gets a reference to the given string and assigns it to the Filters field.
func (o *SearchRecommendRulesParams) SetFilters(v string) *SearchRecommendRulesParams {
	o.Filters = &v
	return o
}

// GetFacets returns the Facets field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetFacets() []string {
	if o == nil || o.Facets == nil {
		var ret []string
		return ret
	}
	return o.Facets
}

// GetFacetsOk returns a tuple with the Facets field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetFacetsOk() ([]string, bool) {
	if o == nil || o.Facets == nil {
		return nil, false
	}
	return o.Facets, true
}

// HasFacets returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasFacets() bool {
	if o != nil && o.Facets != nil {
		return true
	}

	return false
}

// SetFacets gets a reference to the given []string and assigns it to the Facets field.
func (o *SearchRecommendRulesParams) SetFacets(v []string) *SearchRecommendRulesParams {
	o.Facets = v
	return o
}

// GetMaxValuesPerFacet returns the MaxValuesPerFacet field value if set, zero value otherwise.
func (o *SearchRecommendRulesParams) GetMaxValuesPerFacet() int32 {
	if o == nil || o.MaxValuesPerFacet == nil {
		var ret int32
		return ret
	}
	return *o.MaxValuesPerFacet
}

// GetMaxValuesPerFacetOk returns a tuple with the MaxValuesPerFacet field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchRecommendRulesParams) GetMaxValuesPerFacetOk() (*int32, bool) {
	if o == nil || o.MaxValuesPerFacet == nil {
		return nil, false
	}
	return o.MaxValuesPerFacet, true
}

// HasMaxValuesPerFacet returns a boolean if a field has been set.
func (o *SearchRecommendRulesParams) HasMaxValuesPerFacet() bool {
	if o != nil && o.MaxValuesPerFacet != nil {
		return true
	}

	return false
}

// SetMaxValuesPerFacet gets a reference to the given int32 and assigns it to the MaxValuesPerFacet field.
func (o *SearchRecommendRulesParams) SetMaxValuesPerFacet(v int32) *SearchRecommendRulesParams {
	o.MaxValuesPerFacet = &v
	return o
}

func (o SearchRecommendRulesParams) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Query != nil {
		toSerialize["query"] = o.Query
	}
	if o.Context != nil {
		toSerialize["context"] = o.Context
	}
	if o.Page != nil {
		toSerialize["page"] = o.Page
	}
	if o.HitsPerPage != nil {
		toSerialize["hitsPerPage"] = o.HitsPerPage
	}
	if o.Enabled != nil {
		toSerialize["enabled"] = o.Enabled
	}
	if o.Filters != nil {
		toSerialize["filters"] = o.Filters
	}
	if o.Facets != nil {
		toSerialize["facets"] = o.Facets
	}
	if o.MaxValuesPerFacet != nil {
		toSerialize["maxValuesPerFacet"] = o.MaxValuesPerFacet
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SearchRecommendRulesParams: %w", err)
	}

	return serialized, nil
}

func (o SearchRecommendRulesParams) String() string {
	out := ""
	out += fmt.Sprintf("  query=%v\n", o.Query)
	out += fmt.Sprintf("  context=%v\n", o.Context)
	out += fmt.Sprintf("  page=%v\n", o.Page)
	out += fmt.Sprintf("  hitsPerPage=%v\n", o.HitsPerPage)
	out += fmt.Sprintf("  enabled=%v\n", o.Enabled)
	out += fmt.Sprintf("  filters=%v\n", o.Filters)
	out += fmt.Sprintf("  facets=%v\n", o.Facets)
	out += fmt.Sprintf("  maxValuesPerFacet=%v\n", o.MaxValuesPerFacet)
	return fmt.Sprintf("SearchRecommendRulesParams {\n%s}", out)
}
