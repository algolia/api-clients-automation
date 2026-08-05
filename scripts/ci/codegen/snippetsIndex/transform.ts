import { createHash } from 'node:crypto';
import { readFile } from 'node:fs/promises';

import { toAbsolutePath } from '../../../common.ts';

import { encodeVersion } from './version.ts';
import type { VersionedSnippet } from './versionRanges.ts';

/**
 * Snippets index — record shaping.
 *
 * Turns the in-memory `VersionedSnippet[]` into the two record sets that get pushed to
 * Algolia:
 *   - `snippets`: one lean record per version era (the code + versions). Keyed by a stable
 *     `objectID`, so re-runs are idempotent — the same era always maps to the same document.
 *   - `catalog`: one record per current `api`+`operationId`, carrying the human title/description
 *     joined from the OpenAPI spec (`docs/bundled/<api>.json`). This is the discovery grain.
 */

export type SnippetRecord = {
  objectID: string;
  api: string;
  operationId: string;
  language: string;
  variant: string;
  code: string;
  versionFrom: string;
  versionTo: string;
  /** Ranking-only (customRanking keeps the newest eras when a query truncates); matching uses the strings. */
  versionFromNum: number;
  isCurrent: boolean;
  firstVersionUnknown: boolean;
};

export type CatalogRecord = {
  objectID: string;
  api: string;
  operationId: string;
  title: string;
  description: string;
  /** Languages this operation currently ships a snippet for, sorted. */
  languages: string[];
};

/** `${api}|${operationId}` -> its human title/description. */
export type DescriptionLookup = Map<string, { title: string; description: string }>;

/** Pseudo-operations that aren't in the OpenAPI spec but are still worth discovering. */
const PSEUDO_OP_DESCRIPTIONS: Record<string, { title: string; description: string }> = {
  import: { title: 'Import the client', description: 'How to import the Algolia client into your project.' },
  init: { title: 'Initialize the client', description: 'How to create and configure an Algolia client instance.' },
};

function descriptionKey(api: string, operationId: string): string {
  return `${api}|${operationId}`;
}

/** Stable id for one snippet era. Uniqueness is enforced by {@link assertUniqueObjectIDs}. */
export function snippetObjectID(range: VersionedSnippet): string {
  const identity = `${range.api}|${range.operationId}|${range.language}|${range.variant}|${range.versionFrom}`;
  return createHash('sha1').update(identity).digest('hex');
}

/**
 * Two eras of the same snippet can share a `versionFrom` (code changed between tags without a
 * version bump, or the `0.0.0` sentinel), which would collide on `objectID` and silently drop
 * one record at index time. Fail loud instead so a human resolves the ambiguity.
 */
export function assertUniqueObjectIDs(records: SnippetRecord[]): void {
  const seen = new Map<string, SnippetRecord>();
  for (const record of records) {
    const other = seen.get(record.objectID);
    if (other) {
      throw new Error(
        `objectID collision: two eras of ${record.api}|${record.operationId}|${record.language}|${record.variant}` +
          ` share versionFrom ${record.versionFrom} (versionTo ${other.versionTo} vs ${record.versionTo})`,
      );
    }
    seen.set(record.objectID, record);
  }
}

/** One `VersionedSnippet` -> one `snippets` record (adds objectID + numeric versions). */
export function snippetRecord(range: VersionedSnippet): SnippetRecord {
  return {
    objectID: snippetObjectID(range),
    api: range.api,
    operationId: range.operationId,
    language: range.language,
    variant: range.variant,
    code: range.code,
    versionFrom: range.versionFrom,
    versionTo: range.versionTo,
    versionFromNum: encodeVersion(range.versionFrom),
    isCurrent: range.isCurrent,
    firstVersionUnknown: range.firstVersionUnknown,
  };
}

/**
 * Build the `catalog` records: one per current `api`+`operationId`, with descriptions joined
 * from `descriptions` (falling back to a pseudo-op blurb, then to the raw operationId). Only
 * currently-shipping operations are catalogued — the catalog reflects the live API surface,
 * not retired operations.
 */
export function buildCatalog(ranges: VersionedSnippet[], descriptions: DescriptionLookup): CatalogRecord[] {
  const byOp = new Map<string, { api: string; operationId: string; languages: Set<string> }>();

  for (const range of ranges) {
    if (!range.isCurrent) {
      continue;
    }
    const key = descriptionKey(range.api, range.operationId);
    let entry = byOp.get(key);
    if (!entry) {
      entry = { api: range.api, operationId: range.operationId, languages: new Set() };
      byOp.set(key, entry);
    }
    entry.languages.add(range.language);
  }

  return [...byOp.values()].map((entry) => {
    const desc = descriptions.get(descriptionKey(entry.api, entry.operationId)) ??
      PSEUDO_OP_DESCRIPTIONS[entry.operationId] ?? { title: entry.operationId, description: '' };
    return {
      objectID: descriptionKey(entry.api, entry.operationId),
      api: entry.api,
      operationId: entry.operationId,
      title: desc.title,
      description: desc.description,
      languages: [...entry.languages].sort(),
    };
  });
}

// ---------------------------------------------------------------------------
// Description IO
// ---------------------------------------------------------------------------

interface OpenApiSpec {
  paths?: Record<string, Record<string, { operationId?: string; summary?: string; description?: string }>>;
}

/** Read `docs/bundled/<api>.json` for each api and map `api|operationId` -> title/description. */
export async function readDescriptions(apis: string[]): Promise<DescriptionLookup> {
  const lookup: DescriptionLookup = new Map();

  for (const api of apis) {
    let spec: OpenApiSpec;
    try {
      spec = JSON.parse(await readFile(toAbsolutePath(`docs/bundled/${api}.json`), 'utf8')) as OpenApiSpec;
    } catch (error) {
      if ((error as NodeJS.ErrnoException).code === 'ENOENT') {
        continue; // no spec for this api (e.g. a snippets-only bundle) — ops fall back to pseudo/raw
      }
      // An existing spec that fails to read or parse would silently degrade every catalog title.
      throw new Error(`failed to read spec docs/bundled/${api}.json: ${error}`);
    }
    for (const byMethod of Object.values(spec.paths ?? {})) {
      for (const op of Object.values(byMethod)) {
        if (op && typeof op === 'object' && typeof op.operationId === 'string') {
          lookup.set(descriptionKey(api, op.operationId), {
            title: op.summary ?? op.operationId,
            description: op.description ?? '',
          });
        }
      }
    }
  }

  return lookup;
}

/** Shape the ranges into both record sets, reading OpenAPI descriptions for the catalog. */
export async function transform(
  ranges: VersionedSnippet[],
): Promise<{ snippets: SnippetRecord[]; catalog: CatalogRecord[] }> {
  const apis = [...new Set(ranges.map((range) => range.api))];
  const descriptions = await readDescriptions(apis);
  const snippets = ranges.map(snippetRecord);
  assertUniqueObjectIDs(snippets);
  return {
    snippets,
    catalog: buildCatalog(ranges, descriptions),
  };
}
