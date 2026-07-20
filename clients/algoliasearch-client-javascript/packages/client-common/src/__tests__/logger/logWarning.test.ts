import { describe, expect, test, vi } from 'vitest';

import { createNullLogger, logWarning } from '../../logger';

describe('logWarning', () => {
  test('prefers the logger warn method when implemented', () => {
    vi.resetAllMocks();
    vi.spyOn(console, 'warn');

    const warn = vi.fn().mockResolvedValue(undefined);

    logWarning({ ...createNullLogger(), warn }, 'foo');

    expect(warn).toHaveBeenCalledWith('foo');
    expect(console.warn).toHaveBeenCalledTimes(0);
  });

  test('falls back to console.warn when the logger does not implement warn', () => {
    vi.resetAllMocks();
    vi.spyOn(console, 'warn');

    logWarning(createNullLogger(), 'foo');

    expect(console.warn).toHaveBeenCalledWith('foo');
  });

  test('does not leak an unhandled rejection when the logger warn rejects', async () => {
    const unhandled = vi.fn();
    process.on('unhandledRejection', unhandled);

    try {
      // a plain function: `vi.fn` attaches handlers to returned promises, hiding the leak
      const warn = () => Promise.reject(new Error('warn failed'));

      expect(() => logWarning({ ...createNullLogger(), warn }, 'foo')).not.toThrow();

      // a leaked rejection is only reported after the microtask queue drains
      await new Promise((resolve) => setTimeout(resolve, 0));

      expect(unhandled).not.toHaveBeenCalled();
    } finally {
      process.off('unhandledRejection', unhandled);
    }
  });
});
