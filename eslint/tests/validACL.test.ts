import { RuleTester } from 'eslint';
import { validACL } from '../src/rules/validACL';


const ruleTester = new RuleTester({
  parser: require.resolve('yaml-eslint-parser'),
});

ruleTester.run('valid-acl', validACL, {
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
});
