// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// ListEventsResponse struct for ListEventsResponse
type ListEventsResponse struct {
	Events     []Event    `json:"events"`
	Pagination Pagination `json:"pagination"`
}

// NewListEventsResponse instantiates a new ListEventsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewListEventsResponse(events []Event, pagination Pagination) *ListEventsResponse {
	this := &ListEventsResponse{}
	this.Events = events
	this.Pagination = pagination
	return this
}

// NewListEventsResponseWithDefaults instantiates a new ListEventsResponse object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewListEventsResponseWithDefaults() *ListEventsResponse {
	this := &ListEventsResponse{}
	return this
}

// GetEvents returns the Events field value
func (o *ListEventsResponse) GetEvents() []Event {
	if o == nil {
		var ret []Event
		return ret
	}

	return o.Events
}

// GetEventsOk returns a tuple with the Events field value
// and a boolean to check if the value has been set.
func (o *ListEventsResponse) GetEventsOk() ([]Event, bool) {
	if o == nil {
		return nil, false
	}
	return o.Events, true
}

// SetEvents sets field value
func (o *ListEventsResponse) SetEvents(v []Event) {
	o.Events = v
}

// GetPagination returns the Pagination field value
func (o *ListEventsResponse) GetPagination() Pagination {
	if o == nil {
		var ret Pagination
		return ret
	}

	return o.Pagination
}

// GetPaginationOk returns a tuple with the Pagination field value
// and a boolean to check if the value has been set.
func (o *ListEventsResponse) GetPaginationOk() (*Pagination, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Pagination, true
}

// SetPagination sets field value
func (o *ListEventsResponse) SetPagination(v Pagination) {
	o.Pagination = v
}

func (o ListEventsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["events"] = o.Events
	}
	if true {
		toSerialize["pagination"] = o.Pagination
	}
	return json.Marshal(toSerialize)
}

func (o ListEventsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  events=%v\n", o.Events)
	out += fmt.Sprintf("  pagination=%v\n", o.Pagination)
	return fmt.Sprintf("ListEventsResponse {\n%s}", out)
}

type NullableListEventsResponse struct {
	value *ListEventsResponse
	isSet bool
}

func (v NullableListEventsResponse) Get() *ListEventsResponse {
	return v.value
}

func (v *NullableListEventsResponse) Set(val *ListEventsResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableListEventsResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableListEventsResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableListEventsResponse(val *ListEventsResponse) *NullableListEventsResponse {
	return &NullableListEventsResponse{value: val, isSet: true}
}

func (v NullableListEventsResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableListEventsResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
