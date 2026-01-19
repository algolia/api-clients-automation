import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { hasType } from '../src/rules/hasType.js';

runClassic(
  'has-type',
  hasType,
  {
    valid: [
      `
simple:
  type: object
  properties:
    prop1:
    `,
      `
withArray:
  type: array
  items:
    type: string
  `,
    ],
    invalid: [
      {
        code: `
simple:
  properties:
    noType:
      type: string
    `,
        errors: [{ messageId: 'hasType' }],
      },
      {
        code: `
wrongType:
  type: string
  properties:
    noType:
      type: string
    `,
        errors: [{ messageId: 'hasType' }],
      },
      {
        code: `
array:
  items:
    type: string
    `,
        errors: [{ messageId: 'hasType' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
