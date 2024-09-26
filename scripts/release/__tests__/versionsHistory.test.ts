// @ts-nocheck this file is broken while the VersionsHistory is unclear
import { describe, expect, it } from 'vitest';

import { fullReleaseConfig, LANGUAGES } from '../../common.js';
import { generateLanguageVersionsHistory } from '../versionsHistory.js';

describe('generateLanguageVersionsHistory', () => {
  LANGUAGES.forEach((lang) => {
    if (!('versionsHistory' in fullReleaseConfig)) {
      fullReleaseConfig.versionsHistory = {};
    }

    // @ts-expect-error
    fullReleaseConfig.versionsHistory[lang] = {};
  });

  describe('no new releases', () => {
    it('parses version of the same minor', () => {
      generateLanguageVersionsHistory(
        [
          '1.2.4 Thu Dec 28 15:48:25 2023 +0000',
          '1.2.5 Tue Jan 2 14:17:11 2024 +0000',
          '1.2.6 Tue Jan 2 15:26:06 2024 +0000',
          '1.2.7 Thu Jan 4 15:09:11 2024 +0000',
        ],
        'csharp',
        { current: '1.2.7', next: null, releaseType: null },
      );

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.csharp).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          supportEnd: '2024-01-02',
          supportStatus: 'inactive',
        },
        '1.2.5': {
          releaseDate: '2024-01-02',
          supportEnd: '2024-01-02',
          supportStatus: 'inactive',
        },
        '1.2.6': {
          releaseDate: '2024-01-02',
          supportEnd: '2024-01-04',
          supportStatus: 'inactive',
        },
        '1.2.7': {
          releaseDate: '2024-01-04',
          supportStatus: 'active',
        },
      });
    });

    it('parses version of different same minor', () => {
      generateLanguageVersionsHistory(
        [
          '1.1.4 Thu Dec 28 15:48:25 2023 +0000',
          '1.2.5 Tue Jan 2 14:17:11 2024 +0000',
          '1.3.6 Tue Jan 2 15:26:06 2024 +0000',
          '1.4.7 Thu Jan 4 15:09:11 2024 +0000',
        ],
        'javascript',
        { current: '1.4.7', next: null, releaseType: null },
      );

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.javascript).toEqual({
        '1.1.4': {
          releaseDate: '2023-12-28',
          supportEnd: '2026-01-02',
          supportStart: '2024-01-02',
          supportStatus: 'maintenance',
        },
        '1.2.5': {
          releaseDate: '2024-01-02',
          supportEnd: '2026-01-02',
          supportStart: '2024-01-02',
          supportStatus: 'maintenance',
        },
        '1.3.6': {
          releaseDate: '2024-01-02',
          supportEnd: '2026-01-04',
          supportStart: '2024-01-04',
          supportStatus: 'maintenance',
        },
        '1.4.7': {
          releaseDate: '2024-01-04',
          supportStatus: 'active',
        },
      });
    });

    it('ignores versions older than 2 years', () => {
      generateLanguageVersionsHistory(
        [
          'v1.0.9 Thu Dec 28 15:48:25 2011 +0000',
          'v1.1.4 Thu Dec 28 15:48:25 2021 +0000',
          'v1.4.7 Tue Jan 2 14:17:11 2024 +0000',
        ],
        'php',
        { current: '1.4.7', next: null, releaseType: null },
      );

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.php).toEqual({
        '1.1.4': {
          releaseDate: '2021-12-28',
          supportEnd: '2026-01-02',
          supportStart: '2024-01-02',
          supportStatus: 'maintenance',
        },
        '1.4.7': {
          releaseDate: '2024-01-02',
          supportStatus: 'active',
        },
      });
    });

    it('overrides the previously stored versions and sanitize v prefixed versions', () => {
      // @ts-expect-error
      fullReleaseConfig.versionsHistory.go = { '0.1.2': { releaseDate: '2014-01-04', supportStatus: 'active' } };

      generateLanguageVersionsHistory(
        ['v1.1.4 Thu Dec 28 15:48:25 2023 +0000', 'v1.4.7 Tue Jan 2 14:17:11 2024 +0000'],
        'go',
        {
          current: '1.4.7',
          next: null,
          releaseType: null,
        },
      );

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.go).toEqual({
        '1.1.4': {
          releaseDate: '2023-12-28',
          supportEnd: '2026-01-02',
          supportStart: '2024-01-02',
          supportStatus: 'maintenance',
        },
        '1.4.7': {
          releaseDate: '2024-01-02',
          supportStatus: 'active',
        },
      });
    });
  });

  describe('new release', () => {
    const start = new Date();
    const end = new Date(start);
    end.setFullYear(start.getFullYear() + 2);

    it('same version as active version', () => {
      generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'dart', {
        next: '1.2.4',
        current: '1.2.4',
        releaseType: 'minor',
      });

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.dart).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          supportStatus: 'active',
        },
      });
    });

    it('new major: sets the new release as active, sets the last tag as maintenance', () => {
      generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'dart', {
        next: '2.0.0',
        current: '1.2.4',
        releaseType: 'major',
      });

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.dart).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          supportEnd: end.toISOString().split('T')[0],
          supportStart: start.toISOString().split('T')[0],
          supportStatus: 'maintenance',
        },
        '2.0.0': {
          releaseDate: start.toISOString().split('T')[0],
          supportStatus: 'active',
        },
      });
    });

    it('new minor: sets the new release as active, sets the last tag as maintenance', () => {
      generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'kotlin', {
        next: '1.3.0',
        current: '1.2.4',
        releaseType: 'minor',
      });

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.kotlin).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          supportEnd: end.toISOString().split('T')[0],
          supportStart: start.toISOString().split('T')[0],
          supportStatus: 'maintenance',
        },
        '1.3.0': {
          releaseDate: start.toISOString().split('T')[0],
          supportStatus: 'active',
        },
      });
    });

    it('new patch: sets the new release as active, sets the last tag as inactive', () => {
      generateLanguageVersionsHistory(['1.2.4 Thu Dec 28 15:48:25 2023 +0000'], 'swift', {
        next: '1.2.5',
        current: '1.2.4',
        releaseType: 'patch',
      });

      // @ts-expect-error
      expect(fullReleaseConfig.versionsHistory.swift).toEqual({
        '1.2.4': {
          releaseDate: '2023-12-28',
          supportEnd: start.toISOString().split('T')[0],
          supportStatus: 'inactive',
        },
        '1.2.5': {
          releaseDate: start.toISOString().split('T')[0],
          supportStatus: 'active',
        },
      });
    });
  });
});
