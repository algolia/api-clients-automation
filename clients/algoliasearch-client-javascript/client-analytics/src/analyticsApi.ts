import type { GetAverageClickPositionResponse } from '../model/getAverageClickPositionResponse';
import type { GetClickPositionsResponse } from '../model/getClickPositionsResponse';
import type { GetClickThroughRateResponse } from '../model/getClickThroughRateResponse';
import type { GetConversationRateResponse } from '../model/getConversationRateResponse';
import type { GetStatusResponse } from '../model/getStatusResponse';
import { ApiKeyAuth } from '../model/models';
import { Transporter } from '../utils/Transporter';
import type { Requester } from '../utils/requester/Requester';
import type { Headers, Host, Request, RequestOptions } from '../utils/types';

export enum AnalyticsApiKeys {
  apiKey,
  appId,
}

export class AnalyticsApi {
  protected authentications = {
    apiKey: new ApiKeyAuth('header', 'X-Algolia-API-Key'),
    appId: new ApiKeyAuth('header', 'X-Algolia-Application-Id'),
  };

  private transporter: Transporter;

  private sendRequest<TResponse>(
    request: Request,
    requestOptions: RequestOptions
  ): Promise<TResponse> {
    if (this.authentications.apiKey.apiKey) {
      this.authentications.apiKey.applyToRequest(requestOptions);
    }

    if (this.authentications.appId.apiKey) {
      this.authentications.appId.applyToRequest(requestOptions);
    }

    return this.transporter.request(request, requestOptions);
  }

  constructor(
    appId: string,
    apiKey: string,
    region: 'de' | 'us',
    options?: { requester?: Requester; hosts?: Host[] }
  ) {
    this.setApiKey(AnalyticsApiKeys.appId, appId);
    this.setApiKey(AnalyticsApiKeys.apiKey, apiKey);

    this.transporter = new Transporter({
      hosts: options?.hosts ?? this.getDefaultHosts(region),
      baseHeaders: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      userAgent: 'Algolia for Javascript',
      timeouts: {
        connect: 2,
        read: 5,
        write: 30,
      },
      requester: options?.requester,
    });
  }

  getDefaultHosts(region: 'de' | 'us'): Host[] {
    return [
      {
        url: `analytics.${region}.algolia.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
    ];
  }

  setRequest(requester: Requester): void {
    this.transporter.setRequester(requester);
  }

  setHosts(hosts: Host[]): void {
    this.transporter.setHosts(hosts);
  }

  setApiKey(key: AnalyticsApiKeys, value: string): void {
    this.authentications[AnalyticsApiKeys[key]].apiKey = value;
  }

  /**
   * Returns the average click position. The endpoint returns a value for the complete given time range, as well as a value per day.  An average of null means Algolia didn\'t receive any click events for the queries with the clickAnalytics search parameter set to true. The average is null until Algolia receives at least one click event.
   *
   * @summary Returns the average click position.
   * @param index - The index name to target.
   * @param startDate - The lower bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param endDate - The upper bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param tags - Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded.
   */
  getAverageClickPosition(
    index: string,
    startDate?: Date,
    endDate?: Date,
    tags?: string
  ): Promise<GetAverageClickPositionResponse> {
    const path = '/2/clicks/averageClickPosition';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error(
        'Required parameter index was null or undefined when calling getAverageClickPosition.'
      );
    }

    if (index !== undefined) {
      queryParameters.index = index.toString();
    }

    if (startDate !== undefined) {
      queryParameters.startDate = startDate.toString();
    }

    if (endDate !== undefined) {
      queryParameters.endDate = endDate.toString();
    }

    if (tags !== undefined) {
      queryParameters.tags = tags.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Returns the distribution of clicks per range of positions.  If the groups all have a count of 0, it means Algolia didn\'t receive any click events for the queries with the clickAnalytics search parameter set to true. The count is 0 until Algolia receives at least one click event.
   *
   * @summary Returns the distribution of clicks per range of positions.
   * @param index - The index name to target.
   * @param startDate - The lower bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param endDate - The upper bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param tags - Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded.
   */
  getClickPositions(
    index: string,
    startDate?: Date,
    endDate?: Date,
    tags?: string
  ): Promise<GetClickPositionsResponse> {
    const path = '/2/clicks/positions';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error(
        'Required parameter index was null or undefined when calling getClickPositions.'
      );
    }

    if (index !== undefined) {
      queryParameters.index = index.toString();
    }

    if (startDate !== undefined) {
      queryParameters.startDate = startDate.toString();
    }

    if (endDate !== undefined) {
      queryParameters.endDate = endDate.toString();
    }

    if (tags !== undefined) {
      queryParameters.tags = tags.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Returns a click-through rate (CTR). The endpoint returns a value for the complete given time range, as well as a value per day. It also returns the count of clicks and searches used to compute the rates.  Tracked searches are searches for which the engine returned a queryID, so searches where you\'ve set the clickAnalytics search parameter to true. This is different than the “count” attribute of the response, which includes tracked searches and searches where you didn\'t enable the clickAnalytics search parameter.  If the CTR is null, it means that Algolia didn\'t receive any queries with the clickAnalytics search parameter set to true. If the CTR is 0, it means Algolia didn\'t receive any click events for the queries with the clickAnalytics search parameter set to true.
   *
   * @summary Returns a click-through rate (CTR).
   * @param index - The index name to target.
   * @param startDate - The lower bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param endDate - The upper bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param tags - Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded.
   */
  getClickThroughRate(
    index: string,
    startDate?: Date,
    endDate?: Date,
    tags?: string
  ): Promise<GetClickThroughRateResponse> {
    const path = '/2/clicks/clickThroughRate';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error(
        'Required parameter index was null or undefined when calling getClickThroughRate.'
      );
    }

    if (index !== undefined) {
      queryParameters.index = index.toString();
    }

    if (startDate !== undefined) {
      queryParameters.startDate = startDate.toString();
    }

    if (endDate !== undefined) {
      queryParameters.endDate = endDate.toString();
    }

    if (tags !== undefined) {
      queryParameters.tags = tags.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Returns a conversion rate (CR). The endpoint returns a value for the complete given time range, as well as a value per day. It also returns the count of conversion and searches used to compute the rates.  Tracked searches are searches for which the engine returned a queryID, so searches where you\'ve set the clickAnalytics search parameter to true. This is different than the “count” attribute of the response, which includes tracked searches and searches where you didn\'t enable the clickAnalytics search parameter.  If the CR is null, it means that Algolia didn\'t receive any queries with the clickAnalytics search parameter set to true. If the CR is 0, it means Algolia didn\'t receive any conversion events for the queries with the clickAnalytics search parameter set to true.
   *
   * @summary Returns a conversion rate (CR).
   * @param index - The index name to target.
   * @param startDate - The lower bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param endDate - The upper bound timestamp (a date, a string like “2006-01-02”) of the period to analyze.
   * @param tags - Filter metrics on the provided tags. Each tag must correspond to an analyticsTags set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it should be URL encoded.
   */
  getConversationRate(
    index: string,
    startDate?: Date,
    endDate?: Date,
    tags?: string
  ): Promise<GetConversationRateResponse> {
    const path = '/2/conversions/conversionRate';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error(
        'Required parameter index was null or undefined when calling getConversationRate.'
      );
    }

    if (index !== undefined) {
      queryParameters.index = index.toString();
    }

    if (startDate !== undefined) {
      queryParameters.startDate = startDate.toString();
    }

    if (endDate !== undefined) {
      queryParameters.endDate = endDate.toString();
    }

    if (tags !== undefined) {
      queryParameters.tags = tags.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Returns the latest update time of the analytics API for a given index. If the index has been recently created and/or no search has been performed yet the updated time will be null.
   *
   * @summary Get latest update time of the analytics API.
   * @param index - The index name to target.
   */
  getStatus(index: string): Promise<GetStatusResponse> {
    const path = '/2/status';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error(
        'Required parameter index was null or undefined when calling getStatus.'
      );
    }

    if (index !== undefined) {
      queryParameters.index = index.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}
