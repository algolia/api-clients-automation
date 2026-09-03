from contextlib import contextmanager
from typing import Any, AsyncIterator, Iterator, List, Optional, Tuple

from multidict import CIMultiDict
from requests import PreparedRequest, Response, Session
from requests.structures import CaseInsensitiveDict

from algoliasearch.http import transporter as async_transporter
from algoliasearch.http import transporter_sync as sync_transporter
from algoliasearch.http.base_config import BaseConfig
from algoliasearch.http.exceptions import RequestException
from algoliasearch.http.hosts import CallType, Host, HostsCollection
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.retry import (
    DEFAULT_RATE_LIMIT_WAIT_SECONDS,
    parse_retry_after_seconds,
)
from algoliasearch.http.transporter import Transporter
from algoliasearch.http.transporter_sync import TransporterSync
from algoliasearch.http.verb import Verb

RATE_LIMITED_BODY = '{"message":"Too many requests"}'
SUCCESS_BODY = '{"message":"ok rate limit retry"}'
SSE_BODY = "data: hello\n\n"


def create_config(
    hosts: int = 1, max_rate_limit_retries: Optional[int] = None
) -> BaseConfig:
    config = BaseConfig("test-app", "test-key")
    if max_rate_limit_retries is not None:
        config.max_rate_limit_retries = max_rate_limit_retries
    config.hosts = HostsCollection(
        [
            Host("localhost{}".format(index), accept=CallType.READ | CallType.WRITE)
            for index in range(hosts)
        ]
    )
    return config


class FakeSyncResponse(Response):
    def __init__(
        self,
        status_code: int,
        retry_after: Optional[str] = None,
        body: str = SUCCESS_BODY,
    ) -> None:
        super().__init__()
        self.status_code = status_code
        self.headers = CaseInsensitiveDict()
        if retry_after is not None:
            self.headers["Retry-After"] = retry_after
        self.reason = "Too Many Requests" if status_code == 429 else "OK"
        self.closes = 0
        self._body = body

    @property
    def text(self) -> str:
        return self._body

    def iter_content(  # type: ignore[override]
        self, chunk_size: Optional[int] = 1, decode_unicode: bool = False
    ) -> Iterator[bytes]:
        _ = chunk_size
        _ = decode_unicode
        yield self._body.encode("utf-8")

    def close(self) -> None:
        self.closes += 1


class RecordingSyncSession(Session):
    def __init__(self, responses: List[FakeSyncResponse]) -> None:
        super().__init__()
        self._responses = list(responses)
        self.sent_urls: List[str] = []

    def send(self, request: PreparedRequest, **kwargs: Any) -> Response:  # type: ignore # the tests only need the recorded request
        _ = kwargs
        self.sent_urls.append(request.url or "")
        return self._responses.pop(0)


class AsyncByteStream:
    def __init__(self, payload: bytes) -> None:
        self._payload = payload

    async def _iter(self) -> AsyncIterator[bytes]:
        yield self._payload

    def iter_any(self) -> AsyncIterator[bytes]:
        return self._iter()


class FakeAsyncResponse:
    def __init__(
        self,
        status: int,
        retry_after: Optional[str] = None,
        body: str = SUCCESS_BODY,
    ) -> None:
        self.status = status
        self.headers: CIMultiDict[str] = CIMultiDict()
        if retry_after is not None:
            self.headers["Retry-After"] = retry_after
        self.reason = "Too Many Requests" if status == 429 else "OK"
        self.releases = 0
        self.content = AsyncByteStream(body.encode("utf-8"))
        self._body = body

    async def text(self) -> str:
        return self._body

    def release(self) -> None:
        self.releases += 1


class FakeRequestContext:
    def __init__(self, response: FakeAsyncResponse) -> None:
        self._response = response

    async def _resolve(self) -> FakeAsyncResponse:
        return self._response

    def __await__(self) -> Any:
        return self._resolve().__await__()

    async def __aenter__(self) -> FakeAsyncResponse:
        return self._response

    async def __aexit__(self, *args: Any) -> None:
        return None


class RecordingAsyncSession:
    def __init__(self, responses: List[FakeAsyncResponse]) -> None:
        self._responses = list(responses)
        self.sent_urls: List[str] = []

    def request(self, **kwargs: Any) -> FakeRequestContext:
        self.sent_urls.append(str(kwargs.get("url", "")))
        return FakeRequestContext(self._responses.pop(0))


@contextmanager
def recorded_sync_sleep() -> Iterator[List[float]]:
    waits: List[float] = []
    original = sync_transporter.sleep

    def fake_sleep(seconds: float) -> None:
        waits.append(seconds)

    sync_transporter.sleep = fake_sleep  # type: ignore[assignment]
    try:
        yield waits
    finally:
        sync_transporter.sleep = original  # type: ignore[assignment]


@contextmanager
def recorded_async_sleep() -> Iterator[List[float]]:
    waits: List[float] = []
    original = async_transporter.sleep

    async def fake_sleep(seconds: float) -> None:
        waits.append(seconds)

    async_transporter.sleep = fake_sleep  # type: ignore[assignment]
    try:
        yield waits
    finally:
        async_transporter.sleep = original  # type: ignore[assignment]


def build_sync_transporter(
    config: BaseConfig, responses: List[FakeSyncResponse]
) -> Tuple[TransporterSync, RecordingSyncSession]:
    transporter = TransporterSync(config)
    session = RecordingSyncSession(responses)
    transporter._session = session
    return transporter, session


def build_async_transporter(
    config: BaseConfig, responses: List[FakeAsyncResponse]
) -> Tuple[Transporter, RecordingAsyncSession]:
    transporter = Transporter(config)
    session = RecordingAsyncSession(responses)
    transporter._session = session  # type: ignore[assignment]
    return transporter, session


def test_the_default_budget_is_three_retries() -> None:
    assert BaseConfig("test-app", "test-key").max_rate_limit_retries == 3


def test_retry_after_honors_only_positive_whole_seconds() -> None:
    assert parse_retry_after_seconds({"retry-after": "2"}) == 2.0
    assert parse_retry_after_seconds({"retry-after": " 3 "}) == 3.0
    assert parse_retry_after_seconds({"retry-after": "86400"}) == 86400.0

    assert parse_retry_after_seconds(None) == DEFAULT_RATE_LIMIT_WAIT_SECONDS
    assert parse_retry_after_seconds({}) == DEFAULT_RATE_LIMIT_WAIT_SECONDS

    for value in [
        "",
        "   ",
        "0",
        "-1",
        "1.5",
        "+2",
        "120abc",
        "Wed, 21 Oct 2015 07:28:00 GMT",
    ]:
        assert (
            parse_retry_after_seconds({"retry-after": value})
            == DEFAULT_RATE_LIMIT_WAIT_SECONDS
        ), value


def test_retry_after_is_read_whatever_the_header_casing() -> None:
    assert parse_retry_after_seconds(CaseInsensitiveDict({"Retry-After": "5"})) == 5.0
    assert parse_retry_after_seconds(CIMultiDict({"RETRY-AFTER": "5"})) == 5.0


def test_sync_waits_and_retries_the_same_host_on_429() -> None:
    config = create_config(hosts=2)
    transporter, session = build_sync_transporter(
        config,
        [
            FakeSyncResponse(429, retry_after="2", body=RATE_LIMITED_BODY),
            FakeSyncResponse(200),
        ],
    )

    with recorded_sync_sleep() as waits:
        response = transporter.request(
            verb=Verb.GET,
            path="/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    assert response.status_code == 200
    assert waits == [2.0]
    assert session.sent_urls == ["https://localhost0/test"] * 2

    host = transporter._hosts[0]
    assert host.up is True
    assert host.retry_count == 0


def test_sync_falls_back_to_one_second_without_the_header() -> None:
    config = create_config()
    transporter, session = build_sync_transporter(
        config,
        [FakeSyncResponse(429, body=RATE_LIMITED_BODY), FakeSyncResponse(200)],
    )

    with recorded_sync_sleep() as waits:
        transporter.request(
            verb=Verb.GET,
            path="/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    assert waits == [1.0]
    assert len(session.sent_urls) == 2


def test_sync_raises_once_the_budget_is_spent() -> None:
    config = create_config()
    transporter, session = build_sync_transporter(
        config,
        [FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)] * 4,
    )

    with recorded_sync_sleep() as waits:
        try:
            transporter.request(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert str(exception) == "Too many requests"
            assert exception.status_code == 429

    assert waits == [1.0, 1.0, 1.0]
    assert len(session.sent_urls) == 4
    assert transporter._hosts[0].up is True
    assert transporter._hosts[0].retry_count == 0


def test_sync_fails_on_the_first_429_when_retries_are_disabled() -> None:
    config = create_config(max_rate_limit_retries=0)
    transporter, session = build_sync_transporter(
        config, [FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)]
    )

    with recorded_sync_sleep() as waits:
        try:
            transporter.request(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert exception.status_code == 429

    assert waits == []
    assert len(session.sent_urls) == 1


def test_sync_does_not_fail_over_to_another_host_on_429() -> None:
    config = create_config(hosts=2)
    transporter, session = build_sync_transporter(
        config,
        [
            FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY),
            FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY),
            FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY),
            FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY),
        ],
    )

    with recorded_sync_sleep() as waits:
        try:
            transporter.request(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
            raise AssertionError("expected a RequestException")
        except RequestException:
            pass

    assert waits == [1.0, 1.0, 1.0]
    assert session.sent_urls == ["https://localhost0/test"] * 4


def test_sync_request_stream_waits_and_retries_on_429() -> None:
    config = create_config()
    rate_limited = FakeSyncResponse(429, retry_after="2", body=RATE_LIMITED_BODY)
    transporter, session = build_sync_transporter(
        config, [rate_limited, FakeSyncResponse(200, body=SSE_BODY)]
    )

    with recorded_sync_sleep() as waits:
        events = list(
            transporter.request_stream(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
        )

    assert [event.data for event in events] == ["hello"]
    assert waits == [2.0]
    assert len(session.sent_urls) == 2
    assert rate_limited.closes == 1


def test_sync_request_stream_raises_once_the_budget_is_spent() -> None:
    config = create_config(max_rate_limit_retries=1)
    transporter, session = build_sync_transporter(
        config,
        [FakeSyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)] * 2,
    )

    with recorded_sync_sleep() as waits:
        try:
            list(
                transporter.request_stream(
                    verb=Verb.GET,
                    path="/test",
                    request_options=RequestOptions(config).merge(),
                    use_read_transporter=True,
                )
            )
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert exception.status_code == 429

    assert waits == [1.0]
    assert len(session.sent_urls) == 2


async def test_async_waits_and_retries_the_same_host_on_429() -> None:
    config = create_config(hosts=2)
    transporter, session = build_async_transporter(
        config,
        [
            FakeAsyncResponse(429, retry_after="2", body=RATE_LIMITED_BODY),
            FakeAsyncResponse(200),
        ],
    )

    with recorded_async_sleep() as waits:
        response = await transporter.request(
            verb=Verb.GET,
            path="/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    assert response.status_code == 200
    assert waits == [2.0]
    assert session.sent_urls == ["https://localhost0/test"] * 2

    host = transporter._hosts[0]
    assert host.up is True
    assert host.retry_count == 0


async def test_async_falls_back_to_one_second_without_the_header() -> None:
    config = create_config()
    transporter, session = build_async_transporter(
        config,
        [FakeAsyncResponse(429, body=RATE_LIMITED_BODY), FakeAsyncResponse(200)],
    )

    with recorded_async_sleep() as waits:
        await transporter.request(
            verb=Verb.GET,
            path="/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    assert waits == [1.0]
    assert len(session.sent_urls) == 2


async def test_async_raises_once_the_budget_is_spent() -> None:
    config = create_config()
    transporter, session = build_async_transporter(
        config,
        [FakeAsyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)] * 4,
    )

    with recorded_async_sleep() as waits:
        try:
            await transporter.request(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert str(exception) == "Too many requests"
            assert exception.status_code == 429

    assert waits == [1.0, 1.0, 1.0]
    assert len(session.sent_urls) == 4
    assert transporter._hosts[0].up is True
    assert transporter._hosts[0].retry_count == 0


async def test_async_fails_on_the_first_429_when_retries_are_disabled() -> None:
    config = create_config(max_rate_limit_retries=0)
    transporter, session = build_async_transporter(
        config, [FakeAsyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)]
    )

    with recorded_async_sleep() as waits:
        try:
            await transporter.request(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert exception.status_code == 429

    assert waits == []
    assert len(session.sent_urls) == 1


async def test_async_request_stream_waits_and_retries_on_429() -> None:
    config = create_config()
    rate_limited = FakeAsyncResponse(429, retry_after="2", body=RATE_LIMITED_BODY)
    transporter, session = build_async_transporter(
        config, [rate_limited, FakeAsyncResponse(200, body=SSE_BODY)]
    )

    with recorded_async_sleep() as waits:
        events = [
            event
            async for event in transporter.request_stream(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            )
        ]

    assert [event.data for event in events] == ["hello"]
    assert waits == [2.0]
    assert len(session.sent_urls) == 2
    assert rate_limited.releases == 1


async def test_async_request_stream_raises_once_the_budget_is_spent() -> None:
    config = create_config(max_rate_limit_retries=1)
    transporter, session = build_async_transporter(
        config,
        [FakeAsyncResponse(429, retry_after="1", body=RATE_LIMITED_BODY)] * 2,
    )

    with recorded_async_sleep() as waits:
        try:
            async for _ in transporter.request_stream(
                verb=Verb.GET,
                path="/test",
                request_options=RequestOptions(config).merge(),
                use_read_transporter=True,
            ):
                pass
            raise AssertionError("expected a RequestException")
        except RequestException as exception:
            assert exception.status_code == 429

    assert waits == [1.0]
    assert len(session.sent_urls) == 2
