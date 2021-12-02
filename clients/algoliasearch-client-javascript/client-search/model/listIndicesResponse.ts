import type { Index } from './index';

export type ListIndicesResponse = {
  items?: Index[];
  /**
   * Number of pages.
   */
  nbPages?: number;
};
