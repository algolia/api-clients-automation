import { RuleTester } from 'eslint';

import { noFinalDot } from '../src/rules/noFinalDot';

const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

ruleTester.run('no-final-dot', noFinalDot, {
  valid: [`summary: Valid summary`],
  invalid: [
    {
      code: `summary: Has final dot.`,
      errors: [{ messageId: 'noFinalDot' }],
      output: `summary: Has final dot`,
    },
    {
      code: `summary: With dot and newline.

      `,
      errors: [{ messageId: 'noFinalDot' }],
      output: `summary: With dot and newline

      `,
    },
  ],
});
