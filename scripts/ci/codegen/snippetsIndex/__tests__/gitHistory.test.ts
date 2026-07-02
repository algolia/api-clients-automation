import { describe, expect, it } from 'vitest';

import { apiFromSnippetsPath, parseVersions, selectReachable } from '../gitHistory.ts';

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
