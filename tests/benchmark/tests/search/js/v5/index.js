/* eslint-disable no-process-exit */
/* eslint-disable no-console */
/* eslint-disable import/no-commonjs */
const { algoliasearch } = require('algoliasearch');

(async () => {
  try {
    const appId = process.env.APP_ID;
    const apiKey = process.env.API_KEY;
    const recordsNum = parseInt(process.env.NUM_RECORDS || '1', 10);
    const randomId = (Math.random() + 1).toString(36).substring(7);
    const client = algoliasearch(appId, apiKey);
    const indexName = `bench.search.js.v5.${randomId}`;

    const records = new Array(recordsNum).fill(1);
    const saves = records.map(async (_, i) => {
      const task = await client.saveObject({
        indexName,
        body: { objectID: `${i}--${randomId}` },
      });
      await client.waitForTask({ indexName, taskID: task.taskID });
    });
    await Promise.all(saves);
  } catch (err) {
    console.error(err);
    process.exit(1);
  }

  console.log('✅');
})();
