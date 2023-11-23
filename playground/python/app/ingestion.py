from algoliasearch.ingestion import __version__
from algoliasearch.ingestion.client import IngestionClient


def main():
    print("IngestionClient version", __version__)

    client = IngestionClient()

    print("client initialized", client)
