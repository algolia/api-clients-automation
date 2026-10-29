import { describe, expect, it, vi } from 'vitest';

import { getOctokit } from '../../../common.ts';
import { getReleaseWarnings } from '../waitForAllReleases.ts';

vi.mock('../../../common.ts', async (importOriginal) => {
  return {
    // eslint-disable-next-line
    ...(await importOriginal<typeof import('../../../common.ts')>()),
    getOctokit: vi.fn(),
  };
});

describe('getReleaseWarnings', () => {
  it('only reports warning annotations carrying the release-warning title prefix', async () => {
    const annotations = [
      { annotation_level: 'warning', title: 'release-warning: CocoaPods publish failed' },
      { annotation_level: 'warning', title: 'Node.js 20 actions are deprecated' },
      { annotation_level: 'failure', title: 'release-warning: not a warning' },
      { annotation_level: 'warning', title: null },
    ];
    const listJobsForWorkflowRun = vi.fn();
    const listAnnotations = vi.fn();
    const octokit = {
      actions: { listJobsForWorkflowRun },
      checks: { listAnnotations },
      paginate: vi
        .fn()
        .mockImplementation(async (fn: unknown) => (fn === listJobsForWorkflowRun ? [{ id: 1 }] : annotations)),
    };
    vi.mocked(getOctokit).mockReturnValue(octokit as unknown as ReturnType<typeof getOctokit>);

    await expect(getReleaseWarnings('swift', 42)).resolves.toEqual(['CocoaPods publish failed']);
  });
});
