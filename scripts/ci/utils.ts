import fsp from 'fs/promises';
import { resolve } from 'path';

import { assertSafeRef, git, run } from '../common.ts';
import { getGitHubUrl } from '../config.ts';
import { getTargetBranch } from '../release/common.ts';
import type { Language } from '../types.ts';

/**
 * Returns 1 when there is a diff between a `branch` and its `HEAD` for the given `path`, 0 otherwise.
 *
 * @param opts - Parameters of the method.
 * @param opts.branch - The branch to trigger the operation, defaults to '' (current branch).
 * @param opts.head - The head to compare the operation, defaults to 'HEAD', providing 'null' will check for unstaged changes.
 * @param opts.path - The pathspec, or list of pathspecs, to look for changes in, defaults to '.' (current directory).
 * @param opts.cwd - The path to run the command, defaults to current directory.
 */
export async function getNbGitDiff({
  branch = '',
  head = 'HEAD',
  path = '.',
  cwd,
}: Partial<{
  branch: string;
  head: string | null;
  path: string | string[];
  cwd: string;
}>): Promise<number> {
  const range = `${branch}${head === null ? '' : `...${head}`}`;
  const pathspecs = Array.isArray(path) ? path : [path];

  await git(['add', '-N', '.'], { cwd });

  const shortstat = await git(
    ['diff', '--shortstat', '--end-of-options', ...(range ? [assertSafeRef(range)] : []), '--', ...pathspecs],
    { cwd },
  );

  return shortstat.split('\n').filter(Boolean).length;
}

export async function cloneRepository({
  lang,
  githubToken,
  tempDir,
}: {
  lang: Language;
  githubToken: string;
  tempDir: string;
}): Promise<{ tempGitDir: string }> {
  const targetBranch = getTargetBranch(lang);

  const gitHubUrl = getGitHubUrl(lang, { token: githubToken });
  const tempGitDir = resolve(tempDir, lang);
  await fsp.rm(tempGitDir, { force: true, recursive: true });
  await run(`git clone --depth 1 --branch ${targetBranch} ${gitHubUrl} ${tempGitDir}`);

  return {
    tempGitDir,
  };
}
