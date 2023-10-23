// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// BaseSearchResponse struct for BaseSearchResponse
type BaseSearchResponse struct {
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
	UserData             interface{} `json:"userData,omitempty"`
	AdditionalProperties map[string]any
}

type _BaseSearchResponse BaseSearchResponse

type BaseSearchResponseOption func(f *BaseSearchResponse)

func WithBaseSearchResponseAbTestID(val int32) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.AbTestID = &val
	}
}

func WithBaseSearchResponseAbTestVariantID(val int32) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.AbTestVariantID = &val
	}
}

func WithBaseSearchResponseAroundLatLng(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.AroundLatLng = &val
	}
}

func WithBaseSearchResponseAutomaticRadius(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.AutomaticRadius = &val
	}
}

func WithBaseSearchResponseExhaustive(val Exhaustive) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.Exhaustive = &val
	}
}

func WithBaseSearchResponseExhaustiveFacetsCount(val bool) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ExhaustiveFacetsCount = &val
	}
}

func WithBaseSearchResponseExhaustiveNbHits(val bool) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ExhaustiveNbHits = &val
	}
}

func WithBaseSearchResponseExhaustiveTypo(val bool) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ExhaustiveTypo = &val
	}
}

func WithBaseSearchResponseFacets(val map[string]map[string]int32) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.Facets = &val
	}
}

func WithBaseSearchResponseFacetsStats(val map[string]FacetsStats) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.FacetsStats = &val
	}
}

func WithBaseSearchResponseIndex(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.Index = &val
	}
}

func WithBaseSearchResponseIndexUsed(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.IndexUsed = &val
	}
}

func WithBaseSearchResponseMessage(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.Message = &val
	}
}

func WithBaseSearchResponseNbSortedHits(val int32) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.NbSortedHits = &val
	}
}

func WithBaseSearchResponseParsedQuery(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ParsedQuery = &val
	}
}

func WithBaseSearchResponseProcessingTimingsMS(val map[string]interface{}) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ProcessingTimingsMS = val
	}
}

func WithBaseSearchResponseQueryAfterRemoval(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.QueryAfterRemoval = &val
	}
}

func WithBaseSearchResponseRedirect(val Redirect) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.Redirect = &val
	}
}

func WithBaseSearchResponseRenderingContent(val RenderingContent) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.RenderingContent = &val
	}
}

func WithBaseSearchResponseServerTimeMS(val int32) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ServerTimeMS = &val
	}
}

func WithBaseSearchResponseServerUsed(val string) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.ServerUsed = &val
	}
}

func WithBaseSearchResponseUserData(val interface{}) BaseSearchResponseOption {
	return func(f *BaseSearchResponse) {
		f.UserData = val
	}
}

// NewBaseSearchResponse instantiates a new BaseSearchResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBaseSearchResponse(hitsPerPage int32, nbHits int32, nbPages int32, page int32, processingTimeMS int32, opts ...BaseSearchResponseOption) *BaseSearchResponse {
	this := &BaseSearchResponse{}
	this.HitsPerPage = hitsPerPage
	this.NbHits = nbHits
	this.NbPages = nbPages
	this.Page = page
	this.ProcessingTimeMS = processingTimeMS
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewBaseSearchResponseWithDefaults instantiates a new BaseSearchResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBaseSearchResponseWithDefaults() *BaseSearchResponse {
	this := &BaseSearchResponse{}
	var hitsPerPage int32 = 20
	this.HitsPerPage = hitsPerPage
	var page int32 = 0
	this.Page = page
	return this
}

// GetAbTestID returns the AbTestID field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetAbTestID() int32 {
	if o == nil || o.AbTestID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestID
}

// GetAbTestIDOk returns a tuple with the AbTestID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetAbTestIDOk() (*int32, bool) {
	if o == nil || o.AbTestID == nil {
		return nil, false
	}
	return o.AbTestID, true
}

// HasAbTestID returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasAbTestID() bool {
	if o != nil && o.AbTestID != nil {
		return true
	}

	return false
}

// SetAbTestID gets a reference to the given int32 and assigns it to the AbTestID field.
func (o *BaseSearchResponse) SetAbTestID(v int32) {
	o.AbTestID = &v
}

// GetAbTestVariantID returns the AbTestVariantID field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetAbTestVariantID() int32 {
	if o == nil || o.AbTestVariantID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestVariantID
}

// GetAbTestVariantIDOk returns a tuple with the AbTestVariantID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetAbTestVariantIDOk() (*int32, bool) {
	if o == nil || o.AbTestVariantID == nil {
		return nil, false
	}
	return o.AbTestVariantID, true
}

// HasAbTestVariantID returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasAbTestVariantID() bool {
	if o != nil && o.AbTestVariantID != nil {
		return true
	}

	return false
}

// SetAbTestVariantID gets a reference to the given int32 and assigns it to the AbTestVariantID field.
func (o *BaseSearchResponse) SetAbTestVariantID(v int32) {
	o.AbTestVariantID = &v
}

// GetAroundLatLng returns the AroundLatLng field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetAroundLatLng() string {
	if o == nil || o.AroundLatLng == nil {
		var ret string
		return ret
	}
	return *o.AroundLatLng
}

// GetAroundLatLngOk returns a tuple with the AroundLatLng field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetAroundLatLngOk() (*string, bool) {
	if o == nil || o.AroundLatLng == nil {
		return nil, false
	}
	return o.AroundLatLng, true
}

// HasAroundLatLng returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasAroundLatLng() bool {
	if o != nil && o.AroundLatLng != nil {
		return true
	}

	return false
}

// SetAroundLatLng gets a reference to the given string and assigns it to the AroundLatLng field.
func (o *BaseSearchResponse) SetAroundLatLng(v string) {
	o.AroundLatLng = &v
}

// GetAutomaticRadius returns the AutomaticRadius field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetAutomaticRadius() string {
	if o == nil || o.AutomaticRadius == nil {
		var ret string
		return ret
	}
	return *o.AutomaticRadius
}

// GetAutomaticRadiusOk returns a tuple with the AutomaticRadius field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetAutomaticRadiusOk() (*string, bool) {
	if o == nil || o.AutomaticRadius == nil {
		return nil, false
	}
	return o.AutomaticRadius, true
}

// HasAutomaticRadius returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasAutomaticRadius() bool {
	if o != nil && o.AutomaticRadius != nil {
		return true
	}

	return false
}

// SetAutomaticRadius gets a reference to the given string and assigns it to the AutomaticRadius field.
func (o *BaseSearchResponse) SetAutomaticRadius(v string) {
	o.AutomaticRadius = &v
}

// GetExhaustive returns the Exhaustive field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetExhaustive() Exhaustive {
	if o == nil || o.Exhaustive == nil {
		var ret Exhaustive
		return ret
	}
	return *o.Exhaustive
}

// GetExhaustiveOk returns a tuple with the Exhaustive field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetExhaustiveOk() (*Exhaustive, bool) {
	if o == nil || o.Exhaustive == nil {
		return nil, false
	}
	return o.Exhaustive, true
}

// HasExhaustive returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasExhaustive() bool {
	if o != nil && o.Exhaustive != nil {
		return true
	}

	return false
}

// SetExhaustive gets a reference to the given Exhaustive and assigns it to the Exhaustive field.
func (o *BaseSearchResponse) SetExhaustive(v Exhaustive) {
	o.Exhaustive = &v
}

// GetExhaustiveFacetsCount returns the ExhaustiveFacetsCount field value if set, zero value otherwise.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveFacetsCount() bool {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveFacetsCount
}

// GetExhaustiveFacetsCountOk returns a tuple with the ExhaustiveFacetsCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveFacetsCountOk() (*bool, bool) {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		return nil, false
	}
	return o.ExhaustiveFacetsCount, true
}

// HasExhaustiveFacetsCount returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasExhaustiveFacetsCount() bool {
	if o != nil && o.ExhaustiveFacetsCount != nil {
		return true
	}

	return false
}

// SetExhaustiveFacetsCount gets a reference to the given bool and assigns it to the ExhaustiveFacetsCount field.
// Deprecated
func (o *BaseSearchResponse) SetExhaustiveFacetsCount(v bool) {
	o.ExhaustiveFacetsCount = &v
}

// GetExhaustiveNbHits returns the ExhaustiveNbHits field value if set, zero value otherwise.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveNbHits() bool {
	if o == nil || o.ExhaustiveNbHits == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveNbHits
}

// GetExhaustiveNbHitsOk returns a tuple with the ExhaustiveNbHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveNbHitsOk() (*bool, bool) {
	if o == nil || o.ExhaustiveNbHits == nil {
		return nil, false
	}
	return o.ExhaustiveNbHits, true
}

// HasExhaustiveNbHits returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasExhaustiveNbHits() bool {
	if o != nil && o.ExhaustiveNbHits != nil {
		return true
	}

	return false
}

// SetExhaustiveNbHits gets a reference to the given bool and assigns it to the ExhaustiveNbHits field.
// Deprecated
func (o *BaseSearchResponse) SetExhaustiveNbHits(v bool) {
	o.ExhaustiveNbHits = &v
}

// GetExhaustiveTypo returns the ExhaustiveTypo field value if set, zero value otherwise.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveTypo() bool {
	if o == nil || o.ExhaustiveTypo == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveTypo
}

// GetExhaustiveTypoOk returns a tuple with the ExhaustiveTypo field value if set, nil otherwise
// and a boolean to check if the value has been set.
// Deprecated
func (o *BaseSearchResponse) GetExhaustiveTypoOk() (*bool, bool) {
	if o == nil || o.ExhaustiveTypo == nil {
		return nil, false
	}
	return o.ExhaustiveTypo, true
}

// HasExhaustiveTypo returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasExhaustiveTypo() bool {
	if o != nil && o.ExhaustiveTypo != nil {
		return true
	}

	return false
}

// SetExhaustiveTypo gets a reference to the given bool and assigns it to the ExhaustiveTypo field.
// Deprecated
func (o *BaseSearchResponse) SetExhaustiveTypo(v bool) {
	o.ExhaustiveTypo = &v
}

// GetFacets returns the Facets field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetFacets() map[string]map[string]int32 {
	if o == nil || o.Facets == nil {
		var ret map[string]map[string]int32
		return ret
	}
	return *o.Facets
}

// GetFacetsOk returns a tuple with the Facets field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetFacetsOk() (*map[string]map[string]int32, bool) {
	if o == nil || o.Facets == nil {
		return nil, false
	}
	return o.Facets, true
}

// HasFacets returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasFacets() bool {
	if o != nil && o.Facets != nil {
		return true
	}

	return false
}

// SetFacets gets a reference to the given map[string]map[string]int32 and assigns it to the Facets field.
func (o *BaseSearchResponse) SetFacets(v map[string]map[string]int32) {
	o.Facets = &v
}

// GetFacetsStats returns the FacetsStats field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetFacetsStats() map[string]FacetsStats {
	if o == nil || o.FacetsStats == nil {
		var ret map[string]FacetsStats
		return ret
	}
	return *o.FacetsStats
}

// GetFacetsStatsOk returns a tuple with the FacetsStats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetFacetsStatsOk() (*map[string]FacetsStats, bool) {
	if o == nil || o.FacetsStats == nil {
		return nil, false
	}
	return o.FacetsStats, true
}

// HasFacetsStats returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasFacetsStats() bool {
	if o != nil && o.FacetsStats != nil {
		return true
	}

	return false
}

// SetFacetsStats gets a reference to the given map[string]FacetsStats and assigns it to the FacetsStats field.
func (o *BaseSearchResponse) SetFacetsStats(v map[string]FacetsStats) {
	o.FacetsStats = &v
}

// GetHitsPerPage returns the HitsPerPage field value
func (o *BaseSearchResponse) GetHitsPerPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.HitsPerPage
}

// GetHitsPerPageOk returns a tuple with the HitsPerPage field value
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetHitsPerPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.HitsPerPage, true
}

// SetHitsPerPage sets field value
func (o *BaseSearchResponse) SetHitsPerPage(v int32) {
	o.HitsPerPage = v
}

// GetIndex returns the Index field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetIndex() string {
	if o == nil || o.Index == nil {
		var ret string
		return ret
	}
	return *o.Index
}

// GetIndexOk returns a tuple with the Index field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetIndexOk() (*string, bool) {
	if o == nil || o.Index == nil {
		return nil, false
	}
	return o.Index, true
}

// HasIndex returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasIndex() bool {
	if o != nil && o.Index != nil {
		return true
	}

	return false
}

// SetIndex gets a reference to the given string and assigns it to the Index field.
func (o *BaseSearchResponse) SetIndex(v string) {
	o.Index = &v
}

// GetIndexUsed returns the IndexUsed field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetIndexUsed() string {
	if o == nil || o.IndexUsed == nil {
		var ret string
		return ret
	}
	return *o.IndexUsed
}

// GetIndexUsedOk returns a tuple with the IndexUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetIndexUsedOk() (*string, bool) {
	if o == nil || o.IndexUsed == nil {
		return nil, false
	}
	return o.IndexUsed, true
}

// HasIndexUsed returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasIndexUsed() bool {
	if o != nil && o.IndexUsed != nil {
		return true
	}

	return false
}

// SetIndexUsed gets a reference to the given string and assigns it to the IndexUsed field.
func (o *BaseSearchResponse) SetIndexUsed(v string) {
	o.IndexUsed = &v
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetMessage() string {
	if o == nil || o.Message == nil {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetMessageOk() (*string, bool) {
	if o == nil || o.Message == nil {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasMessage() bool {
	if o != nil && o.Message != nil {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *BaseSearchResponse) SetMessage(v string) {
	o.Message = &v
}

// GetNbHits returns the NbHits field value
func (o *BaseSearchResponse) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value
func (o *BaseSearchResponse) SetNbHits(v int32) {
	o.NbHits = v
}

// GetNbPages returns the NbPages field value
func (o *BaseSearchResponse) GetNbPages() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbPages
}

// GetNbPagesOk returns a tuple with the NbPages field value
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetNbPagesOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbPages, true
}

// SetNbPages sets field value
func (o *BaseSearchResponse) SetNbPages(v int32) {
	o.NbPages = v
}

// GetNbSortedHits returns the NbSortedHits field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetNbSortedHits() int32 {
	if o == nil || o.NbSortedHits == nil {
		var ret int32
		return ret
	}
	return *o.NbSortedHits
}

// GetNbSortedHitsOk returns a tuple with the NbSortedHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetNbSortedHitsOk() (*int32, bool) {
	if o == nil || o.NbSortedHits == nil {
		return nil, false
	}
	return o.NbSortedHits, true
}

// HasNbSortedHits returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasNbSortedHits() bool {
	if o != nil && o.NbSortedHits != nil {
		return true
	}

	return false
}

// SetNbSortedHits gets a reference to the given int32 and assigns it to the NbSortedHits field.
func (o *BaseSearchResponse) SetNbSortedHits(v int32) {
	o.NbSortedHits = &v
}

// GetPage returns the Page field value
func (o *BaseSearchResponse) GetPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Page
}

// GetPageOk returns a tuple with the Page field value
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Page, true
}

// SetPage sets field value
func (o *BaseSearchResponse) SetPage(v int32) {
	o.Page = v
}

// GetParsedQuery returns the ParsedQuery field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetParsedQuery() string {
	if o == nil || o.ParsedQuery == nil {
		var ret string
		return ret
	}
	return *o.ParsedQuery
}

// GetParsedQueryOk returns a tuple with the ParsedQuery field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetParsedQueryOk() (*string, bool) {
	if o == nil || o.ParsedQuery == nil {
		return nil, false
	}
	return o.ParsedQuery, true
}

// HasParsedQuery returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasParsedQuery() bool {
	if o != nil && o.ParsedQuery != nil {
		return true
	}

	return false
}

// SetParsedQuery gets a reference to the given string and assigns it to the ParsedQuery field.
func (o *BaseSearchResponse) SetParsedQuery(v string) {
	o.ParsedQuery = &v
}

// GetProcessingTimeMS returns the ProcessingTimeMS field value
func (o *BaseSearchResponse) GetProcessingTimeMS() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ProcessingTimeMS
}

// GetProcessingTimeMSOk returns a tuple with the ProcessingTimeMS field value
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetProcessingTimeMSOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ProcessingTimeMS, true
}

// SetProcessingTimeMS sets field value
func (o *BaseSearchResponse) SetProcessingTimeMS(v int32) {
	o.ProcessingTimeMS = v
}

// GetProcessingTimingsMS returns the ProcessingTimingsMS field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetProcessingTimingsMS() map[string]interface{} {
	if o == nil || o.ProcessingTimingsMS == nil {
		var ret map[string]interface{}
		return ret
	}
	return o.ProcessingTimingsMS
}

// GetProcessingTimingsMSOk returns a tuple with the ProcessingTimingsMS field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetProcessingTimingsMSOk() (map[string]interface{}, bool) {
	if o == nil || o.ProcessingTimingsMS == nil {
		return nil, false
	}
	return o.ProcessingTimingsMS, true
}

// HasProcessingTimingsMS returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasProcessingTimingsMS() bool {
	if o != nil && o.ProcessingTimingsMS != nil {
		return true
	}

	return false
}

// SetProcessingTimingsMS gets a reference to the given map[string]interface{} and assigns it to the ProcessingTimingsMS field.
func (o *BaseSearchResponse) SetProcessingTimingsMS(v map[string]interface{}) {
	o.ProcessingTimingsMS = v
}

// GetQueryAfterRemoval returns the QueryAfterRemoval field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetQueryAfterRemoval() string {
	if o == nil || o.QueryAfterRemoval == nil {
		var ret string
		return ret
	}
	return *o.QueryAfterRemoval
}

// GetQueryAfterRemovalOk returns a tuple with the QueryAfterRemoval field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetQueryAfterRemovalOk() (*string, bool) {
	if o == nil || o.QueryAfterRemoval == nil {
		return nil, false
	}
	return o.QueryAfterRemoval, true
}

// HasQueryAfterRemoval returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasQueryAfterRemoval() bool {
	if o != nil && o.QueryAfterRemoval != nil {
		return true
	}

	return false
}

// SetQueryAfterRemoval gets a reference to the given string and assigns it to the QueryAfterRemoval field.
func (o *BaseSearchResponse) SetQueryAfterRemoval(v string) {
	o.QueryAfterRemoval = &v
}

// GetRedirect returns the Redirect field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetRedirect() Redirect {
	if o == nil || o.Redirect == nil {
		var ret Redirect
		return ret
	}
	return *o.Redirect
}

// GetRedirectOk returns a tuple with the Redirect field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetRedirectOk() (*Redirect, bool) {
	if o == nil || o.Redirect == nil {
		return nil, false
	}
	return o.Redirect, true
}

// HasRedirect returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasRedirect() bool {
	if o != nil && o.Redirect != nil {
		return true
	}

	return false
}

// SetRedirect gets a reference to the given Redirect and assigns it to the Redirect field.
func (o *BaseSearchResponse) SetRedirect(v Redirect) {
	o.Redirect = &v
}

// GetRenderingContent returns the RenderingContent field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetRenderingContent() RenderingContent {
	if o == nil || o.RenderingContent == nil {
		var ret RenderingContent
		return ret
	}
	return *o.RenderingContent
}

// GetRenderingContentOk returns a tuple with the RenderingContent field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetRenderingContentOk() (*RenderingContent, bool) {
	if o == nil || o.RenderingContent == nil {
		return nil, false
	}
	return o.RenderingContent, true
}

// HasRenderingContent returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasRenderingContent() bool {
	if o != nil && o.RenderingContent != nil {
		return true
	}

	return false
}

// SetRenderingContent gets a reference to the given RenderingContent and assigns it to the RenderingContent field.
func (o *BaseSearchResponse) SetRenderingContent(v RenderingContent) {
	o.RenderingContent = &v
}

// GetServerTimeMS returns the ServerTimeMS field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetServerTimeMS() int32 {
	if o == nil || o.ServerTimeMS == nil {
		var ret int32
		return ret
	}
	return *o.ServerTimeMS
}

// GetServerTimeMSOk returns a tuple with the ServerTimeMS field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetServerTimeMSOk() (*int32, bool) {
	if o == nil || o.ServerTimeMS == nil {
		return nil, false
	}
	return o.ServerTimeMS, true
}

// HasServerTimeMS returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasServerTimeMS() bool {
	if o != nil && o.ServerTimeMS != nil {
		return true
	}

	return false
}

// SetServerTimeMS gets a reference to the given int32 and assigns it to the ServerTimeMS field.
func (o *BaseSearchResponse) SetServerTimeMS(v int32) {
	o.ServerTimeMS = &v
}

// GetServerUsed returns the ServerUsed field value if set, zero value otherwise.
func (o *BaseSearchResponse) GetServerUsed() string {
	if o == nil || o.ServerUsed == nil {
		var ret string
		return ret
	}
	return *o.ServerUsed
}

// GetServerUsedOk returns a tuple with the ServerUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BaseSearchResponse) GetServerUsedOk() (*string, bool) {
	if o == nil || o.ServerUsed == nil {
		return nil, false
	}
	return o.ServerUsed, true
}

// HasServerUsed returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasServerUsed() bool {
	if o != nil && o.ServerUsed != nil {
		return true
	}

	return false
}

// SetServerUsed gets a reference to the given string and assigns it to the ServerUsed field.
func (o *BaseSearchResponse) SetServerUsed(v string) {
	o.ServerUsed = &v
}

// GetUserData returns the UserData field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *BaseSearchResponse) GetUserData() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}
	return o.UserData
}

// GetUserDataOk returns a tuple with the UserData field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *BaseSearchResponse) GetUserDataOk() (*interface{}, bool) {
	if o == nil || o.UserData == nil {
		return nil, false
	}
	return &o.UserData, true
}

// HasUserData returns a boolean if a field has been set.
func (o *BaseSearchResponse) HasUserData() bool {
	if o != nil && o.UserData != nil {
		return true
	}

	return false
}

// SetUserData gets a reference to the given interface{} and assigns it to the UserData field.
func (o *BaseSearchResponse) SetUserData(v interface{}) {
	o.UserData = v
}

func (o BaseSearchResponse) MarshalJSON() ([]byte, error) {
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

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return json.Marshal(toSerialize)
}

func (o *BaseSearchResponse) UnmarshalJSON(bytes []byte) (err error) {
	varBaseSearchResponse := _BaseSearchResponse{}

	if err = json.Unmarshal(bytes, &varBaseSearchResponse); err == nil {
		*o = BaseSearchResponse(varBaseSearchResponse)
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
		o.AdditionalProperties = additionalProperties
	}

	return err
}

func (o BaseSearchResponse) String() string {
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
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("BaseSearchResponse {\n%s}", out)
}

type NullableBaseSearchResponse struct {
	value *BaseSearchResponse
	isSet bool
}

func (v NullableBaseSearchResponse) Get() *BaseSearchResponse {
	return v.value
}

func (v *NullableBaseSearchResponse) Set(val *BaseSearchResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableBaseSearchResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableBaseSearchResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBaseSearchResponse(val *BaseSearchResponse) *NullableBaseSearchResponse {
	return &NullableBaseSearchResponse{value: val, isSet: true}
}

func (v NullableBaseSearchResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBaseSearchResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
