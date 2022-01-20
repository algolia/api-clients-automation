import type { PostUrlResponse } from '../model/postUrlResponse';
import type { URLJob } from '../model/uRLJob';
import { Transporter } from '../utils/Transporter';
import type { Requester } from '../utils/requester/Requester';
import type { Headers, Host, Request, RequestOptions } from '../utils/types';

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
    region: 'us',
    options?: { requester?: Requester; hosts?: Host[] }
  ) {
    this.setAuthentication({ appId, apiKey });

    this.transporter = new Transporter({
      hosts: options?.hosts ?? this.getDefaultHosts(region),
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

  getDefaultHosts(region: 'us' = 'us'): Host[] {
    return [
      {
        url: `data.${region}.algolia.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
    ];
  }

  setRequest(requester: Requester): void {
    this.transporter.setRequester(requester);
  }

  setHosts(hosts: Host[]): void {
    this.transporter.setHosts(hosts);
  }

  setAuthentication({ appId, apiKey }): void {
    this.authentications = {
      apiKey,
      appId,
    };
  }

  /**
   * Add an ingestion job that will fetch data from an URL.
   *
   * @summary Create a new ingestion job via URL.
   * @param uRLJob - The uRLJob object.
   */
  postUrl(uRLJob: URLJob): Promise<PostUrlResponse> {
    const path = '/1/ingest/url';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (uRLJob === null || uRLJob === undefined) {
      throw new Error(
        'Required parameter uRLJob was null or undefined when calling postUrl.'
      );
    }

    if (uRLJob.type === null || uRLJob.type === undefined) {
      throw new Error(
        'Required parameter uRLJob.type was null or undefined when calling postUrl.'
      );
    }
    if (uRLJob.input === null || uRLJob.input === undefined) {
      throw new Error(
        'Required parameter uRLJob.input was null or undefined when calling postUrl.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: uRLJob,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}
