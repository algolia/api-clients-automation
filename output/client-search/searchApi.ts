import localVarRequest from 'request';
import http from 'http';

import { BatchObject } from '../model/batchObject';
import { BatchResponse } from '../model/batchResponse';
import { MultipleQueriesObject } from '../model/multipleQueriesObject';
import { MultipleQueriesResponse } from '../model/multipleQueriesResponse';
import { SaveObjectResponse } from '../model/saveObjectResponse';
import { SearchParams } from '../model/searchParams';
import { SingleQueryResponse } from '../model/singleQueryResponse';

import { ObjectSerializer, Authentication, VoidAuth, Interceptor } from '../model/models';
import { HttpBasicAuth, HttpBearerAuth, ApiKeyAuth, OAuth } from '../model/models';

import { HttpError, RequestFile } from './apis';

let defaultBasePath = 'https://test-1.algolianet.com';

// ===============================================
// This file is autogenerated - Please do not edit
// ===============================================

export enum SearchApiApiKeys {
  apiKey,
  appId,
}

export class SearchApi {
  protected _basePath = defaultBasePath;
  protected _defaultHeaders: any = {};
  protected _useQuerystring: boolean = false;

  protected authentications = {
    default: <Authentication>new VoidAuth(),
    apiKey: new ApiKeyAuth('header', 'X-Algolia-API-Key'),
    appId: new ApiKeyAuth('header', 'X-Algolia-Application-Id'),
  };

  protected interceptors: Interceptor[] = [];

  constructor(appId: string, apiKey: string, basePath?: string) {
    this.setApiKey(SearchApiApiKeys.appId, appId);
    this.setApiKey(SearchApiApiKeys.apiKey, apiKey);
    this.basePath = 'https://' + appId + '-1.algolianet.com';

    if (basePath) {
      this.basePath = basePath;
    }
  }

  set useQuerystring(value: boolean) {
    this._useQuerystring = value;
  }

  set basePath(basePath: string) {
    this._basePath = basePath;
  }

  set defaultHeaders(defaultHeaders: any) {
    this._defaultHeaders = defaultHeaders;
  }

  get defaultHeaders() {
    return this._defaultHeaders;
  }

  get basePath() {
    return this._basePath;
  }

  public setDefaultAuthentication(auth: Authentication) {
    this.authentications.default = auth;
  }

  public setApiKey(key: SearchApiApiKeys, value: string) {
    (this.authentications as any)[SearchApiApiKeys[key]].apiKey = value;
  }

  public addInterceptor(interceptor: Interceptor) {
    this.interceptors.push(interceptor);
  }

  /**
   *
   * @summary Performs multiple write operations in a single API call
   * @param indexName The index in which to perform the request
   * @param batchObject
   */
  public async batch(
    indexName: string,
    batchObject: BatchObject,
    options: { headers: { [name: string]: string } } = { headers: {} }
  ): Promise<{ response: http.IncomingMessage; body: BatchResponse }> {
    const localVarPath =
      this.basePath +
      '/1/indexes/{indexName}/batch'.replace(
        '{' + 'indexName' + '}',
        encodeURIComponent(String(indexName))
      );
    let localVarQueryParameters: any = {};
    let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
    const produces = ['application/json'];
    // give precedence to 'application/json'
    if (produces.indexOf('application/json') >= 0) {
      localVarHeaderParams.Accept = 'application/json';
    } else {
      localVarHeaderParams.Accept = produces.join(',');
    }
    let localVarFormParams: any = {};

    // verify required parameter 'indexName' is not null or undefined
    if (indexName === null || indexName === undefined) {
      throw new Error('Required parameter indexName was null or undefined when calling batch.');
    }

    // verify required parameter 'batchObject' is not null or undefined
    if (batchObject === null || batchObject === undefined) {
      throw new Error('Required parameter batchObject was null or undefined when calling batch.');
    }

    (<any>Object).assign(localVarHeaderParams, options.headers);

    let localVarUseFormData = false;

    let localVarRequestOptions: localVarRequest.Options = {
      method: 'POST',
      qs: localVarQueryParameters,
      headers: localVarHeaderParams,
      uri: localVarPath,
      useQuerystring: this._useQuerystring,
      json: true,
      body: ObjectSerializer.serialize(batchObject, 'BatchObject'),
    };

    let authenticationPromise = Promise.resolve();
    if (this.authentications.apiKey.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.apiKey.applyToRequest(localVarRequestOptions)
      );
    }
    if (this.authentications.appId.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.appId.applyToRequest(localVarRequestOptions)
      );
    }
    authenticationPromise = authenticationPromise.then(() =>
      this.authentications.default.applyToRequest(localVarRequestOptions)
    );

    let interceptorPromise = authenticationPromise;
    for (const interceptor of this.interceptors) {
      interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
    }

    return interceptorPromise.then(() => {
      if (Object.keys(localVarFormParams).length) {
        if (localVarUseFormData) {
          (<any>localVarRequestOptions).formData = localVarFormParams;
        } else {
          localVarRequestOptions.form = localVarFormParams;
        }
      }
      return new Promise<{ response: http.IncomingMessage; body: BatchResponse }>(
        (resolve, reject) => {
          localVarRequest(localVarRequestOptions, (error, response, body) => {
            if (error) {
              reject(error);
            } else {
              body = ObjectSerializer.deserialize(body, 'BatchResponse');
              if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                resolve({ response: response, body: body });
              } else {
                reject(new HttpError(response, body, response.statusCode));
              }
            }
          });
        }
      );
    });
  }
  /**
   *
   * @summary Get search results for the given requests.
   * @param multipleQueriesObject
   */
  public async multipleQueries(
    multipleQueriesObject: MultipleQueriesObject,
    options: { headers: { [name: string]: string } } = { headers: {} }
  ): Promise<{ response: http.IncomingMessage; body: MultipleQueriesResponse }> {
    const localVarPath = this.basePath + '/1/indexes/*/queries';
    let localVarQueryParameters: any = {};
    let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
    const produces = ['application/json'];
    // give precedence to 'application/json'
    if (produces.indexOf('application/json') >= 0) {
      localVarHeaderParams.Accept = 'application/json';
    } else {
      localVarHeaderParams.Accept = produces.join(',');
    }
    let localVarFormParams: any = {};

    // verify required parameter 'multipleQueriesObject' is not null or undefined
    if (multipleQueriesObject === null || multipleQueriesObject === undefined) {
      throw new Error(
        'Required parameter multipleQueriesObject was null or undefined when calling multipleQueries.'
      );
    }

    (<any>Object).assign(localVarHeaderParams, options.headers);

    let localVarUseFormData = false;

    let localVarRequestOptions: localVarRequest.Options = {
      method: 'POST',
      qs: localVarQueryParameters,
      headers: localVarHeaderParams,
      uri: localVarPath,
      useQuerystring: this._useQuerystring,
      json: true,
      body: ObjectSerializer.serialize(multipleQueriesObject, 'MultipleQueriesObject'),
    };

    let authenticationPromise = Promise.resolve();
    if (this.authentications.apiKey.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.apiKey.applyToRequest(localVarRequestOptions)
      );
    }
    if (this.authentications.appId.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.appId.applyToRequest(localVarRequestOptions)
      );
    }
    authenticationPromise = authenticationPromise.then(() =>
      this.authentications.default.applyToRequest(localVarRequestOptions)
    );

    let interceptorPromise = authenticationPromise;
    for (const interceptor of this.interceptors) {
      interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
    }

    return interceptorPromise.then(() => {
      if (Object.keys(localVarFormParams).length) {
        if (localVarUseFormData) {
          (<any>localVarRequestOptions).formData = localVarFormParams;
        } else {
          localVarRequestOptions.form = localVarFormParams;
        }
      }
      return new Promise<{ response: http.IncomingMessage; body: MultipleQueriesResponse }>(
        (resolve, reject) => {
          localVarRequest(localVarRequestOptions, (error, response, body) => {
            if (error) {
              reject(error);
            } else {
              body = ObjectSerializer.deserialize(body, 'MultipleQueriesResponse');
              if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                resolve({ response: response, body: body });
              } else {
                reject(new HttpError(response, body, response.statusCode));
              }
            }
          });
        }
      );
    });
  }
  /**
   * Add an object to the index, automatically assigning it an object ID
   * @summary Save object
   * @param indexName The index in which to perform the request
   * @param requestBody
   */
  public async saveObject(
    indexName: string,
    requestBody: { [key: string]: object },
    options: { headers: { [name: string]: string } } = { headers: {} }
  ): Promise<{ response: http.IncomingMessage; body: SaveObjectResponse }> {
    const localVarPath =
      this.basePath +
      '/1/indexes/{indexName}'.replace(
        '{' + 'indexName' + '}',
        encodeURIComponent(String(indexName))
      );
    let localVarQueryParameters: any = {};
    let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
    const produces = ['application/json'];
    // give precedence to 'application/json'
    if (produces.indexOf('application/json') >= 0) {
      localVarHeaderParams.Accept = 'application/json';
    } else {
      localVarHeaderParams.Accept = produces.join(',');
    }
    let localVarFormParams: any = {};

    // verify required parameter 'indexName' is not null or undefined
    if (indexName === null || indexName === undefined) {
      throw new Error(
        'Required parameter indexName was null or undefined when calling saveObject.'
      );
    }

    // verify required parameter 'requestBody' is not null or undefined
    if (requestBody === null || requestBody === undefined) {
      throw new Error(
        'Required parameter requestBody was null or undefined when calling saveObject.'
      );
    }

    (<any>Object).assign(localVarHeaderParams, options.headers);

    let localVarUseFormData = false;

    let localVarRequestOptions: localVarRequest.Options = {
      method: 'POST',
      qs: localVarQueryParameters,
      headers: localVarHeaderParams,
      uri: localVarPath,
      useQuerystring: this._useQuerystring,
      json: true,
      body: ObjectSerializer.serialize(requestBody, '{ [key: string]: object; }'),
    };

    let authenticationPromise = Promise.resolve();
    if (this.authentications.apiKey.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.apiKey.applyToRequest(localVarRequestOptions)
      );
    }
    if (this.authentications.appId.apiKey) {
      authenticationPromise = authenticationPromise.then(() =>
        this.authentications.appId.applyToRequest(localVarRequestOptions)
      );
    }
    authenticationPromise = authenticationPromise.then(() =>
      this.authentications.default.applyToRequest(localVarRequestOptions)
    );

    let interceptorPromise = authenticationPromise;
    for (const interceptor of this.interceptors) {
      interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
    }

    return interceptorPromise.then(() => {
      if (Object.keys(localVarFormParams).length) {
        if (localVarUseFormData) {
          (<any>localVarRequestOptions).formData = localVarFormParams;
        } else {
          localVarRequestOptions.form = localVarFormParams;
        }
      }
      return new Promise<{ response: http.IncomingMessage; body: SaveObjectResponse }>(
        (resolve, reject) => {
          localVarRequest(localVarRequestOptions, (error, response, body) => {
            if (error) {
              reject(error);
            } else {
              body = ObjectSerializer.deserialize(body, 'SaveObjectResponse');
              if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                resolve({ response: response, body: body });
              } else {
                reject(new HttpError(response, body, response.statusCode));
              }
            }
          });
        }
      );
    });
  }
  /**
   *
   * @summary Get search results
   * @param xAlgoliaApplicationId Algolia appID
   * @param xAlgoliaAPIKey Algolia API key
   * @param indexName The index in which to perform the request
   * @param searchParams
   */
  public async search(
    xAlgoliaApplicationId: string,
    xAlgoliaAPIKey: string,
    indexName: string,
    searchParams: SearchParams,
    options: { headers: { [name: string]: string } } = { headers: {} }
  ): Promise<{ response: http.IncomingMessage; body: SingleQueryResponse }> {
    const localVarPath =
      this.basePath +
      '/1/indexes/{indexName}/query'.replace(
        '{' + 'indexName' + '}',
        encodeURIComponent(String(indexName))
      );
    let localVarQueryParameters: any = {};
    let localVarHeaderParams: any = (<any>Object).assign({}, this._defaultHeaders);
    const produces = ['application/json'];
    // give precedence to 'application/json'
    if (produces.indexOf('application/json') >= 0) {
      localVarHeaderParams.Accept = 'application/json';
    } else {
      localVarHeaderParams.Accept = produces.join(',');
    }
    let localVarFormParams: any = {};

    // verify required parameter 'xAlgoliaApplicationId' is not null or undefined
    if (xAlgoliaApplicationId === null || xAlgoliaApplicationId === undefined) {
      throw new Error(
        'Required parameter xAlgoliaApplicationId was null or undefined when calling search.'
      );
    }

    // verify required parameter 'xAlgoliaAPIKey' is not null or undefined
    if (xAlgoliaAPIKey === null || xAlgoliaAPIKey === undefined) {
      throw new Error(
        'Required parameter xAlgoliaAPIKey was null or undefined when calling search.'
      );
    }

    // verify required parameter 'indexName' is not null or undefined
    if (indexName === null || indexName === undefined) {
      throw new Error('Required parameter indexName was null or undefined when calling search.');
    }

    // verify required parameter 'searchParams' is not null or undefined
    if (searchParams === null || searchParams === undefined) {
      throw new Error('Required parameter searchParams was null or undefined when calling search.');
    }

    localVarHeaderParams['X-Algolia-Application-Id'] = ObjectSerializer.serialize(
      xAlgoliaApplicationId,
      'string'
    );
    localVarHeaderParams['X-Algolia-API-Key'] = ObjectSerializer.serialize(
      xAlgoliaAPIKey,
      'string'
    );
    (<any>Object).assign(localVarHeaderParams, options.headers);

    let localVarUseFormData = false;

    let localVarRequestOptions: localVarRequest.Options = {
      method: 'POST',
      qs: localVarQueryParameters,
      headers: localVarHeaderParams,
      uri: localVarPath,
      useQuerystring: this._useQuerystring,
      json: true,
      body: ObjectSerializer.serialize(searchParams, 'SearchParams'),
    };

    let authenticationPromise = Promise.resolve();
    authenticationPromise = authenticationPromise.then(() =>
      this.authentications.default.applyToRequest(localVarRequestOptions)
    );

    let interceptorPromise = authenticationPromise;
    for (const interceptor of this.interceptors) {
      interceptorPromise = interceptorPromise.then(() => interceptor(localVarRequestOptions));
    }

    return interceptorPromise.then(() => {
      if (Object.keys(localVarFormParams).length) {
        if (localVarUseFormData) {
          (<any>localVarRequestOptions).formData = localVarFormParams;
        } else {
          localVarRequestOptions.form = localVarFormParams;
        }
      }
      return new Promise<{ response: http.IncomingMessage; body: SingleQueryResponse }>(
        (resolve, reject) => {
          localVarRequest(localVarRequestOptions, (error, response, body) => {
            if (error) {
              reject(error);
            } else {
              body = ObjectSerializer.deserialize(body, 'SingleQueryResponse');
              if (response.statusCode && response.statusCode >= 200 && response.statusCode <= 299) {
                resolve({ response: response, body: body });
              } else {
                reject(new HttpError(response, body, response.statusCode));
              }
            }
          });
        }
      );
    });
  }
}
