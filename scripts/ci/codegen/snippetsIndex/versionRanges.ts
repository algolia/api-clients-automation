/**
 * Snippets index — version-range builder.
 *
 * A snippet's code rarely changes between releases, so storing it once per
 * release would mean a lot of near-duplicate records. Instead we store each snippet
 * once per *version range*: walk releases oldest -> newest, and whenever the
 * code is unchanged just stretch the current range; when it changes, close the
 * old range and start a new one; when a snippet disappears, close its range too.
 */

import { encodeVersion } from './version.ts';

/** language -> operationId -> variant -> code. Structurally compatible with specs' `CodeSamples`. */
export type ApiSnippets = Record<string, Record<string, Record<string, string>>>;

/** One release: its per-language package versions and the snippets shipped at that point. */
export interface ReleaseSnapshot {
  /** Git ref, e.g. `released-2024-10-10-4f5b1620e` or `HEAD`. */
  tag: string;
  /** Release date, `YYYY-MM-DD`. */
  date: string;
  /** Per-language package version at this release, e.g. `{ python: '4.23.0' }`. */
  versions: Record<string, string>;
  /** api -> language -> operationId -> variant -> code (parsed `docs/bundled/<api>-snippets.json`). */
  snippets: Record<string, ApiSnippets>;
}

/** One snippet's code together with the package-version range it was current for. */
export interface VersionedSnippet {
  api: string;
  language: string;
  operationId: string;
  variant: string;
  code: string;
  /** First version we saw this code at. A lower bound when `firstVersionUnknown` is true. */
  versionFrom: string;
  /** Last version we saw this code at. For current snippets, the newest release's version. */
  versionTo: string;
  /**
   * True when this code was already shipping at the start of our history, so its real first
   * version predates the snippets we have on record and `versionFrom` is a floor, not exact.
   */
  firstVersionUnknown: boolean;
  /** True when this is still the code shipping at the newest release. */
  isCurrent: boolean;
}

/**
 * Collapse a chronological timeline of releases into per-version-range snippet records.
 * See the file header for the one-paragraph explanation.
 */
export function buildVersionRanges(timeline: ReleaseSnapshot[]): VersionedSnippet[] {
  const open = new Map<string, VersionedSnippet>();
  const done: VersionedSnippet[] = [];
  const lastVersions = new Map<string, string>();

  timeline.forEach((release, index) => {
    // Range stretching assumes each language's version stream never goes backwards
    // across the timeline. A backport release (tagged after a newer one) or a bad
    // clients.config.json at one tag would silently corrupt the ranges — fail loud.
    for (const [language, version] of Object.entries(release.versions)) {
      const previous = lastVersions.get(language);
      if (previous !== undefined && encodeVersion(version) < encodeVersion(previous)) {
        throw new Error(`${language} package version went backwards at ${release.tag}: ${previous} -> ${version}`);
      }
      lastVersions.set(language, version);
    }

    const seenThisRelease = new Set<string>();

    for (const [api, byLanguage] of Object.entries(release.snippets)) {
      for (const [language, byOperation] of Object.entries(byLanguage)) {
        for (const [operationId, byVariant] of Object.entries(byOperation)) {
          for (const [variant, code] of Object.entries(byVariant)) {
            const key = `${api} ${language} ${operationId} ${variant}`;
            seenThisRelease.add(key);
            const current = open.get(key);
            const version = release.versions[language] ?? current?.versionTo ?? '0.0.0';

            if (current && current.code === code) {
              // Same code, newer release: stretch the range forward.
              current.versionTo = version;
            } else {
              // Code changed (or first sight): close the old range, start a new one.
              if (current) {
                done.push({ ...current, isCurrent: false });
              }
              open.set(key, {
                api,
                language,
                operationId,
                variant,
                code,
                versionFrom: version,
                versionTo: version,
                // Unknown first version only when the range starts at the very first release we can see.
                firstVersionUnknown: index === 0,
                isCurrent: true,
              });
            }
          }
        }
      }
    }

    // A snippet present before but missing now was removed/renamed: close its range.
    for (const [key, range] of open) {
      if (!seenThisRelease.has(key)) {
        done.push({ ...range, isCurrent: false });
        open.delete(key);
      }
    }
  });

  // Whatever is still open is the code shipping at HEAD.
  return [...done, ...open.values()];
}
