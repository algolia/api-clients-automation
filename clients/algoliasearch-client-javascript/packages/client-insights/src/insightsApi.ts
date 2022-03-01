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

import type { InsightEvents } from '../model/insightEvents';
import type { PushEventsResponse } from '../model/pushEventsResponse';

export const apiClientVersion = '5.0.0';

export type Region = 'de' | 'us';

function getDefaultHosts(region?: Region): Host[] {
  const regionHost = region ? `.${region}.` : '.';

  return [
    {
      url: `insights${regionHost}algolia.io`,
      accept: 'readWrite',
      protocol: 'https',
    },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createInsightsApi(
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
      client: 'Insights',
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
   * This command pushes an array of events.
   *
   * @summary Pushes an array of events.
   * @param insightEvents - The insightEvents object.
   */
  function pushEvents(
    insightEvents: InsightEvents
  ): Promise<PushEventsResponse> {
    const requestPath = '/1/events';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!insightEvents) {
      throw new Error(
        'Parameter `insightEvents` is required when calling `pushEvents`.'
      );
    }

    if (!insightEvents.events) {
      throw new Error(
        'Parameter `insightEvents.events` is required when calling `pushEvents`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: insightEvents,
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
    postCustomRequest,
    pushEvents,
    putCustomRequest,
  };
}

export type InsightsApi = ReturnType<typeof createInsightsApi>;

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
   * URL-encoded query string. Force some query parameters to be applied for each query made with this API key.
   */
  parameters?: string;
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
