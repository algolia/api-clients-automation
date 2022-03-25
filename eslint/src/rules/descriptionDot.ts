import type { Rule } from 'eslint';
import type { AST } from 'yaml-eslint-parser';

export const descriptionDot: Rule.RuleModule = {
  meta: {
    docs: {
      description: 'description must end with a dot',
    },
    messages: {
      descriptionNoDot: 'description does not end with a dot',
    },
    fixable: 'code',
  },
  create(context) {
    if (!context.parserServices.isYAML) {
      return {};
    }

    return {
      YAMLScalar(node): void {
        if (node.value !== 'description') {
          return;
        }
        const value: AST.YAMLScalar = node.parent.value;
        if (typeof value.value !== 'string' || value.value.endsWith('.')) {
          return;
        }
        context.report({
          node,
          messageId: 'descriptionNoDot',
          fix(fixer) {
            return fixer.insertTextAfterRange(value.range, '.');
          },
        });
      },
    };
  },
};
