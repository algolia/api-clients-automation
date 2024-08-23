// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// DestinationUpdate API request body for updating a destination.
type DestinationUpdate struct {
	Type *DestinationType `json:"type,omitempty"`
	// Descriptive name for the resource.
	Name  *string           `json:"name,omitempty"`
	Input *DestinationInput `json:"input,omitempty"`
	// Universally unique identifier (UUID) of an authentication resource.
	AuthenticationID  *string  `json:"authenticationID,omitempty"`
	TransformationIDs []string `json:"transformationIDs,omitempty"`
}

type DestinationUpdateOption func(f *DestinationUpdate)

func WithDestinationUpdateType(val DestinationType) DestinationUpdateOption {
	return func(f *DestinationUpdate) {
		f.Type = &val
	}
}

func WithDestinationUpdateName(val string) DestinationUpdateOption {
	return func(f *DestinationUpdate) {
		f.Name = &val
	}
}

func WithDestinationUpdateInput(val DestinationInput) DestinationUpdateOption {
	return func(f *DestinationUpdate) {
		f.Input = &val
	}
}

func WithDestinationUpdateAuthenticationID(val string) DestinationUpdateOption {
	return func(f *DestinationUpdate) {
		f.AuthenticationID = &val
	}
}

func WithDestinationUpdateTransformationIDs(val []string) DestinationUpdateOption {
	return func(f *DestinationUpdate) {
		f.TransformationIDs = val
	}
}

// NewDestinationUpdate instantiates a new DestinationUpdate object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDestinationUpdate(opts ...DestinationUpdateOption) *DestinationUpdate {
	this := &DestinationUpdate{}
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyDestinationUpdate return a pointer to an empty DestinationUpdate object.
func NewEmptyDestinationUpdate() *DestinationUpdate {
	return &DestinationUpdate{}
}

// GetType returns the Type field value if set, zero value otherwise.
func (o *DestinationUpdate) GetType() DestinationType {
	if o == nil || o.Type == nil {
		var ret DestinationType
		return ret
	}
	return *o.Type
}

// GetTypeOk returns a tuple with the Type field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DestinationUpdate) GetTypeOk() (*DestinationType, bool) {
	if o == nil || o.Type == nil {
		return nil, false
	}
	return o.Type, true
}

// HasType returns a boolean if a field has been set.
func (o *DestinationUpdate) HasType() bool {
	if o != nil && o.Type != nil {
		return true
	}

	return false
}

// SetType gets a reference to the given DestinationType and assigns it to the Type field.
func (o *DestinationUpdate) SetType(v DestinationType) *DestinationUpdate {
	o.Type = &v
	return o
}

// GetName returns the Name field value if set, zero value otherwise.
func (o *DestinationUpdate) GetName() string {
	if o == nil || o.Name == nil {
		var ret string
		return ret
	}
	return *o.Name
}

// GetNameOk returns a tuple with the Name field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DestinationUpdate) GetNameOk() (*string, bool) {
	if o == nil || o.Name == nil {
		return nil, false
	}
	return o.Name, true
}

// HasName returns a boolean if a field has been set.
func (o *DestinationUpdate) HasName() bool {
	if o != nil && o.Name != nil {
		return true
	}

	return false
}

// SetName gets a reference to the given string and assigns it to the Name field.
func (o *DestinationUpdate) SetName(v string) *DestinationUpdate {
	o.Name = &v
	return o
}

// GetInput returns the Input field value if set, zero value otherwise.
func (o *DestinationUpdate) GetInput() DestinationInput {
	if o == nil || o.Input == nil {
		var ret DestinationInput
		return ret
	}
	return *o.Input
}

// GetInputOk returns a tuple with the Input field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DestinationUpdate) GetInputOk() (*DestinationInput, bool) {
	if o == nil || o.Input == nil {
		return nil, false
	}
	return o.Input, true
}

// HasInput returns a boolean if a field has been set.
func (o *DestinationUpdate) HasInput() bool {
	if o != nil && o.Input != nil {
		return true
	}

	return false
}

// SetInput gets a reference to the given DestinationInput and assigns it to the Input field.
func (o *DestinationUpdate) SetInput(v *DestinationInput) *DestinationUpdate {
	o.Input = v
	return o
}

// GetAuthenticationID returns the AuthenticationID field value if set, zero value otherwise.
func (o *DestinationUpdate) GetAuthenticationID() string {
	if o == nil || o.AuthenticationID == nil {
		var ret string
		return ret
	}
	return *o.AuthenticationID
}

// GetAuthenticationIDOk returns a tuple with the AuthenticationID field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DestinationUpdate) GetAuthenticationIDOk() (*string, bool) {
	if o == nil || o.AuthenticationID == nil {
		return nil, false
	}
	return o.AuthenticationID, true
}

// HasAuthenticationID returns a boolean if a field has been set.
func (o *DestinationUpdate) HasAuthenticationID() bool {
	if o != nil && o.AuthenticationID != nil {
		return true
	}

	return false
}

// SetAuthenticationID gets a reference to the given string and assigns it to the AuthenticationID field.
func (o *DestinationUpdate) SetAuthenticationID(v string) *DestinationUpdate {
	o.AuthenticationID = &v
	return o
}

// GetTransformationIDs returns the TransformationIDs field value if set, zero value otherwise.
func (o *DestinationUpdate) GetTransformationIDs() []string {
	if o == nil || o.TransformationIDs == nil {
		var ret []string
		return ret
	}
	return o.TransformationIDs
}

// GetTransformationIDsOk returns a tuple with the TransformationIDs field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DestinationUpdate) GetTransformationIDsOk() ([]string, bool) {
	if o == nil || o.TransformationIDs == nil {
		return nil, false
	}
	return o.TransformationIDs, true
}

// HasTransformationIDs returns a boolean if a field has been set.
func (o *DestinationUpdate) HasTransformationIDs() bool {
	if o != nil && o.TransformationIDs != nil {
		return true
	}

	return false
}

// SetTransformationIDs gets a reference to the given []string and assigns it to the TransformationIDs field.
func (o *DestinationUpdate) SetTransformationIDs(v []string) *DestinationUpdate {
	o.TransformationIDs = v
	return o
}

func (o DestinationUpdate) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if o.Type != nil {
		toSerialize["type"] = o.Type
	}
	if o.Name != nil {
		toSerialize["name"] = o.Name
	}
	if o.Input != nil {
		toSerialize["input"] = o.Input
	}
	if o.AuthenticationID != nil {
		toSerialize["authenticationID"] = o.AuthenticationID
	}
	if o.TransformationIDs != nil {
		toSerialize["transformationIDs"] = o.TransformationIDs
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DestinationUpdate: %w", err)
	}

	return serialized, nil
}

func (o DestinationUpdate) String() string {
	out := ""
	out += fmt.Sprintf("  type=%v\n", o.Type)
	out += fmt.Sprintf("  name=%v\n", o.Name)
	out += fmt.Sprintf("  input=%v\n", o.Input)
	out += fmt.Sprintf("  authenticationID=%v\n", o.AuthenticationID)
	out += fmt.Sprintf("  transformationIDs=%v\n", o.TransformationIDs)
	return fmt.Sprintf("DestinationUpdate {\n%s}", out)
}
