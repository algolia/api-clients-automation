// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// AuthAlgolia struct for AuthAlgolia
type AuthAlgolia struct {
	// Algolia Application ID.
	AppID string `json:"appID" validate:"required"`
	// Algolia API Key, with the correct rights to push to an index and change settings.
	ApiKey string `json:"apiKey" validate:"required"`
}

// NewAuthAlgolia instantiates a new AuthAlgolia object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewAuthAlgolia(appID string, apiKey string) *AuthAlgolia {
	this := &AuthAlgolia{}
	this.AppID = appID
	this.ApiKey = apiKey
	return this
}

// NewAuthAlgoliaWithDefaults instantiates a new AuthAlgolia object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewAuthAlgoliaWithDefaults() *AuthAlgolia {
	this := &AuthAlgolia{}
	return this
}

// GetAppID returns the AppID field value
func (o *AuthAlgolia) GetAppID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.AppID
}

// GetAppIDOk returns a tuple with the AppID field value
// and a boolean to check if the value has been set.
func (o *AuthAlgolia) GetAppIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.AppID, true
}

// SetAppID sets field value
func (o *AuthAlgolia) SetAppID(v string) {
	o.AppID = v
}

// GetApiKey returns the ApiKey field value
func (o *AuthAlgolia) GetApiKey() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ApiKey
}

// GetApiKeyOk returns a tuple with the ApiKey field value
// and a boolean to check if the value has been set.
func (o *AuthAlgolia) GetApiKeyOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ApiKey, true
}

// SetApiKey sets field value
func (o *AuthAlgolia) SetApiKey(v string) {
	o.ApiKey = v
}

func (o AuthAlgolia) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["appID"] = o.AppID
	}
	if true {
		toSerialize["apiKey"] = o.ApiKey
	}
	return json.Marshal(toSerialize)
}

func (o AuthAlgolia) String() string {
	out := ""
	out += fmt.Sprintf("  appID=%v\n", o.AppID)
	out += fmt.Sprintf("  apiKey=%v\n", o.ApiKey)
	return fmt.Sprintf("AuthAlgolia {\n%s}", out)
}

type NullableAuthAlgolia struct {
	value *AuthAlgolia
	isSet bool
}

func (v NullableAuthAlgolia) Get() *AuthAlgolia {
	return v.value
}

func (v *NullableAuthAlgolia) Set(val *AuthAlgolia) {
	v.value = val
	v.isSet = true
}

func (v NullableAuthAlgolia) IsSet() bool {
	return v.isSet
}

func (v *NullableAuthAlgolia) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableAuthAlgolia(val *AuthAlgolia) *NullableAuthAlgolia {
	return &NullableAuthAlgolia{value: val, isSet: true}
}

func (v NullableAuthAlgolia) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableAuthAlgolia) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
