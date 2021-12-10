import type { HighlightedSynonym } from './highlightedSynonym';

/**
 * Highlighted results.
 */
export type SynonymHitHighlightResult = {
  type?: HighlightedSynonym;
  synonyms?: HighlightedSynonym[];
};
