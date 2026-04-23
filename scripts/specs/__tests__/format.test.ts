import { describe, expect, it } from 'vitest';

import type { Spec } from '../../types.ts';
import { sortDocSpec } from '../format.ts';

function createStringSchema(): Record<string, string> {
  return { type: 'string' };
}

function createIntegerSchema(): Record<string, string> {
  return { type: 'integer' };
}

function createObjectSchema(properties: Record<string, Record<string, any>>, required?: string[]): Record<string, any> {
  return {
    type: 'object',
    ...(required ? { required } : {}),
    properties,
  };
}

function createJsonContent(schema: Record<string, any>): Record<string, any> {
  return {
    'application/json': {
      schema,
    },
  };
}

function createOperationSchemas(): {
  requestSchema: Record<string, any>;
  responseSchema: Record<string, any>;
} {
  return {
    requestSchema: createObjectSchema(
      {
        zeta: createStringSchema(),
        beta: createStringSchema(),
        alpha: createStringSchema(),
        delta: createObjectSchema(
          {
            zulu: createStringSchema(),
            omega: createStringSchema(),
            alpha: createStringSchema(),
          },
          ['omega'],
        ),
      },
      ['delta', 'beta'],
    ),
    responseSchema: createObjectSchema(
      {
        zeta: createStringSchema(),
        alpha: createStringSchema(),
        result: createStringSchema(),
      },
      ['result'],
    ),
  };
}

function createComponentSchemas(): Record<string, any> {
  return {
    AllOfRequiredSchema: createObjectSchema(
      {
        zeta: createStringSchema(),
        beta: createStringSchema(),
      },
      ['beta'],
    ),
    AllOfOptionalSchema: createObjectSchema({
      alpha: createStringSchema(),
      theta: createStringSchema(),
    }),
    AllOfSortedSchema: {
      allOf: [
        createObjectSchema({
          gamma: createStringSchema(),
        }),
        { $ref: '#/components/schemas/AllOfOptionalSchema' },
        { $ref: '#/components/schemas/AllOfRequiredSchema' },
      ],
    },
    ConflictingAllOfSchema: {
      allOf: [
        createObjectSchema({
          zebra: createStringSchema(),
        }),
        createObjectSchema({
          zebra: createIntegerSchema(),
        }),
      ],
    },
    TestSchema: createObjectSchema(
      {
        zeta: createStringSchema(),
        age: createIntegerSchema(),
        name: createStringSchema(),
      },
      ['name'],
    ),
  };
}

function createTestOperation(): Record<string, any> {
  const { requestSchema, responseSchema } = createOperationSchemas();

  return {
    operationId: 'testOperation',
    summary: 'Test operation',
    'x-codeSamples': [],
    parameters: [
      { name: 'zeta', in: 'query' },
      { $ref: '#/components/parameters/beta' },
      { $ref: '#/components/parameters/alpha' },
      { name: 'gamma', in: 'query', required: true },
    ],
    requestBody: {
      content: createJsonContent(requestSchema),
    },
    responses: {
      '200': {
        content: createJsonContent(responseSchema),
      },
    },
  };
}

function createSharedResponse(): Record<string, any> {
  return {
    content: createJsonContent(
      createObjectSchema(
        {
          zeta: createStringSchema(),
          alpha: createStringSchema(),
          status: createStringSchema(),
        },
        ['status'],
      ),
    ),
  };
}

function createComponents(): Spec['components'] {
  return {
    schemas: createComponentSchemas(),
    parameters: {
      alpha: { name: 'alpha', in: 'query' },
      beta: { name: 'beta', in: 'query', required: true },
    },
    responses: {
      Shared: createSharedResponse(),
    },
    securitySchemes: {},
  };
}

function createSpec(): Spec {
  return {
    servers: [],
    tags: [],
    paths: {
      '/test': {
        post: createTestOperation(),
      },
    },
    components: createComponents(),
  } as unknown as Spec;
}

function sortSpec(): Spec {
  const spec = createSpec();
  sortDocSpec(spec);
  return spec;
}

function getTestOperation(spec: Spec): Record<string, any> {
  return spec.paths['/test'].post;
}

function getJsonRequestSchema(spec: Spec): Record<string, any> {
  return getTestOperation(spec).requestBody.content['application/json'].schema;
}

function getJsonResponseSchema(spec: Spec): Record<string, any> {
  return getTestOperation(spec).responses['200'].content['application/json'].schema;
}

function getSharedResponseSchema(spec: Spec): Record<string, any> {
  return spec.components.responses!.Shared.content['application/json'].schema;
}

describe('sortDocSpec', () => {
  it('sorts operation parameters', () => {
    const spec = sortSpec();
    const operation = getTestOperation(spec);

    expect(operation.parameters.map((parameter: Record<string, any>) => parameter.$ref ?? parameter.name)).toEqual([
      '#/components/parameters/beta',
      'gamma',
      '#/components/parameters/alpha',
      'zeta',
    ]);
  });

  it('sorts request body properties with required fields first', () => {
    const spec = sortSpec();
    const requestSchema = getJsonRequestSchema(spec);

    expect(Object.keys(requestSchema.properties)).toEqual(['beta', 'delta', 'alpha', 'zeta']);
  });

  it('sorts nested object properties', () => {
    const spec = sortSpec();
    const requestSchema = getJsonRequestSchema(spec);

    expect(Object.keys(requestSchema.properties.delta.properties)).toEqual(['omega', 'alpha', 'zulu']);
  });

  it('sorts response schema properties', () => {
    const spec = sortSpec();
    const responseSchema = getJsonResponseSchema(spec);

    expect(Object.keys(responseSchema.properties)).toEqual(['result', 'alpha', 'zeta']);
  });

  it('sorts component schema properties', () => {
    const spec = sortSpec();

    expect(Object.keys(spec.components.schemas.TestSchema.properties)).toEqual(['name', 'age', 'zeta']);
  });

  it('flattens and sorts mergeable allOf schemas', () => {
    const spec = sortSpec();
    const schema = spec.components.schemas.AllOfSortedSchema;

    expect(schema.allOf).toBeUndefined();
    expect(Object.keys(schema.properties)).toEqual(['beta', 'alpha', 'gamma', 'theta', 'zeta']);
    expect(schema.required).toEqual(['beta']);
  });

  it('preserves conflicting allOf schemas', () => {
    const spec = sortSpec();

    expect(spec.components.schemas.ConflictingAllOfSchema.allOf).toEqual([
      {
        type: 'object',
        properties: {
          zebra: { type: 'string' },
        },
      },
      {
        type: 'object',
        properties: {
          zebra: { type: 'integer' },
        },
      },
    ]);
  });

  it('sorts shared response schemas', () => {
    const spec = sortSpec();
    const sharedResponseSchema = getSharedResponseSchema(spec);

    expect(Object.keys(sharedResponseSchema.properties)).toEqual(['status', 'alpha', 'zeta']);
  });
});
