// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// BrowseResponse struct for BrowseResponse
type BrowseResponse struct {
	// A/B test ID. This is only included in the response for indices that are part of an A/B test.
	AbTestID *int32 `json:"abTestID,omitempty"`
	// Variant ID. This is only included in the response for indices that are part of an A/B test.
	AbTestVariantID *int32 `json:"abTestVariantID,omitempty"`
	// Computed geographical location.
	AroundLatLng *string `json:"aroundLatLng,omitempty"`
	// Automatically-computed radius.
	AutomaticRadius *string `json:"automaticRadius,omitempty"`
	// Indicates whether the facet count is exhaustive (exact) or approximate.
	ExhaustiveFacetsCount *bool `json:"exhaustiveFacetsCount,omitempty"`
	// Indicates whether the number of hits `nbHits` is exhaustive (exact) or approximate.
	ExhaustiveNbHits *bool `json:"exhaustiveNbHits,omitempty"`
	// Indicates whether the search for typos was exhaustive (exact) or approximate.
	ExhaustiveTypo *bool `json:"exhaustiveTypo,omitempty"`
	// Mapping of each facet name to the corresponding facet counts.
	Facets *map[string]map[string]int32 `json:"facets,omitempty"`
	// Statistics for numerical facets.
	FacetsStats *map[string]FacetsStats `json:"facets_stats,omitempty"`
	// Number of hits per page.
	HitsPerPage int32 `json:"hitsPerPage" validate:"required"`
	// Index name used for the query.
	Index *string `json:"index,omitempty"`
	// Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
	IndexUsed *string `json:"indexUsed,omitempty"`
	// Warnings about the query.
	Message *string `json:"message,omitempty"`
	// Number of hits the search query matched.
	NbHits int32 `json:"nbHits" validate:"required"`
	// Number of pages of results for the current query.
	NbPages int32 `json:"nbPages" validate:"required"`
	// Number of hits selected and sorted by the relevant sort algorithm.
	NbSortedHits *int32 `json:"nbSortedHits,omitempty"`
	// Page to retrieve (the first page is `0`, not `1`).
	Page     int32                       `json:"page" validate:"required"`
	Redirect *BaseSearchResponseRedirect `json:"redirect,omitempty"`
	// Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
	ParsedQuery *string `json:"parsedQuery,omitempty"`
	// Time the server took to process the request, in milliseconds.
	ProcessingTimeMS int32 `json:"processingTimeMS" validate:"required"`
	// Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
	QueryAfterRemoval *string `json:"queryAfterRemoval,omitempty"`
	// Host name of the server that processed the request.
	ServerUsed *string `json:"serverUsed,omitempty"`
	// Lets you store custom data in your indices.
	UserData         interface{}       `json:"userData,omitempty"`
	RenderingContent *RenderingContent `json:"renderingContent,omitempty"`
	Hits             []Hit             `json:"hits" validate:"required"`
	// Text to search for in an index.
	Query string `json:"query" validate:"required"`
	// URL-encoded string of all search parameters.
	Params string `json:"params" validate:"required"`
	// Cursor indicating the location to resume browsing from. Must match the value returned by the previous call. Pass this value to the subsequent browse call to get the next page of results. When the end of the index has been reached, `cursor` is absent from the response.
	Cursor *string `json:"cursor,omitempty"`
}

type BrowseResponseOption func(f *BrowseResponse)

func WithBrowseResponseAbTestID(val int32) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.AbTestID = &val
	}
}

func WithBrowseResponseAbTestVariantID(val int32) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.AbTestVariantID = &val
	}
}

func WithBrowseResponseAroundLatLng(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.AroundLatLng = &val
	}
}

func WithBrowseResponseAutomaticRadius(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.AutomaticRadius = &val
	}
}

func WithBrowseResponseExhaustiveFacetsCount(val bool) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.ExhaustiveFacetsCount = &val
	}
}

func WithBrowseResponseExhaustiveNbHits(val bool) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.ExhaustiveNbHits = &val
	}
}

func WithBrowseResponseExhaustiveTypo(val bool) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.ExhaustiveTypo = &val
	}
}

func WithBrowseResponseFacets(val map[string]map[string]int32) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.Facets = &val
	}
}

func WithBrowseResponseFacetsStats(val map[string]FacetsStats) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.FacetsStats = &val
	}
}

func WithBrowseResponseIndex(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.Index = &val
	}
}

func WithBrowseResponseIndexUsed(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.IndexUsed = &val
	}
}

func WithBrowseResponseMessage(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.Message = &val
	}
}

func WithBrowseResponseNbSortedHits(val int32) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.NbSortedHits = &val
	}
}

func WithBrowseResponseRedirect(val BaseSearchResponseRedirect) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.Redirect = &val
	}
}

func WithBrowseResponseParsedQuery(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.ParsedQuery = &val
	}
}

func WithBrowseResponseQueryAfterRemoval(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.QueryAfterRemoval = &val
	}
}

func WithBrowseResponseServerUsed(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.ServerUsed = &val
	}
}

func WithBrowseResponseUserData(val interface{}) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.UserData = val
	}
}

func WithBrowseResponseRenderingContent(val RenderingContent) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.RenderingContent = &val
	}
}

func WithBrowseResponseCursor(val string) BrowseResponseOption {
	return func(f *BrowseResponse) {
		f.Cursor = &val
	}
}

// NewBrowseResponse instantiates a new BrowseResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewBrowseResponse(hitsPerPage int32, nbHits int32, nbPages int32, page int32, processingTimeMS int32, hits []Hit, query string, params string, opts ...BrowseResponseOption) *BrowseResponse {
	this := &BrowseResponse{}
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

// NewBrowseResponseWithDefaults instantiates a new BrowseResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewBrowseResponseWithDefaults() *BrowseResponse {
	this := &BrowseResponse{}
	var hitsPerPage int32 = 20
	this.HitsPerPage = hitsPerPage
	var page int32 = 0
	this.Page = page
	var query string = ""
	this.Query = query
	return this
}

// GetAbTestID returns the AbTestID field value if set, zero value otherwise.
func (o *BrowseResponse) GetAbTestID() int32 {
	if o == nil || o.AbTestID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestID
}

// GetAbTestIDOk returns a tuple with the AbTestID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetAbTestIDOk() (*int32, bool) {
	if o == nil || o.AbTestID == nil {
		return nil, false
	}
	return o.AbTestID, true
}

// HasAbTestID returns a boolean if a field has been set.
func (o *BrowseResponse) HasAbTestID() bool {
	if o != nil && o.AbTestID != nil {
		return true
	}

	return false
}

// SetAbTestID gets a reference to the given int32 and assigns it to the AbTestID field.
func (o *BrowseResponse) SetAbTestID(v int32) {
	o.AbTestID = &v
}

// GetAbTestVariantID returns the AbTestVariantID field value if set, zero value otherwise.
func (o *BrowseResponse) GetAbTestVariantID() int32 {
	if o == nil || o.AbTestVariantID == nil {
		var ret int32
		return ret
	}
	return *o.AbTestVariantID
}

// GetAbTestVariantIDOk returns a tuple with the AbTestVariantID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetAbTestVariantIDOk() (*int32, bool) {
	if o == nil || o.AbTestVariantID == nil {
		return nil, false
	}
	return o.AbTestVariantID, true
}

// HasAbTestVariantID returns a boolean if a field has been set.
func (o *BrowseResponse) HasAbTestVariantID() bool {
	if o != nil && o.AbTestVariantID != nil {
		return true
	}

	return false
}

// SetAbTestVariantID gets a reference to the given int32 and assigns it to the AbTestVariantID field.
func (o *BrowseResponse) SetAbTestVariantID(v int32) {
	o.AbTestVariantID = &v
}

// GetAroundLatLng returns the AroundLatLng field value if set, zero value otherwise.
func (o *BrowseResponse) GetAroundLatLng() string {
	if o == nil || o.AroundLatLng == nil {
		var ret string
		return ret
	}
	return *o.AroundLatLng
}

// GetAroundLatLngOk returns a tuple with the AroundLatLng field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetAroundLatLngOk() (*string, bool) {
	if o == nil || o.AroundLatLng == nil {
		return nil, false
	}
	return o.AroundLatLng, true
}

// HasAroundLatLng returns a boolean if a field has been set.
func (o *BrowseResponse) HasAroundLatLng() bool {
	if o != nil && o.AroundLatLng != nil {
		return true
	}

	return false
}

// SetAroundLatLng gets a reference to the given string and assigns it to the AroundLatLng field.
func (o *BrowseResponse) SetAroundLatLng(v string) {
	o.AroundLatLng = &v
}

// GetAutomaticRadius returns the AutomaticRadius field value if set, zero value otherwise.
func (o *BrowseResponse) GetAutomaticRadius() string {
	if o == nil || o.AutomaticRadius == nil {
		var ret string
		return ret
	}
	return *o.AutomaticRadius
}

// GetAutomaticRadiusOk returns a tuple with the AutomaticRadius field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetAutomaticRadiusOk() (*string, bool) {
	if o == nil || o.AutomaticRadius == nil {
		return nil, false
	}
	return o.AutomaticRadius, true
}

// HasAutomaticRadius returns a boolean if a field has been set.
func (o *BrowseResponse) HasAutomaticRadius() bool {
	if o != nil && o.AutomaticRadius != nil {
		return true
	}

	return false
}

// SetAutomaticRadius gets a reference to the given string and assigns it to the AutomaticRadius field.
func (o *BrowseResponse) SetAutomaticRadius(v string) {
	o.AutomaticRadius = &v
}

// GetExhaustiveFacetsCount returns the ExhaustiveFacetsCount field value if set, zero value otherwise.
func (o *BrowseResponse) GetExhaustiveFacetsCount() bool {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveFacetsCount
}

// GetExhaustiveFacetsCountOk returns a tuple with the ExhaustiveFacetsCount field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetExhaustiveFacetsCountOk() (*bool, bool) {
	if o == nil || o.ExhaustiveFacetsCount == nil {
		return nil, false
	}
	return o.ExhaustiveFacetsCount, true
}

// HasExhaustiveFacetsCount returns a boolean if a field has been set.
func (o *BrowseResponse) HasExhaustiveFacetsCount() bool {
	if o != nil && o.ExhaustiveFacetsCount != nil {
		return true
	}

	return false
}

// SetExhaustiveFacetsCount gets a reference to the given bool and assigns it to the ExhaustiveFacetsCount field.
func (o *BrowseResponse) SetExhaustiveFacetsCount(v bool) {
	o.ExhaustiveFacetsCount = &v
}

// GetExhaustiveNbHits returns the ExhaustiveNbHits field value if set, zero value otherwise.
func (o *BrowseResponse) GetExhaustiveNbHits() bool {
	if o == nil || o.ExhaustiveNbHits == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveNbHits
}

// GetExhaustiveNbHitsOk returns a tuple with the ExhaustiveNbHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetExhaustiveNbHitsOk() (*bool, bool) {
	if o == nil || o.ExhaustiveNbHits == nil {
		return nil, false
	}
	return o.ExhaustiveNbHits, true
}

// HasExhaustiveNbHits returns a boolean if a field has been set.
func (o *BrowseResponse) HasExhaustiveNbHits() bool {
	if o != nil && o.ExhaustiveNbHits != nil {
		return true
	}

	return false
}

// SetExhaustiveNbHits gets a reference to the given bool and assigns it to the ExhaustiveNbHits field.
func (o *BrowseResponse) SetExhaustiveNbHits(v bool) {
	o.ExhaustiveNbHits = &v
}

// GetExhaustiveTypo returns the ExhaustiveTypo field value if set, zero value otherwise.
func (o *BrowseResponse) GetExhaustiveTypo() bool {
	if o == nil || o.ExhaustiveTypo == nil {
		var ret bool
		return ret
	}
	return *o.ExhaustiveTypo
}

// GetExhaustiveTypoOk returns a tuple with the ExhaustiveTypo field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetExhaustiveTypoOk() (*bool, bool) {
	if o == nil || o.ExhaustiveTypo == nil {
		return nil, false
	}
	return o.ExhaustiveTypo, true
}

// HasExhaustiveTypo returns a boolean if a field has been set.
func (o *BrowseResponse) HasExhaustiveTypo() bool {
	if o != nil && o.ExhaustiveTypo != nil {
		return true
	}

	return false
}

// SetExhaustiveTypo gets a reference to the given bool and assigns it to the ExhaustiveTypo field.
func (o *BrowseResponse) SetExhaustiveTypo(v bool) {
	o.ExhaustiveTypo = &v
}

// GetFacets returns the Facets field value if set, zero value otherwise.
func (o *BrowseResponse) GetFacets() map[string]map[string]int32 {
	if o == nil || o.Facets == nil {
		var ret map[string]map[string]int32
		return ret
	}
	return *o.Facets
}

// GetFacetsOk returns a tuple with the Facets field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetFacetsOk() (*map[string]map[string]int32, bool) {
	if o == nil || o.Facets == nil {
		return nil, false
	}
	return o.Facets, true
}

// HasFacets returns a boolean if a field has been set.
func (o *BrowseResponse) HasFacets() bool {
	if o != nil && o.Facets != nil {
		return true
	}

	return false
}

// SetFacets gets a reference to the given map[string]map[string]int32 and assigns it to the Facets field.
func (o *BrowseResponse) SetFacets(v map[string]map[string]int32) {
	o.Facets = &v
}

// GetFacetsStats returns the FacetsStats field value if set, zero value otherwise.
func (o *BrowseResponse) GetFacetsStats() map[string]FacetsStats {
	if o == nil || o.FacetsStats == nil {
		var ret map[string]FacetsStats
		return ret
	}
	return *o.FacetsStats
}

// GetFacetsStatsOk returns a tuple with the FacetsStats field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetFacetsStatsOk() (*map[string]FacetsStats, bool) {
	if o == nil || o.FacetsStats == nil {
		return nil, false
	}
	return o.FacetsStats, true
}

// HasFacetsStats returns a boolean if a field has been set.
func (o *BrowseResponse) HasFacetsStats() bool {
	if o != nil && o.FacetsStats != nil {
		return true
	}

	return false
}

// SetFacetsStats gets a reference to the given map[string]FacetsStats and assigns it to the FacetsStats field.
func (o *BrowseResponse) SetFacetsStats(v map[string]FacetsStats) {
	o.FacetsStats = &v
}

// GetHitsPerPage returns the HitsPerPage field value
func (o *BrowseResponse) GetHitsPerPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.HitsPerPage
}

// GetHitsPerPageOk returns a tuple with the HitsPerPage field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetHitsPerPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.HitsPerPage, true
}

// SetHitsPerPage sets field value
func (o *BrowseResponse) SetHitsPerPage(v int32) {
	o.HitsPerPage = v
}

// GetIndex returns the Index field value if set, zero value otherwise.
func (o *BrowseResponse) GetIndex() string {
	if o == nil || o.Index == nil {
		var ret string
		return ret
	}
	return *o.Index
}

// GetIndexOk returns a tuple with the Index field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetIndexOk() (*string, bool) {
	if o == nil || o.Index == nil {
		return nil, false
	}
	return o.Index, true
}

// HasIndex returns a boolean if a field has been set.
func (o *BrowseResponse) HasIndex() bool {
	if o != nil && o.Index != nil {
		return true
	}

	return false
}

// SetIndex gets a reference to the given string and assigns it to the Index field.
func (o *BrowseResponse) SetIndex(v string) {
	o.Index = &v
}

// GetIndexUsed returns the IndexUsed field value if set, zero value otherwise.
func (o *BrowseResponse) GetIndexUsed() string {
	if o == nil || o.IndexUsed == nil {
		var ret string
		return ret
	}
	return *o.IndexUsed
}

// GetIndexUsedOk returns a tuple with the IndexUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetIndexUsedOk() (*string, bool) {
	if o == nil || o.IndexUsed == nil {
		return nil, false
	}
	return o.IndexUsed, true
}

// HasIndexUsed returns a boolean if a field has been set.
func (o *BrowseResponse) HasIndexUsed() bool {
	if o != nil && o.IndexUsed != nil {
		return true
	}

	return false
}

// SetIndexUsed gets a reference to the given string and assigns it to the IndexUsed field.
func (o *BrowseResponse) SetIndexUsed(v string) {
	o.IndexUsed = &v
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *BrowseResponse) GetMessage() string {
	if o == nil || o.Message == nil {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetMessageOk() (*string, bool) {
	if o == nil || o.Message == nil {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *BrowseResponse) HasMessage() bool {
	if o != nil && o.Message != nil {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *BrowseResponse) SetMessage(v string) {
	o.Message = &v
}

// GetNbHits returns the NbHits field value
func (o *BrowseResponse) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value
func (o *BrowseResponse) SetNbHits(v int32) {
	o.NbHits = v
}

// GetNbPages returns the NbPages field value
func (o *BrowseResponse) GetNbPages() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbPages
}

// GetNbPagesOk returns a tuple with the NbPages field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetNbPagesOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbPages, true
}

// SetNbPages sets field value
func (o *BrowseResponse) SetNbPages(v int32) {
	o.NbPages = v
}

// GetNbSortedHits returns the NbSortedHits field value if set, zero value otherwise.
func (o *BrowseResponse) GetNbSortedHits() int32 {
	if o == nil || o.NbSortedHits == nil {
		var ret int32
		return ret
	}
	return *o.NbSortedHits
}

// GetNbSortedHitsOk returns a tuple with the NbSortedHits field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetNbSortedHitsOk() (*int32, bool) {
	if o == nil || o.NbSortedHits == nil {
		return nil, false
	}
	return o.NbSortedHits, true
}

// HasNbSortedHits returns a boolean if a field has been set.
func (o *BrowseResponse) HasNbSortedHits() bool {
	if o != nil && o.NbSortedHits != nil {
		return true
	}

	return false
}

// SetNbSortedHits gets a reference to the given int32 and assigns it to the NbSortedHits field.
func (o *BrowseResponse) SetNbSortedHits(v int32) {
	o.NbSortedHits = &v
}

// GetPage returns the Page field value
func (o *BrowseResponse) GetPage() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Page
}

// GetPageOk returns a tuple with the Page field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetPageOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Page, true
}

// SetPage sets field value
func (o *BrowseResponse) SetPage(v int32) {
	o.Page = v
}

// GetRedirect returns the Redirect field value if set, zero value otherwise.
func (o *BrowseResponse) GetRedirect() BaseSearchResponseRedirect {
	if o == nil || o.Redirect == nil {
		var ret BaseSearchResponseRedirect
		return ret
	}
	return *o.Redirect
}

// GetRedirectOk returns a tuple with the Redirect field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetRedirectOk() (*BaseSearchResponseRedirect, bool) {
	if o == nil || o.Redirect == nil {
		return nil, false
	}
	return o.Redirect, true
}

// HasRedirect returns a boolean if a field has been set.
func (o *BrowseResponse) HasRedirect() bool {
	if o != nil && o.Redirect != nil {
		return true
	}

	return false
}

// SetRedirect gets a reference to the given BaseSearchResponseRedirect and assigns it to the Redirect field.
func (o *BrowseResponse) SetRedirect(v BaseSearchResponseRedirect) {
	o.Redirect = &v
}

// GetParsedQuery returns the ParsedQuery field value if set, zero value otherwise.
func (o *BrowseResponse) GetParsedQuery() string {
	if o == nil || o.ParsedQuery == nil {
		var ret string
		return ret
	}
	return *o.ParsedQuery
}

// GetParsedQueryOk returns a tuple with the ParsedQuery field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetParsedQueryOk() (*string, bool) {
	if o == nil || o.ParsedQuery == nil {
		return nil, false
	}
	return o.ParsedQuery, true
}

// HasParsedQuery returns a boolean if a field has been set.
func (o *BrowseResponse) HasParsedQuery() bool {
	if o != nil && o.ParsedQuery != nil {
		return true
	}

	return false
}

// SetParsedQuery gets a reference to the given string and assigns it to the ParsedQuery field.
func (o *BrowseResponse) SetParsedQuery(v string) {
	o.ParsedQuery = &v
}

// GetProcessingTimeMS returns the ProcessingTimeMS field value
func (o *BrowseResponse) GetProcessingTimeMS() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.ProcessingTimeMS
}

// GetProcessingTimeMSOk returns a tuple with the ProcessingTimeMS field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetProcessingTimeMSOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ProcessingTimeMS, true
}

// SetProcessingTimeMS sets field value
func (o *BrowseResponse) SetProcessingTimeMS(v int32) {
	o.ProcessingTimeMS = v
}

// GetQueryAfterRemoval returns the QueryAfterRemoval field value if set, zero value otherwise.
func (o *BrowseResponse) GetQueryAfterRemoval() string {
	if o == nil || o.QueryAfterRemoval == nil {
		var ret string
		return ret
	}
	return *o.QueryAfterRemoval
}

// GetQueryAfterRemovalOk returns a tuple with the QueryAfterRemoval field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetQueryAfterRemovalOk() (*string, bool) {
	if o == nil || o.QueryAfterRemoval == nil {
		return nil, false
	}
	return o.QueryAfterRemoval, true
}

// HasQueryAfterRemoval returns a boolean if a field has been set.
func (o *BrowseResponse) HasQueryAfterRemoval() bool {
	if o != nil && o.QueryAfterRemoval != nil {
		return true
	}

	return false
}

// SetQueryAfterRemoval gets a reference to the given string and assigns it to the QueryAfterRemoval field.
func (o *BrowseResponse) SetQueryAfterRemoval(v string) {
	o.QueryAfterRemoval = &v
}

// GetServerUsed returns the ServerUsed field value if set, zero value otherwise.
func (o *BrowseResponse) GetServerUsed() string {
	if o == nil || o.ServerUsed == nil {
		var ret string
		return ret
	}
	return *o.ServerUsed
}

// GetServerUsedOk returns a tuple with the ServerUsed field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetServerUsedOk() (*string, bool) {
	if o == nil || o.ServerUsed == nil {
		return nil, false
	}
	return o.ServerUsed, true
}

// HasServerUsed returns a boolean if a field has been set.
func (o *BrowseResponse) HasServerUsed() bool {
	if o != nil && o.ServerUsed != nil {
		return true
	}

	return false
}

// SetServerUsed gets a reference to the given string and assigns it to the ServerUsed field.
func (o *BrowseResponse) SetServerUsed(v string) {
	o.ServerUsed = &v
}

// GetUserData returns the UserData field value if set, zero value otherwise (both if not set or set to explicit null).
func (o *BrowseResponse) GetUserData() interface{} {
	if o == nil {
		var ret interface{}
		return ret
	}
	return o.UserData
}

// GetUserDataOk returns a tuple with the UserData field value if set, nil otherwise
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned
func (o *BrowseResponse) GetUserDataOk() (*interface{}, bool) {
	if o == nil || o.UserData == nil {
		return nil, false
	}
	return &o.UserData, true
}

// HasUserData returns a boolean if a field has been set.
func (o *BrowseResponse) HasUserData() bool {
	if o != nil && o.UserData != nil {
		return true
	}

	return false
}

// SetUserData gets a reference to the given interface{} and assigns it to the UserData field.
func (o *BrowseResponse) SetUserData(v interface{}) {
	o.UserData = v
}

// GetRenderingContent returns the RenderingContent field value if set, zero value otherwise.
func (o *BrowseResponse) GetRenderingContent() RenderingContent {
	if o == nil || o.RenderingContent == nil {
		var ret RenderingContent
		return ret
	}
	return *o.RenderingContent
}

// GetRenderingContentOk returns a tuple with the RenderingContent field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetRenderingContentOk() (*RenderingContent, bool) {
	if o == nil || o.RenderingContent == nil {
		return nil, false
	}
	return o.RenderingContent, true
}

// HasRenderingContent returns a boolean if a field has been set.
func (o *BrowseResponse) HasRenderingContent() bool {
	if o != nil && o.RenderingContent != nil {
		return true
	}

	return false
}

// SetRenderingContent gets a reference to the given RenderingContent and assigns it to the RenderingContent field.
func (o *BrowseResponse) SetRenderingContent(v RenderingContent) {
	o.RenderingContent = &v
}

// GetHits returns the Hits field value
func (o *BrowseResponse) GetHits() []Hit {
	if o == nil {
		var ret []Hit
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetHitsOk() ([]Hit, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value
func (o *BrowseResponse) SetHits(v []Hit) {
	o.Hits = v
}

// GetQuery returns the Query field value
func (o *BrowseResponse) GetQuery() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Query
}

// GetQueryOk returns a tuple with the Query field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetQueryOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Query, true
}

// SetQuery sets field value
func (o *BrowseResponse) SetQuery(v string) {
	o.Query = v
}

// GetParams returns the Params field value
func (o *BrowseResponse) GetParams() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Params
}

// GetParamsOk returns a tuple with the Params field value
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetParamsOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Params, true
}

// SetParams sets field value
func (o *BrowseResponse) SetParams(v string) {
	o.Params = v
}

// GetCursor returns the Cursor field value if set, zero value otherwise.
func (o *BrowseResponse) GetCursor() string {
	if o == nil || o.Cursor == nil {
		var ret string
		return ret
	}
	return *o.Cursor
}

// GetCursorOk returns a tuple with the Cursor field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *BrowseResponse) GetCursorOk() (*string, bool) {
	if o == nil || o.Cursor == nil {
		return nil, false
	}
	return o.Cursor, true
}

// HasCursor returns a boolean if a field has been set.
func (o *BrowseResponse) HasCursor() bool {
	if o != nil && o.Cursor != nil {
		return true
	}

	return false
}

// SetCursor gets a reference to the given string and assigns it to the Cursor field.
func (o *BrowseResponse) SetCursor(v string) {
	o.Cursor = &v
}

func (o BrowseResponse) MarshalJSON() ([]byte, error) {
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
	if o.Redirect != nil {
		toSerialize["redirect"] = o.Redirect
	}
	if o.ParsedQuery != nil {
		toSerialize["parsedQuery"] = o.ParsedQuery
	}
	if true {
		toSerialize["processingTimeMS"] = o.ProcessingTimeMS
	}
	if o.QueryAfterRemoval != nil {
		toSerialize["queryAfterRemoval"] = o.QueryAfterRemoval
	}
	if o.ServerUsed != nil {
		toSerialize["serverUsed"] = o.ServerUsed
	}
	if o.UserData != nil {
		toSerialize["userData"] = o.UserData
	}
	if o.RenderingContent != nil {
		toSerialize["renderingContent"] = o.RenderingContent
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
	if o.Cursor != nil {
		toSerialize["cursor"] = o.Cursor
	}
	return json.Marshal(toSerialize)
}

func (o BrowseResponse) String() string {
	out := ""
	out += fmt.Sprintf("  abTestID=%v\n", o.AbTestID)
	out += fmt.Sprintf("  abTestVariantID=%v\n", o.AbTestVariantID)
	out += fmt.Sprintf("  aroundLatLng=%v\n", o.AroundLatLng)
	out += fmt.Sprintf("  automaticRadius=%v\n", o.AutomaticRadius)
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
	out += fmt.Sprintf("  redirect=%v\n", o.Redirect)
	out += fmt.Sprintf("  parsedQuery=%v\n", o.ParsedQuery)
	out += fmt.Sprintf("  processingTimeMS=%v\n", o.ProcessingTimeMS)
	out += fmt.Sprintf("  queryAfterRemoval=%v\n", o.QueryAfterRemoval)
	out += fmt.Sprintf("  serverUsed=%v\n", o.ServerUsed)
	out += fmt.Sprintf("  userData=%v\n", o.UserData)
	out += fmt.Sprintf("  renderingContent=%v\n", o.RenderingContent)
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	out += fmt.Sprintf("  query=%v\n", o.Query)
	out += fmt.Sprintf("  params=%v\n", o.Params)
	out += fmt.Sprintf("  cursor=%v\n", o.Cursor)
	return fmt.Sprintf("BrowseResponse {\n%s}", out)
}

type NullableBrowseResponse struct {
	value *BrowseResponse
	isSet bool
}

func (v NullableBrowseResponse) Get() *BrowseResponse {
	return v.value
}

func (v *NullableBrowseResponse) Set(val *BrowseResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableBrowseResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableBrowseResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableBrowseResponse(val *BrowseResponse) *NullableBrowseResponse {
	return &NullableBrowseResponse{value: val, isSet: true}
}

func (v NullableBrowseResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableBrowseResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
