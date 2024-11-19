from asyncio import run

from algoliasearch.abtesting import __version__
from algoliasearch.abtesting.client import AbtestingClient


async def main():
    print("AbtestingClient version", __version__)

    client = AbtestingClient("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.stop_ab_test(id=10)

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
