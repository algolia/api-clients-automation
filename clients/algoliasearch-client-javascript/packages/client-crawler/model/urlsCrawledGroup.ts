/**
 * Represent a group of URLs that have been crawled and have the same final state.
 */
export type UrlsCrawledGroup = {
  /**
   * A string corresponding to the status of the group.
   */
  status?: UrlsCrawledGroupStatus;
  /**
   * The code of the reason why when ended up in this status.
   */
  reason?: string;
  /**
   * In case of error, will be set to the step where the error occurred, otherwise will be set to \'success\'.
   */
  category?: UrlsCrawledGroupCategory;
  /**
   * Number of URLs belonging to this group.
   */
  count?: number;
  /**
   * Human redeable version of the error.
   */
  readable?: string;
};

export type UrlsCrawledGroupStatus = 'DONE' | 'FAILED' | 'SKIPPED';

export type UrlsCrawledGroupCategory =
  | 'extraction'
  | 'fetch'
  | 'indexing'
  | 'success';
