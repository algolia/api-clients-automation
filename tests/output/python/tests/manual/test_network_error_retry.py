from typing import Any, Dict, List

from aiohttp import ClientConnectionError
from requests import ConnectionError as RequestsConnectionError
from requests import PreparedRequest, Response, Session

from algoliasearch.http.base_config import BaseConfig
from algoliasearch.http.hosts import Host, HostsCollection
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.transporter import Transporter
from algoliasearch.http.transporter_sync import TransporterSync
from algoliasearch.http.verb import Verb

# the first host cannot be reached, the second one answers
SENT_URLS = [
    "https://host-one.test/1/test",
    "https://host-two.test/1/test",
]


def create_config() -> BaseConfig:
    config = BaseConfig("test-app", "test-key")
    config.hosts = HostsCollection([Host("host-one.test"), Host("host-two.test")])
    return config


class UnreachableHostSyncSession(Session):
    def __init__(self) -> None:
        super().__init__()
        self.sent_urls: List[str] = []

    def send(self, request: PreparedRequest, **kwargs: Any) -> Response:  # type: ignore # the tests only need the recorded request
        self.sent_urls.append(request.url or "")
        if "host-one" in (request.url or ""):
            raise RequestsConnectionError("connection refused")

        response = Response()
        response.status_code = 200
        response.encoding = "utf-8"
        response._content = b"{}"
        return response


class OkAsyncResponse:
    def __init__(self) -> None:
        self.status = 200
        self.headers: Dict[str, str] = {}
        self.reason = "OK"

    async def text(self) -> str:
        return "{}"

    async def __aenter__(self) -> "OkAsyncResponse":
        return self

    async def __aexit__(self, *args: Any) -> None:
        return None


class UnreachableHostAsyncSession:
    def __init__(self) -> None:
        self.sent_urls: List[str] = []

    def request(self, **kwargs: Any) -> OkAsyncResponse:
        url = str(kwargs.get("url", ""))
        self.sent_urls.append(url)
        if "host-one" in url:
            raise ClientConnectionError("connection refused")

        return OkAsyncResponse()


def test_sync_tries_the_next_host_on_connection_error() -> None:
    config = create_config()
    transporter = TransporterSync(config)
    session = UnreachableHostSyncSession()
    transporter._session = session

    response = transporter.request(
        verb=Verb.GET,
        path="/1/test",
        request_options=RequestOptions(config).merge(),
        use_read_transporter=True,
    )

    assert response.status_code == 200
    assert session.sent_urls == SENT_URLS


async def test_async_tries_the_next_host_on_connection_error() -> None:
    config = create_config()
    transporter = Transporter(config)
    session = UnreachableHostAsyncSession()
    transporter._session = session  # type: ignore[assignment]

    response = await transporter.request(
        verb=Verb.GET,
        path="/1/test",
        request_options=RequestOptions(config).merge(),
        use_read_transporter=True,
    )

    assert response.status_code == 200
    assert session.sent_urls == SENT_URLS
