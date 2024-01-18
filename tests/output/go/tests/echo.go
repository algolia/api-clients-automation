package tests

import (
	"bytes"
	"io"
	"net/http"
	"net/url"
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
	e.Path = req.URL.Path
	e.Method = req.Method
	e.Header = req.Header
	e.Query = req.URL.Query()
	e.Timeout = timeout
	e.ConnectTimeout = connectTimeout
	if req.Body != nil {
		body, _ := io.ReadAll(req.Body)
		strBody := string(body)
		e.Body = &strBody
	} else {
		e.Body = nil
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
