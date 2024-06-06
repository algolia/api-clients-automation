// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package suggestions

import (
	"encoding/json"
	"fmt"
)

// GetConfigStatus200Response struct for GetConfigStatus200Response.
type GetConfigStatus200Response struct {
	// Name of the Query Suggestions index (case-sensitive).
	IndexName *string `json:"indexName,omitempty"`
	// Whether the creation or update of the Query Suggestions index is in progress.
	IsRunning *bool `json:"isRunning,omitempty"`
	// Date and time when the Query Suggestions index was last built, in RFC 3339 format.
	LastBuiltAt *string `json:"lastBuiltAt,omitempty"`
	// Date and time when the Query Suggestions index was last updated successfully.
	LastSuccessfulBuiltAt *string `json:"lastSuccessfulBuiltAt,omitempty"`
	// Duration of the last successful build in seconds.
	LastSuccessfulBuildDuration *string `json:"lastSuccessfulBuildDuration,omitempty"`
}

type GetConfigStatus200ResponseOption func(f *GetConfigStatus200Response)

func WithGetConfigStatus200ResponseIndexName(val string) GetConfigStatus200ResponseOption {
	return func(f *GetConfigStatus200Response) {
		f.IndexName = &val
	}
}

func WithGetConfigStatus200ResponseIsRunning(val bool) GetConfigStatus200ResponseOption {
	return func(f *GetConfigStatus200Response) {
		f.IsRunning = &val
	}
}

func WithGetConfigStatus200ResponseLastBuiltAt(val string) GetConfigStatus200ResponseOption {
	return func(f *GetConfigStatus200Response) {
		f.LastBuiltAt = &val
	}
}

func WithGetConfigStatus200ResponseLastSuccessfulBuiltAt(val string) GetConfigStatus200ResponseOption {
	return func(f *GetConfigStatus200Response) {
		f.LastSuccessfulBuiltAt = &val
	}
}

func WithGetConfigStatus200ResponseLastSuccessfulBuildDuration(val string) GetConfigStatus200ResponseOption {
	return func(f *GetConfigStatus200Response) {
		f.LastSuccessfulBuildDuration = &val
	}
}

// NewGetConfigStatus200Response instantiates a new GetConfigStatus200Response object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewGetConfigStatus200Response(opts ...GetConfigStatus200ResponseOption) *GetConfigStatus200Response {
	this := &GetConfigStatus200Response{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyGetConfigStatus200Response return a pointer to an empty GetConfigStatus200Response object.
func NewEmptyGetConfigStatus200Response() *GetConfigStatus200Response {
	return &GetConfigStatus200Response{}
}

// GetIndexName returns the IndexName field value if set, zero value otherwise.
func (o *GetConfigStatus200Response) GetIndexName() string {
	if o == nil || o.IndexName == nil {
		var ret string
		return ret
	}
	return *o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetConfigStatus200Response) GetIndexNameOk() (*string, bool) {
	if o == nil || o.IndexName == nil {
		return nil, false
	}
	return o.IndexName, true
}

// HasIndexName returns a boolean if a field has been set.
func (o *GetConfigStatus200Response) HasIndexName() bool {
	if o != nil && o.IndexName != nil {
		return true
	}

	return false
}

// SetIndexName gets a reference to the given string and assigns it to the IndexName field.
func (o *GetConfigStatus200Response) SetIndexName(v string) *GetConfigStatus200Response {
	o.IndexName = &v
	return o
}

// GetIsRunning returns the IsRunning field value if set, zero value otherwise.
func (o *GetConfigStatus200Response) GetIsRunning() bool {
	if o == nil || o.IsRunning == nil {
		var ret bool
		return ret
	}
	return *o.IsRunning
}

// GetIsRunningOk returns a tuple with the IsRunning field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetConfigStatus200Response) GetIsRunningOk() (*bool, bool) {
	if o == nil || o.IsRunning == nil {
		return nil, false
	}
	return o.IsRunning, true
}

// HasIsRunning returns a boolean if a field has been set.
func (o *GetConfigStatus200Response) HasIsRunning() bool {
	if o != nil && o.IsRunning != nil {
		return true
	}

	return false
}

// SetIsRunning gets a reference to the given bool and assigns it to the IsRunning field.
func (o *GetConfigStatus200Response) SetIsRunning(v bool) *GetConfigStatus200Response {
	o.IsRunning = &v
	return o
}

// GetLastBuiltAt returns the LastBuiltAt field value if set, zero value otherwise.
func (o *GetConfigStatus200Response) GetLastBuiltAt() string {
	if o == nil || o.LastBuiltAt == nil {
		var ret string
		return ret
	}
	return *o.LastBuiltAt
}

// GetLastBuiltAtOk returns a tuple with the LastBuiltAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetConfigStatus200Response) GetLastBuiltAtOk() (*string, bool) {
	if o == nil || o.LastBuiltAt == nil {
		return nil, false
	}
	return o.LastBuiltAt, true
}

// HasLastBuiltAt returns a boolean if a field has been set.
func (o *GetConfigStatus200Response) HasLastBuiltAt() bool {
	if o != nil && o.LastBuiltAt != nil {
		return true
	}

	return false
}

// SetLastBuiltAt gets a reference to the given string and assigns it to the LastBuiltAt field.
func (o *GetConfigStatus200Response) SetLastBuiltAt(v string) *GetConfigStatus200Response {
	o.LastBuiltAt = &v
	return o
}

// GetLastSuccessfulBuiltAt returns the LastSuccessfulBuiltAt field value if set, zero value otherwise.
func (o *GetConfigStatus200Response) GetLastSuccessfulBuiltAt() string {
	if o == nil || o.LastSuccessfulBuiltAt == nil {
		var ret string
		return ret
	}
	return *o.LastSuccessfulBuiltAt
}

// GetLastSuccessfulBuiltAtOk returns a tuple with the LastSuccessfulBuiltAt field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetConfigStatus200Response) GetLastSuccessfulBuiltAtOk() (*string, bool) {
	if o == nil || o.LastSuccessfulBuiltAt == nil {
		return nil, false
	}
	return o.LastSuccessfulBuiltAt, true
}

// HasLastSuccessfulBuiltAt returns a boolean if a field has been set.
func (o *GetConfigStatus200Response) HasLastSuccessfulBuiltAt() bool {
	if o != nil && o.LastSuccessfulBuiltAt != nil {
		return true
	}

	return false
}

// SetLastSuccessfulBuiltAt gets a reference to the given string and assigns it to the LastSuccessfulBuiltAt field.
func (o *GetConfigStatus200Response) SetLastSuccessfulBuiltAt(v string) *GetConfigStatus200Response {
	o.LastSuccessfulBuiltAt = &v
	return o
}

// GetLastSuccessfulBuildDuration returns the LastSuccessfulBuildDuration field value if set, zero value otherwise.
func (o *GetConfigStatus200Response) GetLastSuccessfulBuildDuration() string {
	if o == nil || o.LastSuccessfulBuildDuration == nil {
		var ret string
		return ret
	}
	return *o.LastSuccessfulBuildDuration
}

// GetLastSuccessfulBuildDurationOk returns a tuple with the LastSuccessfulBuildDuration field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *GetConfigStatus200Response) GetLastSuccessfulBuildDurationOk() (*string, bool) {
	if o == nil || o.LastSuccessfulBuildDuration == nil {
		return nil, false
	}
	return o.LastSuccessfulBuildDuration, true
}

// HasLastSuccessfulBuildDuration returns a boolean if a field has been set.
func (o *GetConfigStatus200Response) HasLastSuccessfulBuildDuration() bool {
	if o != nil && o.LastSuccessfulBuildDuration != nil {
		return true
	}

	return false
}

// SetLastSuccessfulBuildDuration gets a reference to the given string and assigns it to the LastSuccessfulBuildDuration field.
func (o *GetConfigStatus200Response) SetLastSuccessfulBuildDuration(v string) *GetConfigStatus200Response {
	o.LastSuccessfulBuildDuration = &v
	return o
}

func (o GetConfigStatus200Response) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.IndexName != nil {
		toSerialize["indexName"] = o.IndexName
	}
	if o.IsRunning != nil {
		toSerialize["isRunning"] = o.IsRunning
	}
	if o.LastBuiltAt != nil {
		toSerialize["lastBuiltAt"] = o.LastBuiltAt
	}
	if o.LastSuccessfulBuiltAt != nil {
		toSerialize["lastSuccessfulBuiltAt"] = o.LastSuccessfulBuiltAt
	}
	if o.LastSuccessfulBuildDuration != nil {
		toSerialize["lastSuccessfulBuildDuration"] = o.LastSuccessfulBuildDuration
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal GetConfigStatus200Response: %w", err)
	}

	return serialized, nil
}

func (o GetConfigStatus200Response) String() string {
	out := ""
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	out += fmt.Sprintf("  isRunning=%v\n", o.IsRunning)
	out += fmt.Sprintf("  lastBuiltAt=%v\n", o.LastBuiltAt)
	out += fmt.Sprintf("  lastSuccessfulBuiltAt=%v\n", o.LastSuccessfulBuiltAt)
	out += fmt.Sprintf("  lastSuccessfulBuildDuration=%v\n", o.LastSuccessfulBuildDuration)
	return fmt.Sprintf("GetConfigStatus200Response {\n%s}", out)
}

type NullableGetConfigStatus200Response struct {
	value *GetConfigStatus200Response
	isSet bool
}

func (v NullableGetConfigStatus200Response) Get() *GetConfigStatus200Response {
	return v.value
}

func (v *NullableGetConfigStatus200Response) Set(val *GetConfigStatus200Response) {
	v.value = val
	v.isSet = true
}

func (v NullableGetConfigStatus200Response) IsSet() bool {
	return v.isSet
}

func (v *NullableGetConfigStatus200Response) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableGetConfigStatus200Response(val *GetConfigStatus200Response) *NullableGetConfigStatus200Response {
	return &NullableGetConfigStatus200Response{value: val, isSet: true}
}

func (v NullableGetConfigStatus200Response) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableGetConfigStatus200Response) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
