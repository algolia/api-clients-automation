import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { validInlineTitle } from '../src/rules/validInlineTitle.js';

runClassic(
  'valid-inline-title',
  validInlineTitle,
  {
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
        errors: [{ messageId: 'inlineTitleExists' }],
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
        errors: [{ messageId: 'firstProperty' }],
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
        errors: [{ messageId: 'lowercaseTitle' }],
      },
      {
        code: `
currencies:
  title: spaces are fine
  type: object
  properties:
    inner:
      title: spaces are not fine
      type: object
  `,
        errors: [{ messageId: 'noSpaceInTitle' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
