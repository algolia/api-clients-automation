import fsp from 'fs/promises';

import { GENERATORS, capitalize, exists, toAbsolutePath } from '../common.ts';
import type { Language } from '../types.ts';

import { getSnippetFile } from '../config.ts';
import type { CodeSamples, OpenAPICodeSample, SampleForOperation } from './types.ts';

export function getCodeSampleLabel(language: Language): OpenAPICodeSample['label'] {
  switch (language) {
    case 'csharp':
      return 'C#';
    case 'javascript':
      return 'JavaScript';
    case 'php':
      return 'PHP';
    default:
      return capitalize(language) as OpenAPICodeSample['label'];
  }
}

// Iterates over the result of `transformSnippetsToCodeSamples` in order to generate a JSON file for the doc to consume.
export function generateSnippetsJSON(codeSamples: CodeSamples): CodeSamples {
  for (const [language, operationWithSamples] of Object.entries(codeSamples)) {
    for (const [operation, samples] of Object.entries(operationWithSamples)) {
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

        if (!('init' in codeSamples[language])) {
          codeSamples[language].init = {
            default: initLine.trim(),
          };
        }

        codeSamples[language][operation][sampleName] = callLine.trim();
      }
    }
  }

  return codeSamples;
}

// Reads the generated `docs/snippets/` file for every languages of the given `clientName` and builds an hashmap of snippets per operationId per language.
export async function transformGeneratedSnippetsToCodeSamples(clientName: string): Promise<CodeSamples> {
  const codeSamples = Object.values(GENERATORS).reduce<CodeSamples>(
    (prev, curr) => ({ ...prev, [curr.language]: {} }),
    {} as CodeSamples,
  );

  for (const gen of Object.values(GENERATORS)) {
    if (gen.client !== clientName) {
      continue;
    }

    const snippetPath = toAbsolutePath(getSnippetFile(gen));

    if (!(await exists(snippetPath))) {
      continue;
    }

    // find snippets for each operationId in the current gen.language + clientName combo
    const snippetFileContent = await fsp.readFile(snippetPath, 'utf8');

    const importMatch = snippetFileContent.match(/>IMPORT\n([\s\S]*?)\n.*IMPORT</);
    if (importMatch) {
      codeSamples[gen.language].import = {
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

      if (!codeSamples[gen.language][operationId]) {
        codeSamples[gen.language][operationId] = {};
      }

      const sampleForOperation: SampleForOperation = codeSamples[gen.language][operationId];

      sampleForOperation[testName] = '';

      const indent = lines[0].length - lines[0].trim().length;
      // skip first and last lines because they contain the SEPARATOR or operationId
      lines.forEach((line) => {
        // best effort to determine how far the snippet is indented so we
        // can have every snippets in the documentation on the far left
        // without impacting the formatting
        sampleForOperation[testName] += `${line.slice(indent).replaceAll(/\t/g, '  ')}\n`;
      });
    }
  }

  const jsonSnippets = generateSnippetsJSON(JSON.parse(JSON.stringify(codeSamples)));
  await fsp.writeFile(
    toAbsolutePath(`docs/bundled/${clientName}-snippets.json`),
    JSON.stringify(jsonSnippets, null, 2),
  );

  // remove all the `>LOG` comments from the snippets
  for (const lang of Object.keys(codeSamples) as Language[]) {
    for (const operationId of Object.keys(codeSamples[lang])) {
      for (const sampleName of Object.keys(codeSamples[lang][operationId])) {
        codeSamples[lang][operationId][sampleName] = codeSamples[lang][operationId][sampleName]
          .replace(/(#|\/\/) >LOG/g, '')
          .trim();
      }
    }
  }

  return codeSamples;
}
