from typing import Any, Dict, List

import pytest
from requests import PreparedRequest, Response, Session

from algoliasearch.http.base_config import BaseConfig
from algoliasearch.http.exceptions import AlgoliaUnreachableHostException
from algoliasearch.http.hosts import Host, HostsCollection
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.transporter import Transporter
from algoliasearch.http.transporter_sync import TransporterSync
from algoliasearch.http.verb import Verb

# the first request fails on every host, the next one succeeds
STATUSES = [500, 500, 200]
SENT_URLS = [
    "https://host-one.test/1/test",
    "https://host-two.test/1/test",
    "https://host-one.test/1/test",
]


def create_config() -> BaseConfig:
    config = BaseConfig("test-app", "test-key")
    config.hosts = HostsCollection([Host("host-one.test"), Host("host-two.test")])
    return config


class StatusSyncSession(Session):
    def __init__(self) -> None:
        super().__init__()
        self.sent_urls: List[str] = []

    def send(self, request: PreparedRequest, **kwargs: Any) -> Response:  # type: ignore # the tests only need the recorded request
        response = Response()
        response.status_code = STATUSES[len(self.sent_urls)]
        response.encoding = "utf-8"
        response._content = b"{}"
        self.sent_urls.append(request.url or "")
        return response


class StatusAsyncResponse:
    def __init__(self, status: int) -> None:
        self.status = status
        self.headers: Dict[str, str] = {}
        self.reason = "OK"

    async def text(self) -> str:
        return "{}"

    async def __aenter__(self) -> "StatusAsyncResponse":
        return self

    async def __aexit__(self, *args: Any) -> None:
        return None


class StatusAsyncSession:
    def __init__(self) -> None:
        self.sent_urls: List[str] = []

    def request(self, **kwargs: Any) -> StatusAsyncResponse:
        response = StatusAsyncResponse(STATUSES[len(self.sent_urls)])
        self.sent_urls.append(str(kwargs.get("url", "")))
        return response


def test_sync_retries_every_host_once_all_are_down() -> None:
    config = create_config()
    transporter = TransporterSync(config)
    session = StatusSyncSession()
    transporter._session = session

    with pytest.raises(AlgoliaUnreachableHostException):
        transporter.request(
            verb=Verb.GET,
            path="/1/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    response = transporter.request(
        verb=Verb.GET,
        path="/1/test",
        request_options=RequestOptions(config).merge(),
        use_read_transporter=True,
    )

    assert response.status_code == 200
    assert session.sent_urls == SENT_URLS


async def test_async_retries_every_host_once_all_are_down() -> None:
    config = create_config()
    transporter = Transporter(config)
    session = StatusAsyncSession()
    transporter._session = session  # type: ignore[assignment]

    with pytest.raises(AlgoliaUnreachableHostException):
        await transporter.request(
            verb=Verb.GET,
            path="/1/test",
            request_options=RequestOptions(config).merge(),
            use_read_transporter=True,
        )

    response = await transporter.request(
        verb=Verb.GET,
        path="/1/test",
        request_options=RequestOptions(config).merge(),
        use_read_transporter=True,
    )

    assert response.status_code == 200
    assert session.sent_urls == SENT_URLS
