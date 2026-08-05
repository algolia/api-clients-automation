/**
 * Snippets index — version-range builder.
 *
 * A snippet's code rarely changes between releases, so storing it once per
 * release would mean a lot of near-duplicate records. Instead we store each snippet
 * once per *version range*: walk releases oldest -> newest, and whenever the
 * code is unchanged just stretch the current range; when it changes, close the
 * old range and start a new one; when a snippet disappears, close its range too.
 */

import semver from 'semver';

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
  /**
   * Last version at which this code was the newest for that version. For current snippets,
   * the newest release's version. Rewound past versions where a later range superseded it
   * (code changed with no version bump), so ranges never share a version.
   */
  versionTo: string;
  /**
   * True when this code was already shipping at the start of our history, so its real first
   * version predates the snippets we have on record and `versionFrom` is a floor, not exact.
   */
  firstVersionUnknown: boolean;
  /** True when this is still the code shipping at the newest release. */
  isCurrent: boolean;
}

/** An open range plus the bookkeeping needed to rewind it if it gets superseded. */
interface OpenRange extends VersionedSnippet {
  /** Last distinct version before `versionTo` — where a rewind lands. Unset until the first version bump. */
  prevVersionTo?: string;
}

/** A range leaving the open set: strip the internal bookkeeping field. */
function seal(range: OpenRange, isCurrent: boolean): VersionedSnippet {
  const { prevVersionTo: _prevVersionTo, ...sealed } = range;
  return { ...sealed, isCurrent };
}

/**
 * Collapse a chronological timeline of releases into per-version-range snippet records.
 * See the file header for the one-paragraph explanation.
 */
export function buildVersionRanges(timeline: ReleaseSnapshot[]): VersionedSnippet[] {
  const open = new Map<string, OpenRange>();
  const done: VersionedSnippet[] = [];
  const lastVersions = new Map<string, string>();
  let sawSnippets = false;

  timeline.forEach((release, index) => {
    // Range stretching assumes each language's version stream never goes backwards
    // across the timeline. A backport release (tagged after a newer one) or a bad
    // clients.config.json at one tag would silently corrupt the ranges — fail loud.
    // Full semver precedence, so a prerelease after its release (6.0.0 -> 6.0.0-beta.2)
    // is backwards too, and an unparseable version throws, naming the offending tag.
    for (const [language, version] of Object.entries(release.versions)) {
      if (!semver.valid(version)) {
        throw new Error(`invalid ${language} package version at ${release.tag}: "${version}"`);
      }
      const previous = lastVersions.get(language);
      if (previous !== undefined && semver.lt(version, previous)) {
        throw new Error(
          `${language} package version went backwards at ${release.tag}: ${previous} -> ${version}` +
            ' — skip older tags with SINCE_DATE (the SNIPPETS_SINCE_DATE repo variable in CI)',
        );
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
            const version = release.versions[language] ?? lastVersions.get(language) ?? '0.0.0';

            if (current && current.code === code) {
              // Same code, newer release: stretch the range forward.
              if (version !== current.versionTo) {
                current.prevVersionTo = current.versionTo;
              }
              current.versionTo = version;
            } else {
              // Code changed (or first sight): close the old range, start a new one.
              // Exception: if the old range starts at this same version (code changed with
              // no version bump — e.g. a snippet regeneration fix), it never shipped under
              // a version of its own. It is unreachable at the version grain and would
              // collide with the new range on objectID, so drop it instead of closing it.
              if (current && current.versionFrom !== version) {
                // Same no-bump supersede mid-range: the old code did ship at `version` first,
                // but the new range now owns it — rewind so ranges never share a version.
                if (current.versionTo === version) {
                  current.versionTo = current.prevVersionTo ?? current.versionFrom;
                }
                done.push(seal(current, false));
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

    // A release with no snippets at all after we've seen some means the bundled files were
    // missing/unreadable at that tag, not that every snippet was removed. Letting it through
    // would close every open range and reopen them next release with wrong versionFroms.
    if (seenThisRelease.size === 0 && sawSnippets) {
      throw new Error(
        `no snippets found at ${release.tag}; refusing to close every open range` +
          ' — a SINCE_DATE past this tag (the SNIPPETS_SINCE_DATE repo variable in CI) skips it',
      );
    }
    sawSnippets = sawSnippets || seenThisRelease.size > 0;

    // A snippet present before but missing now was removed/renamed: close its range.
    for (const [key, range] of open) {
      if (!seenThisRelease.has(key)) {
        done.push(seal(range, false));
        open.delete(key);
      }
    }
  });

  // Whatever is still open is the code shipping at HEAD.
  return [...done, ...[...open.values()].map((range) => seal(range, true))];
}
