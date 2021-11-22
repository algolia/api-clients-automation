import type { RequestOptions } from '../utils/types';

export * from './batchObject';
export * from './batchResponse';
export * from './errorBase';
export * from './highlightResult';
export * from './multipleQueries';
export * from './multipleQueriesObject';
export * from './multipleQueriesResponse';
export * from './operation';
export * from './rankingInfo';
export * from './rankingInfoMatchedGeoLocation';
export * from './record';
export * from './saveObjectResponse';
export * from './searchParams';
export * from './searchParamsString';
export * from './searchResponse';
export * from './searchResponseFacetsStats';
export * from './snippetResult';

import { BatchObject } from './batchObject';
import { BatchResponse } from './batchResponse';
import { ErrorBase } from './errorBase';
import { HighlightResult } from './highlightResult';
import { MultipleQueries } from './multipleQueries';
import { MultipleQueriesObject } from './multipleQueriesObject';
import { MultipleQueriesResponse } from './multipleQueriesResponse';
import { Operation } from './operation';
import { RankingInfo } from './rankingInfo';
import { RankingInfoMatchedGeoLocation } from './rankingInfoMatchedGeoLocation';
import { Record } from './record';
import { SaveObjectResponse } from './saveObjectResponse';
import { SearchParams } from './searchParams';
import { SearchParamsString } from './searchParamsString';
import { SearchResponse } from './searchResponse';
import { SearchResponseFacetsStats } from './searchResponseFacetsStats';
import { SnippetResult } from './snippetResult';

let primitives = ['string', 'boolean', 'double', 'integer', 'long', 'float', 'number', 'any'];

let enumsMap: { [index: string]: any } = {
  'HighlightResult.MatchLevelEnum': HighlightResult.MatchLevelEnum,
  'MultipleQueries.TypeEnum': MultipleQueries.TypeEnum,
  'MultipleQueriesObject.StrategyEnum': MultipleQueriesObject.StrategyEnum,
  'Operation.ActionEnum': Operation.ActionEnum,
  'SearchParams.TypoToleranceEnum': SearchParams.TypoToleranceEnum,
  'SearchParams.QueryTypeEnum': SearchParams.QueryTypeEnum,
  'SearchParams.RemoveWordsIfNoResultsEnum': SearchParams.RemoveWordsIfNoResultsEnum,
  'SearchParams.ExactOnSingleWordQueryEnum': SearchParams.ExactOnSingleWordQueryEnum,
  'SearchParams.AlternativesAsExactEnum': SearchParams.AlternativesAsExactEnum,
  'SearchParams.AdvancedSyntaxFeaturesEnum': SearchParams.AdvancedSyntaxFeaturesEnum,
  'SnippetResult.MatchLevelEnum': SnippetResult.MatchLevelEnum,
};

let typeMap: { [index: string]: any } = {
  BatchObject: BatchObject,
  BatchResponse: BatchResponse,
  ErrorBase: ErrorBase,
  HighlightResult: HighlightResult,
  MultipleQueries: MultipleQueries,
  MultipleQueriesObject: MultipleQueriesObject,
  MultipleQueriesResponse: MultipleQueriesResponse,
  Operation: Operation,
  RankingInfo: RankingInfo,
  RankingInfoMatchedGeoLocation: RankingInfoMatchedGeoLocation,
  Record: Record,
  SaveObjectResponse: SaveObjectResponse,
  SearchParams: SearchParams,
  SearchParamsString: SearchParamsString,
  SearchResponse: SearchResponse,
  SearchResponseFacetsStats: SearchResponseFacetsStats,
  SnippetResult: SnippetResult,
};

export class ObjectSerializer {
  public static findCorrectType(data: any, expectedType: string) {
    if (data == undefined) {
      return expectedType;
    } else if (primitives.indexOf(expectedType.toLowerCase()) !== -1) {
      return expectedType;
    } else if (expectedType === 'Date') {
      return expectedType;
    } else {
      if (enumsMap[expectedType]) {
        return expectedType;
      }

      if (!typeMap[expectedType]) {
        return expectedType; // w/e we don't know the type
      }

      // Check the discriminator
      let discriminatorProperty = typeMap[expectedType].discriminator;
      if (discriminatorProperty == null) {
        return expectedType; // the type does not have a discriminator. use it.
      } else {
        if (data[discriminatorProperty]) {
          var discriminatorType = data[discriminatorProperty];
          if (typeMap[discriminatorType]) {
            return discriminatorType; // use the type given in the discriminator
          } else {
            return expectedType; // discriminator did not map to a type
          }
        } else {
          return expectedType; // discriminator was not present (or an empty string)
        }
      }
    }
  }

  public static serialize(data: any, type: string) {
    if (data == undefined) {
      return data;
    } else if (primitives.indexOf(type.toLowerCase()) !== -1) {
      return data;
    } else if (type.lastIndexOf('Array<', 0) === 0) {
      // string.startsWith pre es6
      let subType: string = type.replace('Array<', ''); // Array<Type> => Type>
      subType = subType.substring(0, subType.length - 1); // Type> => Type
      let transformedData: any[] = [];
      for (let index = 0; index < data.length; index++) {
        let datum = data[index];
        transformedData.push(ObjectSerializer.serialize(datum, subType));
      }
      return transformedData;
    } else if (type === 'Date') {
      return data.toISOString();
    } else {
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
      let attributeTypes = typeMap[type].getAttributeTypeMap();
      let instance: { [index: string]: any } = {};
      for (let index = 0; index < attributeTypes.length; index++) {
        let attributeType = attributeTypes[index];
        instance[attributeType.baseName] = ObjectSerializer.serialize(
          data[attributeType.name],
          attributeType.type
        );
      }
      return instance;
    }
  }

  public static deserialize(data: any, type: string) {
    // polymorphism may change the actual type.
    type = ObjectSerializer.findCorrectType(data, type);
    if (data == undefined) {
      return data;
    } else if (primitives.indexOf(type.toLowerCase()) !== -1) {
      return data;
    } else if (type.lastIndexOf('Array<', 0) === 0) {
      // string.startsWith pre es6
      let subType: string = type.replace('Array<', ''); // Array<Type> => Type>
      subType = subType.substring(0, subType.length - 1); // Type> => Type
      let transformedData: any[] = [];
      for (let index = 0; index < data.length; index++) {
        let datum = data[index];
        transformedData.push(ObjectSerializer.deserialize(datum, subType));
      }
      return transformedData;
    } else if (type === 'Date') {
      return new Date(data);
    } else {
      if (enumsMap[type]) {
        // is Enum
        return data;
      }

      if (!typeMap[type]) {
        // dont know the type
        return data;
      }
      let instance = new typeMap[type]();
      let attributeTypes = typeMap[type].getAttributeTypeMap();
      for (let index = 0; index < attributeTypes.length; index++) {
        let attributeType = attributeTypes[index];
        instance[attributeType.name] = ObjectSerializer.deserialize(
          data[attributeType.baseName],
          attributeType.type
        );
      }
      return instance;
    }
  }
}

export interface Authentication {
  /**
   * Apply authentication settings to header and query params.
   */
  applyToRequest(requestOptions: RequestOptions): Promise<void> | void;
}

export class HttpBearerAuth implements Authentication {
  public accessToken: string | (() => string) = '';

  applyToRequest(requestOptions: RequestOptions): void {
    if (requestOptions && requestOptions.headers) {
      const accessToken =
        typeof this.accessToken === 'function' ? this.accessToken() : this.accessToken;
      requestOptions.headers['Authorization'] = 'Bearer ' + accessToken;
    }
  }
}

export class ApiKeyAuth implements Authentication {
  public apiKey: string = '';

  constructor(private location: string, private paramName: string) {}

  applyToRequest(requestOptions: RequestOptions): void {
    if (this.location == 'query') {
      requestOptions.queryParameters[this.paramName] = this.apiKey;
    } else if (this.location == 'header' && requestOptions && requestOptions.headers) {
      requestOptions.headers[this.paramName] = this.apiKey;
    } else if (this.location == 'cookie' && requestOptions && requestOptions.headers) {
      if (requestOptions.headers['Cookie']) {
        requestOptions.headers['Cookie'] +=
          '; ' + this.paramName + '=' + encodeURIComponent(this.apiKey);
      } else {
        requestOptions.headers['Cookie'] = this.paramName + '=' + encodeURIComponent(this.apiKey);
      }
    }
  }
}

export class OAuth implements Authentication {
  public accessToken: string = '';

  applyToRequest(requestOptions: RequestOptions): void {
    if (requestOptions && requestOptions.headers) {
      requestOptions.headers['Authorization'] = 'Bearer ' + this.accessToken;
    }
  }
}

export class VoidAuth implements Authentication {
  public username: string = '';
  public password: string = '';

  applyToRequest(_: RequestOptions): void {
    // Do nothing
  }
}

export type Interceptor = (requestOptions: RequestOptions) => Promise<void> | void;
