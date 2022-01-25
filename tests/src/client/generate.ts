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
import { TestsBlock, Test } from './types';

async function loadTests(client: string) {
  const testBlocks: TestsBlock[] = [];
  const clientPath = `./CTS/client/${client}`;

  if (!(await exists(clientPath))) {
    return;
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

    testBlocks.push({
      operationId: fileName,
      tests,
    });
  }

  return testBlocks;
}

async function loadTemplates(language: string) {
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

export async function generateTests(language: string, client: string) {
  const testsBlocks = await loadTests(client);

  if (!testsBlocks) {
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
      hasRegionalHost:
        openapitools['generator-cli'].generators[`${language}-${client}`]
          .additionalProperties.hasRegionalHost === true
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

function modifyForMustache(blocks: TestsBlock[]) {
  return blocks.map(({ tests, ...rest }) => ({
    ...rest,
    tests: tests.map(({ steps, ...rest }) => ({
      ...rest,
      steps: steps.map((step) => {
        const modified = {
          ...step,
          isCreateClient: step.type === 'createClient',
          isVariable: step.type === 'variable',
          isMethod: step.type === 'method',
        };

        if (step.type === 'method') {
          if (step.parameters) {
            let serialized = JSON.stringify(step.parameters);
            serialized = serialized.slice(1, serialized.length - 1);
            // @ts-expect-error
            modified.parameters = serialized;
          }
        }

        if (step.expected?.error) {
          // @ts-expect-error
          modified.expectedError = step.expected.error;
        }

        if (step.expected?.error === false) {
          // @ts-expect-error
          modified.expectedNoError = true;
        }

        return modified;
      }),
    })),
  }));
}
