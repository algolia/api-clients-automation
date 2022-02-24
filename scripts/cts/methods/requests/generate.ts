import fsp from 'fs/promises';

import Mustache from 'mustache';

import type { Generator } from '../../../types';
import {
  createClientName,
  capitalize,
  getOutputPath,
  createOutputDir,
  loadTemplates,
} from '../../utils';

import { loadCTS } from './cts';

const testPath = 'methods/requests';

export async function generateRequestsTests({
  language,
  client,
  additionalProperties: { hasRegionalHost, packageName },
}: Generator): Promise<void> {
  const { requests: template, ...partialTemplates } = await loadTemplates({
    language,
    testPath,
  });
  const cts = (await loadCTS(client)).requests;
  await createOutputDir({ language, testPath });

  if (cts.length === 0) {
    return;
  }

  const code = Mustache.render(
    template,
    {
      import: packageName,
      client: createClientName(client, language),
      blocks: cts,
      hasRegionalHost: hasRegionalHost ? true : undefined,
      capitalize() {
        return function (text: string, render: (t: string) => string): string {
          return capitalize(render(text));
        };
      },
      escapeQuotes() {
        return function (text: string, render: (t: string) => string): string {
          return render(text).replace(/"/g, '\\"');
        };
      },
    },
    partialTemplates
  );

  await fsp.writeFile(getOutputPath({ language, client, testPath }), code);
}
