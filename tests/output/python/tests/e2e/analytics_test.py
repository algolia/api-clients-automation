# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
from os import environ
from json import loads
from algoliasearch.analytics.client import AnalyticsClient
from ..helpers import Helpers
from dotenv import load_dotenv

load_dotenv("../../.env")


class TestAnalyticsClientE2E:
    _helpers = Helpers()
    _e2e_app_id = environ.get("ALGOLIA_APPLICATION_ID")
    if _e2e_app_id is None:
        raise Exception(
            "please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests"
        )

    _e2e_api_key = environ.get("ALGOLIA_ADMIN_KEY")
    if _e2e_api_key is None:
        raise Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")

    async def test_get_top_searches_2(self):
        """
        e2e with complex query params
        """
        raw_resp = await AnalyticsClient(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).get_top_searches_with_http_info(
            index="cts_e2e_space in index",
        )
        assert raw_resp.status_code == 200

        resp = await AnalyticsClient(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).get_top_searches(
            index="cts_e2e_space in index",
        )
        _expected_body = loads("""{"searches":[{"search":"","nbHits":0}]}""")
        assert self._helpers.union(_expected_body, resp) == _expected_body