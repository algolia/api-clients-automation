import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';
import express from 'express';

import { setupServer } from './index.ts';

const aciState: Record<
  string,
  {
    setSettingsCount: number;
    getSettingsCount: number;
    saveRulesCount: number;
    browseRulesCount: number;
    saveSynonymsCount: number;
    browseSynonymsCount: number;
    saveObjectsCount: number;
    browseObjectsCount: number;
    waitTaskCount: number;
    successful: boolean;
  }
> = {};

export function assertValidAccountCopyIndex(expectedCount: number): void {
  expect(Object.keys(aciState)).to.have.length(expectedCount);
  for (const lang in aciState) {
    expect(aciState[lang].waitTaskCount).to.equal(5);
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.get('/1/indexes/:indexName/settings', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_(source|destination)_(.*)$/)?.[2] as string;

    if (!aciState[lang] || aciState[lang].successful) {
      aciState[lang] = {
        setSettingsCount: 0,
        getSettingsCount: 0,
        saveRulesCount: 0,
        browseRulesCount: 0,
        saveSynonymsCount: 0,
        browseSynonymsCount: 0,
        saveObjectsCount: 0,
        browseObjectsCount: 0,
        waitTaskCount: 0,
        successful: false,
      };
    } else {
      expect(aciState).to.include.keys(lang);
    }

    aciState[lang].getSettingsCount++;

    if (req.params.indexName.includes('destination')) {
      res.status(404).json({ message: 'Index not found' });
    } else {
      res.status(200).json({
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
      });
    }
  });

  app.put('/1/indexes/:indexName/settings', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_destination_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].setSettingsCount++;

    res.json({ taskID: 123 + aciState[lang].setSettingsCount, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.post('/1/indexes/:indexName/rules/search', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_source_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].browseRulesCount++;

    res.json({
      hits: [
        {
          conditions: [
            {
              alternatives: true,
              anchoring: 'contains',
              pattern: 'zorro',
            },
          ],
          consequence: {
            params: {
              ignorePlurals: 'true',
            },
            filterPromotes: true,
            promote: [
              {
                objectIDs: ['\u00C6on Flux'],
                position: 0,
              },
            ],
          },
          description: 'test_rule',
          enabled: true,
          objectID: 'qr-1725004648916',
        },
      ],
      nbHits: 1,
      nbPages: 1,
      page: 0,
    });
  });

  app.post('/1/indexes/:indexName/rules/batch', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_destination_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].saveRulesCount++;

    res.json({ taskID: 456 + aciState[lang].saveRulesCount, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.post('/1/indexes/:indexName/synonyms/search', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_source_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].browseSynonymsCount++;

    res.json({
      hits: [
        {
          objectID: 'foo',
        },
      ],
      nbHits: 1,
      nbPages: 1,
      page: 0,
    });
  });

  app.post('/1/indexes/:indexName/synonyms/batch', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_destination_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].saveSynonymsCount++;

    res.json({ taskID: 789 + aciState[lang].saveSynonymsCount, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.post('/1/indexes/:indexName/browse', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_source_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);
    expect(req.body.hitsPerPage).to.equal(2);

    aciState[lang].browseObjectsCount++;

    res.json({
      page: 0,
      nbHits: 4,
      nbPages: 1,
      hitsPerPage: req.body.hitsPerPage,
      query: '',
      params: '',
      hits: [{ objectID: 'bar' }, { objectID: 'foo' }, { objectID: 'baz' }, { objectID: 'qux' }],
    });
  });

  app.post('/1/indexes/:indexName/batch', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_destination_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);
    expect(req.body.requests).to.have.lengthOf(2);

    aciState[lang].saveObjectsCount++;

    res.json({ taskID: 10 + aciState[lang].saveObjectsCount, updatedAt: '2021-01-01T00:00:00.000Z' });
  });

  app.get('/1/indexes/:indexName/task/:taskID', (req, res) => {
    const lang = req.params.indexName.match(/^cts_e2e_account_copy_index_destination_(.*)$/)?.[1] as string;
    expect(aciState).to.include.keys(lang);

    aciState[lang].waitTaskCount++;

    res.json({ status: 'published', updatedAt: '2021-01-01T00:00:00.000Z' });
  });
}

export function accountCopyIndexServer(): Promise<Server> {
  // this server is used to simulate the responses for the accountCopyIndex method,
  // and uses a state machine to determine if the logic is correct.
  return setupServer('accountCopyIndex', 6687, addRoutes);
}
