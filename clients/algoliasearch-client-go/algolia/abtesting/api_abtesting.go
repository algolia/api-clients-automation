// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
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

type Option struct {
	optionType string
	name       string
	value      string
}

func QueryParamOption(name string, val any) Option {
	return Option{
		optionType: "query",
		name:       queryParameterToString(name),
		value:      queryParameterToString(val),
	}
}

func HeaderParamOption(name string, val any) Option {
	return Option{
		optionType: "header",
		name:       name,
		value:      parameterToString(val),
	}
}

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
AddABTests Wraps AddABTestsWithContext using context.Background.

Creates an A/B test.

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiAddABTestsRequest with parameters below.

	@param addABTestsRequest AddABTestsRequest
	@return ABTestResponse
*/
func (c *APIClient) AddABTests(r ApiAddABTestsRequest, opts ...Option) (*ABTestResponse, error) {
	return c.AddABTestsWithContext(context.Background(), r, opts...)
}

/*
AddABTests

Creates an A/B test.

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiAddABTestsRequest with parameters below.

	@param addABTestsRequest AddABTestsRequest
	@return ABTestResponse
*/
func (c *APIClient) AddABTestsWithContext(ctx context.Context, r ApiAddABTestsRequest, opts ...Option) (*ABTestResponse, error) {
	var (
		postBody    any
		returnValue *ABTestResponse
	)

	requestPath := "/2/abtests"

	headers := make(map[string]string)
	queryParams := url.Values{}

	if r.addABTestsRequest == nil {
		return returnValue, reportError("Parameter `addABTestsRequest` is required when calling `AddABTests`.")
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	// body params
	postBody = r.addABTestsRequest
	req, err := c.prepareRequest(ctx, requestPath, http.MethodPost, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
	parameters map[string]interface{}
}

// NewApiCustomDeleteRequest creates an instance of the ApiCustomDeleteRequest to be used for the API call.
func (c *APIClient) NewApiCustomDeleteRequest(path string) ApiCustomDeleteRequest {
	return ApiCustomDeleteRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomDeleteRequest and returns the request for chaining.
func (r ApiCustomDeleteRequest) WithParameters(parameters map[string]interface{}) ApiCustomDeleteRequest {
	r.parameters = parameters
	return r
}

/*
CustomDelete Wraps CustomDeleteWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@return map[string]interface{}
*/
func (c *APIClient) CustomDelete(r ApiCustomDeleteRequest, opts ...Option) (map[string]interface{}, error) {
	return c.CustomDeleteWithContext(context.Background(), r, opts...)
}

/*
CustomDelete

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@return map[string]interface{}
*/
func (c *APIClient) CustomDeleteWithContext(ctx context.Context, r ApiCustomDeleteRequest, opts ...Option) (map[string]interface{}, error) {
	var (
		postBody    any
		returnValue map[string]interface{}
	)

	requestPath := "/1{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", parameterToString(r.path))

	headers := make(map[string]string)
	queryParams := url.Values{}
	if r.path == "" {
		return returnValue, reportError("Parameter `path` is required when calling `CustomDelete`.")
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			queryParams.Set(k, queryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodDelete, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
	parameters map[string]interface{}
}

// NewApiCustomGetRequest creates an instance of the ApiCustomGetRequest to be used for the API call.
func (c *APIClient) NewApiCustomGetRequest(path string) ApiCustomGetRequest {
	return ApiCustomGetRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomGetRequest and returns the request for chaining.
func (r ApiCustomGetRequest) WithParameters(parameters map[string]interface{}) ApiCustomGetRequest {
	r.parameters = parameters
	return r
}

/*
CustomGet Wraps CustomGetWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@return map[string]interface{}
*/
func (c *APIClient) CustomGet(r ApiCustomGetRequest, opts ...Option) (map[string]interface{}, error) {
	return c.CustomGetWithContext(context.Background(), r, opts...)
}

/*
CustomGet

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@return map[string]interface{}
*/
func (c *APIClient) CustomGetWithContext(ctx context.Context, r ApiCustomGetRequest, opts ...Option) (map[string]interface{}, error) {
	var (
		postBody    any
		returnValue map[string]interface{}
	)

	requestPath := "/1{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", parameterToString(r.path))

	headers := make(map[string]string)
	queryParams := url.Values{}
	if r.path == "" {
		return returnValue, reportError("Parameter `path` is required when calling `CustomGet`.")
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			queryParams.Set(k, queryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodGet, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
	parameters map[string]interface{}
	body       map[string]interface{}
}

// NewApiCustomPostRequest creates an instance of the ApiCustomPostRequest to be used for the API call.
func (c *APIClient) NewApiCustomPostRequest(path string) ApiCustomPostRequest {
	return ApiCustomPostRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomPostRequest and returns the request for chaining.
func (r ApiCustomPostRequest) WithParameters(parameters map[string]interface{}) ApiCustomPostRequest {
	r.parameters = parameters
	return r
}

// WithBody adds the body to the ApiCustomPostRequest and returns the request for chaining.
func (r ApiCustomPostRequest) WithBody(body map[string]interface{}) ApiCustomPostRequest {
	r.body = body
	return r
}

/*
CustomPost Wraps CustomPostWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@param body map[string]interface{} - Parameters to send with the custom request.
	@return map[string]interface{}
*/
func (c *APIClient) CustomPost(r ApiCustomPostRequest, opts ...Option) (map[string]interface{}, error) {
	return c.CustomPostWithContext(context.Background(), r, opts...)
}

/*
CustomPost

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@param body map[string]interface{} - Parameters to send with the custom request.
	@return map[string]interface{}
*/
func (c *APIClient) CustomPostWithContext(ctx context.Context, r ApiCustomPostRequest, opts ...Option) (map[string]interface{}, error) {
	var (
		postBody    any
		returnValue map[string]interface{}
	)

	requestPath := "/1{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", parameterToString(r.path))

	headers := make(map[string]string)
	queryParams := url.Values{}
	if r.path == "" {
		return returnValue, reportError("Parameter `path` is required when calling `CustomPost`.")
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			queryParams.Set(k, queryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(ctx, requestPath, http.MethodPost, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
	parameters map[string]interface{}
	body       map[string]interface{}
}

// NewApiCustomPutRequest creates an instance of the ApiCustomPutRequest to be used for the API call.
func (c *APIClient) NewApiCustomPutRequest(path string) ApiCustomPutRequest {
	return ApiCustomPutRequest{
		path: path,
	}
}

// WithParameters adds the parameters to the ApiCustomPutRequest and returns the request for chaining.
func (r ApiCustomPutRequest) WithParameters(parameters map[string]interface{}) ApiCustomPutRequest {
	r.parameters = parameters
	return r
}

// WithBody adds the body to the ApiCustomPutRequest and returns the request for chaining.
func (r ApiCustomPutRequest) WithBody(body map[string]interface{}) ApiCustomPutRequest {
	r.body = body
	return r
}

/*
CustomPut Wraps CustomPutWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@param body map[string]interface{} - Parameters to send with the custom request.
	@return map[string]interface{}
*/
func (c *APIClient) CustomPut(r ApiCustomPutRequest, opts ...Option) (map[string]interface{}, error) {
	return c.CustomPutWithContext(context.Background(), r, opts...)
}

/*
CustomPut

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]interface{} - Query parameters to apply to the current query.
	@param body map[string]interface{} - Parameters to send with the custom request.
	@return map[string]interface{}
*/
func (c *APIClient) CustomPutWithContext(ctx context.Context, r ApiCustomPutRequest, opts ...Option) (map[string]interface{}, error) {
	var (
		postBody    any
		returnValue map[string]interface{}
	)

	requestPath := "/1{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", parameterToString(r.path))

	headers := make(map[string]string)
	queryParams := url.Values{}
	if r.path == "" {
		return returnValue, reportError("Parameter `path` is required when calling `CustomPut`.")
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			queryParams.Set(k, queryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(ctx, requestPath, http.MethodPut, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
DeleteABTest Wraps DeleteABTestWithContext using context.Background.

Delete an A/B test.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiDeleteABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTestResponse
*/
func (c *APIClient) DeleteABTest(r ApiDeleteABTestRequest, opts ...Option) (*ABTestResponse, error) {
	return c.DeleteABTestWithContext(context.Background(), r, opts...)
}

/*
DeleteABTest

Delete an A/B test.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiDeleteABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTestResponse
*/
func (c *APIClient) DeleteABTestWithContext(ctx context.Context, r ApiDeleteABTestRequest, opts ...Option) (*ABTestResponse, error) {
	var (
		postBody    any
		returnValue *ABTestResponse
	)

	requestPath := "/2/abtests/{id}"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(parameterToString(r.id)))

	headers := make(map[string]string)
	queryParams := url.Values{}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodDelete, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
GetABTest Wraps GetABTestWithContext using context.Background.

Get specific details for an A/B test.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiGetABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTest
*/
func (c *APIClient) GetABTest(r ApiGetABTestRequest, opts ...Option) (*ABTest, error) {
	return c.GetABTestWithContext(context.Background(), r, opts...)
}

/*
GetABTest

Get specific details for an A/B test.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiGetABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTest
*/
func (c *APIClient) GetABTestWithContext(ctx context.Context, r ApiGetABTestRequest, opts ...Option) (*ABTest, error) {
	var (
		postBody    any
		returnValue *ABTest
	)

	requestPath := "/2/abtests/{id}"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(parameterToString(r.id)))

	headers := make(map[string]string)
	queryParams := url.Values{}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodGet, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
ListABTests Wraps ListABTestsWithContext using context.Background.

List all A/B tests.

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiListABTestsRequest with parameters below.

	@param offset int32 - Position of the starting record. Used for paging. 0 is the first record.
	@param limit int32 - Number of records to return (page size).
	@param indexPrefix string - Only return A/B tests for indices starting with this prefix.
	@param indexSuffix string - Only return A/B tests for indices ending with this suffix.
	@return ListABTestsResponse
*/
func (c *APIClient) ListABTests(r ApiListABTestsRequest, opts ...Option) (*ListABTestsResponse, error) {
	return c.ListABTestsWithContext(context.Background(), r, opts...)
}

/*
ListABTests

List all A/B tests.

Required API Key ACLs:
  - analytics

Request can be constructed by NewApiListABTestsRequest with parameters below.

	@param offset int32 - Position of the starting record. Used for paging. 0 is the first record.
	@param limit int32 - Number of records to return (page size).
	@param indexPrefix string - Only return A/B tests for indices starting with this prefix.
	@param indexSuffix string - Only return A/B tests for indices ending with this suffix.
	@return ListABTestsResponse
*/
func (c *APIClient) ListABTestsWithContext(ctx context.Context, r ApiListABTestsRequest, opts ...Option) (*ListABTestsResponse, error) {
	var (
		postBody    any
		returnValue *ListABTestsResponse
	)

	requestPath := "/2/abtests"

	headers := make(map[string]string)
	queryParams := url.Values{}

	if !utils.IsNilOrEmpty(r.offset) {
		queryParams.Set("offset", queryParameterToString(*r.offset))
	}
	if !utils.IsNilOrEmpty(r.limit) {
		queryParams.Set("limit", queryParameterToString(*r.limit))
	}
	if !utils.IsNilOrEmpty(r.indexPrefix) {
		queryParams.Set("indexPrefix", queryParameterToString(*r.indexPrefix))
	}
	if !utils.IsNilOrEmpty(r.indexSuffix) {
		queryParams.Set("indexSuffix", queryParameterToString(*r.indexSuffix))
	}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodGet, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
StopABTest Wraps StopABTestWithContext using context.Background.

If stopped, the test is over and can't be restarted. There is now only one index, receiving 100% of all search requests.
The data gathered for stopped A/B tests is retained.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiStopABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTestResponse
*/
func (c *APIClient) StopABTest(r ApiStopABTestRequest, opts ...Option) (*ABTestResponse, error) {
	return c.StopABTestWithContext(context.Background(), r, opts...)
}

/*
StopABTest

If stopped, the test is over and can't be restarted. There is now only one index, receiving 100% of all search requests.
The data gathered for stopped A/B tests is retained.
To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).

Required API Key ACLs:
  - editSettings

Request can be constructed by NewApiStopABTestRequest with parameters below.

	@param id int32 - Unique A/B test ID.
	@return ABTestResponse
*/
func (c *APIClient) StopABTestWithContext(ctx context.Context, r ApiStopABTestRequest, opts ...Option) (*ABTestResponse, error) {
	var (
		postBody    any
		returnValue *ABTestResponse
	)

	requestPath := "/2/abtests/{id}/stop"
	requestPath = strings.ReplaceAll(requestPath, "{id}", url.PathEscape(parameterToString(r.id)))

	headers := make(map[string]string)
	queryParams := url.Values{}

	// optional params if any
	for _, opt := range opts {
		switch opt.optionType {
		case "query":
			queryParams.Set(opt.name, opt.value)
		case "header":
			headers[opt.name] = opt.value
		}
	}

	req, err := c.prepareRequest(ctx, requestPath, http.MethodPost, postBody, headers, queryParams)
	if err != nil {
		return returnValue, err
	}

	res, resBody, err := c.callAPI(req, false)
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
