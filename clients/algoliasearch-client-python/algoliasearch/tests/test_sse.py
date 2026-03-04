"""Tests for the WHATWG-compliant SSE parser.

Covers all 16 WHATWG spec cases plus boundary/overflow edge cases,
for both sync (iter_sse_events) and async (aiter_sse_events) variants.
"""

import asyncio
import unittest
from typing import AsyncIterator, List

from algoliasearch.http.sse import ServerSentEvent, aiter_sse_events, iter_sse_events

# ---------------------------------------------------------------------------
# Helpers
# ---------------------------------------------------------------------------


def make_byte_chunks(text: str) -> List[bytes]:
    """Convert a string to a list with a single bytes chunk."""
    return [text.encode("utf-8")]


def make_multi_chunks(chunks: List[str]) -> List[bytes]:
    """Convert multiple strings to bytes chunks."""
    return [c.encode("utf-8") for c in chunks]


class AsyncByteIter:
    """Wraps a list of bytes into an async iterable."""

    def __init__(self, chunks: List[bytes]) -> None:
        self._chunks = chunks

    def __aiter__(self) -> AsyncIterator[bytes]:
        return self._iter()

    async def _iter(self) -> AsyncIterator[bytes]:
        for chunk in self._chunks:
            yield chunk


def collect_sync(text: str) -> List[ServerSentEvent]:
    """Collect all SSE events from a text string (sync)."""
    return list(iter_sse_events(make_byte_chunks(text)))


def collect_sync_multi(chunks: List[str]) -> List[ServerSentEvent]:
    """Collect all SSE events from multiple text chunks (sync)."""
    return list(iter_sse_events(make_multi_chunks(chunks)))


def collect_sync_raw(raw_chunks: List[bytes]) -> List[ServerSentEvent]:
    """Collect all SSE events from raw byte chunks (sync)."""
    return list(iter_sse_events(raw_chunks))


async def _collect_async(chunks: List[bytes]) -> List[ServerSentEvent]:
    """Collect all SSE events from byte chunks (async)."""
    result: List[ServerSentEvent] = []
    async for event in aiter_sse_events(AsyncByteIter(chunks)):
        result.append(event)
    return result


def collect_async(text: str) -> List[ServerSentEvent]:
    """Collect all SSE events from a text string (async, run via asyncio)."""
    return asyncio.run(_collect_async(make_byte_chunks(text)))


def collect_async_multi(chunks: List[str]) -> List[ServerSentEvent]:
    """Collect all SSE events from multiple text chunks (async)."""
    return asyncio.run(_collect_async(make_multi_chunks(chunks)))


def collect_async_raw(raw_chunks: List[bytes]) -> List[ServerSentEvent]:
    """Collect all SSE events from raw byte chunks (async)."""
    return asyncio.run(_collect_async(raw_chunks))


# ---------------------------------------------------------------------------
# 1. Single data event
# ---------------------------------------------------------------------------


class TestSingleDataEvent(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: hello\n\n")
        assert len(events) == 1
        assert events[0] == ServerSentEvent(data="hello", event="", id=None, retry=None)

    def test_async(self) -> None:
        events = collect_async("data: hello\n\n")
        assert len(events) == 1
        assert events[0] == ServerSentEvent(data="hello", event="", id=None, retry=None)


# ---------------------------------------------------------------------------
# 2. Multi-line data
# ---------------------------------------------------------------------------


class TestMultiLineData(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: line1\ndata: line2\n\n")
        assert len(events) == 1
        assert events[0].data == "line1\nline2"

    def test_async(self) -> None:
        events = collect_async("data: line1\ndata: line2\n\n")
        assert len(events) == 1
        assert events[0].data == "line1\nline2"


# ---------------------------------------------------------------------------
# 3. Event type
# ---------------------------------------------------------------------------


class TestEventType(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("event: custom\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].event == "custom"
        assert events[0].data == "hi"

    def test_async(self) -> None:
        events = collect_async("event: custom\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].event == "custom"
        assert events[0].data == "hi"


# ---------------------------------------------------------------------------
# 4. Comment ignored
# ---------------------------------------------------------------------------


class TestCommentIgnored(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync(": comment\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].data == "hi"

    def test_async(self) -> None:
        events = collect_async(": comment\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].data == "hi"


# ---------------------------------------------------------------------------
# 5. Empty data suppressed (no data field → no dispatch)
# ---------------------------------------------------------------------------


class TestEmptyDataSuppressed(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("event: ping\n\n")
        assert len(events) == 0

    def test_async(self) -> None:
        events = collect_async("event: ping\n\n")
        assert len(events) == 0


# ---------------------------------------------------------------------------
# 6. Field with no colon
# ---------------------------------------------------------------------------


class TestFieldNoColon(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data\n\n")
        assert len(events) == 1
        assert events[0].data == ""

    def test_async(self) -> None:
        events = collect_async("data\n\n")
        assert len(events) == 1
        assert events[0].data == ""


# ---------------------------------------------------------------------------
# 7. Single space strip (two spaces in, one space out)
# ---------------------------------------------------------------------------


class TestSingleSpaceStrip(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data:  hello\n\n")
        assert len(events) == 1
        assert events[0].data == " hello"

    def test_async(self) -> None:
        events = collect_async("data:  hello\n\n")
        assert len(events) == 1
        assert events[0].data == " hello"


# ---------------------------------------------------------------------------
# 8. Unknown field ignored
# ---------------------------------------------------------------------------


class TestUnknownFieldIgnored(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("foo: bar\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].data == "hi"

    def test_async(self) -> None:
        events = collect_async("foo: bar\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].data == "hi"


# ---------------------------------------------------------------------------
# 9. id persistence
# ---------------------------------------------------------------------------


class TestIdPersistence(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("id: 42\ndata: a\n\ndata: b\n\n")
        assert len(events) == 2
        assert events[0].id == "42"
        assert events[0].data == "a"
        assert events[1].id == "42"
        assert events[1].data == "b"

    def test_async(self) -> None:
        events = collect_async("id: 42\ndata: a\n\ndata: b\n\n")
        assert len(events) == 2
        assert events[0].id == "42"
        assert events[1].id == "42"


# ---------------------------------------------------------------------------
# 10. id with NULL
# ---------------------------------------------------------------------------


class TestIdWithNull(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("id: foo\x00bar\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].id is None

    def test_async(self) -> None:
        events = collect_async("id: foo\x00bar\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].id is None


# ---------------------------------------------------------------------------
# 11. retry digits only
# ---------------------------------------------------------------------------


class TestRetryDigitsOnly(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("retry: 3000\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].retry == 3000

    def test_async(self) -> None:
        events = collect_async("retry: 3000\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].retry == 3000


# ---------------------------------------------------------------------------
# 12. retry non-digits
# ---------------------------------------------------------------------------


class TestRetryNonDigits(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("retry: 3s\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].retry is None

    def test_async(self) -> None:
        events = collect_async("retry: 3s\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].retry is None


# ---------------------------------------------------------------------------
# 13. CR line endings
# ---------------------------------------------------------------------------


class TestCRLineEndings(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: hello\r\r")
        assert len(events) == 1
        assert events[0].data == "hello"

    def test_async(self) -> None:
        events = collect_async("data: hello\r\r")
        assert len(events) == 1
        assert events[0].data == "hello"


# ---------------------------------------------------------------------------
# 14. CRLF line endings
# ---------------------------------------------------------------------------


class TestCRLFLineEndings(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: hello\r\n\r\n")
        assert len(events) == 1
        assert events[0].data == "hello"

    def test_async(self) -> None:
        events = collect_async("data: hello\r\n\r\n")
        assert len(events) == 1
        assert events[0].data == "hello"


# ---------------------------------------------------------------------------
# 15. Mixed line endings
# ---------------------------------------------------------------------------


class TestMixedLineEndings(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: a\rdata: b\n\n")
        assert len(events) == 1
        assert events[0].data == "a\nb"

    def test_async(self) -> None:
        events = collect_async("data: a\rdata: b\n\n")
        assert len(events) == 1
        assert events[0].data == "a\nb"


# ---------------------------------------------------------------------------
# 16. Stream ends mid-event (EOF without blank line)
# ---------------------------------------------------------------------------


class TestStreamEndsMidEvent(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("data: partial")
        assert len(events) == 0

    def test_async(self) -> None:
        events = collect_async("data: partial")
        assert len(events) == 0


# ---------------------------------------------------------------------------
# 17. trailing_cr across chunk boundaries
# ---------------------------------------------------------------------------


class TestTrailingCRAcrossChunks(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync_raw([b"data: hello\r", b"\ndata: world\r\n\r\n"])
        assert len(events) == 1
        assert events[0].data == "hello\nworld"

    def test_async(self) -> None:
        events = collect_async_raw([b"data: hello\r", b"\ndata: world\r\n\r\n"])
        assert len(events) == 1
        assert events[0].data == "hello\nworld"


# ---------------------------------------------------------------------------
# 18. 10MB buffer cap
# ---------------------------------------------------------------------------


class TestBufferCap(unittest.TestCase):
    def test_sync(self) -> None:
        huge_line = "data: " + "x" * (10 * 1024 * 1024 + 1)
        raised = False
        try:
            collect_sync(huge_line)
        except ValueError as e:
            raised = True
            assert "10 MB" in str(e)
        assert raised, "Expected ValueError to be raised"

    def test_async(self) -> None:
        huge_line = "data: " + "x" * (10 * 1024 * 1024 + 1)
        raised = False
        try:
            collect_async(huge_line)
        except ValueError as e:
            raised = True
            assert "10 MB" in str(e)
        assert raised, "Expected ValueError to be raised"


# ---------------------------------------------------------------------------
# 19. eventType resets on suppressed dispatch
# ---------------------------------------------------------------------------


class TestEventTypeResetsOnSuppressedDispatch(unittest.TestCase):
    def test_sync(self) -> None:
        events = collect_sync("event: custom\n\ndata: hi\n\n")
        # First blank line: no data → suppressed, but eventType resets
        # Second event: data="hi", event="" (not "custom")
        assert len(events) == 1
        assert events[0].data == "hi"
        assert events[0].event == ""

    def test_async(self) -> None:
        events = collect_async("event: custom\n\ndata: hi\n\n")
        assert len(events) == 1
        assert events[0].data == "hi"
        assert events[0].event == ""
