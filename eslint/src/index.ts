import { endWithDot } from './rules/endWithDot.js';
import { hasType } from './rules/hasType.js';
import { noBigInt } from './rules/noBigInt.js';
import { noFinalDot } from './rules/noFinalDot.js';
import { createOutOfLineRule } from './rules/outOfLineRule.js';
import { refCommon } from './rules/refCommon.js';
import { singleQuoteRef } from './rules/singleQuoteRef.js';
import { validACL } from './rules/validACL.js';
import { validInlineTitle } from './rules/validInlineTitle.js';

const rules = {
  'end-with-dot': endWithDot,
  'has-type': hasType,
  'no-big-int': noBigInt,
  'no-final-dot': noFinalDot,
  'out-of-line-all-of': createOutOfLineRule({ property: 'allOf' }),
  'out-of-line-any-of': createOutOfLineRule({ property: 'anyOf' }),
  'out-of-line-enum': createOutOfLineRule({ property: 'enum' }),
  'out-of-line-one-of': createOutOfLineRule({ property: 'oneOf' }),
  'ref-common': refCommon,
  'single-quote-ref': singleQuoteRef,
  'valid-acl': validACL,
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

export { parseForESLint, rules };
