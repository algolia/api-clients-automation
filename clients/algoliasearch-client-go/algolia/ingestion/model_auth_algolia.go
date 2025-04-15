// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// AuthAlgolia Credentials for authenticating with Algolia.
type AuthAlgolia struct {
	// Algolia application ID.
	AppID string `json:"appID"`
	// Algolia API key with the ACL: `addObject`, `deleteObject`, `settings`, `editSettings`, `listIndexes`, `deleteIndex`. This field is `null` in the API response.
	ApiKey string `json:"apiKey"`
}

// NewAuthAlgolia instantiates a new AuthAlgolia object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewAuthAlgolia(appID string, apiKey string) *AuthAlgolia {
	this := &AuthAlgolia{}
	this.AppID = appID
	this.ApiKey = apiKey
	return this
}

// NewEmptyAuthAlgolia return a pointer to an empty AuthAlgolia object.
func NewEmptyAuthAlgolia() *AuthAlgolia {
	return &AuthAlgolia{}
}

// GetAppID returns the AppID field value.
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

// SetAppID sets field value.
func (o *AuthAlgolia) SetAppID(v string) *AuthAlgolia {
	o.AppID = v
	return o
}

// GetApiKey returns the ApiKey field value.
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

// SetApiKey sets field value.
func (o *AuthAlgolia) SetApiKey(v string) *AuthAlgolia {
	o.ApiKey = v
	return o
}

func (o AuthAlgolia) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["appID"] = o.AppID
	toSerialize["apiKey"] = o.ApiKey
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal AuthAlgolia: %w", err)
	}

	return serialized, nil
}

func (o AuthAlgolia) String() string {
	out := ""
	out += fmt.Sprintf("  appID=%v\n", o.AppID)
	out += fmt.Sprintf("  apiKey=%v\n", o.ApiKey)
	return fmt.Sprintf("AuthAlgolia {\n%s}", out)
}
