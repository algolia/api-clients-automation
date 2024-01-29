// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package search

import (
	"encoding/json"
	"fmt"
)

// UserId Unique user ID.
type UserId struct {
	// userID of the user.
	UserID string `json:"userID"`
	// Cluster to which the user is assigned.
	ClusterName string `json:"clusterName"`
	// Number of records belonging to the user.
	NbRecords int32 `json:"nbRecords"`
	// Data size used by the user.
	DataSize int32 `json:"dataSize"`
}

// NewUserId instantiates a new UserId object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewUserId(userID string, clusterName string, nbRecords int32, dataSize int32) *UserId {
	this := &UserId{}
	this.UserID = userID
	this.ClusterName = clusterName
	this.NbRecords = nbRecords
	this.DataSize = dataSize
	return this
}

// NewEmptyUserId return a pointer to an empty UserId object.
func NewEmptyUserId() *UserId {
	return &UserId{}
}

// GetUserID returns the UserID field value.
func (o *UserId) GetUserID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.UserID
}

// GetUserIDOk returns a tuple with the UserID field value
// and a boolean to check if the value has been set.
func (o *UserId) GetUserIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.UserID, true
}

// SetUserID sets field value.
func (o *UserId) SetUserID(v string) *UserId {
	o.UserID = v
	return o
}

// GetClusterName returns the ClusterName field value.
func (o *UserId) GetClusterName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ClusterName
}

// GetClusterNameOk returns a tuple with the ClusterName field value
// and a boolean to check if the value has been set.
func (o *UserId) GetClusterNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ClusterName, true
}

// SetClusterName sets field value.
func (o *UserId) SetClusterName(v string) *UserId {
	o.ClusterName = v
	return o
}

// GetNbRecords returns the NbRecords field value.
func (o *UserId) GetNbRecords() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.NbRecords
}

// GetNbRecordsOk returns a tuple with the NbRecords field value
// and a boolean to check if the value has been set.
func (o *UserId) GetNbRecordsOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.NbRecords, true
}

// SetNbRecords sets field value.
func (o *UserId) SetNbRecords(v int32) *UserId {
	o.NbRecords = v
	return o
}

// GetDataSize returns the DataSize field value.
func (o *UserId) GetDataSize() int32 {
	if o == nil {
		var ret int32
		return ret
	}

	return o.DataSize
}

// GetDataSizeOk returns a tuple with the DataSize field value
// and a boolean to check if the value has been set.
func (o *UserId) GetDataSizeOk() (*int32, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DataSize, true
}

// SetDataSize sets field value.
func (o *UserId) SetDataSize(v int32) *UserId {
	o.DataSize = v
	return o
}

func (o UserId) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["userID"] = o.UserID
	}
	if true {
		toSerialize["clusterName"] = o.ClusterName
	}
	if true {
		toSerialize["nbRecords"] = o.NbRecords
	}
	if true {
		toSerialize["dataSize"] = o.DataSize
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal UserId: %w", err)
	}

	return serialized, nil
}

func (o UserId) String() string {
	out := ""
	out += fmt.Sprintf("  userID=%v\n", o.UserID)
	out += fmt.Sprintf("  clusterName=%v\n", o.ClusterName)
	out += fmt.Sprintf("  nbRecords=%v\n", o.NbRecords)
	out += fmt.Sprintf("  dataSize=%v\n", o.DataSize)
	return fmt.Sprintf("UserId {\n%s}", out)
}

type NullableUserId struct {
	value *UserId
	isSet bool
}

func (v NullableUserId) Get() *UserId {
	return v.value
}

func (v *NullableUserId) Set(val *UserId) {
	v.value = val
	v.isSet = true
}

func (v NullableUserId) IsSet() bool {
	return v.isSet
}

func (v *NullableUserId) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableUserId(val *UserId) *NullableUserId {
	return &NullableUserId{value: val, isSet: true}
}

func (v NullableUserId) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value) //nolint:wrapcheck
}

func (v *NullableUserId) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value) //nolint:wrapcheck
}
