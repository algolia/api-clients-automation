from algoliasearch.personalization import __version__
from algoliasearch.personalization.client import PersonalizationClient


def main():
    print("PersonalizationClient version", __version__)

    client = PersonalizationClient()

    print("client initialized", client)
