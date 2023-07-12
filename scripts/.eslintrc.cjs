/* eslint-disable import/no-commonjs */
module.exports = {
  extends: [
    '../.eslintrc.cjs'
  ],

  env: {
    es2021: true,
    node: true,
  },

  parser: '@typescript-eslint/parser',

  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
  },

  settings: {
    'import/extensions': ['.js', '.ts', '.mjs'],
    'import/parsers': {
      '@typescript-eslint/parser': ['.ts', '.js', '.mjs'],
    },
    'import/ignore': ['node_modules'],
    'import/resolver': {
      typescript: {},
    },
  },

  rules: {
    "import/extensions": [2, "ignorePackages", {
      "js": "never",
      "ts": "never",
      "mjs": "never",
    }],
  },
};
