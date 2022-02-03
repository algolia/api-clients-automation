import { shuffle, Transporter, createAuth } from '@algolia/client-common';
import type {
  Headers,
  Host,
  Request,
  CreateClientOptions,
} from '@algolia/client-common';

import type { GetRecommendations } from '../model/getRecommendations';
import type { GetRecommendationsResponse } from '../model/getRecommendationsResponse';

export const version = '5.0.0';

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
export const createRecommendApi = (options: CreateClientOptions) => {
  const auth = createAuth(options.appId, options.apiKey, options.authMode);
  const transporter = new Transporter({
    hosts: options?.hosts ?? getDefaultHosts(options.appId),
    baseHeaders: {
      'content-type': 'application/x-www-form-urlencoded',
    },
    userAgent: options.userAgent,
    timeouts: options.timeouts,
    requester: options.requester,
  });

  /**
   * Returns recommendations for a specific model and objectID.
   *
   * @summary Returns recommendations for a specific model and objectID.
   * @param getRecommendations - The getRecommendations object.
   */
  function getRecommendations(
    getRecommendations: GetRecommendations
  ): Promise<GetRecommendationsResponse> {
    const path = '/1/indexes/*/recommendations';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!getRecommendations) {
      throw new Error(
        'Parameter `getRecommendations` is required when calling `getRecommendations`.'
      );
    }

    if (!getRecommendations.requests) {
      throw new Error(
        'Parameter `getRecommendations.requests` is required when calling `getRecommendations`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: getRecommendations,
    };

    return transporter.request(request, {
      queryParameters,
      headers: {
        ...headers,
        ...auth.headers(),
      },
    });
  }

  return { getRecommendations };
};
