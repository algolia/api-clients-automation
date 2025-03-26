import chalk from 'chalk';
import { execaCommand } from 'execa';
import micromatch from 'micromatch';

import clientConfig from '../../config/clients.config.json' with { type: 'json' };
import { patterns } from '../../config/generation.config.mjs';

async function run(command) {
  return (
    (
      await execaCommand(command, {
        shell: 'bash',
        all: true,
      })
    ).all ?? ''
  );
}

export function getPatterns() {
  const entries = patterns;
  for (const [language, opts] of Object.entries(clientConfig)) {
    if (typeof opts !== 'object') {
      continue;
    }
    entries.unshift(`tests/output/${language}/${opts.tests.outputFolder}/client/**`);
    entries.unshift(`tests/output/${language}/${opts.tests.outputFolder}/requests/**`);
    entries.unshift(`tests/output/${language}/${opts.tests.outputFolder}/e2e/**`);
    entries.unshift(`tests/output/${language}/${opts.tests.outputFolder}/benchmark/**`);
  }
  return entries;
}

async function preCommit(log) {
  // when merging, we want to stage all the files
  try {
    await run('git merge HEAD');
  } catch (e) {
    if (e.exitCode === 128) {
      console.log('Skipping the pre-commit check because a merge is in progress');
      return;
    }
  }

  const stagedFiles = (await run('git diff --name-only --cached')).split('\n');

  const toUnstage = micromatch.match(stagedFiles, getPatterns());

  // the snippets and guides are yarn workspaces, so the yarn.lock file can change when they are updated, but the CI will take care of it
  if ((await run('git diff --name-only --cached -- {guides,snippet}/javascript | wc -l')).trim() !== '0') {
    toUnstage.push('yarn.lock');
  }

  if (toUnstage.length === 0) {
    return;
  }

  if (log) {
    toUnstage.forEach((file) =>
      console.log(chalk.black.bgYellow('[INFO]'), `Generated file found, unstaging: ${file}`),
    );
  }
  await run(`git restore --staged ${toUnstage.join(' ')}`);
}

if (import.meta.url.endsWith(process.argv[1]) && process.env.CI === undefined) {
  preCommit(true).then(() => {
    // Run it twice because of renamed files, the first one delete the renamed one and leaves the deleted file, which is removed by this second pass
    preCommit(false);
  });
}
