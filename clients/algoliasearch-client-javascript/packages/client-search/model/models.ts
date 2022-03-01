import type * as fs from 'fs';

import type localVarRequest from 'request';

import { Action } from './action';
import { AddApiKeyResponse } from './addApiKeyResponse';
import { Anchoring } from './anchoring';
import { ApiKey } from './apiKey';
import { AssignUserIdParams } from './assignUserIdParams';
import { AutomaticFacetFilter } from './automaticFacetFilter';
import { BaseBrowseResponse } from './baseBrowseResponse';
import { BaseIndexSettings } from './baseIndexSettings';
import { BaseSearchParams } from './baseSearchParams';
import { BaseSearchResponse } from './baseSearchResponse';
import { BaseSearchResponseFacetsStats } from './baseSearchResponseFacetsStats';
import { BatchAssignUserIdsParams } from './batchAssignUserIdsParams';
import { BatchDictionaryEntriesParams } from './batchDictionaryEntriesParams';
import { BatchDictionaryEntriesRequest } from './batchDictionaryEntriesRequest';
import { BatchParams } from './batchParams';
import { BatchResponse } from './batchResponse';
import { BatchWriteParams } from './batchWriteParams';
import { BrowseRequest } from './browseRequest';
import { BrowseResponse } from './browseResponse';
import { BuiltInOperation } from './builtInOperation';
import { Condition } from './condition';
import { Consequence } from './consequence';
import { ConsequenceHide } from './consequenceHide';
import { ConsequenceParams } from './consequenceParams';
import { CreatedAtObject } from './createdAtObject';
import { CreatedAtResponse } from './createdAtResponse';
import { DeleteApiKeyResponse } from './deleteApiKeyResponse';
import { DeleteSourceResponse } from './deleteSourceResponse';
import { DeletedAtResponse } from './deletedAtResponse';
import { DictionaryAction } from './dictionaryAction';
import { DictionaryEntry } from './dictionaryEntry';
import { DictionaryEntryState } from './dictionaryEntryState';
import { DictionaryLanguage } from './dictionaryLanguage';
import { DictionarySettingsParams } from './dictionarySettingsParams';
import { ErrorBase } from './errorBase';
import { GetDictionarySettingsResponse } from './getDictionarySettingsResponse';
import { GetLogsResponse } from './getLogsResponse';
import { GetLogsResponseInnerQueries } from './getLogsResponseInnerQueries';
import { GetLogsResponseLogs } from './getLogsResponseLogs';
import { GetObjectsParams } from './getObjectsParams';
import { GetObjectsResponse } from './getObjectsResponse';
import { GetTaskResponse } from './getTaskResponse';
import { GetTopUserIdsResponse } from './getTopUserIdsResponse';
import { HighlightResult } from './highlightResult';
import { Hit } from './hit';
import { IndexSettings } from './indexSettings';
import { IndexSettingsAsSearchParams } from './indexSettingsAsSearchParams';
import { Indice } from './indice';
import { Key } from './key';
import { Languages } from './languages';
import { ListApiKeysResponse } from './listApiKeysResponse';
import { ListClustersResponse } from './listClustersResponse';
import { ListIndicesResponse } from './listIndicesResponse';
import { ListUserIdsResponse } from './listUserIdsResponse';
import { MultipleBatchResponse } from './multipleBatchResponse';
import { MultipleGetObjectsParams } from './multipleGetObjectsParams';
import { MultipleQueries } from './multipleQueries';
import { MultipleQueriesParams } from './multipleQueriesParams';
import { MultipleQueriesResponse } from './multipleQueriesResponse';
import { MultipleQueriesStrategy } from './multipleQueriesStrategy';
import { MultipleQueriesType } from './multipleQueriesType';
import { Operation } from './operation';
import { OperationIndexParams } from './operationIndexParams';
import { OperationType } from './operationType';
import { Params } from './params';
import { Promote } from './promote';
import { RankingInfo } from './rankingInfo';
import { RankingInfoMatchedGeoLocation } from './rankingInfoMatchedGeoLocation';
import { RemoveUserIdResponse } from './removeUserIdResponse';
import { ReplaceSourceResponse } from './replaceSourceResponse';
import { RequiredSearchParams } from './requiredSearchParams';
import { Rule } from './rule';
import { SaveObjectResponse } from './saveObjectResponse';
import { SaveSynonymResponse } from './saveSynonymResponse';
import { ScopeType } from './scopeType';
import { SearchDictionaryEntriesParams } from './searchDictionaryEntriesParams';
import { SearchForFacetValuesRequest } from './searchForFacetValuesRequest';
import { SearchForFacetValuesResponse } from './searchForFacetValuesResponse';
import { SearchForFacetValuesResponseFacetHits } from './searchForFacetValuesResponseFacetHits';
import { SearchHits } from './searchHits';
import { SearchParams } from './searchParams';
import { SearchParamsObject } from './searchParamsObject';
import { SearchParamsString } from './searchParamsString';
import { SearchResponse } from './searchResponse';
import { SearchRulesParams } from './searchRulesParams';
import { SearchRulesResponse } from './searchRulesResponse';
import { SearchSynonymsResponse } from './searchSynonymsResponse';
import { SearchUserIdsParams } from './searchUserIdsParams';
import { SearchUserIdsResponse } from './searchUserIdsResponse';
import { SearchUserIdsResponseHighlightResult } from './searchUserIdsResponseHighlightResult';
import { SearchUserIdsResponseHits } from './searchUserIdsResponseHits';
import { SnippetResult } from './snippetResult';
import { Source } from './source';
import { StandardEntries } from './standardEntries';
import { SynonymHit } from './synonymHit';
import { SynonymHitHighlightResult } from './synonymHitHighlightResult';
import { SynonymType } from './synonymType';
import { TimeRange } from './timeRange';
import { UpdateApiKeyResponse } from './updateApiKeyResponse';
import { UpdatedAtResponse } from './updatedAtResponse';
import { UpdatedAtWithObjectIdResponse } from './updatedAtWithObjectIdResponse';
import { UpdatedRuleResponse } from './updatedRuleResponse';
import { UserId } from './userId';

export * from './action';
export * from './addApiKeyResponse';
export * from './anchoring';
export * from './apiKey';
export * from './assignUserIdParams';
export * from './automaticFacetFilter';
export * from './baseBrowseResponse';
export * from './baseIndexSettings';
export * from './baseSearchParams';
export * from './baseSearchResponse';
export * from './baseSearchResponseFacetsStats';
export * from './batchAssignUserIdsParams';
export * from './batchDictionaryEntriesParams';
export * from './batchDictionaryEntriesRequest';
export * from './batchParams';
export * from './batchResponse';
export * from './batchWriteParams';
export * from './browseRequest';
export * from './browseResponse';
export * from './builtInOperation';
export * from './condition';
export * from './consequence';
export * from './consequenceHide';
export * from './consequenceParams';
export * from './createdAtObject';
export * from './createdAtResponse';
export * from './deleteApiKeyResponse';
export * from './deleteSourceResponse';
export * from './deletedAtResponse';
export * from './dictionaryAction';
export * from './dictionaryEntry';
export * from './dictionaryEntryState';
export * from './dictionaryLanguage';
export * from './dictionarySettingsParams';
export * from './errorBase';
export * from './getDictionarySettingsResponse';
export * from './getLogsResponse';
export * from './getLogsResponseInnerQueries';
export * from './getLogsResponseLogs';
export * from './getObjectsParams';
export * from './getObjectsResponse';
export * from './getTaskResponse';
export * from './getTopUserIdsResponse';
export * from './highlightResult';
export * from './hit';
export * from './indexSettings';
export * from './indexSettingsAsSearchParams';
export * from './indice';
export * from './key';
export * from './languages';
export * from './listApiKeysResponse';
export * from './listClustersResponse';
export * from './listIndicesResponse';
export * from './listUserIdsResponse';
export * from './multipleBatchResponse';
export * from './multipleGetObjectsParams';
export * from './multipleQueries';
export * from './multipleQueriesParams';
export * from './multipleQueriesResponse';
export * from './multipleQueriesStrategy';
export * from './multipleQueriesType';
export * from './operation';
export * from './operationIndexParams';
export * from './operationType';
export * from './params';
export * from './promote';
export * from './rankingInfo';
export * from './rankingInfoMatchedGeoLocation';
export * from './removeUserIdResponse';
export * from './replaceSourceResponse';
export * from './requiredSearchParams';
export * from './rule';
export * from './saveObjectResponse';
export * from './saveSynonymResponse';
export * from './scopeType';
export * from './searchDictionaryEntriesParams';
export * from './searchForFacetValuesRequest';
export * from './searchForFacetValuesResponse';
export * from './searchForFacetValuesResponseFacetHits';
export * from './searchHits';
export * from './searchParams';
export * from './searchParamsObject';
export * from './searchParamsString';
export * from './searchResponse';
export * from './searchRulesParams';
export * from './searchRulesResponse';
export * from './searchSynonymsResponse';
export * from './searchUserIdsParams';
export * from './searchUserIdsResponse';
export * from './searchUserIdsResponseHighlightResult';
export * from './searchUserIdsResponseHits';
export * from './snippetResult';
export * from './source';
export * from './standardEntries';
export * from './synonymHit';
export * from './synonymHitHighlightResult';
export * from './synonymType';
export * from './timeRange';
export * from './updateApiKeyResponse';
export * from './updatedAtResponse';
export * from './updatedAtWithObjectIdResponse';
export * from './updatedRuleResponse';
export * from './userId';

export interface RequestDetailedFile {
  value: Buffer;
  options?: {
    filename?: string;
    contentType?: string;
  };
}

export type RequestFile = Buffer | fs.ReadStream | RequestDetailedFile | string;

/* tslint:disable:no-unused-variable */
const primitives = [
  'string',
  'boolean',
  'double',
  'integer',
  'long',
  'float',
  'number',
  'any',
];

const enumsMap: { [index: string]: any } = {
  Action,
  Anchoring,
  'ApiKey.AclEnum': ApiKey.AclEnum,
  'BuiltInOperation.OperationEnum': BuiltInOperation.OperationEnum,
  'ConsequenceParams.TypoToleranceEnum': ConsequenceParams.TypoToleranceEnum,
  'ConsequenceParams.QueryTypeEnum': ConsequenceParams.QueryTypeEnum,
  'ConsequenceParams.RemoveWordsIfNoResultsEnum':
    ConsequenceParams.RemoveWordsIfNoResultsEnum,
  'ConsequenceParams.ExactOnSingleWordQueryEnum':
    ConsequenceParams.ExactOnSingleWordQueryEnum,
  'ConsequenceParams.AlternativesAsExactEnum':
    ConsequenceParams.AlternativesAsExactEnum,
  'ConsequenceParams.AdvancedSyntaxFeaturesEnum':
    ConsequenceParams.AdvancedSyntaxFeaturesEnum,
  DictionaryAction,
  DictionaryEntryState,
  'GetTaskResponse.StatusEnum': GetTaskResponse.StatusEnum,
  'HighlightResult.MatchLevelEnum': HighlightResult.MatchLevelEnum,
  'IndexSettings.TypoToleranceEnum': IndexSettings.TypoToleranceEnum,
  'IndexSettings.QueryTypeEnum': IndexSettings.QueryTypeEnum,
  'IndexSettings.RemoveWordsIfNoResultsEnum':
    IndexSettings.RemoveWordsIfNoResultsEnum,
  'IndexSettings.ExactOnSingleWordQueryEnum':
    IndexSettings.ExactOnSingleWordQueryEnum,
  'IndexSettings.AlternativesAsExactEnum':
    IndexSettings.AlternativesAsExactEnum,
  'IndexSettings.AdvancedSyntaxFeaturesEnum':
    IndexSettings.AdvancedSyntaxFeaturesEnum,
  'IndexSettingsAsSearchParams.TypoToleranceEnum':
    IndexSettingsAsSearchParams.TypoToleranceEnum,
  'IndexSettingsAsSearchParams.QueryTypeEnum':
    IndexSettingsAsSearchParams.QueryTypeEnum,
  'IndexSettingsAsSearchParams.RemoveWordsIfNoResultsEnum':
    IndexSettingsAsSearchParams.RemoveWordsIfNoResultsEnum,
  'IndexSettingsAsSearchParams.ExactOnSingleWordQueryEnum':
    IndexSettingsAsSearchParams.ExactOnSingleWordQueryEnum,
  'IndexSettingsAsSearchParams.AlternativesAsExactEnum':
    IndexSettingsAsSearchParams.AlternativesAsExactEnum,
  'IndexSettingsAsSearchParams.AdvancedSyntaxFeaturesEnum':
    IndexSettingsAsSearchParams.AdvancedSyntaxFeaturesEnum,
  'Key.AclEnum': Key.AclEnum,
  MultipleQueriesStrategy,
  MultipleQueriesType,
  OperationType,
  ScopeType,
  'SearchParams.TypoToleranceEnum': SearchParams.TypoToleranceEnum,
  'SearchParams.QueryTypeEnum': SearchParams.QueryTypeEnum,
  'SearchParams.RemoveWordsIfNoResultsEnum':
    SearchParams.RemoveWordsIfNoResultsEnum,
  'SearchParams.ExactOnSingleWordQueryEnum':
    SearchParams.ExactOnSingleWordQueryEnum,
  'SearchParams.AlternativesAsExactEnum': SearchParams.AlternativesAsExactEnum,
  'SearchParams.AdvancedSyntaxFeaturesEnum':
    SearchParams.AdvancedSyntaxFeaturesEnum,
  'SearchParamsObject.TypoToleranceEnum': SearchParamsObject.TypoToleranceEnum,
  'SearchParamsObject.QueryTypeEnum': SearchParamsObject.QueryTypeEnum,
  'SearchParamsObject.RemoveWordsIfNoResultsEnum':
    SearchParamsObject.RemoveWordsIfNoResultsEnum,
  'SearchParamsObject.ExactOnSingleWordQueryEnum':
    SearchParamsObject.ExactOnSingleWordQueryEnum,
  'SearchParamsObject.AlternativesAsExactEnum':
    SearchParamsObject.AlternativesAsExactEnum,
  'SearchParamsObject.AdvancedSyntaxFeaturesEnum':
    SearchParamsObject.AdvancedSyntaxFeaturesEnum,
  'SnippetResult.MatchLevelEnum': SnippetResult.MatchLevelEnum,
  SynonymType,
};

const typeMap: { [index: string]: any } = {
  AddApiKeyResponse,
  ApiKey,
  AssignUserIdParams,
  AutomaticFacetFilter,
  BaseBrowseResponse,
  BaseIndexSettings,
  BaseSearchParams,
  BaseSearchResponse,
  BaseSearchResponseFacetsStats,
  BatchAssignUserIdsParams,
  BatchDictionaryEntriesParams,
  BatchDictionaryEntriesRequest,
  BatchParams,
  BatchResponse,
  BatchWriteParams,
  BrowseRequest,
  BrowseResponse,
  BuiltInOperation,
  Condition,
  Consequence,
  ConsequenceHide,
  ConsequenceParams,
  CreatedAtObject,
  CreatedAtResponse,
  DeleteApiKeyResponse,
  DeleteSourceResponse,
  DeletedAtResponse,
  DictionaryEntry,
  DictionaryLanguage,
  DictionarySettingsParams,
  ErrorBase,
  GetDictionarySettingsResponse,
  GetLogsResponse,
  GetLogsResponseInnerQueries,
  GetLogsResponseLogs,
  GetObjectsParams,
  GetObjectsResponse,
  GetTaskResponse,
  GetTopUserIdsResponse,
  HighlightResult,
  Hit,
  IndexSettings,
  IndexSettingsAsSearchParams,
  Indice,
  Key,
  Languages,
  ListApiKeysResponse,
  ListClustersResponse,
  ListIndicesResponse,
  ListUserIdsResponse,
  MultipleBatchResponse,
  MultipleGetObjectsParams,
  MultipleQueries,
  MultipleQueriesParams,
  MultipleQueriesResponse,
  Operation,
  OperationIndexParams,
  Params,
  Promote,
  RankingInfo,
  RankingInfoMatchedGeoLocation,
  RemoveUserIdResponse,
  ReplaceSourceResponse,
  RequiredSearchParams,
  Rule,
  SaveObjectResponse,
  SaveSynonymResponse,
  SearchDictionaryEntriesParams,
  SearchForFacetValuesRequest,
  SearchForFacetValuesResponse,
  SearchForFacetValuesResponseFacetHits,
  SearchHits,
  SearchParams,
  SearchParamsObject,
  SearchParamsString,
  SearchResponse,
  SearchRulesParams,
  SearchRulesResponse,
  SearchSynonymsResponse,
  SearchUserIdsParams,
  SearchUserIdsResponse,
  SearchUserIdsResponseHighlightResult,
  SearchUserIdsResponseHits,
  SnippetResult,
  Source,
  StandardEntries,
  SynonymHit,
  SynonymHitHighlightResult,
  TimeRange,
  UpdateApiKeyResponse,
  UpdatedAtResponse,
  UpdatedAtWithObjectIdResponse,
  UpdatedRuleResponse,
  UserId,
};

export class ObjectSerializer {
  static findCorrectType(data: any, expectedType: string) {
    if (data == undefined) {
      return expectedType;
    }
    if (primitives.indexOf(expectedType.toLowerCase()) !== -1) {
      return expectedType;
    }
    if (expectedType === 'Date') {
      return expectedType;
    }
    if (enumsMap[expectedType]) {
      return expectedType;
    }

    if (!typeMap[expectedType]) {
      return expectedType; // w/e we don't know the type
    }

    // Check the discriminator
    const discriminatorProperty = typeMap[expectedType].discriminator;
    if (discriminatorProperty == null) {
      return expectedType; // the type does not have a discriminator. use it.
    }
    if (data[discriminatorProperty]) {
      const discriminatorType = data[discriminatorProperty];
      if (typeMap[discriminatorType]) {
        return discriminatorType; // use the type given in the discriminator
      }
      return expectedType; // discriminator did not map to a type
    }
    return expectedType; // discriminator was not present (or an empty string)
  }

  static serialize(data: any, type: string) {
    if (data == undefined) {
      return data;
    }
    if (primitives.indexOf(type.toLowerCase()) !== -1) {
      return data;
    }
    if (type.lastIndexOf('Array<', 0) === 0) {
      // string.startsWith pre es6
      let subType: string = type.replace('Array<', ''); // Array<Type> => Type>
      subType = subType.substring(0, subType.length - 1); // Type> => Type
      const transformedData: any[] = [];
      for (let index = 0; index < data.length; index++) {
        const datum = data[index];
        transformedData.push(ObjectSerializer.serialize(datum, subType));
      }
      return transformedData;
    }
    if (type === 'Date') {
      return data.toISOString();
    }
    if (enumsMap[type]) {
      return data;
    }
    if (!typeMap[type]) {
      // in case we dont know the type
      return data;
    }

    // Get the actual type of this object
    type = this.findCorrectType(data, type);

    // get the map for the correct type.
    const attributeTypes = typeMap[type].getAttributeTypeMap();
    const instance: { [index: string]: any } = {};
    for (let index = 0; index < attributeTypes.length; index++) {
      const attributeType = attributeTypes[index];
      instance[attributeType.baseName] = ObjectSerializer.serialize(
        data[attributeType.name],
        attributeType.type
      );
    }
    return instance;
  }

  static deserialize(data: any, type: string) {
    // polymorphism may change the actual type.
    type = ObjectSerializer.findCorrectType(data, type);
    if (data == undefined) {
      return data;
    }
    if (primitives.indexOf(type.toLowerCase()) !== -1) {
      return data;
    }
    if (type.lastIndexOf('Array<', 0) === 0) {
      // string.startsWith pre es6
      let subType: string = type.replace('Array<', ''); // Array<Type> => Type>
      subType = subType.substring(0, subType.length - 1); // Type> => Type
      const transformedData: any[] = [];
      for (let index = 0; index < data.length; index++) {
        const datum = data[index];
        transformedData.push(ObjectSerializer.deserialize(datum, subType));
      }
      return transformedData;
    }
    if (type === 'Date') {
      return new Date(data);
    }
    if (enumsMap[type]) {
      // is Enum
      return data;
    }

    if (!typeMap[type]) {
      // dont know the type
      return data;
    }
    const instance = new typeMap[type]();
    const attributeTypes = typeMap[type].getAttributeTypeMap();
    for (let index = 0; index < attributeTypes.length; index++) {
      const attributeType = attributeTypes[index];
      instance[attributeType.name] = ObjectSerializer.deserialize(
        data[attributeType.baseName],
        attributeType.type
      );
    }
    return instance;
  }
}

export interface Authentication {
  /**
   * Apply authentication settings to header and query params.
   */
  applyToRequest: (
    requestOptions: localVarRequest.Options
  ) => Promise<void> | void;
}

export class HttpBasicAuth implements Authentication {
  username: string = '';
  password: string = '';

  applyToRequest(requestOptions: localVarRequest.Options): void {
    requestOptions.auth = {
      username: this.username,
      password: this.password,
    };
  }
}

export class HttpBearerAuth implements Authentication {
  accessToken: string | (() => string) = '';

  applyToRequest(requestOptions: localVarRequest.Options): void {
    if (requestOptions && requestOptions.headers) {
      const accessToken =
        typeof this.accessToken === 'function'
          ? this.accessToken()
          : this.accessToken;
      requestOptions.headers.Authorization = `Bearer ${accessToken}`;
    }
  }
}

export class ApiKeyAuth implements Authentication {
  apiKey: string = '';

  constructor(private location: string, private paramName: string) {}

  applyToRequest(requestOptions: localVarRequest.Options): void {
    if (this.location == 'query') {
      (<any>requestOptions.qs)[this.paramName] = this.apiKey;
    } else if (
      this.location == 'header' &&
      requestOptions &&
      requestOptions.headers
    ) {
      requestOptions.headers[this.paramName] = this.apiKey;
    } else if (
      this.location == 'cookie' &&
      requestOptions &&
      requestOptions.headers
    ) {
      if (requestOptions.headers.Cookie) {
        requestOptions.headers.Cookie += `; ${
          this.paramName
        }=${encodeURIComponent(this.apiKey)}`;
      } else {
        requestOptions.headers.Cookie = `${this.paramName}=${encodeURIComponent(
          this.apiKey
        )}`;
      }
    }
  }
}

export class OAuth implements Authentication {
  accessToken: string = '';

  applyToRequest(requestOptions: localVarRequest.Options): void {
    if (requestOptions && requestOptions.headers) {
      requestOptions.headers.Authorization = `Bearer ${this.accessToken}`;
    }
  }
}

export class VoidAuth implements Authentication {
  username: string = '';
  password: string = '';

  applyToRequest(_: localVarRequest.Options): void {
    // Do nothing
  }
}

export type Interceptor = (
  requestOptions: localVarRequest.Options
) => Promise<void> | void;
