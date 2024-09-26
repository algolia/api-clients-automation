module.exports = {
  root: true,

  ignorePatterns: [
    '**/node_modules',
    '**/build',
    '**/builddir',
    '**/dist',
    '**/target',
    '**/.yarn',
    '**/project.packagespec.json',
  ],

  overrides: [
    {
      // yml linter
      files: ['*.yml'],

      extends: ['plugin:yml/standard'],

      parser: 'yaml-eslint-parser',
      plugins: ['automation-custom'],
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
      overrides: [
        {
          files: ['specs/**/*.yml'],
          rules: {
            'automation-custom/end-with-dot': 'error',
            'automation-custom/no-final-dot': 'error',
            'automation-custom/single-quote-ref': 'error',
          },
          overrides: [
            {
              files: ['!specs/bundled/*.yml'],
              rules: {
                'automation-custom/out-of-line-enum': 'error',
                'automation-custom/out-of-line-one-of': 'error',
                'automation-custom/out-of-line-all-of': 'error',
                'automation-custom/out-of-line-any-of': 'error',
                'automation-custom/valid-acl': 'error',
                'automation-custom/ref-common': 'error',
                'automation-custom/valid-inline-title': 'error',
              },
            },
          ],
        },
      ],
    },
    {
      // actions yml linter
      files: ['.github/**/*.yml'],

      rules: {
        'yml/no-empty-mapping-value': 0,
      },
    },
    {
      // es linter
      files: ['*.ts', '*.js'],

      extends: [
        'algolia',
        'algolia/typescript',
        'plugin:import/errors',
        'plugin:import/warnings',
        'plugin:import/typescript',
      ],

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
        '@typescript-eslint/no-restricted-types': [
          'error',
          {
            types: {
              String: {
                message: 'Use `string` instead.',
                fixWith: 'string',
              },
              Number: {
                message: 'Use `number` instead.',
                fixWith: 'number',
              },
              Boolean: {
                message: 'Use `boolean` instead.',
                fixWith: 'boolean',
              },
              Symbol: {
                message: 'Use `symbol` instead.',
                fixWith: 'symbol',
              },
              Object: {
                message:
                  'The `Object` type is mostly the same as `unknown`. You probably want `Record<string, unknown>` instead. See https://github.com/typescript-eslint/typescript-eslint/pull/848',
                fixWith: 'Record<string, unknown>',
              },
              '{}': {
                message:
                  'The `{}` type is mostly the same as `unknown`. You probably want `Record<string, unknown>` instead.',
                fixWith: 'Record<string, unknown>',
              },
              object: {
                message:
                  'The `object` type is hard to use. Use `Record<string, unknown>` instead. See: https://github.com/typescript-eslint/typescript-eslint/pull/848',
                fixWith: 'Record<string, unknown>',
              },
              Function: 'Use a specific function type instead, like `() => void`.',
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
      files: ['clients/algoliasearch-client-javascript/packages/**/*.ts'],

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
      }
    },
    {
      files: ['clients/algoliasearch-client-javascript/packages/**/__tests__/**/*.ts'],

      extends: ["plugin:vitest/legacy-recommended"],

      plugins: ['@vitest/eslint-plugin'],
    },
    {
      files: ['guides/**/*.ts'],

      rules: {
        'no-console': 0,

        // TODO: remove this
        '@typescript-eslint/no-unused-vars': 0,
        '@typescript-eslint/explicit-function-return-type': 0,
      },
    },
    {
      files: ['*.json'],
      parserOptions: {
        extraFileExtensions: ['.json'],
      },
      extends: ["plugin:json/recommended-legacy"]
    },
    {
      files: ['templates/**/*.mustache'],

      parser: 'eslint-plugin-automation-custom',
      plugins: ['automation-custom'],
      rules: {
        'automation-custom/no-new-line': 'error',
      },
    },
  ],
};
