import fsp from 'fs/promises';

import Mustache from 'mustache';

import openapitools from '../../../../openapitools.json';
import {
  createClientName,
  packageNames,
  capitalize,
  outputPath,
  createOutputDir,
} from '../../utils';

import { loadCTS } from './cts';
import { loadPartials, loadRequestsTemplate } from './templates';
import type { CTSBlock } from './types';

const testPath = 'methods/requests';

async function generateRequestsTests(
  cts: CTSBlock[],
  template: string,
  language: string,
  client: string,
  partials: Record<string, string>
): Promise<void> {
  if (cts.length === 0) {
    return;
  }

  const code = Mustache.render(
    template,
    {
      import: packageNames[language][client],
      client: createClientName(client),
      blocks: cts,
      hasRegionalHost: openapitools['generator-cli'].generators[
        `${language}-${client}`
      ].additionalProperties.hasRegionalHost
        ? true
        : undefined,
      capitalize() {
        return function (text: string, render: (string) => string): string {
          return capitalize(render(text));
        };
      },
      escapeQuotes() {
        return function (text: string, render: (string) => string): string {
          return render(text).replace(/"/g, '\\"');
        };
      },
    },
    partials
  );

  await fsp.writeFile(outputPath({ language, client, testPath }), code);
}

export async function generateTests(
  language: string,
  client: string
): Promise<void> {
  const template = await loadRequestsTemplate(language);
  const cts = await loadCTS(client);
  const partials = await loadPartials(language);

  await createOutputDir({ language, testPath });

  await generateRequestsTests(
    cts.requests,
    template,
    language,
    client,
    partials
  );
}
