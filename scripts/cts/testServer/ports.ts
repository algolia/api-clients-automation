/**
 * Centralized port registry for CTS test servers.
 *
 * Every test server's base port lives here. PORTS_PER_SLOT is derived from
 * the map length — adding a new server only requires one new entry.
 *
 * SYNC: scripts/docker/slot.sh and generators TestsClient.java each carry
 *       their own PORTS_PER_SLOT constant that must match. A CI check
 *       validates they stay in sync.
 */
export const SERVER_PORTS = {
  error: 6671,
  errorRetriedOnce: 6672,
  errorRetriedTwice: 6673,
  neverCalled: 6674,
  success: 6675,
  timeout: 6676,
  timeoutBis: 6677,
  gzip: 6678,
  replaceAllObjects: 6679,
  chunkWrapper: 6680,
  waitFor: 6681,
  benchmark: 6682,
  apiKey: 6683,
  replaceAllObjectsFailed: 6684,
  replaceAllObjectsScopes: 6685,
  algoliaMock: 6686,
  accountCopyIndex: 6687,
  pushMock: 6688,
  pushMockRetriedOnce: 6689,
  replaceAllObjectsWithTransformation: 6690,
  gzipResponse: 6691,
} as const;

export const BASE_PORT = SERVER_PORTS.error;
export const PORTS_PER_SLOT = Object.keys(SERVER_PORTS).length;
