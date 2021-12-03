import type { SynonymObject } from './synonymObject';

export type SearchSynonymsResponse = {
  /**
   * List of synonym hits.
   */
  hits?: SynonymObject[];
  /**
   * Number of hits that the search query matched.
   */
  nbHits?: number;
};
