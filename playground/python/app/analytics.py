from asyncio import run

from algoliasearch.analytics import __version__, AnalyticsClient


async def main():
    print("AnalyticsClient version", __version__)

    client = AnalyticsClient()

    print("client initialized", client)

    try:
        response = await client.get_users_count(index="nvim")

        print(response)
    finally:
        await client.close()

        print("client closed", client)

run(main())
