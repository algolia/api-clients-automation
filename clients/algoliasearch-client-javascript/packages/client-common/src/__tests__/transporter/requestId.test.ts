import { afterEach, describe, expect, test, vi } from 'vitest';
import { generateRequestId } from '../../transporter';

describe('generateRequestId', () => {
  afterEach(() => {
    vi.unstubAllGlobals();
  });

  test('matches the 11-char base62 format', () => {
    for (let i = 0; i < 1000; i++) {
      expect(generateRequestId()).toMatch(/^[0-9A-Za-z]{11}$/);
    }
  });

  test('generates distinct values across calls', () => {
    const ids = new Set(Array.from({ length: 10000 }, () => generateRequestId()));

    expect(ids.size).toBe(10000);
  });

  test('uses crypto.getRandomValues when available', () => {
    const getRandomValues = vi.fn((bytes: Uint8Array) => bytes.fill(0));
    vi.stubGlobal('crypto', { getRandomValues });

    expect(generateRequestId()).toBe('AAAAAAAAAAA');
    expect(getRandomValues).toHaveBeenCalledTimes(1);
  });

  test('falls back to Math.random when the crypto global is absent', () => {
    vi.stubGlobal('crypto', undefined);

    for (let i = 0; i < 1000; i++) {
      expect(generateRequestId()).toMatch(/^[0-9A-Za-z]{11}$/);
    }
  });

  test('generates distinct values without the crypto global', () => {
    vi.stubGlobal('crypto', undefined);

    const ids = new Set(Array.from({ length: 10000 }, () => generateRequestId()));

    expect(ids.size).toBe(10000);
  });
});
