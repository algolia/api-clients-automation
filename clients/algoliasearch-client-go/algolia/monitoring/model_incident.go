// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package monitoring

import (
	"encoding/json"
	"fmt"
)

// Incident Incident details.
type Incident struct {
	// Description of the incident.
	Title  *string `json:"title,omitempty"`
	Status *Status `json:"status,omitempty"`
}

type IncidentOption func(f *Incident)

func WithIncidentTitle(val string) IncidentOption {
	return func(f *Incident) {
		f.Title = &val
	}
}

func WithIncidentStatus(val Status) IncidentOption {
	return func(f *Incident) {
		f.Status = &val
	}
}

// NewIncident instantiates a new Incident object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewIncident(opts ...IncidentOption) *Incident {
	this := &Incident{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyIncident return a pointer to an empty Incident object.
func NewEmptyIncident() *Incident {
	return &Incident{}
}

// GetTitle returns the Title field value if set, zero value otherwise.
func (o *Incident) GetTitle() string {
	if o == nil || o.Title == nil {
		var ret string
		return ret
	}
	return *o.Title
}

// GetTitleOk returns a tuple with the Title field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Incident) GetTitleOk() (*string, bool) {
	if o == nil || o.Title == nil {
		return nil, false
	}
	return o.Title, true
}

// HasTitle returns a boolean if a field has been set.
func (o *Incident) HasTitle() bool {
	if o != nil && o.Title != nil {
		return true
	}

	return false
}

// SetTitle gets a reference to the given string and assigns it to the Title field.
func (o *Incident) SetTitle(v string) *Incident {
	o.Title = &v
	return o
}

// GetStatus returns the Status field value if set, zero value otherwise.
func (o *Incident) GetStatus() Status {
	if o == nil || o.Status == nil {
		var ret Status
		return ret
	}
	return *o.Status
}

// GetStatusOk returns a tuple with the Status field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Incident) GetStatusOk() (*Status, bool) {
	if o == nil || o.Status == nil {
		return nil, false
	}
	return o.Status, true
}

// HasStatus returns a boolean if a field has been set.
func (o *Incident) HasStatus() bool {
	if o != nil && o.Status != nil {
		return true
	}

	return false
}

// SetStatus gets a reference to the given Status and assigns it to the Status field.
func (o *Incident) SetStatus(v Status) *Incident {
	o.Status = &v
	return o
}

func (o Incident) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Title != nil {
		toSerialize["title"] = o.Title
	}
	if o.Status != nil {
		toSerialize["status"] = o.Status
	}
	return json.Marshal(toSerialize)
}

func (o Incident) String() string {
	out := ""
	out += fmt.Sprintf("  title=%v\n", o.Title)
	out += fmt.Sprintf("  status=%v\n", o.Status)
	return fmt.Sprintf("Incident {\n%s}", out)
}

type NullableIncident struct {
	value *Incident
	isSet bool
}

func (v NullableIncident) Get() *Incident {
	return v.value
}

func (v *NullableIncident) Set(val *Incident) {
	v.value = val
	v.isSet = true
}

func (v NullableIncident) IsSet() bool {
	return v.isSet
}

func (v *NullableIncident) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableIncident(val *Incident) *NullableIncident {
	return &NullableIncident{value: val, isSet: true}
}

func (v NullableIncident) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableIncident) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}
