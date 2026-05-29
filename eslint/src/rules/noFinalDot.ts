import type { Rule } from 'eslint';

import { isPairWithKey, isScalar } from '../utils.js';

export const noFinalDot: Rule.RuleModule = {
  meta: {
    docs: {
      description: '`summary` must not end with a period',
    },
    messages: {
      noFinalDot: 'summary ends with a period',
    },
    fixable: 'code',
    type: 'layout',
    schema: [],
  },
  create(context) {
    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, 'summary')) {
          return;
        }

        if (!isScalar(node.value)) {
          return;
        }

        const value = node.value;
        if (typeof value.value !== 'string' || !value.value.trim().endsWith('.')) {
          // The rule is respected if:
          // the summary is not a string
          // or it doesn't end with a dot.
          return;
        }

        context.report({
          node: node as any,
          messageId: 'noFinalDot',
          fix(fixer) {
            const end = node.range[1];
            return fixer.removeRange([end - 1, end]);
          },
        });
      },
    };
  },
};
