from asyncio import run

from algoliasearch.query_suggestions import __version__
from algoliasearch.query_suggestions.client import QuerySuggestionsClient
from algoliasearch.query_suggestions.models.configuration_with_index import (
    ConfigurationWithIndex,
)
from algoliasearch.query_suggestions.models.source_index import SourceIndex


async def main():
    print("QuerySuggestionsClient version", __version__)

    client = QuerySuggestionsClient("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.create_config(
            configuration_with_index=ConfigurationWithIndex(
                index_name="products",
                source_indices=[SourceIndex(index_name="products")],
            )
        )

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
