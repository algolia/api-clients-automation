import type { Rule } from 'eslint';

import { isPairWithKey, isPairWithValue, isScalar } from '../utils.js';

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

export const validACL: Rule.RuleModule = {
  meta: {
    docs: {
      description: 'x-acl enum must be set and contain valid Algolia ACLs',
    },
    messages: {
      missingACL: 'x-acl is missing',
      validString: 'is not a string',
      validACL: `{{entry}} is not a valid Algolia ACL, must be one of: ${ACLs.join(', ')}.`,
      validArray: 'is not an array of string',
    },
    type: 'layout',
    schema: [],
  },
  create(context) {
    return {
      YAMLPair(node): void {
        const spec = context.filename.match(/specs\/([a-z-]+?)\//)?.[1];
        if (!spec) {
          return;
        }
        if (spec === 'monitoring') {
          // monitoring uses a special API key and doesn't need ACLs
          return;
        }

        if (spec === 'crawler') {
          // no clients are generated for the crawler API
          return;
        }

        // if we find then prop operationId, there must be x-acl on the same level
        if (isPairWithKey(node, 'operationId')) {
          const hasACL = node.parent.pairs.some((item: any) => isPairWithKey(item, 'x-acl'));

          // ignore custom helpers
          if (
            isPairWithValue(node, 'customGet') ||
            isPairWithValue(node, 'customPost') ||
            isPairWithValue(node, 'customPut') ||
            isPairWithValue(node, 'customDelete')
          ) {
            return;
          }

          if (!hasACL) {
            context.report({
              node: node as any,
              messageId: 'missingACL',
            });
          }

          return;
        }

        // check the validity of x-acl
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
};
