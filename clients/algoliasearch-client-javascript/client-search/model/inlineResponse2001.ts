import type { UserId } from './userId';

/**
 * Array of userIDs and clusters.
 */
export type InlineResponse2001 = {
  /**
   * Mapping of cluster names to top users.
   */
  topUsers: Array<{ [key: string]: UserId[] }>;
};
