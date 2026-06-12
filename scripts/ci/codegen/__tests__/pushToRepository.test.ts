import { describe, expect, it, vi } from 'vitest';

import { pushConfiguredRepositories } from '../pushToRepository.ts';
import type { RepositoryConfiguration } from '../types.ts';

describe('pushConfiguredRepositories', () => {
  it('maps settled failures to the selected repository list', async () => {
    const pushRepository = vi.fn(async (_repository: string, _config: RepositoryConfiguration): Promise<void> => {
      throw new Error('push failed');
    });

    const failedRepositories = await pushConfiguredRepositories(['missing-repository', 'go'], pushRepository);

    expect(failedRepositories).toEqual(['go']);
    expect(pushRepository).toHaveBeenCalledTimes(1);
    expect(pushRepository.mock.calls.map(([repository]) => repository)).toEqual(['go']);
  });

  it('continues pushing every selected repository when one fails', async () => {
    const pushRepository = vi.fn(async (repository: string, _config: RepositoryConfiguration): Promise<void> => {
      if (repository === 'docs-new') {
        throw new Error('docs push failed');
      }
    });

    const failedRepositories = await pushConfiguredRepositories(['docs-new', 'go'], pushRepository);

    expect(failedRepositories).toEqual(['docs-new']);
    expect(pushRepository.mock.calls.map(([repository]) => repository)).toEqual(['docs-new', 'go']);
  });
});
