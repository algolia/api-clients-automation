// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package abtesting

import (
	"encoding/json"
	"fmt"
)

// ListABTestsResponse struct for ListABTestsResponse.
type ListABTestsResponse struct {
	// The list of A/B tests, null if no A/B tests are configured for this application.
	Abtests []ABTest `json:"abtests"`
	// Number of A/B tests.
	Count int32 `json:"count"`
	// Number of retrievable A/B tests.
	Total int32 `json:"total"`
}

// NewListABTestsResponse instantiates a new ListABTestsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewListABTestsResponse(abtests []ABTest, count int32, total int32) *ListABTestsResponse {
	this := &ListABTestsResponse{}
	this.Abtests = abtests
	this.Count = count
	this.Total = total
	return this
}

// NewEmptyListABTestsResponse return a pointer to an empty ListABTestsResponse object.
func NewEmptyListABTestsResponse() *ListABTestsResponse {
	return &ListABTestsResponse{}
}

// GetAbtests returns the Abtests field value.
// If the value is explicit nil, the zero value for []ABTest will be returned.
func (o *ListABTestsResponse) GetAbtests() []ABTest {
	if o == nil {
		var ret []ABTest
		return ret
	}

	return o.Abtests
}

// GetAbtestsOk returns a tuple with the Abtests field value
// and a boolean to check if the value has been set.
// NOTE: If the value is an explicit nil, `nil, true` will be returned.
func (o *ListABTestsResponse) GetAbtestsOk() ([]ABTest, bool) {
	if o == nil || o.Abtests == nil {
		return nil, false
	}
	return o.Abtests, true
}

// SetAbtests sets field value.
func (o *ListABTestsResponse) SetAbtests(v []ABTest) *ListABTestsResponse {
	o.Abtests = v
	return o
}

// GetCount returns the Count field value.
func (o *ListABTestsResponse) GetCount() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Count
}

// GetCountOk returns a tuple with the Count field value
// and a boolean to check if the value has been set.
func (o *ListABTestsResponse) GetCountOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Count, true
}

// SetCount sets field value.
func (o *ListABTestsResponse) SetCount(v int32) *ListABTestsResponse {
	o.Count = v
	return o
}

// GetTotal returns the Total field value.
func (o *ListABTestsResponse) GetTotal() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Total
}

// GetTotalOk returns a tuple with the Total field value
// and a boolean to check if the value has been set.
func (o *ListABTestsResponse) GetTotalOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Total, true
}

// SetTotal sets field value.
func (o *ListABTestsResponse) SetTotal(v int32) *ListABTestsResponse {
	o.Total = v
	return o
}

func (o ListABTestsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Abtests != nil {
		toSerialize["abtests"] = o.Abtests
	}
	toSerialize["count"] = o.Count
	toSerialize["total"] = o.Total
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ListABTestsResponse: %w", err)
	}

	return serialized, nil
}

func (o ListABTestsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  abtests=%v\n", o.Abtests)
	out += fmt.Sprintf("  count=%v\n", o.Count)
	out += fmt.Sprintf("  total=%v\n", o.Total)
	return fmt.Sprintf("ListABTestsResponse {\n%s}", out)
}
