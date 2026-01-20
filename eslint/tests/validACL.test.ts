import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

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
       filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
post:
  operationId: test
  description: Test endpoint without ACL
`,
        errors: [{ messageId: 'missingACL' }],
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
x-acl:
  - notACL
  - search
    `,
        errors: [{ messageId: 'validACL' }],
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
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
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
x-acl: notList
    `,
        errors: [{ messageId: 'validArray' }],
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
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
