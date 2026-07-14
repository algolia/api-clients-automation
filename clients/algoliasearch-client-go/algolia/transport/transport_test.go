package transport_test

import (
	"context"
	"errors"
	"io"
	"net/http"
	"net/http/httptest"
	"net/url"
	"strings"
	"testing"
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/errs"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/sse"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

func newTestTransport(t *testing.T, serverURL string) *transport.Transport {
	t.Helper()

	u, err := url.Parse(serverURL)
	if err != nil {
		t.Fatalf("cannot parse server URL: %v", err)
	}

	return transport.New(transport.Configuration{
		Hosts: []transport.StatefulHost{
			transport.NewStatefulHost(u.Scheme, u.Host, func(call.Kind) bool { return true }),
		},
	})
}

func newStreamRequest(t *testing.T, ctx context.Context) *http.Request {
	t.Helper()

	req, err := http.NewRequestWithContext(ctx, http.MethodGet, "/1/events", nil)
	if err != nil {
		t.Fatalf("cannot create request: %v", err)
	}

	return req
}

func TestRequestStream(t *testing.T) {
	t.Parallel()

	firstEventRead := make(chan struct{})

	var receivedAccept string

	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		receivedAccept = r.Header.Get("Accept")

		w.Header().Set("Content-Type", "text/event-stream")

		flusher, ok := w.(http.Flusher)
		if !ok {
			t.Error("expected the response writer to be flushable")

			return
		}

		// Send the first event, then hold the connection open until the
		// client has consumed it: this guarantees that the response body is
		// streamed, not buffered until the end of the response.
		_, _ = io.WriteString(w, "event: message\ndata: first\n\n")

		flusher.Flush()

		select {
		case <-firstEventRead:
		case <-r.Context().Done():
			t.Error("client went away before reading the first event")

			return
		}

		_, _ = io.WriteString(w, "data: second\n\n")
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	tr := newTestTransport(t, srv.URL)

	//nolint:bodyclose // The body is closed through the decoder.
	res, err := tr.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	if err != nil {
		t.Fatalf("unexpected error: %v", err)
	}

	if receivedAccept != "text/event-stream" {
		t.Errorf("expected Accept header to be text/event-stream, got %q", receivedAccept)
	}

	d := sse.NewEventStreamDecoder(res.Body)

	defer func() { _ = d.Close() }()

	if !d.Next() {
		t.Fatalf("expected the first event to be read while the response is still open, got error: %v", d.Err())
	}

	if got := string(d.Event().Data); got != "first" {
		t.Errorf("expected first event data to be %q, got %q", "first", got)
	}

	close(firstEventRead)

	if !d.Next() {
		t.Fatalf("expected the second event to be read, got error: %v", d.Err())
	}

	if got := string(d.Event().Data); got != "second" {
		t.Errorf("expected second event data to be %q, got %q", "second", got)
	}

	if d.Next() {
		t.Error("expected the stream to be exhausted")
	}

	err = d.Err()
	if err != nil {
		t.Errorf("unexpected decoder error: %v", err)
	}
}

func TestRequestStream_HTTPStatusError(t *testing.T) {
	t.Parallel()

	srv := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, _ *http.Request) {
		http.Error(w, `{"message":"invalid request"}`, http.StatusBadRequest)
	}))
	defer srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	tr := newTestTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	res, err := tr.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	if res != nil {
		t.Error("expected no response on HTTP error status")
	}

	var statusErr *errs.HTTPStatusError
	if !errors.As(err, &statusErr) {
		t.Fatalf("expected an HTTPStatusError, got: %v", err)
	}

	if statusErr.StatusCode() != http.StatusBadRequest {
		t.Errorf("expected status code %d, got %d", http.StatusBadRequest, statusErr.StatusCode())
	}

	if !strings.Contains(string(statusErr.Body()), "invalid request") {
		t.Errorf("expected the error body to be carried by the error, got %q", statusErr.Body())
	}
}

func TestRequestStream_NoTryableHost(t *testing.T) {
	t.Parallel()

	tr := transport.New(transport.Configuration{
		Hosts: []transport.StatefulHost{
			transport.NewStatefulHost("https", "write-only.algolia.net", func(k call.Kind) bool { return k == call.Write }),
		},
	})

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	//nolint:bodyclose // The response is nil on error.
	_, err := tr.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	if !errors.Is(err, errs.ErrNoMoreHostToTry) {
		t.Fatalf("expected ErrNoMoreHostToTry, got: %v", err)
	}
}

func TestRequestStream_NetworkErrorIsWrapped(t *testing.T) {
	t.Parallel()

	// Point the transport to a closed port to trigger a network error.
	srv := httptest.NewServer(http.HandlerFunc(func(http.ResponseWriter, *http.Request) {}))
	srv.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 30*time.Second)
	defer cancel()

	tr := newTestTransport(t, srv.URL)

	//nolint:bodyclose // The response is nil on error.
	_, err := tr.RequestStream(ctx, newStreamRequest(t, ctx), call.Read, transport.RequestConfiguration{})
	if err == nil {
		t.Fatal("expected an error when the host is unreachable")
	}

	if !strings.Contains(err.Error(), "cannot perform request") {
		t.Errorf("expected the transport error message, got: %v", err)
	}
}
