import type { UserId } from './userId';

/**
 * Array of userIDs and clusters.
 */
export type InlineResponse2001 = {
  topUsers: Array<{ [key: string]: UserId[] }>;
};
