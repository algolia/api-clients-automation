import { RuleModule } from 'eslint-plugin-yml/lib/types.js';
import { createRule } from 'eslint-plugin-yml/lib/utils';

import { isNullable, isPairWithKey } from '../utils.js';

export function createOutOfLineRule({
  property,
  description = `${property} must be out of line, not nested inside properties`,
  messageId = `${property}NotOutOfLine`,
  message = `${property} must be out of line`,
}: {
  property: string;
  description?: string;
  messageId?: string;
  message?: string;
}): RuleModule {
  return createRule(`${property}OutOfLine`, {
    meta: {
      docs: {
        description,
        categories: null,
        extensionRule: false,
        layout: false,
      },
      messages: {
        [messageId]: message,
      },
      type: 'layout',
      schema: [],
    },
    create(context) {
      if (!context.getSourceCode().parserServices.isYAML) {
        return {};
      }

      return {
        YAMLPair(node): void {
          if (!isPairWithKey(node, property)) {
            return;
          }
          // parent is mapping, and parent is real parent that must be to the far left
          if (node.parent.parent.loc.start.column === 0) {
            return;
          }
          // accept anything in servers
          if (isPairWithKey(node.parent.parent.parent.parent?.parent?.parent?.parent ?? null, 'servers')) {
            return;
          }
          // allow oneOf with `type: 'null'` because OpenAPI 3.1 is weird
          if (property === 'oneOf' && isNullable(node.value)) {
            return;
          }
          // allow enum to be nullable
          if (
            property === 'enum' &&
            isPairWithKey(node.parent.parent.parent, 'oneOf') &&
            isNullable(node.parent.parent.parent.value)
          ) {
            return;
          }
          context.report({
            node: node.parent.parent as any,
            messageId,
          });
        },
      };
    },
  });
}
