import type { GetTopSearchesResponseSimple } from './getTopSearchesResponseSimple';
import type { GetTopSearchesResponseWithAnalytics } from './getTopSearchesResponseWithAnalytics';

export type GetTopSearchesResponse =
  | GetTopSearchesResponseSimple
  | GetTopSearchesResponseWithAnalytics;
