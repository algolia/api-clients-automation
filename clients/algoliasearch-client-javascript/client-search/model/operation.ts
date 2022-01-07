import type { Action } from './action';

export type Operation = {
  action?: Action;
  body?: Record<string, any>;
  /**
   * Index to target for this operation.
   */
  indexName?: string;
};
