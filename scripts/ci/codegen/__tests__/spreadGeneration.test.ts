import { describe, expect, it } from 'vitest';

import { cleanUpCommitMessage } from '../spreadGeneration.ts';
import text from '../text.ts';

describe('spread generation', () => {
  describe('cleanUpCommitMessage', () => {
    it('returns a release commit message with the version', () => {
      expect(cleanUpCommitMessage(`${text.commitReleaseMessage} [skip ci]`, '1.0.0')).toEqual('chore: release 1.0.0');
    });

    it('removes pull-request number from commit message', () => {
      expect(cleanUpCommitMessage('feat(ci): make ci push generated code (#244)', '')).toEqual(
        'feat(ci): make ci push generated code (generated)\n\nhttps://github.com/algolia/api-clients-automation/pull/244',
      );
    });

    it('keeps the commit message even if it does not have PR number', () => {
      const commitMessage = 'feat(ci): make ci push generated code';
      expect(cleanUpCommitMessage(commitMessage, '')).toEqual(commitMessage);
    });

    it('cleans up correctly even if the title contains a url', () => {
      const commitMessage =
        'fix(java): solve oneOf using a custom generator https://algolia.atlassian.net/browse/APIC-123 (#200)';
      expect(cleanUpCommitMessage(commitMessage, '')).toMatchInlineSnapshot(`
      "fix(java): solve oneOf using a custom generator https://algolia.atlassian.net/browse/APIC-123 (generated)

      https://github.com/algolia/api-clients-automation/pull/200"
    `);
    });

    it('generated commits have a link to the origin pull request', () => {
      expect(cleanUpCommitMessage('feat(ci): make ci push generated code (#244) (generated)', '')).toEqual(
        'feat(ci): make ci push generated code (generated)\n\nhttps://github.com/algolia/api-clients-automation/pull/244',
      );
    });
  });
});
