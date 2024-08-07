import { Argument, program } from 'commander';
import semver from 'semver';

import { buildClients, buildPlaygrounds } from '../buildClients.js';
import { LANGUAGES, setVerbose } from '../common.js';
import { ctsGenerateMany } from '../cts/generate.js';
import { runCts } from '../cts/runCts.js';
import { startTestServer } from '../cts/testServer';
import { formatter } from '../formatter.js';
import { generate } from '../generate.js';
import { playground } from '../playground.js';
import { createReleasePR } from '../release/createReleasePR.js';
import { generateSLA } from '../release/sla.js';
import { snippetsGenerateMany } from '../snippets/generate.js';
import { buildSpecs } from '../specs';
import type { Language } from '../types.js';

import type { LangArg } from './utils.js';
import {
  ALL,
  getClientChoices,
  generatorList,
  transformSelection,
  PROMPT_CLIENTS,
  PROMPT_LANGUAGES,
} from './utils.js';

const args = {
  language: new Argument('[language]', 'The language').choices(PROMPT_LANGUAGES),
  languages: new Argument('[language...]', 'The language').choices(PROMPT_LANGUAGES),
  clients: new Argument('[client...]', 'The client').choices(getClientChoices('all')),
  client: new Argument('[client]', 'The client').choices(PROMPT_CLIENTS),
};

const flags = {
  verbose: {
    flag: '-v, --verbose',
    description: 'make the generation verbose',
  },
  skipCache: {
    flag: '-s, --skip-cache',
    description: 'skip cache checking to force building specs',
  },
};

program.name('cli');

program
  .command('generate')
  .description('Generate a specified client')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, clientArg: string[], { verbose }) => {
    const { language, client, clientList } = transformSelection({
      langArg,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await generate(generatorList({ language, client, clientList }));
  });

const buildCommand = program.command('build').description('Build the clients or specs');

buildCommand
  .command('clients')
  .description('Build a specified client')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, clientArg: string[], { verbose }) => {
    const { language, client, clientList } = transformSelection({
      langArg,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await buildClients(generatorList({ language, client, clientList }));
  });

buildCommand
  .command('playground')
  .description('Build a specified playground')
  .addArgument(args.language)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, { verbose }) => {
    setVerbose(Boolean(verbose));

    await buildPlaygrounds(langArg === ALL || langArg === undefined ? LANGUAGES : [langArg]);
  });

buildCommand
  .command('specs')
  .description('Build a specified spec')
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .option(flags.skipCache.flag, flags.skipCache.description)
  .option('-json, --output-json', 'outputs the spec in JSON instead of yml')
  .option('-d, --docs', 'generates the doc specs with the code snippets')
  .action(async (clientArg: string[], { verbose, skipCache, outputJson, docs }) => {
    const { client, clientList } = transformSelection({
      langArg: ALL,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await buildSpecs({
      clients: client[0] === ALL ? clientList : client,
      outputFormat: outputJson ? 'json' : 'yml',
      docs: Boolean(docs),
      useCache: !skipCache,
    });
  });

const ctsCommand = program.command('cts').description('Generate and run the CTS tests');

ctsCommand
  .command('generate')
  .description('Generate the CTS tests')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, clientArg: string[], { verbose }) => {
    const { language, client, clientList } = transformSelection({
      langArg,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await ctsGenerateMany(generatorList({ language, client, clientList }));
  });

ctsCommand
  .command('run')
  .description('Run the tests for the CTS')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .option('-e, --no-e2e', 'run the e2e tests, that requires internet connection')
  .option('-c, --no-client', 'run the client tests')
  .option('-r, --no-requests', 'run the requests tests')
  .option('-b, --benchmark', 'run the benchmarks')
  .action(
    async (
      langArg: LangArg,
      clientArg: string[],
      { verbose, e2e, client: includeClient, requests, benchmark },
    ) => {
      const { language, client } = transformSelection({
        langArg,
        clientArg,
      });

      setVerbose(Boolean(verbose));

      await runCts(language === ALL ? LANGUAGES : [language], client, {
        client: includeClient,
        requests,
        e2e,
        benchmark,
      });
    },
  );

ctsCommand
  .command('server')
  .description('Start the test servers in standalone mode')
  .action(async () => {
    setVerbose(true);
    await startTestServer({
      benchmark: true,
      client: true,
      requests: true,
      e2e: true,
    });
  });

program
  .command('playground')
  .description('Run the playground')
  .addArgument(args.language)
  .addArgument(args.client)
  .action(async (langArg: LangArg, cliClient: string) => {
    const { language, client } = transformSelection({
      langArg,
      clientArg: [cliClient],
    });

    setVerbose(true);

    await playground({
      language,
      client: client[0],
    });
  });

program
  .command('format')
  .description('Format the specified folder for a specific language')
  .addArgument(args.language)
  .argument('folder', 'The folder to format')
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (language: string, folder: string, { verbose }) => {
    setVerbose(Boolean(verbose));

    await formatter(language, folder);
  });

program
  .command('snippets')
  .description('Generate the snippets')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, clientArg: string[], { verbose }) => {
    const { language, client, clientList } = transformSelection({
      langArg,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await snippetsGenerateMany(generatorList({ language, client, clientList }));
  });

program
  .command('release')
  .description('Releases the client')
  .addArgument(args.languages)
  .option(flags.verbose.flag, flags.verbose.description)
  .option<semver.ReleaseType>(
    '-rt --releaseType <type>',
    'triggers a release for the given language list with the given releaseType',
    (value, _previous) => {
      if (semver.RELEASE_TYPES.includes(value as semver.ReleaseType)) {
        return value as semver.ReleaseType;
      }
      return 'patch';
    },
    undefined,
  )
  .option('-d, --dry-run', 'does not push anything to GitHub')
  .option('-sla, --sla-only', 'only generates the sla policy', false)
  .action(async (langArgs: LangArg[], { verbose, releaseType, dryRun, slaOnly }) => {
    setVerbose(Boolean(verbose));

    if (slaOnly) {
      await generateSLA({});

      return;
    }

    if (langArgs.length === 0) {
      langArgs = [ALL];
    }

    await createReleasePR({
      languages: langArgs.includes(ALL) ? LANGUAGES : (langArgs as Language[]),
      releaseType,
      dryRun,
    });
  });

program.parse();
