import { runClassic } from 'eslint-vitest-rule-tester';
import yamlParser from 'yaml-eslint-parser';

import { endWithDot } from '../src/rules/endWithDot.js';

runClassic(
  'end-with-dot',
  endWithDot,
  {
    valid: [
      `
simple:
  type: number
  description: a number.
    `,
      `
multi:
  description: >
    Creates a new A/B test with provided configuration.

    You can set an A/B test on two different indices with different settings, or on the same index with different search parameters by providing a customSearchParameters setting on one of the variants.
    `,
      `
multiStrip:
  description: >-
    Multiline comment
    on description.
    `,
      `
responses:
  '200':
    description: OK
    `,
    ],
    invalid: [
      {
        code: `
simple:
  description: a number
    `,
        errors: [{ messageId: 'endWithDot' }],
        output: `
simple:
  description: a number.
    `,
      },
      {
        code: `
multi:
  description: >
    Multiline comment
    on description
    `,
        errors: [{ messageId: 'endWithDot' }],
        output: `
multi:
  description: >
    Multiline comment
    on description.
    `,
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
