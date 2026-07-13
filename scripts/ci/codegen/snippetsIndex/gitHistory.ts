import { readdir, readFile } from 'node:fs/promises';
import path from 'node:path';

import { execa } from 'execa';

import { ROOT_DIR, toAbsolutePath } from '../../../common.ts';

import type { ApiSnippets, ReleaseSnapshot } from './versionRanges.ts';

/**
 * Snippets index — timeline assembly.
 *
 * Builds the chronological `ReleaseSnapshot[]` that `buildVersionRanges` consumes:
 * every reachable `released-*` tag read straight from git, plus the current working
 * tree as the newest `HEAD` snapshot. Bundled snippets only landed in the repo in
 * Oct 2024, so anything before that is skipped.
 */

/** Bundled snippets first appeared at this release; earlier tags have no snippet data to read. */
export const FIRST_SNAPSHOT_DATE = '2024-10-10';

const BUNDLED_DIR = 'docs/bundled';
const CLIENTS_CONFIG = 'config/clients.config.json';
const SNIPPETS_SUFFIX = '-snippets.json';

/** `docs/bundled/search-snippets.json` -> `search`; anything that isn't a snippets bundle -> null. */
export function apiFromSnippetsPath(filePath: string): string | null {
  const base = filePath.split('/').pop() ?? '';
  if (!base.endsWith(SNIPPETS_SUFFIX)) {
    return null;
  }
  return base.slice(0, -SNIPPETS_SUFFIX.length);
}

/** `clients.config.json` contents -> `{ language: packageVersion }`. Skips `$schema` and version-less entries. */
export function parseVersions(configContent: string): Record<string, string> {
  const config = JSON.parse(configContent) as Record<string, { packageVersion?: string }>;
  const versions: Record<string, string> = {};
  for (const [language, entry] of Object.entries(config)) {
    if (language.startsWith('$')) {
      continue;
    }
    if (entry && typeof entry.packageVersion === 'string') {
      versions[language] = entry.packageVersion;
    }
  }
  return versions;
}

/** Keep tags on/after `sinceDate`, preserving the (chronological) input order. */
export function selectReachable<T extends { date: string }>(tags: T[], sinceDate = FIRST_SNAPSHOT_DATE): T[] {
  return tags.filter((t) => t.date >= sinceDate);
}

async function git(args: string[]): Promise<string> {
  const { stdout } = await execa('git', args, { cwd: ROOT_DIR, maxBuffer: 256 * 1024 * 1024 });
  return stdout;
}

/** All `released-*` tags with their commit dates, in chronological (commit-date) order. */
async function listReleaseTags(): Promise<Array<{ tag: string; date: string }>> {
  const out = await git([
    'for-each-ref',
    '--sort=creatordate',
    '--format=%(refname:short)|%(creatordate:short)',
    'refs/tags/released-*',
  ]);
  return out
    .split('\n')
    .filter(Boolean)
    .map((line) => {
      const [tag, date] = line.split('|');
      return { tag, date };
    });
}

/** Blob OIDs for the bundled snippet files (by api) and the clients config at a given ref. */
async function blobsAt(ref: string): Promise<{ config?: string; snippets: Record<string, string> }> {
  const out = await git(['ls-tree', '-r', ref, '--', BUNDLED_DIR, CLIENTS_CONFIG]);
  const snippets: Record<string, string> = {};
  let config: string | undefined;
  for (const line of out.split('\n').filter(Boolean)) {
    const tab = line.indexOf('\t');
    if (tab < 0) {
      continue;
    }
    const filePath = line.slice(tab + 1);
    const oid = line.slice(0, tab).split(/\s+/)[2];
    if (filePath === CLIENTS_CONFIG) {
      config = oid;
      continue;
    }
    const api = apiFromSnippetsPath(filePath);
    if (api) {
      snippets[api] = oid;
    }
  }
  return { config, snippets };
}

export interface BuildTimelineOptions {
  /** Date stamped on the HEAD snapshot (defaults to today). */
  headDate?: string;
  /** Only include releases on/after this date (defaults to {@link FIRST_SNAPSHOT_DATE}). */
  sinceDate?: string;
}

/**
 * Assemble the full timeline: reachable `released-*` tags (oldest -> newest) read from
 * git, followed by the current working tree as a final `HEAD` snapshot.
 */
export async function buildTimeline(options: BuildTimelineOptions = {}): Promise<ReleaseSnapshot[]> {
  const tags = selectReachable(await listReleaseTags(), options.sinceDate ?? FIRST_SNAPSHOT_DATE);

  // An empty tag list means we can't see history (shallow clone, missing tags) — pushing
  // from here would replace the full index with a HEAD-only snapshot. Fail loud instead.
  if (tags.length === 0) {
    throw new Error(
      'no released-* tags found in range — shallow clone or missing tags? ' +
        'run `git fetch --unshallow --tags` (or check SINCE_DATE) before indexing',
    );
  }

  // Parse each unique blob once; many tags share the same file contents.
  const snippetsByOid = new Map<string, ApiSnippets>();
  const versionsByOid = new Map<string, Record<string, string>>();

  const snippetsForOid = async (oid: string): Promise<ApiSnippets> => {
    const cached = snippetsByOid.get(oid);
    if (cached) {
      return cached;
    }
    const parsed = JSON.parse(await git(['cat-file', '-p', oid])) as ApiSnippets;
    snippetsByOid.set(oid, parsed);
    return parsed;
  };

  const versionsForOid = async (oid: string): Promise<Record<string, string>> => {
    const cached = versionsByOid.get(oid);
    if (cached) {
      return cached;
    }
    const parsed = parseVersions(await git(['cat-file', '-p', oid]));
    versionsByOid.set(oid, parsed);
    return parsed;
  };

  const timeline: ReleaseSnapshot[] = [];
  for (const { tag, date } of tags) {
    const { config, snippets } = await blobsAt(tag);
    const versions = config ? await versionsForOid(config) : {};
    const apiSnippets: Record<string, ApiSnippets> = {};
    for (const [api, oid] of Object.entries(snippets)) {
      apiSnippets[api] = await snippetsForOid(oid);
    }
    timeline.push({ tag, date, versions, snippets: apiSnippets });
  }

  timeline.push(await readHeadSnapshot(options.headDate));
  return timeline;
}

/** The current working tree as a snapshot — what's about to ship. */
async function readHeadSnapshot(headDate?: string): Promise<ReleaseSnapshot> {
  const bundledDir = toAbsolutePath(BUNDLED_DIR);
  const files = (await readdir(bundledDir)).filter((file) => file.endsWith(SNIPPETS_SUFFIX));

  const snippets: Record<string, ApiSnippets> = {};
  for (const file of files) {
    const api = apiFromSnippetsPath(file);
    if (api) {
      snippets[api] = JSON.parse(await readFile(path.join(bundledDir, file), 'utf8')) as ApiSnippets;
    }
  }

  const versions = parseVersions(await readFile(toAbsolutePath(CLIENTS_CONFIG), 'utf8'));
  return { tag: 'HEAD', date: headDate ?? new Date().toISOString().slice(0, 10), versions, snippets };
}
