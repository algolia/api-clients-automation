// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package abtesting

import (
	"context"
	"encoding/json"
	"fmt"
	"net/http"
	"net/url"
	"strings"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

func (r *ApiAddABTestsRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["addABTestsRequest"]; ok {
		err = json.Unmarshal(v, &r.addABTestsRequest)
		if err != nil {
			err = json.Unmarshal(b, &r.addABTestsRequest)
			if err != nil {
				return fmt.Errorf("cannot unmarshal addABTestsRequest: %w", err)
			}
		}
	} else {
		err = json.Unmarshal(b, &r.addABTestsRequest)
		if err != nil {
			return fmt.Errorf("cannot unmarshal body parameter addABTestsRequest: %w", err)
		}
	}

	return nil
}

// ApiAddABTestsRequest represents the request with all the parameters for the API call.
type ApiAddABTestsRequest struct {
	addABTestsRequest *AddABTestsRequest
}

// NewApiAddABTestsRequest creates an instance of the ApiAddABTestsRequest to be used for the API call.
func (c *APIClient) NewApiAddABTestsRequest(addABTestsRequest *AddABTestsRequest) ApiAddABTestsRequest {
	return ApiAddABTestsRequest{
		addABTestsRequest: addABTestsRequest,
	}
}

/*
AddABTests calls the API and returns the raw response from it.

	  Creates a new A/B test.

	    Required API Key ACLs:
	    - editSettings

	Request can be constructed by NewApiAddABTestsRequest with parameters below.
	  @param addABTestsRequest AddABTestsRequest
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) AddABTestsWithHTTPInfo(r ApiAddABTestsRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/2/abtests"

	if r.addABTestsRequest == nil {
		return nil, nil, reportError("Parameter `addABTestsRequest` is required when calling `AddABTests`.")
	}

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	// body params
	postBody = r.addABTestsRequest
	req, err := c.prepareRequest(options.Context, requestPath, http.MethodPost, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
AddABTests casts the HTTP response body to a defined struct.

Creates a new A/B test.

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiAddABTestsRequest with parameters below.

	@param addABTestsRequest AddABTestsRequest
	@return ABTestResponse
*/
func (c *APIClient) AddABTests(r ApiAddABTestsRequest, opts ...utils.RequestOption) (*ABTestResponse, error) {
	var returnValue *ABTestResponse

	res, resBody, err := c.AddABTestsWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiCustomDeleteRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["path"]; ok {
		err = json.Unmarshal(v, &r.path)
		if err != nil {
			err = json.Unmarshal(b, &r.path)
			if err != nil {
				return fmt.Errorf("cannot unmarshal path: %w", err)
			}
		}
	}
	if v, ok := req["parameters"]; ok {
		err = json.Unmarshal(v, &r.parameters)
		if err != nil {
			err = json.Unmarshal(b, &r.parameters)
			if err != nil {
				return fmt.Errorf("cannot unmarshal parameters: %w", err)
			}
		}
	}

	return nil
}

// ApiCustomDeleteRequest represents the request with all the parameters for the API call.
type ApiCustomDeleteRequest struct {
	path       string
	parameters map[string]any
}

// NewApiCustomDeleteRequest creates an instance of the ApiCustomDeleteRequest to be used for the API call.
func (c *APIClient) NewApiCustomDeleteRequest(path string) ApiCustomDeleteRequest {
	return ApiCustomDeleteRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomDeleteRequest and returns the request for chaining.
func (r ApiCustomDeleteRequest) WithParameters(parameters map[string]any) ApiCustomDeleteRequest {
	r.parameters = parameters
	return r
}

/*
CustomDelete calls the API and returns the raw response from it.

	  This method allow you to send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomDeleteRequest with parameters below.
	  @param path string - Path of the endpoint, anything after \"/1\" must be specified.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomDeleteWithHTTPInfo(r ApiCustomDeleteRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomDelete`.")
	}

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			options.QueryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodDelete, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
CustomDelete casts the HTTP response body to a defined struct.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomDelete(r ApiCustomDeleteRequest, opts ...utils.RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomDeleteWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiCustomGetRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["path"]; ok {
		err = json.Unmarshal(v, &r.path)
		if err != nil {
			err = json.Unmarshal(b, &r.path)
			if err != nil {
				return fmt.Errorf("cannot unmarshal path: %w", err)
			}
		}
	}
	if v, ok := req["parameters"]; ok {
		err = json.Unmarshal(v, &r.parameters)
		if err != nil {
			err = json.Unmarshal(b, &r.parameters)
			if err != nil {
				return fmt.Errorf("cannot unmarshal parameters: %w", err)
			}
		}
	}

	return nil
}

// ApiCustomGetRequest represents the request with all the parameters for the API call.
type ApiCustomGetRequest struct {
	path       string
	parameters map[string]any
}

// NewApiCustomGetRequest creates an instance of the ApiCustomGetRequest to be used for the API call.
func (c *APIClient) NewApiCustomGetRequest(path string) ApiCustomGetRequest {
	return ApiCustomGetRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomGetRequest and returns the request for chaining.
func (r ApiCustomGetRequest) WithParameters(parameters map[string]any) ApiCustomGetRequest {
	r.parameters = parameters
	return r
}

/*
CustomGet calls the API and returns the raw response from it.

	  This method allow you to send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomGetRequest with parameters below.
	  @param path string - Path of the endpoint, anything after \"/1\" must be specified.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomGetWithHTTPInfo(r ApiCustomGetRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomGet`.")
	}

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			options.QueryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodGet, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
CustomGet casts the HTTP response body to a defined struct.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomGet(r ApiCustomGetRequest, opts ...utils.RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomGetWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiCustomPostRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["path"]; ok {
		err = json.Unmarshal(v, &r.path)
		if err != nil {
			err = json.Unmarshal(b, &r.path)
			if err != nil {
				return fmt.Errorf("cannot unmarshal path: %w", err)
			}
		}
	}
	if v, ok := req["parameters"]; ok {
		err = json.Unmarshal(v, &r.parameters)
		if err != nil {
			err = json.Unmarshal(b, &r.parameters)
			if err != nil {
				return fmt.Errorf("cannot unmarshal parameters: %w", err)
			}
		}
	}
	if v, ok := req["body"]; ok {
		err = json.Unmarshal(v, &r.body)
		if err != nil {
			err = json.Unmarshal(b, &r.body)
			if err != nil {
				return fmt.Errorf("cannot unmarshal body: %w", err)
			}
		}
	}

	return nil
}

// ApiCustomPostRequest represents the request with all the parameters for the API call.
type ApiCustomPostRequest struct {
	path       string
	parameters map[string]any
	body       map[string]any
}

// NewApiCustomPostRequest creates an instance of the ApiCustomPostRequest to be used for the API call.
func (c *APIClient) NewApiCustomPostRequest(path string) ApiCustomPostRequest {
	return ApiCustomPostRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomPostRequest and returns the request for chaining.
func (r ApiCustomPostRequest) WithParameters(parameters map[string]any) ApiCustomPostRequest {
	r.parameters = parameters
	return r
}

// WithBody adds the body to the ApiCustomPostRequest and returns the request for chaining.
func (r ApiCustomPostRequest) WithBody(body map[string]any) ApiCustomPostRequest {
	r.body = body
	return r
}

/*
CustomPost calls the API and returns the raw response from it.

	  This method allow you to send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomPostRequest with parameters below.
	  @param path string - Path of the endpoint, anything after \"/1\" must be specified.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	  @param body map[string]any - Parameters to send with the custom request.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomPostWithHTTPInfo(r ApiCustomPostRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomPost`.")
	}

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			options.QueryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(options.Context, requestPath, http.MethodPost, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
CustomPost casts the HTTP response body to a defined struct.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPost(r ApiCustomPostRequest, opts ...utils.RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomPostWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiCustomPutRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["path"]; ok {
		err = json.Unmarshal(v, &r.path)
		if err != nil {
			err = json.Unmarshal(b, &r.path)
			if err != nil {
				return fmt.Errorf("cannot unmarshal path: %w", err)
			}
		}
	}
	if v, ok := req["parameters"]; ok {
		err = json.Unmarshal(v, &r.parameters)
		if err != nil {
			err = json.Unmarshal(b, &r.parameters)
			if err != nil {
				return fmt.Errorf("cannot unmarshal parameters: %w", err)
			}
		}
	}
	if v, ok := req["body"]; ok {
		err = json.Unmarshal(v, &r.body)
		if err != nil {
			err = json.Unmarshal(b, &r.body)
			if err != nil {
				return fmt.Errorf("cannot unmarshal body: %w", err)
			}
		}
	}

	return nil
}

// ApiCustomPutRequest represents the request with all the parameters for the API call.
type ApiCustomPutRequest struct {
	path       string
	parameters map[string]any
	body       map[string]any
}

// NewApiCustomPutRequest creates an instance of the ApiCustomPutRequest to be used for the API call.
func (c *APIClient) NewApiCustomPutRequest(path string) ApiCustomPutRequest {
	return ApiCustomPutRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomPutRequest and returns the request for chaining.
func (r ApiCustomPutRequest) WithParameters(parameters map[string]any) ApiCustomPutRequest {
	r.parameters = parameters
	return r
}

// WithBody adds the body to the ApiCustomPutRequest and returns the request for chaining.
func (r ApiCustomPutRequest) WithBody(body map[string]any) ApiCustomPutRequest {
	r.body = body
	return r
}

/*
CustomPut calls the API and returns the raw response from it.

	  This method allow you to send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomPutRequest with parameters below.
	  @param path string - Path of the endpoint, anything after \"/1\" must be specified.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	  @param body map[string]any - Parameters to send with the custom request.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomPutWithHTTPInfo(r ApiCustomPutRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomPut`.")
	}

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			options.QueryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(options.Context, requestPath, http.MethodPut, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
CustomPut casts the HTTP response body to a defined struct.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPut(r ApiCustomPutRequest, opts ...utils.RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomPutWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiDeleteABTestRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["id"]; ok {
		err = json.Unmarshal(v, &r.id)
		if err != nil {
			err = json.Unmarshal(b, &r.id)
			if err != nil {
				return fmt.Errorf("cannot unmarshal id: %w", err)
			}
		}
	}

	return nil
}

// ApiDeleteABTestRequest represents the request with all the parameters for the API call.
type ApiDeleteABTestRequest struct {
	id int32
}

// NewApiDeleteABTestRequest creates an instance of the ApiDeleteABTestRequest to be used for the API call.
func (c *APIClient) NewApiDeleteABTestRequest(id int32) ApiDeleteABTestRequest {
	return ApiDeleteABTestRequest{
		id: id,
	}
}

/*
DeleteABTest calls the API and returns the raw response from it.

	  Deletes an A/B test by its ID.

	    Required API Key ACLs:
	    - editSettings

	Request can be constructed by NewApiDeleteABTestRequest with parameters below.
	  @param id int32 - Unique A/B test identifier.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) DeleteABTestWithHTTPInfo(r ApiDeleteABTestRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/2/abtests/{id}"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(utils.ParameterToString(r.id)))

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodDelete, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
DeleteABTest casts the HTTP response body to a defined struct.

Deletes an A/B test by its ID.

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiDeleteABTestRequest with parameters below.

	@param id int32 - Unique A/B test identifier.
	@return ABTestResponse
*/
func (c *APIClient) DeleteABTest(r ApiDeleteABTestRequest, opts ...utils.RequestOption) (*ABTestResponse, error) {
	var returnValue *ABTestResponse

	res, resBody, err := c.DeleteABTestWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiGetABTestRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["id"]; ok {
		err = json.Unmarshal(v, &r.id)
		if err != nil {
			err = json.Unmarshal(b, &r.id)
			if err != nil {
				return fmt.Errorf("cannot unmarshal id: %w", err)
			}
		}
	}

	return nil
}

// ApiGetABTestRequest represents the request with all the parameters for the API call.
type ApiGetABTestRequest struct {
	id int32
}

// NewApiGetABTestRequest creates an instance of the ApiGetABTestRequest to be used for the API call.
func (c *APIClient) NewApiGetABTestRequest(id int32) ApiGetABTestRequest {
	return ApiGetABTestRequest{
		id: id,
	}
}

/*
GetABTest calls the API and returns the raw response from it.

	  Retrieves the details for an A/B test by its ID.

	    Required API Key ACLs:
	    - analytics

	Request can be constructed by NewApiGetABTestRequest with parameters below.
	  @param id int32 - Unique A/B test identifier.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) GetABTestWithHTTPInfo(r ApiGetABTestRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/2/abtests/{id}"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(utils.ParameterToString(r.id)))

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodGet, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
GetABTest casts the HTTP response body to a defined struct.

Retrieves the details for an A/B test by its ID.

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiGetABTestRequest with parameters below.

	@param id int32 - Unique A/B test identifier.
	@return ABTest
*/
func (c *APIClient) GetABTest(r ApiGetABTestRequest, opts ...utils.RequestOption) (*ABTest, error) {
	var returnValue *ABTest

	res, resBody, err := c.GetABTestWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiListABTestsRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["offset"]; ok {
		err = json.Unmarshal(v, &r.offset)
		if err != nil {
			err = json.Unmarshal(b, &r.offset)
			if err != nil {
				return fmt.Errorf("cannot unmarshal offset: %w", err)
			}
		}
	}
	if v, ok := req["limit"]; ok {
		err = json.Unmarshal(v, &r.limit)
		if err != nil {
			err = json.Unmarshal(b, &r.limit)
			if err != nil {
				return fmt.Errorf("cannot unmarshal limit: %w", err)
			}
		}
	}
	if v, ok := req["indexPrefix"]; ok {
		err = json.Unmarshal(v, &r.indexPrefix)
		if err != nil {
			err = json.Unmarshal(b, &r.indexPrefix)
			if err != nil {
				return fmt.Errorf("cannot unmarshal indexPrefix: %w", err)
			}
		}
	}
	if v, ok := req["indexSuffix"]; ok {
		err = json.Unmarshal(v, &r.indexSuffix)
		if err != nil {
			err = json.Unmarshal(b, &r.indexSuffix)
			if err != nil {
				return fmt.Errorf("cannot unmarshal indexSuffix: %w", err)
			}
		}
	}

	return nil
}

// ApiListABTestsRequest represents the request with all the parameters for the API call.
type ApiListABTestsRequest struct {
	offset      *int32
	limit       *int32
	indexPrefix *string
	indexSuffix *string
}

// NewApiListABTestsRequest creates an instance of the ApiListABTestsRequest to be used for the API call.
func (c *APIClient) NewApiListABTestsRequest() ApiListABTestsRequest {
	return ApiListABTestsRequest{}
}

// WithOffset adds the offset to the ApiListABTestsRequest and returns the request for chaining.
func (r ApiListABTestsRequest) WithOffset(offset int32) ApiListABTestsRequest {
	r.offset = &offset
	return r
}

// WithLimit adds the limit to the ApiListABTestsRequest and returns the request for chaining.
func (r ApiListABTestsRequest) WithLimit(limit int32) ApiListABTestsRequest {
	r.limit = &limit
	return r
}

// WithIndexPrefix adds the indexPrefix to the ApiListABTestsRequest and returns the request for chaining.
func (r ApiListABTestsRequest) WithIndexPrefix(indexPrefix string) ApiListABTestsRequest {
	r.indexPrefix = &indexPrefix
	return r
}

// WithIndexSuffix adds the indexSuffix to the ApiListABTestsRequest and returns the request for chaining.
func (r ApiListABTestsRequest) WithIndexSuffix(indexSuffix string) ApiListABTestsRequest {
	r.indexSuffix = &indexSuffix
	return r
}

/*
ListABTests calls the API and returns the raw response from it.

	  Lists all A/B tests you configured for this application.

	    Required API Key ACLs:
	    - analytics

	Request can be constructed by NewApiListABTestsRequest with parameters below.
	  @param offset int32 - Position of the first item to return.
	  @param limit int32 - Number of items to return.
	  @param indexPrefix string - Index name prefix. Only A/B tests for indices starting with this string are included in the response.
	  @param indexSuffix string - Index name suffix. Only A/B tests for indices ending with this string are included in the response.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) ListABTestsWithHTTPInfo(r ApiListABTestsRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/2/abtests"

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.offset) {
		options.QueryParams.Set("offset", utils.QueryParameterToString(*r.offset))
	}
	if !utils.IsNilOrEmpty(r.limit) {
		options.QueryParams.Set("limit", utils.QueryParameterToString(*r.limit))
	}
	if !utils.IsNilOrEmpty(r.indexPrefix) {
		options.QueryParams.Set("indexPrefix", utils.QueryParameterToString(*r.indexPrefix))
	}
	if !utils.IsNilOrEmpty(r.indexSuffix) {
		options.QueryParams.Set("indexSuffix", utils.QueryParameterToString(*r.indexSuffix))
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodGet, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
ListABTests casts the HTTP response body to a defined struct.

Lists all A/B tests you configured for this application.

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiListABTestsRequest with parameters below.

	@param offset int32 - Position of the first item to return.
	@param limit int32 - Number of items to return.
	@param indexPrefix string - Index name prefix. Only A/B tests for indices starting with this string are included in the response.
	@param indexSuffix string - Index name suffix. Only A/B tests for indices ending with this string are included in the response.
	@return ListABTestsResponse
*/
func (c *APIClient) ListABTests(r ApiListABTestsRequest, opts ...utils.RequestOption) (*ListABTestsResponse, error) {
	var returnValue *ListABTestsResponse

	res, resBody, err := c.ListABTestsWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}

func (r *ApiStopABTestRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["id"]; ok {
		err = json.Unmarshal(v, &r.id)
		if err != nil {
			err = json.Unmarshal(b, &r.id)
			if err != nil {
				return fmt.Errorf("cannot unmarshal id: %w", err)
			}
		}
	}

	return nil
}

// ApiStopABTestRequest represents the request with all the parameters for the API call.
type ApiStopABTestRequest struct {
	id int32
}

// NewApiStopABTestRequest creates an instance of the ApiStopABTestRequest to be used for the API call.
func (c *APIClient) NewApiStopABTestRequest(id int32) ApiStopABTestRequest {
	return ApiStopABTestRequest{
		id: id,
	}
}

/*
StopABTest calls the API and returns the raw response from it.

	Stops an A/B test by its ID.

You can't restart stopped A/B tests.

	    Required API Key ACLs:
	    - editSettings

	Request can be constructed by NewApiStopABTestRequest with parameters below.
	  @param id int32 - Unique A/B test identifier.
	@param opts ...Option - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) StopABTestWithHTTPInfo(r ApiStopABTestRequest, opts ...utils.RequestOption) (*http.Response, []byte, error) {
	requestPath := "/2/abtests/{id}/stop"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(utils.ParameterToString(r.id)))

	options := utils.Options{
		Context:      context.Background(),
		QueryParams:  url.Values{},
		HeaderParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.Apply(&options)
	}

	var postBody any

	req, err := c.prepareRequest(options.Context, requestPath, http.MethodPost, postBody, options.HeaderParams, options.QueryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false)
}

/*
StopABTest casts the HTTP response body to a defined struct.

Stops an A/B test by its ID.

You can't restart stopped A/B tests.

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiStopABTestRequest with parameters below.

	@param id int32 - Unique A/B test identifier.
	@return ABTestResponse
*/
func (c *APIClient) StopABTest(r ApiStopABTestRequest, opts ...utils.RequestOption) (*ABTestResponse, error) {
	var returnValue *ABTestResponse

	res, resBody, err := c.StopABTestWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		newErr := &APIError{
			Message: string(resBody),
			Status:  res.StatusCode,
		}

		var v ErrorBase
		err = c.decode(&v, resBody)
		if err != nil {
			newErr.Message = err.Error()
			return returnValue, newErr
		}

		return returnValue, newErr
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}
