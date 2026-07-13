import { describe, expect, it } from 'vitest';

import type { DescriptionLookup } from '../transform.ts';
import { assertUniqueObjectIDs, buildCatalog, snippetObjectID, snippetRecord } from '../transform.ts';
import type { VersionedSnippet } from '../versionRanges.ts';

function range(overrides: Partial<VersionedSnippet> = {}): VersionedSnippet {
  return {
    api: 'abtesting',
    language: 'javascript',
    operationId: 'addABTests',
    variant: 'default',
    code: 'const x = 1;',
    versionFrom: '5.8.1',
    versionTo: '5.9.1',
    firstVersionUnknown: false,
    isCurrent: true,
    ...overrides,
  };
}

describe('snippetRecord', () => {
  it('carries the snippet fields through and adds the ranking encoding', () => {
    const record = snippetRecord(range({ versionFrom: '5.8.1', versionTo: '5.10.0' }));
    expect(record).toMatchObject({
      api: 'abtesting',
      operationId: 'addABTests',
      language: 'javascript',
      variant: 'default',
      code: 'const x = 1;',
      versionFrom: '5.8.1',
      versionTo: '5.10.0',
      versionFromNum: 5_008_001,
      isCurrent: true,
      firstVersionUnknown: false,
    });
    expect(record).not.toHaveProperty('versionToNum'); // ranking never looks at versionTo
  });

  it('produces a stable objectID from identity + versionFrom', () => {
    const a = snippetObjectID(range());
    const b = snippetObjectID(range());
    expect(a).toBe(b); // same input -> same id (idempotent re-runs)
    expect(a).toMatch(/^[0-9a-f]{40}$/);
  });

  it('gives different eras of the same snippet different objectIDs', () => {
    expect(snippetObjectID(range({ versionFrom: '5.8.1' }))).not.toBe(
      snippetObjectID(range({ versionFrom: '5.10.0' })),
    );
  });
});

describe('assertUniqueObjectIDs', () => {
  it('accepts records whose eras all have distinct versionFroms', () => {
    const records = [
      snippetRecord(range({ versionFrom: '5.8.1', versionTo: '5.9.1', isCurrent: false })),
      snippetRecord(range({ versionFrom: '5.10.0', versionTo: '5.10.0' })),
    ];
    expect(() => assertUniqueObjectIDs(records)).not.toThrow();
  });

  it('throws when two eras of the same snippet share a versionFrom (would silently drop one record)', () => {
    // e.g. the code changed between two tags that did not bump the language version.
    const records = [
      snippetRecord(range({ code: 'old', versionFrom: '5.9.1', versionTo: '5.9.1', isCurrent: false })),
      snippetRecord(range({ code: 'new', versionFrom: '5.9.1', versionTo: '5.9.1' })),
    ];
    expect(() => assertUniqueObjectIDs(records)).toThrow(
      /objectID collision: two eras of abtesting\|addABTests\|javascript\|default share versionFrom 5\.9\.1/,
    );
  });
});

describe('buildCatalog', () => {
  const descriptions: DescriptionLookup = new Map([
    ['abtesting|addABTests', { title: 'Create an A/B test', description: 'Creates a new A/B test.' }],
  ]);

  it('emits one record per api+operationId, collecting the languages it ships in', () => {
    const catalog = buildCatalog(
      [
        range({ language: 'javascript' }),
        range({ language: 'python' }),
        range({ language: 'javascript', variant: 'all' }), // same op+language, different variant
      ],
      descriptions,
    );

    expect(catalog).toHaveLength(1);
    expect(catalog[0]).toMatchObject({
      objectID: 'abtesting|addABTests',
      api: 'abtesting',
      operationId: 'addABTests',
      title: 'Create an A/B test',
      description: 'Creates a new A/B test.',
      languages: ['javascript', 'python'], // sorted, deduped
    });
  });

  it('excludes retired operations (only current ranges are catalogued)', () => {
    const catalog = buildCatalog(
      [range({ operationId: 'addABTests', isCurrent: true }), range({ operationId: 'oldOp', isCurrent: false })],
      descriptions,
    );
    expect(catalog.map((c) => c.operationId)).toEqual(['addABTests']);
  });

  it('falls back to a pseudo-op blurb for import/init (not in the spec)', () => {
    const catalog = buildCatalog([range({ operationId: 'import' })], new Map());
    expect(catalog[0]).toMatchObject({ operationId: 'import', title: 'Import the client' });
    expect(catalog[0].description).toMatch(/import the algolia client/i);
  });

  it('falls back to the raw operationId when there is no description at all', () => {
    const catalog = buildCatalog([range({ operationId: 'mysteryOp' })], new Map());
    expect(catalog[0]).toMatchObject({ operationId: 'mysteryOp', title: 'mysteryOp', description: '' });
  });
});
