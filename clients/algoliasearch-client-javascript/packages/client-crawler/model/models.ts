import type * as fs from 'fs';

import type localVarRequest from 'request';

import { Action } from './action';
import { Config } from './config';
import { ConfigCache } from './configCache';
import { ConfigLogin } from './configLogin';
import { ConfigLoginBrowserRequest } from './configLoginBrowserRequest';
import { ConfigLoginBrowserRequestWaitTime } from './configLoginBrowserRequestWaitTime';
import { ConfigLoginFetchRequest } from './configLoginFetchRequest';
import { ConfigLoginFetchRequestRequestOptions } from './configLoginFetchRequestRequestOptions';
import { ConfigLoginFetchRequestRequestOptionsHeaders } from './configLoginFetchRequestRequestOptionsHeaders';
import { ConfigLoginOauthRequest } from './configLoginOauthRequest';
import { ConfigLoginOauthRequestAccessTokenRequest } from './configLoginOauthRequestAccessTokenRequest';
import { ConfigLoginOauthRequestAccessTokenRequestExtraParameters } from './configLoginOauthRequestAccessTokenRequestExtraParameters';
import { ConfigRequestOptions } from './configRequestOptions';
import { ConfigRequestOptionsHeaders } from './configRequestOptionsHeaders';
import { ConfigSafetyChecks } from './configSafetyChecks';
import { ConfigSafetyChecksBeforeIndexPublishing } from './configSafetyChecksBeforeIndexPublishing';
import { ErrorResponse } from './errorResponse';
import { ErrorResponseError } from './errorResponseError';
import { FunctionAsString } from './functionAsString';
import { GetActionResponse } from './getActionResponse';
import { GetCrawlerResponse } from './getCrawlerResponse';
import { GetCrawlerStatsResponse } from './getCrawlerStatsResponse';
import { InlineObject } from './inlineObject';
import { InlineObject1 } from './inlineObject1';
import { InlineObject2 } from './inlineObject2';
import { InlineResponse200 } from './inlineResponse200';
import { InlineResponse2001 } from './inlineResponse2001';
import { ListConfigVersionsResponse } from './listConfigVersionsResponse';
import { ModelError } from './modelError';
import { Pagination } from './pagination';
import { PatchCrawlerResponse } from './patchCrawlerResponse';
import { TestURLResponse } from './testURLResponse';
import { TestURLResponseError } from './testURLResponseError';
import { TestURLResponseRecords } from './testURLResponseRecords';
import { TestURLResponseRecordsPerExtractor } from './testURLResponseRecordsPerExtractor';
import { UrlsCrawledGroup } from './urlsCrawledGroup';

export * from './action';
export * from './config';
export * from './configCache';
export * from './configLogin';
export * from './configLoginBrowserRequest';
export * from './configLoginBrowserRequestWaitTime';
export * from './configLoginFetchRequest';
export * from './configLoginFetchRequestRequestOptions';
export * from './configLoginFetchRequestRequestOptionsHeaders';
export * from './configLoginOauthRequest';
export * from './configLoginOauthRequestAccessTokenRequest';
export * from './configLoginOauthRequestAccessTokenRequestExtraParameters';
export * from './configRequestOptions';
export * from './configRequestOptionsHeaders';
export * from './configSafetyChecks';
export * from './configSafetyChecksBeforeIndexPublishing';
export * from './errorResponse';
export * from './errorResponseError';
export * from './functionAsString';
export * from './getActionResponse';
export * from './getCrawlerResponse';
export * from './getCrawlerStatsResponse';
export * from './inlineObject';
export * from './inlineObject1';
export * from './inlineObject2';
export * from './inlineResponse200';
export * from './inlineResponse2001';
export * from './listConfigVersionsResponse';
export * from './modelError';
export * from './pagination';
export * from './patchCrawlerResponse';
export * from './testURLResponse';
export * from './testURLResponseError';
export * from './testURLResponseRecords';
export * from './testURLResponseRecordsPerExtractor';
export * from './urlsCrawledGroup';

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
  'FunctionAsString.TypeEnum': FunctionAsString.TypeEnum,
  'UrlsCrawledGroup.StatusEnum': UrlsCrawledGroup.StatusEnum,
  'UrlsCrawledGroup.CategoryEnum': UrlsCrawledGroup.CategoryEnum,
};

const typeMap: { [index: string]: any } = {
  Action,
  Config,
  ConfigCache,
  ConfigLogin,
  ConfigLoginBrowserRequest,
  ConfigLoginBrowserRequestWaitTime,
  ConfigLoginFetchRequest,
  ConfigLoginFetchRequestRequestOptions,
  ConfigLoginFetchRequestRequestOptionsHeaders,
  ConfigLoginOauthRequest,
  ConfigLoginOauthRequestAccessTokenRequest,
  ConfigLoginOauthRequestAccessTokenRequestExtraParameters,
  ConfigRequestOptions,
  ConfigRequestOptionsHeaders,
  ConfigSafetyChecks,
  ConfigSafetyChecksBeforeIndexPublishing,
  ErrorResponse,
  ErrorResponseError,
  FunctionAsString,
  GetActionResponse,
  GetCrawlerResponse,
  GetCrawlerStatsResponse,
  InlineObject,
  InlineObject1,
  InlineObject2,
  InlineResponse200,
  InlineResponse2001,
  ListConfigVersionsResponse,
  ModelError,
  Pagination,
  PatchCrawlerResponse,
  TestURLResponse,
  TestURLResponseError,
  TestURLResponseRecords,
  TestURLResponseRecordsPerExtractor,
  UrlsCrawledGroup,
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
