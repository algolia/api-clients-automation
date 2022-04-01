import type { Rule } from 'eslint';

import { isPairWithKey, isScalar } from '../utils';

export const descriptionDot: Rule.RuleModule = {
  meta: {
    docs: {
      description: 'description must end with a dot',
    },
    messages: {
      descriptionNoDot: 'description does not end with a dot',
    },
    fixable: 'code',
  },
  create(context) {
    if (!context.parserServices.isYAML) {
      return {};
    }

    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, 'description')) {
          return;
        }
        if (!isScalar(node.value)) {
          return;
        }
        const value = node.value;
        if (typeof value.value !== 'string' || value.value.endsWith('.')) {
          return;
        }
        context.report({
          node: node as any,
          messageId: 'descriptionNoDot',
          fix(fixer) {
            return fixer.insertTextAfterRange(value.range, '.');
          },
        });
      },
    };
  },
};
