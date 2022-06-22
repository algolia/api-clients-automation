import inquirer from 'inquirer';

import { CLIENTS, GENERATORS, LANGUAGES } from '../common';
import type { Generator, Language } from '../types';

export const PROMPT_ALL = 'all';
export const PROMPT_LANGUAGES = [PROMPT_ALL, ...LANGUAGES];
export const PROMPT_CLIENTS = [PROMPT_ALL, ...CLIENTS];

export type LangArg = Language | 'all' | undefined;

export type PromptDecision = {
  language: Language | 'all';
  client: string[];
  clientList: string[];
};

export type Job = 'build' | 'generate' | 'specs';

type Prompt = {
  langArg: LangArg;
  clientArg: string[];
  job: Job;
  interactive: boolean;
};

export function getClientChoices(
  job: Job,
  language?: Language | 'all'
): string[] {
  const withoutAlgoliaSearch = PROMPT_CLIENTS.filter(
    (client) => client !== 'algoliasearch'
  );

  if (!language) {
    return job === 'specs' ? withoutAlgoliaSearch : PROMPT_CLIENTS;
  }

  const isJavaScript = language === PROMPT_ALL || language === 'javascript';

  switch (job) {
    // We don't need to build `lite` client as it's a subset of the `algoliasearch` one
    case 'build':
      // Only `JavaScript` provide a lite client, others can build anything but it.
      if (isJavaScript) {
        return PROMPT_CLIENTS.filter((client) => client !== 'lite');
      }

      return withoutAlgoliaSearch.filter((client) => client !== 'lite');
    // `algoliasearch` is not built from specs, it's an aggregation of clients
    case 'specs':
      return withoutAlgoliaSearch;
    case 'generate':
      // Only `JavaScript` provide a lite client, others can build anything but it.
      if (isJavaScript) {
        return withoutAlgoliaSearch;
      }

      return withoutAlgoliaSearch.filter((client) => client !== 'lite');
    default:
      return PROMPT_CLIENTS;
  }
}

export function generatorList({
  language,
  client,
  clientList,
}: {
  language: Language | 'all';
  client: string[];
  clientList: string[];
}): Generator[] {
  const langsTodo = language === PROMPT_ALL ? LANGUAGES : [language];
  const clientsTodo = client[0] === PROMPT_ALL ? clientList : client;

  return langsTodo
    .flatMap((lang) => clientsTodo.map((cli) => GENERATORS[`${lang}-${cli}`]))
    .filter(Boolean);
}

export async function prompt({
  langArg,
  clientArg,
  job,
  interactive,
}: Prompt): Promise<PromptDecision> {
  const decision: PromptDecision = {
    client: [PROMPT_ALL],
    language: PROMPT_ALL,
    clientList: [],
  };

  if (!langArg) {
    if (interactive) {
      const { language } = await inquirer.prompt<PromptDecision>([
        {
          type: 'list',
          name: 'language',
          message: 'Select a language',
          default: PROMPT_ALL,
          choices: LANGUAGES,
        },
      ]);

      decision.language = language;
    }
  } else {
    decision.language = langArg;
  }

  decision.clientList = getClientChoices(job, decision.language);

  if (!clientArg || !clientArg.length) {
    if (interactive) {
      const { client } = await inquirer.prompt<{ client: string }>([
        {
          type: 'list',
          name: 'client',
          message: 'Select a client',
          default: PROMPT_ALL,
          choices: decision.clientList,
        },
      ]);

      decision.client = [client];
    }
  } else {
    clientArg.forEach((client) => {
      if (!decision.clientList.includes(client)) {
        throw new Error(
          `The '${clientArg}' client can't run with the given job: '${job}'.\n\nAllowed choices are: ${decision.clientList.join(
            ', '
          )}`
        );
      }
    });

    decision.client = clientArg;
  }

  return decision;
}
