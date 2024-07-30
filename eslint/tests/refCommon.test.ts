import { RuleTester } from 'eslint';

import { refCommon } from '../src/rules/refCommon';

const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

ruleTester.run('ref-common', refCommon, {
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
});
