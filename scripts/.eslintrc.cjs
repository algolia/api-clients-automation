module.exports = {
  ignorePatterns: ['*.test.ts', '**.yml', 'tsconfig.json'],

  parser: '@typescript-eslint/parser',

  parserOptions: {
    ecmaVersion: 'latest',
    sourceType: 'module',
    tsconfigRootDir: __dirname,
    project: 'tsconfig.json',
  },

  settings: {
    'import/extensions': ['.js', '.ts', '.mjs', '.cjs'],
    'import/parsers': {
      '@typescript-eslint/parser': ['.ts', '.js', '.mjs', '.cjs'],
    },
    'import/ignore': ['node_modules'],
    'import/resolver': {
      typescript: {},
    },
  },

  rules: {
    '@stylistic/max-len': [0, { code: 100, ignoreComments: true }],
    'prettier/prettier': [
      'error',
      {
        singleQuote: true,
        printWidth: 100,
        trailingComma: 'all',
      },
    ],
    'import/extensions': [
      2,
      'ignorePackages',
      {
        js: 'never',
        ts: 'never',
        mjs: 'never',
      },
    ],
    '@typescript-eslint/sort-type-union-intersection-members': 0,
    complexity: 0,
    'no-param-reassign': 0,
    '@typescript-eslint/consistent-type-assertions': 0,
    curly: ['error', 'all'],
  },
};
