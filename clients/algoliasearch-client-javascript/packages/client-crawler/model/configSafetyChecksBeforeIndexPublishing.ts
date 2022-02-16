/**
 * Checks triggered after the Crawler is done, and before the records are pushed to Algolia into the final index.
 */
export type ConfigSafetyChecksBeforeIndexPublishing = {
  /**
   * Defines the limit of records difference between the new and the last crawl as a percentage of total records (inclusive).  _Default_: `10`.  _Minimum_: `0`\\ _Maximum_: `100`.  If the new number of records is less than `last number of records * (1 - maxLostRecordsPercentage / 100)`, the process throws a `SafeReindexingError`, blocking the Crawler until manual restart.
   */
  maxLostRecordsPercentage?: number;
};
