import type { ReleaseType } from 'semver';

export type Version = {
  current: string;
  releaseType: ReleaseType | null;
  skipRelease?: boolean;
  noCommit?: boolean;
};

export type Versions = {
  [lang: string]: Version;
};

export type VersionsWithoutReleaseType = {
  [lang: string]: Omit<Version, 'releaseType'>;
};

export type PassedCommit = {
  hash: string;
  type: string;
  lang: string;
  message: string;
  raw: string;
};

export type Commit =
  | PassedCommit
  | { error: 'missing-language-scope' }
  | { error: 'unknown-language-scope' };

export type VersionsToRelease = {
  [lang: string]: {
    current: string;
    releaseType: ReleaseType;
    dateStamp: string;
  };
};
