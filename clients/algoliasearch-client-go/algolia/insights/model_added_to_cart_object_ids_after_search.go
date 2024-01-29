// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package insights

import (
	"encoding/json"
	"fmt"
)

// AddedToCartObjectIDsAfterSearch Use this event to track when users add items to their shopping cart after a previous Algolia request. If you're building your category pages with Algolia, you'll also use this event.
type AddedToCartObjectIDsAfterSearch struct {
	// The name of the event, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
	EventName    string          `json:"eventName"`
	EventType    ConversionEvent `json:"eventType"`
	EventSubtype AddToCartEvent  `json:"eventSubtype"`
	// The name of an Algolia index.
	Index string `json:"index"`
	// Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.
	QueryID string `json:"queryID"`
	// The object IDs of the records that are part of the event.
	ObjectIDs []string `json:"objectIDs"`
	// An anonymous or pseudonymous user identifier.  > **Note**: Never include personally identifiable information in user tokens.
	UserToken string `json:"userToken"`
	// An identifier for authenticated users.  > **Note**: Never include personally identifiable information in user tokens.
	AuthenticatedUserToken *string `json:"authenticatedUserToken,omitempty"`
	// Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html).
	Currency *string `json:"currency,omitempty"`
	// Extra information about the records involved in a purchase or add-to-cart events.  If provided, it must be the same length as `objectIDs`.
	ObjectData []ObjectDataAfterSearch `json:"objectData,omitempty"`
	// The timestamp of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp.
	Timestamp *int64 `json:"timestamp,omitempty"`
	Value     *Value `json:"value,omitempty"`
}

type AddedToCartObjectIDsAfterSearchOption func(f *AddedToCartObjectIDsAfterSearch)

func WithAddedToCartObjectIDsAfterSearchAuthenticatedUserToken(val string) AddedToCartObjectIDsAfterSearchOption {
	return func(f *AddedToCartObjectIDsAfterSearch) {
		f.AuthenticatedUserToken = &val
	}
}

func WithAddedToCartObjectIDsAfterSearchCurrency(val string) AddedToCartObjectIDsAfterSearchOption {
	return func(f *AddedToCartObjectIDsAfterSearch) {
		f.Currency = &val
	}
}

func WithAddedToCartObjectIDsAfterSearchObjectData(val []ObjectDataAfterSearch) AddedToCartObjectIDsAfterSearchOption {
	return func(f *AddedToCartObjectIDsAfterSearch) {
		f.ObjectData = val
	}
}

func WithAddedToCartObjectIDsAfterSearchTimestamp(val int64) AddedToCartObjectIDsAfterSearchOption {
	return func(f *AddedToCartObjectIDsAfterSearch) {
		f.Timestamp = &val
	}
}

func WithAddedToCartObjectIDsAfterSearchValue(val Value) AddedToCartObjectIDsAfterSearchOption {
	return func(f *AddedToCartObjectIDsAfterSearch) {
		f.Value = &val
	}
}

// NewAddedToCartObjectIDsAfterSearch instantiates a new AddedToCartObjectIDsAfterSearch object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewAddedToCartObjectIDsAfterSearch(eventName string, eventType ConversionEvent, eventSubtype AddToCartEvent, index string, queryID string, objectIDs []string, userToken string, opts ...AddedToCartObjectIDsAfterSearchOption) *AddedToCartObjectIDsAfterSearch {
	this := &AddedToCartObjectIDsAfterSearch{}
	this.EventName = eventName
	this.EventType = eventType
	this.EventSubtype = eventSubtype
	this.Index = index
	this.QueryID = queryID
	this.ObjectIDs = objectIDs
	this.UserToken = userToken
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyAddedToCartObjectIDsAfterSearch return a pointer to an empty AddedToCartObjectIDsAfterSearch object.
func NewEmptyAddedToCartObjectIDsAfterSearch() *AddedToCartObjectIDsAfterSearch {
	return &AddedToCartObjectIDsAfterSearch{}
}

// GetEventName returns the EventName field value.
func (o *AddedToCartObjectIDsAfterSearch) GetEventName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.EventName
}

// GetEventNameOk returns a tuple with the EventName field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetEventNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventName, true
}

// SetEventName sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetEventName(v string) *AddedToCartObjectIDsAfterSearch {
	o.EventName = v
	return o
}

// GetEventType returns the EventType field value.
func (o *AddedToCartObjectIDsAfterSearch) GetEventType() ConversionEvent {
	if o == nil {
		var ret ConversionEvent
		return ret
	}

	return o.EventType
}

// GetEventTypeOk returns a tuple with the EventType field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetEventTypeOk() (*ConversionEvent, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventType, true
}

// SetEventType sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetEventType(v ConversionEvent) *AddedToCartObjectIDsAfterSearch {
	o.EventType = v
	return o
}

// GetEventSubtype returns the EventSubtype field value.
func (o *AddedToCartObjectIDsAfterSearch) GetEventSubtype() AddToCartEvent {
	if o == nil {
		var ret AddToCartEvent
		return ret
	}

	return o.EventSubtype
}

// GetEventSubtypeOk returns a tuple with the EventSubtype field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetEventSubtypeOk() (*AddToCartEvent, bool) {
	if o == nil {
		return nil, false
	}
	return &o.EventSubtype, true
}

// SetEventSubtype sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetEventSubtype(v AddToCartEvent) *AddedToCartObjectIDsAfterSearch {
	o.EventSubtype = v
	return o
}

// GetIndex returns the Index field value.
func (o *AddedToCartObjectIDsAfterSearch) GetIndex() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Index
}

// GetIndexOk returns a tuple with the Index field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetIndexOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Index, true
}

// SetIndex sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetIndex(v string) *AddedToCartObjectIDsAfterSearch {
	o.Index = v
	return o
}

// GetQueryID returns the QueryID field value.
func (o *AddedToCartObjectIDsAfterSearch) GetQueryID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.QueryID
}

// GetQueryIDOk returns a tuple with the QueryID field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetQueryIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.QueryID, true
}

// SetQueryID sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetQueryID(v string) *AddedToCartObjectIDsAfterSearch {
	o.QueryID = v
	return o
}

// GetObjectIDs returns the ObjectIDs field value.
func (o *AddedToCartObjectIDsAfterSearch) GetObjectIDs() []string {
	if o == nil {
		var ret []string
		return ret
	}

	return o.ObjectIDs
}

// GetObjectIDsOk returns a tuple with the ObjectIDs field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetObjectIDsOk() ([]string, bool) {
	if o == nil {
		return nil, false
	}
	return o.ObjectIDs, true
}

// SetObjectIDs sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetObjectIDs(v []string) *AddedToCartObjectIDsAfterSearch {
	o.ObjectIDs = v
	return o
}

// GetUserToken returns the UserToken field value.
func (o *AddedToCartObjectIDsAfterSearch) GetUserToken() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetUserTokenOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserToken, true
}

// SetUserToken sets field value.
func (o *AddedToCartObjectIDsAfterSearch) SetUserToken(v string) *AddedToCartObjectIDsAfterSearch {
	o.UserToken = v
	return o
}

// GetAuthenticatedUserToken returns the AuthenticatedUserToken field value if set, zero value otherwise.
func (o *AddedToCartObjectIDsAfterSearch) GetAuthenticatedUserToken() string {
	if o == nil || o.AuthenticatedUserToken == nil {
		var ret string
		return ret
	}
	return *o.AuthenticatedUserToken
}

// GetAuthenticatedUserTokenOk returns a tuple with the AuthenticatedUserToken field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetAuthenticatedUserTokenOk() (*string, bool) {
	if o == nil || o.AuthenticatedUserToken == nil {
		return nil, false
	}
	return o.AuthenticatedUserToken, true
}

// HasAuthenticatedUserToken returns a boolean if a field has been set.
func (o *AddedToCartObjectIDsAfterSearch) HasAuthenticatedUserToken() bool {
	if o != nil && o.AuthenticatedUserToken != nil {
		return true
	}

	return false
}

// SetAuthenticatedUserToken gets a reference to the given string and assigns it to the AuthenticatedUserToken field.
func (o *AddedToCartObjectIDsAfterSearch) SetAuthenticatedUserToken(v string) *AddedToCartObjectIDsAfterSearch {
	o.AuthenticatedUserToken = &v
	return o
}

// GetCurrency returns the Currency field value if set, zero value otherwise.
func (o *AddedToCartObjectIDsAfterSearch) GetCurrency() string {
	if o == nil || o.Currency == nil {
		var ret string
		return ret
	}
	return *o.Currency
}

// GetCurrencyOk returns a tuple with the Currency field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetCurrencyOk() (*string, bool) {
	if o == nil || o.Currency == nil {
		return nil, false
	}
	return o.Currency, true
}

// HasCurrency returns a boolean if a field has been set.
func (o *AddedToCartObjectIDsAfterSearch) HasCurrency() bool {
	if o != nil && o.Currency != nil {
		return true
	}

	return false
}

// SetCurrency gets a reference to the given string and assigns it to the Currency field.
func (o *AddedToCartObjectIDsAfterSearch) SetCurrency(v string) *AddedToCartObjectIDsAfterSearch {
	o.Currency = &v
	return o
}

// GetObjectData returns the ObjectData field value if set, zero value otherwise.
func (o *AddedToCartObjectIDsAfterSearch) GetObjectData() []ObjectDataAfterSearch {
	if o == nil || o.ObjectData == nil {
		var ret []ObjectDataAfterSearch
		return ret
	}
	return o.ObjectData
}

// GetObjectDataOk returns a tuple with the ObjectData field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetObjectDataOk() ([]ObjectDataAfterSearch, bool) {
	if o == nil || o.ObjectData == nil {
		return nil, false
	}
	return o.ObjectData, true
}

// HasObjectData returns a boolean if a field has been set.
func (o *AddedToCartObjectIDsAfterSearch) HasObjectData() bool {
	if o != nil && o.ObjectData != nil {
		return true
	}

	return false
}

// SetObjectData gets a reference to the given []ObjectDataAfterSearch and assigns it to the ObjectData field.
func (o *AddedToCartObjectIDsAfterSearch) SetObjectData(v []ObjectDataAfterSearch) *AddedToCartObjectIDsAfterSearch {
	o.ObjectData = v
	return o
}

// GetTimestamp returns the Timestamp field value if set, zero value otherwise.
func (o *AddedToCartObjectIDsAfterSearch) GetTimestamp() int64 {
	if o == nil || o.Timestamp == nil {
		var ret int64
		return ret
	}
	return *o.Timestamp
}

// GetTimestampOk returns a tuple with the Timestamp field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetTimestampOk() (*int64, bool) {
	if o == nil || o.Timestamp == nil {
		return nil, false
	}
	return o.Timestamp, true
}

// HasTimestamp returns a boolean if a field has been set.
func (o *AddedToCartObjectIDsAfterSearch) HasTimestamp() bool {
	if o != nil && o.Timestamp != nil {
		return true
	}

	return false
}

// SetTimestamp gets a reference to the given int64 and assigns it to the Timestamp field.
func (o *AddedToCartObjectIDsAfterSearch) SetTimestamp(v int64) *AddedToCartObjectIDsAfterSearch {
	o.Timestamp = &v
	return o
}

// GetValue returns the Value field value if set, zero value otherwise.
func (o *AddedToCartObjectIDsAfterSearch) GetValue() Value {
	if o == nil || o.Value == nil {
		var ret Value
		return ret
	}
	return *o.Value
}

// GetValueOk returns a tuple with the Value field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AddedToCartObjectIDsAfterSearch) GetValueOk() (*Value, bool) {
	if o == nil || o.Value == nil {
		return nil, false
	}
	return o.Value, true
}

// HasValue returns a boolean if a field has been set.
func (o *AddedToCartObjectIDsAfterSearch) HasValue() bool {
	if o != nil && o.Value != nil {
		return true
	}

	return false
}

// SetValue gets a reference to the given Value and assigns it to the Value field.
func (o *AddedToCartObjectIDsAfterSearch) SetValue(v *Value) *AddedToCartObjectIDsAfterSearch {
	o.Value = v
	return o
}

func (o AddedToCartObjectIDsAfterSearch) MarshalJSON() ([]byte, error) {
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
		toSerialize["queryID"] = o.QueryID
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
		return nil, fmt.Errorf("failed to marshal AddedToCartObjectIDsAfterSearch: %w", err)
	}

	return serialized, nil
}

func (o AddedToCartObjectIDsAfterSearch) String() string {
	out := ""
	out += fmt.Sprintf("  eventName=%v\n", o.EventName)
	out += fmt.Sprintf("  eventType=%v\n", o.EventType)
	out += fmt.Sprintf("  eventSubtype=%v\n", o.EventSubtype)
	out += fmt.Sprintf("  index=%v\n", o.Index)
	out += fmt.Sprintf("  queryID=%v\n", o.QueryID)
	out += fmt.Sprintf("  objectIDs=%v\n", o.ObjectIDs)
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	out += fmt.Sprintf("  authenticatedUserToken=%v\n", o.AuthenticatedUserToken)
	out += fmt.Sprintf("  currency=%v\n", o.Currency)
	out += fmt.Sprintf("  objectData=%v\n", o.ObjectData)
	out += fmt.Sprintf("  timestamp=%v\n", o.Timestamp)
	out += fmt.Sprintf("  value=%v\n", o.Value)
	return fmt.Sprintf("AddedToCartObjectIDsAfterSearch {\n%s}", out)
}

type NullableAddedToCartObjectIDsAfterSearch struct {
	value *AddedToCartObjectIDsAfterSearch
	isSet bool
}

func (v NullableAddedToCartObjectIDsAfterSearch) Get() *AddedToCartObjectIDsAfterSearch {
	return v.value
}

func (v *NullableAddedToCartObjectIDsAfterSearch) Set(val *AddedToCartObjectIDsAfterSearch) {
	v.value = val
	v.isSet = true
}

func (v NullableAddedToCartObjectIDsAfterSearch) IsSet() bool {
	return v.isSet
}

func (v *NullableAddedToCartObjectIDsAfterSearch) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAddedToCartObjectIDsAfterSearch(val *AddedToCartObjectIDsAfterSearch) *NullableAddedToCartObjectIDsAfterSearch {
	return &NullableAddedToCartObjectIDsAfterSearch{value: val, isSet: true}
}

func (v NullableAddedToCartObjectIDsAfterSearch) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableAddedToCartObjectIDsAfterSearch) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
