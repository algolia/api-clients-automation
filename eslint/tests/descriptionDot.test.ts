import { RuleTester } from 'eslint';

import { descriptionDot } from '../src/rules/descriptionDot';

const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

ruleTester.run('description-dot', descriptionDot, {
  valid: [
    `
    simple:
      type: number
      description: a number.
    `,
    `
    single:
      can: have
      description: simple.
    ` /*
    `
    multi:
      description: >
        Multiline comment
        on description.
    `,*/,
    `
    multiStrip:
      description: >-
        Multiline comment
        on description.
    `,
  ],
  invalid: [
    {
      code: `
    simple:
      description: a number
    `,
      errors: [{ messageId: 'descriptionNoDot' }],
      output: `
    simple:
      description: a number.
    `,
    },
    {
      code: `
    single:
      description: simple
    `,
      errors: [{ messageId: 'descriptionNoDot' }],
      output: `
    single:
      description: simple.
    `,
    } /*
    {
      code: `
    multi:
      description: >
        Multiline comment
        on description
    `,
      errors: [{ messageId: 'descriptionNoDot' }],
      output: `
    multi:
      description: >
        Multiline comment
        on description.
    `,
    },*/,
  ],
});
