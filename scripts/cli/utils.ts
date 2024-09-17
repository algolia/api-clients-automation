import { CLIENTS, GENERATORS, LANGUAGES } from '../common.ts';
import type { Generator, Language } from '../types.ts';

export const ALL = 'all';
export const PROMPT_LANGUAGES = [ALL, ...LANGUAGES];
export const PROMPT_CLIENTS = [ALL, ...CLIENTS];

export type AllLanguage = Language | typeof ALL;
export type LangArg = AllLanguage | undefined;

type Selection = {
  language: AllLanguage;
  client: string[];
  clientList: string[];
};

type Args = {
  langArg: LangArg;
  clientArg: string[];
};

export function getClientChoices(language?: LangArg, clientList = PROMPT_CLIENTS): string[] {
  const withoutAlgoliaSearch = clientList.filter((client) => client !== 'algoliasearch');

  return language === ALL || language === 'javascript' || language === 'dart' ? clientList : withoutAlgoliaSearch;
}

export function generatorList({
  language,
  client,
  clientList,
}: {
  language: AllLanguage;
  client: string[];
  clientList: string[];
}): Generator[] {
  const langsTodo = language === ALL ? LANGUAGES : [language];
  const clientsTodo = client[0] === ALL ? clientList : client;

  return langsTodo.flatMap((lang) => clientsTodo.map((cli) => GENERATORS[`${lang}-${cli}`])).filter(Boolean);
}

export function transformSelection({ langArg, clientArg }: Args): Selection {
  const selection: Selection = {
    client: [ALL],
    language: langArg || ALL,
    clientList: [],
  };

  selection.clientList = getClientChoices(selection.language, CLIENTS);

  if (clientArg?.length) {
    clientArg.forEach((client) => {
      if (![ALL, ...selection.clientList].includes(client)) {
        throw new Error(
          `The '${clientArg}' client does not exist for ${
            selection.language
          }.\n\nAllowed choices are: ${selection.clientList.join(', ')}`,
        );
      }
    });

    selection.client = clientArg;
  }

  return selection;
}
