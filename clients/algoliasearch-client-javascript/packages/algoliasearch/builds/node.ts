// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import { createHmac } from 'node:crypto';

import type { AbtestingClient, Region as AbtestingRegion } from '@algolia/client-abtesting';
import { abtestingClient } from '@algolia/client-abtesting';
import type { AnalyticsClient, Region as AnalyticsRegion } from '@algolia/client-analytics';
import { analyticsClient } from '@algolia/client-analytics';
import type { ClientOptions } from '@algolia/client-common';
import {
  DEFAULT_CONNECT_TIMEOUT_NODE,
  DEFAULT_READ_TIMEOUT_NODE,
  DEFAULT_WRITE_TIMEOUT_NODE,
  createMemoryCache,
  createNullCache,
  serializeQueryParameters,
} from '@algolia/client-common';
import type { PersonalizationClient, Region as PersonalizationRegion } from '@algolia/client-personalization';
import { personalizationClient } from '@algolia/client-personalization';
import { searchClient, apiClientVersion as searchClientVersion } from '@algolia/client-search';
import type { RecommendClient } from '@algolia/recommend';
import { recommendClient } from '@algolia/recommend';
import { createHttpRequester } from '@algolia/requester-node-http';

import type {
  InitClientOptions,
  InitClientRegion,
  GenerateSecuredApiKeyOptions,
  GetSecuredApiKeyRemainingValidityOptions,
} from './models';

export * from './models';

export const apiClientVersion = searchClientVersion;

/**
 * The client type.
 */
export type Algoliasearch = ReturnType<typeof algoliasearch>;

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function algoliasearch(appId: string, apiKey: string, options?: ClientOptions) {
  if (!appId || typeof appId !== 'string') {
    throw new Error('`appId` is missing.');
  }

  if (!apiKey || typeof apiKey !== 'string') {
    throw new Error('`apiKey` is missing.');
  }

  function initRecommend(initOptions: InitClientOptions = {}): RecommendClient {
    return recommendClient(initOptions.appId || appId, initOptions.apiKey || apiKey, initOptions.options);
  }

  function initAnalytics(initOptions: InitClientOptions & InitClientRegion<AnalyticsRegion> = {}): AnalyticsClient {
    return analyticsClient(
      initOptions.appId || appId,
      initOptions.apiKey || apiKey,
      initOptions.region,
      initOptions.options,
    );
  }

  function initAbtesting(initOptions: InitClientOptions & InitClientRegion<AbtestingRegion> = {}): AbtestingClient {
    return abtestingClient(
      initOptions.appId || appId,
      initOptions.apiKey || apiKey,
      initOptions.region,
      initOptions.options,
    );
  }

  function initPersonalization(
    initOptions: InitClientOptions & Required<InitClientRegion<PersonalizationRegion>>,
  ): PersonalizationClient {
    return personalizationClient(
      initOptions.appId || appId,
      initOptions.apiKey || apiKey,
      initOptions.region,
      initOptions.options,
    );
  }

  return {
    ...searchClient(appId, apiKey, {
      timeouts: {
        connect: DEFAULT_CONNECT_TIMEOUT_NODE,
        read: DEFAULT_READ_TIMEOUT_NODE,
        write: DEFAULT_WRITE_TIMEOUT_NODE,
      },
      requester: createHttpRequester(),
      algoliaAgents: [{ segment: 'Node.js', version: process.versions.node }],
      responsesCache: createNullCache(),
      requestsCache: createNullCache(),
      hostsCache: createMemoryCache(),
      ...options,
    }),
    /**
     * Get the value of the `algoliaAgent`, used by our libraries internally and telemetry system.
     */
    get _ua(): string {
      return this.transporter.algoliaAgent.value;
    },
    initAbtesting,
    initAnalytics,
    initPersonalization,
    initRecommend,
    /**
     * Helper: Generates a secured API key based on the given `parentApiKey` and given `restrictions`.
     *
     * @summary Helper: Generates a secured API key based on the given `parentApiKey` and given `restrictions`.
     * @param generateSecuredApiKey - The `generateSecuredApiKey` object.
     * @param generateSecuredApiKey.parentApiKey - The base API key from which to generate the new secured one.
     * @param generateSecuredApiKey.restrictions - A set of properties defining the restrictions of the secured API key.
     */
    generateSecuredApiKey({ parentApiKey, restrictions = {} }: GenerateSecuredApiKeyOptions): string {
      let mergedRestrictions = restrictions;
      if (restrictions.searchParams) {
        // merge searchParams with the root restrictions
        mergedRestrictions = {
          ...restrictions,
          ...restrictions.searchParams,
        };

        delete mergedRestrictions.searchParams;
      }

      mergedRestrictions = Object.keys(mergedRestrictions)
        .sort()
        .reduce(
          (acc, key) => {
            // eslint-disable-next-line no-param-reassign
            acc[key] = (mergedRestrictions as any)[key];
            return acc;
          },
          {} as Record<string, unknown>,
        );

      const queryParameters = serializeQueryParameters(mergedRestrictions);
      return Buffer.from(
        createHmac('sha256', parentApiKey).update(queryParameters).digest('hex') + queryParameters,
      ).toString('base64');
    },

    /**
     * Helper: Retrieves the remaining validity of the previous generated `securedApiKey`, the `ValidUntil` parameter must have been provided.
     *
     * @summary Helper: Retrieves the remaining validity of the previous generated `secured_api_key`, the `ValidUntil` parameter must have been provided.
     * @param getSecuredApiKeyRemainingValidity - The `getSecuredApiKeyRemainingValidity` object.
     * @param getSecuredApiKeyRemainingValidity.securedApiKey - The secured API key generated with the `generateSecuredApiKey` method.
     */
    getSecuredApiKeyRemainingValidity({ securedApiKey }: GetSecuredApiKeyRemainingValidityOptions): number {
      const decodedString = Buffer.from(securedApiKey, 'base64').toString('ascii');
      const regex = /validUntil=(\d+)/;
      const match = decodedString.match(regex);

      if (match === null) {
        throw new Error('validUntil not found in given secured api key.');
      }

      return parseInt(match[1], 10) - Math.round(new Date().getTime() / 1000);
    },
  };
}
