import type { AddApiKeyResponse } from '../model/addApiKeyResponse';
import type { ApiKey } from '../model/apiKey';
import type { AppendSourceResponse } from '../model/appendSourceResponse';
import type { AssignUserIdObject } from '../model/assignUserIdObject';
import type { AssignUserIdResponse } from '../model/assignUserIdResponse';
import type { BatchAssignUserIdsObject } from '../model/batchAssignUserIdsObject';
import type { BatchAssignUserIdsResponse } from '../model/batchAssignUserIdsResponse';
import type { BatchDictionaryEntries } from '../model/batchDictionaryEntries';
import type { BatchObject } from '../model/batchObject';
import type { BatchResponse } from '../model/batchResponse';
import type { BrowseRequest } from '../model/browseRequest';
import type { BrowseResponse } from '../model/browseResponse';
import type { ClearAllSynonymsResponse } from '../model/clearAllSynonymsResponse';
import type { DeleteApiKeyResponse } from '../model/deleteApiKeyResponse';
import type { DeleteIndexResponse } from '../model/deleteIndexResponse';
import type { DeleteSourceResponse } from '../model/deleteSourceResponse';
import type { DeleteSynonymResponse } from '../model/deleteSynonymResponse';
import type { DictionaryEntriesResponse } from '../model/dictionaryEntriesResponse';
import type { DictionarySettingsRequest } from '../model/dictionarySettingsRequest';
import type { GetDictionarySettingsResponse } from '../model/getDictionarySettingsResponse';
import type { GetLogsResponse } from '../model/getLogsResponse';
import type { GetTaskResponse } from '../model/getTaskResponse';
import type { GetTopUserIdsResponse } from '../model/getTopUserIdsResponse';
import type { HasPendingMappingsResponse } from '../model/hasPendingMappingsResponse';
import type { IndexSettings } from '../model/indexSettings';
import type { KeyObject } from '../model/keyObject';
import type { Languages } from '../model/languages';
import type { ListApiKeysResponse } from '../model/listApiKeysResponse';
import type { ListClustersResponse } from '../model/listClustersResponse';
import type { ListIndicesResponse } from '../model/listIndicesResponse';
import type { ListUserIdsResponse } from '../model/listUserIdsResponse';
import { ApiKeyAuth } from '../model/models';
import type { MultipleQueriesObject } from '../model/multipleQueriesObject';
import type { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import type { OperationIndexObject } from '../model/operationIndexObject';
import type { OperationIndexResponse } from '../model/operationIndexResponse';
import type { RemoveUserIdResponse } from '../model/removeUserIdResponse';
import type { ReplaceSourceResponse } from '../model/replaceSourceResponse';
import type { Rule } from '../model/rule';
import type { SaveObjectResponse } from '../model/saveObjectResponse';
import type { SaveSynonymResponse } from '../model/saveSynonymResponse';
import type { SaveSynonymsResponse } from '../model/saveSynonymsResponse';
import type { SearchDictionaryEntries } from '../model/searchDictionaryEntries';
import type { SearchForFacetValuesRequest } from '../model/searchForFacetValuesRequest';
import type { SearchForFacetValuesResponse } from '../model/searchForFacetValuesResponse';
import type { SearchParams } from '../model/searchParams';
import type { SearchParamsAsString } from '../model/searchParamsAsString';
import type { SearchResponse } from '../model/searchResponse';
import type { SearchRulesParams } from '../model/searchRulesParams';
import type { SearchRulesResponse } from '../model/searchRulesResponse';
import type { SearchSynonymsResponse } from '../model/searchSynonymsResponse';
import type { SearchUserIdsObject } from '../model/searchUserIdsObject';
import type { SearchUserIdsResponse } from '../model/searchUserIdsResponse';
import type { SetSettingsResponse } from '../model/setSettingsResponse';
import type { Source } from '../model/source';
import type { SynonymHit } from '../model/synonymHit';
import type { UpdateApiKeyResponse } from '../model/updateApiKeyResponse';
import type { UpdatedRuleResponse } from '../model/updatedRuleResponse';
import type { UpdatedRuleResponseWithoutObjectID } from '../model/updatedRuleResponseWithoutObjectID';
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
   * Add a new API Key with specific permissions/restrictions.
   *
   * @summary Create a new API key.
   * @param addApiKey - The addApiKey parameters.
   * @param addApiKey.apiKey - The apiKey.
   */
  addApiKey({ apiKey }: AddApiKeyProps): Promise<AddApiKeyResponse> {
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
   * Add a single source to the list of allowed sources.
   *
   * @param appendSource - The appendSource parameters.
   * @param appendSource.source - The source to add.
   */
  appendSource({ source }: AppendSourceProps): Promise<AppendSourceResponse> {
    const path = '/1/security/sources/append';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (source === null || source === undefined) {
      throw new Error(
        'Required parameter source was null or undefined when calling appendSource.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: source,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Assign or Move a userID to a cluster. The time it takes to migrate (move) a user is proportional to the amount of data linked to the userID. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userID is directly usable.
   *
   * @summary Assign or Move userID.
   * @param assignUserId - The assignUserId parameters.
   * @param assignUserId.xAlgoliaUserID - UserID to assign.
   * @param assignUserId.assignUserIdObject - The assignUserIdObject.
   */
  assignUserId({
    xAlgoliaUserID,
    assignUserIdObject,
  }: AssignUserIdProps): Promise<AssignUserIdResponse> {
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
   * @param batch - The batch parameters.
   * @param batch.indexName - The index in which to perform the request.
   * @param batch.batchObject - The batchObject.
   */
  batch({ indexName, batchObject }: BatchProps): Promise<BatchResponse> {
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
   * Assign multiple userIDs to a cluster. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userIDs are directly usable.
   *
   * @summary Batch assign userIDs.
   * @param batchAssignUserIds - The batchAssignUserIds parameters.
   * @param batchAssignUserIds.xAlgoliaUserID - UserID to assign.
   * @param batchAssignUserIds.batchAssignUserIdsObject - The batchAssignUserIdsObject.
   */
  batchAssignUserIds({
    xAlgoliaUserID,
    batchAssignUserIdsObject,
  }: BatchAssignUserIdsProps): Promise<BatchAssignUserIdsResponse> {
    const path = '/1/clusters/mapping/batch';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (xAlgoliaUserID === null || xAlgoliaUserID === undefined) {
      throw new Error(
        'Required parameter xAlgoliaUserID was null or undefined when calling batchAssignUserIds.'
      );
    }

    if (
      batchAssignUserIdsObject === null ||
      batchAssignUserIdsObject === undefined
    ) {
      throw new Error(
        'Required parameter batchAssignUserIdsObject was null or undefined when calling batchAssignUserIds.'
      );
    }

    if (xAlgoliaUserID !== undefined) {
      queryParameters['X-Algolia-User-ID'] = xAlgoliaUserID.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
      data: batchAssignUserIdsObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Send a batch of dictionary entries.
   *
   * @summary Send a batch of dictionary entries.
   * @param batchDictionaryEntries - The batchDictionaryEntries parameters.
   * @param batchDictionaryEntries.dictionaryName - The dictionary to search in.
   * @param batchDictionaryEntries.batchDictionaryEntries - The batchDictionaryEntries.
   */
  batchDictionaryEntries({
    dictionaryName,
    batchDictionaryEntries,
  }: BatchDictionaryEntriesProps): Promise<DictionaryEntriesResponse> {
    const path = '/1/dictionaries/{dictionaryName}/batch'.replace(
      '{dictionaryName}',
      encodeURIComponent(String(dictionaryName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (dictionaryName === null || dictionaryName === undefined) {
      throw new Error(
        'Required parameter dictionaryName was null or undefined when calling batchDictionaryEntries.'
      );
    }

    if (
      batchDictionaryEntries === null ||
      batchDictionaryEntries === undefined
    ) {
      throw new Error(
        'Required parameter batchDictionaryEntries was null or undefined when calling batchDictionaryEntries.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: batchDictionaryEntries,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Create or update a batch of Rules.
   *
   * @summary Batch Rules.
   * @param batchRules - The batchRules parameters.
   * @param batchRules.indexName - The index in which to perform the request.
   * @param batchRules.rule - The rule.
   * @param batchRules.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   * @param batchRules.clearExistingRules - When true, existing Rules are cleared before adding this batch. When false, existing Rules are kept.
   */
  batchRules({
    indexName,
    rule,
    forwardToReplicas,
    clearExistingRules,
  }: BatchRulesProps): Promise<UpdatedRuleResponseWithoutObjectID> {
    const path = '/1/indexes/{indexName}/rules/batch'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling batchRules.'
      );
    }

    if (rule === null || rule === undefined) {
      throw new Error(
        'Required parameter rule was null or undefined when calling batchRules.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    if (clearExistingRules !== undefined) {
      queryParameters.clearExistingRules = clearExistingRules.toString();
    }

    const request: Request = {
      method: 'POST',
      path,
      data: rule,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * This method allows you to retrieve all index content. It can retrieve up to 1,000 records per call and supports full text search and filters. For performance reasons, some features are not supported, including `distinct`, sorting by `typos`, `words` or `geo distance`. When there is more content to be browsed, the response contains a cursor field. This cursor has to be passed to the subsequent call to browse in order to get the next page of results. When the end of the index has been reached, the cursor field is absent from the response.
   *
   * @summary Retrieve all index content.
   * @param browse - The browse parameters.
   * @param browse.indexName - The index in which to perform the request.
   * @param browse.browseRequest - The browseRequest.
   */
  browse({ indexName, browseRequest }: BrowseProps): Promise<BrowseResponse> {
    const path = '/1/indexes/{indexName}/browse'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling browse.'
      );
    }

    if (browseRequest === null || browseRequest === undefined) {
      throw new Error(
        'Required parameter browseRequest was null or undefined when calling browse.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: browseRequest,
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
   * @param clearAllSynonyms - The clearAllSynonyms parameters.
   * @param clearAllSynonyms.indexName - The index in which to perform the request.
   * @param clearAllSynonyms.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  clearAllSynonyms({
    indexName,
    forwardToReplicas,
  }: ClearAllSynonymsProps): Promise<ClearAllSynonymsResponse> {
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
   * Delete all Rules in the index.
   *
   * @summary Clear Rules.
   * @param clearRules - The clearRules parameters.
   * @param clearRules.indexName - The index in which to perform the request.
   * @param clearRules.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  clearRules({
    indexName,
    forwardToReplicas,
  }: ClearRulesProps): Promise<UpdatedRuleResponseWithoutObjectID> {
    const path = '/1/indexes/{indexName}/rules/clear'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling clearRules.'
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
   * @param deleteApiKey - The deleteApiKey parameters.
   * @param deleteApiKey.key - API Key string.
   */
  deleteApiKey({ key }: DeleteApiKeyProps): Promise<DeleteApiKeyResponse> {
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
   * @param deleteIndex - The deleteIndex parameters.
   * @param deleteIndex.indexName - The index in which to perform the request.
   */
  deleteIndex({ indexName }: DeleteIndexProps): Promise<DeleteIndexResponse> {
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
   * Delete the Rule with the specified objectID.
   *
   * @summary Delete a rule.
   * @param deleteRule - The deleteRule parameters.
   * @param deleteRule.indexName - The index in which to perform the request.
   * @param deleteRule.objectID - Unique identifier of an object.
   * @param deleteRule.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  deleteRule({
    indexName,
    objectID,
    forwardToReplicas,
  }: DeleteRuleProps): Promise<UpdatedRuleResponseWithoutObjectID> {
    const path = '/1/indexes/{indexName}/rules/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling deleteRule.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling deleteRule.'
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
   * Remove a single source from the list of allowed sources.
   *
   * @param deleteSource - The deleteSource parameters.
   * @param deleteSource.source - The IP range of the source.
   */
  deleteSource({ source }: DeleteSourceProps): Promise<DeleteSourceResponse> {
    const path = '/1/security/sources/{source}'.replace(
      '{source}',
      encodeURIComponent(String(source))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (source === null || source === undefined) {
      throw new Error(
        'Required parameter source was null or undefined when calling deleteSource.'
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
   * @param deleteSynonym - The deleteSynonym parameters.
   * @param deleteSynonym.indexName - The index in which to perform the request.
   * @param deleteSynonym.objectID - Unique identifier of an object.
   * @param deleteSynonym.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  deleteSynonym({
    indexName,
    objectID,
    forwardToReplicas,
  }: DeleteSynonymProps): Promise<DeleteSynonymResponse> {
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
   * @param getApiKey - The getApiKey parameters.
   * @param getApiKey.key - API Key string.
   */
  getApiKey({ key }: GetApiKeyProps): Promise<KeyObject> {
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
   * List dictionaries supported per language.
   *
   * @summary List dictionaries supported per language.
   * @param getDictionaryLanguages - The getDictionaryLanguages parameters.
   */
  getDictionaryLanguages(): Promise<{ [key: string]: Languages }> {
    const path = '/1/dictionaries/*/languages';
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
   * Retrieve dictionaries settings.
   *
   * @summary Retrieve dictionaries settings. The API stores languages whose standard entries are disabled. Fetch settings does not return false values.
   * @param getDictionarySettings - The getDictionarySettings parameters.
   */
  getDictionarySettings(): Promise<GetDictionarySettingsResponse> {
    const path = '/1/dictionaries/*/settings';
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
   * Return the lastest log entries.
   *
   * @param getLogs - The getLogs parameters.
   * @param getLogs.offset - First entry to retrieve (zero-based). Log entries are sorted by decreasing date, therefore 0 designates the most recent log entry.
   * @param getLogs.length - Maximum number of entries to retrieve. The maximum allowed value is 1000.
   * @param getLogs.indexName - Index for which log entries should be retrieved. When omitted, log entries are retrieved across all indices.
   * @param getLogs.type - Type of log entries to retrieve. When omitted, all log entries are retrieved.
   */
  getLogs({
    offset,
    length,
    indexName,
    type,
  }: GetLogsProps): Promise<GetLogsResponse> {
    const path = '/1/logs';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (offset !== undefined) {
      queryParameters.offset = offset.toString();
    }

    if (length !== undefined) {
      queryParameters.length = length.toString();
    }

    if (indexName !== undefined) {
      queryParameters.indexName = indexName.toString();
    }

    if (type !== undefined) {
      queryParameters.type = type.toString();
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
   * Retrieve the Rule with the specified objectID.
   *
   * @summary Get a rule.
   * @param getRule - The getRule parameters.
   * @param getRule.indexName - The index in which to perform the request.
   * @param getRule.objectID - Unique identifier of an object.
   */
  getRule({ indexName, objectID }: GetRuleProps): Promise<Rule> {
    const path = '/1/indexes/{indexName}/rules/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling getRule.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling getRule.'
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
   * @param getSettings - The getSettings parameters.
   * @param getSettings.indexName - The index in which to perform the request.
   */
  getSettings({ indexName }: GetSettingsProps): Promise<IndexSettings> {
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
   * List all allowed sources.
   *
   * @param getSources - The getSources parameters.
   */
  getSources(): Promise<Source[]> {
    const path = '/1/security/sources';
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
   * Fetch a synonym object identified by its objectID.
   *
   * @summary Get synonym.
   * @param getSynonym - The getSynonym parameters.
   * @param getSynonym.indexName - The index in which to perform the request.
   * @param getSynonym.objectID - Unique identifier of an object.
   */
  getSynonym({ indexName, objectID }: GetSynonymProps): Promise<SynonymHit> {
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
   * Check the current status of a given task.
   *
   * @param getTask - The getTask parameters.
   * @param getTask.indexName - The index in which to perform the request.
   * @param getTask.taskID - Unique identifier of an task. Numeric value (up to 64bits).
   */
  getTask({ indexName, taskID }: GetTaskProps): Promise<GetTaskResponse> {
    const path = '/1/indexes/{indexName}/task/{taskID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{taskID}', encodeURIComponent(String(taskID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling getTask.'
      );
    }

    if (taskID === null || taskID === undefined) {
      throw new Error(
        'Required parameter taskID was null or undefined when calling getTask.'
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
   * Get the top 10 userIDs with the highest number of records per cluster. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following array of userIDs and clusters.
   *
   * @summary Get top userID.
   * @param getTopUserIds - The getTopUserIds parameters.
   */
  getTopUserIds(): Promise<GetTopUserIdsResponse> {
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
   * Returns the userID data stored in the mapping. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following userID data.
   *
   * @summary Get userID.
   * @param getUserId - The getUserId parameters.
   * @param getUserId.userID - UserID to assign.
   */
  getUserId({ userID }: GetUserIdProps): Promise<UserId> {
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
   * Get the status of your clusters\' migrations or user creations. Creating a large batch of users or migrating your multi-cluster may take quite some time. This method lets you retrieve the status of the migration, so you can know when it\'s done. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userIDs are directly usable.
   *
   * @summary Has pending mappings.
   * @param hasPendingMappings - The hasPendingMappings parameters.
   * @param hasPendingMappings.getClusters - The getClusters.
   */
  hasPendingMappings({
    getClusters,
  }: HasPendingMappingsProps): Promise<HasPendingMappingsResponse> {
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
   * List API keys, along with their associated rights.
   *
   * @summary Get the full list of API Keys.
   * @param listApiKeys - The listApiKeys parameters.
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
   * List the clusters available in a multi-clusters setup for a single appID. Upon success, the response is 200 OK and contains the following clusters.
   *
   * @summary List clusters.
   * @param listClusters - The listClusters parameters.
   */
  listClusters(): Promise<ListClustersResponse> {
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
   * @param listIndices - The listIndices parameters.
   * @param listIndices.page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   */
  listIndices({ page }: ListIndicesProps): Promise<ListIndicesResponse> {
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
   * List the userIDs assigned to a multi-clusters appID. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following userIDs data.
   *
   * @summary List userIDs.
   * @param listUserIds - The listUserIds parameters.
   * @param listUserIds.page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   * @param listUserIds.hitsPerPage - Maximum number of objects to retrieve.
   */
  listUserIds({
    page,
    hitsPerPage,
  }: ListUserIdsProps): Promise<ListUserIdsResponse> {
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
   * @param multipleQueries - The multipleQueries parameters.
   * @param multipleQueries.multipleQueriesObject - The multipleQueriesObject.
   */
  multipleQueries({
    multipleQueriesObject,
  }: MultipleQueriesProps): Promise<MultipleQueriesResponse> {
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
   * @param operationIndex - The operationIndex parameters.
   * @param operationIndex.indexName - The index in which to perform the request.
   * @param operationIndex.operationIndexObject - The operationIndexObject.
   */
  operationIndex({
    indexName,
    operationIndexObject,
  }: OperationIndexProps): Promise<OperationIndexResponse> {
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
   * Remove a userID and its associated data from the multi-clusters. Upon success, the response is 200 OK and a task is created to remove the userID data and mapping.
   *
   * @summary Remove userID.
   * @param removeUserId - The removeUserId parameters.
   * @param removeUserId.userID - UserID to assign.
   */
  removeUserId({ userID }: RemoveUserIdProps): Promise<RemoveUserIdResponse> {
    const path = '/1/clusters/mapping/{userID}'.replace(
      '{userID}',
      encodeURIComponent(String(userID))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (userID === null || userID === undefined) {
      throw new Error(
        'Required parameter userID was null or undefined when calling removeUserId.'
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
   * Replace all allowed sources.
   *
   * @param replaceSources - The replaceSources parameters.
   * @param replaceSources.source - The sources to allow.
   */
  replaceSources({
    source,
  }: ReplaceSourcesProps): Promise<ReplaceSourceResponse> {
    const path = '/1/security/sources';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (source === null || source === undefined) {
      throw new Error(
        'Required parameter source was null or undefined when calling replaceSources.'
      );
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: source,
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
   * @param restoreApiKey - The restoreApiKey parameters.
   * @param restoreApiKey.key - API Key string.
   */
  restoreApiKey({ key }: RestoreApiKeyProps): Promise<AddApiKeyResponse> {
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
   * @param saveObject - The saveObject parameters.
   * @param saveObject.indexName - The index in which to perform the request.
   * @param saveObject.requestBody - The Algolia object.
   */
  saveObject({
    indexName,
    requestBody,
  }: SaveObjectProps): Promise<SaveObjectResponse> {
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
   * Create or update the Rule with the specified objectID.
   *
   * @summary Save/Update a rule.
   * @param saveRule - The saveRule parameters.
   * @param saveRule.indexName - The index in which to perform the request.
   * @param saveRule.objectID - Unique identifier of an object.
   * @param saveRule.rule - The rule.
   * @param saveRule.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  saveRule({
    indexName,
    objectID,
    rule,
    forwardToReplicas,
  }: SaveRuleProps): Promise<UpdatedRuleResponse> {
    const path = '/1/indexes/{indexName}/rules/{objectID}'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{objectID}', encodeURIComponent(String(objectID)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling saveRule.'
      );
    }

    if (objectID === null || objectID === undefined) {
      throw new Error(
        'Required parameter objectID was null or undefined when calling saveRule.'
      );
    }

    if (rule === null || rule === undefined) {
      throw new Error(
        'Required parameter rule was null or undefined when calling saveRule.'
      );
    }

    if (forwardToReplicas !== undefined) {
      queryParameters.forwardToReplicas = forwardToReplicas.toString();
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: rule,
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
   * @param saveSynonym - The saveSynonym parameters.
   * @param saveSynonym.indexName - The index in which to perform the request.
   * @param saveSynonym.objectID - Unique identifier of an object.
   * @param saveSynonym.synonymHit - The synonymHit.
   * @param saveSynonym.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  saveSynonym({
    indexName,
    objectID,
    synonymHit,
    forwardToReplicas,
  }: SaveSynonymProps): Promise<SaveSynonymResponse> {
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
   * @param saveSynonyms - The saveSynonyms parameters.
   * @param saveSynonyms.indexName - The index in which to perform the request.
   * @param saveSynonyms.synonymHit - The synonymHit.
   * @param saveSynonyms.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   * @param saveSynonyms.replaceExistingSynonyms - Replace all synonyms of the index with the ones sent with this request.
   */
  saveSynonyms({
    indexName,
    synonymHit,
    forwardToReplicas,
    replaceExistingSynonyms,
  }: SaveSynonymsProps): Promise<SaveSynonymsResponse> {
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
   * @param search - The search parameters.
   * @param search.indexName - The index in which to perform the request.
   * @param search.searchParamsAsStringSearchParams - The searchParamsAsStringSearchParams.
   */
  search({
    indexName,
    searchParamsAsStringSearchParams,
  }: SearchProps): Promise<SearchResponse> {
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
   * Search the dictionary entries.
   *
   * @summary Search the dictionary entries.
   * @param searchDictionaryEntries - The searchDictionaryEntries parameters.
   * @param searchDictionaryEntries.dictionaryName - The dictionary to search in.
   * @param searchDictionaryEntries.searchDictionaryEntries - The searchDictionaryEntries.
   */
  searchDictionaryEntries({
    dictionaryName,
    searchDictionaryEntries,
  }: SearchDictionaryEntriesProps): Promise<DictionaryEntriesResponse> {
    const path = '/1/dictionaries/{dictionaryName}/search'.replace(
      '{dictionaryName}',
      encodeURIComponent(String(dictionaryName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (dictionaryName === null || dictionaryName === undefined) {
      throw new Error(
        'Required parameter dictionaryName was null or undefined when calling searchDictionaryEntries.'
      );
    }

    if (
      searchDictionaryEntries === null ||
      searchDictionaryEntries === undefined
    ) {
      throw new Error(
        'Required parameter searchDictionaryEntries was null or undefined when calling searchDictionaryEntries.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: searchDictionaryEntries,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Search for values of a given facet, optionally restricting the returned values to those contained in objects matching other search criteria.
   *
   * @summary Search for values of a given facet.
   * @param searchForFacetValues - The searchForFacetValues parameters.
   * @param searchForFacetValues.indexName - The index in which to perform the request.
   * @param searchForFacetValues.facetName - The facet name.
   * @param searchForFacetValues.searchForFacetValuesRequest - The searchForFacetValuesRequest.
   */
  searchForFacetValues({
    indexName,
    facetName,
    searchForFacetValuesRequest,
  }: SearchForFacetValuesProps): Promise<SearchForFacetValuesResponse> {
    const path = '/1/indexes/{indexName}/facets/{facetName}/query'
      .replace('{indexName}', encodeURIComponent(String(indexName)))
      .replace('{facetName}', encodeURIComponent(String(facetName)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling searchForFacetValues.'
      );
    }

    if (facetName === null || facetName === undefined) {
      throw new Error(
        'Required parameter facetName was null or undefined when calling searchForFacetValues.'
      );
    }

    if (
      searchForFacetValuesRequest === null ||
      searchForFacetValuesRequest === undefined
    ) {
      throw new Error(
        'Required parameter searchForFacetValuesRequest was null or undefined when calling searchForFacetValues.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: searchForFacetValuesRequest,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
  /**
   * Search for rules matching various criteria.
   *
   * @summary Search for rules.
   * @param searchRules - The searchRules parameters.
   * @param searchRules.indexName - The index in which to perform the request.
   * @param searchRules.searchRulesParams - The searchRulesParams.
   */
  searchRules({
    indexName,
    searchRulesParams,
  }: SearchRulesProps): Promise<SearchRulesResponse> {
    const path = '/1/indexes/{indexName}/rules/search'.replace(
      '{indexName}',
      encodeURIComponent(String(indexName))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling searchRules.'
      );
    }

    if (searchRulesParams === null || searchRulesParams === undefined) {
      throw new Error(
        'Required parameter searchRulesParams was null or undefined when calling searchRules.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: searchRulesParams,
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
   * @param searchSynonyms - The searchSynonyms parameters.
   * @param searchSynonyms.indexName - The index in which to perform the request.
   * @param searchSynonyms.query - Search for specific synonyms matching this string.
   * @param searchSynonyms.type - Only search for specific types of synonyms.
   * @param searchSynonyms.page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   * @param searchSynonyms.hitsPerPage - Maximum number of objects to retrieve.
   */
  searchSynonyms({
    indexName,
    query,
    type,
    page,
    hitsPerPage,
  }: SearchSynonymsProps): Promise<SearchSynonymsResponse> {
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
   * Search for userIDs. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds propagate to the different clusters. To keep updates moving quickly, the index of userIDs isn\'t built synchronously with the mapping. Instead, the index is built once every 12h, at the same time as the update of userID usage. For example, when you perform a modification like adding or moving a userID, the search will report an outdated value until the next rebuild of the mapping, which takes place every 12h. Upon success, the response is 200 OK and contains the following userIDs data.
   *
   * @summary Search userID.
   * @param searchUserIds - The searchUserIds parameters.
   * @param searchUserIds.searchUserIdsObject - The searchUserIdsObject.
   */
  searchUserIds({
    searchUserIdsObject,
  }: SearchUserIdsProps): Promise<SearchUserIdsResponse> {
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
   * Set dictionary settings.
   *
   * @summary Set dictionary settings.
   * @param setDictionarySettings - The setDictionarySettings parameters.
   * @param setDictionarySettings.dictionarySettingsRequest - The dictionarySettingsRequest.
   */
  setDictionarySettings({
    dictionarySettingsRequest,
  }: SetDictionarySettingsProps): Promise<DictionaryEntriesResponse> {
    const path = '/1/dictionaries/*/settings';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (
      dictionarySettingsRequest === null ||
      dictionarySettingsRequest === undefined
    ) {
      throw new Error(
        'Required parameter dictionarySettingsRequest was null or undefined when calling setDictionarySettings.'
      );
    }

    const request: Request = {
      method: 'PUT',
      path,
      data: dictionarySettingsRequest,
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
   * @param setSettings - The setSettings parameters.
   * @param setSettings.indexName - The index in which to perform the request.
   * @param setSettings.indexSettings - The indexSettings.
   * @param setSettings.forwardToReplicas - When true, changes are also propagated to replicas of the given indexName.
   */
  setSettings({
    indexName,
    indexSettings,
    forwardToReplicas,
  }: SetSettingsProps): Promise<SetSettingsResponse> {
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
   * @param updateApiKey - The updateApiKey parameters.
   * @param updateApiKey.key - API Key string.
   * @param updateApiKey.apiKey - The apiKey.
   */
  updateApiKey({
    key,
    apiKey,
  }: UpdateApiKeyProps): Promise<UpdateApiKeyResponse> {
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

export type AddApiKeyProps = {
  apiKey: ApiKey;
};

export type AppendSourceProps = {
  source: Source;
};

export type AssignUserIdProps = {
  xAlgoliaUserID: Record<string, any>;
  assignUserIdObject: AssignUserIdObject;
};

export type BatchProps = {
  indexName: string;
  batchObject: BatchObject;
};

export type BatchAssignUserIdsProps = {
  xAlgoliaUserID: Record<string, any>;
  batchAssignUserIdsObject: BatchAssignUserIdsObject;
};

export type BatchDictionaryEntriesProps = {
  dictionaryName: 'compounds' | 'plurals' | 'stopwords';
  batchDictionaryEntries: BatchDictionaryEntries;
};

export type BatchRulesProps = {
  indexName: string;
  rule: Rule[];
  forwardToReplicas?: boolean;
  clearExistingRules?: boolean;
};

export type BrowseProps = {
  indexName: string;
  browseRequest: BrowseRequest;
};

export type ClearAllSynonymsProps = {
  indexName: string;
  forwardToReplicas?: boolean;
};

export type ClearRulesProps = {
  indexName: string;
  forwardToReplicas?: boolean;
};

export type DeleteApiKeyProps = {
  key: string;
};

export type DeleteIndexProps = {
  indexName: string;
};

export type DeleteRuleProps = {
  indexName: string;
  objectID: string;
  forwardToReplicas?: boolean;
};

export type DeleteSourceProps = {
  source: string;
};

export type DeleteSynonymProps = {
  indexName: string;
  objectID: string;
  forwardToReplicas?: boolean;
};

export type GetApiKeyProps = {
  key: string;
};

export type GetLogsProps = {
  offset?: number;
  length?: number;
  indexName?: string;
  type?: 'all' | 'build' | 'error' | 'query';
};

export type GetRuleProps = {
  indexName: string;
  objectID: string;
};

export type GetSettingsProps = {
  indexName: string;
};

export type GetSynonymProps = {
  indexName: string;
  objectID: string;
};

export type GetTaskProps = {
  indexName: string;
  taskID: number;
};

export type GetUserIdProps = {
  userID: Record<string, any>;
};

export type HasPendingMappingsProps = {
  getClusters?: boolean;
};

export type ListIndicesProps = {
  page?: number;
};

export type ListUserIdsProps = {
  page?: number;
  hitsPerPage?: number;
};

export type MultipleQueriesProps = {
  multipleQueriesObject: MultipleQueriesObject;
};

export type OperationIndexProps = {
  indexName: string;
  operationIndexObject: OperationIndexObject;
};

export type RemoveUserIdProps = {
  userID: Record<string, any>;
};

export type ReplaceSourcesProps = {
  source: Source[];
};

export type RestoreApiKeyProps = {
  key: string;
};

export type SaveObjectProps = {
  indexName: string;
  requestBody: { [key: string]: Record<string, any> };
};

export type SaveRuleProps = {
  indexName: string;
  objectID: string;
  rule: Rule;
  forwardToReplicas?: boolean;
};

export type SaveSynonymProps = {
  indexName: string;
  objectID: string;
  synonymHit: SynonymHit;
  forwardToReplicas?: boolean;
};

export type SaveSynonymsProps = {
  indexName: string;
  synonymHit: SynonymHit[];
  forwardToReplicas?: boolean;
  replaceExistingSynonyms?: boolean;
};

export type SearchProps = {
  indexName: string;
  searchParamsAsStringSearchParams: SearchParams | SearchParamsAsString;
};

export type SearchDictionaryEntriesProps = {
  dictionaryName: 'compounds' | 'plurals' | 'stopwords';
  searchDictionaryEntries: SearchDictionaryEntries;
};

export type SearchForFacetValuesProps = {
  indexName: string;
  facetName: string;
  searchForFacetValuesRequest: SearchForFacetValuesRequest;
};

export type SearchRulesProps = {
  indexName: string;
  searchRulesParams: SearchRulesParams;
};

export type SearchSynonymsProps = {
  indexName: string;
  query?: string;
  type?:
    | 'altcorrection1'
    | 'altcorrection2'
    | 'onewaysynonym'
    | 'placeholder'
    | 'synonym';
  page?: number;
  hitsPerPage?: number;
};

export type SearchUserIdsProps = {
  searchUserIdsObject: SearchUserIdsObject;
};

export type SetDictionarySettingsProps = {
  dictionarySettingsRequest: DictionarySettingsRequest;
};

export type SetSettingsProps = {
  indexName: string;
  indexSettings: IndexSettings;
  forwardToReplicas?: boolean;
};

export type UpdateApiKeyProps = {
  key: string;
  apiKey: ApiKey;
};
