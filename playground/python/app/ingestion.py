from asyncio import run

from algoliasearch.ingestion import __version__
from algoliasearch.ingestion.client import IngestionClient


async def main():
    print("IngestionClient version", __version__)

    client = IngestionClient("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.list_sources()

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
