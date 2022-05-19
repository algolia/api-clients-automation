import { endWithDot } from './rules/endWithDot';
import { outOfLineAllOf } from './rules/outOfLineAllOf';
import { outOfLineAnyOf } from './rules/outOfLineAnyOf';
import { outOfLineEnum } from './rules/outOfLineEnum';
import { outOfLineOneOf } from './rules/outOfLineOneOf';
import { singleQuoteRef } from './rules/singleQuoteRef';

const rules = {
  'end-with-dot': endWithDot,
  'out-of-line-enum': outOfLineEnum,
  'out-of-line-one-of': outOfLineOneOf,
  'out-of-line-all-of': outOfLineAllOf,
  'out-of-line-any-of': outOfLineAnyOf,
  'single-quote-ref': singleQuoteRef,
};

export { rules };
