from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
from algoliasearch.search.models.api_key import ApiKey
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient.create(environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"))
    print("client initialized", client)

    try:
        response = await client.add_api_key(
            api_key=ApiKey(acl=["search"], description="search key", indexes=["cts_e2e_save"])
        )

        print("client response")
        print(response.to_json())

        _wait = await client.wait_for_api_key(operation="add", key=response.key)

        print("wait response")
        print(_wait.to_json())
    finally:
        await client.close()

        print("client closed")


run(main())
