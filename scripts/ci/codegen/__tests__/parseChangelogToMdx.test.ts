import { describe, expect, it } from 'vitest';

import { parseChangelogToMdx } from '../parseChangelogToMdx.ts';

describe('parseChangelogToMdx', () => {
  it('strips commit hash and author', () => {
    const input = [
      '- [99a999aaa](https://github.com/algolia/api-clients-automation/commit/99b999bbb) feat(x): add some feature ([#9999](https://github.com/algolia/api-clients-automation/pull/9999)) by [@user](https://github.com/user/)',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    expect(result).toContain(
      '- feat(x): add some feature ([#9999](https://github.com/algolia/api-clients-automation/pull/9999))',
    );
    expect(result).not.toContain('99a999aaa');
    expect(result).not.toContain('gusernpx vitest run scripts/ci/codegen/__tests__/parseChangelogToMdx.test.ts');
  });

  it('wraps section-level BREAKING CHANGES in <Warning>', () => {
    const input = [
      '## [4.36.0](https://github.com/algolia/algoliasearch-client-python/compare/4.35.4...4.36.0)',
      '',
      'BREAKING CHANGES: this minor version includes multiple breaking changes.',
      '',
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) feat(specs): some change by [@user](https://github.com/user/)',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    expect(result).toContain('<Warning>');
    expect(result).toContain('BREAKING CHANGES: this minor version includes multiple breaking changes.');
    expect(result).toContain('</Warning>');
  });

  it('wraps sub-bullets after a breaking entry in <Note>', () => {
    const input = [
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) fix(specs): BREAKING CHANGE – remove field ([#100](https://github.com/algolia/api-clients-automation/pull/100)) by [@user](https://github.com/user/)',
      '  - The `Foo` model has been updated.',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    expect(result).toContain('\t<Note>');
    expect(result).toContain('\tThe `Foo` model has been updated.');
    expect(result).toContain('\t</Note>');
  });

  it('leaves sub-bullets after a non-breaking entry as plain text', () => {
    const input = [
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) fix(specs): minor tweak ([#100](https://github.com/algolia/api-clients-automation/pull/100)) by [@user](https://github.com/user/)',
      '  - Some additional detail.',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    expect(result).toContain('  - Some additional detail.');
    expect(result).not.toContain('<Note>');
  });

  it('wraps backslash continuation after a breaking entry in <Note>', () => {
    const input = [
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) fix(specs): BREAKING CHANGE — remove fields ([#100](https://github.com/algolia/api-clients-automation/pull/100)) by [@user](https://github.com/user/)\\',
      'Some fields were optional on the API side.',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    expect(result).toContain(
      '- fix(specs): BREAKING CHANGE — remove fields ([#100](https://github.com/algolia/api-clients-automation/pull/100))',
    );
    expect(result).not.toContain('\\');
    expect(result).toContain('\t<Note>');
    expect(result).toContain('\tSome fields were optional on the API side.');
    expect(result).toContain('\t</Note>');
  });

  it('collects multiple consecutive sub-bullets into a single <Note>', () => {
    const input = [
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) fix(specs): BREAKING CHANGE – big update ([#100](https://github.com/algolia/api-clients-automation/pull/100)) by [@user](https://github.com/user/)',
      '  - First change.',
      '  - Second change.',
    ].join('\n');

    const result = parseChangelogToMdx(input);
    const lines = result.split('\n');

    // Find the <Note> block
    const noteStart = lines.indexOf('\t<Note>');
    expect(noteStart).not.toBe(-1);
    expect(lines[noteStart + 1]).toBe('\tFirst change.');
    expect(lines[noteStart + 2]).toBe('\tSecond change.');
    expect(lines[noteStart + 3]).toBe('\t</Note>');
  });

  it('resets breaking state on new version heading', () => {
    const input = [
      '## [4.36.0](https://example.com)',
      '',
      '- [abc123](https://github.com/algolia/api-clients-automation/commit/abc123) fix(specs): BREAKING CHANGE – something by [@user](https://github.com/user/)',
      '  - Breaking detail.',
      '',
      '## [4.35.0](https://example.com)',
      '',
      '- [def456](https://github.com/algolia/api-clients-automation/commit/def456) fix(specs): normal change by [@user](https://github.com/user/)',
      '  - This should NOT be wrapped in Note.',
    ].join('\n');

    const result = parseChangelogToMdx(input);

    // The sub-bullet in 4.36.0 should be wrapped
    expect(result).toContain('\tBreaking detail.');

    // The sub-bullet in 4.35.0 should be plain text
    expect(result).toContain('  - This should NOT be wrapped in Note.');
  });
});
