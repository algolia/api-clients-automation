import type { Server } from 'http';

import { expect } from 'chai';
import type { Express, Request, Response } from 'express';

import { setupServer } from './index.ts';

function addRoutes(app: Express): void {
  app.get('/check-api-key/1', (req: Request, res: Response) => {
    const headerName = 'x-algolia-api-key';

    // eslint-disable-next-line no-unused-expressions
    expect(headerName in req.headers).to.be.true;

    const headerAPIKeyValue = req.headers[headerName];
    expect(headerAPIKeyValue).to.equal('test-api-key');

    res.status(200).json({ headerAPIKeyValue });
  });
  app.get('/check-api-key/2', (req: Request, res: Response) => {
    const headerName = 'x-algolia-api-key';

    // eslint-disable-next-line no-unused-expressions
    expect(headerName in req.headers).to.be.true;

    const headerAPIKeyValue = req.headers[headerName];
    expect(headerAPIKeyValue).to.equal('updated-api-key');

    res.status(200).json({ headerAPIKeyValue });
  });
}

export function apiKeyServer(): Promise<Server> {
  return setupServer('apiKey', 6683, addRoutes);
}
