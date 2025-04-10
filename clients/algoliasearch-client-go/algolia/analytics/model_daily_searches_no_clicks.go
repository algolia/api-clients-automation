// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// DailySearchesNoClicks struct for DailySearchesNoClicks.
type DailySearchesNoClicks struct {
	// Search query.
	Search string `json:"search"`
	// Number of tracked searches.
	Count int32 `json:"count"`
	// Number of results (hits).
	NbHits int32 `json:"nbHits"`
}

// NewDailySearchesNoClicks instantiates a new DailySearchesNoClicks object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDailySearchesNoClicks(search string, count int32, nbHits int32) *DailySearchesNoClicks {
	this := &DailySearchesNoClicks{}
	this.Search = search
	this.Count = count
	this.NbHits = nbHits
	return this
}

// NewEmptyDailySearchesNoClicks return a pointer to an empty DailySearchesNoClicks object.
func NewEmptyDailySearchesNoClicks() *DailySearchesNoClicks {
	return &DailySearchesNoClicks{}
}

// GetSearch returns the Search field value.
func (o *DailySearchesNoClicks) GetSearch() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Search
}

// GetSearchOk returns a tuple with the Search field value
// and a boolean to check if the value has been set.
func (o *DailySearchesNoClicks) GetSearchOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Search, true
}

// SetSearch sets field value.
func (o *DailySearchesNoClicks) SetSearch(v string) *DailySearchesNoClicks {
	o.Search = v
	return o
}

// GetCount returns the Count field value.
func (o *DailySearchesNoClicks) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *DailySearchesNoClicks) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *DailySearchesNoClicks) SetCount(v int32) *DailySearchesNoClicks {
	o.Count = v
	return o
}

// GetNbHits returns the NbHits field value.
func (o *DailySearchesNoClicks) GetNbHits() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbHits
}

// GetNbHitsOk returns a tuple with the NbHits field value
// and a boolean to check if the value has been set.
func (o *DailySearchesNoClicks) GetNbHitsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbHits, true
}

// SetNbHits sets field value.
func (o *DailySearchesNoClicks) SetNbHits(v int32) *DailySearchesNoClicks {
	o.NbHits = v
	return o
}

func (o DailySearchesNoClicks) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["search"] = o.Search
	toSerialize["count"] = o.Count
	toSerialize["nbHits"] = o.NbHits
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DailySearchesNoClicks: %w", err)
	}

	return serialized, nil
}

func (o DailySearchesNoClicks) String() string {
	out := ""
	out += fmt.Sprintf("  search=%v\n", o.Search)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  nbHits=%v\n", o.NbHits)
	return fmt.Sprintf("DailySearchesNoClicks {\n%s}", out)
}
