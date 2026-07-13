package sse

import (
	"encoding/json"
	"fmt"
)

// Stream deserializes the payload of each event of a Server-Sent Events
// stream into a value of type T.
type Stream[T any] struct {
	decoder Decoder
	cur     T
	err     error
}

// NewStream wraps a [Decoder] into a typed Stream. The err argument allows
// callers to forward the error of the call that produced the decoder in a
// single expression: when non-nil, the stream is created in a failed state
// and Err reports it.
func NewStream[T any](decoder Decoder, err error) *Stream[T] {
	return &Stream[T]{decoder: decoder, err: err}
}

// Next advances the stream to the next event and deserializes its payload
// into the value returned by Current. It returns false when the stream is
// exhausted or an error occurred, in which case Err reports it.
func (s *Stream[T]) Next() bool {
	if s.err != nil {
		return false
	}

	if !s.decoder.Next() {
		s.err = s.decoder.Err()

		return false
	}

	var cur T

	err := json.Unmarshal(s.decoder.Event().Data, &cur)
	if err != nil {
		s.err = fmt.Errorf("cannot unmarshal event data: %w", err)

		return false
	}

	s.cur = cur

	return true
}

// Current returns the value parsed by the last successful call to Next.
func (s *Stream[T]) Current() T { //nolint:ireturn // T is a type parameter, not an interface.
	return s.cur
}

// Err returns the terminal error of the stream, or nil if the stream simply
// ended.
func (s *Stream[T]) Err() error {
	return s.err
}

// Close closes the underlying reader.
func (s *Stream[T]) Close() error {
	if s.decoder == nil {
		return nil
	}

	err := s.decoder.Close()
	if err != nil {
		return fmt.Errorf("cannot close stream: %w", err)
	}

	return nil
}
