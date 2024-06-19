// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// TopSearchesResponseWithAnalytics struct for TopSearchesResponseWithAnalytics.
type TopSearchesResponseWithAnalytics struct {
	// Most popular searches and their associated click and conversion metrics.
	Searches []TopSearchWithAnalytics `json:"searches"`
}

// NewTopSearchesResponseWithAnalytics instantiates a new TopSearchesResponseWithAnalytics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTopSearchesResponseWithAnalytics(searches []TopSearchWithAnalytics) *TopSearchesResponseWithAnalytics {
	this := &TopSearchesResponseWithAnalytics{}
	this.Searches = searches
	return this
}

// NewEmptyTopSearchesResponseWithAnalytics return a pointer to an empty TopSearchesResponseWithAnalytics object.
func NewEmptyTopSearchesResponseWithAnalytics() *TopSearchesResponseWithAnalytics {
	return &TopSearchesResponseWithAnalytics{}
}

// GetSearches returns the Searches field value.
func (o *TopSearchesResponseWithAnalytics) GetSearches() []TopSearchWithAnalytics {
	if o == nil {
		var ret []TopSearchWithAnalytics
		return ret
	}

	return o.Searches
}

// GetSearchesOk returns a tuple with the Searches field value
// and a boolean to check if the value has been set.
func (o *TopSearchesResponseWithAnalytics) GetSearchesOk() ([]TopSearchWithAnalytics, bool) {
	if o == nil {
		return nil, false
	}
	return o.Searches, true
}

// SetSearches sets field value.
func (o *TopSearchesResponseWithAnalytics) SetSearches(v []TopSearchWithAnalytics) *TopSearchesResponseWithAnalytics {
	o.Searches = v
	return o
}

func (o TopSearchesResponseWithAnalytics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["searches"] = o.Searches
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TopSearchesResponseWithAnalytics: %w", err)
	}

	return serialized, nil
}

func (o TopSearchesResponseWithAnalytics) String() string {
	out := ""
	out += fmt.Sprintf("  searches=%v\n", o.Searches)
	return fmt.Sprintf("TopSearchesResponseWithAnalytics {\n%s}", out)
}
