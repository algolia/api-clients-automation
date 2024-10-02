import { runClassic } from 'eslint-vitest-rule-tester';

import { parseForESLint } from '../src/index.js';
import { noNewLine } from '../src/rules/noNewLine.js';

runClassic(
  'no-new-line',
  noNewLine,
  {
    valid: [
      `a simple file
with multiples lines.`,
      'single line.',
      '',
    ],
    invalid: [
      {
        code: `simple file with
multiple lines
`,
        errors: [{ messageId: 'noNewLine' }],
        output: `simple file with
multiple lines`,
      },
      {
        code: `single line
    `,
        errors: [{ messageId: 'noNewLine' }],
        output: 'single line',
      },
      {
        code: `multiple new lines


      `,
        errors: [{ messageId: 'noNewLine' }],
        output: 'multiple new lines',
      },
    ],
  },
  {
    parser: { parseForESLint },
  },
);
