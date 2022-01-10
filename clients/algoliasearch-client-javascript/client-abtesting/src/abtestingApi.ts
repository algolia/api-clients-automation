import type { ABTest } from '../model/aBTest';
import type { AddABTestsRequest } from '../model/addABTestsRequest';
import type { AddABTestsResponse } from '../model/addABTestsResponse';
import type { ListABTestsResponse } from '../model/listABTestsResponse';
import { ApiKeyAuth } from '../model/models';
import type { StopABTestRequest } from '../model/stopABTestRequest';
import { Transporter } from '../utils/Transporter';
import type { Requester } from '../utils/requester/Requester';
import type { Headers, Host, Request, RequestOptions } from '../utils/types';

export enum AbtestingApiKeys {
  apiKey,
  appId,
}

export class AbtestingApi {
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
    this.setApiKey(AbtestingApiKeys.appId, appId);
    this.setApiKey(AbtestingApiKeys.apiKey, apiKey);

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

  setApiKey(key: AbtestingApiKeys, value: string): void {
    this.authentications[AbtestingApiKeys[key]].apiKey = value;
  }

  /**
   * Creates a new A/B test with provided configuration. You can set an A/B test on two different indices with different settings, or on the same index with different search parameters by providing a customSearchParameters setting on one of the variants.
   *
   * @summary Creates a new A/B test with provided configuration.
   * @param addABTests - The addABTests parameters.
   * @param addABTests.addABTestsRequest - The addABTestsRequest.
   */
  addABTests({
    addABTestsRequest,
  }: AddABTestsProps): Promise<AddABTestsResponse> {
    const path = '/2/abtests';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (addABTestsRequest === null || addABTestsRequest === undefined) {
      throw new Error(
        'Required parameter addABTestsRequest was null or undefined when calling addABTests.'
      );
    }

    if (
      addABTestsRequest.name === null ||
      addABTestsRequest.name === undefined
    ) {
      throw new Error(
        'Required parameter addABTestsRequest.name was null or undefined when calling addABTests.'
      );
    }
    if (
      addABTestsRequest.variant === null ||
      addABTestsRequest.variant === undefined
    ) {
      throw new Error(
        'Required parameter addABTestsRequest.variant was null or undefined when calling addABTests.'
      );
    }
    if (
      addABTestsRequest.endAt === null ||
      addABTestsRequest.endAt === undefined
    ) {
      throw new Error(
        'Required parameter addABTestsRequest.endAt was null or undefined when calling addABTests.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: addABTestsRequest,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Deletes the A/B Test and removes all associated metadata & metrics.
   *
   * @summary Deletes the A/B Test.
   * @param deleteABTest - The deleteABTest parameters.
   * @param deleteABTest.id - The A/B test ID.
   */
  deleteABTest({ id }: DeleteABTestProps): Promise<Record<string, any>> {
    const path = '/2/abtests/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (id === null || id === undefined) {
      throw new Error(
        'Required parameter id was null or undefined when calling deleteABTest.'
      );
    }

    const request: Request = {
      method: 'DELETE',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Returns metadata and metrics for A/B test id. Behaves in the same way as GET /2/abtests however the endpoint will return 403.
   *
   * @summary Returns metadata and metrics for A/B test id.
   * @param getABTest - The getABTest parameters.
   * @param getABTest.id - The A/B test ID.
   */
  getABTest({ id }: GetABTestProps): Promise<ABTest> {
    const path = '/2/abtests/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (id === null || id === undefined) {
      throw new Error(
        'Required parameter id was null or undefined when calling getABTest.'
      );
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
   * Fetch all existing A/B tests for App that are available for the current API Key. Returns an array of metadata and metrics. When no data has been processed, the metrics will be returned as null.
   *
   * @summary Fetch all existing A/B tests for App that are available for the current API Key.
   * @param listABTests - The listABTests parameters.
   * @param listABTests.offset - Position of the starting record. Used for paging. 0 is the first record.
   * @param listABTests.limit - Number of records to return. Limit is the size of the page.
   */
  listABTests({
    offset,
    limit,
  }: ListABTestsProps): Promise<ListABTestsResponse> {
    const path = '/2/abtests';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (offset !== undefined) {
      queryParameters.offset = offset.toString();
    }

    if (limit !== undefined) {
      queryParameters.limit = limit.toString();
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
   * Marks the A/B test as stopped. At this point, the test is over and cannot be restarted. As a result, your application is back to normal: index A will perform as usual, receiving 100% of all search requests. Associated metadata and metrics are still stored.
   *
   * @summary Marks the A/B test as stopped.
   * @param stopABTest - The stopABTest parameters.
   * @param stopABTest.stopABTestRequest - The stopABTestRequest.
   */
  stopABTest({
    stopABTestRequest,
  }: StopABTestProps): Promise<Record<string, any>> {
    const path = '/2/abtests/{id}/stop';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (stopABTestRequest === null || stopABTestRequest === undefined) {
      throw new Error(
        'Required parameter stopABTestRequest was null or undefined when calling stopABTest.'
      );
    }

    if (stopABTestRequest.id === null || stopABTestRequest.id === undefined) {
      throw new Error(
        'Required parameter stopABTestRequest.id was null or undefined when calling stopABTest.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: stopABTestRequest,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}

export type AddABTestsProps = {
  /**
   * The addABTestsRequest.
   */
  addABTestsRequest: AddABTestsRequest;
};

export type DeleteABTestProps = {
  /**
   * The A/B test ID.
   */
  id: number;
};

export type GetABTestProps = {
  /**
   * The A/B test ID.
   */
  id: number;
};

export type ListABTestsProps = {
  /**
   * Position of the starting record. Used for paging. 0 is the first record.
   */
  offset?: number;
  /**
   * Number of records to return. Limit is the size of the page.
   */
  limit?: number;
};

export type StopABTestProps = {
  /**
   * The stopABTestRequest.
   */
  stopABTestRequest: StopABTestRequest;
};
