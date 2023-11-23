from algoliasearch.analytics import __version__
from algoliasearch.analytics.client import AnalyticsClient


def main():
    print("AnalyticsClient version", __version__)

    client = AnalyticsClient()

    print("client initialized", client)
