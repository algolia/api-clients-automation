// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package search

import (
	"encoding/json"
	"fmt"
)

// FetchedIndex struct for FetchedIndex.
type FetchedIndex struct {
	// Index name.
	Name string `json:"name"`
	// Index creation date. An empty string means that the index has no records.
	CreatedAt string `json:"createdAt"`
	// Date and time when the object was updated, in RFC 3339 format.
	UpdatedAt string `json:"updatedAt"`
	// Number of records contained in the index.
	Entries int32 `json:"entries"`
	// Number of bytes of the index in minified format.
	DataSize int32 `json:"dataSize"`
	// Number of bytes of the index binary file.
	FileSize int32 `json:"fileSize"`
	// Last build time.
	LastBuildTimeS int32 `json:"lastBuildTimeS"`
	// Number of pending indexing operations. This value is deprecated and should not be used.
	NumberOfPendingTasks int32 `json:"numberOfPendingTasks"`
	// A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.
	PendingTask bool `json:"pendingTask"`
	// Only present if the index is a replica. Contains the name of the related primary index.
	Primary *string `json:"primary,omitempty"`
	// Only present if the index is a primary index with replicas. Contains the names of all linked replicas.
	Replicas []string `json:"replicas,omitempty"`
}

type FetchedIndexOption func(f *FetchedIndex)

func WithFetchedIndexPrimary(val string) FetchedIndexOption {
	return func(f *FetchedIndex) {
		f.Primary = &val
	}
}

func WithFetchedIndexReplicas(val []string) FetchedIndexOption {
	return func(f *FetchedIndex) {
		f.Replicas = val
	}
}

// NewFetchedIndex instantiates a new FetchedIndex object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewFetchedIndex(name string, createdAt string, updatedAt string, entries int32, dataSize int32, fileSize int32, lastBuildTimeS int32, numberOfPendingTasks int32, pendingTask bool, opts ...FetchedIndexOption) *FetchedIndex {
	this := &FetchedIndex{}
	this.Name = name
	this.CreatedAt = createdAt
	this.UpdatedAt = updatedAt
	this.Entries = entries
	this.DataSize = dataSize
	this.FileSize = fileSize
	this.LastBuildTimeS = lastBuildTimeS
	this.NumberOfPendingTasks = numberOfPendingTasks
	this.PendingTask = pendingTask
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyFetchedIndex return a pointer to an empty FetchedIndex object.
func NewEmptyFetchedIndex() *FetchedIndex {
	return &FetchedIndex{}
}

// GetName returns the Name field value.
func (o *FetchedIndex) GetName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.Name
}

// GetNameOk returns a tuple with the Name field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Name, true
}

// SetName sets field value.
func (o *FetchedIndex) SetName(v string) *FetchedIndex {
	o.Name = v
	return o
}

// GetCreatedAt returns the CreatedAt field value.
func (o *FetchedIndex) GetCreatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.CreatedAt
}

// GetCreatedAtOk returns a tuple with the CreatedAt field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetCreatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.CreatedAt, true
}

// SetCreatedAt sets field value.
func (o *FetchedIndex) SetCreatedAt(v string) *FetchedIndex {
	o.CreatedAt = v
	return o
}

// GetUpdatedAt returns the UpdatedAt field value.
func (o *FetchedIndex) GetUpdatedAt() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UpdatedAt
}

// GetUpdatedAtOk returns a tuple with the UpdatedAt field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetUpdatedAtOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UpdatedAt, true
}

// SetUpdatedAt sets field value.
func (o *FetchedIndex) SetUpdatedAt(v string) *FetchedIndex {
	o.UpdatedAt = v
	return o
}

// GetEntries returns the Entries field value.
func (o *FetchedIndex) GetEntries() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.Entries
}

// GetEntriesOk returns a tuple with the Entries field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetEntriesOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Entries, true
}

// SetEntries sets field value.
func (o *FetchedIndex) SetEntries(v int32) *FetchedIndex {
	o.Entries = v
	return o
}

// GetDataSize returns the DataSize field value.
func (o *FetchedIndex) GetDataSize() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.DataSize
}

// GetDataSizeOk returns a tuple with the DataSize field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetDataSizeOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DataSize, true
}

// SetDataSize sets field value.
func (o *FetchedIndex) SetDataSize(v int32) *FetchedIndex {
	o.DataSize = v
	return o
}

// GetFileSize returns the FileSize field value.
func (o *FetchedIndex) GetFileSize() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.FileSize
}

// GetFileSizeOk returns a tuple with the FileSize field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetFileSizeOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.FileSize, true
}

// SetFileSize sets field value.
func (o *FetchedIndex) SetFileSize(v int32) *FetchedIndex {
	o.FileSize = v
	return o
}

// GetLastBuildTimeS returns the LastBuildTimeS field value.
func (o *FetchedIndex) GetLastBuildTimeS() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.LastBuildTimeS
}

// GetLastBuildTimeSOk returns a tuple with the LastBuildTimeS field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetLastBuildTimeSOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.LastBuildTimeS, true
}

// SetLastBuildTimeS sets field value.
func (o *FetchedIndex) SetLastBuildTimeS(v int32) *FetchedIndex {
	o.LastBuildTimeS = v
	return o
}

// GetNumberOfPendingTasks returns the NumberOfPendingTasks field value.
func (o *FetchedIndex) GetNumberOfPendingTasks() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NumberOfPendingTasks
}

// GetNumberOfPendingTasksOk returns a tuple with the NumberOfPendingTasks field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetNumberOfPendingTasksOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NumberOfPendingTasks, true
}

// SetNumberOfPendingTasks sets field value.
func (o *FetchedIndex) SetNumberOfPendingTasks(v int32) *FetchedIndex {
	o.NumberOfPendingTasks = v
	return o
}

// GetPendingTask returns the PendingTask field value.
func (o *FetchedIndex) GetPendingTask() bool {
	if o == nil {
		var ret bool
		return ret
	}

	return o.PendingTask
}

// GetPendingTaskOk returns a tuple with the PendingTask field value
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetPendingTaskOk() (*bool, bool) {
	if o == nil {
		return nil, false
	}
	return &o.PendingTask, true
}

// SetPendingTask sets field value.
func (o *FetchedIndex) SetPendingTask(v bool) *FetchedIndex {
	o.PendingTask = v
	return o
}

// GetPrimary returns the Primary field value if set, zero value otherwise.
func (o *FetchedIndex) GetPrimary() string {
	if o == nil || o.Primary == nil {
		var ret string
		return ret
	}
	return *o.Primary
}

// GetPrimaryOk returns a tuple with the Primary field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetPrimaryOk() (*string, bool) {
	if o == nil || o.Primary == nil {
		return nil, false
	}
	return o.Primary, true
}

// HasPrimary returns a boolean if a field has been set.
func (o *FetchedIndex) HasPrimary() bool {
	if o != nil && o.Primary != nil {
		return true
	}

	return false
}

// SetPrimary gets a reference to the given string and assigns it to the Primary field.
func (o *FetchedIndex) SetPrimary(v string) *FetchedIndex {
	o.Primary = &v
	return o
}

// GetReplicas returns the Replicas field value if set, zero value otherwise.
func (o *FetchedIndex) GetReplicas() []string {
	if o == nil || o.Replicas == nil {
		var ret []string
		return ret
	}
	return o.Replicas
}

// GetReplicasOk returns a tuple with the Replicas field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *FetchedIndex) GetReplicasOk() ([]string, bool) {
	if o == nil || o.Replicas == nil {
		return nil, false
	}
	return o.Replicas, true
}

// HasReplicas returns a boolean if a field has been set.
func (o *FetchedIndex) HasReplicas() bool {
	if o != nil && o.Replicas != nil {
		return true
	}

	return false
}

// SetReplicas gets a reference to the given []string and assigns it to the Replicas field.
func (o *FetchedIndex) SetReplicas(v []string) *FetchedIndex {
	o.Replicas = v
	return o
}

func (o FetchedIndex) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["name"] = o.Name
	}
	if true {
		toSerialize["createdAt"] = o.CreatedAt
	}
	if true {
		toSerialize["updatedAt"] = o.UpdatedAt
	}
	if true {
		toSerialize["entries"] = o.Entries
	}
	if true {
		toSerialize["dataSize"] = o.DataSize
	}
	if true {
		toSerialize["fileSize"] = o.FileSize
	}
	if true {
		toSerialize["lastBuildTimeS"] = o.LastBuildTimeS
	}
	if true {
		toSerialize["numberOfPendingTasks"] = o.NumberOfPendingTasks
	}
	if true {
		toSerialize["pendingTask"] = o.PendingTask
	}
	if o.Primary != nil {
		toSerialize["primary"] = o.Primary
	}
	if o.Replicas != nil {
		toSerialize["replicas"] = o.Replicas
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal FetchedIndex: %w", err)
	}

	return serialized, nil
}

func (o FetchedIndex) String() string {
	out := ""
	out += fmt.Sprintf("  name=%v\n", o.Name)
	out += fmt.Sprintf("  createdAt=%v\n", o.CreatedAt)
	out += fmt.Sprintf("  updatedAt=%v\n", o.UpdatedAt)
	out += fmt.Sprintf("  entries=%v\n", o.Entries)
	out += fmt.Sprintf("  dataSize=%v\n", o.DataSize)
	out += fmt.Sprintf("  fileSize=%v\n", o.FileSize)
	out += fmt.Sprintf("  lastBuildTimeS=%v\n", o.LastBuildTimeS)
	out += fmt.Sprintf("  numberOfPendingTasks=%v\n", o.NumberOfPendingTasks)
	out += fmt.Sprintf("  pendingTask=%v\n", o.PendingTask)
	out += fmt.Sprintf("  primary=%v\n", o.Primary)
	out += fmt.Sprintf("  replicas=%v\n", o.Replicas)
	return fmt.Sprintf("FetchedIndex {\n%s}", out)
}
