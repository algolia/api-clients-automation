import type { InlineResponse2003HighlightResult } from './inlineResponse2003HighlightResult';

export type InlineResponse2003Hits = {
  userID?: string;
  /**
   * Name of the cluster.
   */
  clusterName?: string;
  /**
   * Number of records in the cluster.
   */
  nbRecords?: number;
  /**
   * Data size taken by all the users assigned to the cluster.
   */
  dataSize?: number;
  objectID?: string;
  _highlightResult?: InlineResponse2003HighlightResult;
};
