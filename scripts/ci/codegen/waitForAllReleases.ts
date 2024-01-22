/* eslint-disable no-console */
import { exists, getOctokit, setVerbose, toAbsolutePath } from '../../common';
import { getClientsConfigField, getLanguageFolder } from '../../config';
import { getTargetBranch } from '../../release/common';
import type { Language } from '../../types';

function getAllRuns(languages: Language[], workflowIDs: Array<number | undefined>): Promise<any[]> {
  const octokit = getOctokit();

  return Promise.all(
    languages.map(async (lang, index) => {
      // wait for the CI to start
      const workflowID = workflowIDs[index];
      if (!workflowID) {
        return undefined;
      }

      const run = await octokit.actions.listWorkflowRuns({
        owner: 'algolia',
        repo: getClientsConfigField(lang, 'gitRepoId'),
        workflow_id: workflowID,
        per_page: 1,
        branch: getTargetBranch(lang),
      });

      if (run.data.workflow_runs.length === 0) {
        return null;
      }

      // check that the run was created less than 10 minutes ago
      if (Date.now() - Date.parse(run.data.workflow_runs[0].created_at) > 10 * 60 * 1000) {
        return null;
      }

      return run.data.workflow_runs[0];
    })
  );
}

async function waitForAllReleases(languages: Language[]): Promise<void> {
  const octokit = getOctokit();

  console.log(
    `Waiting for all releases CI to finish for the following languages: ${languages.join(', ')}`
  );

  const workflowIDs = await Promise.all(
    languages.map(async (lang) => {
      if (
        !(await exists(toAbsolutePath(`${getLanguageFolder(lang)}/.github/workflows/release.yml`)))
      ) {
        return undefined;
      }

      const workflows = await octokit.actions.listRepoWorkflows({
        owner: 'algolia',
        repo: getClientsConfigField(lang, 'gitRepoId'),
      });

      return workflows.data.workflows.find(
        (workflow) =>
          workflow.path === '.github/workflows/release.yml' && workflow.state === 'active'
      )?.id;
    })
  );

  console.log(
    `Found the following workflows: ${languages.map((l, i) => `${l} => ${workflowIDs[i]}`).join(', ')}`
  );

  const failures: Language[] = [];

  const start = Date.now();
  while (Date.now() - start < 1000 * 60 * 5) {
    const runs = await getAllRuns(languages, workflowIDs);
    for (let i = 0; i < languages.length; i++) {
      if (runs[i] === null) {
        console.log(`⏳ ${languages[i]} CI not started yet`);
        continue;
      }

      if (runs[i]?.status === 'completed') {
        const success = runs[i]?.conclusion === 'success';
        console.log(
          `${success ? '✅' : '❌'} ${languages[i]} CI finished with conclusion: ${runs[i]?.conclusion}`
        );
        if (!success) {
          failures.push(languages[i]);
        }
        // stop fetching this run.
        workflowIDs[i] = undefined;
      }
    }

    if (workflowIDs.every((id) => id === undefined)) {
      break;
    }

    await new Promise((resolve) => {
      setTimeout(resolve, 15000);
    });
  }

  if (failures.length > 0) {
    throw new Error(`${failures.join(', ')} failed to release`);
  }
}

if (import.meta.url.endsWith(process.argv[1])) {
  setVerbose(false);
  waitForAllReleases(process.argv.slice(2) as Language[]);
}
