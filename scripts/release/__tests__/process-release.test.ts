import { getVersionsToRelease, getLangsToUpdateRepo } from '../process-release';

describe('process release', () => {
  it('gets versions to release', () => {
    expect(
      getVersionsToRelease(`
## Version Changes

- [x] javascript: v1.0.0 -> v1.1.0
`)
    ).toEqual({
      javascript: {
        current: '1.0.0',
        next: '1.1.0',
      },
    });
  });

  it('gets langs to update', () => {
    expect(
      getLangsToUpdateRepo(`
## Version Changes

- [ ] javascript: v1.0.0 -> v1.1.0
`)
    ).toEqual(['javascript']);
  });
});
