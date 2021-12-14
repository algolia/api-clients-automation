/* eslint-disable no-param-reassign */
import type { RequestOptions } from '../utils/types';

export * from './assignUserIdResponse';
export * from './baseIndexSettings';
export * from './baseSearchParams';
export * from './baseSearchResponse';
export * from './baseSearchResponseFacetsStats';
export * from './batchObject';
export * from './batchResponse';
export * from './clearAllSynonymsResponse';
export * from './deleteIndexResponse';
export * from './deleteSynonymResponse';
export * from './errorBase';
export * from './highlightResult';
export * from './index';
export * from './indexSettings';
export * from './indexSettingsAsSearchParams';
export * from './inlineObject';
export * from './inlineObject1';
export * from './inlineObject2';
export * from './inlineResponse200';
export * from './inlineResponse2001';
export * from './inlineResponse2002';
export * from './inlineResponse2003';
export * from './inlineResponse2003HighlightResult';
export * from './inlineResponse2003Hits';
export * from './inlineResponse2004';
export * from './listIndicesResponse';
export * from './multipleQueries';
export * from './multipleQueriesObject';
export * from './multipleQueriesResponse';
export * from './operation';
export * from './operationIndexObject';
export * from './operationIndexResponse';
export * from './rankingInfo';
export * from './rankingInfoMatchedGeoLocation';
export * from './record';
export * from './removeUserIdResponse';
export * from './saveObjectResponse';
export * from './saveSynonymResponse';
export * from './saveSynonymsResponse';
export * from './searchHits';
export * from './searchParams';
export * from './searchParamsAsString';
export * from './searchResponse';
export * from './searchSynonymsResponse';
export * from './setSettingsResponse';
export * from './snippetResult';
export * from './synonymHit';
export * from './synonymHitHighlightResult';
export * from './userId';

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
