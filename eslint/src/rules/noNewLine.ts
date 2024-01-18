import type { Rule } from 'eslint';

export const noNewLine: Rule.RuleModule = {
  meta: {
    docs: {
      description: 'the file should not end with a new line',
    },
    messages: {
      noNewLine: 'ends with a new line',
    },
    fixable: 'code',
  },
  create(context) {
    if (!context.sourceCode.parserServices.isPlainText) {
      return {};
    }

    if (
      context.sourceCode.lines.length < 2 ||
      context.sourceCode.lines[context.sourceCode.lines.length - 1].length > 0
    ) {
      return {};
    }

    context.report({
      node: context.sourceCode.ast,
      messageId: 'noNewLine',
      fix(fixer) {
        return fixer.removeRange([
          context.sourceCode.lineStartIndices.at(-1) - 1,
          context.sourceCode.lineStartIndices.at(-1),
        ]);
      },
    });

    return {};
  },
};
