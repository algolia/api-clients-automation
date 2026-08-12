package manual

import (
	"context"
	"encoding/json"
	"fmt"
	"net/http"
	"net/http/httptest"
	"net/url"
	"regexp"
	"strings"
	"sync"
	"sync/atomic"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/errs"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/utils"
)

var requestIDFormat = regexp.MustCompile(`^[0-9A-Za-z]{11}$`)

// requestIDRecorder records the Request-ID header of every request it serves.
type requestIDRecorder struct {
	mu      sync.Mutex
	ids     []string
	handler http.HandlerFunc
}

func (r *requestIDRecorder) ServeHTTP(w http.ResponseWriter, req *http.Request) {
	r.mu.Lock()
	r.ids = append(r.ids, req.Header.Get("Request-ID"))
	r.mu.Unlock()
	r.handler(w, req)
}

func (r *requestIDRecorder) recorded() []string {
	r.mu.Lock()
	defer r.mu.Unlock()

	return append([]string{}, r.ids...)
}

func newSearchClient(t *testing.T, serverURL string, hostCount int) *search.APIClient {
	t.Helper()

	serverHost, err := url.Parse(serverURL)
	require.NoError(t, err)

	hosts := make([]transport.StatefulHost, 0, hostCount)
	for i := 0; i < hostCount; i++ {
		hosts = append(hosts, transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }))
	}

	client, err := search.NewClientWithConfig(search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:         "appID",
			ApiKey:        "apiKey",
			Hosts:         hosts,
			DefaultHeader: map[string]string{},
		},
	})
	require.NoError(t, err)

	return client
}

func okSettings(w http.ResponseWriter, _ *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	_, _ = w.Write([]byte(`{}`))
}

func TestNewRequestIDFormat(t *testing.T) {
	seen := make(map[string]struct{})

	for i := 0; i < 100; i++ {
		id := transport.NewRequestID()
		require.Regexp(t, requestIDFormat, id)
		seen[id] = struct{}{}
	}

	require.Greater(t, len(seen), 90, "IDs are expected to be essentially unique")
}

func TestHasRequestIDIsCaseInsensitive(t *testing.T) {
	require.False(t, transport.HasRequestID(nil))
	require.False(t, transport.HasRequestID(map[string]string{"x-forwarded-for": "1"}))
	require.True(t, transport.HasRequestID(map[string]string{"request-id": "a"}))
	require.True(t, transport.HasRequestID(map[string]string{"ReQuEsT-iD": "a"}))
	require.True(t, transport.HasRequestID(nil, map[string]string{"REQUEST-ID": "a"}))
}

func TestRequestIDSentAndFreshPerCall(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.NoError(t, err)
	_, err = client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.NoError(t, err)

	ids := recorder.recorded()
	require.Len(t, ids, 2)
	require.Regexp(t, requestIDFormat, ids[0])
	require.Regexp(t, requestIDFormat, ids[1])
	require.NotEqual(t, ids[0], ids[1])
}

func TestRequestIDReusedAcrossRetries(t *testing.T) {
	recorder := &requestIDRecorder{}
	// ServeHTTP records before delegating, so the recorder's synchronized
	// state doubles as the attempt counter.
	recorder.handler = func(writer http.ResponseWriter, req *http.Request) {
		if len(recorder.recorded()) < 3 {
			writer.WriteHeader(http.StatusInternalServerError)

			return
		}

		okSettings(writer, req)
	}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 3)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.NoError(t, err)

	ids := recorder.recorded()
	require.Len(t, ids, 3)
	require.Regexp(t, requestIDFormat, ids[0])
	require.Equal(t, ids[0], ids[1])
	require.Equal(t, ids[0], ids[2])
}

func TestCallerSuppliedRequestIDWins(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.GetSettings(
		client.NewApiGetSettingsRequest("indexName"),
		search.WithHeaderParam("ReQuEsT-iD", "CallerOwnedId"),
	)
	require.NoError(t, err)

	require.Equal(t, []string{"CallerOwnedId"}, recorder.recorded())
}

func TestHasRequestIDQueryParamIsCaseInsensitive(t *testing.T) {
	require.False(t, transport.HasRequestIDQueryParam(nil))
	require.False(t, transport.HasRequestIDQueryParam(url.Values{"query": {"a"}}))
	require.True(t, transport.HasRequestIDQueryParam(url.Values{"x-algolia-request-id": {"a"}}))
	require.True(t, transport.HasRequestIDQueryParam(url.Values{"X-Algolia-Request-Id": {"a"}}))
	require.True(t, transport.HasRequestIDQueryParam(url.Values{"X-ALGOLIA-REQUEST-ID": {"a"}}))
}

func TestCallerSuppliedRequestIDQueryParamWins(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	// The server consults the x-algolia-request-id query parameter only when
	// the Request-ID header is absent: minting a header would shadow it.
	_, err := client.CustomGet(
		client.NewApiCustomGetRequest("1/test"),
		search.WithQueryParam("X-Algolia-Request-Id", "QueryOwned"),
	)
	require.NoError(t, err)

	require.Equal(t, []string{""}, recorder.recorded())
}

func TestRequestIDMintedWithoutQueryParam(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	// The inverse of TestCallerSuppliedRequestIDQueryParamWins: the same call
	// without the query parameter must mint, so the suppression assertion
	// above cannot pass vacuously.
	_, err := client.CustomGet(client.NewApiCustomGetRequest("1/test"))
	require.NoError(t, err)

	ids := recorder.recorded()
	require.Len(t, ids, 1)
	require.Regexp(t, requestIDFormat, ids[0])
}

// newRequestIDTransport builds a transport pointed at the recorder with the
// Request-ID channel enabled, bypassing the generated clients so the
// transport behaviour is provable regardless of the generated configuration.
func newRequestIDTransport(t *testing.T, serverURL string) *transport.Transport {
	t.Helper()

	serverHost, err := url.Parse(serverURL)
	require.NoError(t, err)

	return transport.New(transport.Configuration{
		Hosts: []transport.StatefulHost{
			transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }),
		},
		RequestIDEnabled: utils.ToPtr(true),
	})
}

func TestTransportSkipsMintingOverQueryParam(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	transporter := newRequestIDTransport(t, srv.URL)

	req, err := http.NewRequestWithContext(context.Background(), http.MethodGet, srv.URL+"/1/test?X-Algolia-Request-Id=QueryOwned", nil)
	require.NoError(t, err)

	res, _, err := transporter.Request(context.Background(), req, call.Read, transport.RequestConfiguration{})
	require.NoError(t, err)
	require.NoError(t, res.Body.Close())

	require.Equal(t, []string{""}, recorder.recorded())
}

func TestTransportMintsWithoutQueryParam(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	transporter := newRequestIDTransport(t, srv.URL)

	req, err := http.NewRequestWithContext(context.Background(), http.MethodGet, srv.URL+"/1/test", nil)
	require.NoError(t, err)

	res, _, err := transporter.Request(context.Background(), req, call.Read, transport.RequestConfiguration{})
	require.NoError(t, err)
	require.NoError(t, res.Body.Close())

	ids := recorder.recorded()
	require.Len(t, ids, 1)
	require.Regexp(t, requestIDFormat, ids[0])
}

func TestDefaultHeaderRequestIDWins(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)
	client.AddDefaultHeader("REQUEST-ID", "DefaultOwned")

	// Both the transport and the helper layer must leave the ID alone,
	// including when the helper inspects the options rather than the request.
	exists, err := client.IndexExists("indexName")
	require.NoError(t, err)
	require.True(t, exists)

	require.Equal(t, []string{"DefaultOwned"}, recorder.recorded())
}

func TestIngestionExplicitOptInMints(t *testing.T) {
	recorder := &requestIDRecorder{handler: func(w http.ResponseWriter, _ *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		_, _ = w.Write([]byte(`{}`))
	}}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	serverHost, err := url.Parse(srv.URL)
	require.NoError(t, err)

	client, err := ingestion.NewClientWithConfig(ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:  "appID",
			ApiKey: "apiKey",
			Hosts: []transport.StatefulHost{
				transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }),
			},
			// Disabled is only the ingestion default: an explicit opt-in
			// survives the constructor and enables minting on any client.
			RequestIDEnabled: utils.ToPtr(true),
		},
	})
	require.NoError(t, err)

	_, err = client.CustomGet(client.NewApiCustomGetRequest("1/test"))
	require.NoError(t, err)

	ids := recorder.recorded()
	require.Len(t, ids, 1)
	require.Regexp(t, requestIDFormat, ids[0])
}

func TestIngestionDoesNotMintByDefault(t *testing.T) {
	recorder := &requestIDRecorder{handler: func(w http.ResponseWriter, _ *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		_, _ = w.Write([]byte(`{}`))
	}}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	serverHost, err := url.Parse(srv.URL)
	require.NoError(t, err)

	client, err := ingestion.NewClientWithConfig(ingestion.IngestionConfiguration{
		Configuration: transport.Configuration{
			AppID:  "appID",
			ApiKey: "apiKey",
			Hosts: []transport.StatefulHost{
				transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }),
			},
		},
	})
	require.NoError(t, err)

	_, err = client.CustomGet(client.NewApiCustomGetRequest("1/test"))
	require.NoError(t, err)

	require.Equal(t, []string{""}, recorder.recorded())
}

func TestSearchExplicitOptOutDisablesMinting(t *testing.T) {
	recorder := &requestIDRecorder{handler: okSettings}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	serverHost, err := url.Parse(srv.URL)
	require.NoError(t, err)

	client, err := search.NewClientWithConfig(search.SearchConfiguration{
		Configuration: transport.Configuration{
			AppID:  "appID",
			ApiKey: "apiKey",
			Hosts: []transport.StatefulHost{
				transport.NewStatefulHost(serverHost.Scheme, serverHost.Host, func(call.Kind) bool { return true }),
			},
			DefaultHeader: map[string]string{},
			// Enabled is only the search default: an explicit opt-out wins.
			RequestIDEnabled: utils.ToPtr(false),
		},
	})
	require.NoError(t, err)

	_, err = client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.NoError(t, err)

	require.Equal(t, []string{""}, recorder.recorded())
}

func TestHelperSharesOneRequestID(t *testing.T) {
	recorder := &requestIDRecorder{handler: func(writer http.ResponseWriter, req *http.Request) {
		writer.Header().Set("Content-Type", "application/json")

		if req.Method == http.MethodPost {
			_, _ = writer.Write([]byte(`{"taskID":42,"objectIDs":["1"]}`))

			return
		}

		_, _ = writer.Write([]byte(`{"status":"published","pendingTask":false}`))
	}}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	// batchSize 1 over two objects: 2 batch calls + 2 task polls.
	_, err := client.SaveObjects("indexName",
		[]map[string]any{{"objectID": "1"}, {"objectID": "2"}},
		search.WithBatchSize(1), search.WithWaitForTasks(true),
	)
	require.NoError(t, err)

	first := recorder.recorded()
	require.Len(t, first, 4)
	require.Regexp(t, requestIDFormat, first[0])

	for _, id := range first {
		require.Equal(t, first[0], id)
	}

	// A second helper invocation mints a fresh ID.
	_, err = client.SaveObjects("indexName", []map[string]any{{"objectID": "3"}})
	require.NoError(t, err)

	all := recorder.recorded()
	require.Len(t, all, 5)
	require.Regexp(t, requestIDFormat, all[4])
	require.NotEqual(t, first[0], all[4])
}

func TestHelperKeepsCallerRequestID(t *testing.T) {
	recorder := &requestIDRecorder{handler: func(w http.ResponseWriter, _ *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		_, _ = w.Write([]byte(`{"taskID":42,"objectIDs":["1"]}`))
	}}

	srv := httptest.NewServer(recorder)
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.SaveObjects("indexName",
		[]map[string]any{{"objectID": "1"}},
		search.WithHeaderParam("Request-ID", "HelperCaller"),
	)
	require.NoError(t, err)

	require.Equal(t, []string{"HelperCaller"}, recorder.recorded())
}

func TestReplaceAllObjectsCleanupSurvivesCancelledContext(t *testing.T) {
	ctx, cancel := context.WithCancel(context.Background())
	defer cancel()

	type recordedRequest struct {
		method    string
		path      string
		requestID string
	}

	var recorder struct {
		mu       sync.Mutex
		requests []recordedRequest
	}

	release := make(chan struct{})

	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, req *http.Request) {
		recorder.mu.Lock()
		recorder.requests = append(recorder.requests, recordedRequest{method: req.Method, path: req.URL.Path, requestID: req.Header.Get("Request-ID")})
		recorder.mu.Unlock()

		writer.Header().Set("Content-Type", "application/json")

		switch {
		case strings.HasSuffix(req.URL.Path, "/operation"):
			_, _ = writer.Write([]byte(`{"taskID":42,"updatedAt":"2021-01-01T00:00:00.000Z"}`))
		case strings.HasSuffix(req.URL.Path, "/batch"):
			// Cancel the caller's context while the batch is in flight, then
			// hold the handler until the test is done: the batch fails
			// client-side and the helper enters its failure path.
			cancel()
			<-release
		case req.Method == http.MethodDelete:
			_, _ = writer.Write([]byte(`{"taskID":42,"deletedAt":"2021-01-01T00:00:00.000Z"}`))
		}
	}))
	defer srv.Close()
	defer close(release)

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.ReplaceAllObjects("indexName",
		[]map[string]any{{"objectID": "1"}},
		search.WithContext(ctx),
	)
	// The transport reports the aborted batch without wrapping the context
	// error, so the cancellation is asserted on the message.
	require.Error(t, err)
	require.ErrorContains(t, err, "context canceled")

	recorder.mu.Lock()
	recorded := append([]recordedRequest{}, recorder.requests...)
	recorder.mu.Unlock()

	// The copy, the aborted batch, then exactly one rescue DeleteIndex: the
	// cleanup must survive the caller's context so the temporary index cannot
	// leak, and it must carry the Request-ID shared by the helper invocation.
	require.Len(t, recorded, 3)

	deleteReq := recorded[2]
	require.Equal(t, http.MethodDelete, deleteReq.method)
	require.Regexp(t, `^/1/indexes/indexName_tmp_\d+$`, deleteReq.path)
	require.Regexp(t, requestIDFormat, deleteReq.requestID)
	require.Equal(t, recorded[0].requestID, deleteReq.requestID)
}

func TestAPIErrorCarriesCorrelationID(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.Header().Set("Content-Type", "application/json")
		writer.Header().Set("cOrReLaTiOn-Id", "CorrTest123")
		// The unrelated edge header must never be surfaced instead.
		writer.Header().Set("X-Algolia-RequestID", "EdgePopValue")
		writer.WriteHeader(http.StatusBadRequest)
		_, _ = writer.Write([]byte(`{"message":"boom"}`))
	}))
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.Error(t, err)

	var apiErr *search.APIError
	require.ErrorAs(t, err, &apiErr)
	require.Equal(t, "CorrTest123", apiErr.CorrelationID)
	require.Equal(t, 400, apiErr.Status)
	require.Equal(t, "API error [400] boom (Correlation-ID: CorrTest123)", apiErr.Error())
}

func TestAPIErrorWithoutCorrelationIDIsUnchanged(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.Header().Set("Content-Type", "application/json")
		writer.Header().Set("X-Algolia-RequestID", "EdgePopValue")
		writer.WriteHeader(http.StatusBadRequest)
		_, _ = writer.Write([]byte(`{"message":"boom"}`))
	}))
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.Error(t, err)

	var apiErr *search.APIError
	require.ErrorAs(t, err, &apiErr)
	require.Empty(t, apiErr.CorrelationID)
	require.Equal(t, "API error [400] boom", apiErr.Error())
}

func TestAPIErrorJSONRoundTripExcludesCorrelationID(t *testing.T) {
	apiErr := search.APIError{Message: "boom", Status: 400, CorrelationID: "CorrTest123"}

	serialized, err := json.Marshal(apiErr)
	require.NoError(t, err)
	require.NotContains(t, string(serialized), "CorrTest123")

	var restored search.APIError
	require.NoError(t, json.Unmarshal(serialized, &restored))
	require.Equal(t, "boom", restored.Message)
	require.Empty(t, restored.CorrelationID)
	require.NotContains(t, restored.AdditionalProperties, "correlationID")
}

func TestExhaustionErrorCarriesLastCorrelationID(t *testing.T) {
	var attempts atomic.Int64

	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.Header().Set("Correlation-ID", fmt.Sprintf("CorrAttempt%d", attempts.Add(1)))
		writer.WriteHeader(http.StatusInternalServerError)
	}))
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 3)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.Error(t, err)
	require.ErrorIs(t, err, errs.ErrNoMoreHostToTry)

	var exhausted *errs.NoMoreHostToTryError
	require.ErrorAs(t, err, &exhausted)
	require.Equal(t, "CorrAttempt3", exhausted.CorrelationID())
	require.Contains(t, exhausted.Error(), "(Correlation-ID: CorrAttempt3)")
}

func TestExhaustionErrorWithoutCorrelationIDIsUnchanged(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.WriteHeader(http.StatusInternalServerError)
	}))
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 3)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.Error(t, err)
	require.ErrorIs(t, err, errs.ErrNoMoreHostToTry)
	require.NotContains(t, err.Error(), "Correlation-ID")
}

func TestDeserializationErrorCarriesCorrelationID(t *testing.T) {
	srv := httptest.NewServer(http.HandlerFunc(func(writer http.ResponseWriter, _ *http.Request) {
		writer.Header().Set("Content-Type", "application/json")
		writer.Header().Set("Correlation-ID", "CorrDecode1")
		_, _ = writer.Write([]byte(`not-json`))
	}))
	defer srv.Close()

	client := newSearchClient(t, srv.URL, 1)

	_, err := client.GetSettings(client.NewApiGetSettingsRequest("indexName"))
	require.Error(t, err)

	var deser *errs.DeserializationError
	require.ErrorAs(t, err, &deser)
	require.Equal(t, "CorrDecode1", deser.CorrelationID())
	require.Contains(t, err.Error(), "(Correlation-ID: CorrDecode1)")
}
