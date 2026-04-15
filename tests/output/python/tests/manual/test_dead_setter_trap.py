"""Tests for the dead setter trap: calling set_transformation_options or
set_transformation_region after client construction should create the ingestion
transporter lazily, not leave it as None."""

from algoliasearch.search.client import SearchClientSync
from algoliasearch.search.config import SearchConfig, TransformationOptions


def test_set_transformation_options_post_construction():
    """set_transformation_options called after create_with_config should work."""
    config = SearchConfig("test-app-id", "test-api-key")
    client = SearchClientSync.create_with_config(config=config)

    assert client._ingestion_transporter is None

    config.set_transformation_options(TransformationOptions(region="us"))

    try:
        client.save_objects_with_transformation(
            index_name="test",
            objects=[{"objectID": "1"}],
        )
    except ValueError as e:
        if "transformation_options" in str(e):
            raise AssertionError(
                "Dead setter trap: set_transformation_options was called "
                "post-construction but the ingestion transporter was not created"
            ) from e
        raise
    except Exception:
        # Network error is expected — it means the transporter was created
        pass


def test_set_transformation_region_post_construction():
    """Deprecated set_transformation_region called after create_with_config should work."""
    config = SearchConfig("test-app-id", "test-api-key")
    client = SearchClientSync.create_with_config(config=config)

    assert client._ingestion_transporter is None

    config.set_transformation_region("us")

    try:
        client.save_objects_with_transformation(
            index_name="test",
            objects=[{"objectID": "1"}],
        )
    except ValueError as e:
        if "transformation_options" in str(e):
            raise AssertionError(
                "Dead setter trap: set_transformation_region was called "
                "post-construction but the ingestion transporter was not created"
            ) from e
        raise
    except Exception:
        pass
