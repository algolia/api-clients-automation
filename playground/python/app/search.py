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
        resp = await client.replace_all_objects(
            index_name="test_replace_all_objects",
            objects=[{"name": f"John Doe{i}", "objectID": f"fff2bd4d-bb17-4e21-a0c4-0a8ea5e363f2{i}" } for i in range(33)],
            batch_size=10
        )

        print(resp)
    finally:
        await client.close()

        print("client closed")


run(main())
