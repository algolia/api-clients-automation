from re import compile
from typing import Any, Dict, List, Optional

from requests import PreparedRequest, Response, Session
from requests.structures import CaseInsensitiveDict

from algoliasearch.http.base_config import BaseConfig
from algoliasearch.http.exceptions import (
    AlgoliaUnreachableHostException,
    RequestException,
)
from algoliasearch.http.hosts import CallType, Host, HostsCollection
from algoliasearch.http.request_id import (
    REQUEST_ID_HEADER,
    generate_request_id,
    get_correlation_id,
    with_request_id,
)
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.transporter_sync import TransporterSync
from algoliasearch.http.verb import Verb

REQUEST_ID_FORMAT = compile(r"^[0-9A-Za-z]{11}$")


def create_config(request_id_enabled: bool = True, hosts: int = 1) -> BaseConfig:
    config = BaseConfig("test-app", "test-key")
    config.request_id_enabled = request_id_enabled
    config.hosts = HostsCollection(
        [
            Host("localhost{}".format(index), accept=CallType.READ | CallType.WRITE)
            for index in range(hosts)
        ]
    )
    return config


class FakeResponse(Response):
    def __init__(
        self, status_code: int, headers: Optional[Dict[str, str]] = None
    ) -> None:
        super().__init__()
        self.status_code = status_code
        self.headers = CaseInsensitiveDict(headers or {})
        self.reason = "OK"

    @property
    def text(self) -> str:
        if self.status_code >= 400:
            return '{"message":"request-id error test"}'
        return '{"status":"ok"}'


class RecordingSession(Session):
    def __init__(
        self, statuses: List[int], headers: Optional[Dict[str, str]] = None
    ) -> None:
        super().__init__()
        self._statuses = list(statuses)
        self._headers = headers
        self.observed_request_ids: List[Optional[str]] = []

    def send(self, request: PreparedRequest, **kwargs: Any) -> Response:  # type: ignore # the tests only need the recorded request
        _ = kwargs
        self.observed_request_ids.append(request.headers.get("request-id"))
        return FakeResponse(self._statuses.pop(0), self._headers)


def send(
    config: BaseConfig, session: RecordingSession, verb: Verb = Verb.GET
) -> Response:
    transporter = TransporterSync(config)
    transporter._session = session
    return transporter.request(
        verb=verb,
        path="/test",
        request_options=RequestOptions(config).merge(),
        use_read_transporter=True,
    )


def test_generated_ids_are_base62_and_never_repeat() -> None:
    ids = [generate_request_id() for _ in range(100)]

    for request_id in ids:
        assert REQUEST_ID_FORMAT.match(request_id) is not None
    assert len(set(ids)) == len(ids)


def test_mints_a_request_id_header_for_a_supported_client() -> None:
    options = with_request_id(None, create_config())

    assert options is not None
    assert REQUEST_ID_FORMAT.match(options["headers"][REQUEST_ID_HEADER]) is not None


def test_mints_nothing_for_an_unsupported_client() -> None:
    assert with_request_id(None, create_config(request_id_enabled=False)) is None


def test_a_caller_supplied_header_wins_whatever_its_casing() -> None:
    options = with_request_id(
        {"headers": {"Request-Id": "CallerProvided"}}, create_config()
    )

    assert options == {"headers": {"Request-Id": "CallerProvided"}}


def test_a_caller_supplied_query_parameter_suppresses_the_header() -> None:
    options = with_request_id(
        {"query_parameters": {"X-Algolia-Request-Id": "CallerProvided"}},
        create_config(),
    )

    assert options == {"query_parameters": {"X-Algolia-Request-Id": "CallerProvided"}}


def test_a_client_level_header_wins() -> None:
    config = create_config()
    config.headers["REQUEST-ID"] = "ClientProvided"

    assert with_request_id(None, config) is None


def test_the_caller_options_are_never_modified() -> None:
    config = create_config()

    given_dict: Dict[str, Any] = {"headers": {"x-custom": "value"}}
    minted_dict = with_request_id(given_dict, config)

    assert given_dict == {"headers": {"x-custom": "value"}}
    assert minted_dict is not given_dict
    assert REQUEST_ID_HEADER in minted_dict["headers"]

    given_options = RequestOptions(config, headers={"x-custom": "value"})
    minted_options = with_request_id(given_options, config)

    assert given_options.headers == {"x-custom": "value"}
    assert minted_options is not given_options
    assert REQUEST_ID_HEADER in minted_options.headers
    assert config.headers.get(REQUEST_ID_HEADER) is None


def test_one_request_id_covers_every_retry_of_one_call() -> None:
    session = RecordingSession([500, 500, 200])

    response = send(create_config(hosts=3), session)

    assert response.status_code == 200
    assert len(session.observed_request_ids) == 3
    assert REQUEST_ID_FORMAT.match(session.observed_request_ids[0] or "") is not None
    assert len(set(session.observed_request_ids)) == 1


def test_each_call_mints_a_fresh_request_id() -> None:
    config = create_config()
    session = RecordingSession([200, 200])

    send(config, session)
    send(config, session)

    assert len(set(session.observed_request_ids)) == 2


def test_an_unsupported_client_sends_no_request_id() -> None:
    session = RecordingSession([200])

    send(create_config(request_id_enabled=False), session)

    assert session.observed_request_ids == [None]


def test_get_correlation_id_is_case_insensitive() -> None:
    assert get_correlation_id({"CoRrElAtIoN-iD": "abc"}) == "abc"
    assert get_correlation_id({"x-other": "abc"}) is None
    assert get_correlation_id(None) is None


def test_a_failed_request_exposes_the_correlation_id() -> None:
    session = RecordingSession([400], {"Correlation-ID": "CorrelationId1"})

    try:
        send(create_config(), session)
        raise AssertionError("expected a RequestException")
    except RequestException as exception:
        assert (
            str(exception) == "request-id error test (Correlation-ID: CorrelationId1)"
        )
        assert exception.message == str(exception)
        assert exception.correlation_id == "CorrelationId1"
        assert exception.status_code == 400


def test_a_failed_request_without_the_header_reads_as_before() -> None:
    session = RecordingSession([400])

    try:
        send(create_config(), session)
        raise AssertionError("expected a RequestException")
    except RequestException as exception:
        assert str(exception) == "request-id error test"
        assert exception.correlation_id is None


def test_unreachable_hosts_carry_the_last_seen_correlation_id() -> None:
    session = RecordingSession([500, 500], {"Correlation-ID": "CorrelationId2"})

    try:
        send(create_config(hosts=2), session)
        raise AssertionError("expected an AlgoliaUnreachableHostException")
    except AlgoliaUnreachableHostException as exception:
        assert exception.correlation_id == "CorrelationId2"
        assert str(exception).endswith(" (Correlation-ID: CorrelationId2)")
