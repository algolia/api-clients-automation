import json from '@eslint/json';
import automationCustom from 'eslint-plugin-automation-custom';
import yml from 'eslint-plugin-yml';

export default [
  // Global ignores (replaces ignorePatterns and .eslintignore)
  {
    ignores: [
      '**/node_modules/**',
      '**/build/**',
      '**/builddir/**',
      '**/dist/**',
      '**/target/**',
      '**/.yarn/**',
      '**/vendor/**',
      '**/project.packagespec.json',
      'playground/**',
      'composer.json',
      'tsconfig.json',
      'foo/**',
    ],
  },

  // YAML base: extends plugin:yml/standard (Language Plugin architecture)
  ...yml.configs['flat/standard'],

  // YAML files — custom yml rules + automation-custom plugin registration
  {
    files: ['**/*.yml'],
    plugins: {
      'automation-custom': automationCustom,
    },
    rules: {
      'yml/plain-scalar': [2, 'always', { ignorePatterns: ['[./#a-zA-Z0-9_]+'] }],
      'yml/quotes': [2, { prefer: 'single', avoidEscape: true }],
      'yml/no-multiple-empty-lines': [2, { max: 1, maxEOF: 0, maxBOF: 0 }],
      'yml/require-string-key': 2,
      'yml/no-trailing-zeros': 'off',
    },
  },

  // Specs YAML — automation-custom rules (all specs including bundled)
  {
    files: ['specs/**/*.yml'],
    rules: {
      'automation-custom/end-with-dot': 'error',
      'automation-custom/no-big-int': 'error',
      'automation-custom/no-final-dot': 'error',
      'automation-custom/single-quote-ref': 'error',
      'automation-custom/has-type': 'error',
    },
  },

  // Specs YAML excluding bundled — additional automation-custom rules
  {
    files: ['specs/**/*.yml'],
    ignores: ['specs/bundled/*.yml'],
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

  // GitHub Actions YAML override
  {
    files: ['.github/**/*.yml'],
    rules: {
      'yml/no-empty-mapping-value': 0,
    },
  },

  // JSON files (using @eslint/json language plugin)
  {
    plugins: { json },
    files: ['**/*.json'],
    language: 'json/json',
  },
];
