from asyncio import run

from algoliasearch.insights import __version__
from algoliasearch.insights.client import InsightsClient


async def main():
    print("InsightsClient version", __version__)

    client = InsightsClient("FOO", "BAR")

    print("client initialized", client)

    try:
        response = await client.push_events(
            insights_events={
                "events": [
                    {
                        "eventType": "click",
                        "eventName": "Product Clicked",
                        "index": "products",
                        "userToken": "user-123456",
                        "authenticatedUserToken": "user-123456",
                        "timestamp": 1641290601962,
                        "objectIDs": [
                            "9780545139700",
                            "9780439784542",
                        ],
                        "queryID": "43b15df305339e827f0ac0bdc5ebcaa7",
                        "positions": [
                            7,
                            6,
                        ],
                    },
                ],
            },
        )

        print(response)
    finally:
        await client.close()

        print("client closed", client)


run(main())
