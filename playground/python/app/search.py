from os import environ

from algoliasearch.search.client import SearchClientSync
from algoliasearch.search.config import SearchConfig
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


def main():
    print("SearchClient version", __version__)

    client = SearchClientSync(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )
    client.add_user_agent("playground")
    client.add_user_agent("bar", "baz")

    print("user_agent", client._config._user_agent.get())
    print("client initialized", client)

    try:
        resp = client.search_single_index("poussing-RECORDS")
        print(resp.to_dict())
    finally:
        client.close()

        print("client closed")

    # print("with transformations")
    #
    # config = SearchConfig(
    #     environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    # )
    #
    # config.set_transformation_region("eu")
    #
    # print("region in playground")
    # print(config.region)
    #
    # client = SearchClientSync.create_with_config(config)
    # client.add_user_agent("playground search with ingestion")
    #
    # print("user_agent", client._config._user_agent.get())
    #
    # try:
    #     resp = client.replace_all_objects_with_transformation(
    #         "boyd", [{"objectID": "bar"},{"objectID": "bar"},{"objectID": "bar"},{"objectID": "bar"},{"objectID": "bar"}], 2
    #     )
    #     print(resp)
    # except Exception as e:
    #     print(e)
    # finally:
    #     client.close()
    #
    #     print("client closed")
