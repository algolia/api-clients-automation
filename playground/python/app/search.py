from asyncio import run

from algoliasearch.search import SearchClient, __version__
from algoliasearch.search.models import SearchMethodParams, SearchQuery


async def main():
    print("SearchClient version", __version__)

    client = SearchClient.create("QPBQ67WNIG", "b590ae1153bf574215ca1605c19eb1fe")

    print("client initialized", client)

    try:
        # response = await client.search(
        #     search_method_params={"requests": [{"indexName": "nvim"}]},
        #     request_options=RequestOptions({"foo": "bar"}, {}, {"readTimeout": 1, "writeTimeout": 2}, {})
        # )

        response = await client.search(
            search_method_params=SearchMethodParams(
                requests=[SearchQuery(index_name="nvim", query="foo")]
            )
        )

        print(response.to_json())
    finally:
        await client.close()

        print("client closed", client)


run(main())
