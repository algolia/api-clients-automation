import { afterAll, describe, expect, it, vi } from "vitest";

import releaseConfig from '../../../config/release.config.json' assert { type: 'json' };
import type { PassedCommit } from '../types.js';
import { LANGUAGES } from "../../common.js";
import { ReleaseType } from "semver";

const gitAuthor = releaseConfig.gitAuthor;

const buildTestCommit = (
  options: Partial<{
    type: string;
    scope: string;
    message: string;
  }> = {}
): string => {
  const { type = 'fix', scope, message = 'fix the thing (#123)' } = options;
  const baseTestCommit = `b2501882|${gitAuthor.email}`;
  const typeAndScope = `${type}${scope ? `(${scope})` : ''}`;

  return `${baseTestCommit}|${typeAndScope}: ${message}`;
};

// Mock `getOctokit` to bypass the API call and credential requirements
vi.mock('../../common.js', async () => {
  const mod = await vi.importActual<typeof import('../../common.js')>('../../common.js')
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
    }}),
  }
})

vi.mock('../../ci/utils.js', async () => {
  const mod = await vi.importActual<typeof import('../../ci/utils.js')>('../../ci/utils.js')
  return {
    ...mod,
    getNbGitDiff: vi.fn().mockResolvedValue(1)
  }
})

vi.mock('../common.js', async () => {
  const mod = await vi.importActual<typeof import('../common.js')>('../common.js')
  return {
    ...mod,
    getLastReleasedTag: vi.fn().mockResolvedValue("foobar")
  }
})

const {
  parseCommit,
  getVersionChangesText,
  getSkippedCommitsText,
  decideReleaseStrategy,
  readVersions,
  getNextVersion,
} = await import('../createReleasePR.js');

describe('createReleasePR', () => {
  afterAll(() => {
    vi.clearAllMocks();
  });

  it('reads versions of the current language', () => {
    expect(readVersions()).toEqual({
      java: { current: expect.any(String) },
      javascript: { current: expect.any(String) },
      php: { current: expect.any(String) },
      go: { current: expect.any(String) },
      kotlin: { current: expect.any(String) },
      dart: { current: expect.any(String) },
      python: { current: expect.any(String) },
      csharp: { current: expect.any(String) },
      ruby: { current: expect.any(String) },
      scala: { current: expect.any(String) },
      swift: { current: expect.any(String) }
    });
  });

  describe('parseCommit', () => {
    it('parses commit', async () => {
      const testCommit = buildTestCommit({ scope: 'javascript' });
      expect(await parseCommit(testCommit)).toEqual({
        hash: 'b2501882',
        scope: 'javascript',
        message: 'fix(javascript): fix the thing',
        prNumber: 123,
        raw: testCommit,
        type: 'fix',
        author: `[@${gitAuthor.name}](https://github.com/${gitAuthor.name}/)`,
      });
    });

    it('considers `specs` as a lang commit', async () => {
      const testCommit = buildTestCommit({ scope: 'specs' });
      expect(await parseCommit(testCommit)).toEqual({
        hash: 'b2501882',
        scope: 'specs',
        message: 'fix(specs): fix the thing',
        prNumber: 123,
        raw: testCommit,
        type: 'fix',
        author: `[@${gitAuthor.name}](https://github.com/${gitAuthor.name}/)`,
      });
    });

    it('returns error when language scope is missing', async () => {
      expect(await parseCommit(buildTestCommit())).toEqual(
        expect.objectContaining({
          error: 'missing-language-scope',
        })
      );
    });

    it('returns error when language scope is unknown', async () => {
      expect(await parseCommit(buildTestCommit({ scope: 'unkown' }))).toEqual(
        expect.objectContaining({
          error: 'unknown-language-scope',
        })
      );
    });

    it('returns error when it is a generated commit', async () => {
      expect(
        await parseCommit(
          buildTestCommit({
            type: 'chore',
            message: 'generated code for commit',
          })
        )
      ).toEqual({
        error: 'generation-commit',
      });
    });

    it('returns error when it is a generated commit, even with other casing', async () => {
      expect(
        await parseCommit(
          buildTestCommit({
            type: 'chore',
            message: 'GENERATED CODE FOR COMMIT',
          })
        )
      ).toEqual({
        error: 'generation-commit',
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
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
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

          ruby: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          scala: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          csharp: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          swift: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
        })
      ).toMatchInlineSnapshot(`
        "- csharp: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - dart: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - go: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - java: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - javascript: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - kotlin: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - php: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - python: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - ruby: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - scala: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - swift: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**"
      `);
    });

    it('generates text for version changes with a language with no commit', () => {
      expect(
        getVersionChangesText({
          javascript: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          php: {
            current: '0.0.1',
            releaseType: null,
            noCommit: true,
            next: null,
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
            releaseType: null,
            noCommit: true,
            next: null,
          },

          ruby: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          scala: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          csharp: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          swift: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },
        })
      ).toMatchInlineSnapshot(`
        "- csharp: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - dart: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - go: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - java: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - javascript: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - kotlin: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - ~php: 0.0.1 (no commit)~
        - ~python: 0.0.1 (no commit)~
        - ruby: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - scala: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - swift: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**"
      `);
    });

    it('generates text for version changes with a language to skip', () => {
      expect(
        getVersionChangesText({
          javascript: {
            current: '0.0.1',
            releaseType: 'patch',
            next: getNextVersion('0.0.1', 'patch'),
          },

          php: {
            current: '0.0.1',
            releaseType: 'minor',
            next: getNextVersion('0.0.1', 'minor'),
          },

          java: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          go: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          kotlin: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          dart: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          python: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          ruby: {
            current: '3.0.0.alpha.0',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('3.0.0.alpha.0', 'minor'),
          },

          scala: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          csharp: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },

          swift: {
            current: '0.0.1',
            releaseType: null,
            skipRelease: true,
            next: getNextVersion('0.0.1', null),
          },
        })
      ).toMatchInlineSnapshot(`
        "- ~csharp: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~dart: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~go: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~java: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - javascript: 0.0.1 -> **\`patch\` _(e.g. 0.0.2)_**
        - ~kotlin: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - php: 0.0.1 -> **\`minor\` _(e.g. 0.1.0)_**
        - ~python: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~ruby: 3.0.0.alpha.0 -> **\`null\` _(e.g. 3.0.0.alpha.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~scala: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default.
        - ~swift: 0.0.1 -> **\`null\` _(e.g. 0.0.1)_**~
          - No \`feat\` or \`fix\` commit, thus unchecked by default."
      `);
    });
  });

  describe('decideReleaseStrategy', () => {
    it('bumps major version for BREAKING CHANGE', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'javascript',
              message: 'update the API (BREAKING CHANGE)',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.releaseType).toEqual('major');
      expect(versions.javascript.next).toEqual('1.0.0');
    });

    for (const releaseType of ['major', 'minor', 'patch', 'prerelease']) {
    it(`allows forcing ${releaseType} releases`, async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [],
        languages: LANGUAGES,
        releaseType: releaseType as ReleaseType,
      });

      expect(versions.javascript.releaseType).toEqual(releaseType);
      expect(versions.php.releaseType).toEqual(releaseType);
      expect(versions.java.releaseType).toEqual(releaseType);
    });
    }

    it('allows releasing subset of clients', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'javascript',
              message: 'update the API',
            })
          )) as PassedCommit,
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'java',
              message: 'update the API',
            })
          )) as PassedCommit,
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'php',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: ['php'],
      });

      expect(versions.javascript.skipRelease).toEqual(true);
      expect(versions.java.skipRelease).toEqual(true);
      expect(versions.php.skipRelease).toEqual(false);
      expect(versions.php.releaseType).toEqual('minor');
      expect(versions.php.next).toEqual('0.1.0');
    });

    it('bumps minor version for feat', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'php',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.php.releaseType).toEqual('minor');
      expect(versions.php.next).toEqual('0.1.0');
    });

    it('bumps patch version for fix', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'fix',
              scope: 'java',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.java.releaseType).toEqual('patch');
      expect(versions.java.next).toEqual('0.0.2');
    });

    it('marks noCommit for languages without any commit', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'fix',
              scope: 'java',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toEqual(true);
      expect(versions.php.noCommit).toEqual(true);
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('patch');
      expect(versions.java.next).toEqual('0.0.2');
    });

    it('releases every languages if a `specs` commit is present', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'fix',
              scope: 'specs',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toBeUndefined();
      expect(versions.javascript.releaseType).toEqual('patch');
      expect(versions.javascript.next).toEqual('0.0.2');
      expect(versions.php.noCommit).toBeUndefined();
      expect(versions.php.releaseType).toEqual('patch');
      expect(versions.php.next).toEqual('0.0.2');
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('patch');
      expect(versions.java.next).toEqual('0.0.2');
    });

    it('releases every languages if a `clients` commit is present', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'fix',
              scope: 'clients',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toBeUndefined();
      expect(versions.javascript.releaseType).toEqual('patch');
      expect(versions.javascript.next).toEqual('0.0.2');
      expect(versions.php.noCommit).toBeUndefined();
      expect(versions.php.releaseType).toEqual('patch');
      expect(versions.php.next).toEqual('0.0.2');
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('patch');
      expect(versions.java.next).toEqual('0.0.2');
    });

    it('bumps for `specs` feat with only language `fix` commits', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'fix',
              scope: 'php',
              message: 'update the API',
            })
          )) as PassedCommit,
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'specs',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toBeUndefined();
      expect(versions.javascript.releaseType).toEqual('minor');
      expect(versions.javascript.next).toEqual('0.1.0');
      expect(versions.php.noCommit).toBeUndefined();
      expect(versions.php.releaseType).toEqual('minor');
      expect(versions.php.next).toEqual('0.1.0');
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('minor');
      expect(versions.java.next).toEqual('0.1.0');
    });

    it('marks skipRelease for patch upgrade without fix commit', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1',
          },
          java: {
            current: '0.0.1',
          },
          php: {
            current: '0.0.1',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'chore',
              scope: 'javascript',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });
      expect(versions.javascript.skipRelease).toEqual(true);
      expect(versions.java.skipRelease).toBeUndefined();
      expect(versions.php.skipRelease).toBeUndefined();
    });

    it('consider prerelease version and correctly bumps them', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1-alpha',
          },
          java: {
            current: '0.0.1-beta',
          },
          php: {
            current: '0.0.1-algolia',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'specs',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toBeUndefined();
      expect(versions.javascript.releaseType).toEqual('prerelease');
      expect(versions.javascript.next).toEqual('0.0.1-alpha.0');
      expect(versions.php.noCommit).toBeUndefined();
      expect(versions.php.releaseType).toEqual('prerelease');
      expect(versions.php.next).toEqual('0.0.1-algolia.0');
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('prerelease');
      expect(versions.java.next).toEqual('0.0.1-beta.0');
    });

    it('bumps SNAPSHOT versions correctly', async () => {
      const versions = await decideReleaseStrategy({
        versions: {
          javascript: {
            current: '0.0.1-alpha',
          },
          java: {
            current: '0.0.1-SNAPSHOT',
          },
          php: {
            current: '0.0.1-beta',
          },
        },
        commits: [
          (await parseCommit(
            buildTestCommit({
              type: 'feat',
              scope: 'specs',
              message: 'update the API',
            })
          )) as PassedCommit,
        ],
        languages: LANGUAGES,
      });

      expect(versions.javascript.noCommit).toBeUndefined();
      expect(versions.javascript.releaseType).toEqual('prerelease');
      expect(versions.javascript.next).toEqual('0.0.1-alpha.0');
      expect(versions.php.noCommit).toBeUndefined();
      expect(versions.php.releaseType).toEqual('prerelease');
      expect(versions.php.next).toEqual('0.0.1-beta.0');
      expect(versions.java.noCommit).toBeUndefined();
      expect(versions.java.releaseType).toEqual('minor');
      expect(versions.java.next).toEqual('0.0.1-SNAPSHOT');
    });
  });

  describe('getSkippedCommitsText', () => {
    it('does not generate text if there is no commits', () => {
      expect(
        getSkippedCommitsText({
          commitsWithoutLanguageScope: [],
          commitsWithUnknownLanguageScope: [],
        })
      ).toMatchInlineSnapshot(`"_(None)_"`);
    });

    it('generates text for skipped commits', () => {
      expect(
        getSkippedCommitsText({
          commitsWithoutLanguageScope: [
            'abcdefg fix: something',
            'abcdefg fix: somethin2',
          ],

          commitsWithUnknownLanguageScope: [
            'abcdef2 fix(pascal): what',
            'abcdef2 fix(pascal): what is that',
          ],
        })
      ).toMatchInlineSnapshot(`
        "
        <p>It doesn't mean these commits are being excluded from the release. It means they're not taken into account when the release process figured out the next version number, and updated the changelog.</p>

        <details>
          <summary>
            <i>Commits without language scope:</i>
          </summary>

          - abcdefg fix: something
        - abcdefg fix: somethin2
        </details>

        <details>
          <summary>
            <i>Commits with unknown language scope:</i>
          </summary>

          - abcdef2 fix(pascal): what
        - abcdef2 fix(pascal): what is that
        </details>"
      `);
    });

    it('limits the size of the commits to 15 if there is too many', async () => {
      const fakeCommitsWithoutLanguageScope: string[] = [];
      const fakeCommitsWithUnknownLanguageScope: string[] = [];

      for (let i = 0; i < 20; i++) {
        const withoutCommit = await parseCommit(
          buildTestCommit({ message: `something ${i}` })
        );
        const unknownCommit = await parseCommit(
          buildTestCommit({ message: `something ${i}`, scope: 'unknown' })
        );

        if ('message' in withoutCommit && 'message' in unknownCommit) {
          fakeCommitsWithoutLanguageScope.push(withoutCommit.message);
          fakeCommitsWithUnknownLanguageScope.push(unknownCommit.message);
        }
      }

      expect(
        getSkippedCommitsText({
          commitsWithoutLanguageScope: fakeCommitsWithoutLanguageScope,
          commitsWithUnknownLanguageScope: fakeCommitsWithUnknownLanguageScope,
        })
      ).toMatchInlineSnapshot(`
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
        </details>

        <details>
          <summary>
            <i>Commits with unknown language scope:</i>
          </summary>

          - fix(unknown): something 0
        - fix(unknown): something 1
        - fix(unknown): something 2
        - fix(unknown): something 3
        - fix(unknown): something 4
        - fix(unknown): something 5
        - fix(unknown): something 6
        - fix(unknown): something 7
        - fix(unknown): something 8
        - fix(unknown): something 9
        - fix(unknown): something 10
        - fix(unknown): something 11
        - fix(unknown): something 12
        - fix(unknown): something 13
        - fix(unknown): something 14
        </details>"
      `);
    });
  });
});
