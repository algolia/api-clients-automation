import { createRule } from 'eslint-plugin-yml/lib/utils';

import { isPairWithKey, isScalar } from '../utils.js';

// type: number with format: int64 will generate a BigInteger which is not nice to use, most of the time we only need int, long, float or double.
export const noBigInt = createRule('noBigInt', {
  meta: {
    docs: {
      description: 'type big integer is forbidden, did you mean type: integer ?',
      categories: null,
      extensionRule: false,
      layout: false,
    },
    messages: {
      noBigInt: 'type big integer is forbidden, did you mean type: integer ?',
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
        if (!isPairWithKey(node, 'type')) {
          return;
        }

        if (!isScalar(node.value) || node.value.value !== 'number') {
          return;
        }

        // check the format next to the type
        node.parent.pairs.find((pair) => {
          if (isPairWithKey(pair, 'format') && isScalar(pair.value) && (pair.value.value === 'int32' || pair.value.value === 'int64')) {
            context.report({
              node: pair.value as any,
              messageId: 'noBigInt',
            });
          }
        });
      },
    };
  },
});
