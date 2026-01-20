import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { createOutOfLineRule } from '../src/rules/outOfLineRule.js';

// this test is enough for oneOf, allOf, anyOf, as they use the same rule.
runClassic(
  'out-of-line-enum',
  createOutOfLineRule({ property: 'enum' }),
  {
    valid: [
      `
simple:
  type: string
  enum: [bla, blabla]
`,
      `
simple:
  type: string
  enum:
    - bla
    - blabla
`,
      `
simple:
  type: string
  enum: [bla, blabla]

useIt:
  $ref: '#/simple'
`,
      `
servers:
  - url: http://test-server.com
    variables:
      region:
        default: us
        enum:
          - us
          - de
`,
    ],
    invalid: [
      {
        code: `
root:
  inside:
    type: string
    enum: [bla, blabla]
`,
        errors: [{ messageId: 'enumNotOutOfLine' }],
      },
      {
        code: `
root:
  inside:
    deeper:
      type: string
      enum: [bla, blabla]

useIt:
  $ref: '#/root/inside/deeper'
`,
        errors: [{ messageId: 'enumNotOutOfLine' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);

// oneOf should allow `type: 'null'`
runClassic(
  'out-of-line-oneOf-null',
  createOutOfLineRule({ property: 'oneOf' }),
  {
    valid: [
      `
simple:
  oneOf:
    - type: string
    - type: 'null'
`,
      `
obj:
  type: object
  properties:
    name:
      oneOf:
        - type: string
        - type: 'null'
`,
    ],
    invalid: [
      {
        code: `
simple:
  type: object
  properties:
    name:
      oneOf:
        - type: string
        - type: null
      `,
        errors: [{ messageId: 'oneOfNotOutOfLine' }],
      },
      {
        code: `
simple:
  type: object
  properties:
    name:
      oneOf:
        - type: string
          description: bla bla bla
        - type: 'null'
          description: bla bla bla
      `,
        errors: [{ messageId: 'nullDescription' }],
      },
      {
        code: `
root:
  oneOf:
    oneOf:
      - type: string
        description: bla bla bla
      - type: 'null'
        description: bla bla bla
      `,
        errors: [{ messageId: 'nullDescription' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);

// allow enum to be nullable
runClassic(
  'out-of-line-enum-null',
  createOutOfLineRule({ property: 'enum' }),
  {
    valid: [
      `
simple:
  oneOf:
    - type: string
      enum: [bla, blabla]
    - type: 'null'
`,
    ],
    invalid: [],
  },
  {
    parser: yamlParser,
  },
);
