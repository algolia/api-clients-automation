import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { singleQuoteRef } from '../src/rules/singleQuoteRef.js';

runClassic(
  'single-quote-ref',
  singleQuoteRef,
  {
    valid: [
      `
simple:
  $ref: 'random/path.yml'`,
      `
sameFile:
  $ref: '#/inside'`,
      `
long:
  $ref: 'some/random/file.yml#/root/object/prop'
`,
      `
post:
  description: test desc.
  '400':
    $ref: '../../common/responses/BadRequest.yml'
`,
    ],
    invalid: [
      {
        code: `
simple:
  $ref: random/path.yml
`,
        errors: [{ messageId: 'refNoQuote' }],
        output: `
simple:
  $ref: 'random/path.yml'
`,
      },
      {
        code: `
long:
  $ref: some/random/file.yml#/root/object/prop
`,
        errors: [{ messageId: 'refNoQuote' }],
        output: `
long:
  $ref: 'some/random/file.yml#/root/object/prop'
`,
      },
      {
        code: `
post:
  description: test desc.
  '400':
    $ref: ../../common/responses/BadRequest.yml
  '404':
    $ref: ../../common/responses/IndexNotFound.yml
`,
        errors: [{ messageId: 'refNoQuote' }, { messageId: 'refNoQuote' }],
        output: `
post:
  description: test desc.
  '400':
    $ref: '../../common/responses/BadRequest.yml'
  '404':
    $ref: '../../common/responses/IndexNotFound.yml'
`,
      },
      {
        code: `
double:
  $ref: "some/ref"
`,
        errors: [{ messageId: 'refNoQuote' }],
        output: `
double:
  $ref: 'some/ref'
`,
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
