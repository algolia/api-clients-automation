import type { URLJobInput } from './uRLJobInput';

/**
 * Object containing a URL job.
 */
export type URLJob = {
  /**
   * The type of the file to ingest.
   */
  type: URLJobType;
  input: URLJobInput;
};

export type URLJobType = 'csv';
