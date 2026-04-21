import fsp from 'fs/promises';
import { isDeepStrictEqual } from 'node:util';

import oas2har from '@har-sdk/oas';
import type { HarRequest } from '@readme/httpsnippet';
import { HTTPSnippet } from '@readme/httpsnippet';
import yaml from 'js-yaml';

import { Cache } from '../cache.ts';
import { GENERATORS, run, toAbsolutePath } from '../common.ts';
import { createSpinner } from '../spinners.ts';
import type { Spec } from '../types.ts';

import { CODE_SAMPLE_KEY, getCodeSampleLabel, transformGeneratedSnippetsToCodeSamples } from './snippets.ts';

type OpenAPIParameter = {
  $ref?: string;
  name?: string;
  required?: boolean;
};

const MERGEABLE_OBJECT_SCHEMA_KEYS = new Set([
  '$ref',
  'additionalProperties',
  'allOf',
  'default',
  'deprecated',
  'description',
  'example',
  'nullable',
  'properties',
  'readOnly',
  'required',
  'title',
  'type',
  'writeOnly',
  'x-categories',
]);

function resolveLocalRef<T>(spec: Spec, ref: string): T | undefined {
  if (!ref.startsWith('#/')) {
    return undefined;
  }

  return ref
    .slice(2)
    .split('/')
    .map((segment) => segment.replaceAll('~1', '/').replaceAll('~0', '~'))
    .reduce<any>((current, segment) => current?.[segment], spec);
}

function cloneSchema<T>(schema: T): T {
  return structuredClone(schema);
}

function isMergeableObjectSchema(schema: Record<string, any>): boolean {
  return Object.keys(schema).every((key) => MERGEABLE_OBJECT_SCHEMA_KEYS.has(key));
}

function mergeFlattenedObjectSchemas(
  leftSchema: Record<string, any>,
  rightSchema: Record<string, any>,
): Record<string, any> | undefined {
  const mergedSchema: Record<string, any> = {
    type: 'object',
    properties: cloneSchema(leftSchema.properties ?? {}),
  };

  const leftRequired = Array.isArray(leftSchema.required) ? leftSchema.required : [];
  const rightRequired = Array.isArray(rightSchema.required) ? rightSchema.required : [];
  const requiredFields = [...new Set([...leftRequired, ...rightRequired])];

  if (requiredFields.length > 0) {
    mergedSchema.required = requiredFields;
  }

  for (const key of [
    'additionalProperties',
    'default',
    'deprecated',
    'description',
    'example',
    'nullable',
    'readOnly',
    'title',
    'writeOnly',
    'x-categories',
  ] as const) {
    const leftValue = leftSchema[key];
    const rightValue = rightSchema[key];

    if (leftValue !== undefined && rightValue !== undefined && !isDeepStrictEqual(leftValue, rightValue)) {
      return undefined;
    }

    if (leftValue !== undefined || rightValue !== undefined) {
      mergedSchema[key] = cloneSchema(leftValue ?? rightValue);
    }
  }

  for (const [propertyName, propertySchema] of Object.entries(rightSchema.properties ?? {})) {
    const existingProperty = mergedSchema.properties[propertyName];

    if (existingProperty !== undefined && !isDeepStrictEqual(existingProperty, propertySchema)) {
      return undefined;
    }

    mergedSchema.properties[propertyName] = cloneSchema(propertySchema);
  }

  return mergedSchema;
}

function buildFlattenedObjectSchema(
  spec: Spec,
  schema: Record<string, any>,
  seenRefs = new Set<string>(),
): Record<string, any> | undefined {
  let resolvedSchema = schema;

  if (schema.$ref) {
    if (seenRefs.has(schema.$ref)) {
      return undefined;
    }

    const localSchema = resolveLocalRef<Record<string, any>>(spec, schema.$ref);

    if (!localSchema) {
      return undefined;
    }

    seenRefs.add(schema.$ref);
    resolvedSchema = localSchema;
  }

  if (!isMergeableObjectSchema(resolvedSchema)) {
    return undefined;
  }

  if (resolvedSchema.type && resolvedSchema.type !== 'object') {
    return undefined;
  }

  let mergedSchema: Record<string, any> = {
    type: 'object',
    properties: cloneSchema(resolvedSchema.properties ?? {}),
  };

  if (Array.isArray(resolvedSchema.required) && resolvedSchema.required.length > 0) {
    mergedSchema.required = cloneSchema(resolvedSchema.required);
  }

  for (const key of [
    'additionalProperties',
    'default',
    'deprecated',
    'description',
    'example',
    'nullable',
    'readOnly',
    'title',
    'writeOnly',
    'x-categories',
  ] as const) {
    if (resolvedSchema[key] !== undefined) {
      mergedSchema[key] = cloneSchema(resolvedSchema[key]);
    }
  }

  if (!Array.isArray(resolvedSchema.allOf)) {
    return mergedSchema;
  }

  for (const subSchema of resolvedSchema.allOf as Record<string, any>[]) {
    const flattenedSubSchema = buildFlattenedObjectSchema(spec, subSchema, new Set(seenRefs));

    if (!flattenedSubSchema) {
      return undefined;
    }

    const mergedSubSchema = mergeFlattenedObjectSchemas(mergedSchema, flattenedSubSchema);

    if (!mergedSubSchema) {
      return undefined;
    }

    mergedSchema = mergedSubSchema;
  }

  return mergedSchema;
}

function flattenSchemaAllOf(spec: Spec, schema: Record<string, any>): void {
  if (!Array.isArray(schema.allOf)) {
    return;
  }

  const flattenedSchema = buildFlattenedObjectSchema(spec, schema);

  if (!flattenedSchema) {
    return;
  }

  for (const key of Object.keys(schema)) {
    delete schema[key];
  }

  Object.assign(schema, flattenedSchema);
}

function sortSchemaProperties(spec: Spec, schema: Record<string, any> | undefined): void {
  if (!schema || typeof schema !== 'object') {
    return;
  }

  flattenSchemaAllOf(spec, schema);

  if (schema.properties && typeof schema.properties === 'object' && !Array.isArray(schema.properties)) {
    const requiredFields = new Set<string>(Array.isArray(schema.required) ? schema.required : []);
    const sortedPropertyEntries = Object.entries(schema.properties)
      .sort(([leftName], [rightName]) => {
        const leftRequired = requiredFields.has(leftName);
        const rightRequired = requiredFields.has(rightName);

        if (leftRequired !== rightRequired) {
          return leftRequired ? -1 : 1;
        }

        return leftName.localeCompare(rightName);
      })
      .map(([propertyName, propertySchema]) => {
        sortSchemaProperties(spec, propertySchema as Record<string, any>);
        return [propertyName, propertySchema];
      });

    schema.properties = Object.fromEntries(sortedPropertyEntries);
  }

  if (schema.items && typeof schema.items === 'object') {
    sortSchemaProperties(spec, schema.items);
  }

  if (schema.additionalProperties && typeof schema.additionalProperties === 'object') {
    sortSchemaProperties(spec, schema.additionalProperties);
  }

  for (const keyword of ['allOf', 'anyOf', 'oneOf'] as const) {
    if (Array.isArray(schema[keyword])) {
      (schema[keyword] as Record<string, any>[]).forEach((subSchema) => sortSchemaProperties(spec, subSchema));
    }
  }

  if (schema.not && typeof schema.not === 'object') {
    sortSchemaProperties(spec, schema.not);
  }
}

function getParameterSortKey(parameter: OpenAPIParameter, spec: Spec): { name: string; required: boolean } {
  if (parameter.$ref?.startsWith('#/components/parameters/')) {
    const parameterName = parameter.$ref.replace('#/components/parameters/', '');
    const referencedParameter = bundledParameter(spec, parameterName);

    return {
      name: referencedParameter?.name ?? parameterName,
      required: referencedParameter?.required ?? false,
    };
  }

  return {
    name: parameter.name ?? '',
    required: parameter.required ?? false,
  };
}

function bundledParameter(spec: Spec, parameterName: string): Record<string, any> | undefined {
  return spec.components.parameters?.[parameterName];
}

function sortRequestOrResponseSchemas(spec: Spec, content: Record<string, any> | undefined): void {
  if (!content || typeof content !== 'object') {
    return;
  }

  for (const mediaType of Object.values(content)) {
    if (mediaType?.schema && typeof mediaType.schema === 'object') {
      sortSchemaProperties(spec, mediaType.schema);
    }
  }
}

export function sortDocSpec(spec: Spec): void {
  for (const pathMethods of Object.values(spec.paths)) {
    for (const operation of Object.values(pathMethods)) {
      if (Array.isArray(operation.parameters)) {
        operation.parameters.sort((left: OpenAPIParameter, right: OpenAPIParameter) => {
          const leftKey = getParameterSortKey(left, spec);
          const rightKey = getParameterSortKey(right, spec);

          if (leftKey.required !== rightKey.required) {
            return leftKey.required ? -1 : 1;
          }

          return leftKey.name.localeCompare(rightKey.name);
        });
      }

      sortRequestOrResponseSchemas(spec, operation.requestBody?.content);

      if (operation.responses && typeof operation.responses === 'object') {
        for (const response of Object.values(operation.responses) as Array<Record<string, any>>) {
          sortRequestOrResponseSchemas(spec, response.content);
        }
      }
    }
  }

  for (const schema of Object.values(spec.components.schemas ?? {})) {
    sortSchemaProperties(spec, schema);
  }

  for (const response of Object.values(spec.components.responses ?? {})) {
    sortRequestOrResponseSchemas(spec, response?.content);
  }
}

export async function lintCommon(useCache: boolean): Promise<void> {
  const spinner = createSpinner('linting common spec');

  const cache = new Cache({
    folder: toAbsolutePath('specs/'),
    generatedFiles: [],
    dependencies: ['common'],
    cacheFile: toAbsolutePath('specs/dist/common.cache'),
  });

  if (useCache && (await cache.hit())) {
    spinner.succeed("job skipped, cache found for 'common' spec");
    return;
  }

  await run('yarn specs:lint specs/common');

  if (useCache) {
    spinner.text = 'storing common spec cache';
    await cache.store();
  }

  spinner.succeed();
}

export async function bundleSpecsForClient(bundledPath: string, clientName: string): Promise<void> {
  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;

  Object.values(bundledSpec.paths).forEach((pathMethods) => {
    Object.values(pathMethods).forEach((specMethod) => (specMethod.tags = [clientName]));
  });

  await fsp.writeFile(bundledPath, yaml.dump(bundledSpec, { noRefs: true }));
}

export async function bundleSpecsForDoc(bundledPath: string, clientName: string): Promise<void> {
  const bundledSpec = yaml.load(await fsp.readFile(bundledPath, 'utf8')) as Spec;
  const harRequests = await oas2har.oas2har(bundledSpec as any, { includeVendorExamples: true });
  const tagsDefinitions = bundledSpec.tags;
  const codeSamples = await transformGeneratedSnippetsToCodeSamples(clientName);

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, specMethod] of Object.entries(pathMethods)) {
      if (specMethod['x-helper']) {
        delete bundledSpec.paths[pathKey];
        break;
      }

      // Populate the x-codeSamples property with the snippets we retrieved in `transformSnippetsToCodeSamples`
      for (const gen of Object.values(GENERATORS)) {
        if (gen.client !== clientName) {
          continue;
        }

        if (!specMethod['x-codeSamples']) {
          specMethod['x-codeSamples'] = [];
        }

        // if a CTS test is marked with isCodeSample: true, it takes priority; otherwise fall back to the first snippet
        if (codeSamples[gen.language][specMethod.operationId]) {
          specMethod['x-codeSamples'].push({
            lang: gen.language,
            label: getCodeSampleLabel(gen.language),
            source:
              (Object.hasOwn(codeSamples[gen.language][specMethod.operationId], CODE_SAMPLE_KEY)
                ? codeSamples[gen.language][specMethod.operationId][CODE_SAMPLE_KEY]
                : undefined) || Object.values(codeSamples[gen.language][specMethod.operationId])[0],
          });
        }
      }

      // skip custom path for cURL
      if (pathKey !== '/{path}' && specMethod['x-codeSamples']) {
        const harRequest = harRequests.find((baseHarRequest) => {
          // the url also has the query parameters, so we need to check if it ends with the path
          // all the variables are also replaced by the example in the spec, so we need to check with a regex.
          const urlRegex = new RegExp(
            `${pathKey
              .replace('{indexName}', 'ALGOLIA_INDEX_NAME')
              .replace('*', '\\*')
              .replace(/\{.*?\}/g, '.*?')}($|\\?)`,
          );
          return (
            baseHarRequest.url.match(urlRegex) !== null && baseHarRequest.method.toLowerCase() === method.toLowerCase()
          );
        });
        if (!harRequest) {
          throw new Error(`Could not find a the correct HAR request for ${method} ${pathKey}`);
        }

        if (!harRequest?.headers) {
          break;
        }

        for (const harRequestHeader of harRequest.headers) {
          if (harRequestHeader.name === bundledSpec.components.securitySchemes.appId?.name) {
            harRequestHeader.value = 'ALGOLIA_APPLICATION_ID';
          }

          if (harRequestHeader.name === bundledSpec.components.securitySchemes.apiKey?.name) {
            harRequestHeader.value = 'ALGOLIA_API_KEY';
          }
        }

        const curlSnippet = new HTTPSnippet(harRequest as HarRequest).convert('shell', 'curl');

        specMethod['x-codeSamples'].push({
          lang: 'cURL',
          label: 'curl',
          source: curlSnippet ? curlSnippet[0] : '',
        });
      }

      if (!bundledSpec.paths[pathKey][method].tags) {
        continue;
      }

      // Checks that specified tags are well defined at root level
      for (const tag of bundledSpec.paths[pathKey][method].tags) {
        if (tag === clientName) {
          throw new Error(
            `Tag name "${tag}" must be different from client name ${clientName} in operation ${specMethod.operationId}`,
          );
        }

        const tagExists = tagsDefinitions ? tagsDefinitions.find((t) => t.name === tag) : null;
        if (!tagExists) {
          throw new Error(
            `Tag "${tag}" in "client[${clientName}] -> operation[${specMethod.operationId}]" is not defined`,
          );
        }
      }
    }
  }

  sortDocSpec(bundledSpec);

  await fsp.writeFile(toAbsolutePath(`docs/bundled/${clientName}.yml`), yaml.dump(bundledSpec, { noRefs: true }));
}
