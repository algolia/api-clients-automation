package tests

import (
	"bytes"
	"io"
	"net/http"
	"net/url"
	"os"
	"strings"
	"testing"
	"time"

	"github.com/stretchr/testify/require"
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

	queryValues := strings.Split(req.URL.RawQuery, "&")

	e.Query = url.Values{}

	for _, queryValue := range queryValues {
		split := strings.Split(queryValue, "=")
		if len(split) == 2 {
			e.Query.Add(split[0], split[1])
		}
	}

	return &http.Response{
		StatusCode: http.StatusOK,
		Body:       io.NopCloser(bytes.NewBufferString("")),
	}, nil
}

func ZeroValue[T any]() T {
	var v T

	return v
}

func Union(t *testing.T, expected any, received any) any {
	t.Helper()

	if expected != nil {
		require.NotNil(t, received, expected)
	}

	switch exp := expected.(type) {
	case map[string]any:
		res := map[string]any{}

		for key, val := range exp {
			require.Contains(t, received.(map[string]any), key)
			res[key] = Union(t, val, received.(map[string]any)[key])
		}

		return res
	case []any:
		res := []any{}

		require.GreaterOrEqual(t, len(received.([]any)), len(exp))

		for i, val := range exp {
			res = append(res, Union(t, val, received.([]any)[i]))
		}

		return res
	default:
		return received
	}
}

func GetLocalhost() string {
	if os.Getenv("CI") != "true" {
		return "host.docker.internal"
	}

	return "localhost"
}
