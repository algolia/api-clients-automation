const automationCustom = require('./eslint');
const yml = require('eslint-plugin-yml');
const algolia = require('eslint-config-algolia');
const importPlugin = require('eslint-plugin-import');
const ymlParser = require('yaml-eslint-parser');
const unusedImports = require('eslint-plugin-unused-imports');
const jsonFormat = require('eslint-plugin-json-format');

module.exports = [
  {
    ignores: [
      '**/node_modules',
      '**/build',
      '**/builddir',
      '**/dist',
      '**/target',
      '**/.yarn',
      'website/specs',
      '**/project.packagespec.json',
      '**/composer.json',
      '**/vendor',
    ],
  },
  ...yml.configs['flat/standard'],
  {
    name: 'yaml linter',
    files: ['**/*.yml'],
    languageOptions: {
      parser: ymlParser,
    },
    plugins: {
      automationCustom,
    },
    rules: {
      'yml/plain-scalar': [
        2,
        'always',
        {
          // ignore path from ref, that must be quoted
          ignorePatterns: ['[./#a-zA-Z0-9_]+'],
        },
      ],
      'yml/quotes': [
        2,
        {
          prefer: 'single',
          avoidEscape: true,
        },
      ],
      'yml/no-multiple-empty-lines': [
        2,
        {
          max: 1,
          maxEOF: 0,
          maxBOF: 0,
        },
      ],
      'yml/require-string-key': 2,
    },
  },
  {
    files: ['specs/**/*.yml'],
    rules: {
      'automation-custom/end-with-dot': 'error',
      'automation-custom/single-quote-ref': 'error',
    },
  },
  {
    files: ['specs/**/*.yml'],
    ignores: ['specs/bundled/*.yml'],
    rules: {
      'automation-custom/out-of-line-enum': 'error',
      'automation-custom/out-of-line-one-of': 'error',
      'automation-custom/out-of-line-all-of': 'error',
      'automation-custom/out-of-line-any-of': 'error',
      'automation-custom/valid-acl': 'error',
    },
  },
  importPlugin.configs.errors,
  importPlugin.configs.warnings,
  importPlugin.configs.typescript,
  {
    name: 'js linter',
    files: ['*.ts', '*.js'],
    env: {
      es6: true,
    },

    parser: '@typescript-eslint/parser',

    parserOptions: {
      tsconfigRootDir: __dirname,
      project: './**/tsconfig.json',
    },

    settings: {
      'import/extensions': ['.js', '.ts'],
      'import/parsers': {
        '@typescript-eslint/parser': ['.ts'],
      },
      'import/ignore': ['node_modules'],
    },

    plugins: {
      algolia,
      unusedImports
    },

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
      'jsdoc/match-description': [
        'error',
        {
          matchDescription: '^\n?([A-Z`\[\\d_][\\s\\S]*[.?!`]\\s*)?$'
        },
      ],
    },
  },
  {
    name: 'js client linter',
    files: ['clients/algoliasearch-client-javascript/packages/**/*.ts'],

    parserOptions: {
      tsconfigRootDir: __dirname,
      project: './clients/algoliasearch-client-javascript/tsconfig.json'
    },

    rules: {
      // For a wider browser support (IE>=11), we forbid those two
      'no-restricted-syntax': [
        'error',
        {
          selector: "LogicalExpression[operator='??']",
          message:
            'For wider browser support, nullish coalescing operator is not allowed.',
        },
        {
          selector: 'ChainExpression',
          message:
            'For wider browser support, optional chaining is not allowed.',
        },
      ],
      '@typescript-eslint/prefer-optional-chain': 0,
    },
  },
  {
    name: 'json linter',
    files: ['*.json'],
    plugins: {
      jsonFormat,
    },
  },
  {
    name: 'mustache linter',
    files: ['templates/**/*.mustache'],
    parser: 'eslint-plugin-automation-custom',
    plugins: {
      automationCustom
    },
    rules: {
      'automation-custom/no-new-line': 'error',
    },
  }
];
