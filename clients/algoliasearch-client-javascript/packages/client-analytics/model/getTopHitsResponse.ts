import type { GetTopHitsResponseSimple } from './getTopHitsResponseSimple';
import type { GetTopHitsResponseWithAnalytics } from './getTopHitsResponseWithAnalytics';

export type GetTopHitsResponse =
  | GetTopHitsResponseSimple
  | GetTopHitsResponseWithAnalytics;
