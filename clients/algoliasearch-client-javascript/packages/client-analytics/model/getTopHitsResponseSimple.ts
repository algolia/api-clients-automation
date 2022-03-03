import type { GetTopHitsResponseSimpleHits } from './getTopHitsResponseSimpleHits';

export type GetTopHitsResponseSimple = {
  /**
   * A list of top hits with their count.
   */
  hits: GetTopHitsResponseSimpleHits[];
};
