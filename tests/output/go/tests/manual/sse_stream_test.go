package manual

import (
	"io"
	"strings"
	"testing"

	"github.com/stretchr/testify/require"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/sse"
)

type message struct {
	Text  string `json:"text"`
	Index int    `json:"index"`
}

func newMessageStream(input string) *sse.Stream[message] {
	return sse.NewStream[message](sse.NewEventStreamDecoder(io.NopCloser(strings.NewReader(input))), nil)
}

func TestSSEStreamTypedDeserialization(t *testing.T) {
	stream := newMessageStream(`data: {"text":"first","index":0}` + "\n\n" + `data: {"text":"second","index":1}` + "\n\n")

	var messages []message

	for stream.Next() {
		event := stream.Current()
		require.NoError(t, event.Err)

		messages = append(messages, *event.Data)
	}

	require.NoError(t, stream.Err())
	require.Equal(t, []message{{Text: "first", Index: 0}, {Text: "second", Index: 1}}, messages)
}

func TestSSEStreamFieldsDoNotLeakAcrossEvents(t *testing.T) {
	stream := newMessageStream(`data: {"text":"first","index":7}` + "\n\n" + `data: {"index":8}` + "\n\n")

	require.True(t, stream.Next())
	require.True(t, stream.Next())
	require.Equal(t, message{Text: "", Index: 8}, *stream.Current().Data)
}

func TestSSEStreamParseErrorIsPerEvent(t *testing.T) {
	stream := newMessageStream(`data: {"text":"valid"}` + "\n\n" + "data: not json\n\n" + `data: {"text":"still reachable"}` + "\n\n")

	require.True(t, stream.Next())
	require.NoError(t, stream.Current().Err)
	require.Equal(t, "valid", stream.Current().Data.Text)

	require.True(t, stream.Next())
	require.Error(t, stream.Current().Err)
	require.Nil(t, stream.Current().Data)
	require.Equal(t, "not json", string(stream.Current().Raw.Data))

	require.True(t, stream.Next())
	require.NoError(t, stream.Current().Err)
	require.Equal(t, "still reachable", stream.Current().Data.Text)

	require.False(t, stream.Next())
	require.NoError(t, stream.Err())
}

func TestSSEStreamDecoderErrorIsSurfaced(t *testing.T) {
	stream := sse.NewStream[message](sse.NewEventStreamDecoder(io.NopCloser(&failingReader{err: errReadFailure})), nil)

	require.False(t, stream.Next())
	require.ErrorIs(t, stream.Err(), errReadFailure)
}

func TestSSEStreamCleanEndOfStream(t *testing.T) {
	stream := newMessageStream(`data: {"text":"only"}` + "\n\n")

	require.True(t, stream.Next())
	require.False(t, stream.Next())
	require.NoError(t, stream.Err())
}

func TestSSEStreamNilDecoder(t *testing.T) {
	stream := sse.NewStream[message](nil, nil)

	require.False(t, stream.Next())
	require.NoError(t, stream.Err())
	require.NoError(t, stream.Close())
}

func TestSSEStreamCreatedInFailedState(t *testing.T) {
	stream := sse.NewStream[message](nil, errRequestFailure)

	require.False(t, stream.Next())
	require.ErrorIs(t, stream.Err(), errRequestFailure)
	require.NoError(t, stream.Close())
}

func TestSSEStreamCloseClosesDecoder(t *testing.T) {
	rc := &closeRecorder{Reader: strings.NewReader("")}
	stream := sse.NewStream[message](sse.NewEventStreamDecoder(rc), nil)

	require.NoError(t, stream.Close())
	require.True(t, rc.closed)
}
