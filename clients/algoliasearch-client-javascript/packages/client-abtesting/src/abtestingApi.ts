import {
  createAuth,
  createMemoryCache,
  createTransporter,
  getUserAgent,
} from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  Request,
} from '@algolia/client-common';

import type { ABTest } from '../model/aBTest';
import type { ABTestResponse } from '../model/aBTestResponse';
import type { AddABTestsRequest } from '../model/addABTestsRequest';
import type { ListABTestsResponse } from '../model/listABTestsResponse';

export const apiClientVersion = '5.0.0';

export type Region = 'de' | 'us';

function getDefaultHosts(region?: Region): Host[] {
  const regionHost = region ? `.${region}.` : '.';

  return [
    {
      url: `analytics${regionHost}algolia.com`,
      accept: 'readWrite',
      protocol: 'https',
    },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createAbtestingApi(
  options: CreateClientOptions & { region?: Region }
) {
  const auth = createAuth(options.appId, options.apiKey, options.authMode);
  const transporter = createTransporter({
    hosts: options?.hosts ?? getDefaultHosts(options.region),
    hostsCache: createMemoryCache(),
    baseHeaders: {
      'content-type': 'application/x-www-form-urlencoded',
      ...auth.headers(),
    },
    baseQueryParameters: auth.queryParameters(),
    userAgent: getUserAgent({
      userAgents: options.userAgents,
      client: 'Abtesting',
      version: apiClientVersion,
    }),
    timeouts: options.timeouts,
    requester: options.requester,
  });

  function addUserAgent(segment: string, version?: string): void {
    transporter.userAgent.add({ segment, version });
  }

  /**
   * Creates a new A/B test with provided configuration. You can set an A/B test on two different indices with different settings, or on the same index with different search parameters by providing a customSearchParameters setting on one of the variants.
   *
   * @summary Creates a new A/B test with provided configuration.
   * @param addABTestsRequest - The addABTestsRequest object.
   */
  function addABTests(
    addABTestsRequest: AddABTestsRequest
  ): Promise<ABTestResponse> {
    const requestPath = '/2/abtests';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!addABTestsRequest) {
      throw new Error(
        'Parameter `addABTestsRequest` is required when calling `addABTests`.'
      );
    }

    if (!addABTestsRequest.name) {
      throw new Error(
        'Parameter `addABTestsRequest.name` is required when calling `addABTests`.'
      );
    }
    if (!addABTestsRequest.variant) {
      throw new Error(
        'Parameter `addABTestsRequest.variant` is required when calling `addABTests`.'
      );
    }
    if (!addABTestsRequest.endAt) {
      throw new Error(
        'Parameter `addABTestsRequest.endAt` is required when calling `addABTests`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: addABTestsRequest,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Deletes the A/B Test and removes all associated metadata & metrics.
   *
   * @summary Deletes the A/B Test.
   * @param deleteABTest - The deleteABTest object.
   * @param deleteABTest.id - The A/B test ID.
   */
  function deleteABTest({ id }: DeleteABTestProps): Promise<ABTestResponse> {
    const requestPath = '/2/abtests/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `deleteABTest`.'
      );
    }

    const request: Request = {
      method: 'DELETE',
      path: requestPath,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * The customRequest method allow you to send requests to the Algolia REST API.
   *
   * @summary Send requests to the Algolia REST API.
   * @param deleteCustomRequest - The deleteCustomRequest object.
   * @param deleteCustomRequest.path - The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param deleteCustomRequest.body - The parameters to send with the custom request.
   */
  function deleteCustomRequest({
    path,
    body,
  }: DeleteCustomRequestProps): Promise<Record<string, any>> {
    const requestPath = '/1{path}'.replace(
      '{path}',
      encodeURIComponent(String(path))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!path) {
      throw new Error(
        'Parameter `path` is required when calling `deleteCustomRequest`.'
      );
    }

    const request: Request = {
      method: 'DELETE',
      path: requestPath,
      data: body,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Returns metadata and metrics for A/B test id. Behaves in the same way as GET /2/abtests however the endpoint will return 403.
   *
   * @summary Returns metadata and metrics for A/B test id.
   * @param getABTest - The getABTest object.
   * @param getABTest.id - The A/B test ID.
   */
  function getABTest({ id }: GetABTestProps): Promise<ABTest> {
    const requestPath = '/2/abtests/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `getABTest`.');
    }

    const request: Request = {
      method: 'GET',
      path: requestPath,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * The getCustomRequest method allow you to send requests to the Algolia REST API.
   *
   * @summary Send GET requests to the Algolia REST API.
   * @param getCustomRequest - The getCustomRequest object.
   * @param getCustomRequest.path - The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param getCustomRequest.parameters - URL-encoded query string. Force some query parameters to be applied for each query made with this API key.
   */
  function getCustomRequest({
    path,
    parameters,
  }: GetCustomRequestProps): Promise<Record<string, any>> {
    const requestPath = '/1{path}'.replace(
      '{path}',
      encodeURIComponent(String(path))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!path) {
      throw new Error(
        'Parameter `path` is required when calling `getCustomRequest`.'
      );
    }

    if (parameters !== undefined) {
      queryParameters.parameters = parameters.toString();
    }

    const request: Request = {
      method: 'GET',
      path: requestPath,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Fetch all existing A/B tests for App that are available for the current API Key. Returns an array of metadata and metrics. When no data has been processed, the metrics will be returned as null.
   *
   * @summary Fetch all existing A/B tests for App that are available for the current API Key.
   * @param listABTests - The listABTests object.
   * @param listABTests.offset - Position of the starting record. Used for paging. 0 is the first record.
   * @param listABTests.limit - Number of records to return. Limit is the size of the page.
   */
  function listABTests({
    offset,
    limit,
  }: ListABTestsProps): Promise<ListABTestsResponse> {
    const requestPath = '/2/abtests';
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
      path: requestPath,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * The customRequest method allow you to send requests to the Algolia REST API.
   *
   * @summary Send requests to the Algolia REST API.
   * @param postCustomRequest - The postCustomRequest object.
   * @param postCustomRequest.path - The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param postCustomRequest.body - The parameters to send with the custom request.
   */
  function postCustomRequest({
    path,
    body,
  }: PostCustomRequestProps): Promise<Record<string, any>> {
    const requestPath = '/1{path}'.replace(
      '{path}',
      encodeURIComponent(String(path))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!path) {
      throw new Error(
        'Parameter `path` is required when calling `postCustomRequest`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: body,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * The customRequest method allow you to send requests to the Algolia REST API.
   *
   * @summary Send requests to the Algolia REST API.
   * @param putCustomRequest - The putCustomRequest object.
   * @param putCustomRequest.path - The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param putCustomRequest.body - The parameters to send with the custom request.
   */
  function putCustomRequest({
    path,
    body,
  }: PutCustomRequestProps): Promise<Record<string, any>> {
    const requestPath = '/1{path}'.replace(
      '{path}',
      encodeURIComponent(String(path))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!path) {
      throw new Error(
        'Parameter `path` is required when calling `putCustomRequest`.'
      );
    }

    const request: Request = {
      method: 'PUT',
      path: requestPath,
      data: body,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Marks the A/B test as stopped. At this point, the test is over and cannot be restarted. As a result, your application is back to normal: index A will perform as usual, receiving 100% of all search requests. Associated metadata and metrics are still stored.
   *
   * @summary Marks the A/B test as stopped.
   * @param stopABTest - The stopABTest object.
   * @param stopABTest.id - The A/B test ID.
   */
  function stopABTest({ id }: StopABTestProps): Promise<ABTestResponse> {
    const requestPath = '/2/abtests/{id}/stop'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `stopABTest`.');
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  return {
    addUserAgent,
    addABTests,
    deleteABTest,
    deleteCustomRequest,
    getABTest,
    getCustomRequest,
    listABTests,
    postCustomRequest,
    putCustomRequest,
    stopABTest,
  };
}

export type AbtestingApi = ReturnType<typeof createAbtestingApi>;

export type DeleteABTestProps = {
  /**
   * The A/B test ID.
   */
  id: number;
};

export type DeleteCustomRequestProps = {
  /**
   * The path of the API endpoint to target, anything after the /1 needs to be specified.
   */
  path: string;
  /**
   * The parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

export type GetABTestProps = {
  /**
   * The A/B test ID.
   */
  id: number;
};

export type GetCustomRequestProps = {
  /**
   * The path of the API endpoint to target, anything after the /1 needs to be specified.
   */
  path: string;
  /**
   * URL-encoded query string. Force some query parameters to be applied for each query made with this API key.
   */
  parameters?: string;
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

export type PostCustomRequestProps = {
  /**
   * The path of the API endpoint to target, anything after the /1 needs to be specified.
   */
  path: string;
  /**
   * The parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

export type PutCustomRequestProps = {
  /**
   * The path of the API endpoint to target, anything after the /1 needs to be specified.
   */
  path: string;
  /**
   * The parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

export type StopABTestProps = {
  /**
   * The A/B test ID.
   */
  id: number;
};
