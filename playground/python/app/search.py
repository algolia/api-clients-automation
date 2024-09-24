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
        resp = await client.search(search_method_params={
          "requests": [{"indexName": "api-clients-automation"}]
        })
        print(resp.to_dict())
    finally:
        await client.close()

        print("client closed")


run(main())
