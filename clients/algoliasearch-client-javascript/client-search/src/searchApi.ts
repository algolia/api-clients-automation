import type { AddApiKeyResponse } from '../model/addApiKeyResponse';
import type { ApiKey } from '../model/apiKey';
import type { BatchObject } from '../model/batchObject';
import type { BatchResponse } from '../model/batchResponse';
import type { ClearAllSynonymsResponse } from '../model/clearAllSynonymsResponse';
import type { DeleteApiKeyResponse } from '../model/deleteApiKeyResponse';
import type { DeleteIndexResponse } from '../model/deleteIndexResponse';
import type { DeleteSynonymResponse } from '../model/deleteSynonymResponse';
import type { IndexSettings } from '../model/indexSettings';
import type { KeyObject } from '../model/keyObject';
import type { ListApiKeysResponse } from '../model/listApiKeysResponse';
import type { ListIndicesResponse } from '../model/listIndicesResponse';
import { ApiKeyAuth } from '../model/models';
import type { MultipleQueriesObject } from '../model/multipleQueriesObject';
import type { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import type { OperationIndexObject } from '../model/operationIndexObject';
import type { OperationIndexResponse } from '../model/operationIndexResponse';
import type { SaveObjectResponse } from '../model/saveObjectResponse';
import type { SaveSynonymResponse } from '../model/saveSynonymResponse';
import type { SaveSynonymsResponse } from '../model/saveSynonymsResponse';
import type { SearchParams } from '../model/searchParams';
import type { SearchParamsAsString } from '../model/searchParamsAsString';
import type { SearchResponse } from '../model/searchResponse';
import type { SearchSynonymsResponse } from '../model/searchSynonymsResponse';
import type { SetSettingsResponse } from '../model/setSettingsResponse';
import type { SynonymHit } from '../model/synonymHit';
import type { UpdateApiKeyResponse } from '../model/updateApiKeyResponse';
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
   * Add a new API Key with specific permissions/restrictions.
   *
   * @summary Create a new API key.
   * @param apiKey - The apiKey.
   */
  addApiKey(apiKey: ApiKey): Promise<AddApiKeyResponse> {
    const path = '/1/keys';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (apiKey === null || apiKey === undefined) {
      throw new Error(
        'Required parameter apiKey was null or undefined when calling addApiKey.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: apiKey,
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
   * Remove all synonyms from an index.
   *
   * @summary Clear all synonyms.
   * @param indexName - The index in which to perform the request.
   * @param forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  clearAllSynonyms(
    indexName: string,
    forwardToReplicas?: boolean
  ): Promise<ClearAllSynonymsResponse> {
    const path = '/1/indexes/{indexName}/synonyms/clear'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling clearAllSynonyms.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Delete an existing API Key.
   *
   * @summary Delete an API key.
   * @param key - API Key string.
   */
  deleteApiKey(key: string): Promise<DeleteApiKeyResponse> {
    const path = '/1/keys/{key}'.replace(
      '{key}',
      encodeURIComponent(String(key))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (key === null || key === undefined) {
      throw new Error(
        'Required parameter key was null or undefined when calling deleteApiKey.'
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
   * Delete a single synonyms set, identified by the given objectID.
   *
   * @summary Delete synonym.
   * @param indexName - The index in which to perform the request.
   * @param objectID - Unique identifier of an object.
   * @param forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  deleteSynonym(
    indexName: string,
    objectID: string,
    forwardToReplicas?: boolean
  ): Promise<DeleteSynonymResponse> {
    const path = '/1/indexes/{indexName}/synonyms/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling deleteSynonym.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling deleteSynonym.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
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
   * Get the permissions of an API key.
   *
   * @summary Get an API key.
   * @param key - API Key string.
   */
  getApiKey(key: string): Promise<KeyObject> {
    const path = '/1/keys/{key}'.replace(
      '{key}',
      encodeURIComponent(String(key))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (key === null || key === undefined) {
      throw new Error(
        'Required parameter key was null or undefined when calling getApiKey.'
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
   * Fetch a synonym object identified by its objectID.
   *
   * @summary Get synonym.
   * @param indexName - The index in which to perform the request.
   * @param objectID - Unique identifier of an object.
   */
  getSynonym(indexName: string, objectID: string): Promise<SynonymHit> {
    const path = '/1/indexes/{indexName}/synonyms/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling getSynonym.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling getSynonym.'
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
   * List API keys, along with their associated rights.
   *
   * @summary Get the full list of API Keys.
   */
  listApiKeys(): Promise<ListApiKeysResponse> {
    const path = '/1/keys';
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
   * Restore a deleted API key, along with its associated rights.
   *
   * @summary Restore an API key.
   * @param key - API Key string.
   */
  restoreApiKey(key: string): Promise<AddApiKeyResponse> {
    const path = '/1/keys/{key}/restore'.replace(
      '{key}',
      encodeURIComponent(String(key))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (key === null || key === undefined) {
      throw new Error(
        'Required parameter key was null or undefined when calling restoreApiKey.'
      );
    }

    const request: Request = {
      method: 'POST',
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
   * Create a new synonym object or update the existing synonym object with the given object ID.
   *
   * @summary Save synonym.
   * @param indexName - The index in which to perform the request.
   * @param objectID - Unique identifier of an object.
   * @param synonymHit - The synonymHit.
   * @param forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  saveSynonym(
    indexName: string,
    objectID: string,
    synonymHit: SynonymHit,
    forwardToReplicas?: boolean
  ): Promise<SaveSynonymResponse> {
    const path = '/1/indexes/{indexName}/synonyms/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling saveSynonym.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling saveSynonym.'
      );
    }

    if (synonymHit === null || synonymHit === undefined) {
      throw new Error(
        'Required parameter synonymHit was null or undefined when calling saveSynonym.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: synonymHit,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Create/update multiple synonym objects at once, potentially replacing the entire list of synonyms if replaceExistingSynonyms is true.
   *
   * @summary Save a batch of synonyms.
   * @param indexName - The index in which to perform the request.
   * @param synonymHit - The synonymHit.
   * @param forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   * @param replaceExistingSynonyms - Replace all synonyms of the index with the ones sent with this request.
   */
  saveSynonyms(
    indexName: string,
    synonymHit: SynonymHit[],
    forwardToReplicas?: boolean,
    replaceExistingSynonyms?: boolean
  ): Promise<SaveSynonymsResponse> {
    const path = '/1/indexes/{indexName}/synonyms/batch'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling saveSynonyms.'
      );
    }

    if (synonymHit === null || synonymHit === undefined) {
      throw new Error(
        'Required parameter synonymHit was null or undefined when calling saveSynonyms.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    if (replaceExistingSynonyms !== undefined) {
      queryParameters.replaceExistingSynonyms =
        replaceExistingSynonyms.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
      data: synonymHit,
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
   * Search or browse all synonyms, optionally filtering them by type.
   *
   * @summary Get all synonyms that match a query.
   * @param indexName - The index in which to perform the request.
   * @param query - Search for specific synonyms matching this string.
   * @param type - Only search for specific types of synonyms.
   * @param page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   * @param hitsPerPage - Maximum number of objects to retrieve.
   */
  searchSynonyms(
    indexName: string,
    query?: string,
    type?:
      | 'altcorrection1'
      | 'altcorrection2'
      | 'onewaysynonym'
      | 'placeholder'
      | 'synonym',
    page?: number,
    hitsPerPage?: number
  ): Promise<SearchSynonymsResponse> {
    const path = '/1/indexes/{indexName}/synonyms/search'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling searchSynonyms.'
      );
    }

    if (query !== undefined) {
      queryParameters.query = query.toString();
    }

    if (type !== undefined) {
      queryParameters.type = type.toString();
    }

    if (page !== undefined) {
      queryParameters.Page = page.toString();
    }

    if (hitsPerPage !== undefined) {
      queryParameters.hitsPerPage = hitsPerPage.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
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
  /**
   * Replace every permission of an existing API key.
   *
   * @summary Update an API key.
   * @param key - API Key string.
   * @param apiKey - The apiKey.
   */
  updateApiKey(key: string, apiKey: ApiKey): Promise<UpdateApiKeyResponse> {
    const path = '/1/keys/{key}'.replace(
      '{key}',
      encodeURIComponent(String(key))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (key === null || key === undefined) {
      throw new Error(
        'Required parameter key was null or undefined when calling updateApiKey.'
      );
    }

    if (apiKey === null || apiKey === undefined) {
      throw new Error(
        'Required parameter apiKey was null or undefined when calling updateApiKey.'
      );
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: apiKey,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}
