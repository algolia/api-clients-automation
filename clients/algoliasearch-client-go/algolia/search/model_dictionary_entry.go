// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// DictionaryEntry Dictionary entry.
type DictionaryEntry struct {
	// Unique identifier for the dictionary entry.
	ObjectID string             `json:"objectID"`
	Language *SupportedLanguage `json:"language,omitempty"`
	// Matching dictionary word for `stopwords` and `compounds` dictionaries.
	Word *string `json:"word,omitempty"`
	// Matching words in the `plurals` dictionary including declensions.
	Words []string `json:"words,omitempty"`
	// Invividual components of a compound word in the `compounds` dictionary.
	Decomposition        []string              `json:"decomposition,omitempty"`
	State                *DictionaryEntryState `json:"state,omitempty"`
	Type                 *DictionaryEntryType  `json:"type,omitempty"`
	AdditionalProperties map[string]any
}

type _DictionaryEntry DictionaryEntry

type DictionaryEntryOption func(f *DictionaryEntry)

func WithDictionaryEntryLanguage(val SupportedLanguage) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.Language = &val
	}
}

func WithDictionaryEntryWord(val string) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.Word = &val
	}
}

func WithDictionaryEntryWords(val []string) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.Words = val
	}
}

func WithDictionaryEntryDecomposition(val []string) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.Decomposition = val
	}
}

func WithDictionaryEntryState(val DictionaryEntryState) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.State = &val
	}
}

func WithDictionaryEntryType(val DictionaryEntryType) DictionaryEntryOption {
	return func(f *DictionaryEntry) {
		f.Type = &val
	}
}

// NewDictionaryEntry instantiates a new DictionaryEntry object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewDictionaryEntry(objectID string, opts ...DictionaryEntryOption) *DictionaryEntry {
	this := &DictionaryEntry{}
	this.ObjectID = objectID
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyDictionaryEntry return a pointer to an empty DictionaryEntry object.
func NewEmptyDictionaryEntry() *DictionaryEntry {
	return &DictionaryEntry{}
}

// GetObjectID returns the ObjectID field value.
func (o *DictionaryEntry) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value.
func (o *DictionaryEntry) SetObjectID(v string) *DictionaryEntry {
	o.ObjectID = v
	return o
}

// GetLanguage returns the Language field value if set, zero value otherwise.
func (o *DictionaryEntry) GetLanguage() SupportedLanguage {
	if o == nil || o.Language == nil {
		var ret SupportedLanguage
		return ret
	}
	return *o.Language
}

// GetLanguageOk returns a tuple with the Language field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetLanguageOk() (*SupportedLanguage, bool) {
	if o == nil || o.Language == nil {
		return nil, false
	}
	return o.Language, true
}

// HasLanguage returns a boolean if a field has been set.
func (o *DictionaryEntry) HasLanguage() bool {
	if o != nil && o.Language != nil {
		return true
	}

	return false
}

// SetLanguage gets a reference to the given SupportedLanguage and assigns it to the Language field.
func (o *DictionaryEntry) SetLanguage(v SupportedLanguage) *DictionaryEntry {
	o.Language = &v
	return o
}

// GetWord returns the Word field value if set, zero value otherwise.
func (o *DictionaryEntry) GetWord() string {
	if o == nil || o.Word == nil {
		var ret string
		return ret
	}
	return *o.Word
}

// GetWordOk returns a tuple with the Word field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetWordOk() (*string, bool) {
	if o == nil || o.Word == nil {
		return nil, false
	}
	return o.Word, true
}

// HasWord returns a boolean if a field has been set.
func (o *DictionaryEntry) HasWord() bool {
	if o != nil && o.Word != nil {
		return true
	}

	return false
}

// SetWord gets a reference to the given string and assigns it to the Word field.
func (o *DictionaryEntry) SetWord(v string) *DictionaryEntry {
	o.Word = &v
	return o
}

// GetWords returns the Words field value if set, zero value otherwise.
func (o *DictionaryEntry) GetWords() []string {
	if o == nil || o.Words == nil {
		var ret []string
		return ret
	}
	return o.Words
}

// GetWordsOk returns a tuple with the Words field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetWordsOk() ([]string, bool) {
	if o == nil || o.Words == nil {
		return nil, false
	}
	return o.Words, true
}

// HasWords returns a boolean if a field has been set.
func (o *DictionaryEntry) HasWords() bool {
	if o != nil && o.Words != nil {
		return true
	}

	return false
}

// SetWords gets a reference to the given []string and assigns it to the Words field.
func (o *DictionaryEntry) SetWords(v []string) *DictionaryEntry {
	o.Words = v
	return o
}

// GetDecomposition returns the Decomposition field value if set, zero value otherwise.
func (o *DictionaryEntry) GetDecomposition() []string {
	if o == nil || o.Decomposition == nil {
		var ret []string
		return ret
	}
	return o.Decomposition
}

// GetDecompositionOk returns a tuple with the Decomposition field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetDecompositionOk() ([]string, bool) {
	if o == nil || o.Decomposition == nil {
		return nil, false
	}
	return o.Decomposition, true
}

// HasDecomposition returns a boolean if a field has been set.
func (o *DictionaryEntry) HasDecomposition() bool {
	if o != nil && o.Decomposition != nil {
		return true
	}

	return false
}

// SetDecomposition gets a reference to the given []string and assigns it to the Decomposition field.
func (o *DictionaryEntry) SetDecomposition(v []string) *DictionaryEntry {
	o.Decomposition = v
	return o
}

// GetState returns the State field value if set, zero value otherwise.
func (o *DictionaryEntry) GetState() DictionaryEntryState {
	if o == nil || o.State == nil {
		var ret DictionaryEntryState
		return ret
	}
	return *o.State
}

// GetStateOk returns a tuple with the State field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetStateOk() (*DictionaryEntryState, bool) {
	if o == nil || o.State == nil {
		return nil, false
	}
	return o.State, true
}

// HasState returns a boolean if a field has been set.
func (o *DictionaryEntry) HasState() bool {
	if o != nil && o.State != nil {
		return true
	}

	return false
}

// SetState gets a reference to the given DictionaryEntryState and assigns it to the State field.
func (o *DictionaryEntry) SetState(v DictionaryEntryState) *DictionaryEntry {
	o.State = &v
	return o
}

// GetType returns the Type field value if set, zero value otherwise.
func (o *DictionaryEntry) GetType() DictionaryEntryType {
	if o == nil || o.Type == nil {
		var ret DictionaryEntryType
		return ret
	}
	return *o.Type
}

// GetTypeOk returns a tuple with the Type field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *DictionaryEntry) GetTypeOk() (*DictionaryEntryType, bool) {
	if o == nil || o.Type == nil {
		return nil, false
	}
	return o.Type, true
}

// HasType returns a boolean if a field has been set.
func (o *DictionaryEntry) HasType() bool {
	if o != nil && o.Type != nil {
		return true
	}

	return false
}

// SetType gets a reference to the given DictionaryEntryType and assigns it to the Type field.
func (o *DictionaryEntry) SetType(v DictionaryEntryType) *DictionaryEntry {
	o.Type = &v
	return o
}

func (o *DictionaryEntry) SetAdditionalProperty(key string, value any) *DictionaryEntry {
	if o.AdditionalProperties == nil {
		o.AdditionalProperties = make(map[string]any)
	}

	o.AdditionalProperties[key] = value

	return o
}

func (o DictionaryEntry) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["objectID"] = o.ObjectID
	if o.Language != nil {
		toSerialize["language"] = o.Language
	}
	if o.Word != nil {
		toSerialize["word"] = o.Word
	}
	if o.Words != nil {
		toSerialize["words"] = o.Words
	}
	if o.Decomposition != nil {
		toSerialize["decomposition"] = o.Decomposition
	}
	if o.State != nil {
		toSerialize["state"] = o.State
	}
	if o.Type != nil {
		toSerialize["type"] = o.Type
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal DictionaryEntry: %w", err)
	}

	return serialized, nil
}

func (o *DictionaryEntry) UnmarshalJSON(bytes []byte) error {
	varDictionaryEntry := _DictionaryEntry{}

	err := json.Unmarshal(bytes, &varDictionaryEntry)
	if err != nil {
		return fmt.Errorf("failed to unmarshal DictionaryEntry: %w", err)
	}

	*o = DictionaryEntry(varDictionaryEntry)

	additionalProperties := make(map[string]any)

	err = json.Unmarshal(bytes, &additionalProperties)
	if err != nil {
		return fmt.Errorf("failed to unmarshal additionalProperties in DictionaryEntry: %w", err)
	}

	delete(additionalProperties, "objectID")
	delete(additionalProperties, "language")
	delete(additionalProperties, "word")
	delete(additionalProperties, "words")
	delete(additionalProperties, "decomposition")
	delete(additionalProperties, "state")
	delete(additionalProperties, "type")
	o.AdditionalProperties = additionalProperties

	return nil
}

func (o DictionaryEntry) String() string {
	out := ""
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  language=%v\n", o.Language)
	out += fmt.Sprintf("  word=%v\n", o.Word)
	out += fmt.Sprintf("  words=%v\n", o.Words)
	out += fmt.Sprintf("  decomposition=%v\n", o.Decomposition)
	out += fmt.Sprintf("  state=%v\n", o.State)
	out += fmt.Sprintf("  type=%v\n", o.Type)
	for key, value := range o.AdditionalProperties {
		out += fmt.Sprintf("  %s=%v\n", key, value)
	}
	return fmt.Sprintf("DictionaryEntry {\n%s}", out)
}
