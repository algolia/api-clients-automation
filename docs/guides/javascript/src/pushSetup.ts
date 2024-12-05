import type { PushTaskRecords } from 'algoliasearch';
import fs from 'node:fs';

import { algoliasearch } from 'algoliasearch';

// use the region matching your applicationID
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initIngestion({ region: 'us' });

try {
  // read local JSON file containing array of records
  const records = JSON.parse(fs.readFileSync('records.json', 'utf8')) as PushTaskRecords[];

  // push records to the API
  const run = await client.pushTask({
    taskID: 'YOUR_TASK_ID',
    pushTaskPayload: { action: 'addObject', records: records },
  });

  // use runID in the Observability debugger
  console.log(run.runID);
} catch (err) {
  console.error(err);
}
