import type { Language } from '../types.js';

export type BaseBuildSpecsOptions = {
  outputFormat: 'json' | 'yml';
  docs: boolean;
  useCache: boolean;
};

export type SampleForOperation = Record<string, string>;
export type CodeSamples = Record<Language, Record<string, SampleForOperation>>;

export type OpenAPICodeSample = {
  lang:
    | 'c'
    | 'c++'
    | 'coffeescript'
    | 'csharp'
    | 'css'
    | 'dart'
    | 'dm'
    | 'elixir'
    | 'go'
    | 'groovy'
    | 'html'
    | 'java'
    | 'javascript'
    | 'kotlin'
    | 'objective-c'
    | 'perl'
    | 'php'
    | 'powershell'
    | 'python'
    | 'ruby'
    | 'rust'
    | 'scala'
    | 'shell'
    | 'swift'
    | 'typescript';
  label:
    | 'C'
    | 'C#'
    | 'C++'
    | 'CoffeeScript'
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
