# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
from os import environ
from json import loads
from algoliasearch.insights.client import InsightsClient
from algoliasearch.insights.client import InsightsClientSync
from ..helpers import Helpers
from dotenv import load_dotenv

load_dotenv("../../.env")


class TestInsightsClientE2E:
    _helpers = Helpers()
    _e2e_app_id = environ.get("ALGOLIA_APPLICATION_ID")
    if _e2e_app_id is None:
        raise Exception(
            "please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests"
        )

    _e2e_api_key = environ.get("ALGOLIA_ADMIN_KEY")
    if _e2e_api_key is None:
        raise Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")

    async def test_push_events_1(self):
        """
        Many events type
        """
        raw_resp = await InsightsClient(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).push_events_with_http_info(
            insights_events={
                "events": [
                    {
                        "eventType": "conversion",
                        "eventName": "Product Purchased",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    },
                    {
                        "eventType": "view",
                        "eventName": "Product Detail Page Viewed",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                    },
                ],
            },
        )
        assert raw_resp.status_code == 200

        resp = await InsightsClient(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).push_events(
            insights_events={
                "events": [
                    {
                        "eventType": "conversion",
                        "eventName": "Product Purchased",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    },
                    {
                        "eventType": "view",
                        "eventName": "Product Detail Page Viewed",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                    },
                ],
            },
        )
        _expected_body = loads("""{"message":"OK","status":200}""")
        assert (
            self._helpers.union(_expected_body, self._helpers.unwrap(resp))
            == _expected_body
        )


class TestInsightsClientSyncE2E:
    _helpers = Helpers()
    _e2e_app_id = environ.get("ALGOLIA_APPLICATION_ID")
    if _e2e_app_id is None:
        raise Exception(
            "please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests"
        )

    _e2e_api_key = environ.get("ALGOLIA_ADMIN_KEY")
    if _e2e_api_key is None:
        raise Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")

    def test_push_events_1(self):
        """
        Many events type
        """
        raw_resp = InsightsClientSync(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).push_events_with_http_info(
            insights_events={
                "events": [
                    {
                        "eventType": "conversion",
                        "eventName": "Product Purchased",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    },
                    {
                        "eventType": "view",
                        "eventName": "Product Detail Page Viewed",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                    },
                ],
            },
        )
        assert raw_resp.status_code == 200

        resp = InsightsClientSync(
            self._e2e_app_id, self._e2e_api_key, "us"
        ).push_events(
            insights_events={
                "events": [
                    {
                        "eventType": "conversion",
                        "eventName": "Product Purchased",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                    },
                    {
                        "eventType": "view",
                        "eventName": "Product Detail Page Viewed",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1753228800000,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                    },
                ],
            },
        )
        _expected_body = loads("""{"message":"OK","status":200}""")
        assert (
            self._helpers.union(_expected_body, self._helpers.unwrap(resp))
            == _expected_body
        )
