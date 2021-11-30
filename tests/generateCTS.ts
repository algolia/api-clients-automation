import * as fsp from 'fs/promises';
import Mustache from 'mustache';
import * as path from 'path';
import SwaggerParser from 'swagger-parser';
import { OpenAPIV3 } from 'openapi-types';

const availableLangages = ['javascript'];

type CTSBlock = {
  name: string,
  method: string,
  parameters: any[],
  request: {
    path: string,
    method: string,
    body: string,
  }
};

// Array of test per client
type WholeCTS = Record<string, CTSBlock[]>;

const packageNameMapping: Record<string, string> = { javascript: 'npmName' };

//For each langage, for each client, we have a package name
let packageNames: Record<string, Record<string, string>> = {};
let cts: WholeCTS = {};

async function createOutputDir(langage: string) {
  await fsp.mkdir(`output/${langage}`, { recursive: true });
}

async function* walk(dir: string): AsyncGenerator<{ path: string, name: string }> {
  for await (const d of await fsp.opendir(dir)) {
    const entry = path.join(dir, d.name);
    if (d.isDirectory()) yield* walk(entry);
    else if (d.isFile()) yield { path: entry, name: d.name };
  }
}

function capitalize(str: string): string {
  return str.charAt(0).toUpperCase() + str.slice(1);
}

async function loadPackageNames(): Promise<void> {
  const openapitools = JSON.parse((await fsp.readFile('../openapitools.json')).toString());
  packageNames = Object.entries(openapitools["generator-cli"].generators).reduce((prev, curr: any) => {
    const [lang, client] = curr[0].split("-");
    if (!(lang in prev)) {
      prev[lang] = {};
    }
    prev[lang][client] = curr[1].additionalProperties[packageNameMapping[lang]];
    return prev;
  }, {});
}

async function loadCTSForClient(client: string): Promise<CTSBlock[]> {
  // load the list of operations from the spec
  const spec = await SwaggerParser.validate(`../specs/${client}/spec.yml`);
  const operations = Object.values(spec.paths).flatMap<OpenAPIV3.OperationObject>((path) => Object.values(path)).map((obj) => obj.operationId);

  const ctsClient: CTSBlock[] = [];

  for await (const file of walk(`./CTS/clients/${client}`)) {
    if (!file.name.endsWith('json')) {
      continue;
    }
    const operationId = file.name.replace('.json', '');
    const test: CTSBlock[] = JSON.parse((await fsp.readFile(file.path)).toString());
    for (let i = 0; i < test[0].parameters.length; i++) {
      test[0].parameters[i] = JSON.stringify(test[0].parameters[i]);
    }

    //check test validity against spec
    if (!operations.includes(operationId)) {
      throw new Error(`cannot find operationId ${operationId} for the ${client} client`);
    }
    ctsClient.push(...test);
  }
  return ctsClient;
}

async function loadCTS(): Promise<void> {
  for await (const { name: client } of await fsp.opendir('./CTS/clients/')) {
    cts[client] = await loadCTSForClient(client);
  }
}

async function loadTemplate(langage: string): Promise<string> {
  return (await fsp.readFile(`CTS/templates/${langage}.mustache`)).toString();
}

async function generateCode(langage: string) {
  const template = await loadTemplate(langage);
  await createOutputDir(langage);
  for (const client in cts) {
    const code = Mustache.render(template, {
      import: packageNames[langage][client],
      client: `${capitalize(client)}Api`,
      tests: cts[client]
    });
    await fsp.writeFile(`output/${langage}/${client}.test.ts`, code);
  }
}

function printUsage() {
  console.log(`usage: generateCTS all | langage1 langage2...`);
  console.log(`\tavailable langages: ${availableLangages.join(',')}`);
  process.exit(1);
}

async function parseCLI(args: string[]) {
  if (args.length < 3) {
    console.log("not enough arguments");
    printUsage();
  }

  let toGenerate: string[];
  if (args.length == 3 && args[2] === 'all') {
    toGenerate = availableLangages;
  } else {
    const langages = args.slice(2);
    if (!langages.every((lang) => availableLangages.includes(lang))) {
      console.log("unkown langage: ", langages.join(', '));
      printUsage();
    }
    toGenerate = langages;
  }

  try {
    await loadPackageNames();
    await loadCTS();
    for (const lang of toGenerate) {
      generateCode(lang);
    }
  } catch (e) {
    if (e instanceof Error) {
      console.error(e);
    }
  }
}

parseCLI(process.argv);
