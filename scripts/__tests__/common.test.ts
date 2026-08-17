import { execa } from 'execa';
import { afterEach, describe, expect, it, vi } from 'vitest';

import { assertSafeRef, capitalize, createClientName, git, gitBranchExists, gitCommit, setVerbose } from '../common.ts';
import { getClientsConfigField } from '../config.ts';

vi.mock('execa', () => {
  return {
    execa: vi.fn(),
  };
});

describe('gitCommit', () => {
  afterEach(() => {
    vi.clearAllMocks();
  });

  it('commits with message', () => {
    gitCommit({ message: 'chore: does something' });
    expect(execa).toHaveBeenCalledTimes(1);
    expect(execa).toHaveBeenCalledWith('git', ['commit', '-m', 'chore: does something'], {
      all: true,
      cwd: expect.any(String),
    });
  });

  it('commits with co-author', () => {
    // This reflects how it can be retrieved from git commands.
    const author = `Co-authored-by: them <them@algolia.com>
     `.trim();
    const coAuthors = `

      Co-authored-by: me <me@algolia.com>


      Co-authored-by: you <you@algolia.com>
      
      `
      .split('\n')
      .map((coAuthor) => coAuthor.trim())
      .filter(Boolean);

    gitCommit({
      message: 'chore: does something',
      coAuthors: [author, ...coAuthors],
    });
    expect(execa).toHaveBeenCalledTimes(1);
    expect(execa).toHaveBeenCalledWith(
      'git',
      [
        'commit',
        '-m',
        'chore: does something\n\n\nCo-authored-by: them <them@algolia.com>\nCo-authored-by: me <me@algolia.com>\nCo-authored-by: you <you@algolia.com>',
      ],
      { all: true, cwd: expect.any(String) },
    );
  });

  it('passes env to the commit process instead of a shell prefix', () => {
    gitCommit({ message: 'chore: prepare release', env: { CI: 'true' } });
    expect(execa).toHaveBeenCalledWith('git', ['commit', '-m', 'chore: prepare release'], {
      all: true,
      cwd: expect.any(String),
      env: { CI: 'true' },
    });
  });

  it('echoes the commit output when verbose', async () => {
    const log = vi.spyOn(console, 'log').mockImplementation(() => {});
    vi.mocked(execa).mockResolvedValue({ all: '[main abc1234] chore: prepare release' } as never);

    setVerbose(true);
    await gitCommit({ message: 'chore: prepare release' });
    setVerbose(false);

    expect(log).toHaveBeenCalledWith('[main abc1234] chore: prepare release');
    log.mockRestore();
  });
});

describe('git', () => {
  afterEach(() => {
    vi.clearAllMocks();
  });

  it('never runs through a shell', async () => {
    vi.mocked(execa).mockResolvedValue({ stdout: 'output' } as never);

    await expect(git(['status', '--short'])).resolves.toEqual('output');
    expect(execa).toHaveBeenCalledWith('git', ['status', '--short'], { all: true, cwd: expect.any(String) });
  });

  it('passes each argument as its own argv element', async () => {
    vi.mocked(execa).mockResolvedValue({ stdout: '' } as never);

    const payload = 'fix(scripts): $(touch /tmp/pwned) `id` ${HOME} "quoted"';
    await git(['show', '-s', '--format=%s', '--end-of-options', payload]);

    expect(execa).toHaveBeenCalledWith(
      'git',
      ['show', '-s', '--format=%s', '--end-of-options', payload],
      expect.anything(),
    );
  });

  it('returns stdout only, so stderr cannot contaminate the value', async () => {
    vi.mocked(execa).mockResolvedValue({
      stdout: 'the value',
      stderr: 'warning: noise',
      all: 'the value\nwarning: noise',
    } as never);

    await expect(git(['show'])).resolves.toEqual('the value');
  });

  it('swallows the failure when allowFailure is set', async () => {
    vi.mocked(execa).mockRejectedValue(new Error('boom'));

    await expect(git(['push', '-d', 'origin', 'nope'], { allowFailure: true })).resolves.toEqual('');
  });

  it('still logs the failure output when verbose and allowFailure is set', async () => {
    const log = vi.spyOn(console, 'log').mockImplementation(() => {});
    vi.mocked(execa).mockRejectedValue(Object.assign(new Error('boom'), { all: 'remote ref does not exist' }));

    setVerbose(true);
    await expect(git(['push', '-d', 'origin', 'nope'], { allowFailure: true })).resolves.toEqual('');
    setVerbose(false);

    expect(log).toHaveBeenCalledWith('remote ref does not exist');
    log.mockRestore();
  });

  it('throws the provided errorMessage on failure', async () => {
    vi.mocked(execa).mockRejectedValue(new Error('boom'));

    await expect(git(['rev-parse'], { errorMessage: '`released` tag is missing in this repository.' })).rejects.toThrow(
      '[ERROR] `released` tag is missing in this repository.',
    );
  });

  it('echoes the combined output when verbose, still returning stdout', async () => {
    const log = vi.spyOn(console, 'log').mockImplementation(() => {});
    vi.mocked(execa).mockResolvedValue({ stdout: 'the value', all: 'the value\nwarning: noise' } as never);

    setVerbose(true);
    await expect(git(['show'])).resolves.toEqual('the value');
    setVerbose(false);

    expect(log).toHaveBeenCalledWith('the value\nwarning: noise');
    log.mockRestore();
  });

  it('quotes arguments containing whitespace in the failure message', async () => {
    const log = vi.spyOn(console, 'log').mockImplementation(() => {});
    vi.mocked(execa).mockRejectedValue(new Error('boom'));

    await expect(git(['show', '-s', '--format=%s (generated)'])).rejects.toThrow(
      'command failed: git show -s "--format=%s (generated)"',
    );
    log.mockRestore();
  });
});

describe('gitBranchExists', () => {
  afterEach(() => {
    vi.clearAllMocks();
  });

  it('passes the branch as a pattern after --end-of-options', async () => {
    vi.mocked(execa).mockResolvedValue({ stdout: 'abc1234\trefs/heads/chore/prepare-release-2026-08-17' } as never);

    await expect(gitBranchExists('chore/prepare-release-2026-08-17')).resolves.toEqual(true);
    expect(execa).toHaveBeenCalledWith(
      'git',
      ['ls-remote', '--heads', '--end-of-options', 'origin', 'chore/prepare-release-2026-08-17'],
      expect.anything(),
    );
  });

  it('returns false when the remote has no matching branch', async () => {
    vi.mocked(execa).mockResolvedValue({ stdout: '' } as never);

    await expect(gitBranchExists('chore/prepare-release-2026-08-17')).resolves.toEqual(false);
  });
});

describe('assertSafeRef', () => {
  it('returns ordinary refs unchanged', () => {
    for (const ref of [
      'main',
      'feat/my-branch',
      'origin/main',
      'generated/feat/my-branch',
      'fix/issue#123',
      'released-2026-08-17-abc1234',
    ]) {
      expect(assertSafeRef(ref)).toEqual(ref);
    }
  });

  it('rejects refs git would read as an option', () => {
    for (const ref of ['-evil', '--output=/tmp/pwned', '--upload-pack=touch /tmp/pwned']) {
      expect(() => assertSafeRef(ref)).toThrow('refusing to operate on suspicious git ref');
    }
  });

  it('rejects an empty ref, as returned for a detached HEAD', () => {
    expect(() => assertSafeRef('')).toThrow('refusing to operate on suspicious git ref');
  });
});

describe('config', () => {
  describe('getClientsConfigField', () => {
    it('throws if the field is not found', () => {
      expect(() => {
        getClientsConfigField('javascript', 'foofoo');
      }).toThrowErrorMatchingInlineSnapshot("[Error: Unable to find 'foofoo' for 'javascript']");
    });

    it('find the field if it exists', () => {
      expect(getClientsConfigField('java', ['tests', 'extension'])).toEqual('.test.java');
    });
  });
});

describe('utils', () => {
  describe('capitalize', () => {
    it('should capitalize first letter', () => {
      expect(capitalize('hello')).toEqual('Hello');
      expect(capitalize('Hello')).toEqual('Hello');
    });

    it('should only capitalize first letter', () => {
      expect(capitalize('hello wolrd')).toEqual('Hello wolrd');
      expect(capitalize('Hello wolrd')).toEqual('Hello wolrd');
    });

    it('should not affect other character', () => {
      expect(capitalize('8Hello')).toEqual('8Hello');
      expect(capitalize('<hello>')).toEqual('<hello>');
    });
  });

  describe('createClientName', () => {
    it('does not capitalize every part for JavaScript', () => {
      expect(createClientName('search', 'javascript')).toEqual('search');
      expect(createClientName('search-client', 'javascript')).toEqual('searchClient');
      expect(createClientName('search-cli!nt-complex', 'javascript')).toEqual('searchCli!ntComplex');
    });

    it('capitalize every part for other languages', () => {
      expect(createClientName('search', 'java')).toEqual('Search');
      expect(createClientName('search-client', 'java')).toEqual('SearchClient');
      expect(createClientName('search-cli!nt-complex', 'java')).toEqual('SearchCli!ntComplex');
    });
  });
});
