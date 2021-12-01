import { Index } from './index';

export type ListIndicesResponse = {
  items?: Array<Index>;
  /**
   * Number of pages
   */
  nbPages?: number;
};
