import type { Config } from './config';

export type CreateCrawlerRequestBody = {
  /**
   * The name of the Crawler.
   */
  name: string;
  config: Config;
};
