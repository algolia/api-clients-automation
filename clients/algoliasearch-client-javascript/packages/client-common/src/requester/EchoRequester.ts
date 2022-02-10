import type { URLSearchParams } from 'url';
import { URL } from 'url';

import type { EndRequest, Request, Response, EchoResponse } from '../types';

import { Requester } from './Requester';

function searchParamsWithoutUA(
  params: URLSearchParams
): EchoResponse['searchParams'] {
  const searchParams = {};

  for (const [k, v] of params) {
    if (k === 'x-algolia-agent') {
      continue;
    }

    searchParams[k] = v;
  }

  return Object.entries(searchParams).length === 0 ? undefined : searchParams;
}

export class EchoRequester extends Requester {
  constructor(private status = 200) {
    super();
  }

  send(
    { headers, url, connectTimeout, responseTimeout }: EndRequest,
    { data, ...originalRequest }: Request
  ): Promise<Response> {
    const { host, searchParams: urlSearchParams } = new URL(url);
    const userAgent = urlSearchParams.get('x-algolia-agent') || undefined;
    const originalData =
      data && Object.entries(data).length > 0 ? data : undefined;

    return Promise.resolve({
      content: JSON.stringify({
        ...originalRequest,
        host,
        headers,
        connectTimeout,
        responseTimeout,
        userAgent: userAgent ? encodeURI(userAgent) : undefined,
        searchParams: searchParamsWithoutUA(urlSearchParams),
        data: originalData,
      }),
      isTimedOut: false,
      status: this.status,
    });
  }
}
