from asyncio import run

from algoliasearch.ingestion import __version__, IngestionClient


async def main():
    print("IngestionClient version", __version__)

    client = IngestionClient()

    print("client initialized", client)

    try:
        response = await client.get_sources()

        print(response)
    finally:
        await client.close()

        print("client closed", client)

run(main())
