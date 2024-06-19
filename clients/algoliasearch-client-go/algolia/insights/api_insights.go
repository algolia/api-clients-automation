// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

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
CustomDelete Wraps CustomDeleteWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomDelete(r ApiCustomDeleteRequest, opts ...Option) (*map[string]any, error) {
	return c.CustomDeleteWithContext(context.Background(), r, opts...)
}

/*
CustomDelete

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomDeleteWithContext(ctx context.Context, r ApiCustomDeleteRequest, opts ...Option) (*map[string]any, error) {
	var (
		postBody    any
		returnValue *map[string]any
	)

	requestPath := "/{path}"
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
CustomGet Wraps CustomGetWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomGet(r ApiCustomGetRequest, opts ...Option) (*map[string]any, error) {
	return c.CustomGetWithContext(context.Background(), r, opts...)
}

/*
CustomGet

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomGetWithContext(ctx context.Context, r ApiCustomGetRequest, opts ...Option) (*map[string]any, error) {
	var (
		postBody    any
		returnValue *map[string]any
	)

	requestPath := "/{path}"
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
CustomPost Wraps CustomPostWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPost(r ApiCustomPostRequest, opts ...Option) (*map[string]any, error) {
	return c.CustomPostWithContext(context.Background(), r, opts...)
}

/*
CustomPost

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPostWithContext(ctx context.Context, r ApiCustomPostRequest, opts ...Option) (*map[string]any, error) {
	var (
		postBody    any
		returnValue *map[string]any
	)

	requestPath := "/{path}"
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
CustomPut Wraps CustomPutWithContext using context.Background.

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPut(r ApiCustomPutRequest, opts ...Option) (*map[string]any, error) {
	return c.CustomPutWithContext(context.Background(), r, opts...)
}

/*
CustomPut

This method allow you to send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, anything after \"/1\" must be specified.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPutWithContext(ctx context.Context, r ApiCustomPutRequest, opts ...Option) (*map[string]any, error) {
	var (
		postBody    any
		returnValue *map[string]any
	)

	requestPath := "/{path}"
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

func (r *ApiDeleteUserTokenRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["userToken"]; ok {
		err = json.Unmarshal(v, &r.userToken)
		if err != nil {
			err = json.Unmarshal(b, &r.userToken)
			if err != nil {
				return fmt.Errorf("cannot unmarshal userToken: %w", err)
			}
		}
	}

	return nil
}

// ApiDeleteUserTokenRequest represents the request with all the parameters for the API call.
type ApiDeleteUserTokenRequest struct {
	userToken string
}

// NewApiDeleteUserTokenRequest creates an instance of the ApiDeleteUserTokenRequest to be used for the API call.
func (c *APIClient) NewApiDeleteUserTokenRequest(userToken string) ApiDeleteUserTokenRequest {
	return ApiDeleteUserTokenRequest{
		userToken: userToken,
	}
}

/*
DeleteUserToken Wraps DeleteUserTokenWithContext using context.Background.

Deletes all events related to the specified user token from events metrics and analytics.
To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile).

Request can be constructed by NewApiDeleteUserTokenRequest with parameters below.

	@param userToken string - User token for which to delete all associated events.
*/
func (c *APIClient) DeleteUserToken(r ApiDeleteUserTokenRequest, opts ...Option) error {
	return c.DeleteUserTokenWithContext(context.Background(), r, opts...)
}

/*
DeleteUserToken

Deletes all events related to the specified user token from events metrics and analytics.
To delete a personalization user profile, see [Delete a user profile](/specs/personalization#tag/profiles/operation/deleteUserProfile).

Request can be constructed by NewApiDeleteUserTokenRequest with parameters below.

	@param userToken string - User token for which to delete all associated events.
*/
func (c *APIClient) DeleteUserTokenWithContext(ctx context.Context, r ApiDeleteUserTokenRequest, opts ...Option) error {
	var postBody any

	requestPath := "/1/usertokens/{userToken}"
	requestPath = strings.ReplaceAll(requestPath, "{userToken}", url.PathEscape(parameterToString(r.userToken)))

	headers := make(map[string]string)
	queryParams := url.Values{}
	if r.userToken == "" {
		return reportError("Parameter `userToken` is required when calling `DeleteUserToken`.")
	}
	if len(r.userToken) < 1 {
		return reportError("userToken must have at least 1 elements")
	}
	if len(r.userToken) > 129 {
		return reportError("userToken must have less than 129 elements")
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
		return err
	}

	res, resBody, err := c.callAPI(req, false)
	if err != nil {
		return err
	}
	if res == nil {
		return reportError("res is nil")
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
			return newErr
		}

		return newErr
	}

	return nil
}

func (r *ApiPushEventsRequest) UnmarshalJSON(b []byte) error {
	req := map[string]json.RawMessage{}
	err := json.Unmarshal(b, &req)
	if err != nil {
		return fmt.Errorf("cannot unmarshal request: %w", err)
	}
	if v, ok := req["insightsEvents"]; ok {
		err = json.Unmarshal(v, &r.insightsEvents)
		if err != nil {
			err = json.Unmarshal(b, &r.insightsEvents)
			if err != nil {
				return fmt.Errorf("cannot unmarshal insightsEvents: %w", err)
			}
		}
	} else {
		err = json.Unmarshal(b, &r.insightsEvents)
		if err != nil {
			return fmt.Errorf("cannot unmarshal body parameter insightsEvents: %w", err)
		}
	}

	return nil
}

// ApiPushEventsRequest represents the request with all the parameters for the API call.
type ApiPushEventsRequest struct {
	insightsEvents *InsightsEvents
}

// NewApiPushEventsRequest creates an instance of the ApiPushEventsRequest to be used for the API call.
func (c *APIClient) NewApiPushEventsRequest(insightsEvents *InsightsEvents) ApiPushEventsRequest {
	return ApiPushEventsRequest{
		insightsEvents: insightsEvents,
	}
}

/*
PushEvents Wraps PushEventsWithContext using context.Background.

Sends a list of events to the Insights API.

You can include up to 1,000 events in a single request,
but the request body must be smaller than 2&nbsp;MB.

Request can be constructed by NewApiPushEventsRequest with parameters below.

	@param insightsEvents InsightsEvents
	@return EventsResponse
*/
func (c *APIClient) PushEvents(r ApiPushEventsRequest, opts ...Option) (*EventsResponse, error) {
	return c.PushEventsWithContext(context.Background(), r, opts...)
}

/*
PushEvents

Sends a list of events to the Insights API.

You can include up to 1,000 events in a single request,
but the request body must be smaller than 2&nbsp;MB.

Request can be constructed by NewApiPushEventsRequest with parameters below.

	@param insightsEvents InsightsEvents
	@return EventsResponse
*/
func (c *APIClient) PushEventsWithContext(ctx context.Context, r ApiPushEventsRequest, opts ...Option) (*EventsResponse, error) {
	var (
		postBody    any
		returnValue *EventsResponse
	)

	requestPath := "/1/events"

	headers := make(map[string]string)
	queryParams := url.Values{}

	if r.insightsEvents == nil {
		return returnValue, reportError("Parameter `insightsEvents` is required when calling `PushEvents`.")
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
	postBody = r.insightsEvents
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
