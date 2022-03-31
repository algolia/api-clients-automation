import { CLIENTS, GENERATORS, run } from '../common';
import type { Language } from '../types';

type CreateMatrix = {
  language?: Language;
  baseChanged: boolean;
  baseBranch: string;
};

type Client = {
  name: string;
  folder: string;
  config?: string;
  api?: string;
};

type Matrix<TMatrix> = {
  client: TMatrix[];
};

async function getClientMatrix({
  language,
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<Client>> {
  const matrix: Matrix<Client> = { client: [] };

  for (const [generatorKey, generatorOptions] of Object.entries(GENERATORS)) {
    if (
      generatorKey.startsWith(`${language}-`) === false ||
      // `algoliasearch` is an aggregation of clients
      generatorOptions.client === 'algoliasearch'
    ) {
      continue;
    }

    const folder = generatorOptions.output.replace('#{cwd}', '');
    const specChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- specs/${generatorOptions.client} | wc -l | tr -d ' '`
    );
    const clientChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- ${folder} | wc -l | tr -d ' '`
    );

    if (clientChanges === '0' && specChanges === '0' && baseChanged === false) {
      continue;
    }

    const matchedGenerator: Client = {
      name: generatorOptions.client,
      folder,
    };

    // Extra informations for the PHP matrix in order to properly scope the
    // GitHub action cache
    if (language === 'php') {
      matchedGenerator.config =
        generatorOptions.additionalProperties.configClassname;
      matchedGenerator.api =
        generatorOptions.additionalProperties.configClassname.replace(
          'Config',
          'Api'
        );
    }

    matrix.client.push(matchedGenerator);
  }

  return matrix;
}

async function getSpecMatrix({
  baseBranch,
  baseChanged,
}: CreateMatrix): Promise<Matrix<string>> {
  const matrix: Matrix<string> = { client: [] };

  for (const client of CLIENTS) {
    const specChanges = await run(
      `git diff --shortstat ${baseBranch}..HEAD -- specs/${client} | wc -l | tr -d ' '`
    );

    if (specChanges === '0' && baseChanged === false) {
      continue;
    }

    matrix.client.push(client);
  }

  return matrix;
}

export async function createMatrix(
  job: 'client' | 'spec',
  opts: CreateMatrix
): Promise<void> {
  const matrix =
    job === 'spec' ? await getSpecMatrix(opts) : await getClientMatrix(opts);

  // eslint-disable-next-line no-console
  console.log(
    // client cannot be empty or the matrix will fail
    matrix.client.length === 0
      ? '{"client":["no-run"]}'
      : JSON.stringify(matrix)
  );
}

const [job, ...args] = process.argv.slice(2);

if (require.main === module) {
  switch (job) {
    case 'spec':
      createMatrix(job, {
        baseChanged: args[0] === 'true',
        baseBranch: args[1],
      });
      break;
    case 'client':
      createMatrix(job, {
        language: args[0] as Language,
        baseChanged: args[1] === 'true',
        baseBranch: args[2],
      });
      break;
    default:
      throw new Error(`Unknown job: ${job}`);
  }
}
