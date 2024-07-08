import type { Server } from 'http';

import { expect } from 'chai';
import express from 'express';
import type { Express } from 'express';

import { setupServer } from '.';

const chunkWrapperState: Record<string, any> = {};

export function assertChunkWrapperValid(expectedCount: number): void {
  if (Object.values(chunkWrapperState).length !== expectedCount) {
    throw new Error('unexpected number of call to chunkWrapper');
  }
  for (const state of Object.values(chunkWrapperState)) {
    expect(state).to.deep.equal({ saveObjects: 1, partialUpdateObjects: 2, deleteObjects: 1 });
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/indexes/:indexName/batch', (req, res) => {
    const match = req.params.indexName.match(/^cts_e2e_(\w+)_(.*)$/);
    const helper = match?.[1] as string;
    const lang = match?.[2] as string;

    if (!chunkWrapperState[lang]) {
      chunkWrapperState[lang] = {};
    }
    chunkWrapperState[lang][helper] = (chunkWrapperState[lang][helper] ?? 0) + 1;
    switch (helper) {
      case 'saveObjects':
        expect(req.body).to.deep.equal({
          requests: [
            { action: 'addObject', body: { objectID: '1', name: 'Adam' } },
            { action: 'addObject', body: { objectID: '2', name: 'Benoit' } },
          ],
        });

        res.json({
          taskID: 333,
          objectIDs: req.body.requests.map((r) => r.body.objectID),
        });

        break;
      case 'partialUpdateObjects':
        if (req.body.requests[0].body.objectID === '1') {
          expect(req.body).to.deep.equal({
            requests: [
              { action: 'partialUpdateObject', body: { objectID: '1', name: 'Adam' } },
              { action: 'partialUpdateObject', body: { objectID: '2', name: 'Benoit' } },
            ],
          });

          res.json({
            taskID: 444,
            objectIDs: req.body.requests.map((r) => r.body.objectID),
          });
        } else {
          expect(req.body).to.deep.equal({
            requests: [
              { action: 'partialUpdateObjectNoCreate', body: { objectID: '3', name: 'Cyril' } },
              { action: 'partialUpdateObjectNoCreate', body: { objectID: '4', name: 'David' } },
            ],
          });

          res.json({
            taskID: 555,
            objectIDs: req.body.requests.map((r) => r.body.objectID),
          });
        }
        break;
      case 'deleteObjects':
        expect(req.body).to.deep.equal({
          requests: [
            { action: 'deleteObject', body: { objectID: '1' } },
            { action: 'deleteObject', body: { objectID: '2' } },
          ],
        });

        res.json({
          taskID: 666,
          objectIDs: req.body.requests.map((r) => r.body.objectID),
        });
        break;
      default:
        throw new Error('unknown helper');
    }
  });

  app.post('/1/indexes/*/queries', (req, res) => {
    res.json({
      results: [
        {
          hits: [
            {
              objectID: '668bd17a72dcb36605ff10a4',
              index: 0,
              guid: '099dc11e-54ab-4d03-ac18-5ce5d5036c82',
              isActive: true,
              balance: '$1,584.80',
              picture: 'http://placehold.it/32x32',
              age: 21,
              eyeColor: 'green',
              name: 'Knapp Russell',
              gender: 'male',
              company: 'ZIALACTIC',
              email: 'knapprussell@zialactic.com',
              phone: '+1 (952) 480-3477',
              address: '529 Seba Avenue, Colton, New Jersey, 5975',
              about:
                'Deserunt irure duis cillum dolore ad aliqua cillum ut. Qui labore nulla cillum commodo ex labore consequat. Amet sunt irure eiusmod reprehenderit anim tempor irure non tempor sit aute. Culpa dolor labore sit quis. Non ut ut proident voluptate fugiat enim fugiat enim cupidatat ad irure reprehenderit id.\r\n',
              registered: '2022-09-23T02:45:05 -02:00',
              latitude: 38.203585,
              longitude: -150.156823,
              tags: ['est', 'cupidatat', 'sint', 'ipsum', 'aliqua', 'quis', 'ullamco'],
              friends: [
                {
                  id: 0,
                  name: 'Mandy Burch',
                },
                {
                  id: 1,
                  name: 'Connie Dawson',
                },
                {
                  id: 2,
                  name: 'Reynolds Russo',
                },
              ],
              greeting: 'Hello, Knapp Russell! You have 4 unread messages.',
              favoriteFruit: 'banana',
            },
          ],
          page: 1,
          nbHits: 1,
          nbPages: 1,
          hitsPerPage: 50,
          exhaustiveNbHits: true,
          processingTimeMS: 0,
          exhaustiveTypo: true,
          exhaustive: {
            nbHits: true,
            typo: true,
          },
          query: req.body.requests[0].query,
          params: '',
          index: req.body.requests[0].indexName,
          renderingContent: {},
        },
      ],
    });
  });
}

export function chunkWrapperServer(): Promise<Server> {
  return setupServer('chunkWrapper', 6680, addRoutes);
}
