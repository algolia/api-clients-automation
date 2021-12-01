import * as fsp from 'fs/promises';
import Mustache from 'mustache';
import * as path from 'path';
import SwaggerParser from 'swagger-parser';
import { OpenAPIV3 } from 'openapi-types';

const availableLanguages = ['javascript'];

type CTSBlock = {
  name: string,
  method: string,
  parameters: any[],
  request: {
    path: string,
    method: string,
    data: string,
  }
};

// Array of test per client
type CTS = Record<string, CTSBlock[]>;

const packageNameMapping: Record<string, string> = { javascript: 'npmName' };

//For each language, for each client, we have a package name
let packageNames: Record<string, Record<string, string>> = {};
let cts: CTS = {};

async function createOutputDir(language: string) {
  await fsp.mkdir(`output/${language}`, { recursive: true });
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
  // For each generator, we map the packageName with the language and client
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
    const tests: CTSBlock[] = JSON.parse((await fsp.readFile(file.path)).toString());

    // for now we stringify all params for mustache to render them properly
    for (const test of tests) {
      for (let i = 0; i < test.parameters.length; i++) {
        // delete the object name for now, but it could be use for `new $objectName(params)`
        delete test.parameters[i]["$objectName"];

        // include the `-last` param to join with comma in mustache
        test.parameters[i] = {
          value: JSON.stringify(test.parameters[i]),
          '-last': i === test.parameters.length - 1,
        };
      }

      // stringify request.data too
      test.request.data = JSON.stringify(test.request.data);
    }


    // check test validity against spec
    if (!operations.includes(operationId)) {
      throw new Error(`cannot find operationId ${operationId} for the ${client} client`);
    }
    ctsClient.push(...tests);
  }
  return ctsClient;
}

async function loadCTS(): Promise<void> {
  for await (const { name: client } of await fsp.opendir('./CTS/clients/')) {
    cts[client] = await loadCTSForClient(client);
  }
}

async function loadTemplate(language: string): Promise<string> {
  return (await fsp.readFile(`CTS/templates/${language}.mustache`)).toString();
}

async function generateCode(language: string) {
  const template = await loadTemplate(language);
  await createOutputDir(language);
  for (const client in cts) {
    if (cts[client].length === 0) {
      continue;
    }

    const code = Mustache.render(template, {
      import: packageNames[language][client],
      client: `${capitalize(client)}Api`,
      tests: cts[client]
    });
    await fsp.writeFile(`output/${language}/${client}.test.ts`, code);
  }
}

function printUsage() {
  console.log(`usage: generateCTS all | language1 language2...`);
  console.log(`\tavailable languages: ${availableLanguages.join(',')}`);
  process.exit(1);
}

async function parseCLI(args: string[]) {
  if (args.length < 3) {
    console.log("not enough arguments");
    printUsage();
  }

  let toGenerate: string[];
  if (args.length == 3 && args[2] === 'all') {
    toGenerate = availableLanguages;
  } else {
    const languages = args.slice(2);
    if (!languages.every((lang) => availableLanguages.includes(lang))) {
      console.log("unkown language: ", languages.join(', '));
      printUsage();
    }
    toGenerate = languages;
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
