import { algoliasearch } from 'algoliasearch';

const getAllAppIDConfigurations = (): Record<string, string>[] => {
  return [
    /* A list of your MCM AppID/ApiKey pairs */
  ];
};

const playlists: Record<string, any>[] = [
  /* Your records */
];

// Fetch from your own data storage and with your own code
// the list of application IDs and API keys to target each cluster
const configurations = getAllAppIDConfigurations();

// Send the records to each cluster
Object.keys(configurations).forEach(async (appID) => {
  try {
    const client = algoliasearch(appID, configurations[appID]);

    await client.saveObjects({ indexName: 'indexName', objects: playlists });
  } catch (e) {
    console.error(e);
  }
});
