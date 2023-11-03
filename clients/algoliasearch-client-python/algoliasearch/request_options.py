import copy
from typing import Any, Dict

from algoliasearch.helpers import get_items


class RequestOptions(object):
    def __init__(
        self,
        headers: Dict[str, str],
        query_parameters: Dict[str, any],
        write_timeout: int,
        read_timeout: int,
        data: Dict[str, Any],
    ):
        self.headers = headers
        self.query_parameters = query_parameters
        self.write_timeout = write_timeout
        self.read_timeout = read_timeout
        self.data = data

    def __setitem__(self, option: str, value: Any):
        if option.upper() in [header.upper() for header in Params.HEADERS]:
            self.headers[option] = str(value)
        elif option in Params.QUERY_PARAMETERS:
            self.query_parameters[option] = value
        elif option in Params.TIMEOUTS:
            self.timeouts[option] = value
        else:
            self.data[option] = value

    @staticmethod
    def create(config, options=None):
        # type: (Config, Optional[Union[RequestOptions, Dict[str, Any]]]) -> RequestOptions  # noqa: E501

        if isinstance(options, RequestOptions):
            return copy.copy(options)

        headers = dict(config.headers)

        timeouts = {
            "readTimeout": int(config.read_timeout),
            "writeTimeout": int(config.write_timeout),
            "connectTimeout": int(config.connect_timeout),
        }

        request_options = RequestOptions(headers, {}, timeouts, {})

        for option, value in get_items(options):
            request_options[option] = value

        return request_options


class Params(object):
    HEADERS = (
        "Content-type",
        "User-Agent",
        "X-Algolia-User-ID",
        "X-Algolia-UserToken",
        "X-Forwarded-For",
    )

    QUERY_PARAMETERS = (
        "createIfNotExists",
        "forwardToReplicas",
        "replaceExistingSynonyms",
        "clearExistingRules",
        "getVersion",
    )

    TIMEOUTS = (
        "readTimeout",
        "writeTimeout",
        "connectTimeout",
    )
