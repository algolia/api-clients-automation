import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { noFinalDot } from '../src/rules/noFinalDot.js';

runClassic(
  'no-final-dot',
  noFinalDot,
  {
    valid: ['summary: Valid summary'],
    invalid: [
      {
        code: 'summary: Has final dot.',
        errors: [{ messageId: 'noFinalDot' }],
        output: 'summary: Has final dot',
      },
      {
        code: `summary: With dot and newline.

      `,
        errors: [{ messageId: 'noFinalDot' }],
        output: `summary: With dot and newline

      `,
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
