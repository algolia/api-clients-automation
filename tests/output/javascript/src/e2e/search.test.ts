// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { describe, expect, test } from 'vitest';

import { union } from '../helpers';

import { searchClient } from '@algolia/client-search';
import * as dotenv from 'dotenv';

dotenv.config({ path: '../../.env' });

if (!process.env.ALGOLIA_APPLICATION_ID) {
  throw new Error('please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests');
}

if (!process.env.ALGOLIA_ADMIN_KEY) {
  throw new Error('please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests');
}

const client = searchClient(process.env.ALGOLIA_APPLICATION_ID, process.env.ALGOLIA_ADMIN_KEY);

describe('browse', () => {
  test('browse with minimal parameters', async () => {
    const resp = await client.browse({ indexName: 'cts_e2e_browse' });

    const expectedBody = { page: 0, nbHits: 33191, nbPages: 34, hitsPerPage: 1000, query: '', params: '' };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getRule', () => {
  test('getRule', async () => {
    const resp = await client.getRule({ indexName: 'cts_e2e_browse', objectID: 'qr-1725004648916' });

    const expectedBody = {
      description: 'test_rule',
      enabled: true,
      objectID: 'qr-1725004648916',
      conditions: [{ alternatives: true, anchoring: 'contains', pattern: 'zorro' }],
      consequence: {
        params: { ignorePlurals: 'true' },
        filterPromotes: true,
        promote: [{ objectIDs: ['Æon Flux'], position: 0 }],
      },
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getSettings', () => {
  test('getSettings', async () => {
    const resp = await client.getSettings({ indexName: 'cts_e2e_settings' });

    const expectedBody = {
      minWordSizefor1Typo: 4,
      minWordSizefor2Typos: 8,
      hitsPerPage: 100,
      maxValuesPerFacet: 100,
      paginationLimitedTo: 10,
      exactOnSingleWordQuery: 'attribute',
      ranking: ['typo', 'geo', 'words', 'filters', 'proximity', 'attribute', 'exact', 'custom'],
      separatorsToIndex: '',
      removeWordsIfNoResults: 'none',
      queryType: 'prefixLast',
      highlightPreTag: '<em>',
      highlightPostTag: '</em>',
      alternativesAsExact: ['ignorePlurals', 'singleWordSynonym'],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('search', () => {
  test('search for a single hits request with minimal parameters', async () => {
    const resp = await client.search({ requests: [{ indexName: 'cts_e2e_search_empty_index' }] });

    const expectedBody = {
      results: [
        {
          hits: [],
          page: 0,
          nbHits: 0,
          nbPages: 0,
          hitsPerPage: 20,
          exhaustiveNbHits: true,
          exhaustiveTypo: true,
          exhaustive: { nbHits: true, typo: true },
          query: '',
          params: '',
          index: 'cts_e2e_search_empty_index',
          renderingContent: {},
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('search with highlight and snippet results', async () => {
    const resp = await client.search({
      requests: [
        {
          indexName: 'cts_e2e_highlight_snippet_results',
          query: 'vim',
          attributesToSnippet: ['*:20'],
          attributesToHighlight: ['*'],
          attributesToRetrieve: ['*'],
        },
      ],
    });

    const expectedBody = {
      results: [
        {
          hits: [
            {
              editor: { name: 'vim', type: 'beforeneovim' },
              names: ['vim', ':q'],
              _snippetResult: {
                editor: {
                  name: { value: '<em>vim</em>', matchLevel: 'full' },
                  type: { value: 'beforeneovim', matchLevel: 'none' },
                },
                names: [
                  { value: '<em>vim</em>', matchLevel: 'full' },
                  { value: ':q', matchLevel: 'none' },
                ],
              },
              _highlightResult: {
                editor: {
                  name: { value: '<em>vim</em>', matchLevel: 'full', fullyHighlighted: true, matchedWords: ['vim'] },
                  type: { value: 'beforeneovim', matchLevel: 'none', matchedWords: [] },
                },
                names: [
                  { value: '<em>vim</em>', matchLevel: 'full', fullyHighlighted: true, matchedWords: ['vim'] },
                  { value: ':q', matchLevel: 'none', matchedWords: [] },
                ],
              },
            },
          ],
          nbHits: 1,
          page: 0,
          nbPages: 1,
          hitsPerPage: 20,
          exhaustiveNbHits: true,
          exhaustiveTypo: true,
          exhaustive: { nbHits: true, typo: true },
          query: 'vim',
          index: 'cts_e2e_highlight_snippet_results',
          renderingContent: {},
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('search for a single facet request with minimal parameters', async () => {
    const resp = await client.search({
      requests: [{ indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' }],
      strategy: 'stopIfEnoughMatches',
    });

    const expectedBody = {
      results: [
        {
          exhaustiveFacetsCount: true,
          facetHits: [
            { count: 1, highlighted: 'goland', value: 'goland' },
            { count: 1, highlighted: 'neovim', value: 'neovim' },
            { count: 1, highlighted: 'visual studio', value: 'visual studio' },
            { count: 1, highlighted: 'vscode', value: 'vscode' },
          ],
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('search filters end to end', async () => {
    const resp = await client.search({
      requests: [
        { indexName: 'cts_e2e_search_facet', filters: "editor:'visual studio' OR editor:neovim" },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", 'editor:neovim'] },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", ['editor:neovim']] },
        {
          indexName: 'cts_e2e_search_facet',
          facetFilters: ["editor:'visual studio'", ['editor:neovim', ['editor:goland']]],
        },
      ],
    });

    const expectedBody = {
      results: [
        {
          hitsPerPage: 20,
          index: 'cts_e2e_search_facet',
          nbHits: 2,
          nbPages: 1,
          page: 0,
          hits: [
            { editor: 'visual studio', _highlightResult: { editor: { value: 'visual studio', matchLevel: 'none' } } },
            { editor: 'neovim', _highlightResult: { editor: { value: 'neovim', matchLevel: 'none' } } },
          ],
          query: '',
          params: 'filters=editor%3A%27visual+studio%27+OR+editor%3Aneovim',
        },
        {
          hitsPerPage: 20,
          index: 'cts_e2e_search_facet',
          nbHits: 0,
          nbPages: 0,
          page: 0,
          hits: [],
          query: '',
          params: 'facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%22editor%3Aneovim%22%5D',
        },
        {
          hitsPerPage: 20,
          index: 'cts_e2e_search_facet',
          nbHits: 0,
          nbPages: 0,
          page: 0,
          hits: [],
          query: '',
          params: 'facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%5D%5D',
        },
        {
          hitsPerPage: 20,
          index: 'cts_e2e_search_facet',
          nbHits: 0,
          nbPages: 0,
          page: 0,
          hits: [],
          query: '',
          params:
            'facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%2C%5B%22editor%3Agoland%22%5D%5D%5D',
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('searchDictionaryEntries', () => {
  test('get searchDictionaryEntries results with minimal parameters', async () => {
    const resp = await client.searchDictionaryEntries({
      dictionaryName: 'stopwords',
      searchDictionaryEntriesParams: { query: 'about' },
    });

    const expectedBody = {
      hits: [{ objectID: '86ef58032f47d976ca7130a896086783', language: 'en', word: 'about' }],
      page: 0,
      nbHits: 1,
      nbPages: 1,
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('searchRules', () => {
  test('searchRules', async () => {
    const resp = await client.searchRules({ indexName: 'cts_e2e_browse', searchRulesParams: { query: 'zorro' } });

    const expectedBody = {
      hits: [
        {
          conditions: [{ alternatives: true, anchoring: 'contains', pattern: 'zorro' }],
          consequence: {
            params: { ignorePlurals: 'true' },
            filterPromotes: true,
            promote: [{ objectIDs: ['Æon Flux'], position: 0 }],
          },
          description: 'test_rule',
          enabled: true,
          objectID: 'qr-1725004648916',
        },
      ],
      nbHits: 1,
      nbPages: 1,
      page: 0,
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('searchSingleIndex', () => {
  test('search with special characters in indexName', async () => {
    await client.searchSingleIndex({ indexName: 'cts_e2e_space in index' });
  });

  test('single search retrieve snippets', async () => {
    const resp = await client.searchSingleIndex({
      indexName: 'cts_e2e_browse',
      searchParams: {
        query: 'batman mask of the phantasm',
        attributesToRetrieve: ['*'],
        attributesToSnippet: ['*:20'],
      },
    });

    const expectedBody = {
      nbHits: 1,
      hits: [
        {
          _snippetResult: {
            genres: [
              { value: 'Animated', matchLevel: 'none' },
              { value: 'Superhero', matchLevel: 'none' },
              { value: 'Romance', matchLevel: 'none' },
            ],
            year: { value: '1993', matchLevel: 'none' },
          },
          _highlightResult: {
            genres: [
              { value: 'Animated', matchLevel: 'none', matchedWords: [] },
              { value: 'Superhero', matchLevel: 'none', matchedWords: [] },
              { value: 'Romance', matchLevel: 'none', matchedWords: [] },
            ],
            year: { value: '1993', matchLevel: 'none', matchedWords: [] },
          },
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('setSettings', () => {
  test('setSettings with minimal parameters', async () => {
    await client.setSettings({
      indexName: 'cts_e2e_settings',
      indexSettings: { paginationLimitedTo: 10 },
      forwardToReplicas: true,
    });
  });
});
