import type { ReleaseType } from 'semver';

import type { Language } from '../types.ts';

export type Version = {
  current: string;
  releaseType: ReleaseType;
  next: string;
};

export type Versions = {
  [lang in Language]?: Version;
};

export type CommitType = 'chore' | 'feat' | 'fix';
export type Scope = Language | 'clients' | 'specs';

export type ParsedCommit = {
  hash: string;
  type: CommitType;
  /**
   * A commit can be scoped to a language. When scoped to `clients` or `specs`, it impacts all clients.
   */
  scope?: Scope;
  languages: Language[];
  author: string;
  message: string;
  prNumber: number;
};

export type Commit = ParsedCommit | { generated: true; languages: Language[]; message: string };

export type Changelog = {
  [lang in Language]?: string;
};
