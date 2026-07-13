import { describe, expect, it } from 'vitest';

import type { ReleaseSnapshot, VersionedSnippet } from '../versionRanges.ts';
import { buildVersionRanges } from '../versionRanges.ts';

/** Build a release; `snippets` is api -> language -> operationId -> variant -> code. */
function release(
  tag: string,
  date: string,
  versions: Record<string, string>,
  snippets: ReleaseSnapshot['snippets'],
): ReleaseSnapshot {
  return { tag, date, versions, snippets };
}

/** All ranges matching a partial selector. */
function select(ranges: VersionedSnippet[], sel: Partial<VersionedSnippet>): VersionedSnippet[] {
  return ranges.filter((r) => Object.entries(sel).every(([k, v]) => r[k as keyof VersionedSnippet] === v));
}

describe('buildVersionRanges', () => {
  it('returns a single current range with an unknown first version for a one-release timeline', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({
      api: 'search',
      language: 'python',
      operationId: 'addApiKey',
      variant: 'minimal',
      code: 'A',
      versionFrom: '4.0.0',
      versionTo: '4.0.0',
      firstVersionUnknown: true, // shipping at the start of our history -> real first version unknown
      isCurrent: true,
    });
  });

  it('collapses unchanged code across many releases into one range', () => {
    const r = (tag: string, v: string): ReleaseSnapshot =>
      release(tag, '2024-10-10', { python: v }, { search: { python: { addApiKey: { minimal: 'A' } } } });

    const ranges = buildVersionRanges([r('t1', '4.0.0'), r('t2', '4.1.0'), r('t3', '4.2.0')]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({ versionFrom: '4.0.0', versionTo: '4.2.0', isCurrent: true });
  });

  it('starts a new range when code changes, closing the old one at its last version', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.1.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t3', '2024-12-01', { python: '4.2.0' }, { search: { python: { addApiKey: { minimal: 'B' } } } }),
    ]);

    expect(ranges).toHaveLength(2);
    // Closed ranges come first, then the still-open one.
    expect(ranges[0]).toMatchObject({
      code: 'A',
      versionFrom: '4.0.0',
      versionTo: '4.1.0', // boundary = version *before* the change
      firstVersionUnknown: true,
      isCurrent: false,
    });
    expect(ranges[1]).toMatchObject({
      code: 'B',
      versionFrom: '4.2.0',
      versionTo: '4.2.0',
      firstVersionUnknown: false, // a change observed mid-history has a real start
      isCurrent: true,
    });
  });

  it('marks a range that first appears mid-history as having a known first version', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { search: { default: 'S' } } } }),
      release(
        't2',
        '2024-11-01',
        { python: '4.1.0' },
        { search: { python: { search: { default: 'S' }, addApiKey: { minimal: 'A' } } } },
      ),
    ]);

    expect(select(ranges, { operationId: 'addApiKey' })[0]).toMatchObject({
      versionFrom: '4.1.0',
      firstVersionUnknown: false,
      isCurrent: true,
    });
    expect(select(ranges, { operationId: 'search' })[0]).toMatchObject({ firstVersionUnknown: true });
  });

  it('tracks languages independently, each with its own version stream', () => {
    const ranges = buildVersionRanges([
      release(
        't1',
        '2024-10-10',
        { python: '4.0.0', javascript: '5.0.0' },
        { search: { python: { addApiKey: { minimal: 'PY_A' } }, javascript: { addApiKey: { minimal: 'JS_A' } } } },
      ),
      release(
        't2',
        '2024-11-01',
        { python: '4.1.0', javascript: '5.1.0' },
        { search: { python: { addApiKey: { minimal: 'PY_B' } }, javascript: { addApiKey: { minimal: 'JS_A' } } } },
      ),
    ]);

    expect(select(ranges, { language: 'python' })).toHaveLength(2); // changed
    const js = select(ranges, { language: 'javascript' });
    expect(js).toHaveLength(1); // unchanged
    expect(js[0]).toMatchObject({ versionFrom: '5.0.0', versionTo: '5.1.0', isCurrent: true });
  });

  it('tracks variants of the same operation independently', () => {
    const ranges = buildVersionRanges([
      release(
        't1',
        '2024-10-10',
        { python: '4.0.0' },
        { search: { python: { addApiKey: { minimal: 'A', all: 'X' } } } },
      ),
      release(
        't2',
        '2024-11-01',
        { python: '4.1.0' },
        { search: { python: { addApiKey: { minimal: 'A', all: 'Y' } } } },
      ),
    ]);

    expect(select(ranges, { variant: 'minimal' })).toHaveLength(1); // unchanged
    expect(select(ranges, { variant: 'all' })).toHaveLength(2); // changed
  });

  it('separates two APIs that share an operationId (e.g. abtesting vs abtesting-v3)', () => {
    const ranges = buildVersionRanges([
      release(
        't1',
        '2024-10-10',
        { python: '4.0.0' },
        {
          abtesting: { python: { addABTests: { default: 'V2' } } },
          'abtesting-v3': { python: { addABTests: { default: 'V3' } } },
        },
      ),
    ]);

    expect(select(ranges, { api: 'abtesting' })[0]).toMatchObject({ code: 'V2' });
    expect(select(ranges, { api: 'abtesting-v3' })[0]).toMatchObject({ code: 'V3' });
  });

  it('closes a range as not-current when the snippet is removed', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.1.0' }, { search: { python: { search: { default: 'S' } } } }),
    ]);

    expect(select(ranges, { operationId: 'addApiKey' })[0]).toMatchObject({
      versionFrom: '4.0.0',
      versionTo: '4.0.0', // last version it was present at
      isCurrent: false,
    });
  });

  it('treats a removed-then-readded snippet as two separate ranges, even with identical code', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.1.0' }, { search: { python: { search: { default: 'S' } } } }),
      release('t3', '2024-12-01', { python: '4.2.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ]);

    const addApiKey = select(ranges, { operationId: 'addApiKey' });
    expect(addApiKey).toHaveLength(2);
    expect(addApiKey[0]).toMatchObject({ versionFrom: '4.0.0', isCurrent: false });
    expect(addApiKey[1]).toMatchObject({ versionFrom: '4.2.0', isCurrent: true, firstVersionUnknown: false });
  });

  it('handles an empty timeline', () => {
    expect(buildVersionRanges([])).toEqual([]);
  });

  it('throws when a language version goes backwards, naming the offending tag', () => {
    const timeline = [
      release('t1', '2024-10-10', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      // e.g. a 4.18.2 backport tagged after the 4.19.0 release.
      release('t2', '2024-11-01', { python: '4.18.2' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ];

    expect(() => buildVersionRanges(timeline)).toThrow(
      /python package version went backwards at t2: 4\.19\.0 -> 4\.18\.2/,
    );
  });

  it('accepts a release that does not bump a language version', () => {
    const timeline = [
      release('t1', '2024-10-10', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ];

    expect(buildVersionRanges(timeline)).toHaveLength(1);
  });
});
