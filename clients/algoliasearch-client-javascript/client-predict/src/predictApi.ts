import { shuffle, Transporter } from '@algolia/client-common';
import type { Headers, Requester, Host, Request, RequestOptions } from '@algolia/client-common';

import { ErrorBase } from '../model/errorBase';
import { FetchUserProfileResponse } from '../model/fetchUserProfileResponse';
import { InlineObject } from '../model/inlineObject';

export const version = '5.0.0';


export class PredictApi {
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
      options?: {requester?: Requester, hosts?: Host[]}
    ) {
    if (!appId) {
      throw new Error("`appId` is missing.");
    }
    if (!apiKey) {
      throw new Error("`apiKey` is missing.");
    }

    this.setAuthentication({ appId, apiKey });

    this.transporter = new Transporter({
      hosts: options?.hosts ?? this.getDefaultHosts(
        
        
    ),
      baseHeaders: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      userAgent: 'Algolia for Javascript (5.0.0)',
      timeouts: {
        connect: 2,
        read: 5,
        write: 30,
      },
      requester: options?.requester,
    });
  }



    public getDefaultHosts(): Host[] {
      return [{ url: 'predict.algolia.io', accept: 'readWrite', protocol: 'https' }];
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
  * Get predictions, properties (raw, computed or custom) and segments (computed or custom) for an authenticated user (userID) or an anonymous user (cookieID).  The predictions can be goals, metrics or affinities:  * **Goals** ML models compute the probability for an action. Ex. A funnel stage model can output the next stage in the user conversion funnel - add_to_cart with a probability of 72%. * **Metrics** ML models output a number. Ex. Next order value is 172.43 USD. Since metrics models are usually based on regression, these predictions have a single value without a probability attached to it. * **Affinities** ML models output a set of item attributes with associated probabilities. Ex. a user is interested in items with the following characteristics: *color: red* (56% probability), *brand: Adidas* (67% probability).  The usage of segments for a user profile assumes that actions are implemented in a website or app and can be triggered when a segment is identified: *if segment1 in user_segments then do action*. For example, a segment can represent users that are close to churning and the action can be offering them an incentive such as a discount code or free shipping. 
  * @summary Get user profile
          * @param fetchUserProfile - The fetchUserProfile object.
              * @param fetchUserProfile.userID This parameter can have different values: * An user ID for authenticated users. * A cookie ID for non-authenticated repeated users (visitors) 
              * @param fetchUserProfile.inlineObject The inlineObject object.
  */
  public fetchUserProfile(
            {
                userID,
                inlineObject,
            }: FetchUserProfileProps
      ) : Promise<FetchUserProfileResponse> {
    const path = '/1/users/{userID}/fetch'.replace(
      '{userID}',
      encodeURIComponent(String(userID))
    );
    let headers: Headers = { Accept: 'application/json' };
    let queryParameters: Record<string, string> = {};

    if (!userID) {
      throw new Error('Parameter `userID` is required when calling `fetchUserProfile`.');
    }


    if (!inlineObject) {
      throw new Error('Parameter `inlineObject` is required when calling `fetchUserProfile`.');
    }



    const request: Request = {
      method: 'POST',
      path,
      data: inlineObject,
    };

    const requestOptions: RequestOptions = {
      headers,
      queryParameters
    };

    return this.sendRequest(request, requestOptions);
  }
}

export type FetchUserProfileProps = {
    /**
    * This parameter can have different values: * An user ID for authenticated users. * A cookie ID for non-authenticated repeated users (visitors) 
    */
    userID: string;
    inlineObject: InlineObject;
}


