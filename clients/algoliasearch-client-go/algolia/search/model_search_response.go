// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SearchResponse struct for SearchResponse.
type SearchResponse struct {
	// A/B test ID. This is only included in the response for indices that are part of an A/B test.
	AbTestID *int32 `json:"abTestID,omitempty"`
	// Variant ID. This is only included in the response for indices that are part of an A/B test.
	AbTestVariantID *int32 `json:"abTestVariantID,omitempty"`
	// Computed geographical location.
	AroundLatLng *string `json:"aroundLatLng,omitempty"`
	// Automatically-computed radius.
	AutomaticRadius *string     `json:"automaticRadius,omitempty"`
	Exhaustive      *Exhaustive `json:"exhaustive,omitempty"`
	// See the `facetsCount` field of the `exhaustive` object in the response.
	// Deprecated
	ExhaustiveFacetsCount *bool `json:"exhaustiveFacetsCount,omitempty"`
	// See the `nbHits` field of the `exhaustive` object in the response.
	// Deprecated
	ExhaustiveNbHits *bool `json:"exhaustiveNbHits,omitempty"`
	// See the `typo` field of the `exhaustive` object in the response.
	// Deprecated
	ExhaustiveTypo *bool `json:"exhaustiveTypo,omitempty"`
	// Mapping of each facet name to the corresponding facet counts.
	Facets *map[string]map[string]int32 `json:"facets,omitempty"`
	// Statistics for numerical facets.
	FacetsStats *map[string]FacetsStats `json:"facets_stats,omitempty"`
	// Number of hits per page.
	HitsPerPage int32 `json:"hitsPerPage"`
	// Index name used for the query.
	Index *string `json:"index,omitempty"`
	// Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
	IndexUsed *string `json:"indexUsed,omitempty"`
	// Warnings about the query.
	Message *string `json:"message,omitempty"`
	// Number of hits the search query matched.
	NbHits int32 `json:"nbHits"`
	// Number of pages of results for the current query.
	NbPages int32 `json:"nbPages"`
	// Number of hits selected and sorted by the relevant sort algorithm.
	NbSortedHits *int32 `json:"nbSortedHits,omitempty"`
	// Page to retrieve (the first page is `0`, not `1`).
	Page int32 `json:"page"`
	// Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
	ParsedQuery *string `json:"parsedQuery,omitempty"`
	// Time the server took to process the request, in milliseconds.
	ProcessingTimeMS int32 `json:"processingTimeMS"`
	// Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.
	ProcessingTimingsMS map[string]interface{} `json:"processingTimingsMS,omitempty"`
	// Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
	QueryAfterRemoval *string           `json:"queryAfterRemoval,omitempty"`
	Redirect          *Redirect         `json:"redirect,omitempty"`
	RenderingContent  *RenderingContent `json:"renderingContent,omitempty"`
	// Time the server took to process the request, in milliseconds.
	ServerTimeMS *int32 `json:"serverTimeMS,omitempty"`
	// Host name of the server that processed the request.
	ServerUsed *string `json:"serverUsed,omitempty"`
	// Lets you store custom data in your indices.
	UserData map[string]interface{} `json:"userData,omitempty"`
	Hits     []Hit                  `json:"hits"`
	// Text to search for in an index.
	Query string `json:"query"`
	// URL-encoded string of all search parameters.
	Params               string `json:"params"`
	AdditionalProperties map[string]any
}

type _SearchResponse SearchResponse

type SearchResponseOption func(f *SearchResponse)

func WithSearchResponseAbTestID(val int32) SearchResponseOption {
	return func(f *SearchResponse) {
		f.AbTestID = &val
	}
}

func WithSearchResponseAbTestVariantID(val int32) SearchResponseOption {
	return func(f *SearchResponse) {
		f.AbTestVariantID = &val
	}
}

func WithSearchResponseAroundLatLng(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.AroundLatLng = &val
	}
}

func WithSearchResponseAutomaticRadius(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.AutomaticRadius = &val
	}
}

func WithSearchResponseExhaustive(val Exhaustive) SearchResponseOption {
	return func(f *SearchResponse) {
		f.Exhaustive = &val
	}
}

func WithSearchResponseExhaustiveFacetsCount(val bool) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ExhaustiveFacetsCount = &val
	}
}

func WithSearchResponseExhaustiveNbHits(val bool) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ExhaustiveNbHits = &val
	}
}

func WithSearchResponseExhaustiveTypo(val bool) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ExhaustiveTypo = &val
	}
}

func WithSearchResponseFacets(val map[string]map[string]int32) SearchResponseOption {
	return func(f *SearchResponse) {
		f.Facets = &val
	}
}

func WithSearchResponseFacetsStats(val map[string]FacetsStats) SearchResponseOption {
	return func(f *SearchResponse) {
		f.FacetsStats = &val
	}
}

func WithSearchResponseIndex(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.Index = &val
	}
}

func WithSearchResponseIndexUsed(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.IndexUsed = &val
	}
}

func WithSearchResponseMessage(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.Message = &val
	}
}

func WithSearchResponseNbSortedHits(val int32) SearchResponseOption {
	return func(f *SearchResponse) {
		f.NbSortedHits = &val
	}
}

func WithSearchResponseParsedQuery(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ParsedQuery = &val
	}
}

func WithSearchResponseProcessingTimingsMS(val map[string]interface{}) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ProcessingTimingsMS = val
	}
}

func WithSearchResponseQueryAfterRemoval(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.QueryAfterRemoval = &val
	}
}

func WithSearchResponseRedirect(val Redirect) SearchResponseOption {
	return func(f *SearchResponse) {
		f.Redirect = &val
	}
}

func WithSearchResponseRenderingContent(val RenderingContent) SearchResponseOption {
	return func(f *SearchResponse) {
		f.RenderingContent = &val
	}
}

func WithSearchResponseServerTimeMS(val int32) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ServerTimeMS = &val
	}
}

func WithSearchResponseServerUsed(val string) SearchResponseOption {
	return func(f *SearchResponse) {
		f.ServerUsed = &val
	}
}

func WithSearchResponseUserData(val map[string]interface{}) SearchResponseOption {
	return func(f *SearchResponse) {
		f.UserData = val
	}
}

// NewSearchResponse instantiates a new SearchResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSearchResponse(hitsPerPage int32, nbHits int32, nbPages int32, page int32, processingTimeMS int32, hits []Hit, query string, params string, opts ...SearchResponseOption) *SearchResponse {
	this := &SearchResponse{}
	this.HitsPerPage = hitsPerPage
	this.NbHits = nbHits
	this.NbPages = nbPages
	this.Page = page
	this.ProcessingTimeMS = processingTimeMS
	this.Hits = hits
	this.Query = query
	this.Params = params
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewSearchResponseWithDefaults instantiates a new SearchResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set.
func NewSearchResponseWithDefaults() *SearchResponse {
	this := &SearchResponse{}
	var hitsPerPage int32 = 20
	this.HitsPerPage = hitsPerPage
	var page int32 = 0
	this.Page = page
	var query string = ""
	this.Query = query
	return this
}

// GetAbTestID returns the AbTestID field value if set, zero value otherwise.
func (o *SearchResponse) GetAbTestID() int32 {
	if o == nil || o.AbTestID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestID
}

// GetAbTestIDOk returns a tuple with the AbTestID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetAbTestIDOk() (*int32, bool) {
	if o == nil || o.AbTestID == nil {
		return nil, false
	}
	return o.AbTestID, true
}

// HasAbTestID returns a boolean if a field has been set.
func (o *SearchResponse) HasAbTestID() bool {
	if o != nil && o.AbTestID != nil {
		return true
	}

	return false
}

// SetAbTestID gets a reference to the given int32 and assigns it to the AbTestID field.
func (o *SearchResponse) SetAbTestID(v int32) {
	o.AbTestID = &v
}

// GetAbTestVariantID returns the AbTestVariantID field value if set, zero value otherwise.
func (o *SearchResponse) GetAbTestVariantID() int32 {
	if o == nil || o.AbTestVariantID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestVariantID
}

// GetAbTestVariantIDOk returns a tuple with the AbTestVariantID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetAbTestVariantIDOk() (*int32, bool) {
	if o == nil || o.AbTestVariantID == nil {
		return nil, false
	}
	return o.AbTestVariantID, true
}

// HasAbTestVariantID returns a boolean if a field has been set.
func (o *SearchResponse) HasAbTestVariantID() bool {
	if o != nil && o.AbTestVariantID != nil {
		return true
	}

	return false
}

// SetAbTestVariantID gets a reference to the given int32 and assigns it to the AbTestVariantID field.
func (o *SearchResponse) SetAbTestVariantID(v int32) {
	o.AbTestVariantID = &v
}

// GetAroundLatLng returns the AroundLatLng field value if set, zero value otherwise.
func (o *SearchResponse) GetAroundLatLng() string {
	if o == nil || o.AroundLatLng == nil {
		var ret string
		return ret
	}
	return *o.AroundLatLng
}

// GetAroundLatLngOk returns a tuple with the AroundLatLng field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetAroundLatLngOk() (*string, bool) {
	if o == nil || o.AroundLatLng == nil {
		return nil, false
	}
	return o.AroundLatLng, true
}

// HasAroundLatLng returns a boolean if a field has been set.
func (o *SearchResponse) HasAroundLatLng() bool {
	if o != nil && o.AroundLatLng != nil {
		return true
	}

	return false
}

// SetAroundLatLng gets a reference to the given string and assigns it to the AroundLatLng field.
func (o *SearchResponse) SetAroundLatLng(v string) {
	o.AroundLatLng = &v
}

// GetAutomaticRadius returns the AutomaticRadius field value if set, zero value otherwise.
func (o *SearchResponse) GetAutomaticRadius() string {
	if o == nil || o.AutomaticRadius == nil {
		var ret string
		return ret
	}
	return *o.AutomaticRadius
}

// GetAutomaticRadiusOk returns a tuple with the AutomaticRadius field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetAutomaticRadiusOk() (*string, bool) {
	if o == nil || o.AutomaticRadius == nil {
		return nil, false
	}
	return o.AutomaticRadius, true
}

// HasAutomaticRadius returns a boolean if a field has been set.
func (o *SearchResponse) HasAutomaticRadius() bool {
	if o != nil && o.AutomaticRadius != nil {
		return true
	}

	return false
}

// SetAutomaticRadius gets a reference to the given string and assigns it to the AutomaticRadius field.
func (o *SearchResponse) SetAutomaticRadius(v string) {
	o.AutomaticRadius = &v
}

// GetExhaustive returns the Exhaustive field value if set, zero value otherwise.
func (o *SearchResponse) GetExhaustive() Exhaustive {
	if o == nil || o.Exhaustive == nil {
		var ret Exhaustive
		return ret
	}
	return *o.Exhaustive
}

// GetExhaustiveOk returns a tuple with the Exhaustive field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetExhaustiveOk() (*Exhaustive, bool) {
	if o == nil || o.Exhaustive == nil {
		return nil, false
	}
	return o.Exhaustive, true
}

// HasExhaustive returns a boolean if a field has been set.
func (o *SearchResponse) HasExhaustive() bool {
	if o != nil && o.Exhaustive != nil {
		return true
	}

	return false
}

// SetExhaustive gets a reference to the given Exhaustive and assigns it to the Exhaustive field.
func (o *SearchResponse) SetExhaustive(v Exhaustive) {
	o.Exhaustive = &v
}

// GetExhaustiveFacetsCount returns the ExhaustiveFacetsCount field value if set, zero value otherwise.
// Deprecated.
func (o *SearchResponse) GetExhaustiveFacetsCount() bool {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveFacetsCount
}

// GetExhaustiveFacetsCountOk returns a tuple with the ExhaustiveFacetsCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated.
func (o *SearchResponse) GetExhaustiveFacetsCountOk() (*bool, bool) {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		return nil, false
	}
	return o.ExhaustiveFacetsCount, true
}

// HasExhaustiveFacetsCount returns a boolean if a field has been set.
func (o *SearchResponse) HasExhaustiveFacetsCount() bool {
	if o != nil && o.ExhaustiveFacetsCount != nil {
		return true
	}

	return false
}

// SetExhaustiveFacetsCount gets a reference to the given bool and assigns it to the ExhaustiveFacetsCount field.
// Deprecated.
func (o *SearchResponse) SetExhaustiveFacetsCount(v bool) {
	o.ExhaustiveFacetsCount = &v
}

// GetExhaustiveNbHits returns the ExhaustiveNbHits field value if set, zero value otherwise.
// Deprecated.
func (o *SearchResponse) GetExhaustiveNbHits() bool {
	if o == nil || o.ExhaustiveNbHits == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveNbHits
}

// GetExhaustiveNbHitsOk returns a tuple with the ExhaustiveNbHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated.
func (o *SearchResponse) GetExhaustiveNbHitsOk() (*bool, bool) {
	if o == nil || o.ExhaustiveNbHits == nil {
		return nil, false
	}
	return o.ExhaustiveNbHits, true
}

// HasExhaustiveNbHits returns a boolean if a field has been set.
func (o *SearchResponse) HasExhaustiveNbHits() bool {
	if o != nil && o.ExhaustiveNbHits != nil {
		return true
	}

	return false
}

// SetExhaustiveNbHits gets a reference to the given bool and assigns it to the ExhaustiveNbHits field.
// Deprecated.
func (o *SearchResponse) SetExhaustiveNbHits(v bool) {
	o.ExhaustiveNbHits = &v
}

// GetExhaustiveTypo returns the ExhaustiveTypo field value if set, zero value otherwise.
// Deprecated.
func (o *SearchResponse) GetExhaustiveTypo() bool {
	if o == nil || o.ExhaustiveTypo == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveTypo
}

// GetExhaustiveTypoOk returns a tuple with the ExhaustiveTypo field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated.
func (o *SearchResponse) GetExhaustiveTypoOk() (*bool, bool) {
	if o == nil || o.ExhaustiveTypo == nil {
		return nil, false
	}
	return o.ExhaustiveTypo, true
}

// HasExhaustiveTypo returns a boolean if a field has been set.
func (o *SearchResponse) HasExhaustiveTypo() bool {
	if o != nil && o.ExhaustiveTypo != nil {
		return true
	}

	return false
}

// SetExhaustiveTypo gets a reference to the given bool and assigns it to the ExhaustiveTypo field.
// Deprecated.
func (o *SearchResponse) SetExhaustiveTypo(v bool) {
	o.ExhaustiveTypo = &v
}

// GetFacets returns the Facets field value if set, zero value otherwise.
func (o *SearchResponse) GetFacets() map[string]map[string]int32 {
	if o == nil || o.Facets == nil {
		var ret map[string]map[string]int32
		return ret
	}
	return *o.Facets
}

// GetFacetsOk returns a tuple with the Facets field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetFacetsOk() (*map[string]map[string]int32, bool) {
	if o == nil || o.Facets == nil {
		return nil, false
	}
	return o.Facets, true
}

// HasFacets returns a boolean if a field has been set.
func (o *SearchResponse) HasFacets() bool {
	if o != nil && o.Facets != nil {
		return true
	}

	return false
}

// SetFacets gets a reference to the given map[string]map[string]int32 and assigns it to the Facets field.
func (o *SearchResponse) SetFacets(v map[string]map[string]int32) {
	o.Facets = &v
}

// GetFacetsStats returns the FacetsStats field value if set, zero value otherwise.
func (o *SearchResponse) GetFacetsStats() map[string]FacetsStats {
	if o == nil || o.FacetsStats == nil {
		var ret map[string]FacetsStats
		return ret
	}
	return *o.FacetsStats
}

// GetFacetsStatsOk returns a tuple with the FacetsStats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetFacetsStatsOk() (*map[string]FacetsStats, bool) {
	if o == nil || o.FacetsStats == nil {
		return nil, false
	}
	return o.FacetsStats, true
}

// HasFacetsStats returns a boolean if a field has been set.
func (o *SearchResponse) HasFacetsStats() bool {
	if o != nil && o.FacetsStats != nil {
		return true
	}

	return false
}

// SetFacetsStats gets a reference to the given map[string]FacetsStats and assigns it to the FacetsStats field.
func (o *SearchResponse) SetFacetsStats(v map[string]FacetsStats) {
	o.FacetsStats = &v
}

// GetHitsPerPage returns the HitsPerPage field value.
func (o *SearchResponse) GetHitsPerPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.HitsPerPage
}

// GetHitsPerPageOk returns a tuple with the HitsPerPage field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetHitsPerPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.HitsPerPage, true
}

// SetHitsPerPage sets field value.
func (o *SearchResponse) SetHitsPerPage(v int32) {
	o.HitsPerPage = v
}

// GetIndex returns the Index field value if set, zero value otherwise.
func (o *SearchResponse) GetIndex() string {
	if o == nil || o.Index == nil {
		var ret string
		return ret
	}
	return *o.Index
}

// GetIndexOk returns a tuple with the Index field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetIndexOk() (*string, bool) {
	if o == nil || o.Index == nil {
		return nil, false
	}
	return o.Index, true
}

// HasIndex returns a boolean if a field has been set.
func (o *SearchResponse) HasIndex() bool {
	if o != nil && o.Index != nil {
		return true
	}

	return false
}

// SetIndex gets a reference to the given string and assigns it to the Index field.
func (o *SearchResponse) SetIndex(v string) {
	o.Index = &v
}

// GetIndexUsed returns the IndexUsed field value if set, zero value otherwise.
func (o *SearchResponse) GetIndexUsed() string {
	if o == nil || o.IndexUsed == nil {
		var ret string
		return ret
	}
	return *o.IndexUsed
}

// GetIndexUsedOk returns a tuple with the IndexUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetIndexUsedOk() (*string, bool) {
	if o == nil || o.IndexUsed == nil {
		return nil, false
	}
	return o.IndexUsed, true
}

// HasIndexUsed returns a boolean if a field has been set.
func (o *SearchResponse) HasIndexUsed() bool {
	if o != nil && o.IndexUsed != nil {
		return true
	}

	return false
}

// SetIndexUsed gets a reference to the given string and assigns it to the IndexUsed field.
func (o *SearchResponse) SetIndexUsed(v string) {
	o.IndexUsed = &v
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *SearchResponse) GetMessage() string {
	if o == nil || o.Message == nil {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetMessageOk() (*string, bool) {
	if o == nil || o.Message == nil {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *SearchResponse) HasMessage() bool {
	if o != nil && o.Message != nil {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *SearchResponse) SetMessage(v string) {
	o.Message = &v
}

// GetNbHits returns the NbHits field value.
func (o *SearchResponse) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value.
func (o *SearchResponse) SetNbHits(v int32) {
	o.NbHits = v
}

// GetNbPages returns the NbPages field value.
func (o *SearchResponse) GetNbPages() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbPages
}

// GetNbPagesOk returns a tuple with the NbPages field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetNbPagesOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbPages, true
}

// SetNbPages sets field value.
func (o *SearchResponse) SetNbPages(v int32) {
	o.NbPages = v
}

// GetNbSortedHits returns the NbSortedHits field value if set, zero value otherwise.
func (o *SearchResponse) GetNbSortedHits() int32 {
	if o == nil || o.NbSortedHits == nil {
		var ret int32
		return ret
	}
	return *o.NbSortedHits
}

// GetNbSortedHitsOk returns a tuple with the NbSortedHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetNbSortedHitsOk() (*int32, bool) {
	if o == nil || o.NbSortedHits == nil {
		return nil, false
	}
	return o.NbSortedHits, true
}

// HasNbSortedHits returns a boolean if a field has been set.
func (o *SearchResponse) HasNbSortedHits() bool {
	if o != nil && o.NbSortedHits != nil {
		return true
	}

	return false
}

// SetNbSortedHits gets a reference to the given int32 and assigns it to the NbSortedHits field.
func (o *SearchResponse) SetNbSortedHits(v int32) {
	o.NbSortedHits = &v
}

// GetPage returns the Page field value.
func (o *SearchResponse) GetPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Page
}

// GetPageOk returns a tuple with the Page field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Page, true
}

// SetPage sets field value.
func (o *SearchResponse) SetPage(v int32) {
	o.Page = v
}

// GetParsedQuery returns the ParsedQuery field value if set, zero value otherwise.
func (o *SearchResponse) GetParsedQuery() string {
	if o == nil || o.ParsedQuery == nil {
		var ret string
		return ret
	}
	return *o.ParsedQuery
}

// GetParsedQueryOk returns a tuple with the ParsedQuery field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetParsedQueryOk() (*string, bool) {
	if o == nil || o.ParsedQuery == nil {
		return nil, false
	}
	return o.ParsedQuery, true
}

// HasParsedQuery returns a boolean if a field has been set.
func (o *SearchResponse) HasParsedQuery() bool {
	if o != nil && o.ParsedQuery != nil {
		return true
	}

	return false
}

// SetParsedQuery gets a reference to the given string and assigns it to the ParsedQuery field.
func (o *SearchResponse) SetParsedQuery(v string) {
	o.ParsedQuery = &v
}

// GetProcessingTimeMS returns the ProcessingTimeMS field value.
func (o *SearchResponse) GetProcessingTimeMS() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ProcessingTimeMS
}

// GetProcessingTimeMSOk returns a tuple with the ProcessingTimeMS field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetProcessingTimeMSOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ProcessingTimeMS, true
}

// SetProcessingTimeMS sets field value.
func (o *SearchResponse) SetProcessingTimeMS(v int32) {
	o.ProcessingTimeMS = v
}

// GetProcessingTimingsMS returns the ProcessingTimingsMS field value if set, zero value otherwise.
func (o *SearchResponse) GetProcessingTimingsMS() map[string]interface{} {
	if o == nil || o.ProcessingTimingsMS == nil {
		var ret map[string]interface{}
		return ret
	}
	return o.ProcessingTimingsMS
}

// GetProcessingTimingsMSOk returns a tuple with the ProcessingTimingsMS field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetProcessingTimingsMSOk() (map[string]interface{}, bool) {
	if o == nil || o.ProcessingTimingsMS == nil {
		return nil, false
	}
	return o.ProcessingTimingsMS, true
}

// HasProcessingTimingsMS returns a boolean if a field has been set.
func (o *SearchResponse) HasProcessingTimingsMS() bool {
	if o != nil && o.ProcessingTimingsMS != nil {
		return true
	}

	return false
}

// SetProcessingTimingsMS gets a reference to the given map[string]interface{} and assigns it to the ProcessingTimingsMS field.
func (o *SearchResponse) SetProcessingTimingsMS(v map[string]interface{}) {
	o.ProcessingTimingsMS = v
}

// GetQueryAfterRemoval returns the QueryAfterRemoval field value if set, zero value otherwise.
func (o *SearchResponse) GetQueryAfterRemoval() string {
	if o == nil || o.QueryAfterRemoval == nil {
		var ret string
		return ret
	}
	return *o.QueryAfterRemoval
}

// GetQueryAfterRemovalOk returns a tuple with the QueryAfterRemoval field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetQueryAfterRemovalOk() (*string, bool) {
	if o == nil || o.QueryAfterRemoval == nil {
		return nil, false
	}
	return o.QueryAfterRemoval, true
}

// HasQueryAfterRemoval returns a boolean if a field has been set.
func (o *SearchResponse) HasQueryAfterRemoval() bool {
	if o != nil && o.QueryAfterRemoval != nil {
		return true
	}

	return false
}

// SetQueryAfterRemoval gets a reference to the given string and assigns it to the QueryAfterRemoval field.
func (o *SearchResponse) SetQueryAfterRemoval(v string) {
	o.QueryAfterRemoval = &v
}

// GetRedirect returns the Redirect field value if set, zero value otherwise.
func (o *SearchResponse) GetRedirect() Redirect {
	if o == nil || o.Redirect == nil {
		var ret Redirect
		return ret
	}
	return *o.Redirect
}

// GetRedirectOk returns a tuple with the Redirect field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetRedirectOk() (*Redirect, bool) {
	if o == nil || o.Redirect == nil {
		return nil, false
	}
	return o.Redirect, true
}

// HasRedirect returns a boolean if a field has been set.
func (o *SearchResponse) HasRedirect() bool {
	if o != nil && o.Redirect != nil {
		return true
	}

	return false
}

// SetRedirect gets a reference to the given Redirect and assigns it to the Redirect field.
func (o *SearchResponse) SetRedirect(v Redirect) {
	o.Redirect = &v
}

// GetRenderingContent returns the RenderingContent field value if set, zero value otherwise.
func (o *SearchResponse) GetRenderingContent() RenderingContent {
	if o == nil || o.RenderingContent == nil {
		var ret RenderingContent
		return ret
	}
	return *o.RenderingContent
}

// GetRenderingContentOk returns a tuple with the RenderingContent field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetRenderingContentOk() (*RenderingContent, bool) {
	if o == nil || o.RenderingContent == nil {
		return nil, false
	}
	return o.RenderingContent, true
}

// HasRenderingContent returns a boolean if a field has been set.
func (o *SearchResponse) HasRenderingContent() bool {
	if o != nil && o.RenderingContent != nil {
		return true
	}

	return false
}

// SetRenderingContent gets a reference to the given RenderingContent and assigns it to the RenderingContent field.
func (o *SearchResponse) SetRenderingContent(v RenderingContent) {
	o.RenderingContent = &v
}

// GetServerTimeMS returns the ServerTimeMS field value if set, zero value otherwise.
func (o *SearchResponse) GetServerTimeMS() int32 {
	if o == nil || o.ServerTimeMS == nil {
		var ret int32
		return ret
	}
	return *o.ServerTimeMS
}

// GetServerTimeMSOk returns a tuple with the ServerTimeMS field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetServerTimeMSOk() (*int32, bool) {
	if o == nil || o.ServerTimeMS == nil {
		return nil, false
	}
	return o.ServerTimeMS, true
}

// HasServerTimeMS returns a boolean if a field has been set.
func (o *SearchResponse) HasServerTimeMS() bool {
	if o != nil && o.ServerTimeMS != nil {
		return true
	}

	return false
}

// SetServerTimeMS gets a reference to the given int32 and assigns it to the ServerTimeMS field.
func (o *SearchResponse) SetServerTimeMS(v int32) {
	o.ServerTimeMS = &v
}

// GetServerUsed returns the ServerUsed field value if set, zero value otherwise.
func (o *SearchResponse) GetServerUsed() string {
	if o == nil || o.ServerUsed == nil {
		var ret string
		return ret
	}
	return *o.ServerUsed
}

// GetServerUsedOk returns a tuple with the ServerUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetServerUsedOk() (*string, bool) {
	if o == nil || o.ServerUsed == nil {
		return nil, false
	}
	return o.ServerUsed, true
}

// HasServerUsed returns a boolean if a field has been set.
func (o *SearchResponse) HasServerUsed() bool {
	if o != nil && o.ServerUsed != nil {
		return true
	}

	return false
}

// SetServerUsed gets a reference to the given string and assigns it to the ServerUsed field.
func (o *SearchResponse) SetServerUsed(v string) {
	o.ServerUsed = &v
}

// GetUserData returns the UserData field value if set, zero value otherwise.
func (o *SearchResponse) GetUserData() map[string]interface{} {
	if o == nil || o.UserData == nil {
		var ret map[string]interface{}
		return ret
	}
	return o.UserData
}

// GetUserDataOk returns a tuple with the UserData field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetUserDataOk() (map[string]interface{}, bool) {
	if o == nil || o.UserData == nil {
		return nil, false
	}
	return o.UserData, true
}

// HasUserData returns a boolean if a field has been set.
func (o *SearchResponse) HasUserData() bool {
	if o != nil && o.UserData != nil {
		return true
	}

	return false
}

// SetUserData gets a reference to the given map[string]interface{} and assigns it to the UserData field.
func (o *SearchResponse) SetUserData(v map[string]interface{}) {
	o.UserData = v
}

// GetHits returns the Hits field value.
func (o *SearchResponse) GetHits() []Hit {
	if o == nil {
		var ret []Hit
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetHitsOk() ([]Hit, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value.
func (o *SearchResponse) SetHits(v []Hit) {
	o.Hits = v
}

// GetQuery returns the Query field value.
func (o *SearchResponse) GetQuery() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Query
}

// GetQueryOk returns a tuple with the Query field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetQueryOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Query, true
}

// SetQuery sets field value.
func (o *SearchResponse) SetQuery(v string) {
	o.Query = v
}

// GetParams returns the Params field value.
func (o *SearchResponse) GetParams() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Params
}

// GetParamsOk returns a tuple with the Params field value
// and a boolean to check if the value has been set.
func (o *SearchResponse) GetParamsOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Params, true
}

// SetParams sets field value.
func (o *SearchResponse) SetParams(v string) {
	o.Params = v
}

func (o SearchResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.AbTestID != nil {
		toSerialize["abTestID"] = o.AbTestID
	}
	if o.AbTestVariantID != nil {
		toSerialize["abTestVariantID"] = o.AbTestVariantID
	}
	if o.AroundLatLng != nil {
		toSerialize["aroundLatLng"] = o.AroundLatLng
	}
	if o.AutomaticRadius != nil {
		toSerialize["automaticRadius"] = o.AutomaticRadius
	}
	if o.Exhaustive != nil {
		toSerialize["exhaustive"] = o.Exhaustive
	}
	if o.ExhaustiveFacetsCount != nil {
		toSerialize["exhaustiveFacetsCount"] = o.ExhaustiveFacetsCount
	}
	if o.ExhaustiveNbHits != nil {
		toSerialize["exhaustiveNbHits"] = o.ExhaustiveNbHits
	}
	if o.ExhaustiveTypo != nil {
		toSerialize["exhaustiveTypo"] = o.ExhaustiveTypo
	}
	if o.Facets != nil {
		toSerialize["facets"] = o.Facets
	}
	if o.FacetsStats != nil {
		toSerialize["facets_stats"] = o.FacetsStats
	}
	if true {
		toSerialize["hitsPerPage"] = o.HitsPerPage
	}
	if o.Index != nil {
		toSerialize["index"] = o.Index
	}
	if o.IndexUsed != nil {
		toSerialize["indexUsed"] = o.IndexUsed
	}
	if o.Message != nil {
		toSerialize["message"] = o.Message
	}
	if true {
		toSerialize["nbHits"] = o.NbHits
	}
	if true {
		toSerialize["nbPages"] = o.NbPages
	}
	if o.NbSortedHits != nil {
		toSerialize["nbSortedHits"] = o.NbSortedHits
	}
	if true {
		toSerialize["page"] = o.Page
	}
	if o.ParsedQuery != nil {
		toSerialize["parsedQuery"] = o.ParsedQuery
	}
	if true {
		toSerialize["processingTimeMS"] = o.ProcessingTimeMS
	}
	if o.ProcessingTimingsMS != nil {
		toSerialize["processingTimingsMS"] = o.ProcessingTimingsMS
	}
	if o.QueryAfterRemoval != nil {
		toSerialize["queryAfterRemoval"] = o.QueryAfterRemoval
	}
	if o.Redirect != nil {
		toSerialize["redirect"] = o.Redirect
	}
	if o.RenderingContent != nil {
		toSerialize["renderingContent"] = o.RenderingContent
	}
	if o.ServerTimeMS != nil {
		toSerialize["serverTimeMS"] = o.ServerTimeMS
	}
	if o.ServerUsed != nil {
		toSerialize["serverUsed"] = o.ServerUsed
	}
	if o.UserData != nil {
		toSerialize["userData"] = o.UserData
	}
	if true {
		toSerialize["hits"] = o.Hits
	}
	if true {
		toSerialize["query"] = o.Query
	}
	if true {
		toSerialize["params"] = o.Params
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return json.Marshal(toSerialize)
}

func (o *SearchResponse) UnmarshalJSON(bytes []byte) (err error) {
	varSearchResponse := _SearchResponse{}

	if err = json.Unmarshal(bytes, &varSearchResponse); err == nil {
		*o = SearchResponse(varSearchResponse)
	}

	additionalProperties := make(map[string]any)

	if err = json.Unmarshal(bytes, &additionalProperties); err == nil {
		delete(additionalProperties, "abTestID")
		delete(additionalProperties, "abTestVariantID")
		delete(additionalProperties, "aroundLatLng")
		delete(additionalProperties, "automaticRadius")
		delete(additionalProperties, "exhaustive")
		delete(additionalProperties, "exhaustiveFacetsCount")
		delete(additionalProperties, "exhaustiveNbHits")
		delete(additionalProperties, "exhaustiveTypo")
		delete(additionalProperties, "facets")
		delete(additionalProperties, "facets_stats")
		delete(additionalProperties, "hitsPerPage")
		delete(additionalProperties, "index")
		delete(additionalProperties, "indexUsed")
		delete(additionalProperties, "message")
		delete(additionalProperties, "nbHits")
		delete(additionalProperties, "nbPages")
		delete(additionalProperties, "nbSortedHits")
		delete(additionalProperties, "page")
		delete(additionalProperties, "parsedQuery")
		delete(additionalProperties, "processingTimeMS")
		delete(additionalProperties, "processingTimingsMS")
		delete(additionalProperties, "queryAfterRemoval")
		delete(additionalProperties, "redirect")
		delete(additionalProperties, "renderingContent")
		delete(additionalProperties, "serverTimeMS")
		delete(additionalProperties, "serverUsed")
		delete(additionalProperties, "userData")
		delete(additionalProperties, "hits")
		delete(additionalProperties, "query")
		delete(additionalProperties, "params")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

func (o SearchResponse) String() string {
	out := ""
	out += fmt.Sprintf("  abTestID=%v\n", o.AbTestID)
	out += fmt.Sprintf("  abTestVariantID=%v\n", o.AbTestVariantID)
	out += fmt.Sprintf("  aroundLatLng=%v\n", o.AroundLatLng)
	out += fmt.Sprintf("  automaticRadius=%v\n", o.AutomaticRadius)
	out += fmt.Sprintf("  exhaustive=%v\n", o.Exhaustive)
	out += fmt.Sprintf("  exhaustiveFacetsCount=%v\n", o.ExhaustiveFacetsCount)
	out += fmt.Sprintf("  exhaustiveNbHits=%v\n", o.ExhaustiveNbHits)
	out += fmt.Sprintf("  exhaustiveTypo=%v\n", o.ExhaustiveTypo)
	out += fmt.Sprintf("  facets=%v\n", o.Facets)
	out += fmt.Sprintf("  facets_stats=%v\n", o.FacetsStats)
	out += fmt.Sprintf("  hitsPerPage=%v\n", o.HitsPerPage)
	out += fmt.Sprintf("  index=%v\n", o.Index)
	out += fmt.Sprintf("  indexUsed=%v\n", o.IndexUsed)
	out += fmt.Sprintf("  message=%v\n", o.Message)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	out += fmt.Sprintf("  nbPages=%v\n", o.NbPages)
	out += fmt.Sprintf("  nbSortedHits=%v\n", o.NbSortedHits)
	out += fmt.Sprintf("  page=%v\n", o.Page)
	out += fmt.Sprintf("  parsedQuery=%v\n", o.ParsedQuery)
	out += fmt.Sprintf("  processingTimeMS=%v\n", o.ProcessingTimeMS)
	out += fmt.Sprintf("  processingTimingsMS=%v\n", o.ProcessingTimingsMS)
	out += fmt.Sprintf("  queryAfterRemoval=%v\n", o.QueryAfterRemoval)
	out += fmt.Sprintf("  redirect=%v\n", o.Redirect)
	out += fmt.Sprintf("  renderingContent=%v\n", o.RenderingContent)
	out += fmt.Sprintf("  serverTimeMS=%v\n", o.ServerTimeMS)
	out += fmt.Sprintf("  serverUsed=%v\n", o.ServerUsed)
	out += fmt.Sprintf("  userData=%v\n", o.UserData)
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	out += fmt.Sprintf("  query=%v\n", o.Query)
	out += fmt.Sprintf("  params=%v\n", o.Params)
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("SearchResponse {\n%s}", out)
}

type NullableSearchResponse struct {
	value *SearchResponse
	isSet bool
}

func (v NullableSearchResponse) Get() *SearchResponse {
	return v.value
}

func (v *NullableSearchResponse) Set(val *SearchResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchResponse(val *SearchResponse) *NullableSearchResponse {
	return &NullableSearchResponse{value: val, isSet: true}
}

func (v NullableSearchResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableSearchResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
