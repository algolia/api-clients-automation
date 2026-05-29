import type { Rule } from 'eslint';

import { isPairWithKey, isScalar } from '../utils.js';

import clientsConfig from '../../../config/clients.config.json' with { type: 'json' };

export const refCommon: Rule.RuleModule = {
  meta: {
    docs: {
      description:
        'the $ref must target the current spec, or the common spec. If you intended to use a model from an other spec, move it to the common folder',
    },
    messages: {
      refCommon: '$ref to another spec',
    },
    type: 'layout',
    schema: [],
  },
  create(context) {
    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, '$ref')) {
          return;
        }

        if (!isScalar(node.value)) {
          return;
        }

        let ref = node.value.value;
        if (typeof ref !== 'string' || ref.trim().startsWith('#/') || ref.startsWith('./')) {
          return;
        }

        const spec = context.filename.match(/specs\/([a-z-]+?)\//)?.[1];
        if (!spec) {
          return;
        }
        while (ref.startsWith('../')) {
          ref = ref.slice(3);
        }

        if (clientsConfig.javascript.clients.filter((s) => s.name !== spec).every((s) => !ref.startsWith(s.name))) {
          return;
        }

        context.report({
          node: node as any,
          messageId: 'refCommon',
        });
      },
    };
  },
};
