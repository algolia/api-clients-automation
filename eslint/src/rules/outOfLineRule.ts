import type { Rule } from 'eslint';

import { isBlockScalar, isMapping, isNullable, isPairWithKey, isScalar } from '../utils.js';

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
}): Rule.RuleModule {
  return {
    meta: {
      docs: {
        description,
      },
      messages: {
        [messageId]: message,
        nullDescription: 'description must not be present for `null` type',
        descriptionLevel: 'description must not be next to the property',
      },
      type: 'layout',
      schema: [],
    },
    create(context) {
      return {
        YAMLPair(node): void {
          if (!isPairWithKey(node, property)) {
            return;
          }

          // the 'null' must not have a description otherwise it will generate a model for it
          if (
            property === 'oneOf' &&
            isNullable(node.value) &&
            node.value.entries.some(
              (entry) =>
                isMapping(entry) &&
                isPairWithKey(entry.pairs[0], 'type') &&
                isScalar(entry.pairs[0].value) &&
                !isBlockScalar(entry.pairs[0].value) &&
                entry.pairs[0].value.raw === "'null'" &&
                entry.pairs.length > 1,
            )
          ) {
            context.report({
              node: node.value,
              messageId: 'nullDescription',
            });

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
  };
}
