import { shuffle } from '../utils/helpers';
import { Transporter } from '../utils/Transporter'; 
import { Headers, Host, Request, RequestOptions } from '../utils/types';
import { Requester } from '../utils/requester/Requester';

import { ErrorBase } from '../model/errorBase';
import { PostUrlResponse } from '../model/postUrlResponse';


export class SourcesApi {
  protected authentications = {
    apiKey: 'Algolia-API-Key',
    appId: 'Algolia-Application-Id',
  };

  private transporter: Transporter;

  private applyAuthenticationHeaders(
    requestOptions: RequestOptions
  ): RequestOptions {
    if (requestOptions?.headers) {
      return {
        ...requestOptions,
        headers: {
          ...requestOptions.headers,
          'X-Algolia-API-Key': this.authentications.apiKey,
          'X-Algolia-Application-Id': this.authentications.appId,
        },
      };
    }

    return requestOptions;
  }
  
  private sendRequest<TResponse>(
    request: Request,
    requestOptions: RequestOptions
  ): Promise<TResponse> {
    return this.transporter.request(
      request,
      this.applyAuthenticationHeaders(requestOptions)
    );
  }

  constructor(
      appId: string,
      apiKey: string,
        region:  | 'us',
      options?: {requester?: Requester, hosts?: Host[]}
    ) {
    this.setAuthentication({ appId, apiKey });

    this.transporter = new Transporter({
      hosts: options?.hosts ?? this.getDefaultHosts(
        
        region
    ),
      baseHeaders: {
        'content-type': 'application/x-www-form-urlencoded'
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


    public getDefaultHosts(region:  | 'us' = 'us'): Host[] {
      return [{ url: `.${region}.algolia.com`, accept: 'readWrite', protocol: 'https' }];
    }


  public setRequest(requester: Requester): void {
    this.transporter.setRequester(requester);
  }

  public setHosts(hosts: Host[]): void {
    this.transporter.setHosts(hosts);
  }

  public setAuthentication({ appId, apiKey }): void {
    this.authentications = {
      apiKey,
      appId,
    };
  }

  /**
  * Add an ingestion job that will fetch data from an URL.
  * @summary Create a new ingestion job via URL.
      * @param postUrl - The postUrl object.
          * @param postUrl.index The index name to target.
  */
  public postUrl(
        {
            index,
        }: PostUrlProps
      ) : Promise<PostUrlResponse> {
    const path = '/1/ingest/url';
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (index === null || index === undefined) {
      throw new Error('Required parameter index was null or undefined when calling postUrl.');
    }


    if (index !== undefined) {
      queryParameters['index'] = index.toString();
    }


    const request: Request = {
      method: 'POST',
      path,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters
    };

    return this.sendRequest(request, requestOptions);
  }
}

export type PostUrlProps = {
    /**
    * The index name to target.
    */
    index: string;
}


