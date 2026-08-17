import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest';

import { git } from '../../common.ts';
import { getNbGitDiff } from '../utils.ts';

vi.mock('../../common.ts', async (importOriginal) => {
  return {
    // eslint-disable-next-line
    ...(await importOriginal<typeof import('../../common.ts')>()),
    git: vi.fn().mockResolvedValue(''),
  };
});

/** The `git diff` invocation, i.e. everything after the `git add -N .` call. */
function diffArgs(): string[] {
  const call = vi.mocked(git).mock.calls.find(([args]) => args[0] === 'diff');
  if (!call) {
    throw new Error('git diff was never called');
  }

  return call[0];
}

describe('getNbGitDiff', () => {
  beforeEach(() => {
    vi.mocked(git).mockResolvedValue('');
  });

  afterEach(() => {
    vi.clearAllMocks();
  });

  it('stages intent-to-add before diffing', async () => {
    await getNbGitDiff({ head: null });

    expect(git).toHaveBeenCalledWith(['add', '-N', '.'], { cwd: undefined });
  });

  it('omits the revision entirely rather than passing an empty argument', async () => {
    await getNbGitDiff({ head: null });

    // an empty string here would be `fatal: bad revision ''`
    expect(diffArgs()).not.toContain('');
    expect(diffArgs()).toEqual(['diff', '--shortstat', '--end-of-options', '--', '.']);
  });

  it('builds a revision range from branch and head', async () => {
    await getNbGitDiff({ branch: 'origin/main' });

    expect(diffArgs()).toEqual(['diff', '--shortstat', '--end-of-options', 'origin/main...HEAD', '--', '.']);
  });

  it('spreads a list of pathspecs into separate argv elements', async () => {
    await getNbGitDiff({ head: null, path: [':!**node_modules', 'templates/go', 'config/go.config.json'] });

    // joined into one element, the exclusion silently matches nothing
    expect(diffArgs()).toEqual([
      'diff',
      '--shortstat',
      '--end-of-options',
      '--',
      ':!**node_modules',
      'templates/go',
      'config/go.config.json',
    ]);
  });

  it('still accepts a single pathspec string', async () => {
    await getNbGitDiff({ head: null, path: 'clients' });

    expect(diffArgs()).toEqual(['diff', '--shortstat', '--end-of-options', '--', 'clients']);
  });

  it('guards the revision against refs git would read as an option', async () => {
    await expect(getNbGitDiff({ branch: '--output=/tmp/pwned', head: null })).rejects.toThrow(
      'refusing to operate on suspicious git ref',
    );
  });

  it('returns 1 for a shortstat line and 0 for no output', async () => {
    vi.mocked(git).mockResolvedValue(' 3 files changed, 10 insertions(+), 2 deletions(-)');
    await expect(getNbGitDiff({ head: null })).resolves.toEqual(1);

    vi.mocked(git).mockResolvedValue('');
    await expect(getNbGitDiff({ head: null })).resolves.toEqual(0);
  });
});
