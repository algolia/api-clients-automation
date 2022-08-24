/* eslint-disable no-process-exit */
/* eslint-disable no-console */
/* eslint-disable import/no-commonjs */
const { algoliasearch } = require('algoliasearch');

(async () => {
  try {
    const appId = process.env.APP_ID;
    const apiKey = process.env.API_KEY;
    const client = algoliasearch(appId, apiKey);

    const indices = await client.listIndices();

    await Promise.all(
      indices.items.map(async ({ name }) => {
        if (!name.includes('bench')) {
          return null;
        }

        return await client.deleteIndex({ indexName: name });
      })
    );
  } catch (err) {
    console.error(err);
    process.exit(1);
  }

  console.log('✅');
})();
