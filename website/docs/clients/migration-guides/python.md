---
title: Python
---

### Usage

To get started, first install the `algoliasearch` client.

```bash
pip install --upgrade 'algoliasearch>=4.0,<5.0'
```

You can continue this guide on [our installation page](/docs/clients/installation).

### Instantiation

In order to instantiate the client, you had to call the `create` method which wasn't really following the principles of the `__init__` method as many of you reported. You can now instantiate any client by calling the class directly:

```py
from algoliasearch.search.client import SearchClient
from algoliasearch.search.config import SearchConfig

# ordered

client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

# named

client = SearchClient(app_id="YOUR_APP_ID", api_key="YOUR_API_KEY")

# custom

client = SearchClient(app_id="YOUR_APP_ID", api_key="YOUR_API_KEY", config=SearchConfig(...))

```

### Methods targeting an `index_name`

Prior to the `init_index` removal stated in the [common breaking changes](/docs/clients/migration-guides/#common-breaking-changes), all methods previously available at the `init_index` level requires the `index_name` to be sent with the query.

```py
from algoliasearch.search.client import SearchClient

client = SearchClient("YOUR_APP_ID", "YOUR_API_KEY")

# using a raw dict

search_resp = await client.search(search_method_params={"requests": [{"indexName": "nvim"}]})

# using the given models

from algoliasearch.search.models.search_method_params import SearchMethodParams
from algoliasearch.search.models.search_for_hits import SearchForHits
from algoliasearch.search.models.search_query import SearchQuery

search_resp = await client.search(
    search_method_params=SearchMethodParams(
        requests=[
            SearchQuery(SearchForHits(index_name="nvim")),
        ],
    ),
)

print(search_resp.to_json())
```
