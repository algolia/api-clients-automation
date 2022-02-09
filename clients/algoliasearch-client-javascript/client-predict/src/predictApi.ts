import {
  shuffle,
  Transporter,
  createAuth,
  getUserAgent,
} from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  Request,
} from '@algolia/client-common';

import type { FetchUserProfileResponse } from '../model/fetchUserProfileResponse';
import type { ModelsTypesRequest } from '../model/modelsTypesRequest';

export const version = '0.0.1';

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
export const createPredictApi = (options: CreateClientOptions) => {
  const auth = createAuth(options.appId, options.apiKey, options.authMode);
  const transporter = new Transporter({
    hosts: options?.hosts ?? getDefaultHosts(options.appId),
    baseHeaders: {
      'content-type': 'application/x-www-form-urlencoded',
      ...auth.headers(),
    },
    baseQueryParameters: auth.queryParameters(),
    userAgent: getUserAgent({
      userAgents: options.userAgents,
      client: 'Predict',
      version,
    }),
    timeouts: options.timeouts,
    requester: options.requester,
  });

  /**
   * Get predictions, properties (raw, computed or custom) and segments (computed or custom) for a user profile.
   *
   * @summary Get user profile.
   * @param fetchUserProfile - The fetchUserProfile object.
   * @param fetchUserProfile.userID - User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
   * @param fetchUserProfile.modelsTypesRequest - The modelsTypesRequest object.
   */
  function fetchUserProfile({
    userID,
    modelsTypesRequest,
  }: FetchUserProfileProps): Promise<FetchUserProfileResponse> {
    const path = '/1/users/{userID}/fetch'.replace(
      '{userID}',
      encodeURIComponent(String(userID))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!userID) {
      throw new Error(
        'Parameter `userID` is required when calling `fetchUserProfile`.'
      );
    }

    if (!modelsTypesRequest) {
      throw new Error(
        'Parameter `modelsTypesRequest` is required when calling `fetchUserProfile`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: modelsTypesRequest,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  return { fetchUserProfile };
};

export type PredictApi = ReturnType<typeof createPredictApi>;

export type FetchUserProfileProps = {
  /**
   * User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
   */
  userID: string;
  modelsTypesRequest: ModelsTypesRequest;
};
