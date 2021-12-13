import type { AssignUserIdObject } from '../model/assignUserIdObject';
import type { AssignUserIdResponse } from '../model/assignUserIdResponse';
import type { BatchObject } from '../model/batchObject';
import type { BatchResponse } from '../model/batchResponse';
import type { DeleteIndexResponse } from '../model/deleteIndexResponse';
import type { GetTopUserIdsReponse } from '../model/getTopUserIdsReponse';
import type { IndexSettings } from '../model/indexSettings';
import type { InlineResponse200 } from '../model/inlineResponse200';
import type { ListClustersReponse } from '../model/listClustersReponse';
import type { ListIndicesResponse } from '../model/listIndicesResponse';
import type { ListUserIdsResponse } from '../model/listUserIdsResponse';
import { ApiKeyAuth } from '../model/models';
import type { MultipleQueriesObject } from '../model/multipleQueriesObject';
import type { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import type { OperationIndexObject } from '../model/operationIndexObject';
import type { OperationIndexResponse } from '../model/operationIndexResponse';
import type { RemoveUserIdResponse } from '../model/removeUserIdResponse';
import type { SaveObjectResponse } from '../model/saveObjectResponse';
import type { SearchParams } from '../model/searchParams';
import type { SearchParamsAsString } from '../model/searchParamsAsString';
import type { SearchResponse } from '../model/searchResponse';
import type { SearchUserIdsObject } from '../model/searchUserIdsObject';
import type { SetSettingsResponse } from '../model/setSettingsResponse';
import type { UserId } from '../model/userId';
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
   * Assign or Move a userID to a cluster.
   *
   * @summary Assign or Move a userID to a cluster.
   * @param xAlgoliaUserID - UserID to assign.
   * @param assignUserIdObject - The assignUserIdObject.
   */
  assignUserId(
    xAlgoliaUserID: Record<string, any>,
    assignUserIdObject: AssignUserIdObject
  ): Promise<AssignUserIdResponse> {
    const path = '/1/clusters/mapping';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (xAlgoliaUserID === null || xAlgoliaUserID === undefined) {
      throw new Error(
        'Required parameter xAlgoliaUserID was null or undefined when calling assignUserId.'
      );
    }

    if (assignUserIdObject === null || assignUserIdObject === undefined) {
      throw new Error(
        'Required parameter assignUserIdObject was null or undefined when calling assignUserId.'
      );
    }

    if (xAlgoliaUserID !== undefined) {
      queryParameters['X-Algolia-User-ID'] = xAlgoliaUserID.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
      data: assignUserIdObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Performs multiple write operations in a single API call.
   *
   * @param indexName - The index in which to perform the request.
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
   * Assign multiple userIDs to a cluster.
   *
   * @summary Assign multiple userIDs to a cluster.
   * @param xAlgoliaUserID - UserID to assign.
   * @param assignUserIdObject - The assignUserIdObject.
   */
  batchAssignUserIds(
    xAlgoliaUserID: Record<string, any>,
    assignUserIdObject: AssignUserIdObject
  ): Promise<AssignUserIdResponse> {
    const path = '/1/clusters/mapping/batch';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (xAlgoliaUserID === null || xAlgoliaUserID === undefined) {
      throw new Error(
        'Required parameter xAlgoliaUserID was null or undefined when calling batchAssignUserIds.'
      );
    }

    if (assignUserIdObject === null || assignUserIdObject === undefined) {
      throw new Error(
        'Required parameter assignUserIdObject was null or undefined when calling batchAssignUserIds.'
      );
    }

    if (xAlgoliaUserID !== undefined) {
      queryParameters['X-Algolia-User-ID'] = xAlgoliaUserID.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
      data: assignUserIdObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Delete an existing index.
   *
   * @summary Delete index.
   * @param indexName - The index in which to perform the request.
   */
  deleteIndex(indexName: string): Promise<DeleteIndexResponse> {
    const path = '/1/indexes/{indexName}'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

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
   * Retrieve settings of a given indexName.
   *
   * @param indexName - The index in which to perform the request.
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
   * Get the top 10 userIDs with the highest number of records per cluster.
   *
   * @summary Get the top 10 userIDs with the highest number of records per cluster.
   */
  getTopUserIds(): Promise<GetTopUserIdsReponse> {
    const path = '/1/clusters/mapping/top';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

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
   * Returns the userID data stored in the mapping.
   *
   * @summary Returns the userID data stored in the mapping.
   * @param userID - UserID to assign.
   */
  getUserId(userID: Record<string, any>): Promise<UserId> {
    const path = '/1/clusters/mapping/{userID}'.replace(
      '{userID}',
      encodeURIComponent(String(userID))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (userID === null || userID === undefined) {
      throw new Error(
        'Required parameter userID was null or undefined when calling getUserId.'
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
   * Get the status of your clusters’ migrations or user creations.
   *
   * @summary Get the status of your clusters’ migrations or user creations.
   * @param getClusters - The getClusters.
   */
  hasPendingMappins(getClusters?: boolean): Promise<InlineResponse200> {
    const path = '/1/clusters/mapping/pending';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (getClusters !== undefined) {
      queryParameters.getClusters = getClusters.toString();
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
   * List the clusters available in a multi-clusters setup for a single appID.
   *
   * @summary List the clusters available in a multi-clusters setup for a single appID.
   */
  listClusters(): Promise<ListClustersReponse> {
    const path = '/1/clusters';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

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
   * List existing indexes from an application.
   *
   * @summary List existing indexes.
   * @param page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   */
  listIndices(page?: number): Promise<ListIndicesResponse> {
    const path = '/1/indexes';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (page !== undefined) {
      queryParameters.Page = page.toString();
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
   * List the userIDs assigned to a multi-clusters appID.
   *
   * @summary List the userIDs assigned to a multi-clusters appID.
   * @param page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   * @param hitsPerPage - Number of hits returned per page.
   */
  listUserIds(
    page?: number,
    hitsPerPage?: number
  ): Promise<ListUserIdsResponse> {
    const path = '/1/clusters/mapping';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (page !== undefined) {
      queryParameters.Page = page.toString();
    }

    if (hitsPerPage !== undefined) {
      queryParameters.hitsPerPage = hitsPerPage.toString();
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
   * @param multipleQueriesObject - The multipleQueriesObject.
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
   * Peforms a copy or a move operation on a index.
   *
   * @summary Copy/move index.
   * @param indexName - The index in which to perform the request.
   * @param operationIndexObject - The operationIndexObject.
   */
  operationIndex(
    indexName: string,
    operationIndexObject: OperationIndexObject
  ): Promise<OperationIndexResponse> {
    const path = '/1/indexes/{indexName}/operation'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

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
   * Remove a userID and its associated data from the multi-clusters.
   *
   * @summary Remove a userID and its associated data from the multi-clusters.
   * @param xAlgoliaUserID - UserID to assign.
   */
  removeUserId(
    xAlgoliaUserID: Record<string, any>
  ): Promise<RemoveUserIdResponse> {
    const path = '/1/clusters/mapping';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (xAlgoliaUserID === null || xAlgoliaUserID === undefined) {
      throw new Error(
        'Required parameter xAlgoliaUserID was null or undefined when calling removeUserId.'
      );
    }

    if (xAlgoliaUserID !== undefined) {
      queryParameters['X-Algolia-User-ID'] = xAlgoliaUserID.toString();
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
   * Add an object to the index, automatically assigning it an object ID.
   *
   * @param indexName - The index in which to perform the request.
   * @param requestBody - The Algolia object.
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
   * @param indexName - The index in which to perform the request.
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
   * Search for userIDs.
   *
   * @summary Search for userIDs.
   * @param searchUserIdsObject - The searchUserIdsObject.
   */
  searchUserIds(
    searchUserIdsObject: SearchUserIdsObject
  ): Promise<AssignUserIdResponse> {
    const path = '/1/clusters/mapping/search';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (searchUserIdsObject === null || searchUserIdsObject === undefined) {
      throw new Error(
        'Required parameter searchUserIdsObject was null or undefined when calling searchUserIds.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: searchUserIdsObject,
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
   * @param indexName - The index in which to perform the request.
   * @param indexSettings - The indexSettings.
   * @param forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
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
