// eslint-disable-next-line import/no-commonjs
module.exports = {
  extends: '../../.eslintrc.js',
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
        message: 'For wider browser support, optional chaining is not allowed.',
      },
    ],
    '@typescript-eslint/prefer-optional-chain': 0,
  },
};
