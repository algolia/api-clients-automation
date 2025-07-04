// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
package insights

import (
	"context"
	"encoding/json"
	"fmt"
	"net/http"
	"net/url"
	"strings"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

type config struct {
	// -- Request options for API calls
	context      context.Context
	queryParams  url.Values
	headerParams map[string]string
	timeouts     transport.RequestConfiguration
}

type RequestOption interface {
	apply(*config)
}

type requestOption func(*config)

func (r requestOption) apply(c *config) {
	r(c)
}

func WithContext(ctx context.Context) requestOption {
	return requestOption(func(c *config) {
		c.context = ctx
	})
}

func WithHeaderParam(key string, value any) requestOption {
	return requestOption(func(c *config) {
		c.headerParams[key] = utils.ParameterToString(value)
	})
}

func WithQueryParam(key string, value any) requestOption {
	return requestOption(func(c *config) {
		c.queryParams.Set(utils.QueryParameterToString(key), utils.QueryParameterToString(value))
	})
}

func WithReadTimeout(timeout time.Duration) requestOption {
	return requestOption(func(c *config) {
		c.timeouts.ReadTimeout = &timeout
	})
}

func WithWriteTimeout(timeout time.Duration) requestOption {
	return requestOption(func(c *config) {
		c.timeouts.WriteTimeout = &timeout
	})
}

func WithConnectTimeout(timeout time.Duration) requestOption {
	return requestOption(func(c *config) {
		c.timeouts.ConnectTimeout = &timeout
	})
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

	  This method lets you send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomDeleteRequest with parameters below.
	  @param path string - Path of the endpoint, for example `1/newFeature`.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomDeleteWithHTTPInfo(r ApiCustomDeleteRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomDelete`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			conf.queryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	req, err := c.prepareRequest(conf.context, requestPath, http.MethodDelete, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
CustomDelete casts the HTTP response body to a defined struct.

This method lets you send requests to the Algolia REST API.

Request can be constructed by NewApiCustomDeleteRequest with parameters below.

	@param path string - Path of the endpoint, for example `1/newFeature`.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomDelete(r ApiCustomDeleteRequest, opts ...RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomDeleteWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return returnValue, c.decodeError(res, resBody)
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

	  This method lets you send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomGetRequest with parameters below.
	  @param path string - Path of the endpoint, for example `1/newFeature`.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomGetWithHTTPInfo(r ApiCustomGetRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomGet`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			conf.queryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	req, err := c.prepareRequest(conf.context, requestPath, http.MethodGet, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
CustomGet casts the HTTP response body to a defined struct.

This method lets you send requests to the Algolia REST API.

Request can be constructed by NewApiCustomGetRequest with parameters below.

	@param path string - Path of the endpoint, for example `1/newFeature`.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@return map[string]any
*/
func (c *APIClient) CustomGet(r ApiCustomGetRequest, opts ...RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomGetWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return returnValue, c.decodeError(res, resBody)
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

	  This method lets you send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomPostRequest with parameters below.
	  @param path string - Path of the endpoint, for example `1/newFeature`.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	  @param body map[string]any - Parameters to send with the custom request.
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomPostWithHTTPInfo(r ApiCustomPostRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomPost`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			conf.queryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(conf.context, requestPath, http.MethodPost, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
CustomPost casts the HTTP response body to a defined struct.

This method lets you send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPostRequest with parameters below.

	@param path string - Path of the endpoint, for example `1/newFeature`.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPost(r ApiCustomPostRequest, opts ...RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomPostWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return returnValue, c.decodeError(res, resBody)
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

	  This method lets you send requests to the Algolia REST API.


	Request can be constructed by NewApiCustomPutRequest with parameters below.
	  @param path string - Path of the endpoint, for example `1/newFeature`.
	  @param parameters map[string]any - Query parameters to apply to the current query.
	  @param body map[string]any - Parameters to send with the custom request.
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) CustomPutWithHTTPInfo(r ApiCustomPutRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/{path}"
	requestPath = strings.ReplaceAll(requestPath, "{path}", utils.ParameterToString(r.path))

	if r.path == "" {
		return nil, nil, reportError("Parameter `path` is required when calling `CustomPut`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	if !utils.IsNilOrEmpty(r.parameters) {
		for k, v := range r.parameters {
			conf.queryParams.Set(k, utils.QueryParameterToString(v))
		}
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	// body params
	if utils.IsNilOrEmpty(r.body) {
		postBody = "{}"
	} else {
		postBody = r.body
	}
	req, err := c.prepareRequest(conf.context, requestPath, http.MethodPut, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
CustomPut casts the HTTP response body to a defined struct.

This method lets you send requests to the Algolia REST API.

Request can be constructed by NewApiCustomPutRequest with parameters below.

	@param path string - Path of the endpoint, for example `1/newFeature`.
	@param parameters map[string]any - Query parameters to apply to the current query.
	@param body map[string]any - Parameters to send with the custom request.
	@return map[string]any
*/
func (c *APIClient) CustomPut(r ApiCustomPutRequest, opts ...RequestOption) (*map[string]any, error) {
	var returnValue *map[string]any

	res, resBody, err := c.CustomPutWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return returnValue, c.decodeError(res, resBody)
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
DeleteUserToken calls the API and returns the raw response from it.

	Deletes all events related to the specified user token from events metrics and analytics.

The deletion is asynchronous, and processed within 48 hours.
To delete a personalization user profile, see `Delete a user profile` in the Personalization API.

	    Required API Key ACLs:
	    - deleteObject

	Request can be constructed by NewApiDeleteUserTokenRequest with parameters below.
	  @param userToken string - User token for which to delete all associated events.
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) DeleteUserTokenWithHTTPInfo(r ApiDeleteUserTokenRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/1/usertokens/{userToken}"
	requestPath = strings.ReplaceAll(requestPath, "{userToken}", url.PathEscape(utils.ParameterToString(r.userToken)))

	if r.userToken == "" {
		return nil, nil, reportError("Parameter `userToken` is required when calling `DeleteUserToken`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	req, err := c.prepareRequest(conf.context, requestPath, http.MethodDelete, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
DeleteUserToken casts the HTTP response body to a defined struct.

Deletes all events related to the specified user token from events metrics and analytics.
The deletion is asynchronous, and processed within 48 hours.
To delete a personalization user profile, see `Delete a user profile` in the Personalization API.

Required API Key ACLs:
  - deleteObject

Request can be constructed by NewApiDeleteUserTokenRequest with parameters below.

	@param userToken string - User token for which to delete all associated events.
*/
func (c *APIClient) DeleteUserToken(r ApiDeleteUserTokenRequest, opts ...RequestOption) error {
	res, resBody, err := c.DeleteUserTokenWithHTTPInfo(r, opts...)
	if err != nil {
		return err
	}
	if res == nil {
		return reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return c.decodeError(res, resBody)
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
PushEvents calls the API and returns the raw response from it.

	Sends a list of events to the Insights API.

You can include up to 1,000 events in a single request,
but the request body must be smaller than 2&nbsp;MB.

	    Required API Key ACLs:
	    - search

	Request can be constructed by NewApiPushEventsRequest with parameters below.
	  @param insightsEvents InsightsEvents
	@param opts ...RequestOption - Optional parameters for the API call
	@return *http.Response - The raw response from the API
	@return []byte - The raw response body from the API
	@return error - An error if the API call fails
*/
func (c *APIClient) PushEventsWithHTTPInfo(r ApiPushEventsRequest, opts ...RequestOption) (*http.Response, []byte, error) {
	requestPath := "/1/events"

	if r.insightsEvents == nil {
		return nil, nil, reportError("Parameter `insightsEvents` is required when calling `PushEvents`.")
	}

	conf := config{
		context:      context.Background(),
		queryParams:  url.Values{},
		headerParams: map[string]string{},
	}

	// optional params if any
	for _, opt := range opts {
		opt.apply(&conf)
	}

	var postBody any

	// body params
	postBody = r.insightsEvents
	req, err := c.prepareRequest(conf.context, requestPath, http.MethodPost, postBody, conf.headerParams, conf.queryParams)
	if err != nil {
		return nil, nil, err
	}

	return c.callAPI(req, false, conf.timeouts)
}

/*
PushEvents casts the HTTP response body to a defined struct.

Sends a list of events to the Insights API.

You can include up to 1,000 events in a single request,
but the request body must be smaller than 2&nbsp;MB.

Required API Key ACLs:
  - search

Request can be constructed by NewApiPushEventsRequest with parameters below.

	@param insightsEvents InsightsEvents
	@return EventsResponse
*/
func (c *APIClient) PushEvents(r ApiPushEventsRequest, opts ...RequestOption) (*EventsResponse, error) {
	var returnValue *EventsResponse

	res, resBody, err := c.PushEventsWithHTTPInfo(r, opts...)
	if err != nil {
		return returnValue, err
	}
	if res == nil {
		return returnValue, reportError("res is nil")
	}

	if res.StatusCode >= 300 {
		return returnValue, c.decodeError(res, resBody)
	}

	err = c.decode(&returnValue, resBody)
	if err != nil {
		return returnValue, reportError("cannot decode result: %w", err)
	}

	return returnValue, nil
}
