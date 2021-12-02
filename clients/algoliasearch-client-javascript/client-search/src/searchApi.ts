<<<<<<< HEAD
import { shuffle } from '../utils/helpers';
import { Transporter } from '../utils/Transporter';
import { Headers, Host, Request, RequestOptions } from '../utils/types';
import { Requester } from '../utils/requester/Requester';

import { BatchObject } from '../model/batchObject';
import { BatchResponse } from '../model/batchResponse';
import { DeleteIndexResponse } from '../model/deleteIndexResponse';
import { ErrorBase } from '../model/errorBase';
import { IndexSettings } from '../model/indexSettings';
import { ListIndicesObject } from '../model/listIndicesObject';
import { ListIndicesResponse } from '../model/listIndicesResponse';
import { MultipleQueriesObject } from '../model/multipleQueriesObject';
import { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import { OperationIndexObject } from '../model/operationIndexObject';
import { OperationIndexResponse } from '../model/operationIndexResponse';
import { SaveObjectResponse } from '../model/saveObjectResponse';
import { SearchParams } from '../model/searchParams';
import { SearchParamsAsString } from '../model/searchParamsAsString';
import { SearchResponse } from '../model/searchResponse';
import { SetSettingsResponse } from '../model/setSettingsResponse';
=======
import type { BatchObject } from '../model/batchObject';
import type { BatchResponse } from '../model/batchResponse';
import type { IndexSettings } from '../model/indexSettings';
>>>>>>> main
import { ApiKeyAuth } from '../model/models';
import type { MultipleQueriesObject } from '../model/multipleQueriesObject';
import type { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import type { SaveObjectResponse } from '../model/saveObjectResponse';
import type { SearchParams } from '../model/searchParams';
import type { SearchParamsAsString } from '../model/searchParamsAsString';
import type { SearchResponse } from '../model/searchResponse';
import type { SetSettingsResponse } from '../model/setSettingsResponse';
import { Transporter } from '../utils/Transporter';
import { shuffle } from '../utils/helpers';
import type { Requester } from '../utils/requester/Requester';
import type { Headers, Host, Request, RequestOptions } from '../utils/types';

export enum SearchApiKeys {
  apiKey,
  appId,
}

export class SearchApi {
  protected authentications = {
    apiKey: new ApiKeyAuth('header', 'X-Algolia-API-Key'),
    appId: new ApiKeyAuth('header', 'X-Algolia-Application-Id'),
  };

  private transporter: Transporter;

  private sendRequest<TResponse>(
    request: Request,
    requestOptions: RequestOptions
  ): Promise<TResponse> {
    if (this.authentications.apiKey.apiKey) {
      this.authentications.apiKey.applyToRequest(requestOptions);
    }

    if (this.authentications.appId.apiKey) {
      this.authentications.appId.applyToRequest(requestOptions);
    }

    return this.transporter.request(request, requestOptions);
  }

  constructor(
    appId: string,
    apiKey: string,
    options?: { requester?: Requester; hosts?: Host[] }
  ) {
    this.setApiKey(SearchApiKeys.appId, appId);
    this.setApiKey(SearchApiKeys.apiKey, apiKey);
    this.transporter = new Transporter({
      hosts: options?.hosts ?? this.getDefaultHosts(appId),
      baseHeaders: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      userAgent: 'Algolia for Javascript',
      timeouts: {
        connect: 2,
        read: 5,
        write: 30,
      },
      requester: options?.requester,
    });
  }

  getDefaultHosts(appId: string): Host[] {
    return (
      [
        { url: `${appId}-dsn.algolia.net`, accept: 'read', protocol: 'https' },
        { url: `${appId}.algolia.net`, accept: 'write', protocol: 'https' },
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

  setRequest(requester: Requester): void {
    this.transporter.setRequester(requester);
  }

  setHosts(hosts: Host[]): void {
    this.transporter.setHosts(hosts);
  }

  setApiKey(key: SearchApiKeys, value: string): void {
    this.authentications[SearchApiKeys[key]].apiKey = value;
  }

  /**
   * Performs multiple write operations in a single API call.
   *
   * @param indexName  - The index in which to perform the request.
   * @param batchObject - The batchObject.
   */
  batch(indexName: string, batchObject: BatchObject): Promise<BatchResponse> {
    const path = '/1/indexes/{indexName}/batch'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling batch.'
      );
    }

    if (batchObject === null || batchObject === undefined) {
      throw new Error(
        'Required parameter batchObject was null or undefined when calling batch.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: batchObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
<<<<<<< HEAD
   * Delete an existing index.
   * @summary delete index
   * @param indexName The index in which to perform the request
   */
  public async deleteIndex(indexName: string): Promise<DeleteIndexResponse> {
    const path = '/1/indexes/{indexName}'.replace(
      '{' + 'indexName' + '}',
      encodeURIComponent(String(indexName))
    );
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling deleteIndex.'
      );
    }

    const request: Request = {
      method: 'DELETE',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
=======
   * Retrieve settings of a given indexName.
>>>>>>> main
   *
   * @param indexName  - The index in which to perform the request.
   */
  getSettings(indexName: string): Promise<IndexSettings> {
    const path = '/1/indexes/{indexName}/settings'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling getSettings.'
      );
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Get search results for the given requests.
   *
<<<<<<< HEAD
   * @summary List existing indexes
   * @param listIndicesObject
   */
  public async listIndices(listIndicesObject: ListIndicesObject): Promise<ListIndicesResponse> {
    const path = '/1/indexes';
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (listIndicesObject === null || listIndicesObject === undefined) {
      throw new Error(
        'Required parameter listIndicesObject was null or undefined when calling listIndices.'
      );
    }

    const request: Request = {
      method: 'GET',
      path,
      data: listIndicesObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   *
   * @summary Get search results for the given requests.
   * @param multipleQueriesObject
=======
   * @param multipleQueriesObject - The multipleQueriesObject.
>>>>>>> main
   */
  multipleQueries(
    multipleQueriesObject: MultipleQueriesObject
  ): Promise<MultipleQueriesResponse> {
    const path = '/1/indexes/*/queries';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (multipleQueriesObject === null || multipleQueriesObject === undefined) {
      throw new Error(
        'Required parameter multipleQueriesObject was null or undefined when calling multipleQueries.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: multipleQueriesObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
<<<<<<< HEAD
   * Peforms a copy or a move operation on a index
   * @summary Copy/move index
   * @param indexName The index in which to perform the request
   * @param operationIndexObject
   */
  public async operationIndex(
    indexName: string,
    operationIndexObject: OperationIndexObject
  ): Promise<OperationIndexResponse> {
    const path = '/1/indexes/{indexName}/operation'.replace(
      '{' + 'indexName' + '}',
      encodeURIComponent(String(indexName))
    );
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling operationIndex.'
      );
    }

    if (operationIndexObject === null || operationIndexObject === undefined) {
      throw new Error(
        'Required parameter operationIndexObject was null or undefined when calling operationIndex.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: operationIndexObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Add an object to the index, automatically assigning it an object ID
   * @summary Save object
   * @param indexName The index in which to perform the request
   * @param requestBody
=======
   * Add an object to the index, automatically assigning it an object ID.
   *
   * @param indexName  - The index in which to perform the request.
   * @param requestBody  - The Algolia object.
>>>>>>> main
   */
  saveObject(
    indexName: string,
    requestBody: { [key: string]: Record<string, any> }
  ): Promise<SaveObjectResponse> {
    const path = '/1/indexes/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling saveObject.'
      );
    }

    if (requestBody === null || requestBody === undefined) {
      throw new Error(
        'Required parameter requestBody was null or undefined when calling saveObject.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: requestBody,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Get search results.
   *
   * @param indexName  - The index in which to perform the request.
   * @param searchParamsAsStringSearchParams - The searchParamsAsStringSearchParams.
   */
  search(
    indexName: string,
    searchParamsAsStringSearchParams: SearchParams | SearchParamsAsString
  ): Promise<SearchResponse> {
    const path = '/1/indexes/{indexName}/query'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling search.'
      );
    }

    if (
      searchParamsAsStringSearchParams === null ||
      searchParamsAsStringSearchParams === undefined
    ) {
      throw new Error(
        'Required parameter searchParamsAsStringSearchParams was null or undefined when calling search.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: searchParamsAsStringSearchParams,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.
   *
   * @param indexName  - The index in which to perform the request.
   * @param indexSettings - The indexSettings.
   * @param forwardToReplicas  - When true, changes are also propagated to replicas of the given indexName.
   */
  setSettings(
    indexName: string,
    indexSettings: IndexSettings,
    forwardToReplicas?: boolean
  ): Promise<SetSettingsResponse> {
    const path = '/1/indexes/{indexName}/settings'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling setSettings.'
      );
    }

    if (indexSettings === null || indexSettings === undefined) {
      throw new Error(
        'Required parameter indexSettings was null or undefined when calling setSettings.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: indexSettings,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}
