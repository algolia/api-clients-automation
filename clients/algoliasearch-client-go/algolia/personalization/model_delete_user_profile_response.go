// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package personalization

import (
	"encoding/json"
	"fmt"
)

// DeleteUserProfileResponse struct for DeleteUserProfileResponse.
type DeleteUserProfileResponse struct {
	// userToken representing the user for which to fetch the Personalization profile.
	UserToken string `json:"userToken"`
	// A date until which the data can safely be considered as deleted for the given user. Any data received after the `deletedUntil` date will start building a new user profile.
	DeletedUntil string `json:"deletedUntil"`
}

// NewDeleteUserProfileResponse instantiates a new DeleteUserProfileResponse object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDeleteUserProfileResponse(userToken string, deletedUntil string) *DeleteUserProfileResponse {
	this := &DeleteUserProfileResponse{}
	this.UserToken = userToken
	this.DeletedUntil = deletedUntil
	return this
}

// NewEmptyDeleteUserProfileResponse return a pointer to an empty DeleteUserProfileResponse object.
func NewEmptyDeleteUserProfileResponse() *DeleteUserProfileResponse {
	return &DeleteUserProfileResponse{}
}

// GetUserToken returns the UserToken field value.
func (o *DeleteUserProfileResponse) GetUserToken() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value
// and a boolean to check if the value has been set.
func (o *DeleteUserProfileResponse) GetUserTokenOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserToken, true
}

// SetUserToken sets field value.
func (o *DeleteUserProfileResponse) SetUserToken(v string) *DeleteUserProfileResponse {
	o.UserToken = v
	return o
}

// GetDeletedUntil returns the DeletedUntil field value.
func (o *DeleteUserProfileResponse) GetDeletedUntil() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.DeletedUntil
}

// GetDeletedUntilOk returns a tuple with the DeletedUntil field value
// and a boolean to check if the value has been set.
func (o *DeleteUserProfileResponse) GetDeletedUntilOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DeletedUntil, true
}

// SetDeletedUntil sets field value.
func (o *DeleteUserProfileResponse) SetDeletedUntil(v string) *DeleteUserProfileResponse {
	o.DeletedUntil = v
	return o
}

func (o DeleteUserProfileResponse) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["userToken"] = o.UserToken
	}
	if true {
		toSerialize["deletedUntil"] = o.DeletedUntil
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DeleteUserProfileResponse: %w", err)
	}

	return serialized, nil
}

func (o DeleteUserProfileResponse) String() string {
	out := ""
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	out += fmt.Sprintf("  deletedUntil=%v\n", o.DeletedUntil)
	return fmt.Sprintf("DeleteUserProfileResponse {\n%s}", out)
}

type NullableDeleteUserProfileResponse struct {
	value *DeleteUserProfileResponse
	isSet bool
}

func (v NullableDeleteUserProfileResponse) Get() *DeleteUserProfileResponse {
	return v.value
}

func (v *NullableDeleteUserProfileResponse) Set(val *DeleteUserProfileResponse) {
	v.value = val
	v.isSet = true
}

func (v NullableDeleteUserProfileResponse) IsSet() bool {
	return v.isSet
}

func (v *NullableDeleteUserProfileResponse) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableDeleteUserProfileResponse(val *DeleteUserProfileResponse) *NullableDeleteUserProfileResponse {
	return &NullableDeleteUserProfileResponse{value: val, isSet: true}
}

func (v NullableDeleteUserProfileResponse) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableDeleteUserProfileResponse) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
