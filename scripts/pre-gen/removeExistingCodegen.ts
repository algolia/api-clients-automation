import fsp from 'fs/promises';
import path from 'path';

import { createClientName, run, toAbsolutePath, toSnakeCase } from '../common.ts';
import { getLanguageApiFolder, getLanguageFolder, getLanguageModelFolder } from '../config.ts';
import type { Generator } from '../types.ts';

/**
 * Remove `model` folder for the current language and client.
 */
export async function removeExistingCodegen({ language, client, output }: Generator): Promise<void> {
  let folder = getLanguageFolder(language);
  let baseModelFolder = getLanguageModelFolder(language);
  let baseApiFolder = getLanguageApiFolder(language);
  const clientName = createClientName(client, language);

  let clientModel = '';
  let clientApi = '';

  switch (language) {
    case 'dart':
      folder = output;
      break;
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
      folder = output;

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
      clientModel = `${toSnakeCase(clientName)}/models`;
      clientApi = toSnakeCase(clientName);
      baseModelFolder = 'algoliasearch';
      baseApiFolder = 'algoliasearch';
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

  // Delete client model folder/file
  await run(`rm -rf ${path.join(folder, baseModelFolder, clientModel)}`, {
    language,
  });

  // Delete client api folder/file
  await run(`rm -rf ${path.join(folder, baseApiFolder, clientApi)}`, {
    language,
  });
}
