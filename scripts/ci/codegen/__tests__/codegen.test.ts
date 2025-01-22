import { describe, expect, it, vi } from 'vitest';

import { pushGeneratedCode } from '../pushGeneratedCode.ts';

vi.mock('../../../common.ts', async (importOriginal) => {
  return {
    // eslint-disable-next-line
    ...(await importOriginal<typeof import('../../../common.ts')>()),
    run: vi.fn().mockResolvedValue(''),
  };
});

describe('pushGeneratedCode', () => {
  it('throws without GITHUB_TOKEN environment variable', async () => {
    vi.stubEnv('GITHUB_TOKEN', '');
    await expect(pushGeneratedCode()).rejects.toThrow('Environment variable `GITHUB_TOKEN` does not exist.');
  });
});
