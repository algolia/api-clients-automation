/* eslint-disable no-process-exit */
/* eslint-disable no-console */
/* eslint-disable import/no-commonjs */
const algoliasearch = require('algoliasearch');

(async () => {
  try {
    const appId = process.env.APP_ID;
    const apiKey = process.env.API_KEY;
    const randomId = (Math.random() + 1).toString(36).substring(7);
    const client = algoliasearch(appId, apiKey);
    const index = client.initIndex(`bench.search.js.v4.${randomId}`);

    await index
      .saveObject({
        objectID: randomId,
      })
      .wait();
  } catch (err) {
    console.error(err);
    process.exit(1);
  }

  console.log('✅');
})();
