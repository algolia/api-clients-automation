import { describe, expect, it } from 'vitest';

import { generateLanguageVersionsHistory } from '../versionsHistory.js';

describe('generateLanguageVersionsHistory', () => {
  describe('no new releases', () => {
    it('parses version of the same minor', () => {
      const versions = generateLanguageVersionsHistory(
        [
          '1.2.4 Thu Dec 28 15:48:25 2023 +0000',
          '1.2.5 Tue Jan 2 14:17:11 2024 +0000',
          '1.2.6 Tue Jan 2 15:26:06 2024 +0000',
          '1.2.7 Thu Jan 4 15:09:11 2024 +0000',
        ],
        { current: '1.2.7' },
      );

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
        '1.2.5': {
          releaseDate: '2024-01-02',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
        '1.2.6': {
          releaseDate: '2024-01-02',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
        '1.2.7': {
          releaseDate: '2024-01-04',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
      });
    });

    it('parses version of different same minor', () => {
      const versions = generateLanguageVersionsHistory(
        [
          '1.1.4 Thu Dec 28 15:48:25 2022 +0000',
          '2.1.2 Tue Jan 2 14:17:11 2022 +0000',
          '2.2.5 Tue Jan 2 14:17:11 2024 +0000',
          '2.3.6 Tue Jan 2 15:26:06 2024 +0000',
          '3.4.7 Thu Jan 4 15:09:11 2024 +0000',
        ],
        { current: '3.4.7' },
      );

      expect(versions).toEqual({
        '1.1.4': {
          releaseDate: '2022-12-28',
          eligibilityDate: undefined,
          eligibilityStatus: 'not eligible',
        },
        '2.1.2': {
          releaseDate: '2022-01-02',
          eligibilityDate: '2026-08-14',
          eligibilityStatus: 'replaced',
        },
        '2.2.5': {
          releaseDate: '2024-01-02',
          eligibilityDate: '2026-08-14',
          eligibilityStatus: 'replaced',
        },
        '2.3.6': {
          releaseDate: '2024-01-02',
          eligibilityDate: '2026-08-14',
          eligibilityStatus: 'replaced',
        },
        '3.4.7': {
          releaseDate: '2024-01-04',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
      });
    });
  });

  describe('new release', () => {
    const start = new Date();
    const end = new Date(start);
    end.setFullYear(start.getFullYear() + 2);

    it('same version as active version', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], {
        next: '1.2.4',
        current: '1.2.4',
        releaseType: 'minor',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
      });
    });

    it('new major: sets the new release as active, sets the last tag as maintenance', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], {
        next: '2.0.0',
        current: '1.2.4',
        releaseType: 'major',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
        '2.0.0': {
          releaseDate: start.toISOString().split('T')[0],
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
      });
    });

    it('new minor: sets the new release as active, sets the last tag as maintenance', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], {
        next: '1.3.0',
        current: '1.2.4',
        releaseType: 'minor',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
        '1.3.0': {
          releaseDate: start.toISOString().split('T')[0],
          eligibilityDate: undefined,
          eligibilityStatus: 'eligible',
        },
      });
    });

    it.only('new patch: sets the new release as active, sets the last tag as inactive', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], {
        next: '1.2.5',
        current: '1.2.4',
        releaseType: 'patch',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          slaStatus: 'eligible',
          supportStatus: 'not eligible',
        },
        '1.2.5': {
          releaseDate: start.toISOString().split('T')[0],
          slaStatus: 'eligible',
          supportStatus: 'eligible',
        },
      });
    });
  });
});
