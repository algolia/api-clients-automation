import type { ConfigSafetyChecksBeforeIndexPublishing } from './configSafetyChecksBeforeIndexPublishing';

/**
 * A configurable collection of safety checks to make sure the crawl was successful.  This configuration describes all the checks the Crawler can perform to ensure data is correct. For example, the number of records from one crawl to another.
 */
export type ConfigSafetyChecks = {
  beforeIndexPublishing?: ConfigSafetyChecksBeforeIndexPublishing;
};
