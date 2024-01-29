// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// ApiKey API key object.
type ApiKey struct {
	// [Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key.
	Acl []Acl `json:"acl"`
	// Description of an API key for you and your team members.
	Description *string `json:"description,omitempty"`
	// Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - `dev_*` matches all indices starting with \"dev_\" - `*_dev` matches all indices ending with \"_dev\" - `*_products_*` matches all indices containing \"_products_\".
	Indexes []string `json:"indexes,omitempty"`
	// Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.
	MaxHitsPerQuery *int32 `json:"maxHitsPerQuery,omitempty"`
	// Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code `429` (Too Many Requests).  > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index.
	MaxQueriesPerIPPerHour *int32 `json:"maxQueriesPerIPPerHour,omitempty"`
	// Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It's a URL-encoded query string.
	QueryParameters *string `json:"queryParameters,omitempty"`
	// Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - `https://algolia.com/_*` matches all referrers starting with \"https://algolia.com/\" - `*.algolia.com` matches all referrers ending with \".algolia.com\" - `*algolia.com*` allows everything in the domain \"algolia.com\".
	Referers []string `json:"referers,omitempty"`
	// Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can't [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app's backend.
	Validity *int32 `json:"validity,omitempty"`
}

type ApiKeyOption func(f *ApiKey)

func WithApiKeyDescription(val string) ApiKeyOption {
	return func(f *ApiKey) {
		f.Description = &val
	}
}

func WithApiKeyIndexes(val []string) ApiKeyOption {
	return func(f *ApiKey) {
		f.Indexes = val
	}
}

func WithApiKeyMaxHitsPerQuery(val int32) ApiKeyOption {
	return func(f *ApiKey) {
		f.MaxHitsPerQuery = &val
	}
}

func WithApiKeyMaxQueriesPerIPPerHour(val int32) ApiKeyOption {
	return func(f *ApiKey) {
		f.MaxQueriesPerIPPerHour = &val
	}
}

func WithApiKeyQueryParameters(val string) ApiKeyOption {
	return func(f *ApiKey) {
		f.QueryParameters = &val
	}
}

func WithApiKeyReferers(val []string) ApiKeyOption {
	return func(f *ApiKey) {
		f.Referers = val
	}
}

func WithApiKeyValidity(val int32) ApiKeyOption {
	return func(f *ApiKey) {
		f.Validity = &val
	}
}

// NewApiKey instantiates a new ApiKey object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewApiKey(acl []Acl, opts ...ApiKeyOption) *ApiKey {
	this := &ApiKey{}
	this.Acl = acl
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyApiKey return a pointer to an empty ApiKey object.
func NewEmptyApiKey() *ApiKey {
	return &ApiKey{}
}

// GetAcl returns the Acl field value.
func (o *ApiKey) GetAcl() []Acl {
	if o == nil {
		var ret []Acl
		return ret
	}

	return o.Acl
}

// GetAclOk returns a tuple with the Acl field value
// and a boolean to check if the value has been set.
func (o *ApiKey) GetAclOk() ([]Acl, bool) {
	if o == nil {
		return nil, false
	}
	return o.Acl, true
}

// SetAcl sets field value.
func (o *ApiKey) SetAcl(v []Acl) *ApiKey {
	o.Acl = v
	return o
}

// GetDescription returns the Description field value if set, zero value otherwise.
func (o *ApiKey) GetDescription() string {
	if o == nil || o.Description == nil {
		var ret string
		return ret
	}
	return *o.Description
}

// GetDescriptionOk returns a tuple with the Description field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetDescriptionOk() (*string, bool) {
	if o == nil || o.Description == nil {
		return nil, false
	}
	return o.Description, true
}

// HasDescription returns a boolean if a field has been set.
func (o *ApiKey) HasDescription() bool {
	if o != nil && o.Description != nil {
		return true
	}

	return false
}

// SetDescription gets a reference to the given string and assigns it to the Description field.
func (o *ApiKey) SetDescription(v string) *ApiKey {
	o.Description = &v
	return o
}

// GetIndexes returns the Indexes field value if set, zero value otherwise.
func (o *ApiKey) GetIndexes() []string {
	if o == nil || o.Indexes == nil {
		var ret []string
		return ret
	}
	return o.Indexes
}

// GetIndexesOk returns a tuple with the Indexes field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetIndexesOk() ([]string, bool) {
	if o == nil || o.Indexes == nil {
		return nil, false
	}
	return o.Indexes, true
}

// HasIndexes returns a boolean if a field has been set.
func (o *ApiKey) HasIndexes() bool {
	if o != nil && o.Indexes != nil {
		return true
	}

	return false
}

// SetIndexes gets a reference to the given []string and assigns it to the Indexes field.
func (o *ApiKey) SetIndexes(v []string) *ApiKey {
	o.Indexes = v
	return o
}

// GetMaxHitsPerQuery returns the MaxHitsPerQuery field value if set, zero value otherwise.
func (o *ApiKey) GetMaxHitsPerQuery() int32 {
	if o == nil || o.MaxHitsPerQuery == nil {
		var ret int32
		return ret
	}
	return *o.MaxHitsPerQuery
}

// GetMaxHitsPerQueryOk returns a tuple with the MaxHitsPerQuery field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetMaxHitsPerQueryOk() (*int32, bool) {
	if o == nil || o.MaxHitsPerQuery == nil {
		return nil, false
	}
	return o.MaxHitsPerQuery, true
}

// HasMaxHitsPerQuery returns a boolean if a field has been set.
func (o *ApiKey) HasMaxHitsPerQuery() bool {
	if o != nil && o.MaxHitsPerQuery != nil {
		return true
	}

	return false
}

// SetMaxHitsPerQuery gets a reference to the given int32 and assigns it to the MaxHitsPerQuery field.
func (o *ApiKey) SetMaxHitsPerQuery(v int32) *ApiKey {
	o.MaxHitsPerQuery = &v
	return o
}

// GetMaxQueriesPerIPPerHour returns the MaxQueriesPerIPPerHour field value if set, zero value otherwise.
func (o *ApiKey) GetMaxQueriesPerIPPerHour() int32 {
	if o == nil || o.MaxQueriesPerIPPerHour == nil {
		var ret int32
		return ret
	}
	return *o.MaxQueriesPerIPPerHour
}

// GetMaxQueriesPerIPPerHourOk returns a tuple with the MaxQueriesPerIPPerHour field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetMaxQueriesPerIPPerHourOk() (*int32, bool) {
	if o == nil || o.MaxQueriesPerIPPerHour == nil {
		return nil, false
	}
	return o.MaxQueriesPerIPPerHour, true
}

// HasMaxQueriesPerIPPerHour returns a boolean if a field has been set.
func (o *ApiKey) HasMaxQueriesPerIPPerHour() bool {
	if o != nil && o.MaxQueriesPerIPPerHour != nil {
		return true
	}

	return false
}

// SetMaxQueriesPerIPPerHour gets a reference to the given int32 and assigns it to the MaxQueriesPerIPPerHour field.
func (o *ApiKey) SetMaxQueriesPerIPPerHour(v int32) *ApiKey {
	o.MaxQueriesPerIPPerHour = &v
	return o
}

// GetQueryParameters returns the QueryParameters field value if set, zero value otherwise.
func (o *ApiKey) GetQueryParameters() string {
	if o == nil || o.QueryParameters == nil {
		var ret string
		return ret
	}
	return *o.QueryParameters
}

// GetQueryParametersOk returns a tuple with the QueryParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetQueryParametersOk() (*string, bool) {
	if o == nil || o.QueryParameters == nil {
		return nil, false
	}
	return o.QueryParameters, true
}

// HasQueryParameters returns a boolean if a field has been set.
func (o *ApiKey) HasQueryParameters() bool {
	if o != nil && o.QueryParameters != nil {
		return true
	}

	return false
}

// SetQueryParameters gets a reference to the given string and assigns it to the QueryParameters field.
func (o *ApiKey) SetQueryParameters(v string) *ApiKey {
	o.QueryParameters = &v
	return o
}

// GetReferers returns the Referers field value if set, zero value otherwise.
func (o *ApiKey) GetReferers() []string {
	if o == nil || o.Referers == nil {
		var ret []string
		return ret
	}
	return o.Referers
}

// GetReferersOk returns a tuple with the Referers field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetReferersOk() ([]string, bool) {
	if o == nil || o.Referers == nil {
		return nil, false
	}
	return o.Referers, true
}

// HasReferers returns a boolean if a field has been set.
func (o *ApiKey) HasReferers() bool {
	if o != nil && o.Referers != nil {
		return true
	}

	return false
}

// SetReferers gets a reference to the given []string and assigns it to the Referers field.
func (o *ApiKey) SetReferers(v []string) *ApiKey {
	o.Referers = v
	return o
}

// GetValidity returns the Validity field value if set, zero value otherwise.
func (o *ApiKey) GetValidity() int32 {
	if o == nil || o.Validity == nil {
		var ret int32
		return ret
	}
	return *o.Validity
}

// GetValidityOk returns a tuple with the Validity field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ApiKey) GetValidityOk() (*int32, bool) {
	if o == nil || o.Validity == nil {
		return nil, false
	}
	return o.Validity, true
}

// HasValidity returns a boolean if a field has been set.
func (o *ApiKey) HasValidity() bool {
	if o != nil && o.Validity != nil {
		return true
	}

	return false
}

// SetValidity gets a reference to the given int32 and assigns it to the Validity field.
func (o *ApiKey) SetValidity(v int32) *ApiKey {
	o.Validity = &v
	return o
}

func (o ApiKey) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["acl"] = o.Acl
	}
	if o.Description != nil {
		toSerialize["description"] = o.Description
	}
	if o.Indexes != nil {
		toSerialize["indexes"] = o.Indexes
	}
	if o.MaxHitsPerQuery != nil {
		toSerialize["maxHitsPerQuery"] = o.MaxHitsPerQuery
	}
	if o.MaxQueriesPerIPPerHour != nil {
		toSerialize["maxQueriesPerIPPerHour"] = o.MaxQueriesPerIPPerHour
	}
	if o.QueryParameters != nil {
		toSerialize["queryParameters"] = o.QueryParameters
	}
	if o.Referers != nil {
		toSerialize["referers"] = o.Referers
	}
	if o.Validity != nil {
		toSerialize["validity"] = o.Validity
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal ApiKey: %w", err)
	}

	return serialized, nil
}

func (o ApiKey) String() string {
	out := ""
	out += fmt.Sprintf("  acl=%v\n", o.Acl)
	out += fmt.Sprintf("  description=%v\n", o.Description)
	out += fmt.Sprintf("  indexes=%v\n", o.Indexes)
	out += fmt.Sprintf("  maxHitsPerQuery=%v\n", o.MaxHitsPerQuery)
	out += fmt.Sprintf("  maxQueriesPerIPPerHour=%v\n", o.MaxQueriesPerIPPerHour)
	out += fmt.Sprintf("  queryParameters=%v\n", o.QueryParameters)
	out += fmt.Sprintf("  referers=%v\n", o.Referers)
	out += fmt.Sprintf("  validity=%v\n", o.Validity)
	return fmt.Sprintf("ApiKey {\n%s}", out)
}

type NullableApiKey struct {
	value *ApiKey
	isSet bool
}

func (v NullableApiKey) Get() *ApiKey {
	return v.value
}

func (v *NullableApiKey) Set(val *ApiKey) {
	v.value = val
	v.isSet = true
}

func (v NullableApiKey) IsSet() bool {
	return v.isSet
}

func (v *NullableApiKey) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableApiKey(val *ApiKey) *NullableApiKey {
	return &NullableApiKey{value: val, isSet: true}
}

func (v NullableApiKey) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableApiKey) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
