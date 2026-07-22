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

  it('throws when a prerelease follows its own release (semver precedence, not numeric collapse)', () => {
    const timeline = [
      release('t1', '2024-10-10', { python: '6.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '6.0.0-beta.2' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ];

    expect(() => buildVersionRanges(timeline)).toThrow(
      /python package version went backwards at t2: 6\.0\.0 -> 6\.0\.0-beta\.2/,
    );
  });

  it('keeps eras split at a prerelease boundary distinct (beta and GA never merge)', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '6.0.0-beta.1' }, { search: { python: { addApiKey: { minimal: 'B' } } } }),
      release('t2', '2024-11-01', { python: '6.0.0' }, { search: { python: { addApiKey: { minimal: 'C' } } } }),
    ]);

    expect(ranges).toHaveLength(2);
    expect(ranges[0]).toMatchObject({
      code: 'B',
      versionFrom: '6.0.0-beta.1',
      versionTo: '6.0.0-beta.1',
      isCurrent: false,
    });
    expect(ranges[1]).toMatchObject({ code: 'C', versionFrom: '6.0.0', versionTo: '6.0.0', isCurrent: true });
  });

  it('drops a range superseded at its own version (code changed with no version bump)', () => {
    // e.g. a snippet regeneration fix between two tags that did not release the language:
    // code A never shipped under a version of its own, so only B survives for 4.19.0.
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'B' } } } }),
    ]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({ code: 'B', versionFrom: '4.19.0', versionTo: '4.19.0', isCurrent: true });
  });

  it('rewinds a multi-version range superseded at its final version (code changed with no version bump)', () => {
    // Same event as the drop case, but the old range also covered earlier versions, so it
    // survives — rewound to 4.18.0 so it does not share 4.19.0 with its replacement.
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.18.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t3', '2024-12-01', { python: '4.19.0' }, { search: { python: { addApiKey: { minimal: 'B' } } } }),
    ]);

    expect(ranges).toHaveLength(2);
    expect(ranges[0]).toMatchObject({ code: 'A', versionFrom: '4.18.0', versionTo: '4.18.0', isCurrent: false });
    expect(ranges[0]).not.toHaveProperty('prevVersionTo'); // bookkeeping stays internal
    expect(ranges[1]).toMatchObject({ code: 'B', versionFrom: '4.19.0', versionTo: '4.19.0', isCurrent: true });
  });

  it('falls back to the 0.0.0 sentinel when a language has no version, then picks up a real one', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', {}, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.1.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({ versionFrom: '0.0.0', versionTo: '4.1.0', isCurrent: true });
  });

  it('starts a new snippet at the last-seen language version when the version disappears', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { search: { default: 'S' } } } }),
      release(
        't2',
        '2024-11-01',
        {},
        { search: { python: { search: { default: 'S' }, addApiKey: { minimal: 'A' } } } },
      ),
    ]);

    // The new snippet has no open range to lean on, but the language's version is still known.
    expect(select(ranges, { operationId: 'addApiKey' })[0]).toMatchObject({
      versionFrom: '4.0.0',
      versionTo: '4.0.0',
      isCurrent: true,
    });
  });

  it('throws on an unparseable language version, naming the offending tag', () => {
    const timeline = [
      release('t1', '2024-10-10', { python: 'not-a-version' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ];

    expect(() => buildVersionRanges(timeline)).toThrow(/invalid python package version at t1: "not-a-version"/);
  });

  it('carries the previous versionTo forward when a version disappears mid-range', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', {}, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({ versionFrom: '4.0.0', versionTo: '4.0.0', isCurrent: true });
  });

  it('throws on a release with no snippets after snippets have been seen (corrupt tag guard)', () => {
    const timeline = [
      release('t1', '2024-10-10', { python: '4.0.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
      release('t2', '2024-11-01', { python: '4.1.0' }, {}), // bundled files missing at this tag
    ];

    expect(() => buildVersionRanges(timeline)).toThrow(/no snippets found at t2/);
  });

  it('tolerates leading releases with no snippets yet', () => {
    const ranges = buildVersionRanges([
      release('t1', '2024-10-10', { python: '4.0.0' }, {}),
      release('t2', '2024-11-01', { python: '4.1.0' }, { search: { python: { addApiKey: { minimal: 'A' } } } }),
    ]);

    expect(ranges).toHaveLength(1);
    expect(ranges[0]).toMatchObject({ versionFrom: '4.1.0', isCurrent: true });
  });
});
