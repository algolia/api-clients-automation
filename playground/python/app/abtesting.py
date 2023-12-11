from asyncio import run

from algoliasearch.abtesting import AbtestingClient, __version__


async def main():
    print("AbtestingClient version", __version__)

    client = AbtestingClient()

    print("client initialized", client)

    try:
        response = await client.stop_ab_test(id=10)

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
