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

import type { DeleteUserProfileResponse } from '../model/deleteUserProfileResponse';
import type { GetUserTokenResponse } from '../model/getUserTokenResponse';
import type { PersonalizationStrategyParams } from '../model/personalizationStrategyParams';
import type { SetPersonalizationStrategyResponse } from '../model/setPersonalizationStrategyResponse';

export const apiClientVersion = '5.0.0';

export type Region = 'eu' | 'us';

function getDefaultHosts(region: Region): Host[] {
  return [
    {
      url: `personalization.${region}.algolia.com`,
      accept: 'readWrite',
      protocol: 'https',
    },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createPersonalizationApi(
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
      client: 'Personalization',
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
   * Returns, as part of the response, a date until which the data can safely be considered as deleted for the given user. This means that if you send events for the given user before this date, they will be ignored. Any data received after the deletedUntil date will start building a new user profile. It might take a couple hours before for the deletion request to be fully processed.
   *
   * @summary Delete the user profile and all its associated data.
   * @param deleteUserProfile - The deleteUserProfile object.
   * @param deleteUserProfile.userToken - UserToken representing the user for which to fetch the Personalization profile.
   */
  function deleteUserProfile({
    userToken,
  }: DeleteUserProfileProps): Promise<DeleteUserProfileResponse> {
    const requestPath = '/1/profiles/{userToken}'.replace(
      '{userToken}',
      encodeURIComponent(String(userToken))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!userToken) {
      throw new Error(
        'Parameter `userToken` is required when calling `deleteUserProfile`.'
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
   * The strategy contains information on the events and facets that impact user profiles and personalized search results.
   *
   * @summary Get the current personalization strategy.
   */
  function getPersonalizationStrategy(): Promise<PersonalizationStrategyParams> {
    const requestPath = '/1/strategies/personalization';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

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
   * The profile is structured by facet name used in the strategy. Each facet value is mapped to its score. Each score represents the user affinity for a specific facet value given the userToken past events and the Personalization strategy defined. Scores are bounded to 20. The last processed event timestamp is provided using the ISO 8601 format for debugging purposes.
   *
   * @summary Get the user profile built from Personalization strategy.
   * @param getUserTokenProfile - The getUserTokenProfile object.
   * @param getUserTokenProfile.userToken - UserToken representing the user for which to fetch the Personalization profile.
   */
  function getUserTokenProfile({
    userToken,
  }: GetUserTokenProfileProps): Promise<GetUserTokenResponse> {
    const requestPath = '/1/profiles/personalization/{userToken}'.replace(
      '{userToken}',
      encodeURIComponent(String(userToken))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!userToken) {
      throw new Error(
        'Parameter `userToken` is required when calling `getUserTokenProfile`.'
      );
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
   * A strategy defines the events and facets that impact user profiles and personalized search results.
   *
   * @summary Set a new personalization strategy.
   * @param personalizationStrategyParams - The personalizationStrategyParams object.
   */
  function setPersonalizationStrategy(
    personalizationStrategyParams: PersonalizationStrategyParams
  ): Promise<SetPersonalizationStrategyResponse> {
    const requestPath = '/1/strategies/personalization';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!personalizationStrategyParams) {
      throw new Error(
        'Parameter `personalizationStrategyParams` is required when calling `setPersonalizationStrategy`.'
      );
    }

    if (!personalizationStrategyParams.eventScoring) {
      throw new Error(
        'Parameter `personalizationStrategyParams.eventScoring` is required when calling `setPersonalizationStrategy`.'
      );
    }
    if (!personalizationStrategyParams.facetScoring) {
      throw new Error(
        'Parameter `personalizationStrategyParams.facetScoring` is required when calling `setPersonalizationStrategy`.'
      );
    }
    if (!personalizationStrategyParams.personalizationImpact) {
      throw new Error(
        'Parameter `personalizationStrategyParams.personalizationImpact` is required when calling `setPersonalizationStrategy`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: personalizationStrategyParams,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  return {
    addUserAgent,
    deleteCustomRequest,
    deleteUserProfile,
    getCustomRequest,
    getPersonalizationStrategy,
    getUserTokenProfile,
    postCustomRequest,
    putCustomRequest,
    setPersonalizationStrategy,
  };
}

export type PersonalizationApi = ReturnType<typeof createPersonalizationApi>;

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

export type DeleteUserProfileProps = {
  /**
   * UserToken representing the user for which to fetch the Personalization profile.
   */
  userToken: string;
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

export type GetUserTokenProfileProps = {
  /**
   * UserToken representing the user for which to fetch the Personalization profile.
   */
  userToken: string;
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
