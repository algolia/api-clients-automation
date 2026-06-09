from typing import Any, Dict, Iterator, List

from algoliasearch.ingestion.models import WatchResponse
from algoliasearch.search.client import SearchClient, SearchClientSync
from algoliasearch.search.config import SearchConfig, TransformationOptions
from algoliasearch.search.models.batch_request import BatchRequest
from algoliasearch.search.models.batch_response import BatchResponse


def _records(n: int) -> List[Dict[str, Any]]:
    return [{"objectID": str(i), "name": f"record-{i}"} for i in range(n)]


def _as_generator(records: List[Dict[str, Any]]) -> Iterator[Dict[str, Any]]:
    """Yield records one at a time: a generator has no __len__ and is single-pass."""
    for record in records:
        yield record


async def test_chunked_batch_accepts_generator_async() -> None:
    client = SearchClient("test-app-id", "test-api-key")
    captured: List[List[BatchRequest]] = []

    async def spy_batch(index_name, batch_write_params, request_options=None):
        captured.append(list(batch_write_params.requests))
        return BatchResponse(task_id=len(captured), object_ids=[])

    client.batch = spy_batch  # type: ignore[method-assign]

    records = _records(5)
    responses = await client.chunked_batch(
        index_name="cts_manual_iter",
        objects=_as_generator(records),
        batch_size=2,
    )

    # 5 records at batch_size 2 -> three batches of sizes [2, 2, 1], in order.
    assert [len(reqs) for reqs in captured] == [2, 2, 1]
    assert [req.body for batch in captured for req in batch] == records
    assert len(responses) == 3

    await client.close()


def test_chunked_batch_accepts_generator_sync() -> None:
    client = SearchClientSync("test-app-id", "test-api-key")
    captured: List[List[BatchRequest]] = []

    def spy_batch(index_name, batch_write_params, request_options=None):
        captured.append(list(batch_write_params.requests))
        return BatchResponse(task_id=len(captured), object_ids=[])

    client.batch = spy_batch  # type: ignore[method-assign]

    records = _records(5)
    responses = client.chunked_batch(
        index_name="cts_manual_iter",
        objects=_as_generator(records),
        batch_size=2,
    )

    assert [len(reqs) for reqs in captured] == [2, 2, 1]
    assert [req.body for batch in captured for req in batch] == records
    assert len(responses) == 3

    client.close()


async def test_save_objects_accepts_generator() -> None:
    """save_objects must accept a generator, not only a materialized list."""
    client = SearchClient("test-app-id", "test-api-key")
    captured: List[List[BatchRequest]] = []

    async def spy_batch(index_name, batch_write_params, request_options=None):
        captured.append(list(batch_write_params.requests))
        return BatchResponse(task_id=len(captured), object_ids=[])

    client.batch = spy_batch  # type: ignore[method-assign]

    records = _records(3)
    await client.save_objects(
        index_name="cts_manual_iter",
        objects=_as_generator(records),
    )

    assert [req.body for batch in captured for req in batch] == records

    await client.close()
