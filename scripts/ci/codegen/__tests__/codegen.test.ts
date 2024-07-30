import { describe, expect, it, vi } from "vitest";
import { pushGeneratedCode } from '../pushGeneratedCode.js';

vi.mock('../../../common.js', async () => {
  const mod = await vi.importActual<typeof import('../../../common.js')>('../../../common.js')
  return {
    ...mod,
    run: vi.fn().mockResolvedValue(''),
  }
});

describe('pushGeneratedCode', () => {
  it('throws without GITHUB_TOKEN environment variable', async () => {
    process.env.GITHUB_TOKEN = '';
    await expect(pushGeneratedCode()).rejects.toThrow(
      'Environment variable `GITHUB_TOKEN` does not exist.'
    );
  });
});
