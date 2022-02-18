import type { Config } from './config';

export type PatchCrawlerResponse = {
  /**
   * The name of the Crawler.
   */
  name?: string;
  config?: Config;
};
