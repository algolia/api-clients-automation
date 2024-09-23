module.exports = {
  ignorePatterns: ['**.yml', 'tsconfig.json'],

  extends: "../.eslintrc.cjs",

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
    'import/extensions': [
      2,
      'ignorePackages',
      {
        js: 'never',
        ts: 'always',
      },
    ],
    '@typescript-eslint/sort-type-union-intersection-members': 0,
    complexity: 0,
    'no-param-reassign': 0,
    '@typescript-eslint/consistent-type-assertions': 0,
    '@typescript-eslint/consistent-type-imports': 0,
    curly: ['error', 'all'],
  },
};
