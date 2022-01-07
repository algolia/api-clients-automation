import type { EndRequest, Request, Response } from '../types';

import { Requester } from './Requester';

type AdditionalContent = {
  headers: Record<string, string>;
  searchParams: string | undefined;
  userAgent: string | undefined;
  connectTimeout: number;
  responseTimeout: number;
};

function searchParamsWithoutUA(params: URLSearchParams): string | undefined {
  let searchParams = '?';

  for (const [k, v] of params) {
    if (k === 'x-algolia-agent') {
      continue;
    }

    searchParams += encodeURI(`${k}=${v}&`);
  }

  if (searchParams === '?') {
    return undefined;
  }

  return searchParams.replace(/&$/, '');
}

export class EchoRequester extends Requester {
  constructor(private status = 200) {
    super();
  }

  send(
    { headers, url, connectTimeout, responseTimeout }: EndRequest,
    originalRequest: Request
  ): Promise<Response> {
    const urlSearchParams = new URL(url).searchParams;
    const userAgent = urlSearchParams.get('x-algolia-agent') || undefined;
    const additionalContent: AdditionalContent = {
      headers,
      connectTimeout,
      responseTimeout,
      userAgent: userAgent ? encodeURI(userAgent) : undefined,
      searchParams: searchParamsWithoutUA(urlSearchParams),
    };

    return Promise.resolve({
      content: JSON.stringify({ ...originalRequest, ...additionalContent }),
      isTimedOut: false,
      status: this.status,
    });
  }
}
