// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package suggestions

import (
	"encoding/json"
	"fmt"
)

// AppID struct for AppID.
type AppID struct {
	// Algolia application ID to which this Query Suggestions configuration belongs.
	AppID *string `json:"appID,omitempty"`
}

type AppIDOption func(f *AppID)

func WithAppIDAppID(val string) AppIDOption {
	return func(f *AppID) {
		f.AppID = &val
	}
}

// NewAppID instantiates a new AppID object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewAppID(opts ...AppIDOption) *AppID {
	this := &AppID{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyAppID return a pointer to an empty AppID object.
func NewEmptyAppID() *AppID {
	return &AppID{}
}

// GetAppID returns the AppID field value if set, zero value otherwise.
func (o *AppID) GetAppID() string {
	if o == nil || o.AppID == nil {
		var ret string
		return ret
	}
	return *o.AppID
}

// GetAppIDOk returns a tuple with the AppID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *AppID) GetAppIDOk() (*string, bool) {
	if o == nil || o.AppID == nil {
		return nil, false
	}
	return o.AppID, true
}

// HasAppID returns a boolean if a field has been set.
func (o *AppID) HasAppID() bool {
	if o != nil && o.AppID != nil {
		return true
	}

	return false
}

// SetAppID gets a reference to the given string and assigns it to the AppID field.
func (o *AppID) SetAppID(v string) *AppID {
	o.AppID = &v
	return o
}

func (o AppID) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.AppID != nil {
		toSerialize["appID"] = o.AppID
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal AppID: %w", err)
	}

	return serialized, nil
}

func (o AppID) String() string {
	out := ""
	out += fmt.Sprintf("  appID=%v\n", o.AppID)
	return fmt.Sprintf("AppID {\n%s}", out)
}

type NullableAppID struct {
	value *AppID
	isSet bool
}

func (v NullableAppID) Get() *AppID {
	return v.value
}

func (v *NullableAppID) Set(val *AppID) {
	v.value = val
	v.isSet = true
}

func (v NullableAppID) IsSet() bool {
	return v.isSet
}

func (v *NullableAppID) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAppID(val *AppID) *NullableAppID {
	return &NullableAppID{value: val, isSet: true}
}

func (v NullableAppID) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableAppID) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
