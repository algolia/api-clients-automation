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
    client.add_user_agent("playground")
    client.add_user_agent("bar", "baz")

    print("user_agent", client._config._user_agent.get())
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
