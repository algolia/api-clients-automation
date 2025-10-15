import config from '../config/clients.config.json' with { type: 'json' };

import type { CodeSamples } from './specs/types.ts';

type GeneratedFile = {
  extension: string;
  outputFolder: string;
};

/**
 * Config.
 */
export type LanguageConfig = {
  folder: string;
  gitRepoId: string;
  modelFolder: string;
  apiFolder: string;
  packageVersion?: string;
  tests: GeneratedFile;
  snippets: GeneratedFile;
};

export type Generator = {
  language: Language;
  client: string;
  key: string;
  output: string;
  snippets: GeneratedFile;
  packageName?: string;
};

export type GeneratorMode = 'client' | 'guides' | 'snippets' | 'tests';

export type RunOptions = {
  errorMessage?: string;
  cwd?: string;
  language?: Language;
};

export type Language = keyof typeof config;

export type Spec = {
  servers: Server[];
  tags: Tag[];
  paths: Path;
  components: {
    schemas: Record<string, any>;
    securitySchemes: Partial<{ appId?: Record<string, any>; apiKey?: Record<string, any> }>;
  };
};

/**
 * Server of a spec.
 */
type Server = {
  url: string;
  variables?: Record<
    string,
    {
      enum?: string[];
      default: string;
    }
  >;
};

/**
 * Global tag of a spec.
 */
type Tag = {
  name: string;
  description: string;
};

type Method = 'delete' | 'get' | 'options' | 'patch' | 'post' | 'put';

/**
 * Paths of a spec.
 */
type Path = Record<
  Method,
  Record<string, any> & {
    operationId: string;
    'x-codeSamples': CodeSamples[];
    summary: string;
  }
>;
