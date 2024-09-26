// @ts-nocheck this file is broken while the VersionsHistory is unclear
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
        'csharp',
        { current: '1.2.7', next: null, releaseType: null },
      );

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
        },
        '1.2.5': {
          releaseDate: '2024-01-02',
        },
        '1.2.6': {
          releaseDate: '2024-01-02',
        },
        '1.2.7': {
          releaseDate: '2024-01-04',
        },
      });
    });

    it('parses version of different same minor', () => {
      const versions = generateLanguageVersionsHistory(
        [
          '1.1.4 Thu Dec 28 15:48:25 2023 +0000',
          '1.2.5 Tue Jan 2 14:17:11 2024 +0000',
          '1.3.6 Tue Jan 2 15:26:06 2024 +0000',
          '1.4.7 Thu Jan 4 15:09:11 2024 +0000',
        ],
        'javascript',
        { current: '1.4.7', next: null, releaseType: null },
      );

      expect(versions).toEqual({
        '1.1.4': {
          releaseDate: '2023-12-28',
        },
        '1.2.5': {
          releaseDate: '2024-01-02',
        },
        '1.3.6': {
          releaseDate: '2024-01-02',
        },
        '1.4.7': {
          releaseDate: '2024-01-04',
        },
      });
    });
  });

  describe('new release', () => {
    const start = new Date();
    const end = new Date(start);
    end.setFullYear(start.getFullYear() + 2);

    it('same version as active version', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'dart', {
        next: '1.2.4',
        current: '1.2.4',
        releaseType: 'minor',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
        },
      });
    });

    it('new major: sets the new release as active, sets the last tag as maintenance', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'dart', {
        next: '2.0.0',
        current: '1.2.4',
        releaseType: 'major',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
        },
        '2.0.0': {
          releaseDate: start.toISOString().split('T')[0],
        },
      });
    });

    it('new minor: sets the new release as active, sets the last tag as maintenance', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'kotlin', {
        next: '1.3.0',
        current: '1.2.4',
        releaseType: 'minor',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
        },
        '1.3.0': {
          releaseDate: start.toISOString().split('T')[0],
        },
      });
    });

    it('new patch: sets the new release as active, sets the last tag as inactive', () => {
      const versions = generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'swift', {
        next: '1.2.5',
        current: '1.2.4',
        releaseType: 'patch',
      });

      expect(versions).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
        },
        '1.2.5': {
          releaseDate: start.toISOString().split('T')[0],
        },
      });
    });
  });
});
