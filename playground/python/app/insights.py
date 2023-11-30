from asyncio import run

from algoliasearch.insights import __version__
from algoliasearch.insights.client import InsightsClient


async def main():
    print("InsightsClient version", __version__)

    client = InsightsClient.create("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.push_events(user_token="foo")

        print(response)
    finally:
        await client.close()

        print("client closed", client)

run(main())
