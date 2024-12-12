import type { PushTaskRecords } from 'algoliasearch';
import fs from 'node:fs';

import { algoliasearch } from 'algoliasearch';

// use the region matching your applicationID
const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initIngestion({ region: 'us' });

try {
  // read local JSON file containing array of records
  const records = JSON.parse(fs.readFileSync('records.json', 'utf8')) as PushTaskRecords[];

  // setting `watch` to `true` will make the call synchronous
  const resp = await client.pushTask({
    taskID: 'YOUR_TASK_ID',
    pushTaskPayload: { action: 'addObject', records: records },
    watch: true,
  });

  console.log(resp);
} catch (err) {
  console.error(err);
}
