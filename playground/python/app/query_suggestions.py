from algoliasearch.query_suggestions import __version__
from algoliasearch.query_suggestions.client import QuerySuggestionsClient


def main():
    print("QuerySuggestionsClient version", __version__)

    client = QuerySuggestionsClient()

    print("client initialized", client)
