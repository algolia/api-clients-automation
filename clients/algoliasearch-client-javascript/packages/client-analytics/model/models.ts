import type * as fs from 'fs';

import type localVarRequest from 'request';

import { ErrorBase } from './errorBase';
import { GetAverageClickPositionResponse } from './getAverageClickPositionResponse';
import { GetAverageClickPositionResponseDates } from './getAverageClickPositionResponseDates';
import { GetClickPositionsResponse } from './getClickPositionsResponse';
import { GetClickPositionsResponsePositions } from './getClickPositionsResponsePositions';
import { GetClickThroughRateResponse } from './getClickThroughRateResponse';
import { GetClickThroughRateResponseDates } from './getClickThroughRateResponseDates';
import { GetConversationRateResponse } from './getConversationRateResponse';
import { GetConversationRateResponseDates } from './getConversationRateResponseDates';
import { GetNoClickRateResponse } from './getNoClickRateResponse';
import { GetNoClickRateResponseDates } from './getNoClickRateResponseDates';
import { GetNoResultsRateResponse } from './getNoResultsRateResponse';
import { GetNoResultsRateResponseDates } from './getNoResultsRateResponseDates';
import { GetSearchesCountResponse } from './getSearchesCountResponse';
import { GetSearchesCountResponseDates } from './getSearchesCountResponseDates';
import { GetSearchesNoClicksResponse } from './getSearchesNoClicksResponse';
import { GetSearchesNoClicksResponseSearches } from './getSearchesNoClicksResponseSearches';
import { GetSearchesNoResultsResponse } from './getSearchesNoResultsResponse';
import { GetSearchesNoResultsResponseSearches } from './getSearchesNoResultsResponseSearches';
import { GetStatusResponse } from './getStatusResponse';
import { GetTopCountriesResponse } from './getTopCountriesResponse';
import { GetTopCountriesResponseCountries } from './getTopCountriesResponseCountries';
import { GetTopFilterAttribute } from './getTopFilterAttribute';
import { GetTopFilterAttributesResponse } from './getTopFilterAttributesResponse';
import { GetTopFilterForAttribute } from './getTopFilterForAttribute';
import { GetTopFilterForAttributeResponse } from './getTopFilterForAttributeResponse';
import { GetTopFiltersNoResultsResponse } from './getTopFiltersNoResultsResponse';
import { GetTopFiltersNoResultsValue } from './getTopFiltersNoResultsValue';
import { GetTopFiltersNoResultsValues } from './getTopFiltersNoResultsValues';
import { GetTopHitsResponse } from './getTopHitsResponse';
import { GetTopHitsResponseHits } from './getTopHitsResponseHits';
import { GetTopHitsResponseWithAnalytics } from './getTopHitsResponseWithAnalytics';
import { GetTopHitsResponseWithAnalyticsHits } from './getTopHitsResponseWithAnalyticsHits';
import { GetTopSearchesResponse } from './getTopSearchesResponse';
import { GetTopSearchesResponseWithAnalytics } from './getTopSearchesResponseWithAnalytics';
import { GetTopSearchesResponseWithAnalyticsSearches } from './getTopSearchesResponseWithAnalyticsSearches';
import { GetUsersCountResponse } from './getUsersCountResponse';

export * from './errorBase';
export * from './getAverageClickPositionResponse';
export * from './getAverageClickPositionResponseDates';
export * from './getClickPositionsResponse';
export * from './getClickPositionsResponsePositions';
export * from './getClickThroughRateResponse';
export * from './getClickThroughRateResponseDates';
export * from './getConversationRateResponse';
export * from './getConversationRateResponseDates';
export * from './getNoClickRateResponse';
export * from './getNoClickRateResponseDates';
export * from './getNoResultsRateResponse';
export * from './getNoResultsRateResponseDates';
export * from './getSearchesCountResponse';
export * from './getSearchesCountResponseDates';
export * from './getSearchesNoClicksResponse';
export * from './getSearchesNoClicksResponseSearches';
export * from './getSearchesNoResultsResponse';
export * from './getSearchesNoResultsResponseSearches';
export * from './getStatusResponse';
export * from './getTopCountriesResponse';
export * from './getTopCountriesResponseCountries';
export * from './getTopFilterAttribute';
export * from './getTopFilterAttributesResponse';
export * from './getTopFilterForAttribute';
export * from './getTopFilterForAttributeResponse';
export * from './getTopFiltersNoResultsResponse';
export * from './getTopFiltersNoResultsValue';
export * from './getTopFiltersNoResultsValues';
export * from './getTopHitsResponse';
export * from './getTopHitsResponseHits';
export * from './getTopHitsResponseWithAnalytics';
export * from './getTopHitsResponseWithAnalyticsHits';
export * from './getTopSearchesResponse';
export * from './getTopSearchesResponseWithAnalytics';
export * from './getTopSearchesResponseWithAnalyticsSearches';
export * from './getUsersCountResponse';

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

const enumsMap: { [index: string]: any } = {};

const typeMap: { [index: string]: any } = {
  ErrorBase,
  GetAverageClickPositionResponse,
  GetAverageClickPositionResponseDates,
  GetClickPositionsResponse,
  GetClickPositionsResponsePositions,
  GetClickThroughRateResponse,
  GetClickThroughRateResponseDates,
  GetConversationRateResponse,
  GetConversationRateResponseDates,
  GetNoClickRateResponse,
  GetNoClickRateResponseDates,
  GetNoResultsRateResponse,
  GetNoResultsRateResponseDates,
  GetSearchesCountResponse,
  GetSearchesCountResponseDates,
  GetSearchesNoClicksResponse,
  GetSearchesNoClicksResponseSearches,
  GetSearchesNoResultsResponse,
  GetSearchesNoResultsResponseSearches,
  GetStatusResponse,
  GetTopCountriesResponse,
  GetTopCountriesResponseCountries,
  GetTopFilterAttribute,
  GetTopFilterAttributesResponse,
  GetTopFilterForAttribute,
  GetTopFilterForAttributeResponse,
  GetTopFiltersNoResultsResponse,
  GetTopFiltersNoResultsValue,
  GetTopFiltersNoResultsValues,
  GetTopHitsResponse,
  GetTopHitsResponseHits,
  GetTopHitsResponseWithAnalytics,
  GetTopHitsResponseWithAnalyticsHits,
  GetTopSearchesResponse,
  GetTopSearchesResponseWithAnalytics,
  GetTopSearchesResponseWithAnalyticsSearches,
  GetUsersCountResponse,
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
