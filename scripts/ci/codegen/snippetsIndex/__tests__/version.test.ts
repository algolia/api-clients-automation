import { describe, expect, it } from 'vitest';

import { encodeVersion } from '../version.ts';

describe('encodeVersion', () => {
  it('encodes major/minor/patch into one sortable integer', () => {
    expect(encodeVersion('5.9.1')).toBe(5_009_001);
    expect(encodeVersion('5.10.0')).toBe(5_010_000);
    expect(encodeVersion('4.44.1')).toBe(4_044_001);
  });

  it('orders numerically where string compare would not (5.9.1 < 5.10.0)', () => {
    expect(encodeVersion('5.9.1')).toBeLessThan(encodeVersion('5.10.0'));
    expect('5.9.1' < '5.10.0').toBe(false); // the bug we are avoiding
  });

  it('maps the 0.0.0 sentinel and unparseable input to 0', () => {
    expect(encodeVersion('0.0.0')).toBe(0);
    expect(encodeVersion('not-a-version')).toBe(0);
    expect(encodeVersion('')).toBe(0);
  });

  it('coerces loosely-formatted versions', () => {
    expect(encodeVersion('v5.9.1')).toBe(5_009_001);
    expect(encodeVersion('5.9.1-beta.2')).toBe(5_009_001); // prerelease collapsed
  });

  it('throws when minor or patch would overflow the encoding range', () => {
    expect(() => encodeVersion('5.1000.0')).toThrow(/encoding range/);
    expect(() => encodeVersion('5.0.1000')).toThrow(/encoding range/);
  });
});
