// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import {
  createAuth,
  createTransporter,
  getAlgoliaAgent,
} from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  Request,
  RequestOptions,
  QueryParameters,
} from '@algolia/client-common';

import type { ABTest } from '../model/aBTest';
import type { ABTestResponse } from '../model/aBTestResponse';
import type { AddABTestsRequest } from '../model/addABTestsRequest';
import type {
  DelProps,
  DeleteABTestProps,
  GetProps,
  GetABTestProps,
  ListABTestsProps,
  PostProps,
  PutProps,
  StopABTestProps,
} from '../model/clientMethodProps';
import type { ListABTestsResponse } from '../model/listABTestsResponse';

export const apiClientVersion = '5.0.0-alpha.75';

export const REGIONS = ['de', 'us'] as const;
export type Region = (typeof REGIONS)[number];

function getDefaultHosts(region?: Region): Host[] {
  const url = !region
    ? 'analytics.algolia.com'
    : 'analytics.{region}.algolia.com'.replace('{region}', region);

  return [{ url, accept: 'readWrite', protocol: 'https' }];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createAbtestingClient({
  appId: appIdOption,
  apiKey: apiKeyOption,
  authMode,
  algoliaAgents,
  region: regionOption,
  ...options
}: CreateClientOptions & { region?: Region }) {
  const auth = createAuth(appIdOption, apiKeyOption, authMode);
  const transporter = createTransporter({
    hosts: getDefaultHosts(regionOption),
    ...options,
    algoliaAgent: getAlgoliaAgent({
      algoliaAgents,
      client: 'Abtesting',
      version: apiClientVersion,
    }),
    baseHeaders: {
      'content-type': 'text/plain',
      ...auth.headers(),
      ...options.baseHeaders,
    },
    baseQueryParameters: {
      ...auth.queryParameters(),
      ...options.baseQueryParameters,
    },
  });

  return {
    transporter,

    /**
     * The `appId` currently in use.
     */
    appId: appIdOption,

    /**
     * Clears the cache of the transporter for the `requestsCache` and `responsesCache` properties.
     */
    clearCache(): Promise<void> {
      return Promise.all([
        transporter.requestsCache.clear(),
        transporter.responsesCache.clear(),
      ]).then(() => undefined);
    },

    /**
     * Get the value of the `algoliaAgent`, used by our libraries internally and telemetry system.
     */
    get _ua(): string {
      return transporter.algoliaAgent.value;
    },

    /**
     * Adds a `segment` to the `x-algolia-agent` sent with every requests.
     *
     * @param segment - The algolia agent (user-agent) segment to add.
     * @param version - The version of the agent.
     */
    addAlgoliaAgent(segment: string, version?: string): void {
      transporter.algoliaAgent.add({ segment, version });
    },

    /**
     * Creates an A/B test.
     *
     * @summary Create an A/B test.
     * @param addABTestsRequest - The addABTestsRequest object.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    addABTests(
      addABTestsRequest: AddABTestsRequest,
      requestOptions?: RequestOptions
    ): Promise<ABTestResponse> {
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
      if (!addABTestsRequest.variants) {
        throw new Error(
          'Parameter `addABTestsRequest.variants` is required when calling `addABTests`.'
        );
      }
      if (!addABTestsRequest.endAt) {
        throw new Error(
          'Parameter `addABTestsRequest.endAt` is required when calling `addABTests`.'
        );
      }

      const requestPath = '/2/abtests';
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      const request: Request = {
        method: 'POST',
        path: requestPath,
        queryParameters,
        headers,
        data: addABTestsRequest,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @summary Send requests to the Algolia REST API.
     * @param del - The del object.
     * @param del.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param del.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    del(
      { path, parameters }: DelProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error('Parameter `path` is required when calling `del`.');
      }

      const requestPath = '/1{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'DELETE',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * Delete an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     *
     * @summary Delete an A/B test.
     * @param deleteABTest - The deleteABTest object.
     * @param deleteABTest.id - Unique A/B test ID.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    deleteABTest(
      { id }: DeleteABTestProps,
      requestOptions?: RequestOptions
    ): Promise<ABTestResponse> {
      if (!id) {
        throw new Error(
          'Parameter `id` is required when calling `deleteABTest`.'
        );
      }

      const requestPath = '/2/abtests/{id}'.replace(
        '{id}',
        encodeURIComponent(id)
      );
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      const request: Request = {
        method: 'DELETE',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @summary Send requests to the Algolia REST API.
     * @param get - The get object.
     * @param get.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param get.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    get(
      { path, parameters }: GetProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error('Parameter `path` is required when calling `get`.');
      }

      const requestPath = '/1{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * Get specific details for an A/B test. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     *
     * @summary Get A/B test details.
     * @param getABTest - The getABTest object.
     * @param getABTest.id - Unique A/B test ID.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    getABTest(
      { id }: GetABTestProps,
      requestOptions?: RequestOptions
    ): Promise<ABTest> {
      if (!id) {
        throw new Error('Parameter `id` is required when calling `getABTest`.');
      }

      const requestPath = '/2/abtests/{id}'.replace(
        '{id}',
        encodeURIComponent(id)
      );
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * List all A/B tests.
     *
     * @summary List all A/B tests.
     * @param listABTests - The listABTests object.
     * @param listABTests.offset - Position of the starting record. Used for paging. 0 is the first record.
     * @param listABTests.limit - Number of records to return (page size).
     * @param listABTests.indexPrefix - Only return A/B tests for indices starting with this prefix.
     * @param listABTests.indexSuffix - Only return A/B tests for indices ending with this suffix.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    listABTests(
      { offset, limit, indexPrefix, indexSuffix }: ListABTestsProps = {},
      requestOptions: RequestOptions | undefined = undefined
    ): Promise<ListABTestsResponse> {
      const requestPath = '/2/abtests';
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      if (offset !== undefined) {
        queryParameters.offset = offset.toString();
      }

      if (limit !== undefined) {
        queryParameters.limit = limit.toString();
      }

      if (indexPrefix !== undefined) {
        queryParameters.indexPrefix = indexPrefix.toString();
      }

      if (indexSuffix !== undefined) {
        queryParameters.indexSuffix = indexSuffix.toString();
      }

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @summary Send requests to the Algolia REST API.
     * @param post - The post object.
     * @param post.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param post.parameters - Query parameters to apply to the current query.
     * @param post.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    post(
      { path, parameters, body }: PostProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error('Parameter `path` is required when calling `post`.');
      }

      const requestPath = '/1{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'POST',
        path: requestPath,
        queryParameters,
        headers,
        data: body ? body : {},
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @summary Send requests to the Algolia REST API.
     * @param put - The put object.
     * @param put.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param put.parameters - Query parameters to apply to the current query.
     * @param put.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    put(
      { path, parameters, body }: PutProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error('Parameter `path` is required when calling `put`.');
      }

      const requestPath = '/1{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'PUT',
        path: requestPath,
        queryParameters,
        headers,
        data: body ? body : {},
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * If stopped, the test is over and can\'t be restarted. There is now only one index, receiving 100% of all search requests. The data gathered for stopped A/B tests is retained. To determine the `id` for an A/B test, use the [`listABTests` operation](#tag/abtest/operation/listABTests).
     *
     * @summary Stop an A/B test.
     * @param stopABTest - The stopABTest object.
     * @param stopABTest.id - Unique A/B test ID.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    stopABTest(
      { id }: StopABTestProps,
      requestOptions?: RequestOptions
    ): Promise<ABTestResponse> {
      if (!id) {
        throw new Error(
          'Parameter `id` is required when calling `stopABTest`.'
        );
      }

      const requestPath = '/2/abtests/{id}/stop'.replace(
        '{id}',
        encodeURIComponent(id)
      );
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      const request: Request = {
        method: 'POST',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },
  };
}

/**
 * The client type.
 */
export type AbtestingClient = ReturnType<typeof createAbtestingClient>;
