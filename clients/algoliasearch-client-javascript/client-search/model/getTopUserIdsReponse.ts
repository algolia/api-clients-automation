import type { UserId } from './userId';

/**
 * Array of userIDs and clusters.
 */
export type GetTopUserIdsReponse = {
  topUsers?: Array<{ [key: string]: UserId[] }>;
};
