import { Argument, program } from 'commander';
import semver from 'semver';

import { buildClients, buildPlaygrounds, buildSnippets } from '../buildClients.ts';
import { CI, CLIENTS, LANGUAGES, run, setVerbose } from '../common.ts';
import { getLanguageFolder } from '../config.ts';
import { ctsGenerateMany } from '../cts/generate.ts';
import { runCts } from '../cts/runCts.ts';
import { startTestServer } from '../cts/testServer/index.ts';
import { formatter } from '../formatter.ts';
import { generate } from '../generate.ts';
import { playground } from '../playground.ts';
import { createReleasePR } from '../release/createReleasePR.ts';
import { generateSLA } from '../release/sla.ts';
import { snippetsGenerateMany } from '../snippets/generate.ts';
import { buildSpecs } from '../specs/index.ts';
import type { Language } from '../types.ts';

import type { LangArg } from './utils.ts';
import { ALL, getClientChoices, generatorList, transformSelection, PROMPT_CLIENTS, PROMPT_LANGUAGES } from './utils.ts';

const args = {
  language: new Argument('[language]', 'The language').choices(PROMPT_LANGUAGES),
  requiredLanguage: new Argument('language', 'The language').choices(LANGUAGES),
  languages: new Argument('[language...]', 'The language').choices(PROMPT_LANGUAGES),
  clients: new Argument('[client...]', 'The client').choices(getClientChoices('all')),
  client: new Argument('[client]', 'The client').choices(PROMPT_CLIENTS),
  requiredClient: new Argument('client', 'The client').choices(CLIENTS),
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

program.hook('preAction', () => {
  if (!CI) {
    // restore the cursor because sometime it's broken
    process.stdout.write('\x1B[?25h');
  }
});

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
  .command('snippets')
  .description('Build a specified snippets')
  .addArgument(args.language)
  .option(flags.verbose.flag, flags.verbose.description)
  .action(async (langArg: LangArg, { verbose }) => {
    setVerbose(Boolean(verbose));

    await buildSnippets(langArg === ALL || langArg === undefined ? LANGUAGES : [langArg]);
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
  .option('-lv, --language-version <version>', 'the version of the language to use')
  .action(async (langArg: LangArg, clientArg: string[], { verbose, languageVersion }) => {
    const { language, client, clientList } = transformSelection({
      langArg,
      clientArg,
    });

    setVerbose(Boolean(verbose));

    await ctsGenerateMany(generatorList({ language, client, clientList }), languageVersion);
  });

ctsCommand
  .command('run')
  .description('Run the tests for the CTS')
  .addArgument(args.language)
  .addArgument(args.clients)
  .option(flags.verbose.flag, flags.verbose.description)
  .option('-e, --no-e2e', 'skip the e2e tests, that requires internet connection')
  .option('-c, --no-client', 'skip the client tests')
  .option('-r, --no-requests', 'skip the requests tests')
  .option('-b, --benchmark', 'run the benchmarks')
  .action(
    async (langArg: LangArg, clientArg: string[], { verbose, e2e, client: includeClient, requests, benchmark }) => {
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
  .addArgument(args.requiredLanguage)
  .addArgument(args.requiredClient)
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
  .addArgument(args.requiredLanguage)
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
  .option('-b --breaking', 'allow breaking change on the CI', false)
  .action(async ({ verbose, releaseType, dryRun, slaOnly, breaking }) => {
    setVerbose(Boolean(verbose));

    if (slaOnly) {
      await generateSLA({});

      return;
    }

    await createReleasePR({
      releaseType,
      dryRun,
      breaking,
    });
  });

program
  .command('exec')
  .description('Executes a command inside the correct docker image')
  .addArgument(args.requiredLanguage)
  .argument('command...', 'The command to execute')
  .option('-c, --client', "Run the command in the client's folder")
  .action(async (language: Language, command: string[], { client }) => {
    setVerbose(true);
    await run(command.join(' '), { language, cwd: client ? getLanguageFolder(language) : undefined });
  });

program.parse();
