from os import environ
from asyncio import run

from algoliasearch.ingestion import __version__
from algoliasearch.ingestion.client import IngestionClient
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("IngestionClient version", __version__)

    client = IngestionClient(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"), "eu"
    )

    print("client initialized", client)

    try:
        response = await client.list_sources()

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
