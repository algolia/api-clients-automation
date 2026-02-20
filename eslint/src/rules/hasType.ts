import type { Rule } from 'eslint';

import { isPairWithKey, isPairWithValue } from '../utils.js';

export const hasType: Rule.RuleModule = {
  meta: {
    docs: {
      description: '`type` must be specified with `properties` or `items`',
    },
    messages: {
      hasType: '`type` must be specified with `properties` or `items`',
    },
    type: 'problem',
    schema: [],
  },
  create(context) {
    return {
      YAMLPair(node): void {
        if (isPairWithKey(node.parent.parent, 'properties')) {
          return; // allow everything in properties
        }

        const type = node.parent.pairs.find((pair) => isPairWithKey(pair, 'type'));
        if (isPairWithKey(node, 'properties') && (!type || !isPairWithValue(type, 'object'))) {
          return context.report({
            node: node as any,
            messageId: 'hasType',
          });
        }

        if (isPairWithKey(node, 'items') && (!type || !isPairWithValue(type, 'array'))) {
          return context.report({
            node: node as any,
            messageId: 'hasType',
          });
        }
      },
    };
  },
};
