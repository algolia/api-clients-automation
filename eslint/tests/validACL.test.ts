import { runClassic } from 'eslint-vitest-rule-tester';
import yamlParser from 'yaml-eslint-parser';

import { validACL } from '../src/rules/validACL.js';

runClassic(
  'valid-acl',
  validACL,
  {
    valid: [
      `
x-acl:
  - search
  - browse
    `,
      `
x-acl:
  - admin
    `,
      `
x-acl: ['search', 'settings']
    `,
      `
nested:
  inside:
    x-acl:
      - search
      - recommendation
    `,
    ],
    invalid: [
      {
        code: `
post:
  operationId: test
  description: Test endpoint without ACL
`,
        errors: [{ messageId: 'missingACL' }],
      },
      {
        code: `
x-acl:
  - notACL
  - search
    `,
        errors: [{ messageId: 'validACL' }],
      },
      {
        code: `
nested:
  inside:
    x-acl:
      - search
      - notACL
    `,
        errors: [{ messageId: 'validACL' }],
      },
      {
        code: `
x-acl: notList
    `,
        errors: [{ messageId: 'validArray' }],
      },
      {
        code: `
x-acl:
  - ['search']
  - 88
    `,
        errors: [{ messageId: 'validString' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
