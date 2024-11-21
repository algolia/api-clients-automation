from os import environ

from algoliasearch.search.client import SearchClientSync
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


def main():
    print("SearchClient version", __version__)

    client = SearchClientSync(
        environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY")
    )
    client._config.user_agent.add("playground")

    print("user_agent", client._config.user_agent.get())
    print("client initialized", client)

    try:
        resp = client.delete_by(
            index_name="foo", delete_by_params={"filters": "brand:name"}
        )
        print(resp.to_json())
    finally:
        client.close()

        print("client closed")


main()
