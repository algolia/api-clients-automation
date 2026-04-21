import { describe, expect, it } from 'vitest';

import type { Spec } from '../../types.ts';
import { sortDocSpec } from '../format.ts';

describe('sortDocSpec', () => {
  it('sorts parameters and schema properties for docs output', () => {
    const spec = {
      servers: [],
      tags: [],
      paths: {
        '/test': {
          post: {
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
              content: {
                'application/json': {
                  schema: {
                    type: 'object',
                    required: ['delta', 'beta'],
                    properties: {
                      zeta: { type: 'string' },
                      beta: { type: 'string' },
                      alpha: { type: 'string' },
                      delta: {
                        type: 'object',
                        required: ['omega'],
                        properties: {
                          zulu: { type: 'string' },
                          omega: { type: 'string' },
                          alpha: { type: 'string' },
                        },
                      },
                    },
                  },
                },
              },
            },
            responses: {
              '200': {
                content: {
                  'application/json': {
                    schema: {
                      type: 'object',
                      required: ['result'],
                      properties: {
                        zeta: { type: 'string' },
                        alpha: { type: 'string' },
                        result: { type: 'string' },
                      },
                    },
                  },
                },
              },
            },
          },
        },
      },
      components: {
        schemas: {
          AllOfRequiredSchema: {
            type: 'object',
            required: ['beta'],
            properties: {
              zeta: { type: 'string' },
              beta: { type: 'string' },
            },
          },
          AllOfOptionalSchema: {
            type: 'object',
            properties: {
              alpha: { type: 'string' },
              theta: { type: 'string' },
            },
          },
          AllOfSortedSchema: {
            allOf: [
              {
                type: 'object',
                properties: {
                  gamma: { type: 'string' },
                },
              },
              { $ref: '#/components/schemas/AllOfOptionalSchema' },
              { $ref: '#/components/schemas/AllOfRequiredSchema' },
            ],
          },
          ConflictingAllOfSchema: {
            allOf: [
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
            ],
          },
          TestSchema: {
            type: 'object',
            required: ['name'],
            properties: {
              zeta: { type: 'string' },
              age: { type: 'integer' },
              name: { type: 'string' },
            },
          },
        },
        parameters: {
          alpha: { name: 'alpha', in: 'query' },
          beta: { name: 'beta', in: 'query', required: true },
        },
        responses: {
          Shared: {
            content: {
              'application/json': {
                schema: {
                  type: 'object',
                  required: ['status'],
                  properties: {
                    zeta: { type: 'string' },
                    alpha: { type: 'string' },
                    status: { type: 'string' },
                  },
                },
              },
            },
          },
        },
        securitySchemes: {},
      },
    } as unknown as Spec;

    sortDocSpec(spec);

    expect(spec.paths['/test'].post.parameters.map((parameter) => parameter.$ref ?? parameter.name)).toEqual([
      '#/components/parameters/beta',
      'gamma',
      '#/components/parameters/alpha',
      'zeta',
    ]);

    expect(Object.keys(spec.paths['/test'].post.requestBody.content['application/json'].schema.properties)).toEqual([
      'beta',
      'delta',
      'alpha',
      'zeta',
    ]);
    expect(
      Object.keys(spec.paths['/test'].post.requestBody.content['application/json'].schema.properties.delta.properties),
    ).toEqual(['omega', 'alpha', 'zulu']);
    expect(
      Object.keys(spec.paths['/test'].post.responses['200'].content['application/json'].schema.properties),
    ).toEqual(['result', 'alpha', 'zeta']);
    expect(Object.keys(spec.components.schemas.TestSchema.properties)).toEqual(['name', 'age', 'zeta']);
    expect(spec.components.schemas.AllOfSortedSchema.allOf).toBeUndefined();
    expect(Object.keys(spec.components.schemas.AllOfSortedSchema.properties)).toEqual([
      'beta',
      'alpha',
      'gamma',
      'theta',
      'zeta',
    ]);
    expect(spec.components.schemas.AllOfSortedSchema.required).toEqual(['beta']);
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
    expect(Object.keys(spec.components.responses!.Shared.content['application/json'].schema.properties)).toEqual([
      'status',
      'alpha',
      'zeta',
    ]);
  });
});
