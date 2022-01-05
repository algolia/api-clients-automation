import type { InsightEvent } from './insightEvent';

/**
 * Object containing the events sent to the Insights API.
 */
export type InsightEvents = {
  /**
   * Array of events sent to the Insights API.
   */
  events: InsightEvent[];
};
