import type config from '../config/clients.config.json';

import type { OpenAPICodeSample } from './specs/types.js';

/**
 * Config.
 */
export type LanguageConfig = {
  folder: string;
  gitRepoId: string;
  modelFolder: string;
  apiFolder: string;
  packageVersion?: string;
  tests: {
    extension: string;
    outputFolder: string;
  };
};

type AdditionalProperties = Partial<{
  packageName: string;
}> &
  Record<string, any>;

export type Generator = Record<string, any> & {
  language: Language;
  client: string;
  key: string;
  output: string;
  additionalProperties: AdditionalProperties;
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
    parameters: Record<string, any>;
    responses: Record<string, any>;
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
export type Path = Record<string, Record<Method, Operation>>;

export type Operation = {
  operationId: string;
  'x-codeSamples': OpenAPICodeSample[];
  summary: string;
  requestBody?: {
    required: boolean;
    description: string;
    content?: { 'application/json'?: { schema?: { properties?: Record<string, any> } } };
  };
  parameters: Array<Record<string, any>>;
  responses: Record<string, Record<string, any>>;
} & Record<string, unknown>;
