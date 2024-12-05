import { createRule } from 'eslint-plugin-yml/lib/utils';

import { isBlockScalar, isPairWithKey, isScalar } from '../utils.js';

export const singleQuoteRef = createRule('singleQuoteRef', {
  meta: {
    docs: {
      description: '$ref must be wrapped in single quote',
      categories: null,
      extensionRule: false,
      layout: false,
    },
    messages: {
      refNoQuote: '$ref is not wrapped in single quote',
    },
    fixable: 'code',
    type: 'layout',
    schema: [],
  },
  create(context) {
    if (!context.getSourceCode().parserServices?.isYAML) {
      return {};
    }

    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, '$ref')) {
          return;
        }
        if (!isScalar(node.value)) {
          // not our problem, something else will fail like path resolution
          return;
        }
        if (node.value.style === 'single-quoted') {
          // that's what we want
          return;
        }
        if (isBlockScalar(node.value)) {
          // another rule should take care of that case
          return;
        }
        const hasDoubleQuote = node.value.style === 'double-quoted';
        const [start, end] = node.value.range;
        context.report({
          node: node as any,
          messageId: 'refNoQuote',
          *fix(fixer) {
            if (hasDoubleQuote) {
              yield fixer.replaceTextRange([start, start + 1], "'");
              yield fixer.replaceTextRange([end - 1, end], "'");
            } else {
              yield fixer.insertTextBeforeRange([start, start], "'");
              yield fixer.insertTextAfterRange([end, end], "'");
            }
          },
        });
      },
    };
  },
});
