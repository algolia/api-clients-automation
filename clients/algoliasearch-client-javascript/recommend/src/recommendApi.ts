import { shuffle } from '../utils/helpers';
import { Transporter } from '../utils/Transporter';
import { Headers, Host, Request, RequestOptions } from '../utils/types';
import { Requester } from '../utils/Requester';

import { ErrorBase } from '../model/errorBase';
import { GetRecommendationsResponse } from '../model/getRecommendationsResponse';
import { RecommendationRequest } from '../model/recommendationRequest';
import { ApiKeyAuth } from '../model/models';

export enum RecommendApiKeys {
  apiKey,
  appId,
}

export class RecommendApi {
  private transporter: Transporter;

  protected authentications = {
    apiKey: new ApiKeyAuth('header', 'X-Algolia-API-Key'),
    appId: new ApiKeyAuth('header', 'X-Algolia-Application-Id'),
  };

  constructor(appId: string, apiKey: string, requester?: Requester) {
    this.setApiKey(RecommendApiKeys.appId, appId);
    this.setApiKey(RecommendApiKeys.apiKey, apiKey);
    this.transporter = new Transporter({
      hosts: (
        [
          { url: `${appId}-dsn.algolia.net`, accept: 'read', protocol: 'https' },
          { url: `${appId}.algolia.net`, accept: 'write', protocol: 'https' },
        ] as Host[]
      ).concat(
        shuffle([
          { url: `${appId}-1.algolianet.com`, accept: 'readWrite', protocol: 'https' },
          { url: `${appId}-2.algolianet.com`, accept: 'readWrite', protocol: 'https' },
          { url: `${appId}-3.algolianet.com`, accept: 'readWrite', protocol: 'https' },
        ])
      ),
      baseHeaders: {
        'content-type': 'application/x-www-form-urlencoded',
      },
      userAgent: 'Algolia for Javascript',
      timeouts: {
        connect: 2,
        read: 5,
        write: 30,
      },
      requester,
    });
  }

  public setApiKey(key: RecommendApiKeys, value: string) {
    this.authentications[RecommendApiKeys[key]].apiKey = value;
  }

  private async sendRequest<TResponse>(
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

  /**
   *
   * @summary Returns recommendations for a specific model and objectID
   * @param recommendationRequest
   */
  public async getRecommendations(
    recommendationRequest: Array<RecommendationRequest>
  ): Promise<GetRecommendationsResponse> {
    const path = '/1/indexes/*/recommendations';
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (recommendationRequest === null || recommendationRequest === undefined) {
      throw new Error(
        'Required parameter recommendationRequest was null or undefined when calling getRecommendations.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
      data: recommendationRequest,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters,
    };

    return this.sendRequest(request, requestOptions);
  }
}
