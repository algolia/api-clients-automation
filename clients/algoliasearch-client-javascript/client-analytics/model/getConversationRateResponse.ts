import type { GetConversationRateResponseDates } from './getConversationRateResponseDates';

export type GetConversationRateResponse = {
  /**
   * The click-through rate.
   */
  rate: number;
  /**
   * The number of tracked search click.
   */
  trackedSearchCount: number;
  /**
   * The number of converted clicks.
   */
  conversionCount: number;
  /**
   * A list of click-through rate events with their date.
   */
  dates: GetConversationRateResponseDates[];
};
