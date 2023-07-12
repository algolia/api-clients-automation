// eslint-disable-next-line import/no-commonjs
module.exports = {
  extends: [
    'algolia',
    'algolia/typescript',
    'plugin:import/errors',
    'plugin:import/warnings',
    'plugin:import/typescript',
  ],

  env: {
    es2021: true,
    node: true
  },

  parser: '@typescript-eslint/parser',

  parserOptions: {
    ecmaVersion: "latest",
    sourceType: "module"
  },

  settings: {
    'import/extensions': ['.js', '.ts'],
    'import/parsers': {
      '@typescript-eslint/parser': ['.ts'],
    },
    'import/ignore': ['node_modules'],
  },

  plugins: ['algolia', 'unused-imports'],

  rules: {
    // disabled
    'no-bitwise': 0,
    'max-classes-per-file': 0,
    'no-continue': 0,
    '@typescript-eslint/prefer-enum-initializers': 0,
    '@typescript-eslint/no-namespace': 0,
    'import/dynamic-import-chunkname': 0,

    'unused-imports/no-unused-imports-ts': 2,
    '@typescript-eslint/no-unused-vars': 2,
    '@typescript-eslint/consistent-indexed-object-style': 2,
    '@typescript-eslint/member-ordering': [
      'error',
      {
        default: [
          'protected-instance-method',
          'private-instance-method',
          'public-instance-method',
        ],
      },
    ],
    '@typescript-eslint/ban-types': [
      'error',
      {
        types: {
          object: {
            message: 'Use Record instead',
            fixWith: 'Record<string, any>',
          },
        },
      },
    ],
  },
};
