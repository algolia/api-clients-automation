package sse_test

import (
	"bufio"
	"bytes"
	"errors"
	"io"
	"strings"
	"testing"

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

func collectEvents(t *testing.T, d sse.Decoder) []sse.Event {
	t.Helper()

	var events []sse.Event

	for d.Next() {
		events = append(events, d.Event())
	}

	err := d.Err()
	if err != nil {
		t.Fatalf("unexpected decoder error: %v", err)
	}

	return events
}

func TestEventStreamDecoder(t *testing.T) {
	t.Parallel()

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
			input:    "data:\ndata: x\n\n",
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
		test := test

		t.Run(test.name, func(t *testing.T) {
			t.Parallel()

			d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(test.input)))
			events := collectEvents(t, d)

			assertEventsEqual(t, test.expected, events)
		})
	}
}

func TestEventStreamDecoder_CRLFSplitAcrossReads(t *testing.T) {
	t.Parallel()

	// Reading one byte at a time guarantees that every CRLF sequence is split
	// across two reads: a bare CR must not be mistaken for two line endings,
	// which would dispatch spurious events.
	input := "event: message\r\ndata: one\r\n\r\ndata: two\r\n\r\n"
	d := sse.NewEventStreamDecoder(io.NopCloser(oneByteReader{r: strings.NewReader(input)}))
	events := collectEvents(t, d)

	assertEventsEqual(t, []sse.Event{
		{Type: "message", Data: []byte("one")},
		{Type: "", Data: []byte("two")},
	}, events)
}

func TestEventStreamDecoder_IDAndRetryPersistAcrossEvents(t *testing.T) {
	t.Parallel()

	input := "id: 42\nretry: 1000\ndata: one\n\ndata: two\n\nid: 43\ndata: three\n\n"
	d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, d)

	expected := []sse.Event{
		{Data: []byte("one"), ID: "42", Retry: 1000},
		{Data: []byte("two"), ID: "42", Retry: 1000},
		{Data: []byte("three"), ID: "43", Retry: 1000},
	}

	if len(events) != len(expected) {
		t.Fatalf("expected %d events, got %d: %+v", len(expected), len(events), events)
	}

	for i, e := range expected {
		if events[i].ID != e.ID {
			t.Errorf("event %d: expected ID %q, got %q", i, e.ID, events[i].ID)
		}

		if events[i].Retry != e.Retry {
			t.Errorf("event %d: expected Retry %d, got %d", i, e.Retry, events[i].Retry)
		}
	}
}

func TestEventStreamDecoder_IDAndRetryDefaults(t *testing.T) {
	t.Parallel()

	d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader("data: hello\n\n")))
	events := collectEvents(t, d)

	if len(events) != 1 {
		t.Fatalf("expected 1 event, got %d", len(events))
	}

	if events[0].ID != "" {
		t.Errorf("expected empty ID when no id field was received, got %q", events[0].ID)
	}

	if events[0].Retry != -1 {
		t.Errorf("expected Retry to be -1 when no retry field was received, got %d", events[0].Retry)
	}
}

func TestEventStreamDecoder_InvalidIDAndRetryAreIgnored(t *testing.T) {
	t.Parallel()

	input := "id: 4\x002\nretry: -100\nretry: 5s\nretry:\ndata: hello\n\n"
	d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, d)

	if len(events) != 1 {
		t.Fatalf("expected 1 event, got %d", len(events))
	}

	if events[0].ID != "" {
		t.Errorf("expected an id containing NUL to be ignored, got %q", events[0].ID)
	}

	if events[0].Retry != -1 {
		t.Errorf("expected invalid retry values to be ignored, got %d", events[0].Retry)
	}
}

func TestEventStreamDecoder_LineExceedingBufferSize(t *testing.T) {
	t.Parallel()

	input := "data: " + strings.Repeat("x", 11<<20) + "\n\n"
	d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))

	if d.Next() {
		t.Fatal("expected Next to return false on buffer overflow")
	}

	if !errors.Is(d.Err(), bufio.ErrTooLong) {
		t.Fatalf("expected error to wrap bufio.ErrTooLong, got: %v", d.Err())
	}
}

func TestEventStreamDecoder_LineWithinBufferSize(t *testing.T) {
	t.Parallel()

	payload := strings.Repeat("x", 9<<20)
	input := "data: " + payload + "\n\n"
	d := sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input)))
	events := collectEvents(t, d)

	if len(events) != 1 {
		t.Fatalf("expected 1 event, got %d", len(events))
	}

	if !bytes.Equal(events[0].Data, []byte(payload)) {
		t.Fatal("expected the large payload to be read unaltered")
	}
}

func TestEventStreamDecoder_ReadError(t *testing.T) {
	t.Parallel()

	readErr := errors.New("read failure")
	d := sse.NewEventStreamDecoder(io.NopCloser(io.MultiReader(
		strings.NewReader("data: one\n\n"),
		&failingReader{err: readErr},
	)))

	if !d.Next() {
		t.Fatalf("expected the first event to be read, got error: %v", d.Err())
	}

	if d.Next() {
		t.Fatal("expected Next to return false on read error")
	}

	if !errors.Is(d.Err(), readErr) {
		t.Fatalf("expected error to wrap the read error, got: %v", d.Err())
	}
}

type failingReader struct {
	err error
}

func (r *failingReader) Read([]byte) (int, error) {
	return 0, r.err
}

func TestEventStreamDecoder_Close(t *testing.T) {
	t.Parallel()

	rc := &closeRecorder{Reader: strings.NewReader("data: hello\n\n")}
	d := sse.NewEventStreamDecoder(rc)

	err := d.Close()
	if err != nil {
		t.Fatalf("unexpected error on Close: %v", err)
	}

	if !rc.closed {
		t.Fatal("expected Close to close the underlying reader")
	}
}

func TestEventStreamDecoder_CloseError(t *testing.T) {
	t.Parallel()

	closeErr := errors.New("close failure")
	rc := &closeRecorder{Reader: strings.NewReader(""), err: closeErr}
	d := sse.NewEventStreamDecoder(rc)

	err := d.Close()
	if !errors.Is(err, closeErr) {
		t.Fatalf("expected error to wrap the close error, got: %v", err)
	}
}

func assertEventsEqual(t *testing.T, expected, actual []sse.Event) {
	t.Helper()

	if len(expected) != len(actual) {
		t.Fatalf("expected %d events, got %d: %+v", len(expected), len(actual), actual)
	}

	for i, e := range expected {
		if e.Type != actual[i].Type {
			t.Errorf("event %d: expected type %q, got %q", i, e.Type, actual[i].Type)
		}

		if !bytes.Equal(e.Data, actual[i].Data) {
			t.Errorf("event %d: expected data %q, got %q", i, e.Data, actual[i].Data)
		}
	}
}
