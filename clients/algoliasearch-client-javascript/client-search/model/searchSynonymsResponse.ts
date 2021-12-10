import type { SynonymHit } from './synonymHit';

export type SearchSynonymsResponse = {
  /**
   * List of synonym hits.
   */
  hits?: SynonymHit[];
  /**
   * Number of hits that the search query matched.
   */
  nbHits?: number;
};
