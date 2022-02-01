import fsp from 'fs/promises';

import Mustache from 'mustache';

import openapitools from '../../../openapitools.json';
import {
  walk,
  extensionForLanguage,
  packageNames,
  createClientName,
  exists,
} from '../utils';

import type { TestsBlock, Test, ModifiedStepForMustache } from './types';

async function loadTests(client: string): Promise<TestsBlock[]> {
  const testsBlocks: TestsBlock[] = [];
  const clientPath = `./CTS/client/${client}`;

  if (!(await exists(clientPath))) {
    return [];
  }

  for await (const file of walk(clientPath)) {
    if (!file.name.endsWith('.json')) {
      continue;
    }
    const fileName = file.name.replace('.json', '');
    const fileContent = (await fsp.readFile(file.path)).toString();

    if (!fileContent) {
      throw new Error(`cannot read empty file ${fileName} - ${client} client`);
    }

    const tests: Test[] = JSON.parse(fileContent).map((testCase) => {
      if (!testCase.testName) {
        throw new Error(
          `Cannot have a test with no name ${fileName} - ${client} client`
        );
      }
      return {
        autoCreateClient: true,
        ...testCase,
      };
    });

    testsBlocks.push({
      operationId: fileName,
      tests,
    });
  }

  return testsBlocks;
}

async function loadTemplates(
  language: string
): Promise<Record<string, string>> {
  const templates: Record<string, string> = {};
  const templatePath = `./CTS/client/templates/${language}`;

  await exists(`./CTS/client/templates/javascript`);
  if (!(await exists(templatePath))) {
    return {};
  }

  for await (const file of walk(templatePath)) {
    if (!file.name.endsWith('.mustache')) {
      continue;
    }
    const type = file.name.replace('.mustache', '');
    const fileContent = (await fsp.readFile(file.path)).toString();
    templates[type] = fileContent;
  }
  return templates;
}

export async function generateTests(
  language: string,
  client: string
): Promise<void> {
  const testsBlocks = await loadTests(client);

  if (testsBlocks.length === 0) {
    // eslint-disable-next-line no-console
    console.warn(
      `Skipping because tests dont't exist for CTS > generate:client for ${language}-${client}`
    );
    return;
  }

  const outputPath = `output/${language}/tests/client/`;
  await fsp.mkdir(outputPath, { recursive: true });
  const { suite: template, ...partialTemplates } = await loadTemplates(
    language
  );

  if (!template) {
    // eslint-disable-next-line no-console
    console.warn(
      `Skipping because template doesn't exist for CTS > generate:client for ${language}-${client}`
    );
    return;
  }

  const code = Mustache.render(
    template,
    {
      import: packageNames[language][client],
      client: createClientName(client),
      blocks: modifyForMustache(testsBlocks),
      hasRegionalHost: openapitools['generator-cli'].generators[
        `${language}-${client}`
      ].additionalProperties.hasRegionalHost
        ? true
        : undefined,
    },
    partialTemplates
  );
  await fsp.writeFile(
    `${outputPath}/${client}.${extensionForLanguage[language]}`,
    code
  );
}

function serializeParameters(parameters: any): string {
  const serialized = JSON.stringify(parameters);
  return serialized.slice(1, serialized.length - 1); // remove array bracket surrounding the parameters
}

function modifyForMustache(
  blocks: TestsBlock[]
): Array<TestsBlock<ModifiedStepForMustache>> {
  return blocks.map(({ tests, ...blockRest }) => ({
    ...blockRest,
    tests: tests.map(({ steps, ...testRest }) => ({
      ...testRest,
      steps: steps.map((step) => {
        const base = {
          isCreateClient: step.type === 'createClient',
          isVariable: step.type === 'variable',
          isMethod: step.type === 'method',
        };

        let modified: ModifiedStepForMustache;
        if (step.type === 'method') {
          modified = {
            type: step.type,
            object: step.object,
            path: step.path,
            expected: step.expected,
            parameters: step.parameters && serializeParameters(step.parameters),
            ...base,
          };
        } else {
          modified = { ...step, ...base };
        }

        if (step.expected?.error) {
          modified.expectedError = step.expected.error;
        }

        if (step.expected?.error === false) {
          modified.expectedNoError = true;
        }

        if (step.expected?.match?.objectContaining) {
          if (!modified.expected) {
            modified.expected = {};
          }

          modified.expected.match = {
            objectContaining: JSON.stringify(
              step.expected?.match?.objectContaining
            ),
          };
        }

        return modified;
      }),
    })),
  }));
}
