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
            'automation-custom/no-big-int': 'error',
            'automation-custom/no-final-dot': 'error',
            'automation-custom/single-quote-ref': 'error',
            'automation-custom/has-type': 'error',
          },
          overrides: [
            {
              files: ['!specs/bundled/*.yml'],
              rules: {
                'automation-custom/out-of-line-all-of': 'error',
                'automation-custom/out-of-line-any-of': 'error',
                'automation-custom/out-of-line-enum': 'error',
                'automation-custom/out-of-line-one-of': 'error',
                'automation-custom/ref-common': 'error',
                'automation-custom/valid-acl': 'error',
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
      files: ['*.json'],
      parserOptions: {
        extraFileExtensions: ['.json'],
      },
      extends: ["plugin:json/recommended-legacy"]
    },
  ],
};
