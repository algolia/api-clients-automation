import fsp from 'fs/promises';
import { isDeepStrictEqual } from 'node:util';

import oas2har from '@har-sdk/oas';
import type { HarRequest } from '@readme/httpsnippet';
import { HTTPSnippet } from '@readme/httpsnippet';
import { dump, load } from 'js-yaml';

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

type SpecMethod = Record<string, any> & {
  operationId: string;
  tags?: string[];
};

const MERGEABLE_OBJECT_SCHEMA_KEYS = new Set([
  '$ref',
  'additionalProperties',
  'allOf',
  'default',
  'deprecated',
  'description',
  'example',
  'examples',
  'nullable',
  'properties',
  'readOnly',
  'required',
  'title',
  'type',
  'writeOnly',
  'x-categories',
]);

function getEntryValue<T>(record: Record<string, T> | undefined, key: string): T | undefined {
  const entry = Object.entries(record ?? {}).find(([entryKey]) => entryKey === key);

  if (!entry) {
    return undefined;
  }

  const [, value] = entry;
  return value;
}

function setEntryValue<T>(record: Record<string, T>, key: string, value: T): Record<string, T> {
  const entriesWithoutKey = Object.entries(record).filter(([entryKey]) => entryKey !== key);

  return Object.fromEntries([...entriesWithoutKey, [key, value]]) as Record<string, T>;
}

function removeEntry<T>(record: Record<string, T>, key: string): Record<string, T> {
  return Object.fromEntries(Object.entries(record).filter(([entryKey]) => entryKey !== key)) as Record<string, T>;
}

function getSchemaCategories(schema: Record<string, any>): unknown {
  return getEntryValue(schema, 'x-categories');
}

function setSchemaCategories(schema: Record<string, any>, value: unknown): void {
  Object.assign(schema, { 'x-categories': value });
}

function hasHelperFlag(specMethod: SpecMethod): boolean {
  return getEntryValue(specMethod, 'x-helper') === true;
}

function getCodeSamples(specMethod: SpecMethod): Array<Record<string, any>> | undefined {
  const codeSamples = getEntryValue(specMethod, 'x-codeSamples');

  return Array.isArray(codeSamples) ? codeSamples : undefined;
}

function setCodeSamples(specMethod: SpecMethod, codeSamples: Array<Record<string, any>>): void {
  Object.assign(specMethod, { 'x-codeSamples': codeSamples });
}

function appendCodeSample(specMethod: SpecMethod, codeSample: Record<string, any>): void {
  const existingSamples = getCodeSamples(specMethod) ?? [];
  setCodeSamples(specMethod, [...existingSamples, codeSample]);
}

function getOperationSamples(
  codeSamples: Record<string, Record<string, string>>,
  operationId: string,
): Record<string, string> | undefined {
  return getEntryValue(codeSamples, operationId);
}

function getLanguageCodeSamples(
  codeSamples: Record<string, Record<string, Record<string, string>>>,
  language: string,
): Record<string, Record<string, string>> | undefined {
  return getEntryValue(codeSamples, language);
}

function getPreferredCodeSampleSource(operationSamples: Record<string, string>): string | undefined {
  const preferredSample = getEntryValue(operationSamples, CODE_SAMPLE_KEY);

  return preferredSample ?? Object.values(operationSamples)[0];
}

function resolveLocalRef<T>(spec: Spec, ref: string): T | undefined {
  if (!ref.startsWith('#/')) {
    return undefined;
  }

  let current: unknown = spec;

  for (const segment of ref
    .slice(2)
    .split('/')
    .map((part) => part.replaceAll('~1', '/').replaceAll('~0', '~'))) {
    if (!current || typeof current !== 'object' || Array.isArray(current)) {
      return undefined;
    }

    current = getEntryValue(current as Record<string, unknown>, segment);

    if (current === undefined) {
      return undefined;
    }
  }

  return current as T | undefined;
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

  const leftAdditionalProperties = leftSchema.additionalProperties;
  const rightAdditionalProperties = rightSchema.additionalProperties;

  if (
    leftAdditionalProperties !== undefined &&
    rightAdditionalProperties !== undefined &&
    !isDeepStrictEqual(leftAdditionalProperties, rightAdditionalProperties)
  ) {
    return undefined;
  }

  if (leftAdditionalProperties !== undefined || rightAdditionalProperties !== undefined) {
    mergedSchema.additionalProperties = cloneSchema(leftAdditionalProperties ?? rightAdditionalProperties);
  }

  const leftDefault = leftSchema.default;
  const rightDefault = rightSchema.default;

  if (leftDefault !== undefined && rightDefault !== undefined && !isDeepStrictEqual(leftDefault, rightDefault)) {
    return undefined;
  }

  if (leftDefault !== undefined || rightDefault !== undefined) {
    mergedSchema.default = cloneSchema(leftDefault ?? rightDefault);
  }

  const leftDeprecated = leftSchema.deprecated;
  const rightDeprecated = rightSchema.deprecated;

  if (
    leftDeprecated !== undefined &&
    rightDeprecated !== undefined &&
    !isDeepStrictEqual(leftDeprecated, rightDeprecated)
  ) {
    return undefined;
  }

  if (leftDeprecated !== undefined || rightDeprecated !== undefined) {
    mergedSchema.deprecated = cloneSchema(leftDeprecated ?? rightDeprecated);
  }

  const leftDescription = leftSchema.description;
  const rightDescription = rightSchema.description;

  if (
    leftDescription !== undefined &&
    rightDescription !== undefined &&
    !isDeepStrictEqual(leftDescription, rightDescription)
  ) {
    return undefined;
  }

  if (leftDescription !== undefined || rightDescription !== undefined) {
    mergedSchema.description = cloneSchema(leftDescription ?? rightDescription);
  }

  const leftExample = leftSchema.example;
  const rightExample = rightSchema.example;

  if (leftExample !== undefined && rightExample !== undefined && !isDeepStrictEqual(leftExample, rightExample)) {
    return undefined;
  }

  if (leftExample !== undefined || rightExample !== undefined) {
    mergedSchema.example = cloneSchema(leftExample ?? rightExample);
  }

  const leftExamples = leftSchema.examples;
  const rightExamples = rightSchema.examples;

  if (leftExamples !== undefined && rightExamples !== undefined && !isDeepStrictEqual(leftExamples, rightExamples)) {
    return undefined;
  }

  if (leftExamples !== undefined || rightExamples !== undefined) {
    mergedSchema.examples = cloneSchema(leftExamples ?? rightExamples);
  }

  const leftNullable = leftSchema.nullable;
  const rightNullable = rightSchema.nullable;

  if (leftNullable !== undefined && rightNullable !== undefined && !isDeepStrictEqual(leftNullable, rightNullable)) {
    return undefined;
  }

  if (leftNullable !== undefined || rightNullable !== undefined) {
    mergedSchema.nullable = cloneSchema(leftNullable ?? rightNullable);
  }

  const leftReadOnly = leftSchema.readOnly;
  const rightReadOnly = rightSchema.readOnly;

  if (leftReadOnly !== undefined && rightReadOnly !== undefined && !isDeepStrictEqual(leftReadOnly, rightReadOnly)) {
    return undefined;
  }

  if (leftReadOnly !== undefined || rightReadOnly !== undefined) {
    mergedSchema.readOnly = cloneSchema(leftReadOnly ?? rightReadOnly);
  }

  const leftTitle = leftSchema.title;
  const rightTitle = rightSchema.title;

  if (leftTitle !== undefined && rightTitle !== undefined && !isDeepStrictEqual(leftTitle, rightTitle)) {
    return undefined;
  }

  if (leftTitle !== undefined || rightTitle !== undefined) {
    mergedSchema.title = cloneSchema(leftTitle ?? rightTitle);
  }

  const leftWriteOnly = leftSchema.writeOnly;
  const rightWriteOnly = rightSchema.writeOnly;

  if (
    leftWriteOnly !== undefined &&
    rightWriteOnly !== undefined &&
    !isDeepStrictEqual(leftWriteOnly, rightWriteOnly)
  ) {
    return undefined;
  }

  if (leftWriteOnly !== undefined || rightWriteOnly !== undefined) {
    mergedSchema.writeOnly = cloneSchema(leftWriteOnly ?? rightWriteOnly);
  }

  const leftCategories = getSchemaCategories(leftSchema);
  const rightCategories = getSchemaCategories(rightSchema);

  if (
    leftCategories !== undefined &&
    rightCategories !== undefined &&
    !isDeepStrictEqual(leftCategories, rightCategories)
  ) {
    return undefined;
  }

  if (leftCategories !== undefined || rightCategories !== undefined) {
    setSchemaCategories(mergedSchema, cloneSchema(leftCategories ?? rightCategories));
  }

  for (const [propertyName, propertySchema] of Object.entries(rightSchema.properties ?? {})) {
    const existingProperty = getEntryValue(mergedSchema.properties, propertyName);

    if (existingProperty !== undefined && !isDeepStrictEqual(existingProperty, propertySchema)) {
      return undefined;
    }

    mergedSchema.properties = setEntryValue(mergedSchema.properties, propertyName, cloneSchema(propertySchema));
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

  if (resolvedSchema.additionalProperties !== undefined) {
    mergedSchema.additionalProperties = cloneSchema(resolvedSchema.additionalProperties);
  }

  if (resolvedSchema.default !== undefined) {
    mergedSchema.default = cloneSchema(resolvedSchema.default);
  }

  if (resolvedSchema.deprecated !== undefined) {
    mergedSchema.deprecated = cloneSchema(resolvedSchema.deprecated);
  }

  if (resolvedSchema.description !== undefined) {
    mergedSchema.description = cloneSchema(resolvedSchema.description);
  }

  if (resolvedSchema.example !== undefined) {
    mergedSchema.example = cloneSchema(resolvedSchema.example);
  }

  if (resolvedSchema.examples !== undefined) {
    mergedSchema.examples = cloneSchema(resolvedSchema.examples);
  }

  if (resolvedSchema.nullable !== undefined) {
    mergedSchema.nullable = cloneSchema(resolvedSchema.nullable);
  }

  if (resolvedSchema.readOnly !== undefined) {
    mergedSchema.readOnly = cloneSchema(resolvedSchema.readOnly);
  }

  if (resolvedSchema.title !== undefined) {
    mergedSchema.title = cloneSchema(resolvedSchema.title);
  }

  if (resolvedSchema.writeOnly !== undefined) {
    mergedSchema.writeOnly = cloneSchema(resolvedSchema.writeOnly);
  }

  const resolvedSchemaCategories = getSchemaCategories(resolvedSchema);

  if (resolvedSchemaCategories !== undefined) {
    setSchemaCategories(mergedSchema, cloneSchema(resolvedSchemaCategories));
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
    Reflect.deleteProperty(schema, key);
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

  if (Array.isArray(schema.allOf)) {
    schema.allOf.forEach((subSchema: Record<string, any>) => sortSchemaProperties(spec, subSchema));
  }

  if (Array.isArray(schema.anyOf)) {
    schema.anyOf.forEach((subSchema: Record<string, any>) => sortSchemaProperties(spec, subSchema));
  }

  if (Array.isArray(schema.oneOf)) {
    schema.oneOf.forEach((subSchema: Record<string, any>) => sortSchemaProperties(spec, subSchema));
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
  return getEntryValue(spec.components.parameters, parameterName);
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
  const bundledSpec = load(await fsp.readFile(bundledPath, 'utf8')) as Spec;

  Object.values(bundledSpec.paths).forEach((pathMethods) => {
    Object.values(pathMethods).forEach((specMethod) => (specMethod.tags = [clientName]));
  });

  await fsp.writeFile(bundledPath, dump(bundledSpec, { noRefs: true }));
}

export async function bundleSpecsForDoc(bundledPath: string, clientName: string): Promise<void> {
  const bundledSpec = load(await fsp.readFile(bundledPath, 'utf8')) as Spec;
  const harRequests = await oas2har.oas2har(bundledSpec as any, { includeVendorExamples: true });
  const tagsDefinitions = bundledSpec.tags;
  const codeSamples = await transformGeneratedSnippetsToCodeSamples(clientName);

  for (const [pathKey, pathMethods] of Object.entries(bundledSpec.paths)) {
    for (const [method, rawSpecMethod] of Object.entries(pathMethods)) {
      const specMethod = rawSpecMethod as SpecMethod;

      if (hasHelperFlag(specMethod)) {
        bundledSpec.paths = removeEntry(bundledSpec.paths, pathKey) as Spec['paths'];
        break;
      }

      // Populate the x-codeSamples property with the snippets we retrieved in `transformSnippetsToCodeSamples`
      for (const gen of Object.values(GENERATORS)) {
        if (gen.client !== clientName) {
          continue;
        }

        if (!getCodeSamples(specMethod)) {
          setCodeSamples(specMethod, []);
        }

        // if a CTS test is marked with isCodeSample: true, it takes priority; otherwise fall back to the first snippet
        const languageCodeSamples = getLanguageCodeSamples(codeSamples, gen.language);
        const operationSamples = languageCodeSamples
          ? getOperationSamples(languageCodeSamples, specMethod.operationId)
          : undefined;

        if (operationSamples) {
          appendCodeSample(specMethod, {
            lang: gen.language,
            label: getCodeSampleLabel(gen.language),
            source: getPreferredCodeSampleSource(operationSamples),
          });
        }
      }

      // skip custom path for cURL
      if (pathKey !== '/{path}' && getCodeSamples(specMethod)) {
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

        appendCodeSample(specMethod, {
          lang: 'cURL',
          label: 'curl',
          source: curlSnippet ? curlSnippet[0] : '',
        });
      }

      if (!specMethod.tags) {
        continue;
      }

      // Checks that specified tags are well defined at root level
      for (const tag of specMethod.tags) {
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

  await fsp.writeFile(toAbsolutePath(`docs/bundled/${clientName}.yml`), dump(bundledSpec, { noRefs: true }));
}
