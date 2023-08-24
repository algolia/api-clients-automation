import fsp from 'fs/promises';

import yaml from 'js-yaml';

import { buildSpecs } from '../buildSpecs.js';
import { buildCustomGenerators, CI, run, toAbsolutePath } from '../common.js';
import { getTestOutputFolder } from '../config.js';
import { generateOpenapitools } from '../pre-gen/index.js';
import { createSpinner } from '../spinners.js';
import type { Generator, Snippet, Spec } from '../types.js';

async function csGenerate(gen: Generator): Promise<void> {
  const spinner = createSpinner(`generating CS for ${gen.key}`);

  await run(
    `yarn openapi-generator-cli --custom-generator=generators/build/libs/algolia-java-openapi-generator-1.0.0.jar generate \
     -g algolia-cs -i specs/bundled/${gen.client}.yml --additional-properties="language=${gen.language},client=${gen.client}"`
  );
  spinner.succeed();
}

export async function csGenerateMany(generators: Generator[]): Promise<void> {
  if (!CI) {
    const clients = [...new Set(generators.map((gen) => gen.client))];
    await buildSpecs(clients, 'yml', true);
  }

  await generateOpenapitools(generators);
  await buildCustomGenerators();

  for (const gen of generators) {
    if (!getTestOutputFolder(gen.language)) {
      continue;
    }
    await csGenerate(gen);
    await updateBundle(gen);
  }
}

/**
 * This function takes in paths for an OpenAPI specification and code snippets YAML files.
 * It will inject the code snippets and their descriptions into the OpenAPI specification
 * based on matching operationIds. The resulting modified OpenAPI spec will be saved to
 * the provided outputPath.
 */
async function updateBundle(gen: Generator, override: boolean = true): Promise<void> {
  try {
    const openapiPath = toAbsolutePath(`specs/bundled/${gen.client}.yml`);
    const snippetsPath = toAbsolutePath(`snippets/${gen.language}/${gen.client}.yml`);
    const outputPath = override
      ? openapiPath
      : toAbsolutePath(`specs/bundled/${gen.client}_cs.yml`);

    // Load and parse the OpenAPI specification from the provided path
    const openApiSpecContent = await fsp.readFile(openapiPath, 'utf8');
    const openApiSpec = yaml.load(openApiSpecContent) as Spec;

    // Load and parse the code snippets from the provided path
    const codeSnippetsContent = await fsp.readFile(snippetsPath, 'utf8');
    const codeSnippets = yaml.load(codeSnippetsContent) as Snippet[];

    // Process each snippet to inject it into the OpenAPI spec
    for (const snippet of codeSnippets) {
      addSnippetToPath(snippet, openApiSpec, gen);
    }
    // Serialize and save the modified OpenAPI spec
    const dumpedYaml = yaml.dump(openApiSpec, { lineWidth: 120 });
    await fsp.writeFile(outputPath, dumpedYaml, 'utf8');
  } catch (err) {
    throw new Error(`Failed to update bundled specs: ${err}`);
  }
}

function addSnippetToPath(snippet: Snippet, openApiSpec: Spec, gen: Generator): void {
  const operationId = snippet.operationId;

  for (const path in openApiSpec.paths) {
    if (!openApiSpec.paths.hasOwnProperty(path)) continue;

    for (const method in openApiSpec.paths[path]) {
      if (!openApiSpec.paths[path].hasOwnProperty(method)) continue;

      const endpoint = openApiSpec.paths[path][method];

      // Match the operationId and inject the snippet
      if (endpoint.operationId === operationId) {
        // Initialize the x-meta section if it doesn't exist
        if (!endpoint['x-meta']) {
          endpoint['x-meta'] = { examples: {} };
        }

        // Initialize the subsection for the provided language if it doesn't exist
        if (!endpoint['x-meta'].examples[gen.language]) {
          endpoint['x-meta'].examples[gen.language] = [];
        }

        // Add the snippet and its description to the list of examples for the language
        const formatted = snippet.code
          .split('\n')
          .filter((line) => line.trim() !== '')
          .join('\n');
        endpoint['x-meta'].examples[gen.language].push({
          code: formatted,
          description: snippet.description,
        });
      }
    }
  }
}
