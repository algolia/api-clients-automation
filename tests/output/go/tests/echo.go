package tests

import (
	"bytes"
	"io"
	"net/http"
	"net/url"
	"strings"
	"time"
)

type EchoRequester struct {
	Host           string
	Path           string
	Method         string
	Body           *string
	Header         http.Header
	Query          url.Values
	Timeout        time.Duration
	ConnectTimeout time.Duration
}

func (e *EchoRequester) Request(req *http.Request, timeout time.Duration, connectTimeout time.Duration) (*http.Response, error) {
	e.Host = req.URL.Host
	e.Path = req.URL.EscapedPath()
	e.Method = req.Method
	e.Header = req.Header
	e.Timeout = timeout
	e.ConnectTimeout = connectTimeout
	if req.Body != nil {
		body, _ := io.ReadAll(req.Body)
		strBody := string(body)
		e.Body = &strBody
	} else {
		e.Body = nil
	}

	var queryValues = strings.Split(req.URL.RawQuery, "&")
	e.Query = url.Values{}
	for _, queryValue := range queryValues {
		split := strings.Split(queryValue, "=")
		if len(split) == 2 {
			e.Query.Add(split[0], split[1])
		}
	}

	return &http.Response{
		StatusCode: 200,
		Body:       io.NopCloser(bytes.NewBufferString("")),
	}, nil
}

func ZeroValue[T any]() T {
	var v T
	return v
}

func Union(expected any, received any) any {
	switch expected.(type) {
	case map[string]any:
		res := map[string]any{}
		for key, val := range expected.(map[string]any) {
			res[key] = Union(val, received.(map[string]any)[key])
		}
		return res
	case []any:
		res := []any{}
		for i, val := range expected.([]any) {
			res = append(res, Union(val, received.([]any)[i]))
		}
		return res
	default:
		return received
	}
}
