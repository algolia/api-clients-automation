import type config from '../config/clients.config.json';

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

export type GeneratorMode = 'client' | 'snippets' | 'tests';

export type RunOptions = {
  errorMessage?: string;
  cwd?: string;
  language?: Language;
};

export type Language = keyof typeof config;

export type Spec = {
  servers: Server[];
  tags: Tag[];
  paths: Path[];
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

export type CodeSamples = {
  lang:
    | 'C'
    | 'C++'
    | 'CoffeeScript'
    | 'CSharp'
    | 'CSS'
    | 'Dart'
    | 'DM'
    | 'Elixir'
    | 'Go'
    | 'Groovy'
    | 'HTML'
    | 'Java'
    | 'JavaScript'
    | 'Kotlin'
    | 'Objective-C'
    | 'Perl'
    | 'PHP'
    | 'PowerShell'
    | 'Python'
    | 'Ruby'
    | 'Rust'
    | 'Scala'
    | 'Shell'
    | 'Swift'
    | 'TypeScript';
  source: string;
};

export type SnippetSamples = Record<Language, Record<string, string>>;

/**
 * Paths of a spec.
 */
type Path = Record<
  Method,
  Record<string, any> & { operationId: string; 'x-codeSamples': CodeSamples[]; summary: string }
>;
