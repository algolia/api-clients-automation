import type { ReleaseType } from 'semver';

import type { Language } from '../types';

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
  lang: Language;
  message: string;
  raw: string;
};

export type Commit =
  | PassedCommit
  | { error: 'missing-language-scope' }
  | { error: 'unknown-language-scope' };

export type VersionsToRelease = Partial<{
  [lang in Language]: {
    current: string;
    releaseType: ReleaseType;
  };
}>;

export type BeforeClientGenerationCommand = (params: {
  releaseType: ReleaseType;
  dir: string;
}) => Promise<void>;

export type BeforeClientCommitCommand = (params: {
  dir: string;
}) => Promise<void>;
