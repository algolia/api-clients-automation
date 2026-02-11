import type { Rule } from 'eslint';

import { isBlockScalar, isPairWithKey, isScalar } from '../utils.js';

export const endWithDot: Rule.RuleModule = {
  meta: {
    docs: {
      description: '`description` must end with a period',
    },
    messages: {
      endWithDot: 'description does not end with a period',
    },
    fixable: 'code',
    type: 'layout',
    schema: [],
  },
  create(context) {
    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, 'description')) {
          return;
        }

        if (!isScalar(node.value)) {
          return;
        }

        const value = node.value;
        if (typeof value.value !== 'string' || value.value.trim().endsWith('.') || !value.value.trim().includes(' ')) {
          // The rule is respected if:
          // the description is not a string
          // or it ends with a dot
          // or it's a single word (like 'OK' or 'Success', it's not a sentence)
          return;
        }

        // trim the whitespaces at the end before adding the dot. This assume the indent is 2
        let toTrim = value.value.length - value.value.trimEnd().length;
        if (isBlockScalar(value)) {
          // -1 for block scalar, don't know why
          toTrim -= 1;
        }
        context.report({
          node: node as any,
          messageId: 'endWithDot',
          fix(fixer) {
            return fixer.insertTextAfterRange([0, value.range[1] - toTrim], '.');
          },
        });
      },
    };
  },
};
