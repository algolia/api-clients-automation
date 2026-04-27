from algoliasearch.search.client import SearchClient, SearchClientSync
from algoliasearch.search.config import SearchConfig, TransformationOptions


async def test_async_close_closes_ingestion_transporter() -> None:
    """SearchClient.close() closes the ingestion transporter when one exists."""
    config = SearchConfig(
        "test-app-id",
        "test-api-key",
        transformation_options=TransformationOptions(region="us"),
    )
    client = SearchClient.create_with_config(config)

    ingestion = client._ingestion_transporter
    assert ingestion is not None

    calls = 0
    original_close = ingestion.close

    async def spy_close() -> None:
        nonlocal calls
        calls += 1
        await original_close()

    ingestion.close = spy_close  # type: ignore[method-assign]

    await client.close()

    assert calls == 1


def test_sync_close_closes_ingestion_transporter() -> None:
    """SearchClientSync.close() closes the ingestion transporter when one exists."""
    config = SearchConfig(
        "test-app-id",
        "test-api-key",
        transformation_options=TransformationOptions(region="us"),
    )
    client = SearchClientSync.create_with_config(config)

    ingestion = client._ingestion_transporter
    assert ingestion is not None

    calls = 0
    original_close = ingestion.close

    def spy_close() -> None:
        nonlocal calls
        calls += 1
        original_close()

    ingestion.close = spy_close  # type: ignore[method-assign]

    client.close()

    assert calls == 1


async def test_async_close_without_transformation_options_is_noop() -> None:
    """SearchClient.close() does not crash when no ingestion transporter exists."""
    config = SearchConfig("test-app-id", "test-api-key")
    client = SearchClient.create_with_config(config)

    assert client._ingestion_transporter is None

    await client.close()


async def test_async_set_transformation_options_closes_previous() -> None:
    """set_transformation_options replaces the ingestion transporter and closes the previous one."""
    config = SearchConfig(
        "test-app-id",
        "test-api-key",
        transformation_options=TransformationOptions(region="us"),
    )
    client = SearchClient.create_with_config(config)

    previous = client._ingestion_transporter
    assert previous is not None

    calls = 0
    original_close = previous.close

    async def spy_close() -> None:
        nonlocal calls
        calls += 1
        await original_close()

    previous.close = spy_close  # type: ignore[method-assign]

    await client.set_transformation_options(TransformationOptions(region="eu"))

    assert client._ingestion_transporter is not previous
    assert client._ingestion_transporter is not None
    assert client._ingestion_transporter._config.region == "eu"
    assert calls == 1

    await client.close()


def test_sync_set_transformation_options_closes_previous() -> None:
    """SearchClientSync.set_transformation_options replaces and closes the previous ingestion transporter."""
    config = SearchConfig(
        "test-app-id",
        "test-api-key",
        transformation_options=TransformationOptions(region="us"),
    )
    client = SearchClientSync.create_with_config(config)

    previous = client._ingestion_transporter
    assert previous is not None

    calls = 0
    original_close = previous.close

    def spy_close() -> None:
        nonlocal calls
        calls += 1
        original_close()

    previous.close = spy_close  # type: ignore[method-assign]

    client.set_transformation_options(TransformationOptions(region="eu"))

    assert client._ingestion_transporter is not previous
    assert client._ingestion_transporter is not None
    assert client._ingestion_transporter._config.region == "eu"
    assert calls == 1

    client.close()


async def test_async_set_transformation_options_on_client_without_previous() -> None:
    """set_transformation_options works when no previous ingestion transporter existed."""
    config = SearchConfig("test-app-id", "test-api-key")
    client = SearchClient.create_with_config(config)

    assert client._ingestion_transporter is None

    await client.set_transformation_options(TransformationOptions(region="us"))

    assert client._ingestion_transporter is not None
    assert client._ingestion_transporter._config.region == "us"

    await client.close()
