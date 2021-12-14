/**
 * OK.
 */
export type InlineObject2 = {
  /**
   * Query to search. The search is a prefix search with typoTolerance. Use empty query to retrieve all users.
   */
  query: string;
  /**
   * Cluster name.
   */
  clusterName?: string;
  /**
   * Specify the page to retrieve.
   */
  page?: number;
  /**
   * Set the number of hits per page.
   */
  hitsPerPage?: number;
};
