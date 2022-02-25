import {
  createAuth,
  createMemoryCache,
  createTransporter,
  getUserAgent,
  shuffle,
} from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  Request,
} from '@algolia/client-common';

import type { GetRecommendationsParams } from '../model/getRecommendationsParams';
import type { GetRecommendationsResponse } from '../model/getRecommendationsResponse';

export const apiClientVersion = '5.0.0';

function getDefaultHosts(appId: string): Host[] {
  return (
    [
      {
        url: `${appId}-dsn.algolia.net`,
        accept: 'read',
        protocol: 'https',
      },
      {
        url: `${appId}.algolia.net`,
        accept: 'write',
        protocol: 'https',
      },
    ] as Host[]
  ).concat(
    shuffle([
      {
        url: `${appId}-1.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
      {
        url: `${appId}-2.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
      {
        url: `${appId}-3.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
    ])
  );
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createRecommendApi(options: CreateClientOptions) {
  const auth = createAuth(options.appId, options.apiKey, options.authMode);
  const transporter = createTransporter({
    hosts: options?.hosts ?? getDefaultHosts(options.appId),
    hostsCache: createMemoryCache(),
    baseHeaders: {
      'content-type': 'application/x-www-form-urlencoded',
      ...auth.headers(),
    },
    baseQueryParameters: auth.queryParameters(),
    userAgent: getUserAgent({
      userAgents: options.userAgents,
      client: 'Recommend',
      version: apiClientVersion,
    }),
    timeouts: options.timeouts,
    requester: options.requester,
  });

  function addUserAgent(segment: string, version?: string): void {
    transporter.userAgent.add({ segment, version });
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
   * The customRequest method allow you to send requests to the Algolia REST API.
   *
   * @summary Send requests to the Algolia REST API.
   * @param getCustomRequest - The getCustomRequest object.
   * @param getCustomRequest.path - The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param getCustomRequest.body - The parameters to send with the custom request.
   */
  function getCustomRequest({
    path,
    body,
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

    const request: Request = {
      method: 'GET',
      path: requestPath,
      data: body,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Returns recommendations for a specific model and objectID.
   *
   * @summary Returns recommendations for a specific model and objectID.
   * @param getRecommendationsParams - The getRecommendationsParams object.
   */
  function getRecommendations(
    getRecommendationsParams: GetRecommendationsParams
  ): Promise<GetRecommendationsResponse> {
    const requestPath = '/1/indexes/*/recommendations';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!getRecommendationsParams) {
      throw new Error(
        'Parameter `getRecommendationsParams` is required when calling `getRecommendations`.'
      );
    }

    if (!getRecommendationsParams.requests) {
      throw new Error(
        'Parameter `getRecommendationsParams.requests` is required when calling `getRecommendations`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: getRecommendationsParams,
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

  return {
    addUserAgent,
    deleteCustomRequest,
    getCustomRequest,
    getRecommendations,
    postCustomRequest,
    putCustomRequest,
  };
}

export type RecommendApi = ReturnType<typeof createRecommendApi>;

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

export type GetCustomRequestProps = {
  /**
   * The path of the API endpoint to target, anything after the /1 needs to be specified.
   */
  path: string;
  /**
   * The parameters to send with the custom request.
   */
  body?: Record<string, any>;
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
