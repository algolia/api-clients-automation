from algoliasearch.search import __version__
from algoliasearch.search.client import SearchClientSync, SearchClient
from algoliasearch.search.config import SearchConfig
from asyncio import run
from dotenv import load_dotenv
from os import environ

load_dotenv("../.env")


# def main():
#     print("SearchClient version", __version__)
#
#     client = SearchClientSync(
#         environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
#     )
#     client.add_user_agent("playground")
#     client.add_user_agent("bar", "baz")
#
#     print("user_agent", client._config._user_agent.get())
#     print("client initialized", client)
#
#     try:
#         resp = client.search_single_index("poussing-RECORDS")
#         print(resp.to_dict())
#     finally:
#         client.close()
#
#         print("client closed")


async def asyncmain():
    client = SearchClient(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )

    print("client initialized", client)

    try:
        await client.search_single_index("poussing-RECDS")
        print("resp ok")
    finally:
        await client.close()

        print("client closed", client)


run(asyncmain())
