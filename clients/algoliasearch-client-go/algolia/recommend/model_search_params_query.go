// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package recommend

import (
	"encoding/json"
	"fmt"
)

// SearchParamsQuery struct for SearchParamsQuery.
type SearchParamsQuery struct {
	// Search query.
	Query *string `json:"query,omitempty"`
}

type SearchParamsQueryOption func(f *SearchParamsQuery)

func WithSearchParamsQueryQuery(val string) SearchParamsQueryOption {
	return func(f *SearchParamsQuery) {
		f.Query = &val
	}
}

// NewSearchParamsQuery instantiates a new SearchParamsQuery object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSearchParamsQuery(opts ...SearchParamsQueryOption) *SearchParamsQuery {
	this := &SearchParamsQuery{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySearchParamsQuery return a pointer to an empty SearchParamsQuery object.
func NewEmptySearchParamsQuery() *SearchParamsQuery {
	return &SearchParamsQuery{}
}

// GetQuery returns the Query field value if set, zero value otherwise.
func (o *SearchParamsQuery) GetQuery() string {
	if o == nil || o.Query == nil {
		var ret string
		return ret
	}
	return *o.Query
}

// GetQueryOk returns a tuple with the Query field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SearchParamsQuery) GetQueryOk() (*string, bool) {
	if o == nil || o.Query == nil {
		return nil, false
	}
	return o.Query, true
}

// HasQuery returns a boolean if a field has been set.
func (o *SearchParamsQuery) HasQuery() bool {
	if o != nil && o.Query != nil {
		return true
	}

	return false
}

// SetQuery gets a reference to the given string and assigns it to the Query field.
func (o *SearchParamsQuery) SetQuery(v string) *SearchParamsQuery {
	o.Query = &v
	return o
}

func (o SearchParamsQuery) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Query != nil {
		toSerialize["query"] = o.Query
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SearchParamsQuery: %w", err)
	}

	return serialized, nil
}

func (o SearchParamsQuery) String() string {
	out := ""
	out += fmt.Sprintf("  query=%v\n", o.Query)
	return fmt.Sprintf("SearchParamsQuery {\n%s}", out)
}

type NullableSearchParamsQuery struct {
	value *SearchParamsQuery
	isSet bool
}

func (v NullableSearchParamsQuery) Get() *SearchParamsQuery {
	return v.value
}

func (v *NullableSearchParamsQuery) Set(val *SearchParamsQuery) {
	v.value = val
	v.isSet = true
}

func (v NullableSearchParamsQuery) IsSet() bool {
	return v.isSet
}

func (v *NullableSearchParamsQuery) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSearchParamsQuery(val *SearchParamsQuery) *NullableSearchParamsQuery {
	return &NullableSearchParamsQuery{value: val, isSet: true}
}

func (v NullableSearchParamsQuery) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSearchParamsQuery) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
