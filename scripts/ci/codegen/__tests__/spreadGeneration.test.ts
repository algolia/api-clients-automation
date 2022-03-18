import { LANGUAGES } from '../../../common';
import { decideWhereToSpread, cleanUpCommitMessage } from '../spreadGeneration';

describe('spread generation', () => {
  it('skips in case of release commit', () => {
    expect(decideWhereToSpread('chore: release 2022-03-15')).toEqual([]);
  });

  it('spreads to all if scope is missing', () => {
    expect(decideWhereToSpread('chore: do something')).toEqual(LANGUAGES);
  });

  it('spreads to javascript if the scope is javascript', () => {
    expect(decideWhereToSpread('fix(javascript): fix something')).toEqual([
      'javascript',
    ]);
  });

  it('spreads to all if scope is not specific language', () => {
    ['cts', 'spec', 'script', 'ci'].forEach((scope) => {
      expect(decideWhereToSpread(`fix(${scope}): fix something`)).toEqual(
        LANGUAGES
      );
    });
  });

  it('removes pull-request number from commit message', () => {
    expect(
      cleanUpCommitMessage(`feat(ci): make ci push generated code (#244)`)
    ).toEqual(
      `feat(ci): make ci push generated code\nhttps://github.com/algolia/api-clients-automation/pull/244`
    );
  });
});
