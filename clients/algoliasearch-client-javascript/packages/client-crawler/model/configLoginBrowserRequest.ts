import type { ConfigLoginBrowserRequestWaitTime } from './configLoginBrowserRequestWaitTime';

export type ConfigLoginBrowserRequest = {
  url: string;
  username: string;
  password: string;
  waitTime?: ConfigLoginBrowserRequestWaitTime;
};
