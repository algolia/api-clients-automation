import type { Rule } from 'eslint';

import { isPairWithKey, isScalar } from '../utils';

const allSpecs = [
  'abtesting',
  'analytics',
  'crawler',
  'ingestion',
  'insights',
  'monitoring',
  'personalization',
  'query-suggestions',
  'recommend',
  'search',
  'usage',
];

export const refCommon: Rule.RuleModule = {
  meta: {
    docs: {
      description:
        'the $ref must target the current spec, or the common spec. If you intended to use a model from an other spec, move it to the common folder',
    },
    messages: {
      refCommon: '$ref to another spec',
    },
  },
  create(context) {
    if (!context.sourceCode.parserServices.isYAML) {
      return {};
    }

    return {
      YAMLPair(node): void {
        if (!isPairWithKey(node, '$ref')) {
          return;
        }

        if (!isScalar(node.value)) {
          return;
        }

        let ref = node.value.value;
        if (
          typeof ref !== 'string' ||
          ref.trim().startsWith('#/') ||
          ref.startsWith('./')
        ) {
          return;
        }

        const spec = context.filename.match(/specs\/([a-z-]+?)\//)?.[1];
        if (!spec) {
          return;
        }
        while (ref.startsWith(`../`)) {
          ref = ref.slice(3);
        }
        if (
          allSpecs.filter((s) => s !== spec).every((s) => !ref.startsWith(s))
        ) {
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
