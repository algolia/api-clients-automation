// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// Model struct for Model.
type Model struct {
	Fullname     string `json:"fullname"`
	ModelName    string `json:"modelName"`
	SystemPrompt string `json:"systemPrompt"`
	Id           string `json:"id"`
	Provider     string `json:"provider"`
}

// NewModel instantiates a new Model object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewModel(fullname string, modelName string, systemPrompt string, id string, provider string) *Model {
	this := &Model{}
	this.Fullname = fullname
	this.ModelName = modelName
	this.SystemPrompt = systemPrompt
	this.Id = id
	this.Provider = provider
	return this
}

// NewEmptyModel return a pointer to an empty Model object.
func NewEmptyModel() *Model {
	return &Model{}
}

// GetFullname returns the Fullname field value.
func (o *Model) GetFullname() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Fullname
}

// GetFullnameOk returns a tuple with the Fullname field value
// and a boolean to check if the value has been set.
func (o *Model) GetFullnameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Fullname, true
}

// SetFullname sets field value.
func (o *Model) SetFullname(v string) *Model {
	o.Fullname = v
	return o
}

// GetModelName returns the ModelName field value.
func (o *Model) GetModelName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ModelName
}

// GetModelNameOk returns a tuple with the ModelName field value
// and a boolean to check if the value has been set.
func (o *Model) GetModelNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ModelName, true
}

// SetModelName sets field value.
func (o *Model) SetModelName(v string) *Model {
	o.ModelName = v
	return o
}

// GetSystemPrompt returns the SystemPrompt field value.
func (o *Model) GetSystemPrompt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.SystemPrompt
}

// GetSystemPromptOk returns a tuple with the SystemPrompt field value
// and a boolean to check if the value has been set.
func (o *Model) GetSystemPromptOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.SystemPrompt, true
}

// SetSystemPrompt sets field value.
func (o *Model) SetSystemPrompt(v string) *Model {
	o.SystemPrompt = v
	return o
}

// GetId returns the Id field value.
func (o *Model) GetId() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Id
}

// GetIdOk returns a tuple with the Id field value
// and a boolean to check if the value has been set.
func (o *Model) GetIdOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Id, true
}

// SetId sets field value.
func (o *Model) SetId(v string) *Model {
	o.Id = v
	return o
}

// GetProvider returns the Provider field value.
func (o *Model) GetProvider() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Provider
}

// GetProviderOk returns a tuple with the Provider field value
// and a boolean to check if the value has been set.
func (o *Model) GetProviderOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Provider, true
}

// SetProvider sets field value.
func (o *Model) SetProvider(v string) *Model {
	o.Provider = v
	return o
}

func (o Model) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["fullname"] = o.Fullname
	}
	if true {
		toSerialize["modelName"] = o.ModelName
	}
	if true {
		toSerialize["systemPrompt"] = o.SystemPrompt
	}
	if true {
		toSerialize["id"] = o.Id
	}
	if true {
		toSerialize["provider"] = o.Provider
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal Model: %w", err)
	}

	return serialized, nil
}

func (o Model) String() string {
	out := ""
	out += fmt.Sprintf("  fullname=%v\n", o.Fullname)
	out += fmt.Sprintf("  modelName=%v\n", o.ModelName)
	out += fmt.Sprintf("  systemPrompt=%v\n", o.SystemPrompt)
	out += fmt.Sprintf("  id=%v\n", o.Id)
	out += fmt.Sprintf("  provider=%v\n", o.Provider)
	return fmt.Sprintf("Model {\n%s}", out)
}
