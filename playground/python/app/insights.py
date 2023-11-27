from algoliasearch.insights import __version__
from algoliasearch.insights.client import InsightsClient


def main():
    print("InsightsClient version", __version__)

    client = InsightsClient()

    print("client initialized", client)
