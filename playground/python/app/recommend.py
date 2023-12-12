from asyncio import run

from algoliasearch.recommend import RecommendClient, __version__


async def main():
    print("RecommendClient version", __version__)

    client = RecommendClient.create("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.delete_recommend_rule(index_name="nvim")

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
