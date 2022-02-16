import type { Config } from './config';

export type InlineObject = {
  /**
   * The name of the Crawler.
   */
  name: string;
  config: Config;
};
