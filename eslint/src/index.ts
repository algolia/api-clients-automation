import { endWithDot } from './rules/endWithDot';
import { noFinalDot } from './rules/noFinalDot';
import { noNewLine } from './rules/noNewLine';
import { createOutOfLineRule } from './rules/outOfLineRule';
import { refCommon } from './rules/refCommon';
import { singleQuoteRef } from './rules/singleQuoteRef';
import { validACL } from './rules/validACL';
import { validInlineTitle } from './rules/validInlineTitle';

const rules = {
  'end-with-dot': endWithDot,
  'no-final-dot': noFinalDot,
  'out-of-line-enum': createOutOfLineRule({ property: 'enum' }),
  'out-of-line-one-of': createOutOfLineRule({ property: 'oneOf' }),
  'out-of-line-all-of': createOutOfLineRule({ property: 'allOf' }),
  'out-of-line-any-of': createOutOfLineRule({ property: 'anyOf' }),
  'single-quote-ref': singleQuoteRef,
  'valid-acl': validACL,
  'no-new-line': noNewLine,
  'ref-common': refCommon,
  'valid-inline-title': validInlineTitle,
};

// Custom parser for ESLint, to read plain text file like mustache.
// It returns a fake AST, because we only care about the source code.
function parseForESLint(): any {
  return {
    ast: {
      type: 'Program',
      start: 0,
      end: 0,
      loc: { start: { line: 0, column: 0 }, end: { line: 0, column: 0 } },
      range: [0, 0],
      body: [],
      tokens: [],
      comments: [],
    },
    services: {
      isPlainText: true,
    },
    scopeManager: null,
    visitorKeys: null,
  };
}

export { rules, parseForESLint };
