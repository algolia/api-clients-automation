package manual

import (
	"encoding/json"
	"net/http"
	"net/http/httptest"
	"net/url"
	"regexp"
	"sync"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/call"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/ingestion"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/search"
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
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
	for range hostCount {
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

	for range 100 {
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
	var attempts int

	recorder := &requestIDRecorder{handler: func(writer http.ResponseWriter, req *http.Request) {
		attempts++
		if attempts < 3 {
			writer.WriteHeader(http.StatusInternalServerError)

			return
		}

		okSettings(writer, req)
	}}

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

func TestIngestionNeverMints(t *testing.T) {
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
			// An explicit opt-in must not survive the constructor: only the
			// search, recommend and composition APIs support Request-ID.
			RequestIDEnabled: true,
		},
	})
	require.NoError(t, err)

	_, err = client.CustomGet(client.NewApiCustomGetRequest("1/test"))
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
