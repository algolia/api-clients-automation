/**
 * Single source of truth for the per-worktree port block.
 *
 * The ports form one contiguous range: the JVM debug port leads, followed by
 * every CTS test server. A worktree "slot" offsets the whole block by
 * `slot * PORTS_PER_SLOT`, so adjacent slots never overlap.
 *
 * Consumers (nothing hardcodes the count):
 * - `scripts/docker/slot.sh` parses this file for the entry count and the debug port.
 * - `setup.sh` writes the offset (`slot * count`) to `.env.docker` as `CTS_PORT_OFFSET`,
 *   which the host test servers, the manual integration tests, and the Java generator read.
 *
 * Keep the list contiguous and append new servers at the end.
 */
export const SERVER_PORTS = {
  // JVM remote-debug port (host side). Kept first so CTS servers can be
  // appended without shifting it. See scripts/common.ts and docker-compose.yml.
  debug: 6670,
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
  noContent: 6692,
  chunkedPushWait: 6693,
} as const;

export const DEBUG_PORT = SERVER_PORTS.debug;
export const BASE_PORT = Math.min(...Object.values(SERVER_PORTS));
export const PORTS_PER_SLOT = Object.keys(SERVER_PORTS).length;
