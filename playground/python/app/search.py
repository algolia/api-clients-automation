from algoliasearch.search import __version__
from algoliasearch.search.client import SearchClient


def main():
    print("SearchClient version", __version__)

    client = SearchClient()

    print("client initialized", client)
