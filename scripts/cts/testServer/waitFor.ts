import type { Server } from 'http';

import { expect } from 'chai';
import type { Express } from 'express';

import { setupServer } from './index.ts';

const retryCount: Record<
  string,
  {
    add: number;
    update: number;
    delete: number;
  }
> = {};

export function assertValidWaitForApiKey(expectedCount: number): void {
  expect(Object.keys(retryCount).length).to.be.equal(expectedCount);
  for (const retry of Object.values(retryCount)) {
    expect(retry).to.deep.equal({
      add: 0,
      update: 0,
      delete: 0,
    });
  }
}

function addRoutes(app: Express): void {
  app.get('/1/keys/:key', (req, res) => {
    const lang = req.params.key.split('-').at(-1) as string;
    if (!retryCount[lang]) {
      retryCount[lang] = {
        add: 0,
        update: 0,
        delete: 0,
      };
    }
    const retry = retryCount[lang];
    if (req.params.key === `api-key-add-operation-test-${lang}`) {
      if (retry.add < 3) {
        res.status(404).json({ message: "API key doesn't exist" });
      } else if (retry.add === 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my new api key',
          acl: ['search', 'addObject'],
          validity: 300,
          maxQueriesPerIPPerHour: 100,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });

        retry.add = -1;
      } else {
        expect(retry.add).to.be.lessThan(3);
        return;
      }

      retry.add += 1;
    } else if (req.params.key === `api-key-update-operation-test-${lang}`) {
      if (retry.update < 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my new api key',
          acl: ['search', 'addObject'],
          validity: 300,
          maxQueriesPerIPPerHour: 100,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else if (retry.update === 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my updated api key',
          acl: ['search', 'addObject', 'deleteObject'],
          indexes: ['Movies', 'Books'],
          referers: ['*google.com', '*algolia.com'],
          validity: 305,
          maxQueriesPerIPPerHour: 95,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });

        retry.update = -1;
      } else {
        expect(retry.update).to.be.lessThan(3);
        return;
      }

      retry.update += 1;
    } else if (req.params.key === `api-key-delete-operation-test-${lang}`) {
      if (retry.delete < 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my updated api key',
          acl: ['search', 'addObject', 'deleteObject'],
          validity: 305,
          maxQueriesPerIPPerHour: 95,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else if (retry.delete === 3) {
        res.status(404).json({ message: "API key doesn't exist" });

        retry.delete = -1;
      } else {
        expect(retry.delete).to.be.lessThan(3);
        return;
      }

      retry.delete += 1;
    } else {
      throw new Error(`Invalid API key ${req.params.key}`);
    }
  });

  app.get('/1/indexes/:indexName/task/:taskID', (_req, res) => {
    res.status(200).json({
      status: 'published',
    });
  });

  app.get('/1/task/:taskID', (_req, res) => {
    res.status(200).json({
      status: 'published',
    });
  });

  app.get('/1/indexes/:indexName/settings', (req, res) => {
    if (req.params.indexName === 'indexExistsYES') {
      res.status(200).json({
        attributesForFaceting: ['searchable(brand)'],
        searchableAttributes: ['name', 'brand'],
        customRanking: ['desc(price)', 'asc(name)'],
        replicas: ['indexExistsYES-1', 'indexExistsYES-2'],
      });
    } else if (req.params.indexName === 'indexExistsNO') {
      res.status(404).json({ message: 'Index not found' });
    } else {
      res.status(403).json({ message: 'Invalid API key' });
    }
  });
}

export function waitForApiKeyServer(): Promise<Server> {
  return setupServer('waitFor', 6681, addRoutes);
}
