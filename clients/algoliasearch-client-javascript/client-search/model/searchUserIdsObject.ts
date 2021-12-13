/**
 * Search userID object.
 */
export type SearchUserIdsObject = {
  /**
   * Query to search. The search is a prefix search with typoTolerance. Use empty query to retrieve all users.
   */
  query: string;
  /**
   * Cluster name.
   */
  clusterName?: string;
  /**
   * Page number (zero-based).
   */
  page?: number;
  /**
   * Number of hits per page.
   */
  hitsPerPage?: number;
};
