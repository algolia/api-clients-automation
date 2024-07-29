import type { Rule } from 'eslint';

import { isNullable, isPairWithKey } from '../utils';

export const validInlineTitle: Rule.RuleModule = {
  meta: {
    docs: {
      description:
        'title must be set in inline models, should be the first property and start with a lowercase',
    },
    messages: {
      validInlineTitle:
        'title must be set in inline models, should be the first property and start with a lowercase',
    },
  },
  create(context) {
    if (!context.sourceCode.parserServices.isYAML) {
      return {};
    }

    return {
      YAMLPair(node): void {
        if (
          !isPairWithKey(node, 'type') ||
          node.value?.type !== 'YAMLScalar' ||
          node.value.value !== 'object'
        ) {
          return;
        }

        // we don't enforce it for root level object
        if (node.parent.parent.loc.start.column === 0) {
          return;
        }

        // make sure title starts with a lowercase
        const title = node.parent.pairs.find((pair) =>
          isPairWithKey(pair, 'title')
        );
        const titleNode = title?.value;
        if (
          titleNode &&
          (titleNode.type !== 'YAMLScalar' ||
            !/^[a-z]/.test(titleNode.value as string))
        ) {
          context.report({
            node: title,
            messageId: 'validInlineTitle',
          });
        }

        // if there are no properties, we don't need a title
        const properties = node.parent.pairs.find((pair) =>
          isPairWithKey(pair, 'properties')
        );
        if (!properties) {
          return;
        }

        // allow it on nullable objects
        if (
          isPairWithKey(node.parent.parent.parent, 'oneOf') &&
          isNullable(node.parent.parent.parent.value)
        ) {
          return;
        }

        // allow on allOf too, since they are not generated
        if (isPairWithKey(node.parent.parent.parent, 'allOf')) {
          return;
        }

        // make sure the title is set on the same object
        if (!title) {
          context.report({
            node: node.value,
            messageId: 'validInlineTitle',
          });

          return;
        }

        // make sure title is the first property
        if (!isPairWithKey(node.parent.pairs[0], 'title')) {
          context.report({
            node: title,
            messageId: 'validInlineTitle',
          });
        }
      },
    };
  },
};
