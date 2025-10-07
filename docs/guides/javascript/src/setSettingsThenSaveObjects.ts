import { algoliasearch } from 'algoliasearch';

import type { IndexSettings } from 'algoliasearch';

const playlists: Record<string, any>[] = [
  /* Your records */
];

const getAppIDFor = (_: string) => {
  return ''; // Implement your own logic here
};
const getIndexingApiKeyFor = (_: string) => {
  return ''; // Implement your own logic here
};

playlists.forEach(async (playlist) => {
  // Fetch from your own data storage and with your own code
  // the associated application ID and API key for this user
  const appID = getAppIDFor(playlist['user']);
  const apiKey = getIndexingApiKeyFor(playlist['user']);

  try {
    const client = algoliasearch(appID, apiKey);
    const settings: IndexSettings = {
      attributesForFaceting: ['filterOnly(user)'],
    };
    await client.setSettings({ indexName: 'indexName', indexSettings: settings });

    await client.saveObjects({ indexName: 'indexName', objects: playlists });
  } catch (e: any) {
    console.error(e);
  }
});
