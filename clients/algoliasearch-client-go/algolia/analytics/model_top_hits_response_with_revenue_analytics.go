// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package analytics

import (
	"encoding/json"
	"fmt"
)

// TopHitsResponseWithRevenueAnalytics struct for TopHitsResponseWithRevenueAnalytics.
type TopHitsResponseWithRevenueAnalytics struct {
	// Most frequent search results with click, conversion, and revenue metrics.
	Hits []TopHitWithRevenueAnalytics `json:"hits"`
}

// NewTopHitsResponseWithRevenueAnalytics instantiates a new TopHitsResponseWithRevenueAnalytics object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewTopHitsResponseWithRevenueAnalytics(hits []TopHitWithRevenueAnalytics) *TopHitsResponseWithRevenueAnalytics {
	this := &TopHitsResponseWithRevenueAnalytics{}
	this.Hits = hits
	return this
}

// NewEmptyTopHitsResponseWithRevenueAnalytics return a pointer to an empty TopHitsResponseWithRevenueAnalytics object.
func NewEmptyTopHitsResponseWithRevenueAnalytics() *TopHitsResponseWithRevenueAnalytics {
	return &TopHitsResponseWithRevenueAnalytics{}
}

// GetHits returns the Hits field value.
func (o *TopHitsResponseWithRevenueAnalytics) GetHits() []TopHitWithRevenueAnalytics {
	if o == nil {
		var ret []TopHitWithRevenueAnalytics
		return ret
	}

	return o.Hits
}

// GetHitsOk returns a tuple with the Hits field value
// and a boolean to check if the value has been set.
func (o *TopHitsResponseWithRevenueAnalytics) GetHitsOk() ([]TopHitWithRevenueAnalytics, bool) {
	if o == nil {
		return nil, false
	}
	return o.Hits, true
}

// SetHits sets field value.
func (o *TopHitsResponseWithRevenueAnalytics) SetHits(v []TopHitWithRevenueAnalytics) *TopHitsResponseWithRevenueAnalytics {
	o.Hits = v
	return o
}

func (o TopHitsResponseWithRevenueAnalytics) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["hits"] = o.Hits
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal TopHitsResponseWithRevenueAnalytics: %w", err)
	}

	return serialized, nil
}

func (o TopHitsResponseWithRevenueAnalytics) String() string {
	out := ""
	out += fmt.Sprintf("  hits=%v\n", o.Hits)
	return fmt.Sprintf("TopHitsResponseWithRevenueAnalytics {\n%s}", out)
}
