// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package ingestion

import (
	"encoding/json"
	"fmt"
)

// SourceGA4BigQueryExport struct for SourceGA4BigQueryExport.
type SourceGA4BigQueryExport struct {
	// GCP project ID that the BigQuery export writes to.
	ProjectID string `json:"projectID"`
	// BigQuery dataset ID that the BigQuery export writes to.
	DatasetID string `json:"datasetID"`
	// Prefix of the tables that the BigQuery Export writes to.
	TablePrefix string `json:"tablePrefix"`
}

// NewSourceGA4BigQueryExport instantiates a new SourceGA4BigQueryExport object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewSourceGA4BigQueryExport(projectID string, datasetID string, tablePrefix string) *SourceGA4BigQueryExport {
	this := &SourceGA4BigQueryExport{}
	this.ProjectID = projectID
	this.DatasetID = datasetID
	this.TablePrefix = tablePrefix
	return this
}

// NewEmptySourceGA4BigQueryExport return a pointer to an empty SourceGA4BigQueryExport object.
func NewEmptySourceGA4BigQueryExport() *SourceGA4BigQueryExport {
	return &SourceGA4BigQueryExport{}
}

// GetProjectID returns the ProjectID field value.
func (o *SourceGA4BigQueryExport) GetProjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ProjectID
}

// GetProjectIDOk returns a tuple with the ProjectID field value
// and a boolean to check if the value has been set.
func (o *SourceGA4BigQueryExport) GetProjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ProjectID, true
}

// SetProjectID sets field value.
func (o *SourceGA4BigQueryExport) SetProjectID(v string) *SourceGA4BigQueryExport {
	o.ProjectID = v
	return o
}

// GetDatasetID returns the DatasetID field value.
func (o *SourceGA4BigQueryExport) GetDatasetID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.DatasetID
}

// GetDatasetIDOk returns a tuple with the DatasetID field value
// and a boolean to check if the value has been set.
func (o *SourceGA4BigQueryExport) GetDatasetIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.DatasetID, true
}

// SetDatasetID sets field value.
func (o *SourceGA4BigQueryExport) SetDatasetID(v string) *SourceGA4BigQueryExport {
	o.DatasetID = v
	return o
}

// GetTablePrefix returns the TablePrefix field value.
func (o *SourceGA4BigQueryExport) GetTablePrefix() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.TablePrefix
}

// GetTablePrefixOk returns a tuple with the TablePrefix field value
// and a boolean to check if the value has been set.
func (o *SourceGA4BigQueryExport) GetTablePrefixOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.TablePrefix, true
}

// SetTablePrefix sets field value.
func (o *SourceGA4BigQueryExport) SetTablePrefix(v string) *SourceGA4BigQueryExport {
	o.TablePrefix = v
	return o
}

func (o SourceGA4BigQueryExport) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	if true {
		toSerialize["projectID"] = o.ProjectID
	}
	if true {
		toSerialize["datasetID"] = o.DatasetID
	}
	if true {
		toSerialize["tablePrefix"] = o.TablePrefix
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal SourceGA4BigQueryExport: %w", err)
	}

	return serialized, nil
}

func (o SourceGA4BigQueryExport) String() string {
	out := ""
	out += fmt.Sprintf("  projectID=%v\n", o.ProjectID)
	out += fmt.Sprintf("  datasetID=%v\n", o.DatasetID)
	out += fmt.Sprintf("  tablePrefix=%v\n", o.TablePrefix)
	return fmt.Sprintf("SourceGA4BigQueryExport {\n%s}", out)
}
