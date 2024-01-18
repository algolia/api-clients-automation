import { RuleTester } from 'eslint';

import { noNewLine } from '../src/rules/noNewLine';

const ruleTester = new RuleTester({
  parser: require.resolve('eslint-plugin-automation-custom'),
});

ruleTester.run('no-new-line', noNewLine, {
  valid: [
    `a simple file
with multiples lines.`,
    `single line.`,
    ``,
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
      output: `single line`,
    },
    {
      code: `multiple new lines


      `,
      errors: [{ messageId: 'noNewLine' }],
      output: `multiple new lines`,
    }
  ],
});
