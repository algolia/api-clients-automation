from asyncio import run

from algoliasearch.query_suggestions import __version__, QuerySuggestionsClient


async def main():
    print("QuerySuggestionsClient version", __version__)

    client = QuerySuggestionsClient.create("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.create_config(index_name="nvim")

        print(response)
    finally:
        await client.close()

        print("client closed", client)

run(main())
