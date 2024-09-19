from asyncio import run
from os import environ
from base64 import b64decode

from algoliasearch.search.client import SearchClient
from algoliasearch.search.models.search_params_object import SearchParamsObject
from algoliasearch.search.models.secured_api_key_restrictions import (
    SecuredApiKeyRestrictions,
)
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )
    print("client initialized", client)

    try:
        # resp = await client.search(search_method_params={
        #   "requests": [{"indexName": "api-clients-automation"}]
        # })
        # print(resp.to_dict())
        print(
            b64decode(await client.generate_secured_api_key(
                "foo",
                SecuredApiKeyRestrictions(
                    restrictIndices=["foo"],
                    filters="bar",
                    searchParams=SearchParamsObject(attributesToRetrieve=["baz"]),
                ),
            ))
        )
    finally:
        await client.close()

        print("client closed")


run(main())
