from os import environ

from algoliasearch.search.client import SearchClientSync
from algoliasearch.search.config import SearchConfig
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
        resp = client.search_synonyms("foo")
        print(resp)
        client.browse_synonyms("foo", lambda _resp: print(_resp))
    finally:
        client.close()

        print("client closed")

    print("with transformations")

    config = SearchConfig(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )

    config.with_transformation("eu")

    print("region in playground")
    print(config.region)

    client = SearchClientSync.create_with_config(config)
    client.add_user_agent("playground search with ingestion")

    print("user_agent", client._config._user_agent.get())

    try:
        resp = client.save_objects_with_transformation(
            "foo", [{"objectID": "bar"}], wait_for_tasks=True
        )
        print(resp)
    finally:
        client.close()

        print("client closed")
