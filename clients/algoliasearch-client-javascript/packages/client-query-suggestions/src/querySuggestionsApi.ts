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

import type { LogFile } from '../model/logFile';
import type { QuerySuggestionsIndex } from '../model/querySuggestionsIndex';
import type { QuerySuggestionsIndexParam } from '../model/querySuggestionsIndexParam';
import type { QuerySuggestionsIndexWithIndexParam } from '../model/querySuggestionsIndexWithIndexParam';
import type { Status } from '../model/status';
import type { SucessResponse } from '../model/sucessResponse';

export const apiClientVersion = '5.0.0';

export type Region = 'eu' | 'us';

function getDefaultHosts(region: Region): Host[] {
  return [
    {
      url: `query-suggestions.${region}.algolia.com`,
      accept: 'readWrite',
      protocol: 'https',
    },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createQuerySuggestionsApi(
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
      client: 'QuerySuggestions',
      version: apiClientVersion,
    }),
    timeouts: options.timeouts,
    requester: options.requester,
  });

  function addUserAgent(segment: string, version?: string): void {
    transporter.userAgent.add({ segment, version });
  }

  /**
   * Create a configuration of a Query Suggestions index. There\'s a limit of 100 configurations per application.
   *
   * @summary Create a configuration of a Query Suggestions index.
   * @param querySuggestionsIndexWithIndexParam - The querySuggestionsIndexWithIndexParam object.
   */
  function createConfig(
    querySuggestionsIndexWithIndexParam: QuerySuggestionsIndexWithIndexParam
  ): Promise<SucessResponse> {
    const requestPath = '/1/configs';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!querySuggestionsIndexWithIndexParam) {
      throw new Error(
        'Parameter `querySuggestionsIndexWithIndexParam` is required when calling `createConfig`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path: requestPath,
      data: querySuggestionsIndexWithIndexParam,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Delete a configuration of a Query Suggestion\'s index. By deleting a configuraton, you stop all updates to the underlying query suggestion index. Note that when doing this, the underlying index does not change - existing suggestions remain untouched.
   *
   * @summary Delete a configuration of a Query Suggestion\'s index.
   * @param deleteConfig - The deleteConfig object.
   * @param deleteConfig.indexName - The index in which to perform the request.
   */
  function deleteConfig({
    indexName,
  }: DeleteConfigProps): Promise<SucessResponse> {
    const requestPath = '/1/configs/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!indexName) {
      throw new Error(
        'Parameter `indexName` is required when calling `deleteConfig`.'
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
   * Get all the configurations of Query Suggestions. For each index, you get a block of JSON with a list of its configuration settings.
   *
   * @summary Get all the configurations of Query Suggestions.
   */
  function getAllConfigs(): Promise<QuerySuggestionsIndex[]> {
    const requestPath = '/1/configs';
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
   * Get the configuration of a single Query Suggestions index.
   *
   * @summary Get the configuration of a single Query Suggestions index.
   * @param getConfig - The getConfig object.
   * @param getConfig.indexName - The index in which to perform the request.
   */
  function getConfig({
    indexName,
  }: GetConfigProps): Promise<QuerySuggestionsIndex> {
    const requestPath = '/1/configs/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!indexName) {
      throw new Error(
        'Parameter `indexName` is required when calling `getConfig`.'
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
   * Get the status of a Query Suggestion\'s index. The status includes whether the Query Suggestions index is currently in the process of being built, and the last build time.
   *
   * @summary Get the status of a Query Suggestion\'s index.
   * @param getConfigStatus - The getConfigStatus object.
   * @param getConfigStatus.indexName - The index in which to perform the request.
   */
  function getConfigStatus({
    indexName,
  }: GetConfigStatusProps): Promise<Status> {
    const requestPath = '/1/configs/{indexName}/status'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!indexName) {
      throw new Error(
        'Parameter `indexName` is required when calling `getConfigStatus`.'
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
   * Get the log file of the last build of a single Query Suggestion index.
   *
   * @summary Get the log file of the last build of a single Query Suggestion index.
   * @param getLogFile - The getLogFile object.
   * @param getLogFile.indexName - The index in which to perform the request.
   */
  function getLogFile({ indexName }: GetLogFileProps): Promise<LogFile[]> {
    const requestPath = '/1/logs/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!indexName) {
      throw new Error(
        'Parameter `indexName` is required when calling `getLogFile`.'
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
   * Update the configuration of a Query Suggestions index.
   *
   * @summary Update the configuration of a Query Suggestions index.
   * @param updateConfig - The updateConfig object.
   * @param updateConfig.indexName - The index in which to perform the request.
   * @param updateConfig.querySuggestionsIndexParam - The querySuggestionsIndexParam object.
   */
  function updateConfig({
    indexName,
    querySuggestionsIndexParam,
  }: UpdateConfigProps): Promise<SucessResponse> {
    const requestPath = '/1/configs/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!indexName) {
      throw new Error(
        'Parameter `indexName` is required when calling `updateConfig`.'
      );
    }

    if (!querySuggestionsIndexParam) {
      throw new Error(
        'Parameter `querySuggestionsIndexParam` is required when calling `updateConfig`.'
      );
    }

    if (!querySuggestionsIndexParam.sourceIndices) {
      throw new Error(
        'Parameter `querySuggestionsIndexParam.sourceIndices` is required when calling `updateConfig`.'
      );
    }

    const request: Request = {
      method: 'PUT',
      path: requestPath,
      data: querySuggestionsIndexParam,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  return {
    addUserAgent,
    createConfig,
    deleteConfig,
    deleteCustomRequest,
    getAllConfigs,
    getConfig,
    getConfigStatus,
    getCustomRequest,
    getLogFile,
    postCustomRequest,
    putCustomRequest,
    updateConfig,
  };
}

export type QuerySuggestionsApi = ReturnType<typeof createQuerySuggestionsApi>;

export type DeleteConfigProps = {
  /**
   * The index in which to perform the request.
   */
  indexName: string;
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

export type GetConfigProps = {
  /**
   * The index in which to perform the request.
   */
  indexName: string;
};

export type GetConfigStatusProps = {
  /**
   * The index in which to perform the request.
   */
  indexName: string;
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

export type GetLogFileProps = {
  /**
   * The index in which to perform the request.
   */
  indexName: string;
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

export type UpdateConfigProps = {
  /**
   * The index in which to perform the request.
   */
  indexName: string;
  querySuggestionsIndexParam: QuerySuggestionsIndexParam;
};
