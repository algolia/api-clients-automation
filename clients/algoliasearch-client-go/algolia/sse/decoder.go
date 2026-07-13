// Package sse implements a WHATWG-compliant Server-Sent Events parser.
//
// The package is split in two layers:
//   - [Decoder] performs the raw SSE parsing, turning a byte stream into [Event] values.
//   - [Stream] deserializes the payload of each event into a typed value.
//
// Reference: https://html.spec.whatwg.org/multipage/server-sent-events.html#event-stream-interpretation
package sse

import (
	"bufio"
	"bytes"
	"fmt"
	"io"
)

// maxLineSize bounds a single line of the stream to 8 MB.
const maxLineSize = 8 << 20

// Event is a single Server-Sent Event dispatched from the event stream.
type Event struct {
	// Type is the event type from the "event:" field, or "" when the field is absent.
	Type string
	// Data is the concatenation of the "data:" field values, joined by '\n'.
	Data []byte
}

// Decoder decodes a raw byte stream into Server-Sent Events.
type Decoder interface {
	// Next advances the decoder to the next event. It returns false when the
	// stream is exhausted or an error occurred, in which case Err reports it.
	Next() bool
	// Event returns the event read by the last successful call to Next.
	Event() Event
	// Err returns the first error encountered while reading the stream, or
	// nil if the stream simply ended.
	Err() error
	// Close closes the underlying reader.
	Close() error
}

// NewEventStreamDecoder returns a [Decoder] reading Server-Sent Events from
// rc. Closing the decoder closes rc.
func NewEventStreamDecoder(rc io.ReadCloser) Decoder { //nolint:ireturn // The interface is the API, the implementation is not exposed.
	scn := bufio.NewScanner(rc)
	scn.Buffer(make([]byte, 0, 64<<10), maxLineSize)
	scn.Split(scanLines)

	return &eventStreamDecoder{rc: rc, scn: scn}
}

type eventStreamDecoder struct {
	rc         io.ReadCloser
	scn        *bufio.Scanner
	evt        Event
	err        error
	bomChecked bool
}

func (d *eventStreamDecoder) Next() bool {
	if d.err != nil {
		return false
	}

	var (
		data      bytes.Buffer
		hasData   bool
		eventType string
	)

	for d.scn.Scan() {
		line := d.scn.Bytes()

		// Strip the UTF-8 BOM from the very first line only.
		if !d.bomChecked {
			d.bomChecked = true
			line = bytes.TrimPrefix(line, []byte("\xEF\xBB\xBF"))
		}

		// A blank line dispatches the buffered event, if any.
		if len(line) == 0 {
			// The event type resets on every blank line, dispatch or not.
			currentEventType := eventType
			eventType = ""

			if !hasData {
				continue
			}

			d.evt = Event{Type: currentEventType, Data: data.Bytes()}

			return true
		}

		// Comment line.
		if line[0] == ':' {
			continue
		}

		// A line without a colon is a field with an empty value.
		field, value, _ := bytes.Cut(line, []byte{':'})
		// A single space after the colon is part of the separator.
		if len(value) > 0 && value[0] == ' ' {
			value = value[1:]
		}

		switch string(field) {
		case "data":
			if hasData {
				data.WriteByte('\n')
			}

			data.Write(value)

			hasData = true
		case "event":
			eventType = string(value)
		case "id", "retry":
			// Parsed for spec compliance but not surfaced: the client does
			// not implement SSE reconnection, so the last event ID and the
			// retry interval are unused.
		default:
			// Unknown fields are ignored, per spec.
		}
	}

	// An event that is not followed by a blank line before the end of the
	// stream is incomplete and is discarded, per spec.
	err := d.scn.Err()
	if err != nil {
		d.err = fmt.Errorf("cannot read event stream: %w", err)
	}

	return false
}

func (d *eventStreamDecoder) Event() Event {
	return d.evt
}

func (d *eventStreamDecoder) Err() error {
	return d.err
}

func (d *eventStreamDecoder) Close() error {
	err := d.rc.Close()
	if err != nil {
		return fmt.Errorf("cannot close event stream: %w", err)
	}

	return nil
}

// scanLines is a [bufio.SplitFunc] handling the three line endings allowed by
// the WHATWG event-stream format: LF, CRLF and bare CR. Unlike
// [bufio.ScanLines], a bare CR terminates a line, and a CRLF sequence split
// across two reads is not mistaken for two line endings.
func scanLines(data []byte, atEOF bool) (int, []byte, error) {
	if atEOF && len(data) == 0 {
		return 0, nil, nil
	}

	if i := bytes.IndexAny(data, "\r\n"); i >= 0 {
		if data[i] == '\n' {
			return i + 1, data[:i], nil
		}

		// The line ends with a CR: peek at the next byte to consume a
		// potential CRLF sequence as a single line ending.
		if i+1 < len(data) {
			if data[i+1] == '\n' {
				return i + 2, data[:i], nil
			}

			return i + 1, data[:i], nil
		}

		// The CR is the last byte of the buffer: unless the stream is done,
		// request more data to see whether a LF follows.
		if atEOF {
			return i + 1, data[:i], nil
		}

		return 0, nil, nil
	}

	if atEOF {
		return len(data), data, nil
	}

	return 0, nil, nil
}
