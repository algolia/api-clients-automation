import type { Server } from 'http';

import type { Express } from 'express';

import { setupServer } from '.';

const retryCount = {
  add: 0,
  update: 0,
  delete: 0,
};

function addRoutes(app: Express): void {
  app.get('/1/keys/:key', (req, res) => {
    if (req.params.key === 'api-key-add-operation-test') {
      if (retryCount.add < 3) {
        res.status(404).json({ message: `API key doesn't exist` });
      } else if (retryCount.add === 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my new api key',
          acl: ['search', 'addObject'],
          validity: 300,
          maxQueriesPerIPPerHour: 100,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else {
        res.status(500).json({ message: `Internal Server Error` });
      }

      retryCount.add += 1;
    } else if (req.params.key === 'api-key-update-operation-test') {
      if (retryCount.update < 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my new api key',
          acl: ['search', 'addObject'],
          validity: 300,
          maxQueriesPerIPPerHour: 100,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else if (retryCount.update === 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my updated api key',
          acl: ['search', 'addObject', 'deleteObject'],
          validity: 305,
          maxQueriesPerIPPerHour: 95,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else {
        res.status(500).json({ message: `Internal Server Error` });
      }

      retryCount.update += 1;
    } else if (req.params.key === 'api-key-delete-operation-test') {
      if (retryCount.delete < 3) {
        res.status(200).json({
          value: req.params.key,
          description: 'my updated api key',
          acl: ['search', 'addObject', 'deleteObject'],
          validity: 305,
          maxQueriesPerIPPerHour: 95,
          maxHitsPerQuery: 20,
          createdAt: 1720094400,
        });
      } else if (retryCount.delete === 3) {
        res.status(404).json({ message: `API key doesn't exist` });
      } else {
        res.status(500).json({ message: `Internal Server Error` });
      }

      retryCount.delete += 1;
    } else {
      res.status(500).json({ message: `Internal Server Error` });
    }
  });

  // fallback route
  app.use((req, res) => {
    // eslint-disable-next-line no-console
    console.log('fallback route', req.method, req.url);
    res.status(500).json({ message: `Internal Server Error (fallback)` });
  });

  app.use((err, req, res, _) => {
    // eslint-disable-next-line no-console
    console.error(err.message);
    res.status(500).send({ message: err.message });
  });
}

export function waitForApiKeyServer(): Promise<Server> {
  return setupServer('waitForApiKey', 6681, addRoutes);
}
