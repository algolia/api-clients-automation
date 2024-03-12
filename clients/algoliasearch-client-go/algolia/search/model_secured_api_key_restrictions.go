// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// SecuredAPIKeyRestrictions struct for SecuredAPIKeyRestrictions.
type SecuredAPIKeyRestrictions struct {
	SearchParams *SearchParamsObject `json:"searchParams,omitempty"`
	// Filters that apply to every search made with the secured API key. Extra filters added at search time will be combined with `AND`. For example, if you set `group:admin` as fixed filter on your generated API key, and add `groups:visitors` to the search query, the complete set of filters will be `group:admin AND groups:visitors`.
	Filters *string `json:"filters,omitempty"`
	// Timestamp in [Unix epoch time](https://en.wikipedia.org/wiki/Unix_time) when the API key should expire.
	ValidUntil *int64 `json:"validUntil,omitempty"`
	// Index names or patterns that this API key can access. By default, an API key can access all indices in the same application.  You can use leading and trailing wildcard characters (`*`):  - `dev_*` matches all indices starting with \"dev_\". - `*_dev` matches all indices ending with \"_dev\". - `*_products_*` matches all indices containing \"_products_\".
	RestrictIndices []string `json:"restrictIndices,omitempty"`
	// IP network that are allowed to use this key.  You can only add a single source, but you can provide a range of IP addresses. Use this to protect against API key leaking and reuse.
	RestrictSources *string `json:"restrictSources,omitempty"`
	// Pseudonymous user identifier to restrict usage of this API key to specific users.  By default, rate limits are set based on IP addresses. This can be an issue if many users search from the same IP address. To avoid this, add a user token to each generated API key.
	UserToken *string `json:"userToken,omitempty"`
}

type SecuredAPIKeyRestrictionsOption func(f *SecuredAPIKeyRestrictions)

func WithSecuredAPIKeyRestrictionsSearchParams(val SearchParamsObject) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.SearchParams = &val
	}
}

func WithSecuredAPIKeyRestrictionsFilters(val string) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.Filters = &val
	}
}

func WithSecuredAPIKeyRestrictionsValidUntil(val int64) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.ValidUntil = &val
	}
}

func WithSecuredAPIKeyRestrictionsRestrictIndices(val []string) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.RestrictIndices = val
	}
}

func WithSecuredAPIKeyRestrictionsRestrictSources(val string) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.RestrictSources = &val
	}
}

func WithSecuredAPIKeyRestrictionsUserToken(val string) SecuredAPIKeyRestrictionsOption {
	return func(f *SecuredAPIKeyRestrictions) {
		f.UserToken = &val
	}
}

// NewSecuredAPIKeyRestrictions instantiates a new SecuredAPIKeyRestrictions object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSecuredAPIKeyRestrictions(opts ...SecuredAPIKeyRestrictionsOption) *SecuredAPIKeyRestrictions {
	this := &SecuredAPIKeyRestrictions{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySecuredAPIKeyRestrictions return a pointer to an empty SecuredAPIKeyRestrictions object.
func NewEmptySecuredAPIKeyRestrictions() *SecuredAPIKeyRestrictions {
	return &SecuredAPIKeyRestrictions{}
}

// GetSearchParams returns the SearchParams field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetSearchParams() SearchParamsObject {
	if o == nil || o.SearchParams == nil {
		var ret SearchParamsObject
		return ret
	}
	return *o.SearchParams
}

// GetSearchParamsOk returns a tuple with the SearchParams field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetSearchParamsOk() (*SearchParamsObject, bool) {
	if o == nil || o.SearchParams == nil {
		return nil, false
	}
	return o.SearchParams, true
}

// HasSearchParams returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasSearchParams() bool {
	if o != nil && o.SearchParams != nil {
		return true
	}

	return false
}

// SetSearchParams gets a reference to the given SearchParamsObject and assigns it to the SearchParams field.
func (o *SecuredAPIKeyRestrictions) SetSearchParams(v *SearchParamsObject) *SecuredAPIKeyRestrictions {
	o.SearchParams = v
	return o
}

// GetFilters returns the Filters field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetFilters() string {
	if o == nil || o.Filters == nil {
		var ret string
		return ret
	}
	return *o.Filters
}

// GetFiltersOk returns a tuple with the Filters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetFiltersOk() (*string, bool) {
	if o == nil || o.Filters == nil {
		return nil, false
	}
	return o.Filters, true
}

// HasFilters returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasFilters() bool {
	if o != nil && o.Filters != nil {
		return true
	}

	return false
}

// SetFilters gets a reference to the given string and assigns it to the Filters field.
func (o *SecuredAPIKeyRestrictions) SetFilters(v string) *SecuredAPIKeyRestrictions {
	o.Filters = &v
	return o
}

// GetValidUntil returns the ValidUntil field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetValidUntil() int64 {
	if o == nil || o.ValidUntil == nil {
		var ret int64
		return ret
	}
	return *o.ValidUntil
}

// GetValidUntilOk returns a tuple with the ValidUntil field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetValidUntilOk() (*int64, bool) {
	if o == nil || o.ValidUntil == nil {
		return nil, false
	}
	return o.ValidUntil, true
}

// HasValidUntil returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasValidUntil() bool {
	if o != nil && o.ValidUntil != nil {
		return true
	}

	return false
}

// SetValidUntil gets a reference to the given int64 and assigns it to the ValidUntil field.
func (o *SecuredAPIKeyRestrictions) SetValidUntil(v int64) *SecuredAPIKeyRestrictions {
	o.ValidUntil = &v
	return o
}

// GetRestrictIndices returns the RestrictIndices field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetRestrictIndices() []string {
	if o == nil || o.RestrictIndices == nil {
		var ret []string
		return ret
	}
	return o.RestrictIndices
}

// GetRestrictIndicesOk returns a tuple with the RestrictIndices field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetRestrictIndicesOk() ([]string, bool) {
	if o == nil || o.RestrictIndices == nil {
		return nil, false
	}
	return o.RestrictIndices, true
}

// HasRestrictIndices returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasRestrictIndices() bool {
	if o != nil && o.RestrictIndices != nil {
		return true
	}

	return false
}

// SetRestrictIndices gets a reference to the given []string and assigns it to the RestrictIndices field.
func (o *SecuredAPIKeyRestrictions) SetRestrictIndices(v []string) *SecuredAPIKeyRestrictions {
	o.RestrictIndices = v
	return o
}

// GetRestrictSources returns the RestrictSources field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetRestrictSources() string {
	if o == nil || o.RestrictSources == nil {
		var ret string
		return ret
	}
	return *o.RestrictSources
}

// GetRestrictSourcesOk returns a tuple with the RestrictSources field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetRestrictSourcesOk() (*string, bool) {
	if o == nil || o.RestrictSources == nil {
		return nil, false
	}
	return o.RestrictSources, true
}

// HasRestrictSources returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasRestrictSources() bool {
	if o != nil && o.RestrictSources != nil {
		return true
	}

	return false
}

// SetRestrictSources gets a reference to the given string and assigns it to the RestrictSources field.
func (o *SecuredAPIKeyRestrictions) SetRestrictSources(v string) *SecuredAPIKeyRestrictions {
	o.RestrictSources = &v
	return o
}

// GetUserToken returns the UserToken field value if set, zero value otherwise.
func (o *SecuredAPIKeyRestrictions) GetUserToken() string {
	if o == nil || o.UserToken == nil {
		var ret string
		return ret
	}
	return *o.UserToken
}

// GetUserTokenOk returns a tuple with the UserToken field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SecuredAPIKeyRestrictions) GetUserTokenOk() (*string, bool) {
	if o == nil || o.UserToken == nil {
		return nil, false
	}
	return o.UserToken, true
}

// HasUserToken returns a boolean if a field has been set.
func (o *SecuredAPIKeyRestrictions) HasUserToken() bool {
	if o != nil && o.UserToken != nil {
		return true
	}

	return false
}

// SetUserToken gets a reference to the given string and assigns it to the UserToken field.
func (o *SecuredAPIKeyRestrictions) SetUserToken(v string) *SecuredAPIKeyRestrictions {
	o.UserToken = &v
	return o
}

func (o SecuredAPIKeyRestrictions) MarshalJSON() ([]byte, error) {
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
		return nil, fmt.Errorf("failed to marshal SecuredAPIKeyRestrictions: %w", err)
	}

	return serialized, nil
}

func (o SecuredAPIKeyRestrictions) String() string {
	out := ""
	out += fmt.Sprintf("  searchParams=%v\n", o.SearchParams)
	out += fmt.Sprintf("  filters=%v\n", o.Filters)
	out += fmt.Sprintf("  validUntil=%v\n", o.ValidUntil)
	out += fmt.Sprintf("  restrictIndices=%v\n", o.RestrictIndices)
	out += fmt.Sprintf("  restrictSources=%v\n", o.RestrictSources)
	out += fmt.Sprintf("  userToken=%v\n", o.UserToken)
	return fmt.Sprintf("SecuredAPIKeyRestrictions {\n%s}", out)
}

type NullableSecuredAPIKeyRestrictions struct {
	value *SecuredAPIKeyRestrictions
	isSet bool
}

func (v NullableSecuredAPIKeyRestrictions) Get() *SecuredAPIKeyRestrictions {
	return v.value
}

func (v *NullableSecuredAPIKeyRestrictions) Set(val *SecuredAPIKeyRestrictions) {
	v.value = val
	v.isSet = true
}

func (v NullableSecuredAPIKeyRestrictions) IsSet() bool {
	return v.isSet
}

func (v *NullableSecuredAPIKeyRestrictions) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSecuredAPIKeyRestrictions(val *SecuredAPIKeyRestrictions) *NullableSecuredAPIKeyRestrictions {
	return &NullableSecuredAPIKeyRestrictions{value: val, isSet: true}
}

func (v NullableSecuredAPIKeyRestrictions) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSecuredAPIKeyRestrictions) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
