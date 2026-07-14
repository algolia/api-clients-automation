package manual

import (
	"bufio"
	"errors"
	"io"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/sse"
)

// oneByteReader returns a single byte per Read call, to exercise tokens and
// line endings split across reads.
type oneByteReader struct {
	r io.Reader
}

func (r oneByteReader) Read(p []byte) (int, error) {
	if len(p) > 1 {
		p = p[:1]
	}

	return r.r.Read(p) //nolint:wrapcheck
}

type closeRecorder struct {
	io.Reader

	closed bool
	err    error
}

func (c *closeRecorder) Close() error {
	c.closed = true

	return c.err
}

type failingReader struct {
	err error
}

func (r *failingReader) Read([]byte) (int, error) {
	return 0, r.err
}

var (
	errReadFailure    = errors.New("read failure")
	errCloseFailure   = errors.New("close failure")
	errRequestFailure = errors.New("request failure")
)

func collectEvents(t *testing.T, decoder sse.Decoder) []sse.Event {
	t.Helper()

	var events []sse.Event

	for decoder.Next() {
		events = append(events, decoder.Event())
	}

	require.NoError(t, decoder.Err())

	return events
}

func requireEvents(t *testing.T, expected, actual []sse.Event) {
	t.Helper()

	require.Len(t, actual, len(expected))

	for i, e := range expected {
		require.Equal(t, e.Type, actual[i].Type, "event %d type", i)
		require.Equal(t, string(e.Data), string(actual[i].Data), "event %d data", i)
	}
}

func TestSSEDecoder(t *testing.T) {
	tests := []struct {
		name     string
		input    string
		expected []sse.Event
	}{
		{
			name:     "single event",
			input:    "data: hello\n\n",
			expected: []sse.Event{{Type: "", Data: []byte("hello")}},
		},
		{
			name:     "event type",
			input:    "event: message\ndata: hello\n\n",
			expected: []sse.Event{{Type: "message", Data: []byte("hello")}},
		},
		{
			name:     "multiple events",
			input:    "data: one\n\ndata: two\n\n",
			expected: []sse.Event{{Data: []byte("one")}, {Data: []byte("two")}},
		},
		{
			name:     "multi-line data joined with LF",
			input:    "data: first\ndata: second\n\n",
			expected: []sse.Event{{Data: []byte("first\nsecond")}},
		},
		{
			name:     "empty data lines are preserved in concatenation",
			input:    "data:\ndata: x\n\n", //nolint:dupword
			expected: []sse.Event{{Data: []byte("\nx")}},
		},
		{
			name:     "comment lines are ignored",
			input:    ": keep-alive\ndata: hello\n: another comment\n\n",
			expected: []sse.Event{{Data: []byte("hello")}},
		},
		{
			name:     "comment-only stream dispatches nothing",
			input:    ": ping\n\n: ping\n\n",
			expected: nil,
		},
		{
			name:     "field without colon has an empty value",
			input:    "data\n\n",
			expected: []sse.Event{{Data: []byte("")}},
		},
		{
			name:     "only one leading space is stripped from the value",
			input:    "data:  spaced\n\n",
			expected: []sse.Event{{Data: []byte(" spaced")}},
		},
		{
			name:     "value without leading space",
			input:    "data:tight\n\n",
			expected: []sse.Event{{Data: []byte("tight")}},
		},
		{
			name:     "BOM is stripped from the first line only",
			input:    "\uFEFFdata: first\n\ndata: \uFEFFsecond\n\n",
			expected: []sse.Event{{Data: []byte("first")}, {Data: []byte("\uFEFFsecond")}},
		},
		{
			name:     "CRLF line endings",
			input:    "event: message\r\ndata: hello\r\n\r\n",
			expected: []sse.Event{{Type: "message", Data: []byte("hello")}},
		},
		{
			name:     "bare CR line endings",
			input:    "data: one\r\rdata: two\r\r",
			expected: []sse.Event{{Data: []byte("one")}, {Data: []byte("two")}},
		},
		{
			name:     "mixed line endings",
			input:    "data: one\r\ndata: two\ndata: three\r\n\n",
			expected: []sse.Event{{Data: []byte("one\ntwo\nthree")}},
		},
		{
			name:     "event type resets after dispatch",
			input:    "event: custom\ndata: one\n\ndata: two\n\n",
			expected: []sse.Event{{Type: "custom", Data: []byte("one")}, {Type: "", Data: []byte("two")}},
		},
		{
			name:     "event type resets on blank line without dispatch",
			input:    "event: custom\n\ndata: hello\n\n",
			expected: []sse.Event{{Type: "", Data: []byte("hello")}},
		},
		{
			name:     "id and retry fields do not corrupt the event",
			input:    "id: 42\nretry: 1000\ndata: hello\n\n",
			expected: []sse.Event{{Data: []byte("hello")}},
		},
		{
			name:     "unknown fields are ignored",
			input:    "unknown: field\ndata: hello\n\n",
			expected: []sse.Event{{Data: []byte("hello")}},
		},
		{
			name:     "incomplete event at end of stream is discarded",
			input:    "data: complete\n\ndata: incomplete\n",
			expected: []sse.Event{{Data: []byte("complete")}},
		},
		{
			name:     "incomplete event without trailing newline is discarded",
			input:    "data: incomplete",
			expected: nil,
		},
		{
			name:     "empty stream",
			input:    "",
			expected: nil,
		},
	}

	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(test.input)))
			requireEvents(t, test.expected, collectEvents(t, decoder))
		})
	}
}

func TestSSEDecoderCRLFSplitAcrossReads(t *testing.T) {
	// Reading one byte at a time guarantees that every CRLF sequence is split
	// across two reads: a bare CR must not be mistaken for two line endings,
	// which would dispatch spurious events.
	input := "event: message\r\ndata: one\r\n\r\ndata: two\r\n\r\n"
	decoder := sse.NewEventStreamDecoder(io.NopCloser(oneByteReader{r: strings.NewReader(input)}))

	requireEvents(t, []sse.Event{
		{Type: "message", Data: []byte("one")},
		{Type: "", Data: []byte("two")},
	}, collectEvents(t, decoder))
}

func TestSSEDecoderIDAndRetryPersistAcrossEvents(t *testing.T) {
	input := "id: 42\nretry: 1000\ndata: one\n\ndata: two\n\nid: 43\ndata: three\n\n"
	decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, decoder)

	require.Len(t, events, 3)
	require.Equal(t, "42", events[0].ID)
	require.Equal(t, 1000, events[0].Retry)
	require.Equal(t, "42", events[1].ID)
	require.Equal(t, 1000, events[1].Retry)
	require.Equal(t, "43", events[2].ID)
	require.Equal(t, 1000, events[2].Retry)
}

func TestSSEDecoderIDAndRetryDefaults(t *testing.T) {
	decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader("data: hello\n\n")))
	events := collectEvents(t, decoder)

	require.Len(t, events, 1)
	require.Empty(t, events[0].ID)
	require.Equal(t, -1, events[0].Retry)
}

func TestSSEDecoderInvalidIDAndRetryAreIgnored(t *testing.T) {
	input := "id: 4\x002\nretry: -100\nretry: 5s\nretry:\ndata: hello\n\n"
	decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, decoder)

	require.Len(t, events, 1)
	require.Empty(t, events[0].ID)
	require.Equal(t, -1, events[0].Retry)
}

func TestSSEDecoderLineExceedingBufferSize(t *testing.T) {
	input := "data: " + strings.Repeat("x", 11<<20) + "\n\n"
	decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))

	require.False(t, decoder.Next())
	require.ErrorIs(t, decoder.Err(), bufio.ErrTooLong)
}

func TestSSEDecoderLineWithinBufferSize(t *testing.T) {
	payload := strings.Repeat("x", 9<<20)
	input := "data: " + payload + "\n\n"
	decoder := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, decoder)

	require.Len(t, events, 1)
	require.Equal(t, payload, string(events[0].Data))
}

func TestSSEDecoderReadError(t *testing.T) {
	decoder := sse.NewEventStreamDecoder(io.NopCloser(io.MultiReader(
		strings.NewReader("data: one\n\n"),
		&failingReader{err: errReadFailure},
	)))

	require.True(t, decoder.Next())
	require.False(t, decoder.Next())
	require.ErrorIs(t, decoder.Err(), errReadFailure)
}

func TestSSEDecoderClose(t *testing.T) {
	rc := &closeRecorder{Reader: strings.NewReader("data: hello\n\n")}
	decoder := sse.NewEventStreamDecoder(rc)

	require.NoError(t, decoder.Close())
	require.True(t, rc.closed)
}

func TestSSEDecoderCloseError(t *testing.T) {
	rc := &closeRecorder{Reader: strings.NewReader(""), err: errCloseFailure}
	decoder := sse.NewEventStreamDecoder(rc)

	require.ErrorIs(t, decoder.Close(), errCloseFailure)
}
