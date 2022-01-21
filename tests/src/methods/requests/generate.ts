import fsp from 'fs/promises';

import Mustache from 'mustache';

import openapitools from '../../../../openapitools.json';
import { loadCTS } from './cts';
import { loadRequestsTemplate } from './templates';
import type { CTSBlock } from './types';
import {
  createClientName,
  packageNames,
  extensionForLanguage,
} from '../../utils';

async function createOutputDir(language: string): Promise<void> {
  await fsp.mkdir(`output/${language}/tests/methods/requests`, {
    recursive: true,
  });
}

async function generateRequestsTests(
  cts: CTSBlock[],
  template: string,
  language: string,
  client: string
): Promise<void> {
  if (cts.length === 0) {
    return;
  }

  const code = Mustache.render(template, {
    import: packageNames[language][client],
    client: createClientName(client),
    blocks: cts,
    hasRegionalHost:
      openapitools['generator-cli'].generators[`${language}-${client}`]
        .additionalProperties.hasRegionalHost === true
        ? true
        : undefined,
  });
  await fsp.writeFile(
    `output/${language}/tests/methods/requests/${client}.${extensionForLanguage[language]}`,
    code
  );
}

export async function generateTests(
  language: string,
  client: string
): Promise<void> {
  const template = await loadRequestsTemplate(language);
  const cts = await loadCTS(client);

  await createOutputDir(language);

  await generateRequestsTests(cts.requests, template, language, client);
}
