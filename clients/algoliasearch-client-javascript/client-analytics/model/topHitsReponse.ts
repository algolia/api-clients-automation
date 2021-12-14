import type { TopHitsReponseHits } from './topHitsReponseHits';

export type TopHitsReponse = {
  /**
   * A list of top hits with their count.
   */
  hits: TopHitsReponseHits[];
};
