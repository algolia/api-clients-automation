import type { InlineResponse2003HighlightResult } from './inlineResponse2003HighlightResult';

export type InlineResponse2003Hits = {
  userID?: string;
  /**
   * Cluster name.
   */
  clusterName?: string;
  nbRecords?: number;
  dataSize?: number;
  objectID?: string;
  _highlightResult?: InlineResponse2003HighlightResult;
};
