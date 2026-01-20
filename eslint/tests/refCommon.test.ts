import { runClassic } from 'eslint-vitest-rule-tester';
import * as yamlParser from "yaml-eslint-parser"

import { refCommon } from '../src/rules/refCommon.js';

runClassic(
  'ref-common',
  refCommon,
  {
    valid: [
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
local:
  $ref: '#/components/schemas/Example'
    `,
      },
      {
        filename: 'renamedRepo/specs/search/path/test.yml',
        code: `
local:
$ref: '#/components/schemas/Example'
  `,
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
sameFolder:
    $ref: './schemas/Example'
    `,
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
external:
    $ref: '../../common/schemas/Example'
    `,
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
  external:
      $ref: '../../../search/schemas/Example'
      `,
      },
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
nested:
  type: object
  properties:
    nested:
      $ref: '#/components/schemas/Example'
    `,
      },
    ],
    invalid: [
      {
        filename: 'api-client-automation/specs/search/path/test.yml',
        code: `
out:
  $ref: '../../recommend/schemas/Example'
    `,
        errors: [{ messageId: 'refCommon' }],
      },
    ],
  },
  {
    parser: yamlParser,
  },
);
