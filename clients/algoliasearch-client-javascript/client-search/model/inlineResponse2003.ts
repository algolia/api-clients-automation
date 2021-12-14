import type { InlineResponse2003Hits } from './inlineResponse2003Hits';

/**
 * UserIDs data.
 */
export type InlineResponse2003 = {
  /**
   * List of user object matching the query.
   */
  hits?: InlineResponse2003Hits[];
  nbHits?: Record<string, any>;
  /**
   * Specify the page to retrieve.
   */
  page?: number;
  /**
   * Set the number of hits per page.
   */
  hitsPerPage?: number;
  /**
   * Date of last update (ISO-8601 format).
   */
  updatedAt?: Date;
};
