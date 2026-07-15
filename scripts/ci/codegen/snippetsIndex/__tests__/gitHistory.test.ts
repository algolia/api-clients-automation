import { describe, expect, it } from 'vitest';

import { apiFromSnippetsPath, parseBatchBlobs, parseVersions, selectReachable } from '../gitHistory.ts';

describe('apiFromSnippetsPath', () => {
  it('extracts the api name from a bundled snippets path', () => {
    expect(apiFromSnippetsPath('docs/bundled/search-snippets.json')).toBe('search');
    expect(apiFromSnippetsPath('docs/bundled/abtesting-v3-snippets.json')).toBe('abtesting-v3');
    expect(apiFromSnippetsPath('search-snippets.json')).toBe('search'); // bare filename works too
  });

  it('returns null for non-snippet files', () => {
    expect(apiFromSnippetsPath('docs/bundled/search.json')).toBeNull(); // the OpenAPI spec, not snippets
    expect(apiFromSnippetsPath('config/clients.config.json')).toBeNull();
  });
});

describe('parseVersions', () => {
  it('maps each language to its packageVersion', () => {
    const config = JSON.stringify({
      $schema: './clients.schema.json',
      javascript: { packageVersion: '5.55.1', clients: [] },
      python: { packageVersion: '4.44.1' },
    });
    expect(parseVersions(config)).toEqual({ javascript: '5.55.1', python: '4.44.1' });
  });

  it('skips the $schema key and entries without a version', () => {
    const config = JSON.stringify({
      $schema: 'x',
      go: { packageVersion: '4.43.1' },
      weird: { clients: ['search'] },
    });
    expect(parseVersions(config)).toEqual({ go: '4.43.1' });
  });
});

describe('parseBatchBlobs', () => {
  /** One framed `cat-file --batch` response: header, payload, terminating newline. */
  function entry(oid: string, content: string): Buffer {
    const payload = Buffer.from(content, 'utf8');
    return Buffer.concat([Buffer.from(`${oid} blob ${payload.length}\n`), payload, Buffer.from('\n')]);
  }

  it('splits the framed output into per-oid contents', () => {
    const output = Buffer.concat([entry('aaa', '{"x":1}'), entry('bbb', 'second')]);
    expect(parseBatchBlobs(output)).toEqual(
      new Map([
        ['aaa', '{"x":1}'],
        ['bbb', 'second'],
      ]),
    );
  });

  it('slices by bytes, not characters (multi-byte payloads stay framed)', () => {
    // 'héllo — ✓' is 9 characters but 14 bytes; slicing by characters would eat
    // into the next entry's header.
    const output = Buffer.concat([entry('aaa', 'héllo — ✓'), entry('bbb', 'after')]);
    expect(parseBatchBlobs(output)).toEqual(
      new Map([
        ['aaa', 'héllo — ✓'],
        ['bbb', 'after'],
      ]),
    );
  });

  it('handles payloads containing newlines', () => {
    const output = entry('aaa', '{\n  "multi": "line"\n}');
    expect(parseBatchBlobs(output).get('aaa')).toBe('{\n  "multi": "line"\n}');
  });

  it('throws on a missing oid instead of silently skipping it', () => {
    expect(() => parseBatchBlobs(Buffer.from('aaa missing\n'))).toThrow(/unexpected cat-file response: "aaa missing"/);
  });

  it('returns an empty map for empty output', () => {
    expect(parseBatchBlobs(Buffer.alloc(0))).toEqual(new Map());
  });
});

describe('selectReachable', () => {
  const tags = [
    { tag: 'released-2024-09-01-aaa', date: '2024-09-01' },
    { tag: 'released-2024-10-10-bbb', date: '2024-10-10' },
    { tag: 'released-2025-01-01-ccc', date: '2025-01-01' },
  ];

  it('drops tags before the first-snapshot date, preserving order', () => {
    expect(selectReachable(tags).map((t) => t.tag)).toEqual(['released-2024-10-10-bbb', 'released-2025-01-01-ccc']);
  });

  it('honors a custom sinceDate', () => {
    expect(selectReachable(tags, '2025-01-01').map((t) => t.tag)).toEqual(['released-2025-01-01-ccc']);
  });
});
