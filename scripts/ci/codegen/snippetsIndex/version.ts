import semver from 'semver';

const MINOR_MULT = 1_000;
const MAJOR_MULT = 1_000_000;

/**
 * Encode a semver string into a sortable integer: `major*1_000_000 + minor*1_000 + patch`.
 * Prerelease tags are collapsed (5.0.0-beta → 5.0.0). Unparseable or empty input encodes to
 * 0 (sorts first — matches the `'0.0.0'` sentinel `buildVersionRanges` uses when no version
 * is known). Throws if minor or patch reach 1000, so a silent ordering bug fails loud instead.
 *
 * CROSS-REPO CONTRACT: mirrored byte-identical by the MCP reader (algolia/mcp-server →
 * `src/tools/snippets/version.ts`), which encodes the user's requested version and matches it
 * against the `versionFromNum` this function wrote into the index. Changing the encoding here
 * breaks version matching against already-indexed records — update both sides and re-index.
 */
export function encodeVersion(version: string): number {
  const parsed = semver.parse(version) ?? semver.parse(semver.coerce(version) ?? '');
  if (!parsed) {
    return 0;
  }
  const { major, minor, patch } = parsed;
  if (minor >= MINOR_MULT || patch >= MINOR_MULT) {
    throw new Error(`version "${version}" exceeds the encoding range (minor/patch must be < ${MINOR_MULT})`);
  }
  return major * MAJOR_MULT + minor * MINOR_MULT + patch;
}
