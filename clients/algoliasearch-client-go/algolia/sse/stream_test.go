package sse_test

import (
	"errors"
	"io"
	"strings"
	"testing"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/sse"
)

type message struct {
	Text  string `json:"text"`
	Index int    `json:"index"`
}

func newMessageStream(input string) *sse.Stream[message] {
	return sse.NewStream[message](sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input))), nil)
}

func TestStream_TypedDeserialization(t *testing.T) {
	t.Parallel()

	s := newMessageStream(`data: {"text":"first","index":0}` + "\n\n" + `data: {"text":"second","index":1}` + "\n\n")

	var messages []message

	for s.Next() {
		messages = append(messages, s.Current())
	}

	err := s.Err()
	if err != nil {
		t.Fatalf("unexpected stream error: %v", err)
	}

	expected := []message{{Text: "first", Index: 0}, {Text: "second", Index: 1}}
	if len(messages) != len(expected) {
		t.Fatalf("expected %d messages, got %d", len(expected), len(messages))
	}

	for i, m := range expected {
		if messages[i] != m {
			t.Errorf("message %d: expected %+v, got %+v", i, m, messages[i])
		}
	}
}

func TestStream_FieldsDoNotLeakAcrossEvents(t *testing.T) {
	t.Parallel()

	s := newMessageStream(`data: {"text":"first","index":7}` + "\n\n" + `data: {"index":8}` + "\n\n")

	if !s.Next() {
		t.Fatalf("expected the first event to be read, got error: %v", s.Err())
	}

	if !s.Next() {
		t.Fatalf("expected the second event to be read, got error: %v", s.Err())
	}

	if got := s.Current(); got.Text != "" || got.Index != 8 {
		t.Fatalf("expected {Text:\"\" Index:8}, got %+v", got)
	}
}

func TestStream_ParseErrorIsTerminal(t *testing.T) {
	t.Parallel()

	s := newMessageStream(`data: {"text":"valid"}` + "\n\n" + "data: not json\n\n" + `data: {"text":"unreachable"}` + "\n\n")

	if !s.Next() {
		t.Fatalf("expected the first event to be read, got error: %v", s.Err())
	}

	if s.Next() {
		t.Fatal("expected Next to return false on JSON parse error")
	}

	if s.Err() == nil {
		t.Fatal("expected a terminal error after a JSON parse failure")
	}

	if s.Next() {
		t.Fatal("expected Next to keep returning false after a terminal error")
	}
}

func TestStream_DecoderErrorIsSurfaced(t *testing.T) {
	t.Parallel()

	readErr := errors.New("read failure")
	s := sse.NewStream[message](sse.NewEventStreamDecoder(io.NopCloser(&failingReader{err: readErr})), nil)

	if s.Next() {
		t.Fatal("expected Next to return false on decoder error")
	}

	if !errors.Is(s.Err(), readErr) {
		t.Fatalf("expected error to wrap the read error, got: %v", s.Err())
	}
}

func TestStream_CleanEndOfStream(t *testing.T) {
	t.Parallel()

	s := newMessageStream(`data: {"text":"only"}` + "\n\n")

	if !s.Next() {
		t.Fatalf("expected the event to be read, got error: %v", s.Err())
	}

	if s.Next() {
		t.Fatal("expected Next to return false at end of stream")
	}

	err := s.Err()
	if err != nil {
		t.Fatalf("expected no error at clean end of stream, got: %v", err)
	}
}

func TestStream_CreatedInFailedState(t *testing.T) {
	t.Parallel()

	initialErr := errors.New("request failure")
	s := sse.NewStream[message](nil, initialErr)

	if s.Next() {
		t.Fatal("expected Next to return false on a failed stream")
	}

	if !errors.Is(s.Err(), initialErr) {
		t.Fatalf("expected the initial error to be reported, got: %v", s.Err())
	}

	err := s.Close()
	if err != nil {
		t.Fatalf("expected Close to be a no-op without a decoder, got: %v", err)
	}
}

func TestStream_CloseClosesDecoder(t *testing.T) {
	t.Parallel()

	rc := &closeRecorder{Reader: strings.NewReader("")}
	s := sse.NewStream[message](sse.NewEventStreamDecoder(rc), nil)

	err := s.Close()
	if err != nil {
		t.Fatalf("unexpected error on Close: %v", err)
	}

	if !rc.closed {
		t.Fatal("expected Close to close the underlying reader")
	}
}
