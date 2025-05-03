import fs from 'fs';
import type { Server } from 'http';

import { expect } from 'chai';
import chalk from 'chalk';
import type { Express } from 'express';
import express from 'express';

import { CI, toAbsolutePath } from '../../common.ts';

import { setupServer } from './index.ts';

const benchmarkStatus: Record<
  string,
  {
    requestTimes: number[];
  }
> = {};

export function printBenchmarkReport(): void {
  const times: Array<{ lang: string; rate: number }> = [];
  for (const lang of Object.keys(benchmarkStatus)) {
    const status = benchmarkStatus[lang];
    expect(status.requestTimes).to.have.length(2000);
    status.requestTimes.sort((a, b) => a - b);
    const rate = (status.requestTimes.length * 1000) / (status.requestTimes.at(-1)! - status.requestTimes[0]);
    times.push({ lang, rate });
  }

  times.sort((a, b) => b.rate - a.rate);
  console.log(chalk.black.bgCyan('Benchmark report:'));
  for (const { lang, rate } of times) {
    const color = rate > 2000 ? 'bgGreenBright' : rate > 1000 ? 'bgGreen' : rate > 500 ? 'bgYellow' : 'bgRed';
    console.log(chalk.black[color](`${lang}: ${Math.floor(rate)} req/s`));

    if (CI) {
      // save the result to a file, to be reported in the CI.
      // we can't use setOutput here, because it doesn't work with matrix strategies
      fs.writeFileSync(
        toAbsolutePath(`tests/output/${lang}/benchmarkResult.json`),
        JSON.stringify({ [lang]: { rate } }),
      );
    }
  }
}

function addRoutes(app: Express): void {
  app.use(express.urlencoded({ extended: true }));
  app.use(
    express.json({
      type: ['application/json', 'text/plain'], // the js client sends the body as text/plain
    }),
  );

  app.post('/1/indexes/\\*/queries', (req, res) => {
    const lang = req.body.requests[0].indexName.replace('cts_e2e_benchmark_search_', '');
    if (!benchmarkStatus[lang]) {
      benchmarkStatus[lang] = { requestTimes: [] };
    }
    benchmarkStatus[lang].requestTimes.push(Date.now());

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

export function benchmarkServer(): Promise<Server> {
  return setupServer('benchmark', 6682, addRoutes);
}
