import fsp from 'fs/promises';

import { GENERATORS, capitalize, createClientName, exists, toAbsolutePath } from '../common.js';
import type { Language } from '../types.js';

import type { CodeSamples, SnippetForMethod, SnippetSamples } from './types.js';

export function getCodeSampleLabel(language: Language): CodeSamples['label'] {
  switch (language) {
    case 'csharp':
      return 'C#';
    case 'javascript':
      return 'JavaScript';
    case 'php':
      return 'PHP';
    default:
      return capitalize(language) as CodeSamples['label'];
  }
}

// Iterates over the snippet samples and sanitize the data to only keep the method part in order to use it in the guides.
export function transformCodeSamplesToGuideMethods(snippetSamples: SnippetSamples): string {
  for (const [language, operationWithSample] of Object.entries(snippetSamples)) {
    for (const [operation, samples] of Object.entries(operationWithSample)) {
      if (operation === 'import') {
        continue;
      }

      for (const [sampleName, sample] of Object.entries(samples)) {
        const sampleMatch = sample.match(
          /.*Initialize the client.*([\s\S]*?)(#|\/\/) Call the API([\s\S]*?)(#|\/\/) >LOG/,
        );
        if (!sampleMatch) {
          continue;
        }

        const initLine = sampleMatch[1];
        const callLine = sampleMatch[3];

        if (!('init' in snippetSamples[language])) {
          snippetSamples[language].init = {
            default: initLine.trim(),
          };
        }

        snippetSamples[language][operation][sampleName] = callLine.trim();
      }
    }
  }

  return JSON.stringify(snippetSamples, null, 2);
}

// For a given `clientName`, reads the matching snippet file for every available clients and builds an hashmap of snippets per operationId per language.
export async function transformSnippetsToCodeSamples(clientName: string): Promise<SnippetSamples> {
  const snippetSamples = Object.values(GENERATORS).reduce(
    (prev, curr) => ({ ...prev, [curr.language]: {} }),
    {} as SnippetSamples,
  );

  for (const gen of Object.values(GENERATORS)) {
    if (gen.client !== clientName) {
      continue;
    }

    const ppath = toAbsolutePath(
      `snippets/${gen.language}/${gen.snippets.outputFolder}/${createClientName(clientName, gen.language)}${gen.snippets.extension}`,
    );

    if (!(await exists(ppath))) {
      continue;
    }

    // find snippets for each operationId in the current gen.language + clientName combo
    const snippetFileContent = await fsp.readFile(ppath, 'utf8');

    const importMatch = snippetFileContent.match(/>IMPORT\n([\s\S]*?)\n.*IMPORT</);
    if (importMatch) {
      snippetSamples[gen.language].import = {
        default: importMatch[1].trim(),
      };
    }

    // iterate over every matches (operationId) and store it in the hashmap for later use
    for (const match of snippetFileContent.matchAll(/>SEPARATOR (\w+) (.*)\n([\s\S]*?)SEPARATOR</g)) {
      const lines: string[] = match[0].split('\n').slice(1, -1);
      if (!lines.length) {
        throw new Error(`No snippet found for ${gen.language} ${gen.client}`);
      }

      const operationId = match[1];
      const testName = match[2] || 'default';

      if (!snippetSamples[gen.language][operationId]) {
        snippetSamples[gen.language][operationId] = {};
      }

      const snippetForMethod: SnippetForMethod = snippetSamples[gen.language][operationId];

      snippetForMethod[testName] = '';

      const indent = lines[0].length - lines[0].trim().length;
      // skip first and last lines because they contain the SEPARATOR or operationId
      lines.forEach((line) => {
        // best effort to determine how far the snippet is indented so we
        // can have every snippets in the documentation on the far left
        // without impacting the formatting
        snippetForMethod[testName] += `${line.slice(indent).replaceAll(/\t/g, '  ')}\n`;
      });
    }
  }

  return snippetSamples;
}
