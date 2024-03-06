import fsp from 'fs/promises';
import path from 'path';

import { glob } from 'glob';

import { createClientName, isVerbose, toAbsolutePath, toSnakeCase } from '../common.js';
import { getLanguageApiFolder, getLanguageModelFolder } from '../config.js';
import type { Generator } from '../types.js';

/**
 * Remove `model` folder for the current language and client.
 */
export async function removeExistingCodegen({
  language,
  client,
  output,
}: Generator): Promise<void> {
  let baseModelFolder = getLanguageModelFolder(language);
  let baseApiFolder = getLanguageApiFolder(language);
  const clientName = createClientName(client, language);

  let clientModel = '';
  let clientApi = '';

  switch (language) {
    case 'csharp':
      clientModel = clientName;
      clientApi = `${clientName}*.cs`;
      break;
    case 'go':
      clientModel = clientName.toLowerCase();
      clientApi = clientName.toLowerCase();
      break;
    case 'java':
      clientModel = client.replace('-', '');
      clientApi = `${clientName}*.java`;
      break;
    case 'javascript':
      // We want to also delete the nested `lite` client or folders that only exists in JS
      if (clientName === 'algoliasearch') {
        await fsp.rm(toAbsolutePath(path.resolve('..', output, 'lite')), {
          force: true,
          recursive: true,
        });
      }

      // Delete `builds` folder
      await fsp.rm(toAbsolutePath(path.resolve('..', output, 'builds')), {
        force: true,
        recursive: true,
      });
      break;
    case 'kotlin':
      clientModel = clientName.toLowerCase();
      clientApi = `${clientName}*.kt`;
      break;
    case 'php':
      clientModel = clientName;
      clientApi = `${clientName}*.php`;
      break;
    case 'python':
      clientModel = toSnakeCase(clientName);
      clientApi = toSnakeCase(clientName);
      baseModelFolder = '';
      baseApiFolder = '';
      break;
    case 'ruby':
      clientModel = clientName.toLowerCase();
      clientApi = `${toSnakeCase(clientName)}_client.rb`;
      break;
    case 'scala':
      clientModel = client.replace('-', '');
      clientApi = `${clientName}*.scala`;
      break;

    case 'swift':
      clientModel = `${clientName}/Models`;
      clientApi = `${clientName}/*.swift`;
      break;
    default:
      break;
  }

  // Delete client model and API folder/files
  const filesToRemove = await glob([
    toAbsolutePath(path.resolve('..', output, baseModelFolder, clientModel)),
    toAbsolutePath(path.resolve('..', output, baseApiFolder, clientApi)),
  ]);

  if (isVerbose()) {
    // eslint-disable-next-line no-console
    console.log('Existing codegen that will be removed: ', filesToRemove);
  }

  for (const file of filesToRemove) {
    await fsp.rm(file, { force: true, recursive: true });
  }
}
