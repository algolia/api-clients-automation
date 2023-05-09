// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// RankingInfo struct for RankingInfo
type RankingInfo struct {
	// This field is reserved for advanced usage.
	Filters int32 `json:"filters" validate:"required"`
	// Position of the most important matched attribute in the attributes to index list.
	FirstMatchedWord int32 `json:"firstMatchedWord" validate:"required"`
	// Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters).
	GeoDistance int32 `json:"geoDistance" validate:"required"`
	// Precision used when computing the geo distance, in meters.
	GeoPrecision       *int32              `json:"geoPrecision,omitempty"`
	MatchedGeoLocation *MatchedGeoLocation `json:"matchedGeoLocation,omitempty"`
	Personalization    *Personalization    `json:"personalization,omitempty"`
	// Number of exactly matched words.
	NbExactWords int32 `json:"nbExactWords" validate:"required"`
	// Number of typos encountered when matching the record.
	NbTypos int32 `json:"nbTypos" validate:"required"`
	// Present and set to true if a Rule promoted the hit.
	Promoted bool `json:"promoted" validate:"required"`
	// When the query contains more than one word, the sum of the distances between matched words (in meters).
	ProximityDistance *int32 `json:"proximityDistance,omitempty"`
	// Custom ranking for the object, expressed as a single integer value.
	UserScore int32 `json:"userScore" validate:"required"`
	// Number of matched words, including prefixes and typos.
	Words int32 `json:"words" validate:"required"`
	// Wether the record are promoted by the re-ranking strategy.
	PromotedByReRanking *bool `json:"promotedByReRanking,omitempty"`
}

type RankingInfoOption func(f *RankingInfo)

func WithRankingInfoGeoPrecision(val int32) RankingInfoOption {
	return func(f *RankingInfo) {
		f.GeoPrecision = &val
	}
}

func WithRankingInfoMatchedGeoLocation(val MatchedGeoLocation) RankingInfoOption {
	return func(f *RankingInfo) {
		f.MatchedGeoLocation = &val
	}
}

func WithRankingInfoPersonalization(val Personalization) RankingInfoOption {
	return func(f *RankingInfo) {
		f.Personalization = &val
	}
}

func WithRankingInfoProximityDistance(val int32) RankingInfoOption {
	return func(f *RankingInfo) {
		f.ProximityDistance = &val
	}
}

func WithRankingInfoPromotedByReRanking(val bool) RankingInfoOption {
	return func(f *RankingInfo) {
		f.PromotedByReRanking = &val
	}
}

// NewRankingInfo instantiates a new RankingInfo object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewRankingInfo(filters int32, firstMatchedWord int32, geoDistance int32, nbExactWords int32, nbTypos int32, promoted bool, userScore int32, words int32, opts ...RankingInfoOption) *RankingInfo {
	this := &RankingInfo{}
	this.Filters = filters
	this.FirstMatchedWord = firstMatchedWord
	this.GeoDistance = geoDistance
	this.NbExactWords = nbExactWords
	this.NbTypos = nbTypos
	this.Promoted = promoted
	this.UserScore = userScore
	this.Words = words
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewRankingInfoWithDefaults instantiates a new RankingInfo object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewRankingInfoWithDefaults() *RankingInfo {
	this := &RankingInfo{}
	return this
}

// GetFilters returns the Filters field value
func (o *RankingInfo) GetFilters() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Filters
}

// GetFiltersOk returns a tuple with the Filters field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetFiltersOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Filters, true
}

// SetFilters sets field value
func (o *RankingInfo) SetFilters(v int32) {
	o.Filters = v
}

// GetFirstMatchedWord returns the FirstMatchedWord field value
func (o *RankingInfo) GetFirstMatchedWord() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.FirstMatchedWord
}

// GetFirstMatchedWordOk returns a tuple with the FirstMatchedWord field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetFirstMatchedWordOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.FirstMatchedWord, true
}

// SetFirstMatchedWord sets field value
func (o *RankingInfo) SetFirstMatchedWord(v int32) {
	o.FirstMatchedWord = v
}

// GetGeoDistance returns the GeoDistance field value
func (o *RankingInfo) GetGeoDistance() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.GeoDistance
}

// GetGeoDistanceOk returns a tuple with the GeoDistance field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetGeoDistanceOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.GeoDistance, true
}

// SetGeoDistance sets field value
func (o *RankingInfo) SetGeoDistance(v int32) {
	o.GeoDistance = v
}

// GetGeoPrecision returns the GeoPrecision field value if set, zero value otherwise.
func (o *RankingInfo) GetGeoPrecision() int32 {
	if o == nil || o.GeoPrecision == nil {
		var ret int32
		return ret
	}
	return *o.GeoPrecision
}

// GetGeoPrecisionOk returns a tuple with the GeoPrecision field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetGeoPrecisionOk() (*int32, bool) {
	if o == nil || o.GeoPrecision == nil {
		return nil, false
	}
	return o.GeoPrecision, true
}

// HasGeoPrecision returns a boolean if a field has been set.
func (o *RankingInfo) HasGeoPrecision() bool {
	if o != nil && o.GeoPrecision != nil {
		return true
	}

	return false
}

// SetGeoPrecision gets a reference to the given int32 and assigns it to the GeoPrecision field.
func (o *RankingInfo) SetGeoPrecision(v int32) {
	o.GeoPrecision = &v
}

// GetMatchedGeoLocation returns the MatchedGeoLocation field value if set, zero value otherwise.
func (o *RankingInfo) GetMatchedGeoLocation() MatchedGeoLocation {
	if o == nil || o.MatchedGeoLocation == nil {
		var ret MatchedGeoLocation
		return ret
	}
	return *o.MatchedGeoLocation
}

// GetMatchedGeoLocationOk returns a tuple with the MatchedGeoLocation field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetMatchedGeoLocationOk() (*MatchedGeoLocation, bool) {
	if o == nil || o.MatchedGeoLocation == nil {
		return nil, false
	}
	return o.MatchedGeoLocation, true
}

// HasMatchedGeoLocation returns a boolean if a field has been set.
func (o *RankingInfo) HasMatchedGeoLocation() bool {
	if o != nil && o.MatchedGeoLocation != nil {
		return true
	}

	return false
}

// SetMatchedGeoLocation gets a reference to the given MatchedGeoLocation and assigns it to the MatchedGeoLocation field.
func (o *RankingInfo) SetMatchedGeoLocation(v MatchedGeoLocation) {
	o.MatchedGeoLocation = &v
}

// GetPersonalization returns the Personalization field value if set, zero value otherwise.
func (o *RankingInfo) GetPersonalization() Personalization {
	if o == nil || o.Personalization == nil {
		var ret Personalization
		return ret
	}
	return *o.Personalization
}

// GetPersonalizationOk returns a tuple with the Personalization field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetPersonalizationOk() (*Personalization, bool) {
	if o == nil || o.Personalization == nil {
		return nil, false
	}
	return o.Personalization, true
}

// HasPersonalization returns a boolean if a field has been set.
func (o *RankingInfo) HasPersonalization() bool {
	if o != nil && o.Personalization != nil {
		return true
	}

	return false
}

// SetPersonalization gets a reference to the given Personalization and assigns it to the Personalization field.
func (o *RankingInfo) SetPersonalization(v Personalization) {
	o.Personalization = &v
}

// GetNbExactWords returns the NbExactWords field value
func (o *RankingInfo) GetNbExactWords() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbExactWords
}

// GetNbExactWordsOk returns a tuple with the NbExactWords field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetNbExactWordsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbExactWords, true
}

// SetNbExactWords sets field value
func (o *RankingInfo) SetNbExactWords(v int32) {
	o.NbExactWords = v
}

// GetNbTypos returns the NbTypos field value
func (o *RankingInfo) GetNbTypos() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbTypos
}

// GetNbTyposOk returns a tuple with the NbTypos field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetNbTyposOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbTypos, true
}

// SetNbTypos sets field value
func (o *RankingInfo) SetNbTypos(v int32) {
	o.NbTypos = v
}

// GetPromoted returns the Promoted field value
func (o *RankingInfo) GetPromoted() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.Promoted
}

// GetPromotedOk returns a tuple with the Promoted field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetPromotedOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Promoted, true
}

// SetPromoted sets field value
func (o *RankingInfo) SetPromoted(v bool) {
	o.Promoted = v
}

// GetProximityDistance returns the ProximityDistance field value if set, zero value otherwise.
func (o *RankingInfo) GetProximityDistance() int32 {
	if o == nil || o.ProximityDistance == nil {
		var ret int32
		return ret
	}
	return *o.ProximityDistance
}

// GetProximityDistanceOk returns a tuple with the ProximityDistance field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetProximityDistanceOk() (*int32, bool) {
	if o == nil || o.ProximityDistance == nil {
		return nil, false
	}
	return o.ProximityDistance, true
}

// HasProximityDistance returns a boolean if a field has been set.
func (o *RankingInfo) HasProximityDistance() bool {
	if o != nil && o.ProximityDistance != nil {
		return true
	}

	return false
}

// SetProximityDistance gets a reference to the given int32 and assigns it to the ProximityDistance field.
func (o *RankingInfo) SetProximityDistance(v int32) {
	o.ProximityDistance = &v
}

// GetUserScore returns the UserScore field value
func (o *RankingInfo) GetUserScore() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.UserScore
}

// GetUserScoreOk returns a tuple with the UserScore field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetUserScoreOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserScore, true
}

// SetUserScore sets field value
func (o *RankingInfo) SetUserScore(v int32) {
	o.UserScore = v
}

// GetWords returns the Words field value
func (o *RankingInfo) GetWords() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Words
}

// GetWordsOk returns a tuple with the Words field value
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetWordsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Words, true
}

// SetWords sets field value
func (o *RankingInfo) SetWords(v int32) {
	o.Words = v
}

// GetPromotedByReRanking returns the PromotedByReRanking field value if set, zero value otherwise.
func (o *RankingInfo) GetPromotedByReRanking() bool {
	if o == nil || o.PromotedByReRanking == nil {
		var ret bool
		return ret
	}
	return *o.PromotedByReRanking
}

// GetPromotedByReRankingOk returns a tuple with the PromotedByReRanking field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *RankingInfo) GetPromotedByReRankingOk() (*bool, bool) {
	if o == nil || o.PromotedByReRanking == nil {
		return nil, false
	}
	return o.PromotedByReRanking, true
}

// HasPromotedByReRanking returns a boolean if a field has been set.
func (o *RankingInfo) HasPromotedByReRanking() bool {
	if o != nil && o.PromotedByReRanking != nil {
		return true
	}

	return false
}

// SetPromotedByReRanking gets a reference to the given bool and assigns it to the PromotedByReRanking field.
func (o *RankingInfo) SetPromotedByReRanking(v bool) {
	o.PromotedByReRanking = &v
}

func (o RankingInfo) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["filters"] = o.Filters
	}
	if true {
		toSerialize["firstMatchedWord"] = o.FirstMatchedWord
	}
	if true {
		toSerialize["geoDistance"] = o.GeoDistance
	}
	if o.GeoPrecision != nil {
		toSerialize["geoPrecision"] = o.GeoPrecision
	}
	if o.MatchedGeoLocation != nil {
		toSerialize["matchedGeoLocation"] = o.MatchedGeoLocation
	}
	if o.Personalization != nil {
		toSerialize["personalization"] = o.Personalization
	}
	if true {
		toSerialize["nbExactWords"] = o.NbExactWords
	}
	if true {
		toSerialize["nbTypos"] = o.NbTypos
	}
	if true {
		toSerialize["promoted"] = o.Promoted
	}
	if o.ProximityDistance != nil {
		toSerialize["proximityDistance"] = o.ProximityDistance
	}
	if true {
		toSerialize["userScore"] = o.UserScore
	}
	if true {
		toSerialize["words"] = o.Words
	}
	if o.PromotedByReRanking != nil {
		toSerialize["promotedByReRanking"] = o.PromotedByReRanking
	}
	return json.Marshal(toSerialize)
}

func (o RankingInfo) String() string {
	out := ""
	out += fmt.Sprintf("  filters=%v\n", o.Filters)
	out += fmt.Sprintf("  firstMatchedWord=%v\n", o.FirstMatchedWord)
	out += fmt.Sprintf("  geoDistance=%v\n", o.GeoDistance)
	out += fmt.Sprintf("  geoPrecision=%v\n", o.GeoPrecision)
	out += fmt.Sprintf("  matchedGeoLocation=%v\n", o.MatchedGeoLocation)
	out += fmt.Sprintf("  personalization=%v\n", o.Personalization)
	out += fmt.Sprintf("  nbExactWords=%v\n", o.NbExactWords)
	out += fmt.Sprintf("  nbTypos=%v\n", o.NbTypos)
	out += fmt.Sprintf("  promoted=%v\n", o.Promoted)
	out += fmt.Sprintf("  proximityDistance=%v\n", o.ProximityDistance)
	out += fmt.Sprintf("  userScore=%v\n", o.UserScore)
	out += fmt.Sprintf("  words=%v\n", o.Words)
	out += fmt.Sprintf("  promotedByReRanking=%v\n", o.PromotedByReRanking)
	return fmt.Sprintf("RankingInfo {\n%s}", out)
}

type NullableRankingInfo struct {
	value *RankingInfo
	isSet bool
}

func (v NullableRankingInfo) Get() *RankingInfo {
	return v.value
}

func (v *NullableRankingInfo) Set(val *RankingInfo) {
	v.value = val
	v.isSet = true
}

func (v NullableRankingInfo) IsSet() bool {
	return v.isSet
}

func (v *NullableRankingInfo) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableRankingInfo(val *RankingInfo) *NullableRankingInfo {
	return &NullableRankingInfo{value: val, isSet: true}
}

func (v NullableRankingInfo) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableRankingInfo) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
