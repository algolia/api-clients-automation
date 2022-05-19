import { endWithDot } from './rules/endWithDot';
import { outOfLineEnum } from './rules/outOfLineEnum';
import { outOfLineOneOf } from './rules/outOfLineOneOf';
import { singleQuoteRef } from './rules/singleQuoteRef';

const rules = {
  'end-with-dot': endWithDot,
  'out-of-line-enum': outOfLineEnum,
  'out-of-line-one-of': outOfLineOneOf,
  'single-quote-ref': singleQuoteRef,
};

export { rules };
