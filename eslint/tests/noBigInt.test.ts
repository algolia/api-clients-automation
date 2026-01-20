import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"
import { noBigInt } from '../src/rules/noBigInt.js';

runClassic(
  'no-big-int',
  noBigInt,
  {
    valid: [
      `
type: object
properties:
  id:
    type: number
    format: float
  url:
    type: string
    format: uri
`,
      `
prop:
  type: integer
  format: int32
`,
    ],
    invalid: [
      {
        code: `
type: object
properties:
  id:
    type: number
    format: int64
  url:
    type: string
    format: uri
`,
        errors: [{ messageId: 'noBigInt' }],
      },
      {
        code: `
prop:
  type: number
  format: int32
`,
        errors: [{ messageId: 'noBigInt' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
