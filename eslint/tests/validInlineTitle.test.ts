import { RuleTester } from 'eslint';

import { validInlineTitle } from '../src/rules/validInlineTitle';

const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

ruleTester.run('valid-inline-title', validInlineTitle, {
  valid: [
    `
currencies:
  type: object
  properties:
    inner:
      type: object
  `,
    `
currencies:
  type: object
  properties:
    inner:
      title: currency
      type: object
      properties:
        currency:
          type: string
          title: Currency
  `,
    `
dictionaryLanguage:
  oneOf:
    - type: object
      properties:
        prop:
          type: integer
    - type: 'null'
    `,
  ],
  invalid: [
    {
      code: `
currencies:
  type: object
  properties:
    inner:
      type: object
      properties:
        currency:
          type: string
          title: Currency
  `,
      errors: [{ messageId: 'validInlineTitle' }],
    },
    {
      code: `
currencies:
  type: object
  properties:
    inner:
      type: object
      title: currency
      properties:
        currency:
          type: string
          title: Currency
  `,
      errors: [{ messageId: 'validInlineTitle' }],
    },
    {
      code: `
currencies:
  title: UpperCaseFine
  type: object
  properties:
    inner:
      title: UpperCaseNotFine
      type: object
  `,
      errors: [{ messageId: 'validInlineTitle' }],
    },
  ],
});
