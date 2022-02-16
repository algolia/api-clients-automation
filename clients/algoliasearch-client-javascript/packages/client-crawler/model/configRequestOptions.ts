import type { ConfigRequestOptionsHeaders } from './configRequestOptionsHeaders';

/**
 * Modify all requests behavior.  Cookie Header will be overriden by the cookie fetched in `login`.
 */
export type ConfigRequestOptions = {
  proxy?: string;
  timeout?: number;
  retries?: number;
  headers?: ConfigRequestOptionsHeaders;
};
