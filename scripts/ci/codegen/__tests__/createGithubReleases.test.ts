import { afterAll, describe, expect, it, vi } from 'vitest';
import { createGitHubRelease } from '../createGitHubReleases.ts';

describe('createGithubRelease', () => {
  afterAll(() => {
    vi.clearAllMocks();
  });

  it('generates a release', async () => {
    const createRelease = vi.fn().mockResolvedValue(undefined);
    const octokit = {
      repos: {
        createRelease,
      },
    } as any;

    vi.mock('../../utils.ts', async (importOriginal) => {
      return {
        // eslint-disable-next-line
        ...(await importOriginal<typeof import('../../utils.ts')>()),
        cloneRepository: vi.fn().mockResolvedValue({ tempGitDir: __dirname }),
      };
    });

    vi.mock('../../../common.ts', async (importOriginal) => {
      return {
        // eslint-disable-next-line
        ...(await importOriginal<typeof import('../../../common.ts')>()),
        run: vi.fn().mockResolvedValue('5.20.0\n5.19.0\n5.18.0\n5.17.1'),
      };
    });

    await expect(createGitHubRelease(octokit, 'dart')).resolves.toBeUndefined();

    expect(createRelease).toMatchSnapshot();
  });
});
