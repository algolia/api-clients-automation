// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceCSV struct for SourceCSV.
type SourceCSV struct {
	// URL of the file.
	Url string `json:"url"`
	// Name of a column that contains a unique ID which will be used as `objectID` in Algolia.
	UniqueIDColumn *string `json:"uniqueIDColumn,omitempty"`
	// Key-value pairs of column names and their expected types.
	Mapping *map[string]MappingTypeCSV `json:"mapping,omitempty"`
	Method  *MethodType                `json:"method,omitempty"`
	// The character used to split the value on each line, default to a comma (\\r, \\n, 0xFFFD, and space are forbidden).
	Delimiter *string `json:"delimiter,omitempty"`
}

type SourceCSVOption func(f *SourceCSV)

func WithSourceCSVUniqueIDColumn(val string) SourceCSVOption {
	return func(f *SourceCSV) {
		f.UniqueIDColumn = &val
	}
}

func WithSourceCSVMapping(val map[string]MappingTypeCSV) SourceCSVOption {
	return func(f *SourceCSV) {
		f.Mapping = &val
	}
}

func WithSourceCSVMethod(val MethodType) SourceCSVOption {
	return func(f *SourceCSV) {
		f.Method = &val
	}
}

func WithSourceCSVDelimiter(val string) SourceCSVOption {
	return func(f *SourceCSV) {
		f.Delimiter = &val
	}
}

// NewSourceCSV instantiates a new SourceCSV object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSourceCSV(url string, opts ...SourceCSVOption) *SourceCSV {
	this := &SourceCSV{}
	this.Url = url
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptySourceCSV return a pointer to an empty SourceCSV object.
func NewEmptySourceCSV() *SourceCSV {
	return &SourceCSV{}
}

// GetUrl returns the Url field value.
func (o *SourceCSV) GetUrl() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Url
}

// GetUrlOk returns a tuple with the Url field value
// and a boolean to check if the value has been set.
func (o *SourceCSV) GetUrlOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Url, true
}

// SetUrl sets field value.
func (o *SourceCSV) SetUrl(v string) *SourceCSV {
	o.Url = v
	return o
}

// GetUniqueIDColumn returns the UniqueIDColumn field value if set, zero value otherwise.
func (o *SourceCSV) GetUniqueIDColumn() string {
	if o == nil || o.UniqueIDColumn == nil {
		var ret string
		return ret
	}
	return *o.UniqueIDColumn
}

// GetUniqueIDColumnOk returns a tuple with the UniqueIDColumn field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCSV) GetUniqueIDColumnOk() (*string, bool) {
	if o == nil || o.UniqueIDColumn == nil {
		return nil, false
	}
	return o.UniqueIDColumn, true
}

// HasUniqueIDColumn returns a boolean if a field has been set.
func (o *SourceCSV) HasUniqueIDColumn() bool {
	if o != nil && o.UniqueIDColumn != nil {
		return true
	}

	return false
}

// SetUniqueIDColumn gets a reference to the given string and assigns it to the UniqueIDColumn field.
func (o *SourceCSV) SetUniqueIDColumn(v string) *SourceCSV {
	o.UniqueIDColumn = &v
	return o
}

// GetMapping returns the Mapping field value if set, zero value otherwise.
func (o *SourceCSV) GetMapping() map[string]MappingTypeCSV {
	if o == nil || o.Mapping == nil {
		var ret map[string]MappingTypeCSV
		return ret
	}
	return *o.Mapping
}

// GetMappingOk returns a tuple with the Mapping field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCSV) GetMappingOk() (*map[string]MappingTypeCSV, bool) {
	if o == nil || o.Mapping == nil {
		return nil, false
	}
	return o.Mapping, true
}

// HasMapping returns a boolean if a field has been set.
func (o *SourceCSV) HasMapping() bool {
	if o != nil && o.Mapping != nil {
		return true
	}

	return false
}

// SetMapping gets a reference to the given map[string]MappingTypeCSV and assigns it to the Mapping field.
func (o *SourceCSV) SetMapping(v map[string]MappingTypeCSV) *SourceCSV {
	o.Mapping = &v
	return o
}

// GetMethod returns the Method field value if set, zero value otherwise.
func (o *SourceCSV) GetMethod() MethodType {
	if o == nil || o.Method == nil {
		var ret MethodType
		return ret
	}
	return *o.Method
}

// GetMethodOk returns a tuple with the Method field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCSV) GetMethodOk() (*MethodType, bool) {
	if o == nil || o.Method == nil {
		return nil, false
	}
	return o.Method, true
}

// HasMethod returns a boolean if a field has been set.
func (o *SourceCSV) HasMethod() bool {
	if o != nil && o.Method != nil {
		return true
	}

	return false
}

// SetMethod gets a reference to the given MethodType and assigns it to the Method field.
func (o *SourceCSV) SetMethod(v MethodType) *SourceCSV {
	o.Method = &v
	return o
}

// GetDelimiter returns the Delimiter field value if set, zero value otherwise.
func (o *SourceCSV) GetDelimiter() string {
	if o == nil || o.Delimiter == nil {
		var ret string
		return ret
	}
	return *o.Delimiter
}

// GetDelimiterOk returns a tuple with the Delimiter field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *SourceCSV) GetDelimiterOk() (*string, bool) {
	if o == nil || o.Delimiter == nil {
		return nil, false
	}
	return o.Delimiter, true
}

// HasDelimiter returns a boolean if a field has been set.
func (o *SourceCSV) HasDelimiter() bool {
	if o != nil && o.Delimiter != nil {
		return true
	}

	return false
}

// SetDelimiter gets a reference to the given string and assigns it to the Delimiter field.
func (o *SourceCSV) SetDelimiter(v string) *SourceCSV {
	o.Delimiter = &v
	return o
}

func (o SourceCSV) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["url"] = o.Url
	}
	if o.UniqueIDColumn != nil {
		toSerialize["uniqueIDColumn"] = o.UniqueIDColumn
	}
	if o.Mapping != nil {
		toSerialize["mapping"] = o.Mapping
	}
	if o.Method != nil {
		toSerialize["method"] = o.Method
	}
	if o.Delimiter != nil {
		toSerialize["delimiter"] = o.Delimiter
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SourceCSV: %w", err)
	}

	return serialized, nil
}

func (o SourceCSV) String() string {
	out := ""
	out += fmt.Sprintf("  url=%v\n", o.Url)
	out += fmt.Sprintf("  uniqueIDColumn=%v\n", o.UniqueIDColumn)
	out += fmt.Sprintf("  mapping=%v\n", o.Mapping)
	out += fmt.Sprintf("  method=%v\n", o.Method)
	out += fmt.Sprintf("  delimiter=%v\n", o.Delimiter)
	return fmt.Sprintf("SourceCSV {\n%s}", out)
}

type NullableSourceCSV struct {
	value *SourceCSV
	isSet bool
}

func (v NullableSourceCSV) Get() *SourceCSV {
	return v.value
}

func (v *NullableSourceCSV) Set(val *SourceCSV) {
	v.value = val
	v.isSet = true
}

func (v NullableSourceCSV) IsSet() bool {
	return v.isSet
}

func (v *NullableSourceCSV) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableSourceCSV(val *SourceCSV) *NullableSourceCSV {
	return &NullableSourceCSV{value: val, isSet: true}
}

func (v NullableSourceCSV) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableSourceCSV) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
