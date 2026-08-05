package manual

import (
	"bytes"
	"context"
	"io"
	"net/http"
	"net/http/httptest"
	"net/url"
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/errs"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/sse"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func newStreamTransport(t *testing.T, serverURL string) *transport.Transport {
	t.Helper()

	serverHost, err := url.Parse(serverURL)
	require.NoError(t, err)

	return transport.New(transport.Configuration{
		Hosts: []transport.StatefulHost{
			transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }),
		},
	})
}

func newStreamRequest(t *testing.T, ctx context.Context) *http.Request { //nolint:revive // t comes first in test helpers.
	t.Helper()

	req, err := http.NewRequestWithContext(ctx, http.MethodGet, "/1/events", nil)
	require.NoError(t, err)

	return req
}

func TestRequestStream(t *testing.T) {
	firstEventRead := make(chan struct{})

	var receivedAccept string

	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, req *http.Request) {
		receivedAccept = req.Header.Get("Accept")

		writer.Header().Set("Content-Type", "text/event-stream")

		flusher, ok := writer.(http.Flusher)
		if !ok {
			t.Error("expected the response writer to be flushable")

			return
		}

		// Send the first event, then hold the connection open until the
		// client has consumed it: this guarantees that the response body is
		// streamed, not buffered until the end of the response.
		_, _ = io.WriteString(writer, "event: message\ndata: first\n\n")

		flusher.Flush()

		select {
		case <-firstEventRead:
		case <-req.Context().Done():
			t.Error("client went away before reading the first event")

			return
		}

		_, _ = io.WriteString(writer, "data: second\n\n")
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	transporter := newStreamTransport(t, srv.URL)

	//nolint:bodyclose // The body is closed through the decoder.
	res, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	require.NoError(t, err)
	require.Equal(t, "text/event-stream", receivedAccept)

	decoder := sse.NewEventStreamDecoder(res.Body)

	defer func() { _ = decoder.Close() }()

	require.True(t, decoder.Next(), "expected the first event to be read while the response is still open")
	require.Equal(t, "first", string(decoder.Event().Data))

	close(firstEventRead)

	require.True(t, decoder.Next())
	require.Equal(t, "second", string(decoder.Event().Data))
	require.False(t, decoder.Next())
	require.NoError(t, decoder.Err())
}

func TestRequestStreamHTTPStatusError(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, _ *http.Request) {
		http.Error(w, `{"message":"invalid request"}`, http.StatusBadRequest)
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	transporter := newStreamTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	res, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	require.Nil(t, res)

	var statusErr *errs.HTTPStatusError
	require.ErrorAs(t, err, &statusErr)
	require.Equal(t, http.StatusBadRequest, statusErr.StatusCode())
	require.Contains(t, string(statusErr.Body()), "invalid request")
}

func TestRequestStreamHTTPStatusErrorBodyTruncated(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.WriteHeader(http.StatusInternalServerError)

		_, _ = writer.Write(bytes.Repeat([]byte("x"), 2<<20))
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	transporter := newStreamTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	_, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})

	var statusErr *errs.HTTPStatusError
	require.ErrorAs(t, err, &statusErr)
	require.Equal(t, http.StatusInternalServerError, statusErr.StatusCode())
	require.Len(t, statusErr.Body(), 1<<20)
}

func TestRequestStreamHTTPStatusErrorBodyReadFailure(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		// Announce a bigger body than is actually written: the server closes
		// the connection early and the client fails to read the error body.
		writer.Header().Set("Content-Length", "100")
		writer.WriteHeader(http.StatusInternalServerError)

		_, _ = io.WriteString(writer, "partial")
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	transporter := newStreamTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	res, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	require.Nil(t, res)
	require.Contains(t, err.Error(), "cannot read error response body")

	var statusErr *errs.HTTPStatusError
	require.ErrorAs(t, err, &statusErr)
	require.Equal(t, http.StatusInternalServerError, statusErr.StatusCode())
	require.Empty(t, statusErr.Body())
}

func TestRequestStreamNoTryableHost(t *testing.T) {
	transporter := transport.New(transport.Configuration{
		Hosts: []transport.StatefulHost{
			transport.NewStatefulHost("https", "write-only.algolia.net", func(k call.Kind) bool { return k == call.Write }),
		},
	})

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	//nolint:bodyclose // The response is nil on error.
	_, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	require.ErrorIs(t, err, errs.ErrNoMoreHostToTry)
}

func TestRequestStreamNetworkErrorIsWrapped(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(http.ResponseWriter, *http.Request) {}))
	srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	transporter := newStreamTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	_, err := transporter.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	require.Error(t, err)
	require.Contains(t, err.Error(), "cannot perform request")
}
