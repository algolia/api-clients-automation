from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
from algoliasearch.search.models.search_method_params import SearchMethodParams
from algoliasearch.search.models.search_for_hits import SearchForHits
from algoliasearch.search.models.search_query import SearchQuery
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient(environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"))
    print("client initialized", client)

    try:
        response = await client.search(
            search_method_params=SearchMethodParams(
                requests=[
                    SearchQuery(SearchForHits(index_name="cts_e2e_search_facet")),
                ],
            ),
        )

        print("client response")
        print(response.to_json())
    finally:
        await client.close()

        print("client closed")


run(main())
