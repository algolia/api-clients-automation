import type { ConfigLoginBrowserRequest } from './configLoginBrowserRequest';
import type { ConfigLoginFetchRequest } from './configLoginFetchRequest';
import type { ConfigLoginOauthRequest } from './configLoginOauthRequest';

/**
 * This property can be set in order to define how the Crawler should login to the website before crawling pages. The Crawler will then extract the `Set-Cookie` response header from the login page and send that Cookie when crawling all pages of the website defined in the configuration.
 */
export type ConfigLogin = {
  fetchRequest?: ConfigLoginFetchRequest;
  browserRequest?: ConfigLoginBrowserRequest;
  oauthRequest?: ConfigLoginOauthRequest;
};
