import type { Config } from './config';

export type GetCrawlerResponse = {
  /**
   * The name of the Crawler.
   */
  name: string;
  /**
   * The creation date of this Crawler.
   */
  createdAt: string;
  /**
   * The date this Crawler was last updated.
   */
  updatedAt: string;
  /**
   * Indicate if this Crawler is running, i.e. Will crawl regularly based on its configuration.
   */
  running: boolean;
  /**
   * Indicate if this Crawler is currently doing a complete reindex.
   */
  reindexing: boolean;
  /**
   * Indicate if this Crawler is currently blocked and need a manual intervention in the Console.
   */
  blocked: boolean;
  /**
   * The reason for which the Crawler has been blocked.
   */
  blockingError?: string;
  /**
   * The ID of the task that is currently blocking the Crawler.
   */
  blockingTaskId?: string;
  /**
   * The date when the last complete reindex was started. Will be null if no reindex was ever done.
   */
  lastReindexStartedAt: string | null;
  /**
   * The date when the last complete reindex finished. Can be null if the reindex is still running.
   */
  lastReindexEndedAt: string | null;
  config?: Config;
};
