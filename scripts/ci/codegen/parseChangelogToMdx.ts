/**
 * Transforms a raw CHANGELOG.md into an MDX snippet suitable for docs-new.
 *
 * - Strips commit-hash links and author attributions from entry lines
 * - Wraps section-level "BREAKING CHANGES:" paragraphs in <Warning>
 * - Wraps sub-bullets and backslash continuations after BREAKING CHANGE entries in <Note>
 */
export function parseChangelogToMdx(rawChangelog: string): string {
  const lines = rawChangelog.split('\n');
  const out: string[] = [
    '{/* This file is auto-generated from the API clients repository. Do not edit manually. */}',
    '',
  ];
  let breaking = false;

  for (let i = 0; i < lines.length; i++) {
    const line = lines[i];

    if (line.startsWith('## ')) {
      breaking = false;
      out.push(line);

      // Section-level "BREAKING CHANGES: ..." paragraph - wrap in <Warning>
    } else if (/^BREAKING CHANGES?\b/.test(line)) {
      out.push('<Warning>', line, '</Warning>');

      // Entry lines: "- [hash](url) message ([#PR](url)) by [@user](url)"
    } else if (line.startsWith('- ')) {
      let cleaned = stripEntryMeta(line);

      // Some entries use "\" at end-of-line to continue onto the next line
      const continuation = cleaned.endsWith('\\');
      if (continuation) cleaned = cleaned.slice(0, -1).trimEnd();

      breaking = /BREAKING CHANGE/.test(cleaned);
      out.push(cleaned);

      // Wrap the continuation line in <Note> only for breaking entries
      if (continuation && i + 1 < lines.length) {
        const next = lines[++i];
        if (breaking) {
          out.push('', '\t<Note>', `\t${next}`, '\t</Note>');
        } else {
          out.push(next);
        }
      }

      // Sub-bullets after a breaking entry - collect and wrap in <Note>
    } else if (/^ {2}- /.test(line) && breaking) {
      const notes: string[] = [];
      for (; i < lines.length && /^ {2}- /.test(lines[i]); i++) {
        notes.push(lines[i].slice(4)); // strip "  - " prefix
      }
      i--; // back up so the outer loop doesn't skip a line
      out.push('', '\t<Note>', ...notes.map((n) => `\t${n}`), '\t</Note>');
    } else {
      out.push(line);
    }
  }

  return out.join('\n');
}

/** Strips commit hash link and author attribution from an entry line. */
function stripEntryMeta(line: string): string {
  return line
    .replace(/\[[a-f0-9]+]\([^)]+\) /, '') // [hash](commit-url)
    .replace(/ by \[.+?]\(.+?\)/, '') // by [@user](profile-url)
    .trimEnd();
}
