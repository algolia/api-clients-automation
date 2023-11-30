from asyncio import run

from algoliasearch.search import __version__
from algoliasearch.search.client import SearchClient


async def main():
    print("SearchClient version", __version__)

    client = SearchClient.create("QPBQ67WNIG", "b590ae1153bf574215ca1605c19eb1fe")

    print("client initialized", client)

    try:
        response = await client.get_settings(index_name="nvim")

        print(response)
    finally:
        await client.close()

        print("client closed", client)

run(main())
