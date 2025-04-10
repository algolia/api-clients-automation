// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"encoding/json"
	"fmt"
)

// ViewedObjectIDs Use this event to track when users viewed items in the search results.
type ViewedObjectIDs struct {
	// Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
	EventName string    `json:"eventName"`
	EventType ViewEvent `json:"eventType"`
	// Index name (case-sensitive) to which the event's items belong.
	Index string `json:"index"`
	// Object IDs of the records that are part of the event.
	ObjectIDs []string `json:"objectIDs"`
	// Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
	UserToken string `json:"userToken"`
	// Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
	AuthenticatedUserToken *string `json:"authenticatedUserToken,omitempty"`
	// Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp.
	Timestamp *int64 `json:"timestamp,omitempty"`
}

type ViewedObjectIDsOption func(f *ViewedObjectIDs)

func WithViewedObjectIDsAuthenticatedUserToken(val string) ViewedObjectIDsOption {
	return func(f *ViewedObjectIDs) {
		f.AuthenticatedUserToken = &val
	}
}

func WithViewedObjectIDsTimestamp(val int64) ViewedObjectIDsOption {
	return func(f *ViewedObjectIDs) {
		f.Timestamp = &val
	}
}

// NewViewedObjectIDs instantiates a new ViewedObjectIDs object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewViewedObjectIDs(eventName string, eventType ViewEvent, index string, objectIDs []string, userToken string, opts ...ViewedObjectIDsOption) *ViewedObjectIDs {
	this := &ViewedObjectIDs{}
	this.EventName = eventName
	this.EventType = eventType
	this.Index = index
	this.ObjectIDs = objectIDs
	this.UserToken = userToken
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyViewedObjectIDs return a pointer to an empty ViewedObjectIDs object.
func NewEmptyViewedObjectIDs() *ViewedObjectIDs {
	return &ViewedObjectIDs{}
}

// GetEventName returns the EventName field value.
func (o *ViewedObjectIDs) GetEventName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.EventName
}

// GetEventNameOk returns a tuple with the EventName field value
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetEventNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventName, true
}

// SetEventName sets field value.
func (o *ViewedObjectIDs) SetEventName(v string) *ViewedObjectIDs {
	o.EventName = v
	return o
}

// GetEventType returns the EventType field value.
func (o *ViewedObjectIDs) GetEventType() ViewEvent {
	if o == nil {
		var ret ViewEvent
		return ret
	}

	return o.EventType
}

// GetEventTypeOk returns a tuple with the EventType field value
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetEventTypeOk() (*ViewEvent, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventType, true
}

// SetEventType sets field value.
func (o *ViewedObjectIDs) SetEventType(v ViewEvent) *ViewedObjectIDs {
	o.EventType = v
	return o
}

// GetIndex returns the Index field value.
func (o *ViewedObjectIDs) GetIndex() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Index
}

// GetIndexOk returns a tuple with the Index field value
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetIndexOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Index, true
}

// SetIndex sets field value.
func (o *ViewedObjectIDs) SetIndex(v string) *ViewedObjectIDs {
	o.Index = v
	return o
}

// GetObjectIDs returns the ObjectIDs field value.
func (o *ViewedObjectIDs) GetObjectIDs() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.ObjectIDs
}

// GetObjectIDsOk returns a tuple with the ObjectIDs field value
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetObjectIDsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.ObjectIDs, true
}

// SetObjectIDs sets field value.
func (o *ViewedObjectIDs) SetObjectIDs(v []string) *ViewedObjectIDs {
	o.ObjectIDs = v
	return o
}

// GetUserToken returns the UserToken field value.
func (o *ViewedObjectIDs) GetUserToken() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetUserTokenOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserToken, true
}

// SetUserToken sets field value.
func (o *ViewedObjectIDs) SetUserToken(v string) *ViewedObjectIDs {
	o.UserToken = v
	return o
}

// GetAuthenticatedUserToken returns the AuthenticatedUserToken field value if set, zero value otherwise.
func (o *ViewedObjectIDs) GetAuthenticatedUserToken() string {
	if o == nil || o.AuthenticatedUserToken == nil {
		var ret string
		return ret
	}
	return *o.AuthenticatedUserToken
}

// GetAuthenticatedUserTokenOk returns a tuple with the AuthenticatedUserToken field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetAuthenticatedUserTokenOk() (*string, bool) {
	if o == nil || o.AuthenticatedUserToken == nil {
		return nil, false
	}
	return o.AuthenticatedUserToken, true
}

// HasAuthenticatedUserToken returns a boolean if a field has been set.
func (o *ViewedObjectIDs) HasAuthenticatedUserToken() bool {
	if o != nil && o.AuthenticatedUserToken != nil {
		return true
	}

	return false
}

// SetAuthenticatedUserToken gets a reference to the given string and assigns it to the AuthenticatedUserToken field.
func (o *ViewedObjectIDs) SetAuthenticatedUserToken(v string) *ViewedObjectIDs {
	o.AuthenticatedUserToken = &v
	return o
}

// GetTimestamp returns the Timestamp field value if set, zero value otherwise.
func (o *ViewedObjectIDs) GetTimestamp() int64 {
	if o == nil || o.Timestamp == nil {
		var ret int64
		return ret
	}
	return *o.Timestamp
}

// GetTimestampOk returns a tuple with the Timestamp field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ViewedObjectIDs) GetTimestampOk() (*int64, bool) {
	if o == nil || o.Timestamp == nil {
		return nil, false
	}
	return o.Timestamp, true
}

// HasTimestamp returns a boolean if a field has been set.
func (o *ViewedObjectIDs) HasTimestamp() bool {
	if o != nil && o.Timestamp != nil {
		return true
	}

	return false
}

// SetTimestamp gets a reference to the given int64 and assigns it to the Timestamp field.
func (o *ViewedObjectIDs) SetTimestamp(v int64) *ViewedObjectIDs {
	o.Timestamp = &v
	return o
}

func (o ViewedObjectIDs) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["eventName"] = o.EventName
	toSerialize["eventType"] = o.EventType
	toSerialize["index"] = o.Index
	toSerialize["objectIDs"] = o.ObjectIDs
	toSerialize["userToken"] = o.UserToken
	if o.AuthenticatedUserToken != nil {
		toSerialize["authenticatedUserToken"] = o.AuthenticatedUserToken
	}
	if o.Timestamp != nil {
		toSerialize["timestamp"] = o.Timestamp
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ViewedObjectIDs: %w", err)
	}

	return serialized, nil
}

func (o ViewedObjectIDs) String() string {
	out := ""
	out += fmt.Sprintf("  eventName=%v\n", o.EventName)
	out += fmt.Sprintf("  eventType=%v\n", o.EventType)
	out += fmt.Sprintf("  index=%v\n", o.Index)
	out += fmt.Sprintf("  objectIDs=%v\n", o.ObjectIDs)
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	out += fmt.Sprintf("  authenticatedUserToken=%v\n", o.AuthenticatedUserToken)
	out += fmt.Sprintf("  timestamp=%v\n", o.Timestamp)
	return fmt.Sprintf("ViewedObjectIDs {\n%s}", out)
}
