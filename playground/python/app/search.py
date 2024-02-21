from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient(environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"))
    print("client initialized", client)

    try:
        resp = await client.browse_synonyms(index_name="test-flag", aggregator=lambda _resp: print(_resp))

        print(resp)
    finally:
        await client.close()

        print("client closed")


run(main())
