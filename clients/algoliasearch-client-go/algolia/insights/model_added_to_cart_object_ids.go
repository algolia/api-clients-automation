// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package insights

import (
	"encoding/json"
	"fmt"
)

// AddedToCartObjectIDs Use this event to track when users add items to their shopping cart unrelated to a previous Algolia request. For example, if you don't use Algolia to build your category pages, use this event.  To track add-to-cart events related to Algolia requests, use the \"Added to cart object IDs after search\" event.
type AddedToCartObjectIDs struct {
	// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
	EventName    string          `json:"eventName"`
	EventType    ConversionEvent `json:"eventType"`
	EventSubtype AddToCartEvent  `json:"eventSubtype"`
	// The name of an Algolia index.
	Index string `json:"index"`
	// The object IDs of the records that are part of the event.
	ObjectIDs []string `json:"objectIDs"`
	// An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.
	UserToken string `json:"userToken"`
	// An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.
	AuthenticatedUserToken *string `json:"authenticatedUserToken,omitempty"`
	// Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
	Currency *string `json:"currency,omitempty"`
	// Extra information about the records involved in a purchase or add-to-cart event.  If specified, it must have the same length as `objectIDs`.
	ObjectData []ObjectData `json:"objectData,omitempty"`
	// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
	Timestamp *int64 `json:"timestamp,omitempty"`
	Value     *Value `json:"value,omitempty"`
}

type AddedToCartObjectIDsOption func(f *AddedToCartObjectIDs)

func WithAddedToCartObjectIDsAuthenticatedUserToken(val string) AddedToCartObjectIDsOption {
	return func(f *AddedToCartObjectIDs) {
		f.AuthenticatedUserToken = &val
	}
}

func WithAddedToCartObjectIDsCurrency(val string) AddedToCartObjectIDsOption {
	return func(f *AddedToCartObjectIDs) {
		f.Currency = &val
	}
}

func WithAddedToCartObjectIDsObjectData(val []ObjectData) AddedToCartObjectIDsOption {
	return func(f *AddedToCartObjectIDs) {
		f.ObjectData = val
	}
}

func WithAddedToCartObjectIDsTimestamp(val int64) AddedToCartObjectIDsOption {
	return func(f *AddedToCartObjectIDs) {
		f.Timestamp = &val
	}
}

func WithAddedToCartObjectIDsValue(val Value) AddedToCartObjectIDsOption {
	return func(f *AddedToCartObjectIDs) {
		f.Value = &val
	}
}

// NewAddedToCartObjectIDs instantiates a new AddedToCartObjectIDs object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewAddedToCartObjectIDs(eventName string, eventType ConversionEvent, eventSubtype AddToCartEvent, index string, objectIDs []string, userToken string, opts ...AddedToCartObjectIDsOption) *AddedToCartObjectIDs {
	this := &AddedToCartObjectIDs{}
	this.EventName = eventName
	this.EventType = eventType
	this.EventSubtype = eventSubtype
	this.Index = index
	this.ObjectIDs = objectIDs
	this.UserToken = userToken
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyAddedToCartObjectIDs return a pointer to an empty AddedToCartObjectIDs object.
func NewEmptyAddedToCartObjectIDs() *AddedToCartObjectIDs {
	return &AddedToCartObjectIDs{}
}

// GetEventName returns the EventName field value.
func (o *AddedToCartObjectIDs) GetEventName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.EventName
}

// GetEventNameOk returns a tuple with the EventName field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetEventNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventName, true
}

// SetEventName sets field value.
func (o *AddedToCartObjectIDs) SetEventName(v string) *AddedToCartObjectIDs {
	o.EventName = v
	return o
}

// GetEventType returns the EventType field value.
func (o *AddedToCartObjectIDs) GetEventType() ConversionEvent {
	if o == nil {
		var ret ConversionEvent
		return ret
	}

	return o.EventType
}

// GetEventTypeOk returns a tuple with the EventType field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetEventTypeOk() (*ConversionEvent, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventType, true
}

// SetEventType sets field value.
func (o *AddedToCartObjectIDs) SetEventType(v ConversionEvent) *AddedToCartObjectIDs {
	o.EventType = v
	return o
}

// GetEventSubtype returns the EventSubtype field value.
func (o *AddedToCartObjectIDs) GetEventSubtype() AddToCartEvent {
	if o == nil {
		var ret AddToCartEvent
		return ret
	}

	return o.EventSubtype
}

// GetEventSubtypeOk returns a tuple with the EventSubtype field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetEventSubtypeOk() (*AddToCartEvent, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventSubtype, true
}

// SetEventSubtype sets field value.
func (o *AddedToCartObjectIDs) SetEventSubtype(v AddToCartEvent) *AddedToCartObjectIDs {
	o.EventSubtype = v
	return o
}

// GetIndex returns the Index field value.
func (o *AddedToCartObjectIDs) GetIndex() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Index
}

// GetIndexOk returns a tuple with the Index field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetIndexOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Index, true
}

// SetIndex sets field value.
func (o *AddedToCartObjectIDs) SetIndex(v string) *AddedToCartObjectIDs {
	o.Index = v
	return o
}

// GetObjectIDs returns the ObjectIDs field value.
func (o *AddedToCartObjectIDs) GetObjectIDs() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.ObjectIDs
}

// GetObjectIDsOk returns a tuple with the ObjectIDs field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetObjectIDsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.ObjectIDs, true
}

// SetObjectIDs sets field value.
func (o *AddedToCartObjectIDs) SetObjectIDs(v []string) *AddedToCartObjectIDs {
	o.ObjectIDs = v
	return o
}

// GetUserToken returns the UserToken field value.
func (o *AddedToCartObjectIDs) GetUserToken() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetUserTokenOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserToken, true
}

// SetUserToken sets field value.
func (o *AddedToCartObjectIDs) SetUserToken(v string) *AddedToCartObjectIDs {
	o.UserToken = v
	return o
}

// GetAuthenticatedUserToken returns the AuthenticatedUserToken field value if set, zero value otherwise.
func (o *AddedToCartObjectIDs) GetAuthenticatedUserToken() string {
	if o == nil || o.AuthenticatedUserToken == nil {
		var ret string
		return ret
	}
	return *o.AuthenticatedUserToken
}

// GetAuthenticatedUserTokenOk returns a tuple with the AuthenticatedUserToken field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetAuthenticatedUserTokenOk() (*string, bool) {
	if o == nil || o.AuthenticatedUserToken == nil {
		return nil, false
	}
	return o.AuthenticatedUserToken, true
}

// HasAuthenticatedUserToken returns a boolean if a field has been set.
func (o *AddedToCartObjectIDs) HasAuthenticatedUserToken() bool {
	if o != nil && o.AuthenticatedUserToken != nil {
		return true
	}

	return false
}

// SetAuthenticatedUserToken gets a reference to the given string and assigns it to the AuthenticatedUserToken field.
func (o *AddedToCartObjectIDs) SetAuthenticatedUserToken(v string) *AddedToCartObjectIDs {
	o.AuthenticatedUserToken = &v
	return o
}

// GetCurrency returns the Currency field value if set, zero value otherwise.
func (o *AddedToCartObjectIDs) GetCurrency() string {
	if o == nil || o.Currency == nil {
		var ret string
		return ret
	}
	return *o.Currency
}

// GetCurrencyOk returns a tuple with the Currency field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetCurrencyOk() (*string, bool) {
	if o == nil || o.Currency == nil {
		return nil, false
	}
	return o.Currency, true
}

// HasCurrency returns a boolean if a field has been set.
func (o *AddedToCartObjectIDs) HasCurrency() bool {
	if o != nil && o.Currency != nil {
		return true
	}

	return false
}

// SetCurrency gets a reference to the given string and assigns it to the Currency field.
func (o *AddedToCartObjectIDs) SetCurrency(v string) *AddedToCartObjectIDs {
	o.Currency = &v
	return o
}

// GetObjectData returns the ObjectData field value if set, zero value otherwise.
func (o *AddedToCartObjectIDs) GetObjectData() []ObjectData {
	if o == nil || o.ObjectData == nil {
		var ret []ObjectData
		return ret
	}
	return o.ObjectData
}

// GetObjectDataOk returns a tuple with the ObjectData field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetObjectDataOk() ([]ObjectData, bool) {
	if o == nil || o.ObjectData == nil {
		return nil, false
	}
	return o.ObjectData, true
}

// HasObjectData returns a boolean if a field has been set.
func (o *AddedToCartObjectIDs) HasObjectData() bool {
	if o != nil && o.ObjectData != nil {
		return true
	}

	return false
}

// SetObjectData gets a reference to the given []ObjectData and assigns it to the ObjectData field.
func (o *AddedToCartObjectIDs) SetObjectData(v []ObjectData) *AddedToCartObjectIDs {
	o.ObjectData = v
	return o
}

// GetTimestamp returns the Timestamp field value if set, zero value otherwise.
func (o *AddedToCartObjectIDs) GetTimestamp() int64 {
	if o == nil || o.Timestamp == nil {
		var ret int64
		return ret
	}
	return *o.Timestamp
}

// GetTimestampOk returns a tuple with the Timestamp field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetTimestampOk() (*int64, bool) {
	if o == nil || o.Timestamp == nil {
		return nil, false
	}
	return o.Timestamp, true
}

// HasTimestamp returns a boolean if a field has been set.
func (o *AddedToCartObjectIDs) HasTimestamp() bool {
	if o != nil && o.Timestamp != nil {
		return true
	}

	return false
}

// SetTimestamp gets a reference to the given int64 and assigns it to the Timestamp field.
func (o *AddedToCartObjectIDs) SetTimestamp(v int64) *AddedToCartObjectIDs {
	o.Timestamp = &v
	return o
}

// GetValue returns the Value field value if set, zero value otherwise.
func (o *AddedToCartObjectIDs) GetValue() Value {
	if o == nil || o.Value == nil {
		var ret Value
		return ret
	}
	return *o.Value
}

// GetValueOk returns a tuple with the Value field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDs) GetValueOk() (*Value, bool) {
	if o == nil || o.Value == nil {
		return nil, false
	}
	return o.Value, true
}

// HasValue returns a boolean if a field has been set.
func (o *AddedToCartObjectIDs) HasValue() bool {
	if o != nil && o.Value != nil {
		return true
	}

	return false
}

// SetValue gets a reference to the given Value and assigns it to the Value field.
func (o *AddedToCartObjectIDs) SetValue(v *Value) *AddedToCartObjectIDs {
	o.Value = v
	return o
}

func (o AddedToCartObjectIDs) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["eventName"] = o.EventName
	}
	if true {
		toSerialize["eventType"] = o.EventType
	}
	if true {
		toSerialize["eventSubtype"] = o.EventSubtype
	}
	if true {
		toSerialize["index"] = o.Index
	}
	if true {
		toSerialize["objectIDs"] = o.ObjectIDs
	}
	if true {
		toSerialize["userToken"] = o.UserToken
	}
	if o.AuthenticatedUserToken != nil {
		toSerialize["authenticatedUserToken"] = o.AuthenticatedUserToken
	}
	if o.Currency != nil {
		toSerialize["currency"] = o.Currency
	}
	if o.ObjectData != nil {
		toSerialize["objectData"] = o.ObjectData
	}
	if o.Timestamp != nil {
		toSerialize["timestamp"] = o.Timestamp
	}
	if o.Value != nil {
		toSerialize["value"] = o.Value
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal AddedToCartObjectIDs: %w", err)
	}

	return serialized, nil
}

func (o AddedToCartObjectIDs) String() string {
	out := ""
	out += fmt.Sprintf("  eventName=%v\n", o.EventName)
	out += fmt.Sprintf("  eventType=%v\n", o.EventType)
	out += fmt.Sprintf("  eventSubtype=%v\n", o.EventSubtype)
	out += fmt.Sprintf("  index=%v\n", o.Index)
	out += fmt.Sprintf("  objectIDs=%v\n", o.ObjectIDs)
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	out += fmt.Sprintf("  authenticatedUserToken=%v\n", o.AuthenticatedUserToken)
	out += fmt.Sprintf("  currency=%v\n", o.Currency)
	out += fmt.Sprintf("  objectData=%v\n", o.ObjectData)
	out += fmt.Sprintf("  timestamp=%v\n", o.Timestamp)
	out += fmt.Sprintf("  value=%v\n", o.Value)
	return fmt.Sprintf("AddedToCartObjectIDs {\n%s}", out)
}

type NullableAddedToCartObjectIDs struct {
	value *AddedToCartObjectIDs
	isSet bool
}

func (v NullableAddedToCartObjectIDs) Get() *AddedToCartObjectIDs {
	return v.value
}

func (v *NullableAddedToCartObjectIDs) Set(val *AddedToCartObjectIDs) {
	v.value = val
	v.isSet = true
}

func (v NullableAddedToCartObjectIDs) IsSet() bool {
	return v.isSet
}

func (v *NullableAddedToCartObjectIDs) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAddedToCartObjectIDs(val *AddedToCartObjectIDs) *NullableAddedToCartObjectIDs {
	return &NullableAddedToCartObjectIDs{value: val, isSet: true}
}

func (v NullableAddedToCartObjectIDs) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableAddedToCartObjectIDs) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
