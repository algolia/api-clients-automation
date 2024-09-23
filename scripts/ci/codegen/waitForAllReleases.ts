/* eslint-disable no-console */
import type { components } from '@octokit/openapi-types';

import { exists, getOctokit, run, setVerbose, toAbsolutePath } from '../../common.ts';
import { getClientsConfigField, getLanguageFolder } from '../../config.ts';
import { getTargetBranch } from '../../release/common.ts';
import type { Language } from '../../types.ts';

import { commitStartRelease } from './text.ts';

type Run = {
  language: Language;
  run?: components['schemas']['workflow-run'];
  finished: boolean;
  retried: boolean;
};

async function fetchAllRuns(runs: Run[]): Promise<void> {
  const octokit = getOctokit();

  await Promise.allSettled(
    runs
      .filter((ciRun) => !ciRun.finished)
      .map(async (ciRun) => {
        // wait for the CI to start
        const workflowRun = await octokit.actions.listWorkflowRuns({
          owner: 'algolia',
          repo: getClientsConfigField(ciRun.language, 'gitRepoId'),
          workflow_id: 'release.yml',
          per_page: 1,
          branch: ciRun.language === 'dart' ? undefined : getTargetBranch(ciRun.language),
        });

        if (workflowRun.data.workflow_runs.length === 0) {
          return;
        }

        // check that the run was created less than 20 minutes ago
        if (Date.now() - Date.parse(workflowRun.data.workflow_runs[0].created_at) > 20 * 60 * 1000) {
          return;
        }

        ciRun.run = workflowRun.data.workflow_runs[0];
      }),
  );
}

function sleep(ms: number): Promise<void> {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
}

async function waitForAllReleases(languagesReleased: Language[]): Promise<void> {
  const lastCommitMessage = await run('git log -1 --format="%s"');

  if (!lastCommitMessage.startsWith(commitStartRelease)) {
    console.log('No release commit found, skipping waiting for CI');

    return;
  }

  const runs: Run[] = (
    await Promise.all(
      languagesReleased.map(async (lang) => ({
        lang,
        available: await exists(toAbsolutePath(`${getLanguageFolder(lang)}/.github/workflows/release.yml`)),
      })),
    )
  )
    .filter((lang) => lang.available)
    .map((lang) => ({ language: lang.lang, run: undefined, finished: false, retried: false }));

  console.log(
    `Waiting for all releases CI to finish for the following languages: ${runs.map((l) => l.language).join(', ')}`,
  );

  const failures: Language[] = [];

  const start = Date.now();
  // kotlin release can take a long time
  while (Date.now() - start < 1000 * 60 * 20) {
    await fetchAllRuns(runs);
    for (const ciRun of runs) {
      if (ciRun.finished) {
        continue;
      }

      if (!ciRun.run) {
        console.log(`⏳ ${ciRun.language} CI not started yet`);
        continue;
      }

      if (ciRun.run.status === 'completed') {
        const success = ciRun.run.conclusion === 'success';
        if (!success && !ciRun.retried) {
          // retry once
          console.log(`❌ ${ciRun.language} CI failed, retrying once`);
          await getOctokit().actions.reRunWorkflowFailedJobs({
            owner: 'algolia',
            repo: getClientsConfigField(ciRun.language, 'gitRepoId'),
            run_id: ciRun.run.id,
          });

          // sleep for a bit to let the CI start
          await sleep(15000);

          ciRun.retried = true;

          continue;
        }
        console.log(`${success ? '✅' : '❌'} ${ciRun.language} CI finished with conclusion: ${ciRun.run.conclusion}`);
        if (!success) {
          failures.push(ciRun.language);
        }
        // stop fetching this run.
        ciRun.finished = true;
      }
    }

    if (runs.every((ciRun) => ciRun.finished)) {
      break;
    }

    await sleep(15000);
  }

  if (failures.length > 0) {
    throw new Error(`${failures.join(', ')} failed to release`);
  }
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  waitForAllReleases(process.argv.slice(2) as Language[]);
}
