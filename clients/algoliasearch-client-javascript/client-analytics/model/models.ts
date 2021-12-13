/* eslint-disable no-param-reassign */
import type { RequestOptions } from '../utils/types';

export * from './errorBase';
export * from './getAttributeTopFiltersResponse';
export * from './getAttributeTopFiltersResponseValues';
export * from './getAverageClickPositionResponse';
export * from './getAverageClickPositionResponseDates';
export * from './getClickPositionsResponse';
export * from './getClickPositionsResponsePositions';
export * from './getClickThroughRateResponse';
export * from './getClickThroughRateResponseDates';
export * from './getConversationRateResponse';
export * from './getConversationRateResponseDates';
export * from './getNoClickRateResponse';
export * from './getNoClickRateResponseDates';
export * from './getNoResultTopFiltersResponse';
export * from './getNoResultTopFiltersResponseValues';
export * from './getNoResultTopFiltersResponseValues1';
export * from './getNoResultsRateResponse';
export * from './getNoResultsRateResponseSearches';
export * from './getStatusResponse';

export interface Authentication {
  /**
   * Apply authentication settings to header and query params.
   */
  applyToRequest: (requestOptions: RequestOptions) => Promise<void> | void;
}

export class ApiKeyAuth implements Authentication {
  apiKey: string = '';

  constructor(private location: string, private paramName: string) {}

  applyToRequest(requestOptions: RequestOptions): void {
    if (this.location === 'query') {
      requestOptions.queryParameters[this.paramName] = this.apiKey;
    } else if (
      this.location === 'header' &&
      requestOptions &&
      requestOptions.headers
    ) {
      requestOptions.headers[this.paramName] = this.apiKey;
    } else if (
      this.location === 'cookie' &&
      requestOptions &&
      requestOptions.headers
    ) {
      if (requestOptions.headers.Cookie) {
        requestOptions.headers.Cookie += `; ${
          this.paramName
        }=${encodeURIComponent(this.apiKey)}`;
      } else {
        requestOptions.headers.Cookie = `${this.paramName}=${encodeURIComponent(
          this.apiKey
        )}`;
      }
    }
  }
}
