export type Index = {
  /**
   * Name of the index
   */
  name?: string;
  /**
   * Date of the index creation. (ISO-8601 format)
   */
  createdAt?: Date;
  /**
   * Date of the index last update. (ISO-8601 format)
   */
  updatedAt?: Date;
  /**
   * Entries in the index
   */
  entries?: number;
  /**
   * data size of the index
   */
  dataSize?: number;
  /**
   * file size of the index
   */
  fileSize?: number;
  /**
   * Last build time
   */
  lastBuildTimeS?: number;
  /**
   * Number of pending tasks
   */
  numberOfPendingTask?: number;
  /**
   * Pending task ?
   */
  pendingTask?: boolean;
};
