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

import type { PostIngestUrlResponse } from '../model/postIngestUrlResponse';
import type { PostURLJob } from '../model/postURLJob';

export const apiClientVersion = '0.0.1';

export type Region = 'de' | 'us';

function getDefaultHosts(region: Region): Host[] {
  return [
    {
      url: `data.${region}.algolia.com`,
      accept: 'readWrite',
      protocol: 'https',
    },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createSourcesApi(
  options: CreateClientOptions & { region: Region }
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
      client: 'Sources',
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
   * Add an ingestion job that will fetch data from an URL.
   *
   * @summary Create a new ingestion job via URL.
   * @param postURLJob - The postURLJob object.
   */
  function postIngestUrl(
    postURLJob: PostURLJob
  ): Promise<PostIngestUrlResponse> {
    const requestPath = '/1/ingest/url';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!postURLJob) {
      throw new Error(
        'Parameter `postURLJob` is required when calling `postIngestUrl`.'
      );
    }

    if (!postURLJob.type) {
      throw new Error(
        'Parameter `postURLJob.type` is required when calling `postIngestUrl`.'
      );
    }
    if (!postURLJob.input) {
      throw new Error(
        'Parameter `postURLJob.input` is required when calling `postIngestUrl`.'
      );
    }
    if (!postURLJob.target) {
      throw new Error(
        'Parameter `postURLJob.target` is required when calling `postIngestUrl`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: postURLJob,
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
    postIngestUrl,
    putCustomRequest,
  };
}

export type SourcesApi = ReturnType<typeof createSourcesApi>;

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
