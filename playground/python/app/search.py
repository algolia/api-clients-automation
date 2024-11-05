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
    print("client initialized", client)

    try:
        resp = client.save_objects("foo", [{"foo": "bar"}])
        print(resp)

        for r in resp:
            client.wait_for_task(index_name="foo", task_id=r.task_id)
    finally:
        client.close()

        print("client closed")


main()
