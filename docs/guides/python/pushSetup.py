import asyncio
import json
from algoliasearch.ingestion.client import IngestionClientSync


async def main():
    # use the region matching your applicationID
    _client = IngestionClientSync(
        "ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION"
    )

    with open("records.json") as f:
        records = json.load(f)

        run = _client.push_task(
            task_id="YOUR_TASK_ID",
            push_task_payload={
                "action": "addObject",
                "records": records,
            },
        )

        # use runID in the Observability debugger
        print(run.run_id)


asyncio.run(main())
