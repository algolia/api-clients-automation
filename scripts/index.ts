/* eslint-disable no-param-reassign */
import { Argument, program } from 'commander';
import inquirer from 'inquirer';

import { buildClients } from './buildClients';
import { buildSpecs } from './buildSpecs';
import {
  CI,
  CLIENTS,
  CLIENTS_JS,
  createGeneratorKey,
  DOCKER,
  GENERATORS,
  LANGUAGES,
} from './common';
import { ctsGenerateMany } from './cts/generate';
import { runCts } from './cts/run';
import { generate } from './generate';
import { playground } from './playground';
import type { Generator } from './types';

if (!CI && !DOCKER) {
  // eslint-disable-next-line no-console
  console.log('You should run scripts via the docker container, see README.md');
  // eslint-disable-next-line no-process-exit
  process.exit(1);
}

program.name('api');

async function promptLanguage(defaut: string | undefined): Promise<string> {
  if (defaut) {
    return defaut;
  }
  if (CI) {
    return 'all';
  }
  const { language } = await inquirer.prompt([
    {
      type: 'list',
      name: 'language',
      message: 'Select a language',
      default: 'all',
      choices: ['all', new inquirer.Separator()].concat(LANGUAGES),
    },
  ]);
  return language;
}

async function promptClient(
  defaut: string | undefined,
  clientList = CLIENTS
): Promise<string> {
  if (defaut) {
    return defaut;
  }
  if (CI) {
    return 'all';
  }
  const { client } = await inquirer.prompt([
    {
      type: 'list',
      name: 'client',
      message: 'Select a client',
      default: 'all',
      choices: ['all', new inquirer.Separator()].concat(clientList),
    },
  ]);
  return client;
}

function generatorList({
  language,
  client,
  clientList = CLIENTS,
}: Pick<Generator, 'client' | 'language'> & {
  clientList?: string[];
}): Generator[] {
  let langsTodo = [language];
  let clientsTodo = [client];
  if (language === 'all') {
    langsTodo = LANGUAGES;
  }
  if (client === 'all') {
    clientsTodo = clientList;
  }

  return langsTodo
    .flatMap((lang) =>
      clientsTodo.map(
        (cli) => GENERATORS[createGeneratorKey({ language: lang, client: cli })]
      )
    )
    .filter(Boolean);
}

program
  .command('generate')
  .description('Generate a specified client')
  .addArgument(
    new Argument('[language]', 'The language').choices(
      ['all'].concat(LANGUAGES)
    )
  )
  .addArgument(
    new Argument('[client]', 'The client').choices(['all'].concat(CLIENTS))
  )
  .option('-v, --verbose', 'make the generation verbose')
  .action(
    async (
      language: string | undefined,
      client: string | undefined,
      { verbose }
    ) => {
      language = await promptLanguage(language);
      client = await promptClient(client);

      await generate(generatorList({ language, client }), Boolean(verbose));
    }
  );

const buildCommand = program.command('build');

buildCommand
  .command('clients')
  .description('Build a specified client')
  .addArgument(
    new Argument('[language]', 'The language').choices(
      ['all'].concat(LANGUAGES)
    )
  )
  .addArgument(
    new Argument('[client]', 'The client').choices(['all'].concat(CLIENTS_JS))
  )
  .option('-v, --verbose', 'make the compilation verbose')
  .action(
    async (
      language: string | undefined,
      client: string | undefined,
      { verbose }
    ) => {
      language = await promptLanguage(language);
      client = await promptClient(client, CLIENTS_JS);

      await buildClients(
        generatorList({ language, client, clientList: CLIENTS_JS }),
        Boolean(verbose)
      );
    }
  );

buildCommand
  .command('specs')
  .description('Build a specified spec')
  .addArgument(
    new Argument('[client]', 'The client').choices(['all'].concat(CLIENTS))
  )
  .addArgument(
    new Argument('[output-format]', 'The output format').choices([
      'yml',
      'json',
    ])
  )
  .option('-v, --verbose', 'make the verification verbose')
  .action(
    async (
      client: string | undefined,
      outputFormat: 'json' | 'yml' | undefined,
      { verbose }
    ) => {
      client = await promptClient(client);

      if (!outputFormat) {
        outputFormat = 'yml';
      }

      let clientsTodo = [client];
      if (client === 'all') {
        clientsTodo = CLIENTS;
      }
      await buildSpecs(clientsTodo, outputFormat!, Boolean(verbose), true);
    }
  );

const ctsCommand = program.command('cts');

ctsCommand
  .command('generate')
  .description('Generate the CTS tests')
  .addArgument(
    new Argument('[language]', 'The language').choices(
      ['all'].concat(LANGUAGES)
    )
  )
  .addArgument(
    new Argument('[client]', 'The client').choices(['all'].concat(CLIENTS))
  )
  .option('-v, --verbose', 'make the generation verbose')
  .action(
    async (
      language: string | undefined,
      client: string | undefined,
      { verbose }
    ) => {
      language = await promptLanguage(language);
      client = await promptClient(client);

      await ctsGenerateMany(
        generatorList({ language, client }),
        Boolean(verbose)
      );
    }
  );

ctsCommand
  .command('run')
  .description('Run the tests for the CTS')
  .addArgument(
    new Argument('[language]', 'The language').choices(
      ['all'].concat(LANGUAGES)
    )
  )
  .option('-v, --verbose', 'make the generation verbose')
  .action(async (language: string | undefined, { verbose }) => {
    language = await promptLanguage(language);

    let langsTodo = [language];
    if (language === 'all') {
      langsTodo = LANGUAGES;
    }
    await runCts(langsTodo, Boolean(verbose));
  });

program
  .command('playground')
  .description('Run the playground')
  .addArgument(new Argument('[language]', 'The language').choices(LANGUAGES))
  .addArgument(
    new Argument('[client]', 'The client').choices(['all'].concat(CLIENTS))
  )
  .action(async (language: string | undefined, client: string | undefined) => {
    language = await promptLanguage(language);
    client = await promptClient(client);

    await playground({
      language,
      client,
      key: createGeneratorKey({ language, client }),
    });
  });

program.parse();
