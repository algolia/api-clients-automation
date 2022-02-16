import { Transporter, createAuth, getUserAgent } from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  Request,
} from '@algolia/client-common';

import type { InlineObject } from '../model/inlineObject';
import type { InlineObject1 } from '../model/inlineObject1';
import type { InlineObject2 } from '../model/inlineObject2';
import type { InlineObject3 } from '../model/inlineObject3';
import type { InlineResponse200 } from '../model/inlineResponse200';
import type { InlineResponse2001 } from '../model/inlineResponse2001';
import type { InlineResponse2002 } from '../model/inlineResponse2002';
import type { InlineResponse2003 } from '../model/inlineResponse2003';
import type { InlineResponse2004 } from '../model/inlineResponse2004';
import type { InlineResponse2005 } from '../model/inlineResponse2005';
import type { InlineResponse2006 } from '../model/inlineResponse2006';
import type { Pagination } from '../model/pagination';

export const version = '0.0.1';

function getDefaultHosts(): Host[] {
  return [
    { url: 'crawler.algolia.com', accept: 'readWrite', protocol: 'https' },
  ];
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export const createCrawlerApi = (options: CreateClientOptions) => {
  const auth = createAuth(options.appId, options.apiKey, options.authMode);
  const transporter = new Transporter({
    hosts: options?.hosts ?? getDefaultHosts(),
    baseHeaders: {
      'content-type': 'application/x-www-form-urlencoded',
      ...auth.headers(),
    },
    baseQueryParameters: auth.queryParameters(),
    userAgent: getUserAgent({
      userAgents: options.userAgents,
      client: 'Crawler',
      version,
    }),
    timeouts: options.timeouts,
    requester: options.requester,
  });

  /**
   * TODO: complete.
   *
   * @summary Cancel a blocking action on your Crawler.
   * @param cancelAction - The cancelAction object.
   * @param cancelAction.id - The Id of the targeted Crawler.
   * @param cancelAction.tid - The Id of the targeted Task.
   */
  function cancelAction({
    id,
    tid,
  }: CancelActionProps): Promise<{ [key: string]: Record<string, any> }> {
    const path = '/crawlers/{id}/tasks/{tid}/cancel'
      .replace('{id}', encodeURIComponent(String(id)))
      .replace('{tid}', encodeURIComponent(String(tid)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `cancelAction`.'
      );
    }

    if (!tid) {
      throw new Error(
        'Parameter `tid` is required when calling `cancelAction`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * The passed URLs will be crawled immediately, and the generated records will be pushed to the live index if no reindex is currently running. If a reindex is running, the records will be pushed to the temporary index.
   *
   * @summary Immediately crawl some URLs and update the live index.
   * @param createCrawl - The createCrawl object.
   * @param createCrawl.id - The Id of the targeted Crawler.
   * @param createCrawl.inlineObject3 - The inlineObject3 object.
   */
  function createCrawl({
    id,
    inlineObject3,
  }: CreateCrawlProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}/urls/crawl'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `createCrawl`.');
    }

    const request: Request = {
      method: 'POST',
      path,
      data: inlineObject3,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Create a new Crawler with the given config.
   * @param inlineObject - The inlineObject object.
   */
  function createCrawler(
    inlineObject: InlineObject
  ): Promise<InlineResponse200> {
    const path = '/crawlers';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    const request: Request = {
      method: 'POST',
      path,
      data: inlineObject,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Get the status of a specific task.
   * @param getAction - The getAction object.
   * @param getAction.id - The Id of the targeted Crawler.
   * @param getAction.tid - The Id of the targeted Task.
   */
  function getAction({ id, tid }: GetActionProps): Promise<InlineResponse2005> {
    const path = '/crawlers/{id}/tasks/{tid}'
      .replace('{id}', encodeURIComponent(String(id)))
      .replace('{tid}', encodeURIComponent(String(tid)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `getAction`.');
    }

    if (!tid) {
      throw new Error('Parameter `tid` is required when calling `getAction`.');
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary List crawler versions.
   * @param getConfigVersion - The getConfigVersion object.
   * @param getConfigVersion.id - The Id of the targeted Crawler.
   * @param getConfigVersion.version - The version of the targeted Crawler revision.
   * @param getConfigVersion.itemsPerPage - Change the number of versions per page.
   * @param getConfigVersion.page - Change the page number.
   */
  function getConfigVersion({
    id,
    version,
    itemsPerPage,
    page,
  }: GetConfigVersionProps): Promise<Pagination & Record<string, any>> {
    const path = '/crawlers/{id}/config/versions/{version}'
      .replace('{id}', encodeURIComponent(String(id)))
      .replace('{version}', encodeURIComponent(String(version)));
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `getConfigVersion`.'
      );
    }

    if (!version) {
      throw new Error(
        'Parameter `version` is required when calling `getConfigVersion`.'
      );
    }

    if (itemsPerPage !== undefined) {
      queryParameters.itemsPerPage = itemsPerPage.toString();
    }

    if (page !== undefined) {
      queryParameters.page = page.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Get information about the specified Crawler and its configuration.
   * @param getCrawler - The getCrawler object.
   * @param getCrawler.id - The Id of the targeted Crawler.
   * @param getCrawler.withConfig - Whether or not the configuration should be returned in the response (in the \'config\' field).
   */
  function getCrawler({
    id,
    withConfig,
  }: GetCrawlerProps): Promise<InlineResponse2001> {
    const path = '/crawlers/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `getCrawler`.');
    }

    if (withConfig !== undefined) {
      queryParameters.withConfig = withConfig.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Get a summary of the current status of crawled URLs for the specified Crawler.
   * @param getCrawlerStats - The getCrawlerStats object.
   * @param getCrawlerStats.id - The Id of the targeted Crawler.
   */
  function getCrawlerStats({
    id,
  }: GetCrawlerStatsProps): Promise<InlineResponse2003> {
    const path = '/crawlers/{id}/stats/urls'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `getCrawlerStats`.'
      );
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Get a specific version of the configuration of a crawler.
   * @param listConfigVersions - The listConfigVersions object.
   * @param listConfigVersions.id - The Id of the targeted Crawler.
   */
  function listConfigVersions({
    id,
  }: ListConfigVersionsProps): Promise<InlineResponse2006> {
    const path = '/crawlers/{id}/config/versions'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `listConfigVersions`.'
      );
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary List available Crawlers.
   * @param listCrawlers - The listCrawlers object.
   * @param listCrawlers.itemsPerPage - Change the number of items per page.
   * @param listCrawlers.page - Change the page number.
   * @param listCrawlers.name - Filter by crawler name.
   * @param listCrawlers.appId - Filter by Application ID.
   */
  function listCrawlers({
    itemsPerPage,
    page,
    name,
    appId,
  }: ListCrawlersProps): Promise<Pagination & Record<string, any>> {
    const path = '/crawlers';
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (itemsPerPage !== undefined) {
      queryParameters.itemsPerPage = itemsPerPage.toString();
    }

    if (page !== undefined) {
      queryParameters.page = page.toString();
    }

    if (name !== undefined) {
      queryParameters.name = name.toString();
    }

    if (appId !== undefined) {
      queryParameters.appId = appId.toString();
    }

    const request: Request = {
      method: 'GET',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Update parts of the Crawler configuration.
   * @param patchConfig - The patchConfig object.
   * @param patchConfig.id - The Id of the targeted Crawler.
   * @param patchConfig.body - The body object.
   */
  function patchConfig({
    id,
    body,
  }: PatchConfigProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}/config'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `patchConfig`.');
    }

    const request: Request = {
      method: 'PATCH',
      path,
      data: body,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Update parts of the Crawler, either its name, its config, or both.
   * @param patchCrawler - The patchCrawler object.
   * @param patchCrawler.id - The Id of the targeted Crawler.
   * @param patchCrawler.inlineObject1 - The inlineObject1 object.
   */
  function patchCrawler({
    id,
    inlineObject1,
  }: PatchCrawlerProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `patchCrawler`.'
      );
    }

    const request: Request = {
      method: 'PATCH',
      path,
      data: inlineObject1,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Request the specified Crawler to pause itself.
   * @param pauseCrawler - The pauseCrawler object.
   * @param pauseCrawler.id - The Id of the targeted Crawler.
   */
  function pauseCrawler({
    id,
  }: PauseCrawlerProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}/pause'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `pauseCrawler`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Request the specified Crawler to start a reindex.
   * @param reindexCrawler - The reindexCrawler object.
   * @param reindexCrawler.id - The Id of the targeted Crawler.
   */
  function reindexCrawler({
    id,
  }: ReindexCrawlerProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}/reindex'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error(
        'Parameter `id` is required when calling `reindexCrawler`.'
      );
    }

    const request: Request = {
      method: 'POST',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * TODO: complete.
   *
   * @summary Request the specified Crawler to run.
   * @param runCrawler - The runCrawler object.
   * @param runCrawler.id - The Id of the targeted Crawler.
   */
  function runCrawler({ id }: RunCrawlerProps): Promise<InlineResponse2002> {
    const path = '/crawlers/{id}/run'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `runCrawler`.');
    }

    const request: Request = {
      method: 'POST',
      path,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  /**
   * Test an URL against the given Crawler\'s config and see what will be processed. You can also override parts of the configuration to try your changes before updating the configuration.
   *
   * @summary Test an URL against the crawler\'s config.
   * @param testURL - The testURL object.
   * @param testURL.id - The Id of the targeted Crawler.
   * @param testURL.inlineObject2 - The inlineObject2 object.
   */
  function testURL({
    id,
    inlineObject2,
  }: TestURLProps): Promise<InlineResponse2004> {
    const path = '/crawlers/{id}/test'.replace(
      '{id}',
      encodeURIComponent(String(id))
    );
    const headers: Headers = { Accept: 'application/json' };
    const queryParameters: Record<string, string> = {};

    if (!id) {
      throw new Error('Parameter `id` is required when calling `testURL`.');
    }

    const request: Request = {
      method: 'POST',
      path,
      data: inlineObject2,
    };

    return transporter.request(request, {
      queryParameters,
      headers,
    });
  }

  return {
    cancelAction,
    createCrawl,
    createCrawler,
    getAction,
    getConfigVersion,
    getCrawler,
    getCrawlerStats,
    listConfigVersions,
    listCrawlers,
    patchConfig,
    patchCrawler,
    pauseCrawler,
    reindexCrawler,
    runCrawler,
    testURL,
  };
};

export type CrawlerApi = ReturnType<typeof createCrawlerApi>;

export type CancelActionProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  /**
   * The Id of the targeted Task.
   */
  tid: string;
};

export type CreateCrawlProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  inlineObject3?: InlineObject3;
};

export type GetActionProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  /**
   * The Id of the targeted Task.
   */
  tid: string;
};

export type GetConfigVersionProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  /**
   * The version of the targeted Crawler revision.
   */
  version: number;
  /**
   * Change the number of versions per page.
   */
  itemsPerPage?: number;
  /**
   * Change the page number.
   */
  page?: number;
};

export type GetCrawlerProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  /**
   * Whether or not the configuration should be returned in the response (in the \'config\' field).
   */
  withConfig?: boolean;
};

export type GetCrawlerStatsProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
};

export type ListConfigVersionsProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
};

export type ListCrawlersProps = {
  /**
   * Change the number of items per page.
   */
  itemsPerPage?: number;
  /**
   * Change the page number.
   */
  page?: number;
  /**
   * Filter by crawler name.
   */
  name?: string;
  /**
   * Filter by Application ID.
   */
  appId?: string;
};

export type PatchConfigProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  body?: Record<string, any>;
};

export type PatchCrawlerProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  inlineObject1?: InlineObject1;
};

export type PauseCrawlerProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
};

export type ReindexCrawlerProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
};

export type RunCrawlerProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
};

export type TestURLProps = {
  /**
   * The Id of the targeted Crawler.
   */
  id: string;
  inlineObject2?: InlineObject2;
};
