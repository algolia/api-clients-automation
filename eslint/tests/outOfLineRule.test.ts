import { RuleTester } from 'eslint';

import { createOutOfLineRule } from '../src/rules/outOfLineRule';

const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

// this test is enough for oneOf, allOf, anyOf, as they use the same rule.
ruleTester.run('out-of-line-enum', createOutOfLineRule({ property: 'enum' }), {
  valid: [
    `
simple:
  type: string
  enum: [bla, blabla]
`,
    `
simple:
  type: string
  enum:
    - bla
    - blabla
`,
    `
simple:
  type: string
  enum: [bla, blabla]

useIt:
  $ref: '#/simple'
`,
    `
servers:
  - url: http://test-server.com
    variables:
      region:
        default: us
        enum:
          - us
          - de
`,
  ],
  invalid: [
    {
      code: `
root:
  inside:
    type: string
    enum: [bla, blabla]
`,
      errors: [{ messageId: 'enumNotOutOfLine' }],
    },
    {
      code: `
root:
  inside:
    deeper:
      type: string
      enum: [bla, blabla]

useIt:
  $ref: '#/root/inside/deeper'
`,
      errors: [{ messageId: 'enumNotOutOfLine' }],
    },
  ],
});

// oneOf should allow `type: 'null'`
ruleTester.run('out-of-line-oneOf-null', createOutOfLineRule({ property: 'oneOf' }), {
  valid: [
    `
simple:
  oneOf:
    - type: string
    - type: 'null'
`,
    `
obj:
  type: object
  properties:
    name:
      oneOf:
        - type: string
        - type: 'null'
`,
  ],
  invalid: [
    {
      code: `
simple:
  type: object
  properties:
    name:
      oneOf:
        - type: string
        - type: null
      `,
      errors: [{ messageId: 'oneOfNotOutOfLine' }],
    },
  ],
});

// allow enum to be nullable
ruleTester.run('out-of-line-enum-null', createOutOfLineRule({ property: 'enum' }), {
  valid: [
    `
simple:
  oneOf:
    - type: string
      enum: [bla, blabla]
    - type: 'null'
`,
  ],
  invalid: [],
});
