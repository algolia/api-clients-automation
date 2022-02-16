import type { UrlsCrawledGroup } from './urlsCrawledGroup';

export type InlineResponse2003 = {
  /**
   * The total number of crawled URLs.
   */
  count: number;
  data: UrlsCrawledGroup[];
};
