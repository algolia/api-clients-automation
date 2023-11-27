from algoliasearch.abtesting import __version__
from algoliasearch.abtesting.client import AbtestingClient


def main():
    print("AbtestingClient version", __version__)

    client = AbtestingClient()

    print("client initialized", client)
