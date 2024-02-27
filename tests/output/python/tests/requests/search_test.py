from json import loads
from os import environ
from time import time
from unittest.mock import AsyncMock

from algoliasearch.http.transporter import EchoTransporter
from algoliasearch.search.client import SearchClient
from algoliasearch.search.config import SearchConfig
from algoliasearch.search.models.batch_response import BatchResponse
from algoliasearch.search.models.get_task_response import GetTaskResponse
from algoliasearch.search.models.secured_api_key_restrictions import (
    SecuredAPIKeyRestrictions,
)
from algoliasearch.search.models.updated_at_response import UpdatedAtResponse
from dotenv import load_dotenv

from ..helpers import Helpers

load_dotenv("../../.env")


class TestSearchClient:
    _config = SearchConfig("test_app_id", "test_api_key")
    _client = SearchClient.create_with_config(
        config=_config, transporter=EchoTransporter(_config)
    )

    _helpers = Helpers()
    _e2e_app_id = environ.get("ALGOLIA_APPLICATION_ID")
    if _e2e_app_id is None:
        raise Exception(
            "please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests"
        )

    _e2e_api_key = environ.get("ALGOLIA_ADMIN_KEY")
    if _e2e_api_key is None:
        raise Exception("please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests")

    async def test_add_api_key_0(self):
        """
        addApiKey0
        """
        _req = await self._client.add_api_key_with_http_info(
            api_key={
                "acl": [
                    "search",
                    "addObject",
                ],
                "description": "my new api key",
                "validity": 300,
                "maxQueriesPerIPPerHour": 100,
                "maxHitsPerQuery": 20,
            },
        )

        assert _req.path == "/1/keys"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"acl":["search","addObject"],"description":"my new api key","validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}"""
        )

    async def test_add_or_update_object_0(self):
        """
        addOrUpdateObject0
        """
        _req = await self._client.add_or_update_object_with_http_info(
            index_name="indexName",
            object_id="uniqueID",
            body={
                "key": "value",
            },
        )

        assert _req.path == "/1/indexes/indexName/uniqueID"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"key":"value"}""")

    async def test_append_source_0(self):
        """
        appendSource0
        """
        _req = await self._client.append_source_with_http_info(
            source={
                "source": "theSource",
                "description": "theDescription",
            },
        )

        assert _req.path == "/1/security/sources/append"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"source":"theSource","description":"theDescription"}"""
        )

    async def test_assign_user_id_0(self):
        """
        assignUserId0
        """
        _req = await self._client.assign_user_id_with_http_info(
            x_algolia_user_id="userID",
            assign_user_id_params={
                "cluster": "theCluster",
            },
        )

        assert _req.path == "/1/clusters/mapping"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {"x-algolia-user-id": "userID"}.items()
        assert loads(_req.data) == loads("""{"cluster":"theCluster"}""")

    async def test_assign_user_id_1(self):
        """
        it should not encode the userID
        """
        _req = await self._client.assign_user_id_with_http_info(
            x_algolia_user_id="user id with spaces",
            assign_user_id_params={
                "cluster": "cluster with spaces",
            },
        )

        assert _req.path == "/1/clusters/mapping"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert (
            _req.headers.items() >= {"x-algolia-user-id": "user id with spaces"}.items()
        )
        assert loads(_req.data) == loads("""{"cluster":"cluster with spaces"}""")

    async def test_batch_0(self):
        """
        allows batch method with `addObject` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "addObject",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"addObject","body":{"key":"value"}}]}"""
        )

    async def test_batch_1(self):
        """
        allows batch method with `clear` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "clear",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"clear","body":{"key":"value"}}]}"""
        )

    async def test_batch_2(self):
        """
        allows batch method with `delete` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "delete",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"delete","body":{"key":"value"}}]}"""
        )

    async def test_batch_3(self):
        """
        allows batch method with `deleteObject` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "deleteObject",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"deleteObject","body":{"key":"value"}}]}"""
        )

    async def test_batch_4(self):
        """
        allows batch method with `partialUpdateObject` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "partialUpdateObject",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"partialUpdateObject","body":{"key":"value"}}]}"""
        )

    async def test_batch_5(self):
        """
        allows batch method with `partialUpdateObjectNoCreate` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "partialUpdateObjectNoCreate",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"partialUpdateObjectNoCreate","body":{"key":"value"}}]}"""
        )

    async def test_batch_6(self):
        """
        allows batch method with `updateObject` action
        """
        _req = await self._client.batch_with_http_info(
            index_name="theIndexName",
            batch_write_params={
                "requests": [
                    {
                        "action": "updateObject",
                        "body": {
                            "key": "value",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"updateObject","body":{"key":"value"}}]}"""
        )

    async def test_batch_assign_user_ids_0(self):
        """
        batchAssignUserIds0
        """
        _req = await self._client.batch_assign_user_ids_with_http_info(
            x_algolia_user_id="userID",
            batch_assign_user_ids_params={
                "cluster": "theCluster",
                "users": [
                    "user1",
                    "user2",
                ],
            },
        )

        assert _req.path == "/1/clusters/mapping/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {"x-algolia-user-id": "userID"}.items()
        assert loads(_req.data) == loads(
            """{"cluster":"theCluster","users":["user1","user2"]}"""
        )

    async def test_batch_dictionary_entries_0(self):
        """
        get batchDictionaryEntries results with minimal parameters
        """
        _req = await self._client.batch_dictionary_entries_with_http_info(
            dictionary_name="compounds",
            batch_dictionary_entries_params={
                "requests": [
                    {
                        "action": "addEntry",
                        "body": {
                            "objectID": "1",
                            "language": "en",
                        },
                    },
                    {
                        "action": "deleteEntry",
                        "body": {
                            "objectID": "2",
                            "language": "fr",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/dictionaries/compounds/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr"}}]}"""
        )

    async def test_batch_dictionary_entries_1(self):
        """
        get batchDictionaryEntries results with all parameters
        """
        _req = await self._client.batch_dictionary_entries_with_http_info(
            dictionary_name="compounds",
            batch_dictionary_entries_params={
                "clearExistingDictionaryEntries": False,
                "requests": [
                    {
                        "action": "addEntry",
                        "body": {
                            "objectID": "1",
                            "language": "en",
                            "word": "fancy",
                            "words": [
                                "believe",
                                "algolia",
                            ],
                            "decomposition": [
                                "trust",
                                "algolia",
                            ],
                            "state": "enabled",
                        },
                    },
                    {
                        "action": "deleteEntry",
                        "body": {
                            "objectID": "2",
                            "language": "fr",
                            "word": "humility",
                            "words": [
                                "candor",
                                "algolia",
                            ],
                            "decomposition": [
                                "grit",
                                "algolia",
                            ],
                            "state": "enabled",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/dictionaries/compounds/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"clearExistingDictionaryEntries":false,"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","word":"fancy","words":["believe","algolia"],"decomposition":["trust","algolia"],"state":"enabled"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr","word":"humility","words":["candor","algolia"],"decomposition":["grit","algolia"],"state":"enabled"}}]}"""
        )

    async def test_batch_dictionary_entries_2(self):
        """
        get batchDictionaryEntries results additional properties
        """
        _req = await self._client.batch_dictionary_entries_with_http_info(
            dictionary_name="compounds",
            batch_dictionary_entries_params={
                "requests": [
                    {
                        "action": "addEntry",
                        "body": {
                            "objectID": "1",
                            "language": "en",
                            "additional": "try me",
                        },
                    },
                ],
            },
        )

        assert _req.path == "/1/dictionaries/compounds/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","additional":"try me"}}]}"""
        )

    async def test_browse_0(self):
        """
        browse with minimal parameters
        """
        _req = await self._client.browse_with_http_info(
            index_name="cts_e2e_browse",
        )

        assert _req.path == "/1/indexes/cts_e2e_browse/browse"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).browse_with_http_info(
            index_name="cts_e2e_browse",
        )
        assert raw_resp.status_code == 200

        resp = await SearchClient(self._e2e_app_id, self._e2e_api_key).browse(
            index_name="cts_e2e_browse",
        )
        _expected_body = loads(
            """{"page":0,"nbHits":33191,"nbPages":34,"hitsPerPage":1000,"query":"","params":""}"""
        )
        assert self._helpers.union(_expected_body, resp) == _expected_body

    async def test_browse_1(self):
        """
        browse with search parameters
        """
        _req = await self._client.browse_with_http_info(
            index_name="indexName",
            browse_params={
                "query": "myQuery",
                "facetFilters": [
                    "tags:algolia",
                ],
            },
        )

        assert _req.path == "/1/indexes/indexName/browse"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"myQuery","facetFilters":["tags:algolia"]}"""
        )

    async def test_browse_2(self):
        """
        browse allow a cursor in parameters
        """
        _req = await self._client.browse_with_http_info(
            index_name="indexName",
            browse_params={
                "cursor": "test",
            },
        )

        assert _req.path == "/1/indexes/indexName/browse"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"cursor":"test"}""")

    async def test_clear_objects_0(self):
        """
        clearObjects0
        """
        _req = await self._client.clear_objects_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/indexes/theIndexName/clear"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()

    async def test_clear_rules_0(self):
        """
        clearRules0
        """
        _req = await self._client.clear_rules_with_http_info(
            index_name="indexName",
        )

        assert _req.path == "/1/indexes/indexName/rules/clear"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()

    async def test_clear_synonyms_0(self):
        """
        clearSynonyms0
        """
        _req = await self._client.clear_synonyms_with_http_info(
            index_name="indexName",
        )

        assert _req.path == "/1/indexes/indexName/synonyms/clear"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()

    async def test_custom_delete_0(self):
        """
        allow del method for a custom path with minimal parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_delete_1(self):
        """
        allow del method for a custom path with all parameters
        """
        _req = await self._client.custom_delete_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_0(self):
        """
        allow get method for a custom path with minimal parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_1(self):
        """
        allow get method for a custom path with all parameters
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters with space",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters%20with%20space"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_custom_get_2(self):
        """
        requestOptions should be escaped too
        """
        _req = await self._client.custom_get_with_http_info(
            path="/test/all",
            parameters={
                "query": "to be overriden",
            },
            request_options={
                "headers": loads("""{"x-header-1":"spaces are left alone"}"""),
                "query_parameters": loads(
                    """{"query":"parameters with space","and an array":["array","with spaces"]}"""
                ),
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {
                "query": "parameters%20with%20space",
                "and%20an%20array": "array%2Cwith%20spaces",
            }.items()
        )
        assert _req.headers.items() >= {"x-header-1": "spaces are left alone"}.items()
        assert _req.data is None

    async def test_custom_post_0(self):
        """
        allow post method for a custom path with minimal parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_post_1(self):
        """
        allow post method for a custom path with all parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_custom_post_2(self):
        """
        requestOptions can override default query parameters
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"query":"myQueryParameter"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "myQueryParameter"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_3(self):
        """
        requestOptions merges query parameters with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"query2":"myQueryParameter"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "query2": "myQueryParameter"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_4(self):
        """
        requestOptions can override default headers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "headers": loads("""{"x-algolia-api-key":"myApiKey"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_5(self):
        """
        requestOptions merges headers with default ones
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "headers": loads("""{"x-algolia-api-key":"myApiKey"}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {"x-algolia-api-key": "myApiKey"}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_6(self):
        """
        requestOptions queryParameters accepts booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"isItWorking":true}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "isItWorking": "true"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_7(self):
        """
        requestOptions queryParameters accepts integers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":2}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "2"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_8(self):
        """
        requestOptions queryParameters accepts list of string
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":["b and c","d"]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "b%20and%20c%2Cd"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_9(self):
        """
        requestOptions queryParameters accepts list of booleans
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":[true,true,false]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "true%2Ctrue%2Cfalse"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_post_10(self):
        """
        requestOptions queryParameters accepts list of integers
        """
        _req = await self._client.custom_post_with_http_info(
            path="/test/requestOptions",
            parameters={
                "query": "parameters",
            },
            body={
                "facet": "filters",
            },
            request_options={
                "query_parameters": loads("""{"myParam":[1,2]}"""),
            },
        )

        assert _req.path == "/1/test/requestOptions"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"query": "parameters", "myParam": "1%2C2"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"facet":"filters"}""")

    async def test_custom_put_0(self):
        """
        allow put method for a custom path with minimal parameters
        """
        _req = await self._client.custom_put_with_http_info(
            path="/test/minimal",
        )

        assert _req.path == "/1/test/minimal"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_custom_put_1(self):
        """
        allow put method for a custom path with all parameters
        """
        _req = await self._client.custom_put_with_http_info(
            path="/test/all",
            parameters={
                "query": "parameters",
            },
            body={
                "body": "parameters",
            },
        )

        assert _req.path == "/1/test/all"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"query": "parameters"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"body":"parameters"}""")

    async def test_delete_api_key_0(self):
        """
        deleteApiKey0
        """
        _req = await self._client.delete_api_key_with_http_info(
            key="myTestApiKey",
        )

        assert _req.path == "/1/keys/myTestApiKey"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_by_0(self):
        """
        deleteBy0
        """
        _req = await self._client.delete_by_with_http_info(
            index_name="theIndexName",
            delete_by_params={
                "filters": "brand:brandName",
            },
        )

        assert _req.path == "/1/indexes/theIndexName/deleteByQuery"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"filters":"brand:brandName"}""")

    async def test_delete_index_0(self):
        """
        deleteIndex0
        """
        _req = await self._client.delete_index_with_http_info(
            index_name="theIndexName",
        )

        assert _req.path == "/1/indexes/theIndexName"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_object_0(self):
        """
        deleteObject0
        """
        _req = await self._client.delete_object_with_http_info(
            index_name="theIndexName",
            object_id="uniqueID",
        )

        assert _req.path == "/1/indexes/theIndexName/uniqueID"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_rule_0(self):
        """
        delete rule simple case
        """
        _req = await self._client.delete_rule_with_http_info(
            index_name="indexName",
            object_id="id1",
        )

        assert _req.path == "/1/indexes/indexName/rules/id1"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_rule_1(self):
        """
        delete rule with simple characters to encode in objectID
        """
        _req = await self._client.delete_rule_with_http_info(
            index_name="indexName",
            object_id="test/with/slash",
        )

        assert _req.path == "/1/indexes/indexName/rules/test%2Fwith%2Fslash"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_source_0(self):
        """
        deleteSource0
        """
        _req = await self._client.delete_source_with_http_info(
            source="theSource",
        )

        assert _req.path == "/1/security/sources/theSource"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_delete_synonym_0(self):
        """
        deleteSynonym0
        """
        _req = await self._client.delete_synonym_with_http_info(
            index_name="indexName",
            object_id="id1",
        )

        assert _req.path == "/1/indexes/indexName/synonyms/id1"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_api_key_0(self):
        """
        getApiKey0
        """
        _req = await self._client.get_api_key_with_http_info(
            key="myTestApiKey",
        )

        assert _req.path == "/1/keys/myTestApiKey"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_dictionary_languages_0(self):
        """
        get getDictionaryLanguages
        """
        _req = await self._client.get_dictionary_languages_with_http_info()

        assert _req.path == "/1/dictionaries/*/languages"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_dictionary_settings_0(self):
        """
        get getDictionarySettings results
        """
        _req = await self._client.get_dictionary_settings_with_http_info()

        assert _req.path == "/1/dictionaries/*/settings"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_logs_0(self):
        """
        getLogs with minimal parameters
        """
        _req = await self._client.get_logs_with_http_info()

        assert _req.path == "/1/logs"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_logs_1(self):
        """
        getLogs with parameters
        """
        _req = await self._client.get_logs_with_http_info(
            offset=5,
            length=10,
            index_name="theIndexName",
            type="all",
        )

        assert _req.path == "/1/logs"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {
                "offset": "5",
                "length": "10",
                "indexName": "theIndexName",
                "type": "all",
            }.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_object_0(self):
        """
        getObject0
        """
        _req = await self._client.get_object_with_http_info(
            index_name="theIndexName",
            object_id="uniqueID",
            attributes_to_retrieve=[
                "attr1",
                "attr2",
            ],
        )

        assert _req.path == "/1/indexes/theIndexName/uniqueID"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items()
            == {"attributesToRetrieve": "attr1%2Cattr2"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_objects_0(self):
        """
        getObjects0
        """
        _req = await self._client.get_objects_with_http_info(
            get_objects_params={
                "requests": [
                    {
                        "attributesToRetrieve": [
                            "attr1",
                            "attr2",
                        ],
                        "objectID": "uniqueID",
                        "indexName": "theIndexName",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/objects"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"attributesToRetrieve":["attr1","attr2"],"objectID":"uniqueID","indexName":"theIndexName"}]}"""
        )

    async def test_get_rule_0(self):
        """
        getRule0
        """
        _req = await self._client.get_rule_with_http_info(
            index_name="indexName",
            object_id="id1",
        )

        assert _req.path == "/1/indexes/indexName/rules/id1"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_settings_0(self):
        """
        getSettings0
        """
        _req = await self._client.get_settings_with_http_info(
            index_name="cts_e2e_settings",
        )

        assert _req.path == "/1/indexes/cts_e2e_settings/settings"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).get_settings_with_http_info(
            index_name="cts_e2e_settings",
        )
        assert raw_resp.status_code == 200

        resp = await SearchClient(self._e2e_app_id, self._e2e_api_key).get_settings(
            index_name="cts_e2e_settings",
        )
        _expected_body = loads(
            """{"minWordSizefor1Typo":4,"minWordSizefor2Typos":8,"hitsPerPage":100,"maxValuesPerFacet":100,"paginationLimitedTo":10,"exactOnSingleWordQuery":"attribute","ranking":["typo","geo","words","filters","proximity","attribute","exact","custom"],"separatorsToIndex":"","removeWordsIfNoResults":"none","queryType":"prefixLast","highlightPreTag":"<em>","highlightPostTag":"</em>","alternativesAsExact":["ignorePlurals","singleWordSynonym"]}"""
        )
        assert self._helpers.union(_expected_body, resp) == _expected_body

    async def test_get_sources_0(self):
        """
        getSources0
        """
        _req = await self._client.get_sources_with_http_info()

        assert _req.path == "/1/security/sources"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_synonym_0(self):
        """
        getSynonym0
        """
        _req = await self._client.get_synonym_with_http_info(
            index_name="indexName",
            object_id="id1",
        )

        assert _req.path == "/1/indexes/indexName/synonyms/id1"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_task_0(self):
        """
        getTask0
        """
        _req = await self._client.get_task_with_http_info(
            index_name="theIndexName",
            task_id=123,
        )

        assert _req.path == "/1/indexes/theIndexName/task/123"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_top_user_ids_0(self):
        """
        getTopUserIds0
        """
        _req = await self._client.get_top_user_ids_with_http_info()

        assert _req.path == "/1/clusters/mapping/top"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_get_user_id_0(self):
        """
        getUserId0
        """
        _req = await self._client.get_user_id_with_http_info(
            user_id="uniqueID",
        )

        assert _req.path == "/1/clusters/mapping/uniqueID"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_has_pending_mappings_0(self):
        """
        hasPendingMappings with minimal parameters
        """
        _req = await self._client.has_pending_mappings_with_http_info()

        assert _req.path == "/1/clusters/mapping/pending"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_has_pending_mappings_1(self):
        """
        hasPendingMappings with parameters
        """
        _req = await self._client.has_pending_mappings_with_http_info(
            get_clusters=True,
        )

        assert _req.path == "/1/clusters/mapping/pending"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {"getClusters": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_api_keys_0(self):
        """
        listApiKeys0
        """
        _req = await self._client.list_api_keys_with_http_info()

        assert _req.path == "/1/keys"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_clusters_0(self):
        """
        listClusters0
        """
        _req = await self._client.list_clusters_with_http_info()

        assert _req.path == "/1/clusters"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_indices_0(self):
        """
        listIndices with minimal parameters
        """
        _req = await self._client.list_indices_with_http_info()

        assert _req.path == "/1/indexes"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_indices_1(self):
        """
        listIndices with parameters
        """
        _req = await self._client.list_indices_with_http_info(
            page=8,
            hits_per_page=3,
        )

        assert _req.path == "/1/indexes"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items() == {"page": "8", "hitsPerPage": "3"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_user_ids_0(self):
        """
        listUserIds with minimal parameters
        """
        _req = await self._client.list_user_ids_with_http_info()

        assert _req.path == "/1/clusters/mapping"
        assert _req.verb == "GET"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_list_user_ids_1(self):
        """
        listUserIds with parameters
        """
        _req = await self._client.list_user_ids_with_http_info(
            page=8,
            hits_per_page=100,
        )

        assert _req.path == "/1/clusters/mapping"
        assert _req.verb == "GET"
        assert (
            _req.query_parameters.items() == {"page": "8", "hitsPerPage": "100"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_multiple_batch_0(self):
        """
        multipleBatch0
        """
        _req = await self._client.multiple_batch_with_http_info(
            batch_params={
                "requests": [
                    {
                        "action": "addObject",
                        "body": {
                            "key": "value",
                        },
                        "indexName": "theIndexName",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"action":"addObject","body":{"key":"value"},"indexName":"theIndexName"}]}"""
        )

    async def test_operation_index_0(self):
        """
        operationIndex0
        """
        _req = await self._client.operation_index_with_http_info(
            index_name="theIndexName",
            operation_index_params={
                "operation": "copy",
                "destination": "dest",
                "scope": [
                    "rules",
                    "settings",
                ],
            },
        )

        assert _req.path == "/1/indexes/theIndexName/operation"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"operation":"copy","destination":"dest","scope":["rules","settings"]}"""
        )

    async def test_partial_update_object_0(self):
        """
        partialUpdateObject0
        """
        _req = await self._client.partial_update_object_with_http_info(
            index_name="theIndexName",
            object_id="uniqueID",
            attributes_to_update={
                "id1": "test",
                "id2": {
                    "_operation": "AddUnique",
                    "value": "test2",
                },
            },
            create_if_not_exists=True,
        )

        assert _req.path == "/1/indexes/theIndexName/uniqueID/partial"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {"createIfNotExists": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"id1":"test","id2":{"_operation":"AddUnique","value":"test2"}}"""
        )

    async def test_remove_user_id_0(self):
        """
        removeUserId0
        """
        _req = await self._client.remove_user_id_with_http_info(
            user_id="uniqueID",
        )

        assert _req.path == "/1/clusters/mapping/uniqueID"
        assert _req.verb == "DELETE"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert _req.data is None

    async def test_replace_sources_0(self):
        """
        replaceSources0
        """
        _req = await self._client.replace_sources_with_http_info(
            source=[
                {
                    "source": "theSource",
                    "description": "theDescription",
                },
            ],
        )

        assert _req.path == "/1/security/sources"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """[{"source":"theSource","description":"theDescription"}]"""
        )

    async def test_restore_api_key_0(self):
        """
        restoreApiKey0
        """
        _req = await self._client.restore_api_key_with_http_info(
            key="myApiKey",
        )

        assert _req.path == "/1/keys/myApiKey/restore"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()

    async def test_save_object_0(self):
        """
        saveObject0
        """
        _req = await self._client.save_object_with_http_info(
            index_name="theIndexName",
            body={
                "objectID": "id",
                "test": "val",
            },
        )

        assert _req.path == "/1/indexes/theIndexName"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"objectID":"id","test":"val"}""")

    async def test_save_rule_0(self):
        """
        saveRule with minimal parameters
        """
        _req = await self._client.save_rule_with_http_info(
            index_name="indexName",
            object_id="id1",
            rule={
                "objectID": "id1",
                "conditions": [
                    {
                        "pattern": "apple",
                        "anchoring": "contains",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/indexName/rules/id1"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains"}]}"""
        )

    async def test_save_rule_1(self):
        """
        saveRule with all parameters
        """
        _req = await self._client.save_rule_with_http_info(
            index_name="indexName",
            object_id="id1",
            rule={
                "objectID": "id1",
                "conditions": [
                    {
                        "pattern": "apple",
                        "anchoring": "contains",
                        "alternatives": False,
                        "context": "search",
                    },
                ],
                "consequence": {
                    "params": {
                        "filters": "brand:apple",
                        "query": {
                            "remove": [
                                "algolia",
                            ],
                            "edits": [
                                {
                                    "type": "remove",
                                    "delete": "abc",
                                    "insert": "cde",
                                },
                                {
                                    "type": "replace",
                                    "delete": "abc",
                                    "insert": "cde",
                                },
                            ],
                        },
                    },
                    "hide": [
                        {
                            "objectID": "321",
                        },
                    ],
                    "filterPromotes": False,
                    "userData": {"algolia": "aloglia"},
                    "promote": [
                        {
                            "objectID": "abc",
                            "position": 3,
                        },
                        {
                            "objectIDs": [
                                "abc",
                                "def",
                            ],
                            "position": 1,
                        },
                    ],
                },
                "description": "test",
                "enabled": True,
                "validity": [
                    {
                        "from": 1656670273,
                        "until": 1656670277,
                    },
                ],
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/indexName/rules/id1"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}"""
        )

    async def test_save_rules_0(self):
        """
        saveRules with minimal parameters
        """
        _req = await self._client.save_rules_with_http_info(
            index_name="indexName",
            rules=[
                {
                    "objectID": "a-rule-id",
                    "conditions": [
                        {
                            "pattern": "smartphone",
                            "anchoring": "contains",
                        },
                    ],
                },
                {
                    "objectID": "a-second-rule-id",
                    "conditions": [
                        {
                            "pattern": "apple",
                            "anchoring": "contains",
                        },
                    ],
                },
            ],
        )

        assert _req.path == "/1/indexes/indexName/rules/batch"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """[{"objectID":"a-rule-id","conditions":[{"pattern":"smartphone","anchoring":"contains"}]},{"objectID":"a-second-rule-id","conditions":[{"pattern":"apple","anchoring":"contains"}]}]"""
        )

    async def test_save_rules_1(self):
        """
        saveRules with all parameters
        """
        _req = await self._client.save_rules_with_http_info(
            index_name="indexName",
            rules=[
                {
                    "objectID": "id1",
                    "conditions": [
                        {
                            "pattern": "apple",
                            "anchoring": "contains",
                            "alternatives": False,
                            "context": "search",
                        },
                    ],
                    "consequence": {
                        "params": {
                            "filters": "brand:apple",
                            "query": {
                                "remove": [
                                    "algolia",
                                ],
                                "edits": [
                                    {
                                        "type": "remove",
                                        "delete": "abc",
                                        "insert": "cde",
                                    },
                                    {
                                        "type": "replace",
                                        "delete": "abc",
                                        "insert": "cde",
                                    },
                                ],
                            },
                        },
                        "hide": [
                            {
                                "objectID": "321",
                            },
                        ],
                        "filterPromotes": False,
                        "userData": {"algolia": "aloglia"},
                        "promote": [
                            {
                                "objectID": "abc",
                                "position": 3,
                            },
                            {
                                "objectIDs": [
                                    "abc",
                                    "def",
                                ],
                                "position": 1,
                            },
                        ],
                    },
                    "description": "test",
                    "enabled": True,
                    "validity": [
                        {
                            "from": 1656670273,
                            "until": 1656670277,
                        },
                    ],
                },
            ],
            forward_to_replicas=True,
            clear_existing_rules=True,
        )

        assert _req.path == "/1/indexes/indexName/rules/batch"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"forwardToReplicas": "true", "clearExistingRules": "true"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """[{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}]"""
        )

    async def test_save_synonym_0(self):
        """
        saveSynonym0
        """
        _req = await self._client.save_synonym_with_http_info(
            index_name="indexName",
            object_id="id1",
            synonym_hit={
                "objectID": "id1",
                "type": "synonym",
                "synonyms": [
                    "car",
                    "vehicule",
                    "auto",
                ],
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/indexName/synonyms/id1"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]}"""
        )

    async def test_save_synonyms_0(self):
        """
        saveSynonyms0
        """
        _req = await self._client.save_synonyms_with_http_info(
            index_name="indexName",
            synonym_hit=[
                {
                    "objectID": "id1",
                    "type": "synonym",
                    "synonyms": [
                        "car",
                        "vehicule",
                        "auto",
                    ],
                },
                {
                    "objectID": "id2",
                    "type": "onewaysynonym",
                    "input": "iphone",
                    "synonyms": [
                        "ephone",
                        "aphone",
                        "yphone",
                    ],
                },
            ],
            forward_to_replicas=True,
            replace_existing_synonyms=False,
        )

        assert _req.path == "/1/indexes/indexName/synonyms/batch"
        assert _req.verb == "POST"
        assert (
            _req.query_parameters.items()
            == {"forwardToReplicas": "true", "replaceExistingSynonyms": "false"}.items()
        )
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """[{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]},{"objectID":"id2","type":"onewaysynonym","input":"iphone","synonyms":["ephone","aphone","yphone"]}]"""
        )

    async def test_search_0(self):
        """
        search for a single hits request with minimal parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_empty_index",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"cts_e2e_search_empty_index"}]}"""
        )

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_empty_index",
                    },
                ],
            },
        )
        assert raw_resp.status_code == 200

        resp = await SearchClient(self._e2e_app_id, self._e2e_api_key).search(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_empty_index",
                    },
                ],
            },
        )
        _expected_body = loads(
            """{"results":[{"hits":[],"page":0,"nbHits":0,"nbPages":0,"hitsPerPage":20,"exhaustiveNbHits":true,"exhaustiveTypo":true,"exhaustive":{"nbHits":true,"typo":true},"query":"","params":"","index":"cts_e2e_search_empty_index","renderingContent":{}}]}"""
        )
        assert self._helpers.union(_expected_body, resp) == _expected_body

    async def test_search_1(self):
        """
        search for a single facet request with minimal parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_facet",
                        "type": "facet",
                        "facet": "editor",
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"cts_e2e_search_facet","type":"facet","facet":"editor"}],"strategy":"stopIfEnoughMatches"}"""
        )

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_facet",
                        "type": "facet",
                        "facet": "editor",
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )
        assert raw_resp.status_code == 200

        resp = await SearchClient(self._e2e_app_id, self._e2e_api_key).search(
            search_method_params={
                "requests": [
                    {
                        "indexName": "cts_e2e_search_facet",
                        "type": "facet",
                        "facet": "editor",
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )
        _expected_body = loads(
            """{"results":[{"exhaustiveFacetsCount":true,"facetHits":[{"count":1,"highlighted":"goland","value":"goland"},{"count":1,"highlighted":"neovim","value":"neovim"},{"count":1,"highlighted":"vscode","value":"vscode"}]}]}"""
        )
        assert self._helpers.union(_expected_body, resp) == _expected_body

    async def test_search_2(self):
        """
        search for a single hits request with all parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "theIndexName",
                        "query": "myQuery",
                        "hitsPerPage": 50,
                        "type": "default",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}]}"""
        )

    async def test_search_3(self):
        """
        search for a single facet request with all parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "theIndexName",
                        "type": "facet",
                        "facet": "theFacet",
                        "facetQuery": "theFacetQuery",
                        "query": "theQuery",
                        "maxFacetHits": 50,
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50}],"strategy":"stopIfEnoughMatches"}"""
        )

    async def test_search_4(self):
        """
        search for multiple mixed requests in multiple indices with minimal parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "theIndexName",
                    },
                    {
                        "indexName": "theIndexName2",
                        "type": "facet",
                        "facet": "theFacet",
                    },
                    {
                        "indexName": "theIndexName",
                        "type": "default",
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"theIndexName"},{"indexName":"theIndexName2","type":"facet","facet":"theFacet"},{"indexName":"theIndexName","type":"default"}],"strategy":"stopIfEnoughMatches"}"""
        )

    async def test_search_5(self):
        """
        search for multiple mixed requests in multiple indices with all parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "theIndexName",
                        "type": "facet",
                        "facet": "theFacet",
                        "facetQuery": "theFacetQuery",
                        "query": "theQuery",
                        "maxFacetHits": 50,
                    },
                    {
                        "indexName": "theIndexName",
                        "query": "myQuery",
                        "hitsPerPage": 50,
                        "type": "default",
                    },
                ],
                "strategy": "stopIfEnoughMatches",
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50},{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}],"strategy":"stopIfEnoughMatches"}"""
        )

    async def test_search_6(self):
        """
        search filters accept all of the possible shapes
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "indexName": "theIndexName",
                        "facetFilters": "mySearch:filters",
                        "reRankingApplyFilter": "mySearch:filters",
                        "tagFilters": "mySearch:filters",
                        "numericFilters": "mySearch:filters",
                        "optionalFilters": "mySearch:filters",
                    },
                    {
                        "indexName": "theIndexName",
                        "facetFilters": [
                            "mySearch:filters",
                            [
                                "mySearch:filters",
                            ],
                        ],
                        "reRankingApplyFilter": [
                            "mySearch:filters",
                            [
                                "mySearch:filters",
                            ],
                        ],
                        "tagFilters": [
                            "mySearch:filters",
                            [
                                "mySearch:filters",
                            ],
                        ],
                        "numericFilters": [
                            "mySearch:filters",
                            [
                                "mySearch:filters",
                            ],
                        ],
                        "optionalFilters": [
                            "mySearch:filters",
                            [
                                "mySearch:filters",
                            ],
                        ],
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"indexName":"theIndexName","facetFilters":"mySearch:filters","reRankingApplyFilter":"mySearch:filters","tagFilters":"mySearch:filters","numericFilters":"mySearch:filters","optionalFilters":"mySearch:filters"},{"indexName":"theIndexName","facetFilters":["mySearch:filters",["mySearch:filters"]],"reRankingApplyFilter":["mySearch:filters",["mySearch:filters"]],"tagFilters":["mySearch:filters",["mySearch:filters"]],"numericFilters":["mySearch:filters",["mySearch:filters"]],"optionalFilters":["mySearch:filters",["mySearch:filters"]]}]}"""
        )

    async def test_search_7(self):
        """
        search with all search parameters
        """
        _req = await self._client.search_with_http_info(
            search_method_params={
                "requests": [
                    {
                        "advancedSyntax": True,
                        "advancedSyntaxFeatures": [
                            "exactPhrase",
                        ],
                        "allowTyposOnNumericTokens": True,
                        "alternativesAsExact": [
                            "multiWordsSynonym",
                        ],
                        "analytics": True,
                        "analyticsTags": [
                            "",
                        ],
                        "aroundLatLng": "",
                        "aroundLatLngViaIP": True,
                        "aroundPrecision": 0,
                        "aroundRadius": "all",
                        "attributeCriteriaComputedByMinProximity": True,
                        "attributesForFaceting": [
                            "",
                        ],
                        "attributesToHighlight": [
                            "",
                        ],
                        "attributesToRetrieve": [
                            "",
                        ],
                        "attributesToSnippet": [
                            "",
                        ],
                        "clickAnalytics": True,
                        "customRanking": [
                            "",
                        ],
                        "decompoundQuery": True,
                        "disableExactOnAttributes": [
                            "",
                        ],
                        "disableTypoToleranceOnAttributes": [
                            "",
                        ],
                        "distinct": 0,
                        "enableABTest": True,
                        "enablePersonalization": True,
                        "enableReRanking": True,
                        "enableRules": True,
                        "exactOnSingleWordQuery": "attribute",
                        "explain": [
                            "foo",
                            "bar",
                        ],
                        "facetFilters": [
                            "",
                        ],
                        "facetingAfterDistinct": True,
                        "facets": [
                            "",
                        ],
                        "filters": "",
                        "getRankingInfo": True,
                        "highlightPostTag": "",
                        "highlightPreTag": "",
                        "hitsPerPage": 1,
                        "ignorePlurals": False,
                        "indexName": "theIndexName",
                        "insideBoundingBox": [
                            [
                                47.3165,
                                4.9665,
                                47.3424,
                                5.0201,
                            ],
                            [
                                40.9234,
                                2.1185,
                                38.643,
                                1.9916,
                            ],
                        ],
                        "insidePolygon": [
                            [
                                47.3165,
                                4.9665,
                                47.3424,
                                5.0201,
                                47.32,
                                4.9,
                            ],
                            [
                                40.9234,
                                2.1185,
                                38.643,
                                1.9916,
                                39.2587,
                                2.0104,
                            ],
                        ],
                        "keepDiacriticsOnCharacters": "",
                        "length": 1,
                        "maxValuesPerFacet": 0,
                        "minProximity": 1,
                        "minWordSizefor1Typo": 0,
                        "minWordSizefor2Typos": 0,
                        "minimumAroundRadius": 1,
                        "naturalLanguages": [
                            "",
                        ],
                        "numericFilters": [
                            "",
                        ],
                        "offset": 0,
                        "optionalFilters": [
                            "",
                        ],
                        "optionalWords": [
                            "",
                        ],
                        "page": 0,
                        "percentileComputation": True,
                        "personalizationImpact": 0,
                        "query": "",
                        "queryLanguages": [
                            "",
                        ],
                        "queryType": "prefixAll",
                        "ranking": [
                            "",
                        ],
                        "reRankingApplyFilter": [
                            "",
                        ],
                        "relevancyStrictness": 0,
                        "removeStopWords": True,
                        "removeWordsIfNoResults": "allOptional",
                        "renderingContent": {
                            "facetOrdering": {
                                "facets": {
                                    "order": [
                                        "a",
                                        "b",
                                    ],
                                },
                                "values": {
                                    "a": {
                                        "order": [
                                            "b",
                                        ],
                                        "sortRemainingBy": "count",
                                    },
                                },
                            },
                        },
                        "replaceSynonymsInHighlight": True,
                        "responseFields": [
                            "",
                        ],
                        "restrictHighlightAndSnippetArrays": True,
                        "restrictSearchableAttributes": [
                            "",
                        ],
                        "ruleContexts": [
                            "",
                        ],
                        "similarQuery": "",
                        "snippetEllipsisText": "",
                        "sortFacetValuesBy": "",
                        "sumOrFiltersScores": True,
                        "synonyms": True,
                        "tagFilters": [
                            "",
                        ],
                        "type": "default",
                        "typoTolerance": "min",
                        "userToken": "",
                    },
                ],
            },
        )

        assert _req.path == "/1/indexes/*/queries"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"requests":[{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowTyposOnNumericTokens":true,"alternativesAsExact":["multiWordsSynonym"],"analytics":true,"analyticsTags":[""],"aroundLatLng":"","aroundLatLngViaIP":true,"aroundPrecision":0,"aroundRadius":"all","attributeCriteriaComputedByMinProximity":true,"attributesForFaceting":[""],"attributesToHighlight":[""],"attributesToRetrieve":[""],"attributesToSnippet":[""],"clickAnalytics":true,"customRanking":[""],"decompoundQuery":true,"disableExactOnAttributes":[""],"disableTypoToleranceOnAttributes":[""],"distinct":0,"enableABTest":true,"enablePersonalization":true,"enableReRanking":true,"enableRules":true,"exactOnSingleWordQuery":"attribute","explain":["foo","bar"],"facetFilters":[""],"facetingAfterDistinct":true,"facets":[""],"filters":"","getRankingInfo":true,"highlightPostTag":"","highlightPreTag":"","hitsPerPage":1,"ignorePlurals":false,"indexName":"theIndexName","insideBoundingBox":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],"insidePolygon":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],"keepDiacriticsOnCharacters":"","length":1,"maxValuesPerFacet":0,"minProximity":1,"minWordSizefor1Typo":0,"minWordSizefor2Typos":0,"minimumAroundRadius":1,"naturalLanguages":[""],"numericFilters":[""],"offset":0,"optionalFilters":[""],"optionalWords":[""],"page":0,"percentileComputation":true,"personalizationImpact":0,"query":"","queryLanguages":[""],"queryType":"prefixAll","ranking":[""],"reRankingApplyFilter":[""],"relevancyStrictness":0,"removeStopWords":true,"removeWordsIfNoResults":"allOptional","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"responseFields":[""],"restrictHighlightAndSnippetArrays":true,"restrictSearchableAttributes":[""],"ruleContexts":[""],"similarQuery":"","snippetEllipsisText":"","sortFacetValuesBy":"","sumOrFiltersScores":true,"synonyms":true,"tagFilters":[""],"type":"default","typoTolerance":"min","userToken":""}]}"""
        )

    async def test_search_dictionary_entries_0(self):
        """
        get searchDictionaryEntries results with minimal parameters
        """
        _req = await self._client.search_dictionary_entries_with_http_info(
            dictionary_name="compounds",
            search_dictionary_entries_params={
                "query": "foo",
            },
        )

        assert _req.path == "/1/dictionaries/compounds/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"query":"foo"}""")

    async def test_search_dictionary_entries_1(self):
        """
        get searchDictionaryEntries results with all parameters
        """
        _req = await self._client.search_dictionary_entries_with_http_info(
            dictionary_name="compounds",
            search_dictionary_entries_params={
                "query": "foo",
                "page": 4,
                "hitsPerPage": 2,
                "language": "fr",
            },
        )

        assert _req.path == "/1/dictionaries/compounds/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"foo","page":4,"hitsPerPage":2,"language":"fr"}"""
        )

    async def test_search_for_facet_values_0(self):
        """
        get searchForFacetValues results with minimal parameters
        """
        _req = await self._client.search_for_facet_values_with_http_info(
            index_name="indexName",
            facet_name="facetName",
        )

        assert _req.path == "/1/indexes/indexName/facets/facetName/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_search_for_facet_values_1(self):
        """
        get searchForFacetValues results with all parameters
        """
        _req = await self._client.search_for_facet_values_with_http_info(
            index_name="indexName",
            facet_name="facetName",
            search_for_facet_values_request={
                "params": "query=foo&facetFilters=['bar']",
                "facetQuery": "foo",
                "maxFacetHits": 42,
            },
        )

        assert _req.path == "/1/indexes/indexName/facets/facetName/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"params":"query=foo&facetFilters=['bar']","facetQuery":"foo","maxFacetHits":42}"""
        )

    async def test_search_rules_0(self):
        """
        searchRules0
        """
        _req = await self._client.search_rules_with_http_info(
            index_name="indexName",
            search_rules_params={
                "query": "something",
            },
        )

        assert _req.path == "/1/indexes/indexName/rules/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"query":"something"}""")

    async def test_search_single_index_0(self):
        """
        search with minimal parameters
        """
        _req = await self._client.search_single_index_with_http_info(
            index_name="indexName",
        )

        assert _req.path == "/1/indexes/indexName/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_search_single_index_1(self):
        """
        search with special characters in indexName
        """
        _req = await self._client.search_single_index_with_http_info(
            index_name="cts_e2e_space in index",
        )

        assert _req.path == "/1/indexes/cts_e2e_space%20in%20index/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).search_single_index_with_http_info(
            index_name="cts_e2e_space in index",
        )
        assert raw_resp.status_code == 200

    async def test_search_single_index_2(self):
        """
        search with searchParams
        """
        _req = await self._client.search_single_index_with_http_info(
            index_name="indexName",
            search_params={
                "query": "myQuery",
                "facetFilters": [
                    "tags:algolia",
                ],
            },
        )

        assert _req.path == "/1/indexes/indexName/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"myQuery","facetFilters":["tags:algolia"]}"""
        )

    async def test_search_single_index_3(self):
        """
        single search retrieve snippets
        """
        _req = await self._client.search_single_index_with_http_info(
            index_name="cts_e2e_browse",
            search_params={
                "query": "batman mask of the phantasm",
                "attributesToRetrieve": [
                    "*",
                ],
                "attributesToSnippet": [
                    "*:20",
                ],
            },
        )

        assert _req.path == "/1/indexes/cts_e2e_browse/query"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"batman mask of the phantasm","attributesToRetrieve":["*"],"attributesToSnippet":["*:20"]}"""
        )

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).search_single_index_with_http_info(
            index_name="cts_e2e_browse",
            search_params={
                "query": "batman mask of the phantasm",
                "attributesToRetrieve": [
                    "*",
                ],
                "attributesToSnippet": [
                    "*:20",
                ],
            },
        )
        assert raw_resp.status_code == 200

        resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).search_single_index(
            index_name="cts_e2e_browse",
            search_params={
                "query": "batman mask of the phantasm",
                "attributesToRetrieve": [
                    "*",
                ],
                "attributesToSnippet": [
                    "*:20",
                ],
            },
        )
        _expected_body = loads(
            """{"nbHits":1,"hits":[{"_snippetResult":{"genres":[{"value":"Animated","matchLevel":"none"},{"value":"Superhero","matchLevel":"none"},{"value":"Romance","matchLevel":"none"}],"year":{"value":"1993","matchLevel":"none"}},"_highlightResult":{"genres":[{"value":"Animated","matchLevel":"none","matchedWords":[]},{"value":"Superhero","matchLevel":"none","matchedWords":[]},{"value":"Romance","matchLevel":"none","matchedWords":[]}],"year":{"value":"1993","matchLevel":"none","matchedWords":[]}}}]}"""
        )
        assert self._helpers.union(_expected_body, resp) == _expected_body

    async def test_search_synonyms_0(self):
        """
        searchSynonyms with minimal parameters
        """
        _req = await self._client.search_synonyms_with_http_info(
            index_name="indexName",
        )

        assert _req.path == "/1/indexes/indexName/synonyms/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{}""")

    async def test_search_synonyms_1(self):
        """
        searchSynonyms with all parameters
        """
        _req = await self._client.search_synonyms_with_http_info(
            index_name="indexName",
            search_synonyms_params={
                "query": "myQuery",
                "type": "altcorrection1",
                "page": 10,
                "hitsPerPage": 10,
            },
        )

        assert _req.path == "/1/indexes/indexName/synonyms/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"myQuery","type":"altcorrection1","page":10,"hitsPerPage":10}"""
        )

    async def test_search_user_ids_0(self):
        """
        searchUserIds0
        """
        _req = await self._client.search_user_ids_with_http_info(
            search_user_ids_params={
                "query": "test",
                "clusterName": "theClusterName",
                "page": 5,
                "hitsPerPage": 10,
            },
        )

        assert _req.path == "/1/clusters/mapping/search"
        assert _req.verb == "POST"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"query":"test","clusterName":"theClusterName","page":5,"hitsPerPage":10}"""
        )

    async def test_set_dictionary_settings_0(self):
        """
        get setDictionarySettings results with minimal parameters
        """
        _req = await self._client.set_dictionary_settings_with_http_info(
            dictionary_settings_params={
                "disableStandardEntries": {
                    "plurals": {
                        "fr": False,
                        "en": False,
                        "ru": True,
                    },
                },
            },
        )

        assert _req.path == "/1/dictionaries/*/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true}}}"""
        )

    async def test_set_dictionary_settings_1(self):
        """
        get setDictionarySettings results with all parameters
        """
        _req = await self._client.set_dictionary_settings_with_http_info(
            dictionary_settings_params={
                "disableStandardEntries": {
                    "plurals": {
                        "fr": False,
                        "en": False,
                        "ru": True,
                    },
                    "stopwords": {
                        "fr": False,
                    },
                    "compounds": {
                        "ru": True,
                    },
                },
            },
        )

        assert _req.path == "/1/dictionaries/*/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true},"stopwords":{"fr":false},"compounds":{"ru":true}}}"""
        )

    async def test_set_settings_0(self):
        """
        setSettings with minimal parameters
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="cts_e2e_settings",
            index_settings={
                "paginationLimitedTo": 10,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/cts_e2e_settings/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"paginationLimitedTo":10}""")

        raw_resp = await SearchClient(
            self._e2e_app_id, self._e2e_api_key
        ).set_settings_with_http_info(
            index_name="cts_e2e_settings",
            index_settings={
                "paginationLimitedTo": 10,
            },
            forward_to_replicas=True,
        )
        assert raw_resp.status_code == 200

    async def test_set_settings_1(self):
        """
        setSettings allow boolean `typoTolerance`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "typoTolerance": True,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"typoTolerance":true}""")

    async def test_set_settings_2(self):
        """
        setSettings allow enum `typoTolerance`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "typoTolerance": "min",
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"typoTolerance":"min"}""")

    async def test_set_settings_3(self):
        """
        setSettings allow boolean `ignorePlurals`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "ignorePlurals": True,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"ignorePlurals":true}""")

    async def test_set_settings_4(self):
        """
        setSettings allow list of string `ignorePlurals`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "ignorePlurals": [
                    "algolia",
                ],
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"ignorePlurals":["algolia"]}""")

    async def test_set_settings_5(self):
        """
        setSettings allow boolean `removeStopWords`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "removeStopWords": True,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"removeStopWords":true}""")

    async def test_set_settings_6(self):
        """
        setSettings allow list of string `removeStopWords`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "removeStopWords": [
                    "algolia",
                ],
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"removeStopWords":["algolia"]}""")

    async def test_set_settings_7(self):
        """
        setSettings allow boolean `distinct`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "distinct": True,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"distinct":true}""")

    async def test_set_settings_8(self):
        """
        setSettings allow integers for `distinct`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "distinct": 1,
            },
            forward_to_replicas=True,
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {"forwardToReplicas": "true"}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads("""{"distinct":1}""")

    async def test_set_settings_9(self):
        """
        setSettings allow all `indexSettings`
        """
        _req = await self._client.set_settings_with_http_info(
            index_name="theIndexName",
            index_settings={
                "advancedSyntax": True,
                "advancedSyntaxFeatures": [
                    "exactPhrase",
                ],
                "allowCompressionOfIntegerArray": True,
                "allowTyposOnNumericTokens": True,
                "alternativesAsExact": [
                    "singleWordSynonym",
                ],
                "attributeCriteriaComputedByMinProximity": True,
                "attributeForDistinct": "test",
                "attributesForFaceting": [
                    "algolia",
                ],
                "attributesToHighlight": [
                    "algolia",
                ],
                "attributesToRetrieve": [
                    "algolia",
                ],
                "attributesToSnippet": [
                    "algolia",
                ],
                "attributesToTransliterate": [
                    "algolia",
                ],
                "camelCaseAttributes": [
                    "algolia",
                ],
                "customNormalization": {
                    "algolia": {
                        "aloglia": "aglolia",
                    },
                },
                "customRanking": [
                    "algolia",
                ],
                "decompoundQuery": False,
                "decompoundedAttributes": {
                    "algolia": "aloglia",
                },
                "disableExactOnAttributes": [
                    "algolia",
                ],
                "disablePrefixOnAttributes": [
                    "algolia",
                ],
                "disableTypoToleranceOnAttributes": [
                    "algolia",
                ],
                "disableTypoToleranceOnWords": [
                    "algolia",
                ],
                "distinct": 3,
                "enablePersonalization": True,
                "enableReRanking": False,
                "enableRules": True,
                "exactOnSingleWordQuery": "attribute",
                "highlightPreTag": "<span>",
                "highlightPostTag": "</span>",
                "hitsPerPage": 10,
                "ignorePlurals": False,
                "indexLanguages": [
                    "algolia",
                ],
                "keepDiacriticsOnCharacters": "abc",
                "maxFacetHits": 20,
                "maxValuesPerFacet": 30,
                "minProximity": 6,
                "minWordSizefor1Typo": 5,
                "minWordSizefor2Typos": 11,
                "mode": "neuralSearch",
                "numericAttributesForFiltering": [
                    "algolia",
                ],
                "optionalWords": [
                    "myspace",
                ],
                "paginationLimitedTo": 0,
                "queryLanguages": [
                    "algolia",
                ],
                "queryType": "prefixLast",
                "ranking": [
                    "geo",
                ],
                "reRankingApplyFilter": "mySearch:filters",
                "relevancyStrictness": 10,
                "removeStopWords": False,
                "removeWordsIfNoResults": "lastWords",
                "renderingContent": {
                    "facetOrdering": {
                        "facets": {
                            "order": [
                                "a",
                                "b",
                            ],
                        },
                        "values": {
                            "a": {
                                "order": [
                                    "b",
                                ],
                                "sortRemainingBy": "count",
                            },
                        },
                    },
                },
                "replaceSynonymsInHighlight": True,
                "replicas": [
                    "",
                ],
                "responseFields": [
                    "algolia",
                ],
                "restrictHighlightAndSnippetArrays": True,
                "searchableAttributes": [
                    "foo",
                ],
                "semanticSearch": {
                    "eventSources": [
                        "foo",
                    ],
                },
                "separatorsToIndex": "bar",
                "snippetEllipsisText": "---",
                "sortFacetValuesBy": "date",
                "typoTolerance": False,
                "unretrievableAttributes": [
                    "foo",
                ],
                "userData": {
                    "user": "data",
                },
            },
        )

        assert _req.path == "/1/indexes/theIndexName/settings"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowCompressionOfIntegerArray":true,"allowTyposOnNumericTokens":true,"alternativesAsExact":["singleWordSynonym"],"attributeCriteriaComputedByMinProximity":true,"attributeForDistinct":"test","attributesForFaceting":["algolia"],"attributesToHighlight":["algolia"],"attributesToRetrieve":["algolia"],"attributesToSnippet":["algolia"],"attributesToTransliterate":["algolia"],"camelCaseAttributes":["algolia"],"customNormalization":{"algolia":{"aloglia":"aglolia"}},"customRanking":["algolia"],"decompoundQuery":false,"decompoundedAttributes":{"algolia":"aloglia"},"disableExactOnAttributes":["algolia"],"disablePrefixOnAttributes":["algolia"],"disableTypoToleranceOnAttributes":["algolia"],"disableTypoToleranceOnWords":["algolia"],"distinct":3,"enablePersonalization":true,"enableReRanking":false,"enableRules":true,"exactOnSingleWordQuery":"attribute","highlightPreTag":"<span>","highlightPostTag":"</span>","hitsPerPage":10,"ignorePlurals":false,"indexLanguages":["algolia"],"keepDiacriticsOnCharacters":"abc","maxFacetHits":20,"maxValuesPerFacet":30,"minProximity":6,"minWordSizefor1Typo":5,"minWordSizefor2Typos":11,"mode":"neuralSearch","numericAttributesForFiltering":["algolia"],"optionalWords":["myspace"],"paginationLimitedTo":0,"queryLanguages":["algolia"],"queryType":"prefixLast","ranking":["geo"],"reRankingApplyFilter":"mySearch:filters","relevancyStrictness":10,"removeStopWords":false,"removeWordsIfNoResults":"lastWords","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"replicas":[""],"responseFields":["algolia"],"restrictHighlightAndSnippetArrays":true,"searchableAttributes":["foo"],"semanticSearch":{"eventSources":["foo"]},"separatorsToIndex":"bar","snippetEllipsisText":"---","sortFacetValuesBy":"date","typoTolerance":false,"unretrievableAttributes":["foo"],"userData":{"user":"data"}}"""
        )

    async def test_update_api_key_0(self):
        """
        updateApiKey0
        """
        _req = await self._client.update_api_key_with_http_info(
            key="myApiKey",
            api_key={
                "acl": [
                    "search",
                    "addObject",
                ],
                "validity": 300,
                "maxQueriesPerIPPerHour": 100,
                "maxHitsPerQuery": 20,
            },
        )

        assert _req.path == "/1/keys/myApiKey"
        assert _req.verb == "PUT"
        assert _req.query_parameters.items() == {}.items()
        assert _req.headers.items() >= {}.items()
        assert loads(_req.data) == loads(
            """{"acl":["search","addObject"],"validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}"""
        )

    def test_generate_secured_api_key_0(self):
        """
        allow generating a secured api key without restrictions
        """
        _resp = self._client.generate_secured_api_key(parent_api_key="foo")
        assert (
            _resp
            == "Yzc2MzU2ZWZhMTlkMjE5ZDFkN2UwOGNjYjIwYjFkMjZkYjUzYjE0MzE1NmY0MDZjOTlkY2I4ZTA4NzZkNmM1NXt9"
        )

    def test_generate_secured_api_key_1(self):
        """
        allow generating a secured api key with a dict of restrictions
        """
        _resp = self._client.generate_secured_api_key(
            parent_api_key="foo",
            restrictions={
                "search_params": {"query": "foo"},
                "valid_until": 100,
                "restrict_indices": ["bar"],
                "restrict_sources": "baz",
                "user_token": "foobarbaz",
            },
        )
        assert (
            _resp
            == "OGM3YTUyNjI5MTExNjEwNWQ5ZTJhYzBlMWFmY2VjNTg3MmRlZTM4MjZmNzk2MjVmOTJkZGUyNjFhZTQzNDJlNXsic2VhcmNoX3BhcmFtcyI6ICJ7XCJxdWVyeVwiOiBcImZvb1wifSIsICJ2YWxpZF91bnRpbCI6ICIxMDAiLCAicmVzdHJpY3RfaW5kaWNlcyI6ICJiYXIiLCAicmVzdHJpY3Rfc291cmNlcyI6ICJiYXoiLCAidXNlcl90b2tlbiI6ICJmb29iYXJiYXoifQ=="
        )

    def test_generate_secured_api_key_2(self):
        """
        allow generating a secured api key with from the model
        """
        _resp = self._client.generate_secured_api_key(
            parent_api_key="bar",
            restrictions=SecuredAPIKeyRestrictions(
                search_params={"query": "bar", "page": 3},
                valid_until=42,
                restrict_indices=["baz"],
                restrict_sources="foo",
                user_token="bazbarfoo",
            ),
        )
        assert (
            _resp
            == "Y2ZhNWM0Y2MxNjc1NTE2YjhiZjdlMGU5YWE1OGViOTk5MTdjMGU1YjRhNDU2NTczOWI5ZGE5Y2NjMTJmMDE0YXsic2VhcmNoUGFyYW1zIjogIntcInF1ZXJ5XCI6IFwiYmFyXCIsIFwic2ltaWxhclF1ZXJ5XCI6IFwiXCIsIFwiZmlsdGVyc1wiOiBcIlwiLCBcInN1bU9yRmlsdGVyc1Njb3Jlc1wiOiBmYWxzZSwgXCJmYWNldGluZ0FmdGVyRGlzdGluY3RcIjogZmFsc2UsIFwicGFnZVwiOiAzLCBcImFyb3VuZExhdExuZ1wiOiBcIlwiLCBcImFyb3VuZExhdExuZ1ZpYUlQXCI6IGZhbHNlLCBcInBlcnNvbmFsaXphdGlvbkltcGFjdFwiOiAxMDAsIFwiZ2V0UmFua2luZ0luZm9cIjogZmFsc2UsIFwic3lub255bXNcIjogdHJ1ZSwgXCJjbGlja0FuYWx5dGljc1wiOiBmYWxzZSwgXCJhbmFseXRpY3NcIjogdHJ1ZSwgXCJwZXJjZW50aWxlQ29tcHV0YXRpb25cIjogdHJ1ZSwgXCJlbmFibGVBQlRlc3RcIjogdHJ1ZSwgXCJyZWxldmFuY3lTdHJpY3RuZXNzXCI6IDEwMCwgXCJoaWdobGlnaHRQcmVUYWdcIjogXCI8ZW0+XCIsIFwiaGlnaGxpZ2h0UG9zdFRhZ1wiOiBcIjwvZW0+XCIsIFwic25pcHBldEVsbGlwc2lzVGV4dFwiOiBcIlxcdTIwMjZcIiwgXCJyZXN0cmljdEhpZ2hsaWdodEFuZFNuaXBwZXRBcnJheXNcIjogZmFsc2UsIFwiaGl0c1BlclBhZ2VcIjogMjAsIFwibWluV29yZFNpemVmb3IxVHlwb1wiOiA0LCBcIm1pbldvcmRTaXplZm9yMlR5cG9zXCI6IDgsIFwiYWxsb3dUeXBvc09uTnVtZXJpY1Rva2Vuc1wiOiB0cnVlLCBcImtlZXBEaWFjcml0aWNzT25DaGFyYWN0ZXJzXCI6IFwiXCIsIFwiZGVjb21wb3VuZFF1ZXJ5XCI6IHRydWUsIFwiZW5hYmxlUnVsZXNcIjogdHJ1ZSwgXCJlbmFibGVQZXJzb25hbGl6YXRpb25cIjogZmFsc2UsIFwiYWR2YW5jZWRTeW50YXhcIjogZmFsc2UsIFwicmVwbGFjZVN5bm9ueW1zSW5IaWdobGlnaHRcIjogZmFsc2UsIFwibWluUHJveGltaXR5XCI6IDEsIFwibWF4RmFjZXRIaXRzXCI6IDEwLCBcIm1heFZhbHVlc1BlckZhY2V0XCI6IDEwMCwgXCJzb3J0RmFjZXRWYWx1ZXNCeVwiOiBcImNvdW50XCIsIFwiYXR0cmlidXRlQ3JpdGVyaWFDb21wdXRlZEJ5TWluUHJveGltaXR5XCI6IGZhbHNlLCBcImVuYWJsZVJlUmFua2luZ1wiOiB0cnVlfSIsICJ2YWxpZFVudGlsIjogIjQyIiwgInJlc3RyaWN0SW5kaWNlcyI6ICJiYXoiLCAicmVzdHJpY3RTb3VyY2VzIjogImZvbyIsICJ1c2VyVG9rZW4iOiAiYmF6YmFyZm9vIn0="
        )

    def test_generate_secured_api_key_and_validity_0(self):
        """
        is able to check the remaining validity of a key
        """
        _resp = self._client.generate_secured_api_key(
            parent_api_key="foo", restrictions={"valid_until": 0}
        )
        _validity = self._client.get_secured_api_key_remaining_validity(_resp)
        assert abs(_validity) == int(round(time()))

    def test_generate_secured_api_key_and_validity_1(self):
        """
        throws when the validity field is not found
        """
        try:
            _resp = self._client.generate_secured_api_key("foo", {"valid_until": None})
            self._client.get_secured_api_key_remaining_validity(_resp)
            assert False
        except Exception as e:
            assert str(e) == "valid_until not found in api key."

    def test_generate_secured_api_key_and_validity_2(self):
        """
        throws when the invalid key
        """
        try:
            self._client.get_secured_api_key_remaining_validity("foo")
            assert False
        except Exception as e:
            assert str(e) == "Incorrect padding"

    async def test_replace_all_objects_0(self):
        """
        executes with minimal parameters
        """
        self._client.batch = AsyncMock(
            return_value=BatchResponse(task_id=42, object_ids=["foo", "bar"])
        )
        self._client.operation_index = AsyncMock(
            return_value=UpdatedAtResponse(task_id=21, updated_at="foobar")
        )
        self._client.get_task = AsyncMock(
            return_value=GetTaskResponse(status="published")
        )
        _resp = await self._client.replace_all_objects(
            index_name="foo", objects=[{"name": "John Doe"}]
        )
        self._client.operation_index.assert_called()
        self._client.batch.assert_called()
        self._client.operation_index.assert_called()
        assert _resp == {
            "batch_responses": [BatchResponse(task_id=42, object_ids=["foo", "bar"])],
            "copy_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
            "move_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
        }

    async def test_replace_all_objects_1(self):
        """
        does many calls when len(objects) > batchSize
        """
        self._client.batch = AsyncMock(
            return_value=BatchResponse(task_id=42, object_ids=["foo", "bar"])
        )
        self._client.operation_index = AsyncMock(
            return_value=UpdatedAtResponse(task_id=21, updated_at="foobar")
        )
        self._client.get_task = AsyncMock(
            return_value=GetTaskResponse(status="published")
        )
        _resp = await self._client.replace_all_objects(
            index_name="foo",
            objects=[
                {
                    "name": f"John Doe{i}",
                    "objectID": f"fff2bd4d-bb17-4e21-a0c4-0a8ea5e363f2{i}",
                }
                for i in range(33)
            ],
            batch_size=10,
        )
        self._client.operation_index.assert_called()
        self._client.batch.assert_called()
        self._client.operation_index.assert_called()
        assert _resp == {
            "batch_responses": [
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
            ],
            "copy_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
            "move_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
        }

    async def test_replace_all_objects_2(self):
        """
        batchSize is 1000 by default
        """
        self._client.batch = AsyncMock(
            return_value=BatchResponse(task_id=42, object_ids=["foo", "bar"])
        )
        self._client.operation_index = AsyncMock(
            return_value=UpdatedAtResponse(task_id=21, updated_at="foobar")
        )
        self._client.get_task = AsyncMock(
            return_value=GetTaskResponse(status="published")
        )
        _resp = await self._client.replace_all_objects(
            index_name="foo",
            objects=[
                {
                    "name": f"John Doe{i}",
                    "objectID": f"fff2bd4d-bb17-4e21-a0c4-0a8ea5e363f2{i}",
                }
                for i in range(1001)
            ],
        )
        self._client.operation_index.assert_called()
        self._client.batch.assert_called()
        self._client.operation_index.assert_called()
        assert _resp == {
            "batch_responses": [
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
                BatchResponse(task_id=42, object_ids=["foo", "bar"]),
            ],
            "copy_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
            "move_operation_response": UpdatedAtResponse(
                task_id=21, updated_at="foobar"
            ),
        }
