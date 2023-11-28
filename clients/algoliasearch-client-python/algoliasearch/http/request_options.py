import copy
from typing import Any, Dict, Optional, Union

from algoliasearch.search.config import Config

try:
    from typing import Self
except ImportError:
    from typing_extensions import Self


class RequestOptions(object):
    def __init__(
        self,
        headers: Dict[str, str],
        query_parameters: Dict[str, Any],
        timeouts: Dict[str, int],
        data: Dict[str, Any],
    ) -> None:
        self.headers = headers
        self.query_parameters = query_parameters
        self.timeouts = timeouts
        self.data = data

    def __setitem__(self, option: str, value: Any) -> None:
        if option.upper() in [
            header.upper() for header in AllowedRequestsOptionsParams.HEADERS
        ]:
            self.headers[option] = str(value)
        elif option in AllowedRequestsOptionsParams.QUERY_PARAMETERS:
            self.query_parameters[option] = value
        elif option in AllowedRequestsOptionsParams.TIMEOUTS:
            self.timeouts[option] = value
        else:
            self.data[option] = value

    def create(
        config: Config, options: Optional[Union[Self, Dict[str, Any]]] = None
    ) -> Self:
        if isinstance(options, RequestOptions):
            return copy.copy(options)

        headers = dict(config.headers)

        timeouts = {
            "readTimeout": int(config.read_timeout),
            "writeTimeout": int(config.write_timeout),
            "connectTimeout": int(config.connect_timeout),
        }

        request_options = RequestOptions(headers, {}, timeouts, {})

        if options is not None:
            for option, value in options.items():
                request_options[option] = value

        return request_options


class AllowedRequestsOptionsParams(object):
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
