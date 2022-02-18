import type { UrlsCrawledGroup } from './urlsCrawledGroup';

export type GetCrawlerStatsResponse = {
  /**
   * The total number of crawled URLs.
   */
  count: number;
  data: UrlsCrawledGroup[];
};
