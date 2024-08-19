import fsp from 'fs/promises';

import { GENERATORS, capitalize, createClientName, toAbsolutePath } from '../common.js';
import type { Language } from '../types.js';

/* eslint import/namespace: ['error', { allowComputed: true }]*/
import * as helperSnippets from './helper-snippets.js';
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

function getHelperSnippet(
  helperName: keyof typeof helperSnippets,
  language: string,
): Record<string, string> | string {
  if (typeof helperSnippets[helperName][language] === 'string') {
    return {
      default: helperSnippets[helperName][language],
    };
  }

  return helperSnippets[helperName][language];
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
          /.*Initialize the client\n(.*)((.|\n)*)(.*Call the API\n)((.|\n)*)/,
        );
        if (!sampleMatch) {
          continue;
        }

        const initLine = sampleMatch[1];
        const callLine = sampleMatch[5];

        if (!('init' in snippetSamples[language])) {
          snippetSamples[language].init = {
            default: initLine.replace(/\n$/, ''),
          };
        }

        snippetSamples[language][operation][sampleName] = callLine.replace(/\n$/, '');
      }
    }

    // add specific helper snippets to the current language
    snippetSamples[language].waitForAppTask = getHelperSnippet('waitForAppTask', language);
    snippetSamples[language].waitForApiKey = getHelperSnippet('waitForApiKey', language);
    snippetSamples[language].waitForTask = getHelperSnippet('waitForTask', language);
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

    // find snippets for each operationId in the current gen.language + clientName combo
    const snippetFileContent = await fsp.readFile(
      toAbsolutePath(
        `snippets/${gen.language}/${gen.snippets.outputFolder}/${createClientName(clientName, gen.language)}${gen.snippets.extension}`,
      ),
      'utf8',
    );

    const importMatch = snippetFileContent.match(/>IMPORT\n([\s\S]*?)\n.*IMPORT</);
    if (importMatch) {
      snippetSamples[gen.language].import = {
        default: importMatch[1].replace(/\n$/, ''),
      };
    }

    // iterate over every matches (operationId) and store it in the hashmap for later use
    for (const match of snippetFileContent.matchAll(
      />SEPARATOR (\w+) (.*)\n([\s\S]*?)SEPARATOR</g,
    )) {
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
