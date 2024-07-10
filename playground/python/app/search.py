from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
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
        await client.browse_objects(
            index_name="api-clients-automation",
            aggregator=lambda _resp: print("baaaaaaaaaaaaaaar", _resp.to_json()),
        )
    finally:
        await client.close()

        print("client closed")


run(main())
