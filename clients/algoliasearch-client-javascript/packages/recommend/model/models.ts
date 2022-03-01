import type * as fs from 'fs';

import type localVarRequest from 'request';

import { BaseSearchParams } from './baseSearchParams';
import { BaseSearchResponse } from './baseSearchResponse';
import { BaseSearchResponseFacetsStats } from './baseSearchResponseFacetsStats';
import { ErrorBase } from './errorBase';
import { GetRecommendationsParams } from './getRecommendationsParams';
import { GetRecommendationsResponse } from './getRecommendationsResponse';
import { HighlightResult } from './highlightResult';
import { IndexSettingsAsSearchParams } from './indexSettingsAsSearchParams';
import { RankingInfo } from './rankingInfo';
import { RankingInfoMatchedGeoLocation } from './rankingInfoMatchedGeoLocation';
import { RecommendHit } from './recommendHit';
import { RecommendHits } from './recommendHits';
import { RecommendationRequest } from './recommendationRequest';
import { RecommendationsResponse } from './recommendationsResponse';
import { RequiredSearchParams } from './requiredSearchParams';
import { SearchParams } from './searchParams';
import { SnippetResult } from './snippetResult';

export * from './baseSearchParams';
export * from './baseSearchResponse';
export * from './baseSearchResponseFacetsStats';
export * from './errorBase';
export * from './getRecommendationsParams';
export * from './getRecommendationsResponse';
export * from './highlightResult';
export * from './indexSettingsAsSearchParams';
export * from './rankingInfo';
export * from './rankingInfoMatchedGeoLocation';
export * from './recommendHit';
export * from './recommendHits';
export * from './recommendationRequest';
export * from './recommendationsResponse';
export * from './requiredSearchParams';
export * from './searchParams';
export * from './snippetResult';

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
  'HighlightResult.MatchLevelEnum': HighlightResult.MatchLevelEnum,
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
  'RecommendationRequest.ModelEnum': RecommendationRequest.ModelEnum,
  'SearchParams.TypoToleranceEnum': SearchParams.TypoToleranceEnum,
  'SearchParams.QueryTypeEnum': SearchParams.QueryTypeEnum,
  'SearchParams.RemoveWordsIfNoResultsEnum':
    SearchParams.RemoveWordsIfNoResultsEnum,
  'SearchParams.ExactOnSingleWordQueryEnum':
    SearchParams.ExactOnSingleWordQueryEnum,
  'SearchParams.AlternativesAsExactEnum': SearchParams.AlternativesAsExactEnum,
  'SearchParams.AdvancedSyntaxFeaturesEnum':
    SearchParams.AdvancedSyntaxFeaturesEnum,
  'SnippetResult.MatchLevelEnum': SnippetResult.MatchLevelEnum,
};

const typeMap: { [index: string]: any } = {
  BaseSearchParams,
  BaseSearchResponse,
  BaseSearchResponseFacetsStats,
  ErrorBase,
  GetRecommendationsParams,
  GetRecommendationsResponse,
  HighlightResult,
  IndexSettingsAsSearchParams,
  RankingInfo,
  RankingInfoMatchedGeoLocation,
  RecommendHit,
  RecommendHits,
  RecommendationRequest,
  RecommendationsResponse,
  RequiredSearchParams,
  SearchParams,
  SnippetResult,
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
