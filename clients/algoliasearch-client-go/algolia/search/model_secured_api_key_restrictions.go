// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// SecuredApiKeyRestrictions struct for SecuredApiKeyRestrictions.
type SecuredApiKeyRestrictions struct {
	SearchParams *SearchParamsObject `json:"searchParams,omitempty"`
	// Filters that apply to every search made with the secured API key. Extra filters added at search time will be combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`.
	Filters *string `json:"filters,omitempty"`
	// Timestamp when the secured API key expires, measured in seconds since the Unix epoch.
	ValidUntil *int64 `json:"validUntil,omitempty"`
	// Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".
	RestrictIndices []string `json:"restrictIndices,omitempty"`
	// IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of IP addresses. Use this to protect against API key leaking and reuse.
	RestrictSources *string `json:"restrictSources,omitempty"`
	// Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this, add a user token to each generated API key.
	UserToken *string `json:"userToken,omitempty"`
}

type SecuredApiKeyRestrictionsOption func(f *SecuredApiKeyRestrictions)

func WithSecuredApiKeyRestrictionsSearchParams(val SearchParamsObject) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.SearchParams = &val
	}
}

func WithSecuredApiKeyRestrictionsFilters(val string) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.Filters = &val
	}
}

func WithSecuredApiKeyRestrictionsValidUntil(val int64) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.ValidUntil = &val
	}
}

func WithSecuredApiKeyRestrictionsRestrictIndices(val []string) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.RestrictIndices = val
	}
}

func WithSecuredApiKeyRestrictionsRestrictSources(val string) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.RestrictSources = &val
	}
}

func WithSecuredApiKeyRestrictionsUserToken(val string) SecuredApiKeyRestrictionsOption {
	return func(f *SecuredApiKeyRestrictions) {
		f.UserToken = &val
	}
}

// NewSecuredApiKeyRestrictions instantiates a new SecuredApiKeyRestrictions object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSecuredApiKeyRestrictions(opts ...SecuredApiKeyRestrictionsOption) *SecuredApiKeyRestrictions {
	this := &SecuredApiKeyRestrictions{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySecuredApiKeyRestrictions return a pointer to an empty SecuredApiKeyRestrictions object.
func NewEmptySecuredApiKeyRestrictions() *SecuredApiKeyRestrictions {
	return &SecuredApiKeyRestrictions{}
}

// GetSearchParams returns the SearchParams field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetSearchParams() SearchParamsObject {
	if o == nil || o.SearchParams == nil {
		var ret SearchParamsObject
		return ret
	}
	return *o.SearchParams
}

// GetSearchParamsOk returns a tuple with the SearchParams field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetSearchParamsOk() (*SearchParamsObject, bool) {
	if o == nil || o.SearchParams == nil {
		return nil, false
	}
	return o.SearchParams, true
}

// HasSearchParams returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasSearchParams() bool {
	if o != nil && o.SearchParams != nil {
		return true
	}

	return false
}

// SetSearchParams gets a reference to the given SearchParamsObject and assigns it to the SearchParams field.
func (o *SecuredApiKeyRestrictions) SetSearchParams(v *SearchParamsObject) *SecuredApiKeyRestrictions {
	o.SearchParams = v
	return o
}

// GetFilters returns the Filters field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetFilters() string {
	if o == nil || o.Filters == nil {
		var ret string
		return ret
	}
	return *o.Filters
}

// GetFiltersOk returns a tuple with the Filters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetFiltersOk() (*string, bool) {
	if o == nil || o.Filters == nil {
		return nil, false
	}
	return o.Filters, true
}

// HasFilters returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasFilters() bool {
	if o != nil && o.Filters != nil {
		return true
	}

	return false
}

// SetFilters gets a reference to the given string and assigns it to the Filters field.
func (o *SecuredApiKeyRestrictions) SetFilters(v string) *SecuredApiKeyRestrictions {
	o.Filters = &v
	return o
}

// GetValidUntil returns the ValidUntil field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetValidUntil() int64 {
	if o == nil || o.ValidUntil == nil {
		var ret int64
		return ret
	}
	return *o.ValidUntil
}

// GetValidUntilOk returns a tuple with the ValidUntil field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetValidUntilOk() (*int64, bool) {
	if o == nil || o.ValidUntil == nil {
		return nil, false
	}
	return o.ValidUntil, true
}

// HasValidUntil returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasValidUntil() bool {
	if o != nil && o.ValidUntil != nil {
		return true
	}

	return false
}

// SetValidUntil gets a reference to the given int64 and assigns it to the ValidUntil field.
func (o *SecuredApiKeyRestrictions) SetValidUntil(v int64) *SecuredApiKeyRestrictions {
	o.ValidUntil = &v
	return o
}

// GetRestrictIndices returns the RestrictIndices field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetRestrictIndices() []string {
	if o == nil || o.RestrictIndices == nil {
		var ret []string
		return ret
	}
	return o.RestrictIndices
}

// GetRestrictIndicesOk returns a tuple with the RestrictIndices field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetRestrictIndicesOk() ([]string, bool) {
	if o == nil || o.RestrictIndices == nil {
		return nil, false
	}
	return o.RestrictIndices, true
}

// HasRestrictIndices returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasRestrictIndices() bool {
	if o != nil && o.RestrictIndices != nil {
		return true
	}

	return false
}

// SetRestrictIndices gets a reference to the given []string and assigns it to the RestrictIndices field.
func (o *SecuredApiKeyRestrictions) SetRestrictIndices(v []string) *SecuredApiKeyRestrictions {
	o.RestrictIndices = v
	return o
}

// GetRestrictSources returns the RestrictSources field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetRestrictSources() string {
	if o == nil || o.RestrictSources == nil {
		var ret string
		return ret
	}
	return *o.RestrictSources
}

// GetRestrictSourcesOk returns a tuple with the RestrictSources field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetRestrictSourcesOk() (*string, bool) {
	if o == nil || o.RestrictSources == nil {
		return nil, false
	}
	return o.RestrictSources, true
}

// HasRestrictSources returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasRestrictSources() bool {
	if o != nil && o.RestrictSources != nil {
		return true
	}

	return false
}

// SetRestrictSources gets a reference to the given string and assigns it to the RestrictSources field.
func (o *SecuredApiKeyRestrictions) SetRestrictSources(v string) *SecuredApiKeyRestrictions {
	o.RestrictSources = &v
	return o
}

// GetUserToken returns the UserToken field value if set, zero value otherwise.
func (o *SecuredApiKeyRestrictions) GetUserToken() string {
	if o == nil || o.UserToken == nil {
		var ret string
		return ret
	}
	return *o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredApiKeyRestrictions) GetUserTokenOk() (*string, bool) {
	if o == nil || o.UserToken == nil {
		return nil, false
	}
	return o.UserToken, true
}

// HasUserToken returns a boolean if a field has been set.
func (o *SecuredApiKeyRestrictions) HasUserToken() bool {
	if o != nil && o.UserToken != nil {
		return true
	}

	return false
}

// SetUserToken gets a reference to the given string and assigns it to the UserToken field.
func (o *SecuredApiKeyRestrictions) SetUserToken(v string) *SecuredApiKeyRestrictions {
	o.UserToken = &v
	return o
}

func (o SecuredApiKeyRestrictions) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.SearchParams != nil {
		toSerialize["searchParams"] = o.SearchParams
	}
	if o.Filters != nil {
		toSerialize["filters"] = o.Filters
	}
	if o.ValidUntil != nil {
		toSerialize["validUntil"] = o.ValidUntil
	}
	if o.RestrictIndices != nil {
		toSerialize["restrictIndices"] = o.RestrictIndices
	}
	if o.RestrictSources != nil {
		toSerialize["restrictSources"] = o.RestrictSources
	}
	if o.UserToken != nil {
		toSerialize["userToken"] = o.UserToken
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SecuredApiKeyRestrictions: %w", err)
	}

	return serialized, nil
}

func (o SecuredApiKeyRestrictions) String() string {
	out := ""
	out += fmt.Sprintf("  searchParams=%v\n", o.SearchParams)
	out += fmt.Sprintf("  filters=%v\n", o.Filters)
	out += fmt.Sprintf("  validUntil=%v\n", o.ValidUntil)
	out += fmt.Sprintf("  restrictIndices=%v\n", o.RestrictIndices)
	out += fmt.Sprintf("  restrictSources=%v\n", o.RestrictSources)
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	return fmt.Sprintf("SecuredApiKeyRestrictions {\n%s}", out)
}
