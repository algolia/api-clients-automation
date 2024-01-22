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

    const code = context.sourceCode;

    if (
      code.lines.length < 2 ||
      code.lines[code.lines.length - 1].trim().length > 0
    ) {
      return {};
    }

    context.report({
      node: code.ast,
      messageId: 'noNewLine',
      fix(fixer) {
        const toRemove = code.text.length - code.text.trimEnd().length;
        return fixer.removeRange([
          code.text.length - toRemove,
          code.text.length,
        ]);
      },
    });

    return {};
  },
};
