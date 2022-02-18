import type { Config } from './config';

export type PatchCrawlerRequestBody = {
  /**
   * The name of the Crawler.
   */
  name?: string;
  config?: Config;
};
