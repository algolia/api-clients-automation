import type { ConfigLoginOauthRequestAccessTokenRequestExtraParameters } from './configLoginOauthRequestAccessTokenRequestExtraParameters';

export type ConfigLoginOauthRequestAccessTokenRequest = {
  url: string;
  grant_type: string;
  client_id: string;
  client_secret?: string;
  scope?: string;
  extraParameters?: ConfigLoginOauthRequestAccessTokenRequestExtraParameters;
};
