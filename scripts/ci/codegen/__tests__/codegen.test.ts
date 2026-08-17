import { afterEach, beforeEach, describe, expect, it, vi } from 'vitest';

import { git, gitCommit, MAIN_BRANCH } from '../../../common.ts';
import { getNbGitDiff } from '../../utils.ts';
import { pushGeneratedCode } from '../pushGeneratedCode.ts';

vi.mock('../../../common.ts', async (importOriginal) => {
  return {
    // eslint-disable-next-line
    ...(await importOriginal<typeof import('../../../common.ts')>()),
    run: vi.fn().mockResolvedValue(''),
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
}: Partial<{ branch: string; subject: string; trailers: string }> = {}): void {
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
      return 'Already up to date.';
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
});
