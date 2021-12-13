import type { GetNoClickRateResponseDates } from './getNoClickRateResponseDates';

export type GetNoClickRateResponse = {
  /**
   * The click-through rate.
   */
  rate: number;
  /**
   * The number of click event.
   */
  count: number;
  /**
   * The number of click event.
   */
  noClickCount: number;
  /**
   * A list of click-through rate events with their date.
   */
  dates: GetNoClickRateResponseDates[];
};
