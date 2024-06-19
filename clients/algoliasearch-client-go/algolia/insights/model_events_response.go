// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"encoding/json"
	"fmt"
)

// EventsResponse The response of the Insights API.
type EventsResponse struct {
	// Details about the response, such as error messages.
	Message *string `json:"message,omitempty"`
	// The HTTP status code of the response.
	Status *int32 `json:"status,omitempty"`
}

type EventsResponseOption func(f *EventsResponse)

func WithEventsResponseMessage(val string) EventsResponseOption {
	return func(f *EventsResponse) {
		f.Message = &val
	}
}

func WithEventsResponseStatus(val int32) EventsResponseOption {
	return func(f *EventsResponse) {
		f.Status = &val
	}
}

// NewEventsResponse instantiates a new EventsResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewEventsResponse(opts ...EventsResponseOption) *EventsResponse {
	this := &EventsResponse{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyEventsResponse return a pointer to an empty EventsResponse object.
func NewEmptyEventsResponse() *EventsResponse {
	return &EventsResponse{}
}

// GetMessage returns the Message field value if set, zero value otherwise.
func (o *EventsResponse) GetMessage() string {
	if o == nil || o.Message == nil {
		var ret string
		return ret
	}
	return *o.Message
}

// GetMessageOk returns a tuple with the Message field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventsResponse) GetMessageOk() (*string, bool) {
	if o == nil || o.Message == nil {
		return nil, false
	}
	return o.Message, true
}

// HasMessage returns a boolean if a field has been set.
func (o *EventsResponse) HasMessage() bool {
	if o != nil && o.Message != nil {
		return true
	}

	return false
}

// SetMessage gets a reference to the given string and assigns it to the Message field.
func (o *EventsResponse) SetMessage(v string) *EventsResponse {
	o.Message = &v
	return o
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *EventsResponse) GetStatus() int32 {
	if o == nil || o.Status == nil {
		var ret int32
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *EventsResponse) GetStatusOk() (*int32, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *EventsResponse) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given int32 and assigns it to the Status field.
func (o *EventsResponse) SetStatus(v int32) *EventsResponse {
	o.Status = &v
	return o
}

func (o EventsResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Message != nil {
		toSerialize["message"] = o.Message
	}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal EventsResponse: %w", err)
	}

	return serialized, nil
}

func (o EventsResponse) String() string {
	out := ""
	out += fmt.Sprintf("  message=%v\n", o.Message)
	out += fmt.Sprintf("  status=%v\n", o.Status)
	return fmt.Sprintf("EventsResponse {\n%s}", out)
}
