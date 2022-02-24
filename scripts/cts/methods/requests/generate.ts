import fsp from 'fs/promises';

import Mustache from 'mustache';

import { createSpinner } from '../../../oraLog';
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

export async function generateRequestsTests(
  {
    language,
    client,
    additionalProperties: { hasRegionalHost, packageName },
  }: Generator,
  verbose: boolean
): Promise<void> {
  createSpinner('generating requests tests', verbose).start().info();
  const spinner = createSpinner('loading templates', verbose).start();
  const { requests: template, ...partialTemplates } = await loadTemplates({
    language,
    testPath,
  });

  spinner.text = 'loading CTS';
  const cts = (await loadCTS(client)).requests;
  await createOutputDir({ language, testPath });

  if (cts.length === 0) {
    return;
  }

  spinner.text = 'rendering templates';
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
  spinner.succeed();
}
