from asyncio import run
from os import environ

from algoliasearch.recommend import __version__
from algoliasearch.recommend.client import RecommendClient
from algoliasearch.recommend.models.get_recommendations_params import (
    GetRecommendationsParams,
)
from algoliasearch.recommend.models.related_query import RelatedQuery
from algoliasearch.recommend.models.recommendations_request import (
    RecommendationsRequest,
)
from algoliasearch.recommend.models.related_model import RelatedModel

from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("RecommendClient version", __version__)

    client = RecommendClient(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )

    print("client initialized", client)

    try:
        response = await client.get_recommendations(
            GetRecommendationsParams(
                requests=[
                    RecommendationsRequest(
                        RelatedQuery(
                            index_name="cts_e2e_browse",
                            object_id="Æon Flux",
                            model=RelatedModel.RELATED_PRODUCTS,
                            threshold=30,
                            max_recommendations=2,
                        )
                    )
                ]
            )
        )

        print(len(response.results[0].hits), "recommendations found")
    finally:
        await client.close()

        print("client closed", client)


run(main())
