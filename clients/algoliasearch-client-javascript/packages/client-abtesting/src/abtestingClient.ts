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
  QueryParameters,
  Request,
  RequestOptions,
} from '@algolia/client-common';

import type { ABTest } from '../model/aBTest';
import type { ABTestResponse } from '../model/aBTestResponse';
import type { AddABTestsRequest } from '../model/addABTestsRequest';
import type {
  CustomDeleteProps,
  CustomGetProps,
  CustomPostProps,
  CustomPutProps,
  DeleteABTestProps,
  GetABTestProps,
  ListABTestsProps,
  StopABTestProps,
} from '../model/clientMethodProps';
import type { ListABTestsResponse } from '../model/listABTestsResponse';

export const apiClientVersion = '5.0.0-beta.13';

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
     * Creates a new A/B test.
     *
     * Required API Key ACLs:
     * - editSettings.
     *
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
     * @param customDelete - The customDelete object.
     * @param customDelete.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customDelete.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customDelete(
      { path, parameters }: CustomDeleteProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customDelete`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customGet - The customGet object.
     * @param customGet.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customGet.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customGet(
      { path, parameters }: CustomGetProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customGet`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
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
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customPost - The customPost object.
     * @param customPost.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customPost.parameters - Query parameters to apply to the current query.
     * @param customPost.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customPost(
      { path, parameters, body }: CustomPostProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customPost`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
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
     * @param customPut - The customPut object.
     * @param customPut.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customPut.parameters - Query parameters to apply to the current query.
     * @param customPut.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customPut(
      { path, parameters, body }: CustomPutProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customPut`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
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
     * Deletes an A/B test by its ID.
     *
     * Required API Key ACLs:
     * - editSettings.
     *
     * @param deleteABTest - The deleteABTest object.
     * @param deleteABTest.id - Unique A/B test identifier.
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
     * Retrieves the details for an A/B test by its ID.
     *
     * Required API Key ACLs:
     * - analytics.
     *
     * @param getABTest - The getABTest object.
     * @param getABTest.id - Unique A/B test identifier.
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
     * Lists all A/B tests you configured for this application.
     *
     * Required API Key ACLs:
     * - analytics.
     *
     * @param listABTests - The listABTests object.
     * @param listABTests.offset - Position of the first item to return.
     * @param listABTests.limit - Number of items to return.
     * @param listABTests.indexPrefix - Index name prefix. Only A/B tests for indices starting with this string are included in the response.
     * @param listABTests.indexSuffix - Index name suffix. Only A/B tests for indices ending with this string are included in the response.
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
     * Stops an A/B test by its ID.  You can\'t restart stopped A/B tests.
     *
     * Required API Key ACLs:
     * - editSettings.
     *
     * @param stopABTest - The stopABTest object.
     * @param stopABTest.id - Unique A/B test identifier.
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
