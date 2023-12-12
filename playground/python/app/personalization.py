from asyncio import run

from algoliasearch.personalization import PersonalizationClient, __version__


async def main():
    print("PersonalizationClient version", __version__)

    client = PersonalizationClient.create("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.delete_user_profile(user_token="foo")

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
