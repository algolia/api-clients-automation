import { createRule } from 'eslint-plugin-yml/lib/utils';

import { isPairWithKey, isScalar } from '../utils.js';

const ACLs = [
  'search',
  'browse',
  'addObject',
  'deleteObject',
  'listIndexes',
  'deleteIndex',
  'settings',
  'editSettings',
  'analytics',
  'recommendation',
  'usage',
  'logs',
  'setUnretrievableAttributes',
  'admin',
];

export const validACL = createRule('validACL', {
  meta: {
    docs: {
      description: 'x-acl enum must contains valid Algolia ACLs',
      categories: null,
      extensionRule: false,
      layout: false,
    },
    messages: {
      validString: 'is not a string',
      validACL: `{{entry}} is not a valid Algolia ACL, must be one of: ${ACLs.join(', ')}.`,
      validArray: 'is not an array of string',
    },
    type: 'layout',
    schema: [],
  },
  create(context) {
    if (!context.getSourceCode().parserServices?.isYAML) {
      return {};
    }

    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, 'x-acl')) {
          return;
        }

        if (node.value?.type === 'YAMLSequence') {
          for (const entry of node.value.entries) {
            if (!isScalar(entry)) {
              context.report({
                node: entry as any,
                messageId: 'validString',
              });

              return;
            }

            if (!ACLs.includes(entry.value as string)) {
              context.report({
                node: entry as any,
                messageId: 'validACL',
                data: {
                  entry: entry.value as string,
                },
              });

              return;
            }
          }

          return;
        }

        context.report({
          node: node as any,
          messageId: 'validArray',
        });
      },
    };
  },
});
