from algoliasearch.recommend import __version__
from algoliasearch.recommend.client import RecommendClient


def main():
    print("RecommendClient version", __version__)

    client = RecommendClient()

    print("client initialized", client)
