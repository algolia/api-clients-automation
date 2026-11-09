import sys
from typing import List

import pytest

from algoliasearch.http.helpers import create_iterable, create_iterable_sync

from algoliasearch.search.client import SearchClient, SearchClientSync
from algoliasearch.search.models.browse_response import BrowseResponse


def test_browse_objects_sync_beyond_recursion_limit() -> None:
    client = SearchClientSync("test-app-id", "test-api-key")
    page_count = sys.getrecursionlimit() + 10
    seen: List[BrowseResponse] = []
    calls = 0

    def browse(**kwargs):
        nonlocal calls
        calls += 1
        return BrowseResponse(
            hits=[], cursor=str(calls) if calls < page_count else None
        )

    client.browse = browse  # type: ignore[method-assign]
    try:
        last = client.browse_objects("test-index", aggregator=seen.append)
        assert calls == page_count
        assert [page.cursor for page in seen] == [
            str(i) for i in range(1, page_count)
        ] + [None]
        assert last is seen[-1]
    finally:
        client.close()


async def test_browse_objects_async_beyond_recursion_limit() -> None:
    client = SearchClient("test-app-id", "test-api-key")
    page_count = sys.getrecursionlimit() + 10
    seen: List[BrowseResponse] = []
    calls = 0

    async def browse(**kwargs):
        nonlocal calls
        calls += 1
        return BrowseResponse(
            hits=[], cursor=str(calls) if calls < page_count else None
        )

    client.browse = browse  # type: ignore[method-assign]
    try:
        last = await client.browse_objects("test-index", aggregator=seen.append)
        assert calls == page_count
        assert [page.cursor for page in seen] == [
            str(i) for i in range(1, page_count)
        ] + [None]
        assert last is seen[-1]
    finally:
        await client.close()


@pytest.mark.parametrize("mode", ["sync", "async"])
@pytest.mark.parametrize("outcome", ["success", "default_error", "custom_error"])
async def test_iterable_preserves_callbacks_and_stopping(mode, outcome) -> None:
    seen = []
    previous = []

    def func(prev):
        previous.append(prev)
        return 1 if prev is None else prev + 1

    async def async_func(prev):
        return func(prev)

    kwargs = dict(
        validate=lambda value: value == 3 if outcome == "success" else False,
        aggregator=seen.append,
        timeout=lambda: 0,
        error_validate=lambda value: value >= (3 if outcome == "success" else 2),
        error_message=(lambda value: f"failed at {value}")
        if outcome == "custom_error"
        else None,
    )
    if outcome == "success":
        result = (
            await create_iterable(async_func, **kwargs)
            if mode == "async"
            else create_iterable_sync(func, **kwargs)
        )
        assert result == 3
        assert previous == [None, 1, 2]
        assert seen == [1, 2, 3]
    else:
        message = "failed at 2" if outcome == "custom_error" else "An error occurred"
        with pytest.raises(Exception, match=message):
            if mode == "async":
                await create_iterable(async_func, **kwargs)
            else:
                create_iterable_sync(func, **kwargs)
        assert previous == [None, 1]
        assert seen == [1, 2]
