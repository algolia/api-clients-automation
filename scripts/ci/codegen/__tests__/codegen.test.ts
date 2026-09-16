import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest';

import { git, gitCommit, MAIN_BRANCH } from '../../../common.ts';
import { getNbGitDiff } from '../../utils.ts';
import { pushGeneratedCode } from '../pushGeneratedCode.ts';
import text, { commitStartPrepareRelease } from '../text.ts';

vi.mock('../../../common.ts', async (importOriginal) => {
  return {
    // eslint-disable-next-line
    ...(await importOriginal<typeof import('../../../common.ts')>()),
    configureGitHubAuthor: vi.fn(),
    git: vi.fn().mockResolvedValue(''),
    gitCommit: vi.fn(),
  };
});

vi.mock('../../utils.ts', () => {
  return {
    getNbGitDiff: vi.fn().mockResolvedValue(1),
  };
});

vi.mock('@actions/core', () => {
  return {
    setOutput: vi.fn(),
  };
});

const AUTHOR = 'Co-authored-by: Someone <someone@algolia.com>';

function stubGit({
  branch = 'feat/my-branch',
  subject = 'feat(scripts): something',
  trailers = '',
  pull = 'Already up to date.',
}: Partial<{ branch: string; subject: string; trailers: string; pull: string }> = {}): void {
  vi.mocked(git).mockImplementation(async (args) => {
    if (args[0] === 'branch') {
      return branch;
    }
    if (args[0] === 'log') {
      return subject;
    }
    if (args[0] === 'show') {
      if (args.includes('--format=%s')) {
        return subject;
      }
      if (args.some((arg) => arg.startsWith('--format=Co-authored-by'))) {
        return AUTHOR;
      }
      if (args.some((arg) => arg.startsWith('--format=%(trailers'))) {
        return trailers;
      }
    }
    if (args[0] === 'pull') {
      return pull;
    }

    return '';
  });
}

describe('pushGeneratedCode', () => {
  beforeEach(() => {
    vi.stubEnv('GITHUB_TOKEN', 'token');
    vi.mocked(getNbGitDiff).mockResolvedValue(1);
    stubGit();
  });

  afterEach(() => {
    vi.unstubAllEnvs();
    vi.clearAllMocks();
  });

  it('throws without GITHUB_TOKEN environment variable', async () => {
    vi.stubEnv('GITHUB_TOKEN', '');
    await expect(pushGeneratedCode()).rejects.toThrow('Environment variable `GITHUB_TOKEN` or `GH_TOKEN` must be set.');
  });

  it('commits a subject containing shell metacharacters verbatim', async () => {
    const payload = 'fix(scripts): $(touch /tmp/pwned) `id` ${HOME} "quoted" \\`escaped';
    stubGit({ subject: payload });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: `${payload} (generated)`,
      coAuthors: [AUTHOR],
    });
  });

  it('keeps an injectable author name as data rather than a command', async () => {
    stubGit({ trailers: 'Co-authored-by: Bot $(touch /tmp/pwned) <bot@algolia.com>' });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: 'feat(scripts): something (generated)',
      coAuthors: [AUTHOR, 'Co-authored-by: Bot $(touch /tmp/pwned) <bot@algolia.com>'],
    });
  });

  it('appends [skip ci] on the main branch', async () => {
    stubGit({ branch: MAIN_BRANCH });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: 'feat(scripts): something (generated) [skip ci]',
      coAuthors: [AUTHOR],
    });
  });

  it('parses several Co-authored-by trailers, ignoring blank lines', async () => {
    stubGit({
      trailers: '\n  Co-authored-by: me <me@algolia.com>\n\n\n  Co-authored-by: you <you@algolia.com>\n  ',
    });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: 'feat(scripts): something (generated)',
      coAuthors: [AUTHOR, 'Co-authored-by: me <me@algolia.com>', 'Co-authored-by: you <you@algolia.com>'],
    });
  });

  it('refuses a branch name git would read as an option', async () => {
    stubGit({ branch: '--upload-pack=touch /tmp/pwned' });

    await expect(pushGeneratedCode()).rejects.toThrow('refusing to operate on suspicious git ref');
    expect(gitCommit).not.toHaveBeenCalled();
  });

  it('passes the branch to push as its own argv element', async () => {
    await pushGeneratedCode();

    expect(git).toHaveBeenCalledWith(['push', 'origin', 'generated/feat/my-branch']);
  });

  it('skips the push when there are no generated changes', async () => {
    vi.mocked(getNbGitDiff).mockResolvedValue(0);

    await pushGeneratedCode();

    expect(git).not.toHaveBeenCalledWith(['add', '.']);
    expect(gitCommit).not.toHaveBeenCalled();
  });

  it('stops without committing when the branch is behind origin', async () => {
    stubGit({ pull: 'Updating abc1234..def5678' });

    await pushGeneratedCode();

    expect(gitCommit).not.toHaveBeenCalled();
    expect(git).not.toHaveBeenCalledWith(['push', 'origin', 'generated/feat/my-branch']);
  });

  it('replaces the message entirely for a release commit on main', async () => {
    stubGit({ branch: MAIN_BRANCH, subject: `${commitStartPrepareRelease} 2026-08-17` });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: `${text.commitReleaseMessage} [skip ci]`,
      coAuthors: [AUTHOR],
    });
  });

  it('drops trailer lines that are not co-author entries', async () => {
    stubGit({ trailers: ' <folded@example.com>\nCo-authored-by: me <me@algolia.com>' });

    await pushGeneratedCode();

    expect(gitCommit).toHaveBeenCalledWith({
      message: 'feat(scripts): something (generated)',
      coAuthors: [AUTHOR, 'Co-authored-by: me <me@algolia.com>'],
    });
  });
});
