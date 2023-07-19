// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { CreateIterablePromise } from '@algolia/client-common';

import type { ApiKey } from './apiKey';
import type { AssignUserIdParams } from './assignUserIdParams';
import type { AttributeToUpdate } from './attributeToUpdate';
import type { BatchAssignUserIdsParams } from './batchAssignUserIdsParams';
import type { BatchDictionaryEntriesParams } from './batchDictionaryEntriesParams';
import type { BatchWriteParams } from './batchWriteParams';
import type { BrowseParams } from './browseParams';
import type { DeleteByParams } from './deleteByParams';
import type { DictionaryType } from './dictionaryType';
import type { IndexSettings } from './indexSettings';
import type { LogType } from './logType';
import type { OperationIndexParams } from './operationIndexParams';
import type { Rule } from './rule';
import type { SearchDictionaryEntriesParams } from './searchDictionaryEntriesParams';
import type { SearchForFacetValuesRequest } from './searchForFacetValuesRequest';
import type { SearchForFacetsOptions } from './searchForFacetsOptions';
import type { SearchForHitsOptions } from './searchForHitsOptions';
import type { SearchParams } from './searchParams';
import type { SearchParamsObject } from './searchParamsObject';
import type { SearchRulesParams } from './searchRulesParams';
import type { SearchSynonymsParams } from './searchSynonymsParams';
import type { Source } from './source';
import type { SynonymHit } from './synonymHit';
import type { SynonymType } from './synonymType';

/**
 * Properties for the `addOrUpdateObject` method.
 */
export type AddOrUpdateObjectProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique record (object) identifier.
   */
  objectID: string;
  /**
   * Algolia record.
   */
  body: Record<string, any>;
};

/**
 * Properties for the `assignUserId` method.
 */
export type AssignUserIdProps = {
  /**
   * UserID to assign.
   */
  xAlgoliaUserID: string;
  assignUserIdParams: AssignUserIdParams;
};

/**
 * Properties for the `batch` method.
 */
export type BatchProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  batchWriteParams: BatchWriteParams;
};

/**
 * Properties for the `batchAssignUserIds` method.
 */
export type BatchAssignUserIdsProps = {
  /**
   * UserID to assign.
   */
  xAlgoliaUserID: string;
  batchAssignUserIdsParams: BatchAssignUserIdsParams;
};

/**
 * Properties for the `batchDictionaryEntries` method.
 */
export type BatchDictionaryEntriesProps = {
  /**
   * Dictionary to search in.
   */
  dictionaryName: DictionaryType;
  batchDictionaryEntriesParams: BatchDictionaryEntriesParams;
};

/**
 * Properties for the `browse` method.
 */
export type BrowseProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  browseParams?: BrowseParams;
};

/**
 * Properties for the `clearAllSynonyms` method.
 */
export type ClearAllSynonymsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `clearObjects` method.
 */
export type ClearObjectsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
};

/**
 * Properties for the `clearRules` method.
 */
export type ClearRulesProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `del` method.
 */
export type DelProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: Record<string, any>;
};

/**
 * Properties for the `deleteApiKey` method.
 */
export type DeleteApiKeyProps = {
  /**
   * API key.
   */
  key: string;
};

/**
 * Properties for the `deleteBy` method.
 */
export type DeleteByProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  deleteByParams: DeleteByParams;
};

/**
 * Properties for the `deleteIndex` method.
 */
export type DeleteIndexProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
};

/**
 * Properties for the `deleteObject` method.
 */
export type DeleteObjectProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique record (object) identifier.
   */
  objectID: string;
};

/**
 * Properties for the `deleteRule` method.
 */
export type DeleteRuleProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a rule object.
   */
  objectID: string;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `deleteSource` method.
 */
export type DeleteSourceProps = {
  /**
   * IP address range of the source.
   */
  source: string;
};

/**
 * Properties for the `deleteSynonym` method.
 */
export type DeleteSynonymProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a synonym object.
   */
  objectID: string;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `get` method.
 */
export type GetProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: Record<string, any>;
};

/**
 * Properties for the `getApiKey` method.
 */
export type GetApiKeyProps = {
  /**
   * API key.
   */
  key: string;
};

/**
 * Properties for the `getLogs` method.
 */
export type GetLogsProps = {
  /**
   * First log entry to retrieve. Sorted by decreasing date with 0 being the most recent.
   */
  offset?: number;
  /**
   * Maximum number of entries to retrieve.
   */
  length?: number;
  /**
   * Index for which log entries should be retrieved. When omitted, log entries are retrieved for all indices.
   */
  indexName?: string;
  /**
   * Type of log entries to retrieve. When omitted, all log entries are retrieved.
   */
  type?: LogType;
};

/**
 * Properties for the `getObject` method.
 */
export type GetObjectProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique record (object) identifier.
   */
  objectID: string;
  /**
   * Attributes to include with the records in the response. This is useful to reduce the size of the API response. By default, all retrievable attributes are returned. `objectID` is always retrieved, even when not specified. [`unretrievableAttributes`](https://www.algolia.com/doc/api-reference/api-parameters/unretrievableAttributes/) won\'t be retrieved unless the request is authenticated with the admin API key.
   */
  attributesToRetrieve?: string[];
};

/**
 * Properties for the `getRule` method.
 */
export type GetRuleProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a rule object.
   */
  objectID: string;
};

/**
 * Properties for the `getSettings` method.
 */
export type GetSettingsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
};

/**
 * Properties for the `getSynonym` method.
 */
export type GetSynonymProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a synonym object.
   */
  objectID: string;
};

/**
 * Properties for the `getTask` method.
 */
export type GetTaskProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique task identifier.
   */
  taskID: number;
};

/**
 * Properties for the `getUserId` method.
 */
export type GetUserIdProps = {
  /**
   * UserID to assign.
   */
  userID: string;
};

/**
 * Properties for the `hasPendingMappings` method.
 */
export type HasPendingMappingsProps = {
  /**
   * Indicates whether to include the cluster\'s pending mapping state in the response.
   */
  getClusters?: boolean;
};

/**
 * Properties for the `listIndices` method.
 */
export type ListIndicesProps = {
  /**
   * Returns the requested page number. The page size is determined by the `hitsPerPage` parameter. You can see the number of available pages in the `nbPages` response attribute. When `page` is null, the API response is not paginated.
   */
  page?: number;
  /**
   * Maximum number of hits per page.
   */
  hitsPerPage?: number;
};

/**
 * Properties for the `listUserIds` method.
 */
export type ListUserIdsProps = {
  /**
   * Returns the requested page number. The page size is determined by the `hitsPerPage` parameter. You can see the number of available pages in the `nbPages` response attribute. When `page` is null, the API response is not paginated.
   */
  page?: number;
  /**
   * Maximum number of hits per page.
   */
  hitsPerPage?: number;
};

/**
 * Properties for the `operationIndex` method.
 */
export type OperationIndexProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  operationIndexParams: OperationIndexParams;
};

/**
 * Properties for the `partialUpdateObject` method.
 */
export type PartialUpdateObjectProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique record (object) identifier.
   */
  objectID: string;
  /**
   * Object with attributes to update.
   */
  attributesToUpdate: Record<string, AttributeToUpdate>;
  /**
   * Indicates whether to create a new record if it doesn\'t exist yet.
   */
  createIfNotExists?: boolean;
};

/**
 * Properties for the `post` method.
 */
export type PostProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: Record<string, any>;
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

/**
 * Properties for the `put` method.
 */
export type PutProps = {
  /**
   * Path of the endpoint, anything after \"/1\" must be specified.
   */
  path: string;
  /**
   * Query parameters to apply to the current query.
   */
  parameters?: Record<string, any>;
  /**
   * Parameters to send with the custom request.
   */
  body?: Record<string, any>;
};

/**
 * Properties for the `removeUserId` method.
 */
export type RemoveUserIdProps = {
  /**
   * UserID to assign.
   */
  userID: string;
};

/**
 * Properties for the `replaceSources` method.
 */
export type ReplaceSourcesProps = {
  /**
   * Allowed sources.
   */
  source: Source[];
};

/**
 * Properties for the `restoreApiKey` method.
 */
export type RestoreApiKeyProps = {
  /**
   * API key.
   */
  key: string;
};

/**
 * Properties for the `saveObject` method.
 */
export type SaveObjectProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * The Algolia record.
   */
  body: Record<string, any>;
};

/**
 * Properties for the `saveRule` method.
 */
export type SaveRuleProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a rule object.
   */
  objectID: string;
  rule: Rule;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `saveRules` method.
 */
export type SaveRulesProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  rules: Rule[];
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
  /**
   * Indicates whether existing rules should be deleted before adding this batch.
   */
  clearExistingRules?: boolean;
};

/**
 * Properties for the `saveSynonym` method.
 */
export type SaveSynonymProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Unique identifier of a synonym object.
   */
  objectID: string;
  synonymHit: SynonymHit;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `saveSynonyms` method.
 */
export type SaveSynonymsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  synonymHit: SynonymHit[];
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
  /**
   * Indicates whether to replace all synonyms in the index with the ones sent with this request.
   */
  replaceExistingSynonyms?: boolean;
};

/**
 * In v4, the search parameters are wrapped in a `params` parameter.
 *
 * @deprecated The `search` method now accepts flat `searchParams` at the root of the method.
 */
type LegacySearchParams = {
  params?: SearchParamsObject;
};

/**
 * In v4, the search parameters are wrapped in a `params` parameter.
 *
 * @deprecated The `search` method now accepts flat `searchParams` at the root of the method.
 */
type LegacySearchForFacets = LegacySearchParams & SearchForFacetsOptions;

/**
 * In v4, the search parameters are wrapped in a `params` parameter.
 *
 * @deprecated The `search` method now accepts flat `searchParams` at the root of the method.
 */
type LegacySearchForHits = LegacySearchParams & SearchForHitsOptions;

type LegacySearchQuery = LegacySearchForFacets | LegacySearchForHits;

/**
 * Search method signature compatible with the `algoliasearch` v4 package. When using this signature, extra computation will be required to make it match the new signature.
 *
 * @deprecated This signature will be removed from the next major version, we recommend using the `SearchMethodParams` type for performances and future proof reasons.
 */
export type LegacySearchMethodProps = LegacySearchQuery[];

/**
 * Properties for the `searchDictionaryEntries` method.
 */
export type SearchDictionaryEntriesProps = {
  /**
   * Dictionary to search in.
   */
  dictionaryName: DictionaryType;
  searchDictionaryEntriesParams: SearchDictionaryEntriesParams;
};

/**
 * Properties for the `searchForFacetValues` method.
 */
export type SearchForFacetValuesProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Facet name.
   */
  facetName: string;
  searchForFacetValuesRequest?: SearchForFacetValuesRequest;
};

/**
 * Properties for the `searchRules` method.
 */
export type SearchRulesProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  searchRulesParams?: SearchRulesParams;
};

/**
 * Properties for the `searchSingleIndex` method.
 */
export type SearchSingleIndexProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  searchParams?: SearchParams;
};

/**
 * Properties for the `searchSynonyms` method.
 */
export type SearchSynonymsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  /**
   * Search for specific [types of synonyms](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#the-different-types-of-synonyms).
   */
  type?: SynonymType;
  /**
   * Returns the requested page number (the first page is 0). Page size is set by `hitsPerPage`. When null, there\'s no pagination.
   */
  page?: number;
  /**
   * Maximum number of hits per page.
   */
  hitsPerPage?: number;
  /**
   * Body of the `searchSynonyms` operation.
   */
  searchSynonymsParams?: SearchSynonymsParams;
};

/**
 * Properties for the `setSettings` method.
 */
export type SetSettingsProps = {
  /**
   * Index on which to perform the request.
   */
  indexName: string;
  indexSettings: IndexSettings;
  /**
   * Indicates whether changed index settings are forwarded to the replica indices.
   */
  forwardToReplicas?: boolean;
};

/**
 * Properties for the `updateApiKey` method.
 */
export type UpdateApiKeyProps = {
  /**
   * API key.
   */
  key: string;
  apiKey: ApiKey;
};

/**
 * The `browseObjects`, `browseRules`, `browseSynonyms` options.
 */
export type BrowseOptions<T> = Partial<
  Pick<CreateIterablePromise<T>, 'validate'>
> &
  Required<Pick<CreateIterablePromise<T>, 'aggregator'>>;

type WaitForOptions = Partial<{
  /**
   * The maximum number of retries. 50 by default.
   */
  maxRetries: number;

  /**
   * The function to decide how long to wait between retries.
   */
  timeout: (retryCount: number) => number;
}>;

export type WaitForTaskOptions = WaitForOptions & {
  /**
   * The `indexName` where the operation was performed.
   */
  indexName: string;
  /**
   * The `taskID` returned by the method response.
   */
  taskID: number;
};

export type WaitForApiKeyOptions = WaitForOptions & {
  /**
   * The API Key.
   */
  key: string;
} & (
    | {
        /**
         * The operation that has been performed, used to compute the stop condition.
         */
        operation: 'add' | 'delete';
        apiKey?: never;
      }
    | {
        /**
         * The operation that has been performed, used to compute the stop condition.
         */
        operation: 'update';
        /**
         * The updated fields, used to compute the stop condition.
         */
        apiKey: Partial<ApiKey>;
      }
  );
