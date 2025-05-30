// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package recommend

import (
	"encoding/json"
	"fmt"
)

// LookingSimilarQuery struct for LookingSimilarQuery.
type LookingSimilarQuery struct {
	// Index name (case-sensitive).
	IndexName string `json:"indexName"`
	// Minimum score a recommendation must have to be included in the response.
	Threshold float64 `json:"threshold"`
	// Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.
	MaxRecommendations *int32                 `json:"maxRecommendations,omitempty"`
	QueryParameters    *RecommendSearchParams `json:"queryParameters,omitempty"`
	Model              LookingSimilarModel    `json:"model"`
	// Unique record identifier.
	ObjectID           string          `json:"objectID"`
	FallbackParameters *FallbackParams `json:"fallbackParameters,omitempty"`
}

type LookingSimilarQueryOption func(f *LookingSimilarQuery)

func WithLookingSimilarQueryMaxRecommendations(val int32) LookingSimilarQueryOption {
	return func(f *LookingSimilarQuery) {
		f.MaxRecommendations = &val
	}
}

func WithLookingSimilarQueryQueryParameters(val RecommendSearchParams) LookingSimilarQueryOption {
	return func(f *LookingSimilarQuery) {
		f.QueryParameters = &val
	}
}

func WithLookingSimilarQueryFallbackParameters(val FallbackParams) LookingSimilarQueryOption {
	return func(f *LookingSimilarQuery) {
		f.FallbackParameters = &val
	}
}

// NewLookingSimilarQuery instantiates a new LookingSimilarQuery object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed.
func NewLookingSimilarQuery(indexName string, threshold float64, model LookingSimilarModel, objectID string, opts ...LookingSimilarQueryOption) *LookingSimilarQuery {
	this := &LookingSimilarQuery{}
	this.IndexName = indexName
	this.Threshold = threshold
	this.Model = model
	this.ObjectID = objectID
	for _, opt := range opts {
		opt(this)
	}
	return this
}

// NewEmptyLookingSimilarQuery return a pointer to an empty LookingSimilarQuery object.
func NewEmptyLookingSimilarQuery() *LookingSimilarQuery {
	return &LookingSimilarQuery{}
}

// GetIndexName returns the IndexName field value.
func (o *LookingSimilarQuery) GetIndexName() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.IndexName
}

// GetIndexNameOk returns a tuple with the IndexName field value
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetIndexNameOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.IndexName, true
}

// SetIndexName sets field value.
func (o *LookingSimilarQuery) SetIndexName(v string) *LookingSimilarQuery {
	o.IndexName = v
	return o
}

// GetThreshold returns the Threshold field value.
func (o *LookingSimilarQuery) GetThreshold() float64 {
	if o == nil {
		var ret float64
		return ret
	}

	return o.Threshold
}

// GetThresholdOk returns a tuple with the Threshold field value
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetThresholdOk() (*float64, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Threshold, true
}

// SetThreshold sets field value.
func (o *LookingSimilarQuery) SetThreshold(v float64) *LookingSimilarQuery {
	o.Threshold = v
	return o
}

// GetMaxRecommendations returns the MaxRecommendations field value if set, zero value otherwise.
func (o *LookingSimilarQuery) GetMaxRecommendations() int32 {
	if o == nil || o.MaxRecommendations == nil {
		var ret int32
		return ret
	}
	return *o.MaxRecommendations
}

// GetMaxRecommendationsOk returns a tuple with the MaxRecommendations field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetMaxRecommendationsOk() (*int32, bool) {
	if o == nil || o.MaxRecommendations == nil {
		return nil, false
	}
	return o.MaxRecommendations, true
}

// HasMaxRecommendations returns a boolean if a field has been set.
func (o *LookingSimilarQuery) HasMaxRecommendations() bool {
	if o != nil && o.MaxRecommendations != nil {
		return true
	}

	return false
}

// SetMaxRecommendations gets a reference to the given int32 and assigns it to the MaxRecommendations field.
func (o *LookingSimilarQuery) SetMaxRecommendations(v int32) *LookingSimilarQuery {
	o.MaxRecommendations = &v
	return o
}

// GetQueryParameters returns the QueryParameters field value if set, zero value otherwise.
func (o *LookingSimilarQuery) GetQueryParameters() RecommendSearchParams {
	if o == nil || o.QueryParameters == nil {
		var ret RecommendSearchParams
		return ret
	}
	return *o.QueryParameters
}

// GetQueryParametersOk returns a tuple with the QueryParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetQueryParametersOk() (*RecommendSearchParams, bool) {
	if o == nil || o.QueryParameters == nil {
		return nil, false
	}
	return o.QueryParameters, true
}

// HasQueryParameters returns a boolean if a field has been set.
func (o *LookingSimilarQuery) HasQueryParameters() bool {
	if o != nil && o.QueryParameters != nil {
		return true
	}

	return false
}

// SetQueryParameters gets a reference to the given RecommendSearchParams and assigns it to the QueryParameters field.
func (o *LookingSimilarQuery) SetQueryParameters(v *RecommendSearchParams) *LookingSimilarQuery {
	o.QueryParameters = v
	return o
}

// GetModel returns the Model field value.
func (o *LookingSimilarQuery) GetModel() LookingSimilarModel {
	if o == nil {
		var ret LookingSimilarModel
		return ret
	}

	return o.Model
}

// GetModelOk returns a tuple with the Model field value
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetModelOk() (*LookingSimilarModel, bool) {
	if o == nil {
		return nil, false
	}
	return &o.Model, true
}

// SetModel sets field value.
func (o *LookingSimilarQuery) SetModel(v LookingSimilarModel) *LookingSimilarQuery {
	o.Model = v
	return o
}

// GetObjectID returns the ObjectID field value.
func (o *LookingSimilarQuery) GetObjectID() string {
	if o == nil {
		var ret string
		return ret
	}

	return o.ObjectID
}

// GetObjectIDOk returns a tuple with the ObjectID field value
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetObjectIDOk() (*string, bool) {
	if o == nil {
		return nil, false
	}
	return &o.ObjectID, true
}

// SetObjectID sets field value.
func (o *LookingSimilarQuery) SetObjectID(v string) *LookingSimilarQuery {
	o.ObjectID = v
	return o
}

// GetFallbackParameters returns the FallbackParameters field value if set, zero value otherwise.
func (o *LookingSimilarQuery) GetFallbackParameters() FallbackParams {
	if o == nil || o.FallbackParameters == nil {
		var ret FallbackParams
		return ret
	}
	return *o.FallbackParameters
}

// GetFallbackParametersOk returns a tuple with the FallbackParameters field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *LookingSimilarQuery) GetFallbackParametersOk() (*FallbackParams, bool) {
	if o == nil || o.FallbackParameters == nil {
		return nil, false
	}
	return o.FallbackParameters, true
}

// HasFallbackParameters returns a boolean if a field has been set.
func (o *LookingSimilarQuery) HasFallbackParameters() bool {
	if o != nil && o.FallbackParameters != nil {
		return true
	}

	return false
}

// SetFallbackParameters gets a reference to the given FallbackParams and assigns it to the FallbackParameters field.
func (o *LookingSimilarQuery) SetFallbackParameters(v *FallbackParams) *LookingSimilarQuery {
	o.FallbackParameters = v
	return o
}

func (o LookingSimilarQuery) MarshalJSON() ([]byte, error) {
	toSerialize := map[string]any{}
	toSerialize["indexName"] = o.IndexName
	toSerialize["threshold"] = o.Threshold
	if o.MaxRecommendations != nil {
		toSerialize["maxRecommendations"] = o.MaxRecommendations
	}
	if o.QueryParameters != nil {
		toSerialize["queryParameters"] = o.QueryParameters
	}
	toSerialize["model"] = o.Model
	toSerialize["objectID"] = o.ObjectID
	if o.FallbackParameters != nil {
		toSerialize["fallbackParameters"] = o.FallbackParameters
	}
	serialized, err := json.Marshal(toSerialize)
	if err != nil {
		return nil, fmt.Errorf("failed to marshal LookingSimilarQuery: %w", err)
	}

	return serialized, nil
}

func (o LookingSimilarQuery) String() string {
	out := ""
	out += fmt.Sprintf("  indexName=%v\n", o.IndexName)
	out += fmt.Sprintf("  threshold=%v\n", o.Threshold)
	out += fmt.Sprintf("  maxRecommendations=%v\n", o.MaxRecommendations)
	out += fmt.Sprintf("  queryParameters=%v\n", o.QueryParameters)
	out += fmt.Sprintf("  model=%v\n", o.Model)
	out += fmt.Sprintf("  objectID=%v\n", o.ObjectID)
	out += fmt.Sprintf("  fallbackParameters=%v\n", o.FallbackParameters)
	return fmt.Sprintf("LookingSimilarQuery {\n%s}", out)
}
