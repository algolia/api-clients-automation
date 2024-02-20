from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
from algoliasearch.http.helpers import SecuredApiKeyRestrictions
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient(environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"))
    print("client initialized", client)

    try:
        # resp = client.generate_secured_api_key(parent_api_key="foo", restrictions={
        #     "search_params": {"query": "foo"},
        #     "valid_until": 100,
        #     "restrict_indices": ["bar"],
        #     "restrict_sources": "baz",
        #     "user_token": "foobarbaz",
        # })

        resp = client.generate_secured_api_key(parent_api_key="foo", restrictions=SecuredApiKeyRestrictions(
              search_params={"query": "foo"},
              valid_until=100,
              restrict_indices=["bar"],
              restrict_sources="baz",
              user_token="foobarbaz",
          ))

        print(resp)

        validity = client.get_secured_api_key_remaining_validity(resp)

        print(validity)
    finally:
        await client.close()

        print("client closed")


run(main())
