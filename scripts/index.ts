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
import { generate } from './generate';
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
      // eslint-disable-next-line no-param-reassign
      language = await promptLanguage(language);
      // eslint-disable-next-line no-param-reassign
      client = await promptClient(client);

      await generate(generatorList({ language, client }), Boolean(verbose));
    }
  );

program
  .command('build:clients')
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
      // eslint-disable-next-line no-param-reassign
      language = await promptLanguage(language);
      // eslint-disable-next-line no-param-reassign
      client = await promptClient(client, CLIENTS_JS);

      await buildClients(
        generatorList({ language, client, clientList: CLIENTS_JS }),
        Boolean(verbose)
      );
    }
  );

program
  .command('build:specs')
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
      // eslint-disable-next-line no-param-reassign
      client = await promptClient(client);

      if (!outputFormat) {
        // eslint-disable-next-line no-param-reassign
        ({ outputFormat } = await inquirer.prompt([
          {
            type: 'list',
            name: 'outputFormat',
            message: 'Select the output format',
            default: 'yml',
            choices: ['yml', 'json'],
          },
        ]));
      }

      let clientsTodo = [client];
      if (client === 'all') {
        clientsTodo = CLIENTS;
      }
      await buildSpecs(clientsTodo, outputFormat!, Boolean(verbose), true);
    }
  );

program.parse();
