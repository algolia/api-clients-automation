import { afterAll, describe, expect, it, vi } from 'vitest';

import releaseConfig from '../../../config/release.config.json' assert { type: 'json' };
// @ts-expect-error this is a mock created below
import { getFileChangesMock } from '../common.ts';
import {
  decideReleaseStrategy,
  getNextVersion,
  getSkippedCommitsText,
  getVersionChangesText,
  parseCommit,
} from '../createReleasePR.ts';
import type { ParsedCommit } from '../types.ts';

const gitAuthor = releaseConfig.gitAuthor;

const buildTestCommit = (
  options: Partial<{
    type: string;
    scope: string;
    message: string;
  }> = {},
): string => {
  const { type = 'fix', scope, message = 'fix the thing (#123)' } = options;
  const baseTestCommit = `b2501882|${gitAuthor.email}`;
  const typeAndScope = `${type}${scope ? `(${scope})` : ''}`;

  return `${baseTestCommit}|${typeAndScope}: ${message}`;
};

// Mock `getOctokit` to bypass the API call and credential requirements
vi.mock('../../common.ts', async (importOriginal) => {
  const mod = await importOriginal<typeof import('../../common.ts')>();
  return {
    ...mod,
    getOctokit: vi.fn().mockReturnValue({
      pulls: {
        get: (): any => ({
          data: {
            user: {
              login: gitAuthor.name,
            },
          },
        }),
      },
    }),
  };
});

vi.mock('../../ci/utils.ts', async (importOriginal) => {
  const mod = await importOriginal<typeof import('../../ci/utils.ts')>();
  return {
    ...mod,
    getNbGitDiff: vi.fn().mockResolvedValue(1),
  };
});

vi.mock('../common.ts', async (importOriginal) => {
  const mod = await importOriginal<typeof import('../common.ts')>();
  const getFileChangesMockFn = vi.fn();

  return {
    ...mod,
    getLastReleasedTag: vi.fn().mockResolvedValue('foobar'),
    getFileChanges: getFileChangesMockFn,
    getFileChangesMock: getFileChangesMockFn,
  };
});

vi.mock('../../config.ts', async (importOriginal) => {
  const mod = await importOriginal<typeof import('../../config.ts')>();
  return {
    ...mod,
    getPackageVersionDefault: vi.fn().mockReturnValue('0.1.2'),
  };
});

describe('createReleasePR', () => {
  afterAll(() => {
    vi.clearAllMocks();
  });

  describe('parseCommit', () => {
    it('parses commit', async () => {
      getFileChangesMock.mockResolvedValueOnce(`clients/algoliasearch-client-javascript/package.json
        clients/algoliasearch-client-kotlin/src/something/deep.json
        templates/php/api.mustache`);
      const testCommit = buildTestCommit({ scope: 'javascript' });
      expect(await parseCommit(testCommit)).toEqual({
        hash: 'b2501882',
        scope: 'javascript',
        languages: ['javascript', 'kotlin'],
        message: 'fix(javascript): fix the thing',
        prNumber: 123,
        type: 'fix',
        author: `[@${gitAuthor.name}](https://github.com/${gitAuthor.name}/)`,
      });
    });

    it('empty commit should be skipped', async () => {
      getFileChangesMock.mockResolvedValueOnce('');
      expect(await parseCommit(buildTestCommit())).toEqual(
        expect.objectContaining({
          author: '[@algolia-bot](https://github.com/algolia-bot/)',
          hash: 'b2501882',
          languages: [],
          message: 'fix: fix the thing',
          prNumber: 123,
          scope: undefined,
          type: 'fix',
        }),
      );
    });

    it('returns error when languages have not changed', async () => {
      getFileChangesMock.mockResolvedValueOnce('specs/search/something.json');
      expect(await parseCommit(buildTestCommit())).toEqual(
        expect.objectContaining({
          author: '[@algolia-bot](https://github.com/algolia-bot/)',
          hash: 'b2501882',
          languages: [],
          message: 'fix: fix the thing',
          prNumber: 123,
          scope: undefined,
          type: 'fix',
        }),
      );
    });

    it('default to fix on unknown type', async () => {
      getFileChangesMock.mockResolvedValueOnce('clients/algoliasearch-client-javascript/package.json');
      expect(await parseCommit(buildTestCommit({ type: 'what', scope: 'unkown' }))).toEqual({
        author: '[@algolia-bot](https://github.com/algolia-bot/)',
        hash: 'b2501882',
        languages: ['javascript'],
        message: 'what(unkown): fix the thing',
        prNumber: 123,
        scope: 'unkown',
        type: 'fix',
      });

      getFileChangesMock.mockResolvedValueOnce('clients/algoliasearch-client-javascript/package.json');
      expect(await parseCommit(buildTestCommit({ type: '', scope: '' }))).toEqual({
        author: '[@algolia-bot](https://github.com/algolia-bot/)',
        hash: 'b2501882',
        languages: ['javascript'],
        message: ': fix the thing',
        prNumber: 123,
        type: 'fix',
      });
    });

    it('returns early when it is a generated commit', async () => {
      getFileChangesMock.mockResolvedValueOnce('clients/algoliasearch-client-javascript/package.json');
      expect(
        await parseCommit(
          buildTestCommit({
            type: 'feat(specs)',
            message: 'foo bar baz (generated)',
          }),
        ),
      ).toEqual({
        generated: true,
        languages: ['javascript'],
        message: 'feat(specs): foo bar baz (generated)',
      });
    });
  });

  describe('getVersionChangesText', () => {
    it('generates text for version changes', () => {
      expect(
        getVersionChangesText({
          javascript: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          php: {
            current: '0.0.1',
            releaseType: 'major',
            next: getNextVersion('1.0.0', 'major'),
          },
          java: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          go: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          kotlin: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          dart: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          python: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          scala: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
          swift: {
            current: '2.0.1',
            releaseType: 'minor',
            next: getNextVersion('2.0.1', 'minor'),
          },
        }),
      ).toMatchInlineSnapshot(`
        "- ~csharp: 0.1.2 (no commit)~
        - dart: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - go: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - java: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - javascript: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - kotlin: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - php: 0.0.1 -> **\`major\` _(e.g. 2.0.0)_**
        - python: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - ~ruby: 0.1.2 (no commit)~
        - scala: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - swift: 2.0.1 -> **\`minor\` _(e.g. 2.1.0)_**"
      `);
    });
  });

  describe('decideReleaseStrategy', () => {
    it('bumps major version for BREAKING CHANGE', async () => {
      getFileChangesMock.mockResolvedValue(`clients/algoliasearch-client-javascript/package.json
        templates/php/api.mustache`);
      const versions = decideReleaseStrategy({
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'javascript',
              message: 'update the API (BREAKING CHANGE)',
            }),
          )) as ParsedCommit,
        ],
      });

      expect(versions.javascript?.releaseType).toEqual('major');
      expect(versions.javascript?.next).toEqual('1.0.0');
    });

    it('allows releasing subset of clients', async () => {
      getFileChangesMock.mockResolvedValue(`clients/algoliasearch-client-javascript/package.json
        clients/algoliasearch-client-java/package.json
        clients/algoliasearch-client-php/package.json`);
      const versions = decideReleaseStrategy({
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'javascript',
              message: 'update the API',
            }),
          )) as ParsedCommit,
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'java',
              message: 'update the API',
            }),
          )) as ParsedCommit,
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'php',
              message: 'update the API',
            }),
          )) as ParsedCommit,
        ],
      });

      expect(versions).toEqual({
        java: {
          current: '0.1.2',
          next: '0.2.0',
          releaseType: 'minor',
        },
        javascript: {
          current: '0.1.2',
          next: '0.2.0',
          releaseType: 'minor',
        },
        php: {
          current: '0.1.2',
          next: '0.2.0',
          releaseType: 'minor',
        },
      });
    });
  });

  describe('getSkippedCommitsText', () => {
    it('does not generate text if there is no commits', () => {
      expect(getSkippedCommitsText({ commitsWithoutLanguageScope: [] })).toMatchInlineSnapshot('"_(None)_"');
    });

    it('generates text for skipped commits', () => {
      expect(
        getSkippedCommitsText({ commitsWithoutLanguageScope: ['abcdefg fix: something', 'abcdefg fix: somethin2'] }),
      ).toMatchInlineSnapshot(`
        "
        <p>It doesn't mean these commits are being excluded from the release. It means they're not taken into account when the release process figured out the next version number, and updated the changelog.</p>

        <details>
          <summary>
            <i>Commits without language scope:</i>
          </summary>

          - abcdefg fix: something
        - abcdefg fix: somethin2
        </details>"
      `);
    });

    it('limits the size of the commits to 15 if there is too many', async () => {
      const fakeCommitsWithoutLanguageScope: string[] = [];

      for (let i = 0; i < 20; i++) {
        const withoutCommit = await parseCommit(buildTestCommit({ message: `something ${i}` }));
        const unknownCommit = await parseCommit(buildTestCommit({ message: `something ${i}`, scope: 'unknown' }));

        if ('message' in withoutCommit && 'message' in unknownCommit) {
          fakeCommitsWithoutLanguageScope.push(withoutCommit.message);
        }
      }

      expect(getSkippedCommitsText({ commitsWithoutLanguageScope: fakeCommitsWithoutLanguageScope }))
        .toMatchInlineSnapshot(`
        "
        <p>It doesn't mean these commits are being excluded from the release. It means they're not taken into account when the release process figured out the next version number, and updated the changelog.</p>

        <details>
          <summary>
            <i>Commits without language scope:</i>
          </summary>

          - fix: something 0
        - fix: something 1
        - fix: something 2
        - fix: something 3
        - fix: something 4
        - fix: something 5
        - fix: something 6
        - fix: something 7
        - fix: something 8
        - fix: something 9
        - fix: something 10
        - fix: something 11
        - fix: something 12
        - fix: something 13
        - fix: something 14
        </details>"
      `);
    });
  });
});

describe('getNextVersion', () => {
  it('does nothing for -SNAPSHOT', () => {
    expect(getNextVersion('1.0.0-SNAPSHOT', 'minor')).toEqual('1.0.0-SNAPSHOT');
  });

  it('bumps python alpha releases', () => {
    expect(getNextVersion('4.0.0a1', 'minor')).toEqual('4.0.0a2');
    expect(getNextVersion('4.0.0a12', 'minor')).toEqual('4.0.0a13');
    expect(getNextVersion('4.0.0a99', 'minor')).toEqual('4.0.0a100');
    expect(getNextVersion('3.0.0.alpha.0', 'minor')).toEqual('3.0.0.alpha.1');
  });
});
